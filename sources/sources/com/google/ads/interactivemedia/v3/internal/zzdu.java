package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.StreamRequest;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzdu implements Runnable {
    public final /* synthetic */ zzec zza;
    public final /* synthetic */ StreamRequest zzb;

    public /* synthetic */ zzdu(zzec zzec, StreamRequest streamRequest) {
        this.zza = zzec;
        this.zzb = streamRequest;
    }

    public final void run() {
        this.zza.zzp(this.zzb);
    }
}
