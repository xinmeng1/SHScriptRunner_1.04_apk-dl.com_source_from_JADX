package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0181a.C0179c;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.ContentsResult;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;

/* renamed from: com.google.android.gms.drive.internal.p */
public class C0648p implements DriveApi {

    /* renamed from: com.google.android.gms.drive.internal.p.a */
    public static class C1039a implements ContentsResult {
        private final Contents HG;
        private final Status yz;

        public C1039a(Status status, Contents contents) {
            this.yz = status;
            this.HG = contents;
        }

        public Contents getContents() {
            return this.HG;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.c */
    static class C1040c implements DriveIdResult {
        private final DriveId Hz;
        private final Status yz;

        public C1040c(Status status, DriveId driveId) {
            this.yz = status;
            this.Hz = driveId;
        }

        public DriveId getDriveId() {
            return this.Hz;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.e */
    static class C1041e implements MetadataBufferResult {
        private final MetadataBuffer IO;
        private final boolean IP;
        private final Status yz;

        public C1041e(Status status, MetadataBuffer metadataBuffer, boolean z) {
            this.yz = status;
            this.IO = metadataBuffer;
            this.IP = z;
        }

        public MetadataBuffer getMetadataBuffer() {
            return this.IO;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.b */
    private static class C1190b extends C1037c {
        private final C0180d<DriveIdResult> yR;

        public C1190b(C0180d<DriveIdResult> c0180d) {
            this.yR = c0180d;
        }

        public void m3906a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.yR.m154a(new C1040c(Status.En, onDriveIdResponse.getDriveId()));
        }

        public void m3907a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.yR.m154a(new C1040c(Status.En, new C1038l(onMetadataResponse.gB()).getDriveId()));
        }

        public void m3908o(Status status) throws RemoteException {
            this.yR.m154a(new C1040c(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.f */
    private static class C1191f extends C1037c {
        private final C0180d<ContentsResult> yR;

        public C1191f(C0180d<ContentsResult> c0180d) {
            this.yR = c0180d;
        }

        public void m3909a(OnContentsResponse onContentsResponse) throws RemoteException {
            this.yR.m154a(new C1039a(Status.En, onContentsResponse.gt()));
        }

        public void m3910o(Status status) throws RemoteException {
            this.yR.m154a(new C1039a(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.h */
    static class C1192h extends C1037c {
        private final C0180d<MetadataBufferResult> yR;

        public C1192h(C0180d<MetadataBufferResult> c0180d) {
            this.yR = c0180d;
        }

        public void m3911a(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
            this.yR.m154a(new C1041e(Status.En, new MetadataBuffer(onListEntriesResponse.gy(), null), onListEntriesResponse.gz()));
        }

        public void m3912o(Status status) throws RemoteException {
            this.yR.m154a(new C1041e(status, null, false));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.d */
    abstract class C1247d extends C1193q<DriveIdResult> {
        final /* synthetic */ C0648p IL;

        C1247d(C0648p c0648p) {
            this.IL = c0648p;
        }

        public /* synthetic */ Result m4125c(Status status) {
            return m4126p(status);
        }

        public DriveIdResult m4126p(Status status) {
            return new C1040c(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.g */
    abstract class C1248g extends C1193q<ContentsResult> {
        final /* synthetic */ C0648p IL;

        C1248g(C0648p c0648p) {
            this.IL = c0648p;
        }

        public /* synthetic */ Result m4127c(Status status) {
            return m4128q(status);
        }

        public ContentsResult m4128q(Status status) {
            return new C1039a(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.i */
    abstract class C1249i extends C1193q<MetadataBufferResult> {
        final /* synthetic */ C0648p IL;

        C1249i(C0648p c0648p) {
            this.IL = c0648p;
        }

        public /* synthetic */ Result m4129c(Status status) {
            return m4130r(status);
        }

        public MetadataBufferResult m4130r(Status status) {
            return new C1041e(status, null, false);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.j */
    static abstract class C1250j extends C1193q<Status> {
        C1250j() {
        }

        public /* synthetic */ Result m4131c(Status status) {
            return m4132d(status);
        }

        public Status m4132d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.l */
    abstract class C1251l extends C1193q<Status> {
        final /* synthetic */ C0648p IL;

        C1251l(C0648p c0648p) {
            this.IL = c0648p;
        }

        public /* synthetic */ Result m4133c(Status status) {
            return m4134d(status);
        }

        public Status m4134d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.1 */
    class C13241 extends C1249i {
        final /* synthetic */ Query IK;
        final /* synthetic */ C0648p IL;

        C13241(C0648p c0648p, Query query) {
            this.IL = c0648p;
            this.IK = query;
            super(c0648p);
        }

        protected void m4378a(C1042r c1042r) throws RemoteException {
            c1042r.gp().m295a(new QueryRequest(this.IK), new C1192h(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.2 */
    class C13252 extends C1248g {
        final /* synthetic */ C0648p IL;

        C13252(C0648p c0648p) {
            this.IL = c0648p;
            super(c0648p);
        }

        protected void m4380a(C1042r c1042r) throws RemoteException {
            c1042r.gp().m284a(new CreateContentsRequest(), new C1191f(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.3 */
    class C13263 extends C1250j {
        final /* synthetic */ C0648p IL;
        final /* synthetic */ Contents IM;

        C13263(C0648p c0648p, Contents contents) {
            this.IL = c0648p;
            this.IM = contents;
        }

        protected void m4382a(C1042r c1042r) throws RemoteException {
            c1042r.gp().m283a(new CloseContentsRequest(this.IM, false), new aw(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.4 */
    class C13274 extends C1247d {
        final /* synthetic */ C0648p IL;
        final /* synthetic */ String IN;

        C13274(C0648p c0648p, String str) {
            this.IL = c0648p;
            this.IN = str;
            super(c0648p);
        }

        protected void m4384a(C1042r c1042r) throws RemoteException {
            c1042r.gp().m291a(new GetMetadataRequest(DriveId.aL(this.IN)), new C1190b(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.5 */
    class C13285 extends C1251l {
        final /* synthetic */ C0648p IL;

        C13285(C0648p c0648p) {
            this.IL = c0648p;
            super(c0648p);
        }

        protected void m4386a(C1042r c1042r) throws RemoteException {
            c1042r.gp().m300a(new aw(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.k */
    static class C1329k extends C1250j {
        C1329k(GoogleApiClient googleApiClient, Status status) {
            m1981a(new C0179c(((C1042r) googleApiClient.m145a(Drive.yH)).getLooper()));
            m1984b(status);
        }

        protected void m4388a(C1042r c1042r) {
        }
    }

    public PendingResult<Status> discardContents(GoogleApiClient apiClient, Contents contents) {
        return apiClient.m147b(new C13263(this, contents));
    }

    public PendingResult<DriveIdResult> fetchDriveId(GoogleApiClient apiClient, String resourceId) {
        return apiClient.m146a(new C13274(this, resourceId));
    }

    public DriveFolder getAppFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            DriveId gr = ((C1042r) apiClient.m145a(Drive.yH)).gr();
            return gr != null ? new C1046u(gr) : null;
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFile getFile(GoogleApiClient apiClient, DriveId id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new C1043s(id);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getFolder(GoogleApiClient apiClient, DriveId id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new C1046u(id);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            return new C1046u(((C1042r) apiClient.m145a(Drive.yH)).gq());
        }
        throw new IllegalStateException("Client must be connected");
    }

    public PendingResult<ContentsResult> newContents(GoogleApiClient apiClient) {
        return apiClient.m146a(new C13252(this));
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    public PendingResult<MetadataBufferResult> query(GoogleApiClient apiClient, Query query) {
        if (query != null) {
            return apiClient.m146a(new C13241(this, query));
        }
        throw new IllegalArgumentException("Query must be provided.");
    }

    public PendingResult<Status> requestSync(GoogleApiClient client) {
        return client.m147b(new C13285(this));
    }
}
