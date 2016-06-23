package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

public class jn implements Creator<jm> {
    static void m1308a(jm jmVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m258b(parcel, 1, jmVar.Wc, false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, jmVar.xM);
        C0200b.m247a(parcel, 2, jmVar.jg(), false);
        C0200b.m250a(parcel, 3, jmVar.jh());
        C0200b.m258b(parcel, 4, jmVar.Wf, false);
        C0200b.m247a(parcel, 5, jmVar.ji(), false);
        C0200b.m248a(parcel, 6, jmVar.Wh, false);
        C0200b.m235G(parcel, C);
    }

    public jm bv(Parcel parcel) {
        boolean z = false;
        List list = null;
        int B = C0199a.m196B(parcel);
        String str = null;
        List list2 = null;
        String str2 = null;
        List list3 = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    list3 = C0199a.m207c(parcel, A, js.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    list2 = C0199a.m207c(parcel, A, jw.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    list = C0199a.m197B(parcel, A);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new jm(i, list3, str2, z, list2, str, list);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public jm[] cQ(int i) {
        return new jm[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bv(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cQ(x0);
    }
}
