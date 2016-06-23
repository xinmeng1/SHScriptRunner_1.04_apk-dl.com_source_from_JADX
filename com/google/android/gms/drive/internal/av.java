package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;
import java.util.List;

public class av implements Creator<SetResourceParentsRequest> {
    static void m335a(SetResourceParentsRequest setResourceParentsRequest, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, setResourceParentsRequest.xM);
        C0200b.m243a(parcel, 2, setResourceParentsRequest.JF, i, false);
        C0200b.m258b(parcel, 3, setResourceParentsRequest.JG, false);
        C0200b.m235G(parcel, C);
    }

    public SetResourceParentsRequest aw(Parcel parcel) {
        List list = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < B) {
            DriveId driveId2;
            int g;
            ArrayList c;
            int A = C0199a.m194A(parcel);
            List list2;
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    List list3 = list;
                    driveId2 = driveId;
                    g = C0199a.m212g(parcel, A);
                    list2 = list3;
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    g = i;
                    DriveId driveId3 = (DriveId) C0199a.m201a(parcel, A, DriveId.CREATOR);
                    list2 = list;
                    driveId2 = driveId3;
                    break;
                case DetectedActivity.STILL /*3*/:
                    c = C0199a.m207c(parcel, A, DriveId.CREATOR);
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    c = list;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            Object obj = c;
        }
        if (parcel.dataPosition() == B) {
            return new SetResourceParentsRequest(i, driveId, list);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public SetResourceParentsRequest[] bs(int i) {
        return new SetResourceParentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bs(x0);
    }
}
