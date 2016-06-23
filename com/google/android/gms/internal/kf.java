package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.C0181a.C1029b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.kd.C0805a;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.C1161a;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

public class kf implements PanoramaApi {

    /* renamed from: com.google.android.gms.internal.kf.4 */
    static class C11274 extends C0805a {
        final /* synthetic */ Uri abk;
        final /* synthetic */ kd abn;
        final /* synthetic */ Context qu;

        C11274(Context context, Uri uri, kd kdVar) {
            this.qu = context;
            this.abk = uri;
            this.abn = kdVar;
        }

        public void m3690a(int i, Bundle bundle, int i2, Intent intent) throws RemoteException {
            kf.m2786a(this.qu, this.abk);
            this.abn.m1326a(i, bundle, i2, intent);
        }
    }

    /* renamed from: com.google.android.gms.internal.kf.a */
    private static final class C1128a extends C0805a {
        private final C0180d<C1161a> yR;

        public C1128a(C0180d<C1161a> c0180d) {
            this.yR = c0180d;
        }

        public void m3691a(int i, Bundle bundle, int i2, Intent intent) {
            this.yR.m154a(new kc(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent, i2));
        }
    }

    /* renamed from: com.google.android.gms.internal.kf.c */
    private static final class C1129c extends C0805a {
        private final C0180d<PanoramaResult> yR;

        public C1129c(C0180d<PanoramaResult> c0180d) {
            this.yR = c0180d;
        }

        public void m3692a(int i, Bundle bundle, int i2, Intent intent) {
            this.yR.m154a(new kh(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent));
        }
    }

    /* renamed from: com.google.android.gms.internal.kf.d */
    private static abstract class C1218d<R extends Result> extends C1029b<R, kg> {
        protected C1218d() {
            super(Panorama.yH);
        }

        protected abstract void m4076a(Context context, ke keVar) throws RemoteException;

        protected final void m4078a(kg kgVar) throws RemoteException {
            m4076a(kgVar.getContext(), (ke) kgVar.ft());
        }
    }

    /* renamed from: com.google.android.gms.internal.kf.1 */
    class C12761 extends C1218d<C1161a> {
        final /* synthetic */ Uri abk;
        final /* synthetic */ Bundle abl;

        protected void m4256a(Context context, ke keVar) throws RemoteException {
            kf.m2787a(context, keVar, new C1128a(this), this.abk, this.abl);
        }

        protected C1161a aj(Status status) {
            return new kc(status, null, 0);
        }

        protected /* synthetic */ Result m4257c(Status status) {
            return aj(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.kf.b */
    private static abstract class C1277b extends C1218d<PanoramaResult> {
        private C1277b() {
        }

        protected PanoramaResult ak(Status status) {
            return new kh(status, null);
        }

        protected /* synthetic */ Result m4258c(Status status) {
            return ak(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.kf.2 */
    class C14302 extends C1277b {
        final /* synthetic */ Uri abk;
        final /* synthetic */ kf abm;

        C14302(kf kfVar, Uri uri) {
            this.abm = kfVar;
            this.abk = uri;
            super();
        }

        protected void m4656a(Context context, ke keVar) throws RemoteException {
            keVar.m1327a(new C1129c(this), this.abk, null, false);
        }
    }

    /* renamed from: com.google.android.gms.internal.kf.3 */
    class C14313 extends C1277b {
        final /* synthetic */ Uri abk;
        final /* synthetic */ kf abm;

        C14313(kf kfVar, Uri uri) {
            this.abm = kfVar;
            this.abk = uri;
            super();
        }

        protected void m4657a(Context context, ke keVar) throws RemoteException {
            kf.m2787a(context, keVar, new C1129c(this), this.abk, null);
        }
    }

    private static void m2786a(Context context, Uri uri) {
        context.revokeUriPermission(uri, 1);
    }

    private static void m2787a(Context context, ke keVar, kd kdVar, Uri uri, Bundle bundle) throws RemoteException {
        context.grantUriPermission(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, uri, 1);
        try {
            keVar.m1327a(new C11274(context, uri, kdVar), uri, bundle, true);
        } catch (RemoteException e) {
            m2786a(context, uri);
            throw e;
        } catch (RuntimeException e2) {
            m2786a(context, uri);
            throw e2;
        }
    }

    public PendingResult<PanoramaResult> loadPanoramaInfo(GoogleApiClient client, Uri uri) {
        return client.m146a(new C14302(this, uri));
    }

    public PendingResult<PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient client, Uri uri) {
        return client.m146a(new C14313(this, uri));
    }
}
