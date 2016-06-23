package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.wearable.d */
public class C0566d implements Creator<C1000c> {
    static void m1805a(C1000c c1000c, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, c1000c.xM);
        C0200b.m247a(parcel, 2, c1000c.getName(), false);
        C0200b.m247a(parcel, 3, c1000c.getAddress(), false);
        C0200b.m259c(parcel, 4, c1000c.getType());
        C0200b.m259c(parcel, 5, c1000c.getRole());
        C0200b.m250a(parcel, 6, c1000c.isEnabled());
        C0200b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ct(x0);
    }

    public C1000c ct(Parcel parcel) {
        String str = null;
        boolean z = false;
        int B = C0199a.m196B(parcel);
        int i = 0;
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C1000c(i3, str2, str, i2, i, z);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public C1000c[] eb(int i) {
        return new C1000c[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eb(x0);
    }
}
