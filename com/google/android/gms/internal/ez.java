package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;

public class ez extends WebChromeClient {
    private final ex lN;

    /* renamed from: com.google.android.gms.internal.ez.1 */
    static class C03471 implements OnCancelListener {
        final /* synthetic */ JsResult sP;

        C03471(JsResult jsResult) {
            this.sP = jsResult;
        }

        public void onCancel(DialogInterface dialog) {
            this.sP.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.ez.2 */
    static class C03482 implements OnClickListener {
        final /* synthetic */ JsResult sP;

        C03482(JsResult jsResult) {
            this.sP = jsResult;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.sP.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.ez.3 */
    static class C03493 implements OnClickListener {
        final /* synthetic */ JsResult sP;

        C03493(JsResult jsResult) {
            this.sP = jsResult;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.sP.confirm();
        }
    }

    /* renamed from: com.google.android.gms.internal.ez.4 */
    static class C03504 implements OnCancelListener {
        final /* synthetic */ JsPromptResult sQ;

        C03504(JsPromptResult jsPromptResult) {
            this.sQ = jsPromptResult;
        }

        public void onCancel(DialogInterface dialog) {
            this.sQ.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.ez.5 */
    static class C03515 implements OnClickListener {
        final /* synthetic */ JsPromptResult sQ;

        C03515(JsPromptResult jsPromptResult) {
            this.sQ = jsPromptResult;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.sQ.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.ez.6 */
    static class C03526 implements OnClickListener {
        final /* synthetic */ JsPromptResult sQ;
        final /* synthetic */ EditText sR;

        C03526(JsPromptResult jsPromptResult, EditText editText) {
            this.sQ = jsPromptResult;
            this.sR = editText;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.sQ.confirm(this.sR.getText().toString());
        }
    }

    /* renamed from: com.google.android.gms.internal.ez.7 */
    static /* synthetic */ class C03537 {
        static final /* synthetic */ int[] sS;

        static {
            sS = new int[MessageLevel.values().length];
            try {
                sS[MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                sS[MessageLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                sS[MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                sS[MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                sS[MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public ez(ex exVar) {
        this.lN = exVar;
    }

    private static void m1046a(Builder builder, String str, JsResult jsResult) {
        builder.setMessage(str).setPositiveButton(17039370, new C03493(jsResult)).setNegativeButton(17039360, new C03482(jsResult)).setOnCancelListener(new C03471(jsResult)).create().show();
    }

    private static void m1047a(Context context, Builder builder, String str, String str2, JsPromptResult jsPromptResult) {
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        View textView = new TextView(context);
        textView.setText(str);
        View editText = new EditText(context);
        editText.setText(str2);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView(linearLayout).setPositiveButton(17039370, new C03526(jsPromptResult, editText)).setNegativeButton(17039360, new C03515(jsPromptResult)).setOnCancelListener(new C03504(jsPromptResult)).create().show();
    }

    protected final void m1048a(View view, int i, CustomViewCallback customViewCallback) {
        cf ca = this.lN.ca();
        if (ca == null) {
            eu.m1014D("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        ca.m3565a(view, customViewCallback);
        ca.setRequestedOrientation(i);
    }

    protected boolean m1049a(Context context, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        try {
            Builder builder = new Builder(context);
            builder.setTitle(str);
            if (z) {
                m1047a(context, builder, str2, str3, jsPromptResult);
            } else {
                m1046a(builder, str2, jsResult);
            }
        } catch (Throwable e) {
            eu.m1017c("Fail to display Dialog.", e);
        }
        return true;
    }

    public final void onCloseWindow(WebView webView) {
        if (webView instanceof ex) {
            cf ca = ((ex) webView).ca();
            if (ca == null) {
                eu.m1014D("Tried to close an AdWebView not associated with an overlay.");
                return;
            } else {
                ca.close();
                return;
            }
        }
        eu.m1014D("Tried to close a WebView that wasn't an AdWebView.");
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        switch (C03537.sS[consoleMessage.messageLevel().ordinal()]) {
            case DataEvent.TYPE_CHANGED /*1*/:
                eu.m1011A(str);
                break;
            case DataEvent.TYPE_DELETED /*2*/:
                eu.m1014D(str);
                break;
            case DetectedActivity.STILL /*3*/:
            case DetectedActivity.UNKNOWN /*4*/:
                eu.m1012B(str);
                break;
            case DetectedActivity.TILTING /*5*/:
                eu.m1019z(str);
                break;
            default:
                eu.m1012B(str);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
        WebViewTransport webViewTransport = (WebViewTransport) resultMsg.obj;
        WebView webView = new WebView(view.getContext());
        webView.setWebViewClient(this.lN.cb());
        webViewTransport.setWebView(webView);
        resultMsg.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String url, String databaseIdentifier, long currentQuota, long estimatedSize, long totalUsedQuota, QuotaUpdater quotaUpdater) {
        long j = 5242880 - totalUsedQuota;
        if (j <= 0) {
            quotaUpdater.updateQuota(currentQuota);
            return;
        }
        if (currentQuota == 0) {
            if (estimatedSize > j || estimatedSize > 1048576) {
                estimatedSize = 0;
            }
        } else if (estimatedSize == 0) {
            estimatedSize = Math.min(Math.min(131072, j) + currentQuota, 1048576);
        } else {
            if (estimatedSize <= Math.min(1048576 - currentQuota, j)) {
                currentQuota += estimatedSize;
            }
            estimatedSize = currentQuota;
        }
        quotaUpdater.updateQuota(estimatedSize);
    }

    public final void onHideCustomView() {
        cf ca = this.lN.ca();
        if (ca == null) {
            eu.m1014D("Could not get ad overlay when hiding custom view.");
        } else {
            ca.aR();
        }
    }

    public final boolean onJsAlert(WebView webView, String url, String message, JsResult result) {
        return (!(webView instanceof ex) || ((ex) webView).cf() == null) ? m1049a(webView.getContext(), url, message, null, result, null, false) : m1049a(((ex) webView).cf(), url, message, null, result, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String url, String message, JsResult result) {
        return m1049a(webView.getContext(), url, message, null, result, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String url, String message, JsResult result) {
        return m1049a(webView.getContext(), url, message, null, result, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String url, String message, String defaultValue, JsPromptResult result) {
        return m1049a(webView.getContext(), url, message, defaultValue, null, result, true);
    }

    public final void onReachedMaxAppCacheSize(long spaceNeeded, long totalUsedQuota, QuotaUpdater quotaUpdater) {
        long j = 131072 + spaceNeeded;
        if (5242880 - totalUsedQuota < j) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        m1048a(view, -1, customViewCallback);
    }
}
