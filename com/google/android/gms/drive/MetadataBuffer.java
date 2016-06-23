package com.google.android.gms.drive;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.C1038l;
import com.google.android.gms.drive.metadata.C1049b;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.C0233e;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.iq;
import java.util.ArrayList;
import java.util.List;

public final class MetadataBuffer extends DataBuffer<Metadata> {
    private static final String[] HR;
    private final String HS;
    private C1036a HT;

    /* renamed from: com.google.android.gms.drive.MetadataBuffer.a */
    private static class C1036a extends Metadata {
        private final DataHolder DG;
        private final int ED;
        private final int HU;

        public C1036a(DataHolder dataHolder, int i) {
            this.DG = dataHolder;
            this.HU = i;
            this.ED = dataHolder.ae(i);
        }

        protected <T> T m3199a(MetadataField<T> metadataField) {
            return metadataField.m362a(this.DG, this.HU, this.ED);
        }

        public /* synthetic */ Object freeze() {
            return gl();
        }

        public Metadata gl() {
            MetadataBundle gF = MetadataBundle.gF();
            for (MetadataField metadataField : C0233e.gE()) {
                if (!((metadataField instanceof C1049b) || metadataField == iq.Kq)) {
                    metadataField.m363a(this.DG, gF, this.HU, this.ED);
                }
            }
            return new C1038l(gF);
        }

        public boolean isDataValid() {
            return !this.DG.isClosed();
        }
    }

    static {
        List arrayList = new ArrayList();
        for (MetadataField gC : C0233e.gE()) {
            arrayList.addAll(gC.gC());
        }
        HR = (String[]) arrayList.toArray(new String[0]);
    }

    public MetadataBuffer(DataHolder dataHolder, String nextPageToken) {
        super(dataHolder);
        this.HS = nextPageToken;
        dataHolder.eU().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    public Metadata get(int row) {
        C1036a c1036a = this.HT;
        if (c1036a != null && c1036a.HU == row) {
            return c1036a;
        }
        Metadata c1036a2 = new C1036a(this.DG, row);
        this.HT = c1036a2;
        return c1036a2;
    }

    public String getNextPageToken() {
        return this.HS;
    }
}
