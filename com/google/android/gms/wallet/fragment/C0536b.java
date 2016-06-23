package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.fragment.b */
public class C0536b implements Creator<WalletFragmentOptions> {
    static void m1776a(WalletFragmentOptions walletFragmentOptions, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, walletFragmentOptions.xM);
        C0200b.m259c(parcel, 2, walletFragmentOptions.getEnvironment());
        C0200b.m259c(parcel, 3, walletFragmentOptions.getTheme());
        C0200b.m243a(parcel, 4, walletFragmentOptions.getFragmentStyle(), i, false);
        C0200b.m259c(parcel, 5, walletFragmentOptions.getMode());
        C0200b.m235G(parcel, C);
    }

    public WalletFragmentOptions ch(Parcel parcel) {
        int i = 1;
        int i2 = 0;
        int B = C0199a.m196B(parcel);
        WalletFragmentStyle walletFragmentStyle = null;
        int i3 = 1;
        int i4 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i4 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    walletFragmentStyle = (WalletFragmentStyle) C0199a.m201a(parcel, A, WalletFragmentStyle.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new WalletFragmentOptions(i4, i3, i2, walletFragmentStyle, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ch(x0);
    }

    public WalletFragmentOptions[] dO(int i) {
        return new WalletFragmentOptions[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dO(x0);
    }
}
