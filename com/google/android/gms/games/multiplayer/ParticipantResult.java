package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.constants.MatchResult;
import com.google.android.gms.internal.hm;

public final class ParticipantResult implements SafeParcelable {
    public static final ParticipantResultCreator CREATOR;
    public static final int MATCH_RESULT_DISAGREED = 5;
    public static final int MATCH_RESULT_DISCONNECT = 4;
    public static final int MATCH_RESULT_LOSS = 1;
    public static final int MATCH_RESULT_NONE = 3;
    public static final int MATCH_RESULT_TIE = 2;
    public static final int MATCH_RESULT_UNINITIALIZED = -1;
    public static final int MATCH_RESULT_WIN = 0;
    public static final int PLACING_UNINITIALIZED = -1;
    private final String Oq;
    private final int Tf;
    private final int Tg;
    private final int xM;

    static {
        CREATOR = new ParticipantResultCreator();
    }

    public ParticipantResult(int versionCode, String participantId, int result, int placing) {
        this.xM = versionCode;
        this.Oq = (String) hm.m1232f(participantId);
        hm.m1224A(MatchResult.isValid(result));
        this.Tf = result;
        this.Tg = placing;
    }

    public ParticipantResult(String participantId, int result, int placing) {
        this(MATCH_RESULT_LOSS, participantId, result, placing);
    }

    public int describeContents() {
        return MATCH_RESULT_WIN;
    }

    public String getParticipantId() {
        return this.Oq;
    }

    public int getPlacing() {
        return this.Tg;
    }

    public int getResult() {
        return this.Tf;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel out, int flags) {
        ParticipantResultCreator.m742a(this, out, flags);
    }
}
