package com.vungle.ads.internal.executor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000fR\u0014\u0010\u001a\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/vungle/ads/internal/executor/SDKExecutors;", "Lcom/vungle/ads/internal/executor/Executors;", "()V", "BACKGROUND_EXECUTOR", "Lcom/vungle/ads/internal/executor/VungleThreadPoolExecutor;", "DOWNLOADER_EXECUTOR", "IO_EXECUTOR", "JOB_EXECUTOR", "LOGGER_EXECUTOR", "NUMBER_OF_CORES", "", "OFFLOAD_EXECUTOR", "UA_EXECUTOR", "backgroundExecutor", "getBackgroundExecutor", "()Lcom/vungle/ads/internal/executor/VungleThreadPoolExecutor;", "downloaderExecutor", "getDownloaderExecutor", "ioExecutor", "getIoExecutor", "jobExecutor", "getJobExecutor", "loggerExecutor", "getLoggerExecutor", "offloadExecutor", "getOffloadExecutor", "uaExecutor", "getUaExecutor", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SDKExecutors.kt */
public final class SDKExecutors implements Executors {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int IO_KEEP_ALIVE_TIME_SECONDS = 5;
    private static final int JOBS_KEEP_ALIVE_TIME_SECONDS = 1;
    private static final int SINGLE_CORE_POOL_SIZE = 1;
    private static final int VUNGLE_KEEP_ALIVE_TIME_SECONDS = 10;
    private VungleThreadPoolExecutor BACKGROUND_EXECUTOR = new VungleThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("vng_background"));
    private VungleThreadPoolExecutor DOWNLOADER_EXECUTOR = new VungleThreadPoolExecutor(4, 4, 1, TimeUnit.SECONDS, new PriorityBlockingQueue(), new NamedThreadFactory("vng_down"));
    private VungleThreadPoolExecutor IO_EXECUTOR = new VungleThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("vng_io"));
    private VungleThreadPoolExecutor JOB_EXECUTOR;
    private VungleThreadPoolExecutor LOGGER_EXECUTOR = new VungleThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("vng_logger"));
    private final int NUMBER_OF_CORES;
    private VungleThreadPoolExecutor OFFLOAD_EXECUTOR = new VungleThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("vng_ol"));
    private VungleThreadPoolExecutor UA_EXECUTOR = new VungleThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("vng_ua"));

    public SDKExecutors() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.NUMBER_OF_CORES = availableProcessors;
        this.JOB_EXECUTOR = new VungleThreadPoolExecutor(availableProcessors, availableProcessors, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("vng_jr"));
    }

    public VungleThreadPoolExecutor getBackgroundExecutor() {
        return this.BACKGROUND_EXECUTOR;
    }

    public VungleThreadPoolExecutor getIoExecutor() {
        return this.IO_EXECUTOR;
    }

    public VungleThreadPoolExecutor getJobExecutor() {
        return this.JOB_EXECUTOR;
    }

    public VungleThreadPoolExecutor getLoggerExecutor() {
        return this.LOGGER_EXECUTOR;
    }

    public VungleThreadPoolExecutor getOffloadExecutor() {
        return this.OFFLOAD_EXECUTOR;
    }

    public VungleThreadPoolExecutor getUaExecutor() {
        return this.UA_EXECUTOR;
    }

    public VungleThreadPoolExecutor getDownloaderExecutor() {
        return this.DOWNLOADER_EXECUTOR;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/vungle/ads/internal/executor/SDKExecutors$Companion;", "", "()V", "IO_KEEP_ALIVE_TIME_SECONDS", "", "JOBS_KEEP_ALIVE_TIME_SECONDS", "SINGLE_CORE_POOL_SIZE", "VUNGLE_KEEP_ALIVE_TIME_SECONDS", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SDKExecutors.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
