package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0300b;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

class ac extends aj {
    private static final String ID;
    private static final String afA;
    private static final String afB;
    private static final String afy;
    private static final String afz;

    static {
        ID = C0296a.ENCODE.toString();
        afy = C0300b.ARG0.toString();
        afz = C0300b.NO_PADDING.toString();
        afA = C0300b.INPUT_FORMAT.toString();
        afB = C0300b.OUTPUT_FORMAT.toString();
    }

    public ac() {
        super(ID, afy);
    }

    public boolean lh() {
        return true;
    }

    public C1109a m2940w(Map<String, C1109a> map) {
        C1109a c1109a = (C1109a) map.get(afy);
        if (c1109a == null || c1109a == dh.nd()) {
            return dh.nd();
        }
        String j = dh.m1722j(c1109a);
        c1109a = (C1109a) map.get(afA);
        String j2 = c1109a == null ? "text" : dh.m1722j(c1109a);
        c1109a = (C1109a) map.get(afB);
        String j3 = c1109a == null ? "base16" : dh.m1722j(c1109a);
        c1109a = (C1109a) map.get(afz);
        int i = (c1109a == null || !dh.m1728n(c1109a).booleanValue()) ? 2 : 3;
        try {
            byte[] bytes;
            Object d;
            if ("text".equals(j2)) {
                bytes = j.getBytes();
            } else if ("base16".equals(j2)) {
                bytes = C0505j.bE(j);
            } else if ("base64".equals(j2)) {
                bytes = Base64.decode(j, i);
            } else if ("base64url".equals(j2)) {
                bytes = Base64.decode(j, i | 8);
            } else {
                bh.m1642A("Encode: unknown input format: " + j2);
                return dh.nd();
            }
            if ("base16".equals(j3)) {
                d = C0505j.m1741d(bytes);
            } else if ("base64".equals(j3)) {
                d = Base64.encodeToString(bytes, i);
            } else if ("base64url".equals(j3)) {
                d = Base64.encodeToString(bytes, i | 8);
            } else {
                bh.m1642A("Encode: unknown output format: " + j3);
                return dh.nd();
            }
            return dh.m1733r(d);
        } catch (IllegalArgumentException e) {
            bh.m1642A("Encode: invalid input:");
            return dh.nd();
        }
    }
}
