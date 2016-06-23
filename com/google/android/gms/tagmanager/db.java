package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

class db extends dc {
    private static final String ID;

    static {
        ID = C0296a.STARTS_WITH.toString();
    }

    public db() {
        super(ID);
    }

    protected boolean m4093a(String str, String str2, Map<String, C1109a> map) {
        return str.startsWith(str2);
    }
}
