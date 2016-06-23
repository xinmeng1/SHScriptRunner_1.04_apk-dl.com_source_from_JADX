package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.Plus.C1222a;
import com.google.android.gms.plus.internal.C1165e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public final class kl implements Moments {

    /* renamed from: com.google.android.gms.internal.kl.a */
    private static abstract class C1279a extends C1222a<LoadMomentsResult> {

        /* renamed from: com.google.android.gms.internal.kl.a.1 */
        class C11301 implements LoadMomentsResult {
            final /* synthetic */ C1279a acl;
            final /* synthetic */ Status yJ;

            C11301(C1279a c1279a, Status status) {
                this.acl = c1279a;
                this.yJ = status;
            }

            public MomentBuffer getMomentBuffer() {
                return null;
            }

            public String getNextPageToken() {
                return null;
            }

            public Status getStatus() {
                return this.yJ;
            }

            public String getUpdated() {
                return null;
            }

            public void release() {
            }
        }

        private C1279a() {
        }

        public LoadMomentsResult an(Status status) {
            return new C11301(this, status);
        }

        public /* synthetic */ Result m4261c(Status status) {
            return an(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.kl.b */
    private static abstract class C1280b extends C1222a<Status> {
        private C1280b() {
        }

        public /* synthetic */ Result m4262c(Status status) {
            return m4263d(status);
        }

        public Status m4263d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.kl.c */
    private static abstract class C1281c extends C1222a<Status> {
        private C1281c() {
        }

        public /* synthetic */ Result m4264c(Status status) {
            return m4265d(status);
        }

        public Status m4265d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.kl.1 */
    class C14331 extends C1279a {
        final /* synthetic */ kl ace;

        C14331(kl klVar) {
            this.ace = klVar;
            super();
        }

        protected void m4661a(C1165e c1165e) {
            c1165e.m3806k(this);
        }
    }

    /* renamed from: com.google.android.gms.internal.kl.2 */
    class C14342 extends C1279a {
        final /* synthetic */ int PM;
        final /* synthetic */ kl ace;
        final /* synthetic */ String acf;
        final /* synthetic */ Uri acg;
        final /* synthetic */ String ach;
        final /* synthetic */ String aci;

        C14342(kl klVar, int i, String str, Uri uri, String str2, String str3) {
            this.ace = klVar;
            this.PM = i;
            this.acf = str;
            this.acg = uri;
            this.ach = str2;
            this.aci = str3;
            super();
        }

        protected void m4663a(C1165e c1165e) {
            c1165e.m3801a(this, this.PM, this.acf, this.acg, this.ach, this.aci);
        }
    }

    /* renamed from: com.google.android.gms.internal.kl.3 */
    class C14353 extends C1281c {
        final /* synthetic */ kl ace;
        final /* synthetic */ Moment acj;

        C14353(kl klVar, Moment moment) {
            this.ace = klVar;
            this.acj = moment;
            super();
        }

        protected void m4665a(C1165e c1165e) {
            c1165e.m3802a((C0180d) this, this.acj);
        }
    }

    /* renamed from: com.google.android.gms.internal.kl.4 */
    class C14364 extends C1280b {
        final /* synthetic */ kl ace;
        final /* synthetic */ String ack;

        C14364(kl klVar, String str) {
            this.ace = klVar;
            this.ack = str;
            super();
        }

        protected void m4667a(C1165e c1165e) {
            c1165e.removeMoment(this.ack);
            m1984b(Status.En);
        }
    }

    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient) {
        return googleApiClient.m146a(new C14331(this));
    }

    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        return googleApiClient.m146a(new C14342(this, maxResults, pageToken, targetUrl, type, userId));
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, String momentId) {
        return googleApiClient.m147b(new C14364(this, momentId));
    }

    public PendingResult<Status> write(GoogleApiClient googleApiClient, Moment moment) {
        return googleApiClient.m147b(new C14353(this, moment));
    }
}
