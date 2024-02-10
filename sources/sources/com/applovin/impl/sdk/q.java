package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.e.e;
import com.applovin.impl.sdk.e.f;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class q {
    private final String a = "FileManager";
    private final m b;
    private final u c;
    private final Object d = new Object();
    private final Set<String> e = new HashSet();

    q(m mVar) {
        this.b = mVar;
        this.c = mVar.A();
    }

    private long a() {
        long longValue = ((Long) this.b.a(b.bm)).longValue();
        if (longValue < 0 || !b()) {
            return -1;
        }
        return longValue;
    }

    private long a(long j) {
        return j / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    private File a(String str, boolean z, Context context) {
        if (!StringUtils.isValidString(str)) {
            if (u.a()) {
                this.c.b("FileManager", "Nothing to look up, skipping...");
            }
            return null;
        }
        if (u.a()) {
            u uVar = this.c;
            uVar.b("FileManager", "Looking up cached resource: " + str);
        }
        if (str.contains(RewardPlus.ICON)) {
            str = str.replace("/", "_").replace(".", "_");
        }
        File e2 = e(context);
        File file = new File(e2, str);
        if (z) {
            try {
                e2.mkdirs();
            } catch (Throwable th) {
                if (u.a()) {
                    u uVar2 = this.c;
                    uVar2.b("FileManager", "Unable to make cache directory at " + e2, th);
                }
                return null;
            }
        }
        return file;
    }

    private void a(long j, Context context) {
        u uVar;
        String str;
        if (b()) {
            long intValue = (long) ((Integer) this.b.a(b.bn)).intValue();
            if (intValue != -1) {
                int i = (a(j) > intValue ? 1 : (a(j) == intValue ? 0 : -1));
                boolean a2 = u.a();
                if (i > 0) {
                    if (a2) {
                        this.c.b("FileManager", "Cache has exceeded maximum size; dropping...");
                    }
                    for (File b2 : d(context)) {
                        b(b2);
                    }
                    this.b.T().a(f.h);
                    return;
                } else if (a2) {
                    uVar = this.c;
                    str = "Cache is present but under size limit; not dropping...";
                } else {
                    return;
                }
            } else if (u.a()) {
                uVar = this.c;
                str = "Cache has no maximum size set; skipping drop...";
            } else {
                return;
            }
            uVar.b("FileManager", str);
        }
    }

    private boolean a(File file, String str, List<String> list, boolean z, e eVar) {
        InputStream inputStream;
        if (file == null || !file.exists() || file.isDirectory()) {
            try {
                inputStream = a(str, list, z, eVar);
                try {
                    boolean b2 = b(inputStream, file);
                    Utils.close(inputStream, this.b);
                    return b2;
                } catch (Throwable th) {
                    th = th;
                    Utils.close(inputStream, this.b);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
                Utils.close(inputStream, this.b);
                throw th;
            }
        } else {
            if (u.a()) {
                u uVar = this.c;
                uVar.b("FileManager", "File exists for " + str);
            }
            if (eVar == null) {
                return true;
            }
            eVar.b(file.length());
            return true;
        }
    }

    private boolean b() {
        return ((Boolean) this.b.a(b.bl)).booleanValue();
    }

    /* JADX INFO: finally extract failed */
    private boolean b(File file) {
        if (u.a()) {
            u uVar = this.c;
            uVar.b("FileManager", "Removing file " + file.getName() + " from filesystem...");
        }
        try {
            c(file);
            boolean delete = file.delete();
            d(file);
            return delete;
        } catch (Exception e2) {
            if (u.a()) {
                u uVar2 = this.c;
                uVar2.b("FileManager", "Failed to remove file " + file.getName() + " from filesystem!", e2);
            }
            d(file);
            return false;
        } catch (Throwable th) {
            d(file);
            throw th;
        }
    }

    private long c(Context context) {
        boolean z;
        long a2 = a();
        boolean z2 = a2 != -1;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        List<String> b2 = this.b.b(b.bs);
        long j = 0;
        for (File next : d(context)) {
            if (!z2 || b2.contains(next.getName()) || e(next) || seconds - TimeUnit.MILLISECONDS.toSeconds(next.lastModified()) <= a2) {
                z = false;
            } else {
                if (u.a()) {
                    u uVar = this.c;
                    uVar.b("FileManager", "File " + next.getName() + " has expired, removing...");
                }
                z = b(next);
            }
            if (z) {
                this.b.T().a(f.g);
            } else {
                j += next.length();
            }
        }
        return j;
    }

    private void c(File file) {
        String absolutePath = file.getAbsolutePath();
        synchronized (this.d) {
            boolean add = this.e.add(absolutePath);
            while (!add) {
                try {
                    this.d.wait();
                    add = this.e.add(absolutePath);
                } catch (InterruptedException e2) {
                    if (u.a()) {
                        u uVar = this.c;
                        uVar.b("FileManager", "Lock '" + absolutePath + "' interrupted", e2);
                    }
                    throw new RuntimeException(e2);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r2 = r2.listFiles();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.io.File> d(android.content.Context r2) {
        /*
            r1 = this;
            java.io.File r2 = r1.e((android.content.Context) r2)
            boolean r0 = r2.isDirectory()
            if (r0 == 0) goto L_0x0015
            java.io.File[] r2 = r2.listFiles()
            if (r2 == 0) goto L_0x0015
            java.util.List r2 = java.util.Arrays.asList(r2)
            return r2
        L_0x0015:
            java.util.List r2 = java.util.Collections.emptyList()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.q.d(android.content.Context):java.util.List");
    }

    private void d(File file) {
        String absolutePath = file.getAbsolutePath();
        synchronized (this.d) {
            this.e.remove(absolutePath);
            this.d.notifyAll();
        }
    }

    private File e(Context context) {
        return new File(context.getFilesDir(), CampaignEx.JSON_KEY_AD_AL);
    }

    private boolean e(File file) {
        boolean contains;
        String absolutePath = file.getAbsolutePath();
        synchronized (this.d) {
            contains = this.e.contains(absolutePath);
        }
        return contains;
    }

    public File a(String str, Context context) {
        return a(str, true, context);
    }

    public InputStream a(String str, List<String> list, boolean z, e eVar) {
        if (!z || Utils.isDomainWhitelisted(str, list)) {
            if (((Boolean) this.b.a(b.cR)).booleanValue() && !str.contains("https://")) {
                if (u.a()) {
                    this.c.d("FileManager", "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting...");
                }
                str = str.replace("http://", "https://");
            }
            if (u.a()) {
                u uVar = this.c;
                uVar.b("FileManager", "Loading " + str + "...");
            }
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(((Integer) this.b.a(b.cP)).intValue());
                httpURLConnection.setReadTimeout(((Integer) this.b.a(b.cQ)).intValue());
                httpURLConnection.setDefaultUseCaches(true);
                httpURLConnection.setUseCaches(true);
                httpURLConnection.setAllowUserInteraction(false);
                httpURLConnection.setInstanceFollowRedirects(true);
                int responseCode = httpURLConnection.getResponseCode();
                eVar.a(responseCode);
                if (responseCode >= 200) {
                    if (responseCode < 300) {
                        if (u.a()) {
                            u uVar2 = this.c;
                            uVar2.b("FileManager", "Opened stream to resource " + str);
                        }
                        return httpURLConnection.getInputStream();
                    }
                }
                return null;
            } catch (Exception e2) {
                if (u.a()) {
                    u uVar3 = this.c;
                    uVar3.b("FileManager", "Error loading " + str, e2);
                }
                eVar.a(e2);
                return null;
            }
        } else {
            if (u.a()) {
                u uVar4 = this.c;
                uVar4.b("FileManager", "Domain is not whitelisted, skipping precache for url: " + str);
            }
            return null;
        }
    }

    public String a(Context context, String str, String str2, List<String> list, boolean z, e eVar) {
        return a(context, str, str2, list, z, false, eVar);
    }

    public String a(Context context, String str, String str2, List<String> list, boolean z, boolean z2, e eVar) {
        if (!StringUtils.isValidString(str)) {
            if (u.a()) {
                this.c.b("FileManager", "Nothing to cache, skipping...");
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
        if (u.a()) {
            u uVar = this.c;
            uVar.b("FileManager", "Caching succeeded for file " + str4);
        }
        return z2 ? Uri.fromFile(a2).toString() : str4;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.applovin.impl.sdk.u} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:12|13|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        com.applovin.impl.sdk.utils.Utils.close(r3, r8.b);
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r0 = r3.toString("UTF-8");
        r1 = r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003f */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0062 A[Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x006a, all -> 0x005a, all -> 0x00af }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072 A[Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x006a, all -> 0x005a, all -> 0x00af }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0098 A[Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x006a, all -> 0x005a, all -> 0x00af }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.io.File r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = com.applovin.impl.sdk.u.a()
            java.lang.String r2 = "FileManager"
            if (r1 == 0) goto L_0x0023
            com.applovin.impl.sdk.u r1 = r8.c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Reading resource from filesystem: "
            r3.<init>(r4)
            java.lang.String r4 = r9.getName()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.b(r2, r3)
        L_0x0023:
            r8.c((java.io.File) r9)     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x006a, all -> 0x005a }
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x006a, all -> 0x005a }
            r1.<init>(r9)     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x006a, all -> 0x005a }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
            r4 = 8192(0x2000, float:1.14794E-41)
            byte[] r5 = new byte[r4]     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
        L_0x0034:
            r6 = 0
            int r7 = r1.read(r5, r6, r4)     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
            if (r7 < 0) goto L_0x004d
            r3.write(r5, r6, r7)     // Catch:{ Exception -> 0x003f }
            goto L_0x0034
        L_0x003f:
            com.applovin.impl.sdk.m r4 = r8.b     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
            com.applovin.impl.sdk.utils.Utils.close(r3, r4)     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
        L_0x0044:
            com.applovin.impl.sdk.m r2 = r8.b
            com.applovin.impl.sdk.utils.Utils.close(r1, r2)
            r8.d((java.io.File) r9)
            return r0
        L_0x004d:
            java.lang.String r4 = "UTF-8"
            java.lang.String r0 = r3.toString(r4)     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0054 }
            goto L_0x0044
        L_0x0054:
            r3 = move-exception
            goto L_0x005c
        L_0x0056:
            r3 = move-exception
            goto L_0x006c
        L_0x0058:
            r3 = move-exception
            goto L_0x0092
        L_0x005a:
            r3 = move-exception
            r1 = r0
        L_0x005c:
            boolean r4 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x00af }
            if (r4 == 0) goto L_0x0044
            com.applovin.impl.sdk.u r4 = r8.c     // Catch:{ all -> 0x00af }
            java.lang.String r5 = "Unknown failure to read file."
            r4.b(r2, r5, r3)     // Catch:{ all -> 0x00af }
            goto L_0x0044
        L_0x006a:
            r3 = move-exception
            r1 = r0
        L_0x006c:
            boolean r4 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x00af }
            if (r4 == 0) goto L_0x0044
            com.applovin.impl.sdk.u r4 = r8.c     // Catch:{ all -> 0x00af }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
            r5.<init>()     // Catch:{ all -> 0x00af }
            java.lang.String r6 = "Failed to read file: "
            r5.append(r6)     // Catch:{ all -> 0x00af }
            java.lang.String r6 = r9.getName()     // Catch:{ all -> 0x00af }
            r5.append(r6)     // Catch:{ all -> 0x00af }
            r5.append(r3)     // Catch:{ all -> 0x00af }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x00af }
            r4.b(r2, r3)     // Catch:{ all -> 0x00af }
            goto L_0x0044
        L_0x0090:
            r3 = move-exception
            r1 = r0
        L_0x0092:
            boolean r4 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x00af }
            if (r4 == 0) goto L_0x0044
            com.applovin.impl.sdk.u r4 = r8.c     // Catch:{ all -> 0x00af }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
            r5.<init>()     // Catch:{ all -> 0x00af }
            java.lang.String r6 = "File not found. "
            r5.append(r6)     // Catch:{ all -> 0x00af }
            r5.append(r3)     // Catch:{ all -> 0x00af }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x00af }
            r4.c(r2, r3)     // Catch:{ all -> 0x00af }
            goto L_0x0044
        L_0x00af:
            r0 = move-exception
            com.applovin.impl.sdk.m r2 = r8.b
            com.applovin.impl.sdk.utils.Utils.close(r1, r2)
            r8.d((java.io.File) r9)
            goto L_0x00ba
        L_0x00b9:
            throw r0
        L_0x00ba:
            goto L_0x00b9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.q.a(java.io.File):java.lang.String");
    }

    public void a(Context context) {
        if (b() && this.b.c()) {
            if (u.a()) {
                this.c.b("FileManager", "Compacting cache...");
            }
            a(c(context), context);
        }
    }

    public boolean a(File file, String str, List<String> list, e eVar) {
        return a(file, str, list, true, eVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0062 A[Catch:{ all -> 0x006f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.io.InputStream r7, java.io.File r8) {
        /*
            r6 = this;
            boolean r0 = com.applovin.impl.sdk.u.a()
            java.lang.String r1 = "FileManager"
            if (r0 == 0) goto L_0x001f
            com.applovin.impl.sdk.u r0 = r6.c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Writing resource to filesystem: "
            r2.<init>(r3)
            java.lang.String r3 = r8.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.b(r1, r2)
        L_0x001f:
            r0 = 0
            r2 = 0
            r6.c((java.io.File) r8)     // Catch:{ all -> 0x005b }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x005b }
            r3.<init>(r8)     // Catch:{ all -> 0x005b }
            r2 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r2]     // Catch:{ all -> 0x0058 }
        L_0x002d:
            int r5 = r7.read(r4, r0, r2)     // Catch:{ all -> 0x0058 }
            if (r5 < 0) goto L_0x004e
            r3.write(r4, r0, r5)     // Catch:{ Exception -> 0x0037 }
            goto L_0x002d
        L_0x0037:
            r7 = move-exception
            boolean r2 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x0058 }
            if (r2 == 0) goto L_0x0045
            com.applovin.impl.sdk.u r2 = r6.c     // Catch:{ all -> 0x0058 }
            java.lang.String r4 = "Failed to write next buffer to file"
            r2.b(r1, r4, r7)     // Catch:{ all -> 0x0058 }
        L_0x0045:
            com.applovin.impl.sdk.m r7 = r6.b
            com.applovin.impl.sdk.utils.Utils.close(r3, r7)
        L_0x004a:
            r6.d((java.io.File) r8)
            return r0
        L_0x004e:
            com.applovin.impl.sdk.m r7 = r6.b
            com.applovin.impl.sdk.utils.Utils.close(r3, r7)
            r6.d((java.io.File) r8)
            r7 = 1
            return r7
        L_0x0058:
            r7 = move-exception
            r2 = r3
            goto L_0x005c
        L_0x005b:
            r7 = move-exception
        L_0x005c:
            boolean r3 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x006f }
            if (r3 == 0) goto L_0x0069
            com.applovin.impl.sdk.u r3 = r6.c     // Catch:{ all -> 0x006f }
            java.lang.String r4 = "Unknown failure to write file."
            r3.b(r1, r4, r7)     // Catch:{ all -> 0x006f }
        L_0x0069:
            com.applovin.impl.sdk.m r7 = r6.b
            com.applovin.impl.sdk.utils.Utils.close(r2, r7)
            goto L_0x004a
        L_0x006f:
            r7 = move-exception
            com.applovin.impl.sdk.m r0 = r6.b
            com.applovin.impl.sdk.utils.Utils.close(r2, r0)
            r6.d((java.io.File) r8)
            goto L_0x007a
        L_0x0079:
            throw r7
        L_0x007a:
            goto L_0x0079
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.q.a(java.io.InputStream, java.io.File):boolean");
    }

    public void b(Context context) {
        try {
            a(".nomedia", context);
            File file = new File(e(context), ".nomedia");
            if (!file.exists()) {
                if (u.a()) {
                    u uVar = this.c;
                    uVar.b("FileManager", "Creating .nomedia file at " + file.getAbsolutePath());
                }
                if (!file.createNewFile() && u.a()) {
                    this.c.e("FileManager", "Failed to create .nomedia file");
                }
            }
        } catch (IOException e2) {
            if (u.a()) {
                this.c.b("FileManager", "Failed to create .nomedia file", e2);
            }
        }
    }

    public boolean b(InputStream inputStream, File file) {
        if (file == null) {
            return false;
        }
        if (u.a()) {
            u uVar = this.c;
            uVar.b("FileManager", "Caching " + file.getAbsolutePath() + "...");
        }
        if (!a(inputStream, file)) {
            if (u.a()) {
                u uVar2 = this.c;
                uVar2.e("FileManager", "Unable to cache " + file.getAbsolutePath());
            }
            return false;
        } else if (!u.a()) {
            return true;
        } else {
            u uVar3 = this.c;
            uVar3.b("FileManager", "Caching completed for " + file);
            return true;
        }
    }

    public boolean b(String str, Context context) {
        File a2 = a(str, false, context);
        return a2 != null && a2.exists() && !a2.isDirectory();
    }
}
