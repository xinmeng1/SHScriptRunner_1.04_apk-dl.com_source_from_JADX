package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0176b;
import com.google.android.gms.common.api.Api.C0177c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;

public final class ff {
    public static final C0177c<fx> xI;
    private static final C0176b<fx, NoOptions> xJ;
    public static final Api<NoOptions> xK;
    public static final ft xL;

    /* renamed from: com.google.android.gms.internal.ff.1 */
    static class C07571 implements C0176b<fx, NoOptions> {
        C07571() {
        }

        public fx m2579a(Context context, Looper looper, gy gyVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new fx(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    static {
        xI = new C0177c();
        xJ = new C07571();
        xK = new Api(xJ, xI, new Scope[0]);
        xL = new fy();
    }
}
