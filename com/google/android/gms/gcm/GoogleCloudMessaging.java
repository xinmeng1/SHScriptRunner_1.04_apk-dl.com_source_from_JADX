package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class GoogleCloudMessaging {
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String MESSAGE_TYPE_DELETED = "deleted_messages";
    public static final String MESSAGE_TYPE_MESSAGE = "gcm";
    public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";
    static GoogleCloudMessaging Us;
    private PendingIntent Ut;
    final BlockingQueue<Intent> Uu;
    private Handler Uv;
    private Messenger Uw;
    private Context kO;

    /* renamed from: com.google.android.gms.gcm.GoogleCloudMessaging.1 */
    class C02911 extends Handler {
        final /* synthetic */ GoogleCloudMessaging Ux;

        C02911(GoogleCloudMessaging googleCloudMessaging, Looper looper) {
            this.Ux = googleCloudMessaging;
            super(looper);
        }

        public void handleMessage(Message msg) {
            this.Ux.Uu.add((Intent) msg.obj);
        }
    }

    public GoogleCloudMessaging() {
        this.Uu = new LinkedBlockingQueue();
        this.Uv = new C02911(this, Looper.getMainLooper());
        this.Uw = new Messenger(this.Uv);
    }

    private void m752a(String str, String str2, long j, int i, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException(ERROR_MAIN_THREAD);
        } else if (str == null) {
            throw new IllegalArgumentException("Missing 'to'");
        } else {
            Intent intent = new Intent("com.google.android.gcm.intent.SEND");
            intent.putExtras(bundle);
            m755h(intent);
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
            intent.putExtra("google.to", str);
            intent.putExtra("google.message_id", str2);
            intent.putExtra("google.ttl", Long.toString(j));
            intent.putExtra("google.delay", Integer.toString(i));
            this.kO.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
        }
    }

    private void m753c(String... strArr) {
        String d = m754d(strArr);
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
        intent.putExtra("google.messenger", this.Uw);
        m755h(intent);
        intent.putExtra("sender", d);
        this.kO.startService(intent);
    }

    public static synchronized GoogleCloudMessaging getInstance(Context context) {
        GoogleCloudMessaging googleCloudMessaging;
        synchronized (GoogleCloudMessaging.class) {
            if (Us == null) {
                Us = new GoogleCloudMessaging();
                Us.kO = context;
            }
            googleCloudMessaging = Us;
        }
        return googleCloudMessaging;
    }

    private void iO() {
        Intent intent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
        this.Uu.clear();
        intent.putExtra("google.messenger", this.Uw);
        m755h(intent);
        this.kO.startService(intent);
    }

    public void close() {
        iP();
    }

    String m754d(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder stringBuilder = new StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            stringBuilder.append(',').append(strArr[i]);
        }
        return stringBuilder.toString();
    }

    public String getMessageType(Intent intent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            return null;
        }
        String stringExtra = intent.getStringExtra("message_type");
        return stringExtra == null ? MESSAGE_TYPE_MESSAGE : stringExtra;
    }

    synchronized void m755h(Intent intent) {
        if (this.Ut == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.Ut = PendingIntent.getBroadcast(this.kO, 0, intent2, 0);
        }
        intent.putExtra("app", this.Ut);
    }

    synchronized void iP() {
        if (this.Ut != null) {
            this.Ut.cancel();
            this.Ut = null;
        }
    }

    public String register(String... senderIds) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException(ERROR_MAIN_THREAD);
        }
        this.Uu.clear();
        m753c(senderIds);
        try {
            Intent intent = (Intent) this.Uu.poll(5000, TimeUnit.MILLISECONDS);
            if (intent == null) {
                throw new IOException(ERROR_SERVICE_NOT_AVAILABLE);
            }
            String stringExtra = intent.getStringExtra("registration_id");
            if (stringExtra != null) {
                return stringExtra;
            }
            intent.getStringExtra("error");
            String stringExtra2 = intent.getStringExtra("error");
            if (stringExtra2 != null) {
                throw new IOException(stringExtra2);
            }
            throw new IOException(ERROR_SERVICE_NOT_AVAILABLE);
        } catch (InterruptedException e) {
            throw new IOException(e.getMessage());
        }
    }

    public void send(String to, String msgId, long timeToLive, Bundle data) throws IOException {
        m752a(to, msgId, timeToLive, -1, data);
    }

    public void send(String to, String msgId, Bundle data) throws IOException {
        send(to, msgId, -1, data);
    }

    public void unregister() throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException(ERROR_MAIN_THREAD);
        }
        iO();
        try {
            Intent intent = (Intent) this.Uu.poll(5000, TimeUnit.MILLISECONDS);
            if (intent == null) {
                throw new IOException(ERROR_SERVICE_NOT_AVAILABLE);
            } else if (intent.getStringExtra("unregistered") == null) {
                String stringExtra = intent.getStringExtra("error");
                if (stringExtra != null) {
                    throw new IOException(stringExtra);
                }
                throw new IOException(ERROR_SERVICE_NOT_AVAILABLE);
            }
        } catch (InterruptedException e) {
            throw new IOException(e.getMessage());
        }
    }
}
