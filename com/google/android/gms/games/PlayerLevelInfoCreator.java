package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class PlayerLevelInfoCreator implements Creator<PlayerLevelInfo> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m476a(PlayerLevelInfo playerLevelInfo, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m239a(parcel, 1, playerLevelInfo.getCurrentXpTotal());
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, playerLevelInfo.getVersionCode());
        C0200b.m239a(parcel, 2, playerLevelInfo.getLastLevelUpTimestamp());
        C0200b.m243a(parcel, 3, playerLevelInfo.getCurrentLevel(), i, false);
        C0200b.m243a(parcel, 4, playerLevelInfo.getNextLevel(), i, false);
        C0200b.m235G(parcel, C);
    }

    public PlayerLevelInfo createFromParcel(Parcel parcel) {
        long j = 0;
        PlayerLevel playerLevel = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        PlayerLevel playerLevel2 = null;
        long j2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    j2 = C0199a.m214i(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    playerLevel2 = (PlayerLevel) C0199a.m201a(parcel, A, PlayerLevel.CREATOR);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    playerLevel = (PlayerLevel) C0199a.m201a(parcel, A, PlayerLevel.CREATOR);
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
            return new PlayerLevelInfo(i, j2, j, playerLevel2, playerLevel);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public PlayerLevelInfo[] newArray(int size) {
        return new PlayerLevelInfo[size];
    }
}
