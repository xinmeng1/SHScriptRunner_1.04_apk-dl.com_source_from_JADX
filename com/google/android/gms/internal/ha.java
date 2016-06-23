package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class ha implements SafeParcelable {
    private static final Object FX;
    private static ClassLoader FY;
    private static Integer FZ;
    private boolean Ga;

    static {
        FX = new Object();
        FY = null;
        FZ = null;
    }

    public ha() {
        this.Ga = false;
    }

    private static boolean m2649a(Class<?> cls) {
        boolean z = false;
        try {
            z = SafeParcelable.NULL.equals(cls.getField("NULL").get(null));
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e2) {
        }
        return z;
    }

    protected static boolean aA(String str) {
        ClassLoader fp = fp();
        if (fp == null) {
            return true;
        }
        try {
            return m2649a(fp.loadClass(str));
        } catch (Exception e) {
            return false;
        }
    }

    protected static ClassLoader fp() {
        ClassLoader classLoader;
        synchronized (FX) {
            classLoader = FY;
        }
        return classLoader;
    }

    protected static Integer fq() {
        Integer num;
        synchronized (FX) {
            num = FZ;
        }
        return num;
    }

    protected boolean fr() {
        return this.Ga;
    }
}
