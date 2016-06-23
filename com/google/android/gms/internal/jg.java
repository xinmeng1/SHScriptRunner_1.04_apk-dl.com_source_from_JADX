package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.hb.C0373b;
import com.google.android.gms.internal.hb.C1119e;
import com.google.android.gms.internal.jd.C0796a;
import com.google.android.gms.internal.je.C0798a;
import com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener;
import com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

public class jg extends hb<je> {
    private final jj<je> VJ;
    private final jf VP;
    private final jz VQ;
    private final iz VR;
    private final String VS;

    /* renamed from: com.google.android.gms.internal.jg.a */
    private final class C0799a extends C0373b<OnAddGeofencesResultListener> {
        private final int CT;
        private final String[] VT;
        final /* synthetic */ jg VU;

        public C0799a(jg jgVar, OnAddGeofencesResultListener onAddGeofencesResultListener, int i, String[] strArr) {
            this.VU = jgVar;
            super(jgVar, onAddGeofencesResultListener);
            this.CT = LocationStatusCodes.cJ(i);
            this.VT = strArr;
        }

        protected void m2772a(OnAddGeofencesResultListener onAddGeofencesResultListener) {
            if (onAddGeofencesResultListener != null) {
                onAddGeofencesResultListener.onAddGeofencesResult(this.CT, this.VT);
            }
        }

        protected /* synthetic */ void m2773d(Object obj) {
            m2772a((OnAddGeofencesResultListener) obj);
        }

        protected void fu() {
        }
    }

    /* renamed from: com.google.android.gms.internal.jg.c */
    private final class C0800c implements jj<je> {
        final /* synthetic */ jg VU;

        private C0800c(jg jgVar) {
            this.VU = jgVar;
        }

        public void cn() {
            this.VU.cn();
        }

        public /* synthetic */ IInterface ft() {
            return iZ();
        }

        public je iZ() {
            return (je) this.VU.ft();
        }
    }

    /* renamed from: com.google.android.gms.internal.jg.d */
    private final class C0801d extends C0373b<OnRemoveGeofencesResultListener> {
        private final int CT;
        private final String[] VT;
        final /* synthetic */ jg VU;
        private final int VY;
        private final PendingIntent mPendingIntent;

        public C0801d(jg jgVar, int i, OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, int i2, PendingIntent pendingIntent) {
            boolean z = true;
            this.VU = jgVar;
            super(jgVar, onRemoveGeofencesResultListener);
            if (i != 1) {
                z = false;
            }
            gx.m1158A(z);
            this.VY = i;
            this.CT = LocationStatusCodes.cJ(i2);
            this.mPendingIntent = pendingIntent;
            this.VT = null;
        }

        public C0801d(jg jgVar, int i, OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, int i2, String[] strArr) {
            this.VU = jgVar;
            super(jgVar, onRemoveGeofencesResultListener);
            gx.m1158A(i == 2);
            this.VY = i;
            this.CT = LocationStatusCodes.cJ(i2);
            this.VT = strArr;
            this.mPendingIntent = null;
        }

        protected void m2774a(OnRemoveGeofencesResultListener onRemoveGeofencesResultListener) {
            if (onRemoveGeofencesResultListener != null) {
                switch (this.VY) {
                    case DataEvent.TYPE_CHANGED /*1*/:
                        onRemoveGeofencesResultListener.onRemoveGeofencesByPendingIntentResult(this.CT, this.mPendingIntent);
                    case DataEvent.TYPE_DELETED /*2*/:
                        onRemoveGeofencesResultListener.onRemoveGeofencesByRequestIdsResult(this.CT, this.VT);
                    default:
                        Log.wtf("LocationClientImpl", "Unsupported action: " + this.VY);
                }
            }
        }

        protected /* synthetic */ void m2775d(Object obj) {
            m2774a((OnRemoveGeofencesResultListener) obj);
        }

        protected void fu() {
        }
    }

    /* renamed from: com.google.android.gms.internal.jg.b */
    private static final class C1126b extends C0796a {
        private OnAddGeofencesResultListener VV;
        private OnRemoveGeofencesResultListener VW;
        private jg VX;

        public C1126b(OnAddGeofencesResultListener onAddGeofencesResultListener, jg jgVar) {
            this.VV = onAddGeofencesResultListener;
            this.VW = null;
            this.VX = jgVar;
        }

        public C1126b(OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, jg jgVar) {
            this.VW = onRemoveGeofencesResultListener;
            this.VV = null;
            this.VX = jgVar;
        }

        public void onAddGeofencesResult(int statusCode, String[] geofenceRequestIds) throws RemoteException {
            if (this.VX == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            }
            jg jgVar = this.VX;
            jg jgVar2 = this.VX;
            jgVar2.getClass();
            jgVar.m2664a(new C0799a(jgVar2, this.VV, statusCode, geofenceRequestIds));
            this.VX = null;
            this.VV = null;
            this.VW = null;
        }

        public void onRemoveGeofencesByPendingIntentResult(int statusCode, PendingIntent pendingIntent) {
            if (this.VX == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
                return;
            }
            jg jgVar = this.VX;
            jg jgVar2 = this.VX;
            jgVar2.getClass();
            jgVar.m2664a(new C0801d(jgVar2, 1, this.VW, statusCode, pendingIntent));
            this.VX = null;
            this.VV = null;
            this.VW = null;
        }

