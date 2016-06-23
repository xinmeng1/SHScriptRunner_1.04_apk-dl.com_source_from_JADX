package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ConnectionInfo implements SafeParcelable {
    public static final ConnectionInfoCreator CREATOR;
    private final String Nn;
    private final int No;
    private final int xM;

    static {
        CREATOR = new ConnectionInfoCreator();
    }

    public ConnectionInfo(int versionCode, String clientAddress, int registrationLatency) {
        this.xM = versionCode;
        this.Nn = clientAddress;
        this.No = registrationLatency;
    }

    public int describeContents() {
        return 0;
    }

    public String gW() {
        return this.Nn;
    }

    public int gX() {
        return this.No;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel out, int flags) {
        ConnectionInfoCreator.m478a(this, out, flags);
    }
}
