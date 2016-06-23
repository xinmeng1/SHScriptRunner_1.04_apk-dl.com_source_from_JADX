package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hm;

public final class PlayerLevel implements SafeParcelable {
    public static final PlayerLevelCreator CREATOR;
    private final int MZ;
    private final long Na;
    private final long Nb;
    private final int xM;

    static {
        CREATOR = new PlayerLevelCreator();
    }

    PlayerLevel(int versionCode, int levelNumber, long minXp, long maxXp) {
        boolean z = true;
        hm.m1226a(minXp >= 0, "Min XP must be positive!");
        if (maxXp <= minXp) {
            z = false;
        }
        hm.m1226a(z, "Max XP must be more than min XP!");
        this.xM = versionCode;
        this.MZ = levelNumber;
        this.Na = minXp;
        this.Nb = maxXp;
    }

    public PlayerLevel(int value, long minXp, long maxXp) {
        this(1, value, minXp, maxXp);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PlayerLevel playerLevel = (PlayerLevel) obj;
        return hk.equal(Integer.valueOf(playerLevel.getLevelNumber()), Integer.valueOf(getLevelNumber())) && hk.equal(Long.valueOf(playerLevel.getMinXp()), Long.valueOf(getMinXp())) && hk.equal(Long.valueOf(playerLevel.getMaxXp()), Long.valueOf(getMaxXp()));
    }

    public int getLevelNumber() {
        return this.MZ;
    }

    public long getMaxXp() {
        return this.Nb;
    }

    public long getMinXp() {
        return this.Na;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return hk.hashCode(Integer.valueOf(this.MZ), Long.valueOf(this.Na), Long.valueOf(this.Nb));
    }

    public String toString() {
        return hk.m1221e(this).m1220a("LevelNumber", Integer.valueOf(getLevelNumber())).m1220a("MinXp", Long.valueOf(getMinXp())).m1220a("MaxXp", Long.valueOf(getMaxXp())).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        PlayerLevelCreator.m475a(this, out, flags);
    }
}
