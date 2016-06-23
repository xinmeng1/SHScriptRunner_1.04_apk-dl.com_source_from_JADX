package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class hk {

    /* renamed from: com.google.android.gms.internal.hk.a */
    public static final class C0380a {
        private final List<String> GJ;
        private final Object GK;

        private C0380a(Object obj) {
            this.GK = hm.m1232f(obj);
            this.GJ = new ArrayList();
        }

        public C0380a m1220a(String str, Object obj) {
            this.GJ.add(((String) hm.m1232f(str)) + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.GK.getClass().getSimpleName()).append('{');
            int size = this.GJ.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.GJ.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public static C0380a m1221e(Object obj) {
        return new C0380a(null);
    }

    public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public static int hashCode(Object... objects) {
        return Arrays.hashCode(objects);
    }
}
