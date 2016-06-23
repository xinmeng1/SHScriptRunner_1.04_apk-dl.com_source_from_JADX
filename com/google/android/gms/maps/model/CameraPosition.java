package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C0128R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.internal.C0433v;

public final class CameraPosition implements SafeParcelable {
    public static final CameraPositionCreator CREATOR;
    public final float bearing;
    public final LatLng target;
    public final float tilt;
    private final int xM;
    public final float zoom;

    public static final class Builder {
        private LatLng aan;
        private float aao;
        private float aap;
        private float aaq;

        public Builder(CameraPosition previous) {
            this.aan = previous.target;
            this.aao = previous.zoom;
            this.aap = previous.tilt;
            this.aaq = previous.bearing;
        }

        public Builder bearing(float bearing) {
            this.aaq = bearing;
            return this;
        }

        public CameraPosition build() {
            return new CameraPosition(this.aan, this.aao, this.aap, this.aaq);
        }

        public Builder target(LatLng location) {
            this.aan = location;
            return this;
        }

        public Builder tilt(float tilt) {
            this.aap = tilt;
            return this;
        }

        public Builder zoom(float zoom) {
            this.aao = zoom;
            return this;
        }
    }

    static {
        CREATOR = new CameraPositionCreator();
    }

    CameraPosition(int versionCode, LatLng target, float zoom, float tilt, float bearing) {
        hm.m1228b((Object) target, (Object) "null camera target");
        boolean z = 0.0f <= tilt && tilt <= 90.0f;
        hm.m1230b(z, (Object) "Tilt needs to be between 0 and 90 inclusive");
        this.xM = versionCode;
        this.target = target;
        this.zoom = zoom;
        this.tilt = tilt + 0.0f;
        if (((double) bearing) <= 0.0d) {
            bearing = (bearing % 360.0f) + 360.0f;
        }
        this.bearing = bearing % 360.0f;
    }

    public CameraPosition(LatLng target, float zoom, float tilt, float bearing) {
        this(1, target, zoom, tilt, bearing);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition camera) {
        return new Builder(camera);
    }

    public static CameraPosition createFromAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, C0128R.styleable.MapAttrs);
        LatLng latLng = new LatLng((double) (obtainAttributes.hasValue(2) ? obtainAttributes.getFloat(2, 0.0f) : 0.0f), (double) (obtainAttributes.hasValue(3) ? obtainAttributes.getFloat(3, 0.0f) : 0.0f));
        Builder builder = builder();
        builder.target(latLng);
        if (obtainAttributes.hasValue(5)) {
            builder.zoom(obtainAttributes.getFloat(5, 0.0f));
        }
        if (obtainAttributes.hasValue(1)) {
            builder.bearing(obtainAttributes.getFloat(1, 0.0f));
        }
        if (obtainAttributes.hasValue(4)) {
            builder.tilt(obtainAttributes.getFloat(4, 0.0f));
        }
        return builder.build();
    }

    public static final CameraPosition fromLatLngZoom(LatLng target, float zoom) {
        return new CameraPosition(target, zoom, 0.0f, 0.0f);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) o;
        return this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing);
    }

    int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return hk.hashCode(this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    public String toString() {
        return hk.m1221e(this).m1220a("target", this.target).m1220a("zoom", Float.valueOf(this.zoom)).m1220a("tilt", Float.valueOf(this.tilt)).m1220a("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0433v.jL()) {
            C0434a.m1527a(this, out, flags);
        } else {
            CameraPositionCreator.m1511a(this, out, flags);
        }
    }
}
