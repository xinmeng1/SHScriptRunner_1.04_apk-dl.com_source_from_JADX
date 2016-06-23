package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0652a;

/* renamed from: com.google.android.gms.drive.metadata.internal.g */
public class C1053g extends C0652a<Long> {
    public C1053g(String str, int i) {
        super(str, i);
    }

    protected void m3240a(Bundle bundle, Long l) {
        bundle.putLong(getName(), l.longValue());
    }

    protected /* synthetic */ Object m3242b(DataHolder dataHolder, int i, int i2) {
        return m3244g(dataHolder, i, i2);
    }

    protected /* synthetic */ Object m3243f(Bundle bundle) {
        return m3245j(bundle);
    }

    protected Long m3244g(DataHolder dataHolder, int i, int i2) {
        return Long.valueOf(dataHolder.m2008a(getName(), i, i2));
    }

    protected Long m3245j(Bundle bundle) {
        return Long.valueOf(bundle.getLong(getName()));
    }
}
