package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.h */
class C0967h extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C0296a.APP_VERSION.toString();
    }

    public C0967h(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean lh() {
        return true;
    }

    public C1109a m3027w(Map<String, C1109a> map) {
        try {
            return dh.m1733r(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
        } catch (NameNotFoundException e) {
            bh.m1642A("Package name " + this.mContext.getPackageName() + " not found. " + e.getMessage());
            return dh.nd();
        }
    }
}
