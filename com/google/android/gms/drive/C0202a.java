package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.a */
public class C0202a implements Creator<Contents> {
    static void m262a(Contents contents, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, contents.xM);
        C0200b.m243a(parcel, 2, contents.Fj, i, false);
        C0200b.m259c(parcel, 3, contents.ra);
        C0200b.m259c(parcel, 4, contents.Hy);
        C0200b.m243a(parcel, 5, contents.Hz, i, false);
        C0200b.m247a(parcel, 6, contents.HA, false);
        C0200b.m250a(parcel, 7, contents.HB);
        C0200b.m235G(parcel, C);
    }

    public Contents m263M(Parcel parcel) {
        String str = null;
        boolean z = false;
        int B = C0199a.m196B(parcel);
        DriveId driveId = null;
        int i = 0;
        int i2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) C0199a.m201a(parcel, A, ParcelFileDescriptor.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    driveId = (DriveId) C0199a.m201a(parcel, A, DriveId.CREATOR);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new Contents(i3, parcelFileDescriptor, i2, i, driveId, str, z);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public Contents[] aG(int i) {
        return new Contents[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m263M(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aG(x0);
    }
}
