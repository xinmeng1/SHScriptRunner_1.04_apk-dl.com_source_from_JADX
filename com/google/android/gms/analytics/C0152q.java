package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* renamed from: com.google.android.gms.analytics.q */
class C0152q extends BroadcastReceiver {
    static final String tR;
    private final af tS;

    static {
        tR = C0152q.class.getName();
    }

    C0152q(af afVar) {
        this.tS = afVar;
    }

    public static void m81w(Context context) {
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(tR, true);
        context.sendBroadcast(intent);
    }

    public void onReceive(Context ctx, Intent intent) {
        boolean z = false;
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            af afVar = this.tS;
            if (!booleanExtra) {
                z = true;
            }
            afVar.m45t(z);
        } else if ("com.google.analytics.RADIO_POWERED".equals(action) && !intent.hasExtra(tR)) {
            this.tS.cI();
        }
    }

    public void m82v(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(this, intentFilter);
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.analytics.RADIO_POWERED");
        intentFilter.addCategory(context.getPackageName());
        context.registerReceiver(this, intentFilter);
    }
}
