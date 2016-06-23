package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0300b;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.w */
class C1169w extends df {
    private static final String ID;
    private static final String VALUE;
    private static final String aft;
    private final DataLayer aeu;

    static {
        ID = C0296a.DATA_LAYER_WRITE.toString();
        VALUE = C0300b.VALUE.toString();
        aft = C0300b.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    }

    public C1169w(DataLayer dataLayer) {
        super(ID, VALUE);
        this.aeu = dataLayer;
    }

    private void m3849a(C1109a c1109a) {
        if (c1109a != null && c1109a != dh.mX()) {
            String j = dh.m1722j(c1109a);
            if (j != dh.nc()) {
                this.aeu.bN(j);
            }
        }
    }

    private void m3850b(C1109a c1109a) {
        if (c1109a != null && c1109a != dh.mX()) {
            Object o = dh.m1730o(c1109a);
            if (o instanceof List) {
                for (Object o2 : (List) o2) {
                    if (o2 instanceof Map) {
                        this.aeu.push((Map) o2);
                    }
                }
            }
        }
    }

    public void m3851y(Map<String, C1109a> map) {
        m3850b((C1109a) map.get(VALUE));
        m3849a((C1109a) map.get(aft));
    }
}
