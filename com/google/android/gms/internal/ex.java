package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.drive.DriveFile;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ex extends WebView implements DownloadListener {
    private final WindowManager lC;
    private final Object ls;
    private al nF;
    private final ev nG;
    private final C0387k pA;
    private final ey sA;
    private final C0344a sB;
    private cf sC;
    private boolean sD;
    private boolean sE;
    private boolean sF;

    /* renamed from: com.google.android.gms.internal.ex.a */
    private static class C0344a extends MutableContextWrapper {
        private Context lz;
        private Activity sG;

        public C0344a(Context context) {
            super(context);
            setBaseContext(context);
        }

        public Context cf() {
            return this.sG;
        }

        public void setBaseContext(Context base) {
            this.lz = base.getApplicationContext();
            this.sG = base instanceof Activity ? (Activity) base : null;
            super.setBaseContext(this.lz);
        }

        public void startActivity(Intent intent) {
            if (this.sG != null) {
                this.sG.startActivity(intent);
                return;
            }
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            this.lz.startActivity(intent);
        }
    }

    private ex(C0344a c0344a, al alVar, boolean z, boolean z2, C0387k c0387k, ev evVar) {
        super(c0344a);
        this.ls = new Object();
        this.sB = c0344a;
        this.nF = alVar;
        this.sD = z;
        this.pA = c0387k;
        this.nG = evVar;
        this.lC = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        eo.m972a((Context) c0344a, evVar.sw, settings);
        if (VERSION.SDK_INT >= 17) {
            er.m1003a(getContext(), settings);
        } else if (VERSION.SDK_INT >= 11) {
            eq.m997a(getContext(), settings);
        }
        setDownloadListener(this);
        if (VERSION.SDK_INT >= 11) {
            this.sA = new fa(this, z2);
        } else {
            this.sA = new ey(this, z2);
        }
        setWebViewClient(this.sA);
        if (VERSION.SDK_INT >= 14) {
            setWebChromeClient(new fb(this));
        } else if (VERSION.SDK_INT >= 11) {
            setWebChromeClient(new ez(this));
        }
        cg();
    }

    public static ex m1023a(Context context, al alVar, boolean z, boolean z2, C0387k c0387k, ev evVar) {
        return new ex(new C0344a(context), alVar, z, z2, c0387k, evVar);
    }

    private void cg() {
        synchronized (this.ls) {
            if (this.sD || this.nF.mf) {
                if (VERSION.SDK_INT < 14) {
                    eu.m1019z("Disabling hardware acceleration on an overlay.");
                    ch();
                } else {
                    eu.m1019z("Enabling hardware acceleration on an overlay.");
                    ci();
                }
            } else if (VERSION.SDK_INT < 18) {
                eu.m1019z("Disabling hardware acceleration on an AdView.");
                ch();
            } else {
                eu.m1019z("Enabling hardware acceleration on an AdView.");
                ci();
            }
        }
    }

    private void ch() {
        synchronized (this.ls) {
            if (!this.sE && VERSION.SDK_INT >= 11) {
                eq.m1001d(this);
            }
            this.sE = true;
        }
    }

    private void ci() {
        synchronized (this.ls) {
            if (this.sE && VERSION.SDK_INT >= 11) {
                eq.m1002e(this);
            }
            this.sE = false;
        }
    }

    protected void m1024E(String str) {
        synchronized (this.ls) {
            if (isDestroyed()) {
                eu.m1014D("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    public al m1025V() {
        al alVar;
        synchronized (this.ls) {
            alVar = this.nF;
        }
        return alVar;
    }

    public void m1026a(Context context, al alVar) {
        synchronized (this.ls) {
            this.sB.setBaseContext(context);
            this.sC = null;
            this.nF = alVar;
            this.sD = false;
            eo.m981b((WebView) this);
            loadUrl("about:blank");
            this.sA.reset();
        }
    }

    public void m1027a(al alVar) {
        synchronized (this.ls) {
            this.nF = alVar;
            requestLayout();
        }
    }

    public void m1028a(cf cfVar) {
        synchronized (this.ls) {
            this.sC = cfVar;
        }
    }

    public void m1029a(String str, Map<String, ?> map) {
        try {
            m1031b(str, eo.m987o((Map) map));
        } catch (JSONException e) {
            eu.m1014D("Could not convert parameters to JSON.");
        }
    }

    public void m1030a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:" + str + "(");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        m1024E(stringBuilder.toString());
    }

    public void m1031b(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:AFMA_ReceiveMessage('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        eu.m1013C("Dispatching AFMA event: " + stringBuilder);
        m1024E(stringBuilder.toString());
    }

    public void bX() {
        if (cb().cj()) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display defaultDisplay = this.lC.getDefaultDisplay();
            defaultDisplay.getMetrics(displayMetrics);
            float f = 160.0f / ((float) displayMetrics.densityDpi);
            try {
                m1031b("onScreenInfoChanged", new JSONObject().put("width", (int) (((float) displayMetrics.widthPixels) * f)).put("height", (int) (((float) (displayMetrics.heightPixels - eo.m988p(getContext()))) * f)).put("density", (double) displayMetrics.density).put("rotation", defaultDisplay.getRotation()));
            } catch (Throwable e) {
                eu.m1016b("Error occured while obtaining screen information.", e);
            }
        }
    }

    public void bY() {
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.nG.sw);
        m1029a("onhide", hashMap);
    }

    public void bZ() {
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.nG.sw);
        m1029a("onshow", hashMap);
    }

    public cf ca() {
        cf cfVar;
        synchronized (this.ls) {
            cfVar = this.sC;
        }
        return cfVar;
    }

    public ey cb() {
        return this.sA;
    }

    public C0387k cc() {
        return this.pA;
    }

    public ev cd() {
        return this.nG;
    }

    public boolean ce() {
        boolean z;
        synchronized (this.ls) {
            z = this.sD;
        }
        return z;
    }

    public Context cf() {
        return this.sB.cf();
    }

    public void destroy() {
        synchronized (this.ls) {
            super.destroy();
            this.sF = true;
        }
    }

    public boolean isDestroyed() {
        boolean z;
        synchronized (this.ls) {
            z = this.sF;
        }
        return z;
    }

    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long size) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(url), mimeType);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            eu.m1019z("Couldn't find an Activity to view url/mimetype: " + url + " / " + mimeType);
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        synchronized (this.ls) {
            if (isInEditMode() || this.sD) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                return;
            }
            int mode = MeasureSpec.getMode(widthMeasureSpec);
            int size = MeasureSpec.getSize(widthMeasureSpec);
            int mode2 = MeasureSpec.getMode(heightMeasureSpec);
            int size2 = MeasureSpec.getSize(heightMeasureSpec);
            mode = (mode == ExploreByTouchHelper.INVALID_ID || mode == 1073741824) ? size : Integer.MAX_VALUE;
            if (mode2 == ExploreByTouchHelper.INVALID_ID || mode2 == 1073741824) {
                i = size2;
            }
            if (this.nF.widthPixels > mode || this.nF.heightPixels > r0) {
                float f = this.sB.getResources().getDisplayMetrics().density;
                eu.m1014D("Not enough space to show ad. Needs " + ((int) (((float) this.nF.widthPixels) / f)) + "x" + ((int) (((float) this.nF.heightPixels) / f)) + " dp, but only has " + ((int) (((float) size) / f)) + "x" + ((int) (((float) size2) / f)) + " dp.");
                if (getVisibility() != 8) {
                    setVisibility(4);
                }
                setMeasuredDimension(0, 0);
            } else {
                if (getVisibility() != 8) {
                    setVisibility(0);
                }
                setMeasuredDimension(this.nF.widthPixels, this.nF.heightPixels);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.pA != null) {
            this.pA.m1321a(event);
        }
        return super.onTouchEvent(event);
    }

    public void m1032q(boolean z) {
        synchronized (this.ls) {
            this.sD = z;
            cg();
        }
    }

    public void setContext(Context context) {
        this.sB.setBaseContext(context);
    }
}
