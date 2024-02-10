package com.umlaut.crowd.internal;

import com.facebook.internal.security.CertificateUtil;
import com.umlaut.crowd.InsightCore;
import java.net.InetAddress;
import java.util.ArrayList;

public class de {
    private static final String a = "com.umlaut.crowd.internal.de";
    private static final boolean b = false;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.umlaut.crowd.internal.d[] r0 = com.umlaut.crowd.internal.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.umlaut.crowd.internal.d r1 = com.umlaut.crowd.internal.d.Full     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.internal.d r1 = com.umlaut.crowd.internal.d.Anonymized     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.internal.d r1 = com.umlaut.crowd.internal.d.None     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.de.a.<clinit>():void");
        }
    }

    public static String a(String str) {
        int i;
        if (str.length() == 0 || (i = a.a[InsightCore.getInsightConfig().b2().ordinal()]) == 1) {
            return str;
        }
        if (i != 2) {
            return "";
        }
        int a2 = InsightCore.getInsightConfig().a2();
        if (str.length() == 17 && a2 + 5 < 17) {
            try {
                int length = (str.length() - (str.split(CertificateUtil.DELIMITER).length - 1)) - a2;
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                for (int i3 = 0; i3 < str.length(); i3++) {
                    char charAt = str.charAt(i3);
                    if (charAt != ':') {
                        int i4 = i2 + 1;
                        if (i2 >= length) {
                            charAt = 'x';
                        }
                        i2 = i4;
                    }
                    sb.append(charAt);
                }
                return sb.toString();
            } catch (Exception unused) {
            }
        }
        return "xx:xx:xx:xx:xx:xx";
    }

    private static int[] a(long j) {
        return new int[]{(int) ((j >> 24) & 255), (int) ((j >> 16) & 255), (int) ((j >> 8) & 255), (int) (j & 255)};
    }

    public static b1 b(String str) {
        b1 b1Var = b1.Unknown;
        if (str == null || str.length() <= 0) {
            return b1Var;
        }
        if (str.equalsIgnoreCase("permanent")) {
            return b1.Permanent;
        }
        if (str.equalsIgnoreCase("reachable")) {
            return b1.Reachable;
        }
        if (str.equalsIgnoreCase("noarp")) {
            return b1.Noarp;
        }
        if (str.equalsIgnoreCase("none")) {
            return b1.None;
        }
        if (str.equalsIgnoreCase("stale")) {
            return b1.Stale;
        }
        if (str.equalsIgnoreCase("incomplete")) {
            return b1.Incomplete;
        }
        if (str.equalsIgnoreCase("delay")) {
            return b1.Delay;
        }
        return str.equalsIgnoreCase("probe") ? b1.Probe : b1Var;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: short} */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        r10 = a(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        r3 = com.umlaut.crowd.internal.de.a.a[com.umlaut.crowd.InsightCore.getInsightConfig().Z1().ordinal()];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        if (r3 == 1) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        if (r3 == 2) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        if (r2 == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        r3 = "\\.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        if (r2 == false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        r0 = ".";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r3 = r8.split(r3);
        r6 = new java.lang.StringBuilder();
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0054, code lost:
        if (r2 == false) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0056, code lost:
        r9 = com.umlaut.crowd.InsightCore.getInsightConfig().Y1();
        r8 = ((java.net.Inet6Address) java.net.InetAddress.getByName(r8)).getAddress();
        r0 = r8.length - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006c, code lost:
        if (r0 < (r8.length - r9)) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006e, code lost:
        r8[r0] = 0;
        r0 = r0 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
        r6.append(((java.net.Inet6Address) java.net.InetAddress.getByAddress(r8)).getHostAddress());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0082, code lost:
        if (r7 >= r9.length) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0084, code lost:
        r6.append(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0089, code lost:
        if (r9[r7] != 0) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008b, code lost:
        r8 = "xxx";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008f, code lost:
        r8 = r3[r7];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0091, code lost:
        r6.append(r8);
        r7 = r7 + 1;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ae, code lost:
        return r6.toString() + "/" + r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00af, code lost:
        r8 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b5, code lost:
        if (r2 != false) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b7, code lost:
        r9 = "xxxx::/";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bb, code lost:
        r9 = "xxx.xxx.xxx.xxx/";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00be, code lost:
        r8.append(r9);
        r8.append(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c8, code lost:
        return r8.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00db, code lost:
        return r8 + "/" + r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (r10 > 0) goto L_0x0026;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r8, int[] r9, short r10) {
        /*
            java.lang.String r0 = ":"
            java.lang.String r1 = ""
            if (r8 == 0) goto L_0x00dc
            java.lang.String r2 = r8.trim()
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0012
            goto L_0x00dc
        L_0x0012:
            java.net.InetAddress r2 = java.net.InetAddress.getByName(r8)     // Catch:{ Exception -> 0x0019 }
            boolean r2 = r2 instanceof java.net.Inet6Address     // Catch:{ Exception -> 0x0019 }
            goto L_0x001d
        L_0x0019:
            boolean r2 = r8.contains(r0)
        L_0x001d:
            if (r2 == 0) goto L_0x0022
            if (r10 <= 0) goto L_0x0022
            goto L_0x0026
        L_0x0022:
            int r10 = a((int[]) r9)
        L_0x0026:
            int[] r3 = com.umlaut.crowd.internal.de.a.a
            com.umlaut.crowd.IC r4 = com.umlaut.crowd.InsightCore.getInsightConfig()
            com.umlaut.crowd.internal.d r4 = r4.Z1()
            int r4 = r4.ordinal()
            r3 = r3[r4]
            java.lang.String r4 = "/"
            r5 = 1
            if (r3 == r5) goto L_0x00c9
            r6 = 2
            if (r3 == r6) goto L_0x003f
            return r1
        L_0x003f:
            if (r2 == 0) goto L_0x0043
            r3 = r0
            goto L_0x0045
        L_0x0043:
            java.lang.String r3 = "\\."
        L_0x0045:
            if (r2 == 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            java.lang.String r0 = "."
        L_0x004a:
            java.lang.String[] r3 = r8.split(r3)     // Catch:{ Exception -> 0x00af }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00af }
            r6.<init>()     // Catch:{ Exception -> 0x00af }
            r7 = 0
            if (r2 == 0) goto L_0x0081
            com.umlaut.crowd.IC r9 = com.umlaut.crowd.InsightCore.getInsightConfig()     // Catch:{ Exception -> 0x00af }
            int r9 = r9.Y1()     // Catch:{ Exception -> 0x00af }
            java.net.InetAddress r8 = java.net.InetAddress.getByName(r8)     // Catch:{ Exception -> 0x00af }
            java.net.Inet6Address r8 = (java.net.Inet6Address) r8     // Catch:{ Exception -> 0x00af }
            byte[] r8 = r8.getAddress()     // Catch:{ Exception -> 0x00af }
            int r0 = r8.length     // Catch:{ Exception -> 0x00af }
            int r0 = r0 - r5
        L_0x006a:
            int r1 = r8.length     // Catch:{ Exception -> 0x00af }
            int r1 = r1 - r9
            if (r0 < r1) goto L_0x0073
            r8[r0] = r7     // Catch:{ Exception -> 0x00af }
            int r0 = r0 + -1
            goto L_0x006a
        L_0x0073:
            java.net.InetAddress r8 = java.net.InetAddress.getByAddress(r8)     // Catch:{ Exception -> 0x00af }
            java.net.Inet6Address r8 = (java.net.Inet6Address) r8     // Catch:{ Exception -> 0x00af }
            java.lang.String r8 = r8.getHostAddress()     // Catch:{ Exception -> 0x00af }
            r6.append(r8)     // Catch:{ Exception -> 0x00af }
            goto L_0x0098
        L_0x0081:
            int r8 = r9.length     // Catch:{ Exception -> 0x00af }
            if (r7 >= r8) goto L_0x0098
            r6.append(r1)     // Catch:{ Exception -> 0x00af }
            r8 = r9[r7]     // Catch:{ Exception -> 0x00af }
            if (r8 != 0) goto L_0x008f
            java.lang.String r8 = "xxx"
            goto L_0x0091
        L_0x008f:
            r8 = r3[r7]     // Catch:{ Exception -> 0x00af }
        L_0x0091:
            r6.append(r8)     // Catch:{ Exception -> 0x00af }
            int r7 = r7 + 1
            r1 = r0
            goto L_0x0081
        L_0x0098:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00af }
            r8.<init>()     // Catch:{ Exception -> 0x00af }
            java.lang.String r9 = r6.toString()     // Catch:{ Exception -> 0x00af }
            r8.append(r9)     // Catch:{ Exception -> 0x00af }
            r8.append(r4)     // Catch:{ Exception -> 0x00af }
            r8.append(r10)     // Catch:{ Exception -> 0x00af }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00af }
            return r8
        L_0x00af:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            if (r2 == 0) goto L_0x00bb
            java.lang.String r9 = "xxxx::/"
            goto L_0x00be
        L_0x00bb:
            java.lang.String r9 = "xxx.xxx.xxx.xxx/"
        L_0x00be:
            r8.append(r9)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            return r8
        L_0x00c9:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r8)
            r9.append(r4)
            r9.append(r10)
            java.lang.String r8 = r9.toString()
            return r8
        L_0x00dc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.de.a(java.lang.String, int[], short):java.lang.String");
    }

    public static ArrayList<c1> a() {
        ArrayList<c1> arrayList = new ArrayList<>();
        String[] a2 = i9.a("/proc/net/arp");
        if (a2.length > 1) {
            for (int i = 1; i < a2.length; i++) {
                String str = a2[i];
                if (!str.contains("00:00:00:00:00:00")) {
                    String[] split = str.split(" +");
                    if (split.length > 3) {
                        String str2 = split[0];
                        String str3 = split[3];
                        c1 c1Var = new c1();
                        c1Var.MacAddress = str3;
                        c1Var.IpAddress = str2;
                        c1Var.IpAddress_Full = str2;
                        arrayList.add(c1Var);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:22|23|24|33) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ca, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r0.shutdown();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d4, code lost:
        r1.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00d8, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return r1.a();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x00cc */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, com.umlaut.crowd.internal.c1> a(java.lang.String r16, com.umlaut.crowd.internal.c4 r17) {
        /*
            r0 = r17
            if (r0 != 0) goto L_0x0006
            r0 = 0
            return r0
        L_0x0006:
            int[] r1 = r0.a
            r2 = 0
            r1 = r1[r2]
            double r3 = (double) r1
            r5 = 4643211215818981376(0x4070000000000000, double:256.0)
            r7 = 4613937818241073152(0x4008000000000000, double:3.0)
            double r9 = java.lang.Math.pow(r5, r7)
            java.lang.Double.isNaN(r3)
            double r3 = r3 * r9
            long r3 = (long) r3
            int[] r1 = r0.a
            r9 = 1
            r1 = r1[r9]
            double r10 = (double) r1
            r12 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r14 = java.lang.Math.pow(r5, r12)
            java.lang.Double.isNaN(r10)
            double r10 = r10 * r14
            long r10 = (long) r10
            long r3 = r3 + r10
            int[] r1 = r0.a
            r10 = 2
            r11 = r1[r10]
            int r11 = r11 * 256
            long r14 = (long) r11
            long r3 = r3 + r14
            r11 = 3
            r1 = r1[r11]
            long r14 = (long) r1
            long r3 = r3 + r14
            int[] r1 = r0.b
            r1 = r1[r2]
            double r14 = (double) r1
            double r7 = java.lang.Math.pow(r5, r7)
            java.lang.Double.isNaN(r14)
            double r14 = r14 * r7
            long r7 = (long) r14
            int[] r1 = r0.b
            r1 = r1[r9]
            double r14 = (double) r1
            double r5 = java.lang.Math.pow(r5, r12)
            java.lang.Double.isNaN(r14)
            double r14 = r14 * r5
            long r5 = (long) r14
            long r7 = r7 + r5
            int[] r0 = r0.b
            r1 = r0[r10]
            int r1 = r1 * 256
            long r5 = (long) r1
            long r7 = r7 + r5
            r0 = r0[r11]
            long r0 = (long) r0
            long r7 = r7 + r0
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newCachedThreadPool()
            long r5 = r7 - r3
            int r1 = (int) r5
            int r5 = com.umlaut.crowd.threads.ThreadManager.e
            int r1 = r1 / r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            long r9 = (long) r1
            long r11 = r3 + r9
        L_0x0078:
            if (r2 >= r5) goto L_0x009a
            int[] r1 = a((long) r11)
            int[] r3 = a((long) r3)
            com.umlaut.crowd.internal.he r4 = new com.umlaut.crowd.internal.he
            r4.<init>(r3, r1)
            r6.add(r4)
            r3 = 1
            long r3 = r3 + r11
            long r11 = r11 + r9
            int r1 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r1 > 0) goto L_0x0096
            int r1 = r2 + 2
            if (r1 != r5) goto L_0x0097
        L_0x0096:
            r11 = r7
        L_0x0097:
            int r2 = r2 + 1
            goto L_0x0078
        L_0x009a:
            com.umlaut.crowd.internal.ge r1 = new com.umlaut.crowd.internal.ge
            r2 = 2147483647(0x7fffffff, float:NaN)
            r3 = r16
            r1.<init>(r3, r2)
            r1.start()     // Catch:{ InterruptedException -> 0x00cc }
            java.util.List r2 = r0.invokeAll(r6)     // Catch:{ InterruptedException -> 0x00cc }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ InterruptedException -> 0x00cc }
        L_0x00af:
            boolean r3 = r2.hasNext()     // Catch:{ InterruptedException -> 0x00cc }
            if (r3 == 0) goto L_0x00c5
            java.lang.Object r3 = r2.next()     // Catch:{ InterruptedException -> 0x00cc }
            java.util.concurrent.Future r3 = (java.util.concurrent.Future) r3     // Catch:{ InterruptedException -> 0x00cc }
            java.lang.Object r3 = r3.get()     // Catch:{ ExecutionException -> 0x00af }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ ExecutionException -> 0x00af }
            r3.intValue()     // Catch:{ ExecutionException -> 0x00af }
            goto L_0x00af
        L_0x00c5:
            java.util.Map r0 = r1.a()
            goto L_0x00d3
        L_0x00ca:
            r0 = move-exception
            goto L_0x00d4
        L_0x00cc:
            r0.shutdown()     // Catch:{ all -> 0x00ca }
            java.util.Map r0 = r1.a()
        L_0x00d3:
            return r0
        L_0x00d4:
            r1.a()
            goto L_0x00d9
        L_0x00d8:
            throw r0
        L_0x00d9:
            goto L_0x00d8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.de.a(java.lang.String, com.umlaut.crowd.internal.c4):java.util.Map");
    }

    private static int a(int[] iArr) {
        int i = 0;
        try {
            byte[] address = InetAddress.getByAddress(new byte[]{(byte) iArr[0], (byte) iArr[1], (byte) iArr[2], (byte) iArr[3]}).getAddress();
            int length = address.length;
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            while (i2 < length) {
                try {
                    byte b2 = address[i2];
                    int i4 = 128;
                    for (int i5 = 0; i5 < 8; i5++) {
                        if ((b2 & i4) == 0) {
                            z = true;
                        } else if (!z) {
                            i3++;
                        } else {
                            throw new IllegalArgumentException("Invalid netmask.");
                        }
                        i4 >>>= 1;
                    }
                    i2++;
                } catch (Exception unused) {
                    i = i3;
                    return i;
                }
            }
            return i3;
        } catch (Exception unused2) {
            return i;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0067 A[Catch:{ Exception -> 0x011e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.umlaut.crowd.internal.c4 a(java.lang.String r16, java.lang.String r17) {
        /*
            r0 = r16
            r1 = r17
            java.lang.String r2 = "\\."
            r3 = 4
            r4 = 3
            r5 = 0
            r6 = 2
            r7 = 1
            if (r1 == 0) goto L_0x0127
            boolean r9 = r17.isEmpty()
            if (r9 != 0) goto L_0x0127
            java.lang.String[] r9 = r1.split(r2)
            int[] r10 = new int[r3]
            r11 = r9[r5]
            int r11 = java.lang.Integer.parseInt(r11)
            r10[r5] = r11
            r11 = r9[r7]
            int r11 = java.lang.Integer.parseInt(r11)
            r10[r7] = r11
            r11 = r9[r6]
            int r11 = java.lang.Integer.parseInt(r11)
            r10[r6] = r11
            r9 = r9[r4]
            int r9 = java.lang.Integer.parseInt(r9)
            r10[r4] = r9
            if (r0 == 0) goto L_0x0046
            boolean r9 = r16.isEmpty()     // Catch:{ Exception -> 0x0120 }
            if (r9 != 0) goto L_0x0046
            java.net.NetworkInterface r0 = java.net.NetworkInterface.getByName(r16)     // Catch:{ Exception -> 0x0120 }
            goto L_0x004e
        L_0x0046:
            java.net.InetAddress r0 = java.net.InetAddress.getByName(r17)     // Catch:{ Exception -> 0x0120 }
            java.net.NetworkInterface r0 = java.net.NetworkInterface.getByInetAddress(r0)     // Catch:{ Exception -> 0x0120 }
        L_0x004e:
            if (r0 == 0) goto L_0x0261
            java.util.List r9 = r0.getInterfaceAddresses()     // Catch:{ Exception -> 0x0120 }
            if (r9 == 0) goto L_0x0261
            java.util.List r0 = r0.getInterfaceAddresses()     // Catch:{ Exception -> 0x0120 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0120 }
            r9 = -1
            r8 = 0
            r11 = -1
        L_0x0061:
            boolean r12 = r0.hasNext()     // Catch:{ Exception -> 0x011e }
            if (r12 == 0) goto L_0x0116
            java.lang.Object r12 = r0.next()     // Catch:{ Exception -> 0x011e }
            java.net.InterfaceAddress r12 = (java.net.InterfaceAddress) r12     // Catch:{ Exception -> 0x011e }
            if (r12 == 0) goto L_0x0100
            java.net.InetAddress r13 = r12.getAddress()     // Catch:{ Exception -> 0x011e }
            if (r13 == 0) goto L_0x0100
            java.net.InetAddress r13 = r12.getBroadcast()     // Catch:{ Exception -> 0x011e }
            if (r13 == 0) goto L_0x0100
            java.lang.String r13 = r12.toString()     // Catch:{ Exception -> 0x011e }
            boolean r13 = r13.contains(r1)     // Catch:{ Exception -> 0x011e }
            if (r13 == 0) goto L_0x0100
            short r13 = r12.getNetworkPrefixLength()     // Catch:{ Exception -> 0x011e }
            int r13 = 32 - r13
            int r13 = r9 << r13
            int[] r14 = new int[r3]     // Catch:{ Exception -> 0x011e }
            int r15 = r13 >>> 24
            r14[r5] = r15     // Catch:{ Exception -> 0x011e }
            int r15 = r13 >> 16
            r15 = r15 & 255(0xff, float:3.57E-43)
            r14[r7] = r15     // Catch:{ Exception -> 0x011e }
            int r15 = r13 >> 8
            r15 = r15 & 255(0xff, float:3.57E-43)
            r14[r6] = r15     // Catch:{ Exception -> 0x011e }
            r13 = r13 & 255(0xff, float:3.57E-43)
            r14[r4] = r13     // Catch:{ Exception -> 0x011e }
            com.umlaut.crowd.internal.c4 r13 = new com.umlaut.crowd.internal.c4     // Catch:{ Exception -> 0x011e }
            r13.<init>()     // Catch:{ Exception -> 0x011e }
            r13.c = r14     // Catch:{ Exception -> 0x00fd }
            java.net.InetAddress r8 = r12.getBroadcast()     // Catch:{ Exception -> 0x00fd }
            java.lang.String r8 = r8.getHostAddress()     // Catch:{ Exception -> 0x00fd }
            java.lang.String[] r8 = r8.split(r2)     // Catch:{ Exception -> 0x00fd }
            int[] r12 = new int[r3]     // Catch:{ Exception -> 0x00fd }
            r15 = r8[r5]     // Catch:{ Exception -> 0x00fd }
            int r15 = java.lang.Integer.parseInt(r15)     // Catch:{ Exception -> 0x00fd }
            r12[r5] = r15     // Catch:{ Exception -> 0x00fd }
            r15 = r8[r7]     // Catch:{ Exception -> 0x00fd }
            int r15 = java.lang.Integer.parseInt(r15)     // Catch:{ Exception -> 0x00fd }
            r12[r7] = r15     // Catch:{ Exception -> 0x00fd }
            r15 = r8[r6]     // Catch:{ Exception -> 0x00fd }
            int r15 = java.lang.Integer.parseInt(r15)     // Catch:{ Exception -> 0x00fd }
            r12[r6] = r15     // Catch:{ Exception -> 0x00fd }
            r8 = r8[r4]     // Catch:{ Exception -> 0x00fd }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ Exception -> 0x00fd }
            r12[r4] = r8     // Catch:{ Exception -> 0x00fd }
            r13.b = r12     // Catch:{ Exception -> 0x00fd }
            int[] r8 = new int[r3]     // Catch:{ Exception -> 0x00fd }
            r12 = r10[r5]     // Catch:{ Exception -> 0x00fd }
            r15 = r14[r5]     // Catch:{ Exception -> 0x00fd }
            r12 = r12 & r15
            r8[r5] = r12     // Catch:{ Exception -> 0x00fd }
            r12 = r10[r7]     // Catch:{ Exception -> 0x00fd }
            r15 = r14[r7]     // Catch:{ Exception -> 0x00fd }
            r12 = r12 & r15
            r8[r7] = r12     // Catch:{ Exception -> 0x00fd }
            r12 = r10[r6]     // Catch:{ Exception -> 0x00fd }
            r15 = r14[r6]     // Catch:{ Exception -> 0x00fd }
            r12 = r12 & r15
            r8[r6] = r12     // Catch:{ Exception -> 0x00fd }
            r12 = r10[r4]     // Catch:{ Exception -> 0x00fd }
            r14 = r14[r4]     // Catch:{ Exception -> 0x00fd }
            r12 = r12 & r14
            r8[r4] = r12     // Catch:{ Exception -> 0x00fd }
            r13.a = r8     // Catch:{ Exception -> 0x00fd }
            r8 = r13
            goto L_0x0061
        L_0x00fd:
            r0 = move-exception
            r8 = r13
            goto L_0x0122
        L_0x0100:
            if (r12 == 0) goto L_0x0061
            java.net.InetAddress r13 = r12.getAddress()     // Catch:{ Exception -> 0x011e }
            if (r13 == 0) goto L_0x0061
            java.net.InetAddress r13 = r12.getAddress()     // Catch:{ Exception -> 0x011e }
            boolean r13 = r13 instanceof java.net.Inet6Address     // Catch:{ Exception -> 0x011e }
            if (r13 == 0) goto L_0x0061
            short r11 = r12.getNetworkPrefixLength()     // Catch:{ Exception -> 0x011e }
            goto L_0x0061
        L_0x0116:
            if (r8 == 0) goto L_0x0262
            if (r11 <= 0) goto L_0x0262
            r8.d = r11     // Catch:{ Exception -> 0x011e }
            goto L_0x0262
        L_0x011e:
            r0 = move-exception
            goto L_0x0122
        L_0x0120:
            r0 = move-exception
            r8 = 0
        L_0x0122:
            r0.printStackTrace()
            goto L_0x0262
        L_0x0127:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r9 = "ifconfig "
            r1.<init>(r9)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String[] r0 = com.umlaut.crowd.internal.i9.b(r0)
            int r1 = r0.length
            if (r1 <= r7) goto L_0x0261
            r1 = r0[r7]
            java.lang.String r1 = r1.trim()
            java.lang.String r9 = " "
            java.lang.String[] r1 = r1.split(r9)
            int r10 = r1.length
            java.lang.String r11 = ""
            r12 = r11
            r13 = r12
            r14 = 0
        L_0x014e:
            if (r14 >= r10) goto L_0x0174
            r15 = r1[r14]
            if (r15 == 0) goto L_0x0171
            java.lang.String r8 = "addr:"
            boolean r8 = r15.contains(r8)
            if (r8 == 0) goto L_0x015e
            r11 = r15
            goto L_0x0171
        L_0x015e:
            java.lang.String r8 = "Bcast:"
            boolean r8 = r15.contains(r8)
            if (r8 == 0) goto L_0x0168
            r12 = r15
            goto L_0x0171
        L_0x0168:
            java.lang.String r8 = "Mask:"
            boolean r8 = r15.contains(r8)
            if (r8 == 0) goto L_0x0171
            r13 = r15
        L_0x0171:
            int r14 = r14 + 1
            goto L_0x014e
        L_0x0174:
            int r1 = r0.length
            if (r1 <= r6) goto L_0x0188
            r1 = r0[r6]
            java.lang.String r8 = "inet6"
            boolean r1 = r1.contains(r8)
            if (r1 == 0) goto L_0x0188
            r0 = r0[r6]
            java.lang.String[] r0 = r0.split(r9)
            goto L_0x0189
        L_0x0188:
            r0 = 0
        L_0x0189:
            java.lang.String r1 = "0"
            if (r0 == 0) goto L_0x01a9
            int r8 = r0.length
            if (r8 <= 0) goto L_0x01a9
            int r8 = r0.length
            r9 = 0
        L_0x0192:
            if (r9 >= r8) goto L_0x01a9
            r10 = r0[r9]
            if (r10 == 0) goto L_0x01a6
            java.lang.String r14 = "/"
            boolean r15 = r10.contains(r14)
            if (r15 == 0) goto L_0x01a6
            java.lang.String[] r1 = r10.split(r14)
            r1 = r1[r7]
        L_0x01a6:
            int r9 = r9 + 1
            goto L_0x0192
        L_0x01a9:
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L_0x0261
            boolean r0 = r12.isEmpty()
            if (r0 != 0) goto L_0x0261
            boolean r0 = r13.isEmpty()
            if (r0 != 0) goto L_0x0261
            java.lang.String r0 = ":"
            java.lang.String[] r8 = r13.split(r0)
            r8 = r8[r7]
            java.lang.String[] r9 = r12.split(r0)
            r9 = r9[r7]
            java.lang.String[] r0 = r11.split(r0)
            r0 = r0[r7]
            com.umlaut.crowd.internal.c4 r10 = new com.umlaut.crowd.internal.c4     // Catch:{ Exception -> 0x0261 }
            r10.<init>()     // Catch:{ Exception -> 0x0261 }
            java.lang.String[] r8 = r8.split(r2)     // Catch:{ Exception -> 0x025f }
            int[] r11 = new int[r3]     // Catch:{ Exception -> 0x025f }
            r12 = r8[r5]     // Catch:{ Exception -> 0x025f }
            int r12 = java.lang.Integer.parseInt(r12)     // Catch:{ Exception -> 0x025f }
            r11[r5] = r12     // Catch:{ Exception -> 0x025f }
            r12 = r8[r7]     // Catch:{ Exception -> 0x025f }
            int r12 = java.lang.Integer.parseInt(r12)     // Catch:{ Exception -> 0x025f }
            r11[r7] = r12     // Catch:{ Exception -> 0x025f }
            r12 = r8[r6]     // Catch:{ Exception -> 0x025f }
            int r12 = java.lang.Integer.parseInt(r12)     // Catch:{ Exception -> 0x025f }
            r11[r6] = r12     // Catch:{ Exception -> 0x025f }
            r8 = r8[r4]     // Catch:{ Exception -> 0x025f }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ Exception -> 0x025f }
            r11[r4] = r8     // Catch:{ Exception -> 0x025f }
            r10.c = r11     // Catch:{ Exception -> 0x025f }
            java.lang.String[] r8 = r9.split(r2)     // Catch:{ Exception -> 0x025f }
            int[] r9 = new int[r3]     // Catch:{ Exception -> 0x025f }
            r11 = r8[r5]     // Catch:{ Exception -> 0x025f }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ Exception -> 0x025f }
            r9[r5] = r11     // Catch:{ Exception -> 0x025f }
            r11 = r8[r7]     // Catch:{ Exception -> 0x025f }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ Exception -> 0x025f }
            r9[r7] = r11     // Catch:{ Exception -> 0x025f }
            r11 = r8[r6]     // Catch:{ Exception -> 0x025f }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ Exception -> 0x025f }
            r9[r6] = r11     // Catch:{ Exception -> 0x025f }
            r8 = r8[r4]     // Catch:{ Exception -> 0x025f }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ Exception -> 0x025f }
            r9[r4] = r8     // Catch:{ Exception -> 0x025f }
            r10.b = r9     // Catch:{ Exception -> 0x025f }
            java.lang.String[] r0 = r0.split(r2)     // Catch:{ Exception -> 0x025f }
            int[] r2 = new int[r3]     // Catch:{ Exception -> 0x025f }
            r3 = r0[r5]     // Catch:{ Exception -> 0x025f }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x025f }
            int[] r8 = r10.c     // Catch:{ Exception -> 0x025f }
            r8 = r8[r5]     // Catch:{ Exception -> 0x025f }
            r3 = r3 & r8
            r2[r5] = r3     // Catch:{ Exception -> 0x025f }
            r3 = r0[r7]     // Catch:{ Exception -> 0x025f }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x025f }
            int[] r5 = r10.c     // Catch:{ Exception -> 0x025f }
            r5 = r5[r7]     // Catch:{ Exception -> 0x025f }
            r3 = r3 & r5
            r2[r7] = r3     // Catch:{ Exception -> 0x025f }
            r0 = r0[r6]     // Catch:{ Exception -> 0x025f }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x025f }
            int[] r3 = r10.c     // Catch:{ Exception -> 0x025f }
            r3 = r3[r6]     // Catch:{ Exception -> 0x025f }
            r0 = r0 & r3
            r2[r6] = r0     // Catch:{ Exception -> 0x025f }
            r2[r4] = r7     // Catch:{ Exception -> 0x025f }
            r10.a = r2     // Catch:{ Exception -> 0x025f }
            java.lang.Short r0 = java.lang.Short.valueOf(r1)     // Catch:{ Exception -> 0x025f }
            short r0 = r0.shortValue()     // Catch:{ Exception -> 0x025f }
            r10.d = r0     // Catch:{ Exception -> 0x025f }
        L_0x025f:
            r8 = r10
            goto L_0x0262
        L_0x0261:
            r8 = 0
        L_0x0262:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.de.a(java.lang.String, java.lang.String):com.umlaut.crowd.internal.c4");
    }
}
