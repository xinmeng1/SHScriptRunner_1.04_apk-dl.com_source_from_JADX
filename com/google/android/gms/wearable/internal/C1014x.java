package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wearable.internal.x */
public class C1014x implements SafeParcelable {
    public static final Creator<C1014x> CREATOR;
    public final ParcelFileDescriptor alP;
    public final int statusCode;
    public final int versionCode;

    static {
        CREATOR = new C0575y();
    }

    C1014x(int i, int i2, ParcelFileDescriptor parcelFileDescriptor) {
        this.versionCode = i;
        this.statusCode = i2;
        this.alP = parcelFileDescriptor;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0575y.m1854a(this, dest, flags | 1);
    }
}
