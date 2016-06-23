package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.events.a */
public class C0208a implements Creator<ChangeEvent> {
    static void m270a(ChangeEvent changeEvent, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, changeEvent.xM);
        C0200b.m243a(parcel, 2, changeEvent.Hz, i, false);
        C0200b.m259c(parcel, 3, changeEvent.Ig);
        C0200b.m235G(parcel, C);
    }

    public ChangeEvent m271P(Parcel parcel) {
        int i = 0;
        int B = C0199a.m196B(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            DriveId driveId2;
            int g;
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    int i3 = i;
                    driveId2 = driveId;
                    g = C0199a.m212g(parcel, A);
                    A = i3;
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    g = i2;
                    DriveId driveId3 = (DriveId) C0199a.m201a(parcel, A, DriveId.CREATOR);
                    A = i;
                    driveId2 = driveId3;
                    break;
                case DetectedActivity.STILL /*3*/:
                    A = C0199a.m212g(parcel, A);
                    driveId2 = driveId;
                    g = i2;
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    A = i;
                    driveId2 = driveId;
                    g = i2;
                    break;
            }
            i2 = g;
            driveId = driveId2;
            i = A;
        }
        if (parcel.dataPosition() == B) {
            return new ChangeEvent(i2, driveId, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public ChangeEvent[] aJ(int i) {
        return new ChangeEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m271P(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aJ(x0);
    }
}
