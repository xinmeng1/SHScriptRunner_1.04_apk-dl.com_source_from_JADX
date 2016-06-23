package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

/* renamed from: com.google.android.gms.wearable.internal.g */
public class C1180g implements DataEvent {
    private int AT;
    private DataItem alH;

    public C1180g(DataEvent dataEvent) {
        this.AT = dataEvent.getType();
        this.alH = (DataItem) dataEvent.getDataItem().freeze();
    }

    public /* synthetic */ Object freeze() {
        return np();
    }

    public DataItem getDataItem() {
        return this.alH;
    }

    public int getType() {
        return this.AT;
    }

    public boolean isDataValid() {
        return true;
    }

    public DataEvent np() {
        return this;
    }
}
