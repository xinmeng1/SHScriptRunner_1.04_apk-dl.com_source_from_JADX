package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0300b;
import com.google.android.gms.internal.C0323d.C1109a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class az extends aj {
    private static final String ID;
    private static final String afU;
    private static final String afV;
    private static final String afW;
    private static final String afy;

    /* renamed from: com.google.android.gms.tagmanager.az.1 */
    static /* synthetic */ class C04791 {
        static final /* synthetic */ int[] afX;

        static {
            afX = new int[C0480a.values().length];
            try {
                afX[C0480a.URL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                afX[C0480a.BACKSLASH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                afX[C0480a.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.az.a */
    private enum C0480a {
        NONE,
        URL,
        BACKSLASH
    }

    static {
        ID = C0296a.JOINER.toString();
        afy = C0300b.ARG0.toString();
        afU = C0300b.ITEM_SEPARATOR.toString();
        afV = C0300b.KEY_VALUE_SEPARATOR.toString();
        afW = C0300b.ESCAPE.toString();
    }

    public az() {
        super(ID, afy);
    }

    private String m2957a(String str, C0480a c0480a, Set<Character> set) {
        switch (C04791.afX[c0480a.ordinal()]) {
            case DataEvent.TYPE_CHANGED /*1*/:
                try {
                    return dk.cv(str);
                } catch (Throwable e) {
                    bh.m1646b("Joiner: unsupported encoding", e);
                    return str;
                }
            case DataEvent.TYPE_DELETED /*2*/:
                String replace = str.replace("\\", "\\\\");
                String str2 = replace;
                for (Character ch : set) {
                    CharSequence ch2 = ch.toString();
                    str2 = str2.replace(ch2, "\\" + ch2);
                }
                return str2;
            default:
                return str;
        }
    }

    private void m2958a(StringBuilder stringBuilder, String str, C0480a c0480a, Set<Character> set) {
        stringBuilder.append(m2957a(str, c0480a, set));
    }

    private void m2959a(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    public boolean lh() {
        return true;
    }

    public C1109a m2960w(Map<String, C1109a> map) {
        C1109a c1109a = (C1109a) map.get(afy);
        if (c1109a == null) {
            return dh.nd();
        }
        C0480a c0480a;
        Set set;
        C1109a c1109a2 = (C1109a) map.get(afU);
        String j = c1109a2 != null ? dh.m1722j(c1109a2) : "";
        c1109a2 = (C1109a) map.get(afV);
        String j2 = c1109a2 != null ? dh.m1722j(c1109a2) : "=";
        C0480a c0480a2 = C0480a.NONE;
        c1109a2 = (C1109a) map.get(afW);
        if (c1109a2 != null) {
            String j3 = dh.m1722j(c1109a2);
            if (PlusShare.KEY_CALL_TO_ACTION_URL.equals(j3)) {
                c0480a = C0480a.URL;
                set = null;
            } else if ("backslash".equals(j3)) {
                c0480a = C0480a.BACKSLASH;
                set = new HashSet();
                m2959a(set, j);
                m2959a(set, j2);
                set.remove(Character.valueOf('\\'));
            } else {
                bh.m1642A("Joiner: unsupported escape type: " + j3);
                return dh.nd();
            }
        }
        set = null;
        c0480a = c0480a2;
        StringBuilder stringBuilder = new StringBuilder();
        switch (c1109a.type) {
            case DataEvent.TYPE_DELETED /*2*/:
                Object obj = 1;
                C1109a[] c1109aArr = c1109a.fO;
                int length = c1109aArr.length;
                int i = 0;
                while (i < length) {
                    C1109a c1109a3 = c1109aArr[i];
                    if (obj == null) {
                        stringBuilder.append(j);
                    }
                    m2958a(stringBuilder, dh.m1722j(c1109a3), c0480a, set);
                    i++;
                    obj = null;
                }
                break;
            case DetectedActivity.STILL /*3*/:
                for (int i2 = 0; i2 < c1109a.fP.length; i2++) {
                    if (i2 > 0) {
                        stringBuilder.append(j);
                    }
                    String j4 = dh.m1722j(c1109a.fP[i2]);
                    String j5 = dh.m1722j(c1109a.fQ[i2]);
                    m2958a(stringBuilder, j4, c0480a, set);
                    stringBuilder.append(j2);
                    m2958a(stringBuilder, j5, c0480a, set);
                }
                break;
            default:
                m2958a(stringBuilder, dh.m1722j(c1109a), c0480a, set);
                break;
        }
        return dh.m1733r(stringBuilder.toString());
    }
}
