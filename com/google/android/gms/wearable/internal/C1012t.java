package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* renamed from: com.google.android.gms.wearable.internal.t */
public class C1012t implements SafeParcelable {
    public static final Creator<C1012t> CREATOR;
    public final List<ai> alN;
    public final int statusCode;
    public final int versionCode;

    static {
        CREATOR = new C0573u();
    }

    C1012t(int i, int i2, List<ai> list) {
        this.versionCode = i;
        this.statusCode = i2;
        this.alN = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0573u.m1852a(this, dest, flags);
    }
}
