package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

abstract class bx extends cc {
    public bx(String str) {
        super(str);
    }

    protected boolean m3811a(C1109a c1109a, C1109a c1109a2, Map<String, C1109a> map) {
        dg k = dh.m1723k(c1109a);
        dg k2 = dh.m1723k(c1109a2);
        return (k == dh.nb() || k2 == dh.nb()) ? false : m3812a(k, k2, (Map) map);
    }

    protected abstract boolean m3812a(dg dgVar, dg dgVar2, Map<String, C1109a> map);
}
