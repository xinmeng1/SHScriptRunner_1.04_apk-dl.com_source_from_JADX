package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.v */
public final class C0826v implements SafeParcelable {
    public static final C0404w CREATOR;
    public final boolean lb;
    public final boolean ld;
    public final int versionCode;

    static {
        CREATOR = new C0404w();
    }

    C0826v(int i, boolean z, boolean z2) {
        this.versionCode = i;
        this.lb = z;
        this.ld = z2;
    }

    public C0826v(boolean z, boolean z2) {
        this.versionCode = 1;
        this.lb = z;
        this.ld = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0404w.m1467a(this, out, flags);
    }
}
