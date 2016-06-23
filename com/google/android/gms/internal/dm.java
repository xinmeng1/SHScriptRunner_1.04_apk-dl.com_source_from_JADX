package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.ds.C0334a;

public final class dm {

    /* renamed from: com.google.android.gms.internal.dm.a */
    public interface C0325a {
        void m892a(ef efVar);
    }

    public static em m893a(Context context, C0334a c0334a, C0387k c0387k, ex exVar, bt btVar, C0325a c0325a) {
        em dnVar = new dn(context, c0334a, c0387k, exVar, btVar, c0325a);
        dnVar.start();
        return dnVar;
    }
}
