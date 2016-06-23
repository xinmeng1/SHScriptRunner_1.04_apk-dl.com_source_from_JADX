package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.adamioan.scriptrunner.C0127R;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class PlayerEntityCreator implements Creator<PlayerEntity> {
    static void m474a(PlayerEntity playerEntity, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m247a(parcel, 1, playerEntity.getPlayerId(), false);
        C0200b.m247a(parcel, 2, playerEntity.getDisplayName(), false);
        C0200b.m243a(parcel, 3, playerEntity.getIconImageUri(), i, false);
        C0200b.m243a(parcel, 4, playerEntity.getHiResImageUri(), i, false);
        C0200b.m239a(parcel, 5, playerEntity.getRetrievedTimestamp());
        C0200b.m259c(parcel, 6, playerEntity.gS());
        C0200b.m239a(parcel, 7, playerEntity.getLastPlayedWithTimestamp());
        C0200b.m247a(parcel, 8, playerEntity.getIconImageUrl(), false);
        C0200b.m247a(parcel, 9, playerEntity.getHiResImageUrl(), false);
        C0200b.m247a(parcel, 14, playerEntity.getTitle(), false);
        C0200b.m243a(parcel, 15, playerEntity.gU(), i, false);
        C0200b.m250a(parcel, 17, playerEntity.gT());
        C0200b.m243a(parcel, 16, playerEntity.getLevelInfo(), i, false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, playerEntity.getVersionCode());
        C0200b.m235G(parcel, C);
    }

    public PlayerEntity be(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        PlayerLevelInfo playerLevelInfo = null;
        boolean z = false;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    uri = (Uri) C0199a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    uri2 = (Uri) C0199a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    j2 = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    str4 = C0199a.m220o(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    str5 = C0199a.m220o(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    mostRecentGameInfoEntity = (MostRecentGameInfoEntity) C0199a.m201a(parcel, A, MostRecentGameInfoEntity.CREATOR);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    playerLevelInfo = (PlayerLevelInfo) C0199a.m201a(parcel, A, PlayerLevelInfo.CREATOR);
                    break;
                case C0127R.styleable.ActionBar_progressBarPadding /*17*/:
                    z = C0199a.m208c(parcel, A);
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
            return new PlayerEntity(i, str, str2, uri, uri2, j, i2, j2, str3, str4, str5, mostRecentGameInfoEntity, playerLevelInfo, z);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public PlayerEntity[] cc(int i) {
        return new PlayerEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return be(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cc(x0);
    }
}
