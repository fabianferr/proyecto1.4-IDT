package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.e.e;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;

public class r {
    private final String a = "FileManagerOld";
    private final m b;
    private final u c;
    private final Object d = new Object();

    r(m mVar) {
        this.b = mVar;
        this.c = mVar.A();
    }

    private File a(Context context) {
        return new File(context.getFilesDir(), CampaignEx.JSON_KEY_AD_AL);
    }

    private boolean a(File file, String str, List<String> list, boolean z, e eVar) {
        if (file == null || !file.exists() || file.isDirectory()) {
            ByteArrayOutputStream a2 = a(str, list, z, eVar);
            if (!(eVar == null || a2 == null)) {
                eVar.a((long) a2.size());
            }
            return a(a2, file);
        }
        if (u.a(this.b)) {
            u uVar = this.c;
            uVar.b("FileManagerOld", "File exists for " + str);
        }
        if (eVar == null) {
            return true;
        }
        eVar.b(file.length());
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0045 A[Catch:{ all -> 0x006c }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005d A[Catch:{ all -> 0x006c }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x0055=Splitter:B:27:0x0055, B:19:0x003d=Splitter:B:19:0x003d} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0066=Splitter:B:31:0x0066, B:19:0x003d=Splitter:B:19:0x003d, B:23:0x004e=Splitter:B:23:0x004e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(java.io.ByteArrayOutputStream r5, java.io.File r6) {
        /*
            r4 = this;
            com.applovin.impl.sdk.m r0 = r4.b
            boolean r0 = com.applovin.impl.sdk.u.a((com.applovin.impl.sdk.m) r0)
            if (r0 == 0) goto L_0x0021
            com.applovin.impl.sdk.u r0 = r4.c
            java.lang.String r1 = "FileManagerOld"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Writing resource to filesystem: "
            r2.<init>(r3)
            java.lang.String r3 = r6.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.b(r1, r2)
        L_0x0021:
            java.lang.Object r0 = r4.d
            monitor-enter(r0)
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0054, all -> 0x003c }
            r2.<init>(r6)     // Catch:{ IOException -> 0x0054, all -> 0x003c }
            r5.writeTo(r2)     // Catch:{ IOException -> 0x0039, all -> 0x0036 }
            com.applovin.impl.sdk.m r5 = r4.b     // Catch:{ all -> 0x0034 }
            com.applovin.impl.sdk.utils.Utils.close(r2, r5)     // Catch:{ all -> 0x0034 }
            r5 = 1
            goto L_0x006a
        L_0x0034:
            r5 = move-exception
            goto L_0x0073
        L_0x0036:
            r5 = move-exception
            r1 = r2
            goto L_0x003d
        L_0x0039:
            r5 = move-exception
            r1 = r2
            goto L_0x0055
        L_0x003c:
            r5 = move-exception
        L_0x003d:
            com.applovin.impl.sdk.m r6 = r4.b     // Catch:{ all -> 0x006c }
            boolean r6 = com.applovin.impl.sdk.u.a((com.applovin.impl.sdk.m) r6)     // Catch:{ all -> 0x006c }
            if (r6 == 0) goto L_0x004e
            com.applovin.impl.sdk.u r6 = r4.c     // Catch:{ all -> 0x006c }
            java.lang.String r2 = "FileManagerOld"
            java.lang.String r3 = "Unknown failure to write file."
            r6.b(r2, r3, r5)     // Catch:{ all -> 0x006c }
        L_0x004e:
            com.applovin.impl.sdk.m r5 = r4.b     // Catch:{ all -> 0x0034 }
        L_0x0050:
            com.applovin.impl.sdk.utils.Utils.close(r1, r5)     // Catch:{ all -> 0x0034 }
            goto L_0x0069
        L_0x0054:
            r5 = move-exception
        L_0x0055:
            com.applovin.impl.sdk.m r6 = r4.b     // Catch:{ all -> 0x006c }
            boolean r6 = com.applovin.impl.sdk.u.a((com.applovin.impl.sdk.m) r6)     // Catch:{ all -> 0x006c }
            if (r6 == 0) goto L_0x0066
            com.applovin.impl.sdk.u r6 = r4.c     // Catch:{ all -> 0x006c }
            java.lang.String r2 = "FileManagerOld"
            java.lang.String r3 = "Unable to write data to file."
            r6.b(r2, r3, r5)     // Catch:{ all -> 0x006c }
        L_0x0066:
            com.applovin.impl.sdk.m r5 = r4.b     // Catch:{ all -> 0x0034 }
            goto L_0x0050
        L_0x0069:
            r5 = 0
        L_0x006a:
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return r5
        L_0x006c:
            r5 = move-exception
            com.applovin.impl.sdk.m r6 = r4.b     // Catch:{ all -> 0x0034 }
            com.applovin.impl.sdk.utils.Utils.close(r1, r6)     // Catch:{ all -> 0x0034 }
            throw r5     // Catch:{ all -> 0x0034 }
        L_0x0073:
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            goto L_0x0076
        L_0x0075:
            throw r5
        L_0x0076:
            goto L_0x0075
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.r.b(java.io.ByteArrayOutputStream, java.io.File):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:14|15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        com.applovin.impl.sdk.utils.Utils.close(r3, r8.b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        com.applovin.impl.sdk.utils.Utils.close(r2, r8.b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0041 */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0064 A[Catch:{ all -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007e A[Catch:{ all -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ae A[Catch:{ all -> 0x00cd }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:40:0x0076=Splitter:B:40:0x0076, B:50:0x00a6=Splitter:B:50:0x00a6, B:30:0x005c=Splitter:B:30:0x005c} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:54:0x00c6=Splitter:B:54:0x00c6, B:30:0x005c=Splitter:B:30:0x005c, B:34:0x006d=Splitter:B:34:0x006d, B:44:0x009d=Splitter:B:44:0x009d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.ByteArrayOutputStream a(java.io.File r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.applovin.impl.sdk.m r1 = r8.b
            boolean r1 = com.applovin.impl.sdk.u.a((com.applovin.impl.sdk.m) r1)
            if (r1 == 0) goto L_0x0025
            com.applovin.impl.sdk.u r1 = r8.c
            java.lang.String r2 = "FileManagerOld"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Reading resource from filesystem: "
            r3.<init>(r4)
            java.lang.String r4 = r9.getName()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.b(r2, r3)
        L_0x0025:
            java.lang.Object r1 = r8.d
            monitor-enter(r1)
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0074, all -> 0x005a }
            r2.<init>(r9)     // Catch:{ FileNotFoundException -> 0x00a4, IOException -> 0x0074, all -> 0x005a }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r4]     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
        L_0x0036:
            r6 = 0
            int r7 = r2.read(r5, r6, r4)     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
            if (r7 < 0) goto L_0x004d
            r3.write(r5, r6, r7)     // Catch:{ Exception -> 0x0041 }
            goto L_0x0036
        L_0x0041:
            com.applovin.impl.sdk.m r4 = r8.b     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
            com.applovin.impl.sdk.utils.Utils.close(r3, r4)     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
            com.applovin.impl.sdk.m r9 = r8.b     // Catch:{ all -> 0x00d4 }
            com.applovin.impl.sdk.utils.Utils.close(r2, r9)     // Catch:{ all -> 0x00d4 }
            monitor-exit(r1)     // Catch:{ all -> 0x00d4 }
            return r0
        L_0x004d:
            com.applovin.impl.sdk.m r9 = r8.b     // Catch:{ all -> 0x00d4 }
            com.applovin.impl.sdk.utils.Utils.close(r2, r9)     // Catch:{ all -> 0x00d4 }
            monitor-exit(r1)     // Catch:{ all -> 0x00d4 }
            return r3
        L_0x0054:
            r9 = move-exception
            goto L_0x005c
        L_0x0056:
            r3 = move-exception
            goto L_0x0076
        L_0x0058:
            r9 = move-exception
            goto L_0x00a6
        L_0x005a:
            r9 = move-exception
            r2 = r0
        L_0x005c:
            com.applovin.impl.sdk.m r3 = r8.b     // Catch:{ all -> 0x00cd }
            boolean r3 = com.applovin.impl.sdk.u.a((com.applovin.impl.sdk.m) r3)     // Catch:{ all -> 0x00cd }
            if (r3 == 0) goto L_0x006d
            com.applovin.impl.sdk.u r3 = r8.c     // Catch:{ all -> 0x00cd }
            java.lang.String r4 = "FileManagerOld"
            java.lang.String r5 = "Unknown failure to read file."
            r3.b(r4, r5, r9)     // Catch:{ all -> 0x00cd }
        L_0x006d:
            com.applovin.impl.sdk.m r9 = r8.b     // Catch:{ all -> 0x00d4 }
            com.applovin.impl.sdk.utils.Utils.close(r2, r9)     // Catch:{ all -> 0x00d4 }
            monitor-exit(r1)     // Catch:{ all -> 0x00d4 }
            return r0
        L_0x0074:
            r3 = move-exception
            r2 = r0
        L_0x0076:
            com.applovin.impl.sdk.m r4 = r8.b     // Catch:{ all -> 0x00cd }
            boolean r4 = com.applovin.impl.sdk.u.a((com.applovin.impl.sdk.m) r4)     // Catch:{ all -> 0x00cd }
            if (r4 == 0) goto L_0x009d
            com.applovin.impl.sdk.u r4 = r8.c     // Catch:{ all -> 0x00cd }
            java.lang.String r5 = "FileManagerOld"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cd }
            r6.<init>()     // Catch:{ all -> 0x00cd }
            java.lang.String r7 = "Failed to read file: "
            r6.append(r7)     // Catch:{ all -> 0x00cd }
            java.lang.String r9 = r9.getName()     // Catch:{ all -> 0x00cd }
            r6.append(r9)     // Catch:{ all -> 0x00cd }
            r6.append(r3)     // Catch:{ all -> 0x00cd }
            java.lang.String r9 = r6.toString()     // Catch:{ all -> 0x00cd }
            r4.b(r5, r9)     // Catch:{ all -> 0x00cd }
        L_0x009d:
            com.applovin.impl.sdk.m r9 = r8.b     // Catch:{ all -> 0x00d4 }
            com.applovin.impl.sdk.utils.Utils.close(r2, r9)     // Catch:{ all -> 0x00d4 }
            monitor-exit(r1)     // Catch:{ all -> 0x00d4 }
            return r0
        L_0x00a4:
            r9 = move-exception
            r2 = r0
        L_0x00a6:
            com.applovin.impl.sdk.m r3 = r8.b     // Catch:{ all -> 0x00cd }
            boolean r3 = com.applovin.impl.sdk.u.a((com.applovin.impl.sdk.m) r3)     // Catch:{ all -> 0x00cd }
            if (r3 == 0) goto L_0x00c6
            com.applovin.impl.sdk.u r3 = r8.c     // Catch:{ all -> 0x00cd }
            java.lang.String r4 = "FileManagerOld"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cd }
            r5.<init>()     // Catch:{ all -> 0x00cd }
            java.lang.String r6 = "File not found. "
            r5.append(r6)     // Catch:{ all -> 0x00cd }
            r5.append(r9)     // Catch:{ all -> 0x00cd }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x00cd }
            r3.c(r4, r9)     // Catch:{ all -> 0x00cd }
        L_0x00c6:
            com.applovin.impl.sdk.m r9 = r8.b     // Catch:{ all -> 0x00d4 }
            com.applovin.impl.sdk.utils.Utils.close(r2, r9)     // Catch:{ all -> 0x00d4 }
            monitor-exit(r1)     // Catch:{ all -> 0x00d4 }
            return r0
        L_0x00cd:
            r9 = move-exception
            com.applovin.impl.sdk.m r0 = r8.b     // Catch:{ all -> 0x00d4 }
            com.applovin.impl.sdk.utils.Utils.close(r2, r0)     // Catch:{ all -> 0x00d4 }
            throw r9     // Catch:{ all -> 0x00d4 }
        L_0x00d4:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00d4 }
            goto L_0x00d8
        L_0x00d7:
            throw r9
        L_0x00d8:
            goto L_0x00d7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.r.a(java.io.File):java.io.ByteArrayOutputStream");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: java.io.InputStream} */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:35|36|37) */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        com.applovin.impl.sdk.utils.Utils.close(r9, r7.b);
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f1, code lost:
        if (com.applovin.impl.sdk.u.a(r7.b) == false) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f3, code lost:
        r7.c.b("FileManagerOld", "Loaded resource at " + r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0109, code lost:
        com.applovin.impl.sdk.utils.Utils.close(r2, r7.b);
        com.applovin.impl.sdk.utils.Utils.close(r9, r7.b);
        com.applovin.impl.sdk.utils.Utils.disconnect(r10, r7.b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0118, code lost:
        return r9;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x013c A[Catch:{ all -> 0x0156 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.ByteArrayOutputStream a(java.lang.String r8, java.util.List<java.lang.String> r9, boolean r10, com.applovin.impl.sdk.e.e r11) {
        /*
            r7 = this;
            java.lang.String r0 = "FileManagerOld"
            r1 = 0
            if (r10 == 0) goto L_0x0027
            boolean r9 = com.applovin.impl.sdk.utils.Utils.isDomainWhitelisted(r8, r9)
            if (r9 != 0) goto L_0x0027
            com.applovin.impl.sdk.m r9 = r7.b
            boolean r9 = com.applovin.impl.sdk.u.a((com.applovin.impl.sdk.m) r9)
            if (r9 == 0) goto L_0x0026
            com.applovin.impl.sdk.u r9 = r7.c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Domain is not whitelisted, skipping precache for url: "
            r10.<init>(r11)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.b(r0, r8)
        L_0x0026:
            return r1
        L_0x0027:
            com.applovin.impl.sdk.m r9 = r7.b
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r10 = com.applovin.impl.sdk.d.b.cR
            java.lang.Object r9 = r9.a(r10)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0054
            java.lang.String r9 = "https://"
            boolean r10 = r8.contains(r9)
            if (r10 != 0) goto L_0x0054
            com.applovin.impl.sdk.m r10 = r7.b
            boolean r10 = com.applovin.impl.sdk.u.a((com.applovin.impl.sdk.m) r10)
            if (r10 == 0) goto L_0x004e
            com.applovin.impl.sdk.u r10 = r7.c
            java.lang.String r2 = "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting..."
            r10.d(r0, r2)
        L_0x004e:
            java.lang.String r10 = "http://"
            java.lang.String r8 = r8.replace(r10, r9)
        L_0x0054:
            com.applovin.impl.sdk.m r9 = r7.b
            boolean r9 = com.applovin.impl.sdk.u.a((com.applovin.impl.sdk.m) r9)
            if (r9 == 0) goto L_0x0074
            com.applovin.impl.sdk.u r9 = r7.c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r2 = "Loading "
            r10.<init>(r2)
            r10.append(r8)
            java.lang.String r2 = "..."
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            r9.b(r0, r10)
        L_0x0074:
            java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0130, all -> 0x012c }
            r9.<init>()     // Catch:{ IOException -> 0x0130, all -> 0x012c }
            java.net.URL r10 = new java.net.URL     // Catch:{ IOException -> 0x0129, all -> 0x0126 }
            r10.<init>(r8)     // Catch:{ IOException -> 0x0129, all -> 0x0126 }
            java.net.URLConnection r10 = r10.openConnection()     // Catch:{ IOException -> 0x0129, all -> 0x0126 }
            java.net.HttpURLConnection r10 = (java.net.HttpURLConnection) r10     // Catch:{ IOException -> 0x0129, all -> 0x0126 }
            com.applovin.impl.sdk.m r2 = r7.b     // Catch:{ IOException -> 0x0123, all -> 0x0121 }
            com.applovin.impl.sdk.d.b<java.lang.Integer> r3 = com.applovin.impl.sdk.d.b.cP     // Catch:{ IOException -> 0x0123, all -> 0x0121 }
            java.lang.Object r2 = r2.a(r3)     // Catch:{ IOException -> 0x0123, all -> 0x0121 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x0123, all -> 0x0121 }
            int r2 = r2.intValue()     // Catch:{ IOException -> 0x0123, all -> 0x0121 }
            r10.setConnectTimeout(r2)     // Catch:{ IOException -> 0x0123, all -> 0x0121 }
            com.applovin.impl.sdk.m r2 = r7.b     // Catch:{ IOException -> 0x0123, all -> 0x0121 }
            com.applovin.impl.sdk.d.b<java.lang.Integer> r3 = com.applovin.impl.sdk.d.b.cQ     // Catch:{ IOException -> 0x0123, all -> 0x0121 }
            java.lang.Object r2 = r2.a(r3)     // Catch:{ IOException -> 0x0123, all -> 0x0121 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x0123, all -> 0x0121 }
            int r2 = r2.intValue()     // Catch:{ IOException -> 0x0123, all -> 0x0121 }
            r10.setReadTimeout(r2)     // Catch:{ IOException -> 0x0123, all -> 0x0121 }
            r2 = 1
            r10.setDefaultUseCaches(r2)     // Catch:{ IOException -> 0x0123, all -> 0x0121 }
            r10.setUseCaches(r2)     // Catch:{ IOException -> 0x0123, all -> 0x0121 }
            r3 = 0
            r10.setAllowUserInteraction(r3)     // Catch:{ IOException -> 0x0123, all -> 0x0121 }
            r10.setInstanceFollowRedirects(r2)     // Catch:{ IOException -> 0x0123, all -> 0x0121 }
            int r2 = r10.getResponseCode()     // Catch:{ IOException -> 0x0123, all -> 0x0121 }
            r11.a((int) r2)     // Catch:{ IOException -> 0x0123, all -> 0x0121 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r2 < r4) goto L_0x011b
            r4 = 300(0x12c, float:4.2E-43)
            if (r2 < r4) goto L_0x00c4
            goto L_0x011b
        L_0x00c4:
            java.io.InputStream r2 = r10.getInputStream()     // Catch:{ IOException -> 0x0123, all -> 0x0121 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r4]     // Catch:{ IOException -> 0x0119 }
        L_0x00cc:
            int r6 = r2.read(r5, r3, r4)     // Catch:{ IOException -> 0x0119 }
            if (r6 < 0) goto L_0x00eb
            r9.write(r5, r3, r6)     // Catch:{ Exception -> 0x00d6 }
            goto L_0x00cc
        L_0x00d6:
            com.applovin.impl.sdk.m r3 = r7.b     // Catch:{ IOException -> 0x0119 }
            com.applovin.impl.sdk.utils.Utils.close(r9, r3)     // Catch:{ IOException -> 0x0119 }
        L_0x00db:
            com.applovin.impl.sdk.m r8 = r7.b
            com.applovin.impl.sdk.utils.Utils.close(r2, r8)
        L_0x00e0:
            com.applovin.impl.sdk.m r8 = r7.b
            com.applovin.impl.sdk.utils.Utils.close(r9, r8)
            com.applovin.impl.sdk.m r8 = r7.b
            com.applovin.impl.sdk.utils.Utils.disconnect(r10, r8)
            return r1
        L_0x00eb:
            com.applovin.impl.sdk.m r3 = r7.b     // Catch:{ IOException -> 0x0119 }
            boolean r3 = com.applovin.impl.sdk.u.a((com.applovin.impl.sdk.m) r3)     // Catch:{ IOException -> 0x0119 }
            if (r3 == 0) goto L_0x0109
            com.applovin.impl.sdk.u r3 = r7.c     // Catch:{ IOException -> 0x0119 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0119 }
            r4.<init>()     // Catch:{ IOException -> 0x0119 }
            java.lang.String r5 = "Loaded resource at "
            r4.append(r5)     // Catch:{ IOException -> 0x0119 }
            r4.append(r8)     // Catch:{ IOException -> 0x0119 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x0119 }
            r3.b(r0, r4)     // Catch:{ IOException -> 0x0119 }
        L_0x0109:
            com.applovin.impl.sdk.m r8 = r7.b
            com.applovin.impl.sdk.utils.Utils.close(r2, r8)
            com.applovin.impl.sdk.m r8 = r7.b
            com.applovin.impl.sdk.utils.Utils.close(r9, r8)
            com.applovin.impl.sdk.m r8 = r7.b
            com.applovin.impl.sdk.utils.Utils.disconnect(r10, r8)
            return r9
        L_0x0119:
            r3 = move-exception
            goto L_0x0134
        L_0x011b:
            com.applovin.impl.sdk.m r8 = r7.b
            com.applovin.impl.sdk.utils.Utils.close(r1, r8)
            goto L_0x00e0
        L_0x0121:
            r8 = move-exception
            goto L_0x0158
        L_0x0123:
            r3 = move-exception
            r2 = r1
            goto L_0x0134
        L_0x0126:
            r8 = move-exception
            r10 = r1
            goto L_0x0158
        L_0x0129:
            r3 = move-exception
            r10 = r1
            goto L_0x0133
        L_0x012c:
            r8 = move-exception
            r9 = r1
            r10 = r9
            goto L_0x0158
        L_0x0130:
            r3 = move-exception
            r9 = r1
            r10 = r9
        L_0x0133:
            r2 = r10
        L_0x0134:
            com.applovin.impl.sdk.m r4 = r7.b     // Catch:{ all -> 0x0156 }
            boolean r4 = com.applovin.impl.sdk.u.a((com.applovin.impl.sdk.m) r4)     // Catch:{ all -> 0x0156 }
            if (r4 == 0) goto L_0x0152
            com.applovin.impl.sdk.u r4 = r7.c     // Catch:{ all -> 0x0156 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0156 }
            r5.<init>()     // Catch:{ all -> 0x0156 }
            java.lang.String r6 = "Error loading "
            r5.append(r6)     // Catch:{ all -> 0x0156 }
            r5.append(r8)     // Catch:{ all -> 0x0156 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x0156 }
            r4.b(r0, r8, r3)     // Catch:{ all -> 0x0156 }
        L_0x0152:
            r11.a((java.lang.Exception) r3)     // Catch:{ all -> 0x0156 }
            goto L_0x00db
        L_0x0156:
            r8 = move-exception
            r1 = r2
        L_0x0158:
            com.applovin.impl.sdk.m r11 = r7.b
            com.applovin.impl.sdk.utils.Utils.close(r1, r11)
            com.applovin.impl.sdk.m r11 = r7.b
            com.applovin.impl.sdk.utils.Utils.close(r9, r11)
            com.applovin.impl.sdk.m r9 = r7.b
            com.applovin.impl.sdk.utils.Utils.disconnect(r10, r9)
            goto L_0x0169
        L_0x0168:
            throw r8
        L_0x0169:
            goto L_0x0168
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.r.a(java.lang.String, java.util.List, boolean, com.applovin.impl.sdk.e.e):java.io.ByteArrayOutputStream");
    }

    public File a(String str, Context context) {
        File file;
        if (!StringUtils.isValidString(str)) {
            if (u.a(this.b)) {
                this.c.b("FileManagerOld", "Nothing to look up, skipping...");
            }
            return null;
        }
        if (u.a(this.b)) {
            u uVar = this.c;
            uVar.b("FileManagerOld", "Looking up cached resource: " + str);
        }
        if (str.contains(RewardPlus.ICON)) {
            str = str.replace("/", "_").replace(".", "_");
        }
        synchronized (this.d) {
            File a2 = a(context);
            file = new File(a2, str);
            try {
                a2.mkdirs();
            } catch (Throwable th) {
                if (u.a(this.b)) {
                    u uVar2 = this.c;
                    uVar2.b("FileManagerOld", "Unable to make cache directory at " + a2, th);
                }
                return null;
            }
        }
        return file;
    }

    public String a(Context context, String str, String str2, List<String> list, boolean z, e eVar) {
        return a(context, str, str2, list, z, false, eVar);
    }

    public String a(Context context, String str, String str2, List<String> list, boolean z, boolean z2, e eVar) {
        if (!StringUtils.isValidString(str)) {
            if (u.a(this.b)) {
                this.c.b("FileManagerOld", "Nothing to cache, skipping...");
            }
            return null;
        }
        Uri parse = Uri.parse(str);
        String fileName = ((Boolean) this.b.a(b.eW)).booleanValue() ? Utils.getFileName(parse) : parse.getLastPathSegment();
        if (StringUtils.isValidString(fileName) && StringUtils.isValidString(str2)) {
            StringBuilder sb = new StringBuilder();
            String str3 = str2;
            sb.append(str2);
            sb.append(fileName);
            fileName = sb.toString();
        }
        String str4 = fileName;
        Context context2 = context;
        File a2 = a(str4, context);
        if (!a(a2, str, list, z, eVar)) {
            return null;
        }
        if (u.a(this.b)) {
            u uVar = this.c;
            uVar.b("FileManagerOld", "Caching succeeded for file " + str4);
        }
        return z2 ? Uri.fromFile(a2).toString() : str4;
    }

    public boolean a(ByteArrayOutputStream byteArrayOutputStream, File file) {
        if (file == null) {
            return false;
        }
        if (u.a(this.b)) {
            u uVar = this.c;
            uVar.b("FileManagerOld", "Caching " + file.getAbsolutePath() + "...");
        }
        if (byteArrayOutputStream == null || byteArrayOutputStream.size() <= 0) {
            if (u.a(this.b)) {
                u uVar2 = this.c;
                uVar2.d("FileManagerOld", "No data for " + file.getAbsolutePath());
            }
            return false;
        } else if (!b(byteArrayOutputStream, file)) {
            if (u.a(this.b)) {
                u uVar3 = this.c;
                uVar3.e("FileManagerOld", "Unable to cache " + file.getAbsolutePath());
            }
            return false;
        } else if (!u.a(this.b)) {
            return true;
        } else {
            u uVar4 = this.c;
            uVar4.b("FileManagerOld", "Caching completed for " + file);
            return true;
        }
    }

    public boolean a(File file, String str, List<String> list, e eVar) {
        return a(file, str, list, true, eVar);
    }

    public boolean b(String str, Context context) {
        boolean z;
        synchronized (this.d) {
            File a2 = a(str, context);
            z = a2 != null && a2.exists() && !a2.isDirectory();
        }
        return z;
    }
}
