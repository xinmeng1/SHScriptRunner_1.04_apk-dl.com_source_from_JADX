package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

class cy {

    /* renamed from: com.google.android.gms.tagmanager.cy.1 */
    static class C05021 implements Runnable {
        final /* synthetic */ Editor ahW;

        C05021(Editor editor) {
            this.ahW = editor;
        }

        public void run() {
            this.ahW.commit();
        }
    }

    static void m1714a(Context context, String str, String str2, String str3) {
        Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        m1715a(edit);
    }

    static void m1715a(Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            new Thread(new C05021(editor)).start();
        }
    }
}
