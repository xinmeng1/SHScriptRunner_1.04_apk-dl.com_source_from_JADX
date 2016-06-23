package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public final class cc {
    public static boolean m847a(Context context, ce ceVar, cl clVar) {
        if (ceVar == null) {
            eu.m1014D("No intent data for launcher overlay.");
            return false;
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(ceVar.ob)) {
            eu.m1014D("Open GMSG did not contain a URL.");
            return false;
        }
        if (TextUtils.isEmpty(ceVar.mimeType)) {
            intent.setData(Uri.parse(ceVar.ob));
        } else {
            intent.setDataAndType(Uri.parse(ceVar.ob), ceVar.mimeType);
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(ceVar.packageName)) {
            intent.setPackage(ceVar.packageName);
        }
        if (!TextUtils.isEmpty(ceVar.oc)) {
            String[] split = ceVar.oc.split("/", 2);
            if (split.length < 2) {
                eu.m1014D("Could not parse component name from open GMSG: " + ceVar.oc);
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        try {
            eu.m1013C("Launching an intent: " + intent);
            context.startActivity(intent);
            clVar.m864Y();
            return true;
        } catch (ActivityNotFoundException e) {
            eu.m1014D(e.getMessage());
            return false;
        }
    }
}
