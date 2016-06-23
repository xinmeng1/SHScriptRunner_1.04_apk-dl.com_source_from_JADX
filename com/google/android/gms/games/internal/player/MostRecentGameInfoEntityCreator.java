package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class MostRecentGameInfoEntityCreator implements Creator<MostRecentGameInfoEntity> {
    static void m735a(MostRecentGameInfoEntity mostRecentGameInfoEntity, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m247a(parcel, 1, mostRecentGameInfoEntity.ip(), false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, mostRecentGameInfoEntity.getVersionCode());
        C0200b.m247a(parcel, 2, mostRecentGameInfoEntity.iq(), false);
        C0200b.m239a(parcel, 3, mostRecentGameInfoEntity.ir());
        C0200b.m243a(parcel, 4, mostRecentGameInfoEntity.is(), i, false);
        C0200b.m243a(parcel, 5, mostRecentGameInfoEntity.it(), i, false);
        C0200b.m243a(parcel, 6, mostRecentGameInfoEntity.iu(), i, false);
        C0200b.m235G(parcel, C);
    }

    public MostRecentGameInfoEntity bj(Parcel parcel) {
        Uri uri = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        long j = 0;
        Uri uri2 = null;
        Uri uri3 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    uri3 = (Uri) C0199a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    uri2 = (Uri) C0199a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    uri = (Uri) C0199a.m201a(parcel, A, Uri.CREATOR);
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
            return new MostRecentGameInfoEntity(i, str2, str, j, uri3, uri2, uri);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bj(x0);
    }

    public MostRecentGameInfoEntity[] cu(int i) {
        return new MostRecentGameInfoEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cu(x0);
    }
}
