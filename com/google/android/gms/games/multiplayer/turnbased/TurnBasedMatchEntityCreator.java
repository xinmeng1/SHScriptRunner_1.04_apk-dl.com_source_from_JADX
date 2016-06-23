package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import android.support.v4.util.TimeUtils;
import com.adamioan.scriptrunner.C0127R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

public class TurnBasedMatchEntityCreator implements Creator<TurnBasedMatchEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m745a(TurnBasedMatchEntity turnBasedMatchEntity, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m243a(parcel, 1, turnBasedMatchEntity.getGame(), i, false);
        C0200b.m247a(parcel, 2, turnBasedMatchEntity.getMatchId(), false);
        C0200b.m247a(parcel, 3, turnBasedMatchEntity.getCreatorId(), false);
        C0200b.m239a(parcel, 4, turnBasedMatchEntity.getCreationTimestamp());
        C0200b.m247a(parcel, 5, turnBasedMatchEntity.getLastUpdaterId(), false);
        C0200b.m239a(parcel, 6, turnBasedMatchEntity.getLastUpdatedTimestamp());
        C0200b.m247a(parcel, 7, turnBasedMatchEntity.getPendingParticipantId(), false);
        C0200b.m259c(parcel, 8, turnBasedMatchEntity.getStatus());
        C0200b.m259c(parcel, 10, turnBasedMatchEntity.getVariant());
        C0200b.m259c(parcel, 11, turnBasedMatchEntity.getVersion());
        C0200b.m251a(parcel, 12, turnBasedMatchEntity.getData(), false);
        C0200b.m258b(parcel, 13, turnBasedMatchEntity.getParticipants(), false);
        C0200b.m247a(parcel, 14, turnBasedMatchEntity.getRematchId(), false);
        C0200b.m251a(parcel, 15, turnBasedMatchEntity.getPreviousMatchData(), false);
        C0200b.m240a(parcel, 17, turnBasedMatchEntity.getAutoMatchCriteria(), false);
        C0200b.m259c(parcel, 16, turnBasedMatchEntity.getMatchNumber());
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, turnBasedMatchEntity.getVersionCode());
        C0200b.m250a(parcel, 19, turnBasedMatchEntity.isLocallyModified());
        C0200b.m259c(parcel, 18, turnBasedMatchEntity.getTurnStatus());
        C0200b.m247a(parcel, 21, turnBasedMatchEntity.getDescriptionParticipantId(), false);
        C0200b.m247a(parcel, 20, turnBasedMatchEntity.getDescription(), false);
        C0200b.m235G(parcel, C);
    }

    public TurnBasedMatchEntity createFromParcel(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        String str2 = null;
        long j = 0;
        String str3 = null;
        long j2 = 0;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        byte[] bArr = null;
        ArrayList arrayList = null;
        String str5 = null;
        byte[] bArr2 = null;
        int i5 = 0;
        Bundle bundle = null;
        int i6 = 0;
        boolean z = false;
        String str6 = null;
        String str7 = null;
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
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    j2 = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    str4 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    i4 = C0199a.m212g(parcel, A);
                    break;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    bArr = C0199a.m223r(parcel, A);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    arrayList = C0199a.m207c(parcel, A, ParticipantEntity.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    str5 = C0199a.m220o(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    bArr2 = C0199a.m223r(parcel, A);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    i5 = C0199a.m212g(parcel, A);
                    break;
                case C0127R.styleable.ActionBar_progressBarPadding /*17*/:
                    bundle = C0199a.m222q(parcel, A);
                    break;
                case C0127R.styleable.ActionBar_itemPadding /*18*/:
                    i6 = C0199a.m212g(parcel, A);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                case 20:
                    str6 = C0199a.m220o(parcel, A);
                    break;
                case 21:
                    str7 = C0199a.m220o(parcel, A);
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
            return new TurnBasedMatchEntity(i, gameEntity, str, str2, j, str3, j2, str4, i2, i3, i4, bArr, arrayList, str5, bArr2, i5, bundle, i6, z, str6, str7);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public TurnBasedMatchEntity[] newArray(int size) {
        return new TurnBasedMatchEntity[size];
    }
}
