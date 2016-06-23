package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0300b;
import com.google.android.gms.internal.C0323d.C1109a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class ao extends aj {
    private static final String ID;
    private static final String afA;
    private static final String afE;
    private static final String afy;

    static {
        ID = C0296a.HASH.toString();
        afy = C0300b.ARG0.toString();
        afE = C0300b.ALGORITHM.toString();
        afA = C0300b.INPUT_FORMAT.toString();
    }

    public ao() {
        super(ID, afy);
    }

    private byte[] m2943c(String str, byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        return instance.digest();
    }

    public boolean lh() {
        return true;
    }

    public C1109a m2944w(Map<String, C1109a> map) {
        C1109a c1109a = (C1109a) map.get(afy);
        if (c1109a == null || c1109a == dh.nd()) {
            return dh.nd();
        }
        byte[] bytes;
        String j = dh.m1722j(c1109a);
        c1109a = (C1109a) map.get(afE);
        String j2 = c1109a == null ? "MD5" : dh.m1722j(c1109a);
        c1109a = (C1109a) map.get(afA);
        String j3 = c1109a == null ? "text" : dh.m1722j(c1109a);
        if ("text".equals(j3)) {
            bytes = j.getBytes();
        } else if ("base16".equals(j3)) {
            bytes = C0505j.bE(j);
        } else {
            bh.m1642A("Hash: unknown input format: " + j3);
            return dh.nd();
        }
        try {
            return dh.m1733r(C0505j.m1741d(m2943c(j2, bytes)));
        } catch (NoSuchAlgorithmException e) {
            bh.m1642A("Hash: unknown algorithm: " + j2);
            return dh.nd();
        }
    }
}
