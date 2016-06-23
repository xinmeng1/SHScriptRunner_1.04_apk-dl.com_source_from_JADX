package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0300b;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

class ce extends aj {
    private static final String ID;
    private static final String agF;
    private static final String agG;

    static {
        ID = C0296a.RANDOM.toString();
        agF = C0300b.MIN.toString();
        agG = C0300b.MAX.toString();
    }

    public ce() {
        super(ID, new String[0]);
    }

    public boolean lh() {
        return false;
    }

    public C1109a m2993w(Map<String, C1109a> map) {
        double doubleValue;
        double d;
        C1109a c1109a = (C1109a) map.get(agF);
        C1109a c1109a2 = (C1109a) map.get(agG);
        if (!(c1109a == null || c1109a == dh.nd() || c1109a2 == null || c1109a2 == dh.nd())) {
            dg k = dh.m1723k(c1109a);
            dg k2 = dh.m1723k(c1109a2);
            if (!(k == dh.nb() || k2 == dh.nb())) {
                double doubleValue2 = k.doubleValue();
                doubleValue = k2.doubleValue();
                if (doubleValue2 <= doubleValue) {
                    d = doubleValue2;
                    return dh.m1733r(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
                }
            }
        }
        doubleValue = 2.147483647E9d;
        d = 0.0d;
        return dh.m1733r(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
    }
}
