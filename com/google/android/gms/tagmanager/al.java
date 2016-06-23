package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

class al extends bx {
    private static final String ID;

    static {
        ID = C0296a.GREATER_EQUALS.toString();
    }

    public al() {
        super(ID);
    }

    protected boolean m4088a(dg dgVar, dg dgVar2, Map<String, C1109a> map) {
        return dgVar.m1721a(dgVar2) >= 0;
    }
}
