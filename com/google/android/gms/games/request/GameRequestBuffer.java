package com.google.android.gms.games.request;

import com.google.android.gms.common.data.C1033g;
import com.google.android.gms.common.data.DataHolder;

public final class GameRequestBuffer extends C1033g<GameRequest> {
    public GameRequestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object m4052c(int i, int i2) {
        return m4053k(i, i2);
    }

    protected String eZ() {
        return "external_request_id";
    }

    protected GameRequest m4053k(int i, int i2) {
        return new GameRequestRef(this.DG, i, i2);
    }
}
