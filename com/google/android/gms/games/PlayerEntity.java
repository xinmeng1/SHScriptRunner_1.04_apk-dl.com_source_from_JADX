package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.ik;

public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Creator<PlayerEntity> CREATOR;
    private final String HY;
    private final String Ln;
    private final String MC;
    private final String MD;
    private final String MS;
    private final long MT;
    private final int MU;
    private final long MV;
    private final MostRecentGameInfoEntity MW;
    private final PlayerLevelInfo MX;
    private final boolean MY;
    private final Uri Mr;
    private final Uri Ms;
    private final int xM;

    static final class PlayerEntityCreatorCompat extends PlayerEntityCreator {
        PlayerEntityCreatorCompat() {
        }

        public PlayerEntity be(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.m3452c(ha.fq()) || ha.aA(PlayerEntity.class.getCanonicalName())) {
                return super.be(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            return new PlayerEntity(10, readString, readString2, readString3 == null ? null : Uri.parse(readString3), readString4 == null ? null : Uri.parse(readString4), parcel.readLong(), -1, -1, null, null, null, null, null, true);
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return be(x0);
        }
    }

    static {
        CREATOR = new PlayerEntityCreatorCompat();
    }

    PlayerEntity(int versionCode, String playerId, String displayName, Uri iconImageUri, Uri hiResImageUri, long retrievedTimestamp, int isInCircles, long lastPlayedWithTimestamp, String iconImageUrl, String hiResImageUrl, String title, MostRecentGameInfoEntity mostRecentGameInfo, PlayerLevelInfo playerLevelInfo, boolean hasAllPublic) {
        this.xM = versionCode;
        this.MS = playerId;
        this.Ln = displayName;
        this.Mr = iconImageUri;
        this.MC = iconImageUrl;
        this.Ms = hiResImageUri;
        this.MD = hiResImageUrl;
        this.MT = retrievedTimestamp;
        this.MU = isInCircles;
        this.MV = lastPlayedWithTimestamp;
        this.HY = title;
        this.MY = hasAllPublic;
        this.MW = mostRecentGameInfo;
        this.MX = playerLevelInfo;
    }

    public PlayerEntity(Player player) {
        this.xM = 10;
        this.MS = player.getPlayerId();
        this.Ln = player.getDisplayName();
        this.Mr = player.getIconImageUri();
        this.MC = player.getIconImageUrl();
        this.Ms = player.getHiResImageUri();
        this.MD = player.getHiResImageUrl();
        this.MT = player.getRetrievedTimestamp();
        this.MU = player.gS();
        this.MV = player.getLastPlayedWithTimestamp();
        this.HY = player.getTitle();
        this.MY = player.gT();
        MostRecentGameInfo gU = player.gU();
        this.MW = gU == null ? null : new MostRecentGameInfoEntity(gU);
        this.MX = player.getLevelInfo();
        gx.m1160c(this.MS);
        gx.m1160c(this.Ln);
        gx.m1158A(this.MT > 0);
    }

    static int m3944a(Player player) {
        return hk.hashCode(player.getPlayerId(), player.getDisplayName(), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo());
    }

    static boolean m3945a(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return hk.equal(player2.getPlayerId(), player.getPlayerId()) && hk.equal(player2.getDisplayName(), player.getDisplayName()) && hk.equal(player2.getIconImageUri(), player.getIconImageUri()) && hk.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && hk.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && hk.equal(player2.getTitle(), player.getTitle()) && hk.equal(player2.getLevelInfo(), player.getLevelInfo());
    }

    static String m3946b(Player player) {
        return hk.m1221e(player).m1220a("PlayerId", player.getPlayerId()).m1220a("DisplayName", player.getDisplayName()).m1220a("IconImageUri", player.getIconImageUri()).m1220a("IconImageUrl", player.getIconImageUrl()).m1220a("HiResImageUri", player.getHiResImageUri()).m1220a("HiResImageUrl", player.getHiResImageUrl()).m1220a("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).m1220a("Title", player.getTitle()).m1220a("LevelInfo", player.getLevelInfo()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m3945a(this, obj);
    }

    public Player freeze() {
        return this;
    }

    public int gS() {
        return this.MU;
    }

    public boolean gT() {
        return this.MY;
    }

    public MostRecentGameInfo gU() {
        return this.MW;
    }

    public String getDisplayName() {
        return this.Ln;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        ik.m1275b(this.Ln, dataOut);
    }

    public Uri getHiResImageUri() {
        return this.Ms;
    }

    public String getHiResImageUrl() {
        return this.MD;
    }

    public Uri getIconImageUri() {
        return this.Mr;
    }

    public String getIconImageUrl() {
        return this.MC;
    }

    public long getLastPlayedWithTimestamp() {
        return this.MV;
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.MX;
    }

    public String getPlayerId() {
        return this.MS;
    }

    public long getRetrievedTimestamp() {
        return this.MT;
    }

    public String getTitle() {
        return this.HY;
    }

    public void getTitle(CharArrayBuffer dataOut) {
        ik.m1275b(this.HY, dataOut);
    }

    public int getVersionCode() {
        return this.xM;
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return m3944a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m3946b((Player) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        if (fr()) {
            dest.writeString(this.MS);
            dest.writeString(this.Ln);
            dest.writeString(this.Mr == null ? null : this.Mr.toString());
            if (this.Ms != null) {
                str = this.Ms.toString();
            }
            dest.writeString(str);
            dest.writeLong(this.MT);
            return;
        }
        PlayerEntityCreator.m474a(this, dest, flags);
    }
}
