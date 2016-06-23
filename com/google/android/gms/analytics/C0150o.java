package com.google.android.gms.analytics;

/* renamed from: com.google.android.gms.analytics.o */
public final class C0150o {
    private static String m71b(String str, int i) {
        if (i >= 1) {
            return str + i;
        }
        aa.m37A("index out of range for " + str + " (" + i + ")");
        return "";
    }

    static String m72s(int i) {
        return C0150o.m71b("&cd", i);
    }

    static String m73t(int i) {
        return C0150o.m71b("&cm", i);
    }

    public static String m74u(int i) {
        return C0150o.m71b("&pr", i);
    }

    public static String m75v(int i) {
        return C0150o.m71b("&promo", i);
    }

    public static String m76w(int i) {
        return C0150o.m71b("pi", i);
    }

    public static String m77x(int i) {
        return C0150o.m71b("&il", i);
    }

    public static String m78y(int i) {
        return C0150o.m71b("cd", i);
    }

    public static String m79z(int i) {
        return C0150o.m71b("cm", i);
    }
}
