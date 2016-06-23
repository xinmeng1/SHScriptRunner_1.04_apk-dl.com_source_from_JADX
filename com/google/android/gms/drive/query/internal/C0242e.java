package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Set;

/* renamed from: com.google.android.gms.drive.query.internal.e */
class C0242e {
    static MetadataField<?> m377b(MetadataBundle metadataBundle) {
        Set gG = metadataBundle.gG();
        if (gG.size() == 1) {
            return (MetadataField) gG.iterator().next();
        }
        throw new IllegalArgumentException("bundle should have exactly 1 populated field");
    }
}
