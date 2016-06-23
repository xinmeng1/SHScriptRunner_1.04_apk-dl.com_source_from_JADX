package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.l */
public final class C0996l implements SafeParcelable {
    public static final Creator<C0996l> CREATOR;
    long ala;
    long alb;
    private final int xM;

    static {
        CREATOR = new C0555m();
    }

    C0996l() {
        this.xM = 1;
    }

    C0996l(int i, long j, long j2) {
        this.xM = i;
        this.ala = j;
        this.alb = j2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0555m.m1793a(this, dest, flags);
    }
}
