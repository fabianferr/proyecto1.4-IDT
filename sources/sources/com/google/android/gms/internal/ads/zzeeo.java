package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeeo implements zzfhk {
    protected final Context zza;
    protected final String zzb;
    protected final zzcbo zzc;

    public zzeeo(Context context, String str, zzcbo zzcbo, int i, byte[] bArr) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzcbo;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v16, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: java.io.InputStreamReader} */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r2 = new java.io.InputStreamReader(r3.getInputStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        com.google.android.gms.ads.internal.zzt.zzp();
        r0 = new java.lang.StringBuilder(8192);
        r4 = new char[2048];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x012c, code lost:
        r7 = r2.read(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0131, code lost:
        if (r7 == -1) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0133, code lost:
        r0.append(r4, 0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0138, code lost:
        r0 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2);
        r6.zzg(r0);
        r5.zzc = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0148, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x015a, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzay.zzc().zzb(com.google.android.gms.internal.ads.zzbjc.zzeC)).booleanValue() == false) goto L_0x015d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0163, code lost:
        throw new com.google.android.gms.internal.ads.zzebh(3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0164, code lost:
        r5.zzd = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0175, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0176, code lost:
        r7 = r2;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0210 A[Catch:{ all -> 0x0220 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x021f A[Catch:{ all -> 0x0220 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:57:0x0170=Splitter:B:57:0x0170, B:96:0x0221=Splitter:B:96:0x0221} */
    /* renamed from: zzb */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzeen zza(com.google.android.gms.internal.ads.zzeem r21) throws com.google.android.gms.internal.ads.zzebh {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            java.lang.String r2 = "Received error HTTP response code: "
            java.lang.String r3 = "AdRequestServiceImpl: Sending request: "
            java.lang.String r4 = "SDK version: "
            java.lang.String r5 = r0.zza
            int r13 = r0.zzb
            java.util.Map r14 = r0.zzc
            byte[] r15 = r0.zzd
            java.lang.String r0 = r0.zze
            com.google.android.gms.common.util.Clock r6 = com.google.android.gms.ads.internal.zzt.zzB()
            long r16 = r6.elapsedRealtime()
            r12 = 1
            com.google.android.gms.internal.ads.zzeen r11 = new com.google.android.gms.internal.ads.zzeen     // Catch:{ IOException -> 0x0227 }
            r11.<init>()     // Catch:{ IOException -> 0x0227 }
            java.lang.String r6 = r1.zzb     // Catch:{ IOException -> 0x0227 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0227 }
            r7.<init>(r4)     // Catch:{ IOException -> 0x0227 }
            r7.append(r6)     // Catch:{ IOException -> 0x0227 }
            java.lang.String r4 = r7.toString()     // Catch:{ IOException -> 0x0227 }
            com.google.android.gms.ads.internal.util.zze.zzi(r4)     // Catch:{ IOException -> 0x0227 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0227 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0227 }
            r4.append(r5)     // Catch:{ IOException -> 0x0227 }
            java.lang.String r3 = r4.toString()     // Catch:{ IOException -> 0x0227 }
            com.google.android.gms.ads.internal.util.zze.zze(r3)     // Catch:{ IOException -> 0x0227 }
            java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x0227 }
            r3.<init>(r5)     // Catch:{ IOException -> 0x0227 }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ IOException -> 0x0227 }
            r4.<init>()     // Catch:{ IOException -> 0x0227 }
            r18 = 0
        L_0x004e:
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x0227 }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x0227 }
            com.google.android.gms.ads.internal.util.zzs r6 = com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ zzebh -> 0x01fb, all -> 0x01f8 }
            android.content.Context r7 = r1.zza     // Catch:{ zzebh -> 0x01fb, all -> 0x01f8 }
            java.lang.String r8 = r1.zzb     // Catch:{ zzebh -> 0x01fb, all -> 0x01f8 }
            r9 = 0
            r19 = 0
            r10 = r3
            r5 = r11
            r11 = r19
            r1 = 1
            r12 = r13
            r6.zze(r7, r8, r9, r10, r11, r12)     // Catch:{ zzebh -> 0x01f6 }
            java.util.Set r6 = r14.entrySet()     // Catch:{ zzebh -> 0x01f6 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ zzebh -> 0x01f6 }
        L_0x0070:
            boolean r7 = r6.hasNext()     // Catch:{ zzebh -> 0x01f6 }
            if (r7 == 0) goto L_0x008c
            java.lang.Object r7 = r6.next()     // Catch:{ zzebh -> 0x01f6 }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ zzebh -> 0x01f6 }
            java.lang.Object r8 = r7.getKey()     // Catch:{ zzebh -> 0x01f6 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ zzebh -> 0x01f6 }
            java.lang.Object r7 = r7.getValue()     // Catch:{ zzebh -> 0x01f6 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ zzebh -> 0x01f6 }
            r3.addRequestProperty(r8, r7)     // Catch:{ zzebh -> 0x01f6 }
            goto L_0x0070
        L_0x008c:
            boolean r6 = android.text.TextUtils.isEmpty(r0)     // Catch:{ zzebh -> 0x01f6 }
            if (r6 != 0) goto L_0x0097
            java.lang.String r6 = "Content-Type"
            r3.setRequestProperty(r6, r0)     // Catch:{ zzebh -> 0x01f6 }
        L_0x0097:
            int r6 = r15.length     // Catch:{ zzebh -> 0x01f6 }
            r7 = 0
            if (r6 <= 0) goto L_0x00b9
            r3.setDoOutput(r1)     // Catch:{ zzebh -> 0x01f6 }
            r3.setFixedLengthStreamingMode(r6)     // Catch:{ zzebh -> 0x01f6 }
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00b4 }
            java.io.OutputStream r8 = r3.getOutputStream()     // Catch:{ all -> 0x00b4 }
            r6.<init>(r8)     // Catch:{ all -> 0x00b4 }
            r6.write(r15)     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r6)     // Catch:{ zzebh -> 0x01f6 }
            goto L_0x00b9
        L_0x00b1:
            r0 = move-exception
            r7 = r6
            goto L_0x00b5
        L_0x00b4:
            r0 = move-exception
        L_0x00b5:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r7)     // Catch:{ zzebh -> 0x01f6 }
            throw r0     // Catch:{ zzebh -> 0x01f6 }
        L_0x00b9:
            com.google.android.gms.internal.ads.zzcgo r6 = new com.google.android.gms.internal.ads.zzcgo     // Catch:{ zzebh -> 0x01f6 }
            r6.<init>(r7)     // Catch:{ zzebh -> 0x01f6 }
            r6.zzc(r3, r15)     // Catch:{ zzebh -> 0x01f6 }
            int r8 = r3.getResponseCode()     // Catch:{ zzebh -> 0x01f6 }
            java.util.Map r9 = r3.getHeaderFields()     // Catch:{ zzebh -> 0x01f6 }
            java.util.Set r9 = r9.entrySet()     // Catch:{ zzebh -> 0x01f6 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ zzebh -> 0x01f6 }
        L_0x00d1:
            boolean r10 = r9.hasNext()     // Catch:{ zzebh -> 0x01f6 }
            if (r10 == 0) goto L_0x0102
            java.lang.Object r10 = r9.next()     // Catch:{ zzebh -> 0x01f6 }
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ zzebh -> 0x01f6 }
            java.lang.Object r11 = r10.getKey()     // Catch:{ zzebh -> 0x01f6 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ zzebh -> 0x01f6 }
            java.lang.Object r10 = r10.getValue()     // Catch:{ zzebh -> 0x01f6 }
            java.util.List r10 = (java.util.List) r10     // Catch:{ zzebh -> 0x01f6 }
            boolean r12 = r4.containsKey(r11)     // Catch:{ zzebh -> 0x01f6 }
            if (r12 == 0) goto L_0x00f9
            java.lang.Object r11 = r4.get(r11)     // Catch:{ zzebh -> 0x01f6 }
            java.util.List r11 = (java.util.List) r11     // Catch:{ zzebh -> 0x01f6 }
            r11.addAll(r10)     // Catch:{ zzebh -> 0x01f6 }
            goto L_0x00d1
        L_0x00f9:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ zzebh -> 0x01f6 }
            r12.<init>(r10)     // Catch:{ zzebh -> 0x01f6 }
            r4.put(r11, r12)     // Catch:{ zzebh -> 0x01f6 }
            goto L_0x00d1
        L_0x0102:
            r6.zze(r3, r8)     // Catch:{ zzebh -> 0x01f6 }
            r5.zza = r8     // Catch:{ zzebh -> 0x01f6 }
            r5.zzb = r4     // Catch:{ zzebh -> 0x01f6 }
            java.lang.String r9 = ""
            r5.zzc = r9     // Catch:{ zzebh -> 0x01f6 }
            r9 = 200(0xc8, float:2.8E-43)
            r10 = 300(0x12c, float:4.2E-43)
            if (r8 < r9) goto L_0x017d
            if (r8 >= r10) goto L_0x017d
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0178 }
            java.io.InputStream r0 = r3.getInputStream()     // Catch:{ all -> 0x0178 }
            r2.<init>(r0)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x0175 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0175 }
            r4 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r4)     // Catch:{ all -> 0x0175 }
            r4 = 2048(0x800, float:2.87E-42)
            char[] r4 = new char[r4]     // Catch:{ all -> 0x0175 }
        L_0x012c:
            int r7 = r2.read(r4)     // Catch:{ all -> 0x0175 }
            r8 = -1
            if (r7 == r8) goto L_0x0138
            r9 = 0
            r0.append(r4, r9, r7)     // Catch:{ all -> 0x0175 }
            goto L_0x012c
        L_0x0138:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0175 }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)     // Catch:{ zzebh -> 0x01f6 }
            r6.zzg(r0)     // Catch:{ zzebh -> 0x01f6 }
            r5.zzc = r0     // Catch:{ zzebh -> 0x01f6 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ zzebh -> 0x01f6 }
            if (r0 == 0) goto L_0x0164
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzeC     // Catch:{ zzebh -> 0x01f6 }
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ zzebh -> 0x01f6 }
            java.lang.Object r0 = r2.zzb(r0)     // Catch:{ zzebh -> 0x01f6 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ zzebh -> 0x01f6 }
            boolean r0 = r0.booleanValue()     // Catch:{ zzebh -> 0x01f6 }
            if (r0 == 0) goto L_0x015d
            goto L_0x0164
        L_0x015d:
            com.google.android.gms.internal.ads.zzebh r0 = new com.google.android.gms.internal.ads.zzebh     // Catch:{ zzebh -> 0x01f6 }
            r2 = 3
            r0.<init>(r2)     // Catch:{ zzebh -> 0x01f6 }
            throw r0     // Catch:{ zzebh -> 0x01f6 }
        L_0x0164:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzt.zzB()     // Catch:{ zzebh -> 0x01f6 }
            long r6 = r0.elapsedRealtime()     // Catch:{ zzebh -> 0x01f6 }
            long r6 = r6 - r16
            r5.zzd = r6     // Catch:{ zzebh -> 0x01f6 }
        L_0x0170:
            r3.disconnect()     // Catch:{ IOException -> 0x0225 }
            goto L_0x021e
        L_0x0175:
            r0 = move-exception
            r7 = r2
            goto L_0x0179
        L_0x0178:
            r0 = move-exception
        L_0x0179:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r7)     // Catch:{ zzebh -> 0x01f6 }
            throw r0     // Catch:{ zzebh -> 0x01f6 }
        L_0x017d:
            r9 = 0
            if (r8 < r10) goto L_0x01cf
            r6 = 400(0x190, float:5.6E-43)
            if (r8 >= r6) goto L_0x01cf
            java.lang.String r6 = "Location"
            java.lang.String r6 = r3.getHeaderField(r6)     // Catch:{ zzebh -> 0x01f6 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ zzebh -> 0x01f6 }
            if (r7 != 0) goto L_0x01c2
            java.net.URL r7 = new java.net.URL     // Catch:{ zzebh -> 0x01f6 }
            r7.<init>(r6)     // Catch:{ zzebh -> 0x01f6 }
            int r6 = r18 + 1
            com.google.android.gms.internal.ads.zzbiu r8 = com.google.android.gms.internal.ads.zzbjc.zzef     // Catch:{ zzebh -> 0x01f6 }
            com.google.android.gms.internal.ads.zzbja r10 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ zzebh -> 0x01f6 }
            java.lang.Object r8 = r10.zzb(r8)     // Catch:{ zzebh -> 0x01f6 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ zzebh -> 0x01f6 }
            int r8 = r8.intValue()     // Catch:{ zzebh -> 0x01f6 }
            if (r6 > r8) goto L_0x01b5
            r3.disconnect()     // Catch:{ IOException -> 0x0225 }
            r1 = r20
            r11 = r5
            r18 = r6
            r3 = r7
            r12 = 1
            goto L_0x004e
        L_0x01b5:
            java.lang.String r0 = "Too many redirects."
            com.google.android.gms.ads.internal.util.zze.zzj(r0)     // Catch:{ zzebh -> 0x01f6 }
            com.google.android.gms.internal.ads.zzebh r0 = new com.google.android.gms.internal.ads.zzebh     // Catch:{ zzebh -> 0x01f6 }
            java.lang.String r2 = "Too many redirects"
            r0.<init>(r1, r2)     // Catch:{ zzebh -> 0x01f6 }
            throw r0     // Catch:{ zzebh -> 0x01f6 }
        L_0x01c2:
            java.lang.String r0 = "No location header to follow redirect."
            com.google.android.gms.ads.internal.util.zze.zzj(r0)     // Catch:{ zzebh -> 0x01f6 }
            com.google.android.gms.internal.ads.zzebh r0 = new com.google.android.gms.internal.ads.zzebh     // Catch:{ zzebh -> 0x01f6 }
            java.lang.String r2 = "No location header to follow redirect"
            r0.<init>(r1, r2)     // Catch:{ zzebh -> 0x01f6 }
            throw r0     // Catch:{ zzebh -> 0x01f6 }
        L_0x01cf:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ zzebh -> 0x01f6 }
            r0.<init>()     // Catch:{ zzebh -> 0x01f6 }
            r0.append(r2)     // Catch:{ zzebh -> 0x01f6 }
            r0.append(r8)     // Catch:{ zzebh -> 0x01f6 }
            java.lang.String r0 = r0.toString()     // Catch:{ zzebh -> 0x01f6 }
            com.google.android.gms.ads.internal.util.zze.zzj(r0)     // Catch:{ zzebh -> 0x01f6 }
            com.google.android.gms.internal.ads.zzebh r0 = new com.google.android.gms.internal.ads.zzebh     // Catch:{ zzebh -> 0x01f6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ zzebh -> 0x01f6 }
            r4.<init>()     // Catch:{ zzebh -> 0x01f6 }
            r4.append(r2)     // Catch:{ zzebh -> 0x01f6 }
            r4.append(r8)     // Catch:{ zzebh -> 0x01f6 }
            java.lang.String r2 = r4.toString()     // Catch:{ zzebh -> 0x01f6 }
            r0.<init>(r1, r2)     // Catch:{ zzebh -> 0x01f6 }
            throw r0     // Catch:{ zzebh -> 0x01f6 }
        L_0x01f6:
            r0 = move-exception
            goto L_0x01fe
        L_0x01f8:
            r0 = move-exception
            r1 = 1
            goto L_0x0221
        L_0x01fb:
            r0 = move-exception
            r5 = r11
            r1 = 1
        L_0x01fe:
            com.google.android.gms.internal.ads.zzbiu r2 = com.google.android.gms.internal.ads.zzbjc.zzhg     // Catch:{ all -> 0x0220 }
            com.google.android.gms.internal.ads.zzbja r4 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x0220 }
            java.lang.Object r2 = r4.zzb(r2)     // Catch:{ all -> 0x0220 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x0220 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0220 }
            if (r2 == 0) goto L_0x021f
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzt.zzB()     // Catch:{ all -> 0x0220 }
            long r6 = r0.elapsedRealtime()     // Catch:{ all -> 0x0220 }
            long r6 = r6 - r16
            r5.zzd = r6     // Catch:{ all -> 0x0220 }
            goto L_0x0170
        L_0x021e:
            return r5
        L_0x021f:
            throw r0     // Catch:{ all -> 0x0220 }
        L_0x0220:
            r0 = move-exception
        L_0x0221:
            r3.disconnect()     // Catch:{ IOException -> 0x0225 }
            throw r0     // Catch:{ IOException -> 0x0225 }
        L_0x0225:
            r0 = move-exception
            goto L_0x0229
        L_0x0227:
            r0 = move-exception
            r1 = 1
        L_0x0229:
            java.lang.String r2 = r0.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "Error while connecting to ad server: "
            java.lang.String r2 = r3.concat(r2)
            com.google.android.gms.ads.internal.util.zze.zzj(r2)
            com.google.android.gms.internal.ads.zzebh r3 = new com.google.android.gms.internal.ads.zzebh
            r3.<init>(r1, r2, r0)
            goto L_0x0241
        L_0x0240:
            throw r3
        L_0x0241:
            goto L_0x0240
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeeo.zza(com.google.android.gms.internal.ads.zzeem):com.google.android.gms.internal.ads.zzeen");
    }
}
