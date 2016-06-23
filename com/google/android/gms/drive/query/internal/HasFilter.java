package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;

public class HasFilter<T> implements SafeParcelable, Filter {
    public static final C0243f CREATOR;
    final MetadataBundle KM;
    final MetadataField<T> KN;
    final int xM;

    static {
        CREATOR = new C0243f();
    }

    HasFilter(int versionCode, MetadataBundle value) {
        this.xM = versionCode;
        this.KM = value;
        this.KN = C0242e.m377b(value);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0243f.m378a(this, out, flags);
    }
}
