package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DisconnectRequest implements SafeParcelable {
    public static final Creator<DisconnectRequest> CREATOR;
    final int xM;

    static {
        CREATOR = new C0223o();
    }

    public DisconnectRequest() {
        this(1);
    }

    DisconnectRequest(int versionCode) {
        this.xM = versionCode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0223o.m358a(this, dest, flags);
    }
}
