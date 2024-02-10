package com.apm.insight.g;

import android.os.Looper;
import android.os.SystemClock;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.ICrashFilter;
import com.apm.insight.IOOMCallback;
import com.apm.insight.b;
import com.apm.insight.c;
import com.apm.insight.i;
import com.apm.insight.k.d;
import com.apm.insight.l.e;
import com.apm.insight.l.k;
import com.apm.insight.l.q;
import com.apm.insight.l.r;
import com.apm.insight.l.v;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.a.f;
import com.apm.insight.runtime.o;
import com.apm.insight.runtime.p;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

public class a implements Thread.UncaughtExceptionHandler {
    private static a a = null;
    private static volatile boolean i = false;
    private static volatile ThreadLocal<Boolean> j = new ThreadLocal<>();
    private static ArrayList<b> l = new ArrayList<>();
    private Thread.UncaughtExceptionHandler b;
    private c c;
    private c d;
    private volatile int e = 0;
    private volatile int f = 0;
    private ConcurrentHashMap<String, Object> g = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Object> h = new ConcurrentHashMap<>();
    private JSONArray k;

    private a() {
        d();
    }

    private static int a(Throwable th, Thread thread) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < l.size()) {
            try {
                try {
                    i3 |= l.get(i2).a(th, thread);
                } catch (Throwable th2) {
                    c.a().a("NPTH_CATCH", th2);
                }
                i2++;
            } catch (Throwable unused) {
            }
        }
        return i3;
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    private String a(File file, boolean z, Throwable th, String str, Thread thread, boolean z2) {
        String absolutePath = file.getAbsolutePath();
        this.h.put(file.getName(), file);
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            NativeImpl.c(absolutePath);
        } catch (Throwable unused) {
        }
        String str2 = null;
        if (z2) {
            int h2 = NativeImpl.h(absolutePath);
            if (h2 > 0) {
                try {
                    NativeImpl.a(h2, com.apm.insight.l.a.c(i.g()));
                    NativeImpl.a(h2, "\n");
                    NativeImpl.a(h2, th.getMessage());
                    NativeImpl.a(h2, "\n");
                    NativeImpl.a(h2, th.getClass().getName());
                    if (th.getMessage() != null) {
                        NativeImpl.a(h2, ": ");
                        NativeImpl.a(h2, th.getMessage());
                    }
                    NativeImpl.a(h2, "\n");
                    NativeImpl.a(h2, thread.getName());
                    NativeImpl.a(h2, "\n");
                } catch (Throwable unused2) {
                }
                try {
                    NativeImpl.a(h2, "stack:");
                    NativeImpl.a(h2, "\n");
                } catch (Throwable unused3) {
                }
                v.a(th, h2);
                NativeImpl.b(h2);
            }
        } else {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                try {
                    if (!r.a(32768)) {
                        fileOutputStream.write((com.apm.insight.l.a.c(i.g()) + "\n").getBytes());
                        fileOutputStream.write((th.getMessage() + "\n").getBytes());
                        fileOutputStream.write((th + "\n").getBytes());
                        fileOutputStream.write((thread.getName() + "\n").getBytes());
                        try {
                            fileOutputStream.write("stack:\n".getBytes());
                        } catch (Throwable unused4) {
                        }
                        try {
                            if (!r.a(8192)) {
                                str2 = v.a(th, thread, new PrintStream(fileOutputStream), Looper.getMainLooper() == Looper.myLooper() ? new e.a() {
                                    boolean a = false;

                                    public boolean a(String str) {
                                        if (!this.a && str.contains("android.os.Looper.loop")) {
                                            this.a = true;
                                        }
                                        return !this.a;
                                    }
                                } : new e.a());
                                k.a((Closeable) fileOutputStream);
                                k.a((Closeable) fileOutputStream);
                            } else {
                                throw new RuntimeException("test exception npth write stack");
                            }
                        } catch (Throwable th2) {
                            try {
                                fileOutputStream.write("err:\n".getBytes());
                                fileOutputStream.write((th + "\n").getBytes());
                                fileOutputStream.write((th2 + "\n").getBytes());
                            } catch (Throwable unused5) {
                            }
                        }
                    } else {
                        throw new RuntimeException("test exception before write stack");
                    }
                } catch (Throwable unused6) {
                }
            } catch (Throwable unused7) {
            }
        }
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x022f A[Catch:{ all -> 0x025a, all -> 0x0273 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0234 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b A[SYNTHETIC, Splitter:B:23:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066 A[SYNTHETIC, Splitter:B:28:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a2 A[ADDED_TO_REGION, Catch:{ all -> 0x0215 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c5 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d1 A[SYNTHETIC, Splitter:B:50:0x00d1] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d4 A[Catch:{ all -> 0x0207 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0106 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0122 A[Catch:{ all -> 0x01ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x012b A[SYNTHETIC, Splitter:B:66:0x012b] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x012e A[Catch:{ all -> 0x01fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x014e A[SYNTHETIC, Splitter:B:71:0x014e] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x018d A[SYNTHETIC, Splitter:B:87:0x018d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Throwable a(java.lang.Thread r27, java.lang.Throwable r28) {
        /*
            r26 = this;
            r8 = r26
            r15 = r27
            r14 = r28
            java.lang.String r0 = "[uncaughtException] mLaunchCrashDisposer "
            java.lang.String r13 = "[uncaughtException] mLaunchCrashDisposer "
            java.lang.String r9 = "[uncaughtException] isLaunchCrash="
            int r1 = r8.e
            r2 = 3
            r18 = 0
            if (r1 < r2) goto L_0x001c
            r1 = 65536(0x10000, float:9.18355E-41)
            boolean r1 = com.apm.insight.l.r.a((int) r1)
            if (r1 != 0) goto L_0x001c
            return r18
        L_0x001c:
            int r1 = r8.e
            r12 = 1
            int r1 = r1 + r12
            r8.e = r1
            int r1 = r8.f
            int r1 = r1 + r12
            r8.f = r1
            boolean r1 = i
            if (r1 == 0) goto L_0x0034
            java.lang.ThreadLocal<java.lang.Boolean> r1 = j
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r12)
            r1.set(r2)
        L_0x0034:
            i = r12
            long r10 = java.lang.System.currentTimeMillis()
            boolean r7 = a((long) r10)
            r6 = 0
            boolean r1 = com.apm.insight.l.v.c((java.lang.Throwable) r28)     // Catch:{ all -> 0x0054 }
            if (r1 == 0) goto L_0x004f
            boolean r2 = com.apm.insight.l.v.d(r28)     // Catch:{ all -> 0x004d }
            if (r2 == 0) goto L_0x004f
            r2 = 1
            goto L_0x0050
        L_0x004d:
            goto L_0x0056
        L_0x004f:
            r2 = 0
        L_0x0050:
            r5 = r1
            r19 = r2
            goto L_0x0059
        L_0x0054:
            r1 = 0
        L_0x0056:
            r5 = r1
            r19 = 0
        L_0x0059:
            if (r7 == 0) goto L_0x0066
            com.apm.insight.CrashType r1 = com.apm.insight.CrashType.LAUNCH     // Catch:{ all -> 0x005e }
            goto L_0x0068
        L_0x005e:
            r0 = move-exception
            r4 = r7
            r5 = r10
            r7 = r14
            r9 = r15
        L_0x0063:
            r2 = 1
            goto L_0x0225
        L_0x0066:
            com.apm.insight.CrashType r1 = com.apm.insight.CrashType.JAVA     // Catch:{ all -> 0x021d }
        L_0x0068:
            java.lang.String r4 = com.apm.insight.i.a(r10, r1, r5, r6)     // Catch:{ all -> 0x021d }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x021d }
            android.content.Context r1 = com.apm.insight.i.g()     // Catch:{ all -> 0x021d }
            java.io.File r1 = com.apm.insight.l.o.a((android.content.Context) r1)     // Catch:{ all -> 0x021d }
            r3.<init>(r1, r4)     // Catch:{ all -> 0x021d }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x021d }
            java.lang.String r1 = "logEventStack"
            r2.<init>(r3, r1)     // Catch:{ all -> 0x021d }
            r1 = r26
            r16 = r2
            r20 = r3
            r3 = r5
            r17 = r4
            r4 = r28
            r21 = r5
            r5 = r17
            r22 = 0
            r6 = r27
            r23 = r7
            r7 = r19
            java.lang.String r7 = r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0215 }
            int r1 = a((java.lang.Throwable) r14, (java.lang.Thread) r15)     // Catch:{ all -> 0x0215 }
            r1 = r1 & r12
            if (r1 != 0) goto L_0x00b4
            if (r7 == 0) goto L_0x00af
            com.apm.insight.runtime.ConfigManager r1 = com.apm.insight.i.i()     // Catch:{ all -> 0x0215 }
            boolean r1 = r1.isCrashIgnored(r7)     // Catch:{ all -> 0x0215 }
            if (r1 == 0) goto L_0x00af
            goto L_0x00b4
        L_0x00af:
            r1 = r20
            r20 = 0
            goto L_0x00b8
        L_0x00b4:
            r1 = r20
            r20 = 1
        L_0x00b8:
            org.json.JSONArray r2 = com.apm.insight.entity.b.a((java.lang.Throwable) r14, (java.lang.Thread) r15, (java.io.File) r1)     // Catch:{ all -> 0x020d }
            r8.k = r2     // Catch:{ all -> 0x020d }
            if (r2 != 0) goto L_0x00c2
            r6 = 1
            goto L_0x00c3
        L_0x00c2:
            r6 = 0
        L_0x00c3:
            if (r6 != 0) goto L_0x00cd
            if (r20 == 0) goto L_0x00c8
            goto L_0x00cd
        L_0x00c8:
            r6 = r17
            r5 = r23
            goto L_0x00f6
        L_0x00cd:
            r5 = r23
            if (r5 == 0) goto L_0x00d4
            com.apm.insight.CrashType r2 = com.apm.insight.CrashType.LAUNCH     // Catch:{ all -> 0x0207 }
            goto L_0x00d6
        L_0x00d4:
            com.apm.insight.CrashType r2 = com.apm.insight.CrashType.JAVA     // Catch:{ all -> 0x0207 }
        L_0x00d6:
            r3 = r21
            java.lang.String r2 = com.apm.insight.i.a(r10, r2, r3, r12)     // Catch:{ all -> 0x0207 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0207 }
            android.content.Context r4 = com.apm.insight.i.g()     // Catch:{ all -> 0x0207 }
            java.io.File r4 = com.apm.insight.l.o.a((android.content.Context) r4)     // Catch:{ all -> 0x0207 }
            r3.<init>(r4, r2)     // Catch:{ all -> 0x0207 }
            r1.renameTo(r3)     // Catch:{ all -> 0x0207 }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0207 }
            java.lang.String r4 = "logEventStack"
            r1.<init>(r3, r4)     // Catch:{ all -> 0x0207 }
            r16 = r1
            r6 = r2
        L_0x00f6:
            com.apm.insight.l.f.a()     // Catch:{ all -> 0x0207 }
            com.apm.insight.k.b r1 = com.apm.insight.k.b.a()     // Catch:{ all -> 0x0207 }
            r1.b()     // Catch:{ all -> 0x0207 }
            boolean r21 = r26.g()     // Catch:{ all -> 0x0207 }
            if (r19 == 0) goto L_0x0118
            if (r21 == 0) goto L_0x0118
            r1 = r26
            r2 = r27
            r3 = r28
            r4 = r5
            r24 = r5
            r25 = r6
            r5 = r10
            r1.a((java.lang.Thread) r2, (java.lang.Throwable) r3, (boolean) r4, (long) r5)     // Catch:{ all -> 0x01ff }
            goto L_0x011c
        L_0x0118:
            r24 = r5
            r25 = r6
        L_0x011c:
            boolean r1 = com.apm.insight.l.r.a((int) r12)     // Catch:{ all -> 0x01ff }
            if (r1 == 0) goto L_0x0127
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r1 = r8.h     // Catch:{ all -> 0x01ff }
            r1.clear()     // Catch:{ all -> 0x01ff }
        L_0x0127:
            r4 = r24
            if (r4 == 0) goto L_0x012e
            com.apm.insight.CrashType r1 = com.apm.insight.CrashType.LAUNCH     // Catch:{ all -> 0x01fa }
            goto L_0x0130
        L_0x012e:
            com.apm.insight.CrashType r1 = com.apm.insight.CrashType.JAVA     // Catch:{ all -> 0x01fa }
        L_0x0130:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01fa }
            r2.<init>(r9)     // Catch:{ all -> 0x01fa }
            r2.append(r4)     // Catch:{ all -> 0x01fa }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01fa }
            com.apm.insight.l.q.a((java.lang.Object) r2)     // Catch:{ all -> 0x01fa }
            com.apm.insight.a.a r2 = com.apm.insight.a.a.a()     // Catch:{ all -> 0x01fa }
            r3 = r25
            r2.a((com.apm.insight.CrashType) r1, (long) r10, (java.lang.String) r3)     // Catch:{ all -> 0x01fa }
            boolean r1 = r26.b((java.lang.Thread) r27, (java.lang.Throwable) r28)     // Catch:{ all -> 0x01fa }
            if (r1 == 0) goto L_0x0189
            com.apm.insight.g.c r2 = r8.c     // Catch:{ all -> 0x0182 }
            if (r2 == 0) goto L_0x0189
            if (r4 == 0) goto L_0x0189
            boolean r2 = r2.a(r14)     // Catch:{ all -> 0x0182 }
            if (r2 == 0) goto L_0x0189
            com.apm.insight.g.c r9 = r8.c     // Catch:{ all -> 0x0182 }
            r5 = r10
            r2 = 1
            r12 = r27
            r13 = r28
            r1 = r14
            r14 = r3
            r3 = r15
            r15 = r16
            r16 = r7
            r17 = r20
            r9.a(r10, r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x01bc }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x01bc }
            r7.<init>(r0)     // Catch:{ all -> 0x01bc }
            java.lang.String r0 = r28.toString()     // Catch:{ all -> 0x01bc }
            r7.append(r0)     // Catch:{ all -> 0x01bc }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x01bc }
        L_0x017e:
            com.apm.insight.l.q.a((java.lang.Object) r0)     // Catch:{ all -> 0x01bc }
            goto L_0x01c5
        L_0x0182:
            r0 = move-exception
            r5 = r10
            r2 = 1
        L_0x0185:
            r7 = r14
            r9 = r15
            goto L_0x0229
        L_0x0189:
            r5 = r10
            r2 = 1
            if (r1 == 0) goto L_0x01c3
            com.apm.insight.g.c r0 = r8.d     // Catch:{ all -> 0x01c1 }
            if (r0 == 0) goto L_0x01c3
            boolean r0 = r0.a(r14)     // Catch:{ all -> 0x01c1 }
            if (r0 == 0) goto L_0x01c3
            com.apm.insight.g.c r9 = r8.d     // Catch:{ all -> 0x01c1 }
            r10 = r5
            r12 = r27
            r0 = r13
            r13 = r28
            r1 = r14
            r14 = r3
            r3 = r15
            r15 = r16
            r16 = r7
            r17 = r20
            r9.a(r10, r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x01bc }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x01bc }
            r7.<init>(r0)     // Catch:{ all -> 0x01bc }
            java.lang.String r0 = r28.toString()     // Catch:{ all -> 0x01bc }
            r7.append(r0)     // Catch:{ all -> 0x01bc }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x01bc }
            goto L_0x017e
        L_0x01bc:
            r0 = move-exception
            r7 = r1
            r9 = r3
            goto L_0x0229
        L_0x01c1:
            r0 = move-exception
            goto L_0x0185
        L_0x01c3:
            r1 = r14
            r3 = r15
        L_0x01c5:
            if (r20 != 0) goto L_0x01e4
            if (r19 == 0) goto L_0x01d7
            if (r21 != 0) goto L_0x01d7
            r7 = r1
            r1 = r26
            r2 = r27
            r9 = r3
            r3 = r28
            r1.a((java.lang.Thread) r2, (java.lang.Throwable) r3, (boolean) r4, (long) r5)     // Catch:{ all -> 0x0245 }
            goto L_0x01d9
        L_0x01d7:
            r7 = r1
            r9 = r3
        L_0x01d9:
            r26.f()     // Catch:{ all -> 0x0245 }
        L_0x01dc:
            r26.e()     // Catch:{ all -> 0x0245 }
            r26.c(r27, r28)     // Catch:{ all -> 0x0245 }
            goto L_0x0245
        L_0x01e4:
            r7 = r1
            r9 = r3
            monitor-enter(r26)
            int r0 = r8.f     // Catch:{ all -> 0x01f7 }
            int r0 = r0 - r2
            r8.f = r0     // Catch:{ all -> 0x01f7 }
            int r0 = r8.e     // Catch:{ all -> 0x01f7 }
            int r0 = r0 - r2
            r8.e = r0     // Catch:{ all -> 0x01f7 }
            monitor-exit(r26)     // Catch:{ all -> 0x01f7 }
            java.lang.Throwable r0 = b((java.lang.Throwable) r7, (java.lang.Thread) r9)
            return r0
        L_0x01f7:
            r0 = move-exception
            monitor-exit(r26)     // Catch:{ all -> 0x01f7 }
            throw r0
        L_0x01fa:
            r0 = move-exception
            r5 = r10
            r7 = r14
            r9 = r15
            goto L_0x0205
        L_0x01ff:
            r0 = move-exception
            r5 = r10
            r7 = r14
            r9 = r15
            r4 = r24
        L_0x0205:
            r2 = 1
            goto L_0x0229
        L_0x0207:
            r0 = move-exception
            r4 = r5
            r5 = r10
            r7 = r14
            r9 = r15
            goto L_0x0213
        L_0x020d:
            r0 = move-exception
            r5 = r10
            r7 = r14
            r9 = r15
            r4 = r23
        L_0x0213:
            r2 = 1
            goto L_0x0227
        L_0x0215:
            r0 = move-exception
            r5 = r10
            r7 = r14
            r9 = r15
            r4 = r23
            goto L_0x0063
        L_0x021d:
            r0 = move-exception
            r4 = r7
            r5 = r10
            r7 = r14
            r9 = r15
            r2 = 1
            r22 = 0
        L_0x0225:
            r20 = 0
        L_0x0227:
            r21 = 0
        L_0x0229:
            boolean r1 = com.apm.insight.l.v.c((java.lang.Throwable) r0)     // Catch:{ all -> 0x025a }
            if (r1 != 0) goto L_0x0232
            com.apm.insight.l.q.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x025a }
        L_0x0232:
            if (r20 != 0) goto L_0x0246
            if (r19 == 0) goto L_0x0241
            if (r21 != 0) goto L_0x0241
            r1 = r26
            r2 = r27
            r3 = r28
            r1.a((java.lang.Thread) r2, (java.lang.Throwable) r3, (boolean) r4, (long) r5)     // Catch:{ all -> 0x0245 }
        L_0x0241:
            r26.f()     // Catch:{ all -> 0x0245 }
            goto L_0x01dc
        L_0x0245:
            return r18
        L_0x0246:
            monitor-enter(r26)
            int r0 = r8.f     // Catch:{ all -> 0x0257 }
            int r0 = r0 - r2
            r8.f = r0     // Catch:{ all -> 0x0257 }
            int r0 = r8.e     // Catch:{ all -> 0x0257 }
            int r0 = r0 - r2
            r8.e = r0     // Catch:{ all -> 0x0257 }
            monitor-exit(r26)     // Catch:{ all -> 0x0257 }
            java.lang.Throwable r0 = b((java.lang.Throwable) r7, (java.lang.Thread) r9)
            return r0
        L_0x0257:
            r0 = move-exception
            monitor-exit(r26)     // Catch:{ all -> 0x0257 }
            throw r0
        L_0x025a:
            r0 = move-exception
            if (r20 != 0) goto L_0x0274
            if (r19 == 0) goto L_0x026a
            if (r21 != 0) goto L_0x026a
            r1 = r26
            r2 = r27
            r3 = r28
            r1.a((java.lang.Thread) r2, (java.lang.Throwable) r3, (boolean) r4, (long) r5)     // Catch:{ all -> 0x0273 }
        L_0x026a:
            r26.f()     // Catch:{ all -> 0x0273 }
            r26.e()     // Catch:{ all -> 0x0273 }
            r26.c(r27, r28)     // Catch:{ all -> 0x0273 }
        L_0x0273:
            throw r0
        L_0x0274:
            monitor-enter(r26)
            int r0 = r8.f     // Catch:{ all -> 0x0285 }
            int r0 = r0 - r2
            r8.f = r0     // Catch:{ all -> 0x0285 }
            int r0 = r8.e     // Catch:{ all -> 0x0285 }
            int r0 = r0 - r2
            r8.e = r0     // Catch:{ all -> 0x0285 }
            monitor-exit(r26)     // Catch:{ all -> 0x0285 }
            java.lang.Throwable r0 = b((java.lang.Throwable) r7, (java.lang.Thread) r9)
            return r0
        L_0x0285:
            r0 = move-exception
            monitor-exit(r26)     // Catch:{ all -> 0x0285 }
            goto L_0x0289
        L_0x0288:
            throw r0
        L_0x0289:
            goto L_0x0288
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.g.a.a(java.lang.Thread, java.lang.Throwable):java.lang.Throwable");
    }

    private void a(Thread thread, Throwable th, boolean z, long j2) {
        List<IOOMCallback> a2 = o.a().a();
        CrashType crashType = z ? CrashType.LAUNCH : CrashType.JAVA;
        for (IOOMCallback next : a2) {
            try {
                if (next instanceof b) {
                    ((b) next).a(crashType, th, thread, j2, this.k);
                } else {
                    next.onCrash(crashType, th, thread, j2);
                }
            } catch (Throwable th2) {
                q.b(th2);
            }
        }
    }

    public static void a(final Throwable th) {
        if (th != null) {
            try {
                p.b().a((Runnable) new Runnable() {
                    public void run() {
                        try {
                            com.apm.insight.entity.a a2 = com.apm.insight.entity.a.a(System.currentTimeMillis(), i.g(), (Thread) null, th);
                            a2.a("userdefine", (Object) 1);
                            com.apm.insight.entity.a a3 = f.a().a(CrashType.CUSTOM_JAVA, a2);
                            if (a3 != null) {
                                d.a().b(a3.h());
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(long j2) {
        return e.a(j2);
    }

    private static Throwable b(Throwable th, Thread thread) {
        int i2 = 0;
        while (i2 < l.size()) {
            try {
                try {
                    l.get(i2).b(th, thread);
                    i2++;
                } catch (Throwable th2) {
                    return th2;
                }
            } catch (Throwable unused) {
            }
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return null;
        }
        try {
            Looper.loop();
            return null;
        } catch (Throwable th3) {
            return th3;
        }
    }

    public static boolean b() {
        return i;
    }

    private boolean b(Thread thread, Throwable th) {
        ICrashFilter b2 = i.b().b();
        if (b2 == null) {
            return true;
        }
        try {
            return b2.onJavaCrashFilter(th, thread);
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void c(final String str) {
        if (str != null) {
            try {
                p.b().a((Runnable) new Runnable() {
                    public void run() {
                        try {
                            com.apm.insight.entity.a aVar = new com.apm.insight.entity.a();
                            aVar.a("data", (Object) str);
                            aVar.a("userdefine", (Object) 1);
                            com.apm.insight.entity.a a2 = f.a().a(CrashType.CUSTOM_JAVA, aVar);
                            if (a2 != null) {
                                d.a().b(a2.h());
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    private void c(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null && uncaughtExceptionHandler != this && !r.a(512)) {
            this.b.uncaughtException(thread, th);
        }
    }

    public static boolean c() {
        Boolean bool = j.get();
        return bool != null && bool.booleanValue();
    }

    private void d() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            this.b = defaultUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    private void e() {
        synchronized (this) {
            this.f--;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        while (this.f != 0 && SystemClock.uptimeMillis() - uptimeMillis < 10000) {
            SystemClock.sleep(50);
        }
    }

    private void f() {
        File a2 = com.apm.insight.l.o.a(i.g());
        File a3 = com.apm.insight.l.o.a();
        if (!com.apm.insight.l.i.b(a2) || !com.apm.insight.l.i.b(a3)) {
            long uptimeMillis = SystemClock.uptimeMillis();
            while (!com.apm.insight.k.i.a() && SystemClock.uptimeMillis() - uptimeMillis < 10000) {
                try {
                    SystemClock.sleep(500);
                } catch (Throwable unused) {
                }
            }
        }
    }

    private boolean g() {
        return com.apm.insight.runtime.a.a("exception_modules", "oom_callback") == 1;
    }

    public void a(c cVar) {
        this.c = cVar;
    }

    public void a(String str) {
        this.g.put(str, new Object());
    }

    public void a(Thread thread, Throwable th, boolean z, com.apm.insight.entity.a aVar) {
        List<ICrashCallback> list;
        CrashType crashType;
        if (z) {
            list = o.a().b();
            crashType = CrashType.LAUNCH;
        } else {
            list = o.a().c();
            crashType = CrashType.JAVA;
        }
        for (ICrashCallback next : list) {
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                if (next instanceof b) {
                    ((b) next).a(crashType, v.a(th), thread, this.k);
                } else {
                    next.onCrash(crashType, v.a(th), thread);
                }
                aVar.b("callback_cost_" + next.getClass().getName(), String.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            } catch (Throwable th2) {
                q.b(th2);
                aVar.b("callback_err_" + next.getClass().getName(), String.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            }
        }
    }

    public void b(c cVar) {
        this.d = cVar;
    }

    public boolean b(String str) {
        return this.g.containsKey(str);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        do {
            th = a(thread, th);
        } while (th != null);
    }
}
