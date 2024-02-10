package com.umlaut.crowd.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.InetAddresses;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.SystemClock;
import android.util.Patterns;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class h2 {
    public static final String a = "h2";
    private static final boolean b = false;
    private static final boolean c = false;
    private static final int d = 53;
    private static final int e = 1000;
    private static final int f = 1000;
    private static final short g = 444;
    private static final short h = 666;

    private static class b {
        ArrayList<InetAddress> a;
        String b;
        short c;

        private b() {
            this.a = new ArrayList<>();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007e A[SYNTHETIC, Splitter:B:42:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x008f A[Catch:{ Exception -> 0x00f2, all -> 0x00f0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.umlaut.crowd.internal.g2 a(java.lang.String[] r18, java.lang.String[] r19, java.lang.String r20, int r21, boolean r22) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            java.net.DatagramSocket r4 = new java.net.DatagramSocket     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            r4.<init>()     // Catch:{ Exception -> 0x00ff, all -> 0x00fc }
            r5 = 1000(0x3e8, float:1.401E-42)
            r4.setSoTimeout(r5)     // Catch:{ Exception -> 0x00f8, all -> 0x00f4 }
            int r5 = r0.length     // Catch:{ Exception -> 0x00f8, all -> 0x00f4 }
            java.net.InetAddress[] r6 = new java.net.InetAddress[r5]     // Catch:{ Exception -> 0x00f8, all -> 0x00f4 }
            r8 = 0
        L_0x0014:
            int r9 = r0.length     // Catch:{ Exception -> 0x00f8, all -> 0x00f4 }
            if (r8 >= r9) goto L_0x0022
            r9 = r0[r8]     // Catch:{ Exception -> 0x00f8, all -> 0x00f4 }
            java.net.InetAddress r9 = java.net.InetAddress.getByName(r9)     // Catch:{ Exception -> 0x00f8, all -> 0x00f4 }
            r6[r8] = r9     // Catch:{ Exception -> 0x00f8, all -> 0x00f4 }
            int r8 = r8 + 1
            goto L_0x0014
        L_0x0022:
            int r0 = r1.length     // Catch:{ Exception -> 0x00f8, all -> 0x00f4 }
            java.net.InetAddress[] r8 = new java.net.InetAddress[r0]     // Catch:{ Exception -> 0x00f8, all -> 0x00f4 }
            r9 = 0
        L_0x0026:
            int r10 = r1.length     // Catch:{ Exception -> 0x00f8, all -> 0x00f4 }
            if (r9 >= r10) goto L_0x0034
            r10 = r1[r9]     // Catch:{ Exception -> 0x00f8, all -> 0x00f4 }
            java.net.InetAddress r10 = java.net.InetAddress.getByName(r10)     // Catch:{ Exception -> 0x00f8, all -> 0x00f4 }
            r8[r9] = r10     // Catch:{ Exception -> 0x00f8, all -> 0x00f4 }
            int r9 = r9 + 1
            goto L_0x0026
        L_0x0034:
            int r1 = r1.length     // Catch:{ Exception -> 0x00f8, all -> 0x00f4 }
            if (r1 == 0) goto L_0x003c
            if (r22 != 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r1 = 0
            goto L_0x003d
        L_0x003c:
            r1 = 1
        L_0x003d:
            com.umlaut.crowd.internal.g2 r10 = new com.umlaut.crowd.internal.g2     // Catch:{ Exception -> 0x00f8, all -> 0x00f4 }
            r10.<init>()     // Catch:{ Exception -> 0x00f8, all -> 0x00f4 }
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x00f8, all -> 0x00f4 }
            r10.a((long) r11)     // Catch:{ Exception -> 0x00f8, all -> 0x00f4 }
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x004c:
            if (r11 != 0) goto L_0x00c9
            if (r12 != 0) goto L_0x00c9
            long r14 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x00f8, all -> 0x00f4 }
            r9 = r21
            r16 = r4
            long r3 = (long) r9
            long r14 = r14 - r3
            long r3 = r10.f()     // Catch:{ Exception -> 0x00c5, all -> 0x00c1 }
            int r17 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r17 >= 0) goto L_0x00be
            r3 = 444(0x1bc, float:6.22E-43)
            r4 = 666(0x29a, float:9.33E-43)
            if (r12 != 0) goto L_0x008a
            if (r1 != 0) goto L_0x008a
            int r14 = r13 % r0
            r14 = r8[r14]     // Catch:{ Exception -> 0x00c5, all -> 0x00c1 }
            com.umlaut.crowd.internal.d4 r15 = com.umlaut.crowd.internal.d4.IPv6     // Catch:{ IOException -> 0x0077 }
            r7 = r16
            a(r2, r7, r14, r15)     // Catch:{ IOException -> 0x0079 }
            r14 = 1
            goto L_0x007c
        L_0x0077:
            r7 = r16
        L_0x0079:
            r12 = 1
            r14 = 0
        L_0x007c:
            if (r14 == 0) goto L_0x008d
            int r15 = a(r7, r10)     // Catch:{ Exception -> 0x00f2, all -> 0x00f0 }
            if (r15 != r4) goto L_0x0086
            r12 = 1
            goto L_0x008d
        L_0x0086:
            if (r15 != r3) goto L_0x008d
            r11 = 1
            goto L_0x008d
        L_0x008a:
            r7 = r16
            r14 = 0
        L_0x008d:
            if (r11 != 0) goto L_0x00af
            int r15 = r13 % r5
            r15 = r6[r15]     // Catch:{ Exception -> 0x00f2, all -> 0x00f0 }
            com.umlaut.crowd.internal.d4 r4 = com.umlaut.crowd.internal.d4.IPv4     // Catch:{ IOException -> 0x009a }
            a(r2, r7, r15, r4)     // Catch:{ IOException -> 0x009a }
            r14 = 1
            goto L_0x009c
        L_0x009a:
            r11 = 1
        L_0x009c:
            if (r14 == 0) goto L_0x00af
            if (r11 == 0) goto L_0x00a2
            if (r12 != 0) goto L_0x00af
        L_0x00a2:
            int r4 = a(r7, r10)     // Catch:{ Exception -> 0x00f2, all -> 0x00f0 }
            if (r4 != r3) goto L_0x00aa
            r11 = 1
            goto L_0x00af
        L_0x00aa:
            r3 = 666(0x29a, float:9.33E-43)
            if (r4 != r3) goto L_0x00af
            r12 = 1
        L_0x00af:
            if (r11 != 0) goto L_0x00bc
            if (r12 != 0) goto L_0x00bc
            int r13 = r13 + 1
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x00bb }
            goto L_0x00bc
        L_0x00bb:
        L_0x00bc:
            r4 = r7
            goto L_0x004c
        L_0x00be:
            r7 = r16
            goto L_0x00ca
        L_0x00c1:
            r0 = move-exception
            r7 = r16
            goto L_0x00f6
        L_0x00c5:
            r0 = move-exception
            r7 = r16
            goto L_0x00fa
        L_0x00c9:
            r7 = r4
        L_0x00ca:
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x00f2, all -> 0x00f0 }
            long r2 = r10.f()     // Catch:{ Exception -> 0x00f2, all -> 0x00f0 }
            long r0 = r0 - r2
            int r1 = (int) r0     // Catch:{ Exception -> 0x00f2, all -> 0x00f0 }
            r10.a((int) r1)     // Catch:{ Exception -> 0x00f2, all -> 0x00f0 }
            java.net.InetAddress[] r0 = r10.d()     // Catch:{ Exception -> 0x00f2, all -> 0x00f0 }
            int r0 = r0.length     // Catch:{ Exception -> 0x00f2, all -> 0x00f0 }
            if (r0 != 0) goto L_0x00e3
            r7.close()
            r1 = 0
            return r1
        L_0x00e3:
            r0 = 0
            r10.a((boolean) r0)     // Catch:{ Exception -> 0x00f2, all -> 0x00f0 }
            com.umlaut.crowd.internal.tb r0 = com.umlaut.crowd.internal.tb.No     // Catch:{ Exception -> 0x00f2, all -> 0x00f0 }
            r10.a((com.umlaut.crowd.internal.tb) r0)     // Catch:{ Exception -> 0x00f2, all -> 0x00f0 }
            r7.close()
            return r10
        L_0x00f0:
            r0 = move-exception
            goto L_0x00f6
        L_0x00f2:
            r0 = move-exception
            goto L_0x00fa
        L_0x00f4:
            r0 = move-exception
            r7 = r4
        L_0x00f6:
            r4 = r7
            goto L_0x0121
        L_0x00f8:
            r0 = move-exception
            r7 = r4
        L_0x00fa:
            r4 = r7
            goto L_0x0101
        L_0x00fc:
            r0 = move-exception
            r3 = 0
            goto L_0x0120
        L_0x00ff:
            r0 = move-exception
            r4 = 0
        L_0x0101:
            java.lang.String r1 = a     // Catch:{ all -> 0x011e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x011e }
            r2.<init>()     // Catch:{ all -> 0x011e }
            java.lang.String r3 = "customQuery: "
            r2.append(r3)     // Catch:{ all -> 0x011e }
            r2.append(r0)     // Catch:{ all -> 0x011e }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x011e }
            android.util.Log.d(r1, r0)     // Catch:{ all -> 0x011e }
            if (r4 == 0) goto L_0x011c
            r4.close()
        L_0x011c:
            r1 = 0
            return r1
        L_0x011e:
            r0 = move-exception
            r3 = r4
        L_0x0120:
            r4 = r3
        L_0x0121:
            if (r4 == 0) goto L_0x0126
            r4.close()
        L_0x0126:
            goto L_0x0128
        L_0x0127:
            throw r0
        L_0x0128:
            goto L_0x0127
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.h2.a(java.lang.String[], java.lang.String[], java.lang.String, int, boolean):com.umlaut.crowd.internal.g2");
    }

    public static g2 b(String str) throws UnknownHostException {
        g2 g2Var = new g2();
        g2Var.a(SystemClock.elapsedRealtime());
        InetAddress[] allByName = InetAddress.getAllByName(str);
        g2Var.a((int) (SystemClock.elapsedRealtime() - g2Var.f()));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (InetAddress inetAddress : allByName) {
            if (inetAddress instanceof Inet6Address) {
                arrayList2.add((Inet6Address) inetAddress);
            } else {
                arrayList.add((Inet4Address) inetAddress);
            }
        }
        g2Var.a((InetAddress[]) arrayList.toArray(new InetAddress[0]));
        g2Var.b((InetAddress[]) arrayList2.toArray(new InetAddress[0]));
        g2Var.a(true);
        return g2Var;
    }

    private static int a(DatagramSocket datagramSocket, g2 g2Var) {
        b a2 = a(datagramSocket);
        if (a2 == null) {
            return 0;
        }
        short s = a2.c;
        if (s == 444) {
            g2Var.a((InetAddress[]) a2.a.toArray(new InetAddress[0]));
            g2Var.a(a2.b);
            return 444;
        } else if (s != 666) {
            return 0;
        } else {
            g2Var.b((InetAddress[]) a2.a.toArray(new InetAddress[0]));
            g2Var.b(a2.b);
            return TTAdConstant.STYLE_SIZE_RADIO_2_3;
        }
    }

    private static void a(String str, DatagramSocket datagramSocket, InetAddress inetAddress, d4 d4Var) throws IOException {
        byte[] a2 = a(str, d4Var, d4Var == d4.IPv6 ? h : g);
        datagramSocket.send(new DatagramPacket(a2, a2.length, inetAddress, 53));
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] a(java.lang.String r7, com.umlaut.crowd.internal.d4 r8, short r9) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            java.io.DataOutputStream r1 = new java.io.DataOutputStream
            r1.<init>(r0)
            r1.writeShort(r9)     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            r9 = 256(0x100, float:3.59E-43)
            r1.writeShort(r9)     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            r9 = 1
            r1.writeShort(r9)     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            r2 = 0
            r1.writeShort(r2)     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            r1.writeShort(r2)     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            r1.writeShort(r2)     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            java.lang.String r3 = "\\."
            java.lang.String[] r7 = r7.split(r3)     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            int r3 = r7.length     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            r4 = 0
        L_0x0028:
            if (r4 >= r3) goto L_0x003c
            r5 = r7[r4]     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            java.lang.String r6 = "UTF-8"
            byte[] r5 = r5.getBytes(r6)     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            int r6 = r5.length     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            r1.writeByte(r6)     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            r1.write(r5)     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            int r4 = r4 + 1
            goto L_0x0028
        L_0x003c:
            r1.writeByte(r2)     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            com.umlaut.crowd.internal.d4 r7 = com.umlaut.crowd.internal.d4.IPv6     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            if (r8 != r7) goto L_0x0046
            r7 = 28
            goto L_0x0047
        L_0x0046:
            r7 = 1
        L_0x0047:
            r1.writeShort(r7)     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            r1.writeShort(r9)     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            byte[] r7 = r0.toByteArray()     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            r1.close()     // Catch:{ IOException -> 0x0054 }
        L_0x0054:
            return r7
        L_0x0055:
            r7 = move-exception
            r1.close()     // Catch:{ IOException -> 0x0059 }
        L_0x0059:
            throw r7
        L_0x005a:
            r1.close()     // Catch:{ IOException -> 0x005d }
        L_0x005d:
            byte[] r7 = r0.toByteArray()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.h2.a(java.lang.String, com.umlaut.crowd.internal.d4, short):byte[]");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0194 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.umlaut.crowd.internal.h2.b a(java.net.DatagramSocket r18) {
        /*
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r0]
            java.net.DatagramPacket r2 = new java.net.DatagramPacket
            r2.<init>(r1, r0)
            java.io.DataInputStream r3 = new java.io.DataInputStream
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream
            r4.<init>(r1)
            r3.<init>(r4)
            r5 = r18
            r5.receive(r2)     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            short r5 = r3.readShort()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r3.readShort()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r3.readShort()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            short r6 = r3.readShort()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r3.readShort()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r3.readShort()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
        L_0x002c:
            byte r7 = r3.readByte()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            java.lang.String r8 = "UTF-8"
            if (r7 <= 0) goto L_0x0048
            byte[] r10 = new byte[r7]     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r9 = 0
        L_0x0037:
            if (r9 >= r7) goto L_0x0042
            byte r11 = r3.readByte()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r10[r9] = r11     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            int r9 = r9 + 1
            goto L_0x0037
        L_0x0042:
            java.lang.String r7 = new java.lang.String     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r7.<init>(r10, r8)     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            goto L_0x002c
        L_0x0048:
            r3.readShort()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r3.readShort()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r7.<init>()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r10.<init>()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r11.<init>()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            java.io.ByteArrayOutputStream r12 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r12.<init>()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r13 = 0
        L_0x0063:
            if (r13 >= r6) goto L_0x0177
            short r14 = r3.readShort()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r15 = 49152(0xc000, float:6.8877E-41)
            r15 = r15 & r14
            int r15 = r15 >>> 14
            r4 = 3
            if (r15 != r4) goto L_0x016c
            r14 = r14 & 16383(0x3fff, float:2.2957E-41)
            byte[] r14 = java.util.Arrays.copyOfRange(r1, r14, r0)     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            java.io.DataInputStream r15 = new java.io.DataInputStream     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            java.io.ByteArrayInputStream r9 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r9.<init>(r14)     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r15.<init>(r9)     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r10.clear()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r11.clear()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r9 = 0
            r14 = 0
        L_0x008a:
            if (r9 != 0) goto L_0x00fd
            byte r0 = r15.readByte()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r4 = r0 & 192(0xc0, float:2.69E-43)
            int r4 = r4 >>> 6
            r17 = r6
            r6 = 3
            if (r4 != r6) goto L_0x00bb
            r0 = r0 & 63
            int r0 = r0 << 8
            byte r4 = r15.readByte()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r4 = r4 & 255(0xff, float:3.57E-43)
            r0 = r0 | r4
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r0 = java.util.Arrays.copyOfRange(r1, r0, r4)     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r15.close()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            java.io.DataInputStream r15 = new java.io.DataInputStream     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r15.<init>(r4)     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            byte r0 = r15.readByte()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
        L_0x00bb:
            if (r0 == 0) goto L_0x00cf
            byte[] r4 = new byte[r0]     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r6 = 0
        L_0x00c0:
            if (r6 >= r0) goto L_0x00cb
            byte r16 = r15.readByte()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r4[r6] = r16     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            int r6 = r6 + 1
            goto L_0x00c0
        L_0x00cb:
            r12.write(r4)     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            goto L_0x00ef
        L_0x00cf:
            short r14 = r3.readShort()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r3.readShort()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r3.readInt()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            short r0 = r3.readShort()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r4 = 0
        L_0x00de:
            if (r4 >= r0) goto L_0x00ee
            byte r6 = r3.readByte()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            java.lang.Byte r6 = java.lang.Byte.valueOf(r6)     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r10.add(r6)     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            int r4 = r4 + 1
            goto L_0x00de
        L_0x00ee:
            r9 = 1
        L_0x00ef:
            java.lang.String r0 = r12.toString(r8)     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r11.add(r0)     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r12.reset()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r6 = r17
            r4 = 3
            goto L_0x008a
        L_0x00fd:
            r17 = r6
            r0 = 1
            if (r14 != r0) goto L_0x0106
            r0 = 444(0x1bc, float:6.22E-43)
            if (r5 == r0) goto L_0x010e
        L_0x0106:
            r0 = 28
            if (r14 != r0) goto L_0x0167
            r0 = 666(0x29a, float:9.33E-43)
            if (r5 != r0) goto L_0x0167
        L_0x010e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r0.<init>()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            java.util.Iterator r4 = r11.iterator()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
        L_0x0117:
            boolean r6 = r4.hasNext()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            if (r6 == 0) goto L_0x0134
            java.lang.Object r6 = r4.next()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            java.lang.String r9 = ""
            boolean r9 = r6.equals(r9)     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            if (r9 != 0) goto L_0x0117
            r0.append(r6)     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            java.lang.String r6 = "."
            r0.append(r6)     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            goto L_0x0117
        L_0x0134:
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            int r4 = r0.length()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r6 = 1
            int r4 = r4 - r6
            r6 = 0
            java.lang.String r0 = r0.substring(r6, r4)     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            int r4 = r10.size()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r9 = 0
        L_0x014a:
            int r14 = r10.size()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            if (r9 >= r14) goto L_0x015f
            java.lang.Object r14 = r10.get(r9)     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            java.lang.Byte r14 = (java.lang.Byte) r14     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            byte r14 = r14.byteValue()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r4[r9] = r14     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            int r9 = r9 + 1
            goto L_0x014a
        L_0x015f:
            java.net.InetAddress r0 = java.net.InetAddress.getByAddress(r0, r4)     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r7.add(r0)     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            goto L_0x0168
        L_0x0167:
            r6 = 0
        L_0x0168:
            r15.close()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            goto L_0x016f
        L_0x016c:
            r17 = r6
            r6 = 0
        L_0x016f:
            int r13 = r13 + 1
            r6 = r17
            r0 = 1024(0x400, float:1.435E-42)
            goto L_0x0063
        L_0x0177:
            com.umlaut.crowd.internal.h2$b r0 = new com.umlaut.crowd.internal.h2$b     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r1 = 0
            r0.<init>()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            java.net.InetAddress r1 = r2.getAddress()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            java.lang.String r1 = r1.getHostAddress()     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r0.b = r1     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r0.a = r7     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r0.c = r5     // Catch:{ Exception -> 0x0194, all -> 0x018f }
            r3.close()     // Catch:{ IOException -> 0x018e }
        L_0x018e:
            return r0
        L_0x018f:
            r0 = move-exception
            r3.close()     // Catch:{ IOException -> 0x0193 }
        L_0x0193:
            throw r0
        L_0x0194:
            r3.close()     // Catch:{ IOException -> 0x0197 }
        L_0x0197:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.h2.a(java.net.DatagramSocket):com.umlaut.crowd.internal.h2$b");
    }

    public static String a(Context context) {
        Network activeNetwork;
        NetworkInfo networkInfo;
        LinkProperties linkProperties;
        StringBuilder sb = new StringBuilder();
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (!(connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkInfo = connectivityManager.getNetworkInfo(activeNetwork)) == null || !networkInfo.isConnected() || (linkProperties = connectivityManager.getLinkProperties(activeNetwork)) == null)) {
                    for (InetAddress hostAddress : linkProperties.getDnsServers()) {
                        sb.append(hostAddress.getHostAddress());
                        sb.append(",");
                    }
                }
            } catch (Exception unused) {
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    public static boolean a(String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return InetAddresses.isNumericAddress(str);
        }
        if (Patterns.IP_ADDRESS.matcher(str).matches()) {
            return true;
        }
        String[] split = str.split("\\.");
        return !Patterns.TOP_LEVEL_DOMAIN.matcher(split[split.length - 1]).matches();
    }
}
