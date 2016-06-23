package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.C0188d;
import com.google.android.gms.common.data.DataHolder;

public final class ExperienceEventRef extends C0188d implements ExperienceEvent {
    public ExperienceEventRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public String getIconImageUrl() {
        return getString("icon_url");
    }
}
