package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0652a;

/* renamed from: com.google.android.gms.drive.metadata.internal.b */
public class C1051b extends C0652a<Boolean> {
    public C1051b(String str, int i) {
        super(str, i);
    }

    protected void m3228a(Bundle bundle, Boolean bool) {
        bundle.putBoolean(getName(), bool.booleanValue());
    }

    protected /* synthetic */ Object m3230b(DataHolder dataHolder, int i, int i2) {
        return m3231d(dataHolder, i, i2);
    }

    protected Boolean m3231d(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.m2013d(getName(), i, i2));
    }

    protected /* synthetic */ Object m3232f(Bundle bundle) {
        return m3233g(bundle);
    }

    protected Boolean m3233g(Bundle bundle) {
        return Boolean.valueOf(bundle.getBoolean(getName()));
    }
}
