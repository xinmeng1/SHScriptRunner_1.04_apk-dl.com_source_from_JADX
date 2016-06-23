package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.internal.ks.C1136c;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.Set;

public class ky implements Creator<C1136c> {
    static void m1335a(C1136c c1136c, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        Set kk = c1136c.kk();
        if (kk.contains(Integer.valueOf(1))) {
            C0200b.m259c(parcel, 1, c1136c.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            C0200b.m247a(parcel, 2, c1136c.getUrl(), true);
        }
        C0200b.m235G(parcel, C);
    }

    public C1136c bL(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(2));
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C1136c(hashSet, i, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bL(x0);
    }

    public C1136c[] di(int i) {
        return new C1136c[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return di(x0);
    }
}
