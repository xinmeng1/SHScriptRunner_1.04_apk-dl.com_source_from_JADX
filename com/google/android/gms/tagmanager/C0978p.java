package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.p */
class C0978p extends aj {
    private static final String ID;
    private final String aeU;

    static {
        ID = C0296a.CONTAINER_VERSION.toString();
    }

    public C0978p(String str) {
        super(ID, new String[0]);
        this.aeU = str;
    }

    public boolean lh() {
        return true;
    }

    public C1109a m3040w(Map<String, C1109a> map) {
        return this.aeU == null ? dh.nd() : dh.m1733r(this.aeU);
    }
}
