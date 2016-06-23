package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener;
import com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener;
import com.google.android.gms.location.LocationServices.C1221a;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.ArrayList;
import java.util.List;

public class jc implements GeofencingApi {

    /* renamed from: com.google.android.gms.internal.jc.a */
    private static abstract class C1275a extends C1221a<Status> {
        private C1275a() {
        }

        public /* synthetic */ Result m4254c(Status status) {
            return m4255d(status);
        }

        public Status m4255d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.jc.1 */
    class C14271 extends C1275a {
        final /* synthetic */ List VC;
        final /* synthetic */ PendingIntent VD;
        final /* synthetic */ jc VE;

        /* renamed from: com.google.android.gms.internal.jc.1.1 */
        class C07921 implements OnAddGeofencesResultListener {
            final /* synthetic */ C14271 VF;

            C07921(C14271 c14271) {
                this.VF = c14271;
            }

            public void onAddGeofencesResult(int statusCode, String[] geofenceRequestIds) {
                this.VF.m1984b(LocationStatusCodes.cK(statusCode));
            }
        }

        C14271(jc jcVar, List list, PendingIntent pendingIntent) {
            this.VE = jcVar;
            this.VC = list;
            this.VD = pendingIntent;
            super();
        }

        protected void m4651a(jg jgVar) throws RemoteException {
            jgVar.addGeofences(this.VC, this.VD, new C07921(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.jc.2 */
    class C14282 extends C1275a {
        final /* synthetic */ PendingIntent VD;
        final /* synthetic */ jc VE;

        /* renamed from: com.google.android.gms.internal.jc.2.1 */
        class C07931 implements OnRemoveGeofencesResultListener {
            final /* synthetic */ C14282 VG;

            C07931(C14282 c14282) {
                this.VG = c14282;
            }

            public void onRemoveGeofencesByPendingIntentResult(int statusCode, PendingIntent pendingIntent) {
                this.VG.m1984b(LocationStatusCodes.cK(statusCode));
            }

            public void onRemoveGeofencesByRequestIdsResult(int statusCode, String[] geofenceRequestIds) {
                Log.wtf("GeofencingImpl", "Request ID callback shouldn't have been called");
            }
        }

        C14282(jc jcVar, PendingIntent pendingIntent) {
            this.VE = jcVar;
            this.VD = pendingIntent;
            super();
        }

        protected void m4653a(jg jgVar) throws RemoteException {
            jgVar.removeGeofences(this.VD, new C07931(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.jc.3 */
    class C14293 extends C1275a {
        final /* synthetic */ jc VE;
        final /* synthetic */ List VH;

        /* renamed from: com.google.android.gms.internal.jc.3.1 */
        class C07941 implements OnRemoveGeofencesResultListener {
            final /* synthetic */ C14293 VI;

            C07941(C14293 c14293) {
                this.VI = c14293;
            }

            public void onRemoveGeofencesByPendingIntentResult(int statusCode, PendingIntent pendingIntent) {
                Log.wtf("GeofencingImpl", "PendingIntent callback shouldn't have been called");
            }

            public void onRemoveGeofencesByRequestIdsResult(int statusCode, String[] geofenceRequestIds) {
                this.VI.m1984b(LocationStatusCodes.cK(statusCode));
            }
        }

        C14293(jc jcVar, List list) {
            this.VE = jcVar;
            this.VH = list;
            super();
        }

        protected void m4655a(jg jgVar) throws RemoteException {
            jgVar.removeGeofences(this.VH, new C07941(this));
        }
    }

    public PendingResult<Status> addGeofences(GoogleApiClient client, List<Geofence> geofences, PendingIntent pendingIntent) {
        List list;
        if (geofences != null) {
            List arrayList = new ArrayList(geofences.size());
            for (Geofence geofence : geofences) {
                hm.m1230b(geofence instanceof jh, (Object) "Geofence must be created using Geofence.Builder.");
                arrayList.add((jh) geofence);
            }
            list = arrayList;
        } else {
            list = null;
        }
        return client.m147b(new C14271(this, list, pendingIntent));
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient client, PendingIntent pendingIntent) {
        return client.m147b(new C14282(this, pendingIntent));
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient client, List<String> geofenceRequestIds) {
        return client.m147b(new C14293(this, geofenceRequestIds));
    }
}
