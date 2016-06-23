package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.tagmanager.DataLayer.C0469b;
import com.google.android.gms.tagmanager.cd.C0484a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager aig;
    private final DataLayer aeu;
    private final C0512r agO;
    private final C0474a aie;
    private final ConcurrentMap<C1167n, Boolean> aif;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.TagManager.3 */
    static /* synthetic */ class C04733 {
        static final /* synthetic */ int[] aii;

        static {
            aii = new int[C0484a.values().length];
            try {
                aii[C0484a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                aii[C0484a.CONTAINER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                aii[C0484a.CONTAINER_DEBUG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.a */
    interface C0474a {
        C1168o m1612a(Context context, TagManager tagManager, Looper looper, String str, int i, C0512r c0512r);
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.1 */
    class C09481 implements C0469b {
        final /* synthetic */ TagManager aih;

        C09481(TagManager tagManager) {
            this.aih = tagManager;
        }

        public void m2937x(Map<String, Object> map) {
            Object obj = map.get(DataLayer.EVENT_KEY);
            if (obj != null) {
                this.aih.cl(obj.toString());
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.2 */
    static class C09492 implements C0474a {
        C09492() {
        }

        public C1168o m2938a(Context context, TagManager tagManager, Looper looper, String str, int i, C0512r c0512r) {
            return new C1168o(context, tagManager, looper, str, i, c0512r);
        }
    }

    TagManager(Context context, C0474a containerHolderLoaderProvider, DataLayer dataLayer) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.aie = containerHolderLoaderProvider;
        this.aif = new ConcurrentHashMap();
        this.aeu = dataLayer;
        this.aeu.m1606a(new C09481(this));
        this.aeu.m1606a(new C0962d(this.mContext));
        this.agO = new C0512r();
    }

    private void cl(String str) {
        for (C1167n bH : this.aif.keySet()) {
            bH.bH(str);
        }
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (aig == null) {
                if (context == null) {
                    bh.m1642A("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                aig = new TagManager(context, new C09492(), new DataLayer(new C0981v(context)));
            }
            tagManager = aig;
        }
        return tagManager;
    }

    void m1614a(C1167n c1167n) {
        this.aif.put(c1167n, Boolean.valueOf(true));
    }

    boolean m1615b(C1167n c1167n) {
        return this.aif.remove(c1167n) != null;
    }

    public DataLayer getDataLayer() {
        return this.aeu;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    synchronized boolean m1616i(android.net.Uri r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r1 = com.google.android.gms.tagmanager.cd.md();	 Catch:{ all -> 0x0049 }
        r0 = r1.m1661i(r6);	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x0085;
    L_0x000b:
        r2 = r1.getContainerId();	 Catch:{ all -> 0x0049 }
        r0 = com.google.android.gms.tagmanager.TagManager.C04733.aii;	 Catch:{ all -> 0x0049 }
        r3 = r1.me();	 Catch:{ all -> 0x0049 }
        r3 = r3.ordinal();	 Catch:{ all -> 0x0049 }
        r0 = r0[r3];	 Catch:{ all -> 0x0049 }
        switch(r0) {
            case 1: goto L_0x0021;
            case 2: goto L_0x004c;
            case 3: goto L_0x004c;
            default: goto L_0x001e;
        };
    L_0x001e:
        r0 = 1;
    L_0x001f:
        monitor-exit(r5);
        return r0;
    L_0x0021:
        r0 = r5.aif;	 Catch:{ all -> 0x0049 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0049 }
        r1 = r0.iterator();	 Catch:{ all -> 0x0049 }
    L_0x002b:
        r0 = r1.hasNext();	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x001e;
    L_0x0031:
        r0 = r1.next();	 Catch:{ all -> 0x0049 }
        r0 = (com.google.android.gms.tagmanager.C1167n) r0;	 Catch:{ all -> 0x0049 }
        r3 = r0.getContainerId();	 Catch:{ all -> 0x0049 }
        r3 = r3.equals(r2);	 Catch:{ all -> 0x0049 }
        if (r3 == 0) goto L_0x002b;
    L_0x0041:
        r3 = 0;
        r0.bJ(r3);	 Catch:{ all -> 0x0049 }
        r0.refresh();	 Catch:{ all -> 0x0049 }
        goto L_0x002b;
    L_0x0049:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
    L_0x004c:
        r0 = r5.aif;	 Catch:{ all -> 0x0049 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0049 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0049 }
    L_0x0056:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x001e;
    L_0x005c:
        r0 = r3.next();	 Catch:{ all -> 0x0049 }
        r0 = (com.google.android.gms.tagmanager.C1167n) r0;	 Catch:{ all -> 0x0049 }
        r4 = r0.getContainerId();	 Catch:{ all -> 0x0049 }
        r4 = r4.equals(r2);	 Catch:{ all -> 0x0049 }
        if (r4 == 0) goto L_0x0077;
    L_0x006c:
        r4 = r1.mf();	 Catch:{ all -> 0x0049 }
        r0.bJ(r4);	 Catch:{ all -> 0x0049 }
        r0.refresh();	 Catch:{ all -> 0x0049 }
        goto L_0x0056;
    L_0x0077:
        r4 = r0.lo();	 Catch:{ all -> 0x0049 }
        if (r4 == 0) goto L_0x0056;
    L_0x007d:
        r4 = 0;
        r0.bJ(r4);	 Catch:{ all -> 0x0049 }
        r0.refresh();	 Catch:{ all -> 0x0049 }
        goto L_0x0056;
    L_0x0085:
        r0 = 0;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.TagManager.i(android.net.Uri):boolean");
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.aie.m1612a(this.mContext, this, null, containerId, defaultContainerResourceId, this.agO);
        a.lr();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.aie.m1612a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.agO);
        a.lr();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.aie.m1612a(this.mContext, this, null, containerId, defaultContainerResourceId, this.agO);
        a.lt();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.aie.m1612a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.agO);
        a.lt();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.aie.m1612a(this.mContext, this, null, containerId, defaultContainerResourceId, this.agO);
        a.ls();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.aie.m1612a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.agO);
        a.ls();
        return a;
    }

    public void setVerboseLoggingEnabled(boolean enableVerboseLogging) {
        bh.setLogLevel(enableVerboseLogging ? 2 : 5);
    }
}
