package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;

public final class Status implements Result, SafeParcelable {
    public static final StatusCreator CREATOR;
    public static final Status En;
    public static final Status Eo;
    public static final Status Ep;
    public static final Status Eq;
    public static final Status Er;
    private final int CT;
    private final String Es;
    private final PendingIntent mPendingIntent;
    private final int xM;

    static {
        En = new Status(0);
        Eo = new Status(14);
        Ep = new Status(8);
        Eq = new Status(15);
        Er = new Status(16);
        CREATOR = new StatusCreator();
    }

    public Status(int statusCode) {
        this(1, statusCode, null, null);
    }

    Status(int versionCode, int statusCode, String statusMessage, PendingIntent pendingIntent) {
        this.xM = versionCode;
        this.CT = statusCode;
        this.Es = statusMessage;
        this.mPendingIntent = pendingIntent;
    }

    public Status(int statusCode, String statusMessage, PendingIntent pendingIntent) {
        this(1, statusCode, statusMessage, pendingIntent);
    }

    private String ex() {
        return this.Es != null ? this.Es : CommonStatusCodes.getStatusCodeString(this.CT);
    }

    public int describeContents() {
        return 0;
    }

    PendingIntent eQ() {
        return this.mPendingIntent;
    }

    @Deprecated
    public ConnectionResult eR() {
        return new ConnectionResult(this.CT, this.mPendingIntent);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.xM == status.xM && this.CT == status.CT && hk.equal(this.Es, status.Es) && hk.equal(this.mPendingIntent, status.mPendingIntent);
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.CT;
    }

    public String getStatusMessage() {
        return this.Es;
    }

    int getVersionCode() {
        return this.xM;
    }

    public boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    public int hashCode() {
        return hk.hashCode(Integer.valueOf(this.xM), Integer.valueOf(this.CT), this.Es, this.mPendingIntent);
    }

    public boolean isCanceled() {
        return this.CT == 16;
    }

    public boolean isInterrupted() {
        return this.CT == 14;
    }

    public boolean isSuccess() {
        return this.CT <= 0;
    }

    public void startResolutionForResult(Activity activity, int requestCode) throws SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), requestCode, null, 0, 0, 0);
        }
    }

    public String toString() {
        return hk.m1221e(this).m1220a("statusCode", ex()).m1220a("resolution", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        StatusCreator.m150a(this, out, flags);
    }
}
