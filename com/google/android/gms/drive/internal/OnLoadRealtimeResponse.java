package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnLoadRealtimeResponse implements SafeParcelable {
    public static final Creator<OnLoadRealtimeResponse> CREATOR;
    final boolean JC;
    final int xM;

    static {
        CREATOR = new an();
    }

    OnLoadRealtimeResponse(int versionCode, boolean isInitialized) {
        this.xM = versionCode;
        this.JC = isInitialized;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        an.m327a(this, dest, flags);
    }
}
