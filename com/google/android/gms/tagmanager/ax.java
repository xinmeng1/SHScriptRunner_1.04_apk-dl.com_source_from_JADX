package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0300b;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

class ax extends aj {
    private static final String ID;
    private static final String aek;
    private final Context kO;

    static {
        ID = C0296a.INSTALL_REFERRER.toString();
        aek = C0300b.COMPONENT.toString();
    }

    public ax(Context context) {
        super(ID, new String[0]);
        this.kO = context;
    }

    public boolean lh() {
        return true;
    }

    public C1109a m2956w(Map<String, C1109a> map) {
        String e = ay.m1635e(this.kO, ((C1109a) map.get(aek)) != null ? dh.m1722j((C1109a) map.get(aek)) : null);
        return e != null ? dh.m1733r(e) : dh.nd();
    }
}
