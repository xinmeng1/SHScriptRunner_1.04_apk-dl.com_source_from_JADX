package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class GroundOverlayOptionsCreator implements Creator<GroundOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1513a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, groundOverlayOptions.getVersionCode());
        C0200b.m241a(parcel, 2, groundOverlayOptions.jN(), false);
        C0200b.m243a(parcel, 3, groundOverlayOptions.getLocation(), i, false);
        C0200b.m238a(parcel, 4, groundOverlayOptions.getWidth());
        C0200b.m238a(parcel, 5, groundOverlayOptions.getHeight());
        C0200b.m243a(parcel, 6, groundOverlayOptions.getBounds(), i, false);
        C0200b.m238a(parcel, 7, groundOverlayOptions.getBearing());
        C0200b.m238a(parcel, 8, groundOverlayOptions.getZIndex());
        C0200b.m250a(parcel, 9, groundOverlayOptions.isVisible());
        C0200b.m238a(parcel, 10, groundOverlayOptions.getTransparency());
        C0200b.m238a(parcel, 11, groundOverlayOptions.getAnchorU());
        C0200b.m238a(parcel, 12, groundOverlayOptions.getAnchorV());
        C0200b.m235G(parcel, C);
    }

    public GroundOverlayOptions createFromParcel(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        IBinder iBinder = null;
        LatLng latLng = null;
        float f = 0.0f;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
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
                    latLng = (LatLng) C0199a.m201a(parcel, A, LatLng.CREATOR);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    f = C0199a.m217l(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    f2 = C0199a.m217l(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    latLngBounds = (LatLngBounds) C0199a.m201a(parcel, A, LatLngBounds.CREATOR);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    f3 = C0199a.m217l(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    f4 = C0199a.m217l(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    f5 = C0199a.m217l(parcel, A);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    f6 = C0199a.m217l(parcel, A);
                    break;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    f7 = C0199a.m217l(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public GroundOverlayOptions[] newArray(int size) {
        return new GroundOverlayOptions[size];
    }
}
