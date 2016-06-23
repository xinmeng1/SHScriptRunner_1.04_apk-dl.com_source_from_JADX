package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class NotificationsImpl implements Notifications {

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.1 */
    class C12601 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String PV;

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.1.1 */
        class C10721 implements GameMuteStatusChangeResult {
            final /* synthetic */ C12601 PW;
            final /* synthetic */ Status yJ;

            C10721(C12601 c12601, Status status) {
                this.PW = c12601;
                this.yJ = status;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        public GameMuteStatusChangeResult m4191K(Status status) {
            return new C10721(this, status);
        }

        protected void m4193a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3418d((C0180d) this, this.PV, true);
        }

        public /* synthetic */ Result m4194c(Status status) {
            return m4191K(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.2 */
    class C12612 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String PV;

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.2.1 */
        class C10731 implements GameMuteStatusChangeResult {
            final /* synthetic */ C12612 PX;
            final /* synthetic */ Status yJ;

            C10731(C12612 c12612, Status status) {
                this.PX = c12612;
                this.yJ = status;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        public GameMuteStatusChangeResult m4195K(Status status) {
            return new C10731(this, status);
        }

        protected void m4197a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3418d((C0180d) this, this.PV, false);
        }

        public /* synthetic */ Result m4198c(Status status) {
            return m4195K(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.3 */
    class C12623 extends BaseGamesApiMethodImpl<GameMuteStatusLoadResult> {
        final /* synthetic */ String PV;

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.3.1 */
        class C10741 implements GameMuteStatusLoadResult {
            final /* synthetic */ C12623 PY;
            final /* synthetic */ Status yJ;

            C10741(C12623 c12623, Status status) {
                this.PY = c12623;
                this.yJ = status;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        public GameMuteStatusLoadResult m4199L(Status status) {
            return new C10741(this, status);
        }

        protected void m4201a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3450q(this, this.PV);
        }

        public /* synthetic */ Result m4202c(Status status) {
            return m4199L(status);
        }
    }

    private static abstract class ContactSettingLoadImpl extends BaseGamesApiMethodImpl<ContactSettingLoadResult> {

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.ContactSettingLoadImpl.1 */
        class C10751 implements ContactSettingLoadResult {
            final /* synthetic */ ContactSettingLoadImpl Qb;
            final /* synthetic */ Status yJ;

            C10751(ContactSettingLoadImpl contactSettingLoadImpl, Status status) {
                this.Qb = contactSettingLoadImpl;
                this.yJ = status;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        private ContactSettingLoadImpl() {
        }

        public ContactSettingLoadResult m4203M(Status status) {
            return new C10751(this, status);
        }

        public /* synthetic */ Result m4204c(Status status) {
            return m4203M(status);
        }
    }

    private static abstract class ContactSettingUpdateImpl extends BaseGamesApiMethodImpl<Status> {
        private ContactSettingUpdateImpl() {
        }

        public /* synthetic */ Result m4205c(Status status) {
            return m4206d(status);
        }

        public Status m4206d(Status status) {
            return status;
        }
    }

    private static abstract class InboxCountImpl extends BaseGamesApiMethodImpl<InboxCountResult> {

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.InboxCountImpl.1 */
        class C10761 implements InboxCountResult {
            final /* synthetic */ InboxCountImpl Qc;
            final /* synthetic */ Status yJ;

            C10761(InboxCountImpl inboxCountImpl, Status status) {
                this.Qc = inboxCountImpl;
                this.yJ = status;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        private InboxCountImpl() {
        }

        public InboxCountResult m4207N(Status status) {
            return new C10761(this, status);
        }

        public /* synthetic */ Result m4208c(Status status) {
            return m4207N(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.4 */
    class C13754 extends ContactSettingLoadImpl {
        protected void m4506a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3436i(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.5 */
    class C13765 extends ContactSettingLoadImpl {
        final /* synthetic */ boolean Pe;

        protected void m4508a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3430f((C0180d) this, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.6 */
    class C13776 extends ContactSettingUpdateImpl {
        final /* synthetic */ boolean PZ;
        final /* synthetic */ Bundle Qa;

        protected void m4510a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3374a((C0180d) this, this.PZ, this.Qa);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.7 */
    class C13787 extends InboxCountImpl {
        protected void m4512a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3438j(this);
        }
    }

    public void clear(GoogleApiClient apiClient, int notificationTypes) {
        Games.m472c(apiClient).ch(notificationTypes);
    }

    public void clearAll(GoogleApiClient apiClient) {
        clear(apiClient, 31);
    }
}
