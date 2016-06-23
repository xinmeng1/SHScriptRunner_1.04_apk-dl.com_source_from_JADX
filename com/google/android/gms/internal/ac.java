package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.internal.ae.C0298a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ac implements OnGlobalLayoutListener, OnScrollChangedListener {
    private static final long lG;
    private final ae lA;
    private boolean lB;
    private final WindowManager lC;
    private final PowerManager lD;
    private final KeyguardManager lE;
    private ad lF;
    private boolean lH;
    private long lI;
    private boolean lJ;
    private BroadcastReceiver lK;
    private HashSet<C0408z> lL;
    private boolean lj;
    private final Object ls;
    private final WeakReference<ef> lv;
    private WeakReference<ViewTreeObserver> lw;
    private final WeakReference<View> lx;
    private final aa ly;
    private final Context lz;

    /* renamed from: com.google.android.gms.internal.ac.2 */
    class C02972 extends BroadcastReceiver {
        final /* synthetic */ ac lM;

        C02972(ac acVar) {
            this.lM = acVar;
        }

        public void onReceive(Context context, Intent intent) {
            this.lM.m773e(false);
        }
    }

    /* renamed from: com.google.android.gms.internal.ac.1 */
    class C06931 implements C0298a {
        final /* synthetic */ ac lM;

        C06931(ac acVar) {
            this.lM = acVar;
        }

        public void aE() {
            this.lM.lB = true;
            this.lM.m773e(false);
            this.lM.av();
        }
    }

    /* renamed from: com.google.android.gms.internal.ac.3 */
    class C06943 implements bc {
        final /* synthetic */ ac lM;

        C06943(ac acVar) {
            this.lM = acVar;
        }

        public void m2441b(ex exVar, Map<String, String> map) {
            this.lM.m765a(exVar, (Map) map);
        }
    }

    /* renamed from: com.google.android.gms.internal.ac.4 */
    class C06954 implements bc {
        final /* synthetic */ ac lM;

        C06954(ac acVar) {
            this.lM = acVar;
        }

        public void m2442b(ex exVar, Map<String, String> map) {
            if (map.containsKey("pingType") && "unloadPing".equals(map.get("pingType"))) {
                this.lM.m771c(this.lM.lA);
                eu.m1012B("Unregistered GMSG handlers for: " + this.lM.ly.au());
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ac.5 */
    class C06965 implements bc {
        final /* synthetic */ ac lM;

        C06965(ac acVar) {
            this.lM = acVar;
        }

        public void m2443b(ex exVar, Map<String, String> map) {
            if (map.containsKey("isVisible")) {
                boolean z = "1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible"));
                this.lM.m772d(Boolean.valueOf(z).booleanValue());
            }
        }
    }

    static {
        lG = TimeUnit.MILLISECONDS.toNanos(100);
    }

    public ac(al alVar, ef efVar) {
        this(alVar, efVar, efVar.oy.cd(), efVar.oy, new af(efVar.oy.getContext(), efVar.oy.cd()));
    }

    public ac(al alVar, ef efVar, ev evVar, View view, ae aeVar) {
        this.ls = new Object();
        this.lj = false;
        this.lH = false;
        this.lI = Long.MIN_VALUE;
        this.lL = new HashSet();
        this.lv = new WeakReference(efVar);
        this.lx = new WeakReference(view);
        this.lw = new WeakReference(null);
        this.lJ = true;
        this.ly = new aa(Integer.toString(efVar.hashCode()), evVar, alVar.me, efVar.ry);
        this.lA = aeVar;
        this.lC = (WindowManager) view.getContext().getSystemService("window");
        this.lD = (PowerManager) view.getContext().getApplicationContext().getSystemService("power");
        this.lE = (KeyguardManager) view.getContext().getSystemService("keyguard");
        this.lz = view.getContext().getApplicationContext();
        m764a(aeVar);
        this.lA.m775a(new C06931(this));
        m769b(this.lA);
        eu.m1012B("Tracking ad unit: " + this.ly.au());
    }

    protected int m762a(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    public void m763a(ad adVar) {
        synchronized (this.ls) {
            this.lF = adVar;
        }
    }

    protected void m764a(ae aeVar) {
        aeVar.m778d("http://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.html");
    }

    protected void m765a(ex exVar, Map<String, String> map) {
        m773e(false);
    }

    public void m766a(C0408z c0408z) {
        this.lL.add(c0408z);
    }

    protected void m767a(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        this.lA.m777a("AFMA_updateActiveView", jSONObject2);
    }

    protected boolean m768a(View view, boolean z) {
        return view.getVisibility() == 0 && z && view.isShown() && this.lD.isScreenOn() && !this.lE.inKeyguardRestrictedInputMode();
    }

    protected void aA() {
        View view = (View) this.lx.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.lw.get();
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2 != viewTreeObserver) {
                this.lw = new WeakReference(viewTreeObserver2);
                viewTreeObserver2.addOnScrollChangedListener(this);
                viewTreeObserver2.addOnGlobalLayoutListener(this);
            }
        }
    }

    protected void aB() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.lw.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    protected JSONObject aC() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.ly.as()).put("activeViewJSON", this.ly.at()).put("timestamp", TimeUnit.NANOSECONDS.toMillis(System.nanoTime())).put("adFormat", this.ly.ar()).put("hashCode", this.ly.au());
        return jSONObject;
    }

    protected JSONObject aD() throws JSONException {
        JSONObject aC = aC();
        aC.put("doneReasonCode", "u");
        return aC;
    }

    protected void av() {
        synchronized (this.ls) {
            if (this.lK != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.lK = new C02972(this);
            this.lz.registerReceiver(this.lK, intentFilter);
        }
    }

    protected void aw() {
        synchronized (this.ls) {
            if (this.lK != null) {
                this.lz.unregisterReceiver(this.lK);
                this.lK = null;
            }
        }
    }

    public void ax() {
        synchronized (this.ls) {
            if (this.lJ) {
                aB();
                aw();
                try {
                    m767a(aD());
                } catch (Throwable e) {
                    eu.m1016b("JSON Failure while processing active view data.", e);
                }
                this.lJ = false;
                ay();
                eu.m1012B("Untracked ad unit: " + this.ly.au());
            }
        }
    }

    protected void ay() {
        if (this.lF != null) {
            this.lF.m774a(this);
        }
    }

    public boolean az() {
        boolean z;
        synchronized (this.ls) {
            z = this.lJ;
        }
        return z;
    }

    protected void m769b(ae aeVar) {
        aeVar.m776a("/updateActiveView", new C06943(this));
        aeVar.m776a("/activeViewPingSent", new C06954(this));
        aeVar.m776a("/visibilityChanged", new C06965(this));
        aeVar.m776a("/viewabilityChanged", bb.mT);
    }

    protected JSONObject m770c(View view) throws JSONException {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr);
        view.getLocationInWindow(iArr2);
        JSONObject aC = aC();
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        rect2.right = this.lC.getDefaultDisplay().getWidth();
        rect2.bottom = this.lC.getDefaultDisplay().getHeight();
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, null);
        Rect rect4 = new Rect();
        view.getLocalVisibleRect(rect4);
        aC.put("viewBox", new JSONObject().put("top", m762a(rect2.top, displayMetrics)).put("bottom", m762a(rect2.bottom, displayMetrics)).put("left", m762a(rect2.left, displayMetrics)).put("right", m762a(rect2.right, displayMetrics))).put("adBox", new JSONObject().put("top", m762a(rect.top, displayMetrics)).put("bottom", m762a(rect.bottom, displayMetrics)).put("left", m762a(rect.left, displayMetrics)).put("right", m762a(rect.right, displayMetrics))).put("globalVisibleBox", new JSONObject().put("top", m762a(rect3.top, displayMetrics)).put("bottom", m762a(rect3.bottom, displayMetrics)).put("left", m762a(rect3.left, displayMetrics)).put("right", m762a(rect3.right, displayMetrics))).put("localVisibleBox", new JSONObject().put("top", m762a(rect4.top, displayMetrics)).put("bottom", m762a(rect4.bottom, displayMetrics)).put("left", m762a(rect4.left, displayMetrics)).put("right", m762a(rect4.right, displayMetrics))).put("screenDensity", (double) displayMetrics.density).put("isVisible", m768a(view, globalVisibleRect)).put("isStopped", this.lH).put("isPaused", this.lj);
        return aC;
    }

    protected void m771c(ae aeVar) {
        aeVar.m779e("/viewabilityChanged");
        aeVar.m779e("/visibilityChanged");
        aeVar.m779e("/activeViewPingSent");
        aeVar.m779e("/updateActiveView");
    }

    protected void m772d(boolean z) {
        Iterator it = this.lL.iterator();
        while (it.hasNext()) {
            ((C0408z) it.next()).m1474a(this, z);
        }
    }

    protected void m773e(boolean z) {
        synchronized (this.ls) {
            if (this.lB && this.lJ) {
                long nanoTime = System.nanoTime();
                if (!z || this.lI + lG <= nanoTime) {
                    this.lI = nanoTime;
                    View view = (View) this.lx.get();
                    Object obj = (view == null || ((ef) this.lv.get()) == null) ? 1 : null;
                    if (obj != null) {
                        ax();
                        return;
                    }
                    try {
                        m767a(m770c(view));
                    } catch (Throwable e) {
                        eu.m1016b("Active view update failed.", e);
                    }
                    aA();
                    ay();
                    return;
                }
                return;
            }
        }
    }

    public void onGlobalLayout() {
        m773e(false);
    }

    public void onScrollChanged() {
        m773e(true);
    }

    public void pause() {
        synchronized (this.ls) {
            this.lj = true;
            m773e(false);
            this.lA.pause();
        }
    }

    public void resume() {
        synchronized (this.ls) {
            this.lA.resume();
            this.lj = false;
            m773e(false);
        }
    }

    public void stop() {
        synchronized (this.ls) {
            this.lH = true;
            m773e(false);
            this.lA.pause();
        }
    }
}
