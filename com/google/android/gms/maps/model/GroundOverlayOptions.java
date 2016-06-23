package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0280d.C0688a;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.internal.C0433v;

public final class GroundOverlayOptions implements SafeParcelable {
    public static final GroundOverlayOptionsCreator CREATOR;
    public static final float NO_DIMENSION = -1.0f;
    private BitmapDescriptor aaA;
    private LatLng aaB;
    private float aaC;
    private float aaD;
    private LatLngBounds aaE;
    private float aaF;
    private float aaG;
    private float aaH;
    private float aaq;
    private float aax;
    private boolean aay;
    private final int xM;

    static {
        CREATOR = new GroundOverlayOptionsCreator();
    }

    public GroundOverlayOptions() {
        this.aay = true;
        this.aaF = 0.0f;
        this.aaG = 0.5f;
        this.aaH = 0.5f;
        this.xM = 1;
    }

    GroundOverlayOptions(int versionCode, IBinder wrappedImage, LatLng location, float width, float height, LatLngBounds bounds, float bearing, float zIndex, boolean visible, float transparency, float anchorU, float anchorV) {
        this.aay = true;
        this.aaF = 0.0f;
        this.aaG = 0.5f;
        this.aaH = 0.5f;
        this.xM = versionCode;
        this.aaA = new BitmapDescriptor(C0688a.ag(wrappedImage));
        this.aaB = location;
        this.aaC = width;
        this.aaD = height;
        this.aaE = bounds;
        this.aaq = bearing;
        this.aax = zIndex;
        this.aay = visible;
        this.aaF = transparency;
        this.aaG = anchorU;
        this.aaH = anchorV;
    }

    private GroundOverlayOptions m2864a(LatLng latLng, float f, float f2) {
        this.aaB = latLng;
        this.aaC = f;
        this.aaD = f2;
        return this;
    }

    public GroundOverlayOptions anchor(float u, float v) {
        this.aaG = u;
        this.aaH = v;
        return this;
    }

    public GroundOverlayOptions bearing(float bearing) {
        this.aaq = ((bearing % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.aaG;
    }

    public float getAnchorV() {
        return this.aaH;
    }

    public float getBearing() {
        return this.aaq;
    }

    public LatLngBounds getBounds() {
        return this.aaE;
    }

    public float getHeight() {
        return this.aaD;
    }

    public BitmapDescriptor getImage() {
        return this.aaA;
    }

    public LatLng getLocation() {
        return this.aaB;
    }

    public float getTransparency() {
        return this.aaF;
    }

    int getVersionCode() {
        return this.xM;
    }

    public float getWidth() {
        return this.aaC;
    }

    public float getZIndex() {
        return this.aax;
    }

    public GroundOverlayOptions image(BitmapDescriptor image) {
        this.aaA = image;
        return this;
    }

    public boolean isVisible() {
        return this.aay;
    }

    IBinder jN() {
        return this.aaA.jn().asBinder();
    }

    public GroundOverlayOptions position(LatLng location, float width) {
        boolean z = true;
        hm.m1226a(this.aaE == null, "Position has already been set using positionFromBounds");
        hm.m1230b(location != null, (Object) "Location must be specified");
        if (width < 0.0f) {
            z = false;
        }
        hm.m1230b(z, (Object) "Width must be non-negative");
        return m2864a(location, width, NO_DIMENSION);
    }

    public GroundOverlayOptions position(LatLng location, float width, float height) {
        boolean z = true;
        hm.m1226a(this.aaE == null, "Position has already been set using positionFromBounds");
        hm.m1230b(location != null, (Object) "Location must be specified");
        hm.m1230b(width >= 0.0f, (Object) "Width must be non-negative");
        if (height < 0.0f) {
            z = false;
        }
        hm.m1230b(z, (Object) "Height must be non-negative");
        return m2864a(location, width, height);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds bounds) {
        hm.m1227a(this.aaB == null, "Position has already been set using position: %s", this.aaB);
        this.aaE = bounds;
        return this;
    }

    public GroundOverlayOptions transparency(float transparency) {
        boolean z = transparency >= 0.0f && transparency <= TextTrackStyle.DEFAULT_FONT_SCALE;
        hm.m1230b(z, (Object) "Transparency must be in the range [0..1]");
        this.aaF = transparency;
        return this;
    }

    public GroundOverlayOptions visible(boolean visible) {
        this.aay = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0433v.jL()) {
            C0436c.m1529a(this, out, flags);
        } else {
            GroundOverlayOptionsCreator.m1513a(this, out, flags);
        }
    }

    public GroundOverlayOptions zIndex(float zIndex) {
        this.aax = zIndex;
        return this;
    }
}
