package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.wearable.DataEvent;

public class lh implements Creator<lg> {
    static void m1340a(lg lgVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, lgVar.getVersionCode());
        C0200b.m252a(parcel, 2, lgVar.akd, false);
        C0200b.m235G(parcel, C);
    }

    public lg ce(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        int[] iArr = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    iArr = C0199a.m226u(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new lg(i, iArr);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ce(x0);
    }

    public lg[] dK(int i) {
        return new lg[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dK(x0);
    }
}
