package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hy.C0381b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class hv implements SafeParcelable, C0381b<String, Integer> {
    public static final hw CREATOR;
    private final HashMap<String, Integer> GW;
    private final HashMap<Integer, String> GX;
    private final ArrayList<C0784a> GY;
    private final int xM;

    /* renamed from: com.google.android.gms.internal.hv.a */
    public static final class C0784a implements SafeParcelable {
        public static final hx CREATOR;
        final String GZ;
        final int Ha;
        final int versionCode;

        static {
            CREATOR = new hx();
        }

        C0784a(int i, String str, int i2) {
            this.versionCode = i;
            this.GZ = str;
            this.Ha = i2;
        }

        C0784a(String str, int i) {
            this.versionCode = 1;
            this.GZ = str;
            this.Ha = i;
        }

        public int describeContents() {
            hx hxVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            hx hxVar = CREATOR;
            hx.m1246a(this, out, flags);
        }
    }

    static {
        CREATOR = new hw();
    }

    public hv() {
        this.xM = 1;
        this.GW = new HashMap();
        this.GX = new HashMap();
        this.GY = null;
    }

    hv(int i, ArrayList<C0784a> arrayList) {
        this.xM = i;
        this.GW = new HashMap();
        this.GX = new HashMap();
        this.GY = null;
        m2714a((ArrayList) arrayList);
    }

    private void m2714a(ArrayList<C0784a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0784a c0784a = (C0784a) it.next();
            m2716f(c0784a.GZ, c0784a.Ha);
        }
    }

    public String m2715a(Integer num) {
        String str = (String) this.GX.get(num);
        return (str == null && this.GW.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public int describeContents() {
        hw hwVar = CREATOR;
        return 0;
    }

    public hv m2716f(String str, int i) {
        this.GW.put(str, Integer.valueOf(i));
        this.GX.put(Integer.valueOf(i), str);
        return this;
    }

    ArrayList<C0784a> fD() {
        ArrayList<C0784a> arrayList = new ArrayList();
        for (String str : this.GW.keySet()) {
            arrayList.add(new C0784a(str, ((Integer) this.GW.get(str)).intValue()));
        }
        return arrayList;
    }

    public int fE() {
        return 7;
    }

    public int fF() {
        return 0;
    }

    public /* synthetic */ Object m2717g(Object obj) {
        return m2715a((Integer) obj);
    }

    int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel out, int flags) {
        hw hwVar = CREATOR;
        hw.m1244a(this, out, flags);
    }
}
