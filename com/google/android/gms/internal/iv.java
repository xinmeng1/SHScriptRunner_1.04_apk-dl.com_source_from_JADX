package com.google.android.gms.internal;

import com.adamioan.scriptrunner.C0127R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.location.DetectedActivity;
import java.io.IOException;

public interface iv {

    /* renamed from: com.google.android.gms.internal.iv.a */
    public static final class C1123a extends ma<C1123a> {
        public C1122a[] Uy;

        /* renamed from: com.google.android.gms.internal.iv.a.a */
        public static final class C1122a extends ma<C1122a> {
            private static volatile C1122a[] Uz;
            public String UA;
            public String UB;
            public int viewId;

            public C1122a() {
                iS();
            }

            public static C1122a[] iR() {
                if (Uz == null) {
                    synchronized (mc.ana) {
                        if (Uz == null) {
                            Uz = new C1122a[0];
                        }
                    }
                }
                return Uz;
            }

            public void m3674a(lz lzVar) throws IOException {
                if (!this.UA.equals("")) {
                    lzVar.m1408b(1, this.UA);
                }
                if (!this.UB.equals("")) {
                    lzVar.m1408b(2, this.UB);
                }
                if (this.viewId != 0) {
                    lzVar.m1414p(3, this.viewId);
                }
                super.m2812a(lzVar);
            }

            public /* synthetic */ me m3675b(ly lyVar) throws IOException {
                return m3677o(lyVar);
            }

            protected int m3676c() {
                int c = super.m2814c();
                if (!this.UA.equals("")) {
                    c += lz.m1391h(1, this.UA);
                }
                if (!this.UB.equals("")) {
                    c += lz.m1391h(2, this.UB);
                }
                return this.viewId != 0 ? c + lz.m1393r(3, this.viewId) : c;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof C1122a)) {
                    return false;
                }
                C1122a c1122a = (C1122a) o;
                if (this.UA == null) {
                    if (c1122a.UA != null) {
                        return false;
                    }
                } else if (!this.UA.equals(c1122a.UA)) {
                    return false;
                }
                if (this.UB == null) {
                    if (c1122a.UB != null) {
                        return false;
                    }
                } else if (!this.UB.equals(c1122a.UB)) {
                    return false;
                }
                if (this.viewId != c1122a.viewId) {
                    return false;
                }
                if (this.amX == null || this.amX.isEmpty()) {
                    return c1122a.amX == null || c1122a.amX.isEmpty();
                } else {
                    return this.amX.equals(c1122a.amX);
                }
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((((this.UB == null ? 0 : this.UB.hashCode()) + (((this.UA == null ? 0 : this.UA.hashCode()) + 527) * 31)) * 31) + this.viewId) * 31;
                if (!(this.amX == null || this.amX.isEmpty())) {
                    i = this.amX.hashCode();
                }
                return hashCode + i;
            }

            public C1122a iS() {
                this.UA = "";
                this.UB = "";
                this.viewId = 0;
                this.amX = null;
                this.anb = -1;
                return this;
            }

            public C1122a m3677o(ly lyVar) throws IOException {
                while (true) {
                    int nB = lyVar.nB();
                    switch (nB) {
                        case DetectedActivity.IN_VEHICLE /*0*/:
                            break;
                        case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                            this.UA = lyVar.readString();
                            continue;
                        case C0127R.styleable.ActionBar_itemPadding /*18*/:
                            this.UB = lyVar.readString();
                            continue;
                        case 24:
                            this.viewId = lyVar.nE();
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

        public C1123a() {
            iQ();
        }

        public void m3678a(lz lzVar) throws IOException {
            if (this.Uy != null && this.Uy.length > 0) {
                for (me meVar : this.Uy) {
                    if (meVar != null) {
                        lzVar.m1402a(1, meVar);
                    }
                }
            }
            super.m2812a(lzVar);
        }

        public /* synthetic */ me m3679b(ly lyVar) throws IOException {
            return m3681n(lyVar);
        }

        protected int m3680c() {
            int c = super.m2814c();
            if (this.Uy != null && this.Uy.length > 0) {
                for (me meVar : this.Uy) {
                    if (meVar != null) {
                        c += lz.m1381b(1, meVar);
                    }
                }
            }
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1123a)) {
                return false;
            }
            C1123a c1123a = (C1123a) o;
            if (!mc.equals(this.Uy, c1123a.Uy)) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1123a.amX == null || c1123a.amX.isEmpty();
            } else {
                return this.amX.equals(c1123a.amX);
            }
        }

        public int hashCode() {
            int hashCode = (mc.hashCode(this.Uy) + 527) * 31;
            int hashCode2 = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
            return hashCode2 + hashCode;
        }

        public C1123a iQ() {
            this.Uy = C1122a.iR();
            this.amX = null;
            this.anb = -1;
            return this;
        }

        public C1123a m3681n(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case DetectedActivity.IN_VEHICLE /*0*/:
                        break;
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        int b = mh.m1435b(lyVar, 10);
                        nB = this.Uy == null ? 0 : this.Uy.length;
                        Object obj = new C1122a[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.Uy, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1122a();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1122a();
                        lyVar.m1372a(obj[nB]);
                        this.Uy = obj;
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
