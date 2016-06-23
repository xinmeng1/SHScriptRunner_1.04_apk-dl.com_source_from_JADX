package com.google.android.gms.internal;

import com.google.android.gms.internal.lw.C1145a;
import com.google.android.gms.internal.lw.C1145a.C1144a;
import com.google.android.gms.internal.lw.C1145a.C1144a.C1143a;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class lv {

    /* renamed from: com.google.android.gms.internal.lv.a */
    public static class C0391a {
        public final lw amp;
        public final List<Asset> amq;

        public C0391a(lw lwVar, List<Asset> list) {
            this.amp = lwVar;
            this.amq = list;
        }
    }

    private static int m1360a(String str, C1144a[] c1144aArr) {
        int i = 14;
        for (C1144a c1144a : c1144aArr) {
            if (i == 14) {
                if (c1144a.type == 9 || c1144a.type == 2 || c1144a.type == 6) {
                    i = c1144a.type;
                } else if (c1144a.type != 14) {
                    throw new IllegalArgumentException("Unexpected TypedValue type: " + c1144a.type + " for key " + str);
                }
            } else if (c1144a.type != i) {
                throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + c1144a.type);
            }
        }
        return i;
    }

    static int m1361a(List<Asset> list, Asset asset) {
        list.add(asset);
        return list.size() - 1;
    }

    public static C0391a m1362a(DataMap dataMap) {
        lw lwVar = new lw();
        List arrayList = new ArrayList();
        lwVar.amr = m1367a(dataMap, arrayList);
        return new C0391a(lwVar, arrayList);
    }

    private static C1144a m1363a(List<Asset> list, Object obj) {
        C1144a c1144a = new C1144a();
        if (obj == null) {
            c1144a.type = 14;
            return c1144a;
        }
        c1144a.amv = new C1143a();
        if (obj instanceof String) {
            c1144a.type = 2;
            c1144a.amv.amx = (String) obj;
        } else if (obj instanceof Integer) {
            c1144a.type = 6;
            c1144a.amv.amB = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            c1144a.type = 5;
            c1144a.amv.amA = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            c1144a.type = 3;
            c1144a.amv.amy = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            c1144a.type = 4;
            c1144a.amv.amz = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            c1144a.type = 8;
            c1144a.amv.amD = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            c1144a.type = 7;
            c1144a.amv.amC = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            c1144a.type = 1;
            c1144a.amv.amw = (byte[]) obj;
        } else if (obj instanceof String[]) {
            c1144a.type = 11;
            c1144a.amv.amG = (String[]) obj;
        } else if (obj instanceof long[]) {
            c1144a.type = 12;
            c1144a.amv.amH = (long[]) obj;
        } else if (obj instanceof float[]) {
            c1144a.type = 15;
            c1144a.amv.amI = (float[]) obj;
        } else if (obj instanceof Asset) {
            c1144a.type = 13;
            c1144a.amv.amJ = (long) m1361a((List) list, (Asset) obj);
        } else if (obj instanceof DataMap) {
            c1144a.type = 9;
            DataMap dataMap = (DataMap) obj;
            Set<String> keySet = dataMap.keySet();
            C1145a[] c1145aArr = new C1145a[keySet.size()];
            r1 = 0;
            for (String str : keySet) {
                c1145aArr[r1] = new C1145a();
                c1145aArr[r1].name = str;
                c1145aArr[r1].amt = m1363a((List) list, dataMap.get(str));
                r1++;
            }
            c1144a.amv.amE = c1145aArr;
        } else if (obj instanceof ArrayList) {
            c1144a.type = 10;
            ArrayList arrayList = (ArrayList) obj;
            C1144a[] c1144aArr = new C1144a[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i = 0;
            int i2 = 14;
            while (i < size) {
                Object obj3 = arrayList.get(i);
                C1144a a = m1363a((List) list, obj3);
                if (a.type == 14 || a.type == 2 || a.type == 6 || a.type == 9) {
                    if (i2 == 14 && a.type != 14) {
                        r1 = a.type;
                    } else if (a.type != i2) {
                        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                    } else {
                        obj3 = obj2;
                        r1 = i2;
                    }
                    c1144aArr[i] = a;
                    i++;
                    i2 = r1;
                    obj2 = obj3;
                } else {
                    throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                }
            }
            c1144a.amv.amF = c1144aArr;
        } else {
            throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
        }
        return c1144a;
    }

    public static DataMap m1364a(C0391a c0391a) {
        DataMap dataMap = new DataMap();
        for (C1145a c1145a : c0391a.amp.amr) {
            m1366a(c0391a.amq, dataMap, c1145a.name, c1145a.amt);
        }
        return dataMap;
    }

    private static ArrayList m1365a(List<Asset> list, C1143a c1143a, int i) {
        ArrayList arrayList = new ArrayList(c1143a.amF.length);
        for (C1144a c1144a : c1143a.amF) {
            if (c1144a.type == 14) {
                arrayList.add(null);
            } else if (i == 9) {
                DataMap dataMap = new DataMap();
                for (C1145a c1145a : c1144a.amv.amE) {
                    m1366a(list, dataMap, c1145a.name, c1145a.amt);
                }
                arrayList.add(dataMap);
            } else if (i == 2) {
                arrayList.add(c1144a.amv.amx);
            } else if (i == 6) {
                arrayList.add(Integer.valueOf(c1144a.amv.amB));
            } else {
                throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
            }
        }
        return arrayList;
    }

    private static void m1366a(List<Asset> list, DataMap dataMap, String str, C1144a c1144a) {
        int i = c1144a.type;
        if (i == 14) {
            dataMap.putString(str, null);
            return;
        }
        C1143a c1143a = c1144a.amv;
        if (i == 1) {
            dataMap.putByteArray(str, c1143a.amw);
        } else if (i == 11) {
            dataMap.putStringArray(str, c1143a.amG);
        } else if (i == 12) {
            dataMap.putLongArray(str, c1143a.amH);
        } else if (i == 15) {
            dataMap.putFloatArray(str, c1143a.amI);
        } else if (i == 2) {
            dataMap.putString(str, c1143a.amx);
        } else if (i == 3) {
            dataMap.putDouble(str, c1143a.amy);
        } else if (i == 4) {
            dataMap.putFloat(str, c1143a.amz);
        } else if (i == 5) {
            dataMap.putLong(str, c1143a.amA);
        } else if (i == 6) {
            dataMap.putInt(str, c1143a.amB);
        } else if (i == 7) {
            dataMap.putByte(str, (byte) c1143a.amC);
        } else if (i == 8) {
            dataMap.putBoolean(str, c1143a.amD);
        } else if (i == 13) {
            if (list == null) {
                throw new RuntimeException("populateBundle: unexpected type for: " + str);
            }
            dataMap.putAsset(str, (Asset) list.get((int) c1143a.amJ));
        } else if (i == 9) {
            DataMap dataMap2 = new DataMap();
            for (C1145a c1145a : c1143a.amE) {
                m1366a(list, dataMap2, c1145a.name, c1145a.amt);
            }
            dataMap.putDataMap(str, dataMap2);
        } else if (i == 10) {
            i = m1360a(str, c1143a.amF);
            ArrayList a = m1365a(list, c1143a, i);
            if (i == 14) {
                dataMap.putStringArrayList(str, a);
            } else if (i == 9) {
                dataMap.putDataMapArrayList(str, a);
            } else if (i == 2) {
                dataMap.putStringArrayList(str, a);
            } else if (i == 6) {
                dataMap.putIntegerArrayList(str, a);
            } else {
                throw new IllegalStateException("Unexpected typeOfArrayList: " + i);
            }
        } else {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
    }

    private static C1145a[] m1367a(DataMap dataMap, List<Asset> list) {
        Set<String> keySet = dataMap.keySet();
        C1145a[] c1145aArr = new C1145a[keySet.size()];
        int i = 0;
        for (String str : keySet) {
            Object obj = dataMap.get(str);
            c1145aArr[i] = new C1145a();
            c1145aArr[i].name = str;
            c1145aArr[i].amt = m1363a((List) list, obj);
            i++;
        }
        return c1145aArr;
    }
}
