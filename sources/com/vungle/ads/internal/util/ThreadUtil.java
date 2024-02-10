package com.vungle.ads.internal.util;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R&\u0010\b\u001a\u0004\u0018\u00010\t8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/vungle/ads/internal/util/ThreadUtil;", "", "()V", "UI_HANDLER", "Landroid/os/Handler;", "isMainThread", "", "()Z", "uiExecutor", "Ljava/util/concurrent/Executor;", "getUiExecutor$vungle_ads_release$annotations", "getUiExecutor$vungle_ads_release", "()Ljava/util/concurrent/Executor;", "setUiExecutor$vungle_ads_release", "(Ljava/util/concurrent/Executor;)V", "runOnUiThread", "", "runnable", "Ljava/lang/Runnable;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ThreadUtil.kt */
public final class ThreadUtil {
    public static final ThreadUtil INSTANCE = new ThreadUtil();
    private static final Handler UI_HANDLER = new Handler(Looper.getMainLooper());
    private static Executor uiExecutor;

    public static /* synthetic */ void getUiExecutor$vungle_ads_release$annotations() {
    }

    private ThreadUtil() {
    }

    public final Executor getUiExecutor$vungle_ads_release() {
        return uiExecutor;
    }

    public final void setUiExecutor$vungle_ads_release(Executor executor) {
        uiExecutor = executor;
    }

    public final boolean isMainThread() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return mainLooper.isCurrentThread();
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper == null || !Intrinsics.areEqual((Object) mainLooper.getThread(), (Object) myLooper.getThread())) {
            return false;
        }
        return true;
    }

    public final void runOnUiThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (isMainThread()) {
            runnable.run();
            return;
        }
        Executor executor = uiExecutor;
        if (executor == null) {
            UI_HANDLER.post(runnable);
        } else if (executor != null) {
            executor.execute(runnable);
        }
    }
}
