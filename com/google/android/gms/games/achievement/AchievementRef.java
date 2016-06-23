package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.C0188d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.C0380a;
import com.google.android.gms.plus.PlusShare;

public final class AchievementRef extends C0188d implements Achievement {
    AchievementRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public String getAchievementId() {
        return getString("external_achievement_id");
    }

    public int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        gx.m1158A(z);
        return getInteger("current_steps");
    }

    public String getDescription() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
    }

    public void getDescription(CharArrayBuffer dataOut) {
        m164a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, dataOut);
    }

    public String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        gx.m1158A(z);
        return getString("formatted_current_steps");
    }

    public void getFormattedCurrentSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        gx.m1158A(z);
        m164a("formatted_current_steps", dataOut);
    }

    public String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        gx.m1158A(z);
        return getString("formatted_total_steps");
    }

    public void getFormattedTotalSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        gx.m1158A(z);
        m164a("formatted_total_steps", dataOut);
    }

    public long getLastUpdatedTimestamp() {
        return getLong("last_updated_timestamp");
    }

    public String getName() {
        return getString("name");
    }

    public void getName(CharArrayBuffer dataOut) {
        m164a("name", dataOut);
    }

    public Player getPlayer() {
        return new PlayerRef(this.DG, this.EC);
    }

    public Uri getRevealedImageUri() {
        return aw("revealed_icon_image_uri");
    }

    public String getRevealedImageUrl() {
        return getString("revealed_icon_image_url");
    }

    public int getState() {
        return getInteger("state");
    }

    public int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        gx.m1158A(z);
        return getInteger("total_steps");
    }

    public int getType() {
        return getInteger("type");
    }

    public Uri getUnlockedImageUri() {
        return aw("unlocked_icon_image_uri");
    }

    public String getUnlockedImageUrl() {
        return getString("unlocked_icon_image_url");
    }

    public long getXpValue() {
        return (!av("instance_xp_value") || ax("instance_xp_value")) ? getLong("definition_xp_value") : getLong("instance_xp_value");
    }

    public String toString() {
        C0380a a = hk.m1221e(this).m1220a("AchievementId", getAchievementId()).m1220a("Type", Integer.valueOf(getType())).m1220a("Name", getName()).m1220a("Description", getDescription()).m1220a("UnlockedImageUri", getUnlockedImageUri()).m1220a("UnlockedImageUrl", getUnlockedImageUrl()).m1220a("RevealedImageUri", getRevealedImageUri()).m1220a("RevealedImageUrl", getRevealedImageUrl()).m1220a("Player", getPlayer()).m1220a("LastUpdatedTimeStamp", Long.valueOf(getLastUpdatedTimestamp()));
        if (getType() == 1) {
            a.m1220a("CurrentSteps", Integer.valueOf(getCurrentSteps()));
            a.m1220a("TotalSteps", Integer.valueOf(getTotalSteps()));
        }
        return a.toString();
    }
}
