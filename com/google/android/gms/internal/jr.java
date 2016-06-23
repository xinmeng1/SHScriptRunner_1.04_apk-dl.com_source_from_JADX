package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.wearable.DataEvent;

public class jr implements Creator<jq> {
    static void m1310a(jq jqVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, jqVar.xM);
        C0200b.m243a(parcel, 2, jqVar.jf(), i, false);
        C0200b.m239a(parcel, 3, jqVar.getInterval());
        C0200b.m259c(parcel, 4, jqVar.getPriority());
        C0200b.m235G(parcel, C);
    }

    public jq bx(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        jm jmVar = null;
        long j = jq.Wm;
        int i2 = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_DELETED /*2*/:
                    jmVar = (jm) C0199a.m201a(parcel, A, jm.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i2 = C0199a.m212g(parcel, A);
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
            return new jq(i, jmVar, j, i2);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public jq[] cS(int i) {
        return new jq[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bx(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cS(x0);
    }
}
