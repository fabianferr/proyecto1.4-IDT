package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzjp implements Runnable, zzjl {
    final CountDownLatch zza;
    private final AtomicReference zzb = new AtomicReference();
    private Context zzc;
    /* access modifiers changed from: private */
    public final zzoy zzd;
    private final Executor zze;
    private final zzm zzf;
    private final boolean zzg;
    private final List zzh;

    public zzjp(Context context, Executor executor, zzm zzm) {
        boolean z = true;
        this.zza = new CountDownLatch(1);
        this.zzh = new ArrayList();
        this.zzf = zzm;
        this.zzc = context;
        this.zze = executor;
        zznr.zza(context);
        z = (!((Boolean) zznc.zzc().zzb(zznr.zzca)).booleanValue() || !zzm.zzh()) ? false : z;
        this.zzg = z;
        this.zzd = zzoy.zza(context, executor, z);
        executor.execute(this);
    }

    private final void zzd() {
        if (!this.zzh.isEmpty() && this.zzb.get() != null) {
            for (Object[] objArr : this.zzh) {
                int length = objArr.length;
                if (length == 1) {
                    ((zzjl) this.zzb.get()).zzk((MotionEvent) objArr[0]);
                } else if (length == 3) {
                    ((zzjl) this.zzb.get()).zzl(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.zzh.clear();
        }
    }

    private final boolean zzi() {
        AtomicReference atomicReference = this.zzb;
        String zzc2 = this.zzf.zzc();
        Context zzj = zzj(this.zzc);
        boolean zzg2 = this.zzf.zzg();
        zzjr.zzr(zzj, zzg2);
        atomicReference.set(new zzjr(zzj, zzc2, zzg2));
        return true;
    }

    private static final Context zzj(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004c A[Catch:{ NullPointerException -> 0x009c, all -> 0x009a }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0062 A[Catch:{ NullPointerException -> 0x009c, all -> 0x009a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r11 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 0
            com.google.ads.interactivemedia.v3.internal.zzm r3 = r11.zzf     // Catch:{ NullPointerException -> 0x009c }
            int r3 = r3.zzk()     // Catch:{ NullPointerException -> 0x009c }
            int r3 = r3 + -1
            r4 = 3
            r5 = 2
            if (r3 == r5) goto L_0x0013
        L_0x0011:
            r3 = 2
            goto L_0x0048
        L_0x0013:
            android.content.Context r3 = r11.zzc     // Catch:{ NullPointerException -> 0x009c }
            com.google.ads.interactivemedia.v3.internal.zzoy r6 = r11.zzd     // Catch:{ NullPointerException -> 0x009c }
            com.google.ads.interactivemedia.v3.internal.zzjo r7 = new com.google.ads.interactivemedia.v3.internal.zzjo     // Catch:{ NullPointerException -> 0x009c }
            r7.<init>(r11)     // Catch:{ NullPointerException -> 0x009c }
            com.google.ads.interactivemedia.v3.internal.zzqi r8 = new com.google.ads.interactivemedia.v3.internal.zzqi     // Catch:{ NullPointerException -> 0x009c }
            android.content.Context r9 = r11.zzc     // Catch:{ NullPointerException -> 0x009c }
            int r3 = com.google.ads.interactivemedia.v3.internal.zzpq.zzb(r3, r6)     // Catch:{ NullPointerException -> 0x009c }
            com.google.ads.interactivemedia.v3.internal.zznj r6 = com.google.ads.interactivemedia.v3.internal.zznr.zzbX     // Catch:{ NullPointerException -> 0x009c }
            com.google.ads.interactivemedia.v3.internal.zznp r10 = com.google.ads.interactivemedia.v3.internal.zznc.zzc()     // Catch:{ NullPointerException -> 0x009c }
            java.lang.Object r6 = r10.zzb(r6)     // Catch:{ NullPointerException -> 0x009c }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ NullPointerException -> 0x009c }
            boolean r6 = r6.booleanValue()     // Catch:{ NullPointerException -> 0x009c }
            r8.<init>(r9, r3, r7, r6)     // Catch:{ NullPointerException -> 0x009c }
            r3 = 1
            boolean r3 = r8.zzd(r3)     // Catch:{ NullPointerException -> 0x009c }
            if (r3 != 0) goto L_0x0047
            com.google.ads.interactivemedia.v3.internal.zzm r3 = r11.zzf     // Catch:{ NullPointerException -> 0x009c }
            boolean r3 = r3.zzi()     // Catch:{ NullPointerException -> 0x009c }
            if (r3 == 0) goto L_0x0047
            goto L_0x0011
        L_0x0047:
            r3 = 3
        L_0x0048:
            int r3 = r3 + -1
            if (r3 == r5) goto L_0x0062
            r11.zzi()     // Catch:{ NullPointerException -> 0x009c }
            com.google.ads.interactivemedia.v3.internal.zzm r3 = r11.zzf     // Catch:{ NullPointerException -> 0x009c }
            int r3 = r3.zzk()     // Catch:{ NullPointerException -> 0x009c }
            if (r3 != r4) goto L_0x0092
            java.util.concurrent.Executor r3 = r11.zze     // Catch:{ NullPointerException -> 0x009c }
            com.google.ads.interactivemedia.v3.internal.zzjn r4 = new com.google.ads.interactivemedia.v3.internal.zzjn     // Catch:{ NullPointerException -> 0x009c }
            r4.<init>(r11)     // Catch:{ NullPointerException -> 0x009c }
            r3.execute(r4)     // Catch:{ NullPointerException -> 0x009c }
            goto L_0x0092
        L_0x0062:
            com.google.ads.interactivemedia.v3.internal.zzm r3 = r11.zzf     // Catch:{ NullPointerException -> 0x009c }
            java.lang.String r3 = r3.zzc()     // Catch:{ NullPointerException -> 0x009c }
            android.content.Context r4 = r11.zzc     // Catch:{ NullPointerException -> 0x009c }
            android.content.Context r4 = zzj(r4)     // Catch:{ NullPointerException -> 0x009c }
            java.util.concurrent.Executor r5 = r11.zze     // Catch:{ NullPointerException -> 0x009c }
            com.google.ads.interactivemedia.v3.internal.zzm r6 = r11.zzf     // Catch:{ NullPointerException -> 0x009c }
            boolean r6 = r6.zzg()     // Catch:{ NullPointerException -> 0x009c }
            boolean r7 = r11.zzg     // Catch:{ NullPointerException -> 0x009c }
            com.google.ads.interactivemedia.v3.internal.zzji r3 = com.google.ads.interactivemedia.v3.internal.zzji.zzb(r3, r4, r5, r6, r7)     // Catch:{ NullPointerException -> 0x009c }
            java.util.concurrent.atomic.AtomicReference r4 = r11.zzb     // Catch:{ NullPointerException -> 0x009c }
            r4.set(r3)     // Catch:{ NullPointerException -> 0x009c }
            boolean r3 = r3.zzr()     // Catch:{ NullPointerException -> 0x009c }
            if (r3 != 0) goto L_0x0092
            com.google.ads.interactivemedia.v3.internal.zzm r3 = r11.zzf     // Catch:{ NullPointerException -> 0x009c }
            boolean r3 = r3.zzi()     // Catch:{ NullPointerException -> 0x009c }
            if (r3 == 0) goto L_0x0092
            r11.zzi()     // Catch:{ NullPointerException -> 0x009c }
        L_0x0092:
            r11.zzc = r2
            java.util.concurrent.CountDownLatch r0 = r11.zza
        L_0x0096:
            r0.countDown()
            return
        L_0x009a:
            r0 = move-exception
            goto L_0x00b9
        L_0x009c:
            r3 = move-exception
            com.google.ads.interactivemedia.v3.internal.zzm r4 = r11.zzf     // Catch:{ all -> 0x009a }
            boolean r4 = r4.zzi()     // Catch:{ all -> 0x009a }
            if (r4 == 0) goto L_0x00a8
            r11.zzi()     // Catch:{ all -> 0x009a }
        L_0x00a8:
            com.google.ads.interactivemedia.v3.internal.zzoy r4 = r11.zzd     // Catch:{ all -> 0x009a }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x009a }
            long r5 = r5 - r0
            r0 = 2031(0x7ef, float:2.846E-42)
            r4.zzc(r0, r5, r3)     // Catch:{ all -> 0x009a }
            r11.zzc = r2
            java.util.concurrent.CountDownLatch r0 = r11.zza
            goto L_0x0096
        L_0x00b9:
            r11.zzc = r2
            java.util.concurrent.CountDownLatch r1 = r11.zza
            r1.countDown()
            goto L_0x00c2
        L_0x00c1:
            throw r0
        L_0x00c2:
            goto L_0x00c1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzjp.run():void");
    }

    public final zzjl zza() {
        return (zzjl) this.zzb.get();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzji.zza(this.zzf.zzc(), zzj(this.zzc), this.zzf.zzg(), this.zzg).zzo();
        } catch (NullPointerException e) {
            this.zzd.zzc(2027, System.currentTimeMillis() - currentTimeMillis, e);
        }
    }

    @Deprecated
    public final String zze(Context context, String str, View view, Activity activity) {
        if (!zzs()) {
            return "";
        }
        zzd();
        return ((zzjl) this.zzb.get()).zze(zzj(context), str, view, activity);
    }

    public final String zzf(Context context) {
        return zzg(context, (byte[]) null);
    }

    public final String zzg(Context context, byte[] bArr) {
        if (!zzs()) {
            return "";
        }
        zzd();
        return ((zzjl) this.zzb.get()).zzf(zzj(context));
    }

    public final String zzh(Context context, View view, Activity activity) {
        return zzs() ? ((zzjl) this.zzb.get()).zzh(context, view, activity) : "";
    }

    public final void zzk(MotionEvent motionEvent) {
        if (this.zzb.get() != null) {
            zzd();
            ((zzjl) this.zzb.get()).zzk(motionEvent);
            return;
        }
        this.zzh.add(new Object[]{motionEvent});
    }

    public final void zzl(int i, int i2, int i3) {
        if (this.zzb.get() != null) {
            zzd();
            ((zzjl) this.zzb.get()).zzl(i, i2, i3);
            return;
        }
        this.zzh.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final void zzn(View view) {
        if (this.zzb.get() != null) {
            ((zzjl) this.zzb.get()).zzn(view);
        }
    }

    public final boolean zzq() {
        return this.zza.getCount() == 0 && this.zzb.get() != null && ((zzjl) this.zzb.get()).zzq();
    }

    public final boolean zzs() {
        try {
            this.zza.await();
            if (this.zzb.get() == null || !((zzjl) this.zzb.get()).zzs()) {
                return false;
            }
            return true;
        } catch (InterruptedException unused) {
            return false;
        }
    }
}
