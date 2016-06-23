package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.C0209b;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.internal.C0648p.C1250j;
import com.google.android.gms.drive.internal.C0648p.C1329k;
import com.google.android.gms.drive.internal.aa.C0643a;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.C1119e;
import com.google.android.gms.internal.hh;
import com.google.android.gms.internal.hi;
import com.google.android.gms.internal.hm;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.drive.internal.r */
public class C1042r extends hb<aa> {
    private final String IQ;
    private final Bundle IR;
    private DriveId IS;
    private DriveId IT;
    final ConnectionCallbacks IU;
    Map<DriveId, Map<Listener<?>, C1048x<?>>> IV;
    private final String yQ;

    /* renamed from: com.google.android.gms.drive.internal.r.1 */
    class C13301 extends C1250j {
        final /* synthetic */ DriveId IW;
        final /* synthetic */ int IX;
        final /* synthetic */ C1048x IY;
        final /* synthetic */ C1042r IZ;

        C13301(C1042r c1042r, DriveId driveId, int i, C1048x c1048x) {
            this.IZ = c1042r;
            this.IW = driveId;
            this.IX = i;
            this.IY = c1048x;
        }

        protected void m4390a(C1042r c1042r) throws RemoteException {
            c1042r.gp().m279a(new AddEventListenerRequest(this.IW, this.IX, null), this.IY, null, new aw(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.2 */
    class C13312 extends C1250j {
        final /* synthetic */ DriveId IW;
        final /* synthetic */ int IX;
        final /* synthetic */ C1048x IY;
        final /* synthetic */ C1042r IZ;

        C13312(C1042r c1042r, DriveId driveId, int i, C1048x c1048x) {
            this.IZ = c1042r;
            this.IW = driveId;
            this.IX = i;
            this.IY = c1048x;
        }

        protected void m4392a(C1042r c1042r) throws RemoteException {
            c1042r.gp().m296a(new RemoveEventListenerRequest(this.IW, this.IX), this.IY, null, new aw(this));
        }
    }

    public C1042r(Context context, Looper looper, gy gyVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String[] strArr, Bundle bundle) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.IV = new HashMap();
        this.yQ = (String) hm.m1228b(gyVar.fj(), (Object) "Must call Api.ClientBuilder.setAccountName()");
        this.IQ = gyVar.fn();
        this.IU = connectionCallbacks;
        this.IR = bundle;
    }

    protected aa m3217O(IBinder iBinder) {
        return C0643a.m2061P(iBinder);
    }

    <C extends DriveEvent> PendingResult<Status> m3218a(GoogleApiClient googleApiClient, DriveId driveId, int i, Listener<C> listener) {
        PendingResult<Status> c1329k;
        hm.m1230b(C0209b.m272a(i, driveId), (Object) "id");
        hm.m1228b((Object) listener, (Object) "listener");
        hm.m1226a(isConnected(), "Client must be connected");
        synchronized (this.IV) {
            Map map = (Map) this.IV.get(driveId);
            if (map == null) {
                map = new HashMap();
                this.IV.put(driveId, map);
            }
            if (map.containsKey(listener)) {
                c1329k = new C1329k(googleApiClient, Status.En);
            } else {
                C1048x c1048x = new C1048x(getLooper(), i, listener);
                map.put(listener, c1048x);
                c1329k = googleApiClient.m147b(new C13301(this, driveId, i, c1048x));
            }
        }
        return c1329k;
    }

    protected void m3219a(int i, IBinder iBinder, Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.IS = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.IT = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
        }
        super.m2663a(i, iBinder, bundle);
    }

    protected void m3220a(hi hiVar, C1119e c1119e) throws RemoteException {
        String packageName = getContext().getPackageName();
        hm.m1232f(c1119e);
        hm.m1232f(packageName);
        hm.m1232f(fs());
        Bundle bundle = new Bundle();
        bundle.putString("proxy_package_name", this.IQ);
        bundle.putAll(this.IR);
        hiVar.m1194a((hh) c1119e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, packageName, fs(), this.yQ, bundle);
    }

    PendingResult<Status> m3221b(GoogleApiClient googleApiClient, DriveId driveId, int i, Listener<?> listener) {
        PendingResult<Status> c1329k;
        hm.m1230b(C0209b.m272a(i, driveId), (Object) "id");
        hm.m1226a(isConnected(), "Client must be connected");
        hm.m1228b((Object) listener, (Object) "listener");
        synchronized (this.IV) {
            Map map = (Map) this.IV.get(driveId);
            if (map == null) {
                c1329k = new C1329k(googleApiClient, Status.En);
            } else {
                C1048x c1048x = (C1048x) map.remove(listener);
                if (c1048x == null) {
                    c1329k = new C1329k(googleApiClient, Status.En);
                } else {
                    if (map.isEmpty()) {
                        this.IV.remove(driveId);
                    }
                    c1329k = googleApiClient.m147b(new C13312(this, driveId, i, c1048x));
                }
            }
        }
        return c1329k;
    }

    protected String bu() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    protected String bv() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    public void disconnect() {
        aa aaVar = (aa) ft();
        if (aaVar != null) {
            try {
                aaVar.m289a(new DisconnectRequest());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        this.IV.clear();
    }

    public aa gp() {
        return (aa) ft();
    }

    public DriveId gq() {
        return this.IS;
    }

    public DriveId gr() {
        return this.IT;
    }

    protected /* synthetic */ IInterface m3222x(IBinder iBinder) {
        return m3217O(iBinder);
    }
}
