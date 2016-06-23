package com.google.android.gms.internal;

import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

public final class bw implements MediationAdRequest {
    private final Date f57d;
    private final Set<String> f58f;
    private final boolean f59g;
    private final int ml;
    private final int nR;

    public bw(Date date, int i, Set<String> set, boolean z, int i2) {
        this.f57d = date;
        this.ml = i;
        this.f58f = set;
        this.f59g = z;
        this.nR = i2;
    }

    public Date getBirthday() {
        return this.f57d;
    }

    public int getGender() {
        return this.ml;
    }

    public Set<String> getKeywords() {
        return this.f58f;
    }

    public boolean isTesting() {
        return this.f59g;
    }

    public int taggedForChildDirectedTreatment() {
        return this.nR;
    }
}
