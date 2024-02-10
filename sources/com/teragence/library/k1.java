package com.teragence.library;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import com.teragence.client.c;
import com.teragence.client.d;
import com.teragence.client.f;
import com.teragence.client.g;
import com.teragence.client.i;
import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicBoolean;

public class k1 implements j1 {
    /* access modifiers changed from: private */
    public static final String b = "k1";
    private final Context a;

    class a extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ AtomicBoolean a;
        final /* synthetic */ Network[] b;
        final /* synthetic */ Object c;

        a(AtomicBoolean atomicBoolean, Network[] networkArr, Object obj) {
            this.a = atomicBoolean;
            this.b = networkArr;
            this.c = obj;
        }

        public void onAvailable(Network network) {
            if (!this.a.get()) {
                i.a(k1.b, "Got cell network, using NetworkSocketFactory");
                this.b[0] = network;
                this.a.set(true);
                synchronized (this.c) {
                    this.c.notify();
                }
            }
        }

        public void onLost(Network network) {
            if (!this.a.get()) {
                i.a(k1.b, "Haven't got cell network (lost)");
                this.b[0] = null;
                this.a.set(true);
                synchronized (this.c) {
                    this.c.notify();
                }
            }
        }

        public void onUnavailable() {
            if (!this.a.get()) {
                i.a(k1.b, "Haven't got cell network (unavailable), falling back");
                this.b[0] = null;
                this.a.set(true);
                synchronized (this.c) {
                    this.c.notify();
                }
            }
        }
    }

    public k1(Context context) {
        this.a = context;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004a */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d A[EDGE_INSN: B:28:0x005d->B:21:0x005d ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.net.Network a(android.content.Context r12) {
        /*
            java.lang.String r0 = "connectivity"
            java.lang.Object r12 = r12.getSystemService(r0)
            android.net.ConnectivityManager r12 = (android.net.ConnectivityManager) r12
            android.net.NetworkRequest$Builder r0 = new android.net.NetworkRequest$Builder
            r0.<init>()
            r1 = 12
            r0.addCapability(r1)
            r1 = 1
            r0.addTransportType(r1)
            android.net.NetworkRequest r0 = r0.build()
            java.util.concurrent.atomic.AtomicBoolean r2 = new java.util.concurrent.atomic.AtomicBoolean
            r3 = 0
            r2.<init>(r3)
            android.net.Network[] r4 = new android.net.Network[r1]
            r5 = 0
            r4[r3] = r5
            java.lang.Object r5 = new java.lang.Object
            r5.<init>()
            com.teragence.library.k1$a r6 = new com.teragence.library.k1$a
            r6.<init>(r2, r4, r5)
            r12.requestNetwork(r0, r6)     // Catch:{ Exception -> 0x006b }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x006b }
            r8 = 15000(0x3a98, double:7.411E-320)
            long r6 = r6 + r8
        L_0x0039:
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x005d
            monitor-enter(r5)     // Catch:{ Exception -> 0x004a }
            r8 = 1500(0x5dc, double:7.41E-321)
            r5.wait(r8)     // Catch:{ all -> 0x0047 }
            monitor-exit(r5)     // Catch:{ all -> 0x0047 }
            goto L_0x0051
        L_0x0047:
            r12 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0047 }
            throw r12     // Catch:{ Exception -> 0x004a }
        L_0x004a:
            java.lang.String r12 = b     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = "requestNetwork wait interrupted"
            com.teragence.client.i.c(r12, r0)     // Catch:{ Exception -> 0x006b }
        L_0x0051:
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x006b }
            long r8 = r6 - r8
            boolean r12 = r2.get()     // Catch:{ Exception -> 0x006b }
            if (r12 == 0) goto L_0x0039
        L_0x005d:
            boolean r12 = r2.getAndSet(r1)     // Catch:{ Exception -> 0x006b }
            if (r12 != 0) goto L_0x0075
            java.lang.String r12 = b     // Catch:{ Exception -> 0x006b }
            java.lang.String r0 = "Timeout while acquiring cell network"
            com.teragence.client.i.c(r12, r0)     // Catch:{ Exception -> 0x006b }
            goto L_0x0075
        L_0x006b:
            r2.set(r1)
            java.lang.String r12 = b
            java.lang.String r0 = "Failure to request network, missing permissions?"
            com.teragence.client.i.b(r12, r0)
        L_0x0075:
            r12 = r4[r3]
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.teragence.library.k1.a(android.content.Context):android.net.Network");
    }

    private static g a(Context context, InetAddress inetAddress, boolean z) {
        if (!v0.c(context)) {
            i.c(b, "getWiFiSocketFactory Missing required network permissions for network binding");
            return new c();
        } else if (Build.VERSION.SDK_INT >= 21) {
            String str = b;
            i.a(str, "Getting socket factory using new apis");
            Network a2 = a(context);
            if (a2 == null && z) {
                i.a(str, "Other networks allowed, falling back");
                return new c();
            } else if (a2 != null) {
                return new d(a2);
            } else {
                return null;
            }
        } else {
            i.a(b, "Getting socket factory using old RouteToHostTcpSocketFactory helper");
            return new f(context, inetAddress, z);
        }
    }

    public g a(InetAddress inetAddress, boolean z) {
        g a2 = a(this.a, inetAddress, z);
        if (a2 != null) {
            return a2;
        }
        throw new l("No network available");
    }
}
