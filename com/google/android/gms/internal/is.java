package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.C1199d;
import java.util.Date;

public class is {
    public static final C1272e KA;
    public static final C1268a Kw;
    public static final C1269b Kx;
    public static final C1271d Ky;
    public static final C1270c Kz;

    /* renamed from: com.google.android.gms.internal.is.a */
    public static class C1268a extends C1199d implements SortableMetadataField<Date> {
        public C1268a(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.is.b */
    public static class C1269b extends C1199d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public C1269b(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.is.c */
    public static class C1270c extends C1199d implements SortableMetadataField<Date> {
        public C1270c(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.is.d */
    public static class C1271d extends C1199d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public C1271d(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.is.e */
    public static class C1272e extends C1199d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public C1272e(String str, int i) {
            super(str, i);
        }
    }

    static {
        Kw = new C1268a("created", 4100000);
        Kx = new C1269b("lastOpenedTime", 4300000);
        Ky = new C1271d("modified", 4100000);
        Kz = new C1270c("modifiedByMe", 4100000);
        KA = new C1272e("sharedWithMe", 4100000);
    }
}
