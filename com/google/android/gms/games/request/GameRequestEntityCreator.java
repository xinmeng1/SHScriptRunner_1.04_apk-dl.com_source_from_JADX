package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

public class GameRequestEntityCreator implements Creator<GameRequestEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m748a(GameRequestEntity gameRequestEntity, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m243a(parcel, 1, gameRequestEntity.getGame(), i, false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, gameRequestEntity.getVersionCode());
        C0200b.m243a(parcel, 2, gameRequestEntity.getSender(), i, false);
        C0200b.m251a(parcel, 3, gameRequestEntity.getData(), false);
        C0200b.m247a(parcel, 4, gameRequestEntity.getRequestId(), false);
        C0200b.m258b(parcel, 5, gameRequestEntity.getRecipients(), false);
        C0200b.m259c(parcel, 7, gameRequestEntity.getType());
        C0200b.m239a(parcel, 9, gameRequestEntity.getCreationTimestamp());
        C0200b.m239a(parcel, 10, gameRequestEntity.getExpirationTimestamp());
        C0200b.m240a(parcel, 11, gameRequestEntity.iL(), false);
        C0200b.m259c(parcel, 12, gameRequestEntity.getStatus());
        C0200b.m235G(parcel, C);
    }

    public GameRequestEntity createFromParcel(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        byte[] bArr = null;
        String str = null;
        ArrayList arrayList = null;
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        Bundle bundle = null;
        int i3 = 0;
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
                    bArr = C0199a.m223r(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    arrayList = C0199a.m207c(parcel, A, PlayerEntity.CREATOR);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    j2 = C0199a.m214i(parcel, A);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    bundle = C0199a.m222q(parcel, A);
                    break;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    i3 = C0199a.m212g(parcel, A);
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
            return new GameRequestEntity(i, gameEntity, playerEntity, bArr, str, arrayList, i2, j, j2, bundle, i3);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public GameRequestEntity[] newArray(int size) {
        return new GameRequestEntity[size];
    }
}
