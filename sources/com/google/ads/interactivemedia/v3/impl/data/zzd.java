package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.v3.api.UiElement;
import com.google.ads.interactivemedia.v3.internal.zzqy;
import com.google.ads.interactivemedia.v3.internal.zzso;
import com.google.ads.interactivemedia.v3.internal.zzst;
import javax.annotation.Nullable;

@zzqy(zza = zzk.class)
/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzd {
    public static zzc builder(AdsRenderingSettings adsRenderingSettings) {
        zze zze = (zze) adsRenderingSettings;
        zzi zzi = new zzi();
        zzi.setBitrate(zze.getBitrateKbps());
        zzi.setDisableUi(zze.getDisableUi());
        zzi.setEnablePreloading(zze.getEnablePreloading());
        zzi.setEnableFocusSkipButton(zze.getFocusSkipButtonWhenAvailable());
        zzi.setLoadVideoTimeout(zze.getLoadVideoTimeout());
        zzi.setMimeTypes(zze.getMimeTypes());
        zzi.setPlayAdsAfterTime(zze.getPlayAdsAfterTime());
        zzi.setUiElements(zze.getUiElements());
        return zzi;
    }

    public abstract int bitrate();

    public abstract boolean disableUi();

    public abstract boolean enableFocusSkipButton();

    public abstract boolean enablePreloading();

    public abstract int loadVideoTimeout();

    @Nullable
    public abstract zzso<String> mimeTypes();

    public abstract double playAdsAfterTime();

    @Nullable
    public abstract zzst<UiElement> uiElements();
}
