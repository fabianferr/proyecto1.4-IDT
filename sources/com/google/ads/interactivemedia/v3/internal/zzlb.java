package com.google.ads.interactivemedia.v3.internal;

import android.app.AppOpsManager;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzlb implements AppOpsManager.OnOpActiveChangedListener {
    final /* synthetic */ zzlc zza;

    zzlb(zzlc zzlc) {
        this.zza = zzlc;
    }

    public final void onOpActiveChanged(String str, int i, String str2, boolean z) {
        if (z) {
            this.zza.zzb = System.currentTimeMillis();
            this.zza.zze = true;
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        zzlc zzlc = this.zza;
        if (zzlc.zzc > 0 && currentTimeMillis >= zzlc.zzc) {
            zzlc.zzd = currentTimeMillis - zzlc.zzc;
        }
        this.zza.zze = false;
    }
}
