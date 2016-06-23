package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class fa extends ey {
    public fa(ex exVar, boolean z) {
        super(exVar, z);
    }

    protected WebResourceResponse m2575c(Context context, String str, String str2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
        try {
            eo.m974a(context, str, true, httpURLConnection);
            httpURLConnection.connect();
            WebResourceResponse webResourceResponse = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(eo.m969a(new InputStreamReader(httpURLConnection.getInputStream())).getBytes("UTF-8")));
            return webResourceResponse;
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String url) {
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(url).getName())) {
                return super.shouldInterceptRequest(webView, url);
            }
            if (webView instanceof ex) {
                ex exVar = (ex) webView;
                exVar.cb().aS();
                if (exVar.m1025V().mf) {
                    eu.m1013C("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_interstitial.js)");
                    return m2575c(exVar.getContext(), this.lN.cd().sw, "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
                } else if (exVar.ce()) {
                    eu.m1013C("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js)");
                    return m2575c(exVar.getContext(), this.lN.cd().sw, "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
                } else {
                    eu.m1013C("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_banner.js)");
                    return m2575c(exVar.getContext(), this.lN.cd().sw, "http://media.admob.com/mraid/v1/mraid_app_banner.js");
                }
            }
            eu.m1014D("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return super.shouldInterceptRequest(webView, url);
        } catch (IOException e) {
            eu.m1014D("Could not fetching MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, url);
        }
    }
}
