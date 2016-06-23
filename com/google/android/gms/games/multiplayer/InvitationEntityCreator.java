package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

public class InvitationEntityCreator implements Creator<InvitationEntity> {
    static void m740a(InvitationEntity invitationEntity, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m243a(parcel, 1, invitationEntity.getGame(), i, false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, invitationEntity.getVersionCode());
        C0200b.m247a(parcel, 2, invitationEntity.getInvitationId(), false);
        C0200b.m239a(parcel, 3, invitationEntity.getCreationTimestamp());
        C0200b.m259c(parcel, 4, invitationEntity.getInvitationType());
        C0200b.m243a(parcel, 5, invitationEntity.getInviter(), i, false);
        C0200b.m258b(parcel, 6, invitationEntity.getParticipants(), false);
        C0200b.m259c(parcel, 7, invitationEntity.getVariant());
        C0200b.m259c(parcel, 8, invitationEntity.getAvailableAutoMatchSlots());
        C0200b.m235G(parcel, C);
    }

    public InvitationEntity bl(Parcel parcel) {
        ArrayList arrayList = null;
        int i = 0;
        int B = C0199a.m196B(parcel);
        long j = 0;
        int i2 = 0;
        ParticipantEntity participantEntity = null;
        int i3 = 0;
        String str = null;
        GameEntity gameEntity = null;
        int i4 = 0;
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
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    participantEntity = (ParticipantEntity) C0199a.m201a(parcel, A, ParticipantEntity.CREATOR);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    arrayList = C0199a.m207c(parcel, A, ParticipantEntity.CREATOR);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
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
            return new InvitationEntity(i4, gameEntity, str, j, i3, participantEntity, arrayList, i2, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bl(x0);
    }

    public InvitationEntity[] cx(int i) {
        return new InvitationEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cx(x0);
    }
}
