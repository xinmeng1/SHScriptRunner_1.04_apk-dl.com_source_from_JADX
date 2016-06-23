package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.C1049b;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;
import java.util.Collections;

public class InFilter<T> implements SafeParcelable, Filter {
    public static final C0244g CREATOR;
    final MetadataBundle KM;
    private final C1049b<T> KX;
    final int xM;

    static {
        CREATOR = new C0244g();
    }

    InFilter(int versionCode, MetadataBundle value) {
        this.xM = versionCode;
        this.KM = value;
        this.KX = (C1049b) C0242e.m377b(value);
    }

    public InFilter(SearchableCollectionMetadataField<T> field, T value) {
        this(1, MetadataBundle.m2083a(field, Collections.singleton(value)));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0244g.m379a(this, out, flags);
    }
}
