package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.internal.ks.C1135b.C1134b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.Set;

public class kx implements Creator<C1134b> {
    static void m1334a(C1134b c1134b, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        Set kk = c1134b.kk();
        if (kk.contains(Integer.valueOf(1))) {
            C0200b.m259c(parcel, 1, c1134b.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            C0200b.m259c(parcel, 2, c1134b.getHeight());
        }
        if (kk.contains(Integer.valueOf(3))) {
            C0200b.m247a(parcel, 3, c1134b.getUrl(), true);
        }
        if (kk.contains(Integer.valueOf(4))) {
            C0200b.m259c(parcel, 4, c1134b.getWidth());
        }
        C0200b.m235G(parcel, C);
    }

    public C1134b bK(Parcel parcel) {
        int i = 0;
        int B = C0199a.m196B(parcel);
        Set hashSet = new HashSet();
        String str = null;
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
                    str = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i = C0199a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C1134b(hashSet, i3, i2, str, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bK(x0);
    }

    public C1134b[] dh(int i) {
        return new C1134b[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dh(x0);
    }
}
