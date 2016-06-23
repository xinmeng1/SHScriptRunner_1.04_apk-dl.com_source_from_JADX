package com.google.android.gms.internal;

import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.Plus.C1222a;
import com.google.android.gms.plus.internal.C1165e;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public final class km implements People {

    /* renamed from: com.google.android.gms.internal.km.a */
    private static abstract class C1282a extends C1222a<LoadPeopleResult> {

        /* renamed from: com.google.android.gms.internal.km.a.1 */
        class C11311 implements LoadPeopleResult {
            final /* synthetic */ C1282a acq;
            final /* synthetic */ Status yJ;

            C11311(C1282a c1282a, Status status) {
                this.acq = c1282a;
                this.yJ = status;
            }

            public String getNextPageToken() {
                return null;
            }

            public PersonBuffer getPersonBuffer() {
                return null;
            }

            public Status getStatus() {
                return this.yJ;
            }

            public void release() {
            }
        }

        private C1282a() {
        }

        public LoadPeopleResult ao(Status status) {
            return new C11311(this, status);
        }

        public /* synthetic */ Result m4266c(Status status) {
            return ao(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.km.1 */
    class C14371 extends C1282a {
        final /* synthetic */ String acf;
        final /* synthetic */ int acm;
        final /* synthetic */ km acn;

        C14371(km kmVar, int i, String str) {
            this.acn = kmVar;
            this.acm = i;
            this.acf = str;
            super();
        }

        protected void m4669a(C1165e c1165e) {
            m1982a(c1165e.m3799a((C0180d) this, this.acm, this.acf));
        }
    }

    /* renamed from: com.google.android.gms.internal.km.2 */
    class C14382 extends C1282a {
        final /* synthetic */ String acf;
        final /* synthetic */ km acn;

        C14382(km kmVar, String str) {
            this.acn = kmVar;
            this.acf = str;
            super();
        }

        protected void m4671a(C1165e c1165e) {
            m1982a(c1165e.m3809r(this, this.acf));
        }
    }

    /* renamed from: com.google.android.gms.internal.km.3 */
    class C14393 extends C1282a {
        final /* synthetic */ km acn;

        C14393(km kmVar) {
            this.acn = kmVar;
            super();
        }

        protected void m4673a(C1165e c1165e) {
            c1165e.m3807l(this);
        }
    }

    /* renamed from: com.google.android.gms.internal.km.4 */
    class C14404 extends C1282a {
        final /* synthetic */ km acn;
        final /* synthetic */ Collection aco;

        C14404(km kmVar, Collection collection) {
            this.acn = kmVar;
            this.aco = collection;
            super();
        }

        protected void m4675a(C1165e c1165e) {
            c1165e.m3803a((C0180d) this, this.aco);
        }
    }

    /* renamed from: com.google.android.gms.internal.km.5 */
    class C14415 extends C1282a {
        final /* synthetic */ km acn;
        final /* synthetic */ String[] acp;

        C14415(km kmVar, String[] strArr) {
            this.acn = kmVar;
            this.acp = strArr;
            super();
        }

        protected void m4677a(C1165e c1165e) {
            c1165e.m3805d(this, this.acp);
        }
    }

    public Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.m1550a(googleApiClient, Plus.yH).getCurrentPerson();
    }

    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, Collection<String> personIds) {
        return googleApiClient.m146a(new C14404(this, personIds));
    }

    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, String... personIds) {
        return googleApiClient.m146a(new C14415(this, personIds));
    }

    public PendingResult<LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.m146a(new C14393(this));
    }

    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, int orderBy, String pageToken) {
        return googleApiClient.m146a(new C14371(this, orderBy, pageToken));
    }

    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, String pageToken) {
        return googleApiClient.m146a(new C14382(this, pageToken));
    }
}
