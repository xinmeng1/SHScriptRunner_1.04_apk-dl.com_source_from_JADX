package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.hk;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestCluster implements SafeParcelable, GameRequest {
    public static final GameRequestClusterCreator CREATOR;
    private final ArrayList<GameRequestEntity> Sm;
    private final int xM;

    static {
        CREATOR = new GameRequestClusterCreator();
    }

    GameRequestCluster(int versionCode, ArrayList<GameRequestEntity> requestList) {
        this.xM = versionCode;
        this.Sm = requestList;
        ii();
    }

    private void ii() {
        gx.m1158A(!this.Sm.isEmpty());
        GameRequest gameRequest = (GameRequest) this.Sm.get(0);
        int size = this.Sm.size();
        for (int i = 1; i < size; i++) {
            GameRequest gameRequest2 = (GameRequest) this.Sm.get(i);
            gx.m1159a(gameRequest.getType() == gameRequest2.getType(), "All the requests must be of the same type");
            gx.m1159a(gameRequest.getSender().equals(gameRequest2.getSender()), "All the requests must be from the same sender");
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GameRequestCluster)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        GameRequestCluster gameRequestCluster = (GameRequestCluster) obj;
        if (gameRequestCluster.Sm.size() != this.Sm.size()) {
            return false;
        }
        int size = this.Sm.size();
        for (int i = 0; i < size; i++) {
            if (!((GameRequest) this.Sm.get(i)).equals((GameRequest) gameRequestCluster.Sm.get(i))) {
                return false;
            }
        }
        return true;
    }

    public GameRequest freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public byte[] getData() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public long getExpirationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Game getGame() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getRecipientStatus(String playerId) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public /* synthetic */ List getRecipients() {
        return ix();
    }

    public String getRequestId() {
        return ((GameRequestEntity) this.Sm.get(0)).getRequestId();
    }

    public Player getSender() {
        return ((GameRequestEntity) this.Sm.get(0)).getSender();
    }

    public int getStatus() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getType() {
        return ((GameRequestEntity) this.Sm.get(0)).getType();
    }

    public int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return hk.hashCode(this.Sm.toArray());
    }

    public boolean isConsumed(String playerId) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public boolean isDataValid() {
        return true;
    }

    public ArrayList<GameRequest> iw() {
        return new ArrayList(this.Sm);
    }

    public ArrayList<Player> ix() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public void writeToParcel(Parcel dest, int flags) {
        GameRequestClusterCreator.m736a(this, dest, flags);
    }
}
