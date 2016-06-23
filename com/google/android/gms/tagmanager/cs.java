package com.google.android.gms.tagmanager;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.internal.C0300b;
import com.google.android.gms.internal.C0304c.C1107i;
import com.google.android.gms.internal.C0323d.C1109a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.tagmanager.C0508l.C0507a;
import com.google.android.gms.tagmanager.C0979s.C0513a;
import com.google.android.gms.tagmanager.cq.C0490a;
import com.google.android.gms.tagmanager.cq.C0492c;
import com.google.android.gms.tagmanager.cq.C0494e;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class cs {
    private static final by<C1109a> ahm;
    private final DataLayer aeu;
    private final C0492c ahn;
    private final ag aho;
    private final Map<String, aj> ahp;
    private final Map<String, aj> ahq;
    private final Map<String, aj> ahr;
    private final C0506k<C0490a, by<C1109a>> ahs;
    private final C0506k<String, C0498b> aht;
    private final Set<C0494e> ahu;
    private final Map<String, C0499c> ahv;
    private volatile String ahw;
    private int ahx;

    /* renamed from: com.google.android.gms.tagmanager.cs.a */
    interface C0497a {
        void m1689a(C0494e c0494e, Set<C0490a> set, Set<C0490a> set2, cm cmVar);
    }

    /* renamed from: com.google.android.gms.tagmanager.cs.b */
    private static class C0498b {
        private C1109a agY;
        private by<C1109a> ahD;

        public C0498b(by<C1109a> byVar, C1109a c1109a) {
            this.ahD = byVar;
            this.agY = c1109a;
        }

        public int getSize() {
            return (this.agY == null ? 0 : this.agY.nZ()) + ((C1109a) this.ahD.getObject()).nZ();
        }

        public by<C1109a> mJ() {
            return this.ahD;
        }

        public C1109a mp() {
            return this.agY;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cs.c */
    private static class C0499c {
        private final Map<C0494e, List<C0490a>> ahE;
        private final Map<C0494e, List<C0490a>> ahF;
        private final Map<C0494e, List<String>> ahG;
        private final Map<C0494e, List<String>> ahH;
        private C0490a ahI;
        private final Set<C0494e> ahu;

        public C0499c() {
            this.ahu = new HashSet();
            this.ahE = new HashMap();
            this.ahG = new HashMap();
            this.ahF = new HashMap();
            this.ahH = new HashMap();
        }

        public void m1690a(C0494e c0494e, C0490a c0490a) {
            List list = (List) this.ahE.get(c0494e);
            if (list == null) {
                list = new ArrayList();
                this.ahE.put(c0494e, list);
            }
            list.add(c0490a);
        }

        public void m1691a(C0494e c0494e, String str) {
            List list = (List) this.ahG.get(c0494e);
            if (list == null) {
                list = new ArrayList();
                this.ahG.put(c0494e, list);
            }
            list.add(str);
        }

        public void m1692b(C0494e c0494e) {
            this.ahu.add(c0494e);
        }

        public void m1693b(C0494e c0494e, C0490a c0490a) {
            List list = (List) this.ahF.get(c0494e);
            if (list == null) {
                list = new ArrayList();
                this.ahF.put(c0494e, list);
            }
            list.add(c0490a);
        }

        public void m1694b(C0494e c0494e, String str) {
            List list = (List) this.ahH.get(c0494e);
            if (list == null) {
                list = new ArrayList();
                this.ahH.put(c0494e, list);
            }
            list.add(str);
        }

        public void m1695i(C0490a c0490a) {
            this.ahI = c0490a;
        }

        public Set<C0494e> mK() {
            return this.ahu;
        }

        public Map<C0494e, List<C0490a>> mL() {
            return this.ahE;
        }

        public Map<C0494e, List<String>> mM() {
            return this.ahG;
        }

        public Map<C0494e, List<String>> mN() {
            return this.ahH;
        }

        public Map<C0494e, List<C0490a>> mO() {
            return this.ahF;
        }

        public C0490a mP() {
            return this.ahI;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cs.1 */
    class C09571 implements C0507a<C0490a, by<C1109a>> {
        final /* synthetic */ cs ahy;

        C09571(cs csVar) {
            this.ahy = csVar;
        }

        public int m2997a(C0490a c0490a, by<C1109a> byVar) {
            return ((C1109a) byVar.getObject()).nZ();
        }

        public /* synthetic */ int sizeOf(Object x0, Object x1) {
            return m2997a((C0490a) x0, (by) x1);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cs.2 */
    class C09582 implements C0507a<String, C0498b> {
        final /* synthetic */ cs ahy;

        C09582(cs csVar) {
            this.ahy = csVar;
        }

        public int m2998a(String str, C0498b c0498b) {
            return str.length() + c0498b.getSize();
        }

        public /* synthetic */ int sizeOf(Object x0, Object x1) {
            return m2998a((String) x0, (C0498b) x1);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cs.3 */
    class C09593 implements C0497a {
        final /* synthetic */ Map ahA;
        final /* synthetic */ Map ahB;
        final /* synthetic */ Map ahC;
        final /* synthetic */ cs ahy;
        final /* synthetic */ Map ahz;

        C09593(cs csVar, Map map, Map map2, Map map3, Map map4) {
            this.ahy = csVar;
            this.ahz = map;
            this.ahA = map2;
            this.ahB = map3;
            this.ahC = map4;
        }

        public void m2999a(C0494e c0494e, Set<C0490a> set, Set<C0490a> set2, cm cmVar) {
            List list = (List) this.ahz.get(c0494e);
            List list2 = (List) this.ahA.get(c0494e);
            if (list != null) {
                set.addAll(list);
                cmVar.lU().m1664b(list, list2);
            }
            list = (List) this.ahB.get(c0494e);
            list2 = (List) this.ahC.get(c0494e);
            if (list != null) {
                set2.addAll(list);
                cmVar.lV().m1664b(list, list2);
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cs.4 */
    class C09604 implements C0497a {
        final /* synthetic */ cs ahy;

        C09604(cs csVar) {
            this.ahy = csVar;
        }

        public void m3000a(C0494e c0494e, Set<C0490a> set, Set<C0490a> set2, cm cmVar) {
            set.addAll(c0494e.my());
            set2.addAll(c0494e.mz());
            cmVar.lW().m1664b(c0494e.my(), c0494e.mD());
            cmVar.lX().m1664b(c0494e.mz(), c0494e.mE());
        }
    }

    static {
        ahm = new by(dh.nd(), true);
    }

    public cs(Context context, C0492c c0492c, DataLayer dataLayer, C0513a c0513a, C0513a c0513a2, ag agVar) {
        if (c0492c == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.ahn = c0492c;
        this.ahu = new HashSet(c0492c.ms());
        this.aeu = dataLayer;
        this.aho = agVar;
        this.ahs = new C0508l().m1743a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C09571(this));
        this.aht = new C0508l().m1743a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C09582(this));
        this.ahp = new HashMap();
        m1710b(new C1166i(context));
        m1710b(new C0979s(c0513a2));
        m1710b(new C1169w(dataLayer));
        m1710b(new di(context, dataLayer));
        this.ahq = new HashMap();
        m1711c(new C1227q());
        m1711c(new ad());
        m1711c(new ae());
        m1711c(new al());
        m1711c(new am());
        m1711c(new bd());
        m1711c(new be());
        m1711c(new ch());
        m1711c(new db());
        this.ahr = new HashMap();
        m1709a(new C0951b(context));
        m1709a(new C0953c(context));
        m1709a(new C0964e(context));
        m1709a(new C0965f(context));
        m1709a(new C0966g(context));
        m1709a(new C0967h(context));
        m1709a(new C0970m());
        m1709a(new C0978p(this.ahn.getVersion()));
        m1709a(new C0979s(c0513a));
        m1709a(new C0980u(dataLayer));
        m1709a(new C0984z(context));
        m1709a(new aa());
        m1709a(new ac());
        m1709a(new ah(this));
        m1709a(new an());
        m1709a(new ao());
        m1709a(new ax(context));
        m1709a(new az());
        m1709a(new bc());
        m1709a(new bk(context));
        m1709a(new bz());
        m1709a(new cb());
        m1709a(new ce());
        m1709a(new cg());
        m1709a(new ci(context));
        m1709a(new ct());
        m1709a(new cu());
        m1709a(new dd());
        this.ahv = new HashMap();
        for (C0494e c0494e : this.ahu) {
            if (agVar.lK()) {
                m1701a(c0494e.mA(), c0494e.mB(), "add macro");
                m1701a(c0494e.mF(), c0494e.mC(), "remove macro");
                m1701a(c0494e.my(), c0494e.mD(), "add tag");
                m1701a(c0494e.mz(), c0494e.mE(), "remove tag");
            }
            int i = 0;
            while (i < c0494e.mA().size()) {
                C0490a c0490a = (C0490a) c0494e.mA().get(i);
                String str = "Unknown";
                if (agVar.lK() && i < c0494e.mB().size()) {
                    str = (String) c0494e.mB().get(i);
                }
                C0499c d = m1703d(this.ahv, m1704h(c0490a));
                d.m1692b(c0494e);
                d.m1690a(c0494e, c0490a);
                d.m1691a(c0494e, str);
                i++;
            }
            i = 0;
            while (i < c0494e.mF().size()) {
                c0490a = (C0490a) c0494e.mF().get(i);
                str = "Unknown";
                if (agVar.lK() && i < c0494e.mC().size()) {
                    str = (String) c0494e.mC().get(i);
                }
                d = m1703d(this.ahv, m1704h(c0490a));
                d.m1692b(c0494e);
                d.m1693b(c0494e, c0490a);
                d.m1694b(c0494e, str);
                i++;
            }
        }
        for (Entry entry : this.ahn.mt().entrySet()) {
            for (C0490a c0490a2 : (List) entry.getValue()) {
                if (!dh.m1728n((C1109a) c0490a2.mo().get(C0300b.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    m1703d(this.ahv, (String) entry.getKey()).m1695i(c0490a2);
                }
            }
        }
    }

    private by<C1109a> m1696a(C1109a c1109a, Set<String> set, dj djVar) {
        if (!c1109a.fX) {
            return new by(c1109a, true);
        }
        C1109a g;
        int i;
        by a;
        switch (c1109a.type) {
            case DataEvent.TYPE_DELETED /*2*/:
                g = cq.m1686g(c1109a);
                g.fO = new C1109a[c1109a.fO.length];
                for (i = 0; i < c1109a.fO.length; i++) {
                    a = m1696a(c1109a.fO[i], (Set) set, djVar.dq(i));
                    if (a == ahm) {
                        return ahm;
                    }
                    g.fO[i] = (C1109a) a.getObject();
                }
                return new by(g, false);
            case DetectedActivity.STILL /*3*/:
                g = cq.m1686g(c1109a);
                if (c1109a.fP.length != c1109a.fQ.length) {
                    bh.m1642A("Invalid serving value: " + c1109a.toString());
                    return ahm;
                }
                g.fP = new C1109a[c1109a.fP.length];
                g.fQ = new C1109a[c1109a.fP.length];
                for (i = 0; i < c1109a.fP.length; i++) {
                    a = m1696a(c1109a.fP[i], (Set) set, djVar.dr(i));
                    by a2 = m1696a(c1109a.fQ[i], (Set) set, djVar.ds(i));
                    if (a == ahm || a2 == ahm) {
                        return ahm;
                    }
                    g.fP[i] = (C1109a) a.getObject();
                    g.fQ[i] = (C1109a) a2.getObject();
                }
                return new by(g, false);
            case DetectedActivity.UNKNOWN /*4*/:
                if (set.contains(c1109a.fR)) {
                    bh.m1642A("Macro cycle detected.  Current macro reference: " + c1109a.fR + "." + "  Previous macro references: " + set.toString() + ".");
                    return ahm;
                }
                set.add(c1109a.fR);
                by<C1109a> a3 = dk.m1739a(m1697a(c1109a.fR, (Set) set, djVar.lZ()), c1109a.fW);
                set.remove(c1109a.fR);
                return a3;
            case DetectedActivity.WALKING /*7*/:
                g = cq.m1686g(c1109a);
                g.fV = new C1109a[c1109a.fV.length];
                for (i = 0; i < c1109a.fV.length; i++) {
                    a = m1696a(c1109a.fV[i], (Set) set, djVar.dt(i));
                    if (a == ahm) {
                        return ahm;
                    }
                    g.fV[i] = (C1109a) a.getObject();
                }
                return new by(g, false);
            default:
                bh.m1642A("Unknown type: " + c1109a.type);
                return ahm;
        }
    }

    private by<C1109a> m1697a(String str, Set<String> set, bj bjVar) {
        this.ahx++;
        C0498b c0498b = (C0498b) this.aht.get(str);
        if (c0498b == null || this.aho.lK()) {
            C0499c c0499c = (C0499c) this.ahv.get(str);
            if (c0499c == null) {
                bh.m1642A(mI() + "Invalid macro: " + str);
                this.ahx--;
                return ahm;
            }
            C0490a mP;
            by a = m1707a(str, c0499c.mK(), c0499c.mL(), c0499c.mM(), c0499c.mO(), c0499c.mN(), set, bjVar.lB());
            if (((Set) a.getObject()).isEmpty()) {
                mP = c0499c.mP();
            } else {
                if (((Set) a.getObject()).size() > 1) {
                    bh.m1645D(mI() + "Multiple macros active for macroName " + str);
                }
                mP = (C0490a) ((Set) a.getObject()).iterator().next();
            }
            if (mP == null) {
                this.ahx--;
                return ahm;
            }
            by a2 = m1698a(this.ahr, mP, (Set) set, bjVar.lQ());
            boolean z = a.ma() && a2.ma();
            by<C1109a> byVar = a2 == ahm ? ahm : new by(a2.getObject(), z);
            C1109a mp = mP.mp();
            if (byVar.ma()) {
                this.aht.m1742e(str, new C0498b(byVar, mp));
            }
            m1700a(mp, (Set) set);
            this.ahx--;
            return byVar;
        }
        m1700a(c0498b.mp(), (Set) set);
        this.ahx--;
        return c0498b.mJ();
    }

    private by<C1109a> m1698a(Map<String, aj> map, C0490a c0490a, Set<String> set, cj cjVar) {
        boolean z = true;
        C1109a c1109a = (C1109a) c0490a.mo().get(C0300b.FUNCTION.toString());
        if (c1109a == null) {
            bh.m1642A("No function id in properties");
            return ahm;
        }
        String str = c1109a.fS;
        aj ajVar = (aj) map.get(str);
        if (ajVar == null) {
            bh.m1642A(str + " has no backing implementation.");
            return ahm;
        }
        by<C1109a> byVar = (by) this.ahs.get(c0490a);
        if (byVar != null && !this.aho.lK()) {
            return byVar;
        }
        Map hashMap = new HashMap();
        boolean z2 = true;
        for (Entry entry : c0490a.mo().entrySet()) {
            by a = m1696a((C1109a) entry.getValue(), (Set) set, cjVar.bZ((String) entry.getKey()).m1665e((C1109a) entry.getValue()));
            if (a == ahm) {
                return ahm;
            }
            boolean z3;
            if (a.ma()) {
                c0490a.m1669a((String) entry.getKey(), (C1109a) a.getObject());
                z3 = z2;
            } else {
                z3 = false;
            }
            hashMap.put(entry.getKey(), a.getObject());
            z2 = z3;
        }
        if (ajVar.m1626a(hashMap.keySet())) {
            if (!(z2 && ajVar.lh())) {
                z = false;
            }
            byVar = new by(ajVar.m1627w(hashMap), z);
            if (z) {
                this.ahs.m1742e(c0490a, byVar);
            }
            cjVar.m1663d((C1109a) byVar.getObject());
            return byVar;
        }
        bh.m1642A("Incorrect keys for function " + str + " required " + ajVar.lM() + " had " + hashMap.keySet());
        return ahm;
    }

    private by<Set<C0490a>> m1699a(Set<C0494e> set, Set<String> set2, C0497a c0497a, cr crVar) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (C0494e c0494e : set) {
            cm lY = crVar.lY();
            by a = m1706a(c0494e, (Set) set2, lY);
            if (((Boolean) a.getObject()).booleanValue()) {
                c0497a.m1689a(c0494e, hashSet, hashSet2, lY);
            }
            boolean z2 = z && a.ma();
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        crVar.m1688b(hashSet);
        return new by(hashSet, z);
    }

    private void m1700a(C1109a c1109a, Set<String> set) {
        if (c1109a != null) {
            by a = m1696a(c1109a, (Set) set, new bw());
            if (a != ahm) {
                Object o = dh.m1730o((C1109a) a.getObject());
                if (o instanceof Map) {
                    this.aeu.push((Map) o);
                } else if (o instanceof List) {
                    for (Object o2 : (List) o2) {
                        if (o2 instanceof Map) {
                            this.aeu.push((Map) o2);
                        } else {
                            bh.m1645D("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    bh.m1645D("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    private static void m1701a(List<C0490a> list, List<String> list2, String str) {
        if (list.size() != list2.size()) {
            bh.m1643B("Invalid resource: imbalance of rule names of functions for " + str + " operation. Using default rule name instead");
        }
    }

    private static void m1702a(Map<String, aj> map, aj ajVar) {
        if (map.containsKey(ajVar.lL())) {
            throw new IllegalArgumentException("Duplicate function type name: " + ajVar.lL());
        }
        map.put(ajVar.lL(), ajVar);
    }

    private static C0499c m1703d(Map<String, C0499c> map, String str) {
        C0499c c0499c = (C0499c) map.get(str);
        if (c0499c != null) {
            return c0499c;
        }
        c0499c = new C0499c();
        map.put(str, c0499c);
        return c0499c;
    }

    private static String m1704h(C0490a c0490a) {
        return dh.m1722j((C1109a) c0490a.mo().get(C0300b.INSTANCE_NAME.toString()));
    }

    private String mI() {
        if (this.ahx <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.ahx));
        for (int i = 2; i < this.ahx; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    by<Boolean> m1705a(C0490a c0490a, Set<String> set, cj cjVar) {
        by a = m1698a(this.ahq, c0490a, (Set) set, cjVar);
        Boolean n = dh.m1728n((C1109a) a.getObject());
        cjVar.m1663d(dh.m1733r(n));
        return new by(n, a.ma());
    }

    by<Boolean> m1706a(C0494e c0494e, Set<String> set, cm cmVar) {
        boolean z = true;
        for (C0490a a : c0494e.mx()) {
            by a2 = m1705a(a, (Set) set, cmVar.lS());
            if (((Boolean) a2.getObject()).booleanValue()) {
                cmVar.m1666f(dh.m1733r(Boolean.valueOf(false)));
                return new by(Boolean.valueOf(false), a2.ma());
            }
            boolean z2 = z && a2.ma();
            z = z2;
        }
        for (C0490a a3 : c0494e.mw()) {
            a2 = m1705a(a3, (Set) set, cmVar.lT());
            if (((Boolean) a2.getObject()).booleanValue()) {
                z = z && a2.ma();
            } else {
                cmVar.m1666f(dh.m1733r(Boolean.valueOf(false)));
                return new by(Boolean.valueOf(false), a2.ma());
            }
        }
        cmVar.m1666f(dh.m1733r(Boolean.valueOf(true)));
        return new by(Boolean.valueOf(true), z);
    }

    by<Set<C0490a>> m1707a(String str, Set<C0494e> set, Map<C0494e, List<C0490a>> map, Map<C0494e, List<String>> map2, Map<C0494e, List<C0490a>> map3, Map<C0494e, List<String>> map4, Set<String> set2, cr crVar) {
        return m1699a((Set) set, (Set) set2, new C09593(this, map, map2, map3, map4), crVar);
    }

    by<Set<C0490a>> m1708a(Set<C0494e> set, cr crVar) {
        return m1699a((Set) set, new HashSet(), new C09604(this), crVar);
    }

    void m1709a(aj ajVar) {
        m1702a(this.ahr, ajVar);
    }

    void m1710b(aj ajVar) {
        m1702a(this.ahp, ajVar);
    }

    public synchronized void bH(String str) {
        ck(str);
        af bT = this.aho.bT(str);
        C0514t lI = bT.lI();
        for (C0490a a : (Set) m1708a(this.ahu, lI.lB()).getObject()) {
            m1698a(this.ahp, a, new HashSet(), lI.lA());
        }
        bT.lJ();
        ck(null);
    }

    void m1711c(aj ajVar) {
        m1702a(this.ahq, ajVar);
    }

    public by<C1109a> cj(String str) {
        this.ahx = 0;
        af bS = this.aho.bS(str);
        by<C1109a> a = m1697a(str, new HashSet(), bS.lH());
        bS.lJ();
        return a;
    }

    synchronized void ck(String str) {
        this.ahw = str;
    }

    public synchronized void m1712h(List<C1107i> list) {
        for (C1107i c1107i : list) {
            if (c1107i.name == null || !c1107i.name.startsWith("gaExperiment:")) {
                bh.m1644C("Ignored supplemental: " + c1107i);
            } else {
                ai.m1622a(this.aeu, c1107i);
            }
        }
    }

    synchronized String mH() {
        return this.ahw;
    }
}
