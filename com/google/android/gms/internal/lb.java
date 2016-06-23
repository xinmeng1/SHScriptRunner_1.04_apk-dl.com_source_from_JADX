package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.internal.ks.C1139g;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.Set;

public class lb implements Creator<C1139g> {
    static void m1338a(C1139g c1139g, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        Set kk = c1139g.kk();
        if (kk.contains(Integer.valueOf(1))) {
            C0200b.m259c(parcel, 1, c1139g.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            C0200b.m250a(parcel, 2, c1139g.isPrimary());
        }
        if (kk.contains(Integer.valueOf(3))) {
            C0200b.m247a(parcel, 3, c1139g.getValue(), true);
        }
        C0200b.m235G(parcel, C);
    }

    public C1139g bO(Parcel parcel) {
        boolean z = false;
        int B = C0199a.m196B(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    z = C0199a.m208c(parcel, A);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C1139g(hashSet, i, z, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bO(x0);
    }

    public C1139g[] dl(int i) {
        return new C1139g[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dl(x0);
    }
}
