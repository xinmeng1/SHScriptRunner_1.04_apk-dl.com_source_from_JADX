package com.google.android.gms.drive.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.internal.ac.C0647a;
import com.google.android.gms.internal.hm;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.internal.x */
public class C1048x<C extends DriveEvent> extends C0647a {
    private final int Iq;
    private final Listener<C> Jn;
    private final C0225a<C> Jo;

    /* renamed from: com.google.android.gms.drive.internal.x.a */
    private static class C0225a<E extends DriveEvent> extends Handler {
        private C0225a(Looper looper) {
            super(looper);
        }

        public void m359a(Listener<E> listener, E e) {
            sendMessage(obtainMessage(1, new Pair(listener, e)));
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    Pair pair = (Pair) msg.obj;
                    ((Listener) pair.first).onEvent((DriveEvent) pair.second);
                default:
                    Log.wtf("EventCallback", "Don't know how to handle this event");
            }
        }
    }

    public C1048x(Looper looper, int i, Listener<C> listener) {
        this.Iq = i;
        this.Jn = listener;
        this.Jo = new C0225a(null);
    }

    public void m3225a(OnEventResponse onEventResponse) throws RemoteException {
        hm.m1224A(this.Iq == onEventResponse.getEventType());
        switch (onEventResponse.getEventType()) {
            case DataEvent.TYPE_CHANGED /*1*/:
                this.Jo.m359a(this.Jn, onEventResponse.gw());
            case DataEvent.TYPE_DELETED /*2*/:
                this.Jo.m359a(this.Jn, onEventResponse.gx());
            default:
                Log.w("EventCallback", "Unexpected event type:" + onEventResponse.getEventType());
        }
    }
}
