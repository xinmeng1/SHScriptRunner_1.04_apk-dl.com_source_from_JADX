package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class MilestoneEntityCreator implements Creator<MilestoneEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m746a(MilestoneEntity milestoneEntity, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m247a(parcel, 1, milestoneEntity.getMilestoneId(), false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, milestoneEntity.getVersionCode());
        C0200b.m239a(parcel, 2, milestoneEntity.getCurrentProgress());
        C0200b.m239a(parcel, 3, milestoneEntity.getTargetProgress());
        C0200b.m251a(parcel, 4, milestoneEntity.getCompletionRewardData(), false);
        C0200b.m259c(parcel, 5, milestoneEntity.getState());
        C0200b.m247a(parcel, 6, milestoneEntity.getEventId(), false);
        C0200b.m235G(parcel, C);
    }

    public MilestoneEntity createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        String str = null;
        int B = C0199a.m196B(parcel);
        byte[] bArr = null;
        long j2 = 0;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j2 = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    bArr = C0199a.m223r(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    str = C0199a.m220o(parcel, A);
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
            return new MilestoneEntity(i2, str2, j2, j, bArr, i, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public MilestoneEntity[] newArray(int size) {
        return new MilestoneEntity[size];
    }
}
