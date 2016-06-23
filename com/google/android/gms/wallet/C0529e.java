package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.e */
public class C0529e implements Creator<C0986d> {
    static void m1753a(C0986d c0986d, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, c0986d.getVersionCode());
        C0200b.m243a(parcel, 2, c0986d.aiO, i, false);
        C0200b.m243a(parcel, 3, c0986d.aiP, i, false);
        C0200b.m235G(parcel, C);
    }

    public C0986d bT(Parcel parcel) {
        OfferWalletObject offerWalletObject = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        LoyaltyWalletObject loyaltyWalletObject = null;
        while (parcel.dataPosition() < B) {
            LoyaltyWalletObject loyaltyWalletObject2;
            int g;
            OfferWalletObject offerWalletObject2;
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    OfferWalletObject offerWalletObject3 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    g = C0199a.m212g(parcel, A);
                    offerWalletObject2 = offerWalletObject3;
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    g = i;
                    LoyaltyWalletObject loyaltyWalletObject3 = (LoyaltyWalletObject) C0199a.m201a(parcel, A, LoyaltyWalletObject.CREATOR);
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject3;
                    break;
                case DetectedActivity.STILL /*3*/:
                    offerWalletObject2 = (OfferWalletObject) C0199a.m201a(parcel, A, OfferWalletObject.CREATOR);
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    g = i;
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    g = i;
                    break;
            }
            i = g;
            loyaltyWalletObject = loyaltyWalletObject2;
            offerWalletObject = offerWalletObject2;
        }
        if (parcel.dataPosition() == B) {
            return new C0986d(i, loyaltyWalletObject, offerWalletObject);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bT(x0);
    }

    public C0986d[] dz(int i) {
        return new C0986d[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dz(x0);
    }
}
