package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0188d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;
import java.util.List;

public final class QuestRef extends C0188d implements Quest {
    private final int RG;
    private final Game Ss;

    QuestRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.Ss = new GameRef(holder, dataRow);
        this.RG = numChildren;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return QuestEntity.m3476a(this, obj);
    }

    public Quest freeze() {
        return new QuestEntity(this);
    }

    public long getAcceptedTimestamp() {
        return getLong("accepted_ts");
    }

    public Uri getBannerImageUri() {
        return aw("quest_banner_image_uri");
    }

    public String getBannerImageUrl() {
        return getString("quest_banner_image_url");
    }

    public Milestone getCurrentMilestone() {
        return (Milestone) iJ().get(0);
    }

    public String getDescription() {
        return getString("quest_description");
    }

    public void getDescription(CharArrayBuffer dataOut) {
        m164a("quest_description", dataOut);
    }

    public long getEndTimestamp() {
        return getLong("quest_end_ts");
    }

    public Game getGame() {
        return this.Ss;
    }

    public Uri getIconImageUri() {
        return aw("quest_icon_image_uri");
    }

    public String getIconImageUrl() {
        return getString("quest_icon_image_url");
    }

    public long getLastUpdatedTimestamp() {
        return getLong("quest_last_updated_ts");
    }

    public String getName() {
        return getString("quest_name");
    }

    public void getName(CharArrayBuffer dataOut) {
        m164a("quest_name", dataOut);
    }

    public String getQuestId() {
        return getString("external_quest_id");
    }

    public long getStartTimestamp() {
        return getLong("quest_start_ts");
    }

    public int getState() {
        return getInteger("quest_state");
    }

    public int getType() {
        return getInteger("quest_type");
    }

    public int hashCode() {
        return QuestEntity.m3475a(this);
    }

    public List<Milestone> iJ() {
        List arrayList = new ArrayList(this.RG);
        for (int i = 0; i < this.RG; i++) {
            arrayList.add(new MilestoneRef(this.DG, this.EC + i));
        }
        return arrayList;
    }

    public long iK() {
        return getLong("notification_ts");
    }

    public boolean isEndingSoon() {
        return iK() <= System.currentTimeMillis() + 1800000;
    }

    public String toString() {
        return QuestEntity.m3477b(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((QuestEntity) freeze()).writeToParcel(dest, flags);
    }
}
