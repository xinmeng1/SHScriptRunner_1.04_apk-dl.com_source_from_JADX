package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ak implements SafeParcelable {
    public static final Creator<ak> CREATOR;
    public final long amb;
    public final String label;
    public final String packageName;
    public final int versionCode;

    static {
        CREATOR = new al();
    }

    ak(int i, String str, String str2, long j) {
        this.versionCode = i;
        this.packageName = str;
        this.label = str2;
        this.amb = j;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        al.m1842a(this, out, flags);
    }
}
