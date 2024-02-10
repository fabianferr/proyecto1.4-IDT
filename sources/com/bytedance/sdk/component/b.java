package com.bytedance.sdk.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* compiled from: TTPropHelper */
public class b {
    /* access modifiers changed from: private */
    public static boolean a = false;
    private static ArrayMap<String, File> k;
    private static ArrayMap<File, b> l;
    /* access modifiers changed from: private */
    public static ExecutorService m;
    /* access modifiers changed from: private */
    public final Object b;
    /* access modifiers changed from: private */
    public final Object c = new Object();
    /* access modifiers changed from: private */
    public Properties d = new Properties();
    private volatile boolean e = false;
    /* access modifiers changed from: private */
    public int f = 0;
    /* access modifiers changed from: private */
    public long g;
    private long h;
    /* access modifiers changed from: private */
    public final File i;
    private final File j;

    static /* synthetic */ int e(b bVar) {
        int i2 = bVar.f;
        bVar.f = i2 + 1;
        return i2;
    }

    static /* synthetic */ long f(b bVar) {
        long j2 = bVar.g;
        bVar.g = 1 + j2;
        return j2;
    }

    static /* synthetic */ int i(b bVar) {
        int i2 = bVar.f;
        bVar.f = i2 - 1;
        return i2;
    }

    /* compiled from: TTPropHelper */
    public static class a {
        public static void a(ExecutorService executorService) {
            ExecutorService unused = b.m = executorService;
        }
    }

