package com.wortise.ads;

import android.content.Context;
import android.content.ContextWrapper;
import com.wortise.ads.consent.ConsentDialog;
import java.util.Locale;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0013\u0010\u0006\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\u0002R\u001b\u0010\r\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0006\u0010\u0019R\"\u0010\u001a\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u0006\u0010\u001d\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/wortise/ads/s1;", "Landroid/content/ContextWrapper;", "", "f", "Lcom/wortise/ads/w1;", "settings", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope$delegate", "Lkotlin/Lazy;", "()Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "", "d", "()Z", "isActive", "e", "isShowing", "Lcom/wortise/ads/consent/ConsentDialog$Listener;", "listener", "Lcom/wortise/ads/consent/ConsentDialog$Listener;", "b", "()Lcom/wortise/ads/consent/ConsentDialog$Listener;", "(Lcom/wortise/ads/consent/ConsentDialog$Listener;)V", "withOptOut", "Z", "c", "(Z)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: ConsentDialogController.kt */
public final class s1 extends ContextWrapper {
    private final Lazy a = LazyKt.lazy(a.a);
    private ConsentDialog b;
    private Job c;
    private ConsentDialog.Listener d;
    private boolean e = true;

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: ConsentDialogController.kt */
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

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.consent.ConsentDialogController", f = "ConsentDialogController.kt", i = {0}, l = {73}, m = "load", n = {"this"}, s = {"L$0"})
    /* compiled from: ConsentDialogController.kt */
    static final class b extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ s1 c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(s1 s1Var, Continuation<? super b> continuation) {
            super(continuation);
            this.c = s1Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.a((Continuation<? super Unit>) this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/wortise/ads/w5;", "Lcom/wortise/ads/w1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.consent.ConsentDialogController$load$response$1", f = "ConsentDialogController.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: ConsentDialogController.kt */
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super w5<w1>>, Object> {
        int a;
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = str;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super w5<w1>> continuation) {
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
                u1 a2 = v1.a();
                String str = this.b;
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                String language = locale.getLanguage();
                this.a = 1;
                obj = a2.a(str, language, this);
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

    @Metadata(bv = {}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    /* compiled from: CoroutineExceptionHandler.kt */
    public static final class d extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        final /* synthetic */ s1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(CoroutineExceptionHandler.Key key, s1 s1Var) {
            super(key);
            this.a = s1Var;
        }

        public void handleException(CoroutineContext coroutineContext, Throwable th) {
            this.a.f();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.consent.ConsentDialogController$show$1", f = "ConsentDialogController.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: ConsentDialogController.kt */
    static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ s1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(s1 s1Var, Continuation<? super e> continuation) {
            super(2, continuation);
            this.b = s1Var;
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
                s1 s1Var = this.b;
                this.a = 1;
                if (s1Var.a((Continuation<? super Unit>) this) == coroutine_suspended) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s1(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean d() {
        Job job = this.c;
        return (job != null && job.isActive()) || e();
    }

    private final boolean e() {
        ConsentDialog consentDialog = this.b;
        return consentDialog != null && consentDialog.isShowing();
    }

    /* access modifiers changed from: private */
    public final void f() {
        ConsentDialog.Listener listener = this.d;
        if (listener != null) {
            listener.onConsentRequestFinished((Boolean) null);
        }
    }

    public final ConsentDialog.Listener b() {
        return this.d;
    }

    public final boolean c() {
        return this.e;
    }

    public final void g() {
        if (!d()) {
            this.c = BuildersKt__Builders_commonKt.launch$default(a(), new d(CoroutineExceptionHandler.Key, this), (CoroutineStart) null, new e(this, (Continuation<? super e>) null), 2, (Object) null);
        }
    }

    private final CoroutineScope a() {
        return (CoroutineScope) this.a.getValue();
    }

    public final void a(ConsentDialog.Listener listener) {
        this.d = listener;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    private final void a(w1 w1Var) {
        ConsentDialog consentDialog = this.b;
        if (consentDialog != null) {
            consentDialog.dismiss();
        }
        ConsentDialog consentDialog2 = new ConsentDialog(this, w1Var);
        consentDialog2.setListener(b());
        consentDialog2.setWithOptOut(c());
        consentDialog2.show();
        Unit unit = Unit.INSTANCE;
        this.b = consentDialog2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.wortise.ads.s1.b
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.wortise.ads.s1$b r0 = (com.wortise.ads.s1.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.s1$b r0 = new com.wortise.ads.s1$b
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.a
            com.wortise.ads.s1 r0 = (com.wortise.ads.s1) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0054
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r7)
            com.wortise.ads.AdSettings r7 = com.wortise.ads.AdSettings.INSTANCE
            java.lang.String r7 = r7.requireAssetKey$sdk_productionRelease(r6)
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            com.wortise.ads.s1$c r4 = new com.wortise.ads.s1$c
            r5 = 0
            r4.<init>(r7, r5)
            r0.a = r6
            r0.d = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r0)
            if (r7 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r0 = r6
        L_0x0054:
            com.wortise.ads.w5 r7 = (com.wortise.ads.w5) r7
            java.lang.Object r7 = com.wortise.ads.z5.a(r7)
            com.wortise.ads.w1 r7 = (com.wortise.ads.w1) r7
            r1 = 3
            java.lang.String[] r1 = new java.lang.String[r1]
            java.lang.String r2 = r7.a()
            r4 = 0
            r1[r4] = r2
            java.lang.String r2 = r7.b()
            r1[r3] = r2
            java.lang.String r2 = r7.c()
            r3 = 2
            r1[r3] = r2
            com.wortise.ads.h6.a((java.lang.String[]) r1)
            r0.a((com.wortise.ads.w1) r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.s1.a(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
