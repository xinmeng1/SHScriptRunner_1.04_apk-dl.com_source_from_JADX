package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.ik;
import java.util.ArrayList;

public final class RoomEntity extends GamesDowngradeableSafeParcel implements Room {
    public static final Creator<RoomEntity> CREATOR;
    private final String Mp;
    private final String NS;
    private final long SU;
    private final ArrayList<ParticipantEntity> SX;
    private final int SY;
    private final Bundle To;
    private final String Ts;
    private final int Tt;
    private final int Tu;
    private final int xM;

    static final class RoomEntityCreatorCompat extends RoomEntityCreator {
        RoomEntityCreatorCompat() {
        }

        public RoomEntity bo(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.m3452c(ha.fq()) || ha.aA(RoomEntity.class.getCanonicalName())) {
                return super.bo(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            String readString3 = parcel.readString();
            int readInt2 = parcel.readInt();
            Bundle readBundle = parcel.readBundle();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i < readInt3; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new RoomEntity(2, readString, readString2, readLong, readInt, readString3, readInt2, readBundle, arrayList, -1);
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return bo(x0);
        }
    }

    static {
        CREATOR = new RoomEntityCreatorCompat();
    }

    RoomEntity(int versionCode, String roomId, String creatorId, long creationTimestamp, int roomStatus, String description, int variant, Bundle autoMatchCriteria, ArrayList<ParticipantEntity> participants, int autoMatchWaitEstimateSeconds) {
        this.xM = versionCode;
        this.NS = roomId;
        this.Ts = creatorId;
        this.SU = creationTimestamp;
        this.Tt = roomStatus;
        this.Mp = description;
        this.SY = variant;
        this.To = autoMatchCriteria;
        this.SX = participants;
        this.Tu = autoMatchWaitEstimateSeconds;
    }

    public RoomEntity(Room room) {
        this.xM = 2;
        this.NS = room.getRoomId();
        this.Ts = room.getCreatorId();
        this.SU = room.getCreationTimestamp();
        this.Tt = room.getStatus();
        this.Mp = room.getDescription();
        this.SY = room.getVariant();
        this.To = room.getAutoMatchCriteria();
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        this.SX = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.SX.add((ParticipantEntity) ((Participant) participants.get(i)).freeze());
        }
        this.Tu = room.getAutoMatchWaitEstimateSeconds();
    }

    static int m4040a(Room room) {
        return hk.hashCode(room.getRoomId(), room.getCreatorId(), Long.valueOf(room.getCreationTimestamp()), Integer.valueOf(room.getStatus()), room.getDescription(), Integer.valueOf(room.getVariant()), room.getAutoMatchCriteria(), room.getParticipants(), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    static int m4041a(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in room " + room.getRoomId());
    }

    static boolean m4042a(Room room, Object obj) {
        if (!(obj instanceof Room)) {
            return false;
        }
        if (room == obj) {
            return true;
        }
        Room room2 = (Room) obj;
        return hk.equal(room2.getRoomId(), room.getRoomId()) && hk.equal(room2.getCreatorId(), room.getCreatorId()) && hk.equal(Long.valueOf(room2.getCreationTimestamp()), Long.valueOf(room.getCreationTimestamp())) && hk.equal(Integer.valueOf(room2.getStatus()), Integer.valueOf(room.getStatus())) && hk.equal(room2.getDescription(), room.getDescription()) && hk.equal(Integer.valueOf(room2.getVariant()), Integer.valueOf(room.getVariant())) && hk.equal(room2.getAutoMatchCriteria(), room.getAutoMatchCriteria()) && hk.equal(room2.getParticipants(), room.getParticipants()) && hk.equal(Integer.valueOf(room2.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    static String m4043b(Room room) {
        return hk.m1221e(room).m1220a("RoomId", room.getRoomId()).m1220a("CreatorId", room.getCreatorId()).m1220a("CreationTimestamp", Long.valueOf(room.getCreationTimestamp())).m1220a("RoomStatus", Integer.valueOf(room.getStatus())).m1220a("Description", room.getDescription()).m1220a("Variant", Integer.valueOf(room.getVariant())).m1220a("AutoMatchCriteria", room.getAutoMatchCriteria()).m1220a("Participants", room.getParticipants()).m1220a("AutoMatchWaitEstimateSeconds", Integer.valueOf(room.getAutoMatchWaitEstimateSeconds())).toString();
    }

    static String m4044b(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(str)) {
                return participant.getParticipantId();
            }
        }
        return null;
    }

    static Participant m4046c(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + room.getRoomId());
    }

    static ArrayList<String> m4047c(Room room) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m4042a((Room) this, obj);
    }

    public Room freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.To;
    }

    public int getAutoMatchWaitEstimateSeconds() {
        return this.Tu;
    }

    public long getCreationTimestamp() {
        return this.SU;
    }

    public String getCreatorId() {
        return this.Ts;
    }

    public String getDescription() {
        return this.Mp;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        ik.m1275b(this.Mp, dataOut);
    }

    public Participant getParticipant(String participantId) {
        return m4046c(this, participantId);
    }

    public String getParticipantId(String playerId) {
        return m4044b(this, playerId);
    }

    public ArrayList<String> getParticipantIds() {
        return m4047c(this);
    }

    public int getParticipantStatus(String participantId) {
        return m4041a((Room) this, participantId);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.SX);
    }

    public String getRoomId() {
        return this.NS;
    }

    public int getStatus() {
        return this.Tt;
    }

    public int getVariant() {
        return this.SY;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return m4040a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m4043b((Room) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (fr()) {
            dest.writeString(this.NS);
            dest.writeString(this.Ts);
            dest.writeLong(this.SU);
            dest.writeInt(this.Tt);
            dest.writeString(this.Mp);
            dest.writeInt(this.SY);
            dest.writeBundle(this.To);
            int size = this.SX.size();
            dest.writeInt(size);
            for (int i = 0; i < size; i++) {
                ((ParticipantEntity) this.SX.get(i)).writeToParcel(dest, flags);
            }
            return;
        }
        RoomEntityCreator.m743a(this, dest, flags);
    }
}
