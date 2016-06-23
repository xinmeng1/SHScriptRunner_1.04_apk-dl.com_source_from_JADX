package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

class ah extends aj {
    private static final String ID;
    private final cs aev;

    static {
        ID = C0296a.EVENT.toString();
    }

    public ah(cs csVar) {
        super(ID, new String[0]);
        this.aev = csVar;
    }

    public boolean lh() {
        return false;
    }

    public C1109a m2941w(Map<String, C1109a> map) {
        String mH = this.aev.mH();
        return mH == null ? dh.nd() : dh.m1733r(mH);
    }
}
