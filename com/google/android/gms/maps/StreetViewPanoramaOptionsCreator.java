package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.wearable.DataEvent;

public class StreetViewPanoramaOptionsCreator implements Creator<StreetViewPanoramaOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1483a(StreetViewPanoramaOptions streetViewPanoramaOptions, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, streetViewPanoramaOptions.getVersionCode());
        C0200b.m243a(parcel, 2, streetViewPanoramaOptions.getStreetViewPanoramaCamera(), i, false);
        C0200b.m247a(parcel, 3, streetViewPanoramaOptions.getPanoramaId(), false);
        C0200b.m243a(parcel, 4, streetViewPanoramaOptions.getPosition(), i, false);
        C0200b.m245a(parcel, 5, streetViewPanoramaOptions.getRadius(), false);
        C0200b.m236a(parcel, 6, streetViewPanoramaOptions.jD());
        C0200b.m236a(parcel, 7, streetViewPanoramaOptions.jv());
        C0200b.m236a(parcel, 8, streetViewPanoramaOptions.jE());
        C0200b.m236a(parcel, 9, streetViewPanoramaOptions.jF());
        C0200b.m236a(parcel, 10, streetViewPanoramaOptions.jr());
        C0200b.m235G(parcel, C);
    }

    public StreetViewPanoramaOptions createFromParcel(Parcel parcel) {
        Integer num = null;
        byte b = (byte) 0;
        int B = C0199a.m196B(parcel);
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        LatLng latLng = null;
        String str = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) C0199a.m201a(parcel, A, StreetViewPanoramaCamera.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0199a.m220o(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    latLng = (LatLng) C0199a.m201a(parcel, A, LatLng.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    num = C0199a.m213h(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    b5 = C0199a.m210e(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    b4 = C0199a.m210e(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    b3 = C0199a.m210e(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    b2 = C0199a.m210e(parcel, A);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    b = C0199a.m210e(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new StreetViewPanoramaOptions(i, streetViewPanoramaCamera, str, latLng, num, b5, b4, b3, b2, b);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public StreetViewPanoramaOptions[] newArray(int size) {
        return new StreetViewPanoramaOptions[size];
    }
}
