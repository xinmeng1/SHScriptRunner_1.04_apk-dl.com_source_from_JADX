package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.internal.k */
public class C0220k implements Creator<CreateFolderRequest> {
    static void m354a(CreateFolderRequest createFolderRequest, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, createFolderRequest.xM);
        C0200b.m243a(parcel, 2, createFolderRequest.IG, i, false);
        C0200b.m243a(parcel, 3, createFolderRequest.IE, i, false);
        C0200b.m235G(parcel, C);
    }

    public CreateFolderRequest m355Z(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < B) {
            DriveId driveId2;
            int g;
            MetadataBundle metadataBundle2;
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    driveId2 = driveId;
                    g = C0199a.m212g(parcel, A);
                    metadataBundle2 = metadataBundle3;
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    g = i;
                    DriveId driveId3 = (DriveId) C0199a.m201a(parcel, A, DriveId.CREATOR);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId3;
                    break;
                case DetectedActivity.STILL /*3*/:
                    metadataBundle2 = (MetadataBundle) C0199a.m201a(parcel, A, MetadataBundle.CREATOR);
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == B) {
            return new CreateFolderRequest(i, driveId, metadataBundle);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public CreateFolderRequest[] aV(int i) {
        return new CreateFolderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m355Z(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aV(x0);
    }
}
