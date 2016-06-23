package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.internal.i */
public class C0218i implements Creator<CreateFileIntentSenderRequest> {
    static void m350a(CreateFileIntentSenderRequest createFileIntentSenderRequest, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, createFileIntentSenderRequest.xM);
        C0200b.m243a(parcel, 2, createFileIntentSenderRequest.IE, i, false);
        C0200b.m259c(parcel, 3, createFileIntentSenderRequest.ra);
        C0200b.m247a(parcel, 4, createFileIntentSenderRequest.HY, false);
        C0200b.m243a(parcel, 5, createFileIntentSenderRequest.Ia, i, false);
        C0200b.m245a(parcel, 6, createFileIntentSenderRequest.IF, false);
        C0200b.m235G(parcel, C);
    }

    public CreateFileIntentSenderRequest m351X(Parcel parcel) {
        int i = 0;
        Integer num = null;
        int B = C0199a.m196B(parcel);
        DriveId driveId = null;
        String str = null;
        MetadataBundle metadataBundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    metadataBundle = (MetadataBundle) C0199a.m201a(parcel, A, MetadataBundle.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    driveId = (DriveId) C0199a.m201a(parcel, A, DriveId.CREATOR);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    num = C0199a.m213h(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CreateFileIntentSenderRequest(i2, metadataBundle, i, str, driveId, num);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public CreateFileIntentSenderRequest[] aT(int i) {
        return new CreateFileIntentSenderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m351X(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aT(x0);
    }
}
