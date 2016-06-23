package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class SnapshotMetadataEntityCreator implements Creator<SnapshotMetadataEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m751a(SnapshotMetadataEntity snapshotMetadataEntity, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m243a(parcel, 1, snapshotMetadataEntity.getGame(), i, false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, snapshotMetadataEntity.getVersionCode());
        C0200b.m243a(parcel, 2, snapshotMetadataEntity.getOwner(), i, false);
        C0200b.m247a(parcel, 3, snapshotMetadataEntity.getSnapshotId(), false);
        C0200b.m243a(parcel, 5, snapshotMetadataEntity.getCoverImageUri(), i, false);
        C0200b.m247a(parcel, 6, snapshotMetadataEntity.getCoverImageUrl(), false);
        C0200b.m247a(parcel, 7, snapshotMetadataEntity.getTitle(), false);
        C0200b.m247a(parcel, 8, snapshotMetadataEntity.getDescription(), false);
        C0200b.m239a(parcel, 9, snapshotMetadataEntity.getLastModifiedTimestamp());
        C0200b.m239a(parcel, 10, snapshotMetadataEntity.getPlayedTime());
        C0200b.m238a(parcel, 11, snapshotMetadataEntity.getCoverImageAspectRatio());
        C0200b.m247a(parcel, 12, snapshotMetadataEntity.getUniqueName(), false);
        C0200b.m235G(parcel, C);
    }

    public SnapshotMetadataEntity createFromParcel(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        String str = null;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        float f = 0.0f;
        String str5 = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    gameEntity = (GameEntity) C0199a.m201a(parcel, A, GameEntity.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    playerEntity = (PlayerEntity) C0199a.m201a(parcel, A, PlayerEntity.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    uri = (Uri) C0199a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    str4 = C0199a.m220o(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    j2 = C0199a.m214i(parcel, A);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    f = C0199a.m217l(parcel, A);
                    break;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    str5 = C0199a.m220o(parcel, A);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new SnapshotMetadataEntity(i, gameEntity, playerEntity, str, uri, str2, str3, str4, j, j2, f, str5);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public SnapshotMetadataEntity[] newArray(int size) {
        return new SnapshotMetadataEntity[size];
    }
}
