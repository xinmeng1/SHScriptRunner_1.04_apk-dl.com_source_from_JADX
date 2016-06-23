package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.C1033g;
import com.google.android.gms.common.data.DataHolder;

public final class InvitationBuffer extends C1033g<Invitation> {
    public InvitationBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object m4028c(int i, int i2) {
        return m4029g(i, i2);
    }

    protected String eZ() {
        return "external_invitation_id";
    }

    protected Invitation m4029g(int i, int i2) {
        return new InvitationRef(this.DG, i, i2);
    }
}
