package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.internal.h */
public class C0245h implements Creator<LogicalFilter> {
    static void m380a(LogicalFilter logicalFilter, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, logicalFilter.xM);
        C0200b.m243a(parcel, 1, logicalFilter.KL, i, false);
        C0200b.m258b(parcel, 2, logicalFilter.KY, false);
        C0200b.m235G(parcel, C);
    }

    public LogicalFilter aL(Parcel parcel) {
        List list = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < B) {
            int i2;
            Operator operator2;
            ArrayList c;
            int A = C0199a.m194A(parcel);
            List list2;
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = i;
                    Operator operator3 = (Operator) C0199a.m201a(parcel, A, Operator.CREATOR);
                    list2 = list;
                    operator2 = operator3;
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    c = C0199a.m207c(parcel, A, FilterHolder.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    List list3 = list;
                    operator2 = operator;
                    i2 = C0199a.m212g(parcel, A);
                    list2 = list3;
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    c = list;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            Object obj = c;
        }
        if (parcel.dataPosition() == B) {
            return new LogicalFilter(i, operator, list);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public LogicalFilter[] bH(int i) {
        return new LogicalFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bH(x0);
    }
}
