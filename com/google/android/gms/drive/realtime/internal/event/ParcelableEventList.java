package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableEventList implements SafeParcelable {
    public static final Creator<ParcelableEventList> CREATOR;
    final ParcelableEvent[] LB;
    final DataHolder LC;
    final boolean LD;
    final ParcelableObjectChangedEvent[] LE;
    final int xM;

    static {
        CREATOR = new C0255b();
    }

    ParcelableEventList(int versionCode, ParcelableEvent[] events, DataHolder eventData, boolean undoRedoStateChanged, ParcelableObjectChangedEvent[] objectChangedEvents) {
        this.xM = versionCode;
        this.LB = events;
        this.LC = eventData;
        this.LD = undoRedoStateChanged;
        this.LE = objectChangedEvents;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0255b.m393a(this, dest, flags);
    }
}
