package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.p */
public final class C0998p implements SafeParcelable {
    public static final Creator<C0998p> CREATOR;
    String akZ;
    C0996l ald;
    C0997n ale;
    C0997n alf;
    String qe;
    private final int xM;

    static {
        CREATOR = new C0557q();
    }

    C0998p() {
        this.xM = 1;
    }

    C0998p(int i, String str, String str2, C0996l c0996l, C0997n c0997n, C0997n c0997n2) {
        this.xM = i;
        this.akZ = str;
        this.qe = str2;
        this.ald = c0996l;
        this.ale = c0997n;
        this.alf = c0997n2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0557q.m1795a(this, dest, flags);
    }
}
