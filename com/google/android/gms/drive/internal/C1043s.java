package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.ContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.C0648p.C1039a;

/* renamed from: com.google.android.gms.drive.internal.s */
public class C1043s extends C0650v implements DriveFile {

    /* renamed from: com.google.android.gms.drive.internal.s.c */
    private static class C1194c extends C1037c {
        private final DownloadProgressListener Je;
        private final C0180d<ContentsResult> yR;

        public C1194c(C0180d<ContentsResult> c0180d, DownloadProgressListener downloadProgressListener) {
            this.yR = c0180d;
            this.Je = downloadProgressListener;
        }

        public void m3913a(OnContentsResponse onContentsResponse) throws RemoteException {
            this.yR.m154a(new C1039a(Status.En, onContentsResponse.gt()));
        }

        public void m3914a(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
            if (this.Je != null) {
                this.Je.onProgress(onDownloadProgressResponse.gu(), onDownloadProgressResponse.gv());
            }
        }

        public void m3915o(Status status) throws RemoteException {
            this.yR.m154a(new C1039a(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.s.a */
    private abstract class C1252a extends C1193q<Status> {
        final /* synthetic */ C1043s Jc;

        private C1252a(C1043s c1043s) {
            this.Jc = c1043s;
        }

        public /* synthetic */ Result m4135c(Status status) {
            return m4136d(status);
        }

        public Status m4136d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.s.b */
    private abstract class C1253b extends C1193q<Status> {
        final /* synthetic */ C1043s Jc;

        private C1253b(C1043s c1043s) {
            this.Jc = c1043s;
        }

        public /* synthetic */ Result m4137c(Status status) {
            return m4138d(status);
        }

        public Status m4138d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.s.d */
    private abstract class C1254d extends C1193q<ContentsResult> {
        final /* synthetic */ C1043s Jc;

        private C1254d(C1043s c1043s) {
            this.Jc = c1043s;
        }

        public /* synthetic */ Result m4139c(Status status) {
            return m4140q(status);
        }

        public ContentsResult m4140q(Status status) {
            return new C1039a(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.s.1 */
    class C13321 extends C1254d {
        final /* synthetic */ int Ja;
        final /* synthetic */ DownloadProgressListener Jb;
        final /* synthetic */ C1043s Jc;

        C13321(C1043s c1043s, int i, DownloadProgressListener downloadProgressListener) {
            this.Jc = c1043s;
            this.Ja = i;
            this.Jb = downloadProgressListener;
            super(null);
        }

        protected void m4394a(C1042r c1042r) throws RemoteException {
            c1042r.gp().m294a(new OpenContentsRequest(this.Jc.getDriveId(), this.Ja), new C1194c(this, this.Jb));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.s.2 */
    class C13332 extends C1253b {
        final /* synthetic */ Contents IM;
        final /* synthetic */ C1043s Jc;

        C13332(C1043s c1043s, Contents contents) {
            this.Jc = c1043s;
            this.IM = contents;
            super(null);
        }

        protected void m4396a(C1042r c1042r) throws RemoteException {
            this.IM.close();
            c1042r.gp().m283a(new CloseContentsRequest(this.IM, true), new aw(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.s.3 */
    class C13343 extends C1252a {
        final /* synthetic */ Contents IM;
        final /* synthetic */ C1043s Jc;
        final /* synthetic */ MetadataChangeSet Jd;

        C13343(C1043s c1043s, Contents contents, MetadataChangeSet metadataChangeSet) {
            this.Jc = c1043s;
            this.IM = contents;
            this.Jd = metadataChangeSet;
            super(null);
        }

        protected void m4398a(C1042r c1042r) throws RemoteException {
            this.IM.close();
            c1042r.gp().m282a(new CloseContentsAndUpdateMetadataRequest(this.Jc.Hz, this.Jd.gm(), this.IM, false, null), new aw(this));
        }
    }

    public C1043s(DriveId driveId) {
        super(driveId);
    }

    public PendingResult<Status> commitAndCloseContents(GoogleApiClient apiClient, Contents contents) {
        if (contents != null) {
            return apiClient.m147b(new C13332(this, contents));
        }
        throw new IllegalArgumentException("Contents must be provided.");
    }

    public PendingResult<Status> commitAndCloseContents(GoogleApiClient apiClient, Contents contents, MetadataChangeSet changeSet) {
        if (contents != null) {
            return apiClient.m147b(new C13343(this, contents, changeSet));
        }
        throw new IllegalArgumentException("Contents must be provided.");
    }

    public PendingResult<Status> discardContents(GoogleApiClient apiClient, Contents contents) {
        return Drive.DriveApi.discardContents(apiClient, contents);
    }

    public PendingResult<ContentsResult> openContents(GoogleApiClient apiClient, int mode, DownloadProgressListener listener) {
        if (mode == DriveFile.MODE_READ_ONLY || mode == DriveFile.MODE_WRITE_ONLY || mode == DriveFile.MODE_READ_WRITE) {
            return apiClient.m146a(new C13321(this, mode, listener));
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
