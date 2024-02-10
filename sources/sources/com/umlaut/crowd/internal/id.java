package com.umlaut.crowd.internal;

import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.ScheduledExecutorService;

public class id extends x6 {
    public static final String k = "id";
    private static final boolean l = false;
    private static final String m = "google.com";
    /* access modifiers changed from: private */
    public final int h;
    /* access modifiers changed from: private */
    public int i;
    private final SparseArray<Long> j = new SparseArray<>();

    class a implements Runnable {
        final /* synthetic */ ScheduledExecutorService a;
        final /* synthetic */ DatagramSocket b;
        final /* synthetic */ InetAddress c;

        a(ScheduledExecutorService scheduledExecutorService, DatagramSocket datagramSocket, InetAddress inetAddress) {
            this.a = scheduledExecutorService;
            this.b = datagramSocket;
            this.c = inetAddress;
        }

        public void run() {
            if (id.b(id.this) >= id.this.d || id.this.g) {
                this.a.shutdown();
                return;
            }
            try {
                id idVar = id.this;
                idVar.a(this.b, this.c, idVar.h, (short) id.this.i);
                id.this.b.a(id.this.i - 1, ((long) (id.this.i - 1)) * ((long) id.this.e));
            } catch (IOException unused) {
            }
        }
    }

    public id(Context context, w6 w6Var, String str, int i2, int i3, int i4, int i5) {
        this.a = context;
        this.b = w6Var;
        this.c = str;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.h = i5;
    }

