package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;

public class StreetViewPanoramaLink implements SafeParcelable {
    public static final StreetViewPanoramaLinkCreator CREATOR;
    public final float bearing;
    public final String panoId;
    private final int xM;

    static {
        CREATOR = new StreetViewPanoramaLinkCreator();
    }

    StreetViewPanoramaLink(int versionCode, String panoId, float bearing) {
        this.xM = versionCode;
        this.panoId = panoId;
        if (((double) bearing) <= 0.0d) {
            bearing = (bearing % 360.0f) + 360.0f;
        }
        this.bearing = bearing % 360.0f;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StreetViewPanoramaLink)) {
            return false;
        }
        StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) o;
        return this.panoId.equals(streetViewPanoramaLink.panoId) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaLink.bearing);
    }

    int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return hk.hashCode(this.panoId, Float.valueOf(this.bearing));
    }

    public String toString() {
        return hk.m1221e(this).m1220a("panoId", this.panoId).m1220a("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        StreetViewPanoramaLinkCreator.m1521a(this, out, flags);
    }
}
