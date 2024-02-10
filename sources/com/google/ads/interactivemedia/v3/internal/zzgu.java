package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.impl.data.JavaScriptMsgData;
import java.util.List;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzgu {
    public final boolean zza;
    public final long zzb;
    public final boolean zzc;
    public final boolean zzd;
    public final List zze;
    public final int zzf;

    public zzgu(JavaScriptMsgData javaScriptMsgData) {
        this.zza = javaScriptMsgData.disableAppSetId;
        this.zzb = javaScriptMsgData.appSetIdTimeoutMs;
        this.zzc = javaScriptMsgData.enableTrustlessGksBc;
        this.zzd = javaScriptMsgData.enableTrustlessGksDai;
        this.zze = javaScriptMsgData.gksFirstPartyAdServers;
        this.zzf = javaScriptMsgData.gksTimeoutMs;
    }
}
