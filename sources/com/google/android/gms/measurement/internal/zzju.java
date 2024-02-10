package com.google.android.gms.measurement.internal;

import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
public final class zzju extends zzkn {
    public final zzez zza;
    public final zzez zzb;
    public final zzez zzc;
    public final zzez zzd;
    public final zzez zze;
    private final Map zzg = new HashMap();

    zzju(zzkz zzkz) {
        super(zzkz);
        zzfd zzm = this.zzs.zzm();
        zzm.getClass();
        this.zza = new zzez(zzm, "last_delete_stale", 0);
        zzfd zzm2 = this.zzs.zzm();
        zzm2.getClass();
        this.zzb = new zzez(zzm2, "backoff", 0);
        zzfd zzm3 = this.zzs.zzm();
        zzm3.getClass();
        this.zzc = new zzez(zzm3, "last_upload", 0);
        zzfd zzm4 = this.zzs.zzm();
        zzm4.getClass();
        this.zzd = new zzez(zzm4, "last_upload_attempt", 0);
        zzfd zzm5 = this.zzs.zzm();
        zzm5.getClass();
        this.zze = new zzez(zzm5, "midnight_offset", 0);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final Pair zza(String str) {
        zzjt zzjt;
        zzg();
        long elapsedRealtime = this.zzs.zzav().elapsedRealtime();
        zzjt zzjt2 = (zzjt) this.zzg.get(str);
        if (zzjt2 != null && elapsedRealtime < zzjt2.zzc) {
            return new Pair(zzjt2.zza, Boolean.valueOf(zzjt2.zzb));
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        long zzi = elapsedRealtime + this.zzs.zzf().zzi(str, zzeb.zza);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zzs.zzau());
            if (advertisingIdInfo == null) {
                return new Pair("", false);
            }
            String id = advertisingIdInfo.getId();
            if (id != null) {
                zzjt = new zzjt(id, advertisingIdInfo.isLimitAdTrackingEnabled(), zzi);
            } else {
                zzjt = new zzjt("", advertisingIdInfo.isLimitAdTrackingEnabled(), zzi);
            }
            this.zzg.put(str, zzjt);
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
            return new Pair(zzjt.zza, Boolean.valueOf(zzjt.zzb));
        } catch (Exception e) {
            this.zzs.zzay().zzc().zzb("Unable to get advertising id", e);
            zzjt = new zzjt("", false, zzi);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzb() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final Pair zzd(String str, zzai zzai) {
        if (zzai.zzi(zzah.AD_STORAGE)) {
            return zza(str);
        }
        return new Pair("", false);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final String zzf(String str, boolean z) {
        zzg();
        String str2 = z ? (String) zza(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest zzF = zzlh.zzF();
        if (zzF == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzF.digest(str2.getBytes()))});
    }
}
