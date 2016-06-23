package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.C0176b;
import com.google.android.gms.common.api.Api.C0177c;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.C0181a.C1029b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AclsImpl;
import com.google.android.gms.games.internal.api.EventsImpl;
import com.google.android.gms.games.internal.api.GamesMetadataImpl;
import com.google.android.gms.games.internal.api.InvitationsImpl;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.internal.api.MultiplayerImpl;
import com.google.android.gms.games.internal.api.NotificationsImpl;
import com.google.android.gms.games.internal.api.PlayersImpl;
import com.google.android.gms.games.internal.api.QuestsImpl;
import com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl;
import com.google.android.gms.games.internal.api.RequestsImpl;
import com.google.android.gms.games.internal.api.SnapshotsImpl;
import com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;

public final class Games {
    public static final Api<GamesOptions> API;
    public static final Achievements Achievements;
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final Events Events;
    public static final GamesMetadata GamesMetadata;
    public static final Invitations Invitations;
    public static final Leaderboards Leaderboards;
    public static final Scope MI;
    public static final Api<GamesOptions> MJ;
    public static final Multiplayer MK;
    public static final Acls ML;
    public static final Notifications Notifications;
    public static final Players Players;
    public static final Quests Quests;
    public static final RealTimeMultiplayer RealTimeMultiplayer;
    public static final Requests Requests;
    public static final Scope SCOPE_GAMES;
    public static final Snapshots Snapshots;
    public static final TurnBasedMultiplayer TurnBasedMultiplayer;
    static final C0177c<GamesClientImpl> yH;
    private static final C0176b<GamesClientImpl, GamesOptions> yI;

    /* renamed from: com.google.android.gms.games.Games.1 */
    static class C06891 implements C0176b<GamesClientImpl, GamesOptions> {
        C06891() {
        }

        public GamesClientImpl m2162a(Context context, Looper looper, gy gyVar, GamesOptions gamesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (gamesOptions == null) {
                GamesOptions gamesOptions2 = new GamesOptions();
            }
            return new GamesClientImpl(context, looper, gyVar.fn(), gyVar.fj(), connectionCallbacks, onConnectionFailedListener, gyVar.fm(), gyVar.fk(), gyVar.fo(), gamesOptions.MM, gamesOptions.MN, gamesOptions.MO, gamesOptions.MP, gamesOptions.MQ, gamesOptions.MR);
        }

        public int getPriority() {
            return 1;
        }
    }

    public static abstract class BaseGamesApiMethodImpl<R extends Result> extends C1029b<R, GamesClientImpl> {
        public BaseGamesApiMethodImpl() {
            super(Games.yH);
        }
    }

    public static final class GamesOptions implements Optional {
        final boolean MM;
        final boolean MN;
        final int MO;
        final boolean MP;
        final int MQ;
        final String MR;

        public static final class Builder {
            boolean MM;
            boolean MN;
            int MO;
            boolean MP;
            int MQ;
            String MR;

            private Builder() {
                this.MM = false;
                this.MN = true;
                this.MO = 17;
                this.MP = false;
                this.MQ = 4368;
                this.MR = null;
            }

            public GamesOptions build() {
                return new GamesOptions();
            }

            public Builder setSdkVariant(int variant) {
                this.MQ = variant;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup) {
                this.MN = showConnectingPopup;
                this.MO = 17;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup, int gravity) {
                this.MN = showConnectingPopup;
                this.MO = gravity;
                return this;
            }
        }

        private GamesOptions() {
            this.MM = false;
            this.MN = true;
            this.MO = 17;
            this.MP = false;
            this.MQ = 4368;
            this.MR = null;
        }

        private GamesOptions(Builder builder) {
            this.MM = builder.MM;
            this.MN = builder.MN;
            this.MO = builder.MO;
            this.MP = builder.MP;
            this.MQ = builder.MQ;
            this.MR = builder.MR;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    private static abstract class SignOutImpl extends BaseGamesApiMethodImpl<Status> {
        private SignOutImpl() {
        }

        public /* synthetic */ Result m4153c(Status status) {
            return m4154d(status);
        }

        public Status m4154d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.games.Games.2 */
    static class C13392 extends SignOutImpl {
        C13392() {
            super();
        }

        protected void m4408a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3387b((C0180d) this);
        }
    }

    static {
        yH = new C0177c();
        yI = new C06891();
        SCOPE_GAMES = new Scope(Scopes.GAMES);
        API = new Api(yI, yH, SCOPE_GAMES);
        MI = new Scope("https://www.googleapis.com/auth/games.firstparty");
        MJ = new Api(yI, yH, MI);
        GamesMetadata = new GamesMetadataImpl();
        Achievements = new AchievementsImpl();
        Events = new EventsImpl();
        Leaderboards = new LeaderboardsImpl();
        Invitations = new InvitationsImpl();
        TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();
        RealTimeMultiplayer = new RealTimeMultiplayerImpl();
        MK = new MultiplayerImpl();
        Players = new PlayersImpl();
        Notifications = new NotificationsImpl();
        Quests = new QuestsImpl();
        Requests = new RequestsImpl();
        Snapshots = new SnapshotsImpl();
        ML = new AclsImpl();
    }

    private Games() {
    }

    public static GamesClientImpl m472c(GoogleApiClient googleApiClient) {
        hm.m1230b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        hm.m1226a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        return m473d(googleApiClient);
    }

    public static GamesClientImpl m473d(GoogleApiClient googleApiClient) {
        GamesClientImpl gamesClientImpl = (GamesClientImpl) googleApiClient.m145a(yH);
        hm.m1226a(gamesClientImpl != null, "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return gamesClientImpl;
    }

    public static String getAppId(GoogleApiClient apiClient) {
        return m472c(apiClient).ho();
    }

    public static String getCurrentAccountName(GoogleApiClient apiClient) {
        return m472c(apiClient).gZ();
    }

    public static int getSdkVariant(GoogleApiClient apiClient) {
        return m472c(apiClient).hn();
    }

    public static Intent getSettingsIntent(GoogleApiClient apiClient) {
        return m472c(apiClient).hm();
    }

    public static void setGravityForPopups(GoogleApiClient apiClient, int gravity) {
        m472c(apiClient).cg(gravity);
    }

    public static void setViewForPopups(GoogleApiClient apiClient, View gamesContentView) {
        hm.m1232f(gamesContentView);
        m472c(apiClient).m3425f(gamesContentView);
    }

    public static PendingResult<Status> signOut(GoogleApiClient apiClient) {
        return apiClient.m147b(new C13392());
    }
}
