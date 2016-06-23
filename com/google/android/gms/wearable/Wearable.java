package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.C0176b;
import com.google.android.gms.common.api.Api.C0177c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.gy;
import com.google.android.gms.wearable.internal.C1008e;
import com.google.android.gms.wearable.internal.C1009f;
import com.google.android.gms.wearable.internal.ae;
import com.google.android.gms.wearable.internal.ah;
import com.google.android.gms.wearable.internal.au;

public class Wearable {
    public static final Api<WearableOptions> API;
    public static final DataApi DataApi;
    public static final MessageApi MessageApi;
    public static final NodeApi NodeApi;
    public static final C0565b alp;
    public static final C0177c<au> yH;
    private static final C0176b<au, WearableOptions> yI;

    /* renamed from: com.google.android.gms.wearable.Wearable.1 */
    static class C09991 implements C0176b<au, WearableOptions> {
        C09991() {
        }

        public au m3123a(Context context, Looper looper, gy gyVar, WearableOptions wearableOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (wearableOptions == null) {
                WearableOptions wearableOptions2 = new WearableOptions(null);
            }
            return new au(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public static final class WearableOptions implements Optional {

        public static class Builder {
            public WearableOptions build() {
                return new WearableOptions();
            }
        }

        private WearableOptions(Builder builder) {
        }
    }

    static {
        DataApi = new C1009f();
        MessageApi = new ae();
        NodeApi = new ah();
        alp = new C1008e();
        yH = new C0177c();
        yI = new C09991();
        API = new Api(yI, yH, new Scope[0]);
    }

    private Wearable() {
    }
}
