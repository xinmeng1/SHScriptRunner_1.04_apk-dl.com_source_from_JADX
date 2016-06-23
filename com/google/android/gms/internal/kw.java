package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.internal.ks.C1135b.C1133a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.Set;

public class kw implements Creator<C1133a> {
    static void m1333a(C1133a c1133a, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        Set kk = c1133a.kk();
        if (kk.contains(Integer.valueOf(1))) {
            C0200b.m259c(parcel, 1, c1133a.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            C0200b.m259c(parcel, 2, c1133a.getLeftImageOffset());
        }
        if (kk.contains(Integer.valueOf(3))) {
            C0200b.m259c(parcel, 3, c1133a.getTopImageOffset());
        }
        C0200b.m235G(parcel, C);
    }

    public C1133a bJ(Parcel parcel) {
        int i = 0;
        int B = C0199a.m196B(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0199a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i2 = C0199a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0199a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C1133a(hashSet, i3, i2, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bJ(x0);
    }

    public C1133a[] dg(int i) {
        return new C1133a[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dg(x0);
    }
}
