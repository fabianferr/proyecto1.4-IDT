package com.pgl.ssdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.RouteInfo;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;

public class f {
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00e2, code lost:
        if (r8.length() == 0) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e7, code lost:
        return r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String a(android.content.Context r8) {
        /*
            java.lang.String r0 = "chmod 600 "
            java.lang.String r1 = "chmod 777 "
            java.lang.String r2 = "/cid"
            java.lang.Class<com.pgl.ssdk.f> r3 = com.pgl.ssdk.f.class
            monitor-enter(r3)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            r4.<init>()     // Catch:{ all -> 0x00da }
            java.io.File r5 = r8.getFilesDir()     // Catch:{ all -> 0x00da }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x00da }
            r4.append(r5)     // Catch:{ all -> 0x00da }
            r4.append(r2)     // Catch:{ all -> 0x00da }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x00da }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x00da }
            r4.<init>(r2)     // Catch:{ all -> 0x00da }
            boolean r4 = r4.exists()     // Catch:{ all -> 0x00da }
            if (r4 == 0) goto L_0x0057
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            r4.<init>(r1)     // Catch:{ all -> 0x00da }
            r4.append(r2)     // Catch:{ all -> 0x00da }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x00da }
            a((java.lang.String) r1)     // Catch:{ all -> 0x00da }
            java.lang.String r1 = a((java.lang.String) r2)     // Catch:{ all -> 0x00da }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            r4.<init>(r0)     // Catch:{ all -> 0x00da }
            r4.append(r2)     // Catch:{ all -> 0x00da }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x00da }
            a((java.lang.String) r0)     // Catch:{ all -> 0x00da }
            if (r1 == 0) goto L_0x0057
            int r0 = r1.length()     // Catch:{ all -> 0x00da }
            if (r0 <= 0) goto L_0x0057
            monitor-exit(r3)
            return r1
        L_0x0057:
            android.content.res.Resources r8 = r8.getResources()     // Catch:{ all -> 0x00da }
            android.content.res.AssetManager r8 = r8.getAssets()     // Catch:{ all -> 0x00da }
            java.lang.String r0 = "cid"
            java.io.InputStream r8 = r8.open(r0)     // Catch:{ all -> 0x00da }
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x00da }
            r0.<init>()     // Catch:{ all -> 0x00da }
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r4 = new byte[r1]     // Catch:{ all -> 0x00da }
        L_0x006e:
            r5 = 0
            int r6 = r8.read(r4, r5, r1)     // Catch:{ all -> 0x00da }
            r7 = -1
            if (r6 == r7) goto L_0x007a
            r0.write(r4, r5, r6)     // Catch:{ all -> 0x00da }
            goto L_0x006e
        L_0x007a:
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ all -> 0x00da }
            r8.<init>(r2)     // Catch:{ all -> 0x00da }
            byte[] r0 = r0.toByteArray()     // Catch:{ all -> 0x00da }
            r8.write(r0)     // Catch:{ all -> 0x00da }
            r8.close()     // Catch:{ all -> 0x00da }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            r8.<init>()     // Catch:{ all -> 0x00da }
            java.lang.String r0 = "chmod 777 "
            r8.append(r0)     // Catch:{ all -> 0x00da }
            r8.append(r2)     // Catch:{ all -> 0x00da }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00da }
            a((java.lang.String) r8)     // Catch:{ all -> 0x00da }
            java.lang.String r8 = a((java.lang.String) r2)     // Catch:{ all -> 0x00da }
            if (r8 == 0) goto L_0x00a9
            int r0 = r8.length()     // Catch:{ all -> 0x00da }
            if (r0 != 0) goto L_0x00c5
        L_0x00a9:
            java.io.RandomAccessFile r8 = new java.io.RandomAccessFile     // Catch:{ all -> 0x00da }
            java.lang.String r0 = "rw"
            r8.<init>(r2, r0)     // Catch:{ all -> 0x00da }
            r0 = 1
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x00da }
            r1 = 2
            r0[r5] = r1     // Catch:{ all -> 0x00da }
            r4 = 16
            r8.seek(r4)     // Catch:{ all -> 0x00da }
            r8.write(r0)     // Catch:{ all -> 0x00da }
            r8.close()     // Catch:{ all -> 0x00da }
            java.lang.String r8 = a((java.lang.String) r2)     // Catch:{ all -> 0x00da }
        L_0x00c5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            r0.<init>()     // Catch:{ all -> 0x00da }
            java.lang.String r1 = "chmod 600 "
            r0.append(r1)     // Catch:{ all -> 0x00da }
            r0.append(r2)     // Catch:{ all -> 0x00da }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00da }
            a((java.lang.String) r0)     // Catch:{ all -> 0x00da }
            goto L_0x00dc
        L_0x00da:
            java.lang.String r8 = "0[<!>]EXCEPTION[<!>]"
        L_0x00dc:
            if (r8 == 0) goto L_0x00e4
            int r0 = r8.length()     // Catch:{ all -> 0x00e8 }
            if (r0 != 0) goto L_0x00e6
        L_0x00e4:
            java.lang.String r8 = "0[<!>]ERROR[<!>]"
        L_0x00e6:
            monitor-exit(r3)
            return r8
        L_0x00e8:
            r8 = move-exception
            monitor-exit(r3)
            goto L_0x00ec
        L_0x00eb:
            throw r8
        L_0x00ec:
            goto L_0x00eb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.f.a(android.content.Context):java.lang.String");
    }

    private static String a(BufferedInputStream bufferedInputStream) {
        int read;
        byte[] bArr = new byte[4096];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb.append(new String(bArr, 0, read));
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (read >= 4096);
        return sb.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0073, code lost:
        if (r1 != null) goto L_0x0075;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0061 A[SYNTHETIC, Splitter:B:33:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006b A[SYNTHETIC, Splitter:B:38:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0081 A[SYNTHETIC, Splitter:B:49:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x008b A[SYNTHETIC, Splitter:B:54:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r6) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0058, all -> 0x0053 }
            java.lang.String r2 = "sh"
            java.lang.Process r1 = r1.exec(r2)     // Catch:{ Exception -> 0x0058, all -> 0x0053 }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            java.io.OutputStream r3 = r1.getOutputStream()     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            java.io.InputStream r4 = r1.getInputStream()     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            r3.<init>(r4)     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            byte[] r6 = r6.getBytes()     // Catch:{ Exception -> 0x0048 }
            r2.write(r6)     // Catch:{ Exception -> 0x0048 }
            r6 = 10
            r2.write(r6)     // Catch:{ Exception -> 0x0048 }
            r2.flush()     // Catch:{ Exception -> 0x0048 }
            r2.close()     // Catch:{ Exception -> 0x0048 }
            r1.waitFor()     // Catch:{ Exception -> 0x0048 }
            java.lang.String r6 = a((java.io.BufferedInputStream) r3)     // Catch:{ Exception -> 0x0048 }
            r2.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x003e:
            r3.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0046:
            r0 = r6
            goto L_0x0075
        L_0x0048:
            r6 = move-exception
            goto L_0x005c
        L_0x004a:
            r6 = move-exception
            goto L_0x007b
        L_0x004c:
            r6 = move-exception
            r3 = r0
            goto L_0x005c
        L_0x004f:
            r6 = move-exception
            goto L_0x0055
        L_0x0051:
            r6 = move-exception
            goto L_0x005a
        L_0x0053:
            r6 = move-exception
            r1 = r0
        L_0x0055:
            r2 = r1
            r1 = r0
            goto L_0x007f
        L_0x0058:
            r6 = move-exception
            r1 = r0
        L_0x005a:
            r2 = r0
            r3 = r2
        L_0x005c:
            r6.printStackTrace()     // Catch:{ all -> 0x0079 }
            if (r2 == 0) goto L_0x0069
            r2.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0069:
            if (r3 == 0) goto L_0x0073
            r3.close()     // Catch:{ IOException -> 0x006f }
            goto L_0x0073
        L_0x006f:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0073:
            if (r1 == 0) goto L_0x0078
        L_0x0075:
            r1.destroy()
        L_0x0078:
            return r0
        L_0x0079:
            r6 = move-exception
            r0 = r3
        L_0x007b:
            r5 = r1
            r1 = r0
            r0 = r2
            r2 = r5
        L_0x007f:
            if (r0 == 0) goto L_0x0089
            r0.close()     // Catch:{ IOException -> 0x0085 }
            goto L_0x0089
        L_0x0085:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0089:
            if (r1 == 0) goto L_0x0093
            r1.close()     // Catch:{ IOException -> 0x008f }
            goto L_0x0093
        L_0x008f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0093:
            if (r2 == 0) goto L_0x0098
            r2.destroy()
        L_0x0098:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.f.a(java.lang.String):java.lang.String");
    }

    private static void a(LinkProperties linkProperties, JSONArray jSONArray) {
        InetAddress gateway;
        if (Build.VERSION.SDK_INT >= 21) {
            for (RouteInfo next : linkProperties.getRoutes()) {
                if (!(next == null || !next.isDefaultRoute() || (gateway = next.getGateway()) == null)) {
                    if (!(gateway instanceof Inet6Address) || !"::".equals(gateway.getHostAddress())) {
                        jSONArray.put(gateway.getHostAddress());
                    }
                }
            }
        }
    }

    private static void b(LinkProperties linkProperties, JSONArray jSONArray) {
        if (Build.VERSION.SDK_INT >= 21) {
            for (LinkAddress next : linkProperties.getLinkAddresses()) {
                if (!(next == null || next.getAddress() == null || next.getAddress().isLoopbackAddress())) {
                    jSONArray.put(next.getAddress().getHostAddress());
                }
            }
        }
    }

    public static String[] b(Context context) {
        Network[] allNetworks;
        NetworkInfo networkInfo;
        LinkProperties linkProperties;
        int type;
        String[] strArr = new String[5];
        if (Build.VERSION.SDK_INT >= 21) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (!(connectivityManager == null || (allNetworks = connectivityManager.getAllNetworks()) == null)) {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = new JSONArray();
                JSONArray jSONArray4 = new JSONArray();
                JSONArray jSONArray5 = new JSONArray();
                for (Network network : allNetworks) {
                    if (!(network == null || (networkInfo = connectivityManager.getNetworkInfo(network)) == null || networkInfo.getState() != NetworkInfo.State.CONNECTED || (linkProperties = connectivityManager.getLinkProperties(network)) == null || ((type = networkInfo.getType()) != 0 && type != 1))) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            for (InetAddress next : linkProperties.getDnsServers()) {
                                if (next != null) {
                                    jSONArray5.put(next.getHostAddress());
                                }
                            }
                        }
                        if (type == 0) {
                            b(linkProperties, jSONArray);
                            a(linkProperties, jSONArray2);
                        } else {
                            b(linkProperties, jSONArray3);
                            a(linkProperties, jSONArray4);
                        }
                    }
                }
                strArr[0] = jSONArray3.toString();
                strArr[1] = jSONArray4.toString();
                strArr[2] = jSONArray.toString();
                strArr[3] = jSONArray2.toString();
                strArr[4] = jSONArray5.toString();
            }
        } else {
            try {
                for (T t : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if (t != null) {
                        String name = t.getName();
                        if (!TextUtils.isEmpty(name) && name.contains("wlan")) {
                            ArrayList<T> list = Collections.list(t.getInetAddresses());
                            JSONArray jSONArray6 = new JSONArray();
                            for (T t2 : list) {
                                if (!t2.isLoopbackAddress()) {
                                    jSONArray6.put(t2.getHostAddress());
                                }
                            }
                            strArr[0] = jSONArray6.toString();
                        }
                    }
                }
                for (int i = 0; i < 5; i++) {
                    if (strArr[i] == null) {
                        strArr[i] = "";
                    }
                }
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
        return strArr;
    }
}
