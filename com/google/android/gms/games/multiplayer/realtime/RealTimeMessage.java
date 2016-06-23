package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.hm;

public final class RealTimeMessage implements Parcelable {
    public static final Creator<RealTimeMessage> CREATOR;
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String Th;
    private final byte[] Ti;
    private final int Tj;

    /* renamed from: com.google.android.gms.games.multiplayer.realtime.RealTimeMessage.1 */
    static class C02881 implements Creator<RealTimeMessage> {
        C02881() {
        }

        public RealTimeMessage bn(Parcel parcel) {
            return new RealTimeMessage(null);
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return bn(x0);
        }

        public RealTimeMessage[] cz(int i) {
            return new RealTimeMessage[i];
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return cz(x0);
        }
    }

    static {
        CREATOR = new C02881();
    }

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    public RealTimeMessage(String senderParticipantId, byte[] messageData, int isReliable) {
        this.Th = (String) hm.m1232f(senderParticipantId);
        this.Ti = (byte[]) ((byte[]) hm.m1232f(messageData)).clone();
        this.Tj = isReliable;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getMessageData() {
        return this.Ti;
    }

    public String getSenderParticipantId() {
        return this.Th;
    }

    public boolean isReliable() {
        return this.Tj == RELIABLE;
    }

    public void writeToParcel(Parcel parcel, int flag) {
        parcel.writeString(this.Th);
        parcel.writeByteArray(this.Ti);
        parcel.writeInt(this.Tj);
    }
}
