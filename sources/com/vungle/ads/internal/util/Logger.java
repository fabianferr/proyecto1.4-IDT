package com.vungle.ads.internal.util;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/vungle/ads/internal/util/Logger;", "", "()V", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Logger.kt */
public final class Logger {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static boolean enabled;

    @JvmStatic
    public static final int d(String str, String str2) {
        return Companion.d(str, str2);
    }

    @JvmStatic
    public static final int e(String str, String str2) {
        return Companion.e(str, str2);
    }

    @JvmStatic
    public static final int e(String str, String str2, Throwable th) {
        return Companion.e(str, str2, th);
    }

    @JvmStatic
    public static final int w(String str, String str2) {
        return Companion.w(str, str2);
    }

    @JvmStatic
    public static final int w(String str, String str2, Throwable th) {
        return Companion.w(str, str2, th);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J&\u0010\n\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0004J\u001c\u0010\u000f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J&\u0010\u000f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/vungle/ads/internal/util/Logger$Companion;", "", "()V", "enabled", "", "d", "", "tag", "", "message", "e", "throwable", "", "enable", "", "w", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Logger.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void enable(boolean z) {
            Companion companion = Logger.Companion;
            Logger.enabled = z;
        }

        @JvmStatic
        public final int d(String str, String str2) {
            if (!Logger.enabled || str == null || str2 == null) {
                return -1;
            }
            return Log.d(str, str2);
        }

        @JvmStatic
        public final int e(String str, String str2) {
            if (!Logger.enabled || str == null || str2 == null) {
                return -1;
            }
            return Log.e(str, str2);
        }

        @JvmStatic
        public final int e(String str, String str2, Throwable th) {
            if (!Logger.enabled || str == null || str2 == null) {
                return -1;
            }
            return Log.e(str, str2, th);
        }

        @JvmStatic
        public final int w(String str, String str2) {
            if (!Logger.enabled || str == null || str2 == null) {
                return -1;
            }
            return Log.w(str, str2);
        }

        @JvmStatic
        public final int w(String str, String str2, Throwable th) {
            if (!Logger.enabled || str2 == null || th == null) {
                return -1;
            }
            Log.w(str, str2, th);
            return -1;
        }
    }
}
