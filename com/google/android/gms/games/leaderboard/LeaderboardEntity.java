package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.ik;
import java.util.ArrayList;

public final class LeaderboardEntity implements Leaderboard {
    private final String Ln;
    private final String MC;
    private final Uri Mr;
    private final String Sp;
    private final int Sq;
    private final ArrayList<LeaderboardVariantEntity> Sr;
    private final Game Ss;

    public LeaderboardEntity(Leaderboard leaderboard) {
        this.Sp = leaderboard.getLeaderboardId();
        this.Ln = leaderboard.getDisplayName();
        this.Mr = leaderboard.getIconImageUri();
        this.MC = leaderboard.getIconImageUrl();
        this.Sq = leaderboard.getScoreOrder();
        Game game = leaderboard.getGame();
        this.Ss = game == null ? null : new GameEntity(game);
        ArrayList variants = leaderboard.getVariants();
        int size = variants.size();
        this.Sr = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.Sr.add((LeaderboardVariantEntity) ((LeaderboardVariant) variants.get(i)).freeze());
        }
    }

    static int m3456a(Leaderboard leaderboard) {
        return hk.hashCode(leaderboard.getLeaderboardId(), leaderboard.getDisplayName(), leaderboard.getIconImageUri(), Integer.valueOf(leaderboard.getScoreOrder()), leaderboard.getVariants());
    }

    static boolean m3457a(Leaderboard leaderboard, Object obj) {
        if (!(obj instanceof Leaderboard)) {
            return false;
        }
        if (leaderboard == obj) {
            return true;
        }
        Leaderboard leaderboard2 = (Leaderboard) obj;
        return hk.equal(leaderboard2.getLeaderboardId(), leaderboard.getLeaderboardId()) && hk.equal(leaderboard2.getDisplayName(), leaderboard.getDisplayName()) && hk.equal(leaderboard2.getIconImageUri(), leaderboard.getIconImageUri()) && hk.equal(Integer.valueOf(leaderboard2.getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())) && hk.equal(leaderboard2.getVariants(), leaderboard.getVariants());
    }

    static String m3458b(Leaderboard leaderboard) {
        return hk.m1221e(leaderboard).m1220a("LeaderboardId", leaderboard.getLeaderboardId()).m1220a("DisplayName", leaderboard.getDisplayName()).m1220a("IconImageUri", leaderboard.getIconImageUri()).m1220a("IconImageUrl", leaderboard.getIconImageUrl()).m1220a("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).m1220a("Variants", leaderboard.getVariants()).toString();
    }

    public boolean equals(Object obj) {
        return m3457a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return iz();
    }

    public String getDisplayName() {
        return this.Ln;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        ik.m1275b(this.Ln, dataOut);
    }

    public Game getGame() {
        return this.Ss;
    }

    public Uri getIconImageUri() {
        return this.Mr;
    }

    public String getIconImageUrl() {
        return this.MC;
    }

    public String getLeaderboardId() {
        return this.Sp;
    }

    public int getScoreOrder() {
        return this.Sq;
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        return new ArrayList(this.Sr);
    }

    public int hashCode() {
        return m3456a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public Leaderboard iz() {
        return this;
    }

    public String toString() {
        return m3458b(this);
    }
}
