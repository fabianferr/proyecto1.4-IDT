package com.google.android.gms.internal.atv_ads_framework;

import android.net.Uri;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
public final class zzc {
    public static final Uri zza;
    public static final Uri zzb;
    private static final Uri zzc;

    static {
        Uri build = new Uri.Builder().scheme("content").appendPath("signals").build();
        zzc = build;
        zza = build.buildUpon().authority("com.google.android.apps.tv.launcherx.ads.signals.AdsSignalsContentProvider").build();
        zzb = build.buildUpon().authority("com.google.android.tvrecommendations.ads.signals.AdsSignalsContentProvider").build();
    }
}
