package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.dynamic.C0283g;
import com.google.android.gms.dynamic.C1057e;
import com.google.android.gms.internal.dd.C0730a;
import com.google.android.gms.internal.de.C0732a;

public final class di extends C0283g<de> {
    private static final di pv;

    /* renamed from: com.google.android.gms.internal.di.a */
    private static final class C0324a extends Exception {
        public C0324a(String str) {
            super(str);
        }
    }

    static {
        pv = new di();
    }

    private di() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    private static boolean m2536b(Activity activity) throws C0324a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        }
        throw new C0324a("InAppPurchaseManager requires the useClientJar flag in intent extras.");
    }

    public static dd m2537d(Activity activity) {
        try {
            if (!m2536b(activity)) {
                return pv.m2538e(activity);
            }
            eu.m1019z("Using AdOverlay from the client jar.");
            return new cu(activity);
        } catch (C0324a e) {
            eu.m1014D(e.getMessage());
            return null;
        }
    }

    private dd m2538e(Activity activity) {
        try {
            return C0730a.m2530r(((de) m469G(activity)).m890b(C1057e.m3260h(activity)));
        } catch (Throwable e) {
            eu.m1017c("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (Throwable e2) {
            eu.m1017c("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    protected /* synthetic */ Object m2539d(IBinder iBinder) {
        return m2540v(iBinder);
    }

    protected de m2540v(IBinder iBinder) {
        return C0732a.m2532s(iBinder);
    }
}
