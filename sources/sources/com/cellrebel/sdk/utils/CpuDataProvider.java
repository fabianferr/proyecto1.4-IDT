package com.cellrebel.sdk.utils;

import android.util.Log;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.RandomAccessFile;

public final class CpuDataProvider {
    public final long a(int i) {
        try {
            try {
                return Long.parseLong(new RandomAccessFile("/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq", CampaignEx.JSON_KEY_AD_R).readLine()) / 1000;
            } catch (Throwable th) {
                Log.e("DeviceInfoWorker", "DeviceInfoWorker strFileList: " + th);
                return 0;
            }
        } catch (Exception e) {
            Log.e("DeviceInfoWorker", "DeviceInfoWorker strFileList: " + e);
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return new androidx.core.util.Pair(-1L, -1L);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.core.util.Pair b(int r10) {
        /*
            r9 = this;
            java.lang.String r0 = "DeviceInfoWorker"
            java.lang.String r1 = "r"
            java.lang.String r2 = "DeviceInfoWorker strFileList: "
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "/sys/devices/system/cpu/cpu"
            r3.<init>(r4)
            r3.append(r10)
            java.lang.String r5 = "/cpufreq/cpuinfo_min_freq"
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            r5.append(r10)
            java.lang.String r10 = "/cpufreq/cpuinfo_max_freq"
            r5.append(r10)
            java.lang.String r10 = r5.toString()
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x007d }
            r4.<init>(r3, r1)     // Catch:{ Exception -> 0x007d }
            r5 = 1000(0x3e8, double:4.94E-321)
            java.lang.String r3 = r4.readLine()     // Catch:{ all -> 0x003b }
            long r3 = java.lang.Long.parseLong(r3)     // Catch:{ all -> 0x003b }
            long r3 = r3 / r5
            goto L_0x004b
        L_0x003b:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x007b }
            r4.<init>(r2)     // Catch:{ all -> 0x007b }
            r4.append(r3)     // Catch:{ all -> 0x007b }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x007b }
            android.util.Log.e(r0, r3)     // Catch:{ all -> 0x007b }
        L_0x004b:
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x007d }
            r3.<init>(r10, r1)     // Catch:{ Exception -> 0x007d }
            r7 = 0
            java.lang.String r10 = r3.readLine()     // Catch:{ all -> 0x005c }
            long r3 = java.lang.Long.parseLong(r10)     // Catch:{ all -> 0x005c }
            long r3 = r3 / r5
            goto L_0x006d
        L_0x005c:
            r10 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x007b }
            r1.<init>(r2)     // Catch:{ all -> 0x007b }
            r1.append(r10)     // Catch:{ all -> 0x007b }
            java.lang.String r10 = r1.toString()     // Catch:{ all -> 0x007b }
            android.util.Log.e(r0, r10)     // Catch:{ all -> 0x007b }
            r3 = r7
        L_0x006d:
            androidx.core.util.Pair r10 = new androidx.core.util.Pair     // Catch:{ Exception -> 0x007d }
            java.lang.Long r0 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x007d }
            java.lang.Long r1 = java.lang.Long.valueOf(r3)     // Catch:{ Exception -> 0x007d }
            r10.<init>(r0, r1)     // Catch:{ Exception -> 0x007d }
            goto L_0x008c
        L_0x007b:
            r10 = move-exception
            throw r10     // Catch:{ Exception -> 0x007d }
        L_0x007d:
            androidx.core.util.Pair r10 = new androidx.core.util.Pair
            r0 = -1
            java.lang.Long r2 = java.lang.Long.valueOf(r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r10.<init>(r2, r0)
        L_0x008c:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.utils.CpuDataProvider.b(int):androidx.core.util.Pair");
    }
}
