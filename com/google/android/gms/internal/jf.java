package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.location.C0409a;
import com.google.android.gms.location.C0409a.C0831a;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashMap;

public class jf {
    private final jj<je> VJ;
    private ContentProviderClient VK;
    private boolean VL;
    private HashMap<LocationListener, C1125b> VM;
    private final Context mContext;

    /* renamed from: com.google.android.gms.internal.jf.a */
    private static class C0385a extends Handler {
        private final LocationListener VN;

        public C0385a(LocationListener locationListener) {
            this.VN = locationListener;
        }

        public C0385a(LocationListener locationListener, Looper looper) {
            super(looper);
            this.VN = locationListener;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    this.VN.onLocationChanged(new Location((Location) msg.obj));
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.jf.b */
    private static class C1125b extends C0831a {
        private Handler VO;

        C1125b(LocationListener locationListener, Looper looper) {
            this.VO = looper == null ? new C0385a(locationListener) : new C0385a(locationListener, looper);
        }

        public void onLocationChanged(Location location) {
            if (this.VO == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.VO.sendMessage(obtain);
        }

        public void release() {
            this.VO = null;
        }
    }

    public jf(Context context, jj<je> jjVar) {
        this.VK = null;
        this.VL = false;
        this.VM = new HashMap();
        this.mContext = context;
        this.VJ = jjVar;
    }

    public Location getLastLocation() {
        this.VJ.cn();
        try {
            return ((je) this.VJ.ft()).bo(this.mContext.getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void iY() {
        if (this.VL) {
            try {
                setMockMode(false);
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.VM) {
                for (C0409a c0409a : this.VM.values()) {
                    if (c0409a != null) {
                        ((je) this.VJ.ft()).m1295a(c0409a);
                    }
                }
                this.VM.clear();
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(PendingIntent callbackIntent) throws RemoteException {
        this.VJ.cn();
        ((je) this.VJ.ft()).m1282a(callbackIntent);
    }

    public void removeLocationUpdates(LocationListener listener) throws RemoteException {
        this.VJ.cn();
        hm.m1228b((Object) listener, (Object) "Invalid null listener");
        synchronized (this.VM) {
            C0409a c0409a = (C1125b) this.VM.remove(listener);
            if (this.VK != null && this.VM.isEmpty()) {
                this.VK.release();
                this.VK = null;
            }
            if (c0409a != null) {
                c0409a.release();
                ((je) this.VJ.ft()).m1295a(c0409a);
            }
        }
    }

    public void requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) throws RemoteException {
        this.VJ.cn();
        ((je) this.VJ.ft()).m1292a(request, callbackIntent);
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener, Looper looper) throws RemoteException {
        this.VJ.cn();
        if (looper == null) {
            hm.m1228b(Looper.myLooper(), (Object) "Can't create handler inside thread that has not called Looper.prepare()");
        }
        synchronized (this.VM) {
            C0409a c1125b;
            C1125b c1125b2 = (C1125b) this.VM.get(listener);
            if (c1125b2 == null) {
                c1125b = new C1125b(listener, looper);
            } else {
                Object obj = c1125b2;
            }
            this.VM.put(listener, c1125b);
            ((je) this.VJ.ft()).m1294a(request, c1125b, this.mContext.getPackageName());
        }
    }

    public void setMockLocation(Location mockLocation) throws RemoteException {
        this.VJ.cn();
        ((je) this.VJ.ft()).setMockLocation(mockLocation);
    }

    public void setMockMode(boolean isMockMode) throws RemoteException {
        this.VJ.cn();
        ((je) this.VJ.ft()).setMockMode(isMockMode);
        this.VL = isMockMode;
    }
}
