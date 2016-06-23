package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.plus.internal.f */
public class C0461f implements Creator<PlusCommonExtras> {
    static void m1579a(PlusCommonExtras plusCommonExtras, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m247a(parcel, 1, plusCommonExtras.jX(), false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, plusCommonExtras.getVersionCode());
        C0200b.m247a(parcel, 2, plusCommonExtras.jY(), false);
        C0200b.m235G(parcel, C);
    }

    public PlusCommonExtras bC(Parcel parcel) {
        String str = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
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
            return new PlusCommonExtras(i, str2, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public PlusCommonExtras[] cZ(int i) {
        return new PlusCommonExtras[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cZ(x0);
    }
}
