package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.data.C0188d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.wearable.internal.o */
public final class C1186o extends C0188d implements DataItem {
    private final int RG;

    public C1186o(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.RG = i2;
    }

    public /* synthetic */ Object freeze() {
        return nr();
    }

    public Map<String, DataItemAsset> getAssets() {
        Map<String, DataItemAsset> hashMap = new HashMap(this.RG);
        for (int i = 0; i < this.RG; i++) {
            C1183k c1183k = new C1183k(this.DG, this.EC + i);
            if (c1183k.getDataItemKey() != null) {
                hashMap.put(c1183k.getDataItemKey(), c1183k);
            }
        }
        return hashMap;
    }

    public byte[] getData() {
        return getByteArray("data");
    }

    public Uri getUri() {
        return Uri.parse(getString("path"));
    }

    public DataItem nr() {
        return new C1184l(this);
    }

    public DataItem setData(byte[] data) {
        throw new UnsupportedOperationException();
    }
}
