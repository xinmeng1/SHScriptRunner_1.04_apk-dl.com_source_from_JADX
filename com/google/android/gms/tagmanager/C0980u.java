package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0300b;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.u */
class C0980u extends aj {
    private static final String ID;
    private static final String NAME;
    private static final String afi;
    private final DataLayer aeu;

    static {
        ID = C0296a.CUSTOM_VAR.toString();
        NAME = C0300b.NAME.toString();
        afi = C0300b.DEFAULT_VALUE.toString();
    }

    public C0980u(DataLayer dataLayer) {
        super(ID, NAME);
        this.aeu = dataLayer;
    }

    public boolean lh() {
        return false;
    }

    public C1109a m3042w(Map<String, C1109a> map) {
        Object obj = this.aeu.get(dh.m1722j((C1109a) map.get(NAME)));
        if (obj != null) {
            return dh.m1733r(obj);
        }
        C1109a c1109a = (C1109a) map.get(afi);
        return c1109a != null ? c1109a : dh.nd();
    }
}
