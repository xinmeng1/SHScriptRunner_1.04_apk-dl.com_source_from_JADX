package com.google.android.gms.drive.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.internal.a */
public class C0211a implements Creator<AddEventListenerRequest> {
    static void m275a(AddEventListenerRequest addEventListenerRequest, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, addEventListenerRequest.xM);
        C0200b.m243a(parcel, 2, addEventListenerRequest.Hz, i, false);
        C0200b.m259c(parcel, 3, addEventListenerRequest.Iq);
        C0200b.m243a(parcel, 4, addEventListenerRequest.Ir, i, false);
        C0200b.m235G(parcel, C);
    }

    public AddEventListenerRequest m276R(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int B = C0199a.m196B(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int i3;
            DriveId driveId2;
            int g;
            PendingIntent pendingIntent2;
            int A = C0199a.m194A(parcel);
            PendingIntent pendingIntent3;
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    pendingIntent3 = pendingIntent;
                    i3 = i;
                    driveId2 = driveId;
                    g = C0199a.m212g(parcel, A);
                    pendingIntent2 = pendingIntent3;
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    g = i2;
                    int i4 = i;
                    driveId2 = (DriveId) C0199a.m201a(parcel, A, DriveId.CREATOR);
                    pendingIntent2 = pendingIntent;
                    i3 = i4;
                    break;
                case DetectedActivity.STILL /*3*/:
                    driveId2 = driveId;
                    g = i2;
                    pendingIntent3 = pendingIntent;
                    i3 = C0199a.m212g(parcel, A);
                    pendingIntent2 = pendingIntent3;
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    pendingIntent2 = (PendingIntent) C0199a.m201a(parcel, A, PendingIntent.CREATOR);
                    i3 = i;
                    driveId2 = driveId;
                    g = i2;
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    driveId2 = driveId;
                    g = i2;
                    break;
            }
            i2 = g;
            driveId = driveId2;
            i = i3;
            pendingIntent = pendingIntent2;
        }
        if (parcel.dataPosition() == B) {
            return new AddEventListenerRequest(i2, driveId, i, pendingIntent);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public AddEventListenerRequest[] aM(int i) {
        return new AddEventListenerRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m276R(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aM(x0);
    }
}
