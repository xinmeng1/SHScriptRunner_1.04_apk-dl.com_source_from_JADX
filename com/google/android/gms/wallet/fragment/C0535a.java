package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.fragment.a */
public class C0535a implements Creator<WalletFragmentInitParams> {
    static void m1775a(WalletFragmentInitParams walletFragmentInitParams, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, walletFragmentInitParams.xM);
        C0200b.m247a(parcel, 2, walletFragmentInitParams.getAccountName(), false);
        C0200b.m243a(parcel, 3, walletFragmentInitParams.getMaskedWalletRequest(), i, false);
        C0200b.m259c(parcel, 4, walletFragmentInitParams.getMaskedWalletRequestCode());
        C0200b.m243a(parcel, 5, walletFragmentInitParams.getMaskedWallet(), i, false);
        C0200b.m235G(parcel, C);
    }

    public WalletFragmentInitParams cg(Parcel parcel) {
        MaskedWallet maskedWallet = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        int i2 = -1;
        MaskedWalletRequest maskedWalletRequest = null;
        String str = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    maskedWalletRequest = (MaskedWalletRequest) C0199a.m201a(parcel, A, MaskedWalletRequest.CREATOR);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    maskedWallet = (MaskedWallet) C0199a.m201a(parcel, A, MaskedWallet.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new WalletFragmentInitParams(i, str, maskedWalletRequest, i2, maskedWallet);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cg(x0);
    }

    public WalletFragmentInitParams[] dN(int i) {
        return new WalletFragmentInitParams[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dN(x0);
    }
}
