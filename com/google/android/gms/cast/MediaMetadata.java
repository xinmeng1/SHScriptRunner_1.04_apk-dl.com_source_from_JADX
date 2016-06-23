package com.google.android.gms.cast;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.gs;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaMetadata {
    private static final String[] AC;
    private static final C0170a AD;
    public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
    public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
    public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
    public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
    public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
    public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
    public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
    public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
    public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
    public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
    public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
    public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
    public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
    public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
    public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
    public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
    public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
    public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
    public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
    public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
    public static final int MEDIA_TYPE_GENERIC = 0;
    public static final int MEDIA_TYPE_MOVIE = 1;
    public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
    public static final int MEDIA_TYPE_PHOTO = 4;
    public static final int MEDIA_TYPE_TV_SHOW = 2;
    public static final int MEDIA_TYPE_USER = 100;
    private final Bundle AE;
    private int AF;
    private final List<WebImage> zQ;

    /* renamed from: com.google.android.gms.cast.MediaMetadata.a */
    private static class C0170a {
        private final Map<String, String> AG;
        private final Map<String, String> AH;
        private final Map<String, Integer> AI;

        public C0170a() {
            this.AG = new HashMap();
            this.AH = new HashMap();
            this.AI = new HashMap();
        }

        public C0170a m102a(String str, String str2, int i) {
            this.AG.put(str, str2);
            this.AH.put(str2, str);
            this.AI.put(str, Integer.valueOf(i));
            return this;
        }

        public String ae(String str) {
            return (String) this.AG.get(str);
        }

        public String af(String str) {
            return (String) this.AH.get(str);
        }

        public int ag(String str) {
            Integer num = (Integer) this.AI.get(str);
            return num != null ? num.intValue() : MediaMetadata.MEDIA_TYPE_GENERIC;
        }
    }

    static {
        AC = new String[]{null, "String", "int", "double", "ISO-8601 date String"};
        AD = new C0170a().m102a(KEY_CREATION_DATE, "creationDateTime", MEDIA_TYPE_PHOTO).m102a(KEY_RELEASE_DATE, "releaseDate", MEDIA_TYPE_PHOTO).m102a(KEY_BROADCAST_DATE, "originalAirdate", MEDIA_TYPE_PHOTO).m102a(KEY_TITLE, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, MEDIA_TYPE_MOVIE).m102a(KEY_SUBTITLE, "subtitle", MEDIA_TYPE_MOVIE).m102a(KEY_ARTIST, "artist", MEDIA_TYPE_MOVIE).m102a(KEY_ALBUM_ARTIST, "albumArtist", MEDIA_TYPE_MOVIE).m102a(KEY_ALBUM_TITLE, "albumName", MEDIA_TYPE_MOVIE).m102a(KEY_COMPOSER, "composer", MEDIA_TYPE_MOVIE).m102a(KEY_DISC_NUMBER, "discNumber", MEDIA_TYPE_TV_SHOW).m102a(KEY_TRACK_NUMBER, "trackNumber", MEDIA_TYPE_TV_SHOW).m102a(KEY_SEASON_NUMBER, "season", MEDIA_TYPE_TV_SHOW).m102a(KEY_EPISODE_NUMBER, "episode", MEDIA_TYPE_TV_SHOW).m102a(KEY_SERIES_TITLE, "seriesTitle", MEDIA_TYPE_MOVIE).m102a(KEY_STUDIO, "studio", MEDIA_TYPE_MOVIE).m102a(KEY_WIDTH, "width", MEDIA_TYPE_TV_SHOW).m102a(KEY_HEIGHT, "height", MEDIA_TYPE_TV_SHOW).m102a(KEY_LOCATION_NAME, "location", MEDIA_TYPE_MOVIE).m102a(KEY_LOCATION_LATITUDE, "latitude", MEDIA_TYPE_MUSIC_TRACK).m102a(KEY_LOCATION_LONGITUDE, "longitude", MEDIA_TYPE_MUSIC_TRACK);
    }

    public MediaMetadata() {
        this(MEDIA_TYPE_GENERIC);
    }

    public MediaMetadata(int mediaType) {
        this.zQ = new ArrayList();
        this.AE = new Bundle();
        this.AF = mediaType;
    }

    private void m103a(JSONObject jSONObject, String... strArr) {
        try {
            int length = strArr.length;
            for (int i = MEDIA_TYPE_GENERIC; i < length; i += MEDIA_TYPE_MOVIE) {
                String str = strArr[i];
                if (this.AE.containsKey(str)) {
                    switch (AD.ag(str)) {
                        case MEDIA_TYPE_MOVIE /*1*/:
                        case MEDIA_TYPE_PHOTO /*4*/:
                            jSONObject.put(AD.ae(str), this.AE.getString(str));
                            break;
                        case MEDIA_TYPE_TV_SHOW /*2*/:
                            jSONObject.put(AD.ae(str), this.AE.getInt(str));
                            break;
                        case MEDIA_TYPE_MUSIC_TRACK /*3*/:
                            jSONObject.put(AD.ae(str), this.AE.getDouble(str));
                            break;
                        default:
                            break;
                    }
                }
            }
            for (String str2 : this.AE.keySet()) {
                if (!str2.startsWith("com.google.")) {
                    Object obj = this.AE.get(str2);
                    if (obj instanceof String) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Integer) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Double) {
                        jSONObject.put(str2, obj);
                    }
                }
            }
        } catch (JSONException e) {
        }
    }

    private boolean m104a(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !m104a((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    private void m105b(JSONObject jSONObject, String... strArr) {
        Set hashSet = new HashSet(Arrays.asList(strArr));
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (!"metadataType".equals(str)) {
                    String af = AD.af(str);
                    if (af == null) {
                        Object obj = jSONObject.get(str);
                        if (obj instanceof String) {
                            this.AE.putString(str, (String) obj);
                        } else if (obj instanceof Integer) {
                            this.AE.putInt(str, ((Integer) obj).intValue());
                        } else if (obj instanceof Double) {
                            this.AE.putDouble(str, ((Double) obj).doubleValue());
                        }
                    } else if (hashSet.contains(af)) {
                        try {
                            Object obj2 = jSONObject.get(str);
                            if (obj2 != null) {
                                switch (AD.ag(af)) {
                                    case MEDIA_TYPE_MOVIE /*1*/:
                                        if (!(obj2 instanceof String)) {
                                            break;
                                        }
                                        this.AE.putString(af, (String) obj2);
                                        break;
                                    case MEDIA_TYPE_TV_SHOW /*2*/:
                                        if (!(obj2 instanceof Integer)) {
                                            break;
                                        }
                                        this.AE.putInt(af, ((Integer) obj2).intValue());
                                        break;
                                    case MEDIA_TYPE_MUSIC_TRACK /*3*/:
                                        if (!(obj2 instanceof Double)) {
                                            break;
                                        }
                                        this.AE.putDouble(af, ((Double) obj2).doubleValue());
                                        break;
                                    case MEDIA_TYPE_PHOTO /*4*/:
                                        if (!(obj2 instanceof String)) {
                                            break;
                                        }
                                        if (gs.aq((String) obj2) == null) {
                                            break;
                                        }
                                        this.AE.putString(af, (String) obj2);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
            }
        } catch (JSONException e2) {
        }
    }

    private void m106d(String str, int i) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        int ag = AD.ag(str);
        if (ag != i && ag != 0) {
            throw new IllegalArgumentException("Value for " + str + " must be a " + AC[i]);
        }
    }

    public void addImage(WebImage image) {
        this.zQ.add(image);
    }

    public void m107b(JSONObject jSONObject) {
        clear();
        this.AF = MEDIA_TYPE_GENERIC;
        try {
            this.AF = jSONObject.getInt("metadataType");
        } catch (JSONException e) {
        }
        gs.m1151a(this.zQ, jSONObject);
        String[] strArr;
        switch (this.AF) {
            case MEDIA_TYPE_GENERIC /*0*/:
                strArr = new String[MEDIA_TYPE_PHOTO];
                strArr[MEDIA_TYPE_GENERIC] = KEY_TITLE;
                strArr[MEDIA_TYPE_MOVIE] = KEY_ARTIST;
                strArr[MEDIA_TYPE_TV_SHOW] = KEY_SUBTITLE;
                strArr[MEDIA_TYPE_MUSIC_TRACK] = KEY_RELEASE_DATE;
                m105b(jSONObject, strArr);
            case MEDIA_TYPE_MOVIE /*1*/:
                strArr = new String[MEDIA_TYPE_PHOTO];
                strArr[MEDIA_TYPE_GENERIC] = KEY_TITLE;
                strArr[MEDIA_TYPE_MOVIE] = KEY_STUDIO;
                strArr[MEDIA_TYPE_TV_SHOW] = KEY_SUBTITLE;
                strArr[MEDIA_TYPE_MUSIC_TRACK] = KEY_RELEASE_DATE;
                m105b(jSONObject, strArr);
            case MEDIA_TYPE_TV_SHOW /*2*/:
                m105b(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
            case MEDIA_TYPE_MUSIC_TRACK /*3*/:
                m105b(jSONObject, KEY_TITLE, KEY_ALBUM_TITLE, KEY_ARTIST, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
            case MEDIA_TYPE_PHOTO /*4*/:
                m105b(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
            default:
                m105b(jSONObject, new String[MEDIA_TYPE_GENERIC]);
        }
    }

    public void clear() {
        this.AE.clear();
        this.zQ.clear();
    }

    public void clearImages() {
        this.zQ.clear();
    }

    public boolean containsKey(String key) {
        return this.AE.containsKey(key);
    }

    public JSONObject dZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadataType", this.AF);
        } catch (JSONException e) {
        }
        gs.m1152a(jSONObject, this.zQ);
        String[] strArr;
        switch (this.AF) {
            case MEDIA_TYPE_GENERIC /*0*/:
                strArr = new String[MEDIA_TYPE_PHOTO];
                strArr[MEDIA_TYPE_GENERIC] = KEY_TITLE;
                strArr[MEDIA_TYPE_MOVIE] = KEY_ARTIST;
                strArr[MEDIA_TYPE_TV_SHOW] = KEY_SUBTITLE;
                strArr[MEDIA_TYPE_MUSIC_TRACK] = KEY_RELEASE_DATE;
                m103a(jSONObject, strArr);
                break;
            case MEDIA_TYPE_MOVIE /*1*/:
                strArr = new String[MEDIA_TYPE_PHOTO];
                strArr[MEDIA_TYPE_GENERIC] = KEY_TITLE;
                strArr[MEDIA_TYPE_MOVIE] = KEY_STUDIO;
                strArr[MEDIA_TYPE_TV_SHOW] = KEY_SUBTITLE;
                strArr[MEDIA_TYPE_MUSIC_TRACK] = KEY_RELEASE_DATE;
                m103a(jSONObject, strArr);
                break;
            case MEDIA_TYPE_TV_SHOW /*2*/:
                m103a(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                break;
            case MEDIA_TYPE_MUSIC_TRACK /*3*/:
                m103a(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_ALBUM_TITLE, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                break;
            case MEDIA_TYPE_PHOTO /*4*/:
                m103a(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                break;
            default:
                m103a(jSONObject, new String[MEDIA_TYPE_GENERIC]);
                break;
        }
        return jSONObject;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaMetadata)) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) other;
        return m104a(this.AE, mediaMetadata.AE) && this.zQ.equals(mediaMetadata.zQ);
    }

    public Calendar getDate(String key) {
        m106d(key, MEDIA_TYPE_PHOTO);
        String string = this.AE.getString(key);
        return string != null ? gs.aq(string) : null;
    }

    public String getDateAsString(String key) {
        m106d(key, MEDIA_TYPE_PHOTO);
        return this.AE.getString(key);
    }

    public double getDouble(String key) {
        m106d(key, MEDIA_TYPE_MUSIC_TRACK);
        return this.AE.getDouble(key);
    }

    public List<WebImage> getImages() {
        return this.zQ;
    }

    public int getInt(String key) {
        m106d(key, MEDIA_TYPE_TV_SHOW);
        return this.AE.getInt(key);
    }

    public int getMediaType() {
        return this.AF;
    }

    public String getString(String key) {
        m106d(key, MEDIA_TYPE_MOVIE);
        return this.AE.getString(key);
    }

    public boolean hasImages() {
        return (this.zQ == null || this.zQ.isEmpty()) ? false : true;
    }

    public int hashCode() {
        int i = 17;
        for (String str : this.AE.keySet()) {
            i *= 31;
            i = this.AE.get(str).hashCode() + i;
        }
        return (i * 31) + this.zQ.hashCode();
    }

    public Set<String> keySet() {
        return this.AE.keySet();
    }

    public void putDate(String key, Calendar value) {
        m106d(key, MEDIA_TYPE_PHOTO);
        this.AE.putString(key, gs.m1150a(value));
    }

    public void putDouble(String key, double value) {
        m106d(key, MEDIA_TYPE_MUSIC_TRACK);
        this.AE.putDouble(key, value);
    }

    public void putInt(String key, int value) {
        m106d(key, MEDIA_TYPE_TV_SHOW);
        this.AE.putInt(key, value);
    }

    public void putString(String key, String value) {
        m106d(key, MEDIA_TYPE_MOVIE);
        this.AE.putString(key, value);
    }
}
