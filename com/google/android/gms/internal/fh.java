package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class fh implements Creator<fg> {
    static void m1057a(fg fgVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m253a(parcel, 1, fgVar.xN, i, false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, fgVar.xM);
        C0200b.m247a(parcel, 2, fgVar.xO, false);
        C0200b.m250a(parcel, 3, fgVar.xP);
        C0200b.m235G(parcel, C);
    }

    public fg[] m1058D(int i) {
        return new fg[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1059l(x0);
    }

    public fg m1059l(Parcel parcel) {
        String str = null;
        boolean z = false;
        int B = C0199a.m196B(parcel);
        fk[] fkVarArr = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int i2;
            fk[] fkVarArr2;
            boolean z2;
            String str2;
            int A = C0199a.m194A(parcel);
            boolean z3;
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = i;
                    String str3 = str;
                    fkVarArr2 = (fk[]) C0199a.m206b(parcel, A, fk.CREATOR);
                    z2 = z;
                    str2 = str3;
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    fkVarArr2 = fkVarArr;
                    i2 = i;
                    z3 = z;
                    str2 = C0199a.m220o(parcel, A);
                    z2 = z3;
                    break;
                case DetectedActivity.STILL /*3*/:
                    z2 = C0199a.m208c(parcel, A);
                    str2 = str;
                    fkVarArr2 = fkVarArr;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    z3 = z;
                    str2 = str;
                    fkVarArr2 = fkVarArr;
                    i2 = C0199a.m212g(parcel, A);
                    z2 = z3;
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    z2 = z;
                    str2 = str;
                    fkVarArr2 = fkVarArr;
                    i2 = i;
                    break;
            }
            i = i2;
            fkVarArr = fkVarArr2;
            str = str2;
            z = z2;
        }
        if (parcel.dataPosition() == B) {
            return new fg(i, fkVarArr, str, z);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1058D(x0);
    }
}
