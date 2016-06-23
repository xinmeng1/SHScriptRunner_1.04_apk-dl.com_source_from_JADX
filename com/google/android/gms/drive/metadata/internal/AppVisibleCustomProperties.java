package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.internal.hm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties implements SafeParcelable, Iterable<CustomProperty> {
    public static final Creator<AppVisibleCustomProperties> CREATOR;
    public static final AppVisibleCustomProperties JN;
    final List<CustomProperty> JO;
    final int xM;

    /* renamed from: com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.a */
    public static class C0230a {
        private final Map<CustomPropertyKey, CustomProperty> JP;

        public C0230a() {
            this.JP = new HashMap();
        }

        public AppVisibleCustomProperties gD() {
            return new AppVisibleCustomProperties(null);
        }
    }

    static {
        CREATOR = new C0231a();
        JN = new C0230a().gD();
    }

    AppVisibleCustomProperties(int versionCode, Collection<CustomProperty> properties) {
        this.xM = versionCode;
        hm.m1232f(properties);
        this.JO = new ArrayList(properties);
    }

    private AppVisibleCustomProperties(Collection<CustomProperty> properties) {
        this(1, (Collection) properties);
    }

    public int describeContents() {
        return 0;
    }

    public Iterator<CustomProperty> iterator() {
        return this.JO.iterator();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0231a.m367a(this, dest, flags);
    }
}
