package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class ae implements MessageApi {

    /* renamed from: com.google.android.gms.wearable.internal.ae.a */
    public static class C1174a implements SendMessageResult {
        private final int ra;
        private final Status yz;

        public C1174a(Status status, int i) {
            this.yz = status;
            this.ra = i;
        }

        public int getRequestId() {
            return this.ra;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ae.1 */
    class C12841 extends C1239d<SendMessageResult> {
        final /* synthetic */ String alR;
        final /* synthetic */ String alS;
        final /* synthetic */ ae alT;
        final /* synthetic */ byte[] yL;

        C12841(ae aeVar, String str, String str2, byte[] bArr) {
            this.alT = aeVar;
            this.alR = str;
            this.alS = str2;
            this.yL = bArr;
        }

        protected void m4270a(au auVar) throws RemoteException {
            auVar.m3886a(this, this.alR, this.alS, this.yL);
        }

        protected SendMessageResult au(Status status) {
            return new C1174a(status, -1);
        }

        protected /* synthetic */ Result m4271c(Status status) {
            return au(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ae.2 */
    class C12852 extends C1239d<Status> {
        final /* synthetic */ IntentFilter[] alG;
        final /* synthetic */ ae alT;
        final /* synthetic */ MessageListener alU;

        C12852(ae aeVar, MessageListener messageListener, IntentFilter[] intentFilterArr) {
            this.alT = aeVar;
            this.alU = messageListener;
            this.alG = intentFilterArr;
        }

        protected void m4273a(au auVar) throws RemoteException {
            auVar.m3882a((C0180d) this, this.alU, this.alG);
        }

        public /* synthetic */ Result m4274c(Status status) {
            return m4275d(status);
        }

        public Status m4275d(Status status) {
            return new Status(13);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ae.3 */
    class C12863 extends C1239d<Status> {
        final /* synthetic */ ae alT;
        final /* synthetic */ MessageListener alU;

        C12863(ae aeVar, MessageListener messageListener) {
            this.alT = aeVar;
            this.alU = messageListener;
        }

        protected void m4277a(au auVar) throws RemoteException {
            auVar.m3881a((C0180d) this, this.alU);
        }

        public /* synthetic */ Result m4278c(Status status) {
            return m4279d(status);
        }

        public Status m4279d(Status status) {
            return new Status(13);
        }
    }

    private PendingResult<Status> m3161a(GoogleApiClient googleApiClient, MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.m146a(new C12852(this, messageListener, intentFilterArr));
    }

    public PendingResult<Status> addListener(GoogleApiClient client, MessageListener listener) {
        return m3161a(client, listener, null);
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, MessageListener listener) {
        return client.m146a(new C12863(this, listener));
    }

    public PendingResult<SendMessageResult> sendMessage(GoogleApiClient client, String nodeId, String action, byte[] data) {
        return client.m146a(new C12841(this, nodeId, action, data));
    }
}
