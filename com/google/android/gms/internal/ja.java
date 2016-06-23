package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition.C1220a;
import com.google.android.gms.location.ActivityRecognitionApi;

public class ja implements ActivityRecognitionApi {

    /* renamed from: com.google.android.gms.internal.ja.a */
    private static abstract class C1273a extends C1220a<Status> {
        private C1273a() {
        }

        public /* synthetic */ Result m4250c(Status status) {
            return m4251d(status);
        }

        public Status m4251d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.ja.1 */
    class C14181 extends C1273a {
        final /* synthetic */ long Vt;
        final /* synthetic */ PendingIntent Vu;
        final /* synthetic */ ja Vv;

        C14181(ja jaVar, long j, PendingIntent pendingIntent) {
            this.Vv = jaVar;
            this.Vt = j;
            this.Vu = pendingIntent;
            super();
        }

        protected void m4633a(jg jgVar) throws RemoteException {
            jgVar.requestActivityUpdates(this.Vt, this.Vu);
            m1984b(Status.En);
        }
    }

    /* renamed from: com.google.android.gms.internal.ja.2 */
    class C14192 extends C1273a {
        final /* synthetic */ PendingIntent Vu;
        final /* synthetic */ ja Vv;

        C14192(ja jaVar, PendingIntent pendingIntent) {
            this.Vv = jaVar;
            this.Vu = pendingIntent;
            super();
        }

        protected void m4635a(jg jgVar) throws RemoteException {
            jgVar.removeActivityUpdates(this.Vu);
            m1984b(Status.En);
        }
    }

    public PendingResult<Status> removeActivityUpdates(GoogleApiClient client, PendingIntent callbackIntent) {
        return client.m147b(new C14192(this, callbackIntent));
    }

    public PendingResult<Status> requestActivityUpdates(GoogleApiClient client, long detectionIntervalMillis, PendingIntent callbackIntent) {
        return client.m147b(new C14181(this, detectionIntervalMillis, callbackIntent));
    }
}
