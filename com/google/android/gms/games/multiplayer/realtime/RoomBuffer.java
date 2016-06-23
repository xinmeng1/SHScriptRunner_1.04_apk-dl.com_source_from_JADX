package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.C1033g;
import com.google.android.gms.common.data.DataHolder;

public final class RoomBuffer extends C1033g<Room> {
    public RoomBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object m4038c(int i, int i2) {
        return m4039h(i, i2);
    }

    protected String eZ() {
        return "external_match_id";
    }

    protected Room m4039h(int i, int i2) {
        return new RoomRef(this.DG, i, i2);
    }
}
