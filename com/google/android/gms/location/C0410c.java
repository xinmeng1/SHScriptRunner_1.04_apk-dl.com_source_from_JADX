package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.location.c */
public class C0410c implements Creator<C0832b> {
    static void m1479a(C0832b c0832b, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, c0832b.Vq);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, c0832b.getVersionCode());
        C0200b.m259c(parcel, 2, c0832b.Vr);
        C0200b.m239a(parcel, 3, c0832b.Vs);
        C0200b.m235G(parcel, C);
    }

    public C0832b bs(Parcel parcel) {
        int i = 1;
        int B = C0199a.m196B(parcel);
        int i2 = 0;
        long j = 0;
        int i3 = 1;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j = C0199a.m214i(parcel, A);
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
            return new C0832b(i2, i3, i, j);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public C0832b[] cL(int i) {
        return new C0832b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bs(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cL(x0);
    }
}
