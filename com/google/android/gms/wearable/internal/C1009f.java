package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.RemoteException;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.gms.wearable.internal.f */
public final class C1009f implements DataApi {

    /* renamed from: com.google.android.gms.wearable.internal.f.a */
    public static class C1177a implements DataItemResult {
        private final DataItem alH;
        private final Status yz;

        public C1177a(Status status, DataItem dataItem) {
            this.yz = status;
            this.alH = dataItem;
        }

        public DataItem getDataItem() {
            return this.alH;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.b */
    public static class C1178b implements DeleteDataItemsResult {
        private final int alI;
        private final Status yz;

        public C1178b(Status status, int i) {
            this.yz = status;
            this.alI = i;
        }

        public int getNumDeleted() {
            return this.alI;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.c */
    public static class C1179c implements GetFdForAssetResult {
        private final ParcelFileDescriptor alJ;
        private final Status yz;

        public C1179c(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            this.yz = status;
            this.alJ = parcelFileDescriptor;
        }

        public ParcelFileDescriptor getFd() {
            return this.alJ;
        }

        public InputStream getInputStream() {
            return new AutoCloseInputStream(this.alJ);
        }

        public Status getStatus() {
            return this.yz;
        }

        public void release() {
            try {
                this.alJ.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.1 */
    class C12911 extends C1239d<DataItemResult> {
        final /* synthetic */ PutDataRequest alB;
        final /* synthetic */ C1009f alC;

        C12911(C1009f c1009f, PutDataRequest putDataRequest) {
            this.alC = c1009f;
            this.alB = putDataRequest;
        }

        protected void m4295a(au auVar) throws RemoteException {
            auVar.m3884a((C0180d) this, this.alB);
        }

        public DataItemResult aq(Status status) {
            return new C1177a(status, null);
        }

        public /* synthetic */ Result m4296c(Status status) {
            return aq(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.2 */
    class C12922 extends C1239d<DataItemResult> {
        final /* synthetic */ Uri abk;
        final /* synthetic */ C1009f alC;

        C12922(C1009f c1009f, Uri uri) {
            this.alC = c1009f;
            this.abk = uri;
        }

        protected void m4298a(au auVar) throws RemoteException {
            auVar.m3876a((C0180d) this, this.abk);
        }

        protected DataItemResult aq(Status status) {
            return new C1177a(status, null);
        }

        protected /* synthetic */ Result m4299c(Status status) {
            return aq(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.3 */
    class C12933 extends C1239d<DataItemBuffer> {
        final /* synthetic */ C1009f alC;

        C12933(C1009f c1009f) {
            this.alC = c1009f;
        }

        protected void m4301a(au auVar) throws RemoteException {
            auVar.m3891o(this);
        }

        protected DataItemBuffer ar(Status status) {
            return new DataItemBuffer(DataHolder.af(status.getStatusCode()));
        }

        protected /* synthetic */ Result m4302c(Status status) {
            return ar(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.4 */
    class C12944 extends C1239d<DataItemBuffer> {
        final /* synthetic */ Uri abk;
        final /* synthetic */ C1009f alC;

        C12944(C1009f c1009f, Uri uri) {
            this.alC = c1009f;
            this.abk = uri;
        }

        protected void m4304a(au auVar) throws RemoteException {
            auVar.m3888b((C0180d) this, this.abk);
        }

        protected DataItemBuffer ar(Status status) {
            return new DataItemBuffer(DataHolder.af(status.getStatusCode()));
        }

        protected /* synthetic */ Result m4305c(Status status) {
            return ar(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.5 */
    class C12955 extends C1239d<DeleteDataItemsResult> {
        final /* synthetic */ Uri abk;
        final /* synthetic */ C1009f alC;

        C12955(C1009f c1009f, Uri uri) {
            this.alC = c1009f;
            this.abk = uri;
        }

        protected void m4307a(au auVar) throws RemoteException {
            auVar.m3890c(this, this.abk);
        }

        protected DeleteDataItemsResult as(Status status) {
            return new C1178b(status, 0);
        }

        protected /* synthetic */ Result m4308c(Status status) {
            return as(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.6 */
    class C12966 extends C1239d<GetFdForAssetResult> {
        final /* synthetic */ C1009f alC;
        final /* synthetic */ Asset alD;

        C12966(C1009f c1009f, Asset asset) {
            this.alC = c1009f;
            this.alD = asset;
        }

        protected void m4310a(au auVar) throws RemoteException {
            auVar.m3877a((C0180d) this, this.alD);
        }

        protected GetFdForAssetResult at(Status status) {
            return new C1179c(status, null);
        }

        protected /* synthetic */ Result m4311c(Status status) {
            return at(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.7 */
    class C12977 extends C1239d<GetFdForAssetResult> {
        final /* synthetic */ C1009f alC;
        final /* synthetic */ DataItemAsset alE;

        C12977(C1009f c1009f, DataItemAsset dataItemAsset) {
            this.alC = c1009f;
            this.alE = dataItemAsset;
        }

        protected void m4313a(au auVar) throws RemoteException {
            auVar.m3880a((C0180d) this, this.alE);
        }

        protected GetFdForAssetResult at(Status status) {
            return new C1179c(status, null);
        }

        protected /* synthetic */ Result m4314c(Status status) {
            return at(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.8 */
    class C12988 extends C1239d<Status> {
        final /* synthetic */ C1009f alC;
        final /* synthetic */ DataListener alF;
        final /* synthetic */ IntentFilter[] alG;

        C12988(C1009f c1009f, DataListener dataListener, IntentFilter[] intentFilterArr) {
            this.alC = c1009f;
            this.alF = dataListener;
            this.alG = intentFilterArr;
        }

        protected void m4316a(au auVar) throws RemoteException {
            auVar.m3879a((C0180d) this, this.alF, this.alG);
        }

        public /* synthetic */ Result m4317c(Status status) {
            return m4318d(status);
        }

        public Status m4318d(Status status) {
            return new Status(13);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.9 */
    class C12999 extends C1239d<Status> {
        final /* synthetic */ C1009f alC;
        final /* synthetic */ DataListener alF;

        C12999(C1009f c1009f, DataListener dataListener) {
            this.alC = c1009f;
            this.alF = dataListener;
        }

        protected void m4320a(au auVar) throws RemoteException {
            auVar.m3878a((C0180d) this, this.alF);
        }

        public /* synthetic */ Result m4321c(Status status) {
            return m4322d(status);
        }

        public Status m4322d(Status status) {
            return new Status(13);
        }
    }

    private PendingResult<Status> m3162a(GoogleApiClient googleApiClient, DataListener dataListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.m146a(new C12988(this, dataListener, intentFilterArr));
    }

    private void m3163a(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        } else if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if (asset.getData() != null) {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, DataListener listener) {
        return m3162a(client, listener, null);
    }

    public PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, Uri uri) {
        return client.m146a(new C12955(this, uri));
    }

    public PendingResult<DataItemResult> getDataItem(GoogleApiClient client, Uri uri) {
        return client.m146a(new C12922(this, uri));
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client) {
        return client.m146a(new C12933(this));
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, Uri uri) {
        return client.m146a(new C12944(this, uri));
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, Asset asset) {
        m3163a(asset);
        return client.m146a(new C12966(this, asset));
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, DataItemAsset asset) {
        return client.m146a(new C12977(this, asset));
    }

    public PendingResult<DataItemResult> putDataItem(GoogleApiClient client, PutDataRequest request) {
        return client.m146a(new C12911(this, request));
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, DataListener listener) {
        return client.m146a(new C12999(this, listener));
    }
}
