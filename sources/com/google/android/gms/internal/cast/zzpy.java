package com.google.android.gms.internal.cast;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public abstract class zzpy<V> extends zzqx implements ListenableFuture<V> {
    static final boolean zza;
    private static final Logger zzb;
    /* access modifiers changed from: private */
    public static final zza zzc;
    private static final Object zzd = new Object();
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile zzd listeners;
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile Object value;
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile zzk waiters;

    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    abstract class zza {
        /* synthetic */ zza(zzpx zzpx) {
        }

        /* access modifiers changed from: package-private */
        public abstract zzd zza(zzpy zzpy, zzd zzd);

        /* access modifiers changed from: package-private */
        public abstract zzk zzb(zzpy zzpy, zzk zzk);

        /* access modifiers changed from: package-private */
        public abstract void zzc(zzk zzk, @CheckForNull zzk zzk2);

        /* access modifiers changed from: package-private */
        public abstract void zzd(zzk zzk, Thread thread);

        /* access modifiers changed from: package-private */
        public abstract boolean zze(zzpy zzpy, @CheckForNull zzd zzd, zzd zzd2);

        /* access modifiers changed from: package-private */
        public abstract boolean zzf(zzpy zzpy, @CheckForNull Object obj, Object obj2);

        /* access modifiers changed from: package-private */
        public abstract boolean zzg(zzpy zzpy, @CheckForNull zzk zzk, @CheckForNull zzk zzk2);
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    final class zzb {
        @CheckForNull
        static final zzb zza;
        @CheckForNull
        static final zzb zzb;
        final boolean zzc;
        @CheckForNull
        final Throwable zzd;

        static {
            if (zzpy.zza) {
                zzb = null;
                zza = null;
                return;
            }
            zzb = new zzb(false, (Throwable) null);
            zza = new zzb(true, (Throwable) null);
        }

        zzb(boolean z, @CheckForNull Throwable th) {
            this.zzc = z;
            this.zzd = th;
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") {
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzb;

        zzc(Throwable th) {
            th.getClass();
            this.zzb = th;
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    final class zzd {
        static final zzd zza = new zzd();
        @CheckForNull
        zzd next;
        @CheckForNull
        final Runnable zzb;
        @CheckForNull
        final Executor zzc;

        zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    final class zze extends zza {
        final AtomicReferenceFieldUpdater<zzk, Thread> zza;
        final AtomicReferenceFieldUpdater<zzk, zzk> zzb;
        final AtomicReferenceFieldUpdater<zzpy, zzk> zzc;
        final AtomicReferenceFieldUpdater<zzpy, zzd> zzd;
        final AtomicReferenceFieldUpdater<zzpy, Object> zze;

        zze(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super((zzpx) null);
            this.zza = atomicReferenceFieldUpdater;
            this.zzb = atomicReferenceFieldUpdater2;
            this.zzc = atomicReferenceFieldUpdater3;
            this.zzd = atomicReferenceFieldUpdater4;
            this.zze = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: package-private */
        public final zzd zza(zzpy zzpy, zzd zzd2) {
            return this.zzd.getAndSet(zzpy, zzd2);
        }

        /* access modifiers changed from: package-private */
        public final zzk zzb(zzpy zzpy, zzk zzk) {
            return this.zzc.getAndSet(zzpy, zzk);
        }

        /* access modifiers changed from: package-private */
        public final void zzc(zzk zzk, @CheckForNull zzk zzk2) {
            this.zzb.lazySet(zzk, zzk2);
        }

        /* access modifiers changed from: package-private */
        public final void zzd(zzk zzk, Thread thread) {
            this.zza.lazySet(zzk, thread);
        }

        /* access modifiers changed from: package-private */
        public final boolean zze(zzpy zzpy, @CheckForNull zzd zzd2, zzd zzd3) {
            return zzpz.zza(this.zzd, zzpy, zzd2, zzd3);
        }

        /* access modifiers changed from: package-private */
        public final boolean zzf(zzpy zzpy, @CheckForNull Object obj, Object obj2) {
            return zzpz.zza(this.zze, zzpy, obj, obj2);
        }

        /* access modifiers changed from: package-private */
        public final boolean zzg(zzpy zzpy, @CheckForNull zzk zzk, @CheckForNull zzk zzk2) {
            return zzpz.zza(this.zzc, zzpy, zzk, zzk2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    final class zzf<V> implements Runnable {
        final zzpy<V> zza;
        final ListenableFuture<? extends V> zzb;

        public final void run() {
            throw null;
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    final class zzg extends zza {
        private zzg() {
            super((zzpx) null);
        }

        /* synthetic */ zzg(zzqa zzqa) {
            super((zzpx) null);
        }

        /* access modifiers changed from: package-private */
        public final zzd zza(zzpy zzpy, zzd zzd) {
            zzd zzb;
            synchronized (zzpy) {
                zzb = zzpy.listeners;
                if (zzb != zzd) {
                    zzpy.listeners = zzd;
                }
            }
            return zzb;
        }

        /* access modifiers changed from: package-private */
        public final zzk zzb(zzpy zzpy, zzk zzk) {
            zzk zzc;
            synchronized (zzpy) {
                zzc = zzpy.waiters;
                if (zzc != zzk) {
                    zzpy.waiters = zzk;
                }
            }
            return zzc;
        }

        /* access modifiers changed from: package-private */
        public final void zzc(zzk zzk, @CheckForNull zzk zzk2) {
            zzk.next = zzk2;
        }

        /* access modifiers changed from: package-private */
        public final void zzd(zzk zzk, Thread thread) {
            zzk.thread = thread;
        }

        /* access modifiers changed from: package-private */
        public final boolean zze(zzpy zzpy, @CheckForNull zzd zzd, zzd zzd2) {
            synchronized (zzpy) {
                if (zzpy.listeners != zzd) {
                    return false;
                }
                zzpy.listeners = zzd2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean zzf(zzpy zzpy, @CheckForNull Object obj, Object obj2) {
            synchronized (zzpy) {
                if (zzpy.value != obj) {
                    return false;
                }
                zzpy.value = obj2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean zzg(zzpy zzpy, @CheckForNull zzk zzk, @CheckForNull zzk zzk2) {
            synchronized (zzpy) {
                if (zzpy.waiters != zzk) {
                    return false;
                }
                zzpy.waiters = zzk2;
                return true;
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    interface zzh<V> extends ListenableFuture<V> {
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    abstract class zzi<V> extends zzpy<V> implements zzh<V> {
        zzi() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    final class zzj extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x005e, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x006a, code lost:
            throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:3:?, code lost:
            r0 = (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.android.gms.internal.cast.zzpy.zzj.AnonymousClass1());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0005 */
        static {
            /*
                sun.misc.Unsafe r0 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0005 }
                goto L_0x0010
            L_0x0005:
                com.google.android.gms.internal.cast.zzpy$zzj$1 r0 = new com.google.android.gms.internal.cast.zzpy$zzj$1     // Catch:{ PrivilegedActionException -> 0x005e }
                r0.<init>()     // Catch:{ PrivilegedActionException -> 0x005e }
                java.lang.Object r0 = java.security.AccessController.doPrivileged(r0)     // Catch:{ PrivilegedActionException -> 0x005e }
                sun.misc.Unsafe r0 = (sun.misc.Unsafe) r0     // Catch:{ PrivilegedActionException -> 0x005e }
            L_0x0010:
                java.lang.Class<com.google.android.gms.internal.cast.zzpy> r1 = com.google.android.gms.internal.cast.zzpy.class
                java.lang.String r2 = "waiters"
                java.lang.reflect.Field r2 = r1.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0057, RuntimeException -> 0x0055 }
                long r2 = r0.objectFieldOffset(r2)     // Catch:{ NoSuchFieldException -> 0x0057, RuntimeException -> 0x0055 }
                zzc = r2     // Catch:{ NoSuchFieldException -> 0x0057, RuntimeException -> 0x0055 }
                java.lang.String r2 = "listeners"
                java.lang.reflect.Field r2 = r1.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0057, RuntimeException -> 0x0055 }
                long r2 = r0.objectFieldOffset(r2)     // Catch:{ NoSuchFieldException -> 0x0057, RuntimeException -> 0x0055 }
                zzb = r2     // Catch:{ NoSuchFieldException -> 0x0057, RuntimeException -> 0x0055 }
                java.lang.String r2 = "value"
                java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0057, RuntimeException -> 0x0055 }
                long r1 = r0.objectFieldOffset(r1)     // Catch:{ NoSuchFieldException -> 0x0057, RuntimeException -> 0x0055 }
                zzd = r1     // Catch:{ NoSuchFieldException -> 0x0057, RuntimeException -> 0x0055 }
                java.lang.Class<com.google.android.gms.internal.cast.zzpy$zzk> r1 = com.google.android.gms.internal.cast.zzpy.zzk.class
                java.lang.String r2 = "thread"
                java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0057, RuntimeException -> 0x0055 }
                long r1 = r0.objectFieldOffset(r1)     // Catch:{ NoSuchFieldException -> 0x0057, RuntimeException -> 0x0055 }
                zze = r1     // Catch:{ NoSuchFieldException -> 0x0057, RuntimeException -> 0x0055 }
                java.lang.Class<com.google.android.gms.internal.cast.zzpy$zzk> r1 = com.google.android.gms.internal.cast.zzpy.zzk.class
                java.lang.String r2 = "next"
                java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0057, RuntimeException -> 0x0055 }
                long r1 = r0.objectFieldOffset(r1)     // Catch:{ NoSuchFieldException -> 0x0057, RuntimeException -> 0x0055 }
                zzf = r1     // Catch:{ NoSuchFieldException -> 0x0057, RuntimeException -> 0x0055 }
                zza = r0     // Catch:{ NoSuchFieldException -> 0x0057, RuntimeException -> 0x0055 }
                return
            L_0x0055:
                r0 = move-exception
                throw r0
            L_0x0057:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                r1.<init>(r0)
                throw r1
            L_0x005e:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                java.lang.String r2 = "Could not initialize intrinsics"
                java.lang.Throwable r0 = r0.getCause()
                r1.<init>(r2, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzpy.zzj.<clinit>():void");
        }

        private zzj() {
            super((zzpx) null);
        }

        /* synthetic */ zzj(zzqc zzqc) {
            super((zzpx) null);
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        final com.google.android.gms.internal.cast.zzpy.zzd zza(com.google.android.gms.internal.cast.zzpy r3, com.google.android.gms.internal.cast.zzpy.zzd r4) {
            /*
                r2 = this;
            L_0x0000:
                com.google.android.gms.internal.cast.zzpy$zzd r0 = r3.listeners
                if (r4 != r0) goto L_0x0007
                return r0
            L_0x0007:
                boolean r1 = r2.zze(r3, r0, r4)
                if (r1 == 0) goto L_0x0000
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzpy.zzj.zza(com.google.android.gms.internal.cast.zzpy, com.google.android.gms.internal.cast.zzpy$zzd):com.google.android.gms.internal.cast.zzpy$zzd");
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        final com.google.android.gms.internal.cast.zzpy.zzk zzb(com.google.android.gms.internal.cast.zzpy r3, com.google.android.gms.internal.cast.zzpy.zzk r4) {
            /*
                r2 = this;
            L_0x0000:
                com.google.android.gms.internal.cast.zzpy$zzk r0 = r3.waiters
                if (r4 != r0) goto L_0x0007
                return r0
            L_0x0007:
                boolean r1 = r2.zzg(r3, r0, r4)
                if (r1 == 0) goto L_0x0000
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzpy.zzj.zzb(com.google.android.gms.internal.cast.zzpy, com.google.android.gms.internal.cast.zzpy$zzk):com.google.android.gms.internal.cast.zzpy$zzk");
        }

        /* access modifiers changed from: package-private */
        public final void zzc(zzk zzk, @CheckForNull zzk zzk2) {
            zza.putObject(zzk, zzf, zzk2);
        }

        /* access modifiers changed from: package-private */
        public final void zzd(zzk zzk, Thread thread) {
            zza.putObject(zzk, zze, thread);
        }

        /* access modifiers changed from: package-private */
        public final boolean zze(zzpy zzpy, @CheckForNull zzd zzd2, zzd zzd3) {
            return zzqb.zza(zza, zzpy, zzb, zzd2, zzd3);
        }

        /* access modifiers changed from: package-private */
        public final boolean zzf(zzpy zzpy, @CheckForNull Object obj, Object obj2) {
            return zzqb.zza(zza, zzpy, zzd, obj, obj2);
        }

        /* access modifiers changed from: package-private */
        public final boolean zzg(zzpy zzpy, @CheckForNull zzk zzk, @CheckForNull zzk zzk2) {
            return zzqb.zza(zza, zzpy, zzc, zzk, zzk2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    final class zzk {
        static final zzk zza = new zzk(false);
        @CheckForNull
        volatile zzk next;
        @CheckForNull
        volatile Thread thread;

        zzk() {
            zzpy.zzc.zzd(this, Thread.currentThread());
        }

        zzk(boolean z) {
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        zza zza2;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        zza = z;
        Class<zzpy> cls = zzpy.class;
        zzb = Logger.getLogger(cls.getName());
        try {
            zza2 = new zzj((zzqc) null);
            th2 = null;
            th = null;
        } catch (Error | RuntimeException e) {
            try {
                th2 = e;
                zza2 = new zze(AtomicReferenceFieldUpdater.newUpdater(zzk.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(zzk.class, zzk.class, "next"), AtomicReferenceFieldUpdater.newUpdater(cls, zzk.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(cls, zzd.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "value"));
                th = null;
            } catch (Error | RuntimeException e2) {
                th = e2;
                th2 = e;
                zza2 = new zzg((zzqa) null);
            }
        }
        zzc = zza2;
        if (th != null) {
            Logger logger = zzb;
            logger.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            logger.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    protected zzpy() {
    }

    private static Object zzn(ListenableFuture listenableFuture) {
        Throwable zzf2;
        if (listenableFuture instanceof zzh) {
            Object obj = ((zzpy) listenableFuture).value;
            if (obj instanceof zzb) {
                zzb zzb2 = (zzb) obj;
                if (zzb2.zzc) {
                    Throwable th = zzb2.zzd;
                    obj = th != null ? new zzb(false, th) : zzb.zzb;
                }
            }
            obj.getClass();
            return obj;
        } else if ((listenableFuture instanceof zzqx) && (zzf2 = ((zzqx) listenableFuture).zzf()) != null) {
            return new zzc(zzf2);
        } else {
            boolean isCancelled = listenableFuture.isCancelled();
            if ((!zza) && isCancelled) {
                zzb zzb3 = zzb.zzb;
                zzb3.getClass();
                return zzb3;
            }
            try {
                Object zzo = zzo(listenableFuture);
                if (!isCancelled) {
                    return zzo == null ? zzd : zzo;
                }
                String valueOf = String.valueOf(listenableFuture);
                return new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + valueOf));
            } catch (ExecutionException e) {
                if (isCancelled) {
                    return new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(String.valueOf(listenableFuture))), e));
                }
                return new zzc(e.getCause());
            } catch (CancellationException e2) {
                if (!isCancelled) {
                    return new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(String.valueOf(listenableFuture))), e2));
                }
                return new zzb(false, e2);
            } catch (Error | RuntimeException e3) {
                return new zzc(e3);
            }
        }
    }

    private static Object zzo(Future future) throws ExecutionException {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private final void zzp(StringBuilder sb) {
        try {
            Object zzo = zzo(this);
            sb.append("SUCCESS, result=[");
            if (zzo == null) {
                sb.append(AbstractJsonLexerKt.NULL);
            } else if (zzo == this) {
                sb.append("this future");
            } else {
                sb.append(zzo.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(zzo)));
            }
            sb.append("]");
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private final void zzq(StringBuilder sb) {
        String str;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.value;
        if (obj instanceof zzf) {
            sb.append(", setFuture=[");
            zzr(sb, ((zzf) obj).zzb);
            sb.append("]");
        } else {
            try {
                str = zzew.zza(zze());
            } catch (RuntimeException | StackOverflowError e) {
                str = "Exception thrown from implementation: ".concat(String.valueOf(String.valueOf(e.getClass())));
            }
            if (str != null) {
                sb.append(", info=[");
                sb.append(str);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            zzp(sb);
        }
    }

    private final void zzr(StringBuilder sb, @CheckForNull Object obj) {
        if (obj == this) {
            try {
                sb.append("this future");
            } catch (RuntimeException | StackOverflowError e) {
                sb.append("Exception thrown from implementation: ");
                sb.append(e.getClass());
            }
        } else {
            sb.append(obj);
        }
    }

    private static void zzs(zzpy<V> zzpy, boolean z) {
        zzd zzd2 = null;
        while (true) {
            for (zzk zzb2 = zzc.zzb(zzpy, zzk.zza); zzb2 != null; zzb2 = zzb2.next) {
                Thread thread = zzb2.thread;
                if (thread != null) {
                    zzb2.thread = null;
                    LockSupport.unpark(thread);
                }
            }
            zzpy.zzj();
            zzd zzd3 = zzd2;
            zzd zza2 = zzc.zza(zzpy, zzd.zza);
            zzd zzd4 = zzd3;
            while (zza2 != null) {
                zzd zzd5 = zza2.next;
                zza2.next = zzd4;
                zzd4 = zza2;
                zza2 = zzd5;
            }
            while (true) {
                if (zzd4 != null) {
                    zzd2 = zzd4.next;
                    Runnable runnable = zzd4.zzb;
                    runnable.getClass();
                    if (runnable instanceof zzf) {
                        zzf zzf2 = (zzf) runnable;
                        zzpy = zzf2.zza;
                        if (zzpy.value == zzf2) {
                            if (zzc.zzf(zzpy, zzf2, zzn(zzf2.zzb))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        Executor executor = zzd4.zzc;
                        executor.getClass();
                        zzt(runnable, executor);
                    }
                    zzd4 = zzd2;
                } else {
                    return;
                }
            }
        }
    }

    private static void zzt(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = zzb;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + valueOf + " with executor " + valueOf2, e);
        }
    }

    private final void zzu(zzk zzk2) {
        zzk2.thread = null;
        while (true) {
            zzk zzk3 = this.waiters;
            if (zzk3 != zzk.zza) {
                zzk zzk4 = null;
                while (zzk3 != null) {
                    zzk zzk5 = zzk3.next;
                    if (zzk3.thread != null) {
                        zzk4 = zzk3;
                    } else if (zzk4 != null) {
                        zzk4.next = zzk5;
                        if (zzk4.thread == null) {
                        }
                    } else if (!zzc.zzg(this, zzk3, zzk5)) {
                    }
                    zzk3 = zzk5;
                }
                return;
            }
            return;
        }
    }

    private static final Object zzv(Object obj) throws ExecutionException {
        if (obj instanceof zzb) {
            Throwable th = ((zzb) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        } else if (obj == zzd) {
            return null;
        } else {
            return obj;
        }
    }

    public final void addListener(Runnable runnable, Executor executor) {
        zzd zzd2;
        zzeu.zzc(runnable, "Runnable was null.");
        zzeu.zzc(executor, "Executor was null.");
        if (isDone() || (zzd2 = this.listeners) == zzd.zza) {
            zzt(runnable, executor);
        }
        zzd zzd3 = new zzd(runnable, executor);
        do {
            zzd3.next = zzd2;
            if (!zzc.zze(this, zzd2, zzd3)) {
                zzd2 = this.listeners;
            } else {
                return;
            }
        } while (zzd2 != zzd.zza);
        zzt(runnable, executor);
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [com.google.common.util.concurrent.ListenableFuture, com.google.common.util.concurrent.ListenableFuture<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            boolean r1 = r0 instanceof com.google.android.gms.internal.cast.zzpy.zzf
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x000a
            r4 = 1
            goto L_0x000b
        L_0x000a:
            r4 = 0
        L_0x000b:
            r1 = r1 | r4
            if (r1 == 0) goto L_0x005f
            boolean r1 = zza
            if (r1 == 0) goto L_0x001f
            com.google.android.gms.internal.cast.zzpy$zzb r1 = new com.google.android.gms.internal.cast.zzpy$zzb
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r1.<init>(r8, r4)
            goto L_0x0029
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            com.google.android.gms.internal.cast.zzpy$zzb r1 = com.google.android.gms.internal.cast.zzpy.zzb.zza
            goto L_0x0026
        L_0x0024:
            com.google.android.gms.internal.cast.zzpy$zzb r1 = com.google.android.gms.internal.cast.zzpy.zzb.zzb
        L_0x0026:
            r1.getClass()
        L_0x0029:
            r5 = 0
            r4 = r7
        L_0x002b:
            com.google.android.gms.internal.cast.zzpy$zza r6 = zzc
            boolean r6 = r6.zzf(r4, r0, r1)
            if (r6 == 0) goto L_0x0058
            zzs(r4, r8)
            boolean r4 = r0 instanceof com.google.android.gms.internal.cast.zzpy.zzf
            if (r4 == 0) goto L_0x0056
            com.google.android.gms.internal.cast.zzpy$zzf r0 = (com.google.android.gms.internal.cast.zzpy.zzf) r0
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r0.zzb
            boolean r4 = r0 instanceof com.google.android.gms.internal.cast.zzpy.zzh
            if (r4 == 0) goto L_0x0053
            r4 = r0
            com.google.android.gms.internal.cast.zzpy r4 = (com.google.android.gms.internal.cast.zzpy) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L_0x004b
            r5 = 1
            goto L_0x004c
        L_0x004b:
            r5 = 0
        L_0x004c:
            boolean r6 = r0 instanceof com.google.android.gms.internal.cast.zzpy.zzf
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0056
            r5 = 1
            goto L_0x002b
        L_0x0053:
            r0.cancel(r8)
        L_0x0056:
            r2 = 1
            goto L_0x005f
        L_0x0058:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof com.google.android.gms.internal.cast.zzpy.zzf
            if (r6 != 0) goto L_0x002b
            r2 = r5
        L_0x005f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzpy.cancel(boolean):boolean");
    }

    public final Object get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof zzf))) {
                return zzv(obj2);
            }
            zzk zzk2 = this.waiters;
            if (zzk2 != zzk.zza) {
                zzk zzk3 = new zzk();
                do {
                    zza zza2 = zzc;
                    zza2.zzc(zzk3, zzk2);
                    if (zza2.zzg(this, zzk2, zzk3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                zzu(zzk3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof zzf))));
                        return zzv(obj);
                    }
                    zzk2 = this.waiters;
                } while (zzk2 != zzk.zza);
            }
            Object obj3 = this.value;
            obj3.getClass();
            return zzv(obj3);
        }
        throw new InterruptedException();
    }

    public final boolean isCancelled() {
        return this.value instanceof zzb;
    }

    public final boolean isDone() {
        Object obj = this.value;
        boolean z = true;
        boolean z2 = !(obj instanceof zzf);
        if (obj == null) {
            z = false;
        }
        return z & z2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (this.value instanceof zzb) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzp(sb);
        } else {
            zzq(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public String zze() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        return "remaining delay=[" + delay + " ms]";
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final Throwable zzf() {
        if (!(this instanceof zzh)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void zzj() {
    }

    /* access modifiers changed from: protected */
    public final boolean zzk(Object obj) {
        if (obj == null) {
            obj = zzd;
        }
        if (!zzc.zzf(this, (Object) null, obj)) {
            return false;
        }
        zzs(this, false);
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean zzl(Throwable th) {
        if (!zzc.zzf(this, (Object) null, new zzc(th))) {
            return false;
        }
        zzs(this, false);
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean zzm() {
        Object obj = this.value;
        return (obj instanceof zzb) && ((zzb) obj).zzc;
    }

    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long j2 = j;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            boolean z = true;
            if ((obj != null) && (!(obj instanceof zzf))) {
                return zzv(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                zzk zzk2 = this.waiters;
                if (zzk2 != zzk.zza) {
                    zzk zzk3 = new zzk();
                    do {
                        zza zza2 = zzc;
                        zza2.zzc(zzk3, zzk2);
                        if (zza2.zzg(this, zzk2, zzk3)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) && (!(obj2 instanceof zzf))) {
                                        return zzv(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    zzu(zzk3);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            zzu(zzk3);
                        } else {
                            zzk2 = this.waiters;
                        }
                    } while (zzk2 != zzk.zza);
                }
                Object obj3 = this.value;
                obj3.getClass();
                return zzv(obj3);
            }
            while (nanos > 0) {
                Object obj4 = this.value;
                if ((obj4 != null) && (!(obj4 instanceof zzf))) {
                    return zzv(obj4);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String zzpy = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String str = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(Locale.ROOT);
            if (nanos + 1000 < 0) {
                String concat = str.concat(" (plus ");
                long j3 = -nanos;
                long convert = timeUnit2.convert(j3, TimeUnit.NANOSECONDS);
                long nanos2 = j3 - timeUnit2.toNanos(convert);
                if (convert != 0 && nanos2 <= 1000) {
                    z = false;
                }
                if (convert > 0) {
                    String str2 = concat + convert + " " + lowerCase;
                    if (z) {
                        str2 = str2.concat(",");
                    }
                    concat = str2.concat(" ");
                }
                if (z) {
                    concat = concat + nanos2 + " nanoseconds ";
                }
                str = concat.concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(str.concat(" but future completed as timeout expired"));
            }
            throw new TimeoutException(str + " for " + zzpy);
        }
        throw new InterruptedException();
    }
}
