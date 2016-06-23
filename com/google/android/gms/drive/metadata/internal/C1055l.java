package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0652a;

/* renamed from: com.google.android.gms.drive.metadata.internal.l */
public class C1055l extends C0652a<String> {
    public C1055l(String str, int i) {
        super(str, i);
    }

    protected void m3251a(Bundle bundle, String str) {
        bundle.putString(getName(), str);
    }

    protected /* synthetic */ Object m3252b(DataHolder dataHolder, int i, int i2) {
        return m3254h(dataHolder, i, i2);
    }

    protected /* synthetic */ Object m3253f(Bundle bundle) {
        return m3255m(bundle);
    }

    protected String m3254h(DataHolder dataHolder, int i, int i2) {
        return dataHolder.m2012c(getName(), i, i2);
    }

    protected String m3255m(Bundle bundle) {
        return bundle.getString(getName());
    }
}
