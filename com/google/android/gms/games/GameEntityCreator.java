package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import android.support.v4.util.TimeUtils;
import com.adamioan.scriptrunner.C0127R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class GameEntityCreator implements Creator<GameEntity> {
    static void m471a(GameEntity gameEntity, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m247a(parcel, 1, gameEntity.getApplicationId(), false);
        C0200b.m247a(parcel, 2, gameEntity.getDisplayName(), false);
        C0200b.m247a(parcel, 3, gameEntity.getPrimaryCategory(), false);
        C0200b.m247a(parcel, 4, gameEntity.getSecondaryCategory(), false);
        C0200b.m247a(parcel, 5, gameEntity.getDescription(), false);
        C0200b.m247a(parcel, 6, gameEntity.getDeveloperName(), false);
        C0200b.m243a(parcel, 7, gameEntity.getIconImageUri(), i, false);
        C0200b.m243a(parcel, 8, gameEntity.getHiResImageUri(), i, false);
        C0200b.m243a(parcel, 9, gameEntity.getFeaturedImageUri(), i, false);
        C0200b.m250a(parcel, 10, gameEntity.gM());
        C0200b.m250a(parcel, 11, gameEntity.gO());
        C0200b.m247a(parcel, 12, gameEntity.gP(), false);
        C0200b.m259c(parcel, 13, gameEntity.gQ());
        C0200b.m259c(parcel, 14, gameEntity.getAchievementTotalCount());
        C0200b.m259c(parcel, 15, gameEntity.getLeaderboardCount());
        C0200b.m250a(parcel, 17, gameEntity.isTurnBasedMultiplayerEnabled());
        C0200b.m250a(parcel, 16, gameEntity.isRealTimeMultiplayerEnabled());
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, gameEntity.getVersionCode());
        C0200b.m247a(parcel, 19, gameEntity.getHiResImageUrl(), false);
        C0200b.m247a(parcel, 18, gameEntity.getIconImageUrl(), false);
        C0200b.m250a(parcel, 21, gameEntity.isMuted());
        C0200b.m247a(parcel, 20, gameEntity.getFeaturedImageUrl(), false);
        C0200b.m250a(parcel, 23, gameEntity.areSnapshotsEnabled());
        C0200b.m250a(parcel, 22, gameEntity.gN());
        C0200b.m235G(parcel, C);
    }

    public GameEntity bd(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean z = false;
        boolean z2 = false;
        String str7 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
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
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str4 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str5 = C0199a.m220o(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    str6 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    uri = (Uri) C0199a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    uri2 = (Uri) C0199a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    uri3 = (Uri) C0199a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    z2 = C0199a.m208c(parcel, A);
                    break;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    str7 = C0199a.m220o(parcel, A);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    i4 = C0199a.m212g(parcel, A);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    z3 = C0199a.m208c(parcel, A);
                    break;
                case C0127R.styleable.ActionBar_progressBarPadding /*17*/:
                    z4 = C0199a.m208c(parcel, A);
                    break;
                case C0127R.styleable.ActionBar_itemPadding /*18*/:
                    str8 = C0199a.m220o(parcel, A);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    str9 = C0199a.m220o(parcel, A);
                    break;
                case 20:
                    str10 = C0199a.m220o(parcel, A);
                    break;
                case 21:
                    z5 = C0199a.m208c(parcel, A);
                    break;
                case 22:
                    z6 = C0199a.m208c(parcel, A);
                    break;
                case 23:
                    z7 = C0199a.m208c(parcel, A);
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
            return new GameEntity(i, str, str2, str3, str4, str5, str6, uri, uri2, uri3, z, z2, str7, i2, i3, i4, z3, z4, str8, str9, str10, z5, z6, z7);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public GameEntity[] cb(int i) {
        return new GameEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bd(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cb(x0);
    }
}
