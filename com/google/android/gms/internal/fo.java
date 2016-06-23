package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public class fo {
    private static final String[] xZ;
    private static final Map<String, Integer> ya;

    static {
        int i = 0;
        xZ = new String[]{"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"};
        ya = new HashMap(xZ.length);
        while (i < xZ.length) {
            ya.put(xZ[i], Integer.valueOf(i));
            i++;
        }
    }

    public static String m1069H(int i) {
        return (i < 0 || i >= xZ.length) ? null : xZ[i];
    }

    public static int m1070Y(String str) {
        Integer num = (Integer) ya.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("[" + str + "] is not a valid global search section name");
    }

    public static int dP() {
        return xZ.length;
    }
}
