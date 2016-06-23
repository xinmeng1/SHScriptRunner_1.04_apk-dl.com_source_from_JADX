package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.g */
public final class C0994g implements SafeParcelable {
    public static final Creator<C0994g> CREATOR;
    int akT;
    String akU;
    double akV;
    String akW;
    long akX;
    int akY;
    private final int xM;

    static {
        CREATOR = new C0552h();
    }

    C0994g() {
        this.xM = 1;
        this.akY = -1;
        this.akT = -1;
        this.akV = -1.0d;
    }

    C0994g(int i, int i2, String str, double d, String str2, long j, int i3) {
        this.xM = i;
        this.akT = i2;
        this.akU = str;
        this.akV = d;
        this.akW = str2;
        this.akX = j;
        this.akY = i3;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0552h.m1790a(this, dest, flags);
    }
}
