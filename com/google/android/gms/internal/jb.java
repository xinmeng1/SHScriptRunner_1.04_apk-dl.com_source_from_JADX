package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationServices.C1221a;

public class jb implements FusedLocationProviderApi {

    /* renamed from: com.google.android.gms.internal.jb.a */
    private static abstract class C1274a extends C1221a<Status> {
        private C1274a() {
        }

        public /* synthetic */ Result m4252c(Status status) {
            return m4253d(status);
        }

        public Status m4253d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.jb.1 */
    class C14201 extends C1274a {
        final /* synthetic */ LocationRequest Vw;
        final /* synthetic */ LocationListener Vx;
        final /* synthetic */ jb Vy;

        C14201(jb jbVar, LocationRequest locationRequest, LocationListener locationListener) {
            this.Vy = jbVar;
            this.Vw = locationRequest;
            this.Vx = locationListener;
            super();
        }

        protected void m4637a(jg jgVar) throws RemoteException {
            jgVar.requestLocationUpdates(this.Vw, this.Vx);
            m1984b(Status.En);
        }
    }

    /* renamed from: com.google.android.gms.internal.jb.2 */
    class C14212 extends C1274a {
        final /* synthetic */ LocationRequest Vw;
        final /* synthetic */ LocationListener Vx;
        final /* synthetic */ jb Vy;
        final /* synthetic */ Looper Vz;

        C14212(jb jbVar, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
            this.Vy = jbVar;
            this.Vw = locationRequest;
            this.Vx = locationListener;
            this.Vz = looper;
            super();
        }

        protected void m4639a(jg jgVar) throws RemoteException {
            jgVar.requestLocationUpdates(this.Vw, this.Vx, this.Vz);
            m1984b(Status.En);
        }
    }

    /* renamed from: com.google.android.gms.internal.jb.3 */
    class C14223 extends C1274a {
        final /* synthetic */ PendingIntent Vu;
        final /* synthetic */ LocationRequest Vw;
        final /* synthetic */ jb Vy;

        C14223(jb jbVar, LocationRequest locationRequest, PendingIntent pendingIntent) {
            this.Vy = jbVar;
            this.Vw = locationRequest;
            this.Vu = pendingIntent;
            super();
        }

        protected void m4641a(jg jgVar) throws RemoteException {
            jgVar.requestLocationUpdates(this.Vw, this.Vu);
            m1984b(Status.En);
        }
    }

    /* renamed from: com.google.android.gms.internal.jb.4 */
    class C14234 extends C1274a {
        final /* synthetic */ LocationListener Vx;
        final /* synthetic */ jb Vy;

        C14234(jb jbVar, LocationListener locationListener) {
            this.Vy = jbVar;
            this.Vx = locationListener;
            super();
        }

        protected void m4643a(jg jgVar) throws RemoteException {
            jgVar.removeLocationUpdates(this.Vx);
            m1984b(Status.En);
        }
    }

    /* renamed from: com.google.android.gms.internal.jb.5 */
    class C14245 extends C1274a {
        final /* synthetic */ PendingIntent Vu;
        final /* synthetic */ jb Vy;

        C14245(jb jbVar, PendingIntent pendingIntent) {
            this.Vy = jbVar;
            this.Vu = pendingIntent;
            super();
        }

        protected void m4645a(jg jgVar) throws RemoteException {
            jgVar.removeLocationUpdates(this.Vu);
            m1984b(Status.En);
        }
    }

    /* renamed from: com.google.android.gms.internal.jb.6 */
    class C14256 extends C1274a {
        final /* synthetic */ boolean VA;
        final /* synthetic */ jb Vy;

        C14256(jb jbVar, boolean z) {
            this.Vy = jbVar;
            this.VA = z;
            super();
        }

        protected void m4647a(jg jgVar) throws RemoteException {
            jgVar.setMockMode(this.VA);
            m1984b(Status.En);
        }
    }

    /* renamed from: com.google.android.gms.internal.jb.7 */
    class C14267 extends C1274a {
        final /* synthetic */ Location VB;
        final /* synthetic */ jb Vy;

        C14267(jb jbVar, Location location) {
            this.Vy = jbVar;
            this.VB = location;
            super();
        }

        protected void m4649a(jg jgVar) throws RemoteException {
            jgVar.setMockLocation(this.VB);
            m1984b(Status.En);
        }
    }

    public Location getLastLocation(GoogleApiClient client) {
        try {
            return LocationServices.m1478e(client).getLastLocation();
        } catch (Exception e) {
            return null;
        }
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, PendingIntent callbackIntent) {
        return client.m147b(new C14245(this, callbackIntent));
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, LocationListener listener) {
        return client.m147b(new C14234(this, listener));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, LocationRequest request, PendingIntent callbackIntent) {
        return client.m147b(new C14223(this, request, callbackIntent));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, LocationRequest request, LocationListener listener) {
        return client.m147b(new C14201(this, request, listener));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, LocationRequest request, LocationListener listener, Looper looper) {
        return client.m147b(new C14212(this, request, listener, looper));
    }

    public PendingResult<Status> setMockLocation(GoogleApiClient client, Location mockLocation) {
        return client.m147b(new C14267(this, mockLocation));
    }

    public PendingResult<Status> setMockMode(GoogleApiClient client, boolean isMockMode) {
        return client.m147b(new C14256(this, isMockMode));
    }
}
