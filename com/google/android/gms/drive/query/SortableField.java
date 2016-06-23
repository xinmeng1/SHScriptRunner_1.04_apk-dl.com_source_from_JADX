package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.internal.iq;
import com.google.android.gms.internal.is;
import java.util.Date;

public class SortableField {
    public static final SortableMetadataField<Date> CREATED_DATE;
    public static final SortableMetadataField<Date> LAST_VIEWED_BY_ME;
    public static final SortableMetadataField<Date> MODIFIED_BY_ME_DATE;
    public static final SortableMetadataField<Date> MODIFIED_DATE;
    public static final SortableMetadataField<Long> QUOTA_USED;
    public static final SortableMetadataField<Date> SHARED_WITH_ME_DATE;
    public static final SortableMetadataField<String> TITLE;

    static {
        TITLE = iq.Kr;
        CREATED_DATE = is.Kw;
        MODIFIED_DATE = is.Ky;
        MODIFIED_BY_ME_DATE = is.Kz;
        LAST_VIEWED_BY_ME = is.Kx;
        SHARED_WITH_ME_DATE = is.KA;
        QUOTA_USED = iq.Ko;
    }
}
