package com.google.android.gms.measurement.internal;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzia implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ Uri zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzic zze;

    zzia(zzic zzic, boolean z, Uri uri, String str, String str2) {
        this.zze = zzic;
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a A[SYNTHETIC, Splitter:B:27:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d2 A[Catch:{ RuntimeException -> 0x0165 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d4 A[Catch:{ RuntimeException -> 0x0165 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r17 = this;
            r1 = r17
            com.google.android.gms.measurement.internal.zzic r2 = r1.zze
            boolean r0 = r1.zza
            android.net.Uri r3 = r1.zzb
            java.lang.String r4 = r1.zzc
            java.lang.String r5 = r1.zzd
            com.google.android.gms.measurement.internal.zzid r6 = r2.zza
            r6.zzg()
            com.google.android.gms.measurement.internal.zzid r6 = r2.zza     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzfy r6 = r6.zzs     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzlh r6 = r6.zzv()     // Catch:{ RuntimeException -> 0x0165 }
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0165 }
            java.lang.String r8 = "Activity created with data 'referrer' without required params"
            java.lang.String r9 = "utm_medium"
            java.lang.String r10 = "_cis"
            java.lang.String r11 = "utm_source"
            java.lang.String r12 = "utm_campaign"
            r13 = 0
            java.lang.String r14 = "gclid"
            if (r7 == 0) goto L_0x002e
        L_0x002c:
            r6 = r13
            goto L_0x0085
        L_0x002e:
            boolean r7 = r5.contains(r14)     // Catch:{ RuntimeException -> 0x0165 }
            if (r7 != 0) goto L_0x006c
            boolean r7 = r5.contains(r12)     // Catch:{ RuntimeException -> 0x0165 }
            if (r7 != 0) goto L_0x006c
            boolean r7 = r5.contains(r11)     // Catch:{ RuntimeException -> 0x0165 }
            if (r7 != 0) goto L_0x006c
            boolean r7 = r5.contains(r9)     // Catch:{ RuntimeException -> 0x0165 }
            if (r7 != 0) goto L_0x006c
            java.lang.String r7 = "utm_id"
            boolean r7 = r5.contains(r7)     // Catch:{ RuntimeException -> 0x0165 }
            if (r7 != 0) goto L_0x006c
            java.lang.String r7 = "dclid"
            boolean r7 = r5.contains(r7)     // Catch:{ RuntimeException -> 0x0165 }
            if (r7 != 0) goto L_0x006c
            java.lang.String r7 = "srsltid"
            boolean r7 = r5.contains(r7)     // Catch:{ RuntimeException -> 0x0165 }
            if (r7 != 0) goto L_0x006c
            com.google.android.gms.measurement.internal.zzfy r6 = r6.zzs     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzeo r6 = r6.zzay()     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzem r6 = r6.zzc()     // Catch:{ RuntimeException -> 0x0165 }
            r6.zza(r8)     // Catch:{ RuntimeException -> 0x0165 }
            goto L_0x002c
        L_0x006c:
            java.lang.String r7 = "https://google.com/search?"
            java.lang.String r15 = java.lang.String.valueOf(r5)     // Catch:{ RuntimeException -> 0x0165 }
            java.lang.String r7 = r7.concat(r15)     // Catch:{ RuntimeException -> 0x0165 }
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ RuntimeException -> 0x0165 }
            android.os.Bundle r6 = r6.zzs(r7)     // Catch:{ RuntimeException -> 0x0165 }
            if (r6 == 0) goto L_0x0085
            java.lang.String r7 = "referrer"
            r6.putString(r10, r7)     // Catch:{ RuntimeException -> 0x0165 }
        L_0x0085:
            java.lang.String r7 = "_cmp"
            r15 = 1
            if (r0 == 0) goto L_0x00cc
            com.google.android.gms.measurement.internal.zzid r0 = r2.zza     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzs     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzlh r0 = r0.zzv()     // Catch:{ RuntimeException -> 0x0165 }
            android.os.Bundle r0 = r0.zzs(r3)     // Catch:{ RuntimeException -> 0x0165 }
            if (r0 == 0) goto L_0x00cc
            java.lang.String r3 = "intent"
            r0.putString(r10, r3)     // Catch:{ RuntimeException -> 0x0165 }
            boolean r3 = r0.containsKey(r14)     // Catch:{ RuntimeException -> 0x0165 }
            if (r3 != 0) goto L_0x00c0
            if (r6 == 0) goto L_0x00c0
            boolean r3 = r6.containsKey(r14)     // Catch:{ RuntimeException -> 0x0165 }
            if (r3 == 0) goto L_0x00c0
            java.lang.Object[] r3 = new java.lang.Object[r15]     // Catch:{ RuntimeException -> 0x0165 }
            java.lang.String r10 = r6.getString(r14)     // Catch:{ RuntimeException -> 0x0165 }
            r16 = 0
            r3[r16] = r10     // Catch:{ RuntimeException -> 0x0165 }
            java.lang.String r10 = "_cer"
            java.lang.String r15 = "gclid=%s"
            java.lang.String r3 = java.lang.String.format(r15, r3)     // Catch:{ RuntimeException -> 0x0165 }
            r0.putString(r10, r3)     // Catch:{ RuntimeException -> 0x0165 }
        L_0x00c0:
            com.google.android.gms.measurement.internal.zzid r3 = r2.zza     // Catch:{ RuntimeException -> 0x0165 }
            r3.zzG(r4, r7, r0)     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzid r3 = r2.zza     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzb     // Catch:{ RuntimeException -> 0x0165 }
            r3.zza(r4, r0)     // Catch:{ RuntimeException -> 0x0165 }
        L_0x00cc:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0165 }
            if (r0 == 0) goto L_0x00d4
            goto L_0x0154
        L_0x00d4:
            com.google.android.gms.measurement.internal.zzid r0 = r2.zza     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzs     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x0165 }
            java.lang.String r3 = "Activity created with referrer"
            r0.zzb(r3, r5)     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzid r0 = r2.zza     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzs     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzea r3 = com.google.android.gms.measurement.internal.zzeb.zzY     // Catch:{ RuntimeException -> 0x0165 }
            boolean r0 = r0.zzs(r13, r3)     // Catch:{ RuntimeException -> 0x0165 }
            java.lang.String r3 = "_ldl"
            java.lang.String r10 = "auto"
            if (r0 == 0) goto L_0x0120
            if (r6 == 0) goto L_0x0108
            com.google.android.gms.measurement.internal.zzid r0 = r2.zza     // Catch:{ RuntimeException -> 0x0165 }
            r0.zzG(r4, r7, r6)     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzid r0 = r2.zza     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzs r0 = r0.zzb     // Catch:{ RuntimeException -> 0x0165 }
            r0.zza(r4, r6)     // Catch:{ RuntimeException -> 0x0165 }
            goto L_0x0119
        L_0x0108:
            com.google.android.gms.measurement.internal.zzid r0 = r2.zza     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzs     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x0165 }
            java.lang.String r4 = "Referrer does not contain valid parameters"
            r0.zzb(r4, r5)     // Catch:{ RuntimeException -> 0x0165 }
        L_0x0119:
            com.google.android.gms.measurement.internal.zzid r0 = r2.zza     // Catch:{ RuntimeException -> 0x0165 }
            r4 = 1
            r0.zzW(r10, r3, r13, r4)     // Catch:{ RuntimeException -> 0x0165 }
            return
        L_0x0120:
            boolean r0 = r5.contains(r14)     // Catch:{ RuntimeException -> 0x0165 }
            if (r0 == 0) goto L_0x0155
            boolean r0 = r5.contains(r12)     // Catch:{ RuntimeException -> 0x0165 }
            if (r0 != 0) goto L_0x0148
            boolean r0 = r5.contains(r11)     // Catch:{ RuntimeException -> 0x0165 }
            if (r0 != 0) goto L_0x0148
            boolean r0 = r5.contains(r9)     // Catch:{ RuntimeException -> 0x0165 }
            if (r0 != 0) goto L_0x0148
            java.lang.String r0 = "utm_term"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x0165 }
            if (r0 != 0) goto L_0x0148
            java.lang.String r0 = "utm_content"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x0165 }
            if (r0 == 0) goto L_0x0155
        L_0x0148:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0165 }
            if (r0 != 0) goto L_0x0154
            com.google.android.gms.measurement.internal.zzid r0 = r2.zza     // Catch:{ RuntimeException -> 0x0165 }
            r4 = 1
            r0.zzW(r10, r3, r5, r4)     // Catch:{ RuntimeException -> 0x0165 }
        L_0x0154:
            return
        L_0x0155:
            com.google.android.gms.measurement.internal.zzid r0 = r2.zza     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzs     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()     // Catch:{ RuntimeException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x0165 }
            r0.zza(r8)     // Catch:{ RuntimeException -> 0x0165 }
            return
        L_0x0165:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzid r2 = r2.zza
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzeo r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzd()
            java.lang.String r3 = "Throwable caught in handleReferrerForOnActivityCreated"
            r2.zzb(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzia.run():void");
    }
}
