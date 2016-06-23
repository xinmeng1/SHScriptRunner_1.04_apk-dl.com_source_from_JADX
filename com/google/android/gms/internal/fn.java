package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class fn implements Creator<fm> {
    static void m1066a(fm fmVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, fmVar.id);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, fmVar.xM);
        C0200b.m240a(parcel, 2, fmVar.xY, false);
        C0200b.m235G(parcel, C);
    }

    public fm[] m1067G(int i) {
        return new fm[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1068o(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1067G(x0);
    }

    public fm m1068o(Parcel parcel) {
        int i = 0;
        int B = C0199a.m196B(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    bundle = C0199a.m222q(parcel, A);
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
            return new fm(i2, i, bundle);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }
}
