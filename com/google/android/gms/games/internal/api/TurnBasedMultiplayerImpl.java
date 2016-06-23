package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import java.util.List;

public final class TurnBasedMultiplayerImpl implements TurnBasedMultiplayer {

    private static abstract class CancelMatchImpl extends BaseGamesApiMethodImpl<CancelMatchResult> {
        private final String xG;

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.CancelMatchImpl.1 */
        class C10931 implements CancelMatchResult {
            final /* synthetic */ CancelMatchImpl Rc;
            final /* synthetic */ Status yJ;

            C10931(CancelMatchImpl cancelMatchImpl, Status status) {
                this.Rc = cancelMatchImpl;
                this.yJ = status;
            }

            public String getMatchId() {
                return this.Rc.xG;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        public CancelMatchImpl(String id) {
            this.xG = id;
        }

        public CancelMatchResult ad(Status status) {
            return new C10931(this, status);
        }

        public /* synthetic */ Result m4237c(Status status) {
            return ad(status);
        }
    }

    private static abstract class InitiateMatchImpl extends BaseGamesApiMethodImpl<InitiateMatchResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.InitiateMatchImpl.1 */
        class C10941 implements InitiateMatchResult {
            final /* synthetic */ InitiateMatchImpl Rd;
            final /* synthetic */ Status yJ;

            C10941(InitiateMatchImpl initiateMatchImpl, Status status) {
                this.Rd = initiateMatchImpl;
                this.yJ = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        private InitiateMatchImpl() {
        }

        public InitiateMatchResult ae(Status status) {
            return new C10941(this, status);
        }

        public /* synthetic */ Result m4238c(Status status) {
            return ae(status);
        }
    }

    private static abstract class LeaveMatchImpl extends BaseGamesApiMethodImpl<LeaveMatchResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LeaveMatchImpl.1 */
        class C10951 implements LeaveMatchResult {
            final /* synthetic */ LeaveMatchImpl Re;
            final /* synthetic */ Status yJ;

            C10951(LeaveMatchImpl leaveMatchImpl, Status status) {
                this.Re = leaveMatchImpl;
                this.yJ = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        private LeaveMatchImpl() {
        }

        public LeaveMatchResult af(Status status) {
            return new C10951(this, status);
        }

        public /* synthetic */ Result m4239c(Status status) {
            return af(status);
        }
    }

    private static abstract class LoadMatchImpl extends BaseGamesApiMethodImpl<LoadMatchResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LoadMatchImpl.1 */
        class C10961 implements LoadMatchResult {
            final /* synthetic */ LoadMatchImpl Rf;
            final /* synthetic */ Status yJ;

            C10961(LoadMatchImpl loadMatchImpl, Status status) {
                this.Rf = loadMatchImpl;
                this.yJ = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        private LoadMatchImpl() {
        }

        public LoadMatchResult ag(Status status) {
            return new C10961(this, status);
        }

        public /* synthetic */ Result m4240c(Status status) {
            return ag(status);
        }
    }

    private static abstract class LoadMatchesImpl extends BaseGamesApiMethodImpl<LoadMatchesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LoadMatchesImpl.1 */
        class C10971 implements LoadMatchesResult {
            final /* synthetic */ LoadMatchesImpl Rg;
            final /* synthetic */ Status yJ;

            C10971(LoadMatchesImpl loadMatchesImpl, Status status) {
                this.Rg = loadMatchesImpl;
                this.yJ = status;
            }

            public LoadMatchesResponse getMatches() {
                return new LoadMatchesResponse(new Bundle());
            }

            public Status getStatus() {
                return this.yJ;
            }

            public void release() {
            }
        }

        private LoadMatchesImpl() {
        }

        public LoadMatchesResult ah(Status status) {
            return new C10971(this, status);
        }

        public /* synthetic */ Result m4241c(Status status) {
            return ah(status);
        }
    }

    private static abstract class UpdateMatchImpl extends BaseGamesApiMethodImpl<UpdateMatchResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.UpdateMatchImpl.1 */
        class C10981 implements UpdateMatchResult {
            final /* synthetic */ UpdateMatchImpl Rh;
            final /* synthetic */ Status yJ;

