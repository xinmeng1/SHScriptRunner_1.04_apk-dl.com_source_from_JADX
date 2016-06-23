package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

public class aj implements Creator<ai> {
    static void m780a(ai aiVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, aiVar.versionCode);
        C0200b.m239a(parcel, 2, aiVar.lS);
        C0200b.m240a(parcel, 3, aiVar.extras, false);
        C0200b.m259c(parcel, 4, aiVar.lT);
        C0200b.m248a(parcel, 5, aiVar.lU, false);
        C0200b.m250a(parcel, 6, aiVar.lV);
        C0200b.m259c(parcel, 7, aiVar.lW);
        C0200b.m250a(parcel, 8, aiVar.lX);
        C0200b.m247a(parcel, 9, aiVar.lY, false);
        C0200b.m243a(parcel, 10, aiVar.lZ, i, false);
        C0200b.m243a(parcel, 11, aiVar.ma, i, false);
        C0200b.m247a(parcel, 12, aiVar.mb, false);
        C0200b.m240a(parcel, 13, aiVar.mc, false);
        C0200b.m235G(parcel, C);
    }

    public ai m781b(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        aw awVar = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    bundle = C0199a.m222q(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    list = C0199a.m197B(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    z2 = C0199a.m208c(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    awVar = (aw) C0199a.m201a(parcel, A, aw.CREATOR);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    location = (Location) C0199a.m201a(parcel, A, Location.CREATOR);
                    break;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    bundle2 = C0199a.m222q(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ai(i, j, bundle, i2, list, z, i3, z2, str, awVar, location, str2, bundle2);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public ai[] m782c(int i) {
        return new ai[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m781b(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m782c(x0);
    }
}
