package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.data.C0188d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public final class MilestoneRef extends C0188d implements Milestone {
    MilestoneRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    private long iI() {
        return getLong("initial_value");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return MilestoneEntity.m3473a(this, obj);
    }

    public Milestone freeze() {
        return new MilestoneEntity(this);
    }

    public byte[] getCompletionRewardData() {
        return getByteArray("completion_reward_data");
    }

    public long getCurrentProgress() {
        switch (getState()) {
            case DataEvent.TYPE_DELETED /*2*/:
                return getLong("current_value") - iI();
            case DetectedActivity.STILL /*3*/:
            case DetectedActivity.UNKNOWN /*4*/:
                return getTargetProgress();
            default:
                return 0;
        }
    }

    public String getEventId() {
        return getString("external_event_id");
    }

    public String getMilestoneId() {
        return getString("external_milestone_id");
    }

    public int getState() {
        return getInteger("milestone_state");
    }

    public long getTargetProgress() {
        return getLong("target_value");
    }

    public int hashCode() {
        return MilestoneEntity.m3472a(this);
    }

    public String toString() {
        return MilestoneEntity.m3474b(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((MilestoneEntity) freeze()).writeToParcel(dest, flags);
    }
}
