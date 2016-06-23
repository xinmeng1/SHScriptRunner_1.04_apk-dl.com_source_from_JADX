package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.C1051b;
import com.google.android.gms.drive.metadata.internal.C1052f;

public class iu {
    public static final MetadataField<Integer> KC;
    public static final MetadataField<Boolean> KD;

    static {
        KC = new C1052f("contentAvailability", 4300000);
        KD = new C1051b("isPinnable", 4300000);
    }
}
