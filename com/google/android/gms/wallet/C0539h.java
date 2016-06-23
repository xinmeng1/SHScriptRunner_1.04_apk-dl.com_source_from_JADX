package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.h */
public class C0539h implements Creator<InstrumentInfo> {
    static void m1779a(InstrumentInfo instrumentInfo, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, instrumentInfo.getVersionCode());
        C0200b.m247a(parcel, 2, instrumentInfo.getInstrumentType(), false);
        C0200b.m247a(parcel, 3, instrumentInfo.getInstrumentDetails(), false);
        C0200b.m235G(parcel, C);
    }

    public InstrumentInfo bW(Parcel parcel) {
        String str = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
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
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new InstrumentInfo(i, str2, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bW(x0);
    }

    public InstrumentInfo[] dC(int i) {
        return new InstrumentInfo[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dC(x0);
    }
}
