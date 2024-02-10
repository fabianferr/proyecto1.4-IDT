package com.google.ads.interactivemedia.v3.internal;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzer extends WebViewClient {
    final /* synthetic */ zzes zza;

    zzer(zzes zzes) {
        this.zza = zzes;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        this.zza.zzb.zza(str);
        for (CompanionAdSlot.ClickListener onCompanionAdClick : this.zza.zzc) {
            onCompanionAdClick.onCompanionAdClick();
        }
        return true;
    }
}
