package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

class bz extends aj {
    private static final String ID;

    static {
        ID = C0296a.OS_VERSION.toString();
    }

    public bz() {
        super(ID, new String[0]);
    }

    public boolean lh() {
        return true;
    }

    public C1109a m2972w(Map<String, C1109a> map) {
        return dh.m1733r(VERSION.RELEASE);
    }
}
