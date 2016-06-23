package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.wearable.DataEvent;

public class ji implements Creator<jh> {
    static void m1306a(jh jhVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m247a(parcel, 1, jhVar.getRequestId(), false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, jhVar.getVersionCode());
        C0200b.m239a(parcel, 2, jhVar.getExpirationTime());
        C0200b.m249a(parcel, 3, jhVar.ja());
        C0200b.m237a(parcel, 4, jhVar.getLatitude());
        C0200b.m237a(parcel, 5, jhVar.getLongitude());
        C0200b.m238a(parcel, 6, jhVar.jb());
        C0200b.m259c(parcel, 7, jhVar.jc());
        C0200b.m259c(parcel, 8, jhVar.getNotificationResponsiveness());
        C0200b.m259c(parcel, 9, jhVar.jd());
        C0200b.m235G(parcel, C);
    }

    public jh bt(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    s = C0199a.m211f(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    d = C0199a.m218m(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    d2 = C0199a.m218m(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    f = C0199a.m217l(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    i4 = C0199a.m212g(parcel, A);
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
            return new jh(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public jh[] cO(int i) {
        return new jh[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bt(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cO(x0);
    }
}
