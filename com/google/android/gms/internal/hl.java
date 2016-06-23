package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.internal.gy.C0771a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

public class hl implements Creator<C0771a> {
    static void m1222a(C0771a c0771a, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m247a(parcel, 1, c0771a.getAccountName(), false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, c0771a.getVersionCode());
        C0200b.m248a(parcel, 2, c0771a.fl(), false);
        C0200b.m259c(parcel, 3, c0771a.fk());
        C0200b.m247a(parcel, 4, c0771a.fn(), false);
        C0200b.m235G(parcel, C);
    }

    public C0771a[] aq(int i) {
        return new C0771a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1223z(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aq(x0);
    }

    public C0771a m1223z(Parcel parcel) {
        int i = 0;
        String str = null;
        int B = C0199a.m196B(parcel);
        List list = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    list = C0199a.m197B(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str = C0199a.m220o(parcel, A);
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
            return new C0771a(i2, str2, list, i, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }
}
