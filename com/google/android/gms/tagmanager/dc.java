package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

abstract class dc extends cc {
    public dc(String str) {
        super(str);
    }

    protected boolean m3822a(C1109a c1109a, C1109a c1109a2, Map<String, C1109a> map) {
        String j = dh.m1722j(c1109a);
        String j2 = dh.m1722j(c1109a2);
        return (j == dh.nc() || j2 == dh.nc()) ? false : m3823a(j, j2, (Map) map);
    }

    protected abstract boolean m3823a(String str, String str2, Map<String, C1109a> map);
}
