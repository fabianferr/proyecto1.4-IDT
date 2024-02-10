package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzhy {
    private final Context zza;
    private AdsRenderingSettings zzb;

    public zzhy(Context context, AdsRenderingSettings adsRenderingSettings) {
        this.zza = context;
        this.zzb = adsRenderingSettings;
    }

    public final void zza(String str) {
        if (this.zzb.getEnableCustomTabs()) {
            new CustomTabsIntent.Builder().build().launchUrl(this.zza, Uri.parse(str));
            return;
        }
        Context context = this.zza;
        if (str != null && str.length() > 0) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public final void zzb(AdsRenderingSettings adsRenderingSettings) {
        this.zzb = adsRenderingSettings;
    }
}
