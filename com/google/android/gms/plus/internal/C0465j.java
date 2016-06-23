package com.google.android.gms.plus.internal;

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

/* renamed from: com.google.android.gms.plus.internal.j */
public class C0465j implements Creator<C0943h> {
    static void m1584a(C0943h c0943h, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m247a(parcel, 1, c0943h.getAccountName(), false);
        C0200b.m259c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, c0943h.getVersionCode());
        C0200b.m254a(parcel, 2, c0943h.jZ(), false);
        C0200b.m254a(parcel, 3, c0943h.ka(), false);
        C0200b.m254a(parcel, 4, c0943h.kb(), false);
        C0200b.m247a(parcel, 5, c0943h.kc(), false);
        C0200b.m247a(parcel, 6, c0943h.kd(), false);
        C0200b.m247a(parcel, 7, c0943h.ke(), false);
        C0200b.m247a(parcel, 8, c0943h.kf(), false);
        C0200b.m243a(parcel, 9, c0943h.kg(), i, false);
        C0200b.m235G(parcel, C);
    }

    public C0943h bD(Parcel parcel) {
        PlusCommonExtras plusCommonExtras = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str5 = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str5 = C0199a.m220o(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    strArr3 = C0199a.m195A(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    strArr2 = C0199a.m195A(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    strArr = C0199a.m195A(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str4 = C0199a.m220o(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    plusCommonExtras = (PlusCommonExtras) C0199a.m201a(parcel, A, PlusCommonExtras.CREATOR);
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
            return new C0943h(i, str5, strArr3, strArr2, strArr, str4, str3, str2, str, plusCommonExtras);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bD(x0);
    }

    public C0943h[] da(int i) {
        return new C0943h[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return da(x0);
    }
}
