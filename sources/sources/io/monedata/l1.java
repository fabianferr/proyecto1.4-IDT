package io.monedata;

import android.content.Context;
import io.monedata.consent.ConsentManager;
import io.monedata.consent.models.ConsentData;
import io.monedata.ping.PingWorker;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0007\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0016¨\u0006\u001a"}, d2 = {"Lio/monedata/l1;", "", "Landroid/content/Context;", "context", "", "a", "", "b", "c", "d", "start", "Lio/monedata/k1;", "()Lio/monedata/k1;", "config", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope$delegate", "Lkotlin/Lazy;", "()Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "()Z", "enabled", "", "()J", "interval", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class l1 {
    public static final l1 a = new l1();
    private static final long b = TimeUnit.HOURS.toMinutes(12);
    private static final Lazy c = LazyKt.lazy(a.a);
    private static final AtomicBoolean d = new AtomicBoolean(false);
    private static final AtomicBoolean e = new AtomicBoolean(false);

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "a", "()Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1})
    static final class a extends Lambda implements Function0<CoroutineScope> {
        public static final a a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final CoroutineScope invoke() {
            return CoroutineScopeKt.MainScope();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lio/monedata/consent/models/ConsentData;", "it", "", "a", "(Lio/monedata/consent/models/ConsentData;)V"}, k = 3, mv = {1, 7, 1})
    static final class b extends Lambda implements Function1<ConsentData, Unit> {
        final /* synthetic */ Context a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context) {
            super(1);
            this.a = context;
        }

        public final void a(ConsentData consentData) {
            Intrinsics.checkNotNullParameter(consentData, "it");
            l1 l1Var = l1.a;
            Context context = this.a;
            l1Var.a(context, consentData.canCollectPersonalData(context));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((ConsentData) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.ping.PingManager$start$1", f = "PingManager.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Context b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = context;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PingWorker.a aVar = PingWorker.a;
                Context context = this.b;
                long a2 = l1.a.d();
                this.a = 1;
                if (aVar.a(context, a2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.ping.PingManager$stop$1", f = "PingManager.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Context b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Context context, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = context;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PingWorker.a aVar = PingWorker.a;
                Context context = this.b;
                this.a = 1;
                if (aVar.a(context, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    private l1() {
    }

    private final k1 a() {
        s sVar = (s) u.a.getValue();
        if (sVar != null) {
            return sVar.c();
        }
        return null;
    }

    private final boolean a(Context context) {
        if (!Monedata.isStarted() || !c()) {
            return false;
        }
        return ConsentManager.INSTANCE.canCollectPersonalData(context);
    }

    private final CoroutineScope b() {
        return (CoroutineScope) c.getValue();
    }

    private final boolean c() {
        k1 a2 = a();
        if (a2 != null) {
            return Intrinsics.areEqual((Object) a2.a(), (Object) Boolean.TRUE);
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.b();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long d() {
        /*
            r2 = this;
            io.monedata.k1 r0 = r2.a()
            if (r0 == 0) goto L_0x0011
            java.lang.Long r0 = r0.b()
            if (r0 == 0) goto L_0x0011
            long r0 = r0.longValue()
            goto L_0x0013
        L_0x0011:
            long r0 = b
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.l1.d():long");
    }

    public final void a(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (z) {
            c(context);
        } else {
            d(context);
        }
    }

    public final void b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (d.compareAndSet(false, true)) {
            ConsentManager.INSTANCE.addListener(new b(context));
        }
    }

    public final void c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (a(context) && e.compareAndSet(false, true)) {
            MonedataLog.v$default(MonedataLog.INSTANCE, "Starting ping worker", (Throwable) null, 2, (Object) null);
            Job unused = BuildersKt__Builders_commonKt.launch$default(b(), (CoroutineContext) null, (CoroutineStart) null, new c(context, (Continuation<? super c>) null), 3, (Object) null);
        }
    }

    public final void d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MonedataLog.v$default(MonedataLog.INSTANCE, "Stopping ping worker", (Throwable) null, 2, (Object) null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(b(), (CoroutineContext) null, (CoroutineStart) null, new d(context, (Continuation<? super d>) null), 3, (Object) null);
        e.set(false);
    }
}
