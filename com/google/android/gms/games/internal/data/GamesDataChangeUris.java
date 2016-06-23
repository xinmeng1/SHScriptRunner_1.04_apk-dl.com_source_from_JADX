package com.google.android.gms.games.internal.data;

import android.net.Uri;
import com.google.android.gms.games.Games;

public final class GamesDataChangeUris {
    private static final Uri Rj;
    public static final Uri Rk;
    public static final Uri Rl;

    static {
        Rj = Uri.parse("content://com.google.android.gms.games/").buildUpon().appendPath("data_change").build();
        Rk = Rj.buildUpon().appendPath("invitations").build();
        Rl = Rj.buildUpon().appendEncodedPath(Games.EXTRA_PLAYER_IDS).build();
    }
}
