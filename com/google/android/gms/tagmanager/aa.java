package com.google.android.gms.tagmanager;

import android.os.Build;
import android.support.v4.os.EnvironmentCompat;
import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

class aa extends aj {
    private static final String ID;

    static {
        ID = C0296a.DEVICE_NAME.toString();
    }

    public aa() {
        super(ID, new String[0]);
    }

    public boolean lh() {
        return true;
    }

    public C1109a m2939w(Map<String, C1109a> map) {
        String str = Build.MANUFACTURER;
        Object obj = Build.MODEL;
        if (!(obj.startsWith(str) || str.equals(EnvironmentCompat.MEDIA_UNKNOWN))) {
            obj = str + " " + obj;
        }
        return dh.m1733r(obj);
    }
}
