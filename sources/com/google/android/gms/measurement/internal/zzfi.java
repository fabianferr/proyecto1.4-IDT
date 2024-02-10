package com.google.android.gms.measurement.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
public final /* synthetic */ class zzfi implements Callable {
    public final /* synthetic */ zzfp zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzfi(zzfp zzfp, String str) {
        this.zza = zzfp;
        this.zzb = str;
    }

    public final Object call() {
        zzfp zzfp = this.zza;
        String str = this.zzb;
        zzh zzj = zzfp.zzf.zzi().zzj(str);
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put(CampaignEx.JSON_KEY_PACKAGE_NAME, str);
        zzfp.zzs.zzf().zzh();
        hashMap.put("gmp_version", 73000L);
        if (zzj != null) {
            String zzw = zzj.zzw();
            if (zzw != null) {
                hashMap.put("app_version", zzw);
            }
            hashMap.put("app_version_int", Long.valueOf(zzj.zzb()));
            hashMap.put("dynamite_version", Long.valueOf(zzj.zzk()));
        }
        return hashMap;
    }
}
