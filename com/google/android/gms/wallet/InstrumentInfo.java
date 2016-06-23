package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class InstrumentInfo implements SafeParcelable {
    public static final Creator<InstrumentInfo> CREATOR;
    private String ajc;
    private String ajd;
    private final int xM;

    static {
        CREATOR = new C0539h();
    }

    InstrumentInfo(int versionCode, String instrumentType, String instrumentDetails) {
        this.xM = versionCode;
        this.ajc = instrumentType;
        this.ajd = instrumentDetails;
    }

    public int describeContents() {
        return 0;
    }

    public String getInstrumentDetails() {
        return this.ajd;
    }

    public String getInstrumentType() {
        return this.ajc;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0539h.m1779a(this, out, flags);
    }
}