    public static b a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_prop";
        }
        synchronized (b.class) {
            if (k == null) {
                k = new ArrayMap<>();
            }
            File file = k.get(str);
            if (file == null) {
                file = new File(context.getFilesDir(), str);
                k.put(str, file);
            }
            if (l == null) {
                l = new ArrayMap<>();
            }
            b bVar = l.get(file);
            if (bVar != null) {
                return bVar;
            }
            b bVar2 = new b(file);
            l.put(file, bVar2);
            return bVar2;
        }
    }

    private b(File file) {
        Object obj = new Object();
        this.b = obj;
        this.i = file;
        this.j = a(file);
        synchronized (obj) {
            this.e = false;
        }
        ExecutorService executorService = m;
        if (executorService == null) {
            new Thread("TTPropHelper") {
                public void run() {
                    b.this.a();
                }
            }.start();
        } else {
            executorService.execute(new Runnable() {
                public void run() {
                    b.this.a();
                }
            });
        }
    }

    static File a(File file) {
        return new File(file.getPath() + ".bak");
    }

    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v4, types: [java.util.Properties] */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v7, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r2v9 */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a6 A[SYNTHETIC, Splitter:B:35:0x00a6] */
    public void a() {
        /*
            r5 = this;
            java.lang.String r0 = "reload: find "
            java.lang.Object r1 = r5.b
            monitor-enter(r1)
            boolean r2 = r5.e     // Catch:{ all -> 0x00e2 }
            if (r2 == 0) goto L_0x0016
            boolean r0 = a     // Catch:{ all -> 0x00e2 }
            if (r0 == 0) goto L_0x0014
            java.lang.String r0 = "TTPropHelper"
            java.lang.String r2 = "reload: already loaded, ignore"
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x00e2 }
        L_0x0014:
            monitor-exit(r1)     // Catch:{ all -> 0x00e2 }
            return
        L_0x0016:
            java.io.File r2 = r5.j     // Catch:{ all -> 0x00e2 }
            boolean r2 = r2.exists()     // Catch:{ all -> 0x00e2 }
            if (r2 == 0) goto L_0x002a
            java.io.File r2 = r5.i     // Catch:{ all -> 0x00e2 }
            r2.delete()     // Catch:{ all -> 0x00e2 }
            java.io.File r2 = r5.j     // Catch:{ all -> 0x00e2 }
            java.io.File r3 = r5.i     // Catch:{ all -> 0x00e2 }
            r2.renameTo(r3)     // Catch:{ all -> 0x00e2 }
        L_0x002a:
            monitor-exit(r1)     // Catch:{ all -> 0x00e2 }
            boolean r1 = a
            if (r1 == 0) goto L_0x0056
            java.lang.String r1 = "TTPropHelper"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "reload: "
            r2.<init>(r3)
            java.io.File r3 = r5.i
            java.lang.String r3 = r3.getAbsolutePath()
            r2.append(r3)
            java.lang.String r3 = ", exist? "
            r2.append(r3)
            java.io.File r3 = r5.i
            boolean r3 = r3.exists()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r1, r2)
        L_0x0056:
            java.io.File r1 = r5.i
            boolean r1 = r1.exists()
            r2 = 0
            if (r1 == 0) goto L_0x00c8
            java.util.Properties r1 = new java.util.Properties
            r1.<init>()
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x009c }
            java.io.File r4 = r5.i     // Catch:{ all -> 0x009c }
            r3.<init>(r4)     // Catch:{ all -> 0x009c }
            r1.load(r3)     // Catch:{ all -> 0x0099 }
            boolean r2 = a     // Catch:{ all -> 0x0099 }
            if (r2 == 0) goto L_0x0095
            java.lang.String r2 = "TTPropHelper"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0099 }
            r4.<init>(r0)     // Catch:{ all -> 0x0099 }
            int r0 = r1.size()     // Catch:{ all -> 0x0099 }
            r4.append(r0)     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = " ,items from "
            r4.append(r0)     // Catch:{ all -> 0x0099 }
            java.io.File r0 = r5.i     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0099 }
            r4.append(r0)     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0099 }
            android.util.Log.d(r2, r0)     // Catch:{ all -> 0x0099 }
        L_0x0095:
            r3.close()     // Catch:{ all -> 0x00aa }
            goto L_0x00b4
        L_0x0099:
            r0 = move-exception
            r2 = r3
            goto L_0x009d
        L_0x009c:
            r0 = move-exception
        L_0x009d:
            java.lang.String r3 = "TTPropHelper"
            java.lang.String r4 = "reload: "
            android.util.Log.e(r3, r4, r0)     // Catch:{ all -> 0x00b6 }
            if (r2 == 0) goto L_0x00b4
            r2.close()     // Catch:{ all -> 0x00aa }
            goto L_0x00b4
        L_0x00aa:
            r0 = move-exception
            java.lang.String r2 = "TTPropHelper"
            java.lang.String r0 = r0.getMessage()
            android.util.Log.w(r2, r0)
        L_0x00b4:
            r2 = r1
            goto L_0x00c8
        L_0x00b6:
            r0 = move-exception
            if (r2 == 0) goto L_0x00c7
            r2.close()     // Catch:{ all -> 0x00bd }
            goto L_0x00c7
        L_0x00bd:
            r1 = move-exception
            java.lang.String r2 = "TTPropHelper"
            java.lang.String r1 = r1.getMessage()
            android.util.Log.w(r2, r1)
        L_0x00c7:
            throw r0
        L_0x00c8:
            java.lang.Object r0 = r5.b
            monitor-enter(r0)
            if (r2 == 0) goto L_0x00d5
            boolean r1 = r2.isEmpty()     // Catch:{ all -> 0x00df }
            if (r1 != 0) goto L_0x00d5
            r5.d = r2     // Catch:{ all -> 0x00df }
        L_0x00d5:
            r1 = 1
            r5.e = r1     // Catch:{ all -> 0x00df }
            java.lang.Object r1 = r5.b     // Catch:{ all -> 0x00df }
            r1.notifyAll()     // Catch:{ all -> 0x00df }
            monitor-exit(r0)     // Catch:{ all -> 0x00df }
            return
        L_0x00df:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00df }
            throw r1
        L_0x00e2:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00e2 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.b.a():void");
    }

    private void d() {
        while (!this.e) {
            try {
                this.b.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public String a(String str, String str2) {
        String property;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        synchronized (this.b) {
            d();
            property = this.d.getProperty(str, str2);
        }
        return property;
    }

    public int a(String str, int i2) {
        int parseInt;
        if (TextUtils.isEmpty(str)) {
            return i2;
        }
        synchronized (this.b) {
            try {
                d();
                parseInt = Integer.parseInt(this.d.getProperty(str, String.valueOf(i2)));
            } catch (NumberFormatException e2) {
                Log.e("TTPropHelper", e2.getMessage());
                return i2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return parseInt;
    }

    public long a(String str, long j2) {
        long parseLong;
        if (TextUtils.isEmpty(str)) {
            return j2;
        }
        synchronized (this.b) {
            try {
                d();
                parseLong = Long.parseLong(this.d.getProperty(str, String.valueOf(j2)));
            } catch (NumberFormatException e2) {
                Log.e("TTPropHelper", e2.getMessage());
                return j2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return parseLong;
    }

    public float a(String str, float f2) {
        float parseFloat;
        if (TextUtils.isEmpty(str)) {
            return f2;
        }
        synchronized (this.b) {
            try {
                d();
                parseFloat = Float.parseFloat(this.d.getProperty(str, String.valueOf(f2)));
            } catch (NumberFormatException e2) {
                Log.e("TTPropHelper", e2.getMessage());
                return f2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return parseFloat;
    }

    public boolean a(String str, boolean z) {
        boolean parseBoolean;
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        synchronized (this.b) {
            try {
                d();
                parseBoolean = Boolean.parseBoolean(this.d.getProperty(str, String.valueOf(z)));
            } catch (NumberFormatException e2) {
                Log.e("TTPropHelper", e2.getMessage());
                return z;
            } catch (Throwable th) {
                throw th;
            }
        }
        return parseBoolean;
    }

    public boolean a(String str) {
        boolean containsKey;
        synchronized (this.b) {
            try {
                d();
                containsKey = this.d.containsKey(str);
            } catch (NumberFormatException e2) {
                Log.e("TTPropHelper", e2.getMessage());
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
        return containsKey;
    }

    public c b() {
        return new c();
    }

    /* renamed from: com.bytedance.sdk.component.b$b  reason: collision with other inner class name */
    /* compiled from: TTPropHelper */
    private static class C0048b {
        final long a;
        final Properties b;
        final CountDownLatch c;
        volatile boolean d;
        boolean e;

        private C0048b(long j, Properties properties) {
            this.c = new CountDownLatch(1);
            this.d = false;
            this.e = false;
            this.a = j;
            this.b = properties;
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z, boolean z2) {
            this.e = z;
            this.d = z2;
            this.c.countDown();
        }
    }

    /* compiled from: TTPropHelper */
    public class c implements SharedPreferences.Editor {
        private final Object b = new Object();
        private final Map<String, Object> c = new HashMap();
        private boolean d = false;

        public c() {
        }

        /* renamed from: a */
        public c putStringSet(String str, Set<String> set) {
            synchronized (this.b) {
                this.c.put(str, set == null ? null : new HashSet(set));
            }
            return this;
        }

        /* renamed from: a */
        public c putInt(String str, int i) {
            synchronized (this.b) {
                this.c.put(str, Integer.valueOf(i));
            }
            return this;
        }

        /* renamed from: a */
        public c putLong(String str, long j) {
            synchronized (this.b) {
                this.c.put(str, Long.valueOf(j));
            }
            return this;
        }

        /* renamed from: a */
        public c putFloat(String str, float f) {
            synchronized (this.b) {
                this.c.put(str, Float.valueOf(f));
            }
            return this;
        }

        /* renamed from: a */
        public c putString(String str, String str2) {
            synchronized (this.b) {
                this.c.put(str, str2);
            }
            return this;
        }

        /* renamed from: a */
        public c putBoolean(String str, boolean z) {
            synchronized (this.b) {
                this.c.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        /* renamed from: a */
        public c remove(String str) {
            synchronized (this.b) {
                this.c.put(str, this);
            }
            return this;
        }

        /* renamed from: a */
        public c clear() {
            synchronized (this.b) {
                this.d = true;
            }
            return this;
        }

        public boolean commit() {
            long currentTimeMillis = b.a ? System.currentTimeMillis() : 0;
            C0048b b2 = b();
            b.this.a(b2, true);
            try {
                b2.c.await();
                if (b.a) {
                    Log.d("TTPropHelper", b.this.i.getName() + CertificateUtil.DELIMITER + b2.a + " committed after " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                }
                return b2.d;
            } catch (InterruptedException unused) {
                if (!b.a) {
                    return false;
                }
                Log.d("TTPropHelper", b.this.i.getName() + CertificateUtil.DELIMITER + b2.a + " committed after " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                return false;
            } catch (Throwable th) {
                if (b.a) {
                    Log.d("TTPropHelper", b.this.i.getName() + CertificateUtil.DELIMITER + b2.a + " committed after " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                }
                throw th;
            }
        }

        public void apply() {
            b.this.a(b(), false);
        }

        private C0048b b() {
            Properties d2;
            long g;
            Object obj;
            boolean z;
            synchronized (b.this.b) {
                if (b.this.f > 0) {
                    Properties properties = new Properties();
                    properties.putAll(b.this.d);
                    Properties unused = b.this.d = properties;
                }
                d2 = b.this.d;
                b.e(b.this);
                synchronized (this.b) {
                    boolean z2 = false;
                    if (this.d) {
                        if (!d2.isEmpty()) {
                            d2.clear();
                            z = true;
                        } else {
                            z = false;
                        }
                        this.d = false;
                        z2 = z;
                    }
                    for (Map.Entry next : this.c.entrySet()) {
                        String str = (String) next.getKey();
                        Object value = next.getValue();
                        if (value != this) {
                            if (value != null) {
                                if (!d2.containsKey(str) || (obj = d2.get(str)) == null || !obj.equals(String.valueOf(value))) {
                                    d2.put(str, String.valueOf(value));
                                    z2 = true;
                                }
                            }
                        }
                        if (d2.containsKey(str)) {
                            d2.remove(str);
                            z2 = true;
                        }
                    }
                    this.c.clear();
                    if (z2) {
                        b.f(b.this);
                    }
                    g = b.this.g;
                }
            }
            return new C0048b(g, d2);
        }
    }

    /* access modifiers changed from: private */
    public void a(final C0048b bVar, final boolean z) {
        boolean z2;
        AnonymousClass3 r0 = new Runnable() {
            public void run() {
                synchronized (b.this.c) {
                    b.this.b(bVar, z);
                }
                synchronized (b.this.b) {
                    b.i(b.this);
                }
            }
        };
        if (z) {
            synchronized (this.b) {
                z2 = this.f == 1;
            }
            if (z2) {
                r0.run();
                return;
            }
        }
        c.a(r0, true ^ z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v14, resolved type: java.lang.Object} */
    /* JADX WARNING: type inference failed for: r18v8 */
    /* JADX WARNING: type inference failed for: r18v13 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00fd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00fe, code lost:
        r3 = r0;
        r7 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0102, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0103, code lost:
        r7 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x011d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x011e, code lost:
        r4 = r0;
        r0 = "TTPropHelper";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        r4 = r4.getMessage();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x018d A[SYNTHETIC, Splitter:B:100:0x018d] */
    /* JADX WARNING: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00fd A[ExcHandler: all (r0v23 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:50:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0119 A[SYNTHETIC, Splitter:B:80:0x0119] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x012b A[Catch:{ all -> 0x01a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0130 A[Catch:{ all -> 0x01a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x013b A[Catch:{ all -> 0x01a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0142 A[Catch:{ all -> 0x01a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0152 A[Catch:{ all -> 0x01a0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.bytedance.sdk.component.b.C0048b r21, boolean r22) {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            java.lang.String r3 = "write: "
            java.lang.String r0 = "saveToLocal: save to"
            java.lang.String r4 = "save: "
            boolean r5 = a
            if (r5 == 0) goto L_0x0013
            long r8 = java.lang.System.currentTimeMillis()
            goto L_0x0015
        L_0x0013:
            r8 = 0
        L_0x0015:
            java.io.File r5 = r1.i
            boolean r5 = r5.exists()
            boolean r10 = a
            if (r10 == 0) goto L_0x0025
            long r10 = java.lang.System.currentTimeMillis()
            r12 = r10
            goto L_0x0029
        L_0x0025:
            r10 = 0
            r12 = 0
        L_0x0029:
            if (r5 == 0) goto L_0x009c
            long r6 = r1.h
            long r14 = r2.a
            int r18 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r18 >= 0) goto L_0x0050
            if (r22 == 0) goto L_0x0037
            r5 = 1
            goto L_0x0051
        L_0x0037:
            java.lang.Object r6 = r1.b
            monitor-enter(r6)
            long r14 = r1.g     // Catch:{ all -> 0x004b }
            r18 = r6
            long r5 = r2.a     // Catch:{ all -> 0x0049 }
            int r19 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r19 != 0) goto L_0x0046
            r5 = 1
            goto L_0x0047
        L_0x0046:
            r5 = 0
        L_0x0047:
            monitor-exit(r18)     // Catch:{ all -> 0x0049 }
            goto L_0x0051
        L_0x0049:
            r0 = move-exception
            goto L_0x004e
        L_0x004b:
            r0 = move-exception
            r18 = r6
        L_0x004e:
            monitor-exit(r18)     // Catch:{ all -> 0x0049 }
            throw r0
        L_0x0050:
            r5 = 0
        L_0x0051:
            if (r5 != 0) goto L_0x0059
            r5 = 1
            r6 = 0
            r2.a(r6, r5)
            return
        L_0x0059:
            java.io.File r6 = r1.j
            boolean r6 = r6.exists()
            boolean r7 = a
            if (r7 == 0) goto L_0x0067
            long r12 = java.lang.System.currentTimeMillis()
        L_0x0067:
            if (r6 != 0) goto L_0x0097
            java.io.File r6 = r1.i
            java.io.File r7 = r1.j
            boolean r6 = r6.renameTo(r7)
            if (r6 != 0) goto L_0x009c
            java.lang.String r0 = "TTPropHelper"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Couldn't rename file "
            r3.<init>(r4)
            java.io.File r4 = r1.i
            r3.append(r4)
            java.lang.String r4 = " to backup file "
            r3.append(r4)
            java.io.File r4 = r1.j
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r0, r3)
            r3 = 0
            r2.a(r3, r3)
            return
        L_0x0097:
            java.io.File r6 = r1.i
            r6.delete()
        L_0x009c:
            java.lang.Object r6 = r1.c     // Catch:{ all -> 0x01a0 }
            monitor-enter(r6)     // Catch:{ all -> 0x01a0 }
            r7 = 0
            java.io.FileOutputStream r14 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0109 }
            java.io.File r15 = r1.i     // Catch:{ Exception -> 0x0109 }
            r14.<init>(r15)     // Catch:{ Exception -> 0x0109 }
            boolean r15 = a     // Catch:{ Exception -> 0x0102, all -> 0x00fd }
            if (r15 == 0) goto L_0x00b0
            long r18 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0102, all -> 0x00fd }
            goto L_0x00b2
        L_0x00b0:
            r18 = 0
        L_0x00b2:
            java.util.Properties r15 = r2.b     // Catch:{ Exception -> 0x00fa, all -> 0x00fd }
            r15.store(r14, r7)     // Catch:{ Exception -> 0x00fa, all -> 0x00fd }
            boolean r7 = a     // Catch:{ Exception -> 0x00fa, all -> 0x00fd }
            if (r7 == 0) goto L_0x00ea
            java.lang.String r7 = "TTPropHelper"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fa, all -> 0x00fd }
            r15.<init>(r4)     // Catch:{ Exception -> 0x00fa, all -> 0x00fd }
            java.util.Properties r4 = r2.b     // Catch:{ Exception -> 0x00fa, all -> 0x00fd }
            r15.append(r4)     // Catch:{ Exception -> 0x00fa, all -> 0x00fd }
            java.lang.String r4 = r15.toString()     // Catch:{ Exception -> 0x00fa, all -> 0x00fd }
            android.util.Log.d(r7, r4)     // Catch:{ Exception -> 0x00fa, all -> 0x00fd }
            java.lang.String r4 = "TTPropHelper"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fa, all -> 0x00fd }
            r7.<init>(r0)     // Catch:{ Exception -> 0x00fa, all -> 0x00fd }
            java.io.File r0 = r1.i     // Catch:{ Exception -> 0x00fa, all -> 0x00fd }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x00fa, all -> 0x00fd }
            r7.append(r0)     // Catch:{ Exception -> 0x00fa, all -> 0x00fd }
            java.lang.String r0 = "success"
            r7.append(r0)     // Catch:{ Exception -> 0x00fa, all -> 0x00fd }
            java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x00fa, all -> 0x00fd }
            android.util.Log.d(r4, r0)     // Catch:{ Exception -> 0x00fa, all -> 0x00fd }
        L_0x00ea:
            r14.close()     // Catch:{ all -> 0x00ee }
            goto L_0x0126
        L_0x00ee:
            r0 = move-exception
            r4 = r0
            java.lang.String r0 = "TTPropHelper"
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x019d }
        L_0x00f6:
            android.util.Log.w(r0, r4)     // Catch:{ all -> 0x019d }
            goto L_0x0126
        L_0x00fa:
            r0 = move-exception
            r7 = r14
            goto L_0x010c
        L_0x00fd:
            r0 = move-exception
            r3 = r0
            r7 = r14
            goto L_0x018b
        L_0x0102:
            r0 = move-exception
            r7 = r14
            goto L_0x010a
        L_0x0105:
            r0 = move-exception
            r3 = r0
            goto L_0x018b
        L_0x0109:
            r0 = move-exception
        L_0x010a:
            r18 = 0
        L_0x010c:
            java.lang.String r4 = "TTPropHelper"
            java.lang.String r14 = "saveToLocal: "
            android.util.Log.e(r4, r14, r0)     // Catch:{ all -> 0x0105 }
            r4 = 0
            r2.a(r4, r4)     // Catch:{ all -> 0x0105 }
            if (r7 == 0) goto L_0x0126
            r7.close()     // Catch:{ all -> 0x011d }
            goto L_0x0126
        L_0x011d:
            r0 = move-exception
            r4 = r0
            java.lang.String r0 = "TTPropHelper"
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x019d }
            goto L_0x00f6
        L_0x0126:
            monitor-exit(r6)     // Catch:{ all -> 0x019d }
            boolean r0 = a     // Catch:{ all -> 0x01a0 }
            if (r0 == 0) goto L_0x0130
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01a0 }
            goto L_0x0132
        L_0x0130:
            r6 = 0
        L_0x0132:
            java.io.File r0 = r1.j     // Catch:{ all -> 0x01a0 }
            r0.delete()     // Catch:{ all -> 0x01a0 }
            boolean r0 = a     // Catch:{ all -> 0x01a0 }
            if (r0 == 0) goto L_0x0142
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01a0 }
            r16 = r6
            goto L_0x0146
        L_0x0142:
            r16 = r6
            r14 = 0
        L_0x0146:
            long r5 = r2.a     // Catch:{ all -> 0x01a0 }
            r1.h = r5     // Catch:{ all -> 0x01a0 }
            r4 = 1
            r2.a(r4, r4)     // Catch:{ all -> 0x01a0 }
            boolean r0 = a     // Catch:{ all -> 0x01a0 }
            if (r0 == 0) goto L_0x018a
            java.lang.String r0 = "TTPropHelper"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a0 }
            r4.<init>(r3)     // Catch:{ all -> 0x01a0 }
            long r10 = r10 - r8
            r4.append(r10)     // Catch:{ all -> 0x01a0 }
            java.lang.String r3 = "/"
            r4.append(r3)     // Catch:{ all -> 0x01a0 }
            long r12 = r12 - r8
            r4.append(r12)     // Catch:{ all -> 0x01a0 }
            java.lang.String r3 = "/"
            r4.append(r3)     // Catch:{ all -> 0x01a0 }
            long r5 = r18 - r8
            r4.append(r5)     // Catch:{ all -> 0x01a0 }
            java.lang.String r3 = "/"
            r4.append(r3)     // Catch:{ all -> 0x01a0 }
            long r6 = r16 - r8
            r4.append(r6)     // Catch:{ all -> 0x01a0 }
            java.lang.String r3 = "/"
            r4.append(r3)     // Catch:{ all -> 0x01a0 }
            long r14 = r14 - r8
            r4.append(r14)     // Catch:{ all -> 0x01a0 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x01a0 }
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x01a0 }
        L_0x018a:
            return
        L_0x018b:
            if (r7 == 0) goto L_0x019c
            r7.close()     // Catch:{ all -> 0x0191 }
            goto L_0x019c
        L_0x0191:
            r0 = move-exception
            r4 = r0
            java.lang.String r0 = "TTPropHelper"
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x019d }
            android.util.Log.w(r0, r4)     // Catch:{ all -> 0x019d }
        L_0x019c:
            throw r3     // Catch:{ all -> 0x019d }
        L_0x019d:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x019d }
            throw r0     // Catch:{ all -> 0x01a0 }
        L_0x01a0:
            r0 = move-exception
            java.lang.String r3 = "TTPropHelper"
            java.lang.String r4 = "writeToFile: Got exception:"
            android.util.Log.w(r3, r4, r0)
            java.io.File r0 = r1.i
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x01cd
            java.io.File r0 = r1.i
            boolean r0 = r0.delete()
            if (r0 != 0) goto L_0x01cd
            java.lang.String r0 = "TTPropHelper"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Couldn't clean up partially-written file "
            r3.<init>(r4)
            java.io.File r4 = r1.i
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r0, r3)
        L_0x01cd:
            r3 = 0
            r2.a(r3, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.b.b(com.bytedance.sdk.component.b$b, boolean):void");
    }
}
