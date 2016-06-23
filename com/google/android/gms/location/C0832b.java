package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.internal.hk;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.location.b */
public class C0832b implements SafeParcelable {
    public static final C0410c CREATOR;
    int Vq;
    int Vr;
    long Vs;
    private final int xM;

    static {
        CREATOR = new C0410c();
    }

    C0832b(int i, int i2, int i3, long j) {
        this.xM = i;
        this.Vq = i2;
        this.Vr = i3;
        this.Vs = j;
    }

    private String cI(int i) {
        switch (i) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                return "STATUS_SUCCESSFUL";
            case DataEvent.TYPE_DELETED /*2*/:
                return "STATUS_TIMED_OUT_ON_SCAN";
            case DetectedActivity.STILL /*3*/:
                return "STATUS_NO_INFO_IN_DATABASE";
            case DetectedActivity.UNKNOWN /*4*/:
                return "STATUS_INVALID_SCAN";
            case DetectedActivity.TILTING /*5*/:
                return "STATUS_UNABLE_TO_QUERY_DATABASE";
            case Quest.STATE_FAILED /*6*/:
                return "STATUS_SCANS_DISABLED_IN_SETTINGS";
            case DetectedActivity.WALKING /*7*/:
                return "STATUS_LOCATION_DISABLED_IN_SETTINGS";
            case DetectedActivity.RUNNING /*8*/:
                return "STATUS_IN_PROGRESS";
            default:
                return "STATUS_UNKNOWN";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof C0832b)) {
            return false;
        }
        C0832b c0832b = (C0832b) other;
        return this.Vq == c0832b.Vq && this.Vr == c0832b.Vr && this.Vs == c0832b.Vs;
    }

    int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return hk.hashCode(Integer.valueOf(this.Vq), Integer.valueOf(this.Vr), Long.valueOf(this.Vs));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LocationStatus[cell status: ").append(cI(this.Vq));
        stringBuilder.append(", wifi status: ").append(cI(this.Vr));
        stringBuilder.append(", elapsed realtime ns: ").append(this.Vs);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0410c.m1479a(this, parcel, flags);
    }
}
