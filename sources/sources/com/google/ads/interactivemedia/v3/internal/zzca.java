package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzca {
    private static final zzca zza = new zzca();
    private Context zzb;

    private zzca() {
    }

    public static zzca zzb() {
        return zza;
    }

    public final Context zza() {
        return this.zzb;
    }

    public final void zzc(Context context) {
        this.zzb = context != null ? context.getApplicationContext() : null;
    }
}
