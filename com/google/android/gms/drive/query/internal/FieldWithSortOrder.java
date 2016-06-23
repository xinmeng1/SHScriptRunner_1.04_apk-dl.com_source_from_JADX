package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FieldWithSortOrder implements SafeParcelable {
    public static final C0240c CREATOR;
    final String JH;
    final boolean KO;
    final int xM;

    static {
        CREATOR = new C0240c();
    }

    FieldWithSortOrder(int versionCode, String fieldName, boolean isSortAscending) {
        this.xM = versionCode;
        this.JH = fieldName;
        this.KO = isSortAscending;
    }

    public FieldWithSortOrder(String fieldName, boolean isSortAscending) {
        this(1, fieldName, isSortAscending);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0240c.m375a(this, out, flags);
    }
}
