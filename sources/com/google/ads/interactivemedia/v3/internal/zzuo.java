package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.internal.zzub;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
class zzuo extends zzub.zzi {
    private static final zzuk zza;
    private static final Logger zzc;
    /* access modifiers changed from: private */
    public volatile int remaining;
    @CheckForNull
    private volatile Set<Throwable> seenExceptions = null;

    static {
        Throwable th;
        zzuk zzuk;
        Class<zzuo> cls = zzuo.class;
        zzc = Logger.getLogger(cls.getName());
        try {
            zzuk = new zzul(AtomicReferenceFieldUpdater.newUpdater(cls, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(cls, "remaining"));
            th = null;
        } catch (Error | RuntimeException e) {
            zzuk = new zzun((zzum) null);
            th = e;
        }
        zza = zzuk;
        if (th != null) {
            zzc.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    zzuo(int i) {
        this.remaining = i;
    }

    /* access modifiers changed from: package-private */
    public final int zzt() {
        return zza.zza(this);
    }

    /* access modifiers changed from: package-private */
    public final void zzv() {
        this.seenExceptions = null;
    }
}
