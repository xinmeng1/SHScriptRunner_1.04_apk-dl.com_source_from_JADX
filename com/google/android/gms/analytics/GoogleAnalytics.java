package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.gms.analytics.C0166u.C0165a;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class GoogleAnalytics extends TrackerHandler {
    private static boolean wm;
    private static GoogleAnalytics wt;
    private Context mContext;
    private String tC;
    private String tD;
    private C0142f tV;
    private boolean wn;
    private af wo;
    private volatile Boolean wp;
    private Logger wq;
    private Set<C0133a> wr;
    private boolean ws;

    /* renamed from: com.google.android.gms.analytics.GoogleAnalytics.a */
    interface C0133a {
        void m31h(Activity activity);

        void m32i(Activity activity);
    }

    /* renamed from: com.google.android.gms.analytics.GoogleAnalytics.b */
    class C0134b implements ActivityLifecycleCallbacks {
        final /* synthetic */ GoogleAnalytics wu;

        C0134b(GoogleAnalytics googleAnalytics) {
            this.wu = googleAnalytics;
        }

        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        public void onActivityStarted(Activity activity) {
            this.wu.m1861f(activity);
        }

        public void onActivityStopped(Activity activity) {
            this.wu.m1862g(activity);
        }
    }

    protected GoogleAnalytics(Context context) {
        this(context, C0616t.m1954x(context), C0613r.cE());
    }

    private GoogleAnalytics(Context context, C0142f thread, af serviceManager) {
        this.wp = Boolean.valueOf(false);
        this.ws = false;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.tV = thread;
        this.wo = serviceManager;
        C0609g.m1909u(this.mContext);
        ae.m1887u(this.mContext);
        C0610h.m1915u(this.mContext);
        this.wq = new C0611l();
        this.wr = new HashSet();
        dj();
    }

    private int m1857P(String str) {
        String toLowerCase = str.toLowerCase();
        return "verbose".equals(toLowerCase) ? 0 : "info".equals(toLowerCase) ? 1 : "warning".equals(toLowerCase) ? 2 : "error".equals(toLowerCase) ? 3 : -1;
    }

    private Tracker m1858a(Tracker tracker) {
        if (this.tC != null) {
            tracker.set("&an", this.tC);
        }
        if (this.tD != null) {
            tracker.set("&av", this.tD);
        }
        return tracker;
    }

    static GoogleAnalytics di() {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            googleAnalytics = wt;
        }
        return googleAnalytics;
    }

    private void dj() {
        if (!wm) {
            ApplicationInfo applicationInfo;
            try {
                applicationInfo = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 129);
            } catch (NameNotFoundException e) {
                aa.m39C("PackageManager doesn't know about package: " + e);
                applicationInfo = null;
            }
            if (applicationInfo == null) {
                aa.m40D("Couldn't get ApplicationInfo to load gloabl config.");
                return;
            }
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
                if (i > 0) {
                    C0619w c0619w = (C0619w) new C0618v(this.mContext).m68r(i);
                    if (c0619w != null) {
                        m1864a(c0619w);
                    }
                }
            }
        }
    }

    private void m1861f(Activity activity) {
        for (C0133a h : this.wr) {
            h.m31h(activity);
        }
    }

    private void m1862g(Activity activity) {
        for (C0133a i : this.wr) {
            i.m32i(activity);
        }
    }

    public static GoogleAnalytics getInstance(Context context) {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            if (wt == null) {
                wt = new GoogleAnalytics(context);
            }
            googleAnalytics = wt;
        }
        return googleAnalytics;
    }

    void m1863a(C0133a c0133a) {
        this.wr.add(c0133a);
    }

    void m1864a(C0619w c0619w) {
        aa.m39C("Loading global config values.");
        if (c0619w.cY()) {
            this.tC = c0619w.cZ();
            aa.m39C("app name loaded: " + this.tC);
        }
        if (c0619w.da()) {
            this.tD = c0619w.db();
            aa.m39C("app version loaded: " + this.tD);
        }
        if (c0619w.dc()) {
            int P = m1857P(c0619w.dd());
            if (P >= 0) {
                aa.m39C("log level loaded: " + P);
                getLogger().setLogLevel(P);
            }
        }
        if (c0619w.de()) {
            this.wo.setLocalDispatchPeriod(c0619w.df());
        }
        if (c0619w.dg()) {
            setDryRun(c0619w.dh());
        }
    }

    void m1865b(C0133a c0133a) {
        this.wr.remove(c0133a);
    }

    @Deprecated
    public void dispatchLocalHits() {
        this.wo.dispatchLocalHits();
    }

    public void enableAutoActivityReports(Application application) {
        if (VERSION.SDK_INT >= 14 && !this.ws) {
            application.registerActivityLifecycleCallbacks(new C0134b(this));
            this.ws = true;
        }
    }

    public boolean getAppOptOut() {
        C0166u.cU().m83a(C0165a.GET_APP_OPT_OUT);
        return this.wp.booleanValue();
    }

    public Logger getLogger() {
        return this.wq;
    }

    public boolean isDryRunEnabled() {
        C0166u.cU().m83a(C0165a.GET_DRY_RUN);
        return this.wn;
    }

    public Tracker newTracker(int configResId) {
        Tracker a;
        synchronized (this) {
            C0166u.cU().m83a(C0165a.GET_TRACKER);
            Tracker tracker = new Tracker(null, this, this.mContext);
            if (configResId > 0) {
                aj ajVar = (aj) new ai(this.mContext).m68r(configResId);
                if (ajVar != null) {
                    tracker.m35a(ajVar);
                }
            }
            a = m1858a(tracker);
        }
        return a;
    }

    public Tracker newTracker(String trackingId) {
        Tracker a;
        synchronized (this) {
            C0166u.cU().m83a(C0165a.GET_TRACKER);
            a = m1858a(new Tracker(trackingId, this, this.mContext));
        }
        return a;
    }

    void m1866p(Map<String, String> map) {
        synchronized (this) {
            if (map == null) {
                throw new IllegalArgumentException("hit cannot be null");
            }
            ak.m52a(map, "&ul", ak.m51a(Locale.getDefault()));
            ak.m52a(map, "&sr", ae.dv().getValue("&sr"));
            map.put("&_u", C0166u.cU().cW());
            C0166u.cU().cV();
            this.tV.m62p(map);
        }
    }

    public void reportActivityStart(Activity activity) {
        if (!this.ws) {
            m1861f(activity);
        }
    }

    public void reportActivityStop(Activity activity) {
        if (!this.ws) {
            m1862g(activity);
        }
    }

    public void setAppOptOut(boolean optOut) {
        C0166u.cU().m83a(C0165a.SET_APP_OPT_OUT);
        this.wp = Boolean.valueOf(optOut);
        if (this.wp.booleanValue()) {
            this.tV.cl();
        }
    }

    public void setDryRun(boolean dryRun) {
        C0166u.cU().m83a(C0165a.SET_DRY_RUN);
        this.wn = dryRun;
    }

    @Deprecated
    public void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        this.wo.setLocalDispatchPeriod(dispatchPeriodInSeconds);
    }

    public void setLogger(Logger logger) {
        C0166u.cU().m83a(C0165a.SET_LOGGER);
        this.wq = logger;
    }
}
