package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0199a;
import com.google.android.gms.common.internal.safeparcel.C0199a.C0198a;
import com.google.android.gms.common.internal.safeparcel.C0200b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;
import java.util.List;

public class PolygonOptionsCreator implements Creator<PolygonOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1518a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int C = C0200b.m232C(parcel);
        C0200b.m259c(parcel, 1, polygonOptions.getVersionCode());
        C0200b.m258b(parcel, 2, polygonOptions.getPoints(), false);
        C0200b.m260c(parcel, 3, polygonOptions.jP(), false);
        C0200b.m238a(parcel, 4, polygonOptions.getStrokeWidth());
        C0200b.m259c(parcel, 5, polygonOptions.getStrokeColor());
        C0200b.m259c(parcel, 6, polygonOptions.getFillColor());
        C0200b.m238a(parcel, 7, polygonOptions.getZIndex());
        C0200b.m250a(parcel, 8, polygonOptions.isVisible());
        C0200b.m250a(parcel, 9, polygonOptions.isGeodesic());
        C0200b.m235G(parcel, C);
    }

    public PolygonOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int B = C0199a.m196B(parcel);
        List list = null;
        List arrayList = new ArrayList();
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0199a.m194A(parcel);
            switch (C0199a.ar(A)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0199a.m212g(parcel, A);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    list = C0199a.m207c(parcel, A, LatLng.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    C0199a.m204a(parcel, A, arrayList, getClass().getClassLoader());
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    f2 = C0199a.m217l(parcel, A);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    i2 = C0199a.m212g(parcel, A);
                    break;
                case Quest.STATE_FAILED /*6*/:
                    i = C0199a.m212g(parcel, A);
                    break;
                case DetectedActivity.WALKING /*7*/:
                    f = C0199a.m217l(parcel, A);
                    break;
                case DetectedActivity.RUNNING /*8*/:
                    z2 = C0199a.m208c(parcel, A);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    z = C0199a.m208c(parcel, A);
                    break;
                default:
                    C0199a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new PolygonOptions(i3, list, arrayList, f2, i2, i, f, z2, z);
        }
        throw new C0198a("Overread allowed size end=" + B, parcel);
    }

    public PolygonOptions[] newArray(int size) {
        return new PolygonOptions[size];
    }
}
