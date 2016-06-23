package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

class bk extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C0296a.MOBILE_ADWORDS_UNIQUE_ID.toString();
    }

    public bk(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    protected String m2965O(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public boolean lh() {
        return true;
    }

    public C1109a m2966w(Map<String, C1109a> map) {
        String O = m2965O(this.mContext);
        return O == null ? dh.nd() : dh.m1733r(O);
    }
}
