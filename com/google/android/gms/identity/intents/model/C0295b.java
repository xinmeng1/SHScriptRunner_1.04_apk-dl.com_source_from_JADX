package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.identity.intents.model.b */
public class C0295b implements Creator<UserAddress> {
    static void m758a(UserAddress userAddress, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, userAddress.getVersionCode());
        C0200b.m247a(parcel, 2, userAddress.name, false);
        C0200b.m247a(parcel, 3, userAddress.UH, false);
        C0200b.m247a(parcel, 4, userAddress.UI, false);
        C0200b.m247a(parcel, 5, userAddress.UJ, false);
        C0200b.m247a(parcel, 6, userAddress.UK, false);
        C0200b.m247a(parcel, 7, userAddress.UL, false);
        C0200b.m247a(parcel, 8, userAddress.UM, false);
        C0200b.m247a(parcel, 9, userAddress.UN, false);
        C0200b.m247a(parcel, 10, userAddress.rf, false);
        C0200b.m247a(parcel, 11, userAddress.UO, false);
        C0200b.m247a(parcel, 12, userAddress.UP, false);
        C0200b.m247a(parcel, 13, userAddress.UQ, false);
        C0200b.m250a(parcel, 14, userAddress.UR);
        C0200b.m247a(parcel, 15, userAddress.US, false);
        C0200b.m247a(parcel, 16, userAddress.UT, false);
        C0200b.m235G(parcel, C);
    }

    public UserAddress br(Parcel parcel) {
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
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        boolean z = false;
        String str13 = null;
        String str14 = null;
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
                    str9 = C0199a.m220o(parcel, A);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    str10 = C0199a.m220o(parcel, A);
                    break;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    str11 = C0199a.m220o(parcel, A);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    str12 = C0199a.m220o(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    str13 = C0199a.m220o(parcel, A);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    str14 = C0199a.m220o(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new UserAddress(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, z, str13, str14);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public UserAddress[] cE(int i) {
        return new UserAddress[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return br(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cE(x0);
    }
}
