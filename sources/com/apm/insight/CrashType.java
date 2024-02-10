package com.apm.insight;

import com.facebook.internal.AnalyticsEvents;

public enum CrashType {
    LAUNCH("launch"),
    JAVA("java"),
    NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE),
    ASAN("asan"),
    TSAN("tsan"),
    ANR("anr"),
    BLOCK("block"),
    ENSURE("ensure"),
    DART("dart"),
    CUSTOM_JAVA("custom_java"),
    OOM("oom"),
    ALL("all");
    
    private String mName;

    private CrashType(String str) {
        this.mName = str;
    }

    public String getName() {
        return this.mName;
    }

    public String toString() {
        return getName();
    }
}
