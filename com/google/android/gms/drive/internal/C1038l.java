package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.l */
public final class C1038l extends Metadata {
    private final MetadataBundle II;

    public C1038l(MetadataBundle metadataBundle) {
        this.II = metadataBundle;
    }

    protected <T> T m3216a(MetadataField<T> metadataField) {
        return this.II.m2085a((MetadataField) metadataField);
    }

    public /* synthetic */ Object freeze() {
        return gl();
    }

    public Metadata gl() {
        return new C1038l(MetadataBundle.m2084a(this.II));
    }

    public boolean isDataValid() {
        return this.II != null;
    }

    public String toString() {
        return "Metadata [mImpl=" + this.II + "]";
    }
}
