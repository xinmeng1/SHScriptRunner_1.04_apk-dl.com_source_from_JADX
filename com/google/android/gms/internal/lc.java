package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.internal.ks.C1140h;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.Set;

public class lc implements Creator<C1140h> {
    static void m1339a(C1140h c1140h, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        Set kk = c1140h.kk();
        if (kk.contains(Integer.valueOf(1))) {
            C0200b.m259c(parcel, 1, c1140h.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(3))) {
            C0200b.m259c(parcel, 3, c1140h.kX());
        }
        if (kk.contains(Integer.valueOf(4))) {
            C0200b.m247a(parcel, 4, c1140h.getValue(), true);
        }
        if (kk.contains(Integer.valueOf(5))) {
            C0200b.m247a(parcel, 5, c1140h.getLabel(), true);
        }
        if (kk.contains(Integer.valueOf(6))) {
            C0200b.m259c(parcel, 6, c1140h.getType());
        }
        C0200b.m235G(parcel, C);
    }

    public C1140h bP(Parcel parcel) {
        String str = null;
        int i = 0;
        int B = C0199a.m196B(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0199a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0199a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str2 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Quest.STATE_FAILED /*6*/:
                    i2 = C0199a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C1140h(hashSet, i3, str2, i2, str, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bP(x0);
    }

    public C1140h[] dm(int i) {
        return new C1140h[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dm(x0);
    }
}
