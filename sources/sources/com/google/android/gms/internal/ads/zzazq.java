package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Log;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzazq implements zzazv {
    private static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference zzc = new AtomicReference();
    private final int zzd;
    private final int zze;
    private final String zzf;
    private final zzazu zzg = new zzazu();
    private final zzbab zzh;
    private zzazo zzi;
    private HttpURLConnection zzj;
    private InputStream zzk;
    private boolean zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;

    public zzazq(String str, zzbam zzbam, zzbab zzbab, int i, int i2, boolean z, zzazu zzazu) {
        zzbac.zzb(str);
        this.zzf = str;
        this.zzh = zzbab;
        this.zzd = i;
        this.zze = i2;
    }

    private final void zzf() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.zzj = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ef, code lost:
        if (r3 != 0) goto L_0x00f4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x00d2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d0 A[Catch:{ IOException -> 0x025c }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzb(com.google.android.gms.internal.ads.zzazo r20) throws com.google.android.gms.internal.ads.zzazs {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            java.lang.String r3 = "Unable to connect to "
            r1.zzi = r2
            r4 = 0
            r1.zzp = r4
            r1.zzo = r4
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x025c }
            android.net.Uri r7 = r2.zza     // Catch:{ IOException -> 0x025c }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x025c }
            r0.<init>(r7)     // Catch:{ IOException -> 0x025c }
            long r7 = r2.zzc     // Catch:{ IOException -> 0x025c }
            long r9 = r2.zzd     // Catch:{ IOException -> 0x025c }
            r12 = 0
        L_0x001e:
            int r13 = r12 + 1
            r14 = 20
            if (r12 > r14) goto L_0x0245
            java.net.URLConnection r12 = r0.openConnection()     // Catch:{ IOException -> 0x025c }
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ IOException -> 0x025c }
            int r14 = r1.zzd     // Catch:{ IOException -> 0x025c }
            r12.setConnectTimeout(r14)     // Catch:{ IOException -> 0x025c }
            int r14 = r1.zze     // Catch:{ IOException -> 0x025c }
            r12.setReadTimeout(r14)     // Catch:{ IOException -> 0x025c }
            com.google.android.gms.internal.ads.zzazu r14 = r1.zzg     // Catch:{ IOException -> 0x025c }
            java.util.Map r14 = r14.zza()     // Catch:{ IOException -> 0x025c }
            java.util.Set r14 = r14.entrySet()     // Catch:{ IOException -> 0x025c }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ IOException -> 0x025c }
        L_0x0042:
            boolean r15 = r14.hasNext()     // Catch:{ IOException -> 0x025c }
            if (r15 == 0) goto L_0x0060
            java.lang.Object r15 = r14.next()     // Catch:{ IOException -> 0x025c }
            java.util.Map$Entry r15 = (java.util.Map.Entry) r15     // Catch:{ IOException -> 0x025c }
            java.lang.Object r16 = r15.getKey()     // Catch:{ IOException -> 0x025c }
            r6 = r16
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x025c }
            java.lang.Object r15 = r15.getValue()     // Catch:{ IOException -> 0x025c }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ IOException -> 0x025c }
            r12.setRequestProperty(r6, r15)     // Catch:{ IOException -> 0x025c }
            goto L_0x0042
        L_0x0060:
            r14 = -1
            int r6 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x006b
            int r6 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x009c
            goto L_0x006c
        L_0x006b:
            r4 = r7
        L_0x006c:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x025c }
            r6.<init>()     // Catch:{ IOException -> 0x025c }
            java.lang.String r11 = "bytes="
            r6.append(r11)     // Catch:{ IOException -> 0x025c }
            r6.append(r4)     // Catch:{ IOException -> 0x025c }
            java.lang.String r11 = "-"
            r6.append(r11)     // Catch:{ IOException -> 0x025c }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x025c }
            int r11 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r11 == 0) goto L_0x0097
            long r4 = r4 + r9
            long r4 = r4 + r14
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x025c }
            r11.<init>()     // Catch:{ IOException -> 0x025c }
            r11.append(r6)     // Catch:{ IOException -> 0x025c }
            r11.append(r4)     // Catch:{ IOException -> 0x025c }
            java.lang.String r6 = r11.toString()     // Catch:{ IOException -> 0x025c }
        L_0x0097:
            java.lang.String r4 = "Range"
            r12.setRequestProperty(r4, r6)     // Catch:{ IOException -> 0x025c }
        L_0x009c:
            java.lang.String r4 = "User-Agent"
            java.lang.String r5 = r1.zzf     // Catch:{ IOException -> 0x025c }
            r12.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x025c }
            java.lang.String r4 = "Accept-Encoding"
            java.lang.String r5 = "identity"
            r12.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x025c }
            r4 = 0
            r12.setInstanceFollowRedirects(r4)     // Catch:{ IOException -> 0x025c }
            r12.setDoOutput(r4)     // Catch:{ IOException -> 0x025c }
            r12.connect()     // Catch:{ IOException -> 0x025c }
            int r4 = r12.getResponseCode()     // Catch:{ IOException -> 0x025c }
            r5 = 300(0x12c, float:4.2E-43)
            if (r4 == r5) goto L_0x01ff
            r5 = 301(0x12d, float:4.22E-43)
            if (r4 == r5) goto L_0x01ff
            r5 = 302(0x12e, float:4.23E-43)
            if (r4 == r5) goto L_0x01ff
            r5 = 303(0x12f, float:4.25E-43)
            if (r4 == r5) goto L_0x01ff
            r5 = 307(0x133, float:4.3E-43)
            if (r4 == r5) goto L_0x01ff
            r5 = 308(0x134, float:4.32E-43)
            if (r4 != r5) goto L_0x00d2
            goto L_0x01ff
        L_0x00d2:
            r1.zzj = r12     // Catch:{ IOException -> 0x025c }
            int r0 = r12.getResponseCode()     // Catch:{ IOException -> 0x01e5 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 < r3) goto L_0x01c9
            r4 = 299(0x12b, float:4.19E-43)
            if (r0 <= r4) goto L_0x00e2
            goto L_0x01c9
        L_0x00e2:
            java.net.HttpURLConnection r4 = r1.zzj
            r4.getContentType()
            if (r0 != r3) goto L_0x00f2
            long r3 = r2.zzc
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x00f2
            goto L_0x00f4
        L_0x00f2:
            r3 = 0
        L_0x00f4:
            r1.zzm = r3
            long r3 = r2.zzd
            int r0 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x0100
            r1.zzn = r3
            goto L_0x01a9
        L_0x0100:
            java.net.HttpURLConnection r0 = r1.zzj
            java.lang.String r3 = "Content-Length"
            java.lang.String r3 = r0.getHeaderField(r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r5 = "DefaultHttpDataSource"
            java.lang.String r6 = "]"
            if (r4 != 0) goto L_0x012b
            long r7 = java.lang.Long.parseLong(r3)     // Catch:{ NumberFormatException -> 0x0117 }
            goto L_0x012c
        L_0x0117:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r7 = "Unexpected Content-Length ["
            r4.<init>(r7)
            r4.append(r3)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            android.util.Log.e(r5, r4)
        L_0x012b:
            r7 = r14
        L_0x012c:
            java.lang.String r4 = "Content-Range"
            java.lang.String r0 = r0.getHeaderField(r4)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x019f
            java.util.regex.Pattern r4 = zzb
            java.util.regex.Matcher r4 = r4.matcher(r0)
            boolean r9 = r4.find()
            if (r9 == 0) goto L_0x019f
            r9 = 2
            java.lang.String r9 = r4.group(r9)     // Catch:{ NumberFormatException -> 0x018b }
            long r9 = java.lang.Long.parseLong(r9)     // Catch:{ NumberFormatException -> 0x018b }
            r11 = 1
            java.lang.String r4 = r4.group(r11)     // Catch:{ NumberFormatException -> 0x018b }
            long r11 = java.lang.Long.parseLong(r4)     // Catch:{ NumberFormatException -> 0x018b }
            long r9 = r9 - r11
            r11 = 1
            long r9 = r9 + r11
            r17 = 0
            int r4 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r4 >= 0) goto L_0x0162
            r7 = r9
            goto L_0x019f
        L_0x0162:
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 == 0) goto L_0x019f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x018b }
            r4.<init>()     // Catch:{ NumberFormatException -> 0x018b }
            java.lang.String r11 = "Inconsistent headers ["
            r4.append(r11)     // Catch:{ NumberFormatException -> 0x018b }
            r4.append(r3)     // Catch:{ NumberFormatException -> 0x018b }
            java.lang.String r3 = "] ["
            r4.append(r3)     // Catch:{ NumberFormatException -> 0x018b }
            r4.append(r0)     // Catch:{ NumberFormatException -> 0x018b }
            r4.append(r6)     // Catch:{ NumberFormatException -> 0x018b }
            java.lang.String r3 = r4.toString()     // Catch:{ NumberFormatException -> 0x018b }
            android.util.Log.w(r5, r3)     // Catch:{ NumberFormatException -> 0x018b }
            long r3 = java.lang.Math.max(r7, r9)     // Catch:{ NumberFormatException -> 0x018b }
            r7 = r3
            goto L_0x019f
        L_0x018b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Unexpected Content-Range ["
            r3.<init>(r4)
            r3.append(r0)
            r3.append(r6)
            java.lang.String r0 = r3.toString()
            android.util.Log.e(r5, r0)
        L_0x019f:
            int r0 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x01a7
            long r3 = r1.zzm
            long r14 = r7 - r3
        L_0x01a7:
            r1.zzn = r14
        L_0x01a9:
            java.net.HttpURLConnection r0 = r1.zzj     // Catch:{ IOException -> 0x01be }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x01be }
            r1.zzk = r0     // Catch:{ IOException -> 0x01be }
            r3 = 1
            r1.zzl = r3
            com.google.android.gms.internal.ads.zzbab r0 = r1.zzh
            if (r0 == 0) goto L_0x01bb
            r0.zzk(r1, r2)
        L_0x01bb:
            long r2 = r1.zzn
            return r2
        L_0x01be:
            r0 = move-exception
            r19.zzf()
            com.google.android.gms.internal.ads.zzazs r3 = new com.google.android.gms.internal.ads.zzazs
            r4 = 1
            r3.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzazo) r2, (int) r4)
            throw r3
        L_0x01c9:
            java.net.HttpURLConnection r3 = r1.zzj
            java.util.Map r3 = r3.getHeaderFields()
            r19.zzf()
            com.google.android.gms.internal.ads.zzazt r4 = new com.google.android.gms.internal.ads.zzazt
            r4.<init>(r0, r3, r2)
            r2 = 416(0x1a0, float:5.83E-43)
            if (r0 != r2) goto L_0x01e4
            com.google.android.gms.internal.ads.zzazn r0 = new com.google.android.gms.internal.ads.zzazn
            r5 = 0
            r0.<init>(r5)
            r4.initCause(r0)
        L_0x01e4:
            throw r4
        L_0x01e5:
            r0 = move-exception
            r4 = r0
            r19.zzf()
            com.google.android.gms.internal.ads.zzazs r0 = new com.google.android.gms.internal.ads.zzazs
            android.net.Uri r5 = r2.zza
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r3 = r3.concat(r5)
            r5 = 1
            r0.<init>(r3, r4, r2, r5)
            throw r0
        L_0x01ff:
            r5 = 0
            r17 = 0
            java.lang.String r4 = "Location"
            java.lang.String r4 = r12.getHeaderField(r4)     // Catch:{ IOException -> 0x025c }
            r12.disconnect()     // Catch:{ IOException -> 0x025c }
            if (r4 == 0) goto L_0x023d
            java.net.URL r6 = new java.net.URL     // Catch:{ IOException -> 0x025c }
            r6.<init>(r0, r4)     // Catch:{ IOException -> 0x025c }
            java.lang.String r0 = r6.getProtocol()     // Catch:{ IOException -> 0x025c }
            java.lang.String r4 = "https"
            boolean r4 = r4.equals(r0)     // Catch:{ IOException -> 0x025c }
            if (r4 != 0) goto L_0x0237
            java.lang.String r4 = "http"
            boolean r4 = r4.equals(r0)     // Catch:{ IOException -> 0x025c }
            if (r4 == 0) goto L_0x0227
            goto L_0x0237
        L_0x0227:
            java.net.ProtocolException r4 = new java.net.ProtocolException     // Catch:{ IOException -> 0x025c }
            java.lang.String r5 = "Unsupported protocol redirect: "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x025c }
            java.lang.String r0 = r5.concat(r0)     // Catch:{ IOException -> 0x025c }
            r4.<init>(r0)     // Catch:{ IOException -> 0x025c }
            throw r4     // Catch:{ IOException -> 0x025c }
        L_0x0237:
            r0 = r6
            r12 = r13
            r4 = r17
            goto L_0x001e
        L_0x023d:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x025c }
            java.lang.String r4 = "Null location redirect"
            r0.<init>(r4)     // Catch:{ IOException -> 0x025c }
            throw r0     // Catch:{ IOException -> 0x025c }
        L_0x0245:
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x025c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x025c }
            r4.<init>()     // Catch:{ IOException -> 0x025c }
            java.lang.String r5 = "Too many redirects: "
            r4.append(r5)     // Catch:{ IOException -> 0x025c }
            r4.append(r13)     // Catch:{ IOException -> 0x025c }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x025c }
            r0.<init>(r4)     // Catch:{ IOException -> 0x025c }
            throw r0     // Catch:{ IOException -> 0x025c }
        L_0x025c:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzazs r4 = new com.google.android.gms.internal.ads.zzazs
            android.net.Uri r5 = r2.zza
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r3 = r3.concat(r5)
            r5 = 1
            r4.<init>(r3, r0, r2, r5)
            goto L_0x0273
        L_0x0272:
            throw r4
        L_0x0273:
            goto L_0x0272
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazq.zzb(com.google.android.gms.internal.ads.zzazo):long");
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|(1:6)(1:7)|8|(5:13|14|(2:16|(1:18))(2:19|(1:21))|22|(1:26))|27|28) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0069 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd() throws com.google.android.gms.internal.ads.zzazs {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.zzk     // Catch:{ all -> 0x0085 }
            if (r2 == 0) goto L_0x0079
            java.net.HttpURLConnection r2 = r9.zzj     // Catch:{ all -> 0x0085 }
            long r3 = r9.zzn     // Catch:{ all -> 0x0085 }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            long r7 = r9.zzp     // Catch:{ all -> 0x0085 }
            long r3 = r3 - r7
        L_0x0014:
            int r7 = com.google.android.gms.internal.ads.zzbar.zza     // Catch:{ all -> 0x0085 }
            r8 = 19
            if (r7 == r8) goto L_0x0021
            int r7 = com.google.android.gms.internal.ads.zzbar.zza     // Catch:{ all -> 0x0085 }
            r8 = 20
            if (r7 == r8) goto L_0x0021
            goto L_0x0069
        L_0x0021:
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x0069 }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0031
            int r3 = r2.read()     // Catch:{ Exception -> 0x0069 }
            r4 = -1
            if (r3 == r4) goto L_0x0069
            goto L_0x0038
        L_0x0031:
            r5 = 2048(0x800, double:1.0118E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x0038
            goto L_0x0069
        L_0x0038:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x0069 }
            if (r4 != 0) goto L_0x0050
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x0069 }
            if (r3 == 0) goto L_0x0069
        L_0x0050:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x0069 }
            java.lang.Class r3 = r3.getSuperclass()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0069 }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x0069 }
            r4 = 1
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x0069 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0069 }
            r3.invoke(r2, r4)     // Catch:{ Exception -> 0x0069 }
        L_0x0069:
            java.io.InputStream r2 = r9.zzk     // Catch:{ IOException -> 0x006f }
            r2.close()     // Catch:{ IOException -> 0x006f }
            goto L_0x0079
        L_0x006f:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzazs r3 = new com.google.android.gms.internal.ads.zzazs     // Catch:{ all -> 0x0085 }
            com.google.android.gms.internal.ads.zzazo r4 = r9.zzi     // Catch:{ all -> 0x0085 }
            r5 = 3
            r3.<init>((java.io.IOException) r2, (com.google.android.gms.internal.ads.zzazo) r4, (int) r5)     // Catch:{ all -> 0x0085 }
            throw r3     // Catch:{ all -> 0x0085 }
        L_0x0079:
            r9.zzk = r0
            r9.zzf()
            boolean r0 = r9.zzl
            if (r0 == 0) goto L_0x0084
            r9.zzl = r1
        L_0x0084:
            return
        L_0x0085:
            r2 = move-exception
            r9.zzk = r0
            r9.zzf()
            boolean r0 = r9.zzl
            if (r0 == 0) goto L_0x0091
            r9.zzl = r1
        L_0x0091:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazq.zzd():void");
    }

    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzazs {
        try {
            if (this.zzo != this.zzm) {
                byte[] bArr2 = (byte[]) zzc.getAndSet((Object) null);
                if (bArr2 == null) {
                    bArr2 = new byte[4096];
                }
                while (true) {
                    long j = this.zzo;
                    long j2 = this.zzm;
                    if (j == j2) {
                        zzc.set(bArr2);
                        break;
                    }
                    int read = this.zzk.read(bArr2, 0, (int) Math.min(j2 - j, (long) bArr2.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.zzo += (long) read;
                        zzbab zzbab = this.zzh;
                        if (zzbab != null) {
                            zzbab.zzj(this, read);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
            if (i2 == 0) {
                return 0;
            }
            long j3 = this.zzn;
            if (j3 != -1) {
                long j4 = j3 - this.zzp;
                if (j4 != 0) {
                    i2 = (int) Math.min((long) i2, j4);
                }
                return -1;
            }
            int read2 = this.zzk.read(bArr, i, i2);
            if (read2 != -1) {
                this.zzp += (long) read2;
                zzbab zzbab2 = this.zzh;
                if (zzbab2 == null) {
                    return read2;
                }
                zzbab2.zzj(this, read2);
                return read2;
            } else if (this.zzn == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new zzazs(e, this.zzi, 2);
        }
    }
}
