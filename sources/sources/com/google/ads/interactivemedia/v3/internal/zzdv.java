package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdsRequest;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzdv implements Runnable {
    public final /* synthetic */ zzec zza;
    public final /* synthetic */ AdsRequest zzb;

    public /* synthetic */ zzdv(zzec zzec, AdsRequest adsRequest) {
        this.zza = zzec;
        this.zzb = adsRequest;
    }

    public final void run() {
        this.zza.zzo(this.zzb);
    }
}
