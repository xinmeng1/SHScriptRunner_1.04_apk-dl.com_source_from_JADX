package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.b */
public class C0255b implements Creator<ParcelableEventList> {
    static void m393a(ParcelableEventList parcelableEventList, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, parcelableEventList.xM);
        C0200b.m253a(parcel, 2, parcelableEventList.LB, i, false);
        C0200b.m243a(parcel, 3, parcelableEventList.LC, i, false);
        C0200b.m250a(parcel, 4, parcelableEventList.LD);
        C0200b.m253a(parcel, 5, parcelableEventList.LE, i, false);
        C0200b.m235G(parcel, C);
    }

    public ParcelableEventList aU(Parcel parcel) {
        boolean z = false;
        ParcelableObjectChangedEvent[] parcelableObjectChangedEventArr = null;
        int B = C0199a.m196B(parcel);
        DataHolder dataHolder = null;
        ParcelableEvent[] parcelableEventArr = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    parcelableEventArr = (ParcelableEvent[]) C0199a.m206b(parcel, A, ParcelableEvent.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    dataHolder = (DataHolder) C0199a.m201a(parcel, A, DataHolder.CREATOR);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    parcelableObjectChangedEventArr = (ParcelableObjectChangedEvent[]) C0199a.m206b(parcel, A, ParcelableObjectChangedEvent.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ParcelableEventList(i, parcelableEventArr, dataHolder, z, parcelableObjectChangedEventArr);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public ParcelableEventList[] bR(int i) {
        return new ParcelableEventList[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bR(x0);
    }
}
