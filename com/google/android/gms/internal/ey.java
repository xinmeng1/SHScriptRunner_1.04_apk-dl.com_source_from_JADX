package com.google.android.gms.internal;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;
import java.util.Map;

public class ey extends WebViewClient {
    protected final ex lN;
    private final Object ls;
    private ba mS;
    private bf nc;
    private bd nd;
    private C0346a pN;
    private final HashMap<String, bc> sH;
    private C0400t sI;
    private ci sJ;
    private boolean sK;
    private boolean sL;
    private cl sM;

    /* renamed from: com.google.android.gms.internal.ey.1 */
    class C03451 implements Runnable {
        final /* synthetic */ cf sN;
        final /* synthetic */ ey sO;

        C03451(ey eyVar, cf cfVar) {
            this.sO = eyVar;
            this.sN = cfVar;
        }

        public void run() {
            this.sN.aS();
        }
    }

    /* renamed from: com.google.android.gms.internal.ey.a */
    public interface C0346a {
        void m1033a(ex exVar);
    }

    public ey(ex exVar, boolean z) {
        this.sH = new HashMap();
        this.ls = new Object();
        this.sK = false;
        this.lN = exVar;
        this.sL = z;
    }

    private static boolean m1034d(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    private void m1035e(Uri uri) {
        String path = uri.getPath();
        bc bcVar = (bc) this.sH.get(path);
        if (bcVar != null) {
            Map c = eo.m983c(uri);
            if (eu.m1018p(2)) {
                eu.m1013C("Received GMSG: " + path);
                for (String path2 : c.keySet()) {
                    eu.m1013C("  " + path2 + ": " + ((String) c.get(path2)));
                }
            }
            bcVar.m829b(this.lN, c);
            return;
        }
        eu.m1013C("No GMSG handler found for GMSG: " + uri);
    }

    public final void m1036a(ce ceVar) {
        ci ciVar = null;
        boolean ce = this.lN.ce();
        C0400t c0400t = (!ce || this.lN.m1025V().mf) ? this.sI : null;
        if (!ce) {
            ciVar = this.sJ;
        }
        m1037a(new ch(ceVar, c0400t, ciVar, this.sM, this.lN.cd()));
    }

    protected void m1037a(ch chVar) {
        cf.m3562a(this.lN.getContext(), chVar);
    }

    public final void m1038a(C0346a c0346a) {
        this.pN = c0346a;
    }

    public void m1039a(C0400t c0400t, ci ciVar, ba baVar, cl clVar, boolean z, bd bdVar) {
        m1041a("/appEvent", new az(baVar));
        m1041a("/canOpenURLs", bb.mU);
        m1041a("/click", bb.mV);
        m1041a("/close", bb.mW);
        m1041a("/customClose", bb.mX);
        m1041a("/httpTrack", bb.mY);
        m1041a("/log", bb.mZ);
        m1041a("/open", new bg(bdVar));
        m1041a("/touch", bb.na);
        m1041a("/video", bb.nb);
        this.sI = c0400t;
        this.sJ = ciVar;
        this.mS = baVar;
        this.nd = bdVar;
        this.sM = clVar;
        m1045r(z);
    }

    public void m1040a(C0400t c0400t, ci ciVar, ba baVar, cl clVar, boolean z, bd bdVar, bf bfVar) {
        m1039a(c0400t, ciVar, baVar, clVar, z, bdVar);
        m1041a("/setInterstitialProperties", new be(bfVar));
        this.nc = bfVar;
    }

    public final void m1041a(String str, bc bcVar) {
        this.sH.put(str, bcVar);
    }

    public final void m1042a(boolean z, int i) {
        C0400t c0400t = (!this.lN.ce() || this.lN.m1025V().mf) ? this.sI : null;
        m1037a(new ch(c0400t, this.sJ, this.sM, this.lN, z, i, this.lN.cd()));
    }

    public final void m1043a(boolean z, int i, String str) {
        ci ciVar = null;
        boolean ce = this.lN.ce();
        C0400t c0400t = (!ce || this.lN.m1025V().mf) ? this.sI : null;
        if (!ce) {
            ciVar = this.sJ;
        }
        m1037a(new ch(c0400t, ciVar, this.mS, this.sM, this.lN, z, i, str, this.lN.cd(), this.nd));
    }

    public final void m1044a(boolean z, int i, String str, String str2) {
        boolean ce = this.lN.ce();
        C0400t c0400t = (!ce || this.lN.m1025V().mf) ? this.sI : null;
        m1037a(new ch(c0400t, ce ? null : this.sJ, this.mS, this.sM, this.lN, z, i, str, str2, this.lN.cd(), this.nd));
    }

    public final void aS() {
        synchronized (this.ls) {
            this.sK = false;
            this.sL = true;
            cf ca = this.lN.ca();
            if (ca != null) {
                if (et.bW()) {
                    ca.aS();
                } else {
                    et.sv.post(new C03451(this, ca));
                }
            }
        }
    }

    public boolean cj() {
        boolean z;
        synchronized (this.ls) {
            z = this.sL;
        }
        return z;
    }

    public final void onLoadResource(WebView webView, String url) {
        eu.m1013C("Loading resource: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m1035e(parse);
        }
    }

    public final void onPageFinished(WebView webView, String url) {
        if (this.pN != null) {
            this.pN.m1033a(this.lN);
            this.pN = null;
        }
    }

    public final void m1045r(boolean z) {
        this.sK = z;
    }

    public final void reset() {
        synchronized (this.ls) {
            this.sH.clear();
            this.sI = null;
            this.sJ = null;
            this.pN = null;
            this.mS = null;
            this.sK = false;
            this.sL = false;
            this.nd = null;
            this.sM = null;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String url) {
        eu.m1013C("AdWebView shouldOverrideUrlLoading: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m1035e(parse);
        } else if (this.sK && webView == this.lN && m1034d(parse)) {
            return super.shouldOverrideUrlLoading(webView, url);
        } else {
            if (this.lN.willNotDraw()) {
                eu.m1014D("AdWebView unable to handle URL: " + url);
            } else {
                Uri uri;
                try {
                    C0387k cc = this.lN.cc();
                    if (cc != null && cc.m1323b(parse)) {
                        parse = cc.m1320a(parse, this.lN.getContext());
                    }
                    uri = parse;
                } catch (C0389l e) {
                    eu.m1014D("Unable to append parameter to URL: " + url);
                    uri = parse;
                }
                m1036a(new ce("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            }
        }
        return true;
    }
}
