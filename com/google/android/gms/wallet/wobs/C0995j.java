package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.j */
public final class C0995j implements SafeParcelable {
    public static final Creator<C0995j> CREATOR;
    String akZ;
    String qe;
    private final int xM;

    static {
        CREATOR = new C0554k();
    }

    C0995j() {
        this.xM = 1;
    }

    C0995j(int i, String str, String str2) {
        this.xM = i;
        this.akZ = str;
        this.qe = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0554k.m1792a(this, dest, flags);
    }
}
