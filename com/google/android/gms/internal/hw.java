package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.internal.hv.C0784a;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

public class hw implements Creator<hv> {
    static void m1244a(hv hvVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, hvVar.getVersionCode());
        C0200b.m258b(parcel, 2, hvVar.fD(), false);
        C0200b.m235G(parcel, C);
    }

    public hv m1245F(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    arrayList = C0199a.m207c(parcel, A, C0784a.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new hv(i, arrayList);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public hv[] au(int i) {
        return new hv[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1245F(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return au(x0);
    }
}
