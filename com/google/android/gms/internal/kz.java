package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.internal.ks.C1137d;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.Set;

public class kz implements Creator<C1137d> {
    static void m1336a(C1137d c1137d, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        Set kk = c1137d.kk();
        if (kk.contains(Integer.valueOf(1))) {
            C0200b.m259c(parcel, 1, c1137d.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            C0200b.m247a(parcel, 2, c1137d.getFamilyName(), true);
        }
        if (kk.contains(Integer.valueOf(3))) {
            C0200b.m247a(parcel, 3, c1137d.getFormatted(), true);
        }
        if (kk.contains(Integer.valueOf(4))) {
            C0200b.m247a(parcel, 4, c1137d.getGivenName(), true);
        }
        if (kk.contains(Integer.valueOf(5))) {
            C0200b.m247a(parcel, 5, c1137d.getHonorificPrefix(), true);
        }
        if (kk.contains(Integer.valueOf(6))) {
            C0200b.m247a(parcel, 6, c1137d.getHonorificSuffix(), true);
        }
        if (kk.contains(Integer.valueOf(7))) {
            C0200b.m247a(parcel, 7, c1137d.getMiddleName(), true);
        }
        C0200b.m235G(parcel, C);
    }

    public C1137d bM(Parcel parcel) {
        String str = null;
        int B = C0199a.m196B(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str6 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case DetectedActivity.STILL /*3*/:
                    str5 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str4 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str3 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Quest.STATE_FAILED /*6*/:
                    str2 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(6));
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
            return new C1137d(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bM(x0);
    }

    public C1137d[] dj(int i) {
        return new C1137d[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dj(x0);
    }
}
