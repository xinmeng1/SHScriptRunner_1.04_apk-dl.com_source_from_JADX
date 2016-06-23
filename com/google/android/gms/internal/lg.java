package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class lg implements SafeParcelable {
    public static final Creator<lg> CREATOR;
    int[] akd;
    private final int xM;

    static {
        CREATOR = new lh();
    }

    lg() {
        this(1, null);
    }

    lg(int i, int[] iArr) {
        this.xM = i;
        this.akd = iArr;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel out, int flags) {
        lh.m1340a(this, out, flags);
    }
}
