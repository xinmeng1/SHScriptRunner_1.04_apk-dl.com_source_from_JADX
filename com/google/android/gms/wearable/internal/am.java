package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class am implements SafeParcelable {
    public static final Creator<am> CREATOR;
    public final C1185m alO;
    public final int statusCode;
    public final int versionCode;

    static {
        CREATOR = new an();
    }

    am(int i, int i2, C1185m c1185m) {
        this.versionCode = i;
        this.statusCode = i2;
        this.alO = c1185m;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        an.m1843a(this, dest, flags);
    }
}
