package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzex {
    private final List zza;
    private final zzhc zzb;

    public zzex() {
        this.zza = new ArrayList(1);
        this.zzb = null;
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "ErrorListenerSupport [errorListeners=" + obj + "]";
    }

    public final void zza(AdErrorEvent.AdErrorListener adErrorListener) {
        this.zza.add(adErrorListener);
    }

    public final void zzb() {
        this.zza.clear();
    }

    public final void zzc(AdErrorEvent adErrorEvent) {
        for (AdErrorEvent.AdErrorListener onAdError : this.zza) {
            onAdError.onAdError(adErrorEvent);
        }
        zzhc zzhc = this.zzb;
        if (zzhc != null) {
            zzhc.zza(adErrorEvent);
        }
    }

    public final void zzd(AdErrorEvent.AdErrorListener adErrorListener) {
        this.zza.remove(adErrorListener);
    }

    public zzex(zzhc zzhc) {
        this.zza = new ArrayList(1);
        this.zzb = zzhc;
    }
}
