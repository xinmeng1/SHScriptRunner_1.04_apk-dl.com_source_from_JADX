package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class at {
    public static final String DEVICE_ID_EMULATOR;
    private final Date f44d;
    private final Set<String> f45f;
    private final Location f46h;
    private final String mk;
    private final int ml;
    private final boolean mm;
    private final Bundle mn;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> mo;
    private final String mp;
    private final SearchAdRequest mq;
    private final int mr;
    private final Set<String> ms;

    /* renamed from: com.google.android.gms.internal.at.a */
    public static final class C0299a {
        private Date f42d;
        private Location f43h;
        private String mk;
        private int ml;
        private boolean mm;
        private final Bundle mn;
        private String mp;
        private int mr;
        private final HashSet<String> mt;
        private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> mu;
        private final HashSet<String> mv;

        public C0299a() {
            this.mt = new HashSet();
            this.mn = new Bundle();
            this.mu = new HashMap();
            this.mv = new HashSet();
            this.ml = -1;
            this.mm = false;
            this.mr = -1;
        }

        public void m809a(Location location) {
            this.f43h = location;
        }

        @Deprecated
        public void m810a(NetworkExtras networkExtras) {
            if (networkExtras instanceof AdMobExtras) {
                m811a(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
            } else {
                this.mu.put(networkExtras.getClass(), networkExtras);
            }
        }

        public void m811a(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.mn.putBundle(cls.getName(), bundle);
        }

        public void m812a(Date date) {
            this.f42d = date;
        }

        public void m813b(Class<? extends CustomEvent> cls, Bundle bundle) {
            if (this.mn.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
                this.mn.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
            }
            this.mn.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
        }

        public void m814e(int i) {
            this.ml = i;
        }

        public void m815g(String str) {
            this.mt.add(str);
        }

        public void m816g(boolean z) {
            this.mm = z;
        }

        public void m817h(String str) {
            this.mv.add(str);
        }

        public void m818h(boolean z) {
            this.mr = z ? 1 : 0;
        }

        public void m819i(String str) {
            this.mk = str;
        }

        public void m820j(String str) {
            this.mp = str;
        }
    }

    static {
        DEVICE_ID_EMULATOR = et.m1010y("emulator");
    }

    public at(C0299a c0299a) {
        this(c0299a, null);
    }

    public at(C0299a c0299a, SearchAdRequest searchAdRequest) {
        this.f44d = c0299a.f42d;
        this.mk = c0299a.mk;
        this.ml = c0299a.ml;
        this.f45f = Collections.unmodifiableSet(c0299a.mt);
        this.f46h = c0299a.f43h;
        this.mm = c0299a.mm;
        this.mn = c0299a.mn;
        this.mo = Collections.unmodifiableMap(c0299a.mu);
        this.mp = c0299a.mp;
        this.mq = searchAdRequest;
        this.mr = c0299a.mr;
        this.ms = Collections.unmodifiableSet(c0299a.mv);
    }

    public SearchAdRequest aH() {
        return this.mq;
    }

    public Map<Class<? extends NetworkExtras>, NetworkExtras> aI() {
        return this.mo;
    }

    public Bundle aJ() {
        return this.mn;
    }

    public int aK() {
        return this.mr;
    }

    public Date getBirthday() {
        return this.f44d;
    }

    public String getContentUrl() {
        return this.mk;
    }

    public Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass) {
        Bundle bundle = this.mn.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        return bundle != null ? bundle.getBundle(adapterClass.getClass().getName()) : null;
    }

    public int getGender() {
        return this.ml;
    }

    public Set<String> getKeywords() {
        return this.f45f;
    }

    public Location getLocation() {
        return this.f46h;
    }

    public boolean getManualImpressionsEnabled() {
        return this.mm;
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return (NetworkExtras) this.mo.get(networkExtrasClass);
    }

    public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass) {
        return this.mn.getBundle(adapterClass.getName());
    }

    public String getPublisherProvidedId() {
        return this.mp;
    }

    public boolean isTestDevice(Context context) {
        return this.ms.contains(et.m1009r(context));
    }
}
