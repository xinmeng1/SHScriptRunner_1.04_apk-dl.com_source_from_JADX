package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.C1119e;
import com.google.android.gms.internal.hi;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.google.android.gms.wearable.internal.C1009f.C1177a;
import com.google.android.gms.wearable.internal.C1009f.C1178b;
import com.google.android.gms.wearable.internal.C1009f.C1179c;
import com.google.android.gms.wearable.internal.ad.C1006a;
import com.google.android.gms.wearable.internal.ae.C1174a;
import com.google.android.gms.wearable.internal.ah.C1175a;
import com.google.android.gms.wearable.internal.ah.C1176b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class au extends hb<ad> {
    private final ExecutorService agU;
    private final HashMap<DataListener, av> ame;
    private final HashMap<MessageListener, av> amf;
    private final HashMap<NodeListener, av> amg;

    /* renamed from: com.google.android.gms.wearable.internal.au.11 */
    class AnonymousClass11 implements Callable<Boolean> {
        final /* synthetic */ au amh;
        final /* synthetic */ ParcelFileDescriptor amj;
        final /* synthetic */ byte[] yL;

        AnonymousClass11(au auVar, ParcelFileDescriptor parcelFileDescriptor, byte[] bArr) {
            this.amh = auVar;
            this.amj = parcelFileDescriptor;
            this.yL = bArr;
        }

        public /* synthetic */ Object call() throws Exception {
            return nt();
        }

        public java.lang.Boolean nt() {
            /* JADX: method processing error */
/*
            Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x00bf in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:58)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
            /*
            r5 = this;
            r1 = 3;
            r0 = "WearableClient";
            r0 = android.util.Log.isLoggable(r0, r1);
            if (r0 == 0) goto L_0x0023;
        L_0x0009:
            r0 = "WearableClient";
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "processAssets: writing data to FD : ";
            r1 = r1.append(r2);
            r2 = r5.amj;
            r1 = r1.append(r2);
            r1 = r1.toString();
            android.util.Log.d(r0, r1);
        L_0x0023:
            r1 = new android.os.ParcelFileDescriptor$AutoCloseOutputStream;
            r0 = r5.amj;
            r1.<init>(r0);
            r0 = r5.yL;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r1.write(r0);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r1.flush();	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r0 = "WearableClient";	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r2 = 3;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r0 = android.util.Log.isLoggable(r0, r2);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            if (r0 == 0) goto L_0x0055;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
        L_0x003b:
            r0 = "WearableClient";	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r2.<init>();	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r3 = "processAssets: wrote data: ";	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r2 = r2.append(r3);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r3 = r5.amj;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r2 = r2.append(r3);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r2 = r2.toString();	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            android.util.Log.d(r0, r2);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
        L_0x0055:
            r0 = 1;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r2 = "WearableClient";	 Catch:{ IOException -> 0x00f4 }
            r3 = 3;	 Catch:{ IOException -> 0x00f4 }
            r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x00f4 }
            if (r2 == 0) goto L_0x007d;	 Catch:{ IOException -> 0x00f4 }
        L_0x0063:
            r2 = "WearableClient";	 Catch:{ IOException -> 0x00f4 }
            r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00f4 }
            r3.<init>();	 Catch:{ IOException -> 0x00f4 }
            r4 = "processAssets: closing: ";	 Catch:{ IOException -> 0x00f4 }
            r3 = r3.append(r4);	 Catch:{ IOException -> 0x00f4 }
            r4 = r5.amj;	 Catch:{ IOException -> 0x00f4 }
            r3 = r3.append(r4);	 Catch:{ IOException -> 0x00f4 }
            r3 = r3.toString();	 Catch:{ IOException -> 0x00f4 }
            android.util.Log.d(r2, r3);	 Catch:{ IOException -> 0x00f4 }
        L_0x007d:
            r1.close();	 Catch:{ IOException -> 0x00f4 }
        L_0x0080:
            return r0;
        L_0x0081:
            r0 = move-exception;
            r0 = "WearableClient";	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r2.<init>();	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r3 = "processAssets: writing data failed: ";	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r2 = r2.append(r3);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r3 = r5.amj;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r2 = r2.append(r3);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r2 = r2.toString();	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            android.util.Log.w(r0, r2);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            r0 = "WearableClient";
            r2 = 3;
            r0 = android.util.Log.isLoggable(r0, r2);
            if (r0 == 0) goto L_0x00bf;
        L_0x00a5:
            r0 = "WearableClient";
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "processAssets: closing: ";
            r2 = r2.append(r3);
            r3 = r5.amj;
            r2 = r2.append(r3);
            r2 = r2.toString();
            android.util.Log.d(r0, r2);
        L_0x00bf:
            r1.close();
        L_0x00c2:
            r0 = 0;
            r0 = java.lang.Boolean.valueOf(r0);
            goto L_0x0080;
        L_0x00c8:
            r0 = move-exception;
            r2 = "WearableClient";	 Catch:{ IOException -> 0x00f0 }
            r3 = 3;	 Catch:{ IOException -> 0x00f0 }
            r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x00f0 }
            if (r2 == 0) goto L_0x00ec;	 Catch:{ IOException -> 0x00f0 }
        L_0x00d2:
            r2 = "WearableClient";	 Catch:{ IOException -> 0x00f0 }
            r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00f0 }
            r3.<init>();	 Catch:{ IOException -> 0x00f0 }
            r4 = "processAssets: closing: ";	 Catch:{ IOException -> 0x00f0 }
            r3 = r3.append(r4);	 Catch:{ IOException -> 0x00f0 }
            r4 = r5.amj;	 Catch:{ IOException -> 0x00f0 }
            r3 = r3.append(r4);	 Catch:{ IOException -> 0x00f0 }
            r3 = r3.toString();	 Catch:{ IOException -> 0x00f0 }
            android.util.Log.d(r2, r3);	 Catch:{ IOException -> 0x00f0 }
        L_0x00ec:
            r1.close();	 Catch:{ IOException -> 0x00f0 }
        L_0x00ef:
            throw r0;
        L_0x00f0:
            r1 = move-exception;
            goto L_0x00ef;
        L_0x00f2:
            r0 = move-exception;
            goto L_0x00c2;
        L_0x00f4:
            r1 = move-exception;
            goto L_0x0080;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.au.11.nt():java.lang.Boolean");
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.au.10 */
    class AnonymousClass10 extends C1173a {
        final /* synthetic */ au amh;
        final /* synthetic */ C0180d ami;

        AnonymousClass10(au auVar, C0180d c0180d) {
            this.amh = auVar;
            this.ami = c0180d;
        }

        public void m4099a(Status status) {
            this.ami.m154a(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.au.12 */
    class AnonymousClass12 extends C1173a {
        final /* synthetic */ au amh;
        final /* synthetic */ C0180d ami;

        AnonymousClass12(au auVar, C0180d c0180d) {
            this.amh = auVar;
            this.ami = c0180d;
        }

        public void m4100a(C1013v c1013v) {
            this.ami.m154a(new C1177a(new Status(c1013v.statusCode), c1013v.alO));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.au.13 */
    class AnonymousClass13 extends C1173a {
        final /* synthetic */ au amh;
        final /* synthetic */ C0180d ami;

        AnonymousClass13(au auVar, C0180d c0180d) {
            this.amh = auVar;
            this.ami = c0180d;
        }

        public void m4101Z(DataHolder dataHolder) {
            this.ami.m154a(new DataItemBuffer(dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.au.14 */
    class AnonymousClass14 extends C1173a {
        final /* synthetic */ au amh;
        final /* synthetic */ C0180d ami;

        AnonymousClass14(au auVar, C0180d c0180d) {
            this.amh = auVar;
            this.ami = c0180d;
        }

        public void m4102Z(DataHolder dataHolder) {
            this.ami.m154a(new DataItemBuffer(dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.au.1 */
    class C12291 extends C1173a {
        final /* synthetic */ au amh;

        C12291(au auVar) {
            this.amh = auVar;
        }

        public void m4103a(Status status) {
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.au.2 */
    class C12302 extends C1173a {
        final /* synthetic */ au amh;
        final /* synthetic */ C0180d ami;

        C12302(au auVar, C0180d c0180d) {
            this.amh = auVar;
            this.ami = c0180d;
        }

        public void m4104a(C1010p c1010p) {
            this.ami.m154a(new C1178b(new Status(c1010p.statusCode), c1010p.alL));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.au.3 */
    class C12313 extends C1173a {
        final /* synthetic */ au amh;
        final /* synthetic */ C0180d ami;

        C12313(au auVar, C0180d c0180d) {
            this.amh = auVar;
            this.ami = c0180d;
        }

        public void m4105a(aq aqVar) {
            this.ami.m154a(new C1174a(new Status(aqVar.statusCode), aqVar.amc));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.au.4 */
    class C12324 extends C1173a {
        final /* synthetic */ au amh;
        final /* synthetic */ C0180d ami;

        C12324(au auVar, C0180d c0180d) {
            this.amh = auVar;
            this.ami = c0180d;
        }

        public void m4106a(C1014x c1014x) {
            this.ami.m154a(new C1179c(new Status(c1014x.statusCode), c1014x.alP));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.au.5 */
    class C12335 extends C1173a {
        final /* synthetic */ au amh;
        final /* synthetic */ C0180d ami;

        C12335(au auVar, C0180d c0180d) {
            this.amh = auVar;
            this.ami = c0180d;
        }

        public void m4107a(C1015z c1015z) {
            this.ami.m154a(new C1176b(new Status(c1015z.statusCode), c1015z.alQ));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.au.6 */
    class C12346 extends C1173a {
        final /* synthetic */ au amh;
        final /* synthetic */ C0180d ami;

        C12346(au auVar, C0180d c0180d) {
            this.amh = auVar;
            this.ami = c0180d;
        }

        public void m4108a(C1012t c1012t) {
            List arrayList = new ArrayList();
            arrayList.addAll(c1012t.alN);
            this.ami.m154a(new C1175a(new Status(c1012t.statusCode), arrayList));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.au.7 */
    class C12357 extends C1173a {
        final /* synthetic */ DataListener alF;
        final /* synthetic */ au amh;
        final /* synthetic */ C0180d ami;

        C12357(au auVar, DataListener dataListener, C0180d c0180d) {
            this.amh = auVar;
            this.alF = dataListener;
            this.ami = c0180d;
        }

        public void m4109a(Status status) {
            if (!status.isSuccess()) {
                synchronized (this.amh.ame) {
                    this.amh.ame.remove(this.alF);
                }
            }
            this.ami.m154a(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.au.8 */
    class C12368 extends C1173a {
        final /* synthetic */ MessageListener alU;
        final /* synthetic */ au amh;
        final /* synthetic */ C0180d ami;

        C12368(au auVar, MessageListener messageListener, C0180d c0180d) {
            this.amh = auVar;
            this.alU = messageListener;
            this.ami = c0180d;
        }

        public void m4110a(Status status) {
            if (!status.isSuccess()) {
                synchronized (this.amh.amf) {
                    this.amh.amf.remove(this.alU);
                }
            }
            this.ami.m154a(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.au.9 */
    class C12379 extends C1173a {
        final /* synthetic */ NodeListener alY;
        final /* synthetic */ au amh;
        final /* synthetic */ C0180d ami;

        C12379(au auVar, NodeListener nodeListener, C0180d c0180d) {
            this.amh = auVar;
            this.alY = nodeListener;
            this.ami = c0180d;
        }

        public void m4111a(Status status) {
            if (!status.isSuccess()) {
                synchronized (this.amh.amg) {
                    this.amh.amg.remove(this.alY);
                }
            }
            this.ami.m154a(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.au.a */
    private static class C1238a extends C1173a {
        private final List<FutureTask<Boolean>> amk;
        private final C0180d<DataItemResult> yR;

        C1238a(C0180d<DataItemResult> c0180d, List<FutureTask<Boolean>> list) {
            this.yR = c0180d;
            this.amk = list;
        }

        public void m4112a(am amVar) {
            this.yR.m154a(new C1177a(new Status(amVar.statusCode), amVar.alO));
            if (amVar.statusCode != 0) {
                for (FutureTask cancel : this.amk) {
                    cancel.cancel(true);
                }
            }
        }
    }

    public au(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.agU = Executors.newCachedThreadPool();
        this.ame = new HashMap();
        this.amf = new HashMap();
        this.amg = new HashMap();
    }

    private FutureTask<Boolean> m3871a(ParcelFileDescriptor parcelFileDescriptor, byte[] bArr) {
        return new FutureTask(new AnonymousClass11(this, parcelFileDescriptor, bArr));
    }

    protected void m3875a(int i, IBinder iBinder, Bundle bundle) {
        if (Log.isLoggable("WearableClient", 2)) {
            Log.d("WearableClient", "onPostInitHandler: statusCode " + i);
        }
        if (i == 0) {
            try {
                ab c12291 = new C12291(this);
                if (Log.isLoggable("WearableClient", 2)) {
                    Log.d("WearableClient", "onPostInitHandler: service " + iBinder);
                }
                ad by = C1006a.by(iBinder);
                for (Entry entry : this.ame.entrySet()) {
                    if (Log.isLoggable("WearableClient", 2)) {
                        Log.d("WearableClient", "onPostInitHandler: adding Data listener " + entry.getValue());
                    }
                    by.m1829a(c12291, new C1007b((av) entry.getValue()));
                }
                for (Entry entry2 : this.amf.entrySet()) {
                    if (Log.isLoggable("WearableClient", 2)) {
                        Log.d("WearableClient", "onPostInitHandler: adding Message listener " + entry2.getValue());
                    }
                    by.m1829a(c12291, new C1007b((av) entry2.getValue()));
                }
                for (Entry entry22 : this.amg.entrySet()) {
                    if (Log.isLoggable("WearableClient", 2)) {
                        Log.d("WearableClient", "onPostInitHandler: adding Node listener " + entry22.getValue());
                    }
                    by.m1829a(c12291, new C1007b((av) entry22.getValue()));
                }
            } catch (Throwable e) {
                Log.d("WearableClient", "WearableClientImpl.onPostInitHandler: error while adding listener", e);
            }
        }
        Log.d("WearableClient", "WearableClientImpl.onPostInitHandler: done");
        super.m2663a(i, iBinder, bundle);
    }

    public void m3876a(C0180d<DataItemResult> c0180d, Uri uri) throws RemoteException {
        ((ad) ft()).m1824a(new AnonymousClass12(this, c0180d), uri);
    }

    public void m3877a(C0180d<GetFdForAssetResult> c0180d, Asset asset) throws RemoteException {
        ((ad) ft()).m1825a(new C12324(this, c0180d), asset);
    }

    public void m3878a(C0180d<Status> c0180d, DataListener dataListener) throws RemoteException {
        synchronized (this.ame) {
            ac acVar = (ac) this.ame.remove(dataListener);
        }
        if (acVar == null) {
            c0180d.m154a(new Status(WearableStatusCodes.UNKNOWN_LISTENER));
        } else {
            m3885a((C0180d) c0180d, acVar);
        }
    }

    public void m3879a(C0180d<Status> c0180d, DataListener dataListener, IntentFilter[] intentFilterArr) throws RemoteException {
        av a = av.m3895a(dataListener, intentFilterArr);
        synchronized (this.ame) {
            if (this.ame.get(dataListener) != null) {
                c0180d.m154a(new Status(WearableStatusCodes.DUPLICATE_LISTENER));
                return;
            }
            this.ame.put(dataListener, a);
            ((ad) ft()).m1829a(new C12357(this, dataListener, c0180d), new C1007b(a));
        }
    }

    public void m3880a(C0180d<GetFdForAssetResult> c0180d, DataItemAsset dataItemAsset) throws RemoteException {
        m3877a((C0180d) c0180d, Asset.createFromRef(dataItemAsset.getId()));
    }

    public void m3881a(C0180d<Status> c0180d, MessageListener messageListener) throws RemoteException {
        synchronized (this.amf) {
            ac acVar = (ac) this.amf.remove(messageListener);
            if (acVar == null) {
                c0180d.m154a(new Status(WearableStatusCodes.UNKNOWN_LISTENER));
            } else {
                m3885a((C0180d) c0180d, acVar);
            }
        }
    }

    public void m3882a(C0180d<Status> c0180d, MessageListener messageListener, IntentFilter[] intentFilterArr) throws RemoteException {
        av a = av.m3896a(messageListener, intentFilterArr);
        synchronized (this.amf) {
            if (this.amf.get(messageListener) != null) {
                c0180d.m154a(new Status(WearableStatusCodes.DUPLICATE_LISTENER));
                return;
            }
            this.amf.put(messageListener, a);
            ((ad) ft()).m1829a(new C12368(this, messageListener, c0180d), new C1007b(a));
        }
    }

    public void m3883a(C0180d<Status> c0180d, NodeListener nodeListener) throws RemoteException, RemoteException {
        av a = av.m3897a(nodeListener);
        synchronized (this.amg) {
            if (this.amg.get(nodeListener) != null) {
                c0180d.m154a(new Status(WearableStatusCodes.DUPLICATE_LISTENER));
                return;
            }
            this.amg.put(nodeListener, a);
            ((ad) ft()).m1829a(new C12379(this, nodeListener, c0180d), new C1007b(a));
        }
    }

    public void m3884a(C0180d<DataItemResult> c0180d, PutDataRequest putDataRequest) throws RemoteException {
        for (Entry value : putDataRequest.getAssets().entrySet()) {
            Asset asset = (Asset) value.getValue();
            if (asset.getData() == null && asset.getDigest() == null && asset.getFd() == null && asset.getUri() == null) {
                throw new IllegalArgumentException("Put for " + putDataRequest.getUri() + " contains invalid asset: " + asset);
            }
        }
        PutDataRequest k = PutDataRequest.m3121k(putDataRequest.getUri());
        k.setData(putDataRequest.getData());
        List arrayList = new ArrayList();
        for (Entry value2 : putDataRequest.getAssets().entrySet()) {
            Asset asset2 = (Asset) value2.getValue();
            if (asset2.getData() == null) {
                k.putAsset((String) value2.getKey(), (Asset) value2.getValue());
            } else {
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    if (Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: replacing data with FD in asset: " + asset2 + " read:" + createPipe[0] + " write:" + createPipe[1]);
                    }
                    k.putAsset((String) value2.getKey(), Asset.createFromFd(createPipe[0]));
                    Runnable a = m3871a(createPipe[1], asset2.getData());
                    arrayList.add(a);
                    this.agU.submit(a);
                } catch (Throwable e) {
                    throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + putDataRequest, e);
                }
            }
        }
        try {
            ((ad) ft()).m1826a(new C1238a(c0180d, arrayList), k);
        } catch (Throwable e2) {
            throw new IllegalStateException("Unable to putDataItem: " + putDataRequest, e2);
        }
    }

    public void m3885a(C0180d<Status> c0180d, ac acVar) throws RemoteException {
        ((ad) ft()).m1828a(new AnonymousClass10(this, c0180d), new ao(acVar));
    }

    public void m3886a(C0180d<SendMessageResult> c0180d, String str, String str2, byte[] bArr) throws RemoteException {
        ((ad) ft()).m1830a(new C12313(this, c0180d), str, str2, bArr);
    }

    protected void m3887a(hi hiVar, C1119e c1119e) throws RemoteException {
        hiVar.m1202e(c1119e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName());
    }

    public void m3888b(C0180d<DataItemBuffer> c0180d, Uri uri) throws RemoteException {
        ((ad) ft()).m1832b(new AnonymousClass14(this, c0180d), uri);
    }

    public void m3889b(C0180d<Status> c0180d, NodeListener nodeListener) throws RemoteException {
        synchronized (this.amg) {
            ac acVar = (ac) this.amg.remove(nodeListener);
            if (acVar == null) {
                c0180d.m154a(new Status(WearableStatusCodes.UNKNOWN_LISTENER));
            } else {
                m3885a((C0180d) c0180d, acVar);
            }
        }
    }

    protected String bu() {
        return "com.google.android.gms.wearable.BIND";
    }

    protected String bv() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    protected ad bz(IBinder iBinder) {
        return C1006a.by(iBinder);
    }

    public void m3890c(C0180d<DeleteDataItemsResult> c0180d, Uri uri) throws RemoteException {
        ((ad) ft()).m1834c(new C12302(this, c0180d), uri);
    }

    public void disconnect() {
        super.disconnect();
        this.ame.clear();
        this.amf.clear();
        this.amg.clear();
    }

    public void m3891o(C0180d<DataItemBuffer> c0180d) throws RemoteException {
        ((ad) ft()).m1835d(new AnonymousClass13(this, c0180d));
    }

    public void m3892p(C0180d<GetLocalNodeResult> c0180d) throws RemoteException {
        ((ad) ft()).m1836e(new C12335(this, c0180d));
    }

    public void m3893q(C0180d<GetConnectedNodesResult> c0180d) throws RemoteException {
        ((ad) ft()).m1837f(new C12346(this, c0180d));
    }

    protected /* synthetic */ IInterface m3894x(IBinder iBinder) {
        return bz(iBinder);
    }
}
