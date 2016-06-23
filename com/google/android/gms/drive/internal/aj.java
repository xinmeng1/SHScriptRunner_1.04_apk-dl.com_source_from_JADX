package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.FileConflictEvent;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class aj implements Creator<OnEventResponse> {
    static void m323a(OnEventResponse onEventResponse, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, onEventResponse.xM);
        C0200b.m259c(parcel, 2, onEventResponse.Iq);
        C0200b.m243a(parcel, 3, onEventResponse.Jy, i, false);
        C0200b.m243a(parcel, 4, onEventResponse.Jz, i, false);
        C0200b.m235G(parcel, C);
    }

    public OnEventResponse ak(Parcel parcel) {
        FileConflictEvent fileConflictEvent = null;
        int i = 0;
        int B = C0199a.m196B(parcel);
        ChangeEvent changeEvent = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            ChangeEvent changeEvent2;
            int i3;
            FileConflictEvent fileConflictEvent2;
            int A = C0199a.m194A(parcel);
            FileConflictEvent fileConflictEvent3;
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    fileConflictEvent3 = fileConflictEvent;
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = C0199a.m212g(parcel, A);
                    fileConflictEvent2 = fileConflictEvent3;
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i = i2;
                    ChangeEvent changeEvent3 = changeEvent;
                    i3 = C0199a.m212g(parcel, A);
                    fileConflictEvent2 = fileConflictEvent;
                    changeEvent2 = changeEvent3;
                    break;
                case DetectedActivity.STILL /*3*/:
                    i3 = i;
                    i = i2;
                    fileConflictEvent3 = fileConflictEvent;
                    changeEvent2 = (ChangeEvent) C0199a.m201a(parcel, A, ChangeEvent.CREATOR);
                    fileConflictEvent2 = fileConflictEvent3;
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    fileConflictEvent2 = (FileConflictEvent) C0199a.m201a(parcel, A, FileConflictEvent.CREATOR);
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    fileConflictEvent2 = fileConflictEvent;
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            changeEvent = changeEvent2;
            fileConflictEvent = fileConflictEvent2;
        }
        if (parcel.dataPosition() == B) {
            return new OnEventResponse(i2, i, changeEvent, fileConflictEvent);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public OnEventResponse[] bg(int i) {
        return new OnEventResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ak(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bg(x0);
    }
}
