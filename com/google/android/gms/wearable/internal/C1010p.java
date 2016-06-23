package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wearable.internal.p */
public class C1010p implements SafeParcelable {
    public static final Creator<C1010p> CREATOR;
    public final int alL;
    public final int statusCode;
    public final int versionCode;

    static {
        CREATOR = new C0571q();
    }

    C1010p(int i, int i2, int i3) {
        this.versionCode = i;
        this.statusCode = i2;
        this.alL = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0571q.m1850a(this, dest, flags);
    }
}
