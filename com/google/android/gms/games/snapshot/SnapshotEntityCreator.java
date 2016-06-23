package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class SnapshotEntityCreator implements Creator<SnapshotEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m749a(SnapshotEntity snapshotEntity, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m243a(parcel, 1, snapshotEntity.getMetadata(), i, false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, snapshotEntity.getVersionCode());
        C0200b.m243a(parcel, 2, snapshotEntity.getContents(), i, false);
        C0200b.m235G(parcel, C);
    }

    public SnapshotEntity createFromParcel(Parcel parcel) {
        Contents contents = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        SnapshotMetadata snapshotMetadata = null;
        while (parcel.dataPosition() < B) {
            int i2;
            Contents contents2;
            SnapshotMetadata snapshotMetadata2;
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = i;
                    SnapshotMetadataEntity snapshotMetadataEntity = (SnapshotMetadataEntity) C0199a.m201a(parcel, A, SnapshotMetadataEntity.CREATOR);
                    contents2 = contents;
                    Object obj = snapshotMetadataEntity;
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    contents2 = (Contents) C0199a.m201a(parcel, A, Contents.CREATOR);
                    snapshotMetadata2 = snapshotMetadata;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    Contents contents3 = contents;
                    snapshotMetadata2 = snapshotMetadata;
                    i2 = C0199a.m212g(parcel, A);
                    contents2 = contents3;
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    contents2 = contents;
                    snapshotMetadata2 = snapshotMetadata;
                    i2 = i;
                    break;
            }
            i = i2;
            snapshotMetadata = snapshotMetadata2;
            contents = contents2;
        }
        if (parcel.dataPosition() == B) {
            return new SnapshotEntity(i, snapshotMetadata, contents);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public SnapshotEntity[] newArray(int size) {
        return new SnapshotEntity[size];
    }
}
