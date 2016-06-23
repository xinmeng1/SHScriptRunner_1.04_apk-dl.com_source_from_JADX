package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.d */
public final class C0986d implements SafeParcelable {
    public static final Creator<C0986d> CREATOR;
    LoyaltyWalletObject aiO;
    OfferWalletObject aiP;
    private final int xM;

    static {
        CREATOR = new C0529e();
    }

    C0986d() {
        this.xM = 2;
    }

    C0986d(int i, LoyaltyWalletObject loyaltyWalletObject, OfferWalletObject offerWalletObject) {
        this.xM = i;
        this.aiO = loyaltyWalletObject;
        this.aiP = offerWalletObject;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0529e.m1753a(this, dest, flags);
    }
}
