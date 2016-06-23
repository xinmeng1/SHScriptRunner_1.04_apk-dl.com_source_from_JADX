package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.common.data.f */
public class C0189f implements Creator<DataHolder> {
    static void m165a(DataHolder dataHolder, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m254a(parcel, 1, dataHolder.eX(), false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, dataHolder.getVersionCode());
        C0200b.m253a(parcel, 2, dataHolder.eY(), i, false);
        C0200b.m259c(parcel, 3, dataHolder.getStatusCode());
        C0200b.m240a(parcel, 4, dataHolder.eU(), false);
        C0200b.m235G(parcel, C);
    }

    public DataHolder[] ag(int i) {
        return new DataHolder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m166x(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ag(x0);
    }

    public DataHolder m166x(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int B = C0199a.m196B(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    strArr = C0199a.m195A(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    cursorWindowArr = (CursorWindow[]) C0199a.m206b(parcel, A, CursorWindow.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    bundle = C0199a.m222q(parcel, A);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() != B) {
            throw new C0198a("Overread allowed size end=" + B, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.eW();
        return dataHolder;
    }
}
