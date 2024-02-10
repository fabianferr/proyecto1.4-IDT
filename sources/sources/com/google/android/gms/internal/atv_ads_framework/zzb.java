package com.google.android.gms.internal.atv_ads_framework;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
public enum zzb {
    BUILD_FINGERPRINT_PREFIX("atv_bfp"),
    LAUNCHER_TYPE("atv_lt"),
    OPERATOR_TIER("atv_ot"),
    SDK_VERSION("atv_asv"),
    LAUNCHERX_VERSION_CODE("atv_lxvc"),
    TVLAUNCHER_VERSION_CODE("atv_tlvc"),
    TVRECOMMENDATIONS_VERSION_CODE("atv_csvc");
    
    private final String zzi;

    private zzb(String str) {
        zzn.zzc(str.startsWith("atv_"));
        zzn.zzc(!str.endsWith("_tva"));
        this.zzi = str;
    }

    public final String zza() {
        return this.zzi;
    }
}
