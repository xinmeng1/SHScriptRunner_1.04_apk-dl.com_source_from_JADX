package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0181a.C0180d;
import com.google.android.gms.common.api.Status;

public class aw extends C1037c {
    private final C0180d<Status> yR;

    public aw(C0180d<Status> c0180d) {
        this.yR = c0180d;
    }

    public void m3905o(Status status) throws RemoteException {
        this.yR.m154a(status);
    }

    public void onSuccess() throws RemoteException {
        this.yR.m154a(Status.En);
    }
}
