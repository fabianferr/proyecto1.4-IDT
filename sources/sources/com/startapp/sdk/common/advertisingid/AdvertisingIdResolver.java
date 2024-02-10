package com.startapp.sdk.common.advertisingid;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.startapp.a0;
import com.startapp.i2;
import com.startapp.i3;
import com.startapp.j3;
import com.startapp.sdk.adsbase.remoteconfig.AdvertisingIdResolverMetadata;
import com.startapp.u;
import com.startapp.v;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: Sta */
public class AdvertisingIdResolver {
    public final Context a;
    public final ThreadFactory b;
    public final i2<AdvertisingIdResolverMetadata> c;
    public final Lock d;
    public final Condition e;
    public final AtomicReference<u> f = new AtomicReference<>();
    public volatile boolean g = true;
    public volatile int h = 0;
    public final double i = Math.random();
    public int j;

    /* compiled from: Sta */
    public static class InternalException extends Exception {
        private static final long serialVersionUID = -3951983339713608735L;
        public final int infoEventFlags;

        public InternalException(int i) {
            super(String.valueOf(i));
            this.infoEventFlags = i;
        }
    }

    public AdvertisingIdResolver(Context context, ThreadFactory threadFactory, i2<AdvertisingIdResolverMetadata> i2Var) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.d = reentrantLock;
        this.e = reentrantLock.newCondition();
        this.a = context;
        this.b = threadFactory;
        this.c = i2Var;
    }

    public boolean a(int i2) {
        AdvertisingIdResolverMetadata a2 = this.c.a();
        if (a2 == null || !a2.c()) {
            a2 = null;
        }
        if (a2 == null || this.i >= a2.b() || (a2.a() & i2) != i2) {
            return false;
        }
        return true;
    }

    public final void b(int i2) {
        if (a(i2)) {
            int i3 = this.j;
            if (!((i3 & i2) == i2)) {
                this.j = i3 | i2;
                i3 i3Var = new i3(j3.e);
                i3Var.d = "AIR";
                i3Var.e = String.valueOf(i2);
                i3Var.a();
            }
        }
    }

    public void a(boolean z) {
        boolean z2 = false;
        try {
            if (this.d.tryLock()) {
                z2 = true;
                this.g = z;
                if (z && this.h == 0) {
                    this.b.newThread(new a(this)).start();
                    this.h = 1;
                }
            }
            if (!z2) {
                return;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                this.d.unlock();
            }
            throw th;
        }
        this.d.unlock();
    }

    public static u b(Context context) throws Exception {
        v vVar;
        Parcel obtain;
        Parcel obtain2;
        Parcel obtain3;
        Parcel obtain4;
        try {
            boolean z = false;
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            vVar = new v();
            try {
                if (!context.bindService(intent, vVar, 1)) {
                    throw new InternalException(2048);
                } else if (!vVar.b) {
                    IBinder take = vVar.a.take();
                    if (take != null) {
                        vVar.b = true;
                        obtain = Parcel.obtain();
                        obtain2 = Parcel.obtain();
                        obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        take.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        String readString = obtain2.readString();
                        obtain2.recycle();
                        obtain.recycle();
                        if (readString != null) {
                            obtain3 = Parcel.obtain();
                            obtain4 = Parcel.obtain();
                            obtain3.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                            obtain3.writeInt(1);
                            take.transact(2, obtain3, obtain4, 0);
                            obtain4.readException();
                            if (obtain4.readInt() != 0) {
                                z = true;
                            }
                            obtain4.recycle();
                            obtain3.recycle();
                            u uVar = new u(readString, "DEVICE", z);
                            a0.a(context, (ServiceConnection) vVar);
                            return uVar;
                        }
                        throw new RemoteException();
                    }
                    throw new IllegalStateException();
                } else {
                    throw new IllegalStateException();
                }
            } catch (Throwable th) {
                th = th;
                a0.a(context, (ServiceConnection) vVar);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            vVar = null;
            a0.a(context, (ServiceConnection) vVar);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009c, code lost:
        if (r9.a.checkSelfPermission("com.google.android.gms.permission.AD_ID") == 0) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ab, code lost:
        r2 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.startapp.u a() {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicReference<com.startapp.u> r0 = r9.f
            java.lang.Object r0 = r0.get()
            com.startapp.u r0 = (com.startapp.u) r0
            if (r0 != 0) goto L_0x00d6
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            java.lang.Thread r1 = r1.getThread()
            r2 = 1
            if (r0 != r1) goto L_0x001f
            r9.b((int) r2)
            com.startapp.u r0 = com.startapp.u.d
            return r0
        L_0x001f:
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00c8 }
            java.util.concurrent.locks.Lock r3 = r9.d     // Catch:{ all -> 0x00c8 }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00c8 }
            r5 = 1000(0x3e8, double:4.94E-321)
            boolean r3 = r3.tryLock(r5, r4)     // Catch:{ all -> 0x00c8 }
            if (r3 == 0) goto L_0x00c0
            boolean r3 = r9.g     // Catch:{ all -> 0x00b9 }
            if (r3 != 0) goto L_0x003b
            com.startapp.u r0 = com.startapp.u.d     // Catch:{ all -> 0x00b9 }
            java.util.concurrent.locks.Lock r1 = r9.d     // Catch:{ all -> 0x00c8 }
            r1.unlock()     // Catch:{ all -> 0x00c8 }
            return r0
        L_0x003b:
            int r3 = r9.h     // Catch:{ all -> 0x00b9 }
            if (r3 != 0) goto L_0x004f
            java.util.concurrent.ThreadFactory r3 = r9.b     // Catch:{ all -> 0x00b9 }
            com.startapp.sdk.common.advertisingid.a r4 = new com.startapp.sdk.common.advertisingid.a     // Catch:{ all -> 0x00b9 }
            r4.<init>(r9)     // Catch:{ all -> 0x00b9 }
            java.lang.Thread r3 = r3.newThread(r4)     // Catch:{ all -> 0x00b9 }
            r3.start()     // Catch:{ all -> 0x00b9 }
            r9.h = r2     // Catch:{ all -> 0x00b9 }
        L_0x004f:
            int r3 = r9.h     // Catch:{ all -> 0x00b9 }
            r4 = 2
            if (r3 == r4) goto L_0x0072
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00b9 }
            long r7 = r7 - r0
            int r3 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x0068
            r9.b((int) r4)     // Catch:{ all -> 0x00b9 }
            com.startapp.u r0 = com.startapp.u.d     // Catch:{ all -> 0x00b9 }
            java.util.concurrent.locks.Lock r1 = r9.d     // Catch:{ all -> 0x00c8 }
            r1.unlock()     // Catch:{ all -> 0x00c8 }
            return r0
        L_0x0068:
            java.util.concurrent.locks.Condition r3 = r9.e     // Catch:{ all -> 0x00b9 }
            long r7 = r5 - r7
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00b9 }
            r3.await(r7, r4)     // Catch:{ all -> 0x00b9 }
            goto L_0x004f
        L_0x0072:
            java.util.concurrent.atomic.AtomicReference<com.startapp.u> r0 = r9.f     // Catch:{ all -> 0x00b9 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x00b9 }
            com.startapp.u r0 = (com.startapp.u) r0     // Catch:{ all -> 0x00b9 }
            if (r0 != 0) goto L_0x0083
            r0 = 4
            r9.b((int) r0)     // Catch:{ all -> 0x00b9 }
            com.startapp.u r0 = com.startapp.u.d     // Catch:{ all -> 0x00b9 }
            goto L_0x00b3
        L_0x0083:
            java.lang.String r1 = "00000000-0000-0000-0000-000000000000"
            java.lang.String r3 = r0.a     // Catch:{ all -> 0x00b9 }
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x00b9 }
            if (r1 == 0) goto L_0x00b3
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00b9 }
            r3 = 31
            if (r1 >= r3) goto L_0x0094
            goto L_0x00ac
        L_0x0094:
            android.content.Context r1 = r9.a     // Catch:{ all -> 0x009f }
            java.lang.String r3 = "com.google.android.gms.permission.AD_ID"
            int r1 = r1.checkSelfPermission(r3)     // Catch:{ all -> 0x009f }
            if (r1 != 0) goto L_0x00ab
            goto L_0x00ac
        L_0x009f:
            r1 = move-exception
            r2 = 8192(0x2000, float:1.14794E-41)
            boolean r2 = r9.a((int) r2)     // Catch:{ all -> 0x00b9 }
            if (r2 == 0) goto L_0x00ab
            com.startapp.i3.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x00b9 }
        L_0x00ab:
            r2 = 0
        L_0x00ac:
            if (r2 != 0) goto L_0x00b3
            r1 = 4096(0x1000, float:5.74E-42)
            r9.b((int) r1)     // Catch:{ all -> 0x00b9 }
        L_0x00b3:
            java.util.concurrent.locks.Lock r1 = r9.d     // Catch:{ all -> 0x00c8 }
            r1.unlock()     // Catch:{ all -> 0x00c8 }
            goto L_0x00d6
        L_0x00b9:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r9.d     // Catch:{ all -> 0x00c8 }
            r1.unlock()     // Catch:{ all -> 0x00c8 }
            throw r0     // Catch:{ all -> 0x00c8 }
        L_0x00c0:
            r0 = 8
            r9.b((int) r0)     // Catch:{ all -> 0x00c8 }
            com.startapp.u r0 = com.startapp.u.d     // Catch:{ all -> 0x00c8 }
            goto L_0x00d6
        L_0x00c8:
            r0 = move-exception
            r1 = 32
            boolean r1 = r9.a((int) r1)
            if (r1 == 0) goto L_0x00d4
            com.startapp.i3.a((java.lang.Throwable) r0)
        L_0x00d4:
            com.startapp.u r0 = com.startapp.u.d
        L_0x00d6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.common.advertisingid.AdvertisingIdResolver.a():com.startapp.u");
    }

    public static u a(Context context) throws Exception {
        Object invoke = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
        if (invoke != null) {
            String str = (String) invoke.getClass().getMethod("getId", new Class[0]).invoke(invoke, new Object[0]);
            if (str == null || str.length() < 1) {
                throw new InternalException(1024);
            }
            return new u(str, "APP", Boolean.TRUE.equals((Boolean) invoke.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(invoke, new Object[0])));
        }
        throw new InternalException(512);
    }
}
