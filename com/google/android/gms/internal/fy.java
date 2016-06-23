package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.C0181a.C1029b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ft.C0758a;
import java.util.List;

public final class fy implements AppIndexApi, ft {

    /* renamed from: com.google.android.gms.internal.fy.a */
    private static abstract class C0763a<T> implements Result {
        protected final T yA;
        private final Status yz;

        public C0763a(Status status, T t) {
            this.yz = status;
            this.yA = t;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    /* renamed from: com.google.android.gms.internal.fy.b */
    static class C1112b extends C0763a<ParcelFileDescriptor> implements C0758a {
        public C1112b(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            super(status, parcelFileDescriptor);
        }
    }

    /* renamed from: com.google.android.gms.internal.fy.c */
    private static abstract class C1204c<T extends Result> extends C1029b<T, fx> {
        public C1204c() {
            super(ff.xI);
        }

        protected abstract void m4058a(fu fuVar) throws RemoteException;

        protected final void m4059a(fx fxVar) throws RemoteException {
            m4058a(fxVar.dR());
        }
    }

    /* renamed from: com.google.android.gms.internal.fy.e */
    private static final class C1205e extends fw<Status> {
        public C1205e(C0180d<Status> c0180d) {
            super(c0180d);
        }

        public void m4060a(Status status) {
            this.yu.m154a(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.fy.1 */
    class C12641 extends C1204c<C0758a> {

        /* renamed from: com.google.android.gms.internal.fy.1.1 */
        class C12031 extends fw<C0758a> {
            final /* synthetic */ C12641 yv;

            C12031(C12641 c12641, C0180d c0180d) {
                this.yv = c12641;
                super(c0180d);
            }

            public void m4056a(Status status, ParcelFileDescriptor parcelFileDescriptor) {
                this.yu.m154a(new C1112b(status, parcelFileDescriptor));
            }
        }

        protected void m4245a(fu fuVar) throws RemoteException {
            fuVar.m1081a(new C12031(this, this));
        }

        public C0758a m4246b(Status status) {
            return new C1112b(status, null);
        }

        public /* synthetic */ Result m4247c(Status status) {
            return m4246b(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.fy.d */
    private static abstract class C1265d<T extends Result> extends C1204c<Status> {
        private C1265d() {
        }

        protected /* synthetic */ Result m4248c(Status status) {
            return m4249d(status);
        }

        protected Status m4249d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.fy.2 */
    class C14172 extends C1265d<Status> {
        final /* synthetic */ String yw;
        final /* synthetic */ fr[] yx;
        final /* synthetic */ fy yy;

        C14172(fy fyVar, String str, fr[] frVarArr) {
            this.yy = fyVar;
            this.yw = str;
            this.yx = frVarArr;
            super();
        }

        protected void m4631a(fu fuVar) throws RemoteException {
            fuVar.m1082a(new C1205e(this), this.yw, this.yx);
        }
    }

    static Uri m2595a(String str, Uri uri) {
        if (!"android-app".equals(uri.getScheme())) {
            throw new IllegalArgumentException("Uri scheme must be android-app: " + uri);
        } else if (str.equals(uri.getHost())) {
            List pathSegments = uri.getPathSegments();
            if (pathSegments.isEmpty() || ((String) pathSegments.get(0)).isEmpty()) {
                throw new IllegalArgumentException("Uri path must exist: " + uri);
            }
            String str2 = (String) pathSegments.get(0);
            Builder builder = new Builder();
            builder.scheme(str2);
            if (pathSegments.size() > 1) {
                builder.authority((String) pathSegments.get(1));
                for (int i = 2; i < pathSegments.size(); i++) {
                    builder.appendPath((String) pathSegments.get(i));
                }
            }
            builder.encodedQuery(uri.getEncodedQuery());
            builder.encodedFragment(uri.getEncodedFragment());
            return builder.build();
        } else {
            throw new IllegalArgumentException("Uri host must match package name: " + uri);
        }
    }

    public PendingResult<Status> m2596a(GoogleApiClient googleApiClient, fr... frVarArr) {
        return googleApiClient.m146a(new C14172(this, ((fx) googleApiClient.m145a(ff.xI)).getContext().getPackageName(), frVarArr));
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Intent viewIntent, String title, Uri webUrl, List<AppIndexingLink> outLinks) {
        return m2596a(apiClient, new fr(((fx) apiClient.m145a(ff.xI)).getContext().getPackageName(), viewIntent, title, webUrl, null, (List) outLinks));
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Uri appIndexingUrl, String title, Uri webUrl, List<AppIndexingLink> outLinks) {
        return view(apiClient, activity, new Intent("android.intent.action.VIEW", m2595a(((fx) apiClient.m145a(ff.xI)).getContext().getPackageName(), appIndexingUrl)), title, webUrl, (List) outLinks);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Intent viewIntent) {
        fr frVar = new fr(fr.m2581a(((fx) apiClient.m145a(ff.xI)).getContext().getPackageName(), viewIntent), System.currentTimeMillis(), 3);
        return m2596a(apiClient, frVar);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Uri appIndexingUrl) {
        return viewEnd(apiClient, activity, new Intent("android.intent.action.VIEW", m2595a(((fx) apiClient.m145a(ff.xI)).getContext().getPackageName(), appIndexingUrl)));
    }
}
