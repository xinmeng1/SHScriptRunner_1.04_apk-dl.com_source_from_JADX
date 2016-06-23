package com.google.android.gms.appstate;

import com.google.android.gms.common.data.C0188d;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.appstate.b */
public final class C1024b extends C0188d implements AppState {
    C1024b(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public AppState dS() {
        return new C1023a(this);
    }

    public boolean equals(Object obj) {
        return C1023a.m3174a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return dS();
    }

    public byte[] getConflictData() {
        return getByteArray("conflict_data");
    }

    public String getConflictVersion() {
        return getString("conflict_version");
    }

    public int getKey() {
        return getInteger("key");
    }

    public byte[] getLocalData() {
        return getByteArray("local_data");
    }

    public String getLocalVersion() {
        return getString("local_version");
    }

    public boolean hasConflict() {
        return !ax("conflict_version");
    }

    public int hashCode() {
        return C1023a.m3173a(this);
    }

    public String toString() {
        return C1023a.m3175b(this);
    }
}
