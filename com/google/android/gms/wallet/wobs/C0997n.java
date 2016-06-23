package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.n */
public final class C0997n implements SafeParcelable {
    public static final Creator<C0997n> CREATOR;
    String alc;
    String description;
    private final int xM;

    static {
        CREATOR = new C0556o();
    }

    C0997n() {
        this.xM = 1;
    }

    C0997n(int i, String str, String str2) {
        this.xM = i;
        this.alc = str;
        this.description = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0556o.m1794a(this, dest, flags);
    }
}
