package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdvi {
    private final Map zza = new HashMap();

    zzdvi() {
    }

    @Nullable
    public final synchronized zzdvh zza(String str) {
        return (zzdvh) this.zza.get(str);
    }

    @Nullable
    public final zzdvh zzb(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzdvh zza2 = zza((String) it.next());
            if (zza2 != null) {
                return zza2;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = r1.zzb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzc(java.lang.String r1) {
        /*
            r0 = this;
            com.google.android.gms.internal.ads.zzdvh r1 = r0.zza(r1)
            if (r1 == 0) goto L_0x0010
            com.google.android.gms.internal.ads.zzbxq r1 = r1.zzb
            if (r1 != 0) goto L_0x000b
            goto L_0x0010
        L_0x000b:
            java.lang.String r1 = r1.toString()
            return r1
        L_0x0010:
            java.lang.String r1 = ""
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdvi.zzc(java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0020 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x001c A[SYNTHETIC, Splitter:B:15:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzd(java.lang.String r6, @javax.annotation.Nullable com.google.android.gms.internal.ads.zzffa r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.Map r0 = r5.zza     // Catch:{ all -> 0x0046 }
            boolean r0 = r0.containsKey(r6)     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r5)
            return
        L_0x000b:
            com.google.android.gms.internal.ads.zzdvh r0 = new com.google.android.gms.internal.ads.zzdvh     // Catch:{ all -> 0x0046 }
            r1 = 0
            if (r7 != 0) goto L_0x0012
        L_0x0010:
            r2 = r1
            goto L_0x0019
        L_0x0012:
            com.google.android.gms.internal.ads.zzbxq r2 = r7.zze()     // Catch:{ zzfek -> 0x0017 }
            goto L_0x0019
        L_0x0017:
            goto L_0x0010
        L_0x0019:
            if (r7 != 0) goto L_0x001c
            goto L_0x0020
        L_0x001c:
            com.google.android.gms.internal.ads.zzbxq r1 = r7.zzf()     // Catch:{ zzfek -> 0x0020 }
        L_0x0020:
            com.google.android.gms.internal.ads.zzbiu r3 = com.google.android.gms.internal.ads.zzbjc.zzhZ     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzbja r4 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x0046 }
            java.lang.Object r3 = r4.zzb(r3)     // Catch:{ all -> 0x0046 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0046 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0046 }
            r4 = 1
            if (r3 != 0) goto L_0x0034
            goto L_0x003c
        L_0x0034:
            r3 = 0
            if (r7 != 0) goto L_0x0039
        L_0x0037:
            r4 = 0
            goto L_0x003c
        L_0x0039:
            r7.zzA()     // Catch:{ zzfek -> 0x0037 }
        L_0x003c:
            r0.<init>(r6, r2, r1, r4)     // Catch:{ all -> 0x0046 }
            java.util.Map r7 = r5.zza     // Catch:{ all -> 0x0046 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0046 }
            monitor-exit(r5)
            return
        L_0x0046:
            r6 = move-exception
            monitor-exit(r5)
            goto L_0x004a
        L_0x0049:
            throw r6
        L_0x004a:
            goto L_0x0049
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdvi.zzd(java.lang.String, com.google.android.gms.internal.ads.zzffa):void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zze(String str, zzbxd zzbxd) {
        if (!this.zza.containsKey(str)) {
            try {
                this.zza.put(str, new zzdvh(str, zzbxd.zzf(), zzbxd.zzg(), true));
            } catch (Throwable unused) {
            }
        }
    }
}
