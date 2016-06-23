package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.query.internal.k */
public class C0248k implements Creator<Operator> {
    static void m383a(Operator operator, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, operator.xM);
        C0200b.m247a(parcel, 1, operator.mTag, false);
        C0200b.m235G(parcel, C);
    }

    public Operator aO(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str = C0199a.m220o(parcel, A);
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
            return new Operator(i, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public Operator[] bK(int i) {
        return new Operator[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bK(x0);
    }
}
