package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0300b;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.e */
class C0964e extends aj {
    private static final String ID;
    private static final String aek;
    private static final String ael;
    private final Context kO;

    static {
        ID = C0296a.ADWORDS_CLICK_REFERRER.toString();
        aek = C0300b.COMPONENT.toString();
        ael = C0300b.CONVERSION_ID.toString();
    }

    public C0964e(Context context) {
        super(ID, ael);
        this.kO = context;
    }

    public boolean lh() {
        return true;
    }

    public C1109a m3024w(Map<String, C1109a> map) {
        C1109a c1109a = (C1109a) map.get(ael);
        if (c1109a == null) {
            return dh.nd();
        }
        String j = dh.m1722j(c1109a);
        c1109a = (C1109a) map.get(aek);
        String d = ay.m1633d(this.kO, j, c1109a != null ? dh.m1722j(c1109a) : null);
        return d != null ? dh.m1733r(d) : dh.nd();
    }
}
