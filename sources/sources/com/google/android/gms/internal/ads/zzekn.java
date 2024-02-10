package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzekn implements zzfzc {
    final /* synthetic */ long zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzfdk zzc;
    final /* synthetic */ zzfdn zzd;
    final /* synthetic */ zzfki zze;
    final /* synthetic */ zzfdw zzf;
    final /* synthetic */ zzeko zzg;

    zzekn(zzeko zzeko, long j, String str, zzfdk zzfdk, zzfdn zzfdn, zzfki zzfki, zzfdw zzfdw) {
        this.zzg = zzeko;
        this.zza = j;
        this.zzb = str;
        this.zzc = zzfdk;
        this.zzd = zzfdn;
        this.zze = zzfki;
        this.zzf = zzfdw;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.Throwable r13) {
        /*
            r12 = this;
            com.google.android.gms.internal.ads.zzeko r0 = r12.zzg
            com.google.android.gms.common.util.Clock r0 = r0.zza
            long r0 = r0.elapsedRealtime()
            long r2 = r12.zza
            long r0 = r0 - r2
            boolean r2 = r13 instanceof java.util.concurrent.TimeoutException
            r3 = 3
            r11 = 0
            if (r2 == 0) goto L_0x0016
            r2 = 2
        L_0x0014:
            r10 = r11
            goto L_0x0063
        L_0x0016:
            boolean r2 = r13 instanceof com.google.android.gms.internal.ads.zzekd
            if (r2 == 0) goto L_0x001d
            r10 = r11
            r2 = 3
            goto L_0x0063
        L_0x001d:
            boolean r2 = r13 instanceof java.util.concurrent.CancellationException
            if (r2 == 0) goto L_0x0023
            r2 = 4
            goto L_0x0014
        L_0x0023:
            boolean r2 = r13 instanceof com.google.android.gms.internal.ads.zzfek
            if (r2 == 0) goto L_0x0029
            r2 = 5
            goto L_0x0014
        L_0x0029:
            boolean r2 = r13 instanceof com.google.android.gms.internal.ads.zzebh
            r4 = 6
            if (r2 == 0) goto L_0x0061
            com.google.android.gms.ads.internal.client.zze r2 = com.google.android.gms.internal.ads.zzffe.zza(r13)
            int r2 = r2.zza
            if (r2 != r3) goto L_0x0037
            r4 = 1
        L_0x0037:
            com.google.android.gms.internal.ads.zzbiu r2 = com.google.android.gms.internal.ads.zzbjc.zzbu
            com.google.android.gms.internal.ads.zzbja r5 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r2 = r5.zzb(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x005f
            boolean r2 = r13 instanceof com.google.android.gms.internal.ads.zzehg
            if (r2 == 0) goto L_0x005f
            r2 = r13
            com.google.android.gms.internal.ads.zzehg r2 = (com.google.android.gms.internal.ads.zzehg) r2
            com.google.android.gms.ads.internal.client.zze r2 = r2.zzb()
            if (r2 == 0) goto L_0x005f
            int r2 = r2.zza
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10 = r2
            r2 = r4
            goto L_0x0063
        L_0x005f:
            r2 = r4
            goto L_0x0014
        L_0x0061:
            r10 = r11
            r2 = 6
        L_0x0063:
            com.google.android.gms.internal.ads.zzeko r4 = r12.zzg
            java.lang.String r5 = r12.zzb
            com.google.android.gms.internal.ads.zzfdk r6 = r12.zzc
            java.lang.String r9 = r6.zzah
            r6 = r2
            r7 = r0
            com.google.android.gms.internal.ads.zzeko.zzg(r4, r5, r6, r7, r9, r10)
            com.google.android.gms.internal.ads.zzeko r4 = r12.zzg
            boolean r5 = r4.zze
            if (r5 == 0) goto L_0x008f
            com.google.android.gms.internal.ads.zzekp r4 = r4.zzb
            com.google.android.gms.internal.ads.zzfdn r5 = r12.zzd
            com.google.android.gms.internal.ads.zzfdk r6 = r12.zzc
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzehg
            if (r7 == 0) goto L_0x0089
            r7 = r13
            com.google.android.gms.internal.ads.zzehg r7 = (com.google.android.gms.internal.ads.zzehg) r7
            r8 = r7
            goto L_0x008a
        L_0x0089:
            r8 = r11
        L_0x008a:
            r7 = r2
            r9 = r0
            r4.zza(r5, r6, r7, r8, r9)
        L_0x008f:
            com.google.android.gms.internal.ads.zzbiu r2 = com.google.android.gms.internal.ads.zzbjc.zzhi
            com.google.android.gms.internal.ads.zzbja r4 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r2 = r4.zzb(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x00b6
            com.google.android.gms.internal.ads.zzeko r2 = r12.zzg
            com.google.android.gms.internal.ads.zzfkm r2 = r2.zzc
            com.google.android.gms.internal.ads.zzfki r4 = r12.zze
            com.google.android.gms.internal.ads.zzfdw r5 = r12.zzf
            com.google.android.gms.internal.ads.zzfdk r6 = r12.zzc
            java.util.List r7 = r6.zzo
            java.util.List r4 = r4.zzc(r5, r6, r7)
            r2.zzd(r4)
        L_0x00b6:
            com.google.android.gms.ads.internal.client.zze r13 = com.google.android.gms.internal.ads.zzffe.zza(r13)
            int r2 = r13.zza
            if (r2 == r3) goto L_0x00c0
            if (r2 != 0) goto L_0x00db
        L_0x00c0:
            com.google.android.gms.ads.internal.client.zze r2 = r13.zzd
            if (r2 == 0) goto L_0x00db
            java.lang.String r2 = r2.zzc
            java.lang.String r3 = "com.google.android.gms.ads"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x00db
            com.google.android.gms.internal.ads.zzehg r2 = new com.google.android.gms.internal.ads.zzehg
            r3 = 13
            com.google.android.gms.ads.internal.client.zze r13 = r13.zzd
            r2.<init>(r3, r13)
            com.google.android.gms.ads.internal.client.zze r13 = com.google.android.gms.internal.ads.zzffe.zza(r2)
        L_0x00db:
            com.google.android.gms.internal.ads.zzeko r2 = r12.zzg
            com.google.android.gms.internal.ads.zzehh r2 = r2.zzf
            com.google.android.gms.internal.ads.zzfdk r3 = r12.zzc
            r2.zze(r3, r0, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekn.zza(java.lang.Throwable):void");
    }

    public final void zzb(Object obj) {
        long elapsedRealtime = this.zzg.zza.elapsedRealtime() - this.zza;
        zzeko.zzg(this.zzg, this.zzb, 0, elapsedRealtime, this.zzc.zzah, (Integer) null);
        zzeko zzeko = this.zzg;
        if (zzeko.zze) {
            zzeko.zzb.zza(this.zzd, this.zzc, 0, (zzehg) null, elapsedRealtime);
        }
        this.zzg.zzf.zzf(this.zzc, elapsedRealtime, (zze) null);
    }
}
