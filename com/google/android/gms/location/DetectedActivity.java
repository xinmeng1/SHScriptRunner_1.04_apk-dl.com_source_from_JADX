package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DetectedActivity implements SafeParcelable {
    public static final DetectedActivityCreator CREATOR;
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int RUNNING = 8;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    public static final int WALKING = 7;
    int UY;
    int UZ;
    private final int xM;

    static {
        CREATOR = new DetectedActivityCreator();
    }

    public DetectedActivity(int activityType, int confidence) {
        this.xM = ON_BICYCLE;
        this.UY = activityType;
        this.UZ = confidence;
    }

    public DetectedActivity(int versionCode, int activityType, int confidence) {
        this.xM = versionCode;
        this.UY = activityType;
        this.UZ = confidence;
    }

    private int cF(int i) {
        return i > RUNNING ? UNKNOWN : i;
    }

    public int describeContents() {
        return IN_VEHICLE;
    }

    public int getConfidence() {
        return this.UZ;
    }

    public int getType() {
        return cF(this.UY);
    }

    public int getVersionCode() {
        return this.xM;
    }

    public String toString() {
        return "DetectedActivity [type=" + getType() + ", confidence=" + this.UZ + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        DetectedActivityCreator.m1476a(this, out, flags);
    }
}
