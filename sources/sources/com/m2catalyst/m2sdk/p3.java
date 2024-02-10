package com.m2catalyst.m2sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.MonitoringStatsV10Message;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MonitoringStatsUtils.kt */
public final class p3 {
    public static final void a(MonitoringStatsV10Message.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long blockSizeLong = statFs.getBlockSizeLong();
            builder.system_available_internal_storage = Long.valueOf(statFs.getAvailableBlocksLong() * blockSizeLong);
            builder.system_total_internal_storage = Long.valueOf(statFs.getBlockCountLong() * blockSizeLong);
        } catch (Exception unused) {
        }
    }

    public static final void b(MonitoringStatsV10Message.Builder builder, Context context) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            builder.system_available_memory = null;
            builder.system_current_memory = null;
            if (((ActivityManager) context.getSystemService("activity")) != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                long j = memoryInfo.availMem;
                if (j > 0) {
                    builder.system_available_memory = Long.valueOf(j);
                }
                long j2 = memoryInfo.totalMem - memoryInfo.availMem;
                if (j2 > 0) {
                    builder.system_current_memory = Long.valueOf(j2);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static final void a(MonitoringStatsV10Message.Builder builder, Context context) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            builder.app_memory = null;
            Object systemService = context.getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) systemService).getProcessMemoryInfo(new int[]{Process.myPid()});
            if (processMemoryInfo.length == 1) {
                builder.app_memory = Long.valueOf((long) (processMemoryInfo[0].getTotalPss() * 1024));
            }
        } catch (Exception unused) {
        }
    }
}
