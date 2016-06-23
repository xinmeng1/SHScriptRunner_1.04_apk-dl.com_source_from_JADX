package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

class cu extends aj {
    private static final String ID;

    static {
        ID = C0296a.SDK_VERSION.toString();
    }

    public cu() {
        super(ID, new String[0]);
    }

    public boolean lh() {
        return true;
    }

    public C1109a m3002w(Map<String, C1109a> map) {
        return dh.m1733r(Integer.valueOf(VERSION.SDK_INT));
    }
}
