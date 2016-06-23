package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.internal.ib.C0786a;
import com.google.android.gms.internal.ib.C0787b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

public class id implements Creator<C0786a> {
    static void m1260a(C0786a c0786a, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, c0786a.versionCode);
        C0200b.m247a(parcel, 2, c0786a.className, false);
        C0200b.m258b(parcel, 3, c0786a.Ho, false);
        C0200b.m235G(parcel, C);
    }

    public C0786a m1261K(Parcel parcel) {
        ArrayList arrayList = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
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
                    arrayList = C0199a.m207c(parcel, A, C0787b.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0786a(i, str, arrayList);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public C0786a[] az(int i) {
        return new C0786a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1261K(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return az(x0);
    }
}
