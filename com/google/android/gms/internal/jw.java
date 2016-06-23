package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class jw implements SafeParcelable {
    public static final jx CREATOR;
    public static final jw YP;
    public static final jw YQ;
    public static final Set<jw> YR;
    final int YS;
    final String qX;
    final int xM;

    static {
        YP = m2780w("test_type", 1);
        YQ = m2780w("saved_offers", 4);
        YR = Collections.unmodifiableSet(new HashSet(Arrays.asList(new jw[]{YP, YQ})));
        CREATOR = new jx();
    }

    jw(int i, String str, int i2) {
        hm.aE(str);
        this.xM = i;
        this.qX = str;
        this.YS = i2;
    }

    private static jw m2780w(String str, int i) {
        return new jw(0, str, i);
    }

    public int describeContents() {
        jx jxVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof jw)) {
            return false;
        }
        jw jwVar = (jw) object;
        return this.qX.equals(jwVar.qX) && this.YS == jwVar.YS;
    }

    public int hashCode() {
        return this.qX.hashCode();
    }

    public String toString() {
        return this.qX;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        jx jxVar = CREATOR;
        jx.m1313a(this, parcel, flags);
    }
}
