package com.teragence.library;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import com.google.common.base.Ascii;
import com.teragence.client.c;
import com.teragence.client.d;
import com.teragence.client.e;
import com.teragence.client.g;
import com.teragence.client.i;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicBoolean;

public class v0 {
    /* access modifiers changed from: private */
    public static final String a = "com.teragence.library.v0";

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
                i.a(v0.a, "Got cell network, using NetworkSocketFactory");
                this.b[0] = network;
                this.a.set(true);
                synchronized (this.c) {
                    this.c.notify();
                }
            }
        }

        public void onLost(Network network) {
            if (!this.a.get()) {
                i.a(v0.a, "Haven't got cell network (lost)");
                this.b[0] = null;
                this.a.set(true);
                synchronized (this.c) {
                    this.c.notify();
                }
            }
        }

        public void onUnavailable() {
            if (!this.a.get()) {
                i.a(v0.a, "Haven't got cell network (unavailable), falling back");
                this.b[0] = null;
                this.a.set(true);
                synchronized (this.c) {
                    this.c.notify();
                }
            }
        }
    }

    public static g a(Context context, InetAddress inetAddress, boolean z) {
        if (!c(context)) {
            i.c(a, "getCellularSocketFactory Missing required network permissions for network binding");
            return new c();
        } else if (Build.VERSION.SDK_INT >= 21) {
            String str = a;
            i.a(str, "Getting socket factory using new apis");
            Network b = b(context);
            if (b == null && z) {
                i.a(str, "Other networks allowed, falling back");
                return new c();
            } else if (b != null) {
                return new d(b);
            } else {
                return null;
            }
        } else {
            i.a(a, "Getting socket factory using old RouteToHostTcpSocketFactory helper");
            return new e(context, inetAddress, z);
        }
    }

    public static void a(Context context) {
        if (!c(context)) {
            i.c(a, "clearBindProcessToNetwork missing network permissions");
        } else {
            a((ConnectivityManager) context.getSystemService("connectivity"), (Network) null);
        }
    }

    public static void a(Context context, InetAddress inetAddress) {
        if (!c(context)) {
            i.c(a, "bindProcessToNetwork missing network permissions");
        } else if (Build.VERSION.SDK_INT >= 21) {
            Network b = b(context);
            if (b != null) {
                a((ConnectivityManager) context.getSystemService("connectivity"), b);
            }
        } else {
            b(context, inetAddress);
        }
    }

    private static void a(ConnectivityManager connectivityManager, Network network) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            try {
                ConnectivityManager.class.getMethod("bindProcessToNetwork", new Class[]{Network.class}).invoke(connectivityManager, new Object[]{network});
            } catch (Exception unused) {
                i.c(a, "Unable to bind process network");
            }
        } else if (i >= 21) {
            ConnectivityManager.setProcessDefaultNetwork(network);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:26|(2:27|(3:29|30|(2:44|32)(2:33|34))(0))|35|36|(1:38)|39) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00aa */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c6 A[Catch:{ Exception -> 0x00cd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r6, java.net.InetAddress r7, int r8, java.lang.String r9, int r10) {
        /*
            java.lang.String r0 = "startUsingNetworkFeature result: "
            r1 = 0
            java.lang.String r2 = "connectivity"
            java.lang.Object r6 = r6.getSystemService(r2)     // Catch:{ Exception -> 0x00cd }
            android.net.ConnectivityManager r6 = (android.net.ConnectivityManager) r6     // Catch:{ Exception -> 0x00cd }
            if (r6 != 0) goto L_0x0016
            java.lang.String r6 = a     // Catch:{ Exception -> 0x00cd }
            java.lang.String r7 = "ConnectivityManager is null, cannot try to force a mobile connection"
            com.teragence.client.i.a((java.lang.String) r6, (java.lang.String) r7)     // Catch:{ Exception -> 0x00cd }
            return r1
        L_0x0016:
            android.net.NetworkInfo r2 = r6.getNetworkInfo(r10)     // Catch:{ Exception -> 0x00cd }
            if (r2 != 0) goto L_0x0024
            java.lang.String r6 = a     // Catch:{ Exception -> 0x00cd }
            java.lang.String r7 = "NetworkInfo is null"
            com.teragence.client.i.a((java.lang.String) r6, (java.lang.String) r7)     // Catch:{ Exception -> 0x00cd }
            return r1
        L_0x0024:
            android.net.NetworkInfo$State r3 = r2.getState()     // Catch:{ Exception -> 0x00cd }
            java.lang.String r4 = a     // Catch:{ Exception -> 0x00cd }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cd }
            r5.<init>()     // Catch:{ Exception -> 0x00cd }
            java.lang.String r2 = r2.getTypeName()     // Catch:{ Exception -> 0x00cd }
            r5.append(r2)     // Catch:{ Exception -> 0x00cd }
            java.lang.String r2 = " network state: "
            r5.append(r2)     // Catch:{ Exception -> 0x00cd }
            r5.append(r3)     // Catch:{ Exception -> 0x00cd }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x00cd }
            com.teragence.client.i.a((java.lang.String) r4, (java.lang.String) r2)     // Catch:{ Exception -> 0x00cd }
            android.net.NetworkInfo$State r2 = android.net.NetworkInfo.State.CONNECTED     // Catch:{ Exception -> 0x00cd }
            int r2 = r3.compareTo(r2)     // Catch:{ Exception -> 0x00cd }
            r5 = 1
            if (r2 == 0) goto L_0x00cc
            android.net.NetworkInfo$State r2 = android.net.NetworkInfo.State.CONNECTING     // Catch:{ Exception -> 0x00cd }
            int r2 = r3.compareTo(r2)     // Catch:{ Exception -> 0x00cd }
            if (r2 != 0) goto L_0x0058
            goto L_0x00cc
        L_0x0058:
            com.teragence.library.w7 r2 = com.teragence.library.w7.a(r6)     // Catch:{ Exception -> 0x00cd }
            int r8 = r2.a((int) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x00cd }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cd }
            r9.<init>(r0)     // Catch:{ Exception -> 0x00cd }
            r9.append(r8)     // Catch:{ Exception -> 0x00cd }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00cd }
            com.teragence.client.i.a((java.lang.String) r4, (java.lang.String) r9)     // Catch:{ Exception -> 0x00cd }
            r9 = -1
            if (r9 != r8) goto L_0x0078
            java.lang.String r6 = "Wrong result of startUsingNetworkFeature, maybe problems"
            com.teragence.client.i.b(r4, r6)     // Catch:{ Exception -> 0x00cd }
            return r1
        L_0x0078:
            if (r8 != 0) goto L_0x0080
            java.lang.String r6 = "No need to perform additional network settings"
            com.teragence.client.i.a((java.lang.String) r4, (java.lang.String) r6)     // Catch:{ Exception -> 0x00cd }
            return r5
        L_0x0080:
            int r7 = b((java.net.InetAddress) r7)     // Catch:{ Exception -> 0x00cd }
            if (r9 != r7) goto L_0x008c
            java.lang.String r6 = "Wrong host address transformation, result was -1"
            com.teragence.client.i.b(r4, r6)     // Catch:{ Exception -> 0x00cd }
            return r1
        L_0x008c:
            r8 = 0
        L_0x008d:
            r9 = 30
            if (r8 >= r9) goto L_0x00aa
            android.net.NetworkInfo r9 = r6.getNetworkInfo(r10)     // Catch:{ InterruptedException -> 0x00aa }
            android.net.NetworkInfo$State r9 = r9.getState()     // Catch:{ InterruptedException -> 0x00aa }
            android.net.NetworkInfo$State r0 = android.net.NetworkInfo.State.CONNECTED     // Catch:{ InterruptedException -> 0x00aa }
            int r9 = r9.compareTo(r0)     // Catch:{ InterruptedException -> 0x00aa }
            if (r9 != 0) goto L_0x00a2
            goto L_0x00aa
        L_0x00a2:
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x00aa }
            int r8 = r8 + 1
            goto L_0x008d
        L_0x00aa:
            boolean r6 = r2.a((int) r10, (int) r7)     // Catch:{ Exception -> 0x00cd }
            java.lang.String r7 = a     // Catch:{ Exception -> 0x00cd }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cd }
            r8.<init>()     // Catch:{ Exception -> 0x00cd }
            java.lang.String r9 = "requestRouteToHost result: "
            r8.append(r9)     // Catch:{ Exception -> 0x00cd }
            r8.append(r6)     // Catch:{ Exception -> 0x00cd }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00cd }
            com.teragence.client.i.a((java.lang.String) r7, (java.lang.String) r8)     // Catch:{ Exception -> 0x00cd }
            if (r6 != 0) goto L_0x00cb
            java.lang.String r8 = "Wrong requestRouteToHost result: expected true, but was false"
            com.teragence.client.i.a((java.lang.String) r7, (java.lang.String) r8)     // Catch:{ Exception -> 0x00cd }
        L_0x00cb:
            return r6
        L_0x00cc:
            return r5
        L_0x00cd:
            r6 = move-exception
            java.lang.String r7 = a
            java.lang.String r8 = "Unable to force network"
            com.teragence.client.i.a((java.lang.String) r7, (java.lang.String) r8, (java.lang.Exception) r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.teragence.library.v0.a(android.content.Context, java.net.InetAddress, int, java.lang.String, int):boolean");
    }

    public static boolean a(InetAddress inetAddress) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            DatagramPacket datagramPacket = new DatagramPacket(new byte[1], 1);
            datagramPacket.setAddress(inetAddress);
            datagramPacket.setPort(81);
            datagramSocket.send(datagramPacket);
        } catch (IOException unused) {
            return false;
        } catch (Exception unused2) {
        }
        return true;
    }

    private static int b(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        return (address[0] & 255) | ((address[3] & 255) << Ascii.CAN) | ((address[2] & 255) << Ascii.DLE) | ((address[1] & 255) << 8);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0051 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0064 A[EDGE_INSN: B:31:0x0064->B:24:0x0064 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.net.Network b(android.content.Context r12) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            r2 = 0
            if (r0 >= r1) goto L_0x0008
            return r2
        L_0x0008:
            java.lang.String r0 = "connectivity"
            java.lang.Object r12 = r12.getSystemService(r0)
            android.net.ConnectivityManager r12 = (android.net.ConnectivityManager) r12
            android.net.NetworkRequest$Builder r0 = new android.net.NetworkRequest$Builder
            r0.<init>()
            r1 = 12
            r0.addCapability(r1)
            r1 = 0
            r0.addTransportType(r1)
            android.net.NetworkRequest r0 = r0.build()
            java.util.concurrent.atomic.AtomicBoolean r3 = new java.util.concurrent.atomic.AtomicBoolean
            r3.<init>(r1)
            r4 = 1
            android.net.Network[] r5 = new android.net.Network[r4]
            r5[r1] = r2
            java.lang.Object r2 = new java.lang.Object
            r2.<init>()
            com.teragence.library.v0$a r6 = new com.teragence.library.v0$a
            r6.<init>(r3, r5, r2)
            r12.requestNetwork(r0, r6)     // Catch:{ Exception -> 0x0072 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0072 }
            r8 = 15000(0x3a98, double:7.411E-320)
            long r6 = r6 + r8
        L_0x0040:
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x0064
            monitor-enter(r2)     // Catch:{ Exception -> 0x0051 }
            r8 = 1500(0x5dc, double:7.41E-321)
            r2.wait(r8)     // Catch:{ all -> 0x004e }
            monitor-exit(r2)     // Catch:{ all -> 0x004e }
            goto L_0x0058
        L_0x004e:
            r12 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x004e }
            throw r12     // Catch:{ Exception -> 0x0051 }
        L_0x0051:
            java.lang.String r12 = a     // Catch:{ Exception -> 0x0072 }
            java.lang.String r0 = "requestNetwork wait interrupted"
            com.teragence.client.i.c(r12, r0)     // Catch:{ Exception -> 0x0072 }
        L_0x0058:
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0072 }
            long r8 = r6 - r8
            boolean r12 = r3.get()     // Catch:{ Exception -> 0x0072 }
            if (r12 == 0) goto L_0x0040
        L_0x0064:
            boolean r12 = r3.getAndSet(r4)     // Catch:{ Exception -> 0x0072 }
            if (r12 != 0) goto L_0x007c
            java.lang.String r12 = a     // Catch:{ Exception -> 0x0072 }
            java.lang.String r0 = "Timeout while acquiring cell network"
            com.teragence.client.i.c(r12, r0)     // Catch:{ Exception -> 0x0072 }
            goto L_0x007c
        L_0x0072:
            r3.set(r4)
            java.lang.String r12 = a
            java.lang.String r0 = "Failure to request network, missing permissions?"
            com.teragence.client.i.b(r12, r0)
        L_0x007c:
            r12 = r5[r1]
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.teragence.library.v0.b(android.content.Context):android.net.Network");
    }

    public static boolean b(Context context, InetAddress inetAddress) {
        return a(context, inetAddress, 0, "enableHIPRI", 5);
    }

    public static boolean c(Context context) {
        return Build.VERSION.SDK_INT < 23 || (context.checkCallingOrSelfPermission("android.permission.CHANGE_NETWORK_STATE") == 0 && context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
    }

    public static boolean c(Context context, InetAddress inetAddress) {
        return a(context, inetAddress, 1, "p2p", 1);
    }
}
