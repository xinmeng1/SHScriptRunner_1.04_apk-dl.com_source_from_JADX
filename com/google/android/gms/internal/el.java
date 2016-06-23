package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.math.BigInteger;
import java.util.Locale;

public final class el {
    private static final Object qp;
    private static String se;

    static {
        qp = new Object();
    }

    public static String m966a(Context context, String str, String str2) {
        String str3;
        synchronized (qp) {
            if (se == null && !TextUtils.isEmpty(str)) {
                m967b(context, str, str2);
            }
            str3 = se;
        }
        return str3;
    }

    private static void m967b(Context context, String str, String str2) {
        try {
            ClassLoader classLoader = context.createPackageContext(str2, 3).getClassLoader();
            Class cls = Class.forName("com.google.ads.mediation.MediationAdapter", false, classLoader);
            BigInteger bigInteger = new BigInteger(new byte[1]);
            String[] split = str.split(",");
            BigInteger bigInteger2 = bigInteger;
            for (int i = 0; i < split.length; i++) {
                if (eo.m979a(classLoader, cls, split[i])) {
                    bigInteger2 = bigInteger2.setBit(i);
                }
            }
            se = String.format(Locale.US, "%X", new Object[]{bigInteger2});
        } catch (Throwable th) {
            se = NotificationCompatApi21.CATEGORY_ERROR;
        }
    }

    public static String bP() {
        String str;
        synchronized (qp) {
            str = se;
        }
        return str;
    }
}
