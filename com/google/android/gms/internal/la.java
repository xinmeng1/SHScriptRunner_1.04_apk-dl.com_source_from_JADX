package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.internal.ks.C1138f;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.Set;

public class la implements Creator<C1138f> {
    static void m1337a(C1138f c1138f, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        Set kk = c1138f.kk();
        if (kk.contains(Integer.valueOf(1))) {
            C0200b.m259c(parcel, 1, c1138f.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            C0200b.m247a(parcel, 2, c1138f.getDepartment(), true);
        }
        if (kk.contains(Integer.valueOf(3))) {
            C0200b.m247a(parcel, 3, c1138f.getDescription(), true);
        }
        if (kk.contains(Integer.valueOf(4))) {
            C0200b.m247a(parcel, 4, c1138f.getEndDate(), true);
        }
        if (kk.contains(Integer.valueOf(5))) {
            C0200b.m247a(parcel, 5, c1138f.getLocation(), true);
        }
        if (kk.contains(Integer.valueOf(6))) {
            C0200b.m247a(parcel, 6, c1138f.getName(), true);
        }
        if (kk.contains(Integer.valueOf(7))) {
            C0200b.m250a(parcel, 7, c1138f.isPrimary());
        }
        if (kk.contains(Integer.valueOf(8))) {
            C0200b.m247a(parcel, 8, c1138f.getStartDate(), true);
        }
        if (kk.contains(Integer.valueOf(9))) {
            C0200b.m247a(parcel, 9, c1138f.getTitle(), true);
        }
        if (kk.contains(Integer.valueOf(10))) {
            C0200b.m259c(parcel, 10, c1138f.getType());
        }
        C0200b.m235G(parcel, C);
    }

    public C1138f bN(Parcel parcel) {
        int i = 0;
        String str = null;
        int B = C0199a.m196B(parcel);
        Set hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0199a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str7 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case DetectedActivity.STILL /*3*/:
                    str6 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str5 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str4 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Quest.STATE_FAILED /*6*/:
                    str3 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case DetectedActivity.WALKING /*7*/:
                    z = C0199a.m208c(parcel, A);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    str2 = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    str = C0199a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    i = C0199a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C1138f(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bN(x0);
    }

    public C1138f[] dk(int i) {
        return new C1138f[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dk(x0);
    }
}
