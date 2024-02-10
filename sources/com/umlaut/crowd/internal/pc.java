package com.umlaut.crowd.internal;

import android.net.TrafficStats;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;

public class pc {
    private static final String a = "pc";
    private static String[] b = null;
    private static String[] c = null;
    private static boolean d = true;
    private static Method e;
    private static Method f;
    private static Method g;

    static {
        try {
            Method declaredMethod = TrafficStats.class.getDeclaredMethod("getRxBytes", new Class[]{String.class});
            e = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        try {
            Method declaredMethod2 = TrafficStats.class.getDeclaredMethod("getTxBytes", new Class[]{String.class});
            f = declaredMethod2;
            declaredMethod2.setAccessible(true);
        } catch (NoSuchMethodException unused2) {
        }
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                Method declaredMethod3 = TrafficStats.class.getDeclaredMethod("getMobileIfaces", new Class[0]);
                g = declaredMethod3;
                declaredMethod3.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }
    }

    private static void a() {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if (nextElement != null && nextElement.getName().startsWith("eth")) {
                        String[] strArr = b;
                        if (strArr != null && strArr.length > 0) {
                            int length = strArr.length;
                            int i = 0;
                            while (true) {
                                if (i >= length) {
                                    break;
                                }
                                if (nextElement.getName().equals(strArr[i])) {
                                    break;
                                }
                                i++;
                            }
                        }
                        Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                        boolean z = false;
                        if (inetAddresses != null) {
                            while (inetAddresses.hasMoreElements()) {
                                InetAddress nextElement2 = inetAddresses.nextElement();
                                if (nextElement2 != null && nextElement2.isLinkLocalAddress() && !nextElement2.isLoopbackAddress()) {
                                    z = true;
                                }
                            }
                        }
                        if (z) {
                            arrayList.add(aa.a(nextElement.getName()));
                        }
                    }
                }
            }
        } catch (Exception unused) {
        } finally {
            c = (String[]) arrayList.toArray(new String[arrayList.size()]);
            d = false;
        }
    }

    public static synchronized long b() {
        long j;
        String[] strArr;
        synchronized (pc.class) {
            if (d && ((strArr = c) == null || strArr.length <= 0)) {
                a();
            }
            String[] strArr2 = c;
            j = 0;
            if (strArr2 != null && strArr2.length > 0) {
                for (String a2 : strArr2) {
                    long a3 = a(a2);
                    if (a3 > -1) {
                        j += a3;
                    }
                }
            }
        }
        return j;
    }

    public static synchronized long c() {
        long j;
        String[] strArr;
        synchronized (pc.class) {
            if (d && ((strArr = c) == null || strArr.length <= 0)) {
                a();
            }
            String[] strArr2 = c;
            j = 0;
            if (strArr2 != null && strArr2.length > 0) {
                for (String b2 : strArr2) {
                    long b3 = b(b2);
                    if (b3 > -1) {
                        j += b3;
                    }
                }
            }
        }
        return j;
    }

    private static void d() {
        Method method = g;
        if (method != null) {
            try {
                String[] strArr = (String[]) method.invoke((Object) null, new Object[0]);
                if (strArr != null) {
                    b = strArr;
                }
            } catch (Exception e2) {
                String str = a;
                Log.e(str, "getMobileInterfaces: " + e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    public static synchronized long e() {
        long j;
        synchronized (pc.class) {
            try {
                j = TrafficStats.getMobileRxBytes();
            } catch (Exception e2) {
                Log.e(a, "getMobileRxBytes: " + e2.getMessage());
                j = 0;
            }
            if (j <= 0) {
                String[] strArr = b;
                if (strArr != null) {
                    for (String str : strArr) {
                        long c2 = c("/sys/class/net/" + str + "/statistics/rx_bytes");
                        if (c2 > -1) {
                            j += c2;
                        }
                    }
                }
            } else if (b == null) {
                d();
            }
        }
        return j;
    }

    public static synchronized long f() {
        long j;
        synchronized (pc.class) {
            try {
                j = TrafficStats.getMobileTxBytes();
            } catch (Exception e2) {
                Log.e(a, "getMobileTxBytes: " + e2.getMessage());
                j = 0;
            }
            if (j <= 0) {
                String[] strArr = b;
                if (strArr != null) {
                    for (String str : strArr) {
                        long c2 = c("/sys/class/net/" + str + "/statistics/tx_bytes");
                        if (c2 > -1) {
                            j += c2;
                        }
                    }
                }
            } else if (b == null) {
                d();
            }
        }
        return j;
    }

    public static synchronized long g() {
        long totalRxBytes;
        synchronized (pc.class) {
            totalRxBytes = TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
        }
        return totalRxBytes;
    }

    public static synchronized long h() {
        long totalTxBytes;
        synchronized (pc.class) {
            totalTxBytes = TrafficStats.getTotalTxBytes() - TrafficStats.getMobileTxBytes();
        }
        return totalTxBytes;
    }

    public static long b(String str) {
        Method method = f;
        if (method != null) {
            try {
                return ((Long) method.invoke((Object) null, new Object[]{str})).longValue();
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
        return c("/sys/class/net/" + str + "/statistics/tx_bytes");
    }

    private static long c(String str) {
        String[] a2 = i9.a(str);
        if (a2.length > 0) {
            return Long.parseLong(a2[0]);
        }
        return -1;
    }

    public static long a(String str) {
        Method method = e;
        if (method != null) {
            try {
                return ((Long) method.invoke((Object) null, new Object[]{str})).longValue();
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
        return c("/sys/class/net/" + str + "/statistics/rx_bytes");
    }
}
