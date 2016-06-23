package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.hm;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.drive.metadata.a */
public abstract class C0652a<T> implements MetadataField<T> {
    private final String JH;
    private final Set<String> JI;
    private final Set<String> JJ;
    private final int JK;

    protected C0652a(String str, int i) {
        this.JH = (String) hm.m1228b((Object) str, (Object) "fieldName");
        this.JI = Collections.singleton(str);
        this.JJ = Collections.emptySet();
        this.JK = i;
    }

    protected C0652a(String str, Collection<String> collection, Collection<String> collection2, int i) {
        this.JH = (String) hm.m1228b((Object) str, (Object) "fieldName");
        this.JI = Collections.unmodifiableSet(new HashSet(collection));
        this.JJ = Collections.unmodifiableSet(new HashSet(collection2));
        this.JK = i;
    }

    public final T m2076a(DataHolder dataHolder, int i, int i2) {
        for (String h : this.JI) {
            if (dataHolder.m2017h(h, i, i2)) {
                return null;
            }
        }
        return m2080b(dataHolder, i, i2);
    }

    protected abstract void m2077a(Bundle bundle, T t);

    public final void m2078a(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2) {
        hm.m1228b((Object) dataHolder, (Object) "dataHolder");
        hm.m1228b((Object) metadataBundle, (Object) "bundle");
        metadataBundle.m2086b(this, m2076a(dataHolder, i, i2));
    }

    public final void m2079a(T t, Bundle bundle) {
        hm.m1228b((Object) bundle, (Object) "bundle");
        if (t == null) {
            bundle.putString(getName(), null);
        } else {
            m2077a(bundle, (Object) t);
        }
    }

    protected abstract T m2080b(DataHolder dataHolder, int i, int i2);

    public final T m2081e(Bundle bundle) {
        hm.m1228b((Object) bundle, (Object) "bundle");
        return bundle.get(getName()) != null ? m2082f(bundle) : null;
    }

    protected abstract T m2082f(Bundle bundle);

    public final Collection<String> gC() {
        return this.JI;
    }

    public final String getName() {
        return this.JH;
    }

    public String toString() {
        return this.JH;
    }
}
