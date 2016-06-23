package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.query.internal.b */
public class C0239b implements Creator<FieldOnlyFilter> {
    static void m374a(FieldOnlyFilter fieldOnlyFilter, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, fieldOnlyFilter.xM);
        C0200b.m243a(parcel, 1, fieldOnlyFilter.KM, i, false);
        C0200b.m235G(parcel, C);
    }

    public FieldOnlyFilter aG(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    metadataBundle = (MetadataBundle) C0199a.m201a(parcel, A, MetadataBundle.CREATOR);
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
            return new FieldOnlyFilter(i, metadataBundle);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public FieldOnlyFilter[] bC(int i) {
        return new FieldOnlyFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aG(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bC(x0);
    }
}
