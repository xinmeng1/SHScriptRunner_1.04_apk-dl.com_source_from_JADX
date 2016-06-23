package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class ka implements SafeParcelable {
    public static final kb CREATOR;
    public final String YV;
    public final String YW;
    public final int versionCode;

    static {
        CREATOR = new kb();
    }

    public ka(int i, String str, String str2) {
        this.versionCode = i;
        this.YV = str;
        this.YW = str2;
    }

    public ka(String str, Locale locale) {
        this.versionCode = 0;
        this.YV = str;
        this.YW = locale.toString();
    }

    public int describeContents() {
        kb kbVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || !(object instanceof ka)) {
            return false;
        }
        ka kaVar = (ka) object;
        return this.YW.equals(kaVar.YW) && this.YV.equals(kaVar.YV);
    }

    public int hashCode() {
        return hk.hashCode(this.YV, this.YW);
    }

    public String toString() {
        return hk.m1221e(this).m1220a("clientPackageName", this.YV).m1220a("locale", this.YW).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        kb kbVar = CREATOR;
        kb.m1325a(this, out, flags);
    }
}
