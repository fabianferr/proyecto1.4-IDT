package com.ironsource.environment;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/ironsource/environment/UserAgent;", "", "time", "Lcom/ironsource/environment/Time;", "(Lcom/ironsource/environment/Time;)V", "isUpdateRequired", "", "lastUpdateTimeInMills", "", "expirationThresholdInMillis", "environment_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class n {
    private final l a;

    public n(l lVar) {
        Intrinsics.checkNotNullParameter(lVar, "time");
        this.a = lVar;
    }

    public final boolean a(long j, long j2) {
        long a2 = this.a.a();
        return j2 <= 0 || j <= 0 || a2 < j || a2 - j > j2;
    }
}
