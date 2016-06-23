package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import android.support.v4.util.TimeUtils;
import com.adamioan.scriptrunner.C0127R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.internal.ig;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.wobs.a */
public class C0549a implements Creator<CommonWalletObject> {
    static void m1787a(CommonWalletObject commonWalletObject, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, commonWalletObject.getVersionCode());
        C0200b.m247a(parcel, 2, commonWalletObject.eC, false);
        C0200b.m247a(parcel, 3, commonWalletObject.ajq, false);
        C0200b.m247a(parcel, 4, commonWalletObject.name, false);
        C0200b.m247a(parcel, 5, commonWalletObject.ajj, false);
        C0200b.m247a(parcel, 6, commonWalletObject.ajm, false);
        C0200b.m247a(parcel, 7, commonWalletObject.ajn, false);
        C0200b.m247a(parcel, 8, commonWalletObject.ajo, false);
        C0200b.m247a(parcel, 9, commonWalletObject.ajp, false);
        C0200b.m259c(parcel, 10, commonWalletObject.state);
        C0200b.m258b(parcel, 11, commonWalletObject.ajr, false);
        C0200b.m243a(parcel, 12, commonWalletObject.ajs, i, false);
        C0200b.m258b(parcel, 13, commonWalletObject.ajt, false);
        C0200b.m247a(parcel, 14, commonWalletObject.aju, false);
        C0200b.m247a(parcel, 15, commonWalletObject.ajv, false);
        C0200b.m250a(parcel, 17, commonWalletObject.ajx);
        C0200b.m258b(parcel, 16, commonWalletObject.ajw, false);
        C0200b.m258b(parcel, 19, commonWalletObject.ajz, false);
        C0200b.m258b(parcel, 18, commonWalletObject.ajy, false);
        C0200b.m258b(parcel, 20, commonWalletObject.ajA, false);
        C0200b.m235G(parcel, C);
    }

    public CommonWalletObject cj(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        int i2 = 0;
        ArrayList ga = ig.ga();
        C0996l c0996l = null;
        ArrayList ga2 = ig.ga();
        String str9 = null;
        String str10 = null;
        ArrayList ga3 = ig.ga();
        boolean z = false;
        ArrayList ga4 = ig.ga();
        ArrayList ga5 = ig.ga();
        ArrayList ga6 = ig.ga();
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str4 = C0199a.m220o(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    str5 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    str6 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    str7 = C0199a.m220o(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    str8 = C0199a.m220o(parcel, A);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    ga = C0199a.m207c(parcel, A, C0998p.CREATOR);
                    break;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    c0996l = (C0996l) C0199a.m201a(parcel, A, C0996l.CREATOR);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    ga2 = C0199a.m207c(parcel, A, LatLng.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    str9 = C0199a.m220o(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    str10 = C0199a.m220o(parcel, A);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    ga3 = C0199a.m207c(parcel, A, C0992d.CREATOR);
                    break;
                case C0127R.styleable.ActionBar_progressBarPadding /*17*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                case C0127R.styleable.ActionBar_itemPadding /*18*/:
                    ga4 = C0199a.m207c(parcel, A, C0997n.CREATOR);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    ga5 = C0199a.m207c(parcel, A, C0995j.CREATOR);
                    break;
                case 20:
                    ga6 = C0199a.m207c(parcel, A, C0997n.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CommonWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, i2, ga, c0996l, ga2, str9, str10, ga3, z, ga4, ga5, ga6);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cj(x0);
    }

    public CommonWalletObject[] dR(int i) {
        return new CommonWalletObject[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dR(x0);
    }
}
