package com.google.ads.interactivemedia.v3.internal;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzfs extends WebViewClient {
    final /* synthetic */ zzft zza;

    zzfs(zzft zzft) {
        this.zza = zzft;
    }

    public final void onPageFinished(WebView webView, String str) {
        zzhd.zzc("Finished loading WebView".concat(String.valueOf(str)));
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        zzhd.zzc("Started loading WebView".concat(String.valueOf(str)));
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        zzhd.zzc("Error: " + i + " " + str + " " + str2);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!str.startsWith("gmsg://")) {
            return false;
        }
        this.zza.zzf(str, "0");
        return true;
    }
}
