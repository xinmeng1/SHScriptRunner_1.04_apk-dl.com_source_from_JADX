package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.model.internal.C0446d;
import com.google.android.gms.maps.model.internal.C0447e.C0914a;
import java.util.ArrayList;
import java.util.List;

public final class IndoorBuilding {
    private final C0446d aaI;

    public IndoorBuilding(C0446d delegate) {
        this.aaI = (C0446d) hm.m1232f(delegate);
    }

    public boolean equals(Object other) {
        if (!(other instanceof IndoorBuilding)) {
            return false;
        }
        try {
            return this.aaI.m1542b(((IndoorBuilding) other).aaI);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getActiveLevelIndex() {
        try {
            return this.aaI.getActiveLevelIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getDefaultLevelIndex() {
        try {
            return this.aaI.getActiveLevelIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public List<IndoorLevel> getLevels() {
        try {
            List<IBinder> levels = this.aaI.getLevels();
            List<IndoorLevel> arrayList = new ArrayList(levels.size());
            for (IBinder bb : levels) {
                arrayList.add(new IndoorLevel(C0914a.bb(bb)));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.aaI.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isUnderground() {
        try {
            return this.aaI.isUnderground();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
