package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataBuffer;

public final class GameNotificationBuffer extends DataBuffer<GameNotification> {
    public GameNotification ct(int i) {
        return new GameNotificationRef(this.DG, i);
    }

    public /* synthetic */ Object get(int x0) {
        return ct(x0);
    }
}
