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
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AchievementsImpl implements Achievements {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadAchievementsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.LoadImpl.1 */
        class C10591 implements LoadAchievementsResult {
            final /* synthetic */ LoadImpl Pk;
            final /* synthetic */ Status yJ;

            C10591(LoadImpl loadImpl, Status status) {
                this.Pk = loadImpl;
                this.yJ = status;
            }

            public AchievementBuffer getAchievements() {
                return new AchievementBuffer(DataHolder.af(14));
            }

            public Status getStatus() {
                return this.yJ;
            }

            public void release() {
            }
        }

        private LoadImpl() {
        }

        public /* synthetic */ Result m4161c(Status status) {
            return m4162v(status);
        }

        public LoadAchievementsResult m4162v(Status status) {
            return new C10591(this, status);
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<UpdateAchievementResult> {
        private final String xG;

        /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.UpdateImpl.1 */
        class C10601 implements UpdateAchievementResult {
            final /* synthetic */ UpdateImpl Pl;
            final /* synthetic */ Status yJ;

            C10601(UpdateImpl updateImpl, Status status) {
                this.Pl = updateImpl;
                this.yJ = status;
            }

            public String getAchievementId() {
                return this.Pl.xG;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        public UpdateImpl(String id) {
            this.xG = id;
        }

        public /* synthetic */ Result m4164c(Status status) {
            return m4165w(status);
        }

        public UpdateAchievementResult m4165w(Status status) {
            return new C10601(this, status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.10 */
    class AnonymousClass10 extends LoadImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Pg;
        final /* synthetic */ String Ph;

        public void m4410a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3395b((C0180d) this, this.Pg, this.Ph, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.1 */
    class C13401 extends LoadImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ AchievementsImpl Pf;

        C13401(AchievementsImpl achievementsImpl, boolean z) {
            this.Pf = achievementsImpl;
            this.Pe = z;
            super();
        }

        public void m4412a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3410c((C0180d) this, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.2 */
    class C13412 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl Pf;
        final /* synthetic */ String Pi;

        C13412(AchievementsImpl achievementsImpl, String x0, String str) {
            this.Pf = achievementsImpl;
            this.Pi = str;
            super(x0);
        }

        public void m4414a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3389b(null, this.Pi);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.3 */
    class C13423 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl Pf;
        final /* synthetic */ String Pi;

        C13423(AchievementsImpl achievementsImpl, String x0, String str) {
            this.Pf = achievementsImpl;
            this.Pi = str;
            super(x0);
        }

        public void m4416a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3389b((C0180d) this, this.Pi);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.4 */
    class C13434 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl Pf;
        final /* synthetic */ String Pi;

        C13434(AchievementsImpl achievementsImpl, String x0, String str) {
            this.Pf = achievementsImpl;
            this.Pi = str;
            super(x0);
        }

        public void m4418a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3404c(null, this.Pi);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.5 */
    class C13445 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl Pf;
        final /* synthetic */ String Pi;

        C13445(AchievementsImpl achievementsImpl, String x0, String str) {
            this.Pf = achievementsImpl;
            this.Pi = str;
            super(x0);
        }

        public void m4420a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3404c((C0180d) this, this.Pi);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.6 */
    class C13456 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl Pf;
        final /* synthetic */ String Pi;
        final /* synthetic */ int Pj;

        C13456(AchievementsImpl achievementsImpl, String x0, String str, int i) {
            this.Pf = achievementsImpl;
            this.Pi = str;
            this.Pj = i;
            super(x0);
        }

        public void m4422a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3352a(null, this.Pi, this.Pj);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.7 */
    class C13467 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl Pf;
        final /* synthetic */ String Pi;
        final /* synthetic */ int Pj;

        C13467(AchievementsImpl achievementsImpl, String x0, String str, int i) {
            this.Pf = achievementsImpl;
            this.Pi = str;
            this.Pj = i;
            super(x0);
        }

        public void m4424a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3352a((C0180d) this, this.Pi, this.Pj);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.8 */
    class C13478 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl Pf;
        final /* synthetic */ String Pi;
        final /* synthetic */ int Pj;

        C13478(AchievementsImpl achievementsImpl, String x0, String str, int i) {
            this.Pf = achievementsImpl;
            this.Pi = str;
            this.Pj = i;
            super(x0);
        }

        public void m4426a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3390b(null, this.Pi, this.Pj);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.9 */
    class C13489 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl Pf;
        final /* synthetic */ String Pi;
        final /* synthetic */ int Pj;

        C13489(AchievementsImpl achievementsImpl, String x0, String str, int i) {
            this.Pf = achievementsImpl;
            this.Pi = str;
            this.Pj = i;
            super(x0);
        }

        public void m4428a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3390b((C0180d) this, this.Pi, this.Pj);
        }
    }

    public Intent getAchievementsIntent(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).he();
    }

    public void increment(GoogleApiClient apiClient, String id, int numSteps) {
        apiClient.m147b(new C13456(this, id, id, numSteps));
    }

    public PendingResult<UpdateAchievementResult> incrementImmediate(GoogleApiClient apiClient, String id, int numSteps) {
        return apiClient.m147b(new C13467(this, id, id, numSteps));
    }

    public PendingResult<LoadAchievementsResult> load(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.m146a(new C13401(this, forceReload));
    }

    public void reveal(GoogleApiClient apiClient, String id) {
        apiClient.m147b(new C13412(this, id, id));
    }

    public PendingResult<UpdateAchievementResult> revealImmediate(GoogleApiClient apiClient, String id) {
        return apiClient.m147b(new C13423(this, id, id));
    }

    public void setSteps(GoogleApiClient apiClient, String id, int numSteps) {
        apiClient.m147b(new C13478(this, id, id, numSteps));
    }

    public PendingResult<UpdateAchievementResult> setStepsImmediate(GoogleApiClient apiClient, String id, int numSteps) {
        return apiClient.m147b(new C13489(this, id, id, numSteps));
    }

    public void unlock(GoogleApiClient apiClient, String id) {
        apiClient.m147b(new C13434(this, id, id));
    }

    public PendingResult<UpdateAchievementResult> unlockImmediate(GoogleApiClient apiClient, String id) {
        return apiClient.m147b(new C13445(this, id, id));
    }
}
