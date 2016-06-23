package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ig;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.wobs.d */
public final class C0992d implements SafeParcelable {
    public static final Creator<C0992d> CREATOR;
    String akP;
    String akQ;
    ArrayList<C0991b> akR;
    private final int xM;

    static {
        CREATOR = new C0551e();
    }

    C0992d() {
        this.xM = 1;
        this.akR = ig.ga();
    }

    C0992d(int i, String str, String str2, ArrayList<C0991b> arrayList) {
        this.xM = i;
        this.akP = str;
        this.akQ = str2;
        this.akR = arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0551e.m1789a(this, dest, flags);
    }
}
