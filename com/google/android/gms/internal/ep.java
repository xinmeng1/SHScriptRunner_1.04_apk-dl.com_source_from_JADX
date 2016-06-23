package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Map;

public final class ep {
    private final Context mContext;
    private int mState;
    private String so;
    private final float sp;
    private float sq;
    private float sr;
    private float ss;

    /* renamed from: com.google.android.gms.internal.ep.1 */
    class C03421 implements OnClickListener {
        final /* synthetic */ String st;
        final /* synthetic */ ep su;

        C03421(ep epVar, String str) {
            this.su = epVar;
            this.st = str;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.su.mContext.startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", this.st), "Share via"));
        }
    }

    /* renamed from: com.google.android.gms.internal.ep.2 */
    class C03432 implements OnClickListener {
        final /* synthetic */ ep su;

        C03432(ep epVar) {
            this.su = epVar;
        }

        public void onClick(DialogInterface dialog, int which) {
        }
    }

    public ep(Context context) {
        this.mState = 0;
        this.mContext = context;
        this.sp = context.getResources().getDisplayMetrics().density;
    }

    public ep(Context context, String str) {
        this(context);
        this.so = str;
    }

    private void m994a(int i, float f, float f2) {
        if (i == 0) {
            this.mState = 0;
            this.sq = f;
            this.sr = f2;
            this.ss = f2;
        } else if (this.mState == -1) {
        } else {
            if (i == 2) {
                if (f2 > this.sr) {
                    this.sr = f2;
                } else if (f2 < this.ss) {
                    this.ss = f2;
                }
                if (this.sr - this.ss > BitmapDescriptorFactory.HUE_ORANGE * this.sp) {
                    this.mState = -1;
                    return;
                }
                if (this.mState == 0 || this.mState == 2) {
                    if (f - this.sq >= 50.0f * this.sp) {
                        this.sq = f;
                        this.mState++;
                    }
                } else if ((this.mState == 1 || this.mState == 3) && f - this.sq <= -50.0f * this.sp) {
                    this.sq = f;
                    this.mState++;
                }
                if (this.mState == 1 || this.mState == 3) {
                    if (f > this.sq) {
                        this.sq = f;
                    }
                } else if (this.mState == 2 && f < this.sq) {
                    this.sq = f;
                }
            } else if (i == 1 && this.mState == 4) {
                showDialog();
            }
        }
    }

    private void showDialog() {
        Object obj;
        if (TextUtils.isEmpty(this.so)) {
            obj = "No debug information";
        } else {
            Uri build = new Builder().encodedQuery(this.so).build();
            StringBuilder stringBuilder = new StringBuilder();
            Map c = eo.m983c(build);
            for (String str : c.keySet()) {
                stringBuilder.append(str).append(" = ").append((String) c.get(str)).append("\n\n");
            }
            obj = stringBuilder.toString().trim();
            if (TextUtils.isEmpty(obj)) {
                obj = "No debug information";
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setMessage(obj);
        builder.setTitle("Ad Information");
        builder.setPositiveButton("Share", new C03421(this, obj));
        builder.setNegativeButton("Close", new C03432(this));
        builder.create().show();
    }

    public void m995c(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            m994a(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        m994a(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }

    public void m996x(String str) {
        this.so = str;
    }
}
