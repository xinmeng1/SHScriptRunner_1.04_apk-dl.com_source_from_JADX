package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.ac.C1004a;
import com.google.android.gms.wearable.internal.af;
import com.google.android.gms.wearable.internal.ai;

public abstract class WearableListenerService extends Service implements DataListener, MessageListener, NodeListener {
    public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
    private IBinder GC;
    private volatile int alq;
    private Handler alr;
    private Object als;
    private boolean alt;
    private String xQ;

    /* renamed from: com.google.android.gms.wearable.WearableListenerService.a */
    private class C1172a extends C1004a {
        final /* synthetic */ WearableListenerService alu;

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.a.1 */
        class C05601 implements Runnable {
            final /* synthetic */ DataHolder alv;
            final /* synthetic */ C1172a alw;

            C05601(C1172a c1172a, DataHolder dataHolder) {
                this.alw = c1172a;
                this.alv = dataHolder;
            }

            public void run() {
                DataEventBuffer dataEventBuffer = new DataEventBuffer(this.alv);
                try {
                    this.alw.alu.onDataChanged(dataEventBuffer);
                } finally {
                    dataEventBuffer.release();
                }
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.a.2 */
        class C05612 implements Runnable {
            final /* synthetic */ C1172a alw;
            final /* synthetic */ af alx;

            C05612(C1172a c1172a, af afVar) {
                this.alw = c1172a;
                this.alx = afVar;
            }

            public void run() {
                this.alw.alu.onMessageReceived(this.alx);
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.a.3 */
        class C05623 implements Runnable {
            final /* synthetic */ C1172a alw;
            final /* synthetic */ ai aly;

            C05623(C1172a c1172a, ai aiVar) {
                this.alw = c1172a;
                this.aly = aiVar;
            }

            public void run() {
                this.alw.alu.onPeerConnected(this.aly);
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.a.4 */
        class C05634 implements Runnable {
            final /* synthetic */ C1172a alw;
            final /* synthetic */ ai aly;

            C05634(C1172a c1172a, ai aiVar) {
                this.alw = c1172a;
                this.aly = aiVar;
            }

            public void run() {
                this.alw.alu.onPeerDisconnected(this.aly);
            }
        }

        private C1172a(WearableListenerService wearableListenerService) {
            this.alu = wearableListenerService;
        }

        public void m3856Y(DataHolder dataHolder) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onDataItemChanged: " + this.alu.xQ + ": " + dataHolder);
            }
            this.alu.nn();
            synchronized (this.alu.als) {
                if (this.alu.alt) {
                    dataHolder.close();
                    return;
                }
                this.alu.alr.post(new C05601(this, dataHolder));
            }
        }

        public void m3857a(af afVar) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onMessageReceived: " + afVar);
            }
            this.alu.nn();
            synchronized (this.alu.als) {
                if (this.alu.alt) {
                    return;
                }
                this.alu.alr.post(new C05612(this, afVar));
            }
        }

        public void m3858a(ai aiVar) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onPeerConnected: " + this.alu.xQ + ": " + aiVar);
            }
            this.alu.nn();
            synchronized (this.alu.als) {
                if (this.alu.alt) {
                    return;
                }
                this.alu.alr.post(new C05623(this, aiVar));
            }
        }

        public void m3859b(ai aiVar) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onPeerDisconnected: " + this.alu.xQ + ": " + aiVar);
            }
            this.alu.nn();
            synchronized (this.alu.als) {
                if (this.alu.alt) {
                    return;
                }
                this.alu.alr.post(new C05634(this, aiVar));
            }
        }
    }

    public WearableListenerService() {
        this.alq = -1;
        this.als = new Object();
    }

    private boolean ed(int i) {
        String str = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE;
        String[] packagesForUid = getPackageManager().getPackagesForUid(i);
        if (packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    private void nn() throws SecurityException {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.alq) {
            if (GooglePlayServicesUtil.m134b(getPackageManager(), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE) && ed(callingUid)) {
                this.alq = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    public final IBinder onBind(Intent intent) {
        return BIND_LISTENER_INTENT_ACTION.equals(intent.getAction()) ? this.GC : null;
    }

    public void onCreate() {
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onCreate: " + getPackageName());
        }
        this.xQ = getPackageName();
        HandlerThread handlerThread = new HandlerThread("WearableListenerService");
        handlerThread.start();
        this.alr = new Handler(handlerThread.getLooper());
        this.GC = new C1172a();
    }

    public void onDataChanged(DataEventBuffer dataEvents) {
    }

    public void onDestroy() {
        synchronized (this.als) {
            this.alt = true;
            this.alr.getLooper().quit();
        }
        super.onDestroy();
    }

    public void onMessageReceived(MessageEvent messageEvent) {
    }

    public void onPeerConnected(Node peer) {
    }

    public void onPeerDisconnected(Node peer) {
    }
}
