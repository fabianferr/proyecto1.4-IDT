package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.c.f;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SameFileTool */
public final class y extends h {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003a A[SYNTHETIC, Splitter:B:24:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0040 A[SYNTHETIC, Splitter:B:28:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long c(java.io.File r4) throws java.lang.Exception {
        /*
            r0 = 0
            r2 = 0
            boolean r3 = r4.exists()     // Catch:{ Exception -> 0x0034 }
            if (r3 == 0) goto L_0x001b
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0034 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0034 }
            int r4 = r3.available()     // Catch:{ Exception -> 0x0018, all -> 0x0015 }
            long r0 = (long) r4
            r2 = r3
            goto L_0x0027
        L_0x0015:
            r4 = move-exception
            r2 = r3
            goto L_0x003e
        L_0x0018:
            r4 = move-exception
            r2 = r3
            goto L_0x0035
        L_0x001b:
            r4.createNewFile()     // Catch:{ Exception -> 0x0034 }
            java.lang.String r4 = "获取文件大小"
            java.lang.String r3 = "文件不存在!"
            com.mbridge.msdk.foundation.tools.aa.d(r4, r3)     // Catch:{ Exception -> 0x0034 }
        L_0x0027:
            if (r2 == 0) goto L_0x003d
            r2.close()     // Catch:{ Exception -> 0x002d }
            goto L_0x003d
        L_0x002d:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x003d
        L_0x0032:
            r4 = move-exception
            goto L_0x003e
        L_0x0034:
            r4 = move-exception
        L_0x0035:
            r4.printStackTrace()     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x003d
            r2.close()     // Catch:{ Exception -> 0x002d }
        L_0x003d:
            return r0
        L_0x003e:
            if (r2 == 0) goto L_0x0048
            r2.close()     // Catch:{ Exception -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0048:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.y.c(java.io.File):long");
    }

    private static long d(File file) throws Exception {
        long j;
        File[] listFiles = file.listFiles();
        long j2 = 0;
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory()) {
                    j = d(listFiles[i]);
                } else {
                    j = c(listFiles[i]);
                }
                j2 += j;
            }
        }
        return j2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
        if (r1 == null) goto L_0x0044;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0050 A[SYNTHETIC, Splitter:B:30:0x0050] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x003b, all -> 0x0039 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ IOException -> 0x003b, all -> 0x0039 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x003b, all -> 0x0039 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x003b, all -> 0x0039 }
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x0036 }
            r4.<init>()     // Catch:{ IOException -> 0x0036 }
        L_0x0013:
            java.lang.String r2 = r1.readLine()     // Catch:{ IOException -> 0x0034 }
            if (r2 == 0) goto L_0x002e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0034 }
            r3.<init>()     // Catch:{ IOException -> 0x0034 }
            r3.append(r2)     // Catch:{ IOException -> 0x0034 }
            java.lang.String r2 = "\n"
            r3.append(r2)     // Catch:{ IOException -> 0x0034 }
            java.lang.String r2 = r3.toString()     // Catch:{ IOException -> 0x0034 }
            r4.append(r2)     // Catch:{ IOException -> 0x0034 }
            goto L_0x0013
        L_0x002e:
            r1.close()     // Catch:{ IOException -> 0x0032 }
            goto L_0x0044
        L_0x0032:
            goto L_0x0044
        L_0x0034:
            r2 = move-exception
            goto L_0x003e
        L_0x0036:
            r2 = move-exception
            r4 = r0
            goto L_0x003e
        L_0x0039:
            r4 = move-exception
            goto L_0x004e
        L_0x003b:
            r2 = move-exception
            r4 = r0
            r1 = r4
        L_0x003e:
            r2.printStackTrace()     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x0044
            goto L_0x002e
        L_0x0044:
            if (r4 == 0) goto L_0x004b
            java.lang.String r4 = r4.toString()
            return r4
        L_0x004b:
            return r0
        L_0x004c:
            r4 = move-exception
            r0 = r1
        L_0x004e:
            if (r0 == 0) goto L_0x0053
            r0.close()     // Catch:{ IOException -> 0x0053 }
        L_0x0053:
            goto L_0x0055
        L_0x0054:
            throw r4
        L_0x0055:
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.y.a(java.io.File):java.lang.String");
    }

    public static boolean a(String str) {
        if (f.a(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        return true;
    }

    public static File[] b(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.listFiles();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a() {
        new Thread(new Runnable() {
            public final void run() {
                try {
                    if (b.d().g() != null) {
                        String b = e.b(c.MBRIDGE_VC);
                        try {
                            File file = new File(b);
                            if (file.exists() && file.isDirectory()) {
                                for (File file2 : y.b(b)) {
                                    if (file2.exists() && file2.isFile()) {
                                        file2.delete();
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void c(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                com.mbridge.msdk.c.e b = com.mbridge.msdk.c.f.a().b(b.d().h());
                if (b == null) {
                    b = com.mbridge.msdk.c.f.a().b();
                }
                long currentTimeMillis = System.currentTimeMillis() - ((long) (b.R() * 1000));
                File file = new File(str);
                if (file.exists() && file.isDirectory()) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (File file2 : listFiles) {
                            if (file2.lastModified() + currentTimeMillis < currentTimeMillis2) {
                                b(file2);
                                try {
                                    File file3 = new File(str + ".zip");
                                    if (file3.exists() && file3.isFile()) {
                                        b(file3);
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    public static void b() {
        AnonymousClass2 r0 = new Runnable() {
            public final void run() {
                try {
                    com.mbridge.msdk.c.e b = com.mbridge.msdk.c.f.a().b(b.d().h());
                    if (b == null) {
                        b = com.mbridge.msdk.c.f.a().b();
                    }
                    y.a(e.b(c.MBRIDGE_RES_MANAGER_DIR), b.d());
                    y.a(System.currentTimeMillis() - ((long) (b.R() * 1000)));
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        };
        com.mbridge.msdk.foundation.controller.c.a();
        com.mbridge.msdk.foundation.same.f.b.a().execute(r0);
    }

    public static String b(File file) {
        try {
            if (file.isFile()) {
                file.delete();
                return "";
            } else if (!file.isDirectory()) {
                return "";
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    if (listFiles.length != 0) {
                        for (File b : listFiles) {
                            b(b);
                        }
                        file.delete();
                        return "";
                    }
                }
                file.delete();
                return "";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private static ArrayList<File> e(File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        for (File file2 : file.listFiles(new FileFilter() {
            public final boolean accept(File file) {
                if (!file.isHidden() || file.isDirectory()) {
                    return true;
                }
                return false;
            }
        })) {
            if (!file2.isDirectory()) {
                arrayList.add(file2);
            } else {
                arrayList.addAll(e(file2));
            }
        }
        return arrayList;
    }

    private static void e(String str) {
        try {
            ArrayList<File> e = e(new File(str));
            Collections.sort(e, new Comparator<File>() {
                public final boolean equals(Object obj) {
                    return true;
                }

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    long lastModified = ((File) obj).lastModified() - ((File) obj2).lastModified();
                    if (lastModified > 0) {
                        return 1;
                    }
                    return lastModified == 0 ? 0 : -1;
                }
            });
            int size = (e.size() - 1) / 2;
            for (int i = 0; i < size; i++) {
                File file = e.get(i);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (Exception unused) {
            aa.d("SameFileTool", "del memory failed");
        }
    }

    public static void a(long j) {
        try {
            Iterator<File> it = e(new File(e.b(c.MBRIDGE_RES_MANAGER_DIR))).iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (next.lastModified() < j && next.exists() && next.isFile()) {
                    next.delete();
                }
            }
        } catch (Throwable th) {
            aa.b("SameFileTool", th.getMessage(), th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0034 A[SYNTHETIC, Splitter:B:23:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0040 A[SYNTHETIC, Splitter:B:28:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(byte[] r2, java.io.File r3) {
        /*
            r0 = 0
            java.io.File r1 = r3.getParentFile()     // Catch:{ Exception -> 0x002e }
            if (r1 == 0) goto L_0x0014
            boolean r1 = r3.exists()     // Catch:{ Exception -> 0x002e }
            if (r1 != 0) goto L_0x0014
            java.io.File r1 = r3.getParentFile()     // Catch:{ Exception -> 0x002e }
            r1.mkdirs()     // Catch:{ Exception -> 0x002e }
        L_0x0014:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x002e }
            r1.<init>(r3)     // Catch:{ Exception -> 0x002e }
            r1.write(r2)     // Catch:{ Exception -> 0x0029, all -> 0x0026 }
            r1.close()     // Catch:{ IOException -> 0x0020 }
            goto L_0x0024
        L_0x0020:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0024:
            r2 = 1
            return r2
        L_0x0026:
            r2 = move-exception
            r0 = r1
            goto L_0x003e
        L_0x0029:
            r2 = move-exception
            r0 = r1
            goto L_0x002f
        L_0x002c:
            r2 = move-exception
            goto L_0x003e
        L_0x002e:
            r2 = move-exception
        L_0x002f:
            r2.printStackTrace()     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x003c
            r0.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r2 = move-exception
            r2.printStackTrace()
        L_0x003c:
            r2 = 0
            return r2
        L_0x003e:
            if (r0 == 0) goto L_0x0048
            r0.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0048:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.y.a(byte[], java.io.File):boolean");
    }

    public static String d(String str) {
        return !TextUtils.isEmpty(str) ? SameMD5.getMD5(al.b(str.trim())) : "";
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:40|41|42|43|44|(2:50|(2:145|52)(3:53|(2:55|149)(8:56|(1:58)|59|60|61|(2:62|(1:64)(1:151))|65|150)|140))(2:143|144)) */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0127, code lost:
        r10.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0135, code lost:
        r11 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0140, code lost:
        r11.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x014d, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x014e, code lost:
        r10.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0157, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0158, code lost:
        r10.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00f0, code lost:
        if (r10 == null) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00f6, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00f7, code lost:
        r10.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0120, code lost:
        if (r10 == null) goto L_0x012a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0126, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0093 */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0140 A[Catch:{ all -> 0x015c }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0149 A[SYNTHETIC, Splitter:B:118:0x0149] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0153 A[SYNTHETIC, Splitter:B:123:0x0153] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x015f A[SYNTHETIC, Splitter:B:130:0x015f] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0169 A[SYNTHETIC, Splitter:B:135:0x0169] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x00ab A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ac A[Catch:{ IOException -> 0x0135 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "../"
            java.lang.String r1 = ".."
            if (r10 == 0) goto L_0x0172
            if (r11 != 0) goto L_0x000a
            goto L_0x0172
        L_0x000a:
            java.lang.String r2 = "/"
            boolean r3 = r11.endsWith(r2)
            if (r3 != 0) goto L_0x0021
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r11)
            r3.append(r2)
            java.lang.String r11 = r3.toString()
        L_0x0021:
            java.io.File r2 = new java.io.File
            r2.<init>(r10)
            boolean r10 = r2.exists()
            if (r10 != 0) goto L_0x0030
            java.lang.String r10 = "unzip file not exists"
            return r10
        L_0x0030:
            r10 = 0
            java.util.zip.ZipFile r3 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x013a, all -> 0x0137 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x013a, all -> 0x0137 }
            java.util.Enumeration r2 = r3.entries()     // Catch:{ IOException -> 0x013a, all -> 0x0137 }
            r4 = r10
        L_0x003b:
            boolean r5 = r2.hasMoreElements()     // Catch:{ IOException -> 0x0135 }
            java.lang.String r6 = ""
            if (r5 == 0) goto L_0x011d
            java.lang.Object r5 = r2.nextElement()     // Catch:{ IOException -> 0x0135 }
            java.util.zip.ZipEntry r5 = (java.util.zip.ZipEntry) r5     // Catch:{ IOException -> 0x0135 }
            if (r5 != 0) goto L_0x0063
            java.lang.String r11 = "unzip zipEntry is null"
            if (r10 == 0) goto L_0x0058
            r10.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0058:
            if (r4 == 0) goto L_0x0062
            r4.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0062:
            return r11
        L_0x0063:
            java.lang.String r7 = r5.getName()     // Catch:{ IOException -> 0x0135 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IOException -> 0x0135 }
            if (r8 != 0) goto L_0x0105
            boolean r8 = r7.startsWith(r1)     // Catch:{ IOException -> 0x0135 }
            if (r8 != 0) goto L_0x0105
            boolean r8 = r7.startsWith(r0)     // Catch:{ IOException -> 0x0135 }
            if (r8 == 0) goto L_0x007b
            goto L_0x0105
        L_0x007b:
            java.io.File r8 = new java.io.File     // Catch:{ IOException -> 0x0135 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0135 }
            r9.<init>()     // Catch:{ IOException -> 0x0135 }
            r9.append(r11)     // Catch:{ IOException -> 0x0135 }
            r9.append(r7)     // Catch:{ IOException -> 0x0135 }
            java.lang.String r7 = r9.toString()     // Catch:{ IOException -> 0x0135 }
            r8.<init>(r7)     // Catch:{ IOException -> 0x0135 }
            java.lang.String r6 = r8.getCanonicalPath()     // Catch:{ IOException -> 0x0093 }
        L_0x0093:
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IOException -> 0x0135 }
            if (r7 != 0) goto L_0x00ed
            boolean r7 = r6.startsWith(r11)     // Catch:{ IOException -> 0x0135 }
            if (r7 == 0) goto L_0x00ed
            boolean r7 = r6.startsWith(r1)     // Catch:{ IOException -> 0x0135 }
            if (r7 != 0) goto L_0x00ed
            boolean r6 = r6.startsWith(r0)     // Catch:{ IOException -> 0x0135 }
            if (r6 == 0) goto L_0x00ac
            goto L_0x00ed
        L_0x00ac:
            boolean r6 = r5.isDirectory()     // Catch:{ IOException -> 0x0135 }
            if (r6 == 0) goto L_0x00b6
            r8.mkdirs()     // Catch:{ IOException -> 0x0135 }
            goto L_0x003b
        L_0x00b6:
            java.io.File r6 = r8.getParentFile()     // Catch:{ IOException -> 0x0135 }
            boolean r6 = r6.exists()     // Catch:{ IOException -> 0x0135 }
            if (r6 != 0) goto L_0x00c7
            java.io.File r6 = r8.getParentFile()     // Catch:{ IOException -> 0x0135 }
            r6.mkdirs()     // Catch:{ IOException -> 0x0135 }
        L_0x00c7:
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0135 }
            r6.<init>(r8)     // Catch:{ IOException -> 0x0135 }
            java.io.InputStream r10 = r3.getInputStream(r5)     // Catch:{ IOException -> 0x00ea, all -> 0x00e6 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r4]     // Catch:{ IOException -> 0x00ea, all -> 0x00e6 }
        L_0x00d4:
            r7 = 0
            int r8 = r10.read(r5, r7, r4)     // Catch:{ IOException -> 0x00ea, all -> 0x00e6 }
            r9 = -1
            if (r8 == r9) goto L_0x00e3
            r6.write(r5, r7, r8)     // Catch:{ IOException -> 0x00ea, all -> 0x00e6 }
            r6.flush()     // Catch:{ IOException -> 0x00ea, all -> 0x00e6 }
            goto L_0x00d4
        L_0x00e3:
            r4 = r6
            goto L_0x003b
        L_0x00e6:
            r11 = move-exception
            r4 = r6
            goto L_0x015d
        L_0x00ea:
            r11 = move-exception
            r4 = r6
            goto L_0x013c
        L_0x00ed:
            java.lang.String r11 = "unzip zipEntry canonicalPath is not available"
            if (r10 == 0) goto L_0x00fa
            r10.close()     // Catch:{ IOException -> 0x00f6 }
            goto L_0x00fa
        L_0x00f6:
            r10 = move-exception
            r10.printStackTrace()
        L_0x00fa:
            if (r4 == 0) goto L_0x0104
            r4.close()     // Catch:{ IOException -> 0x0100 }
            goto L_0x0104
        L_0x0100:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0104:
            return r11
        L_0x0105:
            java.lang.String r11 = "unzip zipEntry name is not available"
            if (r10 == 0) goto L_0x0112
            r10.close()     // Catch:{ IOException -> 0x010e }
            goto L_0x0112
        L_0x010e:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0112:
            if (r4 == 0) goto L_0x011c
            r4.close()     // Catch:{ IOException -> 0x0118 }
            goto L_0x011c
        L_0x0118:
            r10 = move-exception
            r10.printStackTrace()
        L_0x011c:
            return r11
        L_0x011d:
            r3.close()     // Catch:{ IOException -> 0x0135 }
            if (r10 == 0) goto L_0x012a
            r10.close()     // Catch:{ IOException -> 0x0126 }
            goto L_0x012a
        L_0x0126:
            r10 = move-exception
            r10.printStackTrace()
        L_0x012a:
            if (r4 == 0) goto L_0x0134
            r4.close()     // Catch:{ IOException -> 0x0130 }
            goto L_0x0134
        L_0x0130:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0134:
            return r6
        L_0x0135:
            r11 = move-exception
            goto L_0x013c
        L_0x0137:
            r11 = move-exception
            r4 = r10
            goto L_0x015d
        L_0x013a:
            r11 = move-exception
            r4 = r10
        L_0x013c:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x015c }
            if (r0 == 0) goto L_0x0143
            r11.printStackTrace()     // Catch:{ all -> 0x015c }
        L_0x0143:
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x015c }
            if (r10 == 0) goto L_0x0151
            r10.close()     // Catch:{ IOException -> 0x014d }
            goto L_0x0151
        L_0x014d:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0151:
            if (r4 == 0) goto L_0x015b
            r4.close()     // Catch:{ IOException -> 0x0157 }
            goto L_0x015b
        L_0x0157:
            r10 = move-exception
            r10.printStackTrace()
        L_0x015b:
            return r11
        L_0x015c:
            r11 = move-exception
        L_0x015d:
            if (r10 == 0) goto L_0x0167
            r10.close()     // Catch:{ IOException -> 0x0163 }
            goto L_0x0167
        L_0x0163:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0167:
            if (r4 == 0) goto L_0x0171
            r4.close()     // Catch:{ IOException -> 0x016d }
            goto L_0x0171
        L_0x016d:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0171:
            throw r11
        L_0x0172:
            java.lang.String r10 = "unzip srcFile or destDir is null "
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.y.a(java.lang.String, java.lang.String):java.lang.String");
    }

    public static List<String> b(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    File file = new File(str + File.separator + "template_config.json");
                    if (file.isFile()) {
                        if (file.exists()) {
                            String a = a(file);
                            if (TextUtils.isEmpty(a)) {
                                return arrayList;
                            }
                            try {
                                JSONArray jSONArray = new JSONArray(a);
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                                    if (jSONObject != null) {
                                        if (str2.equals(jSONObject.optString("xml_type"))) {
                                            arrayList.add(str + File.separator + jSONObject.optString("name"));
                                            if (jSONObject.has("ext_template")) {
                                                jSONObject.put("folder_dir", str);
                                                arrayList.add(jSONObject.toString());
                                            }
                                        }
                                    }
                                }
                                return arrayList;
                            } catch (JSONException e) {
                                aa.d("SameFileTool", e.getMessage());
                                return arrayList;
                            }
                        }
                    }
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (Exception e2) {
            aa.d("SameFileTool", e2.getMessage());
        }
    }

    static /* synthetic */ void a(String str, int i) {
        try {
            if (d(new File(str)) > ((long) (i * 1048576))) {
                e(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable unused) {
            aa.d("SameFileTool", "clean memory failed");
        }
    }
}
