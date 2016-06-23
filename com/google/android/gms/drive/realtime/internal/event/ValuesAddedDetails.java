package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesAddedDetails implements SafeParcelable {
    public static final Creator<ValuesAddedDetails> CREATOR;
    final int LF;
    final int LG;
    final String LN;
    final int LO;
    final int mIndex;
    final int xM;

    static {
        CREATOR = new C0261h();
    }

    ValuesAddedDetails(int versionCode, int index, int valueIndex, int valueCount, String movedFromId, int movedFromIndex) {
        this.xM = versionCode;
        this.mIndex = index;
        this.LF = valueIndex;
        this.LG = valueCount;
        this.LN = movedFromId;
        this.LO = movedFromIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0261h.m399a(this, dest, flags);
    }
}
