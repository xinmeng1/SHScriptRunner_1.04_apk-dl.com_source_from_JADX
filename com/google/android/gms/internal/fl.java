package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class fl implements Creator<fk> {
    static void m1063a(fk fkVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m247a(parcel, 1, fkVar.xU, false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, fkVar.xM);
        C0200b.m243a(parcel, 3, fkVar.xV, i, false);
        C0200b.m259c(parcel, 4, fkVar.xW);
        C0200b.m251a(parcel, 5, fkVar.xX, false);
        C0200b.m235G(parcel, C);
    }

    public fk[] m1064F(int i) {
        return new fk[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1065n(x0);
    }

    public fk m1065n(Parcel parcel) {
        byte[] bArr = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        int i2 = -1;
        fp fpVar = null;
        String str = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    fpVar = (fp) C0199a.m201a(parcel, A, fp.CREATOR);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    bArr = C0199a.m223r(parcel, A);
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
            return new fk(i, str, fpVar, i2, bArr);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1064F(x0);
    }
}
