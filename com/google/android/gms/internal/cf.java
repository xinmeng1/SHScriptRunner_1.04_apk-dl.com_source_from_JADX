package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.cn.C0722a;
import com.google.android.gms.internal.ey.C0346a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class cf extends C0722a {
    private static final int of;
    private ex lN;
    private final Activity og;
    private ch oh;
    private cj oi;
    private C0317c oj;
    private ck ok;
    private boolean ol;
    private FrameLayout om;
    private CustomViewCallback on;
    private boolean oo;
    private boolean op;
    private boolean oq;
    private RelativeLayout or;

    /* renamed from: com.google.android.gms.internal.cf.a */
    private static final class C0315a extends Exception {
        public C0315a(String str) {
            super(str);
        }
    }

    /* renamed from: com.google.android.gms.internal.cf.b */
    private static final class C0316b extends RelativeLayout {
        private final ep kI;

        public C0316b(Context context, String str) {
            super(context);
            this.kI = new ep(context, str);
        }

        public boolean onInterceptTouchEvent(MotionEvent event) {
            this.kI.m995c(event);
            return false;
        }
    }

    /* renamed from: com.google.android.gms.internal.cf.c */
    private static final class C0317c {
        public final int index;
        public final LayoutParams ot;
        public final ViewGroup ou;

        public C0317c(ex exVar) throws C0315a {
            this.ot = exVar.getLayoutParams();
            ViewParent parent = exVar.getParent();
            if (parent instanceof ViewGroup) {
                this.ou = (ViewGroup) parent;
                this.index = this.ou.indexOfChild(exVar);
                this.ou.removeView(exVar);
                exVar.m1032q(true);
                return;
            }
            throw new C0315a("Could not get the parent of the WebView for an overlay.");
        }
    }

    /* renamed from: com.google.android.gms.internal.cf.1 */
    class C07201 implements C0346a {
        final /* synthetic */ cf os;

        C07201(cf cfVar) {
            this.os = cfVar;
        }

        public void m2507a(ex exVar) {
            exVar.bZ();
        }
    }

    static {
        of = Color.argb(0, 0, 0, 0);
    }

    public cf(Activity activity) {
        this.oo = false;
        this.op = false;
        this.oq = false;
        this.og = activity;
    }

    private static RelativeLayout.LayoutParams m3561a(int i, int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        return layoutParams;
    }

    public static void m3562a(Context context, ch chVar) {
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", chVar.kQ.sz);
        ch.m2509a(intent, chVar);
        intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        if (!(context instanceof Activity)) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
        }
        context.startActivity(intent);
    }

    private void aT() {
        if (this.og.isFinishing() && !this.op) {
            this.op = true;
            if (this.og.isFinishing()) {
                if (this.lN != null) {
                    this.lN.bY();
                    this.or.removeView(this.lN);
                    if (this.oj != null) {
                        this.lN.m1032q(false);
                        this.oj.ou.addView(this.lN, this.oj.index, this.oj.ot);
                    }
                }
                if (this.oh != null && this.oh.ox != null) {
                    this.oh.ox.m854Z();
                }
            }
        }
    }

    private void m3563k(boolean z) throws C0315a {
        if (!this.ol) {
            this.og.requestWindowFeature(1);
        }
        Window window = this.og.getWindow();
        if (!this.oq || this.oh.oH.ld) {
            window.setFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        }
        setRequestedOrientation(this.oh.orientation);
        if (VERSION.SDK_INT >= 11) {
            eu.m1019z("Enabling hardware acceleration on the AdActivity window.");
            eq.m998a(window);
        }
        this.or = new C0316b(this.og, this.oh.oG);
        if (this.oq) {
            this.or.setBackgroundColor(of);
        } else {
            this.or.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.og.setContentView(this.or);
        m3564S();
        boolean cj = this.oh.oy.cb().cj();
        if (z) {
            this.lN = ex.m1023a(this.og, this.oh.oy.m1025V(), true, cj, null, this.oh.kQ);
            this.lN.cb().m1039a(null, null, this.oh.oz, this.oh.oD, true, this.oh.oF);
            this.lN.cb().m1038a(new C07201(this));
            if (this.oh.ob != null) {
                this.lN.loadUrl(this.oh.ob);
            } else if (this.oh.oC != null) {
                this.lN.loadDataWithBaseURL(this.oh.oA, this.oh.oC, "text/html", "UTF-8", null);
            } else {
                throw new C0315a("No URL or HTML to display in ad overlay.");
            }
        }
        this.lN = this.oh.oy;
        this.lN.setContext(this.og);
        this.lN.m1028a(this);
        ViewParent parent = this.lN.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.lN);
        }
        if (this.oq) {
            this.lN.setBackgroundColor(of);
        }
        this.or.addView(this.lN, -1, -1);
        if (!z) {
            this.lN.bZ();
        }
        m3568i(cj);
    }

    public void m3564S() {
        this.ol = true;
    }

    public void m3565a(View view, CustomViewCallback customViewCallback) {
        this.om = new FrameLayout(this.og);
        this.om.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.om.addView(view, -1, -1);
        this.og.setContentView(this.om);
        m3564S();
        this.on = customViewCallback;
    }

    public cj aQ() {
        return this.oi;
    }

    public void aR() {
        if (this.oh != null) {
            setRequestedOrientation(this.oh.orientation);
        }
        if (this.om != null) {
            this.og.setContentView(this.or);
            m3564S();
            this.om.removeAllViews();
            this.om = null;
        }
        if (this.on != null) {
            this.on.onCustomViewHidden();
            this.on = null;
        }
    }

    public void aS() {
        this.or.removeView(this.ok);
        m3568i(true);
    }

    public void m3566b(int i, int i2, int i3, int i4) {
        if (this.oi != null) {
            this.oi.setLayoutParams(m3561a(i, i2, i3, i4));
        }
    }

    public void m3567c(int i, int i2, int i3, int i4) {
        if (this.oi == null) {
            this.oi = new cj(this.og, this.lN);
            this.or.addView(this.oi, 0, m3561a(i, i2, i3, i4));
            this.lN.cb().m1045r(false);
        }
    }

    public void close() {
        this.og.finish();
    }

    public void m3568i(boolean z) {
        this.ok = new ck(this.og, z ? 50 : 32);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.ok.m863j(this.oh.oB);
        this.or.addView(this.ok, layoutParams);
    }

    public void m3569j(boolean z) {
        if (this.ok != null) {
            this.ok.m863j(z);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean z = false;
        if (savedInstanceState != null) {
            z = savedInstanceState.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.oo = z;
        try {
            this.oh = ch.m2508a(this.og.getIntent());
            if (this.oh == null) {
                throw new C0315a("Could not get info for ad overlay.");
            }
            if (this.oh.oH != null) {
                this.oq = this.oh.oH.lb;
            } else {
                this.oq = false;
            }
            if (savedInstanceState == null) {
                if (this.oh.ox != null) {
                    this.oh.ox.aa();
                }
                if (!(this.oh.oE == 1 || this.oh.ow == null)) {
                    this.oh.ow.onAdClicked();
                }
            }
            switch (this.oh.oE) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    m3563k(false);
                case DataEvent.TYPE_DELETED /*2*/:
                    this.oj = new C0317c(this.oh.oy);
                    m3563k(false);
                case DetectedActivity.STILL /*3*/:
                    m3563k(true);
                case DetectedActivity.UNKNOWN /*4*/:
                    if (this.oo) {
                        this.og.finish();
                    } else if (!cc.m847a(this.og, this.oh.ov, this.oh.oD)) {
                        this.og.finish();
                    }
                default:
                    throw new C0315a("Could not determine ad overlay type.");
            }
        } catch (C0315a e) {
            eu.m1014D(e.getMessage());
            this.og.finish();
        }
    }

    public void onDestroy() {
        if (this.oi != null) {
            this.oi.destroy();
        }
        if (this.lN != null) {
            this.or.removeView(this.lN);
        }
        aT();
    }

    public void onPause() {
        if (this.oi != null) {
            this.oi.pause();
        }
        aR();
        if (this.lN != null && (!this.og.isFinishing() || this.oj == null)) {
            eo.m975a(this.lN);
        }
        aT();
    }

    public void onRestart() {
    }

    public void onResume() {
        if (this.oh != null && this.oh.oE == 4) {
            if (this.oo) {
                this.og.finish();
            } else {
                this.oo = true;
            }
        }
        if (this.lN != null) {
            eo.m981b(this.lN);
        }
    }

    public void onSaveInstanceState(Bundle outBundle) {
        outBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.oo);
    }

    public void onStart() {
    }

    public void onStop() {
        aT();
    }

    public void setRequestedOrientation(int requestedOrientation) {
        this.og.setRequestedOrientation(requestedOrientation);
    }
}
