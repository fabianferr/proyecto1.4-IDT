package com.cellrebel.sdk.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.facebook.internal.security.CertificateUtil;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RootUtil {
    static final String[] c = {"com.noshufou.android.su", "com.noshufou.android.su.elite", "eu.chainfire.supersu", "com.koushikdutta.superuser", "com.thirdparty.superuser", "com.yellowes.su", "com.topjohnwu.magisk", "com.kingroot.kinguser", "com.kingo.root", "com.smedialink.oneclickroot", "com.zhiqupk.root.global", "com.alephzain.framaroot"};
    public static final String[] d = {"com.koushikdutta.rommanager", "com.koushikdutta.rommanager.license", "com.dimonvideo.luckypatcher", "com.chelpus.lackypatch", "com.ramdroid.appquarantine", "com.ramdroid.appquarantinepro", "com.android.vending.billing.InAppBillingService.COIN", "com.android.vending.billing.InAppBillingService.LUCK", "com.chelpus.luckypatcher", "com.blackmartalpha", "org.blackmart.market", "com.allinone.free", "com.repodroid.app", "org.creeplays.hack", "com.baseappfull.fwd", "com.zmapp", "com.dv.marketmod.installer", "org.mobilism.android", "com.android.wp.net.log", "com.android.camera.update", "cc.madkite.freedom", "com.solohsu.android.edxp.manager", "org.meowcat.edxposed.manager", "com.xmodgame", "com.cih.game_cih", "com.charles.lpoqasert", "catch_.me_.if_.you_.can_"};
    public static final String[] e = {"com.devadvance.rootcloak", "com.devadvance.rootcloakplus", "de.robv.android.xposed.installer", "com.saurik.substrate", "com.zachspong.temprootremovejb", "com.amphoras.hidemyroot", "com.amphoras.hidemyrootadfree", "com.formyhm.hiderootPremium", "com.formyhm.hideroot"};
    private static final String[] f = {"/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/.ext/", "/system/bin/failsafe/", "/system/sd/xbin/", "/system/usr/we-need-root/", "/system/xbin/", "/cache/", "/data/", "/dev/"};
    static final String[] g = {"/system", "/system/bin", "/system/sbin", "/system/xbin", "/vendor/bin", "/sbin", "/etc"};
    private final Context a;
    private boolean b = true;

    public RootUtil(Context context) {
        this.a = context;
    }

    private boolean a(List<String> list) {
        PackageManager packageManager = this.a.getPackageManager();
        boolean z = false;
        for (String packageInfo : list) {
            try {
                packageManager.getPackageInfo(packageInfo, 0);
                z = true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return z;
    }

    static String[] j() {
        Object[] array;
        ArrayList arrayList = new ArrayList(Arrays.asList(f));
        String str = System.getenv("PATH");
        if (str == null || "".equals(str)) {
            array = arrayList.toArray(new String[0]);
        } else {
            String[] split = str.split(CertificateUtil.DELIMITER);
            int length = split.length;
            for (int i = 0; i < length; i++) {
                String str2 = split[i];
                if (!str2.endsWith("/")) {
                    str2 = str2 + '/';
                }
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            array = arrayList.toArray(new String[0]);
        }
        return (String[]) array;
    }

    private String[] l() {
        try {
            InputStream inputStream = Runtime.getRuntime().exec("mount").getInputStream();
            if (inputStream == null) {
                return null;
            }
            return new Scanner(inputStream).useDelimiter("\\A").next().split("\n");
        } catch (IOException | OutOfMemoryError | NoSuchElementException unused) {
            return null;
        }
    }

    private String[] m() {
        try {
            InputStream inputStream = Runtime.getRuntime().exec("getprop").getInputStream();
            if (inputStream == null) {
                return null;
            }
            return new Scanner(inputStream).useDelimiter("\\A").next().split("\n");
        } catch (IOException | NoSuchElementException unused) {
            return null;
        }
    }

    public boolean a() {
        return new RootNative().a();
    }

    public boolean a(String str) {
        boolean z = false;
        for (String str2 : j()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str);
            if (new File(str2, str).exists()) {
                z = true;
            }
        }
        return z;
    }

    public boolean a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(d));
        if (strArr != null && strArr.length > 0) {
            arrayList.addAll(Arrays.asList(strArr));
        }
        return a((List<String>) arrayList);
    }

    public boolean b() {
        HashMap hashMap = new HashMap();
        hashMap.put("ro.debuggable", "1");
        hashMap.put("ro.secure", "0");
        String[] m = m();
        if (m == null) {
            return false;
        }
        boolean z = false;
        for (String str : m) {
            for (String str2 : hashMap.keySet()) {
                if (str.contains(str2)) {
                    if (str.contains("[" + ((String) hashMap.get(str2)) + "]")) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public boolean b(String[] strArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(c));
        if (strArr != null && strArr.length > 0) {
            arrayList.addAll(Arrays.asList(strArr));
        }
        return a((List<String>) arrayList);
    }

    public boolean c() {
        return a("magisk");
    }

    public boolean d() {
        String str;
        String str2;
        String[] l = l();
        if (l == null) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        boolean z = false;
        for (String split : l) {
            String[] split2 = split.split(" ");
            int i2 = 23;
            if ((i > 23 || split2.length >= 4) && (i <= 23 || split2.length >= 6)) {
                if (i > 23) {
                    str = split2[2];
                    str2 = split2[5];
                } else {
                    str = split2[1];
                    str2 = split2[3];
                }
                String[] strArr = g;
                int length = strArr.length;
                int i3 = 0;
                while (i3 < length) {
                    if (str.equalsIgnoreCase(strArr[i3])) {
                        if (Build.VERSION.SDK_INT > i2) {
                            str2 = str2.replace("(", "").replace(")", "");
                        }
                        String[] split3 = str2.split(",");
                        int length2 = split3.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length2) {
                                break;
                            } else if (split3[i4].equalsIgnoreCase("rw")) {
                                z = true;
                                break;
                            } else {
                                i4++;
                            }
                        }
                    }
                    i3++;
                    i2 = 23;
                }
            }
        }
        return z;
    }

    public boolean e() {
        if (!a()) {
            return false;
        }
        String[] j = j();
        int length = j.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = j[i] + DownloadCommon.DOWNLOAD_REPORT_SUCCESS;
        }
        RootNative rootNative = new RootNative();
        try {
            rootNative.setLogDebugMessages(this.b);
            return rootNative.checkForRoot(strArr) > 0;
        } catch (UnsatisfiedLinkError unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean f() {
        /*
            r5 = this;
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x002c }
            java.lang.String r2 = "which"
            java.lang.String r3 = "su"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch:{ all -> 0x002c }
            java.lang.Process r1 = r1.exec(r2)     // Catch:{ all -> 0x002c }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x002a }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x002a }
            java.io.InputStream r4 = r1.getInputStream()     // Catch:{ all -> 0x002a }
            r3.<init>(r4)     // Catch:{ all -> 0x002a }
            r2.<init>(r3)     // Catch:{ all -> 0x002a }
            java.lang.String r2 = r2.readLine()     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x0026
            r0 = 1
        L_0x0026:
            r1.destroy()
            return r0
        L_0x002a:
            goto L_0x002d
        L_0x002c:
            r1 = 0
        L_0x002d:
            if (r1 == 0) goto L_0x0032
            r1.destroy()
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.utils.RootUtil.f():boolean");
    }

    public boolean g() {
        return a((String[]) null);
    }

    public boolean h() {
        return b((String[]) null);
    }

    public boolean i() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public boolean k() {
        return h() || g() || a(DownloadCommon.DOWNLOAD_REPORT_SUCCESS) || b() || d() || i() || f() || e() || c();
    }
}
