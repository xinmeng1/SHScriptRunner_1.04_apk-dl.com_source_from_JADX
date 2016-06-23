package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.f */
public class C0530f implements Creator<FullWallet> {
    static void m1754a(FullWallet fullWallet, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, fullWallet.getVersionCode());
        C0200b.m247a(parcel, 2, fullWallet.aiQ, false);
        C0200b.m247a(parcel, 3, fullWallet.aiR, false);
        C0200b.m243a(parcel, 4, fullWallet.aiS, i, false);
        C0200b.m247a(parcel, 5, fullWallet.aiT, false);
        C0200b.m243a(parcel, 6, fullWallet.aiU, i, false);
        C0200b.m243a(parcel, 7, fullWallet.aiV, i, false);
        C0200b.m254a(parcel, 8, fullWallet.aiW, false);
        C0200b.m243a(parcel, 9, fullWallet.aiX, i, false);
        C0200b.m243a(parcel, 10, fullWallet.aiY, i, false);
        C0200b.m253a(parcel, 11, fullWallet.aiZ, i, false);
        C0200b.m235G(parcel, C);
    }

    public FullWallet bU(Parcel parcel) {
        InstrumentInfo[] instrumentInfoArr = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        String[] strArr = null;
        Address address = null;
        Address address2 = null;
        String str = null;
        ProxyCard proxyCard = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    proxyCard = (ProxyCard) C0199a.m201a(parcel, A, ProxyCard.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    address2 = (Address) C0199a.m201a(parcel, A, Address.CREATOR);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    address = (Address) C0199a.m201a(parcel, A, Address.CREATOR);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    strArr = C0199a.m195A(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    userAddress2 = (UserAddress) C0199a.m201a(parcel, A, UserAddress.CREATOR);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    userAddress = (UserAddress) C0199a.m201a(parcel, A, UserAddress.CREATOR);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    instrumentInfoArr = (InstrumentInfo[]) C0199a.m206b(parcel, A, InstrumentInfo.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new FullWallet(i, str3, str2, proxyCard, str, address2, address, strArr, userAddress2, userAddress, instrumentInfoArr);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bU(x0);
    }

    public FullWallet[] dA(int i) {
        return new FullWallet[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dA(x0);
    }
}
