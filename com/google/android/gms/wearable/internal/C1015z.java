package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wearable.internal.z */
public class C1015z implements SafeParcelable {
    public static final Creator<C1015z> CREATOR;
    public final ai alQ;
    public final int statusCode;
    public final int versionCode;

    static {
        CREATOR = new aa();
    }

    C1015z(int i, int i2, ai aiVar) {
        this.versionCode = i;
        this.statusCode = i2;
        this.alQ = aiVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        aa.m1807a(this, dest, flags);
    }
}
