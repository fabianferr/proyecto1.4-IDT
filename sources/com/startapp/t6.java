package com.startapp;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* compiled from: Sta */
public class t6 {
    public final Context a;

    public t6(Context context) {
        this.a = context;
    }

    public boolean a(String str) {
        boolean z = false;
        for (String file : u6.c) {
            if (new File(file, str).exists()) {
                z = true;
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c() {
        /*
            r5 = this;
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x002e }
            java.lang.String r2 = "which"
            java.lang.String r3 = "su"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch:{ all -> 0x002e }
            java.lang.Process r1 = r1.exec(r2)     // Catch:{ all -> 0x002e }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x002c }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x002c }
            java.io.InputStream r4 = r1.getInputStream()     // Catch:{ all -> 0x002c }
            r3.<init>(r4)     // Catch:{ all -> 0x002c }
            r2.<init>(r3)     // Catch:{ all -> 0x002c }
            java.lang.String r2 = r2.readLine()     // Catch:{ all -> 0x002c }
            if (r2 == 0) goto L_0x0028
            r0 = 1
        L_0x0028:
            r1.destroy()
            return r0
        L_0x002c:
            goto L_0x002f
        L_0x002e:
            r1 = 0
        L_0x002f:
            if (r1 == 0) goto L_0x0034
            r1.destroy()
        L_0x0034:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.t6.c():boolean");
    }

    public boolean b() {
        String[] strArr = new String[0];
        try {
            strArr = new Scanner(Runtime.getRuntime().exec("mount").getInputStream()).useDelimiter("\\A").next().split("\n");
        } catch (IOException | NoSuchElementException e) {
            e.printStackTrace();
        }
        boolean z = false;
        for (String split : strArr) {
            String[] split2 = split.split(" ");
            if (split2.length >= 4) {
                String str = split2[1];
                String str2 = split2[3];
                for (String equalsIgnoreCase : u6.d) {
                    if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                        String[] split3 = str2.split(",");
                        int length = split3.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            } else if (split3[i].equalsIgnoreCase("rw")) {
                                z = true;
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public final boolean a(List<String> list) {
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

    public boolean a() {
        HashMap hashMap = new HashMap();
        hashMap.put("ro.debuggable", "1");
        hashMap.put("ro.secure", "0");
        String[] strArr = new String[0];
        try {
            strArr = new Scanner(Runtime.getRuntime().exec("getprop").getInputStream()).useDelimiter("\\A").next().split("\n");
        } catch (IOException | NoSuchElementException e) {
            e.printStackTrace();
        }
        boolean z = false;
        for (String str : strArr) {
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
}
