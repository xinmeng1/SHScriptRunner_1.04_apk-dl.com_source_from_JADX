package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hm;

public final class NotifyTransactionStatusRequest implements SafeParcelable {
    public static final Creator<NotifyTransactionStatusRequest> CREATOR;
    String aiQ;
    String ajR;
    int status;
    final int xM;

    public final class Builder {
        final /* synthetic */ NotifyTransactionStatusRequest ajS;

        private Builder(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
            this.ajS = notifyTransactionStatusRequest;
        }

        public NotifyTransactionStatusRequest build() {
            boolean z = true;
            hm.m1230b(!TextUtils.isEmpty(this.ajS.aiQ), (Object) "googleTransactionId is required");
            if (this.ajS.status < 1 || this.ajS.status > 8) {
                z = false;
            }
            hm.m1230b(z, (Object) "status is an unrecognized value");
            return this.ajS;
        }

        public Builder setDetailedReason(String detailedReason) {
            this.ajS.ajR = detailedReason;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            this.ajS.aiQ = googleTransactionId;
            return this;
        }

        public Builder setStatus(int status) {
            this.ajS.status = status;
            return this;
        }
    }

    public interface Status {
        public static final int SUCCESS = 1;

        public interface Error {
            public static final int AVS_DECLINE = 7;
            public static final int BAD_CARD = 4;
            public static final int BAD_CVC = 3;
            public static final int DECLINED = 5;
            public static final int FRAUD_DECLINE = 8;
            public static final int OTHER = 6;
            public static final int UNKNOWN = 2;
        }
    }

    static {
        CREATOR = new C0544m();
    }

    NotifyTransactionStatusRequest() {
        this.xM = 1;
    }

    NotifyTransactionStatusRequest(int versionCode, String googleTransactionId, int status, String detailedReason) {
        this.xM = versionCode;
        this.aiQ = googleTransactionId;
        this.status = status;
        this.ajR = detailedReason;
    }

    public static Builder newBuilder() {
        NotifyTransactionStatusRequest notifyTransactionStatusRequest = new NotifyTransactionStatusRequest();
        notifyTransactionStatusRequest.getClass();
        return new Builder(null);
    }

    public int describeContents() {
        return 0;
    }

    public String getDetailedReason() {
        return this.ajR;
    }

    public String getGoogleTransactionId() {
        return this.aiQ;
    }

    public int getStatus() {
        return this.status;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0544m.m1784a(this, out, flags);
    }
}
