package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0300b;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

abstract class cc extends aj {
    private static final String afy;
    private static final String agv;

    static {
        afy = C0300b.ARG0.toString();
        agv = C0300b.ARG1.toString();
    }

    public cc(String str) {
        super(str, afy, agv);
    }

    protected abstract boolean m2991a(C1109a c1109a, C1109a c1109a2, Map<String, C1109a> map);

    public boolean lh() {
        return true;
    }

    public C1109a m2992w(Map<String, C1109a> map) {
        for (C1109a c1109a : map.values()) {
            if (c1109a == dh.nd()) {
                return dh.m1733r(Boolean.valueOf(false));
            }
        }
        C1109a c1109a2 = (C1109a) map.get(afy);
        C1109a c1109a3 = (C1109a) map.get(agv);
        boolean a = (c1109a2 == null || c1109a3 == null) ? false : m2991a(c1109a2, c1109a3, map);
        return dh.m1733r(Boolean.valueOf(a));
    }
}
