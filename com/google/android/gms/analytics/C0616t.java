package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Process;
import android.support.v4.os.EnvironmentCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.google.android.gms.internal.fd;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.analytics.t */
class C0616t extends Thread implements C0142f {
    private static C0616t uO;
    private volatile boolean mClosed;
    private final Context mContext;
    private final LinkedBlockingQueue<Runnable> uK;
    private volatile boolean uL;
    private volatile List<fd> uM;
    private volatile String uN;
    private volatile ag uP;

    /* renamed from: com.google.android.gms.analytics.t.1 */
    class C01611 implements Runnable {
        final /* synthetic */ Map uQ;
        final /* synthetic */ C0616t uR;

        C01611(C0616t c0616t, Map map) {
            this.uR = c0616t;
            this.uQ = map;
        }

        public void run() {
            this.uR.m1952s(this.uQ);
            if (TextUtils.isEmpty((CharSequence) this.uQ.get("&cid"))) {
                this.uQ.put("&cid", C0610h.cv().getValue("&cid"));
            }
            if (!GoogleAnalytics.getInstance(this.uR.mContext).getAppOptOut() && !this.uR.m1951r(this.uQ)) {
                if (!TextUtils.isEmpty(this.uR.uN)) {
                    C0166u.cU().m84u(true);
                    this.uQ.putAll(new HitBuilder().setCampaignParamsFromUrl(this.uR.uN).build());
                    C0166u.cU().m84u(false);
                    this.uR.uN = null;
                }
                this.uR.m1953t(this.uQ);
                this.uR.uP.m46b(C0168y.m88u(this.uQ), Long.valueOf((String) this.uQ.get("&ht")).longValue(), this.uR.m1950q(this.uQ), this.uR.uM);
            }
        }
    }

    /* renamed from: com.google.android.gms.analytics.t.2 */
    class C01622 implements Runnable {
        final /* synthetic */ C0616t uR;

        C01622(C0616t c0616t) {
            this.uR = c0616t;
        }

        public void run() {
            this.uR.uP.cq();
        }
    }

    /* renamed from: com.google.android.gms.analytics.t.3 */
    class C01633 implements Runnable {
        final /* synthetic */ C0616t uR;

        C01633(C0616t c0616t) {
            this.uR = c0616t;
        }

        public void run() {
            this.uR.uP.cl();
        }
    }

    /* renamed from: com.google.android.gms.analytics.t.4 */
    class C01644 implements Runnable {
        final /* synthetic */ C0616t uR;

        C01644(C0616t c0616t) {
            this.uR = c0616t;
        }

        public void run() {
            this.uR.uP.cs();
        }
    }

    private C0616t(Context context) {
        super("GAThread");
        this.uK = new LinkedBlockingQueue();
        this.uL = false;
        this.mClosed = false;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    static int m1939O(String str) {
        int i = 1;
        if (!TextUtils.isEmpty(str)) {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                i = (((i << 6) & 268435455) + charAt) + (charAt << 14);
                int i2 = 266338304 & i;
                if (i2 != 0) {
                    i ^= i2 >> 21;
                }
            }
        }
        return i;
    }

    private String m1942a(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    private String m1950q(Map<String, String> map) {
        return map.containsKey("useSecure") ? ak.m53d((String) map.get("useSecure"), true) ? "https:" : "http:" : "https:";
    }

    private boolean m1951r(Map<String, String> map) {
        if (map.get("&sf") == null) {
            return false;
        }
        double a = ak.m50a((String) map.get("&sf"), 100.0d);
        if (a >= 100.0d) {
            return false;
        }
        if (((double) (C0616t.m1939O((String) map.get("&cid")) % 10000)) < a * 100.0d) {
            return false;
        }
        String str = map.get("&t") == null ? EnvironmentCompat.MEDIA_UNKNOWN : (String) map.get("&t");
        aa.m39C(String.format("%s hit sampled out", new Object[]{str}));
        return true;
    }

    private void m1952s(Map<String, String> map) {
        C0148m s = C0605a.m1872s(this.mContext);
        ak.m52a(map, "&adid", s.getValue("&adid"));
        ak.m52a(map, "&ate", s.getValue("&ate"));
    }

    private void m1953t(Map<String, String> map) {
        C0148m cu = C0609g.cu();
        ak.m52a(map, "&an", cu.getValue("&an"));
        ak.m52a(map, "&av", cu.getValue("&av"));
        ak.m52a(map, "&aid", cu.getValue("&aid"));
        ak.m52a(map, "&aiid", cu.getValue("&aiid"));
        map.put("&v", "1");
    }

    static C0616t m1954x(Context context) {
        if (uO == null) {
            uO = new C0616t(context);
        }
        return uO;
    }

    static String m1955y(Context context) {
        try {
            FileInputStream openFileInput = context.openFileInput("gaInstallData");
            byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD];
            int read = openFileInput.read(bArr, 0, AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD);
            if (openFileInput.available() > 0) {
                aa.m37A("Too much campaign data, ignoring it.");
                openFileInput.close();
                context.deleteFile("gaInstallData");
                return null;
            }
            openFileInput.close();
            context.deleteFile("gaInstallData");
            if (read <= 0) {
                aa.m40D("Campaign file is empty.");
                return null;
            }
            String str = new String(bArr, 0, read);
            aa.m38B("Campaign found: " + str);
            return str;
        } catch (FileNotFoundException e) {
            aa.m38B("No campaign data found.");
            return null;
        } catch (IOException e2) {
            aa.m37A("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
    }

    void m1956a(Runnable runnable) {
        this.uK.add(runnable);
    }

    public void cl() {
        m1956a(new C01633(this));
    }

    public void cq() {
        m1956a(new C01622(this));
    }

    public void cs() {
        m1956a(new C01644(this));
    }

    public LinkedBlockingQueue<Runnable> ct() {
        return this.uK;
    }

    public Thread getThread() {
        return this;
    }

    protected void init() {
        this.uP.cL();
        this.uM = new ArrayList();
        this.uM.add(new fd("appendVersion", "&_v".substring(1), "ma4.0.2"));
        this.uM.add(new fd("appendQueueTime", "&qt".substring(1), null));
        this.uM.add(new fd("appendCacheBuster", "&z".substring(1), null));
    }

    public void m1957p(Map<String, String> map) {
        Map hashMap = new HashMap(map);
        String str = (String) map.get("&ht");
        if (str != null) {
            try {
                Long.valueOf(str);
            } catch (NumberFormatException e) {
                str = null;
            }
        }
        if (str == null) {
            hashMap.put("&ht", Long.toString(System.currentTimeMillis()));
        }
        m1956a(new C01611(this, hashMap));
    }

    public void run() {
        Process.setThreadPriority(10);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            aa.m40D("sleep interrupted in GAThread initialize");
        }
        try {
            if (this.uP == null) {
                this.uP = new C0615s(this.mContext, this);
            }
            init();
            this.uN = C0616t.m1955y(this.mContext);
            aa.m39C("Initialized GA Thread");
        } catch (Throwable th) {
            aa.m37A("Error initializing the GAThread: " + m1942a(th));
            aa.m37A("Google Analytics will not start up.");
            this.uL = true;
        }
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.uK.take();
                if (!this.uL) {
                    runnable.run();
                }
            } catch (InterruptedException e2) {
                aa.m38B(e2.toString());
            } catch (Throwable th2) {
                aa.m37A("Error on GAThread: " + m1942a(th2));
                aa.m37A("Google Analytics is shutting down.");
                this.uL = true;
            }
        }
    }
}
