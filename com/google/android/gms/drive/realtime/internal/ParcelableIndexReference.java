package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableIndexReference implements SafeParcelable {
    public static final Creator<ParcelableIndexReference> CREATOR;
    final String Lq;
    final boolean Lr;
    final int mIndex;
    final int xM;

    static {
        CREATOR = new C0275q();
    }

    ParcelableIndexReference(int versionCode, String objectId, int index, boolean canBeDeleted) {
        this.xM = versionCode;
        this.Lq = objectId;
        this.mIndex = index;
        this.Lr = canBeDeleted;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0275q.m455a(this, dest, flags);
    }
}
