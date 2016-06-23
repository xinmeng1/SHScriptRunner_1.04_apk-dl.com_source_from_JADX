package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

public class ExtendedGameEntityCreator implements Creator<ExtendedGameEntity> {
    static void m732a(ExtendedGameEntity extendedGameEntity, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m243a(parcel, 1, extendedGameEntity.ia(), i, false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, extendedGameEntity.getVersionCode());
        C0200b.m259c(parcel, 2, extendedGameEntity.hR());
        C0200b.m250a(parcel, 3, extendedGameEntity.hS());
        C0200b.m259c(parcel, 4, extendedGameEntity.hT());
        C0200b.m239a(parcel, 5, extendedGameEntity.hU());
        C0200b.m239a(parcel, 6, extendedGameEntity.hV());
        C0200b.m247a(parcel, 7, extendedGameEntity.hW(), false);
        C0200b.m239a(parcel, 8, extendedGameEntity.hX());
        C0200b.m247a(parcel, 9, extendedGameEntity.hY(), false);
        C0200b.m258b(parcel, 10, extendedGameEntity.hQ(), false);
        C0200b.m243a(parcel, 11, extendedGameEntity.hZ(), i, false);
        C0200b.m235G(parcel, C);
    }

    public ExtendedGameEntity bg(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        String str = null;
        long j3 = 0;
        String str2 = null;
        ArrayList arrayList = null;
        SnapshotMetadataEntity snapshotMetadataEntity = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    gameEntity = (GameEntity) C0199a.m201a(parcel, A, GameEntity.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    j2 = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    j3 = C0199a.m214i(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    arrayList = C0199a.m207c(parcel, A, GameBadgeEntity.CREATOR);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    snapshotMetadataEntity = (SnapshotMetadataEntity) C0199a.m201a(parcel, A, SnapshotMetadataEntity.CREATOR);
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
            return new ExtendedGameEntity(i, gameEntity, i2, z, i3, j, j2, str, j3, str2, arrayList, snapshotMetadataEntity);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public ExtendedGameEntity[] co(int i) {
        return new ExtendedGameEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bg(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return co(x0);
    }
}
