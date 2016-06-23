package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.C1032e;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.ks;
import com.google.android.gms.internal.ld;

public final class PersonBuffer extends DataBuffer<Person> {
    private final C1032e<ks> adZ;

    public PersonBuffer(DataHolder dataHolder) {
        super(dataHolder);
        if (dataHolder.eU() == null || !dataHolder.eU().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.adZ = null;
        } else {
            this.adZ = new C1032e(dataHolder, ks.CREATOR);
        }
    }

    public Person get(int position) {
        return this.adZ != null ? (Person) this.adZ.ad(position) : new ld(this.DG, position);
    }
}
