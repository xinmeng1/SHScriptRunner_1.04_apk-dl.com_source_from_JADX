package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0188d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class ParticipantRef extends C0188d implements Participant {
    private final PlayerRef Te;

    public ParticipantRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
        this.Te = new PlayerRef(holder, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return ParticipantEntity.m4035a(this, obj);
    }

    public Participant freeze() {
        return new ParticipantEntity(this);
    }

    public String gW() {
        return getString("client_address");
    }

    public int getCapabilities() {
        return getInteger("capabilities");
    }

    public String getDisplayName() {
        return ax("external_player_id") ? getString("default_display_name") : this.Te.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        if (ax("external_player_id")) {
            m164a("default_display_name", dataOut);
        } else {
            this.Te.getDisplayName(dataOut);
        }
    }

    public Uri getHiResImageUri() {
        return ax("external_player_id") ? aw("default_display_hi_res_image_uri") : this.Te.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        return ax("external_player_id") ? getString("default_display_hi_res_image_url") : this.Te.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        return ax("external_player_id") ? aw("default_display_image_uri") : this.Te.getIconImageUri();
    }

    public String getIconImageUrl() {
        return ax("external_player_id") ? getString("default_display_image_url") : this.Te.getIconImageUrl();
    }

    public String getParticipantId() {
        return getString("external_participant_id");
    }

    public Player getPlayer() {
        return ax("external_player_id") ? null : this.Te;
    }

    public ParticipantResult getResult() {
        if (ax("result_type")) {
            return null;
        }
        return new ParticipantResult(getParticipantId(), getInteger("result_type"), getInteger("placing"));
    }

    public int getStatus() {
        return getInteger("player_status");
    }

    public int hashCode() {
        return ParticipantEntity.m4034a(this);
    }

    public boolean isConnectedToRoom() {
        return getInteger("connected") > 0;
    }

    public String toString() {
        return ParticipantEntity.m4036b((Participant) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((ParticipantEntity) freeze()).writeToParcel(dest, flags);
    }
}
