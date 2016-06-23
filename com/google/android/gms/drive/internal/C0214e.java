package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.internal.e */
public class C0214e implements Creator<CloseContentsAndUpdateMetadataRequest> {
    static void m342a(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, closeContentsAndUpdateMetadataRequest.xM);
        C0200b.m243a(parcel, 2, closeContentsAndUpdateMetadataRequest.Iu, i, false);
        C0200b.m243a(parcel, 3, closeContentsAndUpdateMetadataRequest.Iv, i, false);
        C0200b.m243a(parcel, 4, closeContentsAndUpdateMetadataRequest.Iw, i, false);
        C0200b.m250a(parcel, 5, closeContentsAndUpdateMetadataRequest.Ix);
        C0200b.m247a(parcel, 6, closeContentsAndUpdateMetadataRequest.Iy, false);
        C0200b.m235G(parcel, C);
    }

    public CloseContentsAndUpdateMetadataRequest m343U(Parcel parcel) {
        boolean z = false;
        String str = null;
        int B = C0199a.m196B(parcel);
        Contents contents = null;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    driveId = (DriveId) C0199a.m201a(parcel, A, DriveId.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    metadataBundle = (MetadataBundle) C0199a.m201a(parcel, A, MetadataBundle.CREATOR);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    contents = (Contents) C0199a.m201a(parcel, A, Contents.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CloseContentsAndUpdateMetadataRequest(i, driveId, metadataBundle, contents, z, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public CloseContentsAndUpdateMetadataRequest[] aP(int i) {
        return new CloseContentsAndUpdateMetadataRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m343U(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aP(x0);
    }
}
