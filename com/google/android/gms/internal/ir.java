package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.C1054j;
import java.util.Arrays;
import java.util.Collections;

public class ir extends C1054j<AppVisibleCustomProperties> {
    public ir(int i) {
        super("customFileProperties", Collections.emptyList(), Arrays.asList(new String[]{"customPropertiesExtra"}), i);
    }

    protected /* synthetic */ Object m4068b(DataHolder dataHolder, int i, int i2) {
        return m4069j(dataHolder, i, i2);
    }

    protected AppVisibleCustomProperties m4069j(DataHolder dataHolder, int i, int i2) {
        return (AppVisibleCustomProperties) dataHolder.eU().getSparseParcelableArray("customPropertiesExtra").get(i, AppVisibleCustomProperties.JN);
    }
}
