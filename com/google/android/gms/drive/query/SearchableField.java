package com.google.android.gms.drive.query;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.iq;
import com.google.android.gms.internal.is;
import java.util.Date;

public class SearchableField {
    public static final SearchableMetadataField<Boolean> IS_PINNED;
    public static final SearchableOrderedMetadataField<Date> KI;
    public static final SearchableMetadataField<AppVisibleCustomProperties> KJ;
    public static final SearchableOrderedMetadataField<Date> LAST_VIEWED_BY_ME;
    public static final SearchableMetadataField<String> MIME_TYPE;
    public static final SearchableOrderedMetadataField<Date> MODIFIED_DATE;
    public static final SearchableCollectionMetadataField<DriveId> PARENTS;
    public static final SearchableMetadataField<Boolean> STARRED;
    public static final SearchableMetadataField<String> TITLE;
    public static final SearchableMetadataField<Boolean> TRASHED;

    static {
        TITLE = iq.Kr;
        MIME_TYPE = iq.Kk;
        TRASHED = iq.Ks;
        PARENTS = iq.Kn;
        KI = is.KA;
        STARRED = iq.Kp;
        MODIFIED_DATE = is.Ky;
        LAST_VIEWED_BY_ME = is.Kx;
        IS_PINNED = iq.Kf;
        KJ = iq.JV;
    }
}
