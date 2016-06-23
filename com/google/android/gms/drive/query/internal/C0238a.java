package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.query.internal.a */
public class C0238a implements Creator<ComparisonFilter> {
    static void m373a(ComparisonFilter comparisonFilter, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, comparisonFilter.xM);
        C0200b.m243a(parcel, 1, comparisonFilter.KL, i, false);
        C0200b.m243a(parcel, 2, comparisonFilter.KM, i, false);
        C0200b.m235G(parcel, C);
    }

    public ComparisonFilter aF(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < B) {
            int i2;
            MetadataBundle metadataBundle2;
            Operator operator2;
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = i;
                    Operator operator3 = (Operator) C0199a.m201a(parcel, A, Operator.CREATOR);
                    metadataBundle2 = metadataBundle;
                    operator2 = operator3;
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    metadataBundle2 = (MetadataBundle) C0199a.m201a(parcel, A, MetadataBundle.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    operator2 = operator;
                    i2 = C0199a.m212g(parcel, A);
                    metadataBundle2 = metadataBundle3;
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    metadataBundle2 = metadataBundle;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == B) {
            return new ComparisonFilter(i, operator, metadataBundle);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public ComparisonFilter[] bB(int i) {
        return new ComparisonFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bB(x0);
    }
}
