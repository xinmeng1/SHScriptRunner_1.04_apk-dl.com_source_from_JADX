package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0300b;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.tagmanager.s */
class C0979s extends aj {
    private static final String ID;
    private static final String aeW;
    private static final String aem;
    private final C0513a aeX;

    /* renamed from: com.google.android.gms.tagmanager.s.a */
    public interface C0513a {
        Object m1745b(String str, Map<String, Object> map);
    }

    static {
        ID = C0296a.FUNCTION_CALL.toString();
        aeW = C0300b.FUNCTION_CALL_NAME.toString();
        aem = C0300b.ADDITIONAL_PARAMS.toString();
    }

    public C0979s(C0513a c0513a) {
        super(ID, aeW);
        this.aeX = c0513a;
    }

    public boolean lh() {
        return false;
    }

    public C1109a m3041w(Map<String, C1109a> map) {
        String j = dh.m1722j((C1109a) map.get(aeW));
        Map hashMap = new HashMap();
        C1109a c1109a = (C1109a) map.get(aem);
        if (c1109a != null) {
            Object o = dh.m1730o(c1109a);
            if (o instanceof Map) {
                for (Entry entry : ((Map) o).entrySet()) {
                    hashMap.put(entry.getKey().toString(), entry.getValue());
                }
            } else {
                bh.m1645D("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return dh.nd();
            }
        }
        try {
            return dh.m1733r(this.aeX.m1745b(j, hashMap));
        } catch (Exception e) {
            bh.m1645D("Custom macro/tag " + j + " threw exception " + e.getMessage());
            return dh.nd();
        }
    }
}
