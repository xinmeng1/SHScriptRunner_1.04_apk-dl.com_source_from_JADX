package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0304c.C1101c;
import com.google.android.gms.internal.C0304c.C1102d;
import com.google.android.gms.internal.C0304c.C1107i;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.Map;

class ai {
    private static void m1621a(DataLayer dataLayer, C1102d c1102d) {
        for (C1109a j : c1102d.eS) {
            dataLayer.bN(dh.m1722j(j));
        }
    }

    public static void m1622a(DataLayer dataLayer, C1107i c1107i) {
        if (c1107i.fI == null) {
            bh.m1645D("supplemental missing experimentSupplemental");
            return;
        }
        m1621a(dataLayer, c1107i.fI);
        m1623b(dataLayer, c1107i.fI);
        m1625c(dataLayer, c1107i.fI);
    }

    private static void m1623b(DataLayer dataLayer, C1102d c1102d) {
        for (C1109a c : c1102d.eR) {
            Map c2 = m1624c(c);
            if (c2 != null) {
                dataLayer.push(c2);
            }
        }
    }

    private static Map<String, Object> m1624c(C1109a c1109a) {
        Object o = dh.m1730o(c1109a);
        if (o instanceof Map) {
            return (Map) o;
        }
        bh.m1645D("value: " + o + " is not a map value, ignored.");
        return null;
    }

    private static void m1625c(DataLayer dataLayer, C1102d c1102d) {
        for (C1101c c1101c : c1102d.eT) {
            if (c1101c.eM == null) {
                bh.m1645D("GaExperimentRandom: No key");
            } else {
                Object obj = dataLayer.get(c1101c.eM);
                Long valueOf = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                long j = c1101c.eN;
                long j2 = c1101c.eO;
                if (!c1101c.eP || valueOf == null || valueOf.longValue() < j || valueOf.longValue() > j2) {
                    if (j <= j2) {
                        obj = Long.valueOf(Math.round((Math.random() * ((double) (j2 - j))) + ((double) j)));
                    } else {
                        bh.m1645D("GaExperimentRandom: random range invalid");
                    }
                }
                dataLayer.bN(c1101c.eM);
                Map c = dataLayer.m1609c(c1101c.eM, obj);
                if (c1101c.eQ > 0) {
                    if (c.containsKey("gtm")) {
                        Object obj2 = c.get("gtm");
                        if (obj2 instanceof Map) {
                            ((Map) obj2).put("lifetime", Long.valueOf(c1101c.eQ));
                        } else {
                            bh.m1645D("GaExperimentRandom: gtm not a map");
                        }
                    } else {
                        c.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(c1101c.eQ)));
                    }
                }
                dataLayer.push(c);
            }
        }
    }
}
