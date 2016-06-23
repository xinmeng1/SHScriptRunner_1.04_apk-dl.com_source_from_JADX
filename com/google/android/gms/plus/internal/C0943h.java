package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;
import java.util.Arrays;

/* renamed from: com.google.android.gms.plus.internal.h */
public class C0943h implements SafeParcelable {
    public static final C0465j CREATOR;
    private final String[] abT;
    private final String[] abU;
    private final String[] abV;
    private final String abW;
    private final String abX;
    private final String abY;
    private final String abZ;
    private final PlusCommonExtras aca;
    private final int xM;
    private final String yQ;

    static {
        CREATOR = new C0465j();
    }

    C0943h(int i, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String str5, PlusCommonExtras plusCommonExtras) {
        this.xM = i;
        this.yQ = str;
        this.abT = strArr;
        this.abU = strArr2;
        this.abV = strArr3;
        this.abW = str2;
        this.abX = str3;
        this.abY = str4;
        this.abZ = str5;
        this.aca = plusCommonExtras;
    }

    public C0943h(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, PlusCommonExtras plusCommonExtras) {
        this.xM = 1;
        this.yQ = str;
        this.abT = strArr;
        this.abU = strArr2;
        this.abV = strArr3;
        this.abW = str2;
        this.abX = str3;
        this.abY = str4;
        this.abZ = null;
        this.aca = plusCommonExtras;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0943h)) {
            return false;
        }
        C0943h c0943h = (C0943h) obj;
        return this.xM == c0943h.xM && hk.equal(this.yQ, c0943h.yQ) && Arrays.equals(this.abT, c0943h.abT) && Arrays.equals(this.abU, c0943h.abU) && Arrays.equals(this.abV, c0943h.abV) && hk.equal(this.abW, c0943h.abW) && hk.equal(this.abX, c0943h.abX) && hk.equal(this.abY, c0943h.abY) && hk.equal(this.abZ, c0943h.abZ) && hk.equal(this.aca, c0943h.aca);
    }

    public String getAccountName() {
        return this.yQ;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return hk.hashCode(Integer.valueOf(this.xM), this.yQ, this.abT, this.abU, this.abV, this.abW, this.abX, this.abY, this.abZ, this.aca);
    }

    public String[] jZ() {
        return this.abT;
    }

    public String[] ka() {
        return this.abU;
    }

    public String[] kb() {
        return this.abV;
    }

    public String kc() {
        return this.abW;
    }

    public String kd() {
        return this.abX;
    }

    public String ke() {
        return this.abY;
    }

    public String kf() {
        return this.abZ;
    }

    public PlusCommonExtras kg() {
        return this.aca;
    }

    public Bundle kh() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        this.aca.m2903n(bundle);
        return bundle;
    }

    public String toString() {
        return hk.m1221e(this).m1220a("versionCode", Integer.valueOf(this.xM)).m1220a("accountName", this.yQ).m1220a("requestedScopes", this.abT).m1220a("visibleActivities", this.abU).m1220a("requiredFeatures", this.abV).m1220a("packageNameForAuth", this.abW).m1220a("callingPackageName", this.abX).m1220a("applicationName", this.abY).m1220a("extra", this.aca.toString()).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0465j.m1584a(this, out, flags);
    }
}
