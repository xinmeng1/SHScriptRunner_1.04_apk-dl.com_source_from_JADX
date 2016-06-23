package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.tagmanager.DataLayer.C0469b;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.d */
class C0962d implements C0469b {
    private final Context kO;

    public C0962d(Context context) {
        this.kO = context;
    }

    public void m3014x(Map<String, Object> map) {
        Object obj;
        Object obj2 = map.get("gtm.url");
        if (obj2 == null) {
            obj = map.get("gtm");
            if (obj != null && (obj instanceof Map)) {
                obj = ((Map) obj).get(PlusShare.KEY_CALL_TO_ACTION_URL);
                if (obj != null && (obj instanceof String)) {
                    String queryParameter = Uri.parse((String) obj).getQueryParameter("referrer");
                    if (queryParameter != null) {
                        ay.m1636f(this.kO, queryParameter);
                        return;
                    }
                    return;
                }
            }
        }
        obj = obj2;
        if (obj != null) {
        }
    }
}
