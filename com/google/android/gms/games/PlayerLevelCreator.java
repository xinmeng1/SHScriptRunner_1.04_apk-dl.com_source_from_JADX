package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class PlayerLevelCreator implements Creator<PlayerLevel> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m475a(PlayerLevel playerLevel, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, playerLevel.getLevelNumber());
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, playerLevel.getVersionCode());
        C0200b.m239a(parcel, 2, playerLevel.getMinXp());
        C0200b.m239a(parcel, 3, playerLevel.getMaxXp());
        C0200b.m235G(parcel, C);
    }

    public PlayerLevel createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        int B = C0199a.m196B(parcel);
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j2 = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j = C0199a.m214i(parcel, A);
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
            return new PlayerLevel(i2, i, j2, j);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public PlayerLevel[] newArray(int size) {
        return new PlayerLevel[size];
    }
}
