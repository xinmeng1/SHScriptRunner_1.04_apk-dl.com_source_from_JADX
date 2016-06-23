package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class jx implements Creator<jw> {
    static void m1313a(jw jwVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m247a(parcel, 1, jwVar.qX, false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, jwVar.xM);
        C0200b.m259c(parcel, 2, jwVar.YS);
        C0200b.m235G(parcel, C);
    }

    public jw bA(Parcel parcel) {
        int i = 0;
        int B = C0199a.m196B(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new jw(i2, str, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public jw[] cV(int i) {
        return new jw[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cV(x0);
    }
}
