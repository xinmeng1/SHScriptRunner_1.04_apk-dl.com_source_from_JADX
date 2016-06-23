package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;

public final class AclsImpl implements Acls {

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl.1 */
    static class C10611 implements LoadAclResult {
        final /* synthetic */ Status yJ;

        C10611(Status status) {
            this.yJ = status;
        }

        public Status getStatus() {
            return this.yJ;
        }

        public void release() {
        }
    }

    private static abstract class LoadNotifyAclImpl extends BaseGamesApiMethodImpl<LoadAclResult> {
        private LoadNotifyAclImpl() {
        }

        public /* synthetic */ Result m4166c(Status status) {
            return m4167z(status);
        }

        public LoadAclResult m4167z(Status status) {
            return AclsImpl.m2432x(status);
        }
    }

    private static abstract class UpdateNotifyAclImpl extends BaseGamesApiMethodImpl<Status> {
        private UpdateNotifyAclImpl() {
        }

        public /* synthetic */ Result m4168c(Status status) {
            return m4169d(status);
        }

        public Status m4169d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl.2 */
    class C13492 extends LoadNotifyAclImpl {
        protected void m4430a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3434h(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl.3 */
    class C13503 extends UpdateNotifyAclImpl {
        final /* synthetic */ String Pm;

        protected void m4432a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3449p(this, this.Pm);
        }
    }

    private static LoadAclResult m2432x(Status status) {
        return new C10611(status);
    }
}
