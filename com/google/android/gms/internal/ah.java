package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0283g;
import com.google.android.gms.dynamic.C1057e;
import com.google.android.gms.internal.aq.C0701a;
import com.google.android.gms.internal.ar.C0703a;

public final class ah extends C0283g<ar> {
    private static final ah lR;

    static {
        lR = new ah();
    }

    private ah() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public static aq m2450a(Context context, al alVar, String str, bs bsVar) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            aq b = lR.m2451b(context, alVar, str, bsVar);
            if (b != null) {
                return b;
            }
        }
        eu.m1019z("Using AdManager from the client jar.");
        return new C1146u(context, alVar, str, bsVar, new ev(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, true));
    }

    private aq m2451b(Context context, al alVar, String str, bs bsVar) {
        try {
            return C0701a.m2466f(((ar) m469G(context)).m797a(C1057e.m3260h(context), alVar, str, bsVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE));
        } catch (Throwable e) {
            eu.m1017c("Could not create remote AdManager.", e);
            return null;
        } catch (Throwable e2) {
            eu.m1017c("Could not create remote AdManager.", e2);
            return null;
        }
    }

    protected ar m2452c(IBinder iBinder) {
        return C0703a.m2468g(iBinder);
    }

    protected /* synthetic */ Object m2453d(IBinder iBinder) {
        return m2452c(iBinder);
    }
}
