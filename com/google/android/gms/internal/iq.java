package com.google.android.gms.internal;

import com.google.android.gms.common.data.C0636a;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.C1049b;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.C1051b;
import com.google.android.gms.drive.metadata.internal.C1053g;
import com.google.android.gms.drive.metadata.internal.C1054j;
import com.google.android.gms.drive.metadata.internal.C1055l;
import com.google.android.gms.drive.metadata.internal.C1200i;
import com.google.android.gms.drive.metadata.internal.C1201k;
import com.google.android.gms.plus.PlusShare;
import java.util.Collection;
import java.util.Collections;

public class iq {
    public static final MetadataField<DriveId> JT;
    public static final MetadataField<String> JU;
    public static final C1266a JV;
    public static final MetadataField<String> JW;
    public static final MetadataField<String> JX;
    public static final MetadataField<String> JY;
    public static final MetadataField<Long> JZ;
    public static final MetadataField<Boolean> Ka;
    public static final MetadataField<String> Kb;
    public static final MetadataField<Boolean> Kc;
    public static final MetadataField<Boolean> Kd;
    public static final MetadataField<Boolean> Ke;
    public static final C1211b Kf;
    public static final MetadataField<Boolean> Kg;
    public static final MetadataField<Boolean> Kh;
    public static final MetadataField<Boolean> Ki;
    public static final MetadataField<Boolean> Kj;
    public static final C1212c Kk;
    public static final MetadataField<String> Kl;
    public static final C1049b<String> Km;
    public static final C1267d Kn;
    public static final C1213e Ko;
    public static final C1214f Kp;
    public static final MetadataField<C0636a> Kq;
    public static final C1215g Kr;
    public static final C1216h Ks;
    public static final MetadataField<String> Kt;
    public static final MetadataField<String> Ku;
    public static final MetadataField<String> Kv;

    /* renamed from: com.google.android.gms.internal.iq.1 */
    static class C12101 extends C1054j<C0636a> {
        C12101(String str, Collection collection, Collection collection2, int i) {
            super(str, collection, collection2, i);
        }

        protected /* synthetic */ Object m4064b(DataHolder dataHolder, int i, int i2) {
            return m4065i(dataHolder, i, i2);
        }

        protected C0636a m4065i(DataHolder dataHolder, int i, int i2) {
            throw new IllegalStateException("Thumbnail field is write only");
        }
    }

    /* renamed from: com.google.android.gms.internal.iq.b */
    public static class C1211b extends C1051b implements SearchableMetadataField<Boolean> {
        public C1211b(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.iq.c */
    public static class C1212c extends C1055l implements SearchableMetadataField<String> {
        public C1212c(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.iq.e */
    public static class C1213e extends C1053g implements SortableMetadataField<Long> {
        public C1213e(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.iq.f */
    public static class C1214f extends C1051b implements SearchableMetadataField<Boolean> {
        public C1214f(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.iq.g */
    public static class C1215g extends C1055l implements SearchableMetadataField<String>, SortableMetadataField<String> {
        public C1215g(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.iq.h */
    public static class C1216h extends C1051b implements SearchableMetadataField<Boolean> {
        public C1216h(String str, int i) {
            super(str, i);
        }

        protected /* synthetic */ Object m4066b(DataHolder dataHolder, int i, int i2) {
            return m4067d(dataHolder, i, i2);
        }

        protected Boolean m4067d(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.m2010b(getName(), i, i2) != 0);
        }
    }

    /* renamed from: com.google.android.gms.internal.iq.a */
    public static class C1266a extends ir implements SearchableMetadataField<AppVisibleCustomProperties> {
        public C1266a(int i) {
            super(i);
        }
    }

    /* renamed from: com.google.android.gms.internal.iq.d */
    public static class C1267d extends C1200i<DriveId> implements SearchableCollectionMetadataField<DriveId> {
        public C1267d(String str, int i) {
            super(str, i);
        }
    }

    static {
        JT = it.KB;
        JU = new C1055l("alternateLink", 4300000);
        JV = new C1266a(5000000);
        JW = new C1055l(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 4300000);
        JX = new C1055l("embedLink", 4300000);
        JY = new C1055l("fileExtension", 4300000);
        JZ = new C1053g("fileSize", 4300000);
        Ka = new C1051b("hasThumbnail", 4300000);
        Kb = new C1055l("indexableText", 4300000);
        Kc = new C1051b("isAppData", 4300000);
        Kd = new C1051b("isCopyable", 4300000);
        Ke = new C1051b("isEditable", 4100000);
        Kf = new C1211b("isPinned", 4100000);
        Kg = new C1051b("isRestricted", 4300000);
        Kh = new C1051b("isShared", 4300000);
        Ki = new C1051b("isTrashable", 4400000);
        Kj = new C1051b("isViewed", 4300000);
        Kk = new C1212c("mimeType", 4100000);
        Kl = new C1055l("originalFilename", 4300000);
        Km = new C1201k("ownerNames", 4300000);
        Kn = new C1267d("parents", 4100000);
        Ko = new C1213e("quotaBytesUsed", 4300000);
        Kp = new C1214f("starred", 4100000);
        Kq = new C12101("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000);
        Kr = new C1215g(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 4100000);
        Ks = new C1216h("trashed", 4100000);
        Kt = new C1055l("webContentLink", 4300000);
        Ku = new C1055l("webViewLink", 4300000);
        Kv = new C1055l("uniqueIdentifier", 5000000);
    }
}
