package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ReferenceShiftedDetails implements SafeParcelable {
    public static final Creator<ReferenceShiftedDetails> CREATOR;
    final String LH;
    final String LI;
    final int LJ;
    final int LK;
    final int xM;

    static {
        CREATOR = new C0257d();
    }

    ReferenceShiftedDetails(int versionCode, String oldObjectId, String newObjectId, int oldIndex, int newIndex) {
        this.xM = versionCode;
        this.LH = oldObjectId;
        this.LI = newObjectId;
        this.LJ = oldIndex;
        this.LK = newIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0257d.m395a(this, dest, flags);
    }
}
