package com.google.android.gms.internal.consent_sdk;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.1.0 */
public final class zzcu {
    private static Boolean zza;

    private zzcu() {
    }

    public static void zza(WebView webView, String str) {
        boolean booleanValue;
        synchronized (zzcu.class) {
            if (zza == null) {
                try {
                    webView.evaluateJavascript("(function(){})()", (ValueCallback) null);
                    zza = true;
                } catch (IllegalStateException unused) {
                    zza = false;
                }
            }
            booleanValue = zza.booleanValue();
        }
        if (booleanValue) {
            webView.evaluateJavascript(str, (ValueCallback) null);
        } else {
            webView.loadUrl("javascript:".concat(str));
        }
    }
}
