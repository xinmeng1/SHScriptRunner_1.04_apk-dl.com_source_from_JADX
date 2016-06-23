package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0175a;
import com.google.android.gms.common.api.Api.C0176b;
import com.google.android.gms.common.api.Api.C0177c;
import com.google.android.gms.common.api.C0181a.C1029b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.ja;
import com.google.android.gms.internal.jg;

public class ActivityRecognition {
    public static final Api<NoOptions> API;
    public static ActivityRecognitionApi ActivityRecognitionApi = null;
    public static final String CLIENT_NAME = "activity_recognition";
    private static final C0177c<jg> yH;
    private static final C0176b<jg, NoOptions> yI;

    /* renamed from: com.google.android.gms.location.ActivityRecognition.1 */
    static class C08281 implements C0176b<jg, NoOptions> {
        C08281() {
        }

        public /* synthetic */ C0175a m2831a(Context context, Looper looper, gy gyVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m2832c(context, looper, gyVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public jg m2832c(Context context, Looper looper, gy gyVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new jg(context, looper, connectionCallbacks, onConnectionFailedListener, ActivityRecognition.CLIENT_NAME);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    /* renamed from: com.google.android.gms.location.ActivityRecognition.a */
    public static abstract class C1220a<R extends Result> extends C1029b<R, jg> {
        public C1220a() {
            super(ActivityRecognition.yH);
        }
    }

    static {
        yH = new C0177c();
        yI = new C08281();
        API = new Api(yI, yH, new Scope[0]);
        ActivityRecognitionApi = new ja();
    }

    private ActivityRecognition() {
    }
}
