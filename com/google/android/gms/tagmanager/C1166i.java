package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.C0296a;
import com.google.android.gms.internal.C0300b;
import com.google.android.gms.internal.C0323d.C1109a;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.i */
class C1166i extends df {
    private static final String ID;
    private static final String URL;
    private static final String aem;
    private static final String aen;
    static final String aeo;
    private static final Set<String> aep;
    private final C0504a aeq;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.i.a */
    public interface C0504a {
        aq li();
    }

    /* renamed from: com.google.android.gms.tagmanager.i.1 */
    class C09681 implements C0504a {
        final /* synthetic */ Context qu;

        C09681(Context context) {
            this.qu = context;
        }

        public aq li() {
            return C0983y.m3066N(this.qu);
        }
    }

    static {
        ID = C0296a.ARBITRARY_PIXEL.toString();
        URL = C0300b.URL.toString();
        aem = C0300b.ADDITIONAL_PARAMS.toString();
        aen = C0300b.UNREPEATABLE.toString();
        aeo = "gtm_" + ID + "_unrepeatable";
        aep = new HashSet();
    }

    public C1166i(Context context) {
        this(context, new C09681(context));
    }

    C1166i(Context context, C0504a c0504a) {
        super(ID, URL);
        this.aeq = c0504a;
        this.mContext = context;
    }

    private synchronized boolean bB(String str) {
        boolean z = true;
        synchronized (this) {
            if (!bD(str)) {
                if (bC(str)) {
                    aep.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    boolean bC(String str) {
        return this.mContext.getSharedPreferences(aeo, 0).contains(str);
    }

    boolean bD(String str) {
        return aep.contains(str);
    }

    public void m3832y(Map<String, C1109a> map) {
        String j = map.get(aen) != null ? dh.m1722j((C1109a) map.get(aen)) : null;
        if (j == null || !bB(j)) {
            Builder buildUpon = Uri.parse(dh.m1722j((C1109a) map.get(URL))).buildUpon();
            C1109a c1109a = (C1109a) map.get(aem);
            if (c1109a != null) {
                Object o = dh.m1730o(c1109a);
                if (o instanceof List) {
                    for (Object o2 : (List) o2) {
                        if (o2 instanceof Map) {
                            for (Entry entry : ((Map) o2).entrySet()) {
                                buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                            }
                        } else {
                            bh.m1642A("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + buildUpon.build().toString());
                            return;
                        }
                    }
                }
                bh.m1642A("ArbitraryPixel: additional params not a list: not sending partial hit: " + buildUpon.build().toString());
                return;
            }
            String uri = buildUpon.build().toString();
            this.aeq.li().bR(uri);
            bh.m1644C("ArbitraryPixel: url = " + uri);
            if (j != null) {
                synchronized (C1166i.class) {
                    aep.add(j);
                    cy.m1714a(this.mContext, aeo, j, "true");
                }
            }
        }
    }
}
