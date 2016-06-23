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
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.wearable.DataEvent;

public class GoogleMapOptionsCreator implements Creator<GoogleMapOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1481a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, googleMapOptions.getVersionCode());
        C0200b.m236a(parcel, 2, googleMapOptions.jq());
        C0200b.m236a(parcel, 3, googleMapOptions.jr());
        C0200b.m259c(parcel, 4, googleMapOptions.getMapType());
        C0200b.m243a(parcel, 5, googleMapOptions.getCamera(), i, false);
        C0200b.m236a(parcel, 6, googleMapOptions.js());
        C0200b.m236a(parcel, 7, googleMapOptions.jt());
        C0200b.m236a(parcel, 8, googleMapOptions.ju());
        C0200b.m236a(parcel, 9, googleMapOptions.jv());
        C0200b.m236a(parcel, 10, googleMapOptions.jw());
        C0200b.m236a(parcel, 11, googleMapOptions.jx());
        C0200b.m235G(parcel, C);
    }

    public GoogleMapOptions createFromParcel(Parcel parcel) {
        byte b = (byte) 0;
        int B = C0199a.m196B(parcel);
        CameraPosition cameraPosition = null;
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        byte b6 = (byte) 0;
        int i = 0;
        byte b7 = (byte) 0;
        byte b8 = (byte) 0;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    b8 = C0199a.m210e(parcel, A);
                    break;
                case DetectedActivity.STILL /*3*/:
                    b7 = C0199a.m210e(parcel, A);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    cameraPosition = (CameraPosition) C0199a.m201a(parcel, A, CameraPosition.CREATOR);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    b6 = C0199a.m210e(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    b5 = C0199a.m210e(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    b4 = C0199a.m210e(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    b3 = C0199a.m210e(parcel, A);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    b2 = C0199a.m210e(parcel, A);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    b = C0199a.m210e(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new GoogleMapOptions(i2, b8, b7, i, cameraPosition, b6, b5, b4, b3, b2, b);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public GoogleMapOptions[] newArray(int size) {
        return new GoogleMapOptions[size];
    }
}
