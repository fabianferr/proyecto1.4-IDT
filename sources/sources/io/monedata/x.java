package io.monedata;

import android.content.Context;
import io.monedata.consent.models.ConsentData;
import io.monedata.consent.models.ConsentSettings;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0013\u0010\u0006\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\u0002R\u001b\u0010\r\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R8\u0010\u0017\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014j\u0004\u0018\u0001`\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u0006\u0010\u001bR\"\u0010\u001c\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u0006\u0010\u001f\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lio/monedata/x;", "", "", "d", "Lio/monedata/consent/models/ConsentSettings;", "settings", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "e", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope$delegate", "Lkotlin/Lazy;", "()Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "", "b", "()Z", "isActive", "c", "isShowing", "Lkotlin/Function1;", "Lio/monedata/consent/models/ConsentData;", "Lio/monedata/consent/ConsentRequestListener;", "listener", "Lkotlin/jvm/functions/Function1;", "getListener", "()Lkotlin/jvm/functions/Function1;", "(Lkotlin/jvm/functions/Function1;)V", "withOptOut", "Z", "getWithOptOut", "(Z)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class x {
    /* access modifiers changed from: private */
    public final Context a;
    private final Lazy b = LazyKt.lazy(a.a);
    private w c;
    private Job d;
    private Function1<? super ConsentData, Unit> e;
    private boolean f = true;

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

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.consent.dialog.ConsentDialogController", f = "ConsentDialogController.kt", i = {0}, l = {71}, m = "load", n = {"this"}, s = {"L$0"})
    static final class b extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ x c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(x xVar, Continuation<? super b> continuation) {
            super(continuation);
            this.c = xVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.a((Continuation<? super Unit>) this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lio/monedata/consent/models/ConsentSettings;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.consent.dialog.ConsentDialogController$load$settings$1", f = "ConsentDialogController.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ConsentSettings>, Object> {
        int a;
        final /* synthetic */ x b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(x xVar, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = xVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ConsentSettings> continuation) {
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
                d0 d0Var = d0.a;
                Context a2 = this.b.a;
                this.a = 1;
                obj = d0.a(d0Var, a2, (String) null, this, 2, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    public static final class d extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        final /* synthetic */ x a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(CoroutineExceptionHandler.Key key, x xVar) {
            super(key);
            this.a = xVar;
        }

        public void handleException(CoroutineContext coroutineContext, Throwable th) {
            this.a.d();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.consent.dialog.ConsentDialogController$show$1", f = "ConsentDialogController.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
    static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ x b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(x xVar, Continuation<? super e> continuation) {
            super(2, continuation);
            this.b = xVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                x xVar = this.b;
                this.a = 1;
                if (xVar.a((Continuation<? super Unit>) this) == coroutine_suspended) {
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

    public x(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.monedata.x.b
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.monedata.x$b r0 = (io.monedata.x.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.x$b r0 = new io.monedata.x$b
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.a
            io.monedata.x r0 = (io.monedata.x) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004e
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getIO()
            io.monedata.x$c r2 = new io.monedata.x$c
            r4 = 0
            r2.<init>(r5, r4)
            r0.a = r5
            r0.d = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r2, r0)
            if (r6 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r0 = r5
        L_0x004e:
            io.monedata.consent.models.ConsentSettings r6 = (io.monedata.consent.models.ConsentSettings) r6
            r1 = 3
            java.lang.String[] r1 = new java.lang.String[r1]
            java.lang.String r2 = r6.getAllowText()
            r4 = 0
            r1[r4] = r2
            java.lang.String r2 = r6.getDenyText()
            r1[r3] = r2
            java.lang.String r2 = r6.getMessage()
            r3 = 2
            r1[r3] = r2
            io.monedata.extensions.StringKt.requireNoneEmpty(r1)
            r0.a((io.monedata.consent.models.ConsentSettings) r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.x.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final CoroutineScope a() {
        return (CoroutineScope) this.b.getValue();
    }

    private final void a(ConsentSettings consentSettings) {
        w wVar = this.c;
        if (wVar != null) {
            wVar.a();
        }
        w wVar2 = new w(this.a, consentSettings);
        wVar2.a(this.e);
        wVar2.b(this.f);
        wVar2.d();
        this.c = wVar2;
    }

    private final boolean b() {
        Job job = this.d;
        return (job != null && job.isActive()) || c();
    }

    private final boolean c() {
        w wVar = this.c;
        return wVar != null && wVar.c();
    }

    /* access modifiers changed from: private */
    public final void d() {
        Function1<? super ConsentData, Unit> function1 = this.e;
        if (function1 != null) {
            function1.invoke(null);
        }
    }

    public final void a(Function1<? super ConsentData, Unit> function1) {
        this.e = function1;
    }

    public final void a(boolean z) {
        this.f = z;
    }

    public final void e() {
        if (!b()) {
            this.d = BuildersKt__Builders_commonKt.launch$default(a(), new d(CoroutineExceptionHandler.Key, this), (CoroutineStart) null, new e(this, (Continuation<? super e>) null), 2, (Object) null);
        }
    }
}
