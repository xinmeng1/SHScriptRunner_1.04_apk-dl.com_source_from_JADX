package com.google.android.gms.tagmanager;

import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.internal.C0323d.C1109a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class dh {
    private static final Object ain;
    private static Long aio;
    private static Double aip;
    private static dg aiq;
    private static String air;
    private static Boolean ais;
    private static List<Object> ait;
    private static Map<Object, Object> aiu;
    private static C1109a aiv;

    static {
        ain = null;
        aio = new Long(0);
        aip = new Double(0.0d);
        aiq = dg.m1720z(0);
        air = new String("");
        ais = new Boolean(false);
        ait = new ArrayList(0);
        aiu = new HashMap();
        aiv = m1733r(air);
    }

    public static C1109a cp(String str) {
        C1109a c1109a = new C1109a();
        c1109a.type = 5;
        c1109a.fS = str;
        return c1109a;
    }

    private static dg cq(String str) {
        try {
            return dg.co(str);
        } catch (NumberFormatException e) {
            bh.m1642A("Failed to convert '" + str + "' to a number.");
            return aiq;
        }
    }

    private static Long cr(String str) {
        dg cq = cq(str);
        return cq == aiq ? aio : Long.valueOf(cq.longValue());
    }

    private static Double cs(String str) {
        dg cq = cq(str);
        return cq == aiq ? aip : Double.valueOf(cq.doubleValue());
    }

    private static Boolean ct(String str) {
        return "true".equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : ais;
    }

    private static double getDouble(Object o) {
        if (o instanceof Number) {
            return ((Number) o).doubleValue();
        }
        bh.m1642A("getDouble received non-Number");
        return 0.0d;
    }

    public static String m1722j(C1109a c1109a) {
        return m1726m(m1730o(c1109a));
    }

    public static dg m1723k(C1109a c1109a) {
        return m1727n(m1730o(c1109a));
    }

    public static Long m1724l(C1109a c1109a) {
        return m1729o(m1730o(c1109a));
    }

    public static Double m1725m(C1109a c1109a) {
        return m1731p(m1730o(c1109a));
    }

    public static String m1726m(Object obj) {
        return obj == null ? air : obj.toString();
    }

    public static Object mX() {
        return ain;
    }

    public static Long mY() {
        return aio;
    }

    public static Double mZ() {
        return aip;
    }

    public static dg m1727n(Object obj) {
        return obj instanceof dg ? (dg) obj : m1735t(obj) ? dg.m1720z(m1736u(obj)) : m1734s(obj) ? dg.m1719a(Double.valueOf(getDouble(obj))) : cq(m1726m(obj));
    }

    public static Boolean m1728n(C1109a c1109a) {
        return m1732q(m1730o(c1109a));
    }

    public static Boolean na() {
        return ais;
    }

    public static dg nb() {
        return aiq;
    }

    public static String nc() {
        return air;
    }

    public static C1109a nd() {
        return aiv;
    }

    public static Long m1729o(Object obj) {
        return m1735t(obj) ? Long.valueOf(m1736u(obj)) : cr(m1726m(obj));
    }

    public static Object m1730o(C1109a c1109a) {
        int i = 0;
        if (c1109a == null) {
            return ain;
        }
        C1109a[] c1109aArr;
        int length;
        switch (c1109a.type) {
            case DataEvent.TYPE_CHANGED /*1*/:
                return c1109a.fN;
            case DataEvent.TYPE_DELETED /*2*/:
                ArrayList arrayList = new ArrayList(c1109a.fO.length);
                c1109aArr = c1109a.fO;
                length = c1109aArr.length;
                while (i < length) {
                    Object o = m1730o(c1109aArr[i]);
                    if (o == ain) {
                        return ain;
                    }
                    arrayList.add(o);
                    i++;
                }
                return arrayList;
            case DetectedActivity.STILL /*3*/:
                if (c1109a.fP.length != c1109a.fQ.length) {
                    bh.m1642A("Converting an invalid value to object: " + c1109a.toString());
                    return ain;
                }
                Map hashMap = new HashMap(c1109a.fQ.length);
                while (i < c1109a.fP.length) {
                    Object o2 = m1730o(c1109a.fP[i]);
                    Object o3 = m1730o(c1109a.fQ[i]);
                    if (o2 == ain || o3 == ain) {
                        return ain;
                    }
                    hashMap.put(o2, o3);
                    i++;
                }
                return hashMap;
            case DetectedActivity.UNKNOWN /*4*/:
                bh.m1642A("Trying to convert a macro reference to object");
                return ain;
            case DetectedActivity.TILTING /*5*/:
                bh.m1642A("Trying to convert a function id to object");
                return ain;
            case Quest.STATE_FAILED /*6*/:
                return Long.valueOf(c1109a.fT);
            case DetectedActivity.WALKING /*7*/:
                StringBuffer stringBuffer = new StringBuffer();
                c1109aArr = c1109a.fV;
                length = c1109aArr.length;
                while (i < length) {
                    String j = m1722j(c1109aArr[i]);
                    if (j == air) {
                        return ain;
                    }
                    stringBuffer.append(j);
                    i++;
                }
                return stringBuffer.toString();
            case DetectedActivity.RUNNING /*8*/:
                return Boolean.valueOf(c1109a.fU);
            default:
                bh.m1642A("Failed to convert a value of type: " + c1109a.type);
                return ain;
        }
    }

    public static Double m1731p(Object obj) {
        return m1734s(obj) ? Double.valueOf(getDouble(obj)) : cs(m1726m(obj));
    }

    public static Boolean m1732q(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : ct(m1726m(obj));
    }

    public static C1109a m1733r(Object obj) {
        boolean z = false;
        C1109a c1109a = new C1109a();
        if (obj instanceof C1109a) {
            return (C1109a) obj;
        }
        if (obj instanceof String) {
            c1109a.type = 1;
            c1109a.fN = (String) obj;
        } else if (obj instanceof List) {
            c1109a.type = 2;
            List<Object> list = (List) obj;
            r5 = new ArrayList(list.size());
            r1 = false;
            for (Object r : list) {
                C1109a r2 = m1733r(r);
                if (r2 == aiv) {
                    return aiv;
                }
                r0 = r1 || r2.fX;
                r5.add(r2);
                r1 = r0;
            }
            c1109a.fO = (C1109a[]) r5.toArray(new C1109a[0]);
            z = r1;
        } else if (obj instanceof Map) {
            c1109a.type = 3;
            Set<Entry> entrySet = ((Map) obj).entrySet();
            r5 = new ArrayList(entrySet.size());
            List arrayList = new ArrayList(entrySet.size());
            r1 = false;
            for (Entry entry : entrySet) {
                C1109a r3 = m1733r(entry.getKey());
                C1109a r4 = m1733r(entry.getValue());
                if (r3 == aiv || r4 == aiv) {
                    return aiv;
                }
                r0 = r1 || r3.fX || r4.fX;
                r5.add(r3);
                arrayList.add(r4);
                r1 = r0;
            }
            c1109a.fP = (C1109a[]) r5.toArray(new C1109a[0]);
            c1109a.fQ = (C1109a[]) arrayList.toArray(new C1109a[0]);
            z = r1;
        } else if (m1734s(obj)) {
            c1109a.type = 1;
            c1109a.fN = obj.toString();
        } else if (m1735t(obj)) {
            c1109a.type = 6;
            c1109a.fT = m1736u(obj);
        } else if (obj instanceof Boolean) {
            c1109a.type = 8;
            c1109a.fU = ((Boolean) obj).booleanValue();
        } else {
            bh.m1642A("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
            return aiv;
        }
        c1109a.fX = z;
        return c1109a;
    }

    private static boolean m1734s(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof dg) && ((dg) obj).mS());
    }

    private static boolean m1735t(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof dg) && ((dg) obj).mT());
    }

    private static long m1736u(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        bh.m1642A("getInt64 received non-Number");
        return 0;
    }
}
