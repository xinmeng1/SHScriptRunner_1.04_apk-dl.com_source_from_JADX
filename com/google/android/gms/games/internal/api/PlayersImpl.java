package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpForGamesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl implements Players {

    private static abstract class LoadOwnerCoverPhotoUrisImpl extends BaseGamesApiMethodImpl<LoadOwnerCoverPhotoUrisResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadOwnerCoverPhotoUrisImpl.1 */
        class C10771 implements LoadOwnerCoverPhotoUrisResult {
            final /* synthetic */ LoadOwnerCoverPhotoUrisImpl Qj;
            final /* synthetic */ Status yJ;

            C10771(LoadOwnerCoverPhotoUrisImpl loadOwnerCoverPhotoUrisImpl, Status status) {
                this.Qj = loadOwnerCoverPhotoUrisImpl;
                this.yJ = status;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        private LoadOwnerCoverPhotoUrisImpl() {
        }

        public LoadOwnerCoverPhotoUrisResult m4209O(Status status) {
            return new C10771(this, status);
        }

        public /* synthetic */ Result m4210c(Status status) {
            return m4209O(status);
        }
    }

    private static abstract class LoadPlayersImpl extends BaseGamesApiMethodImpl<LoadPlayersResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadPlayersImpl.1 */
        class C10781 implements LoadPlayersResult {
            final /* synthetic */ LoadPlayersImpl Qk;
            final /* synthetic */ Status yJ;

            C10781(LoadPlayersImpl loadPlayersImpl, Status status) {
                this.Qk = loadPlayersImpl;
                this.yJ = status;
            }

            public PlayerBuffer getPlayers() {
                return new PlayerBuffer(DataHolder.af(14));
            }

            public Status getStatus() {
                return this.yJ;
            }

            public void release() {
            }
        }

        private LoadPlayersImpl() {
        }

        public LoadPlayersResult m4211P(Status status) {
            return new C10781(this, status);
        }

        public /* synthetic */ Result m4212c(Status status) {
            return m4211P(status);
        }
    }

    private static abstract class LoadXpForGameCategoriesResultImpl extends BaseGamesApiMethodImpl<LoadXpForGameCategoriesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadXpForGameCategoriesResultImpl.1 */
        class C10791 implements LoadXpForGameCategoriesResult {
            final /* synthetic */ LoadXpForGameCategoriesResultImpl Ql;
            final /* synthetic */ Status yJ;

            C10791(LoadXpForGameCategoriesResultImpl loadXpForGameCategoriesResultImpl, Status status) {
                this.Ql = loadXpForGameCategoriesResultImpl;
                this.yJ = status;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        private LoadXpForGameCategoriesResultImpl() {
        }

        public LoadXpForGameCategoriesResult m4213Q(Status status) {
            return new C10791(this, status);
        }

        public /* synthetic */ Result m4214c(Status status) {
            return m4213Q(status);
        }
    }

    private static abstract class LoadXpForGameResultImpl extends BaseGamesApiMethodImpl<LoadXpForGamesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadXpForGameResultImpl.1 */
        class C10801 implements LoadXpForGamesResult {
            final /* synthetic */ Status yJ;

            public Status getStatus() {
                return this.yJ;
            }
        }

        private LoadXpForGameResultImpl() {
        }
    }

    private static abstract class LoadXpStreamResultImpl extends BaseGamesApiMethodImpl<LoadXpStreamResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadXpStreamResultImpl.1 */
        class C10811 implements LoadXpStreamResult {
            final /* synthetic */ LoadXpStreamResultImpl Qm;
            final /* synthetic */ Status yJ;

            C10811(LoadXpStreamResultImpl loadXpStreamResultImpl, Status status) {
                this.Qm = loadXpStreamResultImpl;
                this.yJ = status;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        private LoadXpStreamResultImpl() {
        }

        public LoadXpStreamResult m4215R(Status status) {
            return new C10811(this, status);
        }

        public /* synthetic */ Result m4216c(Status status) {
            return m4215R(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.10 */
    class AnonymousClass10 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;

        protected void m4514a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3388b((C0180d) this, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.11 */
    class AnonymousClass11 extends LoadPlayersImpl {
        final /* synthetic */ int Pv;

        protected void m4516a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3388b((C0180d) this, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.12 */
    class AnonymousClass12 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;

        protected void m4518a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3403c((C0180d) this, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.13 */
    class AnonymousClass13 extends LoadPlayersImpl {
        final /* synthetic */ int Pv;

        protected void m4520a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3403c((C0180d) this, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.14 */
    class AnonymousClass14 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;

        protected void m4522a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3413d(this, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.15 */
    class AnonymousClass15 extends LoadPlayersImpl {
        final /* synthetic */ int Pv;

        protected void m4524a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3413d(this, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.16 */
    class AnonymousClass16 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;
        final /* synthetic */ String Px;

        protected void m4526a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3429f(this, this.Px, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.17 */
    class AnonymousClass17 extends LoadPlayersImpl {
        final /* synthetic */ int Pv;
        final /* synthetic */ String Px;

        protected void m4528a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3429f(this, this.Px, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.18 */
    class AnonymousClass18 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Ph;
        final /* synthetic */ int Qe;

        protected void m4530a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3354a((C0180d) this, this.Ph, this.Qe, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.19 */
    class AnonymousClass19 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;

        protected void m4532a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3420e(this, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.1 */
    class C13791 extends LoadPlayersImpl {
        final /* synthetic */ String Pg;
        final /* synthetic */ PlayersImpl Qd;

        C13791(PlayersImpl playersImpl, String str) {
            this.Qd = playersImpl;
            this.Pg = str;
            super();
        }

        protected void m4534a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3351a((C0180d) this, this.Pg);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.20 */
    class AnonymousClass20 extends LoadPlayersImpl {
        final /* synthetic */ int Pv;

        protected void m4536a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3420e(this, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.21 */
    class AnonymousClass21 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;
        final /* synthetic */ String Qg;

        protected void m4538a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3433g(this, this.Qg, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.22 */
    class AnonymousClass22 extends LoadPlayersImpl {
        final /* synthetic */ int Pv;
        final /* synthetic */ String Qg;

        protected void m4540a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3433g(this, this.Qg, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.23 */
    class AnonymousClass23 extends LoadOwnerCoverPhotoUrisImpl {
        protected void m4542a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3431g(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.24 */
    class AnonymousClass24 extends LoadXpForGameCategoriesResultImpl {
        final /* synthetic */ String Qh;

        protected void m4544a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3446n((C0180d) this, this.Qh);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.25 */
    class AnonymousClass25 extends LoadXpStreamResultImpl {
        final /* synthetic */ String Qh;
        final /* synthetic */ int Qi;

        protected void m4546a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3405c((C0180d) this, this.Qh, this.Qi);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.26 */
    class AnonymousClass26 extends LoadXpStreamResultImpl {
        final /* synthetic */ String Qh;
        final /* synthetic */ int Qi;

        protected void m4548a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3415d((C0180d) this, this.Qh, this.Qi);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.2 */
    class C13802 extends LoadPlayersImpl {
        final /* synthetic */ String[] Qf;

        protected void m4550a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3377a((C0180d) this, this.Qf);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.3 */
    class C13813 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;
        final /* synthetic */ PlayersImpl Qd;

        C13813(PlayersImpl playersImpl, int i, boolean z) {
            this.Qd = playersImpl;
            this.Pv = i;
            this.Pe = z;
            super();
        }

        protected void m4552a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3346a((C0180d) this, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.4 */
    class C13824 extends LoadPlayersImpl {
        final /* synthetic */ int Pv;
        final /* synthetic */ PlayersImpl Qd;

        C13824(PlayersImpl playersImpl, int i) {
            this.Qd = playersImpl;
            this.Pv = i;
            super();
        }

        protected void m4554a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3346a((C0180d) this, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.5 */
    class C13835 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;
        final /* synthetic */ PlayersImpl Qd;

        C13835(PlayersImpl playersImpl, int i, boolean z) {
            this.Qd = playersImpl;
            this.Pv = i;
            this.Pe = z;
            super();
        }

        protected void m4556a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3355a((C0180d) this, "played_with", this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.6 */
    class C13846 extends LoadPlayersImpl {
        final /* synthetic */ int Pv;
        final /* synthetic */ PlayersImpl Qd;

        C13846(PlayersImpl playersImpl, int i) {
            this.Qd = playersImpl;
            this.Pv = i;
            super();
        }

        protected void m4558a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3355a((C0180d) this, "played_with", this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.7 */
    class C13857 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Ph;
        final /* synthetic */ int Pv;

        protected void m4560a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3363a((C0180d) this, "played_with", this.Ph, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.8 */
    class C13868 extends LoadPlayersImpl {
        final /* synthetic */ String Ph;
        final /* synthetic */ int Pv;

        protected void m4562a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3363a((C0180d) this, "played_with", this.Ph, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.9 */
    class C13879 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ PlayersImpl Qd;

        C13879(PlayersImpl playersImpl, boolean z) {
            this.Qd = playersImpl;
            this.Pe = z;
            super();
        }

        protected void m4564a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3373a((C0180d) this, this.Pe);
        }
    }

    public Player getCurrentPlayer(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hb();
    }

    public String getCurrentPlayerId(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).ha();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hl();
    }

    public PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.m146a(new C13879(this, forceReload));
    }

    public PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient apiClient, int pageSize, boolean forceReload) {
        return apiClient.m146a(new C13813(this, pageSize, forceReload));
    }

    public PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient apiClient, int pageSize) {
        return apiClient.m146a(new C13824(this, pageSize));
    }

    public PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient apiClient, int pageSize) {
        return apiClient.m146a(new C13846(this, pageSize));
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, String playerId) {
        return apiClient.m146a(new C13791(this, playerId));
    }

    public PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient apiClient, int pageSize, boolean forceReload) {
        return apiClient.m146a(new C13835(this, pageSize, forceReload));
    }
}
