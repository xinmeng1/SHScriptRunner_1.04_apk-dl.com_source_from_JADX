package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.model.internal.C0447e;

public final class IndoorLevel {
    private final C0447e aaJ;

    public IndoorLevel(C0447e delegate) {
        this.aaJ = (C0447e) hm.m1232f(delegate);
    }

    public void activate() {
        try {
            this.aaJ.activate();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object other) {
        if (!(other instanceof IndoorLevel)) {
            return false;
        }
        try {
            return this.aaJ.m1543a(((IndoorLevel) other).aaJ);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getName() {
        try {
            return this.aaJ.getName();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getShortName() {
        try {
            return this.aaJ.getShortName();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.aaJ.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
