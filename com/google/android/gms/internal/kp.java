package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.internal.hy.C0785a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class kp extends hy implements SafeParcelable, Moment {
    public static final kq CREATOR;
    private static final HashMap<String, C0785a<?, ?>> acr;
    private final Set<Integer> acs;
    private String adf;
    private kn adn;
    private kn ado;
    private String qX;
    private String xG;
    private final int xM;

    static {
        CREATOR = new kq();
        acr = new HashMap();
        acr.put("id", C0785a.m2725j("id", 2));
        acr.put("result", C0785a.m2719a("result", 4, kn.class));
        acr.put("startDate", C0785a.m2725j("startDate", 5));
        acr.put("target", C0785a.m2719a("target", 6, kn.class));
        acr.put("type", C0785a.m2725j("type", 7));
    }

    public kp() {
        this.xM = 1;
        this.acs = new HashSet();
    }

    kp(Set<Integer> set, int i, String str, kn knVar, String str2, kn knVar2, String str3) {
        this.acs = set;
        this.xM = i;
        this.xG = str;
        this.adn = knVar;
        this.adf = str2;
        this.ado = knVar2;
        this.qX = str3;
    }

    public kp(Set<Integer> set, String str, kn knVar, String str2, kn knVar2, String str3) {
        this.acs = set;
        this.xM = 1;
        this.xG = str;
        this.adn = knVar;
        this.adf = str2;
        this.ado = knVar2;
        this.qX = str3;
    }

    protected boolean m3697a(C0785a c0785a) {
        return this.acs.contains(Integer.valueOf(c0785a.fN()));
    }

    protected Object aF(String str) {
        return null;
    }

    protected boolean aG(String str) {
        return false;
    }

    protected Object m3698b(C0785a c0785a) {
        switch (c0785a.fN()) {
            case DataEvent.TYPE_DELETED /*2*/:
                return this.xG;
            case DetectedActivity.UNKNOWN /*4*/:
                return this.adn;
            case DetectedActivity.TILTING /*5*/:
                return this.adf;
            case Quest.STATE_FAILED /*6*/:
                return this.ado;
            case DetectedActivity.WALKING /*7*/:
                return this.qX;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + c0785a.fN());
        }
    }

    public int describeContents() {
        kq kqVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof kp)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        kp kpVar = (kp) obj;
        for (C0785a c0785a : acr.values()) {
            if (m3697a(c0785a)) {
                if (!kpVar.m3697a(c0785a)) {
                    return false;
                }
                if (!m3698b(c0785a).equals(kpVar.m3698b(c0785a))) {
                    return false;
                }
            } else if (kpVar.m3697a(c0785a)) {
                return false;
            }
        }
        return true;
    }

    public HashMap<String, C0785a<?, ?>> fG() {
        return acr;
    }

    public /* synthetic */ Object freeze() {
        return kD();
    }

    public String getId() {
        return this.xG;
    }

    public ItemScope getResult() {
        return this.adn;
    }

    public String getStartDate() {
        return this.adf;
    }

    public ItemScope getTarget() {
        return this.ado;
    }

    public String getType() {
        return this.qX;
    }

    int getVersionCode() {
        return this.xM;
    }

    public boolean hasId() {
        return this.acs.contains(Integer.valueOf(2));
    }

    public boolean hasResult() {
        return this.acs.contains(Integer.valueOf(4));
    }

    public boolean hasStartDate() {
        return this.acs.contains(Integer.valueOf(5));
    }

    public boolean hasTarget() {
        return this.acs.contains(Integer.valueOf(6));
    }

    public boolean hasType() {
        return this.acs.contains(Integer.valueOf(7));
    }

    public int hashCode() {
        int i = 0;
        for (C0785a c0785a : acr.values()) {
            int hashCode;
            if (m3697a(c0785a)) {
                hashCode = m3698b(c0785a).hashCode() + (i + c0785a.fN());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    kn kB() {
        return this.adn;
    }

    kn kC() {
        return this.ado;
    }

    public kp kD() {
        return this;
    }

    Set<Integer> kk() {
        return this.acs;
    }

    public void writeToParcel(Parcel out, int flags) {
        kq kqVar = CREATOR;
        kq.m1329a(this, out, flags);
    }
}
