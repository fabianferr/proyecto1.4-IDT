package com.google.ads.interactivemedia.omid.library.adsession;

import com.google.ads.interactivemedia.v3.internal.zzcn;
import com.google.ads.interactivemedia.v3.internal.zzcp;
import org.json.JSONObject;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzb {
    private final zzh zza;
    private final zzh zzb;
    private final zzf zzc;
    private final zzg zzd;

    private zzb(zzf zzf, zzg zzg, zzh zzh, zzh zzh2, boolean z) {
        this.zzc = zzf;
        this.zzd = zzg;
        this.zza = zzh;
        if (zzh2 == null) {
            this.zzb = zzh.NONE;
        } else {
            this.zzb = zzh2;
        }
    }

    public static zzb zza(zzf zzf, zzg zzg, zzh zzh, zzh zzh2, boolean z) {
        zzcp.zzb(zzf, "CreativeType is null");
        zzcp.zzb(zzg, "ImpressionType is null");
        zzcp.zzb(zzh, "Impression owner is null");
        if (zzh == zzh.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        } else if (zzf == zzf.DEFINED_BY_JAVASCRIPT && zzh == zzh.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        } else if (zzg != zzg.DEFINED_BY_JAVASCRIPT || zzh != zzh.NATIVE) {
            return new zzb(zzf, zzg, zzh, zzh2, true);
        } else {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }

    public final JSONObject zzb() {
        JSONObject jSONObject = new JSONObject();
        zzcn.zze(jSONObject, "impressionOwner", this.zza);
        zzcn.zze(jSONObject, "mediaEventsOwner", this.zzb);
        zzcn.zze(jSONObject, "creativeType", this.zzc);
        zzcn.zze(jSONObject, "impressionType", this.zzd);
        zzcn.zze(jSONObject, "isolateVerificationScripts", true);
        return jSONObject;
    }
}
