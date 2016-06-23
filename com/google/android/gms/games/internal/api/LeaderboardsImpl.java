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
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

public final class LeaderboardsImpl implements Leaderboards {

    private static abstract class LoadMetadataImpl extends BaseGamesApiMethodImpl<LeaderboardMetadataResult> {

        /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.LoadMetadataImpl.1 */
        class C10681 implements LeaderboardMetadataResult {
            final /* synthetic */ LoadMetadataImpl PR;
            final /* synthetic */ Status yJ;

            C10681(LoadMetadataImpl loadMetadataImpl, Status status) {
                this.PR = loadMetadataImpl;
                this.yJ = status;
            }

            public LeaderboardBuffer getLeaderboards() {
                return new LeaderboardBuffer(DataHolder.af(14));
            }

            public Status getStatus() {
                return this.yJ;
            }

            public void release() {
            }
        }

        private LoadMetadataImpl() {
        }

        public LeaderboardMetadataResult m4183G(Status status) {
            return new C10681(this, status);
        }

        public /* synthetic */ Result m4184c(Status status) {
            return m4183G(status);
        }
    }

    private static abstract class LoadPlayerScoreImpl extends BaseGamesApiMethodImpl<LoadPlayerScoreResult> {

        /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.LoadPlayerScoreImpl.1 */
        class C10691 implements LoadPlayerScoreResult {
            final /* synthetic */ LoadPlayerScoreImpl PS;
            final /* synthetic */ Status yJ;

            C10691(LoadPlayerScoreImpl loadPlayerScoreImpl, Status status) {
                this.PS = loadPlayerScoreImpl;
                this.yJ = status;
            }

            public LeaderboardScore getScore() {
                return null;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        private LoadPlayerScoreImpl() {
        }

        public LoadPlayerScoreResult m4185H(Status status) {
            return new C10691(this, status);
        }

        public /* synthetic */ Result m4186c(Status status) {
            return m4185H(status);
        }
    }

    private static abstract class LoadScoresImpl extends BaseGamesApiMethodImpl<LoadScoresResult> {

        /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.LoadScoresImpl.1 */
        class C10701 implements LoadScoresResult {
            final /* synthetic */ LoadScoresImpl PT;
            final /* synthetic */ Status yJ;

            C10701(LoadScoresImpl loadScoresImpl, Status status) {
                this.PT = loadScoresImpl;
                this.yJ = status;
            }

            public Leaderboard getLeaderboard() {
                return null;
            }

            public LeaderboardScoreBuffer getScores() {
                return new LeaderboardScoreBuffer(DataHolder.af(14));
            }

            public Status getStatus() {
                return this.yJ;
            }

            public void release() {
            }
        }

        private LoadScoresImpl() {
        }

        public LoadScoresResult m4187I(Status status) {
            return new C10701(this, status);
        }

        public /* synthetic */ Result m4188c(Status status) {
            return m4187I(status);
        }
    }

    protected static abstract class SubmitScoreImpl extends BaseGamesApiMethodImpl<SubmitScoreResult> {

        /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.SubmitScoreImpl.1 */
        class C10711 implements SubmitScoreResult {
            final /* synthetic */ SubmitScoreImpl PU;
            final /* synthetic */ Status yJ;

            C10711(SubmitScoreImpl submitScoreImpl, Status status) {
                this.PU = submitScoreImpl;
                this.yJ = status;
            }

            public ScoreSubmissionData getScoreData() {
                return new ScoreSubmissionData(DataHolder.af(14));
            }

            public Status getStatus() {
                return this.yJ;
            }

            public void release() {
            }
        }

        protected SubmitScoreImpl() {
        }

        public SubmitScoreResult m4189J(Status status) {
            return new C10711(this, status);
        }

