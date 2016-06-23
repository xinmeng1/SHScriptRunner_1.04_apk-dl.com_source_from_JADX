package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.internal.hy.C0785a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class hz implements Creator<C0785a> {
    static void m1254a(C0785a c0785a, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, c0785a.getVersionCode());
        C0200b.m259c(parcel, 2, c0785a.fE());
        C0200b.m250a(parcel, 3, c0785a.fK());
        C0200b.m259c(parcel, 4, c0785a.fF());
        C0200b.m250a(parcel, 5, c0785a.fL());
        C0200b.m247a(parcel, 6, c0785a.fM(), false);
        C0200b.m259c(parcel, 7, c0785a.fN());
        C0200b.m247a(parcel, 8, c0785a.fP(), false);
        C0200b.m243a(parcel, 9, c0785a.fR(), i, false);
        C0200b.m235G(parcel, C);
    }

    public C0785a m1255H(Parcel parcel) {
        ht htVar = null;
        int i = 0;
        int B = C0199a.m196B(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i4 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    z2 = C0199a.m208c(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    htVar = (ht) C0199a.m201a(parcel, A, ht.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0785a(i4, i3, z2, i2, z, str2, i, str, htVar);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public C0785a[] aw(int i) {
        return new C0785a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1255H(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aw(x0);
    }
}
