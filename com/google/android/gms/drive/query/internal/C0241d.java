package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.query.internal.d */
public class C0241d implements Creator<FilterHolder> {
    static void m376a(FilterHolder filterHolder, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m243a(parcel, 1, filterHolder.KP, i, false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, filterHolder.xM);
        C0200b.m243a(parcel, 2, filterHolder.KQ, i, false);
        C0200b.m243a(parcel, 3, filterHolder.KR, i, false);
        C0200b.m243a(parcel, 4, filterHolder.KS, i, false);
        C0200b.m243a(parcel, 5, filterHolder.KT, i, false);
        C0200b.m243a(parcel, 6, filterHolder.KU, i, false);
        C0200b.m243a(parcel, 7, filterHolder.KV, i, false);
        C0200b.m235G(parcel, C);
    }

    public FilterHolder aI(Parcel parcel) {
        HasFilter hasFilter = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        MatchAllFilter matchAllFilter = null;
        InFilter inFilter = null;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter comparisonFilter = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    comparisonFilter = (ComparisonFilter) C0199a.m201a(parcel, A, ComparisonFilter.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    fieldOnlyFilter = (FieldOnlyFilter) C0199a.m201a(parcel, A, FieldOnlyFilter.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    logicalFilter = (LogicalFilter) C0199a.m201a(parcel, A, LogicalFilter.CREATOR);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    notFilter = (NotFilter) C0199a.m201a(parcel, A, NotFilter.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    inFilter = (InFilter) C0199a.m201a(parcel, A, InFilter.CREATOR);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    matchAllFilter = (MatchAllFilter) C0199a.m201a(parcel, A, MatchAllFilter.CREATOR);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    hasFilter = (HasFilter) C0199a.m201a(parcel, A, HasFilter.CREATOR);
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
            return new FilterHolder(i, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter, matchAllFilter, hasFilter);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public FilterHolder[] bE(int i) {
        return new FilterHolder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aI(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bE(x0);
    }
}
