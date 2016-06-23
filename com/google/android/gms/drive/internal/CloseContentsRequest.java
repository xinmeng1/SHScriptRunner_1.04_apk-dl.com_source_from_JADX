package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class CloseContentsRequest implements SafeParcelable {
    public static final Creator<CloseContentsRequest> CREATOR;
    final Contents Iw;
    final Boolean Iz;
    final int xM;

    static {
        CREATOR = new C0215f();
    }

    CloseContentsRequest(int versionCode, Contents contentsReference, Boolean saveResults) {
        this.xM = versionCode;
        this.Iw = contentsReference;
        this.Iz = saveResults;
    }

    public CloseContentsRequest(Contents contentsReference, boolean saveResults) {
        this(1, contentsReference, Boolean.valueOf(saveResults));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0215f.m344a(this, dest, flags);
    }
}
