package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wallet.wobs.h */
public class C0552h implements Creator<C0994g> {
    static void m1790a(C0994g c0994g, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, c0994g.getVersionCode());
        C0200b.m259c(parcel, 2, c0994g.akT);
        C0200b.m247a(parcel, 3, c0994g.akU, false);
        C0200b.m237a(parcel, 4, c0994g.akV);
        C0200b.m247a(parcel, 5, c0994g.akW, false);
        C0200b.m239a(parcel, 6, c0994g.akX);
        C0200b.m259c(parcel, 7, c0994g.akY);
        C0200b.m235G(parcel, C);
    }

    public C0994g cm(Parcel parcel) {
        String str = null;
        int i = 0;
        int B = C0199a.m196B(parcel);
        double d = 0.0d;
        long j = 0;
        int i2 = -1;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    d = C0199a.m218m(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0994g(i3, i, str2, d, str, j, i2);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cm(x0);
    }

    public C0994g[] dU(int i) {
        return new C0994g[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dU(x0);
    }
}
