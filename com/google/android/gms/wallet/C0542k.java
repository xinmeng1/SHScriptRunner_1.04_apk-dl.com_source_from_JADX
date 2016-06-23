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

/* renamed from: com.google.android.gms.wallet.k */
public class C0542k implements Creator<MaskedWallet> {
    static void m1782a(MaskedWallet maskedWallet, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, maskedWallet.getVersionCode());
        C0200b.m247a(parcel, 2, maskedWallet.aiQ, false);
        C0200b.m247a(parcel, 3, maskedWallet.aiR, false);
        C0200b.m254a(parcel, 4, maskedWallet.aiW, false);
        C0200b.m247a(parcel, 5, maskedWallet.aiT, false);
        C0200b.m243a(parcel, 6, maskedWallet.aiU, i, false);
        C0200b.m243a(parcel, 7, maskedWallet.aiV, i, false);
        C0200b.m253a(parcel, 8, maskedWallet.ajC, i, false);
        C0200b.m253a(parcel, 9, maskedWallet.ajD, i, false);
        C0200b.m243a(parcel, 10, maskedWallet.aiX, i, false);
        C0200b.m243a(parcel, 11, maskedWallet.aiY, i, false);
        C0200b.m253a(parcel, 12, maskedWallet.aiZ, i, false);
        C0200b.m235G(parcel, C);
    }

    public MaskedWallet bZ(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String[] strArr = null;
        String str3 = null;
        Address address = null;
        Address address2 = null;
        LoyaltyWalletObject[] loyaltyWalletObjectArr = null;
        OfferWalletObject[] offerWalletObjectArr = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] instrumentInfoArr = null;
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
                    strArr = C0199a.m195A(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    address = (Address) C0199a.m201a(parcel, A, Address.CREATOR);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    address2 = (Address) C0199a.m201a(parcel, A, Address.CREATOR);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    loyaltyWalletObjectArr = (LoyaltyWalletObject[]) C0199a.m206b(parcel, A, LoyaltyWalletObject.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    offerWalletObjectArr = (OfferWalletObject[]) C0199a.m206b(parcel, A, OfferWalletObject.CREATOR);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    userAddress = (UserAddress) C0199a.m201a(parcel, A, UserAddress.CREATOR);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    userAddress2 = (UserAddress) C0199a.m201a(parcel, A, UserAddress.CREATOR);
                    break;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    instrumentInfoArr = (InstrumentInfo[]) C0199a.m206b(parcel, A, InstrumentInfo.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new MaskedWallet(i, str, str2, strArr, str3, address, address2, loyaltyWalletObjectArr, offerWalletObjectArr, userAddress, userAddress2, instrumentInfoArr);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bZ(x0);
    }

    public MaskedWallet[] dF(int i) {
        return new MaskedWallet[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dF(x0);
    }
}
