package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.C1033g;
import com.google.android.gms.common.data.DataHolder;

public final class ExtendedGameBuffer extends C1033g<ExtendedGame> {
    public ExtendedGameBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object m4016c(int i, int i2) {
        return m4017e(i, i2);
    }

    protected ExtendedGame m4017e(int i, int i2) {
        return new ExtendedGameRef(this.DG, i, i2);
    }

    protected String eZ() {
        return "external_game_id";
    }
}
