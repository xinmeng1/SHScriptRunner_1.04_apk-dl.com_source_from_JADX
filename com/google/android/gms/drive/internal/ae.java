package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class ae implements Creator<LoadRealtimeRequest> {
    static void m319a(LoadRealtimeRequest loadRealtimeRequest, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, loadRealtimeRequest.xM);
        C0200b.m243a(parcel, 2, loadRealtimeRequest.Hz, i, false);
        C0200b.m250a(parcel, 3, loadRealtimeRequest.Js);
        C0200b.m235G(parcel, C);
    }

    public LoadRealtimeRequest ag(Parcel parcel) {
        boolean z = false;
        int B = C0199a.m196B(parcel);
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            DriveId driveId2;
            int g;
            boolean z2;
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    boolean z3 = z;
                    driveId2 = driveId;
                    g = C0199a.m212g(parcel, A);
                    z2 = z3;
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    g = i;
                    DriveId driveId3 = (DriveId) C0199a.m201a(parcel, A, DriveId.CREATOR);
                    z2 = z;
                    driveId2 = driveId3;
                    break;
                case DetectedActivity.STILL /*3*/:
                    z2 = C0199a.m208c(parcel, A);
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    z2 = z;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            z = z2;
        }
        if (parcel.dataPosition() == B) {
            return new LoadRealtimeRequest(i, driveId, z);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public LoadRealtimeRequest[] bc(int i) {
        return new LoadRealtimeRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ag(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bc(x0);
    }
}
