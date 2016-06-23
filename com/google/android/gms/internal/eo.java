package com.google.android.gms.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.net.UrlQuerySanitizer.ParameterValuePair;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.cast.Cast;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class eo {
    private static final Object qp;
    private static boolean sl;
    private static String sm;
    private static boolean sn;

    /* renamed from: com.google.android.gms.internal.eo.1 */
    static class C03401 implements Runnable {
        final /* synthetic */ Context qu;

        C03401(Context context) {
            this.qu = context;
        }

        public void run() {
            synchronized (eo.qp) {
                eo.sm = eo.m986o(this.qu);
                eo.qp.notifyAll();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.eo.a */
    private static final class C0341a extends BroadcastReceiver {
        private C0341a() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                eo.sl = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                eo.sl = false;
            }
        }
    }

    static {
        qp = new Object();
        sl = true;
        sn = false;
    }

    public static String m969a(Readable readable) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence allocate = CharBuffer.allocate(AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT);
        while (true) {
            int read = readable.read(allocate);
            if (read == -1) {
                return stringBuilder.toString();
            }
            allocate.flip();
            stringBuilder.append(allocate, 0, read);
        }
    }

    private static JSONArray m970a(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object a : collection) {
            m976a(jSONArray, a);
        }
        return jSONArray;
    }

    static JSONArray m971a(Object[] objArr) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object a : objArr) {
            m976a(jSONArray, a);
        }
        return jSONArray;
    }

    public static void m972a(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(m982c(context, str));
    }

    public static void m973a(Context context, String str, List<String> list) {
        for (String esVar : list) {
            new es(context, str, esVar).start();
        }
    }

    public static void m974a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", m982c(context, str));
        httpURLConnection.setUseCaches(false);
    }

    public static void m975a(WebView webView) {
        if (VERSION.SDK_INT >= 11) {
            eq.m999a(webView);
        }
    }

    private static void m976a(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(m980b((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(m987o((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(m970a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(m971a((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    private static void m977a(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, m980b((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, m987o((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, m970a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, m970a(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    public static boolean m978a(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    public static boolean m979a(ClassLoader classLoader, Class<?> cls, String str) {
        boolean z = false;
        try {
            z = cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
        }
        return z;
    }

    private static JSONObject m980b(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            m977a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public static void m981b(WebView webView) {
        if (VERSION.SDK_INT >= 11) {
            eq.m1000b(webView);
        }
    }

    public static boolean bQ() {
        return sl;
    }

    public static int bR() {
        return VERSION.SDK_INT >= 9 ? 6 : 0;
    }

    public static int bS() {
        return VERSION.SDK_INT >= 9 ? 7 : 1;
    }

    public static String bT() {
        UUID randomUUID = UUID.randomUUID();
        byte[] toByteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] toByteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, toByteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(toByteArray);
                instance.update(toByteArray2);
                Object obj = new byte[8];
                System.arraycopy(instance.digest(), 0, obj, 0, 8);
                bigInteger = new BigInteger(1, obj).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    private static String m982c(Context context, String str) {
        String str2;
        synchronized (qp) {
            if (sm != null) {
                str2 = sm;
            } else {
                if (VERSION.SDK_INT >= 17) {
                    sm = er.getDefaultUserAgent(context);
                } else if (et.bW()) {
                    sm = m986o(context);
                } else {
                    et.sv.post(new C03401(context));
                    while (sm == null) {
                        try {
                            qp.wait();
                        } catch (InterruptedException e) {
                            str2 = sm;
                        }
                    }
                }
                sm += " (Mobile; " + str + ")";
                str2 = sm;
            }
        }
        return str2;
    }

    public static Map<String, String> m983c(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
        urlQuerySanitizer.setAllowUnregisteredParamaters(true);
        urlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
        urlQuerySanitizer.parseUrl(uri.toString());
        for (ParameterValuePair parameterValuePair : urlQuerySanitizer.getParameterList()) {
            hashMap.put(parameterValuePair.mParameter, parameterValuePair.mValue);
        }
        return hashMap;
    }

    public static boolean m984m(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, Cast.MAX_MESSAGE_LENGTH);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            eu.m1014D("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        boolean z;
        String str = "com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".";
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            eu.m1014D(String.format(str, new Object[]{"keyboard"}));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            eu.m1014D(String.format(str, new Object[]{"keyboardHidden"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & TransportMediator.FLAG_KEY_MEDIA_NEXT) == 0) {
            eu.m1014D(String.format(str, new Object[]{"orientation"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) == 0) {
            eu.m1014D(String.format(str, new Object[]{"screenLayout"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & AdRequest.MAX_CONTENT_URL_LENGTH) == 0) {
            eu.m1014D(String.format(str, new Object[]{"uiMode"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT) == 0) {
            eu.m1014D(String.format(str, new Object[]{"screenSize"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT) != 0) {
            return z;
        }
        eu.m1014D(String.format(str, new Object[]{"smallestScreenSize"}));
        return false;
    }

    public static void m985n(Context context) {
        if (!sn) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.getApplicationContext().registerReceiver(new C0341a(), intentFilter);
            sn = true;
        }
    }

    private static String m986o(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    public static JSONObject m987o(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                m977a(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            throw new JSONException("Could not convert map to JSON: " + e.getMessage());
        }
    }

    public static int m988p(Context context) {
        int i;
        int i2 = 0;
        if (context instanceof Activity) {
            Window window = ((Activity) context).getWindow();
            Rect rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            i = rect.top;
            i2 = window.findViewById(16908290).getTop() - i;
        } else {
            i = 0;
        }
        return i2 + i;
    }

    public static String m991v(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }
}
