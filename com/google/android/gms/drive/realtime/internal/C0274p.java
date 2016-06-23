package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.realtime.internal.p */
public class C0274p implements Creator<ParcelableCollaborator> {
    static void m454a(ParcelableCollaborator parcelableCollaborator, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, parcelableCollaborator.xM);
        C0200b.m250a(parcel, 2, parcelableCollaborator.Lk);
        C0200b.m250a(parcel, 3, parcelableCollaborator.Ll);
        C0200b.m247a(parcel, 4, parcelableCollaborator.rR, false);
        C0200b.m247a(parcel, 5, parcelableCollaborator.Lm, false);
        C0200b.m247a(parcel, 6, parcelableCollaborator.Ln, false);
        C0200b.m247a(parcel, 7, parcelableCollaborator.Lo, false);
        C0200b.m247a(parcel, 8, parcelableCollaborator.Lp, false);
        C0200b.m235G(parcel, C);
    }

    public ParcelableCollaborator aR(Parcel parcel) {
        boolean z = false;
        String str = null;
        int B = C0199a.m196B(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    z2 = C0199a.m208c(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str5 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str4 = C0199a.m220o(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ParcelableCollaborator(i, z2, z, str5, str4, str3, str2, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public ParcelableCollaborator[] bO(int i) {
        return new ParcelableCollaborator[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aR(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bO(x0);
    }
}
