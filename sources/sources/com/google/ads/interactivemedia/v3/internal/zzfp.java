package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.webkit.WebView;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzfp implements WebViewCompat.WebMessageListener {
    final /* synthetic */ zzft zza;

    zzfp(zzft zzft) {
        this.zza = zzft;
    }

    public final void onPostMessage(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z, JavaScriptReplyProxy javaScriptReplyProxy) {
        this.zza.zzf(webMessageCompat.getData(), "4");
    }
}
