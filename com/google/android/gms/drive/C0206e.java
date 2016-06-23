package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.e */
public class C0206e implements Creator<StorageStats> {
    static void m266a(StorageStats storageStats, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, storageStats.xM);
        C0200b.m239a(parcel, 2, storageStats.Ib);
        C0200b.m239a(parcel, 3, storageStats.Ic);
        C0200b.m239a(parcel, 4, storageStats.Id);
        C0200b.m239a(parcel, 5, storageStats.Ie);
        C0200b.m259c(parcel, 6, storageStats.If);
        C0200b.m235G(parcel, C);
    }

    public StorageStats m267O(Parcel parcel) {
        int i = 0;
        long j = 0;
        int B = C0199a.m196B(parcel);
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j4 = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j3 = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    j2 = C0199a.m214i(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    j = C0199a.m214i(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new StorageStats(i2, j4, j3, j2, j, i);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public StorageStats[] aI(int i) {
        return new StorageStats[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m267O(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aI(x0);
    }
}
