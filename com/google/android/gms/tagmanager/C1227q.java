package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.q */
class C1227q extends dc {
    private static final String ID;

    static {
        ID = C0296a.CONTAINS.toString();
    }

    public C1227q() {
        super(ID);
    }

    protected boolean m4094a(String str, String str2, Map<String, C1109a> map) {
        return str.contains(str2);
    }
}
