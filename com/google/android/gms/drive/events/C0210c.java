package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.drive.events.c */
public class C0210c implements Creator<FileConflictEvent> {
    static void m273a(FileConflictEvent fileConflictEvent, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, fileConflictEvent.xM);
        C0200b.m243a(parcel, 2, fileConflictEvent.Hz, i, false);
        C0200b.m247a(parcel, 3, fileConflictEvent.yQ, false);
        C0200b.m243a(parcel, 4, fileConflictEvent.Ij, i, false);
        C0200b.m243a(parcel, 5, fileConflictEvent.Ik, i, false);
        C0200b.m243a(parcel, 6, fileConflictEvent.Il, i, false);
        C0200b.m248a(parcel, 7, fileConflictEvent.Im, false);
        C0200b.m235G(parcel, C);
    }

    public FileConflictEvent m274Q(Parcel parcel) {
        ArrayList arrayList = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        String str = null;
        DriveId driveId = null;
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
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) C0199a.m201a(parcel, A, ParcelFileDescriptor.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) C0199a.m201a(parcel, A, ParcelFileDescriptor.CREATOR);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    metadataBundle = (MetadataBundle) C0199a.m201a(parcel, A, MetadataBundle.CREATOR);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    arrayList = C0199a.m197B(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new FileConflictEvent(i, driveId, str, parcelFileDescriptor2, parcelFileDescriptor, metadataBundle, arrayList);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public FileConflictEvent[] aL(int i) {
        return new FileConflictEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m274Q(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aL(x0);
    }
}
