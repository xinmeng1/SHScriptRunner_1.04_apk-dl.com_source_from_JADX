package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

public class RoomEntityCreator implements Creator<RoomEntity> {
    static void m743a(RoomEntity roomEntity, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m247a(parcel, 1, roomEntity.getRoomId(), false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, roomEntity.getVersionCode());
        C0200b.m247a(parcel, 2, roomEntity.getCreatorId(), false);
        C0200b.m239a(parcel, 3, roomEntity.getCreationTimestamp());
        C0200b.m259c(parcel, 4, roomEntity.getStatus());
        C0200b.m247a(parcel, 5, roomEntity.getDescription(), false);
        C0200b.m259c(parcel, 6, roomEntity.getVariant());
        C0200b.m240a(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        C0200b.m258b(parcel, 8, roomEntity.getParticipants(), false);
        C0200b.m259c(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        C0200b.m235G(parcel, C);
    }

    public RoomEntity bo(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int B = C0199a.m196B(parcel);
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        int i4 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    bundle = C0199a.m222q(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    arrayList = C0199a.m207c(parcel, A, ParticipantEntity.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i4 = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new RoomEntity(i4, str3, str2, j, i3, str, i2, bundle, arrayList, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public RoomEntity[] cA(int i) {
        return new RoomEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bo(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cA(x0);
    }
}
