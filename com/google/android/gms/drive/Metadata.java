package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.iq;
import com.google.android.gms.internal.is;
import com.google.android.gms.internal.iu;
import java.util.Date;

public abstract class Metadata implements Freezable<Metadata> {
    public static final int CONTENT_AVAILABLE_LOCALLY = 1;
    public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;

    protected abstract <T> T m2031a(MetadataField<T> metadataField);

    public String getAlternateLink() {
        return (String) m2031a(iq.JU);
    }

    public int getContentAvailability() {
        Integer num = (Integer) m2031a(iu.KC);
        return num == null ? 0 : num.intValue();
    }

    public Date getCreatedDate() {
        return (Date) m2031a(is.Kw);
    }

    public String getDescription() {
        return (String) m2031a(iq.JW);
    }

    public DriveId getDriveId() {
        return (DriveId) m2031a(iq.JT);
    }

    public String getEmbedLink() {
        return (String) m2031a(iq.JX);
    }

    public String getFileExtension() {
        return (String) m2031a(iq.JY);
    }

    public long getFileSize() {
        return ((Long) m2031a(iq.JZ)).longValue();
    }

    public Date getLastViewedByMeDate() {
        return (Date) m2031a(is.Kx);
    }

    public String getMimeType() {
        return (String) m2031a(iq.Kk);
    }

    public Date getModifiedByMeDate() {
        return (Date) m2031a(is.Kz);
    }

    public Date getModifiedDate() {
        return (Date) m2031a(is.Ky);
    }

    public String getOriginalFilename() {
        return (String) m2031a(iq.Kl);
    }

    public long getQuotaBytesUsed() {
        return ((Long) m2031a(iq.Ko)).longValue();
    }

    public Date getSharedWithMeDate() {
        return (Date) m2031a(is.KA);
    }

    public String getTitle() {
        return (String) m2031a(iq.Kr);
    }

    public String getWebContentLink() {
        return (String) m2031a(iq.Kt);
    }

    public String getWebViewLink() {
        return (String) m2031a(iq.Ku);
    }

    public boolean isEditable() {
        Boolean bool = (Boolean) m2031a(iq.Ke);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isFolder() {
        return DriveFolder.MIME_TYPE.equals(getMimeType());
    }

    public boolean isInAppFolder() {
        Boolean bool = (Boolean) m2031a(iq.Kc);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinnable() {
        Boolean bool = (Boolean) m2031a(iu.KD);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinned() {
        Boolean bool = (Boolean) m2031a(iq.Kf);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isRestricted() {
        Boolean bool = (Boolean) m2031a(iq.Kg);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isShared() {
        Boolean bool = (Boolean) m2031a(iq.Kh);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isStarred() {
        Boolean bool = (Boolean) m2031a(iq.Kp);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isTrashed() {
        Boolean bool = (Boolean) m2031a(iq.Ks);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isViewed() {
        Boolean bool = (Boolean) m2031a(iq.Kj);
        return bool == null ? false : bool.booleanValue();
    }
}
