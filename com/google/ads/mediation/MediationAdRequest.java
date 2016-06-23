package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Date;
import java.util.Set;

@Deprecated
public final class MediationAdRequest {
    private final Date f4d;
    private final Gender f5e;
    private final Set<String> f6f;
    private final boolean f7g;
    private final Location f8h;

    public MediationAdRequest(Date birthday, Gender gender, Set<String> keywords, boolean isTesting, Location location) {
        this.f4d = birthday;
        this.f5e = gender;
        this.f6f = keywords;
        this.f7g = isTesting;
        this.f8h = location;
    }

    public Integer getAgeInYears() {
        return null;
    }

    public Date getBirthday() {
        return this.f4d;
    }

    public Gender getGender() {
        return this.f5e;
    }

    public Set<String> getKeywords() {
        return this.f6f;
    }

    public Location getLocation() {
        return this.f8h;
    }

    public boolean isTesting() {
        return this.f7g;
    }
}
