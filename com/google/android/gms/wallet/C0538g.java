package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.g */
public class C0538g implements Creator<FullWalletRequest> {
    static void m1778a(FullWalletRequest fullWalletRequest, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, fullWalletRequest.getVersionCode());
        C0200b.m247a(parcel, 2, fullWalletRequest.aiQ, false);
        C0200b.m247a(parcel, 3, fullWalletRequest.aiR, false);
        C0200b.m243a(parcel, 4, fullWalletRequest.aja, i, false);
        C0200b.m235G(parcel, C);
    }

    public FullWalletRequest bV(Parcel parcel) {
        Cart cart = null;
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
                    cart = (Cart) C0199a.m201a(parcel, A, Cart.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new FullWalletRequest(i, str2, str, cart);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bV(x0);
    }

    public FullWalletRequest[] dB(int i) {
        return new FullWalletRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dB(x0);
    }
}
