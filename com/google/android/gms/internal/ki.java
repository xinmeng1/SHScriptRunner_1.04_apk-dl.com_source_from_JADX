package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.C0177c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.Plus.C1222a;
import com.google.android.gms.plus.internal.C1165e;

public final class ki implements Account {

    /* renamed from: com.google.android.gms.internal.ki.a */
    private static abstract class C1278a extends C1222a<Status> {
        private C1278a() {
        }

        public /* synthetic */ Result m4259c(Status status) {
            return m4260d(status);
        }

        public Status m4260d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.ki.1 */
    class C14321 extends C1278a {
        final /* synthetic */ ki acd;

        C14321(ki kiVar) {
            this.acd = kiVar;
            super();
        }

        protected void m4659a(C1165e c1165e) {
            c1165e.m3808m(this);
        }
    }

    private static C1165e m2790a(GoogleApiClient googleApiClient, C0177c<C1165e> c0177c) {
        boolean z = true;
        hm.m1230b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        hm.m1226a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        C1165e c1165e = (C1165e) googleApiClient.m145a((C0177c) c0177c);
        if (c1165e == null) {
            z = false;
        }
        hm.m1226a(z, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        return c1165e;
    }

    public void clearDefaultAccount(GoogleApiClient googleApiClient) {
        m2790a(googleApiClient, Plus.yH).clearDefaultAccount();
    }

    public String getAccountName(GoogleApiClient googleApiClient) {
        return m2790a(googleApiClient, Plus.yH).getAccountName();
    }

    public PendingResult<Status> revokeAccessAndDisconnect(GoogleApiClient googleApiClient) {
        return googleApiClient.m147b(new C14321(this));
    }
}
