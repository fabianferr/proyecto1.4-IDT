package com.ironsource.environment.thread;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0002R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ironsource/environment/thread/ScheduledExecutorService;", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "threadCount", "", "report", "Lkotlin/Function1;", "", "", "log", "", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "afterExecute", "runnable", "Ljava/lang/Runnable;", "throwable", "buildLogMsg", "msg", "environment_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d extends ScheduledThreadPoolExecutor {
    private final Function1<Throwable, Unit> a;
    private final Function1<String, Unit> b;

    public d() {
        this(0, (Function1) null, (Function1) null, 7);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private d(int i, Function1<? super Throwable, Unit> function1, Function1<? super String, Unit> function12) {
        super(i, new c());
        Intrinsics.checkNotNullParameter(function1, "report");
        Intrinsics.checkNotNullParameter(function12, "log");
        this.a = function1;
        this.b = function12;
    }

    public /* synthetic */ d(int i, Function1 function1, Function1 function12, int i2) {
        this(e.a, AnonymousClass1.a, AnonymousClass2.a);
    }

    private final String a(String str) {
        return getClass().getName() + " RuntimeException caught: " + str;
    }

    /* access modifiers changed from: protected */
    public final void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th != null) {
            this.b.invoke(a(th.toString()));
            this.a.invoke(th);
        } else if ((runnable instanceof Future) && ((Future) runnable).isDone()) {
            try {
                ((Future) runnable).get();
            } catch (CancellationException e) {
                this.b.invoke(a(e.toString()));
                this.a.invoke(e);
            } catch (ExecutionException e2) {
                this.b.invoke(a(e2.toString()));
                this.a.invoke(e2.getCause());
            } catch (InterruptedException e3) {
                this.b.invoke(a(e3.toString()));
                Thread.currentThread().interrupt();
            }
        }
    }
}
