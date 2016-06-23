package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.C1000c;

/* renamed from: com.google.android.gms.wearable.internal.r */
public class C1011r implements SafeParcelable {
    public static final Creator<C1011r> CREATOR;
    public final C1000c alM;
    public final int statusCode;
    public final int versionCode;

    static {
        CREATOR = new C0572s();
    }

    C1011r(int i, int i2, C1000c c1000c) {
        this.versionCode = i;
        this.statusCode = i2;
        this.alM = c1000c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0572s.m1851a(this, dest, flags);
    }
}
