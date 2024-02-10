package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public class zzcgu implements zzcgh {
    private final String zza;

    public zzcgu() {
        this.zza = null;
    }

    public zzcgu(String str) {
        this.zza = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean zza(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = ". "
            java.lang.String r1 = "Received non-success response code "
            java.lang.String r2 = "Error while pinging URL: "
            java.lang.String r3 = "Error while parsing ping URL: "
            java.lang.String r4 = "Pinging URL: "
            r5 = 0
            boolean r6 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()     // Catch:{ IndexOutOfBoundsException -> 0x008f, IOException -> 0x008d, RuntimeException -> 0x008b }
            if (r6 == 0) goto L_0x0016
            r6 = 263(0x107, float:3.69E-43)
            android.net.TrafficStats.setThreadStatsTag(r6)     // Catch:{ IndexOutOfBoundsException -> 0x008f, IOException -> 0x008d, RuntimeException -> 0x008b }
        L_0x0016:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x008f, IOException -> 0x008d, RuntimeException -> 0x008b }
            r6.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x008f, IOException -> 0x008d, RuntimeException -> 0x008b }
            r6.append(r10)     // Catch:{ IndexOutOfBoundsException -> 0x008f, IOException -> 0x008d, RuntimeException -> 0x008b }
            java.lang.String r4 = r6.toString()     // Catch:{ IndexOutOfBoundsException -> 0x008f, IOException -> 0x008d, RuntimeException -> 0x008b }
            com.google.android.gms.internal.ads.zzcgp.zze(r4)     // Catch:{ IndexOutOfBoundsException -> 0x008f, IOException -> 0x008d, RuntimeException -> 0x008b }
            java.net.URL r4 = new java.net.URL     // Catch:{ IndexOutOfBoundsException -> 0x008f, IOException -> 0x008d, RuntimeException -> 0x008b }
            r4.<init>(r10)     // Catch:{ IndexOutOfBoundsException -> 0x008f, IOException -> 0x008d, RuntimeException -> 0x008b }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ IndexOutOfBoundsException -> 0x008f, IOException -> 0x008d, RuntimeException -> 0x008b }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ IndexOutOfBoundsException -> 0x008f, IOException -> 0x008d, RuntimeException -> 0x008b }
            com.google.android.gms.ads.internal.client.zzaw.zzb()     // Catch:{ all -> 0x0091 }
            java.lang.String r6 = r9.zza     // Catch:{ all -> 0x0091 }
            r7 = 60000(0xea60, float:8.4078E-41)
            r4.setConnectTimeout(r7)     // Catch:{ all -> 0x0091 }
            r8 = 1
            r4.setInstanceFollowRedirects(r8)     // Catch:{ all -> 0x0091 }
            r4.setReadTimeout(r7)     // Catch:{ all -> 0x0091 }
            if (r6 == 0) goto L_0x0049
            java.lang.String r7 = "User-Agent"
            r4.setRequestProperty(r7, r6)     // Catch:{ all -> 0x0091 }
        L_0x0049:
            r4.setUseCaches(r5)     // Catch:{ all -> 0x0091 }
            com.google.android.gms.internal.ads.zzcgo r6 = new com.google.android.gms.internal.ads.zzcgo     // Catch:{ all -> 0x0091 }
            r7 = 0
            r6.<init>(r7)     // Catch:{ all -> 0x0091 }
            r6.zzc(r4, r7)     // Catch:{ all -> 0x0091 }
            int r7 = r4.getResponseCode()     // Catch:{ all -> 0x0091 }
            r6.zze(r4, r7)     // Catch:{ all -> 0x0091 }
            r6 = 200(0xc8, float:2.8E-43)
            if (r7 < r6) goto L_0x0067
            r6 = 300(0x12c, float:4.2E-43)
            if (r7 < r6) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r5 = 1
            goto L_0x007e
        L_0x0067:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0091 }
            r6.<init>(r1)     // Catch:{ all -> 0x0091 }
            r6.append(r7)     // Catch:{ all -> 0x0091 }
            java.lang.String r1 = " from pinging URL: "
            r6.append(r1)     // Catch:{ all -> 0x0091 }
            r6.append(r10)     // Catch:{ all -> 0x0091 }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x0091 }
            com.google.android.gms.internal.ads.zzcgp.zzj(r1)     // Catch:{ all -> 0x0091 }
        L_0x007e:
            r4.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x008f, IOException -> 0x008d, RuntimeException -> 0x008b }
            boolean r10 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r10 == 0) goto L_0x00db
            android.net.TrafficStats.clearThreadStatsTag()
            return r5
        L_0x008b:
            r1 = move-exception
            goto L_0x0098
        L_0x008d:
            r1 = move-exception
            goto L_0x0098
        L_0x008f:
            r1 = move-exception
            goto L_0x00bc
        L_0x0091:
            r1 = move-exception
            r4.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x008f, IOException -> 0x008d, RuntimeException -> 0x008b }
            throw r1     // Catch:{ IndexOutOfBoundsException -> 0x008f, IOException -> 0x008d, RuntimeException -> 0x008b }
        L_0x0096:
            r10 = move-exception
            goto L_0x00e0
        L_0x0098:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0096 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0096 }
            r3.<init>(r2)     // Catch:{ all -> 0x0096 }
            r3.append(r10)     // Catch:{ all -> 0x0096 }
            r3.append(r0)     // Catch:{ all -> 0x0096 }
            r3.append(r1)     // Catch:{ all -> 0x0096 }
            java.lang.String r10 = r3.toString()     // Catch:{ all -> 0x0096 }
            com.google.android.gms.internal.ads.zzcgp.zzj(r10)     // Catch:{ all -> 0x0096 }
            boolean r10 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r10 != 0) goto L_0x00b8
            goto L_0x00db
        L_0x00b8:
            android.net.TrafficStats.clearThreadStatsTag()
            return r5
        L_0x00bc:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0096 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0096 }
            r2.<init>(r3)     // Catch:{ all -> 0x0096 }
            r2.append(r10)     // Catch:{ all -> 0x0096 }
            r2.append(r0)     // Catch:{ all -> 0x0096 }
            r2.append(r1)     // Catch:{ all -> 0x0096 }
            java.lang.String r10 = r2.toString()     // Catch:{ all -> 0x0096 }
            com.google.android.gms.internal.ads.zzcgp.zzj(r10)     // Catch:{ all -> 0x0096 }
            boolean r10 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r10 != 0) goto L_0x00dc
        L_0x00db:
            return r5
        L_0x00dc:
            android.net.TrafficStats.clearThreadStatsTag()
            return r5
        L_0x00e0:
            boolean r0 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r0 == 0) goto L_0x00e9
            android.net.TrafficStats.clearThreadStatsTag()
        L_0x00e9:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcgu.zza(java.lang.String):boolean");
    }
}
