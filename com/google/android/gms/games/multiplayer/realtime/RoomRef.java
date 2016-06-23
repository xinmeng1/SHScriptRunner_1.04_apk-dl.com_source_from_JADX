package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.C0188d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;

public final class RoomRef extends C0188d implements Room {
    private final int RG;

    RoomRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.RG = numChildren;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return RoomEntity.m4042a((Room) this, obj);
    }

    public Room freeze() {
        return new RoomEntity(this);
    }

    public Bundle getAutoMatchCriteria() {
        return !getBoolean("has_automatch_criteria") ? null : RoomConfig.createAutoMatchCriteria(getInteger("automatch_min_players"), getInteger("automatch_max_players"), getLong("automatch_bit_mask"));
    }

    public int getAutoMatchWaitEstimateSeconds() {
        return getInteger("automatch_wait_estimate_sec");
    }

    public long getCreationTimestamp() {
        return getLong("creation_timestamp");
    }

    public String getCreatorId() {
        return getString("creator_external");
    }

    public String getDescription() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
    }

    public void getDescription(CharArrayBuffer dataOut) {
        m164a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, dataOut);
    }

    public Participant getParticipant(String participantId) {
        return RoomEntity.m4046c(this, participantId);
    }

    public String getParticipantId(String playerId) {
        return RoomEntity.m4044b(this, playerId);
    }

    public ArrayList<String> getParticipantIds() {
        return RoomEntity.m4047c(this);
    }

    public int getParticipantStatus(String participantId) {
        return RoomEntity.m4041a((Room) this, participantId);
    }

    public ArrayList<Participant> getParticipants() {
        ArrayList<Participant> arrayList = new ArrayList(this.RG);
        for (int i = 0; i < this.RG; i++) {
            arrayList.add(new ParticipantRef(this.DG, this.EC + i));
        }
        return arrayList;
    }

    public String getRoomId() {
        return getString("external_match_id");
    }

    public int getStatus() {
        return getInteger(NotificationCompatApi21.CATEGORY_STATUS);
    }

    public int getVariant() {
        return getInteger("variant");
    }

    public int hashCode() {
        return RoomEntity.m4040a(this);
    }

    public String toString() {
        return RoomEntity.m4043b((Room) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((RoomEntity) freeze()).writeToParcel(dest, flags);
    }
}
