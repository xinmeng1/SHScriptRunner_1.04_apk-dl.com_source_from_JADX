package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast.C1188a;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.gh;
import com.google.android.gms.internal.go;
import com.google.android.gms.internal.gp;
import com.google.android.gms.internal.gq;
import java.io.IOException;
import org.json.JSONObject;

public class RemoteMediaPlayer implements MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2;
    public static final int STATUS_FAILED = 1;
    public static final int STATUS_REPLACED = 4;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 3;
    private final go AW;
    private final C0625a AX;
    private OnMetadataUpdatedListener AY;
    private OnStatusUpdatedListener AZ;
    private final Object ls;

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.a */
    private class C0625a implements gp {
        final /* synthetic */ RemoteMediaPlayer Ba;
        private GoogleApiClient Bm;
        private long Bn;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.a.a */
        private final class C0624a implements ResultCallback<Status> {
            private final long Bo;
            final /* synthetic */ C0625a Bp;

            C0624a(C0625a c0625a, long j) {
                this.Bp = c0625a;
                this.Bo = j;
            }

            public void m1967k(Status status) {
                if (!status.isSuccess()) {
                    this.Bp.Ba.AW.m2631a(this.Bo, status.getStatusCode());
                }
            }

            public /* synthetic */ void onResult(Result x0) {
                m1967k((Status) x0);
            }
        }

        public C0625a(RemoteMediaPlayer remoteMediaPlayer) {
            this.Ba = remoteMediaPlayer;
            this.Bn = 0;
        }

        public void m1968a(String str, String str2, long j, String str3) throws IOException {
            if (this.Bm == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.Bm, str, str2).setResultCallback(new C0624a(this, j));
        }

        public void m1969b(GoogleApiClient googleApiClient) {
            this.Bm = googleApiClient;
        }

        public long eb() {
            long j = this.Bn + 1;
            this.Bn = j;
            return j;
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.1 */
    class C10261 extends go {
        final /* synthetic */ RemoteMediaPlayer Ba;

        C10261(RemoteMediaPlayer remoteMediaPlayer) {
            this.Ba = remoteMediaPlayer;
        }

        protected void onMetadataUpdated() {
            this.Ba.onMetadataUpdated();
        }

        protected void onStatusUpdated() {
            this.Ba.onStatusUpdated();
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.c */
    private static final class C1028c implements MediaChannelResult {
        private final JSONObject AA;
        private final Status yz;

        C1028c(Status status, JSONObject jSONObject) {
            this.yz = status;
            this.AA = jSONObject;
        }

        public JSONObject getCustomData() {
            return this.AA;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.b */
    private static abstract class C1246b extends C1188a<MediaChannelResult> {
        gq Bq;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.b.1 */
        class C06261 implements gq {
            final /* synthetic */ C1246b Br;

            C06261(C1246b c1246b) {
                this.Br = c1246b;
            }

            public void m1970a(long j, int i, JSONObject jSONObject) {
                this.Br.m1984b(new C1028c(new Status(i), jSONObject));
            }

            public void m1971n(long j) {
                this.Br.m1984b(this.Br.m4124l(new Status(RemoteMediaPlayer.STATUS_REPLACED)));
            }
        }

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.b.2 */
        class C10272 implements MediaChannelResult {
            final /* synthetic */ C1246b Br;
            final /* synthetic */ Status yJ;

            C10272(C1246b c1246b, Status status) {
                this.Br = c1246b;
                this.yJ = status;
            }

            public JSONObject getCustomData() {
                return null;
            }

            public Status getStatus() {
                return this.yJ;
            }
        }

        C1246b() {
            this.Bq = new C06261(this);
        }

        public /* synthetic */ Result m4123c(Status status) {
            return m4124l(status);
        }

        public MediaChannelResult m4124l(Status status) {
            return new C10272(this, status);
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.10 */
    class AnonymousClass10 extends C1246b {
        final /* synthetic */ RemoteMediaPlayer Ba;
        final /* synthetic */ GoogleApiClient Bb;
        final /* synthetic */ JSONObject Bh;
        final /* synthetic */ boolean Bl;

        AnonymousClass10(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, boolean z, JSONObject jSONObject) {
            this.Ba = remoteMediaPlayer;
            this.Bb = googleApiClient;
            this.Bl = z;
            this.Bh = jSONObject;
        }

        protected void m4358a(gh ghVar) {
            synchronized (this.Ba.ls) {
                this.Ba.AX.m1969b(this.Bb);
                try {
                    this.Ba.AW.m2629a(this.Bq, this.Bl, this.Bh);
                    this.Ba.AX.m1969b(null);
                } catch (IllegalStateException e) {
                    m1984b(m4124l(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.Ba.AX.m1969b(null);
                } catch (IOException e2) {
                    m1984b(m4124l(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.Ba.AX.m1969b(null);
                } catch (Throwable th) {
                    this.Ba.AX.m1969b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.11 */
    class AnonymousClass11 extends C1246b {
        final /* synthetic */ RemoteMediaPlayer Ba;
        final /* synthetic */ GoogleApiClient Bb;

        AnonymousClass11(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient) {
            this.Ba = remoteMediaPlayer;
            this.Bb = googleApiClient;
        }

        protected void m4360a(gh ghVar) {
            synchronized (this.Ba.ls) {
                this.Ba.AX.m1969b(this.Bb);
                try {
                    this.Ba.AW.m2623a(this.Bq);
                    this.Ba.AX.m1969b(null);
                } catch (IOException e) {
                    m1984b(m4124l(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.Ba.AX.m1969b(null);
                } catch (Throwable th) {
                    this.Ba.AX.m1969b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.2 */
    class C13162 extends C1246b {
        final /* synthetic */ RemoteMediaPlayer Ba;
        final /* synthetic */ GoogleApiClient Bb;
        final /* synthetic */ long[] Bc;

        C13162(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, long[] jArr) {
            this.Ba = remoteMediaPlayer;
            this.Bb = googleApiClient;
            this.Bc = jArr;
        }

        protected void m4362a(gh ghVar) {
            synchronized (this.Ba.ls) {
                this.Ba.AX.m1969b(this.Bb);
                try {
                    this.Ba.AW.m2630a(this.Bq, this.Bc);
                    this.Ba.AX.m1969b(null);
                } catch (IOException e) {
                    m1984b(m4124l(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.Ba.AX.m1969b(null);
                } catch (Throwable th) {
                    this.Ba.AX.m1969b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.3 */
    class C13173 extends C1246b {
        final /* synthetic */ RemoteMediaPlayer Ba;
        final /* synthetic */ GoogleApiClient Bb;
        final /* synthetic */ TextTrackStyle Bd;

        C13173(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, TextTrackStyle textTrackStyle) {
            this.Ba = remoteMediaPlayer;
            this.Bb = googleApiClient;
            this.Bd = textTrackStyle;
        }

        protected void m4364a(gh ghVar) {
            synchronized (this.Ba.ls) {
                this.Ba.AX.m1969b(this.Bb);
                try {
                    this.Ba.AW.m2627a(this.Bq, this.Bd);
                    this.Ba.AX.m1969b(null);
                } catch (IOException e) {
                    m1984b(m4124l(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.Ba.AX.m1969b(null);
                } catch (Throwable th) {
                    this.Ba.AX.m1969b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.4 */
    class C13184 extends C1246b {
        final /* synthetic */ RemoteMediaPlayer Ba;
        final /* synthetic */ GoogleApiClient Bb;
        final /* synthetic */ MediaInfo Be;
        final /* synthetic */ boolean Bf;
        final /* synthetic */ long Bg;
        final /* synthetic */ JSONObject Bh;

        C13184(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j, JSONObject jSONObject) {
            this.Ba = remoteMediaPlayer;
            this.Bb = googleApiClient;
            this.Be = mediaInfo;
            this.Bf = z;
            this.Bg = j;
            this.Bh = jSONObject;
        }

        protected void m4366a(gh ghVar) {
            synchronized (this.Ba.ls) {
                this.Ba.AX.m1969b(this.Bb);
                try {
                    this.Ba.AW.m2626a(this.Bq, this.Be, this.Bf, this.Bg, this.Bh);
                    this.Ba.AX.m1969b(null);
                } catch (IOException e) {
                    m1984b(m4124l(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.Ba.AX.m1969b(null);
                } catch (Throwable th) {
                    this.Ba.AX.m1969b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.5 */
    class C13195 extends C1246b {
        final /* synthetic */ RemoteMediaPlayer Ba;
        final /* synthetic */ GoogleApiClient Bb;
        final /* synthetic */ JSONObject Bh;

        C13195(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, JSONObject jSONObject) {
            this.Ba = remoteMediaPlayer;
            this.Bb = googleApiClient;
            this.Bh = jSONObject;
        }

        protected void m4368a(gh ghVar) {
            synchronized (this.Ba.ls) {
                this.Ba.AX.m1969b(this.Bb);
                try {
                    this.Ba.AW.m2628a(this.Bq, this.Bh);
                    this.Ba.AX.m1969b(null);
                } catch (IOException e) {
                    m1984b(m4124l(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.Ba.AX.m1969b(null);
                } catch (Throwable th) {
                    this.Ba.AX.m1969b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.6 */
    class C13206 extends C1246b {
        final /* synthetic */ RemoteMediaPlayer Ba;
        final /* synthetic */ GoogleApiClient Bb;
        final /* synthetic */ JSONObject Bh;

        C13206(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, JSONObject jSONObject) {
            this.Ba = remoteMediaPlayer;
            this.Bb = googleApiClient;
            this.Bh = jSONObject;
        }

        protected void m4370a(gh ghVar) {
            synchronized (this.Ba.ls) {
                this.Ba.AX.m1969b(this.Bb);
                try {
                    this.Ba.AW.m2632b(this.Bq, this.Bh);
                    this.Ba.AX.m1969b(null);
                } catch (IOException e) {
                    m1984b(m4124l(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.Ba.AX.m1969b(null);
                } catch (Throwable th) {
                    this.Ba.AX.m1969b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.7 */
    class C13217 extends C1246b {
        final /* synthetic */ RemoteMediaPlayer Ba;
        final /* synthetic */ GoogleApiClient Bb;
        final /* synthetic */ JSONObject Bh;

        C13217(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, JSONObject jSONObject) {
            this.Ba = remoteMediaPlayer;
            this.Bb = googleApiClient;
            this.Bh = jSONObject;
        }

        protected void m4372a(gh ghVar) {
            synchronized (this.Ba.ls) {
                this.Ba.AX.m1969b(this.Bb);
                try {
                    this.Ba.AW.m2633c(this.Bq, this.Bh);
                    this.Ba.AX.m1969b(null);
                } catch (IOException e) {
                    m1984b(m4124l(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.Ba.AX.m1969b(null);
                } catch (Throwable th) {
                    this.Ba.AX.m1969b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.8 */
    class C13228 extends C1246b {
        final /* synthetic */ RemoteMediaPlayer Ba;
        final /* synthetic */ GoogleApiClient Bb;
        final /* synthetic */ JSONObject Bh;
        final /* synthetic */ long Bi;
        final /* synthetic */ int Bj;

        C13228(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, long j, int i, JSONObject jSONObject) {
            this.Ba = remoteMediaPlayer;
            this.Bb = googleApiClient;
            this.Bi = j;
            this.Bj = i;
            this.Bh = jSONObject;
        }

        protected void m4374a(gh ghVar) {
            synchronized (this.Ba.ls) {
                this.Ba.AX.m1969b(this.Bb);
                try {
                    this.Ba.AW.m2625a(this.Bq, this.Bi, this.Bj, this.Bh);
                    this.Ba.AX.m1969b(null);
                } catch (IOException e) {
                    m1984b(m4124l(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.Ba.AX.m1969b(null);
                } catch (Throwable th) {
                    this.Ba.AX.m1969b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.9 */
    class C13239 extends C1246b {
        final /* synthetic */ RemoteMediaPlayer Ba;
        final /* synthetic */ GoogleApiClient Bb;
        final /* synthetic */ JSONObject Bh;
        final /* synthetic */ double Bk;

        C13239(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, double d, JSONObject jSONObject) {
            this.Ba = remoteMediaPlayer;
            this.Bb = googleApiClient;
            this.Bk = d;
            this.Bh = jSONObject;
        }

        protected void m4376a(gh ghVar) {
            synchronized (this.Ba.ls) {
                this.Ba.AX.m1969b(this.Bb);
                try {
                    this.Ba.AW.m2624a(this.Bq, this.Bk, this.Bh);
                    this.Ba.AX.m1969b(null);
                } catch (IllegalStateException e) {
                    m1984b(m4124l(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.Ba.AX.m1969b(null);
                } catch (IllegalArgumentException e2) {
                    m1984b(m4124l(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.Ba.AX.m1969b(null);
                } catch (IOException e3) {
                    m1984b(m4124l(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.Ba.AX.m1969b(null);
                } catch (Throwable th) {
                    this.Ba.AX.m1969b(null);
                }
            }
        }
    }

    public RemoteMediaPlayer() {
        this.ls = new Object();
        this.AX = new C0625a(this);
        this.AW = new C10261(this);
        this.AW.m1108a(this.AX);
    }

    private void onMetadataUpdated() {
        if (this.AY != null) {
            this.AY.onMetadataUpdated();
        }
    }

    private void onStatusUpdated() {
        if (this.AZ != null) {
            this.AZ.onStatusUpdated();
        }
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.ls) {
            approximateStreamPosition = this.AW.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.ls) {
            mediaInfo = this.AW.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.ls) {
            mediaStatus = this.AW.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.AW.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.ls) {
            streamDuration = this.AW.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo) {
        return load(apiClient, mediaInfo, true, 0, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay) {
        return load(apiClient, mediaInfo, autoplay, 0, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, JSONObject customData) {
        return apiClient.m147b(new C13184(this, apiClient, mediaInfo, autoplay, playPosition, customData));
    }

    public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
        this.AW.ai(message);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient) {
        return pause(apiClient, null);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.m147b(new C13195(this, apiClient, customData));
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient) {
        return play(apiClient, null);
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.m147b(new C13217(this, apiClient, customData));
    }

    public PendingResult<MediaChannelResult> requestStatus(GoogleApiClient apiClient) {
        return apiClient.m147b(new AnonymousClass11(this, apiClient));
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position) {
        return seek(apiClient, position, STATUS_SUCCEEDED, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState) {
        return seek(apiClient, position, resumeState, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState, JSONObject customData) {
        return apiClient.m147b(new C13228(this, apiClient, position, resumeState, customData));
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(GoogleApiClient apiClient, long[] trackIds) {
        return apiClient.m147b(new C13162(this, apiClient, trackIds));
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener listener) {
        this.AY = listener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener listener) {
        this.AZ = listener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState) {
        return setStreamMute(apiClient, muteState, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState, JSONObject customData) {
        return apiClient.m147b(new AnonymousClass10(this, apiClient, muteState, customData));
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume) throws IllegalArgumentException {
        return setStreamVolume(apiClient, volume, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume, JSONObject customData) throws IllegalArgumentException {
        if (!Double.isInfinite(volume) && !Double.isNaN(volume)) {
            return apiClient.m147b(new C13239(this, apiClient, volume, customData));
        }
        throw new IllegalArgumentException("Volume cannot be " + volume);
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(GoogleApiClient apiClient, TextTrackStyle trackStyle) {
        return apiClient.m147b(new C13173(this, apiClient, trackStyle));
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient) {
        return stop(apiClient, null);
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.m147b(new C13206(this, apiClient, customData));
    }
}
