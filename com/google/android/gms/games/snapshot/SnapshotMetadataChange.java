package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0636a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hm;

public final class SnapshotMetadataChange implements SafeParcelable {
    public static final SnapshotMetadataChangeCreator CREATOR;
    public static final SnapshotMetadataChange EMPTY_CHANGE;
    private final String Mp;
    private final Long Ug;
    private final Uri Uh;
    private C0636a Ui;
    private final int xM;

    public static final class Builder {
        private String Mp;
        private Uri Uh;
        private Long Uj;
        private C0636a Uk;

        public SnapshotMetadataChange build() {
            return new SnapshotMetadataChange(this.Mp, this.Uj, this.Uk, this.Uh);
        }

        public Builder fromMetadata(SnapshotMetadata metadata) {
            this.Mp = metadata.getDescription();
            this.Uj = Long.valueOf(metadata.getPlayedTime());
            if (this.Uj.longValue() == -1) {
                this.Uj = null;
            }
            this.Uh = metadata.getCoverImageUri();
            if (this.Uh != null) {
                this.Uk = null;
            }
            return this;
        }

        public Builder setCoverImage(Bitmap coverImage) {
            this.Uk = new C0636a(coverImage);
            this.Uh = null;
            return this;
        }

        public Builder setDescription(String description) {
            this.Mp = description;
            return this;
        }

        public Builder setPlayedTimeMillis(long playedTimeMillis) {
            this.Uj = Long.valueOf(playedTimeMillis);
            return this;
        }
    }

    static {
        CREATOR = new SnapshotMetadataChangeCreator();
        EMPTY_CHANGE = new SnapshotMetadataChange();
    }

    SnapshotMetadataChange() {
        this(4, null, null, null, null);
    }

    SnapshotMetadataChange(int versionCode, String description, Long playedTimeMillis, C0636a coverImage, Uri coverImageUri) {
        boolean z = true;
        this.xM = versionCode;
        this.Mp = description;
        this.Ug = playedTimeMillis;
        this.Ui = coverImage;
        this.Uh = coverImageUri;
        if (this.Ui != null) {
            if (this.Uh != null) {
                z = false;
            }
            hm.m1226a(z, "Cannot set both a URI and an image");
        } else if (this.Uh != null) {
            if (this.Ui != null) {
                z = false;
            }
            hm.m1226a(z, "Cannot set both a URI and an image");
        }
    }

    SnapshotMetadataChange(String description, Long playedTimeMillis, C0636a coverImage, Uri coverImageUri) {
        this(4, description, playedTimeMillis, coverImage, coverImageUri);
    }

    public int describeContents() {
        return 0;
    }

    public Bitmap getCoverImage() {
        return this.Ui == null ? null : this.Ui.eS();
    }

    public Uri getCoverImageUri() {
        return this.Uh;
    }

    public String getDescription() {
        return this.Mp;
    }

    public Long getPlayedTimeMillis() {
        return this.Ug;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public C0636a iN() {
        return this.Ui;
    }

    public void writeToParcel(Parcel out, int flags) {
        SnapshotMetadataChangeCreator.m750a(this, out, flags);
    }
}
