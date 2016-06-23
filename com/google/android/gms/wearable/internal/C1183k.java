package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.C0188d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemAsset;

/* renamed from: com.google.android.gms.wearable.internal.k */
public class C1183k extends C0188d implements DataItemAsset {
    public C1183k(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public /* synthetic */ Object freeze() {
        return nq();
    }

    public String getDataItemKey() {
        return getString("asset_key");
    }

    public String getId() {
        return getString("asset_id");
    }

    public DataItemAsset nq() {
        return new C1182i(this);
    }
}
