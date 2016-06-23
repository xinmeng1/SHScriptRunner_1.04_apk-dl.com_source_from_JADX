package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.cast.a */
public class C0171a implements Creator<ApplicationMetadata> {
    static void m113a(ApplicationMetadata applicationMetadata, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, applicationMetadata.getVersionCode());
        C0200b.m247a(parcel, 2, applicationMetadata.getApplicationId(), false);
        C0200b.m247a(parcel, 3, applicationMetadata.getName(), false);
        C0200b.m258b(parcel, 4, applicationMetadata.getImages(), false);
        C0200b.m248a(parcel, 5, applicationMetadata.zR, false);
        C0200b.m247a(parcel, 6, applicationMetadata.getSenderAppIdentifier(), false);
        C0200b.m243a(parcel, 7, applicationMetadata.dX(), i, false);
        C0200b.m235G(parcel, C);
    }

    public ApplicationMetadata[] m114M(int i) {
        return new ApplicationMetadata[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m115r(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m114M(x0);
    }

    public ApplicationMetadata m115r(Parcel parcel) {
        Uri uri = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        String str = null;
        List list = null;
        List list2 = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str3 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    list2 = C0199a.m207c(parcel, A, WebImage.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    list = C0199a.m197B(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    uri = (Uri) C0199a.m201a(parcel, A, Uri.CREATOR);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ApplicationMetadata(i, str3, str2, list2, list, str, uri);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }
}
