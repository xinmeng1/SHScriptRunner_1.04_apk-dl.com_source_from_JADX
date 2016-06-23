package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hm;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class MetadataBundle implements SafeParcelable {
    public static final Creator<MetadataBundle> CREATOR;
    final Bundle JS;
    final int xM;

    static {
        CREATOR = new C0234h();
    }

    MetadataBundle(int versionCode, Bundle valueBundle) {
        this.xM = versionCode;
        this.JS = (Bundle) hm.m1232f(valueBundle);
        this.JS.setClassLoader(getClass().getClassLoader());
        List<String> arrayList = new ArrayList();
        for (String str : this.JS.keySet()) {
            if (C0233e.aN(str) == null) {
                arrayList.add(str);
                Log.w("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
            }
        }
        for (String str2 : arrayList) {
            this.JS.remove(str2);
        }
    }

    private MetadataBundle(Bundle valueBundle) {
        this(1, valueBundle);
    }

    public static <T> MetadataBundle m2083a(MetadataField<T> metadataField, T t) {
        MetadataBundle gF = gF();
        gF.m2086b(metadataField, t);
        return gF;
    }

    public static MetadataBundle m2084a(MetadataBundle metadataBundle) {
        return new MetadataBundle(new Bundle(metadataBundle.JS));
    }

    public static MetadataBundle gF() {
        return new MetadataBundle(new Bundle());
    }

    public <T> T m2085a(MetadataField<T> metadataField) {
        return metadataField.m365e(this.JS);
    }

    public <T> void m2086b(MetadataField<T> metadataField, T t) {
        if (C0233e.aN(metadataField.getName()) == null) {
            throw new IllegalArgumentException("Unregistered field: " + metadataField.getName());
        }
        metadataField.m364a(t, this.JS);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataBundle)) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.JS.keySet();
        if (!keySet.equals(metadataBundle.JS.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!hk.equal(this.JS.get(str), metadataBundle.JS.get(str))) {
                return false;
            }
        }
        return true;
    }

    public Set<MetadataField<?>> gG() {
        Set<MetadataField<?>> hashSet = new HashSet();
        for (String aN : this.JS.keySet()) {
            hashSet.add(C0233e.aN(aN));
        }
        return hashSet;
    }

    public int hashCode() {
        int i = 1;
        for (String str : this.JS.keySet()) {
            i *= 31;
            i = this.JS.get(str).hashCode() + i;
        }
        return i;
    }

    public String toString() {
        return "MetadataBundle [values=" + this.JS + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0234h.m370a(this, dest, flags);
    }
}
