package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.internal.zzub;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzvu extends zzub.zzi implements Runnable {
    private final Runnable zza;

    public zzvu(Runnable runnable) {
        runnable.getClass();
        this.zza = runnable;
    }

    /* access modifiers changed from: protected */
    public final String zza() {
        String obj = this.zza.toString();
        return "task=[" + obj + "]";
    }

    public final void run() {
        try {
            this.zza.run();
        } catch (Error | RuntimeException e) {
            zzd(e);
            throw e;
        }
    }
}
