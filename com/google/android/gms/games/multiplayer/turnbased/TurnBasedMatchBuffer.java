package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.C1033g;
import com.google.android.gms.common.data.DataHolder;

public final class TurnBasedMatchBuffer extends C1033g<TurnBasedMatch> {
    public TurnBasedMatchBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object m4048c(int i, int i2) {
        return m4049i(i, i2);
    }

    protected String eZ() {
        return "external_match_id";
    }

    protected TurnBasedMatch m4049i(int i, int i2) {
        return new TurnBasedMatchRef(this.DG, i, i2);
    }
}