        public /* synthetic */ Result m4190c(Status status) {
            return m4189J(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.10 */
    class AnonymousClass10 extends LoadScoresImpl {
        final /* synthetic */ String PJ;
        final /* synthetic */ int PK;
        final /* synthetic */ int PL;
        final /* synthetic */ int PM;
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Ph;

        protected void m4484a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3362a((C0180d) this, this.Ph, this.PJ, this.PK, this.PL, this.PM, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.11 */
    class AnonymousClass11 extends LoadScoresImpl {
        final /* synthetic */ String PJ;
        final /* synthetic */ int PK;
        final /* synthetic */ int PL;
        final /* synthetic */ int PM;
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Ph;

        protected void m4486a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3394b(this, this.Ph, this.PJ, this.PK, this.PL, this.PM, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.1 */
    class C13661 extends LoadMetadataImpl {
        final /* synthetic */ LeaderboardsImpl PI;
        final /* synthetic */ boolean Pe;

        C13661(LeaderboardsImpl leaderboardsImpl, boolean z) {
            this.PI = leaderboardsImpl;
            this.Pe = z;
            super();
        }

        protected void m4488a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3397b((C0180d) this, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.2 */
    class C13672 extends LoadMetadataImpl {
        final /* synthetic */ LeaderboardsImpl PI;
        final /* synthetic */ String PJ;
        final /* synthetic */ boolean Pe;

        C13672(LeaderboardsImpl leaderboardsImpl, String str, boolean z) {
            this.PI = leaderboardsImpl;
            this.PJ = str;
            this.Pe = z;
            super();
        }

        protected void m4490a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3369a((C0180d) this, this.PJ, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.3 */
    class C13683 extends LoadPlayerScoreImpl {
        final /* synthetic */ LeaderboardsImpl PI;
        final /* synthetic */ String PJ;
        final /* synthetic */ int PK;
        final /* synthetic */ int PL;

        C13683(LeaderboardsImpl leaderboardsImpl, String str, int i, int i2) {
            this.PI = leaderboardsImpl;
            this.PJ = str;
            this.PK = i;
            this.PL = i2;
            super();
        }

        protected void m4492a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3360a((C0180d) this, null, this.PJ, this.PK, this.PL);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.4 */
    class C13694 extends LoadScoresImpl {
        final /* synthetic */ LeaderboardsImpl PI;
        final /* synthetic */ String PJ;
        final /* synthetic */ int PK;
        final /* synthetic */ int PL;
        final /* synthetic */ int PM;
        final /* synthetic */ boolean Pe;

        C13694(LeaderboardsImpl leaderboardsImpl, String str, int i, int i2, int i3, boolean z) {
            this.PI = leaderboardsImpl;
            this.PJ = str;
            this.PK = i;
            this.PL = i2;
            this.PM = i3;
            this.Pe = z;
            super();
        }

        protected void m4494a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3353a((C0180d) this, this.PJ, this.PK, this.PL, this.PM, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.5 */
    class C13705 extends LoadScoresImpl {
        final /* synthetic */ LeaderboardsImpl PI;
        final /* synthetic */ String PJ;
        final /* synthetic */ int PK;
        final /* synthetic */ int PL;
        final /* synthetic */ int PM;
        final /* synthetic */ boolean Pe;

        C13705(LeaderboardsImpl leaderboardsImpl, String str, int i, int i2, int i3, boolean z) {
            this.PI = leaderboardsImpl;
            this.PJ = str;
            this.PK = i;
            this.PL = i2;
            this.PM = i3;
            this.Pe = z;
            super();
        }

        protected void m4496a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3391b(this, this.PJ, this.PK, this.PL, this.PM, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.6 */
    class C13716 extends LoadScoresImpl {
        final /* synthetic */ LeaderboardsImpl PI;
        final /* synthetic */ int PM;
        final /* synthetic */ LeaderboardScoreBuffer PN;
        final /* synthetic */ int PO;

        C13716(LeaderboardsImpl leaderboardsImpl, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
            this.PI = leaderboardsImpl;
            this.PN = leaderboardScoreBuffer;
            this.PM = i;
            this.PO = i2;
            super();
        }

        protected void m4498a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3348a((C0180d) this, this.PN, this.PM, this.PO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.7 */
    class C13727 extends SubmitScoreImpl {
        final /* synthetic */ LeaderboardsImpl PI;
        final /* synthetic */ String PJ;
        final /* synthetic */ long PP;
        final /* synthetic */ String PQ;

        C13727(LeaderboardsImpl leaderboardsImpl, String str, long j, String str2) {
            this.PI = leaderboardsImpl;
            this.PJ = str;
            this.PP = j;
            this.PQ = str2;
        }

        protected void m4500a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3358a((C0180d) this, this.PJ, this.PP, this.PQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.8 */
    class C13738 extends LoadMetadataImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Ph;

        protected void m4502a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3409c((C0180d) this, this.Ph, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.9 */
    class C13749 extends LoadMetadataImpl {
        final /* synthetic */ String PJ;
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Ph;

        protected void m4504a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3365a((C0180d) this, this.Ph, this.PJ, this.Pe);
        }
    }

    public Intent getAllLeaderboardsIntent(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hd();
    }

    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId) {
        return Games.m472c(apiClient).aR(leaderboardId);
    }

    public PendingResult<LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection) {
        return apiClient.m146a(new C13683(this, leaderboardId, span, leaderboardCollection));
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, String leaderboardId, boolean forceReload) {
        return apiClient.m146a(new C13672(this, leaderboardId, forceReload));
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.m146a(new C13661(this, forceReload));
    }

    public PendingResult<LoadScoresResult> loadMoreScores(GoogleApiClient apiClient, LeaderboardScoreBuffer buffer, int maxResults, int pageDirection) {
        return apiClient.m146a(new C13716(this, buffer, maxResults, pageDirection));
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadPlayerCenteredScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        return apiClient.m146a(new C13705(this, leaderboardId, span, leaderboardCollection, maxResults, forceReload));
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadTopScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        return apiClient.m146a(new C13694(this, leaderboardId, span, leaderboardCollection, maxResults, forceReload));
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score) {
        submitScore(apiClient, leaderboardId, score, null);
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        Games.m472c(apiClient).m3358a(null, leaderboardId, score, scoreTag);
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score) {
        return submitScoreImmediate(apiClient, leaderboardId, score, null);
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        return apiClient.m147b(new C13727(this, leaderboardId, score, scoreTag));
    }
}
