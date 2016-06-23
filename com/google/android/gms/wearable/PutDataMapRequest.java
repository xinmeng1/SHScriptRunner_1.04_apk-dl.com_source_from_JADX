package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.lv;
import com.google.android.gms.internal.lv.C0391a;
import com.google.android.gms.internal.me;

public class PutDataMapRequest {
    private final DataMap all;
    private final PutDataRequest alm;

    private PutDataMapRequest(PutDataRequest putDataRequest, DataMap dataMap) {
        this.alm = putDataRequest;
        this.all = new DataMap();
        if (dataMap != null) {
            this.all.putAll(dataMap);
        }
    }

    public static PutDataMapRequest create(String path) {
        return new PutDataMapRequest(PutDataRequest.create(path), null);
    }

    public static PutDataMapRequest createFromDataMapItem(DataMapItem source) {
        return new PutDataMapRequest(PutDataRequest.m3121k(source.getUri()), source.getDataMap());
    }

    public static PutDataMapRequest createWithAutoAppendedId(String pathPrefix) {
        return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(pathPrefix), null);
    }

    public PutDataRequest asPutDataRequest() {
        C0391a a = lv.m1362a(this.all);
        this.alm.setData(me.m1428d(a.amp));
        int size = a.amq.size();
        int i = 0;
        while (i < size) {
            String num = Integer.toString(i);
            Asset asset = (Asset) a.amq.get(i);
            if (num == null) {
                throw new IllegalStateException("asset key cannot be null: " + asset);
            } else if (asset == null) {
                throw new IllegalStateException("asset cannot be null: key=" + num);
            } else {
                if (Log.isLoggable(DataMap.TAG, 3)) {
                    Log.d(DataMap.TAG, "asPutDataRequest: adding asset: " + num + " " + asset);
                }
                this.alm.putAsset(num, asset);
                i++;
            }
        }
        return this.alm;
    }

    public DataMap getDataMap() {
        return this.all;
    }

    public Uri getUri() {
        return this.alm.getUri();
    }
}
