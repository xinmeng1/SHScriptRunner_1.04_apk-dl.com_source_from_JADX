package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class li implements SafeParcelable {
    public static final Creator<li> CREATOR;
    String[] ake;
    byte[][] akf;
    private final int xM;

    static {
        CREATOR = new lj();
    }

    li() {
        this(1, new String[0], new byte[0][]);
    }

    li(int i, String[] strArr, byte[][] bArr) {
        this.xM = i;
        this.ake = strArr;
        this.akf = bArr;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel out, int flags) {
        lj.m1341a(this, out, flags);
    }
}
