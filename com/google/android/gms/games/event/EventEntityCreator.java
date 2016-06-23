package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class EventEntityCreator implements Creator<EventEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m477a(EventEntity eventEntity, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m247a(parcel, 1, eventEntity.getEventId(), false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, eventEntity.getVersionCode());
        C0200b.m247a(parcel, 2, eventEntity.getName(), false);
        C0200b.m247a(parcel, 3, eventEntity.getDescription(), false);
        C0200b.m243a(parcel, 4, eventEntity.getIconImageUri(), i, false);
        C0200b.m247a(parcel, 5, eventEntity.getIconImageUrl(), false);
        C0200b.m243a(parcel, 6, eventEntity.getPlayer(), i, false);
        C0200b.m239a(parcel, 7, eventEntity.getValue());
        C0200b.m247a(parcel, 8, eventEntity.getFormattedValue(), false);
        C0200b.m250a(parcel, 9, eventEntity.isVisible());
        C0200b.m235G(parcel, C);
    }

    public EventEntity createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int B = C0199a.m196B(parcel);
        long j = 0;
        Player player = null;
        String str2 = null;
        Uri uri = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str5 = C0199a.m220o(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str4 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    uri = (Uri) C0199a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    player = (PlayerEntity) C0199a.m201a(parcel, A, PlayerEntity.CREATOR);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
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
            return new EventEntity(i, str5, str4, str3, uri, str2, player, j, str, z);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public EventEntity[] newArray(int size) {
        return new EventEntity[size];
    }
}
