package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzuh implements Runnable {
    public final /* synthetic */ zzui zza;

    public /* synthetic */ zzuh(zzui zzui, zzsk zzsk) {
        this.zza = zzui;
    }

    public final void run() {
        zzui zzui = this.zza;
        int zzt = zzui.zzt();
        zzrm.zzh(zzt >= 0, "Less than 0 remaining futures");
        if (zzt == 0) {
            zzui.zzv();
            zzui.zzp();
            zzui.zzr(2);
        }
    }
}
