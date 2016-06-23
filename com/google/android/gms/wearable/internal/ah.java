package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.util.List;

public final class ah implements NodeApi {

    /* renamed from: com.google.android.gms.wearable.internal.ah.a */
    public static class C1175a implements GetConnectedNodesResult {
        private final List<Node> alZ;
        private final Status yz;

        public C1175a(Status status, List<Node> list) {
            this.yz = status;
            this.alZ = list;
        }

        public List<Node> getNodes() {
            return this.alZ;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ah.b */
    public static class C1176b implements GetLocalNodeResult {
        private final Node ama;
        private final Status yz;

        public C1176b(Status status, Node node) {
            this.yz = status;
            this.ama = node;
        }

        public Node getNode() {
            return this.ama;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ah.1 */
    class C12871 extends C1239d<GetLocalNodeResult> {
        final /* synthetic */ ah alX;

        C12871(ah ahVar) {
            this.alX = ahVar;
        }

        protected void m4281a(au auVar) throws RemoteException {
            auVar.m3892p(this);
        }

        protected GetLocalNodeResult av(Status status) {
            return new C1176b(status, null);
        }

        protected /* synthetic */ Result m4282c(Status status) {
            return av(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ah.2 */
    class C12882 extends C1239d<GetConnectedNodesResult> {
        final /* synthetic */ ah alX;

        C12882(ah ahVar) {
            this.alX = ahVar;
        }

        protected void m4284a(au auVar) throws RemoteException {
            auVar.m3893q(this);
        }

        protected GetConnectedNodesResult aw(Status status) {
            return new C1175a(status, null);
        }

        protected /* synthetic */ Result m4285c(Status status) {
            return aw(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ah.3 */
    class C12893 extends C1239d<Status> {
        final /* synthetic */ ah alX;
        final /* synthetic */ NodeListener alY;

        C12893(ah ahVar, NodeListener nodeListener) {
            this.alX = ahVar;
            this.alY = nodeListener;
        }

        protected void m4287a(au auVar) throws RemoteException {
            auVar.m3883a((C0180d) this, this.alY);
        }

        public /* synthetic */ Result m4288c(Status status) {
            return m4289d(status);
        }

        public Status m4289d(Status status) {
            return new Status(13);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ah.4 */
    class C12904 extends C1239d<Status> {
        final /* synthetic */ ah alX;
        final /* synthetic */ NodeListener alY;

        C12904(ah ahVar, NodeListener nodeListener) {
            this.alX = ahVar;
            this.alY = nodeListener;
        }

        protected void m4291a(au auVar) throws RemoteException {
            auVar.m3889b((C0180d) this, this.alY);
        }

        public /* synthetic */ Result m4292c(Status status) {
            return m4293d(status);
        }

        public Status m4293d(Status status) {
            return new Status(13);
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, NodeListener listener) {
        return client.m146a(new C12893(this, listener));
    }

    public PendingResult<GetConnectedNodesResult> getConnectedNodes(GoogleApiClient client) {
        return client.m146a(new C12882(this));
    }

    public PendingResult<GetLocalNodeResult> getLocalNode(GoogleApiClient client) {
        return client.m146a(new C12871(this));
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, NodeListener listener) {
        return client.m146a(new C12904(this, listener));
    }
}
