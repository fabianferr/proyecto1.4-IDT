package com.vungle.ads.internal.executor;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/vungle/ads/internal/executor/NamedThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "name", "", "(Ljava/lang/String;)V", "atomicInteger", "Ljava/util/concurrent/atomic/AtomicInteger;", "threadFactory", "kotlin.jvm.PlatformType", "newThread", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NamedThreadFactory.kt */
public final class NamedThreadFactory implements ThreadFactory {
    private final AtomicInteger atomicInteger = new AtomicInteger(0);
    private final String name;
    private final ThreadFactory threadFactory = Executors.defaultThreadFactory();

    public NamedThreadFactory(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
    }

    public Thread newThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, CampaignEx.JSON_KEY_AD_R);
        Thread newThread = this.threadFactory.newThread(runnable);
        newThread.setName(this.name + "-th-" + this.atomicInteger.incrementAndGet());
        Intrinsics.checkNotNullExpressionValue(newThread, "t");
        return newThread;
    }
}
