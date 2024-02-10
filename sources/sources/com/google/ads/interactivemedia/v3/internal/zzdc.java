package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzdc {
    private final BlockingQueue zza;
    private final ThreadPoolExecutor zzb;
    private final ArrayDeque zzc = new ArrayDeque();
    private zzdb zzd = null;

    public zzdc() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.zza = linkedBlockingQueue;
        this.zzb = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private final void zzc() {
        zzdb zzdb = (zzdb) this.zzc.poll();
        this.zzd = zzdb;
        if (zzdb != null) {
            zzdb.executeOnExecutor(this.zzb, new Object[0]);
        }
    }

    public final void zza(zzdb zzdb) {
        this.zzd = null;
        zzc();
    }

    public final void zzb(zzdb zzdb) {
        zzdb.zzb(this);
        this.zzc.add(zzdb);
        if (this.zzd == null) {
            zzc();
        }
    }
}
