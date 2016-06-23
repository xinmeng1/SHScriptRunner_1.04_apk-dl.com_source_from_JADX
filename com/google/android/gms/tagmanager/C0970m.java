package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0300b;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.m */
class C0970m extends aj {
    private static final String ID;
    private static final String VALUE;

    static {
        ID = C0296a.CONSTANT.toString();
        VALUE = C0300b.VALUE.toString();
    }

    public C0970m() {
        super(ID, VALUE);
    }

    public static String lk() {
        return ID;
    }

    public static String ll() {
        return VALUE;
    }

    public boolean lh() {
        return true;
    }

    public C1109a m3028w(Map<String, C1109a> map) {
        return (C1109a) map.get(VALUE);
    }
}