    static /* synthetic */ int b(id idVar) {
        int i2 = idVar.i;
        idVar.i = i2 + 1;
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.umlaut.crowd.internal.p4 r11) {
        /*
            r10 = this;
            java.util.concurrent.ScheduledExecutorService r11 = java.util.concurrent.Executors.newSingleThreadScheduledExecutor()
            r7 = 1
            r0 = 0
            java.net.DatagramSocket r8 = new java.net.DatagramSocket     // Catch:{ IOException -> 0x006b, all -> 0x0061 }
            r8.<init>()     // Catch:{ IOException -> 0x006b, all -> 0x0061 }
            int r0 = r10.f     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            r8.setSoTimeout(r0)     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            java.lang.String r0 = r10.c     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            java.net.InetAddress r0 = java.net.InetAddress.getByName(r0)     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            com.umlaut.crowd.internal.w6 r1 = r10.b     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            r1.a()     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            com.umlaut.crowd.internal.id$a r1 = new com.umlaut.crowd.internal.id$a     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            r1.<init>(r11, r8, r0)     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            r2 = 0
            int r0 = r10.e     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            long r4 = (long) r0     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            r0 = r11
            r0.scheduleAtFixedRate(r1, r2, r4, r6)     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            r0 = 0
            r9 = 0
        L_0x002d:
            int r1 = r10.d     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            if (r9 >= r1) goto L_0x0053
            boolean r1 = r10.g     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            if (r1 == 0) goto L_0x0036
            goto L_0x0053
        L_0x0036:
            int[] r1 = r10.a((java.net.DatagramSocket) r8)     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            if (r1 != 0) goto L_0x003d
            goto L_0x0053
        L_0x003d:
            r2 = r1[r0]     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            int r2 = r2 - r7
            long r2 = (long) r2     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            int r4 = r10.e     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            long r4 = (long) r4     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            long r3 = r2 * r4
            r1 = r1[r7]     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            com.umlaut.crowd.internal.w6 r2 = r10.b     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            long r5 = (long) r1     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            r1 = r2
            r2 = r9
            r1.b(r2, r3, r5)     // Catch:{ IOException -> 0x005e, all -> 0x005a }
            int r9 = r9 + 1
            goto L_0x002d
        L_0x0053:
            r8.close()
            r11.shutdown()
            goto L_0x0074
        L_0x005a:
            r0 = move-exception
            r1 = r0
            r0 = r8
            goto L_0x0062
        L_0x005e:
            r0 = r8
            goto L_0x006c
        L_0x0061:
            r1 = move-exception
        L_0x0062:
            if (r0 == 0) goto L_0x0067
            r0.close()
        L_0x0067:
            r11.shutdown()
            throw r1
        L_0x006b:
        L_0x006c:
            if (r0 == 0) goto L_0x0071
            r0.close()
        L_0x0071:
            r11.shutdown()
        L_0x0074:
            boolean r11 = r10.g
            r11 = r11 ^ r7
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.id.a(com.umlaut.crowd.internal.p4):boolean");
    }

    public void a() {
        this.g = true;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0052 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(java.lang.String r7, short r8) {
        /*
            r6 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            java.io.DataOutputStream r1 = new java.io.DataOutputStream
            r1.<init>(r0)
            r1.writeShort(r8)     // Catch:{ IOException -> 0x0052, all -> 0x004d }
            r8 = 256(0x100, float:3.59E-43)
            r1.writeShort(r8)     // Catch:{ IOException -> 0x0052, all -> 0x004d }
            r8 = 1
            r1.writeShort(r8)     // Catch:{ IOException -> 0x0052, all -> 0x004d }
            r2 = 0
            r1.writeShort(r2)     // Catch:{ IOException -> 0x0052, all -> 0x004d }
            r1.writeShort(r2)     // Catch:{ IOException -> 0x0052, all -> 0x004d }
            r1.writeShort(r2)     // Catch:{ IOException -> 0x0052, all -> 0x004d }
            java.lang.String r3 = "\\."
            java.lang.String[] r7 = r7.split(r3)     // Catch:{ IOException -> 0x0052, all -> 0x004d }
            r3 = 0
        L_0x0027:
            int r4 = r7.length     // Catch:{ IOException -> 0x0052, all -> 0x004d }
            if (r3 >= r4) goto L_0x003c
            r4 = r7[r3]     // Catch:{ IOException -> 0x0052, all -> 0x004d }
            java.lang.String r5 = "UTF-8"
            byte[] r4 = r4.getBytes(r5)     // Catch:{ IOException -> 0x0052, all -> 0x004d }
            int r5 = r4.length     // Catch:{ IOException -> 0x0052, all -> 0x004d }
            r1.writeByte(r5)     // Catch:{ IOException -> 0x0052, all -> 0x004d }
            r1.write(r4)     // Catch:{ IOException -> 0x0052, all -> 0x004d }
            int r3 = r3 + 1
            goto L_0x0027
        L_0x003c:
            r1.writeByte(r2)     // Catch:{ IOException -> 0x0052, all -> 0x004d }
            r1.writeShort(r8)     // Catch:{ IOException -> 0x0052, all -> 0x004d }
            r1.writeShort(r8)     // Catch:{ IOException -> 0x0052, all -> 0x004d }
            byte[] r7 = r0.toByteArray()     // Catch:{ IOException -> 0x0052, all -> 0x004d }
            r1.close()     // Catch:{ IOException -> 0x004c }
        L_0x004c:
            return r7
        L_0x004d:
            r7 = move-exception
            r1.close()     // Catch:{ IOException -> 0x0051 }
        L_0x0051:
            throw r7
        L_0x0052:
            r1.close()     // Catch:{ IOException -> 0x0055 }
        L_0x0055:
            byte[] r7 = r0.toByteArray()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.id.a(java.lang.String, short):byte[]");
    }

    /* access modifiers changed from: private */
    public void a(DatagramSocket datagramSocket, InetAddress inetAddress, int i2, short s) throws IOException {
        byte[] a2 = a(m, s);
        DatagramPacket datagramPacket = new DatagramPacket(a2, a2.length, inetAddress, i2);
        this.j.append(s, Long.valueOf(SystemClock.elapsedRealtime()));
        datagramSocket.send(datagramPacket);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x004a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int[] a(java.net.DatagramSocket r10) {
        /*
            r9 = this;
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r0]
            java.net.DatagramPacket r2 = new java.net.DatagramPacket
            r2.<init>(r1, r0)
            java.io.DataInputStream r0 = new java.io.DataInputStream
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream
            r3.<init>(r1)
            r0.<init>(r3)
            r10.receive(r2)     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
            short r10 = r0.readShort()     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
            android.util.SparseArray<java.lang.Long> r3 = r9.j     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
            r4 = 0
            java.lang.Long r6 = java.lang.Long.valueOf(r4)     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
            java.lang.Object r3 = r3.get(r10, r6)     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
            long r6 = r3.longValue()     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
            r3 = 0
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 <= 0) goto L_0x0038
            long r1 = r1 - r6
            int r2 = (int) r1     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
            goto L_0x0039
        L_0x0038:
            r2 = 0
        L_0x0039:
            r1 = 2
            int[] r1 = new int[r1]     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
            r1[r3] = r10     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
            r10 = 1
            r1[r10] = r2     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
            r0.close()     // Catch:{ IOException -> 0x0044 }
        L_0x0044:
            return r1
        L_0x0045:
            r10 = move-exception
            r0.close()     // Catch:{ IOException -> 0x0049 }
        L_0x0049:
            throw r10
        L_0x004a:
            r0.close()     // Catch:{ IOException -> 0x004d }
        L_0x004d:
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.id.a(java.net.DatagramSocket):int[]");
    }
}
