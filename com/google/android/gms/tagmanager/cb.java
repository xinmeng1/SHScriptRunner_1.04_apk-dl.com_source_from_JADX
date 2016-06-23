package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

class cb extends aj {
    private static final String ID;
    private static final C1109a agu;

    static {
        ID = C0296a.PLATFORM.toString();
        agu = dh.m1733r("Android");
    }

    public cb() {
        super(ID, new String[0]);
    }

    public boolean lh() {
        return true;
    }

    public C1109a m2990w(Map<String, C1109a> map) {
        return agu;
    }
}
