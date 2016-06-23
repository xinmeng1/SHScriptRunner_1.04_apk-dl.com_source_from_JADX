package com.google.android.gms.drive.metadata;

import com.google.android.gms.common.data.DataHolder;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.google.android.gms.drive.metadata.b */
public abstract class C1049b<T> extends C0652a<Collection<T>> {
    protected C1049b(String str, int i) {
        super(str, Collections.emptySet(), Collections.emptySet(), i);
    }

    protected /* synthetic */ Object m3226b(DataHolder dataHolder, int i, int i2) {
        return m3227c(dataHolder, i, i2);
    }

    protected Collection<T> m3227c(DataHolder dataHolder, int i, int i2) {
        throw new UnsupportedOperationException("Cannot read collections from a dataHolder.");
    }
}
