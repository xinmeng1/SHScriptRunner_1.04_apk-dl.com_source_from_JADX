package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.query.a */
public class C0236a implements Creator<Query> {
    static void m371a(Query query, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, query.xM);
        C0200b.m243a(parcel, 1, query.KE, i, false);
        C0200b.m247a(parcel, 3, query.KF, false);
        C0200b.m243a(parcel, 4, query.KG, i, false);
        C0200b.m235G(parcel, C);
    }

    public Query aD(Parcel parcel) {
        SortOrder sortOrder = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str = null;
        LogicalFilter logicalFilter = null;
        while (parcel.dataPosition() < B) {
            int i2;
            LogicalFilter logicalFilter2;
            SortOrder sortOrder2;
            String str2;
            int A = C0199a.m194A(parcel);
            SortOrder sortOrder3;
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = i;
                    String str3 = str;
                    logicalFilter2 = (LogicalFilter) C0199a.m201a(parcel, A, LogicalFilter.CREATOR);
                    sortOrder2 = sortOrder;
                    str2 = str3;
                    break;
                case DetectedActivity.STILL /*3*/:
                    logicalFilter2 = logicalFilter;
                    i2 = i;
                    sortOrder3 = sortOrder;
                    str2 = C0199a.m220o(parcel, A);
                    sortOrder2 = sortOrder3;
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    sortOrder2 = (SortOrder) C0199a.m201a(parcel, A, SortOrder.CREATOR);
                    str2 = str;
                    logicalFilter2 = logicalFilter;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    sortOrder3 = sortOrder;
                    str2 = str;
                    logicalFilter2 = logicalFilter;
                    i2 = C0199a.m212g(parcel, A);
                    sortOrder2 = sortOrder3;
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    sortOrder2 = sortOrder;
                    str2 = str;
                    logicalFilter2 = logicalFilter;
                    i2 = i;
                    break;
            }
            i = i2;
            logicalFilter = logicalFilter2;
            str = str2;
            sortOrder = sortOrder2;
        }
        if (parcel.dataPosition() == B) {
            return new Query(i, logicalFilter, str, sortOrder);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public Query[] bz(int i) {
        return new Query[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bz(x0);
    }
}
