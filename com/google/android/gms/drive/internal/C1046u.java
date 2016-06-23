package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.Query.Builder;
import com.google.android.gms.drive.query.SearchableField;

/* renamed from: com.google.android.gms.drive.internal.u */
public class C1046u extends C0650v implements DriveFolder {

    /* renamed from: com.google.android.gms.drive.internal.u.d */
    private static class C1044d implements DriveFileResult {
        private final DriveFile Jj;
        private final Status yz;

        public C1044d(Status status, DriveFile driveFile) {
            this.yz = status;
            this.Jj = driveFile;
        }

        public DriveFile getDriveFile() {
            return this.Jj;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.u.e */
    private static class C1045e implements DriveFolderResult {
        private final DriveFolder Jk;
        private final Status yz;

        public C1045e(Status status, DriveFolder driveFolder) {
            this.yz = status;
            this.Jk = driveFolder;
        }

        public DriveFolder getDriveFolder() {
            return this.Jk;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.u.a */
    private static class C1195a extends C1037c {
        private final C0180d<DriveFileResult> yR;

        public C1195a(C0180d<DriveFileResult> c0180d) {
            this.yR = c0180d;
        }

        public void m3916a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.yR.m154a(new C1044d(Status.En, new C1043s(onDriveIdResponse.getDriveId())));
        }

        public void m3917o(Status status) throws RemoteException {
            this.yR.m154a(new C1044d(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.u.b */
    private static class C1196b extends C1037c {
        private final C0180d<DriveFolderResult> yR;

        public C1196b(C0180d<DriveFolderResult> c0180d) {
            this.yR = c0180d;
        }

        public void m3918a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.yR.m154a(new C1045e(Status.En, new C1046u(onDriveIdResponse.getDriveId())));
        }

        public void m3919o(Status status) throws RemoteException {
            this.yR.m154a(new C1045e(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.u.1 */
    class C12551 extends C1193q<DriveFileResult> {
        final /* synthetic */ Contents IM;
        final /* synthetic */ MetadataChangeSet Jd;
        final /* synthetic */ int Jf;
        final /* synthetic */ boolean Jg;
        final /* synthetic */ String Jh;
        final /* synthetic */ C1046u Ji;

        C12551(C1046u c1046u, Contents contents, MetadataChangeSet metadataChangeSet, int i, boolean z, String str) {
            this.Ji = c1046u;
            this.IM = contents;
            this.Jd = metadataChangeSet;
            this.Jf = i;
            this.Jg = z;
            this.Jh = str;
        }

        protected void m4142a(C1042r c1042r) throws RemoteException {
            if (this.IM != null) {
                this.IM.close();
            }
            c1042r.gp().m285a(new CreateFileRequest(this.Ji.getDriveId(), this.Jd.gm(), this.IM, this.Jf, this.Jg, this.Jh), new C1195a(this));
        }

        public /* synthetic */ Result m4143c(Status status) {
            return m4144s(status);
        }

        public DriveFileResult m4144s(Status status) {
            return new C1044d(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.u.c */
    private abstract class C1256c extends C1193q<DriveFolderResult> {
        final /* synthetic */ C1046u Ji;

        private C1256c(C1046u c1046u) {
            this.Ji = c1046u;
        }

        public /* synthetic */ Result m4145c(Status status) {
            return m4146t(status);
        }

        public DriveFolderResult m4146t(Status status) {
            return new C1045e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.u.2 */
    class C13352 extends C1256c {
        final /* synthetic */ MetadataChangeSet Jd;
        final /* synthetic */ C1046u Ji;

        C13352(C1046u c1046u, MetadataChangeSet metadataChangeSet) {
            this.Ji = c1046u;
            this.Jd = metadataChangeSet;
            super(null);
        }

        protected void m4400a(C1042r c1042r) throws RemoteException {
            c1042r.gp().m286a(new CreateFolderRequest(this.Ji.getDriveId(), this.Jd.gm()), new C1196b(this));
        }
    }

    public C1046u(DriveId driveId) {
        super(driveId);
    }

    private PendingResult<DriveFileResult> m3223a(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, Contents contents, int i, boolean z, String str) {
        return googleApiClient.m147b(new C12551(this, contents, metadataChangeSet, i, z, str));
    }

    private PendingResult<DriveFileResult> m3224a(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, Contents contents, boolean z, String str) {
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (contents == null) {
            throw new IllegalArgumentException("Contents must be provided.");
        } else if (!DriveFolder.MIME_TYPE.equals(metadataChangeSet.getMimeType())) {
            return m3223a(googleApiClient, metadataChangeSet, contents, 0, z, str);
        } else {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        }
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, Contents contents) {
        return m3224a(apiClient, changeSet, contents, false, null);
    }

    public PendingResult<DriveFolderResult> createFolder(GoogleApiClient apiClient, MetadataChangeSet changeSet) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (changeSet.getMimeType() == null || changeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return apiClient.m147b(new C13352(this, changeSet));
        } else {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
    }

    public PendingResult<MetadataBufferResult> listChildren(GoogleApiClient apiClient) {
        return queryChildren(apiClient, null);
    }

    public PendingResult<MetadataBufferResult> queryChildren(GoogleApiClient apiClient, Query query) {
        Builder addFilter = new Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
            addFilter.setSortOrder(query.getSortOrder());
        }
        return new C0648p().query(apiClient, addFilter.build());
    }
}
