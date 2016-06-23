package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;

public class StreetViewPanoramaLocation implements SafeParcelable {
    public static final StreetViewPanoramaLocationCreator CREATOR;
    public final StreetViewPanoramaLink[] links;
    public final String panoId;
    public final LatLng position;
    private final int xM;

    static {
        CREATOR = new StreetViewPanoramaLocationCreator();
    }

    StreetViewPanoramaLocation(int versionCode, StreetViewPanoramaLink[] links, LatLng position, String panoId) {
        this.xM = versionCode;
        this.links = links;
        this.position = position;
        this.panoId = panoId;
    }

    public StreetViewPanoramaLocation(StreetViewPanoramaLink[] links, LatLng position, String panoId) {
        this(1, links, position, panoId);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StreetViewPanoramaLocation)) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) o;
        return this.panoId.equals(streetViewPanoramaLocation.panoId) && this.position.equals(streetViewPanoramaLocation.position);
    }

    int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return hk.hashCode(this.position, this.panoId);
    }

    public String toString() {
        return hk.m1221e(this).m1220a("panoId", this.panoId).m1220a("position", this.position.toString()).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        StreetViewPanoramaLocationCreator.m1522a(this, out, flags);
    }
}
