package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.adamioan.scriptrunner.C0127R;
import com.google.ads.AdSize;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.internal.C0323d.C1109a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.c */
public interface C0304c {

    /* renamed from: com.google.android.gms.internal.c.a */
    public static final class C1099a extends ma<C1099a> {
        public int eE;
        public int eF;
        public int level;

        public C1099a() {
            m3506b();
        }

        public C1099a m3504a(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case DetectedActivity.IN_VEHICLE /*0*/:
                        break;
                    case DetectedActivity.RUNNING /*8*/:
                        nB = lyVar.nE();
                        switch (nB) {
                            case DataEvent.TYPE_CHANGED /*1*/:
                            case DataEvent.TYPE_DELETED /*2*/:
                            case DetectedActivity.STILL /*3*/:
                                this.level = nB;
                                break;
                            default:
                                continue;
                        }
                    case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                        this.eE = lyVar.nE();
                        continue;
                    case 24:
                        this.eF = lyVar.nE();
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

        public void m3505a(lz lzVar) throws IOException {
            if (this.level != 1) {
                lzVar.m1414p(1, this.level);
            }
            if (this.eE != 0) {
                lzVar.m1414p(2, this.eE);
            }
            if (this.eF != 0) {
                lzVar.m1414p(3, this.eF);
            }
            super.m2812a(lzVar);
        }

        public C1099a m3506b() {
            this.level = 1;
            this.eE = 0;
            this.eF = 0;
            this.amX = null;
            this.anb = -1;
            return this;
        }

        public /* synthetic */ me m3507b(ly lyVar) throws IOException {
            return m3504a(lyVar);
        }

        protected int m3508c() {
            int c = super.m2814c();
            if (this.level != 1) {
                c += lz.m1393r(1, this.level);
            }
            if (this.eE != 0) {
                c += lz.m1393r(2, this.eE);
            }
            return this.eF != 0 ? c + lz.m1393r(3, this.eF) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1099a)) {
                return false;
            }
            C1099a c1099a = (C1099a) o;
            if (this.level != c1099a.level || this.eE != c1099a.eE || this.eF != c1099a.eF) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1099a.amX == null || c1099a.amX.isEmpty();
            } else {
                return this.amX.equals(c1099a.amX);
            }
        }

        public int hashCode() {
            int i = (((((this.level + 527) * 31) + this.eE) * 31) + this.eF) * 31;
            int hashCode = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
            return hashCode + i;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.b */
    public static final class C1100b extends ma<C1100b> {
        private static volatile C1100b[] eG;
        public int[] eH;
        public int eI;
        public boolean eJ;
        public boolean eK;
        public int name;

        public C1100b() {
            m3514e();
        }

        public static C1100b[] m3509d() {
            if (eG == null) {
                synchronized (mc.ana) {
                    if (eG == null) {
                        eG = new C1100b[0];
                    }
                }
            }
            return eG;
        }

        public void m3510a(lz lzVar) throws IOException {
            if (this.eK) {
                lzVar.m1403a(1, this.eK);
            }
            lzVar.m1414p(2, this.eI);
            if (this.eH != null && this.eH.length > 0) {
                for (int p : this.eH) {
                    lzVar.m1414p(3, p);
                }
            }
            if (this.name != 0) {
                lzVar.m1414p(4, this.name);
            }
            if (this.eJ) {
                lzVar.m1403a(6, this.eJ);
            }
            super.m2812a(lzVar);
        }

        public /* synthetic */ me m3511b(ly lyVar) throws IOException {
            return m3513c(lyVar);
        }

        protected int m3512c() {
            int i = 0;
            int c = super.m2814c();
            if (this.eK) {
                c += lz.m1382b(1, this.eK);
            }
            int r = lz.m1393r(2, this.eI) + c;
            if (this.eH == null || this.eH.length <= 0) {
                c = r;
            } else {
                for (int eE : this.eH) {
                    i += lz.eE(eE);
                }
                c = (r + i) + (this.eH.length * 1);
            }
            if (this.name != 0) {
                c += lz.m1393r(4, this.name);
            }
            return this.eJ ? c + lz.m1382b(6, this.eJ) : c;
        }

        public C1100b m3513c(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                int b;
                switch (nB) {
                    case DetectedActivity.IN_VEHICLE /*0*/:
                        break;
                    case DetectedActivity.RUNNING /*8*/:
                        this.eK = lyVar.nF();
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                        this.eI = lyVar.nE();
                        continue;
                    case 24:
                        b = mh.m1435b(lyVar, 24);
                        nB = this.eH == null ? 0 : this.eH.length;
                        Object obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eH, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.eH = obj;
                        continue;
                    case 26:
                        int ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.eH == null ? 0 : this.eH.length;
                        Object obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.eH, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.eH = obj2;
                        lyVar.ey(ex);
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_STOP /*32*/:
                        this.name = lyVar.nE();
                        continue;
                    case 48:
                        this.eJ = lyVar.nF();
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

        public C1100b m3514e() {
            this.eH = mh.and;
            this.eI = 0;
            this.name = 0;
            this.eJ = false;
            this.eK = false;
            this.amX = null;
            this.anb = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1100b)) {
                return false;
            }
            C1100b c1100b = (C1100b) o;
            if (!mc.equals(this.eH, c1100b.eH) || this.eI != c1100b.eI || this.name != c1100b.name || this.eJ != c1100b.eJ || this.eK != c1100b.eK) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1100b.amX == null || c1100b.amX.isEmpty();
            } else {
                return this.amX.equals(c1100b.amX);
            }
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.eJ ? 1231 : 1237) + ((((((mc.hashCode(this.eH) + 527) * 31) + this.eI) * 31) + this.name) * 31)) * 31;
            if (!this.eK) {
                i = 1237;
            }
            i = (hashCode + i) * 31;
            hashCode = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
            return hashCode + i;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.c */
    public static final class C1101c extends ma<C1101c> {
        private static volatile C1101c[] eL;
        public String eM;
        public long eN;
        public long eO;
        public boolean eP;
        public long eQ;

        public C1101c() {
            m3520g();
        }

        public static C1101c[] m3515f() {
            if (eL == null) {
                synchronized (mc.ana) {
                    if (eL == null) {
                        eL = new C1101c[0];
                    }
                }
            }
            return eL;
        }

        public void m3516a(lz lzVar) throws IOException {
            if (!this.eM.equals("")) {
                lzVar.m1408b(1, this.eM);
            }
            if (this.eN != 0) {
                lzVar.m1407b(2, this.eN);
            }
            if (this.eO != 2147483647L) {
                lzVar.m1407b(3, this.eO);
            }
            if (this.eP) {
                lzVar.m1403a(4, this.eP);
            }
            if (this.eQ != 0) {
                lzVar.m1407b(5, this.eQ);
            }
            super.m2812a(lzVar);
        }

        public /* synthetic */ me m3517b(ly lyVar) throws IOException {
            return m3519d(lyVar);
        }

        protected int m3518c() {
            int c = super.m2814c();
            if (!this.eM.equals("")) {
                c += lz.m1391h(1, this.eM);
            }
            if (this.eN != 0) {
                c += lz.m1387d(2, this.eN);
            }
            if (this.eO != 2147483647L) {
                c += lz.m1387d(3, this.eO);
            }
            if (this.eP) {
                c += lz.m1382b(4, this.eP);
            }
            return this.eQ != 0 ? c + lz.m1387d(5, this.eQ) : c;
        }

        public C1101c m3519d(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case DetectedActivity.IN_VEHICLE /*0*/:
                        break;
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        this.eM = lyVar.readString();
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                        this.eN = lyVar.nD();
                        continue;
                    case 24:
                        this.eO = lyVar.nD();
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_STOP /*32*/:
                        this.eP = lyVar.nF();
                        continue;
                    case 40:
                        this.eQ = lyVar.nD();
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

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1101c)) {
                return false;
            }
            C1101c c1101c = (C1101c) o;
            if (this.eM == null) {
                if (c1101c.eM != null) {
                    return false;
                }
            } else if (!this.eM.equals(c1101c.eM)) {
                return false;
            }
            if (this.eN != c1101c.eN || this.eO != c1101c.eO || this.eP != c1101c.eP || this.eQ != c1101c.eQ) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1101c.amX == null || c1101c.amX.isEmpty();
            } else {
                return this.amX.equals(c1101c.amX);
            }
        }

        public C1101c m3520g() {
            this.eM = "";
            this.eN = 0;
            this.eO = 2147483647L;
            this.eP = false;
            this.eQ = 0;
            this.amX = null;
            this.anb = -1;
            return this;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.eP ? 1231 : 1237) + (((((((this.eM == null ? 0 : this.eM.hashCode()) + 527) * 31) + ((int) (this.eN ^ (this.eN >>> 32)))) * 31) + ((int) (this.eO ^ (this.eO >>> 32)))) * 31)) * 31) + ((int) (this.eQ ^ (this.eQ >>> 32)))) * 31;
            if (!(this.amX == null || this.amX.isEmpty())) {
                i = this.amX.hashCode();
            }
            return hashCode + i;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.d */
    public static final class C1102d extends ma<C1102d> {
        public C1109a[] eR;
        public C1109a[] eS;
        public C1101c[] eT;

        public C1102d() {
            m3525h();
        }

        public void m3521a(lz lzVar) throws IOException {
            int i = 0;
            if (this.eR != null && this.eR.length > 0) {
                for (me meVar : this.eR) {
                    if (meVar != null) {
                        lzVar.m1402a(1, meVar);
                    }
                }
            }
            if (this.eS != null && this.eS.length > 0) {
                for (me meVar2 : this.eS) {
                    if (meVar2 != null) {
                        lzVar.m1402a(2, meVar2);
                    }
                }
            }
            if (this.eT != null && this.eT.length > 0) {
                while (i < this.eT.length) {
                    me meVar3 = this.eT[i];
                    if (meVar3 != null) {
                        lzVar.m1402a(3, meVar3);
                    }
                    i++;
                }
            }
            super.m2812a(lzVar);
        }

        public /* synthetic */ me m3522b(ly lyVar) throws IOException {
            return m3524e(lyVar);
        }

        protected int m3523c() {
            int i;
            int i2 = 0;
            int c = super.m2814c();
            if (this.eR != null && this.eR.length > 0) {
                i = c;
                for (me meVar : this.eR) {
                    if (meVar != null) {
                        i += lz.m1381b(1, meVar);
                    }
                }
                c = i;
            }
            if (this.eS != null && this.eS.length > 0) {
                i = c;
                for (me meVar2 : this.eS) {
                    if (meVar2 != null) {
                        i += lz.m1381b(2, meVar2);
                    }
                }
                c = i;
            }
            if (this.eT != null && this.eT.length > 0) {
                while (i2 < this.eT.length) {
                    me meVar3 = this.eT[i2];
                    if (meVar3 != null) {
                        c += lz.m1381b(3, meVar3);
                    }
                    i2++;
                }
            }
            return c;
        }

        public C1102d m3524e(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                int b;
                Object obj;
                switch (nB) {
                    case DetectedActivity.IN_VEHICLE /*0*/:
                        break;
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        b = mh.m1435b(lyVar, 10);
                        nB = this.eR == null ? 0 : this.eR.length;
                        obj = new C1109a[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eR, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1109a();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1109a();
                        lyVar.m1372a(obj[nB]);
                        this.eR = obj;
                        continue;
                    case C0127R.styleable.ActionBar_itemPadding /*18*/:
                        b = mh.m1435b(lyVar, 18);
                        nB = this.eS == null ? 0 : this.eS.length;
                        obj = new C1109a[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eS, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1109a();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1109a();
                        lyVar.m1372a(obj[nB]);
                        this.eS = obj;
                        continue;
                    case 26:
                        b = mh.m1435b(lyVar, 26);
                        nB = this.eT == null ? 0 : this.eT.length;
                        obj = new C1101c[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eT, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1101c();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1101c();
                        lyVar.m1372a(obj[nB]);
                        this.eT = obj;
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

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1102d)) {
                return false;
            }
            C1102d c1102d = (C1102d) o;
            if (!mc.equals(this.eR, c1102d.eR) || !mc.equals(this.eS, c1102d.eS) || !mc.equals(this.eT, c1102d.eT)) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1102d.amX == null || c1102d.amX.isEmpty();
            } else {
                return this.amX.equals(c1102d.amX);
            }
        }

        public C1102d m3525h() {
            this.eR = C1109a.m3574r();
            this.eS = C1109a.m3574r();
            this.eT = C1101c.m3515f();
            this.amX = null;
            this.anb = -1;
            return this;
        }

        public int hashCode() {
            int hashCode = (((((mc.hashCode(this.eR) + 527) * 31) + mc.hashCode(this.eS)) * 31) + mc.hashCode(this.eT)) * 31;
            int hashCode2 = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
            return hashCode2 + hashCode;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.e */
    public static final class C1103e extends ma<C1103e> {
        private static volatile C1103e[] eU;
        public int key;
        public int value;

        public C1103e() {
            m3531j();
        }

        public static C1103e[] m3526i() {
            if (eU == null) {
                synchronized (mc.ana) {
                    if (eU == null) {
                        eU = new C1103e[0];
                    }
                }
            }
            return eU;
        }

        public void m3527a(lz lzVar) throws IOException {
            lzVar.m1414p(1, this.key);
            lzVar.m1414p(2, this.value);
            super.m2812a(lzVar);
        }

        public /* synthetic */ me m3528b(ly lyVar) throws IOException {
            return m3530f(lyVar);
        }

        protected int m3529c() {
            return (super.m2814c() + lz.m1393r(1, this.key)) + lz.m1393r(2, this.value);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1103e)) {
                return false;
            }
            C1103e c1103e = (C1103e) o;
            if (this.key != c1103e.key || this.value != c1103e.value) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1103e.amX == null || c1103e.amX.isEmpty();
            } else {
                return this.amX.equals(c1103e.amX);
            }
        }

        public C1103e m3530f(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case DetectedActivity.IN_VEHICLE /*0*/:
                        break;
                    case DetectedActivity.RUNNING /*8*/:
                        this.key = lyVar.nE();
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                        this.value = lyVar.nE();
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

        public int hashCode() {
            int i = (((this.key + 527) * 31) + this.value) * 31;
            int hashCode = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
            return hashCode + i;
        }

        public C1103e m3531j() {
            this.key = 0;
            this.value = 0;
            this.amX = null;
            this.anb = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.f */
    public static final class C1104f extends ma<C1104f> {
        public String[] eV;
        public String[] eW;
        public C1109a[] eX;
        public C1103e[] eY;
        public C1100b[] eZ;
        public C1100b[] fa;
        public C1100b[] fb;
        public C1105g[] fc;
        public String fd;
        public String fe;
        public String ff;
        public String fg;
        public C1099a fh;
        public float fi;
        public boolean fj;
        public String[] fk;
        public int fl;

        public C1104f() {
            m3537k();
        }

        public static C1104f m3532a(byte[] bArr) throws md {
            return (C1104f) me.m1425a(new C1104f(), bArr);
        }

        public void m3533a(lz lzVar) throws IOException {
            int i = 0;
            if (this.eW != null && this.eW.length > 0) {
                for (String str : this.eW) {
                    if (str != null) {
                        lzVar.m1408b(1, str);
                    }
                }
            }
            if (this.eX != null && this.eX.length > 0) {
                for (me meVar : this.eX) {
                    if (meVar != null) {
                        lzVar.m1402a(2, meVar);
                    }
                }
            }
            if (this.eY != null && this.eY.length > 0) {
                for (me meVar2 : this.eY) {
                    if (meVar2 != null) {
                        lzVar.m1402a(3, meVar2);
                    }
                }
            }
            if (this.eZ != null && this.eZ.length > 0) {
                for (me meVar22 : this.eZ) {
                    if (meVar22 != null) {
                        lzVar.m1402a(4, meVar22);
                    }
                }
            }
            if (this.fa != null && this.fa.length > 0) {
                for (me meVar222 : this.fa) {
                    if (meVar222 != null) {
                        lzVar.m1402a(5, meVar222);
                    }
                }
            }
            if (this.fb != null && this.fb.length > 0) {
                for (me meVar2222 : this.fb) {
                    if (meVar2222 != null) {
                        lzVar.m1402a(6, meVar2222);
                    }
                }
            }
            if (this.fc != null && this.fc.length > 0) {
                for (me meVar22222 : this.fc) {
                    if (meVar22222 != null) {
                        lzVar.m1402a(7, meVar22222);
                    }
                }
            }
            if (!this.fd.equals("")) {
                lzVar.m1408b(9, this.fd);
            }
            if (!this.fe.equals("")) {
                lzVar.m1408b(10, this.fe);
            }
            if (!this.ff.equals("0")) {
                lzVar.m1408b(12, this.ff);
            }
            if (!this.fg.equals("")) {
                lzVar.m1408b(13, this.fg);
            }
            if (this.fh != null) {
                lzVar.m1402a(14, this.fh);
            }
            if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(0.0f)) {
                lzVar.m1406b(15, this.fi);
            }
            if (this.fk != null && this.fk.length > 0) {
                for (String str2 : this.fk) {
                    if (str2 != null) {
                        lzVar.m1408b(16, str2);
                    }
                }
            }
            if (this.fl != 0) {
                lzVar.m1414p(17, this.fl);
            }
            if (this.fj) {
                lzVar.m1403a(18, this.fj);
            }
            if (this.eV != null && this.eV.length > 0) {
                while (i < this.eV.length) {
                    String str3 = this.eV[i];
                    if (str3 != null) {
                        lzVar.m1408b(19, str3);
                    }
                    i++;
                }
            }
            super.m2812a(lzVar);
        }

        public /* synthetic */ me m3534b(ly lyVar) throws IOException {
            return m3536g(lyVar);
        }

        protected int m3535c() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int c = super.m2814c();
            if (this.eW == null || this.eW.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.eW) {
                    if (str != null) {
                        i3++;
                        i2 += lz.cz(str);
                    }
                }
                i = (c + i2) + (i3 * 1);
            }
            if (this.eX != null && this.eX.length > 0) {
                i2 = i;
                for (me meVar : this.eX) {
                    if (meVar != null) {
                        i2 += lz.m1381b(2, meVar);
                    }
                }
                i = i2;
            }
            if (this.eY != null && this.eY.length > 0) {
                i2 = i;
                for (me meVar2 : this.eY) {
                    if (meVar2 != null) {
                        i2 += lz.m1381b(3, meVar2);
                    }
                }
                i = i2;
            }
            if (this.eZ != null && this.eZ.length > 0) {
                i2 = i;
                for (me meVar22 : this.eZ) {
                    if (meVar22 != null) {
                        i2 += lz.m1381b(4, meVar22);
                    }
                }
                i = i2;
            }
            if (this.fa != null && this.fa.length > 0) {
                i2 = i;
                for (me meVar222 : this.fa) {
                    if (meVar222 != null) {
                        i2 += lz.m1381b(5, meVar222);
                    }
                }
                i = i2;
            }
            if (this.fb != null && this.fb.length > 0) {
                i2 = i;
                for (me meVar2222 : this.fb) {
                    if (meVar2222 != null) {
                        i2 += lz.m1381b(6, meVar2222);
                    }
                }
                i = i2;
            }
            if (this.fc != null && this.fc.length > 0) {
                i2 = i;
                for (me meVar22222 : this.fc) {
                    if (meVar22222 != null) {
                        i2 += lz.m1381b(7, meVar22222);
                    }
                }
                i = i2;
            }
            if (!this.fd.equals("")) {
                i += lz.m1391h(9, this.fd);
            }
            if (!this.fe.equals("")) {
                i += lz.m1391h(10, this.fe);
            }
            if (!this.ff.equals("0")) {
                i += lz.m1391h(12, this.ff);
            }
            if (!this.fg.equals("")) {
                i += lz.m1391h(13, this.fg);
            }
            if (this.fh != null) {
                i += lz.m1381b(14, this.fh);
            }
            if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(0.0f)) {
                i += lz.m1385c(15, this.fi);
            }
            if (this.fk != null && this.fk.length > 0) {
                i3 = 0;
                c = 0;
                for (String str2 : this.fk) {
                    if (str2 != null) {
                        c++;
                        i3 += lz.cz(str2);
                    }
                }
                i = (i + i3) + (c * 2);
            }
            if (this.fl != 0) {
                i += lz.m1393r(17, this.fl);
            }
            if (this.fj) {
                i += lz.m1382b(18, this.fj);
            }
            if (this.eV == null || this.eV.length <= 0) {
                return i;
            }
            i2 = 0;
            i3 = 0;
            while (i4 < this.eV.length) {
                String str3 = this.eV[i4];
                if (str3 != null) {
                    i3++;
                    i2 += lz.cz(str3);
                }
                i4++;
            }
            return (i + i2) + (i3 * 2);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1104f)) {
                return false;
            }
            C1104f c1104f = (C1104f) o;
            if (!mc.equals(this.eV, c1104f.eV) || !mc.equals(this.eW, c1104f.eW) || !mc.equals(this.eX, c1104f.eX) || !mc.equals(this.eY, c1104f.eY) || !mc.equals(this.eZ, c1104f.eZ) || !mc.equals(this.fa, c1104f.fa) || !mc.equals(this.fb, c1104f.fb) || !mc.equals(this.fc, c1104f.fc)) {
                return false;
            }
            if (this.fd == null) {
                if (c1104f.fd != null) {
                    return false;
                }
            } else if (!this.fd.equals(c1104f.fd)) {
                return false;
            }
            if (this.fe == null) {
                if (c1104f.fe != null) {
                    return false;
                }
            } else if (!this.fe.equals(c1104f.fe)) {
                return false;
            }
            if (this.ff == null) {
                if (c1104f.ff != null) {
                    return false;
                }
            } else if (!this.ff.equals(c1104f.ff)) {
                return false;
            }
            if (this.fg == null) {
                if (c1104f.fg != null) {
                    return false;
                }
            } else if (!this.fg.equals(c1104f.fg)) {
                return false;
            }
            if (this.fh == null) {
                if (c1104f.fh != null) {
                    return false;
                }
            } else if (!this.fh.equals(c1104f.fh)) {
                return false;
            }
            if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(c1104f.fi) || this.fj != c1104f.fj || !mc.equals(this.fk, c1104f.fk) || this.fl != c1104f.fl) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1104f.amX == null || c1104f.amX.isEmpty();
            } else {
                return this.amX.equals(c1104f.amX);
            }
        }

        public C1104f m3536g(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                int b;
                Object obj;
                switch (nB) {
                    case DetectedActivity.IN_VEHICLE /*0*/:
                        break;
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        b = mh.m1435b(lyVar, 10);
                        nB = this.eW == null ? 0 : this.eW.length;
                        obj = new String[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eW, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.readString();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.readString();
                        this.eW = obj;
                        continue;
                    case C0127R.styleable.ActionBar_itemPadding /*18*/:
                        b = mh.m1435b(lyVar, 18);
                        nB = this.eX == null ? 0 : this.eX.length;
                        obj = new C1109a[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eX, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1109a();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1109a();
                        lyVar.m1372a(obj[nB]);
                        this.eX = obj;
                        continue;
                    case 26:
                        b = mh.m1435b(lyVar, 26);
                        nB = this.eY == null ? 0 : this.eY.length;
                        obj = new C1103e[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eY, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1103e();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1103e();
                        lyVar.m1372a(obj[nB]);
                        this.eY = obj;
                        continue;
                    case 34:
                        b = mh.m1435b(lyVar, 34);
                        nB = this.eZ == null ? 0 : this.eZ.length;
                        obj = new C1100b[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eZ, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1100b();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1100b();
                        lyVar.m1372a(obj[nB]);
                        this.eZ = obj;
                        continue;
                    case 42:
                        b = mh.m1435b(lyVar, 42);
                        nB = this.fa == null ? 0 : this.fa.length;
                        obj = new C1100b[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fa, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1100b();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1100b();
                        lyVar.m1372a(obj[nB]);
                        this.fa = obj;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        b = mh.m1435b(lyVar, 50);
                        nB = this.fb == null ? 0 : this.fb.length;
                        obj = new C1100b[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fb, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1100b();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1100b();
                        lyVar.m1372a(obj[nB]);
                        this.fb = obj;
                        continue;
                    case 58:
                        b = mh.m1435b(lyVar, 58);
                        nB = this.fc == null ? 0 : this.fc.length;
                        obj = new C1105g[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fc, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1105g();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1105g();
                        lyVar.m1372a(obj[nB]);
                        this.fc = obj;
                        continue;
                    case 74:
                        this.fd = lyVar.readString();
                        continue;
                    case 82:
                        this.fe = lyVar.readString();
                        continue;
                    case 98:
                        this.ff = lyVar.readString();
                        continue;
                    case 106:
                        this.fg = lyVar.readString();
                        continue;
                    case 114:
                        if (this.fh == null) {
                            this.fh = new C1099a();
                        }
                        lyVar.m1372a(this.fh);
                        continue;
                    case 125:
                        this.fi = lyVar.readFloat();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        b = mh.m1435b(lyVar, TransportMediator.KEYCODE_MEDIA_RECORD);
                        nB = this.fk == null ? 0 : this.fk.length;
                        obj = new String[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fk, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.readString();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.readString();
                        this.fk = obj;
                        continue;
                    case 136:
                        this.fl = lyVar.nE();
                        continue;
                    case 144:
                        this.fj = lyVar.nF();
                        continue;
                    case 154:
                        b = mh.m1435b(lyVar, 154);
                        nB = this.eV == null ? 0 : this.eV.length;
                        obj = new String[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eV, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.readString();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.readString();
                        this.eV = obj;
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

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((this.fj ? 1231 : 1237) + (((((this.fh == null ? 0 : this.fh.hashCode()) + (((this.fg == null ? 0 : this.fg.hashCode()) + (((this.ff == null ? 0 : this.ff.hashCode()) + (((this.fe == null ? 0 : this.fe.hashCode()) + (((this.fd == null ? 0 : this.fd.hashCode()) + ((((((((((((((((mc.hashCode(this.eV) + 527) * 31) + mc.hashCode(this.eW)) * 31) + mc.hashCode(this.eX)) * 31) + mc.hashCode(this.eY)) * 31) + mc.hashCode(this.eZ)) * 31) + mc.hashCode(this.fa)) * 31) + mc.hashCode(this.fb)) * 31) + mc.hashCode(this.fc)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + Float.floatToIntBits(this.fi)) * 31)) * 31) + mc.hashCode(this.fk)) * 31) + this.fl) * 31;
            if (!(this.amX == null || this.amX.isEmpty())) {
                i = this.amX.hashCode();
            }
            return hashCode + i;
        }

        public C1104f m3537k() {
            this.eV = mh.ani;
            this.eW = mh.ani;
            this.eX = C1109a.m3574r();
            this.eY = C1103e.m3526i();
            this.eZ = C1100b.m3509d();
            this.fa = C1100b.m3509d();
            this.fb = C1100b.m3509d();
            this.fc = C1105g.m3538l();
            this.fd = "";
            this.fe = "";
            this.ff = "0";
            this.fg = "";
            this.fh = null;
            this.fi = 0.0f;
            this.fj = false;
            this.fk = mh.ani;
            this.fl = 0;
            this.amX = null;
            this.anb = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.g */
    public static final class C1105g extends ma<C1105g> {
        private static volatile C1105g[] fm;
        public int[] fn;
        public int[] fo;
        public int[] fp;
        public int[] fq;
        public int[] fr;
        public int[] fs;
        public int[] ft;
        public int[] fu;
        public int[] fv;
        public int[] fw;

        public C1105g() {
            m3543m();
        }

        public static C1105g[] m3538l() {
            if (fm == null) {
                synchronized (mc.ana) {
                    if (fm == null) {
                        fm = new C1105g[0];
                    }
                }
            }
            return fm;
        }

        public void m3539a(lz lzVar) throws IOException {
            int i = 0;
            if (this.fn != null && this.fn.length > 0) {
                for (int p : this.fn) {
                    lzVar.m1414p(1, p);
                }
            }
            if (this.fo != null && this.fo.length > 0) {
                for (int p2 : this.fo) {
                    lzVar.m1414p(2, p2);
                }
            }
            if (this.fp != null && this.fp.length > 0) {
                for (int p22 : this.fp) {
                    lzVar.m1414p(3, p22);
                }
            }
            if (this.fq != null && this.fq.length > 0) {
                for (int p222 : this.fq) {
                    lzVar.m1414p(4, p222);
                }
            }
            if (this.fr != null && this.fr.length > 0) {
                for (int p2222 : this.fr) {
                    lzVar.m1414p(5, p2222);
                }
            }
            if (this.fs != null && this.fs.length > 0) {
                for (int p22222 : this.fs) {
                    lzVar.m1414p(6, p22222);
                }
            }
            if (this.ft != null && this.ft.length > 0) {
                for (int p222222 : this.ft) {
                    lzVar.m1414p(7, p222222);
                }
            }
            if (this.fu != null && this.fu.length > 0) {
                for (int p2222222 : this.fu) {
                    lzVar.m1414p(8, p2222222);
                }
            }
            if (this.fv != null && this.fv.length > 0) {
                for (int p22222222 : this.fv) {
                    lzVar.m1414p(9, p22222222);
                }
            }
            if (this.fw != null && this.fw.length > 0) {
                while (i < this.fw.length) {
                    lzVar.m1414p(10, this.fw[i]);
                    i++;
                }
            }
            super.m2812a(lzVar);
        }

        public /* synthetic */ me m3540b(ly lyVar) throws IOException {
            return m3542h(lyVar);
        }

        protected int m3541c() {
            int i;
            int i2;
            int i3 = 0;
            int c = super.m2814c();
            if (this.fn == null || this.fn.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                for (int eE : this.fn) {
                    i2 += lz.eE(eE);
                }
                i = (c + i2) + (this.fn.length * 1);
            }
            if (this.fo != null && this.fo.length > 0) {
                c = 0;
                for (int eE2 : this.fo) {
                    c += lz.eE(eE2);
                }
                i = (i + c) + (this.fo.length * 1);
            }
            if (this.fp != null && this.fp.length > 0) {
                c = 0;
                for (int eE22 : this.fp) {
                    c += lz.eE(eE22);
                }
                i = (i + c) + (this.fp.length * 1);
            }
            if (this.fq != null && this.fq.length > 0) {
                c = 0;
                for (int eE222 : this.fq) {
                    c += lz.eE(eE222);
                }
                i = (i + c) + (this.fq.length * 1);
            }
            if (this.fr != null && this.fr.length > 0) {
                c = 0;
                for (int eE2222 : this.fr) {
                    c += lz.eE(eE2222);
                }
                i = (i + c) + (this.fr.length * 1);
            }
            if (this.fs != null && this.fs.length > 0) {
                c = 0;
                for (int eE22222 : this.fs) {
                    c += lz.eE(eE22222);
                }
                i = (i + c) + (this.fs.length * 1);
            }
            if (this.ft != null && this.ft.length > 0) {
                c = 0;
                for (int eE222222 : this.ft) {
                    c += lz.eE(eE222222);
                }
                i = (i + c) + (this.ft.length * 1);
            }
            if (this.fu != null && this.fu.length > 0) {
                c = 0;
                for (int eE2222222 : this.fu) {
                    c += lz.eE(eE2222222);
                }
                i = (i + c) + (this.fu.length * 1);
            }
            if (this.fv != null && this.fv.length > 0) {
                c = 0;
                for (int eE22222222 : this.fv) {
                    c += lz.eE(eE22222222);
                }
                i = (i + c) + (this.fv.length * 1);
            }
            if (this.fw == null || this.fw.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i3 < this.fw.length) {
                i2 += lz.eE(this.fw[i3]);
                i3++;
            }
            return (i + i2) + (this.fw.length * 1);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1105g)) {
                return false;
            }
            C1105g c1105g = (C1105g) o;
            if (!mc.equals(this.fn, c1105g.fn) || !mc.equals(this.fo, c1105g.fo) || !mc.equals(this.fp, c1105g.fp) || !mc.equals(this.fq, c1105g.fq) || !mc.equals(this.fr, c1105g.fr) || !mc.equals(this.fs, c1105g.fs) || !mc.equals(this.ft, c1105g.ft) || !mc.equals(this.fu, c1105g.fu) || !mc.equals(this.fv, c1105g.fv) || !mc.equals(this.fw, c1105g.fw)) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1105g.amX == null || c1105g.amX.isEmpty();
            } else {
                return this.amX.equals(c1105g.amX);
            }
        }

        public C1105g m3542h(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                int b;
                Object obj;
                int ex;
                Object obj2;
                switch (nB) {
                    case DetectedActivity.IN_VEHICLE /*0*/:
                        break;
                    case DetectedActivity.RUNNING /*8*/:
                        b = mh.m1435b(lyVar, 8);
                        nB = this.fn == null ? 0 : this.fn.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fn, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fn = obj;
                        continue;
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fn == null ? 0 : this.fn.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fn, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fn = obj2;
                        lyVar.ey(ex);
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                        b = mh.m1435b(lyVar, 16);
                        nB = this.fo == null ? 0 : this.fo.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fo, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fo = obj;
                        continue;
                    case C0127R.styleable.ActionBar_itemPadding /*18*/:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fo == null ? 0 : this.fo.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fo, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fo = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 24:
                        b = mh.m1435b(lyVar, 24);
                        nB = this.fp == null ? 0 : this.fp.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fp, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fp = obj;
                        continue;
                    case 26:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fp == null ? 0 : this.fp.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fp, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fp = obj2;
                        lyVar.ey(ex);
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_STOP /*32*/:
                        b = mh.m1435b(lyVar, 32);
                        nB = this.fq == null ? 0 : this.fq.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fq, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fq = obj;
                        continue;
                    case 34:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fq == null ? 0 : this.fq.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fq, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fq = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 40:
                        b = mh.m1435b(lyVar, 40);
                        nB = this.fr == null ? 0 : this.fr.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fr, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fr = obj;
                        continue;
                    case 42:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fr == null ? 0 : this.fr.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fr, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fr = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 48:
                        b = mh.m1435b(lyVar, 48);
                        nB = this.fs == null ? 0 : this.fs.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fs, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fs = obj;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fs == null ? 0 : this.fs.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fs, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fs = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 56:
                        b = mh.m1435b(lyVar, 56);
                        nB = this.ft == null ? 0 : this.ft.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.ft, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.ft = obj;
                        continue;
                    case 58:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.ft == null ? 0 : this.ft.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.ft, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.ft = obj2;
                        lyVar.ey(ex);
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_FAST_FORWARD /*64*/:
                        b = mh.m1435b(lyVar, 64);
                        nB = this.fu == null ? 0 : this.fu.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fu, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fu = obj;
                        continue;
                    case 66:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fu == null ? 0 : this.fu.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fu, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fu = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 72:
                        b = mh.m1435b(lyVar, 72);
                        nB = this.fv == null ? 0 : this.fv.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fv, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fv = obj;
                        continue;
                    case 74:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fv == null ? 0 : this.fv.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fv, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fv = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 80:
                        b = mh.m1435b(lyVar, 80);
                        nB = this.fw == null ? 0 : this.fw.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fw, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fw = obj;
                        continue;
                    case 82:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fw == null ? 0 : this.fw.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fw, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fw = obj2;
                        lyVar.ey(ex);
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

        public int hashCode() {
            int hashCode = (((((((((((((((((((mc.hashCode(this.fn) + 527) * 31) + mc.hashCode(this.fo)) * 31) + mc.hashCode(this.fp)) * 31) + mc.hashCode(this.fq)) * 31) + mc.hashCode(this.fr)) * 31) + mc.hashCode(this.fs)) * 31) + mc.hashCode(this.ft)) * 31) + mc.hashCode(this.fu)) * 31) + mc.hashCode(this.fv)) * 31) + mc.hashCode(this.fw)) * 31;
            int hashCode2 = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
            return hashCode2 + hashCode;
        }

        public C1105g m3543m() {
            this.fn = mh.and;
            this.fo = mh.and;
            this.fp = mh.and;
            this.fq = mh.and;
            this.fr = mh.and;
            this.fs = mh.and;
            this.ft = mh.and;
            this.fu = mh.and;
            this.fv = mh.and;
            this.fw = mh.and;
            this.amX = null;
            this.anb = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.h */
    public static final class C1106h extends ma<C1106h> {
        public static final mb<C1109a, C1106h> fx;
        private static final C1106h[] fy;
        public int[] fA;
        public int[] fB;
        public int fC;
        public int[] fD;
        public int fE;
        public int fF;
        public int[] fz;

        static {
            fx = mb.m1421a(11, C1106h.class, 810);
            fy = new C1106h[0];
        }

        public C1106h() {
            m3548n();
        }

        public void m3544a(lz lzVar) throws IOException {
            int i = 0;
            if (this.fz != null && this.fz.length > 0) {
                for (int p : this.fz) {
                    lzVar.m1414p(1, p);
                }
            }
            if (this.fA != null && this.fA.length > 0) {
                for (int p2 : this.fA) {
                    lzVar.m1414p(2, p2);
                }
            }
            if (this.fB != null && this.fB.length > 0) {
                for (int p22 : this.fB) {
                    lzVar.m1414p(3, p22);
                }
            }
            if (this.fC != 0) {
                lzVar.m1414p(4, this.fC);
            }
            if (this.fD != null && this.fD.length > 0) {
                while (i < this.fD.length) {
                    lzVar.m1414p(5, this.fD[i]);
                    i++;
                }
            }
            if (this.fE != 0) {
                lzVar.m1414p(6, this.fE);
            }
            if (this.fF != 0) {
                lzVar.m1414p(7, this.fF);
            }
            super.m2812a(lzVar);
        }

        public /* synthetic */ me m3545b(ly lyVar) throws IOException {
            return m3547i(lyVar);
        }

        protected int m3546c() {
            int i;
            int i2;
            int i3 = 0;
            int c = super.m2814c();
            if (this.fz == null || this.fz.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                for (int eE : this.fz) {
                    i2 += lz.eE(eE);
                }
                i = (c + i2) + (this.fz.length * 1);
            }
            if (this.fA != null && this.fA.length > 0) {
                c = 0;
                for (int eE2 : this.fA) {
                    c += lz.eE(eE2);
                }
                i = (i + c) + (this.fA.length * 1);
            }
            if (this.fB != null && this.fB.length > 0) {
                c = 0;
                for (int eE22 : this.fB) {
                    c += lz.eE(eE22);
                }
                i = (i + c) + (this.fB.length * 1);
            }
            if (this.fC != 0) {
                i += lz.m1393r(4, this.fC);
            }
            if (this.fD != null && this.fD.length > 0) {
                i2 = 0;
                while (i3 < this.fD.length) {
                    i2 += lz.eE(this.fD[i3]);
                    i3++;
                }
                i = (i + i2) + (this.fD.length * 1);
            }
            if (this.fE != 0) {
                i += lz.m1393r(6, this.fE);
            }
            return this.fF != 0 ? i + lz.m1393r(7, this.fF) : i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1106h)) {
                return false;
            }
            C1106h c1106h = (C1106h) o;
            if (!mc.equals(this.fz, c1106h.fz) || !mc.equals(this.fA, c1106h.fA) || !mc.equals(this.fB, c1106h.fB) || this.fC != c1106h.fC || !mc.equals(this.fD, c1106h.fD) || this.fE != c1106h.fE || this.fF != c1106h.fF) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1106h.amX == null || c1106h.amX.isEmpty();
            } else {
                return this.amX.equals(c1106h.amX);
            }
        }

        public int hashCode() {
            int hashCode = (((((((((((((mc.hashCode(this.fz) + 527) * 31) + mc.hashCode(this.fA)) * 31) + mc.hashCode(this.fB)) * 31) + this.fC) * 31) + mc.hashCode(this.fD)) * 31) + this.fE) * 31) + this.fF) * 31;
            int hashCode2 = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
            return hashCode2 + hashCode;
        }

        public C1106h m3547i(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                int b;
                Object obj;
                int ex;
                Object obj2;
                switch (nB) {
                    case DetectedActivity.IN_VEHICLE /*0*/:
                        break;
                    case DetectedActivity.RUNNING /*8*/:
                        b = mh.m1435b(lyVar, 8);
                        nB = this.fz == null ? 0 : this.fz.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fz, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fz = obj;
                        continue;
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fz == null ? 0 : this.fz.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fz, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fz = obj2;
                        lyVar.ey(ex);
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                        b = mh.m1435b(lyVar, 16);
                        nB = this.fA == null ? 0 : this.fA.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fA, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fA = obj;
                        continue;
                    case C0127R.styleable.ActionBar_itemPadding /*18*/:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fA == null ? 0 : this.fA.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fA, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fA = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 24:
                        b = mh.m1435b(lyVar, 24);
                        nB = this.fB == null ? 0 : this.fB.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fB, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fB = obj;
                        continue;
                    case 26:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fB == null ? 0 : this.fB.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fB, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fB = obj2;
                        lyVar.ey(ex);
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_STOP /*32*/:
                        this.fC = lyVar.nE();
                        continue;
                    case 40:
                        b = mh.m1435b(lyVar, 40);
                        nB = this.fD == null ? 0 : this.fD.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fD, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fD = obj;
                        continue;
                    case 42:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fD == null ? 0 : this.fD.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fD, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fD = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 48:
                        this.fE = lyVar.nE();
                        continue;
                    case 56:
                        this.fF = lyVar.nE();
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

        public C1106h m3548n() {
            this.fz = mh.and;
            this.fA = mh.and;
            this.fB = mh.and;
            this.fC = 0;
            this.fD = mh.and;
            this.fE = 0;
            this.fF = 0;
            this.amX = null;
            this.anb = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.i */
    public static final class C1107i extends ma<C1107i> {
        private static volatile C1107i[] fG;
        public C1109a fH;
        public C1102d fI;
        public String name;

        public C1107i() {
            m3554p();
        }

        public static C1107i[] m3549o() {
            if (fG == null) {
                synchronized (mc.ana) {
                    if (fG == null) {
                        fG = new C1107i[0];
                    }
                }
            }
            return fG;
        }

        public void m3550a(lz lzVar) throws IOException {
            if (!this.name.equals("")) {
                lzVar.m1408b(1, this.name);
            }
            if (this.fH != null) {
                lzVar.m1402a(2, this.fH);
            }
            if (this.fI != null) {
                lzVar.m1402a(3, this.fI);
            }
            super.m2812a(lzVar);
        }

        public /* synthetic */ me m3551b(ly lyVar) throws IOException {
            return m3553j(lyVar);
        }

        protected int m3552c() {
            int c = super.m2814c();
            if (!this.name.equals("")) {
                c += lz.m1391h(1, this.name);
            }
            if (this.fH != null) {
                c += lz.m1381b(2, this.fH);
            }
            return this.fI != null ? c + lz.m1381b(3, this.fI) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1107i)) {
                return false;
            }
            C1107i c1107i = (C1107i) o;
            if (this.name == null) {
                if (c1107i.name != null) {
                    return false;
                }
            } else if (!this.name.equals(c1107i.name)) {
                return false;
            }
            if (this.fH == null) {
                if (c1107i.fH != null) {
                    return false;
                }
            } else if (!this.fH.equals(c1107i.fH)) {
                return false;
            }
            if (this.fI == null) {
                if (c1107i.fI != null) {
                    return false;
                }
            } else if (!this.fI.equals(c1107i.fI)) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1107i.amX == null || c1107i.amX.isEmpty();
            } else {
                return this.amX.equals(c1107i.amX);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.fI == null ? 0 : this.fI.hashCode()) + (((this.fH == null ? 0 : this.fH.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + 527) * 31)) * 31)) * 31;
            if (!(this.amX == null || this.amX.isEmpty())) {
                i = this.amX.hashCode();
            }
            return hashCode + i;
        }

        public C1107i m3553j(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case DetectedActivity.IN_VEHICLE /*0*/:
                        break;
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        this.name = lyVar.readString();
                        continue;
                    case C0127R.styleable.ActionBar_itemPadding /*18*/:
                        if (this.fH == null) {
                            this.fH = new C1109a();
                        }
                        lyVar.m1372a(this.fH);
                        continue;
                    case 26:
                        if (this.fI == null) {
                            this.fI = new C1102d();
                        }
                        lyVar.m1372a(this.fI);
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

        public C1107i m3554p() {
            this.name = "";
            this.fH = null;
            this.fI = null;
            this.amX = null;
            this.anb = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.j */
    public static final class C1108j extends ma<C1108j> {
        public C1107i[] fJ;
        public C1104f fK;
        public String fL;

        public C1108j() {
            m3560q();
        }

        public static C1108j m3555b(byte[] bArr) throws md {
            return (C1108j) me.m1425a(new C1108j(), bArr);
        }

        public void m3556a(lz lzVar) throws IOException {
            if (this.fJ != null && this.fJ.length > 0) {
                for (me meVar : this.fJ) {
                    if (meVar != null) {
                        lzVar.m1402a(1, meVar);
                    }
                }
            }
            if (this.fK != null) {
                lzVar.m1402a(2, this.fK);
            }
            if (!this.fL.equals("")) {
                lzVar.m1408b(3, this.fL);
            }
            super.m2812a(lzVar);
        }

        public /* synthetic */ me m3557b(ly lyVar) throws IOException {
            return m3559k(lyVar);
        }

        protected int m3558c() {
            int c = super.m2814c();
            if (this.fJ != null && this.fJ.length > 0) {
                for (me meVar : this.fJ) {
                    if (meVar != null) {
                        c += lz.m1381b(1, meVar);
                    }
                }
            }
            if (this.fK != null) {
                c += lz.m1381b(2, this.fK);
            }
            return !this.fL.equals("") ? c + lz.m1391h(3, this.fL) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1108j)) {
                return false;
            }
            C1108j c1108j = (C1108j) o;
            if (!mc.equals(this.fJ, c1108j.fJ)) {
                return false;
            }
            if (this.fK == null) {
                if (c1108j.fK != null) {
                    return false;
                }
            } else if (!this.fK.equals(c1108j.fK)) {
                return false;
            }
            if (this.fL == null) {
                if (c1108j.fL != null) {
                    return false;
                }
            } else if (!this.fL.equals(c1108j.fL)) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1108j.amX == null || c1108j.amX.isEmpty();
            } else {
                return this.amX.equals(c1108j.amX);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.fL == null ? 0 : this.fL.hashCode()) + (((this.fK == null ? 0 : this.fK.hashCode()) + ((mc.hashCode(this.fJ) + 527) * 31)) * 31)) * 31;
            if (!(this.amX == null || this.amX.isEmpty())) {
                i = this.amX.hashCode();
            }
            return hashCode + i;
        }

        public C1108j m3559k(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case DetectedActivity.IN_VEHICLE /*0*/:
                        break;
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        int b = mh.m1435b(lyVar, 10);
                        nB = this.fJ == null ? 0 : this.fJ.length;
                        Object obj = new C1107i[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fJ, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1107i();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1107i();
                        lyVar.m1372a(obj[nB]);
                        this.fJ = obj;
                        continue;
                    case C0127R.styleable.ActionBar_itemPadding /*18*/:
                        if (this.fK == null) {
                            this.fK = new C1104f();
                        }
                        lyVar.m1372a(this.fK);
                        continue;
                    case 26:
                        this.fL = lyVar.readString();
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

        public C1108j m3560q() {
            this.fJ = C1107i.m3549o();
            this.fK = null;
            this.fL = "";
            this.amX = null;
            this.anb = -1;
            return this;
        }
    }
}
