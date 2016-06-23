package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0300b;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class ch extends dc {
    private static final String ID;
    private static final String agJ;

    static {
        ID = C0296a.REGEX.toString();
        agJ = C0300b.IGNORE_CASE.toString();
    }

    public ch() {
        super(ID);
    }

    protected boolean m4092a(String str, String str2, Map<String, C1109a> map) {
        try {
            return Pattern.compile(str2, dh.m1728n((C1109a) map.get(agJ)).booleanValue() ? 66 : 64).matcher(str).find();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
}
