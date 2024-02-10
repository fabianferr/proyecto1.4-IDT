package com.vungle.ads.internal.task;

import android.content.Context;
import android.os.Bundle;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.network.TpatSender;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.util.PathProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u0002"}, d2 = {"Lcom/vungle/ads/internal/task/ResendTpatJob;", "Lcom/vungle/ads/internal/task/Job;", "context", "Landroid/content/Context;", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "(Landroid/content/Context;Lcom/vungle/ads/internal/util/PathProvider;)V", "getContext", "()Landroid/content/Context;", "getPathProvider", "()Lcom/vungle/ads/internal/util/PathProvider;", "onRunJob", "", "bundle", "Landroid/os/Bundle;", "jobRunner", "Lcom/vungle/ads/internal/task/JobRunner;", "Companion", "vungle-ads_release", "vungleApiClient", "Lcom/vungle/ads/internal/network/VungleApiClient;", "executors", "Lcom/vungle/ads/internal/executor/Executors;"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ResendTpatJob.kt */
public final class ResendTpatJob implements Job {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "ResendTpatJob";
    private final Context context;
    private final PathProvider pathProvider;

    public ResendTpatJob(Context context2, PathProvider pathProvider2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(pathProvider2, "pathProvider");
        this.context = context2;
        this.pathProvider = pathProvider2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final PathProvider getPathProvider() {
        return this.pathProvider;
    }

    /* renamed from: onRunJob$lambda-0  reason: not valid java name */
    private static final VungleApiClient m2326onRunJob$lambda0(Lazy<VungleApiClient> lazy) {
        return lazy.getValue();
    }

    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(jobRunner, "jobRunner");
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new ResendTpatJob$onRunJob$$inlined$inject$1(this.context));
        ServiceLocator.Companion companion2 = ServiceLocator.Companion;
        Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new ResendTpatJob$onRunJob$$inlined$inject$2(this.context));
        new TpatSender(m2326onRunJob$lambda0(lazy), (String) null, (String) null, (String) null, m2327onRunJob$lambda1(lazy2).getIoExecutor(), this.pathProvider).resendStoredTpats$vungle_ads_release(m2327onRunJob$lambda1(lazy2).getJobExecutor());
        return 0;
    }

    /* renamed from: onRunJob$lambda-1  reason: not valid java name */
    private static final Executors m2327onRunJob$lambda1(Lazy<? extends Executors> lazy) {
        return (Executors) lazy.getValue();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/vungle/ads/internal/task/ResendTpatJob$Companion;", "", "()V", "TAG", "", "makeJobInfo", "Lcom/vungle/ads/internal/task/JobInfo;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ResendTpatJob.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JobInfo makeJobInfo() {
            return new JobInfo(ResendTpatJob.TAG).setPriority(0).setUpdateCurrent(true);
        }
    }
}
