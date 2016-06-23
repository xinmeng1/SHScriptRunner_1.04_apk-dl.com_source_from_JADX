package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.dynamic.C0283g;
import com.google.android.gms.dynamic.C1057e;
import com.google.android.gms.internal.cn.C0722a;
import com.google.android.gms.internal.co.C0724a;

public final class cm extends C0283g<co> {
    private static final cm oS;

    /* renamed from: com.google.android.gms.internal.cm.a */
    private static final class C0320a extends Exception {
        public C0320a(String str) {
            super(str);
        }
    }

    static {
        oS = new cm();
    }

    private cm() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static cn m2510a(Activity activity) {
        try {
            if (!m2511b(activity)) {
                return oS.m2512c(activity);
            }
            eu.m1019z("Using AdOverlay from the client jar.");
            return new cf(activity);
        } catch (C0320a e) {
            eu.m1014D(e.getMessage());
            return null;
        }
    }

    private static boolean m2511b(Activity activity) throws C0320a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        throw new C0320a("Ad overlay requires the useClientJar flag in intent extras.");
    }

    private cn m2512c(Activity activity) {
        try {
            return C0722a.m2516m(((co) m469G(activity)).m866a(C1057e.m3260h(activity)));
        } catch (Throwable e) {
            eu.m1017c("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            eu.m1017c("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    protected /* synthetic */ Object m2513d(IBinder iBinder) {
        return m2514l(iBinder);
    }

    protected co m2514l(IBinder iBinder) {
        return C0724a.m2518n(iBinder);
    }
}