        public void onRemoveGeofencesByRequestIdsResult(int statusCode, String[] geofenceRequestIds) {
            if (this.VX == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
                return;
            }
            jg jgVar = this.VX;
            jg jgVar2 = this.VX;
            jgVar2.getClass();
            jgVar.m2664a(new C0801d(jgVar2, 2, this.VW, statusCode, geofenceRequestIds));
            this.VX = null;
            this.VV = null;
            this.VW = null;
        }
    }

    public jg(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str) {
        this(context, looper, context.getPackageName(), connectionCallbacks, onConnectionFailedListener, str, null);
    }

    public jg(Context context, Looper looper, String str, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str2, String str3) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.VJ = new C0800c();
        this.VP = new jf(context, this.VJ);
        this.VS = str2;
        this.VQ = new jz(str, this.VJ);
        this.VR = iz.m1280a(context, str3, this.VJ);
    }

    public jg(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String str) {
        super(context, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.VJ = new C0800c();
        this.VP = new jf(context, this.VJ);
        this.VS = str;
        this.VQ = new jz(context.getPackageName(), this.VJ);
        this.VR = iz.m1280a(context, null, this.VJ);
    }

    protected void m3688a(hi hiVar, C1119e c1119e) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.VS);
        hiVar.m1203e(c1119e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), bundle);
    }

    public void addGeofences(List<jh> geofences, PendingIntent pendingIntent, OnAddGeofencesResultListener listener) throws RemoteException {
        jd jdVar;
        cn();
        boolean z = geofences != null && geofences.size() > 0;
        hm.m1230b(z, (Object) "At least one geofence must be specified.");
        hm.m1228b((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        hm.m1228b((Object) listener, (Object) "OnAddGeofencesResultListener not provided.");
        if (listener == null) {
            jdVar = null;
        } else {
            Object c1126b = new C1126b(listener, this);
        }
        ((je) ft()).m1302a((List) geofences, pendingIntent, jdVar, getContext().getPackageName());
    }

    protected je at(IBinder iBinder) {
        return C0798a.as(iBinder);
    }

    protected String bu() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected String bv() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    public void disconnect() {
        synchronized (this.VP) {
            if (isConnected()) {
                this.VP.removeAllListeners();
                this.VP.iY();
            }
            super.disconnect();
        }
    }

    public Location getLastLocation() {
        return this.VP.getLastLocation();
    }

    public void removeActivityUpdates(PendingIntent callbackIntent) throws RemoteException {
        cn();
        hm.m1232f(callbackIntent);
        ((je) ft()).removeActivityUpdates(callbackIntent);
    }

    public void removeGeofences(PendingIntent pendingIntent, OnRemoveGeofencesResultListener listener) throws RemoteException {
        jd jdVar;
        cn();
        hm.m1228b((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        hm.m1228b((Object) listener, (Object) "OnRemoveGeofencesResultListener not provided.");
        if (listener == null) {
            jdVar = null;
        } else {
            Object c1126b = new C1126b(listener, this);
        }
        ((je) ft()).m1283a(pendingIntent, jdVar, getContext().getPackageName());
    }

    public void removeGeofences(List<String> geofenceRequestIds, OnRemoveGeofencesResultListener listener) throws RemoteException {
        jd jdVar;
        cn();
        boolean z = geofenceRequestIds != null && geofenceRequestIds.size() > 0;
        hm.m1230b(z, (Object) "geofenceRequestIds can't be null nor empty.");
        hm.m1228b((Object) listener, (Object) "OnRemoveGeofencesResultListener not provided.");
        String[] strArr = (String[]) geofenceRequestIds.toArray(new String[0]);
        if (listener == null) {
            jdVar = null;
        } else {
            Object c1126b = new C1126b(listener, this);
        }
        ((je) ft()).m1303a(strArr, jdVar, getContext().getPackageName());
    }

    public void removeLocationUpdates(PendingIntent callbackIntent) throws RemoteException {
        this.VP.removeLocationUpdates(callbackIntent);
    }

    public void removeLocationUpdates(LocationListener listener) throws RemoteException {
        this.VP.removeLocationUpdates(listener);
    }

    public void requestActivityUpdates(long detectionIntervalMillis, PendingIntent callbackIntent) throws RemoteException {
        cn();
        hm.m1232f(callbackIntent);
        hm.m1230b(detectionIntervalMillis >= 0, (Object) "detectionIntervalMillis must be >= 0");
        ((je) ft()).m1281a(detectionIntervalMillis, true, callbackIntent);
    }

    public void requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) throws RemoteException {
        this.VP.requestLocationUpdates(request, callbackIntent);
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener) throws RemoteException {
        requestLocationUpdates(request, listener, null);
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener, Looper looper) throws RemoteException {
        synchronized (this.VP) {
            this.VP.requestLocationUpdates(request, listener, looper);
        }
    }

    public void setMockLocation(Location mockLocation) throws RemoteException {
        this.VP.setMockLocation(mockLocation);
    }

    public void setMockMode(boolean isMockMode) throws RemoteException {
        this.VP.setMockMode(isMockMode);
    }

    protected /* synthetic */ IInterface m3689x(IBinder iBinder) {
        return at(iBinder);
    }
}
