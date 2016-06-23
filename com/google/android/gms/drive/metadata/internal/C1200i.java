package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.C1049b;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.google.android.gms.drive.metadata.internal.i */
public class C1200i<T extends Parcelable> extends C1049b<T> {
    public C1200i(String str, int i) {
        super(str, i);
    }

    protected void m3931a(Bundle bundle, Collection<T> collection) {
        bundle.putParcelableArrayList(getName(), new ArrayList(collection));
    }

    protected /* synthetic */ Object m3932f(Bundle bundle) {
        return m3933k(bundle);
    }

    protected Collection<T> m3933k(Bundle bundle) {
        return bundle.getParcelableArrayList(getName());
    }
}
