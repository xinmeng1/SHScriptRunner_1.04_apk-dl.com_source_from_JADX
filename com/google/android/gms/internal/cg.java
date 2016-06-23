package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.adamioan.scriptrunner.C0127R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class cg implements Creator<ch> {
    static void m851a(ch chVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, chVar.versionCode);
        C0200b.m243a(parcel, 2, chVar.ov, i, false);
        C0200b.m241a(parcel, 3, chVar.aU(), false);
        C0200b.m241a(parcel, 4, chVar.aV(), false);
        C0200b.m241a(parcel, 5, chVar.aW(), false);
        C0200b.m241a(parcel, 6, chVar.aX(), false);
        C0200b.m247a(parcel, 7, chVar.oA, false);
        C0200b.m250a(parcel, 8, chVar.oB);
        C0200b.m247a(parcel, 9, chVar.oC, false);
        C0200b.m241a(parcel, 10, chVar.aZ(), false);
        C0200b.m259c(parcel, 11, chVar.orientation);
        C0200b.m259c(parcel, 12, chVar.oE);
        C0200b.m247a(parcel, 13, chVar.ob, false);
        C0200b.m243a(parcel, 14, chVar.kQ, i, false);
        C0200b.m241a(parcel, 15, chVar.aY(), false);
        C0200b.m243a(parcel, 17, chVar.oH, i, false);
        C0200b.m247a(parcel, 16, chVar.oG, false);
        C0200b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m852f(x0);
    }

    public ch m852f(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        ce ceVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        ev evVar = null;
        IBinder iBinder6 = null;
        String str4 = null;
        C0826v c0826v = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    ceVar = (ce) C0199a.m201a(parcel, A, ce.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    iBinder = C0199a.m221p(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    iBinder2 = C0199a.m221p(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    iBinder3 = C0199a.m221p(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    iBinder4 = C0199a.m221p(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    iBinder5 = C0199a.m221p(parcel, A);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    evVar = (ev) C0199a.m201a(parcel, A, ev.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    iBinder6 = C0199a.m221p(parcel, A);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    str4 = C0199a.m220o(parcel, A);
                    break;
                case C0127R.styleable.ActionBar_progressBarPadding /*17*/:
                    c0826v = (C0826v) C0199a.m201a(parcel, A, C0826v.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ch(i, ceVar, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, evVar, iBinder6, str4, c0826v);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public ch[] m853j(int i) {
        return new ch[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m853j(x0);
    }
}
