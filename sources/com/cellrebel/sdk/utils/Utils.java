package com.cellrebel.sdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.util.Base64;
import androidx.core.content.ContextCompat;
import com.cellrebel.sdk.networking.beans.request.BaseMetric;
import com.cellrebel.sdk.workers.TrackingManager;
import com.mbridge.msdk.foundation.tools.SameMD5;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {
    public static int a(Context context) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") != 0) {
            return 1;
        }
        PreferencesManager m = PreferencesManager.m();
        boolean q = m.q();
        boolean r = m.r();
        if (m.o()) {
            return 2;
        }
        if (r) {
            return 3;
        }
        return q ? 4 : 0;
    }

    private static int a(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i = 0;
            while (i < read) {
                byte b = bArr[i];
                if (b == 10 || i == 0) {
                    if (b == 10) {
                        i++;
                    }
                    int i2 = i;
                    while (true) {
                        if (i2 >= read) {
                            continue;
                            break;
                        }
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            break;
                        } else if (i3 == str.length() - 1) {
                            return a(bArr, i2);
                        } else {
                            i2++;
                        }
                    }
                }
                i++;
            }
        } catch (IOException | NumberFormatException unused) {
        }
        return 0;
    }

    public static int a(boolean z, boolean z2, PowerManager powerManager, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        if (z7) {
            return 7;
        }
        if (z6) {
            return 5;
        }
        if (z5) {
            return 6;
        }
        if (z4) {
            return 4;
        }
        if (z3) {
            return 100;
        }
        if (z) {
            return 0;
        }
        if (z2) {
            return 200;
        }
        return (powerManager == null || !powerManager.isScreenOn()) ? 2 : 1;
    }

    private static int a(byte[] bArr, int i) {
        byte b;
        while (i < bArr.length && (b = bArr[i]) != 10) {
            if (Character.isDigit(b)) {
                int i2 = i + 1;
                while (i2 < bArr.length && Character.isDigit(bArr[i2])) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return 0;
    }

    public static String a() {
        return new String(Base64.decode("Z mhX dFhy ZFZva 0Nlb FNZb FJlN w== ".replaceAll("\\s+", ""), 0));
    }

    public static void a(BaseMetric baseMetric, boolean z, boolean z2, PowerManager powerManager, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        baseMetric.stateDuringMeasurement = a(z, z2, powerManager, z3, z4, z5, z6, z7);
    }

    public static boolean a(int i, long j) {
        return i == 0 || Math.abs(j - System.currentTimeMillis()) >= ((long) (i * 60)) * 1000;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0090 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.telephony.CellInfo r3) {
        /*
            r0 = 0
            boolean r1 = r3.isRegistered()     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            if (r1 != 0) goto L_0x0008
            return r0
        L_0x0008:
            boolean r1 = r3 instanceof android.telephony.CellInfoGsm     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            r2 = 28
            if (r1 == 0) goto L_0x002c
            android.telephony.CellInfoGsm r3 = (android.telephony.CellInfoGsm) r3     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            android.telephony.CellIdentityGsm r3 = r3.getCellIdentity()     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            if (r1 < r2) goto L_0x0027
            java.lang.String r1 = r3.getMncString()     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            if (r1 == 0) goto L_0x0027
            java.lang.String r3 = r3.getMncString()     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
        L_0x0022:
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            goto L_0x0089
        L_0x0027:
            int r3 = r3.getMnc()     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            goto L_0x0089
        L_0x002c:
            boolean r1 = r3 instanceof android.telephony.CellInfoWcdma     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            if (r1 == 0) goto L_0x004a
            android.telephony.CellInfoWcdma r3 = (android.telephony.CellInfoWcdma) r3     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            android.telephony.CellIdentityWcdma r3 = r3.getCellIdentity()     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            if (r1 < r2) goto L_0x0045
            java.lang.String r1 = r3.getMncString()     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            if (r1 == 0) goto L_0x0045
            java.lang.String r3 = r3.getMncString()     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            goto L_0x0022
        L_0x0045:
            int r3 = r3.getMnc()     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            goto L_0x0089
        L_0x004a:
            boolean r1 = r3 instanceof android.telephony.CellInfoLte     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            if (r1 == 0) goto L_0x0068
            android.telephony.CellInfoLte r3 = (android.telephony.CellInfoLte) r3     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            android.telephony.CellIdentityLte r3 = r3.getCellIdentity()     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            if (r1 < r2) goto L_0x0063
            java.lang.String r1 = r3.getMncString()     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            if (r1 == 0) goto L_0x0063
            java.lang.String r3 = r3.getMncString()     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            goto L_0x0022
        L_0x0063:
            int r3 = r3.getMnc()     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            goto L_0x0089
        L_0x0068:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            r2 = 29
            if (r1 < r2) goto L_0x0083
            boolean r1 = r3 instanceof android.telephony.CellInfoNr     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            if (r1 == 0) goto L_0x0083
            android.telephony.CellInfoNr r3 = (android.telephony.CellInfoNr) r3     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            android.telephony.CellIdentity r3 = r3.getCellIdentity()     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            boolean r1 = r3 instanceof android.telephony.CellIdentityNr     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            if (r1 == 0) goto L_0x0088
            android.telephony.CellIdentityNr r3 = (android.telephony.CellIdentityNr) r3     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            java.lang.String r3 = r3.getMncString()     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            goto L_0x0022
        L_0x0083:
            boolean r3 = r3 instanceof android.telephony.CellInfoCdma     // Catch:{ Exception | OutOfMemoryError -> 0x0091 }
            if (r3 == 0) goto L_0x0088
            return r0
        L_0x0088:
            r3 = 0
        L_0x0089:
            if (r3 == 0) goto L_0x0091
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r3 == r1) goto L_0x0091
            r0 = 1
        L_0x0091:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.utils.Utils.a(android.telephony.CellInfo):boolean");
    }

    public static boolean a(String str) {
        return str.contains("nrState=CONNECTED") || str.contains("nrState = CONNECTED");
    }

    public static int b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (Build.VERSION.SDK_INT < 23) {
            return 1;
        }
        if (powerManager != null) {
            return powerManager.isDeviceIdleMode() ? 3 : 2;
        }
        return 0;
    }

    public static String b() {
        return "0";
    }

    public static String b(String str) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance(SameMD5.TAG);
        } catch (NoSuchAlgorithmException unused) {
            messageDigest = null;
        }
        messageDigest.update(str.getBytes(), 0, str.length());
        return new BigInteger(1, messageDigest.digest()).toString(16);
    }

    public static int c(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return (int) (((float) memoryInfo.availMem) / 1048576.0f);
    }

    public static boolean c() {
        return !Build.MANUFACTURER.toLowerCase().contains("motorola") && !Build.BRAND.toLowerCase().contains("motorola") && !Build.MODEL.toLowerCase().contains("motorola");
    }

    public static String d(Context context) {
        String str;
        String packageName = context.getPackageName();
        if (packageName.equals("com.cellrebel.mobile") || packageName.equals("com.cellrebel.ping")) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                str = "-" + packageInfo.versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return "1.9.31" + str;
        }
        str = "";
        return "1.9.31" + str;
    }

    public static boolean d() {
        String packageName = TrackingManager.getContext().getPackageName();
        return packageName != null && packageName.equals("com.cellrebel.ping");
    }

    public static int e(Context context) {
        FileInputStream fileInputStream;
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(new ActivityManager.MemoryInfo());
        long j = 0;
        try {
            fileInputStream = new FileInputStream("/proc/meminfo");
            j = ((long) a("MemTotal", fileInputStream)) * 1024;
            a("MemTotal", fileInputStream);
            a("MemFree", fileInputStream);
            fileInputStream.close();
        } catch (IOException unused) {
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
        return (int) (((float) j) / 1048576.0f);
    }

    public static boolean e() {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("8.8.8.8", 53), 1500);
            socket.close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static Integer f() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return Integer.valueOf((int) (((float) (statFs.getBlockSizeLong() * statFs.getBlockCountLong())) / 1048576.0f));
    }

    public static boolean f(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (SettingsManager.b().c().connectionTestPageLoadUrl().contains("disable-memory-check")) {
                return false;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.lowMemory;
        } catch (Exception | OutOfMemoryError unused) {
            return false;
        }
    }

    public static Integer g() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return Integer.valueOf((int) (((float) (statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong())) / 1048576.0f));
    }

    public static boolean g(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        TelephonyManager h = TrackingHelper.a().h(context);
        ServiceState serviceState = TelephonyHelper.b().c;
        if ((serviceState == null || !serviceState.getRoaming()) && !h.isNetworkRoaming()) {
            return activeNetworkInfo != null && activeNetworkInfo.isRoaming();
        }
        return true;
    }
}
