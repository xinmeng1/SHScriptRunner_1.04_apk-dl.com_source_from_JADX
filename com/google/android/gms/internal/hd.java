package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.hb.C0374f;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class hd implements Callback {
    private static final Object Gv;
    private static hd Gw;
    private final HashMap<String, C0378a> Gx;
    private final Context lz;
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.hd.a */
    final class C0378a {
        private final HashSet<C0374f> GA;
        private boolean GB;
        private IBinder GC;
        private ComponentName GD;
        final /* synthetic */ hd GE;
        private final String Gy;
        private final C0377a Gz;
        private int mState;

        /* renamed from: com.google.android.gms.internal.hd.a.a */
        public class C0377a implements ServiceConnection {
            final /* synthetic */ C0378a GF;

            public C0377a(C0378a c0378a) {
                this.GF = c0378a;
            }

            public void onServiceConnected(ComponentName component, IBinder binder) {
                synchronized (this.GF.GE.Gx) {
                    this.GF.GC = binder;
                    this.GF.GD = component;
                    Iterator it = this.GF.GA.iterator();
                    while (it.hasNext()) {
                        ((C0374f) it.next()).onServiceConnected(component, binder);
                    }
                    this.GF.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName component) {
                synchronized (this.GF.GE.Gx) {
                    this.GF.GC = null;
                    this.GF.GD = component;
                    Iterator it = this.GF.GA.iterator();
                    while (it.hasNext()) {
                        ((C0374f) it.next()).onServiceDisconnected(component);
                    }
                    this.GF.mState = 2;
                }
            }
        }

        public C0378a(hd hdVar, String str) {
            this.GE = hdVar;
            this.Gy = str;
            this.Gz = new C0377a(this);
            this.GA = new HashSet();
            this.mState = 0;
        }

        public void m1170B(boolean z) {
            this.GB = z;
        }

        public void m1171a(C0374f c0374f) {
            this.GA.add(c0374f);
        }

        public void m1172b(C0374f c0374f) {
            this.GA.remove(c0374f);
        }

        public boolean m1173c(C0374f c0374f) {
            return this.GA.contains(c0374f);
        }

        public C0377a fx() {
            return this.Gz;
        }

        public String fy() {
            return this.Gy;
        }

        public boolean fz() {
            return this.GA.isEmpty();
        }

        public IBinder getBinder() {
            return this.GC;
        }

        public ComponentName getComponentName() {
            return this.GD;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.GB;
        }
    }

    static {
        Gv = new Object();
    }

    private hd(Context context) {
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.Gx = new HashMap();
        this.lz = context.getApplicationContext();
    }

    public static hd m1174E(Context context) {
        synchronized (Gv) {
            if (Gw == null) {
                Gw = new hd(context.getApplicationContext());
            }
        }
        return Gw;
    }

    public boolean m1176a(String str, C0374f c0374f) {
        boolean isBound;
        synchronized (this.Gx) {
            C0378a c0378a = (C0378a) this.Gx.get(str);
            if (c0378a != null) {
                this.mHandler.removeMessages(0, c0378a);
                if (!c0378a.m1173c(c0374f)) {
                    c0378a.m1171a((C0374f) c0374f);
                    switch (c0378a.getState()) {
                        case DataEvent.TYPE_CHANGED /*1*/:
                            c0374f.onServiceConnected(c0378a.getComponentName(), c0378a.getBinder());
                            break;
                        case DataEvent.TYPE_DELETED /*2*/:
                            c0378a.m1170B(this.lz.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), c0378a.fx(), 129));
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + str);
            }
            c0378a = new C0378a(this, str);
            c0378a.m1171a((C0374f) c0374f);
            c0378a.m1170B(this.lz.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), c0378a.fx(), 129));
            this.Gx.put(str, c0378a);
            isBound = c0378a.isBound();
        }
        return isBound;
    }

    public void m1177b(String str, C0374f c0374f) {
        synchronized (this.Gx) {
            C0378a c0378a = (C0378a) this.Gx.get(str);
            if (c0378a == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + str);
            } else if (c0378a.m1173c(c0374f)) {
                c0378a.m1172b(c0374f);
                if (c0378a.fz()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, c0378a), 5000);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + str);
            }
        }
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                C0378a c0378a = (C0378a) msg.obj;
                synchronized (this.Gx) {
                    if (c0378a.fz()) {
                        this.lz.unbindService(c0378a.fx());
                        this.Gx.remove(c0378a.fy());
                    }
                    break;
                }
                return true;
            default:
                return false;
        }
    }
}
