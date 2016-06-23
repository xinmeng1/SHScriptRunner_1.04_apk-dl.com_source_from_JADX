package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.b */
public class C0237b implements Creator<SortOrder> {
    static void m372a(SortOrder sortOrder, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, sortOrder.xM);
        C0200b.m258b(parcel, 1, sortOrder.KK, false);
        C0200b.m235G(parcel, C);
    }

    public SortOrder aE(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    list = C0199a.m207c(parcel, A, FieldWithSortOrder.CREATOR);
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
            return new SortOrder(i, list);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public SortOrder[] bA(int i) {
        return new SortOrder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aE(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bA(x0);
    }
}
