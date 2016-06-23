package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class GameBadgeEntityCreator implements Creator<GameBadgeEntity> {
    static void m733a(GameBadgeEntity gameBadgeEntity, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, gameBadgeEntity.getType());
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, gameBadgeEntity.getVersionCode());
        C0200b.m247a(parcel, 2, gameBadgeEntity.getTitle(), false);
        C0200b.m247a(parcel, 3, gameBadgeEntity.getDescription(), false);
        C0200b.m243a(parcel, 4, gameBadgeEntity.getIconImageUri(), i, false);
        C0200b.m235G(parcel, C);
    }

    public GameBadgeEntity bh(Parcel parcel) {
        int i = 0;
        Uri uri = null;
        int B = C0199a.m196B(parcel);
        String str = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    uri = (Uri) C0199a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new GameBadgeEntity(i2, i, str2, str, uri);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public GameBadgeEntity[] cq(int i) {
        return new GameBadgeEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bh(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cq(x0);
    }
}
