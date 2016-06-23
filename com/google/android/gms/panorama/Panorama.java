package com.google.android.gms.panorama;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0175a;
import com.google.android.gms.common.api.Api.C0176b;
import com.google.android.gms.common.api.Api.C0177c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.kf;
import com.google.android.gms.internal.kg;

public final class Panorama {
    public static final Api<NoOptions> API;
    public static final PanoramaApi PanoramaApi;
    public static final C0177c<kg> yH;
    static final C0176b<kg, NoOptions> yI;

    /* renamed from: com.google.android.gms.panorama.Panorama.1 */
    static class C09231 implements C0176b<kg, NoOptions> {
        C09231() {
        }

        public /* synthetic */ C0175a m2886a(Context context, Looper looper, gy gyVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m2887d(context, looper, gyVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public kg m2887d(Context context, Looper looper, gy gyVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new kg(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    static {
        yH = new C0177c();
        yI = new C09231();
        API = new Api(yI, yH, new Scope[0]);
        PanoramaApi = new kf();
    }

    private Panorama() {
    }
}
