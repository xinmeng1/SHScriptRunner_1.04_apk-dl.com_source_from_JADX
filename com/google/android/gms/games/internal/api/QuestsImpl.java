package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;

public final class QuestsImpl implements Quests {

    private static abstract class AcceptImpl extends BaseGamesApiMethodImpl<AcceptQuestResult> {

        /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.AcceptImpl.1 */
        class C10821 implements AcceptQuestResult {
            final /* synthetic */ AcceptImpl Qt;
            final /* synthetic */ Status yJ;

            C10821(AcceptImpl acceptImpl, Status status) {
                this.Qt = acceptImpl;
                this.yJ = status;
            }

            public Quest getQuest() {
                return null;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        private AcceptImpl() {
        }

        public AcceptQuestResult m4217S(Status status) {
            return new C10821(this, status);
        }

        public /* synthetic */ Result m4218c(Status status) {
            return m4217S(status);
        }
    }

    private static abstract class ClaimImpl extends BaseGamesApiMethodImpl<ClaimMilestoneResult> {

        /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.ClaimImpl.1 */
        class C10831 implements ClaimMilestoneResult {
            final /* synthetic */ ClaimImpl Qu;
            final /* synthetic */ Status yJ;

            C10831(ClaimImpl claimImpl, Status status) {
                this.Qu = claimImpl;
                this.yJ = status;
            }

            public Milestone getMilestone() {
                return null;
            }

            public Quest getQuest() {
                return null;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        private ClaimImpl() {
        }

        public ClaimMilestoneResult m4219T(Status status) {
            return new C10831(this, status);
        }

        public /* synthetic */ Result m4220c(Status status) {
            return m4219T(status);
        }
    }

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadQuestsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.LoadsImpl.1 */
        class C10841 implements LoadQuestsResult {
            final /* synthetic */ LoadsImpl Qv;
            final /* synthetic */ Status yJ;

            C10841(LoadsImpl loadsImpl, Status status) {
                this.Qv = loadsImpl;
                this.yJ = status;
            }

            public QuestBuffer getQuests() {
                return null;
            }

            public Status getStatus() {
                return this.yJ;
            }

            public void release() {
            }
        }

        private LoadsImpl() {
        }

        public LoadQuestsResult m4221U(Status status) {
            return new C10841(this, status);
        }

        public /* synthetic */ Result m4222c(Status status) {
            return m4221U(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.1 */
    class C13881 extends AcceptImpl {
        final /* synthetic */ String Qn;
        final /* synthetic */ QuestsImpl Qo;

        C13881(QuestsImpl questsImpl, String str) {
            this.Qo = questsImpl;
            this.Qn = str;
            super();
        }

        protected void m4566a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3437i(this, this.Qn);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.2 */
    class C13892 extends ClaimImpl {
        final /* synthetic */ String Qn;
        final /* synthetic */ QuestsImpl Qo;
        final /* synthetic */ String Qp;

        C13892(QuestsImpl questsImpl, String str, String str2) {
            this.Qo = questsImpl;
            this.Qn = str;
            this.Qp = str2;
            super();
        }

        protected void m4568a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3393b((C0180d) this, this.Qn, this.Qp);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.3 */
    class C13903 extends LoadsImpl {
        final /* synthetic */ int PE;
        final /* synthetic */ boolean Pe;
        final /* synthetic */ QuestsImpl Qo;
        final /* synthetic */ int[] Qq;

        C13903(QuestsImpl questsImpl, int[] iArr, int i, boolean z) {
            this.Qo = questsImpl;
            this.Qq = iArr;
            this.PE = i;
            this.Pe = z;
            super();
        }

        protected void m4570a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3376a((C0180d) this, this.Qq, this.PE, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.4 */
    class C13914 extends LoadsImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ QuestsImpl Qo;
        final /* synthetic */ String[] Qr;

        C13914(QuestsImpl questsImpl, boolean z, String[] strArr) {
            this.Qo = questsImpl;
            this.Pe = z;
            this.Qr = strArr;
            super();
        }

        protected void m4572a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3398b((C0180d) this, this.Pe, this.Qr);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.5 */
    class C13925 extends LoadsImpl {
        final /* synthetic */ int PE;
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Ph;
        final /* synthetic */ int[] Qq;
        final /* synthetic */ String Qs;

        protected void m4574a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3367a((C0180d) this, this.Ph, this.Qs, this.Qq, this.PE, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.6 */
    class C13936 extends LoadsImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Ph;
        final /* synthetic */ String[] Qr;
        final /* synthetic */ String Qs;

        protected void m4576a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3366a((C0180d) this, this.Ph, this.Qs, this.Pe, this.Qr);
        }
    }

    public PendingResult<AcceptQuestResult> accept(GoogleApiClient apiClient, String questId) {
        return apiClient.m147b(new C13881(this, questId));
    }

    public PendingResult<ClaimMilestoneResult> claim(GoogleApiClient apiClient, String questId, String milestoneId) {
        return apiClient.m147b(new C13892(this, questId, milestoneId));
    }

    public Intent getQuestIntent(GoogleApiClient apiClient, String questId) {
        return Games.m472c(apiClient).aU(questId);
    }

    public Intent getQuestsIntent(GoogleApiClient apiClient, int[] questSelectors) {
        return Games.m472c(apiClient).m3341a(questSelectors);
    }

    public PendingResult<LoadQuestsResult> load(GoogleApiClient apiClient, int[] questSelectors, int sortOrder, boolean forceReload) {
        return apiClient.m146a(new C13903(this, questSelectors, sortOrder, forceReload));
    }

    public PendingResult<LoadQuestsResult> loadByIds(GoogleApiClient apiClient, boolean forceReload, String... questIds) {
        return apiClient.m146a(new C13914(this, forceReload, questIds));
    }

    public void registerQuestUpdateListener(GoogleApiClient apiClient, QuestUpdateListener listener) {
        Games.m472c(apiClient).m3382a(listener);
    }

    public void unregisterQuestUpdateListener(GoogleApiClient apiClient) {
        Games.m472c(apiClient).hj();
    }
}
