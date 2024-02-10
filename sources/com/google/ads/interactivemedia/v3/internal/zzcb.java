package com.google.ads.interactivemedia.v3.internal;

import android.webkit.WebView;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzcb implements Runnable {
    final /* synthetic */ WebView zza;
    final /* synthetic */ String zzb;

    zzcb(zzcc zzcc, WebView webView, String str) {
        this.zza = webView;
        this.zzb = str;
    }

    public final void run() {
        this.zza.loadUrl(this.zzb);
    }
}
