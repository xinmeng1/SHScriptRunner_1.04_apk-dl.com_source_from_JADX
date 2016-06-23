package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.metadata.internal.c */
public class C0232c implements Creator<CustomProperty> {
    static void m368a(CustomProperty customProperty, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, customProperty.xM);
        C0200b.m243a(parcel, 2, customProperty.JQ, i, false);
        C0200b.m247a(parcel, 3, customProperty.mValue, false);
        C0200b.m235G(parcel, C);
    }

    public CustomProperty aB(Parcel parcel) {
        String str = null;
        int B = C0199a.m196B(parcel);
        int i = 0;
        CustomPropertyKey customPropertyKey = null;
        while (parcel.dataPosition() < B) {
            CustomPropertyKey customPropertyKey2;
            int g;
            String str2;
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    String str3 = str;
                    customPropertyKey2 = customPropertyKey;
                    g = C0199a.m212g(parcel, A);
                    str2 = str3;
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    g = i;
                    CustomPropertyKey customPropertyKey3 = (CustomPropertyKey) C0199a.m201a(parcel, A, CustomPropertyKey.CREATOR);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey3;
                    break;
                case DetectedActivity.STILL /*3*/:
                    str2 = C0199a.m220o(parcel, A);
                    customPropertyKey2 = customPropertyKey;
                    g = i;
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey;
                    g = i;
                    break;
            }
            i = g;
            customPropertyKey = customPropertyKey2;
            str = str2;
        }
        if (parcel.dataPosition() == B) {
            return new CustomProperty(i, customPropertyKey, str);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public CustomProperty[] bx(int i) {
        return new CustomProperty[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aB(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bx(x0);
    }
}
