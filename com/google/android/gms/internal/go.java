package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.TextTrackStyle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class go extends gg {
    private static final long Cp;
    private static final long Cq;
    private static final long Cr;
    private static final long Cs;
    private static final String NAMESPACE;
    private final gr CA;
    private final gr CB;
    private final gr CC;
    private final gr CD;
    private final gr CE;
    private final List<gr> CF;
    private final Runnable CG;
    private boolean CH;
    private long Ct;
    private MediaStatus Cu;
    private final gr Cv;
    private final gr Cw;
    private final gr Cx;
    private final gr Cy;
    private final gr Cz;
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.go.a */
    private class C0365a implements Runnable {
        final /* synthetic */ go CI;

        private C0365a(go goVar) {
            this.CI = goVar;
        }

        public void run() {
            boolean z = false;
            this.CI.CH = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            for (gr d : this.CI.CF) {
                d.m1148d(elapsedRealtime, 3);
            }
            synchronized (gr.CN) {
                for (gr d2 : this.CI.CF) {
                    z = d2.ev() ? true : z;
                }
            }
            this.CI.m2622z(z);
        }
    }

    static {
        NAMESPACE = gi.al("com.google.cast.media");
        Cp = TimeUnit.HOURS.toMillis(24);
        Cq = TimeUnit.HOURS.toMillis(24);
        Cr = TimeUnit.HOURS.toMillis(24);
        Cs = TimeUnit.SECONDS.toMillis(1);
    }

    public go() {
        this(null);
    }

    public go(String str) {
        super(NAMESPACE, "MediaControlChannel", str);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.CG = new C0365a();
        this.CF = new ArrayList();
        this.Cv = new gr(Cq);
        this.CF.add(this.Cv);
        this.Cw = new gr(Cp);
        this.CF.add(this.Cw);
        this.Cx = new gr(Cp);
        this.CF.add(this.Cx);
        this.Cy = new gr(Cp);
        this.CF.add(this.Cy);
        this.Cz = new gr(Cr);
        this.CF.add(this.Cz);
        this.CA = new gr(Cp);
        this.CF.add(this.CA);
        this.CB = new gr(Cp);
        this.CF.add(this.CB);
        this.CC = new gr(Cp);
        this.CF.add(this.CC);
        this.CD = new gr(Cp);
        this.CF.add(this.CD);
        this.CE = new gr(Cp);
        this.CF.add(this.CE);
        et();
    }

    private void m2619a(long j, JSONObject jSONObject) throws JSONException {
        int i = 1;
        boolean p = this.Cv.m1149p(j);
        int i2 = (!this.Cz.ev() || this.Cz.m1149p(j)) ? 0 : 1;
        if ((!this.CA.ev() || this.CA.m1149p(j)) && (!this.CB.ev() || this.CB.m1149p(j))) {
            i = 0;
        }
        i2 = i2 != 0 ? 2 : 0;
        if (i != 0) {
            i2 |= 1;
        }
        if (p || this.Cu == null) {
            this.Cu = new MediaStatus(jSONObject);
            this.Ct = SystemClock.elapsedRealtime();
            i2 = 7;
        } else {
            i2 = this.Cu.m108a(jSONObject, i2);
        }
        if ((i2 & 1) != 0) {
            this.Ct = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i2 & 2) != 0) {
            this.Ct = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i2 & 4) != 0) {
            onMetadataUpdated();
        }
        for (gr c : this.CF) {
            c.m1147c(j, 0);
        }
    }

    private void et() {
        m2622z(false);
        this.Ct = 0;
        this.Cu = null;
        this.Cv.clear();
        this.Cz.clear();
        this.CA.clear();
    }

    private void m2622z(boolean z) {
        if (this.CH != z) {
            this.CH = z;
            if (z) {
                this.mHandler.postDelayed(this.CG, Cs);
            } else {
                this.mHandler.removeCallbacks(this.CG);
            }
        }
    }

    public long m2623a(gq gqVar) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long ed = ed();
        this.CC.m1145a(ed, gqVar);
        m2622z(true);
        try {
            jSONObject.put("requestId", ed);
            jSONObject.put("type", "GET_STATUS");
            if (this.Cu != null) {
                jSONObject.put("mediaSessionId", this.Cu.ea());
            }
        } catch (JSONException e) {
        }
        m1109a(jSONObject.toString(), ed, null);
        return ed;
    }

    public long m2624a(gq gqVar, double d, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalArgumentException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        JSONObject jSONObject2 = new JSONObject();
        long ed = ed();
        this.CA.m1145a(ed, gqVar);
        m2622z(true);
        try {
            jSONObject2.put("requestId", ed);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", ea());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("level", d);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m1109a(jSONObject2.toString(), ed, null);
        return ed;
    }

    public long m2625a(gq gqVar, long j, int i, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long ed = ed();
        this.Cz.m1145a(ed, gqVar);
        m2622z(true);
        try {
            jSONObject2.put("requestId", ed);
            jSONObject2.put("type", "SEEK");
            jSONObject2.put("mediaSessionId", ea());
            jSONObject2.put("currentTime", gi.m1113o(j));
            if (i == 1) {
                jSONObject2.put("resumeState", "PLAYBACK_START");
            } else if (i == 2) {
                jSONObject2.put("resumeState", "PLAYBACK_PAUSE");
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m1109a(jSONObject2.toString(), ed, null);
        return ed;
    }

    public long m2626a(gq gqVar, MediaInfo mediaInfo, boolean z, long j, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long ed = ed();
        this.Cv.m1145a(ed, gqVar);
        m2622z(true);
        try {
            jSONObject2.put("requestId", ed);
            jSONObject2.put("type", "LOAD");
            jSONObject2.put("media", mediaInfo.dZ());
            jSONObject2.put("autoplay", z);
            jSONObject2.put("currentTime", gi.m1113o(j));
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m1109a(jSONObject2.toString(), ed, null);
        return ed;
    }

    public long m2627a(gq gqVar, TextTrackStyle textTrackStyle) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long ed = ed();
        this.CE.m1145a(ed, gqVar);
        m2622z(true);
        try {
            jSONObject.put("requestId", ed);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            if (textTrackStyle != null) {
                jSONObject.put("textTrackStyle", textTrackStyle.dZ());
            }
            jSONObject.put("mediaSessionId", ea());
        } catch (JSONException e) {
        }
        m1109a(jSONObject.toString(), ed, null);
        return ed;
    }

    public long m2628a(gq gqVar, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long ed = ed();
        this.Cw.m1145a(ed, gqVar);
        m2622z(true);
        try {
            jSONObject2.put("requestId", ed);
            jSONObject2.put("type", "PAUSE");
            jSONObject2.put("mediaSessionId", ea());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m1109a(jSONObject2.toString(), ed, null);
        return ed;
    }

    public long m2629a(gq gqVar, boolean z, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long ed = ed();
        this.CB.m1145a(ed, gqVar);
        m2622z(true);
        try {
            jSONObject2.put("requestId", ed);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", ea());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("muted", z);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m1109a(jSONObject2.toString(), ed, null);
        return ed;
    }

    public long m2630a(gq gqVar, long[] jArr) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long ed = ed();
        this.CD.m1145a(ed, gqVar);
        m2622z(true);
        try {
            jSONObject.put("requestId", ed);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            jSONObject.put("mediaSessionId", ea());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < jArr.length; i++) {
                jSONArray.put(i, jArr[i]);
            }
            jSONObject.put("activeTrackIds", jSONArray);
        } catch (JSONException e) {
        }
        m1109a(jSONObject.toString(), ed, null);
        return ed;
    }

    public void m2631a(long j, int i) {
        for (gr c : this.CF) {
            c.m1147c(j, i);
        }
    }

    public final void ai(String str) {
        this.BD.m1139b("message received: %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            long optLong = jSONObject.optLong("requestId", -1);
            if (string.equals("MEDIA_STATUS")) {
                JSONArray jSONArray = jSONObject.getJSONArray(NotificationCompatApi21.CATEGORY_STATUS);
                if (jSONArray.length() > 0) {
                    m2619a(optLong, jSONArray.getJSONObject(0));
                    return;
                }
                this.Cu = null;
                onStatusUpdated();
                onMetadataUpdated();
                this.CC.m1147c(optLong, 0);
            } else if (string.equals("INVALID_PLAYER_STATE")) {
                this.BD.m1141d("received unexpected error: Invalid Player State.", new Object[0]);
                r1 = jSONObject.optJSONObject("customData");
                for (gr b : this.CF) {
                    b.m1146b(optLong, 1, r1);
                }
            } else if (string.equals("LOAD_FAILED")) {
                this.Cv.m1146b(optLong, 1, jSONObject.optJSONObject("customData"));
            } else if (string.equals("LOAD_CANCELLED")) {
                this.Cv.m1146b(optLong, 2, jSONObject.optJSONObject("customData"));
            } else if (string.equals("INVALID_REQUEST")) {
                this.BD.m1141d("received unexpected error: Invalid Request.", new Object[0]);
                r1 = jSONObject.optJSONObject("customData");
                for (gr b2 : this.CF) {
                    b2.m1146b(optLong, 1, r1);
                }
            }
        } catch (JSONException e) {
            this.BD.m1141d("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    public long m2632b(gq gqVar, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long ed = ed();
        this.Cy.m1145a(ed, gqVar);
        m2622z(true);
        try {
            jSONObject2.put("requestId", ed);
            jSONObject2.put("type", "STOP");
            jSONObject2.put("mediaSessionId", ea());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m1109a(jSONObject2.toString(), ed, null);
        return ed;
    }

    public long m2633c(gq gqVar, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long ed = ed();
        this.Cx.m1145a(ed, gqVar);
        m2622z(true);
        try {
            jSONObject2.put("requestId", ed);
            jSONObject2.put("type", "PLAY");
            jSONObject2.put("mediaSessionId", ea());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m1109a(jSONObject2.toString(), ed, null);
        return ed;
    }

    public long ea() throws IllegalStateException {
        if (this.Cu != null) {
            return this.Cu.ea();
        }
        throw new IllegalStateException("No current media session");
    }

    public void ee() {
        et();
    }

    public long getApproximateStreamPosition() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo == null || this.Ct == 0) {
            return 0;
        }
        double playbackRate = this.Cu.getPlaybackRate();
        long streamPosition = this.Cu.getStreamPosition();
        int playerState = this.Cu.getPlayerState();
        if (playbackRate == 0.0d || playerState != 2) {
            return streamPosition;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.Ct;
        long j = elapsedRealtime < 0 ? 0 : elapsedRealtime;
        if (j == 0) {
            return streamPosition;
        }
        elapsedRealtime = mediaInfo.getStreamDuration();
        streamPosition += (long) (((double) j) * playbackRate);
        if (streamPosition <= elapsedRealtime) {
            elapsedRealtime = streamPosition < 0 ? 0 : streamPosition;
        }
        return elapsedRealtime;
    }

    public MediaInfo getMediaInfo() {
        return this.Cu == null ? null : this.Cu.getMediaInfo();
    }

    public MediaStatus getMediaStatus() {
        return this.Cu;
    }

    public long getStreamDuration() {
        MediaInfo mediaInfo = getMediaInfo();
        return mediaInfo != null ? mediaInfo.getStreamDuration() : 0;
    }

    protected void onMetadataUpdated() {
    }

    protected void onStatusUpdated() {
    }
}
