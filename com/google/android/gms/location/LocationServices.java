package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0175a;
import com.google.android.gms.common.api.Api.C0176b;
import com.google.android.gms.common.api.Api.C0177c;
import com.google.android.gms.common.api.C0181a.C1029b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.jb;
import com.google.android.gms.internal.jc;
import com.google.android.gms.internal.jg;

public class LocationServices {
    public static final Api<NoOptions> API;
    public static FusedLocationProviderApi FusedLocationApi;
    public static GeofencingApi GeofencingApi;
    private static final C0177c<jg> yH;
    private static final C0176b<jg, NoOptions> yI;

    /* renamed from: com.google.android.gms.location.LocationServices.1 */
    static class C08291 implements C0176b<jg, NoOptions> {
        C08291() {
        }

        public /* synthetic */ C0175a m2835a(Context context, Looper looper, gy gyVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m2836c(context, looper, gyVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public jg m2836c(Context context, Looper looper, gy gyVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new jg(context, looper, connectionCallbacks, onConnectionFailedListener, "locationServices");
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    /* renamed from: com.google.android.gms.location.LocationServices.a */
    public static abstract class C1221a<R extends Result> extends C1029b<R, jg> {
        public C1221a() {
            super(LocationServices.yH);
        }
    }

    static {
        yH = new C0177c();
        yI = new C08291();
        API = new Api(yI, yH, new Scope[0]);
        FusedLocationApi = new jb();
        GeofencingApi = new jc();
    }

    private LocationServices() {
    }

    public static jg m1478e(GoogleApiClient googleApiClient) {
        boolean z = true;
        hm.m1230b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        jg jgVar = (jg) googleApiClient.m145a(yH);
        if (jgVar == null) {
            z = false;
        }
        hm.m1226a(z, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return jgVar;
    }
}
