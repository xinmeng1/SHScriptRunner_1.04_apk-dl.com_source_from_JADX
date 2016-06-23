package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.internal.y */
public class C0226y implements Creator<GetDriveIdFromUniqueIdentifierRequest> {
    static void m360a(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, getDriveIdFromUniqueIdentifierRequest.xM);
        C0200b.m247a(parcel, 2, getDriveIdFromUniqueIdentifierRequest.Jp, false);
        C0200b.m250a(parcel, 3, getDriveIdFromUniqueIdentifierRequest.Jq);
        C0200b.m235G(parcel, C);
    }

    public GetDriveIdFromUniqueIdentifierRequest[] aZ(int i) {
        return new GetDriveIdFromUniqueIdentifierRequest[i];
    }

    public GetDriveIdFromUniqueIdentifierRequest ad(Parcel parcel) {
        boolean z = false;
        int B = C0199a.m196B(parcel);
        String str = null;
        int i = 0;
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
                    z = C0199a.m208c(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new GetDriveIdFromUniqueIdentifierRequest(i, str, z);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ad(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aZ(x0);
    }
}
