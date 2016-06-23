package com.google.android.gms.drive.realtime.internal.event;

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

/* renamed from: com.google.android.gms.drive.realtime.internal.event.a */
public class C0254a implements Creator<ParcelableEvent> {
    static void m392a(ParcelableEvent parcelableEvent, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, parcelableEvent.xM);
        C0200b.m247a(parcel, 2, parcelableEvent.rR, false);
        C0200b.m247a(parcel, 3, parcelableEvent.Lm, false);
        C0200b.m250a(parcel, 4, parcelableEvent.Ls);
        C0200b.m247a(parcel, 5, parcelableEvent.Lq, false);
        C0200b.m247a(parcel, 6, parcelableEvent.Lt, false);
        C0200b.m243a(parcel, 7, parcelableEvent.Lu, i, false);
        C0200b.m243a(parcel, 8, parcelableEvent.Lv, i, false);
        C0200b.m243a(parcel, 9, parcelableEvent.Lw, i, false);
        C0200b.m243a(parcel, 10, parcelableEvent.Lx, i, false);
        C0200b.m243a(parcel, 11, parcelableEvent.Ly, i, false);
        C0200b.m243a(parcel, 12, parcelableEvent.Lz, i, false);
        C0200b.m243a(parcel, 13, parcelableEvent.LA, i, false);
        C0200b.m235G(parcel, C);
    }

    public ParcelableEvent aT(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        TextInsertedDetails textInsertedDetails = null;
        TextDeletedDetails textDeletedDetails = null;
        ValuesAddedDetails valuesAddedDetails = null;
        ValuesRemovedDetails valuesRemovedDetails = null;
        ValuesSetDetails valuesSetDetails = null;
        ValueChangedDetails valueChangedDetails = null;
        ReferenceShiftedDetails referenceShiftedDetails = null;
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
                    z = C0199a.m208c(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    str4 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    textInsertedDetails = (TextInsertedDetails) C0199a.m201a(parcel, A, TextInsertedDetails.CREATOR);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    textDeletedDetails = (TextDeletedDetails) C0199a.m201a(parcel, A, TextDeletedDetails.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    valuesAddedDetails = (ValuesAddedDetails) C0199a.m201a(parcel, A, ValuesAddedDetails.CREATOR);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    valuesRemovedDetails = (ValuesRemovedDetails) C0199a.m201a(parcel, A, ValuesRemovedDetails.CREATOR);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    valuesSetDetails = (ValuesSetDetails) C0199a.m201a(parcel, A, ValuesSetDetails.CREATOR);
                    break;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    valueChangedDetails = (ValueChangedDetails) C0199a.m201a(parcel, A, ValueChangedDetails.CREATOR);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    referenceShiftedDetails = (ReferenceShiftedDetails) C0199a.m201a(parcel, A, ReferenceShiftedDetails.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ParcelableEvent(i, str, str2, z, str3, str4, textInsertedDetails, textDeletedDetails, valuesAddedDetails, valuesRemovedDetails, valuesSetDetails, valueChangedDetails, referenceShiftedDetails);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public ParcelableEvent[] bQ(int i) {
        return new ParcelableEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bQ(x0);
    }
}
