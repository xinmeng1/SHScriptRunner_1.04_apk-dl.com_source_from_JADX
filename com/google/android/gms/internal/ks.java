package com.google.android.gms.internal;

import android.os.Parcel;
import android.support.v4.media.TransportMediator;
import android.support.v4.util.TimeUtils;
import com.adamioan.scriptrunner.C0127R;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.internal.hy.C0785a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ks extends hy implements SafeParcelable, Person {
    public static final kt CREATOR;
    private static final HashMap<String, C0785a<?, ?>> acr;
    private String Ar;
    private String Ln;
    private final Set<Integer> acs;
    private String adA;
    private int adB;
    private List<C1138f> adC;
    private List<C1139g> adD;
    private int adE;
    private int adF;
    private String adG;
    private List<C1140h> adH;
    private boolean adI;
    private String adq;
    private C1132a adr;
    private String ads;
    private String adt;
    private int adu;
    private C1135b adv;
    private String adw;
    private C1136c adx;
    private boolean ady;
    private C1137d adz;
    private int ml;
    private String qY;
    private String xG;
    private final int xM;

    /* renamed from: com.google.android.gms.internal.ks.e */
    public static class C0388e {
        public static int bA(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    /* renamed from: com.google.android.gms.internal.ks.a */
    public static final class C1132a extends hy implements SafeParcelable, AgeRange {
        public static final ku CREATOR;
        private static final HashMap<String, C0785a<?, ?>> acr;
        private final Set<Integer> acs;
        private int adJ;
        private int adK;
        private final int xM;

        static {
            CREATOR = new ku();
            acr = new HashMap();
            acr.put("max", C0785a.m2722g("max", 2));
            acr.put("min", C0785a.m2722g("min", 3));
        }

        public C1132a() {
            this.xM = 1;
            this.acs = new HashSet();
        }

        C1132a(Set<Integer> set, int i, int i2, int i3) {
            this.acs = set;
            this.xM = i;
            this.adJ = i2;
            this.adK = i3;
        }

        protected boolean m3699a(C0785a c0785a) {
            return this.acs.contains(Integer.valueOf(c0785a.fN()));
        }

        protected Object aF(String str) {
            return null;
        }

        protected boolean aG(String str) {
            return false;
        }

        protected Object m3700b(C0785a c0785a) {
            switch (c0785a.fN()) {
                case DataEvent.TYPE_DELETED /*2*/:
                    return Integer.valueOf(this.adJ);
                case DetectedActivity.STILL /*3*/:
                    return Integer.valueOf(this.adK);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0785a.fN());
            }
        }

        public int describeContents() {
            ku kuVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1132a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1132a c1132a = (C1132a) obj;
            for (C0785a c0785a : acr.values()) {
                if (m3699a(c0785a)) {
                    if (!c1132a.m3699a(c0785a)) {
                        return false;
                    }
                    if (!m3700b(c0785a).equals(c1132a.m3700b(c0785a))) {
                        return false;
                    }
                } else if (c1132a.m3699a(c0785a)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, C0785a<?, ?>> fG() {
            return acr;
        }

        public /* synthetic */ Object freeze() {
            return kN();
        }

        public int getMax() {
            return this.adJ;
        }

        public int getMin() {
            return this.adK;
        }

        int getVersionCode() {
            return this.xM;
        }

        public boolean hasMax() {
            return this.acs.contains(Integer.valueOf(2));
        }

        public boolean hasMin() {
            return this.acs.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (C0785a c0785a : acr.values()) {
                int hashCode;
                if (m3699a(c0785a)) {
                    hashCode = m3700b(c0785a).hashCode() + (i + c0785a.fN());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public C1132a kN() {
            return this;
        }

        Set<Integer> kk() {
            return this.acs;
        }

        public void writeToParcel(Parcel out, int flags) {
            ku kuVar = CREATOR;
            ku.m1331a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ks.b */
    public static final class C1135b extends hy implements SafeParcelable, Cover {
        public static final kv CREATOR;
        private static final HashMap<String, C0785a<?, ?>> acr;
        private final Set<Integer> acs;
        private C1133a adL;
        private C1134b adM;
        private int adN;
        private final int xM;

        /* renamed from: com.google.android.gms.internal.ks.b.a */
        public static final class C1133a extends hy implements SafeParcelable, CoverInfo {
            public static final kw CREATOR;
            private static final HashMap<String, C0785a<?, ?>> acr;
            private final Set<Integer> acs;
            private int adO;
            private int adP;
            private final int xM;

            static {
                CREATOR = new kw();
                acr = new HashMap();
                acr.put("leftImageOffset", C0785a.m2722g("leftImageOffset", 2));
                acr.put("topImageOffset", C0785a.m2722g("topImageOffset", 3));
            }

            public C1133a() {
                this.xM = 1;
                this.acs = new HashSet();
            }

            C1133a(Set<Integer> set, int i, int i2, int i3) {
                this.acs = set;
                this.xM = i;
                this.adO = i2;
                this.adP = i3;
            }

            protected boolean m3701a(C0785a c0785a) {
                return this.acs.contains(Integer.valueOf(c0785a.fN()));
            }

            protected Object aF(String str) {
                return null;
            }

            protected boolean aG(String str) {
                return false;
            }

            protected Object m3702b(C0785a c0785a) {
                switch (c0785a.fN()) {
                    case DataEvent.TYPE_DELETED /*2*/:
                        return Integer.valueOf(this.adO);
                    case DetectedActivity.STILL /*3*/:
                        return Integer.valueOf(this.adP);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + c0785a.fN());
                }
            }

            public int describeContents() {
                kw kwVar = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C1133a)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C1133a c1133a = (C1133a) obj;
                for (C0785a c0785a : acr.values()) {
                    if (m3701a(c0785a)) {
                        if (!c1133a.m3701a(c0785a)) {
                            return false;
                        }
                        if (!m3702b(c0785a).equals(c1133a.m3702b(c0785a))) {
                            return false;
                        }
                    } else if (c1133a.m3701a(c0785a)) {
                        return false;
                    }
                }
                return true;
            }

            public HashMap<String, C0785a<?, ?>> fG() {
                return acr;
            }

            public /* synthetic */ Object freeze() {
                return kR();
            }

            public int getLeftImageOffset() {
                return this.adO;
            }

            public int getTopImageOffset() {
                return this.adP;
            }

            int getVersionCode() {
                return this.xM;
            }

            public boolean hasLeftImageOffset() {
                return this.acs.contains(Integer.valueOf(2));
            }

            public boolean hasTopImageOffset() {
                return this.acs.contains(Integer.valueOf(3));
            }

            public int hashCode() {
                int i = 0;
                for (C0785a c0785a : acr.values()) {
                    int hashCode;
                    if (m3701a(c0785a)) {
                        hashCode = m3702b(c0785a).hashCode() + (i + c0785a.fN());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public boolean isDataValid() {
                return true;
            }

            public C1133a kR() {
                return this;
            }

            Set<Integer> kk() {
                return this.acs;
            }

            public void writeToParcel(Parcel out, int flags) {
                kw kwVar = CREATOR;
                kw.m1333a(this, out, flags);
            }
        }

        /* renamed from: com.google.android.gms.internal.ks.b.b */
        public static final class C1134b extends hy implements SafeParcelable, CoverPhoto {
            public static final kx CREATOR;
            private static final HashMap<String, C0785a<?, ?>> acr;
            private final Set<Integer> acs;
            private int ku;
            private int kv;
            private String qY;
            private final int xM;

            static {
                CREATOR = new kx();
                acr = new HashMap();
                acr.put("height", C0785a.m2722g("height", 2));
                acr.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0785a.m2725j(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                acr.put("width", C0785a.m2722g("width", 4));
            }

            public C1134b() {
                this.xM = 1;
                this.acs = new HashSet();
            }

            C1134b(Set<Integer> set, int i, int i2, String str, int i3) {
                this.acs = set;
                this.xM = i;
                this.kv = i2;
                this.qY = str;
                this.ku = i3;
            }

            protected boolean m3703a(C0785a c0785a) {
                return this.acs.contains(Integer.valueOf(c0785a.fN()));
            }

            protected Object aF(String str) {
                return null;
            }

            protected boolean aG(String str) {
                return false;
            }

            protected Object m3704b(C0785a c0785a) {
                switch (c0785a.fN()) {
                    case DataEvent.TYPE_DELETED /*2*/:
                        return Integer.valueOf(this.kv);
                    case DetectedActivity.STILL /*3*/:
                        return this.qY;
                    case DetectedActivity.UNKNOWN /*4*/:
                        return Integer.valueOf(this.ku);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + c0785a.fN());
                }
            }

            public int describeContents() {
                kx kxVar = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C1134b)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C1134b c1134b = (C1134b) obj;
                for (C0785a c0785a : acr.values()) {
                    if (m3703a(c0785a)) {
                        if (!c1134b.m3703a(c0785a)) {
                            return false;
                        }
                        if (!m3704b(c0785a).equals(c1134b.m3704b(c0785a))) {
                            return false;
                        }
                    } else if (c1134b.m3703a(c0785a)) {
                        return false;
                    }
                }
                return true;
            }

            public HashMap<String, C0785a<?, ?>> fG() {
                return acr;
            }

            public /* synthetic */ Object freeze() {
                return kS();
            }

            public int getHeight() {
                return this.kv;
            }

            public String getUrl() {
                return this.qY;
            }

            int getVersionCode() {
                return this.xM;
            }

            public int getWidth() {
                return this.ku;
            }

            public boolean hasHeight() {
                return this.acs.contains(Integer.valueOf(2));
            }

            public boolean hasUrl() {
                return this.acs.contains(Integer.valueOf(3));
            }

            public boolean hasWidth() {
                return this.acs.contains(Integer.valueOf(4));
            }

            public int hashCode() {
                int i = 0;
                for (C0785a c0785a : acr.values()) {
                    int hashCode;
                    if (m3703a(c0785a)) {
                        hashCode = m3704b(c0785a).hashCode() + (i + c0785a.fN());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public boolean isDataValid() {
                return true;
            }

            public C1134b kS() {
                return this;
            }

            Set<Integer> kk() {
                return this.acs;
            }

            public void writeToParcel(Parcel out, int flags) {
                kx kxVar = CREATOR;
                kx.m1334a(this, out, flags);
            }
        }

        static {
            CREATOR = new kv();
            acr = new HashMap();
            acr.put("coverInfo", C0785a.m2719a("coverInfo", 2, C1133a.class));
            acr.put("coverPhoto", C0785a.m2719a("coverPhoto", 3, C1134b.class));
            acr.put("layout", C0785a.m2718a("layout", 4, new hv().m2716f("banner", 0), false));
        }

        public C1135b() {
            this.xM = 1;
            this.acs = new HashSet();
        }

        C1135b(Set<Integer> set, int i, C1133a c1133a, C1134b c1134b, int i2) {
            this.acs = set;
            this.xM = i;
            this.adL = c1133a;
            this.adM = c1134b;
            this.adN = i2;
        }

        protected boolean m3705a(C0785a c0785a) {
            return this.acs.contains(Integer.valueOf(c0785a.fN()));
        }

        protected Object aF(String str) {
            return null;
        }

        protected boolean aG(String str) {
            return false;
        }

        protected Object m3706b(C0785a c0785a) {
            switch (c0785a.fN()) {
                case DataEvent.TYPE_DELETED /*2*/:
                    return this.adL;
                case DetectedActivity.STILL /*3*/:
                    return this.adM;
                case DetectedActivity.UNKNOWN /*4*/:
                    return Integer.valueOf(this.adN);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0785a.fN());
            }
        }

        public int describeContents() {
            kv kvVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1135b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1135b c1135b = (C1135b) obj;
            for (C0785a c0785a : acr.values()) {
                if (m3705a(c0785a)) {
                    if (!c1135b.m3705a(c0785a)) {
                        return false;
                    }
                    if (!m3706b(c0785a).equals(c1135b.m3706b(c0785a))) {
                        return false;
                    }
                } else if (c1135b.m3705a(c0785a)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, C0785a<?, ?>> fG() {
            return acr;
        }

        public /* synthetic */ Object freeze() {
            return kQ();
        }

        public CoverInfo getCoverInfo() {
            return this.adL;
        }

        public CoverPhoto getCoverPhoto() {
            return this.adM;
        }

        public int getLayout() {
            return this.adN;
        }

        int getVersionCode() {
            return this.xM;
        }

        public boolean hasCoverInfo() {
            return this.acs.contains(Integer.valueOf(2));
        }

        public boolean hasCoverPhoto() {
            return this.acs.contains(Integer.valueOf(3));
        }

        public boolean hasLayout() {
            return this.acs.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (C0785a c0785a : acr.values()) {
                int hashCode;
                if (m3705a(c0785a)) {
                    hashCode = m3706b(c0785a).hashCode() + (i + c0785a.fN());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        C1133a kO() {
            return this.adL;
        }

        C1134b kP() {
            return this.adM;
        }

        public C1135b kQ() {
            return this;
        }

        Set<Integer> kk() {
            return this.acs;
        }

        public void writeToParcel(Parcel out, int flags) {
            kv kvVar = CREATOR;
            kv.m1332a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ks.c */
    public static final class C1136c extends hy implements SafeParcelable, Image {
        public static final ky CREATOR;
        private static final HashMap<String, C0785a<?, ?>> acr;
        private final Set<Integer> acs;
        private String qY;
        private final int xM;

        static {
            CREATOR = new ky();
            acr = new HashMap();
            acr.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0785a.m2725j(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public C1136c() {
            this.xM = 1;
            this.acs = new HashSet();
        }

        public C1136c(String str) {
            this.acs = new HashSet();
            this.xM = 1;
            this.qY = str;
            this.acs.add(Integer.valueOf(2));
        }

        C1136c(Set<Integer> set, int i, String str) {
            this.acs = set;
            this.xM = i;
            this.qY = str;
        }

        protected boolean m3707a(C0785a c0785a) {
            return this.acs.contains(Integer.valueOf(c0785a.fN()));
        }

        protected Object aF(String str) {
            return null;
        }

        protected boolean aG(String str) {
            return false;
        }

        protected Object m3708b(C0785a c0785a) {
            switch (c0785a.fN()) {
                case DataEvent.TYPE_DELETED /*2*/:
                    return this.qY;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0785a.fN());
            }
        }

        public int describeContents() {
            ky kyVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1136c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1136c c1136c = (C1136c) obj;
            for (C0785a c0785a : acr.values()) {
                if (m3707a(c0785a)) {
                    if (!c1136c.m3707a(c0785a)) {
                        return false;
                    }
                    if (!m3708b(c0785a).equals(c1136c.m3708b(c0785a))) {
                        return false;
                    }
                } else if (c1136c.m3707a(c0785a)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, C0785a<?, ?>> fG() {
            return acr;
        }

        public /* synthetic */ Object freeze() {
            return kT();
        }

        public String getUrl() {
            return this.qY;
        }

        int getVersionCode() {
            return this.xM;
        }

        public boolean hasUrl() {
            return this.acs.contains(Integer.valueOf(2));
        }

        public int hashCode() {
            int i = 0;
            for (C0785a c0785a : acr.values()) {
                int hashCode;
                if (m3707a(c0785a)) {
                    hashCode = m3708b(c0785a).hashCode() + (i + c0785a.fN());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public C1136c kT() {
            return this;
        }

        Set<Integer> kk() {
            return this.acs;
        }

        public void writeToParcel(Parcel out, int flags) {
            ky kyVar = CREATOR;
            ky.m1335a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ks.d */
    public static final class C1137d extends hy implements SafeParcelable, Name {
        public static final kz CREATOR;
        private static final HashMap<String, C0785a<?, ?>> acr;
        private String acQ;
        private String acT;
        private final Set<Integer> acs;
        private String adQ;
        private String adR;
        private String adS;
        private String adT;
        private final int xM;

        static {
            CREATOR = new kz();
            acr = new HashMap();
            acr.put("familyName", C0785a.m2725j("familyName", 2));
            acr.put("formatted", C0785a.m2725j("formatted", 3));
            acr.put("givenName", C0785a.m2725j("givenName", 4));
            acr.put("honorificPrefix", C0785a.m2725j("honorificPrefix", 5));
            acr.put("honorificSuffix", C0785a.m2725j("honorificSuffix", 6));
            acr.put("middleName", C0785a.m2725j("middleName", 7));
        }

        public C1137d() {
            this.xM = 1;
            this.acs = new HashSet();
        }

        C1137d(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.acs = set;
            this.xM = i;
            this.acQ = str;
            this.adQ = str2;
            this.acT = str3;
            this.adR = str4;
            this.adS = str5;
            this.adT = str6;
        }

        protected boolean m3709a(C0785a c0785a) {
            return this.acs.contains(Integer.valueOf(c0785a.fN()));
        }

        protected Object aF(String str) {
            return null;
        }

        protected boolean aG(String str) {
            return false;
        }

        protected Object m3710b(C0785a c0785a) {
            switch (c0785a.fN()) {
                case DataEvent.TYPE_DELETED /*2*/:
                    return this.acQ;
                case DetectedActivity.STILL /*3*/:
                    return this.adQ;
                case DetectedActivity.UNKNOWN /*4*/:
                    return this.acT;
                case DetectedActivity.TILTING /*5*/:
                    return this.adR;
                case Quest.STATE_FAILED /*6*/:
                    return this.adS;
                case DetectedActivity.WALKING /*7*/:
                    return this.adT;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0785a.fN());
            }
        }

        public int describeContents() {
            kz kzVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1137d)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1137d c1137d = (C1137d) obj;
            for (C0785a c0785a : acr.values()) {
                if (m3709a(c0785a)) {
                    if (!c1137d.m3709a(c0785a)) {
                        return false;
                    }
                    if (!m3710b(c0785a).equals(c1137d.m3710b(c0785a))) {
                        return false;
                    }
                } else if (c1137d.m3709a(c0785a)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, C0785a<?, ?>> fG() {
            return acr;
        }

        public /* synthetic */ Object freeze() {
            return kU();
        }

        public String getFamilyName() {
            return this.acQ;
        }

        public String getFormatted() {
            return this.adQ;
        }

        public String getGivenName() {
            return this.acT;
        }

        public String getHonorificPrefix() {
            return this.adR;
        }

        public String getHonorificSuffix() {
            return this.adS;
        }

        public String getMiddleName() {
            return this.adT;
        }

        int getVersionCode() {
            return this.xM;
        }

        public boolean hasFamilyName() {
            return this.acs.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted() {
            return this.acs.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName() {
            return this.acs.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix() {
            return this.acs.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix() {
            return this.acs.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName() {
            return this.acs.contains(Integer.valueOf(7));
        }

        public int hashCode() {
            int i = 0;
            for (C0785a c0785a : acr.values()) {
                int hashCode;
                if (m3709a(c0785a)) {
                    hashCode = m3710b(c0785a).hashCode() + (i + c0785a.fN());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public C1137d kU() {
            return this;
        }

        Set<Integer> kk() {
            return this.acs;
        }

        public void writeToParcel(Parcel out, int flags) {
            kz kzVar = CREATOR;
            kz.m1336a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ks.f */
    public static final class C1138f extends hy implements SafeParcelable, Organizations {
        public static final la CREATOR;
        private static final HashMap<String, C0785a<?, ?>> acr;
        private int AT;
        private String HY;
        private String Mp;
        private String acP;
        private final Set<Integer> acs;
        private String adU;
        private String adV;
        private boolean adW;
        private String adf;
        private String mName;
        private final int xM;

        static {
            CREATOR = new la();
            acr = new HashMap();
            acr.put("department", C0785a.m2725j("department", 2));
            acr.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, C0785a.m2725j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            acr.put("endDate", C0785a.m2725j("endDate", 4));
            acr.put("location", C0785a.m2725j("location", 5));
            acr.put("name", C0785a.m2725j("name", 6));
            acr.put("primary", C0785a.m2724i("primary", 7));
            acr.put("startDate", C0785a.m2725j("startDate", 8));
            acr.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, C0785a.m2725j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            acr.put("type", C0785a.m2718a("type", 10, new hv().m2716f("work", 0).m2716f("school", 1), false));
        }

        public C1138f() {
            this.xM = 1;
            this.acs = new HashSet();
        }

        C1138f(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.acs = set;
            this.xM = i;
            this.adU = str;
            this.Mp = str2;
            this.acP = str3;
            this.adV = str4;
            this.mName = str5;
            this.adW = z;
            this.adf = str6;
            this.HY = str7;
            this.AT = i2;
        }

        protected boolean m3711a(C0785a c0785a) {
            return this.acs.contains(Integer.valueOf(c0785a.fN()));
        }

        protected Object aF(String str) {
            return null;
        }

        protected boolean aG(String str) {
            return false;
        }

        protected Object m3712b(C0785a c0785a) {
            switch (c0785a.fN()) {
                case DataEvent.TYPE_DELETED /*2*/:
                    return this.adU;
                case DetectedActivity.STILL /*3*/:
                    return this.Mp;
                case DetectedActivity.UNKNOWN /*4*/:
                    return this.acP;
                case DetectedActivity.TILTING /*5*/:
                    return this.adV;
                case Quest.STATE_FAILED /*6*/:
                    return this.mName;
                case DetectedActivity.WALKING /*7*/:
                    return Boolean.valueOf(this.adW);
                case DetectedActivity.RUNNING /*8*/:
                    return this.adf;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    return this.HY;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    return Integer.valueOf(this.AT);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0785a.fN());
            }
        }

        public int describeContents() {
            la laVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1138f)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1138f c1138f = (C1138f) obj;
            for (C0785a c0785a : acr.values()) {
                if (m3711a(c0785a)) {
                    if (!c1138f.m3711a(c0785a)) {
                        return false;
                    }
                    if (!m3712b(c0785a).equals(c1138f.m3712b(c0785a))) {
                        return false;
                    }
                } else if (c1138f.m3711a(c0785a)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, C0785a<?, ?>> fG() {
            return acr;
        }

        public /* synthetic */ Object freeze() {
            return kV();
        }

        public String getDepartment() {
            return this.adU;
        }

        public String getDescription() {
            return this.Mp;
        }

        public String getEndDate() {
            return this.acP;
        }

        public String getLocation() {
            return this.adV;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.adf;
        }

        public String getTitle() {
            return this.HY;
        }

        public int getType() {
            return this.AT;
        }

        int getVersionCode() {
            return this.xM;
        }

        public boolean hasDepartment() {
            return this.acs.contains(Integer.valueOf(2));
        }

        public boolean hasDescription() {
            return this.acs.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate() {
            return this.acs.contains(Integer.valueOf(4));
        }

        public boolean hasLocation() {
            return this.acs.contains(Integer.valueOf(5));
        }

        public boolean hasName() {
            return this.acs.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary() {
            return this.acs.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate() {
            return this.acs.contains(Integer.valueOf(8));
        }

        public boolean hasTitle() {
            return this.acs.contains(Integer.valueOf(9));
        }

        public boolean hasType() {
            return this.acs.contains(Integer.valueOf(10));
        }

        public int hashCode() {
            int i = 0;
            for (C0785a c0785a : acr.values()) {
                int hashCode;
                if (m3711a(c0785a)) {
                    hashCode = m3712b(c0785a).hashCode() + (i + c0785a.fN());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.adW;
        }

        public C1138f kV() {
            return this;
        }

        Set<Integer> kk() {
            return this.acs;
        }

        public void writeToParcel(Parcel out, int flags) {
            la laVar = CREATOR;
            la.m1337a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ks.g */
    public static final class C1139g extends hy implements SafeParcelable, PlacesLived {
        public static final lb CREATOR;
        private static final HashMap<String, C0785a<?, ?>> acr;
        private final Set<Integer> acs;
        private boolean adW;
        private String mValue;
        private final int xM;

        static {
            CREATOR = new lb();
            acr = new HashMap();
            acr.put("primary", C0785a.m2724i("primary", 2));
            acr.put("value", C0785a.m2725j("value", 3));
        }

        public C1139g() {
            this.xM = 1;
            this.acs = new HashSet();
        }

        C1139g(Set<Integer> set, int i, boolean z, String str) {
            this.acs = set;
            this.xM = i;
            this.adW = z;
            this.mValue = str;
        }

        protected boolean m3713a(C0785a c0785a) {
            return this.acs.contains(Integer.valueOf(c0785a.fN()));
        }

        protected Object aF(String str) {
            return null;
        }

        protected boolean aG(String str) {
            return false;
        }

        protected Object m3714b(C0785a c0785a) {
            switch (c0785a.fN()) {
                case DataEvent.TYPE_DELETED /*2*/:
                    return Boolean.valueOf(this.adW);
                case DetectedActivity.STILL /*3*/:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0785a.fN());
            }
        }

        public int describeContents() {
            lb lbVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1139g)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1139g c1139g = (C1139g) obj;
            for (C0785a c0785a : acr.values()) {
                if (m3713a(c0785a)) {
                    if (!c1139g.m3713a(c0785a)) {
                        return false;
                    }
                    if (!m3714b(c0785a).equals(c1139g.m3714b(c0785a))) {
                        return false;
                    }
                } else if (c1139g.m3713a(c0785a)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, C0785a<?, ?>> fG() {
            return acr;
        }

        public /* synthetic */ Object freeze() {
            return kW();
        }

        public String getValue() {
            return this.mValue;
        }

        int getVersionCode() {
            return this.xM;
        }

        public boolean hasPrimary() {
            return this.acs.contains(Integer.valueOf(2));
        }

        public boolean hasValue() {
            return this.acs.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (C0785a c0785a : acr.values()) {
                int hashCode;
                if (m3713a(c0785a)) {
                    hashCode = m3714b(c0785a).hashCode() + (i + c0785a.fN());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.adW;
        }

        public C1139g kW() {
            return this;
        }

        Set<Integer> kk() {
            return this.acs;
        }

        public void writeToParcel(Parcel out, int flags) {
            lb lbVar = CREATOR;
            lb.m1338a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ks.h */
    public static final class C1140h extends hy implements SafeParcelable, Urls {
        public static final lc CREATOR;
        private static final HashMap<String, C0785a<?, ?>> acr;
        private int AT;
        private final Set<Integer> acs;
        private String adX;
        private final int adY;
        private String mValue;
        private final int xM;

        static {
            CREATOR = new lc();
            acr = new HashMap();
            acr.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, C0785a.m2725j(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            acr.put("type", C0785a.m2718a("type", 6, new hv().m2716f("home", 0).m2716f("work", 1).m2716f("blog", 2).m2716f(Scopes.PROFILE, 3).m2716f("other", 4).m2716f("otherProfile", 5).m2716f("contributor", 6).m2716f("website", 7), false));
            acr.put("value", C0785a.m2725j("value", 4));
        }

        public C1140h() {
            this.adY = 4;
            this.xM = 2;
            this.acs = new HashSet();
        }

        C1140h(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.adY = 4;
            this.acs = set;
            this.xM = i;
            this.adX = str;
            this.AT = i2;
            this.mValue = str2;
        }

        protected boolean m3715a(C0785a c0785a) {
            return this.acs.contains(Integer.valueOf(c0785a.fN()));
        }

        protected Object aF(String str) {
            return null;
        }

        protected boolean aG(String str) {
            return false;
        }

        protected Object m3716b(C0785a c0785a) {
            switch (c0785a.fN()) {
                case DetectedActivity.UNKNOWN /*4*/:
                    return this.mValue;
                case DetectedActivity.TILTING /*5*/:
                    return this.adX;
                case Quest.STATE_FAILED /*6*/:
                    return Integer.valueOf(this.AT);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0785a.fN());
            }
        }

        public int describeContents() {
            lc lcVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1140h)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1140h c1140h = (C1140h) obj;
            for (C0785a c0785a : acr.values()) {
                if (m3715a(c0785a)) {
                    if (!c1140h.m3715a(c0785a)) {
                        return false;
                    }
                    if (!m3716b(c0785a).equals(c1140h.m3716b(c0785a))) {
                        return false;
                    }
                } else if (c1140h.m3715a(c0785a)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, C0785a<?, ?>> fG() {
            return acr;
        }

        public /* synthetic */ Object freeze() {
            return kY();
        }

        public String getLabel() {
            return this.adX;
        }

        public int getType() {
            return this.AT;
        }

        public String getValue() {
            return this.mValue;
        }

        int getVersionCode() {
            return this.xM;
        }

        public boolean hasLabel() {
            return this.acs.contains(Integer.valueOf(5));
        }

        public boolean hasType() {
            return this.acs.contains(Integer.valueOf(6));
        }

        public boolean hasValue() {
            return this.acs.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (C0785a c0785a : acr.values()) {
                int hashCode;
                if (m3715a(c0785a)) {
                    hashCode = m3716b(c0785a).hashCode() + (i + c0785a.fN());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        @Deprecated
        public int kX() {
            return 4;
        }

        public C1140h kY() {
            return this;
        }

        Set<Integer> kk() {
            return this.acs;
        }

        public void writeToParcel(Parcel out, int flags) {
            lc lcVar = CREATOR;
            lc.m1339a(this, out, flags);
        }
    }

    static {
        CREATOR = new kt();
        acr = new HashMap();
        acr.put("aboutMe", C0785a.m2725j("aboutMe", 2));
        acr.put("ageRange", C0785a.m2719a("ageRange", 3, C1132a.class));
        acr.put("birthday", C0785a.m2725j("birthday", 4));
        acr.put("braggingRights", C0785a.m2725j("braggingRights", 5));
        acr.put("circledByCount", C0785a.m2722g("circledByCount", 6));
        acr.put("cover", C0785a.m2719a("cover", 7, C1135b.class));
        acr.put("currentLocation", C0785a.m2725j("currentLocation", 8));
        acr.put("displayName", C0785a.m2725j("displayName", 9));
        acr.put("gender", C0785a.m2718a("gender", 12, new hv().m2716f("male", 0).m2716f("female", 1).m2716f("other", 2), false));
        acr.put("id", C0785a.m2725j("id", 14));
        acr.put("image", C0785a.m2719a("image", 15, C1136c.class));
        acr.put("isPlusUser", C0785a.m2724i("isPlusUser", 16));
        acr.put("language", C0785a.m2725j("language", 18));
        acr.put("name", C0785a.m2719a("name", 19, C1137d.class));
        acr.put("nickname", C0785a.m2725j("nickname", 20));
        acr.put("objectType", C0785a.m2718a("objectType", 21, new hv().m2716f("person", 0).m2716f("page", 1), false));
        acr.put("organizations", C0785a.m2720b("organizations", 22, C1138f.class));
        acr.put("placesLived", C0785a.m2720b("placesLived", 23, C1139g.class));
        acr.put("plusOneCount", C0785a.m2722g("plusOneCount", 24));
        acr.put("relationshipStatus", C0785a.m2718a("relationshipStatus", 25, new hv().m2716f("single", 0).m2716f("in_a_relationship", 1).m2716f("engaged", 2).m2716f("married", 3).m2716f("its_complicated", 4).m2716f("open_relationship", 5).m2716f("widowed", 6).m2716f("in_domestic_partnership", 7).m2716f("in_civil_union", 8), false));
        acr.put("tagline", C0785a.m2725j("tagline", 26));
        acr.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0785a.m2725j(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        acr.put("urls", C0785a.m2720b("urls", 28, C1140h.class));
        acr.put("verified", C0785a.m2724i("verified", 29));
    }

    public ks() {
        this.xM = 2;
        this.acs = new HashSet();
    }

    public ks(String str, String str2, C1136c c1136c, int i, String str3) {
        this.xM = 2;
        this.acs = new HashSet();
        this.Ln = str;
        this.acs.add(Integer.valueOf(9));
        this.xG = str2;
        this.acs.add(Integer.valueOf(14));
        this.adx = c1136c;
        this.acs.add(Integer.valueOf(15));
        this.adB = i;
        this.acs.add(Integer.valueOf(21));
        this.qY = str3;
        this.acs.add(Integer.valueOf(27));
    }

    ks(Set<Integer> set, int i, String str, C1132a c1132a, String str2, String str3, int i2, C1135b c1135b, String str4, String str5, int i3, String str6, C1136c c1136c, boolean z, String str7, C1137d c1137d, String str8, int i4, List<C1138f> list, List<C1139g> list2, int i5, int i6, String str9, String str10, List<C1140h> list3, boolean z2) {
        this.acs = set;
        this.xM = i;
        this.adq = str;
        this.adr = c1132a;
        this.ads = str2;
        this.adt = str3;
        this.adu = i2;
        this.adv = c1135b;
        this.adw = str4;
        this.Ln = str5;
        this.ml = i3;
        this.xG = str6;
        this.adx = c1136c;
        this.ady = z;
        this.Ar = str7;
        this.adz = c1137d;
        this.adA = str8;
        this.adB = i4;
        this.adC = list;
        this.adD = list2;
        this.adE = i5;
        this.adF = i6;
        this.adG = str9;
        this.qY = str10;
        this.adH = list3;
        this.adI = z2;
    }

    public static ks m3717i(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        ks bG = CREATOR.bG(obtain);
        obtain.recycle();
        return bG;
    }

    protected boolean m3718a(C0785a c0785a) {
        return this.acs.contains(Integer.valueOf(c0785a.fN()));
    }

    protected Object aF(String str) {
        return null;
    }

    protected boolean aG(String str) {
        return false;
    }

    protected Object m3719b(C0785a c0785a) {
        switch (c0785a.fN()) {
            case DataEvent.TYPE_DELETED /*2*/:
                return this.adq;
            case DetectedActivity.STILL /*3*/:
                return this.adr;
            case DetectedActivity.UNKNOWN /*4*/:
                return this.ads;
            case DetectedActivity.TILTING /*5*/:
                return this.adt;
            case Quest.STATE_FAILED /*6*/:
                return Integer.valueOf(this.adu);
            case DetectedActivity.WALKING /*7*/:
                return this.adv;
            case DetectedActivity.RUNNING /*8*/:
                return this.adw;
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                return this.Ln;
            case CommonStatusCodes.DATE_INVALID /*12*/:
                return Integer.valueOf(this.ml);
            case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                return this.xG;
            case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                return this.adx;
            case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                return Boolean.valueOf(this.ady);
            case C0127R.styleable.ActionBar_itemPadding /*18*/:
                return this.Ar;
            case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                return this.adz;
            case 20:
                return this.adA;
            case 21:
                return Integer.valueOf(this.adB);
            case 22:
                return this.adC;
            case 23:
                return this.adD;
            case 24:
                return Integer.valueOf(this.adE);
            case 25:
                return Integer.valueOf(this.adF);
            case 26:
                return this.adG;
            case 27:
                return this.qY;
            case 28:
                return this.adH;
            case 29:
                return Boolean.valueOf(this.adI);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + c0785a.fN());
        }
    }

    public int describeContents() {
        kt ktVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ks)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ks ksVar = (ks) obj;
        for (C0785a c0785a : acr.values()) {
            if (m3718a(c0785a)) {
                if (!ksVar.m3718a(c0785a)) {
                    return false;
                }
                if (!m3719b(c0785a).equals(ksVar.m3719b(c0785a))) {
                    return false;
                }
            } else if (ksVar.m3718a(c0785a)) {
                return false;
            }
        }
        return true;
    }

    public HashMap<String, C0785a<?, ?>> fG() {
        return acr;
    }

    public /* synthetic */ Object freeze() {
        return kM();
    }

    public String getAboutMe() {
        return this.adq;
    }

    public AgeRange getAgeRange() {
        return this.adr;
    }

    public String getBirthday() {
        return this.ads;
    }

    public String getBraggingRights() {
        return this.adt;
    }

    public int getCircledByCount() {
        return this.adu;
    }

    public Cover getCover() {
        return this.adv;
    }

    public String getCurrentLocation() {
        return this.adw;
    }

    public String getDisplayName() {
        return this.Ln;
    }

    public int getGender() {
        return this.ml;
    }

    public String getId() {
        return this.xG;
    }

    public Image getImage() {
        return this.adx;
    }

    public String getLanguage() {
        return this.Ar;
    }

    public Name getName() {
        return this.adz;
    }

    public String getNickname() {
        return this.adA;
    }

    public int getObjectType() {
        return this.adB;
    }

    public List<Organizations> getOrganizations() {
        return (ArrayList) this.adC;
    }

    public List<PlacesLived> getPlacesLived() {
        return (ArrayList) this.adD;
    }

    public int getPlusOneCount() {
        return this.adE;
    }

    public int getRelationshipStatus() {
        return this.adF;
    }

    public String getTagline() {
        return this.adG;
    }

    public String getUrl() {
        return this.qY;
    }

    public List<Urls> getUrls() {
        return (ArrayList) this.adH;
    }

    int getVersionCode() {
        return this.xM;
    }

    public boolean hasAboutMe() {
        return this.acs.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange() {
        return this.acs.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday() {
        return this.acs.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights() {
        return this.acs.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount() {
        return this.acs.contains(Integer.valueOf(6));
    }

    public boolean hasCover() {
        return this.acs.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation() {
        return this.acs.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName() {
        return this.acs.contains(Integer.valueOf(9));
    }

    public boolean hasGender() {
        return this.acs.contains(Integer.valueOf(12));
    }

    public boolean hasId() {
        return this.acs.contains(Integer.valueOf(14));
    }

    public boolean hasImage() {
        return this.acs.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser() {
        return this.acs.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage() {
        return this.acs.contains(Integer.valueOf(18));
    }

    public boolean hasName() {
        return this.acs.contains(Integer.valueOf(19));
    }

    public boolean hasNickname() {
        return this.acs.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType() {
        return this.acs.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations() {
        return this.acs.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived() {
        return this.acs.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount() {
        return this.acs.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus() {
        return this.acs.contains(Integer.valueOf(25));
    }

    public boolean hasTagline() {
        return this.acs.contains(Integer.valueOf(26));
    }

    public boolean hasUrl() {
        return this.acs.contains(Integer.valueOf(27));
    }

    public boolean hasUrls() {
        return this.acs.contains(Integer.valueOf(28));
    }

    public boolean hasVerified() {
        return this.acs.contains(Integer.valueOf(29));
    }

    public int hashCode() {
        int i = 0;
        for (C0785a c0785a : acr.values()) {
            int hashCode;
            if (m3718a(c0785a)) {
                hashCode = m3719b(c0785a).hashCode() + (i + c0785a.fN());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isPlusUser() {
        return this.ady;
    }

    public boolean isVerified() {
        return this.adI;
    }

    C1132a kF() {
        return this.adr;
    }

    C1135b kG() {
        return this.adv;
    }

    C1136c kH() {
        return this.adx;
    }

    C1137d kI() {
        return this.adz;
    }

    List<C1138f> kJ() {
        return this.adC;
    }

    List<C1139g> kK() {
        return this.adD;
    }

    List<C1140h> kL() {
        return this.adH;
    }

    public ks kM() {
        return this;
    }

    Set<Integer> kk() {
        return this.acs;
    }

    public void writeToParcel(Parcel out, int flags) {
        kt ktVar = CREATOR;
        kt.m1330a(this, out, flags);
    }
}
