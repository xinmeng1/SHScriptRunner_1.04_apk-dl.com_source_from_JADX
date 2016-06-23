package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.C1033g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.C1181h;

public class DataEventBuffer extends C1033g<DataEvent> implements Result {
    private final Status yz;

    public DataEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.yz = new Status(dataHolder.getStatusCode());
    }

    protected /* synthetic */ Object m4095c(int i, int i2) {
        return m4096m(i, i2);
    }

    protected String eZ() {
        return "path";
    }

    public Status getStatus() {
        return this.yz;
    }

    protected DataEvent m4096m(int i, int i2) {
        return new C1181h(this.DG, i, i2);
    }
}
