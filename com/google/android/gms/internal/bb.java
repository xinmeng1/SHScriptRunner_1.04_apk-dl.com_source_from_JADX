package com.google.android.gms.internal;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.cast.Cast;
import java.util.HashMap;
import java.util.Map;

public final class bb {
    public static final bc mT;
    public static final bc mU;
    public static final bc mV;
    public static final bc mW;
    public static final bc mX;
    public static final bc mY;
    public static final bc mZ;
    public static final bc na;
    public static final bc nb;

    /* renamed from: com.google.android.gms.internal.bb.1 */
    static class C07061 implements bc {
        C07061() {
        }

        public void m2471b(ex exVar, Map<String, String> map) {
        }
    }

    /* renamed from: com.google.android.gms.internal.bb.2 */
    static class C07072 implements bc {
        C07072() {
        }

        public void m2472b(ex exVar, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                eu.m1014D("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = exVar.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), Cast.MAX_MESSAGE_LENGTH) != null));
            }
            exVar.m1029a("openableURLs", hashMap);
        }
    }

    /* renamed from: com.google.android.gms.internal.bb.3 */
    static class C07083 implements bc {
        C07083() {
        }

        public void m2473b(ex exVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                eu.m1014D("URL missing from click GMSG.");
                return;
            }
            Uri a;
            Uri parse = Uri.parse(str);
            try {
                C0387k cc = exVar.cc();
                if (cc != null && cc.m1323b(parse)) {
                    a = cc.m1320a(parse, exVar.getContext());
                    new es(exVar.getContext(), exVar.cd().sw, a.toString()).start();
                }
            } catch (C0389l e) {
                eu.m1014D("Unable to append parameter to URL: " + str);
            }
            a = parse;
            new es(exVar.getContext(), exVar.cd().sw, a.toString()).start();
        }
    }

    /* renamed from: com.google.android.gms.internal.bb.4 */
    static class C07094 implements bc {
        C07094() {
        }

        public void m2474b(ex exVar, Map<String, String> map) {
            cf ca = exVar.ca();
            if (ca == null) {
                eu.m1014D("A GMSG tried to close something that wasn't an overlay.");
            } else {
                ca.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bb.5 */
    static class C07105 implements bc {
        C07105() {
        }

        public void m2475b(ex exVar, Map<String, String> map) {
            cf ca = exVar.ca();
            if (ca == null) {
                eu.m1014D("A GMSG tried to use a custom close button on something that wasn't an overlay.");
            } else {
                ca.m3569j("1".equals(map.get("custom_close")));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bb.6 */
    static class C07116 implements bc {
        C07116() {
        }

        public void m2476b(ex exVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                eu.m1014D("URL missing from httpTrack GMSG.");
            } else {
                new es(exVar.getContext(), exVar.cd().sw, str).start();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bb.7 */
    static class C07127 implements bc {
        C07127() {
        }

        public void m2477b(ex exVar, Map<String, String> map) {
            eu.m1012B("Received log message: " + ((String) map.get("string")));
        }
    }

    /* renamed from: com.google.android.gms.internal.bb.8 */
    static class C07138 implements bc {
        C07138() {
        }

        public void m2478b(ex exVar, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                C0387k cc = exVar.cc();
                if (cc != null) {
                    cc.m1324z().m1090a(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                eu.m1014D("Could not parse touch parameters from gmsg.");
            }
        }
    }

    static {
        mT = new C07061();
        mU = new C07072();
        mV = new C07083();
        mW = new C07094();
        mX = new C07105();
        mY = new C07116();
        mZ = new C07127();
        na = new C07138();
        nb = new bh();
    }
}
