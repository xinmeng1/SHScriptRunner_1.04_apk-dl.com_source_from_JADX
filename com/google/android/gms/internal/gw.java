package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;

public final class gw extends hq<C0371a, Drawable> {

    /* renamed from: com.google.android.gms.internal.gw.a */
    public static final class C0371a {
        public final int FS;
        public final int FT;

        public C0371a(int i, int i2) {
            this.FS = i;
            this.FT = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0371a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0371a c0371a = (C0371a) obj;
            return c0371a.FS == this.FS && c0371a.FT == this.FT;
        }

        public int hashCode() {
            return hk.hashCode(Integer.valueOf(this.FS), Integer.valueOf(this.FT));
        }
    }

    public gw() {
        super(10);
    }
}
