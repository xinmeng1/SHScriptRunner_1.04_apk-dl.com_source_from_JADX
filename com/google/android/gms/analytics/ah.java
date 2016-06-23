package com.google.android.gms.analytics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class ah implements C0149n {
    private final Context mContext;
    private GoogleAnalytics ul;
    private final String xa;
    private final HttpClient xb;
    private URL xc;

    ah(HttpClient httpClient, Context context) {
        this(httpClient, GoogleAnalytics.getInstance(context), context);
    }

    ah(HttpClient httpClient, GoogleAnalytics googleAnalytics, Context context) {
        this.mContext = context.getApplicationContext();
        this.xa = m1894a("GoogleAnalytics", "3.0", VERSION.RELEASE, ak.m51a(Locale.getDefault()), Build.MODEL, Build.ID);
        this.xb = httpClient;
        this.ul = googleAnalytics;
    }

    private void m1889a(ab abVar, URL url, boolean z) {
        if (!TextUtils.isEmpty(abVar.dq()) && dx()) {
            URL url2;
            if (url == null) {
                try {
                    url2 = this.xc != null ? this.xc : new URL("https://ssl.google-analytics.com/collect");
                } catch (MalformedURLException e) {
                    return;
                }
            }
            url2 = url;
            HttpHost httpHost = new HttpHost(url2.getHost(), url2.getPort(), url2.getProtocol());
            try {
                HttpEntityEnclosingRequest e2 = m1891e(abVar.dq(), url2.getPath());
                if (e2 != null) {
                    e2.addHeader("Host", httpHost.toHostString());
                    if (aa.dp()) {
                        m1890a(e2);
                    }
                    if (z) {
                        C0152q.m81w(this.mContext);
                    }
                    HttpResponse execute = this.xb.execute(httpHost, e2);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    HttpEntity entity = execute.getEntity();
                    if (entity != null) {
                        entity.consumeContent();
                    }
                    if (statusCode != 200) {
                        aa.m40D("Bad response: " + execute.getStatusLine().getStatusCode());
                    }
                }
            } catch (ClientProtocolException e3) {
                aa.m40D("ClientProtocolException sending monitoring hit.");
            } catch (IOException e4) {
                aa.m40D("Exception sending monitoring hit: " + e4.getClass().getSimpleName());
                aa.m40D(e4.getMessage());
            }
        }
    }

    private void m1890a(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object obj : httpEntityEnclosingRequest.getAllHeaders()) {
            stringBuffer.append(obj.toString()).append("\n");
        }
        stringBuffer.append(httpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
        if (httpEntityEnclosingRequest.getEntity() != null) {
            try {
                InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                if (content != null) {
                    int available = content.available();
                    if (available > 0) {
                        byte[] bArr = new byte[available];
                        content.read(bArr);
                        stringBuffer.append("POST:\n");
                        stringBuffer.append(new String(bArr)).append("\n");
                    }
                }
            } catch (IOException e) {
                aa.m39C("Error Writing hit to log...");
            }
        }
        aa.m39C(stringBuffer.toString());
    }

    private HttpEntityEnclosingRequest m1891e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            aa.m40D("Empty hit, discarding.");
            return null;
        }
        HttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
        String str3 = str2 + "?" + str;
        if (str3.length() < 2036) {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", str3);
        } else {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("POST", str2);
            try {
                basicHttpEntityEnclosingRequest.setEntity(new StringEntity(str));
            } catch (UnsupportedEncodingException e) {
                aa.m40D("Encoding error, discarding hit");
                return null;
            }
        }
        basicHttpEntityEnclosingRequest.addHeader("User-Agent", this.xa);
        return basicHttpEntityEnclosingRequest;
    }

    public void m1892M(String str) {
        try {
            this.xc = new URL(str);
        } catch (MalformedURLException e) {
            this.xc = null;
        }
    }

    public int m1893a(List<C0167x> list, ab abVar, boolean z) {
        int i = 0;
        int min = Math.min(list.size(), 40);
        abVar.m41c("_hr", list.size());
        int i2 = 0;
        URL url = null;
        boolean z2 = true;
        int i3 = 0;
        while (i3 < min) {
            int i4;
            URL url2;
            C0167x c0167x = (C0167x) list.get(i3);
            URL a = m1895a(c0167x);
            if (a == null) {
                if (aa.dp()) {
                    aa.m40D("No destination: discarding hit: " + c0167x.dk());
                } else {
                    aa.m40D("No destination: discarding hit.");
                }
                i2++;
                URL url3 = url;
                i4 = i + 1;
                url2 = url3;
            } else {
                HttpHost httpHost = new HttpHost(a.getHost(), a.getPort(), a.getProtocol());
                String path = a.getPath();
                String a2 = TextUtils.isEmpty(c0167x.dk()) ? "" : C0168y.m87a(c0167x, System.currentTimeMillis());
                HttpEntityEnclosingRequest e = m1891e(a2, path);
                if (e == null) {
                    i2++;
                    i4 = i + 1;
                    url2 = a;
                } else {
                    e.addHeader("Host", httpHost.toHostString());
                    if (aa.dp()) {
                        m1890a(e);
                    }
                    if (a2.length() > AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD) {
                        aa.m40D("Hit too long (> 8192 bytes)--not sent");
                        i2++;
                    } else if (this.ul.isDryRunEnabled()) {
                        aa.m38B("Dry run enabled. Hit not actually sent.");
                    } else {
                        if (z2) {
                            try {
                                C0152q.m81w(this.mContext);
                                z2 = false;
                            } catch (ClientProtocolException e2) {
                                aa.m40D("ClientProtocolException sending hit; discarding hit...");
                                abVar.m41c("_hd", i2);
                            } catch (IOException e3) {
                                aa.m40D("Exception sending hit: " + e3.getClass().getSimpleName());
                                aa.m40D(e3.getMessage());
                                abVar.m41c("_de", 1);
                                abVar.m41c("_hd", i2);
                                abVar.m41c("_hs", i);
                                m1889a(abVar, a, z2);
                                return i;
                            }
                        }
                        HttpResponse execute = this.xb.execute(httpHost, e);
                        int statusCode = execute.getStatusLine().getStatusCode();
                        HttpEntity entity = execute.getEntity();
                        if (entity != null) {
                            entity.consumeContent();
                        }
                        if (statusCode != 200) {
                            aa.m40D("Bad response: " + execute.getStatusLine().getStatusCode());
                        }
                    }
                    abVar.m41c("_td", a2.getBytes().length);
                    i4 = i + 1;
                    url2 = a;
                }
            }
            i3++;
            i = i4;
            url = url2;
        }
        abVar.m41c("_hd", i2);
        abVar.m41c("_hs", i);
        if (z) {
            m1889a(abVar, url, z2);
        }
        return i;
    }

    String m1894a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    URL m1895a(C0167x c0167x) {
        if (this.xc != null) {
            return this.xc;
        }
        try {
            return new URL("http:".equals(c0167x.dn()) ? "http://www.google-analytics.com/collect" : "https://ssl.google-analytics.com/collect");
        } catch (MalformedURLException e) {
            aa.m37A("Error trying to parse the hardcoded host url. This really shouldn't happen.");
            return null;
        }
    }

    public boolean cC() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        aa.m39C("...no network connectivity");
        return false;
    }

    boolean dx() {
        return Math.random() * 100.0d <= 1.0d;
    }
}
