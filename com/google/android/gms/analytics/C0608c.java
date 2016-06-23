package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.fd;
import com.google.android.gms.internal.fe;
import com.google.android.gms.internal.fe.C0756a;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.c */
class C0608c implements C0136b {
    private Context mContext;
    private fe tA;
    private ServiceConnection tx;
    private C0138b ty;
    private C0139c tz;

    /* renamed from: com.google.android.gms.analytics.c.a */
    final class C0137a implements ServiceConnection {
        final /* synthetic */ C0608c tB;

        C0137a(C0608c c0608c) {
            this.tB = c0608c;
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            aa.m39C("service connected, binder: " + binder);
            try {
                if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(binder.getInterfaceDescriptor())) {
                    aa.m39C("bound to service");
                    this.tB.tA = C0756a.m2577z(binder);
                    this.tB.co();
                    return;
                }
            } catch (RemoteException e) {
            }
            this.tB.mContext.unbindService(this);
            this.tB.tx = null;
            this.tB.tz.m56a(2, null);
        }

        public void onServiceDisconnected(ComponentName component) {
            aa.m39C("service disconnected: " + component);
            this.tB.tx = null;
            this.tB.ty.onDisconnected();
        }
    }

    /* renamed from: com.google.android.gms.analytics.c.b */
    public interface C0138b {
        void onConnected();

        void onDisconnected();
    }

    /* renamed from: com.google.android.gms.analytics.c.c */
    public interface C0139c {
        void m56a(int i, Intent intent);
    }

    public C0608c(Context context, C0138b c0138b, C0139c c0139c) {
        this.mContext = context;
        if (c0138b == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.ty = c0138b;
        if (c0139c == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.tz = c0139c;
    }

    private fe cm() {
        cn();
        return this.tA;
    }

    private void co() {
        cp();
    }

    private void cp() {
        this.ty.onConnected();
    }

    public void m1908a(Map<String, String> map, long j, String str, List<fd> list) {
        try {
            cm().m1056a(map, j, str, list);
        } catch (RemoteException e) {
            aa.m37A("sendHit failed: " + e);
        }
    }

    public void cl() {
        try {
            cm().cl();
        } catch (RemoteException e) {
            aa.m37A("clear hits failed: " + e);
        }
    }

    protected void cn() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect() {
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.analytics.service.AnalyticsService"));
        intent.putExtra("app_package_name", this.mContext.getPackageName());
        if (this.tx != null) {
            aa.m37A("Calling connect() while still connected, missing disconnect().");
            return;
        }
        this.tx = new C0137a(this);
        boolean bindService = this.mContext.bindService(intent, this.tx, 129);
        aa.m39C("connect: bindService returned " + bindService + " for " + intent);
        if (!bindService) {
            this.tx = null;
            this.tz.m56a(1, null);
        }
    }

    public void disconnect() {
        this.tA = null;
        if (this.tx != null) {
            try {
                this.mContext.unbindService(this.tx);
            } catch (IllegalStateException e) {
            } catch (IllegalArgumentException e2) {
            }
            this.tx = null;
            this.ty.onDisconnected();
        }
    }

    public boolean isConnected() {
        return this.tA != null;
    }
}
