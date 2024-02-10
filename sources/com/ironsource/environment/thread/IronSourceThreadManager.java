package com.ironsource.environment.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.internal.NativeProtocol;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00132\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\u0006\u0010\u001f\u001a\u00020 J\u001a\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u001e2\b\b\u0002\u0010#\u001a\u00020$H\u0007J\u001a\u0010%\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u001e2\b\b\u0002\u0010#\u001a\u00020$H\u0007J\u001a\u0010&\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u001e2\b\b\u0002\u0010#\u001a\u00020$H\u0007J\u001a\u0010'\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u001e2\b\b\u0002\u0010#\u001a\u00020$H\u0007J\u000e\u0010(\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u001eJ\u000e\u0010)\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u001eJ\u000e\u0010*\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u001eJ\u0010\u0010+\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lcom/ironsource/environment/thread/IronSourceThreadManager;", "", "()V", "adapterBackgroundHandler", "Lcom/ironsource/environment/thread/IronSourceHandlerThread;", "executorService", "Lcom/ironsource/environment/thread/ScheduledExecutorService;", "getExecutorService", "()Lcom/ironsource/environment/thread/ScheduledExecutorService;", "executorService$delegate", "Lkotlin/Lazy;", "initHandler", "Landroid/os/Handler;", "getInitHandler", "()Landroid/os/Handler;", "mediationBackgroundHandler", "publisherCallbackHandler", "uiHandler", "useSharedExecutorService", "", "getUseSharedExecutorService", "()Z", "setUseSharedExecutorService", "(Z)V", "executeTasks", "", "shouldExecuteAsync", "shouldWaitUntilAllOperationsCompleted", "tasks", "", "Ljava/lang/Runnable;", "getThreadPoolExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "postAdapterBackgroundTask", "action", "delay", "", "postMediationBackgroundTask", "postOnUiThreadTask", "postPublisherCallback", "removeAdapterBackgroundTask", "removeMediationBackgroundTask", "removeUiThreadTask", "shouldRemoveTaskFromThreadPool", "environment_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IronSourceThreadManager {
    public static final IronSourceThreadManager INSTANCE = new IronSourceThreadManager();
    private static boolean a;
    private static final Handler b = new Handler(Looper.getMainLooper());
    private static final Handler c;
    private static final b d;
    private static final b e;
    private static final b f;
    private static final Lazy g = LazyKt.lazy(a.a);

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ironsource/environment/thread/ScheduledExecutorService;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class a extends Lambda implements Function0<d> {
        public static final a a = new a();

        a() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            return new d(0, (Function1) null, (Function1) null, 7);
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("IronSourceInitiatorHandler");
        handlerThread.start();
        c = new Handler(handlerThread.getLooper());
        b bVar = new b("mediationBackground");
        bVar.start();
        bVar.a();
        d = bVar;
        b bVar2 = new b("adapterBackground");
        bVar2.start();
        bVar2.a();
        e = bVar2;
        b bVar3 = new b("publisher-callbacks");
        bVar3.start();
        bVar3.a();
        f = bVar3;
    }

    private IronSourceThreadManager() {
    }

    private static d a() {
        return (d) g.getValue();
    }

    /* access modifiers changed from: private */
    public static final void a(Runnable runnable, CountDownLatch countDownLatch) {
        Intrinsics.checkNotNullParameter(runnable, "$it");
        Intrinsics.checkNotNullParameter(countDownLatch, "$latch");
        runnable.run();
        new IronSourceThreadManager$$ExternalSyntheticLambda0(countDownLatch).run();
    }

    /* access modifiers changed from: private */
    public static final void a(CountDownLatch countDownLatch) {
        Intrinsics.checkNotNullParameter(countDownLatch, "$latch");
        countDownLatch.countDown();
    }

    private final boolean a(Runnable runnable) {
        return a && a().getQueue().contains(runnable);
    }

    public static /* synthetic */ void postAdapterBackgroundTask$default(IronSourceThreadManager ironSourceThreadManager, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        ironSourceThreadManager.postAdapterBackgroundTask(runnable, j);
    }

    public static /* synthetic */ void postMediationBackgroundTask$default(IronSourceThreadManager ironSourceThreadManager, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        ironSourceThreadManager.postMediationBackgroundTask(runnable, j);
    }

    public static /* synthetic */ void postOnUiThreadTask$default(IronSourceThreadManager ironSourceThreadManager, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        ironSourceThreadManager.postOnUiThreadTask(runnable, j);
    }

    public static /* synthetic */ void postPublisherCallback$default(IronSourceThreadManager ironSourceThreadManager, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        ironSourceThreadManager.postPublisherCallback(runnable, j);
    }

    public final void executeTasks(boolean z, boolean z2, List<? extends Runnable> list) {
        Intrinsics.checkNotNullParameter(list, "tasks");
        if (!z) {
            for (Runnable run : list) {
                run.run();
            }
        } else if (!z2) {
            for (Runnable postMediationBackgroundTask$default : list) {
                postMediationBackgroundTask$default(INSTANCE, postMediationBackgroundTask$default, 0, 2, (Object) null);
            }
        } else {
            CountDownLatch countDownLatch = new CountDownLatch(list.size());
            for (Runnable ironSourceThreadManager$$ExternalSyntheticLambda1 : list) {
                postMediationBackgroundTask$default(INSTANCE, new IronSourceThreadManager$$ExternalSyntheticLambda1(ironSourceThreadManager$$ExternalSyntheticLambda1, countDownLatch), 0, 2, (Object) null);
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    public final Handler getInitHandler() {
        return c;
    }

    public final ThreadPoolExecutor getThreadPoolExecutor() {
        return new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors(), Long.MAX_VALUE, TimeUnit.NANOSECONDS, new LinkedBlockingQueue());
    }

    public final boolean getUseSharedExecutorService() {
        return a;
    }

    public final void postAdapterBackgroundTask(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, NativeProtocol.WEB_DIALOG_ACTION);
        postAdapterBackgroundTask$default(this, runnable, 0, 2, (Object) null);
    }

    public final void postAdapterBackgroundTask(Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(runnable, NativeProtocol.WEB_DIALOG_ACTION);
        if (a) {
            a().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } else {
            e.a(runnable, j);
        }
    }

    public final void postMediationBackgroundTask(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, NativeProtocol.WEB_DIALOG_ACTION);
        postMediationBackgroundTask$default(this, runnable, 0, 2, (Object) null);
    }

    public final void postMediationBackgroundTask(Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(runnable, NativeProtocol.WEB_DIALOG_ACTION);
        if (a) {
            a().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } else {
            d.a(runnable, j);
        }
    }

    public final void postOnUiThreadTask(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, NativeProtocol.WEB_DIALOG_ACTION);
        postOnUiThreadTask$default(this, runnable, 0, 2, (Object) null);
    }

    public final void postOnUiThreadTask(Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(runnable, NativeProtocol.WEB_DIALOG_ACTION);
        b.postDelayed(runnable, j);
    }

    public final void postPublisherCallback(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, NativeProtocol.WEB_DIALOG_ACTION);
        postPublisherCallback$default(this, runnable, 0, 2, (Object) null);
    }

    public final void postPublisherCallback(Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(runnable, NativeProtocol.WEB_DIALOG_ACTION);
        f.a(runnable, j);
    }

    public final void removeAdapterBackgroundTask(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, NativeProtocol.WEB_DIALOG_ACTION);
        if (a(runnable)) {
            a().remove(runnable);
        } else {
            e.a(runnable);
        }
    }

    public final void removeMediationBackgroundTask(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, NativeProtocol.WEB_DIALOG_ACTION);
        if (a(runnable)) {
            a().remove(runnable);
        } else {
            d.a(runnable);
        }
    }

    public final void removeUiThreadTask(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, NativeProtocol.WEB_DIALOG_ACTION);
        b.removeCallbacks(runnable);
    }

    public final void setUseSharedExecutorService(boolean z) {
        a = z;
    }
}
