package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.wearable.DataEvent;

public class hu implements Creator<ht> {
    static void m1242a(ht htVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, htVar.getVersionCode());
        C0200b.m243a(parcel, 2, htVar.fB(), i, false);
        C0200b.m235G(parcel, C);
    }

    public ht m1243E(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        hv hvVar = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    hvVar = (hv) C0199a.m201a(parcel, A, hv.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ht(i, hvVar);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public ht[] at(int i) {
        return new ht[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1243E(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return at(x0);
    }
}
