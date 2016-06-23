package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.in;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack {
    public static final int SUBTYPE_CAPTIONS = 2;
    public static final int SUBTYPE_CHAPTERS = 4;
    public static final int SUBTYPE_DESCRIPTIONS = 3;
    public static final int SUBTYPE_METADATA = 5;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_SUBTITLES = 1;
    public static final int SUBTYPE_UNKNOWN = -1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 3;
    private JSONObject AA;
    private long AS;
    private int AT;
    private int AU;
    private String Ar;
    private String At;
    private String Av;
    private String mName;

    public static class Builder {
        private final MediaTrack AV;

        public Builder(long trackId, int trackType) throws IllegalArgumentException {
            this.AV = new MediaTrack(trackId, trackType);
        }

        public MediaTrack build() {
            return this.AV;
        }

        public Builder setContentId(String contentId) {
            this.AV.setContentId(contentId);
            return this;
        }

        public Builder setContentType(String contentType) {
            this.AV.setContentType(contentType);
            return this;
        }

        public Builder setCustomData(JSONObject customData) {
            this.AV.setCustomData(customData);
            return this;
        }

        public Builder setLanguage(String language) {
            this.AV.setLanguage(language);
            return this;
        }

        public Builder setLanguage(Locale locale) {
            this.AV.setLanguage(gi.m1112b(locale));
            return this;
        }

        public Builder setName(String trackName) {
            this.AV.setName(trackName);
            return this;
        }

        public Builder setSubtype(int subtype) throws IllegalArgumentException {
            this.AV.m110R(subtype);
            return this;
        }
    }

    MediaTrack(long id, int type) throws IllegalArgumentException {
        clear();
        this.AS = id;
        if (type <= 0 || type > TYPE_VIDEO) {
            throw new IllegalArgumentException("invalid type " + type);
        }
        this.AT = type;
    }

    MediaTrack(JSONObject json) throws JSONException {
        m109b(json);
    }

    private void m109b(JSONObject jSONObject) throws JSONException {
        clear();
        this.AS = jSONObject.getLong("trackId");
        String string = jSONObject.getString("type");
        if ("TEXT".equals(string)) {
            this.AT = TYPE_TEXT;
        } else if ("AUDIO".equals(string)) {
            this.AT = TYPE_AUDIO;
        } else if ("VIDEO".equals(string)) {
            this.AT = TYPE_VIDEO;
        } else {
            throw new JSONException("invalid type: " + string);
        }
        this.At = jSONObject.optString("trackContentId", null);
        this.Av = jSONObject.optString("trackContentType", null);
        this.mName = jSONObject.optString("name", null);
        this.Ar = jSONObject.optString("language", null);
        if (jSONObject.has("subtype")) {
            string = jSONObject.getString("subtype");
            if ("SUBTITLES".equals(string)) {
                this.AU = TYPE_TEXT;
            } else if ("CAPTIONS".equals(string)) {
                this.AU = TYPE_AUDIO;
            } else if ("DESCRIPTIONS".equals(string)) {
                this.AU = TYPE_VIDEO;
            } else if ("CHAPTERS".equals(string)) {
                this.AU = SUBTYPE_CHAPTERS;
            } else if ("METADATA".equals(string)) {
                this.AU = SUBTYPE_METADATA;
            } else {
                throw new JSONException("invalid subtype: " + string);
            }
        }
        this.AU = TYPE_UNKNOWN;
        this.AA = jSONObject.optJSONObject("customData");
    }

    private void clear() {
        this.AS = 0;
        this.AT = TYPE_UNKNOWN;
        this.At = null;
        this.mName = null;
        this.Ar = null;
        this.AU = SUBTYPE_UNKNOWN;
        this.AA = null;
    }

    void m110R(int i) throws IllegalArgumentException {
        if (i <= SUBTYPE_UNKNOWN || i > SUBTYPE_METADATA) {
            throw new IllegalArgumentException("invalid subtype " + i);
        } else if (i == 0 || this.AT == TYPE_TEXT) {
            this.AU = i;
        } else {
            throw new IllegalArgumentException("subtypes are only valid for text tracks");
        }
    }

    public JSONObject dZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackId", this.AS);
            switch (this.AT) {
                case TYPE_TEXT /*1*/:
                    jSONObject.put("type", "TEXT");
                    break;
                case TYPE_AUDIO /*2*/:
                    jSONObject.put("type", "AUDIO");
                    break;
                case TYPE_VIDEO /*3*/:
                    jSONObject.put("type", "VIDEO");
                    break;
            }
            if (this.At != null) {
                jSONObject.put("trackContentId", this.At);
            }
            if (this.Av != null) {
                jSONObject.put("trackContentType", this.Av);
            }
            if (this.mName != null) {
                jSONObject.put("name", this.mName);
            }
            if (!TextUtils.isEmpty(this.Ar)) {
                jSONObject.put("language", this.Ar);
            }
            switch (this.AU) {
                case TYPE_TEXT /*1*/:
                    jSONObject.put("subtype", "SUBTITLES");
                    break;
                case TYPE_AUDIO /*2*/:
                    jSONObject.put("subtype", "CAPTIONS");
                    break;
                case TYPE_VIDEO /*3*/:
                    jSONObject.put("subtype", "DESCRIPTIONS");
                    break;
                case SUBTYPE_CHAPTERS /*4*/:
                    jSONObject.put("subtype", "CHAPTERS");
                    break;
                case SUBTYPE_METADATA /*5*/:
                    jSONObject.put("subtype", "METADATA");
                    break;
            }
            if (this.AA != null) {
                jSONObject.put("customData", this.AA);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) other;
        if ((this.AA == null ? TYPE_TEXT : false) != (mediaTrack.AA == null ? TYPE_TEXT : false)) {
            return false;
        }
        if (this.AA != null && mediaTrack.AA != null && !in.m1276d(this.AA, mediaTrack.AA)) {
            return false;
        }
        if (!(this.AS == mediaTrack.AS && this.AT == mediaTrack.AT && gi.m1110a(this.At, mediaTrack.At) && gi.m1110a(this.Av, mediaTrack.Av) && gi.m1110a(this.mName, mediaTrack.mName) && gi.m1110a(this.Ar, mediaTrack.Ar) && this.AU == mediaTrack.AU)) {
            z = false;
        }
        return z;
    }

    public String getContentId() {
        return this.At;
    }

    public String getContentType() {
        return this.Av;
    }

    public JSONObject getCustomData() {
        return this.AA;
    }

    public long getId() {
        return this.AS;
    }

    public String getLanguage() {
        return this.Ar;
    }

    public String getName() {
        return this.mName;
    }

    public int getSubtype() {
        return this.AU;
    }

    public int getType() {
        return this.AT;
    }

    public int hashCode() {
        return hk.hashCode(Long.valueOf(this.AS), Integer.valueOf(this.AT), this.At, this.Av, this.mName, this.Ar, Integer.valueOf(this.AU), this.AA);
    }

    public void setContentId(String contentId) {
        this.At = contentId;
    }

    public void setContentType(String contentType) {
        this.Av = contentType;
    }

    void setCustomData(JSONObject customData) {
        this.AA = customData;
    }

    void setLanguage(String language) {
        this.Ar = language;
    }

    void setName(String name) {
        this.mName = name;
    }
}
