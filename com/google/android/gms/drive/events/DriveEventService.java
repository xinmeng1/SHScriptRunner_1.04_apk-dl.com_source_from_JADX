package com.google.android.gms.drive.events;

import android.app.IntentService;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.internal.hm;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.wearable.DataEvent;
import java.util.concurrent.LinkedBlockingDeque;

public abstract class DriveEventService extends IntentService {
    private static final LinkedBlockingDeque<DriveEvent> Ih;
    private final String mName;

    /* renamed from: com.google.android.gms.drive.events.DriveEventService.1 */
    class C02071 extends Binder {
        final /* synthetic */ DriveEventService Ii;

        C02071(DriveEventService driveEventService) {
            this.Ii = driveEventService;
        }

        protected boolean onTransact(int code, Parcel in, Parcel out, int flags) {
            Log.d("DriveEventService", "onTransact");
            DriveEventService.Ih.add((DriveEvent) in.readParcelable(this.Ii.getClassLoader()));
            this.Ii.startService(new Intent(this.Ii, this.Ii.getClass()));
            return true;
        }
    }

    static {
        Ih = new LinkedBlockingDeque();
    }

    protected DriveEventService() {
        this("DriveEventService");
    }

    protected DriveEventService(String name) {
        super(name);
        this.mName = name;
    }

    private void m268a(DriveEvent driveEvent) {
        try {
            switch (driveEvent.getType()) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    hm.m1227a(driveEvent instanceof ChangeEvent, "Unexpected event type: %s", driveEvent);
                    onChangeEvent((ChangeEvent) driveEvent);
                case DataEvent.TYPE_DELETED /*2*/:
                    hm.m1227a(driveEvent instanceof FileConflictEvent, "Unexpected event type: %s", driveEvent);
                    m269a((FileConflictEvent) driveEvent);
                default:
                    Log.w(this.mName, "Unrecognized event: " + driveEvent);
            }
        } catch (Throwable e) {
            Log.wtf(this.mName, "Service does not implement listener for type:" + driveEvent.getType(), e);
        } catch (Throwable e2) {
            Log.w(this.mName, "Error handling event: " + driveEvent, e2);
        }
    }

    public void m269a(FileConflictEvent fileConflictEvent) {
        Log.w("DriveEventService", "Unhandled FileConflictEvent: " + fileConflictEvent);
    }

    public IBinder onBind(Intent intent) {
        return new C02071(this);
    }

    public void onChangeEvent(ChangeEvent event) {
        Log.w("DriveEventService", "Unhandled ChangeEvent: " + event);
    }

    protected final void onHandleIntent(Intent intent) {
        intent.setExtrasClassLoader(getClassLoader());
        DriveEvent driveEvent = (DriveEvent) intent.getParcelableExtra(DataLayer.EVENT_KEY);
        if (driveEvent == null) {
            driveEvent = (DriveEvent) Ih.poll();
        }
        if (driveEvent != null) {
            m268a(driveEvent);
        } else {
            Log.e("DriveEventService", "The event queue is unexpectedly empty.");
        }
    }
}
