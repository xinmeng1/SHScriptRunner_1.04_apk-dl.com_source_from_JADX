package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
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

public class dt implements Creator<ds> {
    static void m909a(ds dsVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, dsVar.versionCode);
        C0200b.m240a(parcel, 2, dsVar.pW, false);
        C0200b.m243a(parcel, 3, dsVar.pX, i, false);
        C0200b.m243a(parcel, 4, dsVar.kT, i, false);
        C0200b.m247a(parcel, 5, dsVar.kN, false);
        C0200b.m243a(parcel, 6, dsVar.applicationInfo, i, false);
        C0200b.m243a(parcel, 7, dsVar.pY, i, false);
        C0200b.m247a(parcel, 8, dsVar.pZ, false);
        C0200b.m247a(parcel, 9, dsVar.qa, false);
        C0200b.m247a(parcel, 10, dsVar.qb, false);
        C0200b.m243a(parcel, 11, dsVar.kQ, i, false);
        C0200b.m240a(parcel, 12, dsVar.qc, false);
        C0200b.m247a(parcel, 13, dsVar.qd, false);
        C0200b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m910h(x0);
    }

    public ds m910h(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        Bundle bundle = null;
        ai aiVar = null;
        al alVar = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        ev evVar = null;
        Bundle bundle2 = null;
        String str5 = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    bundle = C0199a.m222q(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    aiVar = (ai) C0199a.m201a(parcel, A, ai.CREATOR);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    alVar = (al) C0199a.m201a(parcel, A, al.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    applicationInfo = (ApplicationInfo) C0199a.m201a(parcel, A, ApplicationInfo.CREATOR);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    packageInfo = (PackageInfo) C0199a.m201a(parcel, A, PackageInfo.CREATOR);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    str4 = C0199a.m220o(parcel, A);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    evVar = (ev) C0199a.m201a(parcel, A, ev.CREATOR);
                    break;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    bundle2 = C0199a.m222q(parcel, A);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    str5 = C0199a.m220o(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ds(i, bundle, aiVar, alVar, str, applicationInfo, packageInfo, str2, str3, str4, evVar, bundle2, str5);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public ds[] m911m(int i) {
        return new ds[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m911m(x0);
    }
}
