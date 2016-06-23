package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C1049b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.google.android.gms.drive.metadata.internal.k */
public class C1201k extends C1049b<String> {
    public C1201k(String str, int i) {
        super(str, i);
    }

    public static final Collection<String> aO(String str) throws JSONException {
        if (str == null) {
            return null;
        }
        Collection arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    protected void m3935a(Bundle bundle, Collection<String> collection) {
        bundle.putStringArrayList(getName(), new ArrayList(collection));
    }

    protected /* synthetic */ Object m3936b(DataHolder dataHolder, int i, int i2) {
        return m3937c(dataHolder, i, i2);
    }

    protected Collection<String> m3937c(DataHolder dataHolder, int i, int i2) {
        try {
            return C1201k.aO(dataHolder.m2012c(getName(), i, i2));
        } catch (Throwable e) {
            throw new IllegalStateException("DataHolder supplied invalid JSON", e);
        }
    }

    protected /* synthetic */ Object m3938f(Bundle bundle) {
        return m3939k(bundle);
    }

    protected Collection<String> m3939k(Bundle bundle) {
        return bundle.getStringArrayList(getName());
    }
}
