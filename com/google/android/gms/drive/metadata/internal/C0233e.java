package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.iq;
import com.google.android.gms.internal.is;
import com.google.android.gms.internal.iu;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.drive.metadata.internal.e */
public final class C0233e {
    private static Map<String, MetadataField<?>> JR;

    static {
        JR = new HashMap();
        C0233e.m369b(iq.JT);
        C0233e.m369b(iq.Kr);
        C0233e.m369b(iq.Kk);
        C0233e.m369b(iq.Kp);
        C0233e.m369b(iq.Ks);
        C0233e.m369b(iq.Ke);
        C0233e.m369b(iq.Kf);
        C0233e.m369b(iq.Kc);
        C0233e.m369b(iq.Kh);
        C0233e.m369b(iq.Kn);
        C0233e.m369b(iq.JU);
        C0233e.m369b(iq.Km);
        C0233e.m369b(iq.JW);
        C0233e.m369b(iq.Kd);
        C0233e.m369b(iq.JX);
        C0233e.m369b(iq.JY);
        C0233e.m369b(iq.JZ);
        C0233e.m369b(iq.Kj);
        C0233e.m369b(iq.Kg);
        C0233e.m369b(iq.Kl);
        C0233e.m369b(iq.Ko);
        C0233e.m369b(iq.Kt);
        C0233e.m369b(iq.Ku);
        C0233e.m369b(iq.Kb);
        C0233e.m369b(iq.Ka);
        C0233e.m369b(iq.Kq);
        C0233e.m369b(iq.Ki);
        C0233e.m369b(iq.JV);
        C0233e.m369b(iq.Kv);
        C0233e.m369b(is.Kw);
        C0233e.m369b(is.Ky);
        C0233e.m369b(is.Kz);
        C0233e.m369b(is.KA);
        C0233e.m369b(is.Kx);
        C0233e.m369b(iu.KC);
        C0233e.m369b(iu.KD);
    }

    public static MetadataField<?> aN(String str) {
        return (MetadataField) JR.get(str);
    }

    private static void m369b(MetadataField<?> metadataField) {
        if (JR.containsKey(metadataField.getName())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + metadataField.getName());
        }
        JR.put(metadataField.getName(), metadataField);
    }

    public static Collection<MetadataField<?>> gE() {
        return Collections.unmodifiableCollection(JR.values());
    }
}
