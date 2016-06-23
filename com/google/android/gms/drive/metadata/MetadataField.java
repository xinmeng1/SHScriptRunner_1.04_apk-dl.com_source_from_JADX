package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;

public interface MetadataField<T> {
    T m362a(DataHolder dataHolder, int i, int i2);

    void m363a(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2);

    void m364a(T t, Bundle bundle);

    T m365e(Bundle bundle);

    Collection<String> gC();

    String getName();
}
