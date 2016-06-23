package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

class dd extends aj {
    private static final String ID;

    static {
        ID = C0296a.TIME.toString();
    }

    public dd() {
        super(ID, new String[0]);
    }

    public boolean lh() {
        return false;
    }

    public C1109a m3021w(Map<String, C1109a> map) {
        return dh.m1733r(Long.valueOf(System.currentTimeMillis()));
    }
}
