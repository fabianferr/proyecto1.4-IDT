package com.google.android.gms.internal.cast;

import com.google.android.gms.internal.cast.zzpy;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzqs extends zzpy.zzi implements Runnable {
    private final Runnable zzb;

    public zzqs(Runnable runnable) {
        runnable.getClass();
        this.zzb = runnable;
    }

    /* access modifiers changed from: protected */
    public final String zze() {
        String obj = this.zzb.toString();
        return "task=[" + obj + "]";
    }

    public final void run() {
        try {
            this.zzb.run();
        } catch (Error | RuntimeException e) {
            zzl(e);
            throw e;
        }
    }
}