            C10981(UpdateMatchImpl updateMatchImpl, Status status) {
                this.Rh = updateMatchImpl;
                this.yJ = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        private UpdateMatchImpl() {
        }

        public UpdateMatchResult ai(Status status) {
            return new C10981(this, status);
        }

        public /* synthetic */ Result m4242c(Status status) {
            return ai(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.10 */
    class AnonymousClass10 extends LoadMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl QV;
        final /* synthetic */ String QW;

        AnonymousClass10(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, String str) {
            this.QV = turnBasedMultiplayerImpl;
            this.QW = str;
            super();
        }

        protected void m4606a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3435h(this, this.QW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.11 */
    class AnonymousClass11 extends InitiateMatchImpl {
        final /* synthetic */ String Ph;
        final /* synthetic */ String QW;

        protected void m4608a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3407c((C0180d) this, this.Ph, this.QW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.12 */
    class AnonymousClass12 extends InitiateMatchImpl {
        final /* synthetic */ String Ph;
        final /* synthetic */ String QW;

        protected void m4610a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3417d((C0180d) this, this.Ph, this.QW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.13 */
    class AnonymousClass13 extends LoadMatchesImpl {
        final /* synthetic */ String Ph;
        final /* synthetic */ int QX;
        final /* synthetic */ int[] QY;

        protected void m4612a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3357a((C0180d) this, this.Ph, this.QX, this.QY);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.1 */
    class C14081 extends InitiateMatchImpl {
        final /* synthetic */ TurnBasedMatchConfig QU;
        final /* synthetic */ TurnBasedMultiplayerImpl QV;

        C14081(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, TurnBasedMatchConfig turnBasedMatchConfig) {
            this.QV = turnBasedMultiplayerImpl;
            this.QU = turnBasedMatchConfig;
            super();
        }

        protected void m4614a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3349a((C0180d) this, this.QU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.2 */
    class C14092 extends InitiateMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl QV;
        final /* synthetic */ String QW;

        C14092(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, String str) {
            this.QV = turnBasedMultiplayerImpl;
            this.QW = str;
            super();
        }

        protected void m4616a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3414d((C0180d) this, this.QW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.3 */
    class C14103 extends InitiateMatchImpl {
        final /* synthetic */ String PG;
        final /* synthetic */ TurnBasedMultiplayerImpl QV;

        C14103(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, String str) {
            this.QV = turnBasedMultiplayerImpl;
            this.PG = str;
            super();
        }

        protected void m4618a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3421e((C0180d) this, this.PG);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.4 */
    class C14114 extends UpdateMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl QV;
        final /* synthetic */ String QW;
        final /* synthetic */ byte[] QZ;
        final /* synthetic */ String Ra;
        final /* synthetic */ ParticipantResult[] Rb;

        C14114(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
            this.QV = turnBasedMultiplayerImpl;
            this.QW = str;
            this.QZ = bArr;
            this.Ra = str2;
            this.Rb = participantResultArr;
            super();
        }

        protected void m4620a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3370a((C0180d) this, this.QW, this.QZ, this.Ra, this.Rb);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.5 */
    class C14125 extends UpdateMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl QV;
        final /* synthetic */ String QW;
        final /* synthetic */ byte[] QZ;
        final /* synthetic */ ParticipantResult[] Rb;

        C14125(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
            this.QV = turnBasedMultiplayerImpl;
            this.QW = str;
            this.QZ = bArr;
            this.Rb = participantResultArr;
            super();
        }

        protected void m4622a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3371a((C0180d) this, this.QW, this.QZ, this.Rb);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.6 */
    class C14136 extends LeaveMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl QV;
        final /* synthetic */ String QW;

        C14136(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, String str) {
            this.QV = turnBasedMultiplayerImpl;
            this.QW = str;
            super();
        }

        protected void m4624a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3427f((C0180d) this, this.QW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.7 */
    class C14147 extends LeaveMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl QV;
        final /* synthetic */ String QW;
        final /* synthetic */ String Ra;

        C14147(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, String str, String str2) {
            this.QV = turnBasedMultiplayerImpl;
            this.QW = str;
            this.Ra = str2;
            super();
        }

        protected void m4626a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3359a((C0180d) this, this.QW, this.Ra);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.8 */
    class C14158 extends CancelMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl QV;
        final /* synthetic */ String QW;

        C14158(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, String x0, String str) {
            this.QV = turnBasedMultiplayerImpl;
            this.QW = str;
            super(x0);
        }

        protected void m4628a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3432g(this, this.QW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.9 */
    class C14169 extends LoadMatchesImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl QV;
        final /* synthetic */ int QX;
        final /* synthetic */ int[] QY;

        C14169(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, int i, int[] iArr) {
            this.QV = turnBasedMultiplayerImpl;
            this.QX = i;
            this.QY = iArr;
            super();
        }

        protected void m4630a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3347a((C0180d) this, this.QX, this.QY);
        }
    }

    public PendingResult<InitiateMatchResult> acceptInvitation(GoogleApiClient apiClient, String invitationId) {
        return apiClient.m147b(new C14103(this, invitationId));
    }

    public PendingResult<CancelMatchResult> cancelMatch(GoogleApiClient apiClient, String matchId) {
        return apiClient.m147b(new C14158(this, matchId, matchId));
    }

    public PendingResult<InitiateMatchResult> createMatch(GoogleApiClient apiClient, TurnBasedMatchConfig config) {
        return apiClient.m147b(new C14081(this, config));
    }

    public void declineInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.m472c(apiClient).m3447n(invitationId, 1);
    }

    public void dismissInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.m472c(apiClient).m3445m(invitationId, 1);
    }

    public void dismissMatch(GoogleApiClient apiClient, String matchId) {
        Games.m472c(apiClient).aS(matchId);
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId) {
        return finishMatch(apiClient, matchId, null, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, List<ParticipantResult> results) {
        return finishMatch(apiClient, matchId, matchData, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, ParticipantResult... results) {
        return apiClient.m147b(new C14125(this, matchId, matchData, results));
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hf();
    }

    public int getMaxMatchDataSize(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hp();
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers) {
        return Games.m472c(apiClient).m3337a(minPlayers, maxPlayers, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers, boolean allowAutomatch) {
        return Games.m472c(apiClient).m3337a(minPlayers, maxPlayers, allowAutomatch);
    }

    public PendingResult<LeaveMatchResult> leaveMatch(GoogleApiClient apiClient, String matchId) {
        return apiClient.m147b(new C14136(this, matchId));
    }

    public PendingResult<LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient apiClient, String matchId, String pendingParticipantId) {
        return apiClient.m147b(new C14147(this, matchId, pendingParticipantId));
    }

    public PendingResult<LoadMatchResult> loadMatch(GoogleApiClient apiClient, String matchId) {
        return apiClient.m146a(new AnonymousClass10(this, matchId));
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, int invitationSortOrder, int[] matchTurnStatuses) {
        return apiClient.m146a(new C14169(this, invitationSortOrder, matchTurnStatuses));
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, int[] matchTurnStatuses) {
        return loadMatchesByStatus(apiClient, 0, matchTurnStatuses);
    }

    public void registerMatchUpdateListener(GoogleApiClient apiClient, OnTurnBasedMatchUpdateReceivedListener listener) {
        Games.m472c(apiClient).m3381a(listener);
    }

    public PendingResult<InitiateMatchResult> rematch(GoogleApiClient apiClient, String matchId) {
        return apiClient.m147b(new C14092(this, matchId));
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, List<ParticipantResult> results) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, ParticipantResult... results) {
        return apiClient.m147b(new C14114(this, matchId, matchData, pendingParticipantId, results));
    }

    public void unregisterMatchUpdateListener(GoogleApiClient apiClient) {
        Games.m472c(apiClient).hi();
    }
}
