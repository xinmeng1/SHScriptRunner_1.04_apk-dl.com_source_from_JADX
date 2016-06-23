package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.adamioan.scriptrunner.C0127R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

public class QuestEntityCreator implements Creator<QuestEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m747a(QuestEntity questEntity, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m243a(parcel, 1, questEntity.getGame(), i, false);
        C0200b.m247a(parcel, 2, questEntity.getQuestId(), false);
        C0200b.m239a(parcel, 3, questEntity.getAcceptedTimestamp());
        C0200b.m243a(parcel, 4, questEntity.getBannerImageUri(), i, false);
        C0200b.m247a(parcel, 5, questEntity.getBannerImageUrl(), false);
        C0200b.m247a(parcel, 6, questEntity.getDescription(), false);
        C0200b.m239a(parcel, 7, questEntity.getEndTimestamp());
        C0200b.m239a(parcel, 8, questEntity.getLastUpdatedTimestamp());
        C0200b.m243a(parcel, 9, questEntity.getIconImageUri(), i, false);
        C0200b.m247a(parcel, 10, questEntity.getIconImageUrl(), false);
        C0200b.m247a(parcel, 12, questEntity.getName(), false);
        C0200b.m239a(parcel, 13, questEntity.iK());
        C0200b.m239a(parcel, 14, questEntity.getStartTimestamp());
        C0200b.m259c(parcel, 15, questEntity.getState());
        C0200b.m258b(parcel, 17, questEntity.iJ(), false);
        C0200b.m259c(parcel, 16, questEntity.getType());
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, questEntity.getVersionCode());
        C0200b.m235G(parcel, C);
    }

    public QuestEntity createFromParcel(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        long j = 0;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        long j3 = 0;
        Uri uri2 = null;
        String str4 = null;
        String str5 = null;
        long j4 = 0;
        long j5 = 0;
        int i2 = 0;
        int i3 = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    gameEntity = (GameEntity) C0199a.m201a(parcel, A, GameEntity.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    uri = (Uri) C0199a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    j2 = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    j3 = C0199a.m214i(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    uri2 = (Uri) C0199a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    str4 = C0199a.m220o(parcel, A);
                    break;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    str5 = C0199a.m220o(parcel, A);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    j4 = C0199a.m214i(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    j5 = C0199a.m214i(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case C0127R.styleable.ActionBar_progressBarPadding /*17*/:
                    arrayList = C0199a.m207c(parcel, A, MilestoneEntity.CREATOR);
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
            return new QuestEntity(i, gameEntity, str, j, uri, str2, str3, j2, j3, uri2, str4, str5, j4, j5, i2, i3, arrayList);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public QuestEntity[] newArray(int size) {
        return new QuestEntity[size];
    }
}
