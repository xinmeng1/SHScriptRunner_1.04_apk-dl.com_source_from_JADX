package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.C0630b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.C0636a;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.IGamesService.Stub;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;
import com.google.android.gms.games.internal.game.ExtendedGameBuffer;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.C0373b;
import com.google.android.gms.internal.hb.C0774d;
import com.google.android.gms.internal.hb.C1119e;
import com.google.android.gms.internal.hi;
import com.google.android.gms.internal.hm;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.WearableStatusCodes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class GamesClientImpl extends hb<IGamesService> implements ConnectionCallbacks, OnConnectionFailedListener {
    private final boolean NA;
    private final int NB;
    private final boolean NC;
    private final String ND;
    EventIncrementManager Np;
    private final String Nq;
    private final Map<String, RealTimeSocket> Nr;
    private PlayerEntity Ns;
    private GameEntity Nt;
    private final PopupManager Nu;
    private boolean Nv;
    private boolean Nw;
    private int Nx;
    private final Binder Ny;
    private final long Nz;
    private final String yQ;

    /* renamed from: com.google.android.gms.games.internal.GamesClientImpl.1 */
    class C06901 extends EventIncrementManager {
        final /* synthetic */ GamesClientImpl NE;

        C06901(GamesClientImpl gamesClientImpl) {
            this.NE = gamesClientImpl;
        }

        public EventIncrementCache hx() {
            return new GameClientEventIncrementCache(this.NE);
        }
    }

    private class GameClientEventIncrementCache extends EventIncrementCache {
        final /* synthetic */ GamesClientImpl NE;

        public GameClientEventIncrementCache(GamesClientImpl gamesClientImpl) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl.getContext().getMainLooper(), GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE);
        }

        protected void m2163o(String str, int i) {
            try {
                ((IGamesService) this.NE.ft()).m673l(str, i);
            } catch (RemoteException e) {
                GamesLog.m482j("GamesClientImpl", "service died");
            }
        }
    }

    private final class InvitationReceivedCallback extends C0373b<OnInvitationReceivedListener> {
        final /* synthetic */ GamesClientImpl NE;
        private final Invitation NP;

        InvitationReceivedCallback(GamesClientImpl gamesClientImpl, OnInvitationReceivedListener listener, Invitation invitation) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.NP = invitation;
        }

        protected void m2164b(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.NP);
        }

        protected /* synthetic */ void m2165d(Object obj) {
            m2164b((OnInvitationReceivedListener) obj);
        }

        protected void fu() {
        }
    }

    private final class InvitationRemovedCallback extends C0373b<OnInvitationReceivedListener> {
        final /* synthetic */ GamesClientImpl NE;
        private final String NQ;

        InvitationRemovedCallback(GamesClientImpl gamesClientImpl, OnInvitationReceivedListener listener, String invitationId) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.NQ = invitationId;
        }

        protected void m2166b(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.NQ);
        }

        protected /* synthetic */ void m2167d(Object obj) {
            m2166b((OnInvitationReceivedListener) obj);
        }

        protected void fu() {
        }
    }

    private final class LeftRoomCallback extends C0373b<RoomUpdateListener> {
        private final int CT;
        final /* synthetic */ GamesClientImpl NE;
        private final String NS;

        LeftRoomCallback(GamesClientImpl gamesClientImpl, RoomUpdateListener listener, int statusCode, String roomId) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.CT = statusCode;
            this.NS = roomId;
        }

        public void m2168a(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.CT, this.NS);
        }

        public /* synthetic */ void m2169d(Object obj) {
            m2168a((RoomUpdateListener) obj);
        }

        protected void fu() {
        }
    }

    private final class MatchRemovedCallback extends C0373b<OnTurnBasedMatchUpdateReceivedListener> {
        final /* synthetic */ GamesClientImpl NE;
        private final String Oi;

        MatchRemovedCallback(GamesClientImpl gamesClientImpl, OnTurnBasedMatchUpdateReceivedListener listener, String matchId) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Oi = matchId;
        }

        protected void m2170b(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.Oi);
        }

        protected /* synthetic */ void m2171d(Object obj) {
            m2170b((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        protected void fu() {
        }
    }

    private final class MatchUpdateReceivedCallback extends C0373b<OnTurnBasedMatchUpdateReceivedListener> {
        final /* synthetic */ GamesClientImpl NE;
        private final TurnBasedMatch Ok;

        MatchUpdateReceivedCallback(GamesClientImpl gamesClientImpl, OnTurnBasedMatchUpdateReceivedListener listener, TurnBasedMatch match) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Ok = match;
        }

        protected void m2172b(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.Ok);
        }

        protected /* synthetic */ void m2173d(Object obj) {
            m2172b((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        protected void fu() {
        }
    }

    private final class MessageReceivedCallback extends C0373b<RealTimeMessageReceivedListener> {
        final /* synthetic */ GamesClientImpl NE;
        private final RealTimeMessage Ol;

        MessageReceivedCallback(GamesClientImpl gamesClientImpl, RealTimeMessageReceivedListener listener, RealTimeMessage message) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Ol = message;
        }

        public void m2174a(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            if (realTimeMessageReceivedListener != null) {
                realTimeMessageReceivedListener.onRealTimeMessageReceived(this.Ol);
            }
        }

        public /* synthetic */ void m2175d(Object obj) {
            m2174a((RealTimeMessageReceivedListener) obj);
        }

        protected void fu() {
        }
    }

    private final class P2PConnectedCallback extends C0373b<RoomStatusUpdateListener> {
        final /* synthetic */ GamesClientImpl NE;
        private final String Oq;

        P2PConnectedCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, String participantId) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Oq = participantId;
        }

        public void m2176a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PConnected(this.Oq);
            }
        }

        public /* synthetic */ void m2177d(Object obj) {
            m2176a((RoomStatusUpdateListener) obj);
        }

        protected void fu() {
        }
    }

    private final class P2PDisconnectedCallback extends C0373b<RoomStatusUpdateListener> {
        final /* synthetic */ GamesClientImpl NE;
        private final String Oq;

        P2PDisconnectedCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, String participantId) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Oq = participantId;
        }

        public void m2178a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PDisconnected(this.Oq);
            }
        }

        public /* synthetic */ void m2179d(Object obj) {
            m2178a((RoomStatusUpdateListener) obj);
        }

        protected void fu() {
        }
    }

    private final class QuestCompletedCallback extends C0373b<QuestUpdateListener> {
        final /* synthetic */ GamesClientImpl NE;
        private final Quest NG;

        QuestCompletedCallback(GamesClientImpl gamesClientImpl, QuestUpdateListener listener, Quest quest) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.NG = quest;
        }

        protected void m2180b(QuestUpdateListener questUpdateListener) {
            questUpdateListener.onQuestCompleted(this.NG);
        }

        protected /* synthetic */ void m2181d(Object obj) {
            m2180b((QuestUpdateListener) obj);
        }

        protected void fu() {
        }
    }

    private final class RealTimeMessageSentCallback extends C0373b<ReliableMessageSentCallback> {
        private final int CT;
        final /* synthetic */ GamesClientImpl NE;
        private final String Ow;
        private final int Ox;

        RealTimeMessageSentCallback(GamesClientImpl gamesClientImpl, ReliableMessageSentCallback listener, int statusCode, int token, String recipientParticipantId) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.CT = statusCode;
            this.Ox = token;
            this.Ow = recipientParticipantId;
        }

        public void m2182a(ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.CT, this.Ox, this.Ow);
            }
        }

        public /* synthetic */ void m2183d(Object obj) {
            m2182a((ReliableMessageSentCallback) obj);
        }

        protected void fu() {
        }
    }

    private final class RequestReceivedCallback extends C0373b<OnRequestReceivedListener> {
        final /* synthetic */ GamesClientImpl NE;
        private final GameRequest OA;

        RequestReceivedCallback(GamesClientImpl gamesClientImpl, OnRequestReceivedListener listener, GameRequest request) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.OA = request;
        }

        protected void m2184b(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.OA);
        }

        protected /* synthetic */ void m2185d(Object obj) {
            m2184b((OnRequestReceivedListener) obj);
        }

        protected void fu() {
        }
    }

    private final class RequestRemovedCallback extends C0373b<OnRequestReceivedListener> {
        final /* synthetic */ GamesClientImpl NE;
        private final String OB;

        RequestRemovedCallback(GamesClientImpl gamesClientImpl, OnRequestReceivedListener listener, String requestId) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.OB = requestId;
        }

        protected void m2186b(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.OB);
        }

        protected /* synthetic */ void m2187d(Object obj) {
            m2186b((OnRequestReceivedListener) obj);
        }

        protected void fu() {
        }
    }

    private abstract class AbstractRoomCallback extends C0774d<RoomUpdateListener> {
        final /* synthetic */ GamesClientImpl NE;

        AbstractRoomCallback(GamesClientImpl gamesClientImpl, RoomUpdateListener listener, DataHolder dataHolder) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        protected void m3327a(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            m3328a(roomUpdateListener, this.NE.m3333Q(dataHolder), dataHolder.getStatusCode());
        }

        protected abstract void m3328a(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    private abstract class AbstractRoomStatusCallback extends C0774d<RoomStatusUpdateListener> {
        final /* synthetic */ GamesClientImpl NE;

        AbstractRoomStatusCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        protected void m3330a(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            m3331a(roomStatusUpdateListener, this.NE.m3333Q(dataHolder));
        }

        protected abstract void m3331a(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    private static final class AcceptQuestResultImpl extends C0630b implements AcceptQuestResult {
        private final Quest NG;

        AcceptQuestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.NG = new QuestEntity((Quest) questBuffer.get(0));
                } else {
                    this.NG = null;
                }
                questBuffer.close();
            } catch (Throwable th) {
                questBuffer.close();
            }
        }

        public Quest getQuest() {
            return this.NG;
        }
    }

    private static final class CancelMatchResultImpl implements CancelMatchResult {
        private final String NH;
        private final Status yz;

        CancelMatchResultImpl(Status status, String externalMatchId) {
            this.yz = status;
            this.NH = externalMatchId;
        }

        public String getMatchId() {
            return this.NH;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static final class ClaimMilestoneResultImpl extends C0630b implements ClaimMilestoneResult {
        private final Quest NG;
        private final Milestone NI;

        ClaimMilestoneResultImpl(DataHolder dataHolder, String milestoneId) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.NG = new QuestEntity((Quest) questBuffer.get(0));
                    List iJ = this.NG.iJ();
                    int size = iJ.size();
                    for (int i = 0; i < size; i++) {
                        if (((Milestone) iJ.get(i)).getMilestoneId().equals(milestoneId)) {
                            this.NI = (Milestone) iJ.get(i);
                            return;
                        }
                    }
                    this.NI = null;
                } else {
                    this.NI = null;
                    this.NG = null;
                }
                questBuffer.close();
            } finally {
                questBuffer.close();
            }
        }

        public Milestone getMilestone() {
            return this.NI;
        }

        public Quest getQuest() {
            return this.NG;
        }
    }

    private static final class CommitSnapshotResultImpl extends C0630b implements CommitSnapshotResult {
        private final SnapshotMetadata NJ;

        CommitSnapshotResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.NJ = new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0));
                } else {
                    this.NJ = null;
                }
                snapshotMetadataBuffer.close();
            } catch (Throwable th) {
                snapshotMetadataBuffer.close();
            }
        }

        public SnapshotMetadata getSnapshotMetadata() {
            return this.NJ;
        }
    }

    private static final class ContactSettingLoadResultImpl extends C0630b implements ContactSettingLoadResult {
        ContactSettingLoadResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class DeleteSnapshotResultImpl implements DeleteSnapshotResult {
        private final String NK;
        private final Status yz;

        DeleteSnapshotResultImpl(int statusCode, String snapshotId) {
            this.yz = new Status(statusCode);
            this.NK = snapshotId;
        }

        public String getSnapshotId() {
            return this.NK;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static final class GameMuteStatusChangeResultImpl implements GameMuteStatusChangeResult {
        private final String NL;
        private final boolean NM;
        private final Status yz;

        public GameMuteStatusChangeResultImpl(int statusCode, String externalGameId, boolean isMuted) {
            this.yz = new Status(statusCode);
            this.NL = externalGameId;
            this.NM = isMuted;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static final class GameMuteStatusLoadResultImpl implements GameMuteStatusLoadResult {
        private final String NL;
        private final boolean NM;
        private final Status yz;

        public GameMuteStatusLoadResultImpl(DataHolder dataHolder) {
            try {
                this.yz = new Status(dataHolder.getStatusCode());
                if (dataHolder.getCount() > 0) {
                    this.NL = dataHolder.m2012c("external_game_id", 0, 0);
                    this.NM = dataHolder.m2013d("muted", 0, 0);
                } else {
                    this.NL = null;
                    this.NM = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static final class InboxCountResultImpl implements InboxCountResult {
        private final Bundle NN;
        private final Status yz;

        InboxCountResultImpl(Status status, Bundle inboxCounts) {
            this.yz = status;
            this.NN = inboxCounts;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static final class LeaderboardMetadataResultImpl extends C0630b implements LeaderboardMetadataResult {
        private final LeaderboardBuffer NR;

        LeaderboardMetadataResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.NR = new LeaderboardBuffer(dataHolder);
        }

        public LeaderboardBuffer getLeaderboards() {
            return this.NR;
        }
    }

    private static final class LoadAchievementsResultImpl extends C0630b implements LoadAchievementsResult {
        private final AchievementBuffer NT;

        LoadAchievementsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.NT = new AchievementBuffer(dataHolder);
        }

        public AchievementBuffer getAchievements() {
            return this.NT;
        }
    }

    private static final class LoadAclResultImpl extends C0630b implements LoadAclResult {
        LoadAclResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadEventResultImpl extends C0630b implements LoadEventsResult {
        private final EventBuffer NU;

        LoadEventResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.NU = new EventBuffer(dataHolder);
        }

        public EventBuffer getEvents() {
            return this.NU;
        }
    }

    private static final class LoadExtendedGamesResultImpl extends C0630b implements LoadExtendedGamesResult {
        private final ExtendedGameBuffer NV;

        LoadExtendedGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.NV = new ExtendedGameBuffer(dataHolder);
        }
    }

    private static final class LoadGameInstancesResultImpl extends C0630b implements LoadGameInstancesResult {
        private final GameInstanceBuffer NW;

        LoadGameInstancesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.NW = new GameInstanceBuffer(dataHolder);
        }
    }

    private static final class LoadGameSearchSuggestionsResultImpl extends C0630b implements LoadGameSearchSuggestionsResult {
        LoadGameSearchSuggestionsResultImpl(DataHolder data) {
            super(data);
        }
    }

    private static final class LoadGamesResultImpl extends C0630b implements LoadGamesResult {
        private final GameBuffer NX;

        LoadGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.NX = new GameBuffer(dataHolder);
        }

        public GameBuffer getGames() {
            return this.NX;
        }
    }

    private static final class LoadInvitationsResultImpl extends C0630b implements LoadInvitationsResult {
        private final InvitationBuffer NY;

        LoadInvitationsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.NY = new InvitationBuffer(dataHolder);
        }

        public InvitationBuffer getInvitations() {
            return this.NY;
        }
    }

    private static final class LoadMatchesResultImpl implements LoadMatchesResult {
        private final LoadMatchesResponse NZ;
        private final Status yz;

        LoadMatchesResultImpl(Status status, Bundle matchData) {
            this.yz = status;
            this.NZ = new LoadMatchesResponse(matchData);
        }

        public LoadMatchesResponse getMatches() {
            return this.NZ;
        }

        public Status getStatus() {
            return this.yz;
        }

        public void release() {
            this.NZ.close();
        }
    }

    private static final class LoadOwnerCoverPhotoUrisResultImpl implements LoadOwnerCoverPhotoUrisResult {
        private final Bundle HM;
        private final Status yz;

        LoadOwnerCoverPhotoUrisResultImpl(int statusCode, Bundle bundle) {
            this.yz = new Status(statusCode);
            this.HM = bundle;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static final class LoadPlayerScoreResultImpl extends C0630b implements LoadPlayerScoreResult {
        private final LeaderboardScoreEntity Oa;

        LoadPlayerScoreResultImpl(DataHolder scoreHolder) {
            super(scoreHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(scoreHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.Oa = (LeaderboardScoreEntity) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.Oa = null;
                }
                leaderboardScoreBuffer.close();
            } catch (Throwable th) {
                leaderboardScoreBuffer.close();
            }
        }

        public LeaderboardScore getScore() {
            return this.Oa;
        }
    }

    private static final class LoadPlayersResultImpl extends C0630b implements LoadPlayersResult {
        private final PlayerBuffer Ob;

        LoadPlayersResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.Ob = new PlayerBuffer(dataHolder);
        }

        public PlayerBuffer getPlayers() {
            return this.Ob;
        }
    }

    private static final class LoadQuestsResultImpl extends C0630b implements LoadQuestsResult {
        private final DataHolder DG;

        LoadQuestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.DG = dataHolder;
        }

        public QuestBuffer getQuests() {
            return new QuestBuffer(this.DG);
        }
    }

    private static final class LoadRequestSummariesResultImpl extends C0630b implements LoadRequestSummariesResult {
        LoadRequestSummariesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadRequestsResultImpl implements LoadRequestsResult {
        private final Bundle Oc;
        private final Status yz;

        LoadRequestsResultImpl(Status status, Bundle requestData) {
            this.yz = status;
            this.Oc = requestData;
        }

        public GameRequestBuffer getRequests(int requestType) {
            String cm = RequestType.cm(requestType);
            return !this.Oc.containsKey(cm) ? null : new GameRequestBuffer((DataHolder) this.Oc.get(cm));
        }

        public Status getStatus() {
            return this.yz;
        }

        public void release() {
            for (String parcelable : this.Oc.keySet()) {
                DataHolder dataHolder = (DataHolder) this.Oc.getParcelable(parcelable);
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    private static final class LoadScoresResultImpl extends C0630b implements LoadScoresResult {
        private final LeaderboardEntity Od;
        private final LeaderboardScoreBuffer Oe;

        LoadScoresResultImpl(DataHolder leaderboard, DataHolder scores) {
            super(scores);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(leaderboard);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.Od = (LeaderboardEntity) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.Od = null;
                }
                leaderboardBuffer.close();
                this.Oe = new LeaderboardScoreBuffer(scores);
            } catch (Throwable th) {
                leaderboardBuffer.close();
            }
        }

        public Leaderboard getLeaderboard() {
            return this.Od;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.Oe;
        }
    }

    private static final class LoadSnapshotsResultImpl extends C0630b implements LoadSnapshotsResult {
        LoadSnapshotsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }

        public SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.DG);
        }
    }

    private static final class LoadXpForGameCategoriesResultImpl implements LoadXpForGameCategoriesResult {
        private final List<String> Of;
        private final Bundle Og;
        private final Status yz;

        LoadXpForGameCategoriesResultImpl(Status status, Bundle xpData) {
            this.yz = status;
            this.Of = xpData.getStringArrayList("game_category_list");
            this.Og = xpData;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static final class LoadXpStreamResultImpl extends C0630b implements LoadXpStreamResult {
        private final ExperienceEventBuffer Oh;

        LoadXpStreamResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.Oh = new ExperienceEventBuffer(dataHolder);
        }
    }

    private static final class OpenSnapshotResultImpl extends C0630b implements OpenSnapshotResult {
        private final Snapshot Om;
        private final String On;
        private final Snapshot Oo;
        private final Contents Op;

        OpenSnapshotResultImpl(DataHolder dataHolder, Contents currentContents) {
            this(dataHolder, null, currentContents, null, null);
        }

        OpenSnapshotResultImpl(DataHolder metadataHolder, String conflictId, Contents currentContents, Contents conflictContents, Contents resolutionContents) {
            boolean z = true;
            super(metadataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(metadataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.Om = null;
                    this.Oo = null;
                } else if (snapshotMetadataBuffer.getCount() == 1) {
                    if (metadataHolder.getStatusCode() == WearableStatusCodes.INVALID_TARGET_NODE) {
                        z = false;
                    }
                    gx.m1158A(z);
                    this.Om = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), currentContents);
                    this.Oo = null;
                } else {
                    this.Om = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), currentContents);
                    this.Oo = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(1)), conflictContents);
                }
                snapshotMetadataBuffer.close();
                this.On = conflictId;
                this.Op = resolutionContents;
            } catch (Throwable th) {
                snapshotMetadataBuffer.close();
            }
        }

        public String getConflictId() {
            return this.On;
        }

        public Snapshot getConflictingSnapshot() {
            return this.Oo;
        }

        public Contents getResolutionContents() {
            return this.Op;
        }

        public Snapshot getSnapshot() {
            return this.Om;
        }
    }

    private static final class SendRequestResultImpl extends C0630b implements SendRequestResult {
        private final GameRequest OA;

        SendRequestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    this.OA = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                } else {
                    this.OA = null;
                }
                gameRequestBuffer.close();
            } catch (Throwable th) {
                gameRequestBuffer.close();
            }
        }
    }

    private static final class SubmitScoreResultImpl extends C0630b implements SubmitScoreResult {
        private final ScoreSubmissionData OM;

        public SubmitScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.OM = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        public ScoreSubmissionData getScoreData() {
            return this.OM;
        }
    }

    private static abstract class TurnBasedMatchResult extends C0630b {
        final TurnBasedMatch Ok;

        TurnBasedMatchResult(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.Ok = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.Ok = null;
                }
                turnBasedMatchBuffer.close();
            } catch (Throwable th) {
                turnBasedMatchBuffer.close();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.Ok;
        }
    }

    private static final class UpdateAchievementResultImpl implements UpdateAchievementResult {
        private final String OT;
        private final Status yz;

        UpdateAchievementResultImpl(int statusCode, String achievementId) {
            this.yz = new Status(statusCode);
            this.OT = achievementId;
        }

        public String getAchievementId() {
            return this.OT;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static final class UpdateRequestsResultImpl extends C0630b implements UpdateRequestsResult {
        private final RequestUpdateOutcomes OU;

        UpdateRequestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.OU = RequestUpdateOutcomes.m738U(dataHolder);
        }

        public Set<String> getRequestIds() {
            return this.OU.getRequestIds();
        }

        public int getRequestOutcome(String requestId) {
            return this.OU.getRequestOutcome(requestId);
        }
    }

    private abstract class AbstractPeerStatusCallback extends AbstractRoomStatusCallback {
        final /* synthetic */ GamesClientImpl NE;
        private final ArrayList<String> NF;

        AbstractPeerStatusCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
            this.NF = new ArrayList();
            for (Object add : participantIds) {
                this.NF.add(add);
            }
        }

        protected void m3948a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            m3949a(roomStatusUpdateListener, room, this.NF);
        }

        protected abstract void m3949a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    private final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<UpdateAchievementResult> yR;

        AchievementUpdatedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<UpdateAchievementResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m3950e(int i, String str) {
            this.yR.m154a(new UpdateAchievementResultImpl(i, str));
        }
    }

    private final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LoadAchievementsResult> yR;

        AchievementsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<LoadAchievementsResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m3951c(DataHolder dataHolder) {
            this.yR.m154a(new LoadAchievementsResultImpl(dataHolder));
        }
    }

    private final class ConnectedToRoomCallback extends AbstractRoomStatusCallback {
        final /* synthetic */ GamesClientImpl NE;

        ConnectedToRoomCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        public void m3952a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    private final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<ContactSettingLoadResult> yR;

        ContactSettingsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<ContactSettingLoadResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void m3953D(DataHolder dataHolder) {
            this.yR.m154a(new ContactSettingLoadResultImpl(dataHolder));
        }
    }

    private final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<Status> yR;

        ContactSettingsUpdatedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<Status> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void ce(int i) {
            this.yR.m154a(new Status(i));
        }
    }

    private final class DisconnectedFromRoomCallback extends AbstractRoomStatusCallback {
        final /* synthetic */ GamesClientImpl NE;

        DisconnectedFromRoomCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        public void m3954a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    private final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LoadEventsResult> yR;

        EventsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<LoadEventsResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m3955d(DataHolder dataHolder) {
            this.yR.m154a(new LoadEventResultImpl(dataHolder));
        }
    }

    private final class ExtendedGamesLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LoadExtendedGamesResult> yR;

        ExtendedGamesLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<LoadExtendedGamesResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void m3956j(DataHolder dataHolder) {
            this.yR.m154a(new LoadExtendedGamesResultImpl(dataHolder));
        }
    }

    private final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LoadGameInstancesResult> yR;

        GameInstancesLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<LoadGameInstancesResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void m3957k(DataHolder dataHolder) {
            this.yR.m154a(new LoadGameInstancesResultImpl(dataHolder));
        }
    }

    private final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<GameMuteStatusChangeResult> yR;

        GameMuteStatusChangedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<GameMuteStatusChangeResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void m3958a(int i, String str, boolean z) {
            this.yR.m154a(new GameMuteStatusChangeResultImpl(i, str, z));
        }
    }

    private final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<GameMuteStatusLoadResult> yR;

        GameMuteStatusLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<GameMuteStatusLoadResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void m3959B(DataHolder dataHolder) {
            this.yR.m154a(new GameMuteStatusLoadResultImpl(dataHolder));
        }
    }

    private final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LoadGameSearchSuggestionsResult> yR;

        GameSearchSuggestionsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<LoadGameSearchSuggestionsResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void m3960l(DataHolder dataHolder) {
            this.yR.m154a(new LoadGameSearchSuggestionsResultImpl(dataHolder));
        }
    }

    private final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LoadGamesResult> yR;

        GamesLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<LoadGamesResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void m3961i(DataHolder dataHolder) {
            this.yR.m154a(new LoadGamesResultImpl(dataHolder));
        }
    }

    private final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<InboxCountResult> yR;

        InboxCountsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<InboxCountResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void m3962f(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.yR.m154a(new InboxCountResultImpl(new Status(i), bundle));
        }
    }

    private static final class InitiateMatchResultImpl extends TurnBasedMatchResult implements InitiateMatchResult {
        InitiateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final OnInvitationReceivedListener NO;

        InvitationReceivedBinderCallback(GamesClientImpl gamesClientImpl, OnInvitationReceivedListener listener) {
            this.NE = gamesClientImpl;
            this.NO = listener;
        }

        public void m3963n(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                invitationBuffer.close();
                if (invitation != null) {
                    this.NE.m2664a(new InvitationReceivedCallback(this.NE, this.NO, invitation));
                }
            } catch (Throwable th) {
                invitationBuffer.close();
            }
        }

        public void onInvitationRemoved(String invitationId) {
            this.NE.m2664a(new InvitationRemovedCallback(this.NE, this.NO, invitationId));
        }
    }

    private final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LoadInvitationsResult> yR;

        InvitationsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<LoadInvitationsResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m3964m(DataHolder dataHolder) {
            this.yR.m154a(new LoadInvitationsResultImpl(dataHolder));
        }
    }

    private final class JoinedRoomCallback extends AbstractRoomCallback {
        final /* synthetic */ GamesClientImpl NE;

        public JoinedRoomCallback(GamesClientImpl gamesClientImpl, RoomUpdateListener listener, DataHolder dataHolder) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        public void m3965a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    private final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LoadScoresResult> yR;

        LeaderboardScoresLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<LoadScoresResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m3966a(DataHolder dataHolder, DataHolder dataHolder2) {
            this.yR.m154a(new LoadScoresResultImpl(dataHolder, dataHolder2));
        }
    }

    private final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LeaderboardMetadataResult> yR;

        LeaderboardsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<LeaderboardMetadataResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m3967e(DataHolder dataHolder) {
            this.yR.m154a(new LeaderboardMetadataResultImpl(dataHolder));
        }
    }

    private static final class LeaveMatchResultImpl extends TurnBasedMatchResult implements LeaveMatchResult {
        LeaveMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadMatchResultImpl extends TurnBasedMatchResult implements LoadMatchResult {
        LoadMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final OnTurnBasedMatchUpdateReceivedListener Oj;

        MatchUpdateReceivedBinderCallback(GamesClientImpl gamesClientImpl, OnTurnBasedMatchUpdateReceivedListener listener) {
            this.NE = gamesClientImpl;
            this.Oj = listener;
        }

        public void onTurnBasedMatchRemoved(String matchId) {
            this.NE.m2664a(new MatchRemovedCallback(this.NE, this.Oj, matchId));
        }

        public void m3968t(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            TurnBasedMatch turnBasedMatch = null;
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    turnBasedMatch = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                }
                turnBasedMatchBuffer.close();
                if (turnBasedMatch != null) {
                    this.NE.m2664a(new MatchUpdateReceivedCallback(this.NE, this.Oj, turnBasedMatch));
                }
            } catch (Throwable th) {
                turnBasedMatchBuffer.close();
            }
        }
    }

    private final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LoadAclResult> yR;

        NotifyAclLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<LoadAclResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m3969C(DataHolder dataHolder) {
            this.yR.m154a(new LoadAclResultImpl(dataHolder));
        }
    }

    private final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<Status> yR;

        NotifyAclUpdatedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<Status> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void cd(int i) {
            this.yR.m154a(new Status(i));
        }
    }

    private final class OwnerCoverPhotoUrisLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LoadOwnerCoverPhotoUrisResult> yR;

        OwnerCoverPhotoUrisLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<LoadOwnerCoverPhotoUrisResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void m3970d(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.yR.m154a(new LoadOwnerCoverPhotoUrisResultImpl(i, bundle));
        }
    }

    private final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LoadPlayerScoreResult> yR;

        PlayerLeaderboardScoreLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<LoadPlayerScoreResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m3971E(DataHolder dataHolder) {
            this.yR.m154a(new LoadPlayerScoreResultImpl(dataHolder));
        }
    }

    private final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LoadXpForGameCategoriesResult> yR;

        PlayerXpForGameCategoriesLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<LoadXpForGameCategoriesResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void m3972e(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.yR.m154a(new LoadXpForGameCategoriesResultImpl(new Status(i), bundle));
        }
    }

    final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LoadXpStreamResult> yR;

        PlayerXpStreamLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<LoadXpStreamResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void m3973P(DataHolder dataHolder) {
            this.yR.m154a(new LoadXpStreamResultImpl(dataHolder));
        }
    }

    private final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LoadPlayersResult> yR;

        PlayersLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0180d<LoadPlayersResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void m3974g(DataHolder dataHolder) {
            this.yR.m154a(new LoadPlayersResultImpl(dataHolder));
        }

        public void m3975h(DataHolder dataHolder) {
            this.yR.m154a(new LoadPlayersResultImpl(dataHolder));
        }
    }

    private final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<AcceptQuestResult> Or;

        public QuestAcceptedBinderCallbacks(GamesClientImpl gamesClientImpl, C0180d<AcceptQuestResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.Or = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m3976L(DataHolder dataHolder) {
            this.Or.m154a(new AcceptQuestResultImpl(dataHolder));
        }
    }

    private final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<ClaimMilestoneResult> Os;
        private final String Ot;

        public QuestMilestoneClaimBinderCallbacks(GamesClientImpl gamesClientImpl, C0180d<ClaimMilestoneResult> resultHolder, String milestoneId) {
            this.NE = gamesClientImpl;
            this.Os = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
            this.Ot = (String) hm.m1228b((Object) milestoneId, (Object) "MilestoneId must not be null");
        }

        public void m3977K(DataHolder dataHolder) {
            this.Os.m154a(new ClaimMilestoneResultImpl(dataHolder, this.Ot));
        }
    }

    private final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final QuestUpdateListener Ou;

        QuestUpdateBinderCallback(GamesClientImpl gamesClientImpl, QuestUpdateListener listener) {
            this.NE = gamesClientImpl;
            this.Ou = listener;
        }

        private Quest m3978R(DataHolder dataHolder) {
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            Quest quest = null;
            try {
                if (questBuffer.getCount() > 0) {
                    quest = (Quest) ((Quest) questBuffer.get(0)).freeze();
                }
                questBuffer.close();
                return quest;
            } catch (Throwable th) {
                questBuffer.close();
            }
        }

        public void m3979M(DataHolder dataHolder) {
            Quest R = m3978R(dataHolder);
            if (R != null) {
                this.NE.m2664a(new QuestCompletedCallback(this.NE, this.Ou, R));
            }
        }
    }

    private final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LoadQuestsResult> Ov;

        public QuestsLoadedBinderCallbacks(GamesClientImpl gamesClientImpl, C0180d<LoadQuestsResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.Ov = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m3980O(DataHolder dataHolder) {
            this.Ov.m154a(new LoadQuestsResultImpl(dataHolder));
        }
    }

    private final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        final ReliableMessageSentCallback Oy;

        public RealTimeReliableMessageBinderCallbacks(GamesClientImpl gamesClientImpl, ReliableMessageSentCallback messageSentCallbacks) {
            this.NE = gamesClientImpl;
            this.Oy = messageSentCallbacks;
        }

        public void m3981b(int i, int i2, String str) {
            this.NE.m2664a(new RealTimeMessageSentCallback(this.NE, this.Oy, i, i2, str));
        }
    }

    private final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final OnRequestReceivedListener Oz;

        RequestReceivedBinderCallback(GamesClientImpl gamesClientImpl, OnRequestReceivedListener listener) {
            this.NE = gamesClientImpl;
            this.Oz = listener;
        }

        public void m3982o(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            GameRequest gameRequest = null;
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    gameRequest = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                }
                gameRequestBuffer.close();
                if (gameRequest != null) {
                    this.NE.m2664a(new RequestReceivedCallback(this.NE, this.Oz, gameRequest));
                }
            } catch (Throwable th) {
                gameRequestBuffer.close();
            }
        }

        public void onRequestRemoved(String requestId) {
            this.NE.m2664a(new RequestRemovedCallback(this.NE, this.Oz, requestId));
        }
    }

    private final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<SendRequestResult> OC;

        public RequestSentBinderCallbacks(GamesClientImpl gamesClientImpl, C0180d<SendRequestResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OC = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m3983G(DataHolder dataHolder) {
            this.OC.m154a(new SendRequestResultImpl(dataHolder));
        }
    }

    private final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LoadRequestSummariesResult> OD;

        public RequestSummariesLoadedBinderCallbacks(GamesClientImpl gamesClientImpl, C0180d<LoadRequestSummariesResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OD = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m3984H(DataHolder dataHolder) {
            this.OD.m154a(new LoadRequestSummariesResultImpl(dataHolder));
        }
    }

    private final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LoadRequestsResult> OE;

        public RequestsLoadedBinderCallbacks(GamesClientImpl gamesClientImpl, C0180d<LoadRequestsResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OE = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m3985c(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.OE.m154a(new LoadRequestsResultImpl(new Status(i), bundle));
        }
    }

    private final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<UpdateRequestsResult> OF;

        public RequestsUpdatedBinderCallbacks(GamesClientImpl gamesClientImpl, C0180d<UpdateRequestsResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OF = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m3986F(DataHolder dataHolder) {
            this.OF.m154a(new UpdateRequestsResultImpl(dataHolder));
        }
    }

    private final class RoomAutoMatchingCallback extends AbstractRoomStatusCallback {
        final /* synthetic */ GamesClientImpl NE;

        RoomAutoMatchingCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        public void m3987a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    private final class RoomBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final RoomUpdateListener OG;
        private final RoomStatusUpdateListener OH;
        private final RealTimeMessageReceivedListener OI;

        public RoomBinderCallbacks(GamesClientImpl gamesClientImpl, RoomUpdateListener roomCallbacks) {
            this.NE = gamesClientImpl;
            this.OG = (RoomUpdateListener) hm.m1228b((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.OH = null;
            this.OI = null;
        }

        public RoomBinderCallbacks(GamesClientImpl gamesClientImpl, RoomUpdateListener roomCallbacks, RoomStatusUpdateListener roomStatusCallbacks, RealTimeMessageReceivedListener realTimeMessageReceivedCallbacks) {
            this.NE = gamesClientImpl;
            this.OG = (RoomUpdateListener) hm.m1228b((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.OH = roomStatusCallbacks;
            this.OI = realTimeMessageReceivedCallbacks;
        }

        public void m3988A(DataHolder dataHolder) {
            this.NE.m2664a(new DisconnectedFromRoomCallback(this.NE, this.OH, dataHolder));
        }

        public void m3989a(DataHolder dataHolder, String[] strArr) {
            this.NE.m2664a(new PeerInvitedToRoomCallback(this.NE, this.OH, dataHolder, strArr));
        }

        public void m3990b(DataHolder dataHolder, String[] strArr) {
            this.NE.m2664a(new PeerJoinedRoomCallback(this.NE, this.OH, dataHolder, strArr));
        }

        public void m3991c(DataHolder dataHolder, String[] strArr) {
            this.NE.m2664a(new PeerLeftRoomCallback(this.NE, this.OH, dataHolder, strArr));
        }

        public void m3992d(DataHolder dataHolder, String[] strArr) {
            this.NE.m2664a(new PeerDeclinedCallback(this.NE, this.OH, dataHolder, strArr));
        }

        public void m3993e(DataHolder dataHolder, String[] strArr) {
            this.NE.m2664a(new PeerConnectedCallback(this.NE, this.OH, dataHolder, strArr));
        }

        public void m3994f(DataHolder dataHolder, String[] strArr) {
            this.NE.m2664a(new PeerDisconnectedCallback(this.NE, this.OH, dataHolder, strArr));
        }

        public void onLeftRoom(int statusCode, String externalRoomId) {
            this.NE.m2664a(new LeftRoomCallback(this.NE, this.OG, statusCode, externalRoomId));
        }

        public void onP2PConnected(String participantId) {
            this.NE.m2664a(new P2PConnectedCallback(this.NE, this.OH, participantId));
        }

        public void onP2PDisconnected(String participantId) {
            this.NE.m2664a(new P2PDisconnectedCallback(this.NE, this.OH, participantId));
        }

        public void onRealTimeMessageReceived(RealTimeMessage message) {
            this.NE.m2664a(new MessageReceivedCallback(this.NE, this.OI, message));
        }

        public void m3995u(DataHolder dataHolder) {
            this.NE.m2664a(new RoomCreatedCallback(this.NE, this.OG, dataHolder));
        }

        public void m3996v(DataHolder dataHolder) {
            this.NE.m2664a(new JoinedRoomCallback(this.NE, this.OG, dataHolder));
        }

        public void m3997w(DataHolder dataHolder) {
            this.NE.m2664a(new RoomConnectingCallback(this.NE, this.OH, dataHolder));
        }

        public void m3998x(DataHolder dataHolder) {
            this.NE.m2664a(new RoomAutoMatchingCallback(this.NE, this.OH, dataHolder));
        }

        public void m3999y(DataHolder dataHolder) {
            this.NE.m2664a(new RoomConnectedCallback(this.NE, this.OG, dataHolder));
        }

        public void m4000z(DataHolder dataHolder) {
            this.NE.m2664a(new ConnectedToRoomCallback(this.NE, this.OH, dataHolder));
        }
    }

    private final class RoomConnectedCallback extends AbstractRoomCallback {
        final /* synthetic */ GamesClientImpl NE;

        RoomConnectedCallback(GamesClientImpl gamesClientImpl, RoomUpdateListener listener, DataHolder dataHolder) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        public void m4001a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    private final class RoomConnectingCallback extends AbstractRoomStatusCallback {
        final /* synthetic */ GamesClientImpl NE;

        RoomConnectingCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        public void m4002a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    private final class RoomCreatedCallback extends AbstractRoomCallback {
        final /* synthetic */ GamesClientImpl NE;

        public RoomCreatedCallback(GamesClientImpl gamesClientImpl, RoomUpdateListener listener, DataHolder dataHolder) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        public void m4003a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    private final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<Status> yR;

        public SignOutCompleteBinderCallbacks(GamesClientImpl gamesClientImpl, C0180d<Status> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void dT() {
            this.yR.m154a(new Status(0));
        }
    }

    private final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<CommitSnapshotResult> OJ;

        public SnapshotCommittedBinderCallbacks(GamesClientImpl gamesClientImpl, C0180d<CommitSnapshotResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OJ = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m4004J(DataHolder dataHolder) {
            this.OJ.m154a(new CommitSnapshotResultImpl(dataHolder));
        }
    }

    final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<DeleteSnapshotResult> yR;

        public SnapshotDeletedBinderCallbacks(GamesClientImpl gamesClientImpl, C0180d<DeleteSnapshotResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m4005g(int i, String str) {
            this.yR.m154a(new DeleteSnapshotResultImpl(i, str));
        }
    }

    private final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<OpenSnapshotResult> OK;

        public SnapshotOpenedBinderCallbacks(GamesClientImpl gamesClientImpl, C0180d<OpenSnapshotResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OK = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m4006a(DataHolder dataHolder, Contents contents) {
            this.OK.m154a(new OpenSnapshotResultImpl(dataHolder, contents));
        }

        public void m4007a(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            this.OK.m154a(new OpenSnapshotResultImpl(dataHolder, str, contents, contents2, contents3));
        }
    }

    private final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LoadSnapshotsResult> OL;

        public SnapshotsLoadedBinderCallbacks(GamesClientImpl gamesClientImpl, C0180d<LoadSnapshotsResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OL = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m4008I(DataHolder dataHolder) {
            this.OL.m154a(new LoadSnapshotsResultImpl(dataHolder));
        }
    }

    private final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<SubmitScoreResult> yR;

        public SubmitScoreBinderCallbacks(GamesClientImpl gamesClientImpl, C0180d<SubmitScoreResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m4009f(DataHolder dataHolder) {
            this.yR.m154a(new SubmitScoreResultImpl(dataHolder));
        }
    }

    private final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<CancelMatchResult> ON;

        public TurnBasedMatchCanceledBinderCallbacks(GamesClientImpl gamesClientImpl, C0180d<CancelMatchResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.ON = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m4010f(int i, String str) {
            this.ON.m154a(new CancelMatchResultImpl(new Status(i), str));
        }
    }

    private final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<InitiateMatchResult> OO;

        public TurnBasedMatchInitiatedBinderCallbacks(GamesClientImpl gamesClientImpl, C0180d<InitiateMatchResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OO = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m4011q(DataHolder dataHolder) {
            this.OO.m154a(new InitiateMatchResultImpl(dataHolder));
        }
    }

    private final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LeaveMatchResult> OP;

        public TurnBasedMatchLeftBinderCallbacks(GamesClientImpl gamesClientImpl, C0180d<LeaveMatchResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OP = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m4012s(DataHolder dataHolder) {
            this.OP.m154a(new LeaveMatchResultImpl(dataHolder));
        }
    }

    private final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LoadMatchResult> OQ;

        public TurnBasedMatchLoadedBinderCallbacks(GamesClientImpl gamesClientImpl, C0180d<LoadMatchResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OQ = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m4013p(DataHolder dataHolder) {
            this.OQ.m154a(new LoadMatchResultImpl(dataHolder));
        }
    }

    private final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<UpdateMatchResult> OR;

        public TurnBasedMatchUpdatedBinderCallbacks(GamesClientImpl gamesClientImpl, C0180d<UpdateMatchResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OR = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m4014r(DataHolder dataHolder) {
            this.OR.m154a(new UpdateMatchResultImpl(dataHolder));
        }
    }

    private final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0180d<LoadMatchesResult> OS;

        public TurnBasedMatchesLoadedBinderCallbacks(GamesClientImpl gamesClientImpl, C0180d<LoadMatchesResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OS = (C0180d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m4015b(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.OS.m154a(new LoadMatchesResultImpl(new Status(i), bundle));
        }
    }

    private static final class UpdateMatchResultImpl extends TurnBasedMatchResult implements UpdateMatchResult {
        UpdateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private final class PeerConnectedCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl NE;

        PeerConnectedCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        protected void m4155a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    private final class PeerDeclinedCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl NE;

        PeerDeclinedCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        protected void m4156a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    private final class PeerDisconnectedCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl NE;

        PeerDisconnectedCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        protected void m4157a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    private final class PeerInvitedToRoomCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl NE;

        PeerInvitedToRoomCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        protected void m4158a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    private final class PeerJoinedRoomCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl NE;

        PeerJoinedRoomCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        protected void m4159a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    private final class PeerLeftRoomCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl NE;

        PeerLeftRoomCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        protected void m4160a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    public GamesClientImpl(Context context, Looper looper, String gamePackageName, String accountName, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener, String[] scopes, int gravity, View gamesContentView, boolean isHeadless, boolean showConnectingPopup, int connectingPopupGravity, boolean retryingSignIn, int sdkVariant, String forceResolveAccountKey) {
        super(context, looper, connectedListener, connectionFailedListener, scopes);
        this.Np = new C06901(this);
        this.Nv = false;
        this.Nw = false;
        this.Nq = gamePackageName;
        this.yQ = (String) hm.m1232f(accountName);
        this.Ny = new Binder();
        this.Nr = new HashMap();
        this.Nu = PopupManager.m726a(this, gravity);
        m3425f(gamesContentView);
        this.Nw = showConnectingPopup;
        this.Nx = connectingPopupGravity;
        this.Nz = (long) hashCode();
        this.NA = isHeadless;
        this.NC = retryingSignIn;
        this.NB = sdkVariant;
        this.ND = forceResolveAccountKey;
        registerConnectionCallbacks((ConnectionCallbacks) this);
        registerConnectionFailedListener((OnConnectionFailedListener) this);
    }

    private Room m3333Q(DataHolder dataHolder) {
        RoomBuffer roomBuffer = new RoomBuffer(dataHolder);
        Room room = null;
        try {
            if (roomBuffer.getCount() > 0) {
                room = (Room) ((Room) roomBuffer.get(0)).freeze();
            }
            roomBuffer.close();
            return room;
        } catch (Throwable th) {
            roomBuffer.close();
        }
    }

    private RealTimeSocket aT(String str) {
        try {
            ParcelFileDescriptor bb = ((IGamesService) ft()).bb(str);
            RealTimeSocket libjingleNativeSocket;
            if (bb != null) {
                GamesLog.m481i("GamesClientImpl", "Created native libjingle socket.");
                libjingleNativeSocket = new LibjingleNativeSocket(bb);
                this.Nr.put(str, libjingleNativeSocket);
                return libjingleNativeSocket;
            }
            GamesLog.m481i("GamesClientImpl", "Unable to create native libjingle socket, resorting to old socket.");
            String aW = ((IGamesService) ft()).aW(str);
            if (aW == null) {
                return null;
            }
            LocalSocket localSocket = new LocalSocket();
            try {
                localSocket.connect(new LocalSocketAddress(aW));
                libjingleNativeSocket = new RealTimeSocketImpl(localSocket, str);
                this.Nr.put(str, libjingleNativeSocket);
                return libjingleNativeSocket;
            } catch (IOException e) {
                GamesLog.m483k("GamesClientImpl", "connect() call failed on socket: " + e.getMessage());
                return null;
            }
        } catch (RemoteException e2) {
            GamesLog.m483k("GamesClientImpl", "Unable to create socket. Service died.");
            return null;
        }
    }

    private void gY() {
        this.Ns = null;
    }

    private void hv() {
        for (RealTimeSocket close : this.Nr.values()) {
            try {
                close.close();
            } catch (Throwable e) {
                GamesLog.m480b("GamesClientImpl", "IOException:", e);
            }
        }
        this.Nr.clear();
    }

    public int m3335a(ReliableMessageSentCallback reliableMessageSentCallback, byte[] bArr, String str, String str2) {
        try {
            return ((IGamesService) ft()).m546a(new RealTimeReliableMessageBinderCallbacks(this, reliableMessageSentCallback), bArr, str, str2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int m3336a(byte[] bArr, String str, String[] strArr) {
        hm.m1228b((Object) strArr, (Object) "Participant IDs must not be null");
        try {
            return ((IGamesService) ft()).m604b(bArr, str, strArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return -1;
        }
    }

    public Intent m3337a(int i, int i2, boolean z) {
        try {
            return ((IGamesService) ft()).m547a(i, i2, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent m3338a(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent a = ((IGamesService) ft()).m548a(i, bArr, i2, str);
            hm.m1228b((Object) bitmap, (Object) "Must provide a non null icon");
            a.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return a;
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent m3339a(Room room, int i) {
        try {
            return ((IGamesService) ft()).m551a((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent m3340a(String str, boolean z, boolean z2, int i) {
        try {
            return ((IGamesService) ft()).m552a(str, z, z2, i);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent m3341a(int[] iArr) {
        try {
            return ((IGamesService) ft()).m553a(iArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    protected void m3342a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null) {
            this.Nv = bundle.getBoolean("show_welcome_popup");
        }
        super.m2663a(i, iBinder, bundle);
    }

    public void m3343a(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((IGamesService) ft()).m556a(iBinder, bundle);
            } catch (RemoteException e) {
                GamesLog.m482j("GamesClientImpl", "service died");
            }
        }
    }

    public void m3344a(C0180d<LoadRequestsResult> c0180d, int i, int i2, int i3) {
        try {
            ((IGamesService) ft()).m560a(new RequestsLoadedBinderCallbacks(this, c0180d), i, i2, i3);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3345a(C0180d<LoadExtendedGamesResult> c0180d, int i, int i2, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).m561a(new ExtendedGamesLoadedBinderCallback(this, c0180d), i, i2, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3346a(C0180d<LoadPlayersResult> c0180d, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).m563a(new PlayersLoadedBinderCallback(this, c0180d), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3347a(C0180d<LoadMatchesResult> c0180d, int i, int[] iArr) {
        try {
            ((IGamesService) ft()).m564a(new TurnBasedMatchesLoadedBinderCallbacks(this, c0180d), i, iArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3348a(C0180d<LoadScoresResult> c0180d, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        try {
            ((IGamesService) ft()).m567a(new LeaderboardScoresLoadedBinderCallback(this, c0180d), leaderboardScoreBuffer.iA().iB(), i, i2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3349a(C0180d<InitiateMatchResult> c0180d, TurnBasedMatchConfig turnBasedMatchConfig) {
        try {
            ((IGamesService) ft()).m562a(new TurnBasedMatchInitiatedBinderCallbacks(this, c0180d), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.iH(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3350a(C0180d<CommitSnapshotResult> c0180d, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        Contents contents = snapshot.getContents();
        hm.m1228b((Object) contents, (Object) "Must provide a previously opened Snapshot");
        C0636a iN = snapshotMetadataChange.iN();
        if (iN != null) {
            iN.m2019a(getContext().getCacheDir());
        }
        snapshot.iM();
        try {
            ((IGamesService) ft()).m581a(new SnapshotCommittedBinderCallbacks(this, c0180d), snapshot.getMetadata().getSnapshotId(), snapshotMetadataChange, contents);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3351a(C0180d<LoadPlayersResult> c0180d, String str) {
        try {
            ((IGamesService) ft()).m570a(new PlayersLoadedBinderCallback(this, c0180d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3352a(C0180d<UpdateAchievementResult> c0180d, String str, int i) {
        try {
            ((IGamesService) ft()).m573a(c0180d == null ? null : new AchievementUpdatedBinderCallback(this, c0180d), str, i, this.Nu.hN(), this.Nu.hM());
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3353a(C0180d<LoadScoresResult> c0180d, String str, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) ft()).m572a(new LeaderboardScoresLoadedBinderCallback(this, c0180d), str, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3354a(C0180d<LoadPlayersResult> c0180d, String str, int i, boolean z) {
        try {
            ((IGamesService) ft()).m574a(new PlayersLoadedBinderCallback(this, c0180d), str, i, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3355a(C0180d<LoadPlayersResult> c0180d, String str, int i, boolean z, boolean z2) {
        if (str.equals("played_with")) {
            try {
                ((IGamesService) ft()).m646d(new PlayersLoadedBinderCallback(this, c0180d), str, i, z, z2);
                return;
            } catch (RemoteException e) {
                GamesLog.m482j("GamesClientImpl", "service died");
                return;
            }
        }
        throw new IllegalArgumentException("Invalid player collection: " + str);
    }

    public void m3356a(C0180d<LoadExtendedGamesResult> c0180d, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        try {
            ((IGamesService) ft()).m576a(new ExtendedGamesLoadedBinderCallback(this, c0180d), str, i, z, z2, z3, z4);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3357a(C0180d<LoadMatchesResult> c0180d, String str, int i, int[] iArr) {
        try {
            ((IGamesService) ft()).m577a(new TurnBasedMatchesLoadedBinderCallbacks(this, c0180d), str, i, iArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3358a(C0180d<SubmitScoreResult> c0180d, String str, long j, String str2) {
        try {
            ((IGamesService) ft()).m579a(c0180d == null ? null : new SubmitScoreBinderCallbacks(this, c0180d), str, j, str2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3359a(C0180d<LeaveMatchResult> c0180d, String str, String str2) {
        try {
            ((IGamesService) ft()).m634c(new TurnBasedMatchLeftBinderCallbacks(this, c0180d), str, str2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3360a(C0180d<LoadPlayerScoreResult> c0180d, String str, String str2, int i, int i2) {
        try {
            ((IGamesService) ft()).m583a(new PlayerLeaderboardScoreLoadedBinderCallback(this, c0180d), str, str2, i, i2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3361a(C0180d<LoadRequestsResult> c0180d, String str, String str2, int i, int i2, int i3) {
        try {
            ((IGamesService) ft()).m584a(new RequestsLoadedBinderCallbacks(this, c0180d), str, str2, i, i2, i3);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3362a(C0180d<LoadScoresResult> c0180d, String str, String str2, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) ft()).m585a(new LeaderboardScoresLoadedBinderCallback(this, c0180d), str, str2, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3363a(C0180d<LoadPlayersResult> c0180d, String str, String str2, int i, boolean z, boolean z2) {
        if (str.equals("played_with") || str.equals("circled")) {
            try {
                ((IGamesService) ft()).m586a(new PlayersLoadedBinderCallback(this, c0180d), str, str2, i, z, z2);
                return;
            } catch (RemoteException e) {
                GamesLog.m482j("GamesClientImpl", "service died");
                return;
            }
        }
        throw new IllegalArgumentException("Invalid player collection: " + str);
    }

    public void m3364a(C0180d<OpenSnapshotResult> c0180d, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, Contents contents) {
        C0636a iN = snapshotMetadataChange.iN();
        if (iN != null) {
            iN.m2019a(getContext().getCacheDir());
        }
        try {
            ((IGamesService) ft()).m587a(new SnapshotOpenedBinderCallbacks(this, c0180d), str, str2, snapshotMetadataChange, contents);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3365a(C0180d<LeaderboardMetadataResult> c0180d, String str, String str2, boolean z) {
        try {
            ((IGamesService) ft()).m621b(new LeaderboardsLoadedBinderCallback(this, c0180d), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3366a(C0180d<LoadQuestsResult> c0180d, String str, String str2, boolean z, String[] strArr) {
        try {
            ((IGamesService) ft()).m591a(new QuestsLoadedBinderCallbacks(this, c0180d), str, str2, strArr, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3367a(C0180d<LoadQuestsResult> c0180d, String str, String str2, int[] iArr, int i, boolean z) {
        try {
            ((IGamesService) ft()).m589a(new QuestsLoadedBinderCallbacks(this, c0180d), str, str2, iArr, i, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3368a(C0180d<UpdateRequestsResult> c0180d, String str, String str2, String[] strArr) {
        try {
            ((IGamesService) ft()).m590a(new RequestsUpdatedBinderCallbacks(this, c0180d), str, str2, strArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3369a(C0180d<LeaderboardMetadataResult> c0180d, String str, boolean z) {
        try {
            ((IGamesService) ft()).m636c(new LeaderboardsLoadedBinderCallback(this, c0180d), str, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3370a(C0180d<UpdateMatchResult> c0180d, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
        try {
            ((IGamesService) ft()).m593a(new TurnBasedMatchUpdatedBinderCallbacks(this, c0180d), str, bArr, str2, participantResultArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3371a(C0180d<UpdateMatchResult> c0180d, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
        try {
            ((IGamesService) ft()).m594a(new TurnBasedMatchUpdatedBinderCallbacks(this, c0180d), str, bArr, participantResultArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3372a(C0180d<SendRequestResult> c0180d, String str, String[] strArr, int i, byte[] bArr, int i2) {
        try {
            ((IGamesService) ft()).m596a(new RequestSentBinderCallbacks(this, c0180d), str, strArr, i, bArr, i2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3373a(C0180d<LoadPlayersResult> c0180d, boolean z) {
        try {
            ((IGamesService) ft()).m637c(new PlayersLoadedBinderCallback(this, c0180d), z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3374a(C0180d<Status> c0180d, boolean z, Bundle bundle) {
        try {
            ((IGamesService) ft()).m598a(new ContactSettingsUpdatedBinderCallback(this, c0180d), z, bundle);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3375a(C0180d<LoadEventsResult> c0180d, boolean z, String... strArr) {
        try {
            this.Np.flush();
            ((IGamesService) ft()).m599a(new EventsLoadedBinderCallback(this, c0180d), z, strArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3376a(C0180d<LoadQuestsResult> c0180d, int[] iArr, int i, boolean z) {
        try {
            this.Np.flush();
            ((IGamesService) ft()).m601a(new QuestsLoadedBinderCallbacks(this, c0180d), iArr, i, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3377a(C0180d<LoadPlayersResult> c0180d, String[] strArr) {
        try {
            ((IGamesService) ft()).m638c(new PlayersLoadedBinderCallback(this, c0180d), strArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3378a(OnInvitationReceivedListener onInvitationReceivedListener) {
        try {
            ((IGamesService) ft()).m565a(new InvitationReceivedBinderCallback(this, onInvitationReceivedListener), this.Nz);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3379a(RoomConfig roomConfig) {
        try {
            ((IGamesService) ft()).m568a(new RoomBinderCallbacks(this, roomConfig.getRoomUpdateListener(), roomConfig.getRoomStatusUpdateListener(), roomConfig.getMessageReceivedListener()), this.Ny, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), roomConfig.isSocketEnabled(), this.Nz);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3380a(RoomUpdateListener roomUpdateListener, String str) {
        try {
            ((IGamesService) ft()).m631c(new RoomBinderCallbacks(this, roomUpdateListener), str);
            hv();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3381a(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
        try {
            ((IGamesService) ft()).m609b(new MatchUpdateReceivedBinderCallback(this, onTurnBasedMatchUpdateReceivedListener), this.Nz);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3382a(QuestUpdateListener questUpdateListener) {
        try {
            ((IGamesService) ft()).m643d(new QuestUpdateBinderCallback(this, questUpdateListener), this.Nz);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3383a(OnRequestReceivedListener onRequestReceivedListener) {
        try {
            ((IGamesService) ft()).m629c(new RequestReceivedBinderCallback(this, onRequestReceivedListener), this.Nz);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3384a(Snapshot snapshot) {
        Contents contents = snapshot.getContents();
        hm.m1228b((Object) contents, (Object) "Must provide a previously opened Snapshot");
        snapshot.iM();
        try {
            ((IGamesService) ft()).m557a(contents);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    protected void m3385a(hi hiVar, C1119e c1119e) throws RemoteException {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.NA);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.Nw);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.Nx);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.NC);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.NB);
        bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.ND);
        hiVar.m1193a(c1119e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.yQ, fs(), this.Nq, this.Nu.hN(), locale, bundle);
    }

    public Intent aR(String str) {
        try {
            return ((IGamesService) ft()).aR(str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public void aS(String str) {
        try {
            ((IGamesService) ft()).ba(str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public Intent aU(String str) {
        try {
            return ((IGamesService) ft()).aU(str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    protected IGamesService ah(IBinder iBinder) {
        return Stub.aj(iBinder);
    }

    public Intent m3386b(int i, int i2, boolean z) {
        try {
            return ((IGamesService) ft()).m605b(i, i2, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public void m3387b(C0180d<Status> c0180d) {
        try {
            this.Np.flush();
            ((IGamesService) ft()).m558a(new SignOutCompleteBinderCallbacks(this, c0180d));
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3388b(C0180d<LoadPlayersResult> c0180d, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).m608b(new PlayersLoadedBinderCallback(this, c0180d), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3389b(C0180d<UpdateAchievementResult> c0180d, String str) {
        if (c0180d == null) {
            IGamesCallbacks iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(this, c0180d);
        }
        try {
            ((IGamesService) ft()).m580a(iGamesCallbacks, str, this.Nu.hN(), this.Nu.hM());
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3390b(C0180d<UpdateAchievementResult> c0180d, String str, int i) {
        try {
            ((IGamesService) ft()).m614b(c0180d == null ? null : new AchievementUpdatedBinderCallback(this, c0180d), str, i, this.Nu.hN(), this.Nu.hM());
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3391b(C0180d<LoadScoresResult> c0180d, String str, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) ft()).m613b(new LeaderboardScoresLoadedBinderCallback(this, c0180d), str, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3392b(C0180d<LoadExtendedGamesResult> c0180d, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).m575a(new ExtendedGamesLoadedBinderCallback(this, c0180d), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3393b(C0180d<ClaimMilestoneResult> c0180d, String str, String str2) {
        try {
            this.Np.flush();
            ((IGamesService) ft()).m660f(new QuestMilestoneClaimBinderCallbacks(this, c0180d, str2), str, str2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3394b(C0180d<LoadScoresResult> c0180d, String str, String str2, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) ft()).m619b(new LeaderboardScoresLoadedBinderCallback(this, c0180d), str, str2, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3395b(C0180d<LoadAchievementsResult> c0180d, String str, String str2, boolean z) {
        try {
            ((IGamesService) ft()).m588a(new AchievementsLoadedBinderCallback(this, c0180d), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3396b(C0180d<OpenSnapshotResult> c0180d, String str, boolean z) {
        try {
            ((IGamesService) ft()).m655e(new SnapshotOpenedBinderCallbacks(this, c0180d), str, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3397b(C0180d<LeaderboardMetadataResult> c0180d, boolean z) {
        try {
            ((IGamesService) ft()).m623b(new LeaderboardsLoadedBinderCallback(this, c0180d), z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3398b(C0180d<LoadQuestsResult> c0180d, boolean z, String[] strArr) {
        try {
            ((IGamesService) ft()).m603a(new QuestsLoadedBinderCallbacks(this, c0180d), strArr, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3399b(C0180d<UpdateRequestsResult> c0180d, String[] strArr) {
        try {
            ((IGamesService) ft()).m602a(new RequestsUpdatedBinderCallbacks(this, c0180d), strArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3400b(RoomConfig roomConfig) {
        try {
            ((IGamesService) ft()).m569a(new RoomBinderCallbacks(this, roomConfig.getRoomUpdateListener(), roomConfig.getRoomStatusUpdateListener(), roomConfig.getMessageReceivedListener()), this.Ny, roomConfig.getInvitationId(), roomConfig.isSocketEnabled(), this.Nz);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    protected void m3401b(String... strArr) {
        int i = 0;
        boolean z = false;
        for (String str : strArr) {
            if (str.equals(Scopes.GAMES)) {
                z = true;
            } else if (str.equals("https://www.googleapis.com/auth/games.firstparty")) {
                i = 1;
            }
        }
        if (i != 0) {
            hm.m1227a(!z, "Cannot have both %s and %s!", Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty");
            return;
        }
        hm.m1227a(z, "Games APIs requires %s to function.", Scopes.GAMES);
    }

    protected String bu() {
        return "com.google.android.gms.games.service.START";
    }

    protected String bv() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void m3402c(C0180d<LoadInvitationsResult> c0180d, int i) {
        try {
            ((IGamesService) ft()).m559a(new InvitationsLoadedBinderCallback(this, c0180d), i);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3403c(C0180d<LoadPlayersResult> c0180d, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).m628c(new PlayersLoadedBinderCallback(this, c0180d), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3404c(C0180d<UpdateAchievementResult> c0180d, String str) {
        if (c0180d == null) {
            IGamesCallbacks iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(this, c0180d);
        }
        try {
            ((IGamesService) ft()).m617b(iGamesCallbacks, str, this.Nu.hN(), this.Nu.hM());
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3405c(C0180d<LoadXpStreamResult> c0180d, String str, int i) {
        try {
            ((IGamesService) ft()).m612b(new PlayerXpStreamLoadedBinderCallback(this, c0180d), str, i);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3406c(C0180d<LoadExtendedGamesResult> c0180d, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).m653e(new ExtendedGamesLoadedBinderCallback(this, c0180d), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3407c(C0180d<InitiateMatchResult> c0180d, String str, String str2) {
        try {
            ((IGamesService) ft()).m647d(new TurnBasedMatchInitiatedBinderCallbacks(this, c0180d), str, str2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3408c(C0180d<LoadSnapshotsResult> c0180d, String str, String str2, boolean z) {
        try {
            ((IGamesService) ft()).m635c(new SnapshotsLoadedBinderCallbacks(this, c0180d), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3409c(C0180d<LeaderboardMetadataResult> c0180d, String str, boolean z) {
        try {
            ((IGamesService) ft()).m648d(new LeaderboardsLoadedBinderCallback(this, c0180d), str, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3410c(C0180d<LoadAchievementsResult> c0180d, boolean z) {
        try {
            ((IGamesService) ft()).m597a(new AchievementsLoadedBinderCallback(this, c0180d), z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3411c(C0180d<UpdateRequestsResult> c0180d, String[] strArr) {
        try {
            ((IGamesService) ft()).m624b(new RequestsUpdatedBinderCallbacks(this, c0180d), strArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void cg(int i) {
        this.Nu.setGravity(i);
    }

    public void ch(int i) {
        try {
            ((IGamesService) ft()).ch(i);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void connect() {
        gY();
        super.connect();
    }

    public int m3412d(byte[] bArr, String str) {
        try {
            return ((IGamesService) ft()).m604b(bArr, str, null);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return -1;
        }
    }

    public void m3413d(C0180d<LoadPlayersResult> c0180d, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).m651e(new PlayersLoadedBinderCallback(this, c0180d), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3414d(C0180d<InitiateMatchResult> c0180d, String str) {
        try {
            ((IGamesService) ft()).m672l(new TurnBasedMatchInitiatedBinderCallbacks(this, c0180d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3415d(C0180d<LoadXpStreamResult> c0180d, String str, int i) {
        try {
            ((IGamesService) ft()).m632c(new PlayerXpStreamLoadedBinderCallback(this, c0180d), str, i);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3416d(C0180d<LoadExtendedGamesResult> c0180d, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).m659f(new ExtendedGamesLoadedBinderCallback(this, c0180d), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3417d(C0180d<InitiateMatchResult> c0180d, String str, String str2) {
        try {
            ((IGamesService) ft()).m654e(new TurnBasedMatchInitiatedBinderCallbacks(this, c0180d), str, str2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3418d(C0180d<GameMuteStatusChangeResult> c0180d, String str, boolean z) {
        try {
            ((IGamesService) ft()).m592a(new GameMuteStatusChangedBinderCallback(this, c0180d), str, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3419d(C0180d<LoadEventsResult> c0180d, boolean z) {
        try {
            this.Np.flush();
            ((IGamesService) ft()).m661f(new EventsLoadedBinderCallback(this, c0180d), z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void disconnect() {
        this.Nv = false;
        if (isConnected()) {
            try {
                IGamesService iGamesService = (IGamesService) ft();
                iGamesService.hw();
                this.Np.flush();
                iGamesService.m683q(this.Nz);
            } catch (RemoteException e) {
                GamesLog.m482j("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        hv();
        super.disconnect();
    }

    public void m3420e(C0180d<LoadPlayersResult> c0180d, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).m642d(new PlayersLoadedBinderCallback(this, c0180d), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3421e(C0180d<InitiateMatchResult> c0180d, String str) {
        try {
            ((IGamesService) ft()).m674m(new TurnBasedMatchInitiatedBinderCallbacks(this, c0180d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3422e(C0180d<LoadInvitationsResult> c0180d, String str, int i) {
        try {
            ((IGamesService) ft()).m615b(new InvitationsLoadedBinderCallback(this, c0180d), str, i, false);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3423e(C0180d<LoadExtendedGamesResult> c0180d, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).m633c(new ExtendedGamesLoadedBinderCallback(this, c0180d), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3424e(C0180d<LoadSnapshotsResult> c0180d, boolean z) {
        try {
            ((IGamesService) ft()).m649d(new SnapshotsLoadedBinderCallbacks(this, c0180d), z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public Bundle ef() {
        try {
            Bundle ef = ((IGamesService) ft()).ef();
            if (ef == null) {
                return ef;
            }
            ef.setClassLoader(GamesClientImpl.class.getClassLoader());
            return ef;
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public void m3425f(View view) {
        this.Nu.m727g(view);
    }

    public void m3426f(C0180d<LoadGamesResult> c0180d) {
        try {
            ((IGamesService) ft()).m641d(new GamesLoadedBinderCallback(this, c0180d));
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3427f(C0180d<LeaveMatchResult> c0180d, String str) {
        try {
            ((IGamesService) ft()).m680o(new TurnBasedMatchLeftBinderCallbacks(this, c0180d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3428f(C0180d<LoadRequestSummariesResult> c0180d, String str, int i) {
        try {
            ((IGamesService) ft()).m571a(new RequestSummariesLoadedBinderCallbacks(this, c0180d), str, i);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3429f(C0180d<LoadPlayersResult> c0180d, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).m616b(new PlayersLoadedBinderCallback(this, c0180d), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3430f(C0180d<ContactSettingLoadResult> c0180d, boolean z) {
        try {
            ((IGamesService) ft()).m656e(new ContactSettingsLoadedBinderCallback(this, c0180d), z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3431g(C0180d<LoadOwnerCoverPhotoUrisResult> c0180d) {
        try {
            ((IGamesService) ft()).m669j(new OwnerCoverPhotoUrisLoadedBinderCallback(this, c0180d));
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3432g(C0180d<CancelMatchResult> c0180d, String str) {
        try {
            ((IGamesService) ft()).m677n(new TurnBasedMatchCanceledBinderCallbacks(this, c0180d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3433g(C0180d<LoadPlayersResult> c0180d, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).m620b(new PlayersLoadedBinderCallback(this, c0180d), str, null, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public String gZ() {
        try {
            return ((IGamesService) ft()).gZ();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public void m3434h(C0180d<LoadAclResult> c0180d) {
        try {
            ((IGamesService) ft()).m666h(new NotifyAclLoadedBinderCallback(this, c0180d));
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3435h(C0180d<LoadMatchResult> c0180d, String str) {
        try {
            ((IGamesService) ft()).m681p(new TurnBasedMatchLoadedBinderCallbacks(this, c0180d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public String ha() {
        try {
            return ((IGamesService) ft()).ha();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public Player hb() {
        cn();
        synchronized (this) {
            if (this.Ns == null) {
                PlayerBuffer playerBuffer;
                try {
                    playerBuffer = new PlayerBuffer(((IGamesService) ft()).hy());
                    if (playerBuffer.getCount() > 0) {
                        this.Ns = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.close();
                } catch (RemoteException e) {
                    GamesLog.m482j("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    playerBuffer.close();
                }
            }
        }
        return this.Ns;
    }

    public Game hc() {
        GameBuffer gameBuffer;
        cn();
        synchronized (this) {
            if (this.Nt == null) {
                try {
                    gameBuffer = new GameBuffer(((IGamesService) ft()).hA());
                    if (gameBuffer.getCount() > 0) {
                        this.Nt = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.close();
                } catch (RemoteException e) {
                    GamesLog.m482j("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    gameBuffer.close();
                }
            }
        }
        return this.Nt;
    }

    public Intent hd() {
        try {
            return ((IGamesService) ft()).hd();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent he() {
        try {
            return ((IGamesService) ft()).he();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent hf() {
        try {
            return ((IGamesService) ft()).hf();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent hg() {
        try {
            return ((IGamesService) ft()).hg();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public void hh() {
        try {
            ((IGamesService) ft()).m686r(this.Nz);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void hi() {
        try {
            ((IGamesService) ft()).m688s(this.Nz);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void hj() {
        try {
            ((IGamesService) ft()).m692u(this.Nz);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void hk() {
        try {
            ((IGamesService) ft()).m690t(this.Nz);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public Intent hl() {
        try {
            return ((IGamesService) ft()).hl();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent hm() {
        try {
            return ((IGamesService) ft()).hm();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public int hn() {
        try {
            return ((IGamesService) ft()).hn();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return 4368;
        }
    }

    public String ho() {
        try {
            return ((IGamesService) ft()).ho();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public int hp() {
        try {
            return ((IGamesService) ft()).hp();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return -1;
        }
    }

    public Intent hq() {
        try {
            return ((IGamesService) ft()).hq();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public int hr() {
        try {
            return ((IGamesService) ft()).hr();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int hs() {
        try {
            return ((IGamesService) ft()).hs();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int ht() {
        try {
            return ((IGamesService) ft()).ht();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int hu() {
        try {
            return ((IGamesService) ft()).hu();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return -1;
        }
    }

    public void hw() {
        if (isConnected()) {
            try {
                ((IGamesService) ft()).hw();
            } catch (RemoteException e) {
                GamesLog.m482j("GamesClientImpl", "service died");
            }
        }
    }

    @Deprecated
    public void m3436i(C0180d<ContactSettingLoadResult> c0180d) {
        try {
            ((IGamesService) ft()).m656e(new ContactSettingsLoadedBinderCallback(this, c0180d), false);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3437i(C0180d<AcceptQuestResult> c0180d, String str) {
        try {
            this.Np.flush();
            ((IGamesService) ft()).m693u(new QuestAcceptedBinderCallbacks(this, c0180d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3438j(C0180d<InboxCountResult> c0180d) {
        try {
            ((IGamesService) ft()).m691t(new InboxCountsLoadedBinderCallback(this, c0180d), null);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3439j(C0180d<DeleteSnapshotResult> c0180d, String str) {
        try {
            ((IGamesService) ft()).m687r(new SnapshotDeletedBinderCallbacks(this, c0180d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3440k(C0180d<LoadExtendedGamesResult> c0180d, String str) {
        try {
            ((IGamesService) ft()).m652e(new ExtendedGamesLoadedBinderCallback(this, c0180d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public RealTimeSocket m3441l(String str, String str2) {
        if (str2 == null || !ParticipantUtils.bn(str2)) {
            throw new IllegalArgumentException("Bad participant ID");
        }
        RealTimeSocket realTimeSocket = (RealTimeSocket) this.Nr.get(str2);
        return (realTimeSocket == null || realTimeSocket.isClosed()) ? aT(str2) : realTimeSocket;
    }

    public void m3442l(C0180d<LoadGameInstancesResult> c0180d, String str) {
        try {
            ((IGamesService) ft()).m658f(new GameInstancesLoadedBinderCallback(this, c0180d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3443l(String str, int i) {
        this.Np.m731l(str, i);
    }

    public void m3444m(C0180d<LoadGameSearchSuggestionsResult> c0180d, String str) {
        try {
            ((IGamesService) ft()).m684q(new GameSearchSuggestionsLoadedBinderCallback(this, c0180d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3445m(String str, int i) {
        try {
            ((IGamesService) ft()).m675m(str, i);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3446n(C0180d<LoadXpForGameCategoriesResult> c0180d, String str) {
        try {
            ((IGamesService) ft()).m689s(new PlayerXpForGameCategoriesLoadedBinderCallback(this, c0180d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3447n(String str, int i) {
        try {
            ((IGamesService) ft()).m678n(str, i);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3448o(C0180d<LoadInvitationsResult> c0180d, String str) {
        try {
            ((IGamesService) ft()).m671k(new InvitationsLoadedBinderCallback(this, c0180d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void onConnected(Bundle connectionHint) {
        if (this.Nv) {
            this.Nu.hL();
            this.Nv = false;
        }
    }

    public void onConnectionFailed(ConnectionResult result) {
        this.Nv = false;
    }

    public void onConnectionSuspended(int cause) {
    }

    public void m3449p(C0180d<Status> c0180d, String str) {
        try {
            ((IGamesService) ft()).m670j(new NotifyAclUpdatedBinderCallback(this, c0180d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3450q(C0180d<GameMuteStatusLoadResult> c0180d, String str) {
        try {
            ((IGamesService) ft()).m668i(new GameMuteStatusLoadedBinderCallback(this, c0180d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    protected /* synthetic */ IInterface m3451x(IBinder iBinder) {
        return ah(iBinder);
    }
}
