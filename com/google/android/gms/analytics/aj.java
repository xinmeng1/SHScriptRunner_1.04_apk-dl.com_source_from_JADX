package com.google.android.gms.analytics;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

class aj implements C0145j {
    int xA;
    int xB;
    int xC;
    Map<String, String> xD;
    String xx;
    double xy;
    int xz;

    aj() {
        this.xy = -1.0d;
        this.xz = -1;
        this.xA = -1;
        this.xB = -1;
        this.xC = -1;
        this.xD = new HashMap();
    }

    public String m1900T(String str) {
        String str2 = (String) this.xD.get(str);
        return str2 != null ? str2 : str;
    }

    public boolean dE() {
        return this.xx != null;
    }

    public String dF() {
        return this.xx;
    }

    public boolean dG() {
        return this.xy >= 0.0d;
    }

    public double dH() {
        return this.xy;
    }

    public boolean dI() {
        return this.xz >= 0;
    }

    public boolean dJ() {
        return this.xA != -1;
    }

    public boolean dK() {
        return this.xA == 1;
    }

    public boolean dL() {
        return this.xB != -1;
    }

    public boolean dM() {
        return this.xB == 1;
    }

    public boolean dN() {
        return this.xC == 1;
    }

    public int getSessionTimeout() {
        return this.xz;
    }

    public String m1901j(Activity activity) {
        return m1900T(activity.getClass().getCanonicalName());
    }
}
