package com.cellrebel.sdk.utils;

import android.util.Log;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class CpuUtilisationReader {
    private static final FileFilter e = new a();
    private RandomAccessFile a;
    private a b;
    private ArrayList<a> c;
    private final AtomicBoolean d = new AtomicBoolean();

    class a implements FileFilter {
        a() {
        }

        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (!Character.isDigit(name.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    public CpuUtilisationReader() {
        j();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0028 A[SYNTHETIC, Splitter:B:15:0x0028] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002f A[SYNTHETIC, Splitter:B:21:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(java.lang.String r2) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x002c, all -> 0x0025 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x002c, all -> 0x0025 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            java.lang.String r0 = r2.readLine()     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r2.close()     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            int r2 = b(r0)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r1.close()     // Catch:{ IOException -> 0x001e }
        L_0x001e:
            return r2
        L_0x001f:
            r2 = move-exception
            r0 = r1
            goto L_0x0026
        L_0x0022:
            r0 = r1
            goto L_0x002d
        L_0x0025:
            r2 = move-exception
        L_0x0026:
            if (r0 == 0) goto L_0x002b
            r0.close()     // Catch:{ IOException -> 0x002b }
        L_0x002b:
            throw r2
        L_0x002c:
        L_0x002d:
            if (r0 == 0) goto L_0x0032
            r0.close()     // Catch:{ IOException -> 0x0032 }
        L_0x0032:
            r2 = -1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.utils.CpuUtilisationReader.a(java.lang.String):int");
    }

    private void a() {
        RandomAccessFile randomAccessFile = this.a;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }

    private void a(int i, String str) {
        if (str == null || str.length() <= 0) {
            Log.e("DeviceInfoWorker", "unable to get cpu line");
            return;
        }
        String[] split = str.split("[ ]+");
        if (split[0].contains("cpu")) {
            a(i, split);
        }
    }

    private void a(int i, String[] strArr) {
        a aVar;
        if (i == -1) {
            if (this.b == null) {
                this.b = new a();
            }
            aVar = this.b;
        } else {
            if (this.c == null) {
                this.c = new ArrayList<>();
            }
            if (i < this.c.size()) {
                aVar = this.c.get(i);
            } else {
                a aVar2 = new a();
                aVar2.a(strArr);
                this.c.add(aVar2);
                return;
            }
        }
        aVar.a(strArr);
    }

    static int b(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    private int c() {
        CpuDataProvider cpuDataProvider = new CpuDataProvider();
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i < f()) {
            try {
                f2 += (float) cpuDataProvider.a(i);
                f3 += (float) ((Long) cpuDataProvider.b(i).second).longValue();
                i++;
            } catch (Exception unused) {
            }
        }
        f = (f2 / f3) * 100.0f;
        return (int) f;
    }

    private static int d() {
        return new File("/sys/devices/system/cpu/").listFiles(e).length;
    }

    public static int f() {
        try {
            int a2 = a("/sys/devices/system/cpu/possible");
            if (a2 == -1) {
                a2 = a("/sys/devices/system/cpu/present");
            }
            return a2 == -1 ? d() : a2;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    private int g() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.a();
        }
        return 0;
    }

    private void h() {
        this.a = new RandomAccessFile("/proc/stat", CampaignEx.JSON_KEY_AD_R);
        this.d.set(true);
    }

    private void i() {
        String readLine;
        RandomAccessFile randomAccessFile = this.a;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.seek(0);
                int i = -1;
                do {
                    readLine = this.a.readLine();
                    a(i, readLine);
                    i++;
                } while (readLine != null);
            } catch (IOException e2) {
                Log.e("DeviceInfoWorker", "DeviceInfoWorker Error parsing file: " + e2);
            }
        }
    }

    public int b() {
        int a2 = e().a();
        return a2 == -1 ? c() : a2;
    }

    public CpuData e() {
        if (!this.d.get()) {
            return new CpuData("/proc/stat", true);
        }
        ArrayList arrayList = new ArrayList();
        if (this.c != null) {
            for (int i = 0; i < this.c.size(); i++) {
                arrayList.add(Integer.valueOf(this.c.get(i).a()));
            }
        }
        return new CpuData("/proc/stat", g(), arrayList);
    }

    public void j() {
        StringBuilder sb;
        try {
            h();
            i();
            a();
            return;
        } catch (FileNotFoundException e2) {
            e = e2;
            this.d.set(false);
            this.a = null;
            sb = new StringBuilder("cannot open /proc/stat:");
        } catch (IOException e3) {
            e = e3;
            sb = new StringBuilder("cannot close /proc/stat:");
        }
        sb.append(e);
        Log.e("DeviceInfoWorker", sb.toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d.get()) {
            if (this.b != null) {
                sb.append("Cpu Total : ");
                sb.append(this.b.a());
                sb.append("%");
            }
            if (this.c != null) {
                for (int i = 0; i < this.c.size(); i++) {
                    a aVar = this.c.get(i);
                    sb.append(" Cpu Core(");
                    sb.append(i);
                    sb.append(") : ");
                    sb.append(aVar.a());
                    sb.append("%");
                    aVar.a();
                }
            }
        } else {
            sb.append("Error: Failed to open /proc/stat");
        }
        return sb.toString();
    }
}
