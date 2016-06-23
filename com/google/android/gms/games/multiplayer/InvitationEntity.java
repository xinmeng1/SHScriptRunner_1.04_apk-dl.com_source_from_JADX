package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hm;
import java.util.ArrayList;

public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation {
    public static final Creator<InvitationEntity> CREATOR;
    private final String NQ;
    private final GameEntity Rt;
    private final long SU;
    private final int SV;
    private final ParticipantEntity SW;
    private final ArrayList<ParticipantEntity> SX;
    private final int SY;
    private final int SZ;
    private final int xM;

    static final class InvitationEntityCreatorCompat extends InvitationEntityCreator {
        InvitationEntityCreatorCompat() {
        }

        public InvitationEntity bl(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.m3452c(ha.fq()) || ha.aA(InvitationEntity.class.getCanonicalName())) {
                return super.bl(parcel);
            }
            GameEntity gameEntity = (GameEntity) GameEntity.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            ParticipantEntity participantEntity = (ParticipantEntity) ParticipantEntity.CREATOR.createFromParcel(parcel);
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i = 0; i < readInt2; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new InvitationEntity(2, gameEntity, readString, readLong, readInt, participantEntity, arrayList, -1, 0);
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return bl(x0);
        }
    }

    static {
        CREATOR = new InvitationEntityCreatorCompat();
    }

    InvitationEntity(int versionCode, GameEntity game, String invitationId, long creationTimestamp, int invitationType, ParticipantEntity inviter, ArrayList<ParticipantEntity> participants, int variant, int availableAutoMatchSlots) {
        this.xM = versionCode;
        this.Rt = game;
        this.NQ = invitationId;
        this.SU = creationTimestamp;
        this.SV = invitationType;
        this.SW = inviter;
        this.SX = participants;
        this.SY = variant;
        this.SZ = availableAutoMatchSlots;
    }

    InvitationEntity(Invitation invitation) {
        this.xM = 2;
        this.Rt = new GameEntity(invitation.getGame());
        this.NQ = invitation.getInvitationId();
        this.SU = invitation.getCreationTimestamp();
        this.SV = invitation.getInvitationType();
        this.SY = invitation.getVariant();
        this.SZ = invitation.getAvailableAutoMatchSlots();
        String participantId = invitation.getInviter().getParticipantId();
        Object obj = null;
        ArrayList participants = invitation.getParticipants();
        int size = participants.size();
        this.SX = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(participantId)) {
                obj = participant;
            }
            this.SX.add((ParticipantEntity) participant.freeze());
        }
        hm.m1228b(obj, (Object) "Must have a valid inviter!");
        this.SW = (ParticipantEntity) obj.freeze();
    }

    static int m4030a(Invitation invitation) {
        return hk.hashCode(invitation.getGame(), invitation.getInvitationId(), Long.valueOf(invitation.getCreationTimestamp()), Integer.valueOf(invitation.getInvitationType()), invitation.getInviter(), invitation.getParticipants(), Integer.valueOf(invitation.getVariant()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    static boolean m4031a(Invitation invitation, Object obj) {
        if (!(obj instanceof Invitation)) {
            return false;
        }
        if (invitation == obj) {
            return true;
        }
        Invitation invitation2 = (Invitation) obj;
        return hk.equal(invitation2.getGame(), invitation.getGame()) && hk.equal(invitation2.getInvitationId(), invitation.getInvitationId()) && hk.equal(Long.valueOf(invitation2.getCreationTimestamp()), Long.valueOf(invitation.getCreationTimestamp())) && hk.equal(Integer.valueOf(invitation2.getInvitationType()), Integer.valueOf(invitation.getInvitationType())) && hk.equal(invitation2.getInviter(), invitation.getInviter()) && hk.equal(invitation2.getParticipants(), invitation.getParticipants()) && hk.equal(Integer.valueOf(invitation2.getVariant()), Integer.valueOf(invitation.getVariant())) && hk.equal(Integer.valueOf(invitation2.getAvailableAutoMatchSlots()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    static String m4032b(Invitation invitation) {
        return hk.m1221e(invitation).m1220a("Game", invitation.getGame()).m1220a("InvitationId", invitation.getInvitationId()).m1220a("CreationTimestamp", Long.valueOf(invitation.getCreationTimestamp())).m1220a("InvitationType", Integer.valueOf(invitation.getInvitationType())).m1220a("Inviter", invitation.getInviter()).m1220a("Participants", invitation.getParticipants()).m1220a("Variant", Integer.valueOf(invitation.getVariant())).m1220a("AvailableAutoMatchSlots", Integer.valueOf(invitation.getAvailableAutoMatchSlots())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m4031a(this, obj);
    }

    public Invitation freeze() {
        return this;
    }

    public int getAvailableAutoMatchSlots() {
        return this.SZ;
    }

    public long getCreationTimestamp() {
        return this.SU;
    }

    public Game getGame() {
        return this.Rt;
    }

    public String getInvitationId() {
        return this.NQ;
    }

    public int getInvitationType() {
        return this.SV;
    }

    public Participant getInviter() {
        return this.SW;
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.SX);
    }

    public int getVariant() {
        return this.SY;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return m4030a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m4032b((Invitation) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (fr()) {
            this.Rt.writeToParcel(dest, flags);
            dest.writeString(this.NQ);
            dest.writeLong(this.SU);
            dest.writeInt(this.SV);
            this.SW.writeToParcel(dest, flags);
            int size = this.SX.size();
            dest.writeInt(size);
            for (int i = 0; i < size; i++) {
                ((ParticipantEntity) this.SX.get(i)).writeToParcel(dest, flags);
            }
            return;
        }
        InvitationEntityCreator.m740a(this, dest, flags);
    }
}
