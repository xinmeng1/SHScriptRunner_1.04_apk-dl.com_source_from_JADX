package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.internal.ey.C0346a;

/* renamed from: com.google.android.gms.internal.do */
public class C0332do implements Runnable {
    private final int ku;
    private final int kv;
    protected final ex lN;
    private final Handler pK;
    private final long pL;
    private long pM;
    private C0346a pN;
    protected boolean pO;
    protected boolean pP;

    /* renamed from: com.google.android.gms.internal.do.a */
    protected final class C0331a extends AsyncTask<Void, Void, Boolean> {
        private final WebView pQ;
        private Bitmap pR;
        final /* synthetic */ C0332do pS;

        public C0331a(C0332do c0332do, WebView webView) {
            this.pS = c0332do;
            this.pQ = webView;
        }

        protected synchronized Boolean m894a(Void... voidArr) {
            Boolean valueOf;
            int width = this.pR.getWidth();
            int height = this.pR.getHeight();
            if (width == 0 || height == 0) {
                valueOf = Boolean.valueOf(false);
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.pR.getPixel(i2, i3) != 0) {
                            i++;
                        }
                    }
                }
                valueOf = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
            }
            return valueOf;
        }

        protected void m895a(Boolean bool) {
            C0332do.m898c(this.pS);
            if (bool.booleanValue() || this.pS.bq() || this.pS.pM <= 0) {
                this.pS.pP = bool.booleanValue();
                this.pS.pN.m1033a(this.pS.lN);
            } else if (this.pS.pM > 0) {
                if (eu.m1018p(2)) {
                    eu.m1019z("Ad not detected, scheduling another run.");
                }
                this.pS.pK.postDelayed(this.pS, this.pS.pL);
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] x0) {
            return m894a((Void[]) x0);
        }

        protected /* synthetic */ void onPostExecute(Object x0) {
            m895a((Boolean) x0);
        }

        protected synchronized void onPreExecute() {
            this.pR = Bitmap.createBitmap(this.pS.ku, this.pS.kv, Config.ARGB_8888);
            this.pQ.setVisibility(0);
            this.pQ.measure(MeasureSpec.makeMeasureSpec(this.pS.ku, 0), MeasureSpec.makeMeasureSpec(this.pS.kv, 0));
            this.pQ.layout(0, 0, this.pS.ku, this.pS.kv);
            this.pQ.draw(new Canvas(this.pR));
            this.pQ.invalidate();
        }
    }

    public C0332do(C0346a c0346a, ex exVar, int i, int i2) {
        this(c0346a, exVar, i, i2, 200, 50);
    }

    public C0332do(C0346a c0346a, ex exVar, int i, int i2, long j, long j2) {
        this.pL = j;
        this.pM = j2;
        this.pK = new Handler(Looper.getMainLooper());
        this.lN = exVar;
        this.pN = c0346a;
        this.pO = false;
        this.pP = false;
        this.kv = i2;
        this.ku = i;
    }

    static /* synthetic */ long m898c(C0332do c0332do) {
        long j = c0332do.pM - 1;
        c0332do.pM = j;
        return j;
    }

    public void m903a(du duVar, fc fcVar) {
        this.lN.setWebViewClient(fcVar);
        this.lN.loadDataWithBaseURL(TextUtils.isEmpty(duVar.oA) ? null : eo.m991v(duVar.oA), duVar.qe, "text/html", "UTF-8", null);
    }

    public void m904b(du duVar) {
        m903a(duVar, new fc(this, this.lN, duVar.qn));
    }

    public void bo() {
        this.pK.postDelayed(this, this.pL);
    }

    public synchronized void bp() {
        this.pO = true;
    }

    public synchronized boolean bq() {
        return this.pO;
    }

    public boolean br() {
        return this.pP;
    }

    public void run() {
        if (this.lN == null || bq()) {
            this.pN.m1033a(this.lN);
        } else {
            new C0331a(this, this.lN).execute(new Void[0]);
        }
    }
}
