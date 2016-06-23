package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.StorageStats;

public class OnStorageStatsResponse implements SafeParcelable {
    public static final Creator<OnStorageStatsResponse> CREATOR;
    StorageStats JD;
    final int xM;

    static {
        CREATOR = new ap();
    }

    OnStorageStatsResponse(int versionCode, StorageStats storageStats) {
        this.xM = versionCode;
        this.JD = storageStats;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ap.m329a(this, dest, flags);
    }
}
