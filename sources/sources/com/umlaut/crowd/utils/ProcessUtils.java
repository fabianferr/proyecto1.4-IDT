package com.umlaut.crowd.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import java.util.List;

public class ProcessUtils {
    public static boolean processEqualsPackageName(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return true;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid) {
                return context.getPackageName().equals(next.processName);
            }
        }
        return true;
    }
}
