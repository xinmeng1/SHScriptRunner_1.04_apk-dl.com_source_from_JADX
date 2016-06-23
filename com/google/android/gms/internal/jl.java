package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class jl implements Creator<jk> {
    static void m1307a(jk jkVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, jkVar.jc());
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, jkVar.getVersionCode());
        C0200b.m259c(parcel, 2, jkVar.je());
        C0200b.m243a(parcel, 3, jkVar.jf(), i, false);
        C0200b.m235G(parcel, C);
    }

    public jk bu(Parcel parcel) {
        int i = 0;
        int B = C0199a.m196B(parcel);
        int i2 = -1;
        jm jmVar = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    jmVar = (jm) C0199a.m201a(parcel, A, jm.CREATOR);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new jk(i3, i, i2, jmVar);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public jk[] cP(int i) {
        return new jk[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bu(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cP(x0);
    }
}
