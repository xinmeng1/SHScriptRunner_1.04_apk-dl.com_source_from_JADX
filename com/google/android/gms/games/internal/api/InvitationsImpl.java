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
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

public final class InvitationsImpl implements Invitations {

    private static abstract class LoadInvitationsImpl extends BaseGamesApiMethodImpl<LoadInvitationsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl.LoadInvitationsImpl.1 */
        class C10671 implements LoadInvitationsResult {
            final /* synthetic */ LoadInvitationsImpl PH;
            final /* synthetic */ Status yJ;

            C10671(LoadInvitationsImpl loadInvitationsImpl, Status status) {
                this.PH = loadInvitationsImpl;
                this.yJ = status;
            }

            public InvitationBuffer getInvitations() {
                return new InvitationBuffer(DataHolder.af(14));
            }

            public Status getStatus() {
                return this.yJ;
            }

            public void release() {
            }
        }

        private LoadInvitationsImpl() {
        }

        public LoadInvitationsResult m4181F(Status status) {
            return new C10671(this, status);
        }

        public /* synthetic */ Result m4182c(Status status) {
            return m4181F(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl.1 */
    class C13631 extends LoadInvitationsImpl {
        final /* synthetic */ int PE;
        final /* synthetic */ InvitationsImpl PF;

        C13631(InvitationsImpl invitationsImpl, int i) {
            this.PF = invitationsImpl;
            this.PE = i;
            super();
        }

        protected void m4478a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3402c((C0180d) this, this.PE);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl.2 */
    class C13642 extends LoadInvitationsImpl {
        final /* synthetic */ int PE;
        final /* synthetic */ String Ph;

        protected void m4480a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3422e(this, this.Ph, this.PE);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl.3 */
    class C13653 extends LoadInvitationsImpl {
        final /* synthetic */ String PG;

        protected void m4482a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3448o(this, this.PG);
        }
    }

    public Intent getInvitationInboxIntent(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hg();
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient) {
        return loadInvitations(apiClient, 0);
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient, int sortOrder) {
        return apiClient.m146a(new C13631(this, sortOrder));
    }

    public void registerInvitationListener(GoogleApiClient apiClient, OnInvitationReceivedListener listener) {
        Games.m472c(apiClient).m3378a(listener);
    }

    public void unregisterInvitationListener(GoogleApiClient apiClient) {
        Games.m472c(apiClient).hh();
    }
}
