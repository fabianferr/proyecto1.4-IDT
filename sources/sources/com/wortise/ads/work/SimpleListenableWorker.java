package com.wortise.ads.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H$J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0016R?\u0010\u000e\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00040\u0004 \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\f\u001a\u0004\b\u0007\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/wortise/ads/work/SimpleListenableWorker;", "Landroidx/work/ListenableWorker;", "", "b", "Landroidx/work/ListenableWorker$Result;", "result", "", "a", "Lcom/google/common/util/concurrent/ListenableFuture;", "startWork", "Landroidx/work/impl/utils/futures/SettableFuture;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "()Landroidx/work/impl/utils/futures/SettableFuture;", "future", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: SimpleListenableWorker.kt */
public abstract class SimpleListenableWorker extends ListenableWorker {
    private final Lazy a = LazyKt.lazy(a.a);

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0000H\n"}, d2 = {"Landroidx/work/impl/utils/futures/SettableFuture;", "Landroidx/work/ListenableWorker$Result;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: SimpleListenableWorker.kt */
    static final class a extends Lambda implements Function0<SettableFuture<ListenableWorker.Result>> {
        public static final a a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final SettableFuture<ListenableWorker.Result> invoke() {
            return SettableFuture.create();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleListenableWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
    }

    private final SettableFuture<ListenableWorker.Result> a() {
        return (SettableFuture) this.a.getValue();
    }

    /* access modifiers changed from: protected */
    public abstract boolean b();

    public ListenableFuture<ListenableWorker.Result> startWork() {
        try {
            b();
        } catch (Throwable unused) {
            a().set(ListenableWorker.Result.failure());
        }
        SettableFuture<ListenableWorker.Result> a2 = a();
        Intrinsics.checkNotNullExpressionValue(a2, "future");
        return a2;
    }

    public final void a(ListenableWorker.Result result) {
        Intrinsics.checkNotNullParameter(result, IronSourceConstants.EVENTS_RESULT);
        SettableFuture<ListenableWorker.Result> a2 = a();
        if (a2 != null) {
            a2.set(result);
        }
    }
}
