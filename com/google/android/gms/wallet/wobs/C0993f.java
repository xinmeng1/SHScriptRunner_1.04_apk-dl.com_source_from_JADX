package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.f */
public final class C0993f implements SafeParcelable {
    public static final Creator<C0993f> CREATOR;
    C0996l ajs;
    C0994g akS;
    String label;
    String type;
    private final int xM;

    static {
        CREATOR = new C0553i();
    }

    C0993f() {
        this.xM = 1;
    }

    C0993f(int i, String str, C0994g c0994g, String str2, C0996l c0996l) {
        this.xM = i;
        this.label = str;
        this.akS = c0994g;
        this.type = str2;
        this.ajs = c0996l;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0553i.m1791a(this, dest, flags);
    }
}
