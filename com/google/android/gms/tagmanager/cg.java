package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0300b;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class cg extends aj {
    private static final String ID;
    private static final String agH;
    private static final String agI;
    private static final String agJ;
    private static final String agK;

    static {
        ID = C0296a.REGEX_GROUP.toString();
        agH = C0300b.ARG0.toString();
        agI = C0300b.ARG1.toString();
        agJ = C0300b.IGNORE_CASE.toString();
        agK = C0300b.GROUP.toString();
    }

    public cg() {
        super(ID, agH, agI);
    }

    public boolean lh() {
        return true;
    }

    public C1109a m2994w(Map<String, C1109a> map) {
        C1109a c1109a = (C1109a) map.get(agH);
        C1109a c1109a2 = (C1109a) map.get(agI);
        if (c1109a == null || c1109a == dh.nd() || c1109a2 == null || c1109a2 == dh.nd()) {
            return dh.nd();
        }
        int i = 64;
        if (dh.m1728n((C1109a) map.get(agJ)).booleanValue()) {
            i = 66;
        }
        C1109a c1109a3 = (C1109a) map.get(agK);
        int intValue;
        if (c1109a3 != null) {
            Long l = dh.m1724l(c1109a3);
            if (l == dh.mY()) {
                return dh.nd();
            }
            intValue = l.intValue();
            if (intValue < 0) {
                return dh.nd();
            }
        }
        intValue = 1;
        try {
            CharSequence j = dh.m1722j(c1109a);
            Object obj = null;
            Matcher matcher = Pattern.compile(dh.m1722j(c1109a2), i).matcher(j);
            if (matcher.find() && matcher.groupCount() >= intValue) {
                obj = matcher.group(intValue);
            }
            return obj == null ? dh.nd() : dh.m1733r(obj);
        } catch (PatternSyntaxException e) {
            return dh.nd();
        }
    }
}
