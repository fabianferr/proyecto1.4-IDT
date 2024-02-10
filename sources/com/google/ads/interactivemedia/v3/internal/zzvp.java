package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
abstract class zzvp extends AtomicReference implements Runnable {
    private static final Runnable zza = new zzvo((zzvn) null);
    private static final Runnable zzb = new zzvo((zzvn) null);

    zzvp() {
    }

    private final void zzc(Thread thread) {
        Runnable runnable = (Runnable) get();
        zzvm zzvm = null;
        boolean z = false;
        int i = 0;
        while (true) {
            if (!(runnable instanceof zzvm)) {
                if (runnable != zzb) {
                    break;
                }
            } else {
                zzvm = (zzvm) runnable;
            }
            i++;
            if (i > 1000) {
                Runnable runnable2 = zzb;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    z = Thread.interrupted() || z;
                    LockSupport.park(zzvm);
                }
            } else {
                Thread.yield();
            }
            runnable = (Runnable) get();
        }
        if (z) {
            thread.interrupt();
        }
    }

    public final void run() {
        Thread currentThread = Thread.currentThread();
        Object obj = null;
        if (compareAndSet((Object) null, currentThread)) {
            boolean z = !zzg();
            if (z) {
                try {
                    obj = zza();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, zza)) {
                        zzc(currentThread);
                    }
                    zze((Object) null);
                    throw th;
                }
            }
            if (!compareAndSet(currentThread, zza)) {
                zzc(currentThread);
            }
            if (z) {
                zze(obj);
            }
        }
    }

    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == zza) {
            str = "running=[DONE]";
        } else if (runnable instanceof zzvm) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            str = "running=[RUNNING ON " + ((Thread) runnable).getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + zzb();
    }

    /* access modifiers changed from: package-private */
    public abstract Object zza() throws Exception;

    /* access modifiers changed from: package-private */
    public abstract String zzb();

    /* access modifiers changed from: package-private */
    public abstract void zzd(Throwable th);

    /* access modifiers changed from: package-private */
    public abstract void zze(Object obj);

    /* access modifiers changed from: package-private */
    public abstract boolean zzg();

    /* access modifiers changed from: package-private */
    public final void zzh() {
        Runnable runnable = (Runnable) get();
        if (runnable instanceof Thread) {
            zzvm zzvm = new zzvm(this, (zzvl) null);
            zzvp.super.setExclusiveOwnerThread(Thread.currentThread());
            if (compareAndSet(runnable, zzvm)) {
                try {
                    Thread thread = (Thread) runnable;
                    thread.interrupt();
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark(thread);
                    }
                } catch (Throwable th) {
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark((Thread) runnable);
                    }
                    throw th;
                }
            }
        }
    }
}
