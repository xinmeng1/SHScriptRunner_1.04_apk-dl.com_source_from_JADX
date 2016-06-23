package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.x */
class C0827x implements C0408z {
    private ex le;

    public C0827x(ex exVar) {
        this.le = exVar;
    }

    public void m2830a(ac acVar, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        this.le.m1029a("onAdVisibilityChanged", hashMap);
    }
}
