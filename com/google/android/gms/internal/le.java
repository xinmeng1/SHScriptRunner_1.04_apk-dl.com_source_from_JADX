package com.google.android.gms.internal;

import com.adamioan.scriptrunner.C0127R;
import com.google.android.gms.internal.C0304c.C1104f;
import com.google.android.gms.internal.C0304c.C1108j;
import com.google.android.gms.location.DetectedActivity;
import java.io.IOException;

public interface le {

    /* renamed from: com.google.android.gms.internal.le.a */
    public static final class C1141a extends ma<C1141a> {
        public long aiG;
        public C1108j aiH;
        public C1104f fK;

        public C1141a() {
            nf();
        }

        public static C1141a m3720l(byte[] bArr) throws md {
            return (C1141a) me.m1425a(new C1141a(), bArr);
        }

        public void m3721a(lz lzVar) throws IOException {
            lzVar.m1407b(1, this.aiG);
            if (this.fK != null) {
                lzVar.m1402a(2, this.fK);
            }
            if (this.aiH != null) {
                lzVar.m1402a(3, this.aiH);
            }
            super.m2812a(lzVar);
        }

        public /* synthetic */ me m3722b(ly lyVar) throws IOException {
            return m3724p(lyVar);
        }

        protected int m3723c() {
            int c = super.m2814c() + lz.m1387d(1, this.aiG);
            if (this.fK != null) {
                c += lz.m1381b(2, this.fK);
            }
            return this.aiH != null ? c + lz.m1381b(3, this.aiH) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1141a)) {
                return false;
            }
            C1141a c1141a = (C1141a) o;
            if (this.aiG != c1141a.aiG) {
                return false;
            }
            if (this.fK == null) {
                if (c1141a.fK != null) {
                    return false;
                }
            } else if (!this.fK.equals(c1141a.fK)) {
                return false;
            }
            if (this.aiH == null) {
                if (c1141a.aiH != null) {
                    return false;
                }
            } else if (!this.aiH.equals(c1141a.aiH)) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1141a.amX == null || c1141a.amX.isEmpty();
            } else {
                return this.amX.equals(c1141a.amX);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.aiH == null ? 0 : this.aiH.hashCode()) + (((this.fK == null ? 0 : this.fK.hashCode()) + ((((int) (this.aiG ^ (this.aiG >>> 32))) + 527) * 31)) * 31)) * 31;
            if (!(this.amX == null || this.amX.isEmpty())) {
                i = this.amX.hashCode();
            }
            return hashCode + i;
        }

        public C1141a nf() {
            this.aiG = 0;
            this.fK = null;
            this.aiH = null;
            this.amX = null;
            this.anb = -1;
            return this;
        }

        public C1141a m3724p(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case DetectedActivity.IN_VEHICLE /*0*/:
                        break;
                    case DetectedActivity.RUNNING /*8*/:
                        this.aiG = lyVar.nD();
                        continue;
                    case C0127R.styleable.ActionBar_itemPadding /*18*/:
                        if (this.fK == null) {
                            this.fK = new C1104f();
                        }
                        lyVar.m1372a(this.fK);
                        continue;
                    case 26:
                        if (this.aiH == null) {
                            this.aiH = new C1108j();
                        }
                        lyVar.m1372a(this.aiH);
                        continue;
                    default:
                        if (!m2813a(lyVar, nB)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }
    }
}
