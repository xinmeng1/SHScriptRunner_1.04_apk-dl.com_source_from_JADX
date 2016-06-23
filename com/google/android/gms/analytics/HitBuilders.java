package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.C0166u.C0165a;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HitBuilders {

    protected static class HitBuilder<T extends HitBuilder> {
        ProductAction wA;
        Map<String, List<Product>> wB;
        List<Promotion> wC;
        List<Product> wD;
        private Map<String, String> wz;

        protected HitBuilder() {
            this.wz = new HashMap();
            this.wB = new HashMap();
            this.wC = new ArrayList();
            this.wD = new ArrayList();
        }

        public T addImpression(Product product, String impressionList) {
            if (product == null) {
                aa.m40D("product should be non-null");
            } else {
                if (impressionList == null) {
                    impressionList = "";
                }
                if (!this.wB.containsKey(impressionList)) {
                    this.wB.put(impressionList, new ArrayList());
                }
                ((List) this.wB.get(impressionList)).add(product);
            }
            return this;
        }

        public T addProduct(Product product) {
            if (product == null) {
                aa.m40D("product should be non-null");
            } else {
                this.wD.add(product);
            }
            return this;
        }

        public T addPromotion(Promotion promotion) {
            if (promotion == null) {
                aa.m40D("promotion should be non-null");
            } else {
                this.wC.add(promotion);
            }
            return this;
        }

        public Map<String, String> build() {
            Map<String, String> hashMap = new HashMap(this.wz);
            if (this.wA != null) {
                hashMap.putAll(this.wA.build());
            }
            int i = 1;
            for (Promotion X : this.wC) {
                hashMap.putAll(X.m61X(C0150o.m75v(i)));
                i++;
            }
            i = 1;
            for (Product X2 : this.wD) {
                hashMap.putAll(X2.m60X(C0150o.m74u(i)));
                i++;
            }
            int i2 = 1;
            for (Entry entry : this.wB.entrySet()) {
                List<Product> list = (List) entry.getValue();
                String x = C0150o.m77x(i2);
                int i3 = 1;
                for (Product X3 : list) {
                    hashMap.putAll(X3.m60X(x + C0150o.m76w(i3)));
                    i3++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                    hashMap.put(x + "nm", entry.getKey());
                }
                i2++;
            }
            return hashMap;
        }

        protected String get(String paramName) {
            return (String) this.wz.get(paramName);
        }

        public final T set(String paramName, String paramValue) {
            C0166u.cU().m83a(C0165a.MAP_BUILDER_SET);
            if (paramName != null) {
                this.wz.put(paramName, paramValue);
            } else {
                aa.m40D(" HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        public final T setAll(Map<String, String> params) {
            C0166u.cU().m83a(C0165a.MAP_BUILDER_SET_ALL);
            if (params != null) {
                this.wz.putAll(new HashMap(params));
            }
            return this;
        }

        public T setCampaignParamsFromUrl(String utmParams) {
            C0166u.cU().m83a(C0165a.MAP_BUILDER_SET_CAMPAIGN_PARAMS);
            Object V = ak.m48V(utmParams);
            if (!TextUtils.isEmpty(V)) {
                Map U = ak.m47U(V);
                set("&cc", (String) U.get("utm_content"));
                set("&cm", (String) U.get("utm_medium"));
                set("&cn", (String) U.get("utm_campaign"));
                set("&cs", (String) U.get("utm_source"));
                set("&ck", (String) U.get("utm_term"));
                set("&ci", (String) U.get("utm_id"));
                set("&gclid", (String) U.get("gclid"));
                set("&dclid", (String) U.get("dclid"));
                set("&gmob_t", (String) U.get("gmob_t"));
            }
            return this;
        }

        public T setCustomDimension(int index, String dimension) {
            set(C0150o.m72s(index), dimension);
            return this;
        }

        public T setCustomMetric(int index, float metric) {
            set(C0150o.m73t(index), Float.toString(metric));
            return this;
        }

        protected T setHitType(String hitType) {
            set("&t", hitType);
            return this;
        }

        public T setNewSession() {
            set("&sc", "start");
            return this;
        }

        public T setNonInteraction(boolean nonInteraction) {
            set("&ni", ak.m54v(nonInteraction));
            return this;
        }

        public T setProductAction(ProductAction action) {
            this.wA = action;
            return this;
        }

        public T setPromotionAction(String action) {
            this.wz.put("&promoa", action);
            return this;
        }
    }

    @Deprecated
    public static class AppViewBuilder extends HitBuilder<AppViewBuilder> {
        public AppViewBuilder() {
            C0166u.cU().m83a(C0165a.CONSTRUCT_APP_VIEW);
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class EventBuilder extends HitBuilder<EventBuilder> {
        public EventBuilder() {
            C0166u.cU().m83a(C0165a.CONSTRUCT_EVENT);
            set("&t", DataLayer.EVENT_KEY);
        }

        public EventBuilder(String category, String action) {
            this();
            setCategory(category);
            setAction(action);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public EventBuilder setAction(String action) {
            set("&ea", action);
            return this;
        }

        public EventBuilder setCategory(String category) {
            set("&ec", category);
            return this;
        }

        public EventBuilder setLabel(String label) {
            set("&el", label);
            return this;
        }

        public EventBuilder setValue(long value) {
            set("&ev", Long.toString(value));
            return this;
        }
    }

    public static class ExceptionBuilder extends HitBuilder<ExceptionBuilder> {
        public ExceptionBuilder() {
            C0166u.cU().m83a(C0165a.CONSTRUCT_EXCEPTION);
            set("&t", "exception");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ExceptionBuilder setDescription(String description) {
            set("&exd", description);
            return this;
        }

        public ExceptionBuilder setFatal(boolean fatal) {
            set("&exf", ak.m54v(fatal));
            return this;
        }
    }

    @Deprecated
    public static class ItemBuilder extends HitBuilder<ItemBuilder> {
        public ItemBuilder() {
            C0166u.cU().m83a(C0165a.CONSTRUCT_ITEM);
            set("&t", "item");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ItemBuilder setCategory(String category) {
            set("&iv", category);
            return this;
        }

        public ItemBuilder setCurrencyCode(String currencyCode) {
            set("&cu", currencyCode);
            return this;
        }

        public ItemBuilder setName(String name) {
            set("&in", name);
            return this;
        }

        public ItemBuilder setPrice(double price) {
            set("&ip", Double.toString(price));
            return this;
        }

        public ItemBuilder setQuantity(long quantity) {
            set("&iq", Long.toString(quantity));
            return this;
        }

        public ItemBuilder setSku(String sku) {
            set("&ic", sku);
            return this;
        }

        public ItemBuilder setTransactionId(String transactionid) {
            set("&ti", transactionid);
            return this;
        }
    }

    public static class ScreenViewBuilder extends HitBuilder<ScreenViewBuilder> {
        public ScreenViewBuilder() {
            C0166u.cU().m83a(C0165a.CONSTRUCT_APP_VIEW);
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class SocialBuilder extends HitBuilder<SocialBuilder> {
        public SocialBuilder() {
            C0166u.cU().m83a(C0165a.CONSTRUCT_SOCIAL);
            set("&t", NotificationCompatApi21.CATEGORY_SOCIAL);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public SocialBuilder setAction(String action) {
            set("&sa", action);
            return this;
        }

        public SocialBuilder setNetwork(String network) {
            set("&sn", network);
            return this;
        }

        public SocialBuilder setTarget(String target) {
            set("&st", target);
            return this;
        }
    }

    public static class TimingBuilder extends HitBuilder<TimingBuilder> {
        public TimingBuilder() {
            C0166u.cU().m83a(C0165a.CONSTRUCT_TIMING);
            set("&t", "timing");
        }

        public TimingBuilder(String category, String variable, long value) {
            this();
            setVariable(variable);
            setValue(value);
            setCategory(category);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TimingBuilder setCategory(String category) {
            set("&utc", category);
            return this;
        }

        public TimingBuilder setLabel(String label) {
            set("&utl", label);
            return this;
        }

        public TimingBuilder setValue(long value) {
            set("&utt", Long.toString(value));
            return this;
        }

        public TimingBuilder setVariable(String variable) {
            set("&utv", variable);
            return this;
        }
    }

    @Deprecated
    public static class TransactionBuilder extends HitBuilder<TransactionBuilder> {
        public TransactionBuilder() {
            C0166u.cU().m83a(C0165a.CONSTRUCT_TRANSACTION);
            set("&t", "transaction");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TransactionBuilder setAffiliation(String affiliation) {
            set("&ta", affiliation);
            return this;
        }

        public TransactionBuilder setCurrencyCode(String currencyCode) {
            set("&cu", currencyCode);
            return this;
        }

        public TransactionBuilder setRevenue(double revenue) {
            set("&tr", Double.toString(revenue));
            return this;
        }

        public TransactionBuilder setShipping(double shipping) {
            set("&ts", Double.toString(shipping));
            return this;
        }

        public TransactionBuilder setTax(double tax) {
            set("&tt", Double.toString(tax));
            return this;
        }

        public TransactionBuilder setTransactionId(String transactionid) {
            set("&ti", transactionid);
            return this;
        }
    }
}
