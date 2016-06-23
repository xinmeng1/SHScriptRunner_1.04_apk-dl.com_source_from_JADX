package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.Set;

public class kq implements Creator<kp> {
    static void m1329a(kp kpVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        Set kk = kpVar.kk();
        if (kk.contains(Integer.valueOf(1))) {
            C0200b.m259c(parcel, 1, kpVar.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            C0200b.m247a(parcel, 2, kpVar.getId(), true);
        }
        if (kk.contains(Integer.valueOf(4))) {
            C0200b.m243a(parcel, 4, kpVar.kB(), i, true);
        }
        if (kk.contains(Integer.valueOf(5))) {
            C0200b.m247a(parcel, 5, kpVar.getStartDate(), true);
        }
        if (kk.contains(Integer.valueOf(6))) {
            C0200b.m243a(parcel, 6, kpVar.kC(), i, true);
        }
        if (kk.contains(Integer.valueOf(7))) {
            C0200b.m247a(parcel, 7, kpVar.getType(), true);
        }
        C0200b.m235G(parcel, C);
    }

    public kp bF(Parcel parcel) {
        String str = null;
        int B = C0199a.m196B(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        kn knVar = null;
        String str2 = null;
        kn knVar2 = null;
        String str3 = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            kn knVar3;
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str3 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    knVar3 = (kn) C0199a.m201a(parcel, A, kn.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    knVar2 = knVar3;
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str2 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Quest.STATE_FAILED /*6*/:
                    knVar3 = (kn) C0199a.m201a(parcel, A, kn.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    knVar = knVar3;
                    break;
                case DetectedActivity.WALKING /*7*/:
                    str = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new kp(hashSet, i, str3, knVar2, str2, knVar, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bF(x0);
    }

    public kp[] dc(int i) {
        return new kp[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dc(x0);
    }
}
