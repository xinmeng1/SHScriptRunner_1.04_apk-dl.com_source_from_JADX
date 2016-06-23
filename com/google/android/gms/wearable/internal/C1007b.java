package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ac.C1004a;

/* renamed from: com.google.android.gms.wearable.internal.b */
public class C1007b implements SafeParcelable {
    public static final Creator<C1007b> CREATOR;
    public final IntentFilter[] alA;
    public final ac alz;
    final int xM;

    static {
        CREATOR = new C0568c();
    }

    C1007b(int i, IBinder iBinder, IntentFilter[] intentFilterArr) {
        this.xM = i;
        if (iBinder != null) {
            this.alz = C1004a.bx(iBinder);
        } else {
            this.alz = null;
        }
        this.alA = intentFilterArr;
    }

    public C1007b(av avVar) {
        this.xM = 1;
        this.alz = avVar;
        this.alA = avVar.nu();
    }

    public int describeContents() {
        return 0;
    }

    IBinder no() {
        return this.alz == null ? null : this.alz.asBinder();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0568c.m1847a(this, dest, flags);
    }
}
