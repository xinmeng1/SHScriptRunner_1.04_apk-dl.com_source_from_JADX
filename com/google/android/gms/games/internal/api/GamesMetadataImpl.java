package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class GamesMetadataImpl implements GamesMetadata {

    private static abstract class LoadExtendedGamesImpl extends BaseGamesApiMethodImpl<LoadExtendedGamesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadExtendedGamesImpl.1 */
        class C10631 implements LoadExtendedGamesResult {
            final /* synthetic */ LoadExtendedGamesImpl PA;
            final /* synthetic */ Status yJ;

            C10631(LoadExtendedGamesImpl loadExtendedGamesImpl, Status status) {
                this.PA = loadExtendedGamesImpl;
                this.yJ = status;
            }

            public Status getStatus() {
                return this.yJ;
            }

            public void release() {
            }
        }

        private LoadExtendedGamesImpl() {
        }

        public LoadExtendedGamesResult m4173B(Status status) {
            return new C10631(this, status);
        }

        public /* synthetic */ Result m4174c(Status status) {
            return m4173B(status);
        }
    }

    private static abstract class LoadGameInstancesImpl extends BaseGamesApiMethodImpl<LoadGameInstancesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGameInstancesImpl.1 */
        class C10641 implements LoadGameInstancesResult {
            final /* synthetic */ LoadGameInstancesImpl PB;
            final /* synthetic */ Status yJ;

            C10641(LoadGameInstancesImpl loadGameInstancesImpl, Status status) {
                this.PB = loadGameInstancesImpl;
                this.yJ = status;
            }

            public Status getStatus() {
                return this.yJ;
            }

            public void release() {
            }
        }

        private LoadGameInstancesImpl() {
        }

        public LoadGameInstancesResult m4175C(Status status) {
            return new C10641(this, status);
        }

        public /* synthetic */ Result m4176c(Status status) {
            return m4175C(status);
        }
    }

    private static abstract class LoadGameSearchSuggestionsImpl extends BaseGamesApiMethodImpl<LoadGameSearchSuggestionsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGameSearchSuggestionsImpl.1 */
        class C10651 implements LoadGameSearchSuggestionsResult {
            final /* synthetic */ LoadGameSearchSuggestionsImpl PC;
            final /* synthetic */ Status yJ;

            C10651(LoadGameSearchSuggestionsImpl loadGameSearchSuggestionsImpl, Status status) {
                this.PC = loadGameSearchSuggestionsImpl;
                this.yJ = status;
            }

            public Status getStatus() {
                return this.yJ;
            }

            public void release() {
            }
        }

        private LoadGameSearchSuggestionsImpl() {
        }

        public LoadGameSearchSuggestionsResult m4177D(Status status) {
            return new C10651(this, status);
        }

        public /* synthetic */ Result m4178c(Status status) {
            return m4177D(status);
        }
    }

    private static abstract class LoadGamesImpl extends BaseGamesApiMethodImpl<LoadGamesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGamesImpl.1 */
        class C10661 implements LoadGamesResult {
            final /* synthetic */ LoadGamesImpl PD;
            final /* synthetic */ Status yJ;

            C10661(LoadGamesImpl loadGamesImpl, Status status) {
                this.PD = loadGamesImpl;
                this.yJ = status;
            }

            public GameBuffer getGames() {
                return new GameBuffer(DataHolder.af(14));
            }

            public Status getStatus() {
                return this.yJ;
            }

            public void release() {
            }
        }

        private LoadGamesImpl() {
        }

        public LoadGamesResult m4179E(Status status) {
            return new C10661(this, status);
        }

        public /* synthetic */ Result m4180c(Status status) {
            return m4179E(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.10 */
    class AnonymousClass10 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Pu;
        final /* synthetic */ int Pv;
        final /* synthetic */ boolean Pw;

        protected void m4440a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3356a((C0180d) this, this.Pu, this.Pv, false, true, false, this.Pw);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.11 */
    class AnonymousClass11 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Pg;
        final /* synthetic */ int Pv;

        protected void m4442a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3406c(this, this.Pg, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.12 */
    class AnonymousClass12 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Pg;
        final /* synthetic */ int Pv;

        protected void m4444a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3406c(this, this.Pg, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.13 */
    class AnonymousClass13 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Pg;
        final /* synthetic */ int Pv;

        protected void m4446a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3416d(this, this.Pg, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.14 */
    class AnonymousClass14 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Pg;
        final /* synthetic */ int Pv;

        protected void m4448a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3416d(this, this.Pg, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.15 */
    class AnonymousClass15 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Pu;
        final /* synthetic */ int Pv;
        final /* synthetic */ boolean Pw;

        protected void m4450a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3356a((C0180d) this, this.Pu, this.Pv, true, false, this.Pe, this.Pw);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.16 */
    class AnonymousClass16 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Pu;
        final /* synthetic */ int Pv;
        final /* synthetic */ boolean Pw;

        protected void m4452a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3356a((C0180d) this, this.Pu, this.Pv, true, true, false, this.Pw);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.17 */
    class AnonymousClass17 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;
        final /* synthetic */ String Px;

        protected void m4454a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3423e(this, this.Px, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.18 */
    class AnonymousClass18 extends LoadExtendedGamesImpl {
        final /* synthetic */ int Pv;
        final /* synthetic */ String Px;

        protected void m4456a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3423e(this, this.Px, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.19 */
    class AnonymousClass19 extends LoadGameSearchSuggestionsImpl {
        final /* synthetic */ String Px;

        protected void m4458a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3444m((C0180d) this, this.Px);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.1 */
    class C13541 extends LoadGamesImpl {
        final /* synthetic */ GamesMetadataImpl Pt;

        C13541(GamesMetadataImpl gamesMetadataImpl) {
            this.Pt = gamesMetadataImpl;
            super();
        }

        protected void m4460a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3426f((C0180d) this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.2 */
    class C13552 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Ph;

        protected void m4462a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3440k(this, this.Ph);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.3 */
    class C13563 extends LoadGameInstancesImpl {
        final /* synthetic */ String Ph;

        protected void m4464a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3442l((C0180d) this, this.Ph);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.4 */
    class C13574 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;

        protected void m4466a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3392b(this, null, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.5 */
    class C13585 extends LoadExtendedGamesImpl {
        final /* synthetic */ int Pv;

        protected void m4468a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3392b(this, null, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.6 */
    class C13596 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Pg;
        final /* synthetic */ int Pv;

        protected void m4470a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3392b(this, this.Pg, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.7 */
    class C13607 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Pg;
        final /* synthetic */ int Pv;

        protected void m4472a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3392b(this, this.Pg, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.8 */
    class C13618 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;
        final /* synthetic */ int Py;
        final /* synthetic */ boolean Pz;

        protected void m4474a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3345a((C0180d) this, this.Pv, this.Py, this.Pz, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.9 */
    class C13629 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Pu;
        final /* synthetic */ int Pv;
        final /* synthetic */ boolean Pw;

        protected void m4476a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3356a((C0180d) this, this.Pu, this.Pv, false, false, this.Pe, this.Pw);
        }
    }

    public Game getCurrentGame(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hc();
    }

    public PendingResult<LoadGamesResult> loadGame(GoogleApiClient apiClient) {
        return apiClient.m146a(new C13541(this));
    }
}
