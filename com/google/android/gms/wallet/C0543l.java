package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.l */
public class C0543l implements Creator<MaskedWalletRequest> {
    static void m1783a(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, maskedWalletRequest.getVersionCode());
        C0200b.m247a(parcel, 2, maskedWalletRequest.aiR, false);
        C0200b.m250a(parcel, 3, maskedWalletRequest.ajF);
        C0200b.m250a(parcel, 4, maskedWalletRequest.ajG);
        C0200b.m250a(parcel, 5, maskedWalletRequest.ajH);
        C0200b.m247a(parcel, 6, maskedWalletRequest.ajI, false);
        C0200b.m247a(parcel, 7, maskedWalletRequest.aiL, false);
        C0200b.m247a(parcel, 8, maskedWalletRequest.ajJ, false);
        C0200b.m243a(parcel, 9, maskedWalletRequest.aja, i, false);
        C0200b.m250a(parcel, 10, maskedWalletRequest.ajK);
        C0200b.m250a(parcel, 11, maskedWalletRequest.ajL);
        C0200b.m253a(parcel, 12, maskedWalletRequest.ajM, i, false);
        C0200b.m250a(parcel, 13, maskedWalletRequest.ajN);
        C0200b.m250a(parcel, 14, maskedWalletRequest.ajO);
        C0200b.m258b(parcel, 15, maskedWalletRequest.ajP, false);
        C0200b.m235G(parcel, C);
    }

    public MaskedWalletRequest ca(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Cart cart = null;
        boolean z4 = false;
        boolean z5 = false;
        CountrySpecification[] countrySpecificationArr = null;
        boolean z6 = true;
        boolean z7 = true;
        ArrayList arrayList = null;
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
                    z = C0199a.m208c(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    z2 = C0199a.m208c(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    z3 = C0199a.m208c(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    str4 = C0199a.m220o(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    cart = (Cart) C0199a.m201a(parcel, A, Cart.CREATOR);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    z4 = C0199a.m208c(parcel, A);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    z5 = C0199a.m208c(parcel, A);
                    break;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    countrySpecificationArr = (CountrySpecification[]) C0199a.m206b(parcel, A, CountrySpecification.CREATOR);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    z6 = C0199a.m208c(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    z7 = C0199a.m208c(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    arrayList = C0199a.m207c(parcel, A, CountrySpecification.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new MaskedWalletRequest(i, str, z, z2, z3, str2, str3, str4, cart, z4, z5, countrySpecificationArr, z6, z7, arrayList);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ca(x0);
    }

    public MaskedWalletRequest[] dG(int i) {
        return new MaskedWalletRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dG(x0);
    }
}
