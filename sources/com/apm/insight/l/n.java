package com.apm.insight.l;

import android.app.ActivityManager;

public class n {
    static final a a = new b();

    private static class a {
        private a() {
        }

        public long a(ActivityManager.MemoryInfo memoryInfo) {
            return 0;
        }
    }

    private static class b extends a {
        private b() {
            super();
        }

        public long a(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    public static long a(ActivityManager.MemoryInfo memoryInfo) {
        return a.a(memoryInfo);
    }
}
