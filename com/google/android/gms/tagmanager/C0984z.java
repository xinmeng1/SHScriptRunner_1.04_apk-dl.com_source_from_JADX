package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.z */
class C0984z extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C0296a.DEVICE_ID.toString();
    }

    public C0984z(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    protected String m3067O(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public boolean lh() {
        return true;
    }

    public C1109a m3068w(Map<String, C1109a> map) {
        String O = m3067O(this.mContext);
        return O == null ? dh.nd() : dh.m1733r(O);
    }
}
