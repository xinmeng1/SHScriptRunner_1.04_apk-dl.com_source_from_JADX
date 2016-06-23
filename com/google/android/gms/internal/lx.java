package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

public class lx {
    private final byte[] amK;
    private int amL;
    private int amM;

    public lx(byte[] bArr) {
        int i;
        this.amK = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
        for (i = 0; i < AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY; i++) {
            this.amK[i] = (byte) i;
        }
        i = 0;
        for (int i2 = 0; i2 < AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY; i2++) {
            i = ((i + this.amK[i2]) + bArr[i2 % bArr.length]) & MotionEventCompat.ACTION_MASK;
            byte b = this.amK[i2];
            this.amK[i2] = this.amK[i];
            this.amK[i] = b;
        }
        this.amL = 0;
        this.amM = 0;
    }

    public void m1368o(byte[] bArr) {
        int i = this.amL;
        int i2 = this.amM;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & MotionEventCompat.ACTION_MASK;
            i2 = (i2 + this.amK[i]) & MotionEventCompat.ACTION_MASK;
            byte b = this.amK[i];
            this.amK[i] = this.amK[i2];
            this.amK[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.amK[(this.amK[i] + this.amK[i2]) & MotionEventCompat.ACTION_MASK]);
        }
        this.amL = i;
        this.amM = i2;
    }
}
