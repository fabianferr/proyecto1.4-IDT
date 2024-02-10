package com.mbridge.msdk.foundation.same.net;

import android.net.TrafficStats;
import android.os.SystemClock;

/* compiled from: BandWideUtil */
public final class a {
    private static long a;
    private static long b;
    private static long c;

    /* renamed from: com.mbridge.msdk.foundation.same.net.a$a  reason: collision with other inner class name */
    /* compiled from: BandWideUtil */
    private static class C0140a {
        /* access modifiers changed from: private */
        public static a a = new a();
    }

    private a() {
    }

    public static a a() {
        return C0140a.a;
    }

    public final synchronized void b() {
        if (a == 0) {
            a = SystemClock.elapsedRealtime();
            c = TrafficStats.getTotalRxBytes();
        }
    }

    public final synchronized void c() {
        if (!(a == 0 || c == 0)) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - a;
            if (elapsedRealtime != 0) {
                try {
                    if (TrafficStats.getTotalRxBytes() != -1) {
                        long totalRxBytes = ((TrafficStats.getTotalRxBytes() - c) * 1000) / elapsedRealtime;
                        if (totalRxBytes == 0) {
                            b = 1;
                        } else {
                            b = totalRxBytes;
                        }
                    } else {
                        b = 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            d();
        }
    }

    public final synchronized void d() {
        c = 0;
        a = 0;
    }

    public final long e() {
        return b;
    }
}
