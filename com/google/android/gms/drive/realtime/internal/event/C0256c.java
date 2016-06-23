package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.c */
public class C0256c implements Creator<ParcelableObjectChangedEvent> {
    static void m394a(ParcelableObjectChangedEvent parcelableObjectChangedEvent, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, parcelableObjectChangedEvent.xM);
        C0200b.m247a(parcel, 2, parcelableObjectChangedEvent.rR, false);
        C0200b.m247a(parcel, 3, parcelableObjectChangedEvent.Lm, false);
        C0200b.m250a(parcel, 4, parcelableObjectChangedEvent.Ls);
        C0200b.m247a(parcel, 5, parcelableObjectChangedEvent.Lq, false);
        C0200b.m247a(parcel, 6, parcelableObjectChangedEvent.Lt, false);
        C0200b.m259c(parcel, 7, parcelableObjectChangedEvent.LF);
        C0200b.m259c(parcel, 8, parcelableObjectChangedEvent.LG);
        C0200b.m235G(parcel, C);
    }

    public ParcelableObjectChangedEvent aV(Parcel parcel) {
        String str = null;
        int i = 0;
        int B = C0199a.m196B(parcel);
        int i2 = 0;
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str4 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ParcelableObjectChangedEvent(i3, str4, str3, z, str2, str, i2, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public ParcelableObjectChangedEvent[] bS(int i) {
        return new ParcelableObjectChangedEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aV(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bS(x0);
    }
}
