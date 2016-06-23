package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;
import java.util.List;

public class SortOrder implements SafeParcelable {
    public static final Creator<SortOrder> CREATOR;
    final List<FieldWithSortOrder> KK;
    final int xM;

    public static class Builder {
        private final List<FieldWithSortOrder> KK;

        public Builder() {
            this.KK = new ArrayList();
        }

        public Builder addSortAscending(SortableMetadataField sortField) {
            this.KK.add(new FieldWithSortOrder(sortField.getName(), true));
            return this;
        }

        public Builder addSortDescending(SortableMetadataField sortField) {
            this.KK.add(new FieldWithSortOrder(sortField.getName(), false));
            return this;
        }

        public SortOrder build() {
            return new SortOrder(null);
        }
    }

    static {
        CREATOR = new C0237b();
    }

    SortOrder(int versionCode, List<FieldWithSortOrder> sortingFields) {
        this.xM = versionCode;
        this.KK = sortingFields;
    }

    private SortOrder(List<FieldWithSortOrder> sortingFields) {
        this(1, (List) sortingFields);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0237b.m372a(this, out, flags);
    }
}
