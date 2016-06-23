package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.g */
class C0966g extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C0296a.APP_NAME.toString();
    }

    public C0966g(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean lh() {
        return true;
    }

    public C1109a m3026w(Map<String, C1109a> map) {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            return dh.m1733r(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
        } catch (Throwable e) {
            bh.m1646b("App name is not found.", e);
            return dh.nd();
        }
    }
}
