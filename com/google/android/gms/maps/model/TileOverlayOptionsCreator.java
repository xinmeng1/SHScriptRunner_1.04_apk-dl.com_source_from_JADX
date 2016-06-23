package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class TileOverlayOptionsCreator implements Creator<TileOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1525a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0200b.m241a(parcel, 2, tileOverlayOptions.jQ(), false);
        C0200b.m250a(parcel, 3, tileOverlayOptions.isVisible());
        C0200b.m238a(parcel, 4, tileOverlayOptions.getZIndex());
        C0200b.m250a(parcel, 5, tileOverlayOptions.getFadeIn());
        C0200b.m235G(parcel, C);
    }

    public TileOverlayOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int B = C0199a.m196B(parcel);
        IBinder iBinder = null;
        float f = 0.0f;
        boolean z2 = true;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    iBinder = C0199a.m221p(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    f = C0199a.m217l(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    z2 = C0199a.m208c(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new TileOverlayOptions(i, iBinder, z, f, z2);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public TileOverlayOptions[] newArray(int size) {
        return new TileOverlayOptions[size];
    }
}
