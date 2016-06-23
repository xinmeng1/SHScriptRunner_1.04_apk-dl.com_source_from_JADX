package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class MarkerOptionsCreator implements Creator<MarkerOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1517a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, markerOptions.getVersionCode());
        C0200b.m243a(parcel, 2, markerOptions.getPosition(), i, false);
        C0200b.m247a(parcel, 3, markerOptions.getTitle(), false);
        C0200b.m247a(parcel, 4, markerOptions.getSnippet(), false);
        C0200b.m241a(parcel, 5, markerOptions.jO(), false);
        C0200b.m238a(parcel, 6, markerOptions.getAnchorU());
        C0200b.m238a(parcel, 7, markerOptions.getAnchorV());
        C0200b.m250a(parcel, 8, markerOptions.isDraggable());
        C0200b.m250a(parcel, 9, markerOptions.isVisible());
        C0200b.m250a(parcel, 10, markerOptions.isFlat());
        C0200b.m238a(parcel, 11, markerOptions.getRotation());
        C0200b.m238a(parcel, 12, markerOptions.getInfoWindowAnchorU());
        C0200b.m238a(parcel, 13, markerOptions.getInfoWindowAnchorV());
        C0200b.m238a(parcel, 14, markerOptions.getAlpha());
        C0200b.m235G(parcel, C);
    }

    public MarkerOptions createFromParcel(Parcel parcel) {
        int B = C0199a.m196B(parcel);
        int i = 0;
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = TextTrackStyle.DEFAULT_FONT_SCALE;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    latLng = (LatLng) C0199a.m201a(parcel, A, LatLng.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str2 = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    iBinder = C0199a.m221p(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    f = C0199a.m217l(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    f2 = C0199a.m217l(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    z2 = C0199a.m208c(parcel, A);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    z3 = C0199a.m208c(parcel, A);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    f3 = C0199a.m217l(parcel, A);
                    break;
                case CommonStatusCodes.DATE_INVALID /*12*/:
                    f4 = C0199a.m217l(parcel, A);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    f5 = C0199a.m217l(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    f6 = C0199a.m217l(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new MarkerOptions(i, latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public MarkerOptions[] newArray(int size) {
        return new MarkerOptions[size];
    }
}
