package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class am implements Creator<al> {
    static void m784a(al alVar, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, alVar.versionCode);
        C0200b.m247a(parcel, 2, alVar.me, false);
        C0200b.m259c(parcel, 3, alVar.height);
        C0200b.m259c(parcel, 4, alVar.heightPixels);
        C0200b.m250a(parcel, 5, alVar.mf);
        C0200b.m259c(parcel, 6, alVar.width);
        C0200b.m259c(parcel, 7, alVar.widthPixels);
        C0200b.m253a(parcel, 8, alVar.mg, i, false);
        C0200b.m235G(parcel, C);
    }

    public al m785c(Parcel parcel) {
        al[] alVarArr = null;
        int i = 0;
        int B = C0199a.m196B(parcel);
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i5 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i4 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    alVarArr = (al[]) C0199a.m206b(parcel, A, al.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new al(i5, str, i4, i3, z, i2, i, alVarArr);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m785c(x0);
    }

    public al[] m786d(int i) {
        return new al[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m786d(x0);
    }
}
