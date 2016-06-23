package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Locale;
import java.util.Map;

class bc extends aj {
    private static final String ID;

    static {
        ID = C0296a.LANGUAGE.toString();
    }

    public bc() {
        super(ID, new String[0]);
    }

    public boolean lh() {
        return false;
    }

    public C1109a m2963w(Map<String, C1109a> map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return dh.nd();
        }
        String language = locale.getLanguage();
        return language == null ? dh.nd() : dh.m1733r(language.toLowerCase());
    }
}
