package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.internal.C0648p.C1041e;

/* renamed from: com.google.android.gms.drive.internal.v */
public class C0650v implements DriveResource {
    protected final DriveId Hz;

    /* renamed from: com.google.android.gms.drive.internal.v.e */
    private static class C1047e implements MetadataResult {
        private final Metadata Jm;
        private final Status yz;

        public C1047e(Status status, Metadata metadata) {
            this.yz = status;
            this.Jm = metadata;
        }

        public Metadata getMetadata() {
            return this.Jm;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.v.b */
    private static class C1197b extends C1037c {
        private final C0180d<MetadataBufferResult> yR;

        public C1197b(C0180d<MetadataBufferResult> c0180d) {
            this.yR = c0180d;
        }

        public void m3920a(OnListParentsResponse onListParentsResponse) throws RemoteException {
            this.yR.m154a(new C1041e(Status.En, new MetadataBuffer(onListParentsResponse.gA(), null), false));
        }

        public void m3921o(Status status) throws RemoteException {
            this.yR.m154a(new C1041e(status, null, false));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.v.d */
    private static class C1198d extends C1037c {
        private final C0180d<MetadataResult> yR;

        public C1198d(C0180d<MetadataResult> c0180d) {
            this.yR = c0180d;
        }

        public void m3922a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.yR.m154a(new C1047e(Status.En, new C1038l(onMetadataResponse.gB())));
        }

        public void m3923o(Status status) throws RemoteException {
            this.yR.m154a(new C1047e(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.v.a */
    private abstract class C1257a extends C1193q<MetadataResult> {
        final /* synthetic */ C0650v Jl;

        private C1257a(C0650v c0650v) {
            this.Jl = c0650v;
        }

        public /* synthetic */ Result m4147c(Status status) {
            return m4148u(status);
        }

        public MetadataResult m4148u(Status status) {
            return new C1047e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.v.c */
    private abstract class C1258c extends C1193q<MetadataBufferResult> {
        final /* synthetic */ C0650v Jl;

        private C1258c(C0650v c0650v) {
            this.Jl = c0650v;
        }

        public /* synthetic */ Result m4149c(Status status) {
            return m4150r(status);
        }

        public MetadataBufferResult m4150r(Status status) {
            return new C1041e(status, null, false);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.v.f */
    private abstract class C1259f extends C1193q<MetadataResult> {
        final /* synthetic */ C0650v Jl;

        private C1259f(C0650v c0650v) {
            this.Jl = c0650v;
        }

        public /* synthetic */ Result m4151c(Status status) {
            return m4152u(status);
        }

        public MetadataResult m4152u(Status status) {
            return new C1047e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.v.1 */
    class C13361 extends C1257a {
        final /* synthetic */ C0650v Jl;

        C13361(C0650v c0650v) {
            this.Jl = c0650v;
            super(null);
        }

        protected void m4402a(C1042r c1042r) throws RemoteException {
            c1042r.gp().m291a(new GetMetadataRequest(this.Jl.Hz), new C1198d(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.v.2 */
    class C13372 extends C1258c {
        final /* synthetic */ C0650v Jl;

        C13372(C0650v c0650v) {
            this.Jl = c0650v;
            super(null);
        }

        protected void m4404a(C1042r c1042r) throws RemoteException {
            c1042r.gp().m292a(new ListParentsRequest(this.Jl.Hz), new C1197b(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.v.3 */
    class C13383 extends C1259f {
        final /* synthetic */ MetadataChangeSet Jd;
        final /* synthetic */ C0650v Jl;

        C13383(C0650v c0650v, MetadataChangeSet metadataChangeSet) {
            this.Jl = c0650v;
            this.Jd = metadataChangeSet;
            super(null);
        }

        protected void m4406a(C1042r c1042r) throws RemoteException {
            c1042r.gp().m299a(new UpdateMetadataRequest(this.Jl.Hz, this.Jd.gm()), new C1198d(this));
        }
    }

    protected C0650v(DriveId driveId) {
        this.Hz = driveId;
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient apiClient, Listener<ChangeEvent> listener) {
        return ((C1042r) apiClient.m145a(Drive.yH)).m3218a(apiClient, this.Hz, 1, listener);
    }

    public DriveId getDriveId() {
        return this.Hz;
    }

    public PendingResult<MetadataResult> getMetadata(GoogleApiClient apiClient) {
        return apiClient.m146a(new C13361(this));
    }

    public PendingResult<MetadataBufferResult> listParents(GoogleApiClient apiClient) {
        return apiClient.m146a(new C13372(this));
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient apiClient, Listener<ChangeEvent> listener) {
        return ((C1042r) apiClient.m145a(Drive.yH)).m3221b(apiClient, this.Hz, 1, listener);
    }

    public PendingResult<MetadataResult> updateMetadata(GoogleApiClient apiClient, MetadataChangeSet changeSet) {
        if (changeSet != null) {
            return apiClient.m147b(new C13383(this, changeSet));
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
