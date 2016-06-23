package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0304c.C1104f;
import com.google.android.gms.internal.C0304c.C1107i;
import com.google.android.gms.internal.C0304c.C1108j;
import com.google.android.gms.internal.C0323d.C1109a;
import com.google.android.gms.tagmanager.C0979s.C0513a;
import com.google.android.gms.tagmanager.cd.C0484a;
import com.google.android.gms.tagmanager.cq.C0492c;
import com.google.android.gms.tagmanager.cq.C0496g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    private final String aet;
    private final DataLayer aeu;
    private cs aev;
    private Map<String, FunctionCallMacroCallback> aew;
    private Map<String, FunctionCallTagCallback> aex;
    private volatile long aey;
    private volatile String aez;
    private final Context mContext;

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    /* renamed from: com.google.android.gms.tagmanager.Container.a */
    private class C0944a implements C0513a {
        final /* synthetic */ Container aeA;

        private C0944a(Container container) {
            this.aeA = container;
        }

        public Object m2932b(String str, Map<String, Object> map) {
            FunctionCallMacroCallback bF = this.aeA.bF(str);
            return bF == null ? null : bF.getValue(str, map);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.Container.b */
    private class C0945b implements C0513a {
        final /* synthetic */ Container aeA;

        private C0945b(Container container) {
            this.aeA = container;
        }

        public Object m2933b(String str, Map<String, Object> map) {
            FunctionCallTagCallback bG = this.aeA.bG(str);
            if (bG != null) {
                bG.execute(str, map);
            }
            return dh.nc();
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, C1108j resource) {
        this.aew = new HashMap();
        this.aex = new HashMap();
        this.aez = "";
        this.mContext = context;
        this.aeu = dataLayer;
        this.aet = containerId;
        this.aey = lastRefreshTime;
        m1588a(resource.fK);
        if (resource.fJ != null) {
            m1591a(resource.fJ);
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, C0492c resource) {
        this.aew = new HashMap();
        this.aex = new HashMap();
        this.aez = "";
        this.mContext = context;
        this.aeu = dataLayer;
        this.aet = containerId;
        this.aey = lastRefreshTime;
        m1589a(resource);
    }

    private void m1588a(C1104f c1104f) {
        if (c1104f == null) {
            throw new NullPointerException();
        }
        try {
            m1589a(cq.m1684b(c1104f));
        } catch (C0496g e) {
            bh.m1642A("Not loading resource: " + c1104f + " because it is invalid: " + e.toString());
        }
    }

    private void m1589a(C0492c c0492c) {
        this.aez = c0492c.getVersion();
        C0492c c0492c2 = c0492c;
        m1590a(new cs(this.mContext, c0492c2, this.aeu, new C0944a(), new C0945b(), bI(this.aez)));
    }

    private synchronized void m1590a(cs csVar) {
        this.aev = csVar;
    }

    private void m1591a(C1107i[] c1107iArr) {
        List arrayList = new ArrayList();
        for (Object add : c1107iArr) {
            arrayList.add(add);
        }
        ln().m1712h(arrayList);
    }

    private synchronized cs ln() {
        return this.aev;
    }

    FunctionCallMacroCallback bF(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.aew) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.aew.get(str);
        }
        return functionCallMacroCallback;
    }

    FunctionCallTagCallback bG(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.aex) {
            functionCallTagCallback = (FunctionCallTagCallback) this.aex.get(str);
        }
        return functionCallTagCallback;
    }

    void bH(String str) {
        ln().bH(str);
    }

    ag bI(String str) {
        if (cd.md().me().equals(C0484a.CONTAINER_DEBUG)) {
        }
        return new bq();
    }

    public boolean getBoolean(String key) {
        cs ln = ln();
        if (ln == null) {
            bh.m1642A("getBoolean called for closed container.");
            return dh.na().booleanValue();
        }
        try {
            return dh.m1728n((C1109a) ln.cj(key).getObject()).booleanValue();
        } catch (Exception e) {
            bh.m1642A("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return dh.na().booleanValue();
        }
    }

    public String getContainerId() {
        return this.aet;
    }

    public double getDouble(String key) {
        cs ln = ln();
        if (ln == null) {
            bh.m1642A("getDouble called for closed container.");
            return dh.mZ().doubleValue();
        }
        try {
            return dh.m1725m((C1109a) ln.cj(key).getObject()).doubleValue();
        } catch (Exception e) {
            bh.m1642A("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return dh.mZ().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.aey;
    }

    public long getLong(String key) {
        cs ln = ln();
        if (ln == null) {
            bh.m1642A("getLong called for closed container.");
            return dh.mY().longValue();
        }
        try {
            return dh.m1724l((C1109a) ln.cj(key).getObject()).longValue();
        } catch (Exception e) {
            bh.m1642A("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return dh.mY().longValue();
        }
    }

    public String getString(String key) {
        cs ln = ln();
        if (ln == null) {
            bh.m1642A("getString called for closed container.");
            return dh.nc();
        }
        try {
            return dh.m1722j((C1109a) ln.cj(key).getObject());
        } catch (Exception e) {
            bh.m1642A("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return dh.nc();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    String lm() {
        return this.aez;
    }

    public void registerFunctionCallMacroCallback(String customMacroName, FunctionCallMacroCallback customMacroCallback) {
        if (customMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.aew) {
            this.aew.put(customMacroName, customMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String customTagName, FunctionCallTagCallback customTagCallback) {
        if (customTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.aex) {
            this.aex.put(customTagName, customTagCallback);
        }
    }

    void release() {
        this.aev = null;
    }

    public void unregisterFunctionCallMacroCallback(String customMacroName) {
        synchronized (this.aew) {
            this.aew.remove(customMacroName);
        }
    }

    public void unregisterFunctionCallTagCallback(String customTagName) {
        synchronized (this.aex) {
            this.aex.remove(customTagName);
        }
    }
}
