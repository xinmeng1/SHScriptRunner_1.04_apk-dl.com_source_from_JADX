package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wearable.internal.v */
public class C1013v implements SafeParcelable {
    public static final Creator<C1013v> CREATOR;
    public final C1185m alO;
    public final int statusCode;
    public final int versionCode;

    static {
        CREATOR = new C0574w();
    }

    C1013v(int i, int i2, C1185m c1185m) {
        this.versionCode = i;
        this.statusCode = i2;
        this.alO = c1185m;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0574w.m1853a(this, dest, flags);
    }
}
