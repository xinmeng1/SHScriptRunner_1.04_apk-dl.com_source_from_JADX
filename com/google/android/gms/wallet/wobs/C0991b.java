package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.b */
public final class C0991b implements SafeParcelable {
    public static final Creator<C0991b> CREATOR;
    String label;
    String value;
    private final int xM;

    static {
        CREATOR = new C0550c();
    }

    C0991b() {
        this.xM = 1;
    }

    C0991b(int i, String str, String str2) {
        this.xM = i;
        this.label = str;
        this.value = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0550c.m1788a(this, dest, flags);
    }
}
