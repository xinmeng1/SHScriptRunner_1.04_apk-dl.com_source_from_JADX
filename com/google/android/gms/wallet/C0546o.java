package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.o */
public class C0546o implements Creator<ProxyCard> {
    static void m1786a(ProxyCard proxyCard, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, proxyCard.getVersionCode());
        C0200b.m247a(parcel, 2, proxyCard.ajV, false);
        C0200b.m247a(parcel, 3, proxyCard.ajW, false);
        C0200b.m259c(parcel, 4, proxyCard.ajX);
        C0200b.m259c(parcel, 5, proxyCard.ajY);
        C0200b.m235G(parcel, C);
    }

    public ProxyCard cd(Parcel parcel) {
        String str = null;
        int i = 0;
        int B = C0199a.m196B(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i2 = C0199a.m212g(parcel, A);
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
            return new ProxyCard(i3, str2, str, i2, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cd(x0);
    }

    public ProxyCard[] dJ(int i) {
        return new ProxyCard[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dJ(x0);
    }
}
