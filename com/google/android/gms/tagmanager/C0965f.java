package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.f */
class C0965f extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C0296a.APP_ID.toString();
    }

    public C0965f(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean lh() {
        return true;
    }

    public C1109a m3025w(Map<String, C1109a> map) {
        return dh.m1733r(this.mContext.getPackageName());
    }
}
