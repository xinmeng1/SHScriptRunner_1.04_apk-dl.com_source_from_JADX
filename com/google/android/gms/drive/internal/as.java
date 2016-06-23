package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class as implements Creator<OpenFileIntentSenderRequest> {
    static void m332a(OpenFileIntentSenderRequest openFileIntentSenderRequest, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, openFileIntentSenderRequest.xM);
        C0200b.m247a(parcel, 2, openFileIntentSenderRequest.HY, false);
        C0200b.m254a(parcel, 3, openFileIntentSenderRequest.HZ, false);
        C0200b.m243a(parcel, 4, openFileIntentSenderRequest.Ia, i, false);
        C0200b.m235G(parcel, C);
    }

    public OpenFileIntentSenderRequest at(Parcel parcel) {
        DriveId driveId = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        String[] strArr = null;
        String str = null;
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
                    strArr = C0199a.m195A(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    driveId = (DriveId) C0199a.m201a(parcel, A, DriveId.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new OpenFileIntentSenderRequest(i, str, strArr, driveId);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public OpenFileIntentSenderRequest[] bp(int i) {
        return new OpenFileIntentSenderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return at(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bp(x0);
    }
}
