package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import com.google.android.gms.tagmanager.DataLayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class cj extends FrameLayout implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private final ex lN;
    private final MediaController oI;
    private final C0319a oJ;
    private final VideoView oK;
    private long oL;
    private String oM;

    /* renamed from: com.google.android.gms.internal.cj.a */
    private static final class C0319a {
        private final Runnable lg;
        private volatile boolean oN;

        /* renamed from: com.google.android.gms.internal.cj.a.1 */
        class C03181 implements Runnable {
            private final WeakReference<cj> oO;
            final /* synthetic */ cj oP;
            final /* synthetic */ C0319a oQ;

            C03181(C0319a c0319a, cj cjVar) {
                this.oQ = c0319a;
                this.oP = cjVar;
                this.oO = new WeakReference(this.oP);
            }

            public void run() {
                cj cjVar = (cj) this.oO.get();
                if (!this.oQ.oN && cjVar != null) {
                    cjVar.bb();
                    this.oQ.bc();
                }
            }
        }

        public C0319a(cj cjVar) {
            this.oN = false;
            this.lg = new C03181(this, cjVar);
        }

        public void bc() {
            et.sv.postDelayed(this.lg, 250);
        }

        public void cancel() {
            this.oN = true;
            et.sv.removeCallbacks(this.lg);
        }
    }

    public cj(Context context, ex exVar) {
        super(context);
        this.lN = exVar;
        this.oK = new VideoView(context);
        addView(this.oK, new LayoutParams(-1, -1, 17));
        this.oI = new MediaController(context);
        this.oJ = new C0319a(this);
        this.oJ.bc();
        this.oK.setOnCompletionListener(this);
        this.oK.setOnPreparedListener(this);
        this.oK.setOnErrorListener(this);
    }

    private static void m856a(ex exVar, String str) {
        m859a(exVar, str, new HashMap(1));
    }

    public static void m857a(ex exVar, String str, String str2) {
        Object obj = str2 == null ? 1 : null;
        Map hashMap = new HashMap(obj != null ? 2 : 3);
        hashMap.put("what", str);
        if (obj == null) {
            hashMap.put("extra", str2);
        }
        m859a(exVar, "error", hashMap);
    }

    private static void m858a(ex exVar, String str, String str2, String str3) {
        Map hashMap = new HashMap(2);
        hashMap.put(str2, str3);
        m859a(exVar, str, hashMap);
    }

    private static void m859a(ex exVar, String str, Map<String, String> map) {
        map.put(DataLayer.EVENT_KEY, str);
        exVar.m1029a("onVideoEvent", (Map) map);
    }

    public void m860b(MotionEvent motionEvent) {
        this.oK.dispatchTouchEvent(motionEvent);
    }

    public void ba() {
        if (TextUtils.isEmpty(this.oM)) {
            m857a(this.lN, "no_src", null);
        } else {
            this.oK.setVideoPath(this.oM);
        }
    }

    public void bb() {
        long currentPosition = (long) this.oK.getCurrentPosition();
        if (this.oL != currentPosition) {
            m858a(this.lN, "timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
            this.oL = currentPosition;
        }
    }

    public void destroy() {
        this.oJ.cancel();
        this.oK.stopPlayback();
    }

    public void m861l(boolean z) {
        if (z) {
            this.oK.setMediaController(this.oI);
            return;
        }
        this.oI.hide();
        this.oK.setMediaController(null);
    }

    public void m862o(String str) {
        this.oM = str;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        m856a(this.lN, "ended");
    }

    public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
        m857a(this.lN, String.valueOf(what), String.valueOf(extra));
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        m858a(this.lN, "canplaythrough", "duration", String.valueOf(((float) this.oK.getDuration()) / 1000.0f));
    }

    public void pause() {
        this.oK.pause();
    }

    public void play() {
        this.oK.start();
    }

    public void seekTo(int timeInMilliseconds) {
        this.oK.seekTo(timeInMilliseconds);
    }
}
