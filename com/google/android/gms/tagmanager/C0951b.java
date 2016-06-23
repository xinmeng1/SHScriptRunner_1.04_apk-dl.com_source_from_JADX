package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.b */
class C0951b extends aj {
    private static final String ID;
    private final C0477a aej;

    static {
        ID = C0296a.ADVERTISER_ID.toString();
    }

    public C0951b(Context context) {
        this(C0477a.m1617M(context));
    }

    C0951b(C0477a c0477a) {
        super(ID, new String[0]);
        this.aej = c0477a;
    }

    public boolean lh() {
        return false;
    }

    public C1109a m2961w(Map<String, C1109a> map) {
        String ld = this.aej.ld();
        return ld == null ? dh.nd() : dh.m1733r(ld);
    }
}
