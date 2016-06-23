package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.query.internal.j */
public class C0247j implements Creator<NotFilter> {
    static void m382a(NotFilter notFilter, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, notFilter.xM);
        C0200b.m243a(parcel, 1, notFilter.KZ, i, false);
        C0200b.m235G(parcel, C);
    }

    public NotFilter aN(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        FilterHolder filterHolder = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    filterHolder = (FilterHolder) C0199a.m201a(parcel, A, FilterHolder.CREATOR);
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
            return new NotFilter(i, filterHolder);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public NotFilter[] bJ(int i) {
        return new NotFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bJ(x0);
    }
}
