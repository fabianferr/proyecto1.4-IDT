package com.umlaut.crowd.internal;

import android.os.Build;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructPollfd;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.io.FileDescriptor;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Arrays;

public class e {
    private static final String r = "e";
    private static final boolean s = false;
    /* access modifiers changed from: private */
    public static final short t;
    private static final int u = 7;
    private static final int v = 16;
    private static final int w = 64;
    private static final int x = 11;
    private static final int y = 25;
    private static final short z = 30583;
    private final InetAddress a;
    /* access modifiers changed from: private */
    public w6 b;
    /* access modifiers changed from: private */
    public final int c;
    private final int d;
    /* access modifiers changed from: private */
    public final int e;
    private final u3 f;
    private short g = 0;
    private short h = z;
    /* access modifiers changed from: private */
    public boolean i = false;
    /* access modifiers changed from: private */
    public boolean j = false;
    private final int k;
    /* access modifiers changed from: private */
    public final int l;
    /* access modifiers changed from: private */
    public int m;
    private final boolean n;
    private int o;
    /* access modifiers changed from: private */
    public final SparseArray<Long> p;
    /* access modifiers changed from: private */
    public final SparseIntArray q;

    private class a extends Thread {
        private final StructPollfd[] a;

        a(StructPollfd[] structPollfdArr) {
            this.a = structPollfdArr;
        }

        public void run() {
            int i;
            StructPollfd structPollfd = this.a[0];
            FileDescriptor fileDescriptor = structPollfd.fd;
            int a2 = e.this.l;
            byte[] bArr = new byte[a2];
            int i2 = 0;
            while (e.this.j && !e.this.i && e.this.m < e.this.e) {
                try {
                    int poll = Os.poll(this.a, e.this.c);
                    if (!e.this.i) {
                        if (poll >= 0) {
                            if (structPollfd.revents == e.t) {
                                structPollfd.revents = 0;
                                Os.recvfrom(fileDescriptor, bArr, 0, a2, 64, (InetSocketAddress) null);
                                long elapsedRealtime = SystemClock.elapsedRealtime();
                                int hashCode = Arrays.hashCode(e.b(bArr));
                                Long l = (Long) e.this.p.get(hashCode);
                                if (l != null) {
                                    long longValue = elapsedRealtime - l.longValue();
                                    long j = (long) e.this.q.get(hashCode);
                                    e.this.q.delete(hashCode);
                                    e.this.p.delete(hashCode);
                                    i = i2 + 1;
                                    try {
                                        e.this.b.b(i2, j, longValue);
                                        e.f(e.this);
                                    } catch (Exception e) {
                                        e = e;
                                        i2 = i;
                                    }
                                }
                            } else if (structPollfd.revents == OsConstants.POLLERR) {
                                Os.recvfrom(fileDescriptor, bArr, 0, a2, 8192, new InetSocketAddress(7));
                                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                int hashCode2 = Arrays.hashCode(e.b(bArr));
                                Long l2 = (Long) e.this.p.get(hashCode2);
                                if (l2 != null) {
                                    long longValue2 = elapsedRealtime2 - l2.longValue();
                                    long j2 = (long) e.this.q.get(hashCode2);
                                    e.this.q.delete(hashCode2);
                                    e.this.p.delete(hashCode2);
                                    i = i2 + 1;
                                    e.this.b.a(i2, j2, longValue2);
                                    e.f(e.this);
                                }
                            }
                            i2 = i;
                        }
                    } else {
                        return;
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                }
            }
        }
    }

    static {
        int i2 = OsConstants.POLLIN;
        if (i2 == 0) {
            i2 = 1;
        }
        t = (short) i2;
    }

    public e(InetAddress inetAddress, int i2, int i3, int i4, int i5, boolean z2) {
        this.a = inetAddress;
        this.c = i4;
        this.e = i2;
        this.d = i3;
        this.n = z2;
        this.f = new u3(inetAddress instanceof Inet6Address ? Byte.MIN_VALUE : 8);
        this.k = i5;
        this.l = i5 + 8;
        this.p = new SparseArray<>();
        this.q = new SparseIntArray();
    }

