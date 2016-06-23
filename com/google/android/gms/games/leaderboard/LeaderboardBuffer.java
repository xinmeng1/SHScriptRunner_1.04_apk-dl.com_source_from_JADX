package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C1033g;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardBuffer extends C1033g<Leaderboard> {
    public LeaderboardBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object m4026c(int i, int i2) {
        return m4027f(i, i2);
    }

    protected String eZ() {
        return "external_leaderboard_id";
    }

    protected Leaderboard m4027f(int i, int i2) {
        return new LeaderboardRef(this.DG, i, i2);
    }
}
