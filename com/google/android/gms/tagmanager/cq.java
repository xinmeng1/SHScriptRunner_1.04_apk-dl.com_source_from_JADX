package com.google.android.gms.tagmanager;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.internal.C0300b;
import com.google.android.gms.internal.C0304c.C1100b;
import com.google.android.gms.internal.C0304c.C1103e;
import com.google.android.gms.internal.C0304c.C1104f;
import com.google.android.gms.internal.C0304c.C1105g;
import com.google.android.gms.internal.C0304c.C1106h;
import com.google.android.gms.internal.C0323d.C1109a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class cq {

    /* renamed from: com.google.android.gms.tagmanager.cq.a */
    public static class C0490a {
        private final Map<String, C1109a> agX;
        private final C1109a agY;

        private C0490a(Map<String, C1109a> map, C1109a c1109a) {
            this.agX = map;
            this.agY = c1109a;
        }

        public static C0491b mn() {
            return new C0491b();
        }

        public void m1669a(String str, C1109a c1109a) {
            this.agX.put(str, c1109a);
        }

        public Map<String, C1109a> mo() {
            return Collections.unmodifiableMap(this.agX);
        }

        public C1109a mp() {
            return this.agY;
        }

        public String toString() {
            return "Properties: " + mo() + " pushAfterEvaluate: " + this.agY;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cq.b */
    public static class C0491b {
        private final Map<String, C1109a> agX;
        private C1109a agY;

        private C0491b() {
            this.agX = new HashMap();
        }

        public C0491b m1670b(String str, C1109a c1109a) {
            this.agX.put(str, c1109a);
            return this;
        }

        public C0491b m1671i(C1109a c1109a) {
            this.agY = c1109a;
            return this;
        }

        public C0490a mq() {
            return new C0490a(this.agY, null);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cq.c */
    public static class C0492c {
        private final String aeU;
        private final List<C0494e> agZ;
        private final Map<String, List<C0490a>> aha;
        private final int ahb;

        private C0492c(List<C0494e> list, Map<String, List<C0490a>> map, String str, int i) {
            this.agZ = Collections.unmodifiableList(list);
            this.aha = Collections.unmodifiableMap(map);
            this.aeU = str;
            this.ahb = i;
        }

        public static C0493d mr() {
            return new C0493d();
        }

        public String getVersion() {
            return this.aeU;
        }

        public List<C0494e> ms() {
            return this.agZ;
        }

        public Map<String, List<C0490a>> mt() {
            return this.aha;
        }

        public String toString() {
            return "Rules: " + ms() + "  Macros: " + this.aha;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cq.d */
    public static class C0493d {
        private String aeU;
        private final List<C0494e> agZ;
        private final Map<String, List<C0490a>> aha;
        private int ahb;

        private C0493d() {
            this.agZ = new ArrayList();
            this.aha = new HashMap();
            this.aeU = "";
            this.ahb = 0;
        }

        public C0493d m1672a(C0490a c0490a) {
            String j = dh.m1722j((C1109a) c0490a.mo().get(C0300b.INSTANCE_NAME.toString()));
            List list = (List) this.aha.get(j);
            if (list == null) {
                list = new ArrayList();
                this.aha.put(j, list);
            }
            list.add(c0490a);
            return this;
        }

        public C0493d m1673a(C0494e c0494e) {
            this.agZ.add(c0494e);
            return this;
        }

        public C0493d ce(String str) {
            this.aeU = str;
            return this;
        }

        public C0493d du(int i) {
            this.ahb = i;
            return this;
        }

        public C0492c mu() {
            return new C0492c(this.aha, this.aeU, this.ahb, null);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cq.e */
    public static class C0494e {
        private final List<C0490a> ahc;
        private final List<C0490a> ahd;
        private final List<C0490a> ahe;
        private final List<C0490a> ahf;
        private final List<C0490a> ahg;
        private final List<C0490a> ahh;
        private final List<String> ahi;
        private final List<String> ahj;
        private final List<String> ahk;
        private final List<String> ahl;

        private C0494e(List<C0490a> list, List<C0490a> list2, List<C0490a> list3, List<C0490a> list4, List<C0490a> list5, List<C0490a> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
            this.ahc = Collections.unmodifiableList(list);
            this.ahd = Collections.unmodifiableList(list2);
            this.ahe = Collections.unmodifiableList(list3);
            this.ahf = Collections.unmodifiableList(list4);
            this.ahg = Collections.unmodifiableList(list5);
            this.ahh = Collections.unmodifiableList(list6);
            this.ahi = Collections.unmodifiableList(list7);
            this.ahj = Collections.unmodifiableList(list8);
            this.ahk = Collections.unmodifiableList(list9);
            this.ahl = Collections.unmodifiableList(list10);
        }

        public static C0495f mv() {
            return new C0495f();
        }

        public List<C0490a> mA() {
            return this.ahg;
        }

        public List<String> mB() {
            return this.ahi;
        }

        public List<String> mC() {
            return this.ahj;
        }

        public List<String> mD() {
            return this.ahk;
        }

        public List<String> mE() {
            return this.ahl;
        }

        public List<C0490a> mF() {
            return this.ahh;
        }

        public List<C0490a> mw() {
            return this.ahc;
        }

        public List<C0490a> mx() {
            return this.ahd;
        }

        public List<C0490a> my() {
            return this.ahe;
        }

        public List<C0490a> mz() {
            return this.ahf;
        }

        public String toString() {
            return "Positive predicates: " + mw() + "  Negative predicates: " + mx() + "  Add tags: " + my() + "  Remove tags: " + mz() + "  Add macros: " + mA() + "  Remove macros: " + mF();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cq.f */
    public static class C0495f {
        private final List<C0490a> ahc;
        private final List<C0490a> ahd;
        private final List<C0490a> ahe;
        private final List<C0490a> ahf;
        private final List<C0490a> ahg;
        private final List<C0490a> ahh;
        private final List<String> ahi;
        private final List<String> ahj;
        private final List<String> ahk;
        private final List<String> ahl;

        private C0495f() {
            this.ahc = new ArrayList();
            this.ahd = new ArrayList();
            this.ahe = new ArrayList();
            this.ahf = new ArrayList();
            this.ahg = new ArrayList();
            this.ahh = new ArrayList();
            this.ahi = new ArrayList();
            this.ahj = new ArrayList();
            this.ahk = new ArrayList();
            this.ahl = new ArrayList();
        }

        public C0495f m1674b(C0490a c0490a) {
            this.ahc.add(c0490a);
            return this;
        }

        public C0495f m1675c(C0490a c0490a) {
            this.ahd.add(c0490a);
            return this;
        }

        public C0495f cf(String str) {
            this.ahk.add(str);
            return this;
        }

        public C0495f cg(String str) {
            this.ahl.add(str);
            return this;
        }

        public C0495f ch(String str) {
            this.ahi.add(str);
            return this;
        }

        public C0495f ci(String str) {
            this.ahj.add(str);
            return this;
        }

        public C0495f m1676d(C0490a c0490a) {
            this.ahe.add(c0490a);
            return this;
        }

        public C0495f m1677e(C0490a c0490a) {
            this.ahf.add(c0490a);
            return this;
        }

        public C0495f m1678f(C0490a c0490a) {
            this.ahg.add(c0490a);
            return this;
        }

        public C0495f m1679g(C0490a c0490a) {
            this.ahh.add(c0490a);
            return this;
        }

        public C0494e mG() {
            return new C0494e(this.ahd, this.ahe, this.ahf, this.ahg, this.ahh, this.ahi, this.ahj, this.ahk, this.ahl, null);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cq.g */
    public static class C0496g extends Exception {
        public C0496g(String str) {
            super(str);
        }
    }

    private static C1109a m1680a(int i, C1104f c1104f, C1109a[] c1109aArr, Set<Integer> set) throws C0496g {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            cd("Value cycle detected.  Current value reference: " + i + "." + "  Previous value references: " + set + ".");
        }
        C1109a c1109a = (C1109a) m1683a(c1104f.eX, i, "values");
        if (c1109aArr[i] != null) {
            return c1109aArr[i];
        }
        C1109a c1109a2 = null;
        set.add(Integer.valueOf(i));
        C1106h h;
        int[] iArr;
        int length;
        int i3;
        int i4;
        switch (c1109a.type) {
            case DataEvent.TYPE_CHANGED /*1*/:
            case DetectedActivity.TILTING /*5*/:
            case Quest.STATE_FAILED /*6*/:
            case DetectedActivity.RUNNING /*8*/:
                c1109a2 = c1109a;
                break;
            case DataEvent.TYPE_DELETED /*2*/:
                h = m1687h(c1109a);
                c1109a2 = m1686g(c1109a);
                c1109a2.fO = new C1109a[h.fz.length];
                iArr = h.fz;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c1109a2.fO[i3] = m1680a(iArr[i2], c1104f, c1109aArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case DetectedActivity.STILL /*3*/:
                c1109a2 = m1686g(c1109a);
                C1106h h2 = m1687h(c1109a);
                if (h2.fA.length != h2.fB.length) {
                    cd("Uneven map keys (" + h2.fA.length + ") and map values (" + h2.fB.length + ")");
                }
                c1109a2.fP = new C1109a[h2.fA.length];
                c1109a2.fQ = new C1109a[h2.fA.length];
                int[] iArr2 = h2.fA;
                int length2 = iArr2.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length2) {
                    int i5 = i4 + 1;
                    c1109a2.fP[i4] = m1680a(iArr2[i3], c1104f, c1109aArr, (Set) set);
                    i3++;
                    i4 = i5;
                }
                iArr = h2.fB;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c1109a2.fQ[i3] = m1680a(iArr[i2], c1104f, c1109aArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case DetectedActivity.UNKNOWN /*4*/:
                c1109a2 = m1686g(c1109a);
                c1109a2.fR = dh.m1722j(m1680a(m1687h(c1109a).fE, c1104f, c1109aArr, (Set) set));
                break;
            case DetectedActivity.WALKING /*7*/:
                c1109a2 = m1686g(c1109a);
                h = m1687h(c1109a);
                c1109a2.fV = new C1109a[h.fD.length];
                iArr = h.fD;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c1109a2.fV[i3] = m1680a(iArr[i2], c1104f, c1109aArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
        }
        if (c1109a2 == null) {
            cd("Invalid value: " + c1109a);
        }
        c1109aArr[i] = c1109a2;
        set.remove(Integer.valueOf(i));
        return c1109a2;
    }

    private static C0490a m1681a(C1100b c1100b, C1104f c1104f, C1109a[] c1109aArr, int i) throws C0496g {
        C0491b mn = C0490a.mn();
        for (int valueOf : c1100b.eH) {
            C1103e c1103e = (C1103e) m1683a(c1104f.eY, Integer.valueOf(valueOf).intValue(), "properties");
            String str = (String) m1683a(c1104f.eW, c1103e.key, "keys");
            C1109a c1109a = (C1109a) m1683a(c1109aArr, c1103e.value, "values");
            if (C0300b.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                mn.m1671i(c1109a);
            } else {
                mn.m1670b(str, c1109a);
            }
        }
        return mn.mq();
    }

    private static C0494e m1682a(C1105g c1105g, List<C0490a> list, List<C0490a> list2, List<C0490a> list3, C1104f c1104f) {
        C0495f mv = C0494e.mv();
        for (int valueOf : c1105g.fn) {
            mv.m1674b((C0490a) list3.get(Integer.valueOf(valueOf).intValue()));
        }
        for (int valueOf2 : c1105g.fo) {
            mv.m1675c((C0490a) list3.get(Integer.valueOf(valueOf2).intValue()));
        }
        for (int valueOf22 : c1105g.fp) {
            mv.m1676d((C0490a) list.get(Integer.valueOf(valueOf22).intValue()));
        }
        for (int valueOf3 : c1105g.fr) {
            mv.cf(c1104f.eX[Integer.valueOf(valueOf3).intValue()].fN);
        }
        for (int valueOf222 : c1105g.fq) {
            mv.m1677e((C0490a) list.get(Integer.valueOf(valueOf222).intValue()));
        }
        for (int valueOf32 : c1105g.fs) {
            mv.cg(c1104f.eX[Integer.valueOf(valueOf32).intValue()].fN);
        }
        for (int valueOf2222 : c1105g.ft) {
            mv.m1678f((C0490a) list2.get(Integer.valueOf(valueOf2222).intValue()));
        }
        for (int valueOf322 : c1105g.fv) {
            mv.ch(c1104f.eX[Integer.valueOf(valueOf322).intValue()].fN);
        }
        for (int valueOf22222 : c1105g.fu) {
            mv.m1679g((C0490a) list2.get(Integer.valueOf(valueOf22222).intValue()));
        }
        for (int valueOf4 : c1105g.fw) {
            mv.ci(c1104f.eX[Integer.valueOf(valueOf4).intValue()].fN);
        }
        return mv.mG();
    }

    private static <T> T m1683a(T[] tArr, int i, String str) throws C0496g {
        if (i < 0 || i >= tArr.length) {
            cd("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    public static C0492c m1684b(C1104f c1104f) throws C0496g {
        int i;
        int i2 = 0;
        C1109a[] c1109aArr = new C1109a[c1104f.eX.length];
        for (i = 0; i < c1104f.eX.length; i++) {
            m1680a(i, c1104f, c1109aArr, new HashSet(0));
        }
        C0493d mr = C0492c.mr();
        List arrayList = new ArrayList();
        for (i = 0; i < c1104f.fa.length; i++) {
            arrayList.add(m1681a(c1104f.fa[i], c1104f, c1109aArr, i));
        }
        List arrayList2 = new ArrayList();
        for (i = 0; i < c1104f.fb.length; i++) {
            arrayList2.add(m1681a(c1104f.fb[i], c1104f, c1109aArr, i));
        }
        List arrayList3 = new ArrayList();
        for (i = 0; i < c1104f.eZ.length; i++) {
            C0490a a = m1681a(c1104f.eZ[i], c1104f, c1109aArr, i);
            mr.m1672a(a);
            arrayList3.add(a);
        }
        C1105g[] c1105gArr = c1104f.fc;
        int length = c1105gArr.length;
        while (i2 < length) {
            mr.m1673a(m1682a(c1105gArr[i2], arrayList, arrayList3, arrayList2, c1104f));
            i2++;
        }
        mr.ce(c1104f.fg);
        mr.du(c1104f.fl);
        return mr.mu();
    }

    public static void m1685b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void cd(String str) throws C0496g {
        bh.m1642A(str);
        throw new C0496g(str);
    }

    public static C1109a m1686g(C1109a c1109a) {
        C1109a c1109a2 = new C1109a();
        c1109a2.type = c1109a.type;
        c1109a2.fW = (int[]) c1109a.fW.clone();
        if (c1109a.fX) {
            c1109a2.fX = c1109a.fX;
        }
        return c1109a2;
    }

    private static C1106h m1687h(C1109a c1109a) throws C0496g {
        if (((C1106h) c1109a.m2811a(C1106h.fx)) == null) {
            cd("Expected a ServingValue and didn't get one. Value is: " + c1109a);
        }
        return (C1106h) c1109a.m2811a(C1106h.fx);
    }
}
