package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wallet.wobs.CommonWalletObject;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.n */
public class C0545n implements Creator<OfferWalletObject> {
    static void m1785a(OfferWalletObject offerWalletObject, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, offerWalletObject.getVersionCode());
        C0200b.m247a(parcel, 2, offerWalletObject.eC, false);
        C0200b.m247a(parcel, 3, offerWalletObject.ajT, false);
        C0200b.m243a(parcel, 4, offerWalletObject.ajU, i, false);
        C0200b.m235G(parcel, C);
    }

    public OfferWalletObject cc(Parcel parcel) {
        CommonWalletObject commonWalletObject = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    commonWalletObject = (CommonWalletObject) C0199a.m201a(parcel, A, CommonWalletObject.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new OfferWalletObject(i, str2, str, commonWalletObject);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cc(x0);
    }

    public OfferWalletObject[] dI(int i) {
        return new OfferWalletObject[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dI(x0);
    }
}
