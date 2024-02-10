package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import android.webkit.WebView;
import com.google.ads.interactivemedia.v3.impl.data.CompanionData;
import com.google.ads.interactivemedia.v3.impl.data.zzav;
import java.util.List;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzet extends WebView {
    public zzet(Context context, zzfm zzfm, CompanionData companionData, List list, zzhy zzhy) {
        super(context);
        if (Build.VERSION.SDK_INT >= 21) {
            getSettings().setJavaScriptEnabled(true);
        }
        getSettings().setSupportMultipleWindows(true);
        setWebChromeClient(new zzes(this, context, zzhy, list));
        if (companionData.type() == zzav.Html) {
            loadData(Base64.encodeToString(companionData.src().getBytes(), 1), "text/html", "base64");
        } else if (companionData.type() == zzav.IFrame) {
            loadUrl(companionData.src());
        } else {
            String valueOf = String.valueOf(companionData.type());
            throw new IllegalArgumentException("Companion type " + valueOf + " is not valid for a CompanionWebView");
        }
    }
}
