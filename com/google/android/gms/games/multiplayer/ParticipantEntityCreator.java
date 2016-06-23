package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class ParticipantEntityCreator implements Creator<ParticipantEntity> {
    static void m741a(ParticipantEntity participantEntity, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m247a(parcel, 1, participantEntity.getParticipantId(), false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, participantEntity.getVersionCode());
        C0200b.m247a(parcel, 2, participantEntity.getDisplayName(), false);
        C0200b.m243a(parcel, 3, participantEntity.getIconImageUri(), i, false);
        C0200b.m243a(parcel, 4, participantEntity.getHiResImageUri(), i, false);
        C0200b.m259c(parcel, 5, participantEntity.getStatus());
        C0200b.m247a(parcel, 6, participantEntity.gW(), false);
        C0200b.m250a(parcel, 7, participantEntity.isConnectedToRoom());
        C0200b.m243a(parcel, 8, participantEntity.getPlayer(), i, false);
        C0200b.m259c(parcel, 9, participantEntity.getCapabilities());
        C0200b.m243a(parcel, 10, participantEntity.getResult(), i, false);
        C0200b.m247a(parcel, 11, participantEntity.getIconImageUrl(), false);
        C0200b.m247a(parcel, 12, participantEntity.getHiResImageUrl(), false);
        C0200b.m235G(parcel, C);
    }

    public ParticipantEntity bm(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        int i2 = 0;
        String str3 = null;
        boolean z = false;
        PlayerEntity playerEntity = null;
        int i3 = 0;
        ParticipantResult participantResult = null;
        String str4 = null;
        String str5 = null;
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
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    playerEntity = (PlayerEntity) C0199a.m201a(parcel, A, PlayerEntity.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    participantResult = (ParticipantResult) C0199a.m201a(parcel, A, ParticipantResult.CREATOR);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    str4 = C0199a.m220o(parcel, A);
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
            return new ParticipantEntity(i, str, str2, uri, uri2, i2, str3, z, playerEntity, i3, participantResult, str4, str5);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bm(x0);
    }

    public ParticipantEntity[] cy(int i) {
        return new ParticipantEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cy(x0);
    }
}
