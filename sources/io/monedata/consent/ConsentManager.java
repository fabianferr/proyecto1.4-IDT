package io.monedata.consent;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.monedata.BuildConfig;
import io.monedata.consent.models.ConsentData;
import io.monedata.consent.models.ConsentSource;
import io.monedata.i1;
import io.monedata.j1;
import io.monedata.t1;
import io.monedata.u1;
import io.monedata.v1;
import io.monedata.x;
import io.monedata.x1;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0013\u001a\u00020\u000f2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u0010J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u0017J\u0015\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u001dJ\u0015\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u001fJ\u0015\u0010 \u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010!J!\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010$J\u001e\u0010%\u001a\u00020\u000f2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u0010J:\u0010&\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010'\u001a\u00020\u00122\u001e\b\u0002\u0010\u0014\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rj\u0004\u0018\u0001`(H\u0007J:\u0010)\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010'\u001a\u00020\u00122\u001e\b\u0002\u0010\u0014\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rj\u0004\u0018\u0001`(H\u0007J+\u0010*\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u0016\u0010*\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u0012J\u0016\u0010/\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u0004J\u0019\u0010+\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u00101J!\u00102\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010$R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u00100\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {"Lio/monedata/consent/ConsentManager;", "", "()V", "KEY", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "coroutineScope$delegate", "Lkotlin/Lazy;", "listeners", "", "Lkotlin/Function1;", "Lio/monedata/consent/models/ConsentData;", "", "Lio/monedata/consent/ConsentListener;", "tcfMonitorEnabled", "", "addListener", "listener", "canCollectPersonalData", "context", "Landroid/content/Context;", "enableTcfMonitor", "enable", "exists", "get", "initialize", "initialize$core_productionRelease", "invalidate", "invalidate$core_productionRelease", "isGranted", "(Landroid/content/Context;)Ljava/lang/Boolean;", "notifyChange", "consent", "(Landroid/content/Context;Lio/monedata/consent/models/ConsentData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeListener", "request", "withOptOut", "Lio/monedata/consent/ConsentRequestListener;", "requestOnce", "set", "submit", "set$core_productionRelease", "(Landroid/content/Context;Lio/monedata/consent/models/ConsentData;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "granted", "setIabString", "value", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "core_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ConsentManager {
    public static final ConsentManager INSTANCE = new ConsentManager();
    private static final String KEY = "consent";
    private static final Lazy coroutineScope$delegate = LazyKt.lazy(a.a);
    /* access modifiers changed from: private */
    public static final List<Function1<ConsentData, Unit>> listeners = new ArrayList();
    private static boolean tcfMonitorEnabled = true;

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

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.consent.ConsentManager$invalidate$1", f = "ConsentManager.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Context b;
        final /* synthetic */ ConsentData c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, ConsentData consentData, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = context;
            this.c = consentData;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ConsentManager consentManager = ConsentManager.INSTANCE;
                Context context = this.b;
                ConsentData consentData = this.c;
                this.a = 1;
                if (consentManager.notifyChange(context, consentData, this) == coroutine_suspended) {
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
    @DebugMetadata(c = "io.monedata.consent.ConsentManager$notifyChange$2", f = "ConsentManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Context b;
        final /* synthetic */ ConsentData c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, ConsentData consentData, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = context;
            this.c = consentData;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a == 0) {
                ResultKt.throwOnFailure(obj);
                i1.a(j1.a, this.b, this.c);
                List<Function1> access$getListeners$p = ConsentManager.listeners;
                ConsentData consentData = this.c;
                for (Function1 invoke : access$getListeners$p) {
                    invoke.invoke(consentData);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.consent.ConsentManager", f = "ConsentManager.kt", i = {0, 0, 0}, l = {128, 131}, m = "set$core_productionRelease", n = {"this", "context", "consent"}, s = {"L$0", "L$1", "L$2"})
    static final class d extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        final /* synthetic */ ConsentManager e;
        int f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ConsentManager consentManager, Continuation<? super d> continuation) {
            super(continuation);
            this.e = consentManager;
        }

        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return this.e.set$core_productionRelease((Context) null, (ConsentData) null, false, this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/content/SharedPreferences$Editor;", "", "a", "(Landroid/content/SharedPreferences$Editor;)V"}, k = 3, mv = {1, 7, 1})
    static final class e extends Lambda implements Function1<SharedPreferences.Editor, Unit> {
        final /* synthetic */ ConsentData a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(ConsentData consentData) {
            super(1);
            this.a = consentData;
        }

        public final void a(SharedPreferences.Editor editor) {
            Intrinsics.checkNotNullParameter(editor, "$this$edit");
            u1.a(editor, ConsentManager.KEY, this.a, Reflection.getOrCreateKotlinClass(ConsentData.class));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((SharedPreferences.Editor) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.consent.ConsentManager$set$3", f = "ConsentManager.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
    static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Context b;
        final /* synthetic */ ConsentData c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(Context context, ConsentData consentData, Continuation<? super f> continuation) {
            super(2, continuation);
            this.b = context;
            this.c = consentData;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new f(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ConsentManager consentManager = ConsentManager.INSTANCE;
                Context context = this.b;
                ConsentData consentData = this.c;
                this.a = 1;
                if (consentManager.update(context, consentData, this) == coroutine_suspended) {
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
    @DebugMetadata(c = "io.monedata.consent.ConsentManager$setIabString$2", f = "ConsentManager.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {})
    static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Context b;
        final /* synthetic */ ConsentData c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(Context context, ConsentData consentData, Continuation<? super g> continuation) {
            super(2, continuation);
            this.b = context;
            this.c = consentData;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new g(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ConsentManager consentManager = ConsentManager.INSTANCE;
                Context context = this.b;
                ConsentData consentData = this.c;
                this.a = 1;
                if (consentManager.update(context, consentData, this) == coroutine_suspended) {
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

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.consent.ConsentManager", f = "ConsentManager.kt", i = {}, l = {83}, m = "update", n = {}, s = {})
    static final class h extends ContinuationImpl {
        /* synthetic */ Object a;
        final /* synthetic */ ConsentManager b;
        int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(ConsentManager consentManager, Continuation<? super h> continuation) {
            super(continuation);
            this.b = consentManager;
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.update((Context) null, (ConsentData) null, this);
        }
    }

    private ConsentManager() {
    }

    private final CoroutineScope getCoroutineScope() {
        return (CoroutineScope) coroutineScope$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Object notifyChange(Context context, ConsentData consentData, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new c(context, consentData, (Continuation<? super c>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public static /* synthetic */ void request$default(ConsentManager consentManager, Context context, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        consentManager.request(context, z, function1);
    }

    public static /* synthetic */ void requestOnce$default(ConsentManager consentManager, Context context, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        consentManager.requestOnce(context, z, function1);
    }

    /* access modifiers changed from: private */
    public final Object submit(Context context, Continuation<? super Unit> continuation) {
        if (!exists(context)) {
            return Unit.INSTANCE;
        }
        Object a2 = ConsentSubmitWorker.a.a(context, continuation);
        return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object update(android.content.Context r8, io.monedata.consent.models.ConsentData r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof io.monedata.consent.ConsentManager.h
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.monedata.consent.ConsentManager$h r0 = (io.monedata.consent.ConsentManager.h) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.consent.ConsentManager$h r0 = new io.monedata.consent.ConsentManager$h
            r0.<init>(r7, r10)
        L_0x0018:
            java.lang.Object r10 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0064
        L_0x002b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r10)
            io.monedata.MonedataLog r10 = io.monedata.MonedataLog.INSTANCE
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r6 = "Updating consent: "
            r2.<init>(r6)
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            io.monedata.MonedataLog.v$default((io.monedata.MonedataLog) r10, (java.lang.String) r2, (java.lang.Throwable) r5, (int) r4, (java.lang.Object) r5)
            io.monedata.consent.models.ConsentData r2 = r7.get(r8)
            boolean r2 = r9.isEqual$core_productionRelease(r2)
            if (r2 == 0) goto L_0x005b
            java.lang.String r8 = "Consent is equal, skipping"
            io.monedata.MonedataLog.v$default((io.monedata.MonedataLog) r10, (java.lang.String) r8, (java.lang.Throwable) r5, (int) r4, (java.lang.Object) r5)
        L_0x0058:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x005b:
            r0.c = r3
            java.lang.Object r10 = r7.set$core_productionRelease(r8, r9, r3, r0)
            if (r10 != r1) goto L_0x0064
            return r1
        L_0x0064:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r8 = r10.booleanValue()
            if (r8 != 0) goto L_0x006f
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x006f:
            io.monedata.MonedataLog r8 = io.monedata.MonedataLog.INSTANCE
            java.lang.String r9 = "Consent was updated"
            io.monedata.MonedataLog.v$default((io.monedata.MonedataLog) r8, (java.lang.String) r9, (java.lang.Throwable) r5, (int) r4, (java.lang.Object) r5)
            goto L_0x0058
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.consent.ConsentManager.update(android.content.Context, io.monedata.consent.models.ConsentData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void addListener(Function1<? super ConsentData, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        listeners.add(function1);
    }

    public final boolean canCollectPersonalData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConsentData consentData = get(context);
        return consentData != null && consentData.canCollectPersonalData(context);
    }

    public final void enableTcfMonitor(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        tcfMonitorEnabled = z;
        if (z) {
            x1.c.b(context);
        } else {
            x1.c.c(context);
        }
    }

    public final boolean exists(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(BuildConfig.LIBRARY_PACKAGE_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(\"io.monedata\", MODE_PRIVATE)");
        return sharedPreferences.contains(KEY);
    }

    public final ConsentData get(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(BuildConfig.LIBRARY_PACKAGE_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(\"io.monedata\", MODE_PRIVATE)");
        return (ConsentData) u1.a(sharedPreferences, KEY, Reflection.getOrCreateKotlinClass(ConsentData.class));
    }

    public final void initialize$core_productionRelease(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        t1.c.b(context);
        if (tcfMonitorEnabled) {
            x1.c.b(context);
        }
    }

    public final void invalidate$core_productionRelease(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConsentData consentData = get(context);
        if (consentData != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new b(context, consentData, (Continuation<? super b>) null), 3, (Object) null);
        }
    }

    public final Boolean isGranted(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConsentData consentData = get(context);
        if (consentData != null) {
            return Boolean.valueOf(consentData.isGranted());
        }
        return null;
    }

    public final void removeListener(Function1<? super ConsentData, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        listeners.remove(function1);
    }

    @Deprecated(message = "Use a third-party CMP that follows the IAB TCF")
    public final void request(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        request$default(this, context, false, (Function1) null, 6, (Object) null);
    }

    @Deprecated(message = "Use a third-party CMP that follows the IAB TCF")
    public final void request(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        request$default(this, context, z, (Function1) null, 4, (Object) null);
    }

    @Deprecated(message = "Use a third-party CMP that follows the IAB TCF")
    public final void request(Context context, boolean z, Function1<? super ConsentData, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        x xVar = new x(context);
        xVar.a(function1);
        xVar.a(z);
        xVar.e();
    }

    @Deprecated(message = "Use a third-party CMP that follows with the IAB TCF")
    public final void requestOnce(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        requestOnce$default(this, context, false, (Function1) null, 6, (Object) null);
    }

    @Deprecated(message = "Use a third-party CMP that follows with the IAB TCF")
    public final void requestOnce(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        requestOnce$default(this, context, z, (Function1) null, 4, (Object) null);
    }

    @Deprecated(message = "Use a third-party CMP that follows with the IAB TCF")
    public final void requestOnce(Context context, boolean z, Function1<? super ConsentData, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConsentData consentData = get(context);
        if (consentData == null) {
            request(context, z, function1);
        } else if (function1 != null) {
            function1.invoke(consentData);
        }
    }

    public final void set(Context context, boolean z) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new f(context2, new ConsentData((Date) null, z, (String) null, ConsentSource.EXTERNAL, 5, (DefaultConstructorMarker) null), (Continuation<? super f>) null), 3, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: io.monedata.consent.models.ConsentData} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object set$core_productionRelease(android.content.Context r6, io.monedata.consent.models.ConsentData r7, boolean r8, kotlin.coroutines.Continuation<? super java.lang.Boolean> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.monedata.consent.ConsentManager.d
            if (r0 == 0) goto L_0x0013
            r0 = r9
            io.monedata.consent.ConsentManager$d r0 = (io.monedata.consent.ConsentManager.d) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.consent.ConsentManager$d r0 = new io.monedata.consent.ConsentManager$d
            r0.<init>(r5, r9)
        L_0x0018:
            java.lang.Object r9 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x008d
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.c
            r7 = r6
            io.monedata.consent.models.ConsentData r7 = (io.monedata.consent.models.ConsentData) r7
            java.lang.Object r6 = r0.b
            android.content.Context r6 = (android.content.Context) r6
            java.lang.Object r8 = r0.a
            io.monedata.consent.ConsentManager r8 = (io.monedata.consent.ConsentManager) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x007d
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r9)
            io.monedata.consent.models.ConsentData r9 = r5.get(r6)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r7)
            r2 = 0
            if (r9 == 0) goto L_0x0058
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r6
        L_0x0058:
            java.lang.String r9 = "io.monedata"
            android.content.SharedPreferences r9 = r6.getSharedPreferences(r9, r2)
            java.lang.String r2 = "getSharedPreferences(\"io.monedata\", MODE_PRIVATE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)
            io.monedata.consent.ConsentManager$e r2 = new io.monedata.consent.ConsentManager$e
            r2.<init>(r7)
            io.monedata.u1.a(r9, r2)
            if (r8 == 0) goto L_0x007c
            r0.a = r5
            r0.b = r6
            r0.c = r7
            r0.f = r4
            java.lang.Object r8 = r5.submit(r6, r0)
            if (r8 != r1) goto L_0x007c
            return r1
        L_0x007c:
            r8 = r5
        L_0x007d:
            r9 = 0
            r0.a = r9
            r0.b = r9
            r0.c = r9
            r0.f = r3
            java.lang.Object r6 = r8.notifyChange(r6, r7, r0)
            if (r6 != r1) goto L_0x008d
            return r1
        L_0x008d:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.consent.ConsentManager.set$core_productionRelease(android.content.Context, io.monedata.consent.models.ConsentData, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setIabString(Context context, String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "value");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m2344constructorimpl(v1.a.a(str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2350isFailureimpl(obj)) {
            obj = null;
        }
        ConsentData consentData = (ConsentData) obj;
        if (consentData != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new g(context, consentData, (Continuation<? super g>) null), 3, (Object) null);
            return;
        }
        throw new IllegalArgumentException(("Invalid IAB TC string: " + str).toString());
    }
}
