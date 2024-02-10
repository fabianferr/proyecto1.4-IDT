package com.ironsource.environment;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/ironsource/environment/DeviceConfigurationsDataHolder;", "", "()V", "shouldReuseAdvertisingId", "", "getShouldReuseAdvertisingId", "()Z", "setShouldReuseAdvertisingId", "(Z)V", "shouldUseAdvertisingId", "getShouldUseAdvertisingId", "setShouldUseAdvertisingId", "shouldUseAppSet", "getShouldUseAppSet", "setShouldUseAppSet", "userAgentExpirationThresholdInHours", "", "getUserAgentExpirationThresholdInHours", "()I", "setUserAgentExpirationThresholdInHours", "(I)V", "environment_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class g {
    public static final g a = new g();
    private static boolean b = true;
    private static boolean c = true;
    private static boolean d;
    private static int e;

    private g() {
    }

    public static void a(int i) {
        e = i;
    }

    public static void a(boolean z) {
        b = z;
    }

    public static boolean a() {
        return b;
    }

    public static void b(boolean z) {
        c = z;
    }

    public static boolean b() {
        return c;
    }

    public static void c(boolean z) {
        d = z;
    }

    public static boolean c() {
        return d;
    }

    public static int d() {
        return e;
    }
}
