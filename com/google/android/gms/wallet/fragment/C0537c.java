package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.fragment.c */
public class C0537c implements Creator<WalletFragmentStyle> {
    static void m1777a(WalletFragmentStyle walletFragmentStyle, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, walletFragmentStyle.xM);
        C0200b.m240a(parcel, 2, walletFragmentStyle.akE, false);
        C0200b.m259c(parcel, 3, walletFragmentStyle.akF);
        C0200b.m235G(parcel, C);
    }

    public WalletFragmentStyle ci(Parcel parcel) {
        int i = 0;
        int B = C0199a.m196B(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    bundle = C0199a.m222q(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new WalletFragmentStyle(i2, bundle, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ci(x0);
    }

    public WalletFragmentStyle[] dP(int i) {
        return new WalletFragmentStyle[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dP(x0);
    }
}
