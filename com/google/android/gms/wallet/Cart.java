package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class Cart implements SafeParcelable {
    public static final Creator<Cart> CREATOR;
    String aiK;
    String aiL;
    ArrayList<LineItem> aiM;
    private final int xM;

    public final class Builder {
        final /* synthetic */ Cart aiN;

        private Builder(Cart cart) {
            this.aiN = cart;
        }

        public Builder addLineItem(LineItem lineItem) {
            this.aiN.aiM.add(lineItem);
            return this;
        }

        public Cart build() {
            return this.aiN;
        }

        public Builder setCurrencyCode(String currencyCode) {
            this.aiN.aiL = currencyCode;
            return this;
        }

        public Builder setLineItems(List<LineItem> lineItems) {
            this.aiN.aiM.clear();
            this.aiN.aiM.addAll(lineItems);
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            this.aiN.aiK = totalPrice;
            return this;
        }
    }

    static {
        CREATOR = new C0527b();
    }

    Cart() {
        this.xM = 1;
        this.aiM = new ArrayList();
    }

    Cart(int versionCode, String totalPrice, String currencyCode, ArrayList<LineItem> lineItems) {
        this.xM = versionCode;
        this.aiK = totalPrice;
        this.aiL = currencyCode;
        this.aiM = lineItems;
    }

    public static Builder newBuilder() {
        Cart cart = new Cart();
        cart.getClass();
        return new Builder(null);
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.aiL;
    }

    public ArrayList<LineItem> getLineItems() {
        return this.aiM;
    }

    public String getTotalPrice() {
        return this.aiK;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0527b.m1751a(this, dest, flags);
    }
}
