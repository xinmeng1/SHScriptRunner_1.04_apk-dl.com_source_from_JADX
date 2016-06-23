package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.c */
class C0953c extends aj {
    private static final String ID;
    private final C0477a aej;

    static {
        ID = C0296a.ADVERTISING_TRACKING_ENABLED.toString();
    }

    public C0953c(Context context) {
        this(C0477a.m1617M(context));
    }

    C0953c(C0477a c0477a) {
        super(ID, new String[0]);
        this.aej = c0477a;
    }

    public boolean lh() {
        return false;
    }

    public C1109a m2973w(Map<String, C1109a> map) {
        return dh.m1733r(Boolean.valueOf(!this.aej.isLimitAdTrackingEnabled()));
    }
}