    static /* synthetic */ int f(e eVar) {
        int i2 = eVar.m;
        eVar.m = i2 + 1;
        return i2;
    }

    public void b() {
        this.i = true;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r15.m++;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x009a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c() {
        /*
            r15 = this;
            r0 = 0
            r15.i = r0
            java.net.InetAddress r1 = r15.a
            boolean r1 = r1 instanceof java.net.Inet6Address
            if (r1 == 0) goto L_0x000e
            int r1 = android.system.OsConstants.AF_INET6
            int r2 = android.system.OsConstants.IPPROTO_ICMPV6
            goto L_0x0012
        L_0x000e:
            int r1 = android.system.OsConstants.AF_INET
            int r2 = android.system.OsConstants.IPPROTO_ICMP
        L_0x0012:
            int r3 = android.system.OsConstants.SOCK_DGRAM     // Catch:{ Exception -> 0x00f4 }
            java.io.FileDescriptor r1 = android.system.Os.socket(r1, r3, r2)     // Catch:{ Exception -> 0x00f4 }
            boolean r2 = r1.valid()     // Catch:{ Exception -> 0x00f4 }
            if (r2 == 0) goto L_0x0109
            r15.a((java.io.FileDescriptor) r1)     // Catch:{ all -> 0x00ed }
            android.system.StructPollfd r2 = new android.system.StructPollfd     // Catch:{ all -> 0x00ed }
            r2.<init>()     // Catch:{ all -> 0x00ed }
            r2.fd = r1     // Catch:{ all -> 0x00ed }
            short r3 = t     // Catch:{ all -> 0x00ed }
            int r4 = android.system.OsConstants.POLLERR     // Catch:{ all -> 0x00ed }
            short r4 = (short) r4     // Catch:{ all -> 0x00ed }
            r3 = r3 | r4
            short r3 = (short) r3     // Catch:{ all -> 0x00ed }
            r2.events = r3     // Catch:{ all -> 0x00ed }
            r3 = 1
            android.system.StructPollfd[] r4 = new android.system.StructPollfd[r3]     // Catch:{ all -> 0x00ed }
            r4[r0] = r2     // Catch:{ all -> 0x00ed }
            com.umlaut.crowd.internal.e$a r2 = new com.umlaut.crowd.internal.e$a     // Catch:{ all -> 0x00ed }
            r2.<init>(r4)     // Catch:{ all -> 0x00ed }
            r2.start()     // Catch:{ all -> 0x00ed }
            r15.j = r3     // Catch:{ all -> 0x00ed }
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00ed }
            r6 = 0
        L_0x0045:
            int r7 = r15.e     // Catch:{ all -> 0x00ed }
            if (r6 >= r7) goto L_0x00dc
            boolean r7 = r15.n     // Catch:{ all -> 0x00ed }
            if (r7 == 0) goto L_0x0050
            r15.b((java.io.FileDescriptor) r1)     // Catch:{ all -> 0x00ed }
        L_0x0050:
            boolean r7 = r15.i     // Catch:{ all -> 0x00ed }
            if (r7 == 0) goto L_0x0056
            goto L_0x00dc
        L_0x0056:
            int r7 = r15.k     // Catch:{ all -> 0x00ed }
            byte[] r7 = com.umlaut.crowd.internal.u3.a(r7)     // Catch:{ all -> 0x00ed }
            com.umlaut.crowd.internal.u3 r8 = r15.f     // Catch:{ all -> 0x00ed }
            short r9 = r15.g     // Catch:{ all -> 0x00ed }
            int r9 = r9 + r3
            short r9 = (short) r9     // Catch:{ all -> 0x00ed }
            r15.g = r9     // Catch:{ all -> 0x00ed }
            short r10 = r15.h     // Catch:{ all -> 0x00ed }
            java.nio.ByteBuffer r8 = r8.a(r9, r10, r7)     // Catch:{ all -> 0x00ed }
            int r7 = java.util.Arrays.hashCode(r7)     // Catch:{ Exception -> 0x009a }
            short r9 = r15.g     // Catch:{ Exception -> 0x009a }
            int r9 = r9 - r3
            int r10 = r15.d     // Catch:{ Exception -> 0x009a }
            int r9 = r9 * r10
            android.util.SparseIntArray r10 = r15.q     // Catch:{ Exception -> 0x009a }
            r10.put(r7, r9)     // Catch:{ Exception -> 0x009a }
            com.umlaut.crowd.internal.w6 r10 = r15.b     // Catch:{ Exception -> 0x009a }
            short r11 = r15.g     // Catch:{ Exception -> 0x009a }
            int r11 = r11 - r3
            long r12 = (long) r9     // Catch:{ Exception -> 0x009a }
            r10.a(r11, r12)     // Catch:{ Exception -> 0x009a }
            android.util.SparseArray<java.lang.Long> r9 = r15.p     // Catch:{ Exception -> 0x009a }
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x009a }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ Exception -> 0x009a }
            r9.put(r7, r10)     // Catch:{ Exception -> 0x009a }
            java.net.InetAddress r7 = r15.a     // Catch:{ Exception -> 0x009a }
            r9 = 7
            int r7 = android.system.Os.sendto(r1, r8, r0, r7, r9)     // Catch:{ Exception -> 0x009a }
            if (r7 >= 0) goto L_0x009f
            goto L_0x00dc
        L_0x009a:
            int r7 = r15.m     // Catch:{ all -> 0x00ed }
            int r7 = r7 + r3
            r15.m = r7     // Catch:{ all -> 0x00ed }
        L_0x009f:
            int r7 = r15.e     // Catch:{ all -> 0x00ed }
            int r7 = r7 - r3
            if (r6 >= r7) goto L_0x00d8
            int r7 = r15.d     // Catch:{ Exception -> 0x00c1 }
            long r7 = (long) r7     // Catch:{ Exception -> 0x00c1 }
            long r9 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x00c1 }
            long r9 = r9 - r4
            short r11 = r15.g     // Catch:{ Exception -> 0x00c1 }
            int r11 = r11 - r3
            long r11 = (long) r11     // Catch:{ Exception -> 0x00c1 }
            int r13 = r15.d     // Catch:{ Exception -> 0x00c1 }
            long r13 = (long) r13     // Catch:{ Exception -> 0x00c1 }
            long r11 = r11 * r13
            long r9 = r9 - r11
            long r7 = r7 - r9
            r9 = 0
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 <= 0) goto L_0x00d8
            java.lang.Thread.sleep(r7)     // Catch:{ Exception -> 0x00c1 }
            goto L_0x00d8
        L_0x00c1:
            r7 = move-exception
            java.lang.String r8 = r     // Catch:{ all -> 0x00ed }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ed }
            r9.<init>()     // Catch:{ all -> 0x00ed }
            java.lang.String r10 = "Pause: "
            r9.append(r10)     // Catch:{ all -> 0x00ed }
            r9.append(r7)     // Catch:{ all -> 0x00ed }
            java.lang.String r7 = r9.toString()     // Catch:{ all -> 0x00ed }
            android.util.Log.d(r8, r7)     // Catch:{ all -> 0x00ed }
        L_0x00d8:
            int r6 = r6 + 1
            goto L_0x0045
        L_0x00dc:
            r15.j = r0     // Catch:{ all -> 0x00ed }
            boolean r3 = r2.isAlive()     // Catch:{ all -> 0x00ed }
            if (r3 == 0) goto L_0x00e7
            r2.join()     // Catch:{ all -> 0x00ed }
        L_0x00e7:
            android.system.Os.close(r1)     // Catch:{ Exception -> 0x00f4 }
            r15.j = r0     // Catch:{ Exception -> 0x00f4 }
            goto L_0x0109
        L_0x00ed:
            r2 = move-exception
            android.system.Os.close(r1)     // Catch:{ Exception -> 0x00f4 }
            r15.j = r0     // Catch:{ Exception -> 0x00f4 }
            throw r2     // Catch:{ Exception -> 0x00f4 }
        L_0x00f4:
            r0 = move-exception
            java.lang.String r1 = r
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "start: Os.socket: "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.util.Log.d(r1, r0)
        L_0x0109:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.e.c():void");
    }

    private void b(FileDescriptor fileDescriptor) throws ErrnoException {
        if (Build.VERSION.SDK_INT >= 26) {
            if (this.a instanceof Inet4Address) {
                Os.setsockoptInt(fileDescriptor, OsConstants.IPPROTO_IP, 11, 1);
                Os.setsockoptInt(fileDescriptor, OsConstants.IPPROTO_IP, OsConstants.IP_TTL, this.o);
                return;
            }
            Os.setsockoptInt(fileDescriptor, OsConstants.IPPROTO_IPV6, 25, 1);
            Os.setsockoptInt(fileDescriptor, OsConstants.IPPROTO_IPV6, OsConstants.IPV6_UNICAST_HOPS, this.o);
        } else if (this.a instanceof Inet4Address) {
            Class<Os> cls = Os.class;
            try {
                Class cls2 = Integer.TYPE;
                cls.getMethod("setsockoptInt", new Class[]{FileDescriptor.class, cls2, cls2, cls2}).invoke((Object) null, new Object[]{fileDescriptor, Integer.valueOf(OsConstants.IPPROTO_IP), 11, 1});
                Os.class.getMethod("setsockoptInt", new Class[]{FileDescriptor.class, cls2, cls2, cls2}).invoke((Object) null, new Object[]{fileDescriptor, Integer.valueOf(OsConstants.IPPROTO_IP), Integer.valueOf(OsConstants.IP_TTL), Integer.valueOf(this.o)});
            } catch (Exception e2) {
                Log.e(r, "setLowDelay: setsockoptInt", e2);
            }
        } else {
            Class<Os> cls3 = Os.class;
            try {
                Class cls4 = Integer.TYPE;
                cls3.getMethod("setsockoptInt", new Class[]{FileDescriptor.class, cls4, cls4, cls4}).invoke((Object) null, new Object[]{fileDescriptor, Integer.valueOf(OsConstants.IPPROTO_IPV6), 25, 1});
                Os.class.getMethod("setsockoptInt", new Class[]{FileDescriptor.class, cls4, cls4, cls4}).invoke((Object) null, new Object[]{fileDescriptor, Integer.valueOf(OsConstants.IPPROTO_IPV6), Integer.valueOf(OsConstants.IPV6_UNICAST_HOPS), Integer.valueOf(this.o)});
            } catch (Exception e3) {
                Log.e(r, "setLowDelay: setsockoptInt", e3);
            }
        }
    }

    public void a(int i2) {
        this.o = i2;
    }

    public void a(short s2) {
        this.h = s2;
    }

    public void a(w6 w6Var) {
        this.b = w6Var;
    }

    private void a(FileDescriptor fileDescriptor) throws ErrnoException {
        if (Build.VERSION.SDK_INT >= 26) {
            Os.setsockoptInt(fileDescriptor, OsConstants.IPPROTO_IP, OsConstants.IP_TOS, 16);
            return;
        }
        Class<Os> cls = Os.class;
        try {
            Class cls2 = Integer.TYPE;
            cls.getMethod("setsockoptInt", new Class[]{FileDescriptor.class, cls2, cls2, cls2}).invoke((Object) null, new Object[]{fileDescriptor, Integer.valueOf(OsConstants.IPPROTO_IP), Integer.valueOf(OsConstants.IP_TOS), 16});
        } catch (Exception e2) {
            Log.e(r, "setLowDelay: setsockoptInt", e2);
        }
    }

    /* access modifiers changed from: private */
    public static byte[] b(byte[] bArr) {
        return Arrays.copyOfRange(bArr, 8, bArr.length);
    }
}
