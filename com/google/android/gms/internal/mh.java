package com.google.android.gms.internal;

import java.io.IOException;

public final class mh {
    public static final int[] and;
    public static final long[] ane;
    public static final float[] anf;
    public static final double[] ang;
    public static final boolean[] anh;
    public static final String[] ani;
    public static final byte[][] anj;
    public static final byte[] ank;

    static {
        and = new int[0];
        ane = new long[0];
        anf = new float[0];
        ang = new double[0];
        anh = new boolean[0];
        ani = new String[0];
        anj = new byte[0][];
        ank = new byte[0];
    }

    public static final int m1435b(ly lyVar, int i) throws IOException {
        int i2 = 1;
        int position = lyVar.getPosition();
        lyVar.ev(i);
        while (lyVar.nN() > 0 && lyVar.nB() == i) {
            lyVar.ev(i);
            i2++;
        }
        lyVar.ez(position);
        return i2;
    }

    static int eN(int i) {
        return i & 7;
    }

    public static int eO(int i) {
        return i >>> 3;
    }

    static int m1436u(int i, int i2) {
        return (i << 3) | i2;
    }
}
