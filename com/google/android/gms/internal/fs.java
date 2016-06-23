package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class fs implements Creator<fr> {
    static void m1078a(fr frVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m243a(parcel, 1, frVar.yq, i, false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, frVar.xM);
        C0200b.m239a(parcel, 2, frVar.yr);
        C0200b.m259c(parcel, 3, frVar.ys);
        C0200b.m247a(parcel, 4, frVar.mP, false);
        C0200b.m243a(parcel, 5, frVar.yt, i, false);
        C0200b.m235G(parcel, C);
    }

    public fr[] m1079K(int i) {
        return new fr[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1080q(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1079K(x0);
    }

    public fr m1080q(Parcel parcel) {
        int i = 0;
        fg fgVar = null;
        int B = C0199a.m196B(parcel);
        long j = 0;
        String str = null;
        fi fiVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    fiVar = (fi) C0199a.m201a(parcel, A, fi.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    fgVar = (fg) C0199a.m201a(parcel, A, fg.CREATOR);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new fr(i2, fiVar, j, i, str, fgVar);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }
}
