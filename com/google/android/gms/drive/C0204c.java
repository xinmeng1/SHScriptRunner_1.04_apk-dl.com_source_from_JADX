package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.c */
public class C0204c implements Creator<DriveId> {
    static void m264a(DriveId driveId, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, driveId.xM);
        C0200b.m247a(parcel, 2, driveId.HN, false);
        C0200b.m239a(parcel, 3, driveId.HO);
        C0200b.m239a(parcel, 4, driveId.HP);
        C0200b.m235G(parcel, C);
    }

    public DriveId m265N(Parcel parcel) {
        long j = 0;
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str = null;
        long j2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j2 = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new DriveId(i, str, j2, j);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public DriveId[] aH(int i) {
        return new DriveId[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m265N(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aH(x0);
    }
}
