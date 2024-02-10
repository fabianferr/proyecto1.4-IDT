package com.google.ads.interactivemedia.v3.internal;

import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzkn implements zzql {
    private final zzpa zza;
    private final zzpp zzb;
    private final zzla zzc;
    private final zzkm zzd;
    private final zzjw zze;
    private final zzlc zzf;
    private final zzku zzg;
    private final zzkl zzh;

    zzkn(zzpa zzpa, zzpp zzpp, zzla zzla, zzkm zzkm, zzjw zzjw, zzlc zzlc, zzku zzku, zzkl zzkl) {
        this.zza = zzpa;
        this.zzb = zzpp;
        this.zzc = zzla;
        this.zzd = zzkm;
        this.zze = zzjw;
        this.zzf = zzlc;
        this.zzg = zzku;
        this.zzh = zzkl;
    }

    private final Map zze() {
        HashMap hashMap = new HashMap();
        zzbc zzb2 = this.zzb.zzb();
        hashMap.put("v", this.zza.zzb());
        hashMap.put("gms", Boolean.valueOf(this.zza.zzc()));
        hashMap.put("int", zzb2.zzg());
        hashMap.put("up", Boolean.valueOf(this.zzd.zza()));
        hashMap.put("t", new Throwable());
        zzku zzku = this.zzg;
        if (zzku != null) {
            hashMap.put("tcq", Long.valueOf(zzku.zzc()));
            hashMap.put("tpq", Long.valueOf(this.zzg.zzg()));
            hashMap.put("tcv", Long.valueOf(this.zzg.zzd()));
            hashMap.put("tpv", Long.valueOf(this.zzg.zzh()));
            hashMap.put("tchv", Long.valueOf(this.zzg.zzb()));
            hashMap.put("tphv", Long.valueOf(this.zzg.zzf()));
            hashMap.put("tcc", Long.valueOf(this.zzg.zza()));
            hashMap.put("tpc", Long.valueOf(this.zzg.zze()));
        }
        return hashMap;
    }

    public final Map zza() {
        Map zze2 = zze();
        zze2.put("lts", Long.valueOf(this.zzc.zza()));
        return zze2;
    }

    public final Map zzb() {
        Map zze2 = zze();
        zzbc zza2 = this.zzb.zza();
        zze2.put("gai", Boolean.valueOf(this.zza.zzd()));
        zze2.put("did", zza2.zzf());
        zze2.put("dst", Integer.valueOf(zza2.zzal() - 1));
        zze2.put("doo", Boolean.valueOf(zza2.zzai()));
        zzjw zzjw = this.zze;
        if (zzjw != null) {
            zze2.put("nt", Long.valueOf(zzjw.zza()));
        }
        zzlc zzlc = this.zzf;
        if (zzlc != null) {
            zze2.put("vs", Long.valueOf(zzlc.zzc()));
            zze2.put("vf", Long.valueOf(this.zzf.zzb()));
        }
        return zze2;
    }

    public final Map zzc() {
        Map zze2 = zze();
        zzkl zzkl = this.zzh;
        if (zzkl != null) {
            zze2.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST, zzkl.zza());
        }
        return zze2;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(View view) {
        this.zzc.zzd(view);
    }
}
