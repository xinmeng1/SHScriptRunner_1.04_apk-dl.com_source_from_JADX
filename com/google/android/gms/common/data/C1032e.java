package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.common.data.e */
public class C1032e<T extends SafeParcelable> extends DataBuffer<T> {
    private static final String[] EE;
    private final Creator<T> EF;

    static {
        EE = new String[]{"data"};
    }

    public C1032e(DataHolder dataHolder, Creator<T> creator) {
        super(dataHolder);
        this.EF = creator;
    }

    public T ad(int i) {
        byte[] f = this.DG.m2015f("data", i, 0);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(f, 0, f.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) this.EF.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }

    public /* synthetic */ Object get(int x0) {
        return ad(x0);
    }
}
