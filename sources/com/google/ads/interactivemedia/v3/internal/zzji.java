package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzji implements zzjl {
    private static zzji zzb;
    volatile long zza = 0;
    private final Context zzc;
    private final zzqb zzd;
    private final zzqi zze;
    private final zzqk zzf;
    private final zzkn zzg;
    /* access modifiers changed from: private */
    public final zzoy zzh;
    private final Executor zzi;
    private final zzqh zzj;
    private final CountDownLatch zzk;
    private final zzlc zzl;
    private final zzku zzm;
    private final zzkl zzn;
    /* access modifiers changed from: private */
    public final Object zzo = new Object();
    /* access modifiers changed from: private */
    public volatile boolean zzp;
    private volatile boolean zzq = false;
    private final int zzr;

    zzji(Context context, zzoy zzoy, zzqb zzqb, zzqi zzqi, zzqk zzqk, zzkn zzkn, Executor executor, zzot zzot, int i, zzlc zzlc, zzku zzku, zzkl zzkl) {
        this.zzc = context;
        this.zzh = zzoy;
        this.zzd = zzqb;
        this.zze = zzqi;
        this.zzf = zzqk;
        this.zzg = zzkn;
        this.zzi = executor;
        this.zzr = i;
        this.zzl = zzlc;
        this.zzm = zzku;
        this.zzn = zzkl;
        this.zzq = false;
        this.zzk = new CountDownLatch(1);
        this.zzj = new zzjg(this, zzot);
    }

    public static synchronized zzji zza(String str, Context context, boolean z, boolean z2) {
        zzji zzb2;
        synchronized (zzji.class) {
            zzb2 = zzb(str, context, Executors.newCachedThreadPool(), z, z2);
        }
        return zzb2;
    }

    @Deprecated
    public static synchronized zzji zzb(String str, Context context, Executor executor, boolean z, boolean z2) {
        zzji zzji;
        Context context2 = context;
        Executor executor2 = executor;
        synchronized (zzji.class) {
            if (zzb == null) {
                zzoz zza2 = zzpa.zza();
                zza2.zza(str);
                zza2.zzc(z);
                zzpa zzd2 = zza2.zzd();
                zzoy zza3 = zzoy.zza(context2, executor2, z2);
                zzjw zzc2 = ((Boolean) zznc.zzc().zzb(zznr.zzcW)).booleanValue() ? zzjw.zzc(context) : null;
                zzlc zzd3 = ((Boolean) zznc.zzc().zzb(zznr.zzcX)).booleanValue() ? zzlc.zzd(context, executor) : null;
                zzku zzku = ((Boolean) zznc.zzc().zzb(zznr.zzco)).booleanValue() ? new zzku() : null;
                zzkl zzkl = ((Boolean) zznc.zzc().zzb(zznr.zzcq)).booleanValue() ? new zzkl() : null;
                zzpp zze2 = zzpp.zze(context2, executor2, zza3, zzd2);
                zzkm zzkm = new zzkm(context2);
                zzkn zzkn = new zzkn(zzd2, zze2, new zzla(context2, zzkm), zzkm, zzc2, zzd3, zzku, zzkl);
                int zzb2 = zzpq.zzb(context2, zza3);
                zzot zzot = new zzot();
                zzji zzji2 = new zzji(context, zza3, new zzqb(context2, zzb2), new zzqi(context2, zzb2, new zzjf(zza3), ((Boolean) zznc.zzc().zzb(zznr.zzbX)).booleanValue()), new zzqk(context2, zzkn, zza3, zzot), zzkn, executor, zzot, zzb2, zzd3, zzku, zzkl);
                zzb = zzji2;
                zzji2.zzm();
                zzb.zzo();
            }
            zzji = zzb;
        }
        return zzji;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009a, code lost:
        if (r4.zzc().zzi().equals(r5.zzi()) != false) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r12.zzh.zzd(2030, java.lang.System.currentTimeMillis() - r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0117, code lost:
        r12 = r12.zzk;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x010b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* bridge */ /* synthetic */ void zzj(com.google.ads.interactivemedia.v3.internal.zzji r12) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 1
            com.google.ads.interactivemedia.v3.internal.zzqa r3 = r12.zzu(r2)
            if (r3 == 0) goto L_0x001e
            com.google.ads.interactivemedia.v3.internal.zzmp r4 = r3.zza()
            java.lang.String r4 = r4.zzk()
            com.google.ads.interactivemedia.v3.internal.zzmp r3 = r3.zza()
            java.lang.String r3 = r3.zzi()
            r9 = r3
            r8 = r4
            goto L_0x0021
        L_0x001e:
            r4 = 0
            r8 = r4
            r9 = r8
        L_0x0021:
            android.content.Context r5 = r12.zzc     // Catch:{ zzafc -> 0x012b }
            r6 = 1
            int r7 = r12.zzr     // Catch:{ zzafc -> 0x012b }
            java.lang.String r10 = "1"
            com.google.ads.interactivemedia.v3.internal.zzoy r11 = r12.zzh     // Catch:{ zzafc -> 0x012b }
            com.google.ads.interactivemedia.v3.internal.zzqf r3 = com.google.ads.interactivemedia.v3.internal.zzpi.zza(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ zzafc -> 0x012b }
            byte[] r4 = r3.zzb     // Catch:{ zzafc -> 0x012b }
            if (r4 == 0) goto L_0x011a
            int r5 = r4.length     // Catch:{ zzafc -> 0x012b }
            if (r5 != 0) goto L_0x0037
            goto L_0x011a
        L_0x0037:
            r6 = 0
            com.google.ads.interactivemedia.v3.internal.zzadr r4 = com.google.ads.interactivemedia.v3.internal.zzadr.zzs(r4, r6, r5)     // Catch:{ NullPointerException -> 0x010b }
            com.google.ads.interactivemedia.v3.internal.zzaef r5 = com.google.ads.interactivemedia.v3.internal.zzaef.zza()     // Catch:{ NullPointerException -> 0x010b }
            com.google.ads.interactivemedia.v3.internal.zzmm r4 = com.google.ads.interactivemedia.v3.internal.zzmm.zzb(r4, r5)     // Catch:{ NullPointerException -> 0x010b }
            com.google.ads.interactivemedia.v3.internal.zzmp r5 = r4.zzc()     // Catch:{ zzafc -> 0x012b }
            java.lang.String r5 = r5.zzk()     // Catch:{ zzafc -> 0x012b }
            boolean r5 = r5.isEmpty()     // Catch:{ zzafc -> 0x012b }
            if (r5 != 0) goto L_0x00fc
            com.google.ads.interactivemedia.v3.internal.zzmp r5 = r4.zzc()     // Catch:{ zzafc -> 0x012b }
            java.lang.String r5 = r5.zzi()     // Catch:{ zzafc -> 0x012b }
            boolean r5 = r5.isEmpty()     // Catch:{ zzafc -> 0x012b }
            if (r5 != 0) goto L_0x00fc
            com.google.ads.interactivemedia.v3.internal.zzadr r5 = r4.zzd()     // Catch:{ zzafc -> 0x012b }
            byte[] r5 = r5.zzx()     // Catch:{ zzafc -> 0x012b }
            int r5 = r5.length     // Catch:{ zzafc -> 0x012b }
            if (r5 != 0) goto L_0x006d
            goto L_0x00fc
        L_0x006d:
            com.google.ads.interactivemedia.v3.internal.zzqa r5 = r12.zzu(r2)     // Catch:{ zzafc -> 0x012b }
            if (r5 != 0) goto L_0x0074
            goto L_0x009c
        L_0x0074:
            com.google.ads.interactivemedia.v3.internal.zzmp r5 = r5.zza()     // Catch:{ zzafc -> 0x012b }
            com.google.ads.interactivemedia.v3.internal.zzmp r6 = r4.zzc()     // Catch:{ zzafc -> 0x012b }
            java.lang.String r6 = r6.zzk()     // Catch:{ zzafc -> 0x012b }
            java.lang.String r7 = r5.zzk()     // Catch:{ zzafc -> 0x012b }
            boolean r6 = r6.equals(r7)     // Catch:{ zzafc -> 0x012b }
            if (r6 == 0) goto L_0x009c
            com.google.ads.interactivemedia.v3.internal.zzmp r6 = r4.zzc()     // Catch:{ zzafc -> 0x012b }
            java.lang.String r6 = r6.zzi()     // Catch:{ zzafc -> 0x012b }
            java.lang.String r5 = r5.zzi()     // Catch:{ zzafc -> 0x012b }
            boolean r5 = r6.equals(r5)     // Catch:{ zzafc -> 0x012b }
            if (r5 != 0) goto L_0x00fc
        L_0x009c:
            com.google.ads.interactivemedia.v3.internal.zzqh r5 = r12.zzj     // Catch:{ zzafc -> 0x012b }
            int r3 = r3.zzc     // Catch:{ zzafc -> 0x012b }
            com.google.ads.interactivemedia.v3.internal.zznj r6 = com.google.ads.interactivemedia.v3.internal.zznr.zzbV     // Catch:{ zzafc -> 0x012b }
            com.google.ads.interactivemedia.v3.internal.zznp r7 = com.google.ads.interactivemedia.v3.internal.zznc.zzc()     // Catch:{ zzafc -> 0x012b }
            java.lang.Object r6 = r7.zzb(r6)     // Catch:{ zzafc -> 0x012b }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ zzafc -> 0x012b }
            boolean r6 = r6.booleanValue()     // Catch:{ zzafc -> 0x012b }
            if (r6 == 0) goto L_0x00c6
            r6 = 3
            if (r3 != r6) goto L_0x00bc
            com.google.ads.interactivemedia.v3.internal.zzqi r3 = r12.zze     // Catch:{ zzafc -> 0x012b }
            boolean r3 = r3.zza(r4)     // Catch:{ zzafc -> 0x012b }
            goto L_0x00cc
        L_0x00bc:
            r6 = 4
            if (r3 != r6) goto L_0x00ce
            com.google.ads.interactivemedia.v3.internal.zzqi r3 = r12.zze     // Catch:{ zzafc -> 0x012b }
            boolean r3 = r3.zzb(r4, r5)     // Catch:{ zzafc -> 0x012b }
            goto L_0x00cc
        L_0x00c6:
            com.google.ads.interactivemedia.v3.internal.zzqb r3 = r12.zzd     // Catch:{ zzafc -> 0x012b }
            boolean r3 = r3.zza(r4, r5)     // Catch:{ zzafc -> 0x012b }
        L_0x00cc:
            if (r3 != 0) goto L_0x00e0
        L_0x00ce:
            com.google.ads.interactivemedia.v3.internal.zzoy r2 = r12.zzh     // Catch:{ zzafc -> 0x012b }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzafc -> 0x012b }
            long r3 = r3 - r0
            r5 = 4009(0xfa9, float:5.618E-42)
            r2.zzd(r5, r3)     // Catch:{ zzafc -> 0x012b }
            java.util.concurrent.CountDownLatch r12 = r12.zzk
        L_0x00dc:
            r12.countDown()
            return
        L_0x00e0:
            com.google.ads.interactivemedia.v3.internal.zzqa r3 = r12.zzu(r2)     // Catch:{ zzafc -> 0x012b }
            if (r3 == 0) goto L_0x00f9
            com.google.ads.interactivemedia.v3.internal.zzqk r4 = r12.zzf     // Catch:{ zzafc -> 0x012b }
            boolean r3 = r4.zzc(r3)     // Catch:{ zzafc -> 0x012b }
            if (r3 == 0) goto L_0x00f0
            r12.zzq = r2     // Catch:{ zzafc -> 0x012b }
        L_0x00f0:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ zzafc -> 0x012b }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            r12.zza = r2     // Catch:{ zzafc -> 0x012b }
        L_0x00f9:
            java.util.concurrent.CountDownLatch r12 = r12.zzk
            goto L_0x00dc
        L_0x00fc:
            com.google.ads.interactivemedia.v3.internal.zzoy r2 = r12.zzh     // Catch:{ zzafc -> 0x012b }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzafc -> 0x012b }
            long r3 = r3 - r0
            r5 = 5010(0x1392, float:7.02E-42)
            r2.zzd(r5, r3)     // Catch:{ zzafc -> 0x012b }
            java.util.concurrent.CountDownLatch r12 = r12.zzk
            goto L_0x00dc
        L_0x010b:
            com.google.ads.interactivemedia.v3.internal.zzoy r2 = r12.zzh     // Catch:{ zzafc -> 0x012b }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzafc -> 0x012b }
            long r3 = r3 - r0
            r5 = 2030(0x7ee, float:2.845E-42)
            r2.zzd(r5, r3)     // Catch:{ zzafc -> 0x012b }
            java.util.concurrent.CountDownLatch r12 = r12.zzk
            goto L_0x00dc
        L_0x011a:
            com.google.ads.interactivemedia.v3.internal.zzoy r2 = r12.zzh     // Catch:{ zzafc -> 0x012b }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzafc -> 0x012b }
            long r3 = r3 - r0
            r5 = 5009(0x1391, float:7.019E-42)
            r2.zzd(r5, r3)     // Catch:{ zzafc -> 0x012b }
            java.util.concurrent.CountDownLatch r12 = r12.zzk
            goto L_0x00dc
        L_0x0129:
            r0 = move-exception
            goto L_0x013b
        L_0x012b:
            r2 = move-exception
            com.google.ads.interactivemedia.v3.internal.zzoy r3 = r12.zzh     // Catch:{ all -> 0x0129 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0129 }
            long r4 = r4 - r0
            r0 = 4002(0xfa2, float:5.608E-42)
            r3.zzc(r0, r4, r2)     // Catch:{ all -> 0x0129 }
            java.util.concurrent.CountDownLatch r12 = r12.zzk
            goto L_0x00dc
        L_0x013b:
            java.util.concurrent.CountDownLatch r12 = r12.zzk
            r12.countDown()
            goto L_0x0142
        L_0x0141:
            throw r0
        L_0x0142:
            goto L_0x0141
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzji.zzj(com.google.ads.interactivemedia.v3.internal.zzji):void");
    }

    private final void zzt() {
        zzlc zzlc = this.zzl;
        if (zzlc != null) {
            zzlc.zzh();
        }
    }

    private final zzqa zzu(int i) {
        if (!zzpq.zza(this.zzr)) {
            return null;
        }
        if (((Boolean) zznc.zzc().zzb(zznr.zzbV)).booleanValue()) {
            return this.zze.zzc(1);
        }
        return this.zzd.zzc(1);
    }

    public final String zze(Context context, String str, View view, Activity activity) {
        zzt();
        if (((Boolean) zznc.zzc().zzb(zznr.zzco)).booleanValue()) {
            this.zzm.zzi();
        }
        zzo();
        zzpb zza2 = this.zzf.zza();
        if (zza2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zza3 = zza2.zza(context, (String) null, str, view, activity);
        this.zzh.zzf(5000, System.currentTimeMillis() - currentTimeMillis, zza3, (Map) null);
        return zza3;
    }

    public final String zzf(Context context) {
        zzt();
        if (((Boolean) zznc.zzc().zzb(zznr.zzco)).booleanValue()) {
            this.zzm.zzj();
        }
        zzo();
        zzpb zza2 = this.zzf.zza();
        if (zza2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzc2 = zza2.zzc(context, (String) null);
        this.zzh.zzf(5001, System.currentTimeMillis() - currentTimeMillis, zzc2, (Map) null);
        return zzc2;
    }

    public final String zzg(Context context, byte[] bArr) {
        throw null;
    }

    public final String zzh(Context context, View view, Activity activity) {
        zzt();
        if (((Boolean) zznc.zzc().zzb(zznr.zzco)).booleanValue()) {
            this.zzm.zzk(context, view);
        }
        zzo();
        zzpb zza2 = this.zzf.zza();
        if (zza2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzb2 = zza2.zzb(context, (String) null, view, activity);
        this.zzh.zzf(5002, System.currentTimeMillis() - currentTimeMillis, zzb2, (Map) null);
        return zzb2;
    }

    public final void zzk(MotionEvent motionEvent) {
        zzpb zza2 = this.zzf.zza();
        if (zza2 != null) {
            try {
                zza2.zzd((String) null, motionEvent);
            } catch (zzqj e) {
                this.zzh.zzc(e.zza(), -1, e);
            }
        }
    }

    public final void zzl(int i, int i2, int i3) {
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzm() {
        long currentTimeMillis = System.currentTimeMillis();
        zzqa zzu = zzu(1);
        if (zzu == null) {
            this.zzh.zzd(4013, System.currentTimeMillis() - currentTimeMillis);
        } else if (this.zzf.zzc(zzu)) {
            this.zzq = true;
            this.zzk.countDown();
        }
    }

    public final void zzn(View view) {
        this.zzg.zzd(view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzo() {
        /*
            r6 = this;
            boolean r0 = r6.zzp
            if (r0 != 0) goto L_0x0042
            java.lang.Object r0 = r6.zzo
            monitor-enter(r0)
            boolean r1 = r6.zzp     // Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x003d
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x003f }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            long r3 = r6.zza     // Catch:{ all -> 0x003f }
            long r1 = r1 - r3
            r3 = 3600(0xe10, double:1.7786E-320)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x001d:
            com.google.ads.interactivemedia.v3.internal.zzqk r1 = r6.zzf     // Catch:{ all -> 0x003f }
            com.google.ads.interactivemedia.v3.internal.zzqa r1 = r1.zzb()     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x002b
            boolean r1 = r1.zzd(r3)     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003d
        L_0x002b:
            int r1 = r6.zzr     // Catch:{ all -> 0x003f }
            boolean r1 = com.google.ads.interactivemedia.v3.internal.zzpq.zza(r1)     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003d
            java.util.concurrent.Executor r1 = r6.zzi     // Catch:{ all -> 0x003f }
            com.google.ads.interactivemedia.v3.internal.zzjh r2 = new com.google.ads.interactivemedia.v3.internal.zzjh     // Catch:{ all -> 0x003f }
            r2.<init>(r6)     // Catch:{ all -> 0x003f }
            r1.execute(r2)     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r1
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzji.zzo():void");
    }

    public final boolean zzq() {
        return zzr();
    }

    public final synchronized boolean zzr() {
        return this.zzq;
    }

    public final boolean zzs() {
        try {
            this.zzk.await();
        } catch (InterruptedException unused) {
        }
        return zzr();
    }
}
