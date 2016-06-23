package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.dq.C1110a;
import com.google.android.gms.internal.dq.C1111b;

public final class dp {

    /* renamed from: com.google.android.gms.internal.dp.a */
    public interface C0333a {
        void m905a(du duVar);
    }

    public static em m906a(Context context, ds dsVar, C0333a c0333a) {
        return dsVar.kQ.sz ? m907b(context, dsVar, c0333a) : m908c(context, dsVar, c0333a);
    }

    private static em m907b(Context context, ds dsVar, C0333a c0333a) {
        eu.m1019z("Fetching ad response from local ad request service.");
        em c1110a = new C1110a(context, dsVar, c0333a);
        c1110a.start();
        return c1110a;
    }

    private static em m908c(Context context, ds dsVar, C0333a c0333a) {
        eu.m1019z("Fetching ad response from remote ad request service.");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            return new C1111b(context, dsVar, c0333a);
        }
        eu.m1014D("Failed to connect to remote ad request service.");
        return null;
    }
}
