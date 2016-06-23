package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.common.data.h */
public class C0637h<T> extends C0187c<T> {
    private T EW;

    public C0637h(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    public T next() {
        if (hasNext()) {
            this.EB++;
            if (this.EB == 0) {
                this.EW = this.EA.get(0);
                if (!(this.EW instanceof C0188d)) {
                    throw new IllegalStateException("DataBuffer reference of type " + this.EW.getClass() + " is not movable");
                }
            }
            ((C0188d) this.EW).ac(this.EB);
            return this.EW;
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.EB);
    }
}
