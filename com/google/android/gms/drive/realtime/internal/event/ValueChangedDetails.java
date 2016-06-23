package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValueChangedDetails implements SafeParcelable {
    public static final Creator<ValueChangedDetails> CREATOR;
    final int LM;
    final int xM;

    static {
        CREATOR = new C0260g();
    }

    ValueChangedDetails(int versionCode, int keyIndex) {
        this.xM = versionCode;
        this.LM = keyIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0260g.m398a(this, dest, flags);
    }
}
