package io.monedata.partners;

import android.content.Context;
import com.facebook.bolts.AppLinks;
import com.mbridge.msdk.MBridgeConstans;
import io.monedata.MonedataLog;
import io.monedata.Settings;
import io.monedata.consent.models.ConsentData;
import io.monedata.models.Extras;
import io.monedata.partners.bases.BaseConsentPartnerAdapter;
import io.monedata.partners.extensions.PartnerAdapterKt;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;

@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b'\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00014B%\b\u0007\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010/\u001a\u00020-\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010-¢\u0006\u0004\b1\u00102J#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000bJ\u001b\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u000bJ\u001b\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000bJ\u0016\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013J\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u000bJ\u0016\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003R$\u0010 \u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00138\u0006@BX\u000e¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b \u0010\"R$\u0010#\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00138\u0006@BX\u000e¢\u0006\f\n\u0004\b#\u0010!\u001a\u0004\b#\u0010\"R$\u0010$\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00138\u0006@BX\u000e¢\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b$\u0010\"R$\u0010%\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00138\u0006@BX\u000e¢\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\u00138\u0016XD¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010\"R\u0014\u0010+\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0011\u0010,\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b,\u0010\"\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lio/monedata/partners/PartnerAdapter;", "Lio/monedata/partners/bases/BaseConsentPartnerAdapter;", "Lkotlinx/coroutines/CoroutineScope;", "Landroid/content/Context;", "context", "Lio/monedata/models/Extras;", "extras", "", "internalInitialize", "(Landroid/content/Context;Lio/monedata/models/Extras;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreStart$core_productionRelease", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreStart", "onPostInitialize$core_productionRelease", "onPostInitialize", "internalStart$core_productionRelease", "internalStart", "internalStop$core_productionRelease", "internalStop", "", "value", "Lkotlinx/coroutines/Job;", "disable", "getExtras", "initialize", "Lio/monedata/consent/models/ConsentData;", "consent", "notifyConsentChange", "start", "stop", "warmUp", "<set-?>", "isDisabled", "Z", "()Z", "isInitialized", "isStarted", "isStopped", "requiresBackgroundLocation", "getRequiresBackgroundLocation", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "isReady", "", "id", "name", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public abstract class PartnerAdapter extends BaseConsentPartnerAdapter implements CoroutineScope {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final long TIMEOUT = 10000;
    /* access modifiers changed from: private */
    public boolean isDisabled;
    private boolean isInitialized;
    private boolean isStarted;
    /* access modifiers changed from: private */
    public boolean isStopped;
    private final boolean requiresBackgroundLocation;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lio/monedata/partners/PartnerAdapter$a;", "", "", "TIMEOUT", "J", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.partners.PartnerAdapter$disable$1", f = "PartnerAdapter.kt", i = {}, l = {154, 154}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ PartnerAdapter b;
        final /* synthetic */ boolean c;
        final /* synthetic */ Context d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(PartnerAdapter partnerAdapter, boolean z, Context context, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = partnerAdapter;
            this.c = z;
            this.d = context;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, this.d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.b.isDisabled = this.c;
                if (this.c) {
                    PartnerAdapter partnerAdapter = this.b;
                    Context context = this.d;
                    this.a = 1;
                    if (partnerAdapter.internalStop$core_productionRelease(context, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    PartnerAdapter partnerAdapter2 = this.b;
                    Context context2 = this.d;
                    this.a = 2;
                    if (partnerAdapter2.internalStart$core_productionRelease(context2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i == 1 || i == 2) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.partners.PartnerAdapter", f = "PartnerAdapter.kt", i = {}, l = {159}, m = "getExtras", n = {}, s = {})
    static final class c extends ContinuationImpl {
        /* synthetic */ Object a;
        final /* synthetic */ PartnerAdapter b;
        int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(PartnerAdapter partnerAdapter, Continuation<? super c> continuation) {
            super(continuation);
            this.b = partnerAdapter;
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.getExtras((Context) null, this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.partners.PartnerAdapter$initialize$1", f = "PartnerAdapter.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ PartnerAdapter b;
        final /* synthetic */ Context c;
        final /* synthetic */ Extras d;

        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "io.monedata.partners.PartnerAdapter$initialize$1$1", f = "PartnerAdapter.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
        static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int a;
            final /* synthetic */ PartnerAdapter b;
            final /* synthetic */ Context c;
            final /* synthetic */ Extras d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(PartnerAdapter partnerAdapter, Context context, Extras extras, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = partnerAdapter;
                this.c = context;
                this.d = extras;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, continuation);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PartnerAdapter partnerAdapter = this.b;
                    Context context = this.c;
                    Extras extras = this.d;
                    this.a = 1;
                    if (partnerAdapter.internalInitialize(context, extras, this) == coroutine_suspended) {
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
        d(PartnerAdapter partnerAdapter, Context context, Extras extras, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = partnerAdapter;
            this.c = context;
            this.d = extras;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, this.d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.b.isInitialized()) {
                    return Unit.INSTANCE;
                }
                a aVar = new a(this.b, this.c, this.d, (Continuation<? super a>) null);
                this.a = 1;
                if (TimeoutKt.withTimeoutOrNull(10000, aVar, this) == coroutine_suspended) {
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
    @DebugMetadata(c = "io.monedata.partners.PartnerAdapter", f = "PartnerAdapter.kt", i = {0, 0, 1, 1}, l = {68, 74, 84}, m = "internalInitialize", n = {"this", "context", "this", "context"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class e extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        final /* synthetic */ PartnerAdapter d;
        int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(PartnerAdapter partnerAdapter, Continuation<? super e> continuation) {
            super(continuation);
            this.d = partnerAdapter;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.internalInitialize((Context) null, (Extras) null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.partners.PartnerAdapter", f = "PartnerAdapter.kt", i = {0, 0, 1, 1}, l = {99, 105, 118}, m = "internalStart$core_productionRelease", n = {"this", "context", "this", "context"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class f extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        final /* synthetic */ PartnerAdapter d;
        int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(PartnerAdapter partnerAdapter, Continuation<? super f> continuation) {
            super(continuation);
            this.d = partnerAdapter;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.internalStart$core_productionRelease((Context) null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.partners.PartnerAdapter", f = "PartnerAdapter.kt", i = {0, 0}, l = {128, 141}, m = "internalStop$core_productionRelease", n = {"this", "context"}, s = {"L$0", "L$1"})
    static final class g extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        final /* synthetic */ PartnerAdapter d;
        int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(PartnerAdapter partnerAdapter, Continuation<? super g> continuation) {
            super(continuation);
            this.d = partnerAdapter;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.internalStop$core_productionRelease((Context) null, this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.partners.PartnerAdapter$notifyConsentChange$1", f = "PartnerAdapter.kt", i = {}, l = {179}, m = "invokeSuspend", n = {}, s = {})
    static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        private /* synthetic */ Object b;
        final /* synthetic */ Context c;
        final /* synthetic */ PartnerAdapter d;
        final /* synthetic */ ConsentData e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(Context context, PartnerAdapter partnerAdapter, ConsentData consentData, Continuation<? super h> continuation) {
            super(2, continuation);
            this.c = context;
            this.d = partnerAdapter;
            this.e = consentData;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            h hVar = new h(this.c, this.d, this.e, continuation);
            hVar.b = obj;
            return hVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.b;
                Context applicationContext = this.c.getApplicationContext();
                PartnerAdapter partnerAdapter = this.d;
                ConsentData consentData = this.e;
                Result.Companion companion = Result.Companion;
                Intrinsics.checkNotNullExpressionValue(applicationContext, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                this.a = 1;
                if (partnerAdapter.onConsentChange(applicationContext, consentData, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj2 = Result.m2344constructorimpl(ResultKt.createFailure(th));
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj2 = Result.m2344constructorimpl(Unit.INSTANCE);
            PartnerAdapter partnerAdapter2 = this.d;
            Throwable r6 = Result.m2347exceptionOrNullimpl(obj2);
            if (r6 != null) {
                MonedataLog monedataLog = MonedataLog.INSTANCE;
                monedataLog.d(partnerAdapter2.getName() + " adapter could not be notified of consent change", r6);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 7, 1})
    static final class i extends Lambda implements Function0<String> {
        public static final i a = new i();

        i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Background location is required";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.partners.PartnerAdapter$start$1", f = "PartnerAdapter.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
    static final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ PartnerAdapter b;
        final /* synthetic */ Context c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(PartnerAdapter partnerAdapter, Context context, Continuation<? super j> continuation) {
            super(2, continuation);
            this.b = partnerAdapter;
            this.c = context;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((j) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new j(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.b.isStopped = false;
                PartnerAdapter partnerAdapter = this.b;
                Context applicationContext = this.c.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                this.a = 1;
                if (partnerAdapter.internalStart$core_productionRelease(applicationContext, this) == coroutine_suspended) {
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
    @DebugMetadata(c = "io.monedata.partners.PartnerAdapter$stop$1", f = "PartnerAdapter.kt", i = {}, l = {201}, m = "invokeSuspend", n = {}, s = {})
    static final class k extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ PartnerAdapter b;
        final /* synthetic */ Context c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(PartnerAdapter partnerAdapter, Context context, Continuation<? super k> continuation) {
            super(2, continuation);
            this.b = partnerAdapter;
            this.c = context;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((k) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new k(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.b.isStopped = true;
                PartnerAdapter partnerAdapter = this.b;
                Context applicationContext = this.c.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                this.a = 1;
                if (partnerAdapter.internalStop$core_productionRelease(applicationContext, this) == coroutine_suspended) {
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PartnerAdapter(String str, String str2) {
        this(str, str2, (String) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PartnerAdapter(String str, String str2, String str3) {
        super(str, str2, str3);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PartnerAdapter(String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? null : str3);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0092 A[Catch:{ all -> 0x0053 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object internalInitialize(android.content.Context r9, io.monedata.models.Extras r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            java.lang.String r0 = "Initializing adapter: "
            boolean r1 = r11 instanceof io.monedata.partners.PartnerAdapter.e
            if (r1 == 0) goto L_0x0015
            r1 = r11
            io.monedata.partners.PartnerAdapter$e r1 = (io.monedata.partners.PartnerAdapter.e) r1
            int r2 = r1.e
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.e = r2
            goto L_0x001a
        L_0x0015:
            io.monedata.partners.PartnerAdapter$e r1 = new io.monedata.partners.PartnerAdapter$e
            r1.<init>(r8, r11)
        L_0x001a:
            java.lang.Object r11 = r1.c
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.e
            r4 = 3
            r5 = 1
            r6 = 2
            r7 = 0
            if (r3 == 0) goto L_0x0055
            if (r3 == r5) goto L_0x0047
            if (r3 == r6) goto L_0x003b
            if (r3 != r4) goto L_0x0033
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00d7
        L_0x0033:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003b:
            java.lang.Object r9 = r1.b
            android.content.Context r9 = (android.content.Context) r9
            java.lang.Object r10 = r1.a
            io.monedata.partners.PartnerAdapter r10 = (io.monedata.partners.PartnerAdapter) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0053 }
            goto L_0x0093
        L_0x0047:
            java.lang.Object r9 = r1.b
            android.content.Context r9 = (android.content.Context) r9
            java.lang.Object r10 = r1.a
            io.monedata.partners.PartnerAdapter r10 = (io.monedata.partners.PartnerAdapter) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0053 }
            goto L_0x0084
        L_0x0053:
            r11 = move-exception
            goto L_0x00b0
        L_0x0055:
            kotlin.ResultKt.throwOnFailure(r11)
            io.monedata.MonedataLog r11 = io.monedata.MonedataLog.INSTANCE     // Catch:{ all -> 0x00ae }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
            r3.<init>(r0)     // Catch:{ all -> 0x00ae }
            java.lang.String r0 = r8.getName()     // Catch:{ all -> 0x00ae }
            r3.append(r0)     // Catch:{ all -> 0x00ae }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00ae }
            io.monedata.MonedataLog.d$default((io.monedata.MonedataLog) r11, (java.lang.String) r0, (java.lang.Throwable) r7, (int) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x00ae }
            android.content.Context r11 = r9.getApplicationContext()     // Catch:{ all -> 0x00ae }
            java.lang.String r0 = "context.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)     // Catch:{ all -> 0x00ae }
            r1.a = r8     // Catch:{ all -> 0x00ae }
            r1.b = r9     // Catch:{ all -> 0x00ae }
            r1.e = r5     // Catch:{ all -> 0x00ae }
            java.lang.Object r10 = r8.onInitialize(r11, r10, r1)     // Catch:{ all -> 0x00ae }
            if (r10 != r2) goto L_0x0083
            return r2
        L_0x0083:
            r10 = r8
        L_0x0084:
            r10.isInitialized = r5     // Catch:{ all -> 0x0053 }
            r1.a = r10     // Catch:{ all -> 0x0053 }
            r1.b = r9     // Catch:{ all -> 0x0053 }
            r1.e = r6     // Catch:{ all -> 0x0053 }
            java.lang.Object r11 = r10.onPostInitialize$core_productionRelease(r9, r1)     // Catch:{ all -> 0x0053 }
            if (r11 != r2) goto L_0x0093
            return r2
        L_0x0093:
            io.monedata.MonedataLog r11 = io.monedata.MonedataLog.INSTANCE     // Catch:{ all -> 0x0053 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0053 }
            r0.<init>()     // Catch:{ all -> 0x0053 }
            java.lang.String r3 = r10.getName()     // Catch:{ all -> 0x0053 }
            r0.append(r3)     // Catch:{ all -> 0x0053 }
            java.lang.String r3 = " adapter has been initialized"
            r0.append(r3)     // Catch:{ all -> 0x0053 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0053 }
            io.monedata.MonedataLog.d$default((io.monedata.MonedataLog) r11, (java.lang.String) r0, (java.lang.Throwable) r7, (int) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0053 }
            goto L_0x00d7
        L_0x00ae:
            r11 = move-exception
            r10 = r8
        L_0x00b0:
            io.monedata.MonedataLog r0 = io.monedata.MonedataLog.INSTANCE
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r10.getName()
            r3.append(r5)
            java.lang.String r5 = " adapter has failed to initialize"
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r0.d((java.lang.String) r3, (java.lang.Throwable) r11)
            r1.a = r7
            r1.b = r7
            r1.e = r4
            java.lang.Object r9 = io.monedata.partners.extensions.PartnerAdapterKt.a(r10, r9, r11, r1)
            if (r9 != r2) goto L_0x00d7
            return r2
        L_0x00d7:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.partners.PartnerAdapter.internalInitialize(android.content.Context, io.monedata.models.Extras, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object onPreStart$suspendImpl(PartnerAdapter partnerAdapter, Context context, Continuation continuation) {
        PartnerAdapterKt.test(partnerAdapter, !partnerAdapter.getRequiresBackgroundLocation() || Settings.isBackgroundLocationEnabled(context), i.a);
        return Unit.INSTANCE;
    }

    public final Job disable(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new b(this, z, context, (Continuation<? super b>) null), 3, (Object) null);
    }

    public CoroutineContext getCoroutineContext() {
        return SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain());
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0057 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getExtras(android.content.Context r5, kotlin.coroutines.Continuation<? super io.monedata.models.Extras> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.monedata.partners.PartnerAdapter.c
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.monedata.partners.PartnerAdapter$c r0 = (io.monedata.partners.PartnerAdapter.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.partners.PartnerAdapter$c r0 = new io.monedata.partners.PartnerAdapter$c
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0046 }
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x0046 }
            r0.c = r3     // Catch:{ all -> 0x0046 }
            java.lang.Object r6 = r4.onExtras(r5, r0)     // Catch:{ all -> 0x0046 }
            if (r6 != r1) goto L_0x003f
            return r1
        L_0x003f:
            io.monedata.models.Extras r6 = (io.monedata.models.Extras) r6     // Catch:{ all -> 0x0046 }
            java.lang.Object r5 = kotlin.Result.m2344constructorimpl(r6)     // Catch:{ all -> 0x0046 }
            goto L_0x0051
        L_0x0046:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m2344constructorimpl(r5)
        L_0x0051:
            boolean r6 = kotlin.Result.m2350isFailureimpl(r5)
            if (r6 == 0) goto L_0x0058
            r5 = 0
        L_0x0058:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.partners.PartnerAdapter.getExtras(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean getRequiresBackgroundLocation() {
        return this.requiresBackgroundLocation;
    }

    public final Job initialize(Context context, Extras extras) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extras, AppLinks.KEY_NAME_EXTRAS);
        return BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new d(this, context, extras, (Continuation<? super d>) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object internalStart$core_productionRelease(android.content.Context r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            java.lang.String r0 = "Starting adapter: "
            boolean r1 = r11 instanceof io.monedata.partners.PartnerAdapter.f
            if (r1 == 0) goto L_0x0015
            r1 = r11
            io.monedata.partners.PartnerAdapter$f r1 = (io.monedata.partners.PartnerAdapter.f) r1
            int r2 = r1.e
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.e = r2
            goto L_0x001a
        L_0x0015:
            io.monedata.partners.PartnerAdapter$f r1 = new io.monedata.partners.PartnerAdapter$f
            r1.<init>(r9, r11)
        L_0x001a:
            java.lang.Object r11 = r1.c
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.e
            r4 = 3
            r5 = 1
            r6 = 2
            r7 = 0
            if (r3 == 0) goto L_0x0059
            if (r3 == r5) goto L_0x004a
            if (r3 == r6) goto L_0x003b
            if (r3 != r4) goto L_0x0033
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00e3
        L_0x0033:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003b:
            java.lang.Object r10 = r1.b
            android.content.Context r10 = (android.content.Context) r10
            java.lang.Object r0 = r1.a
            io.monedata.partners.PartnerAdapter r0 = (io.monedata.partners.PartnerAdapter) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0047 }
            goto L_0x009d
        L_0x0047:
            r11 = move-exception
            goto L_0x00bc
        L_0x004a:
            java.lang.Object r10 = r1.b
            android.content.Context r10 = (android.content.Context) r10
            java.lang.Object r3 = r1.a
            io.monedata.partners.PartnerAdapter r3 = (io.monedata.partners.PartnerAdapter) r3
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0056 }
            goto L_0x007a
        L_0x0056:
            r11 = move-exception
            r0 = r3
            goto L_0x00bc
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r11)
            boolean r11 = r9.isReady()
            if (r11 == 0) goto L_0x00e6
            boolean r11 = r9.isStarted
            if (r11 != 0) goto L_0x00e6
            boolean r11 = r9.isStopped
            if (r11 == 0) goto L_0x006c
            goto L_0x00e6
        L_0x006c:
            r1.a = r9     // Catch:{ all -> 0x00ba }
            r1.b = r10     // Catch:{ all -> 0x00ba }
            r1.e = r5     // Catch:{ all -> 0x00ba }
            java.lang.Object r11 = r9.onPreStart$core_productionRelease(r10, r1)     // Catch:{ all -> 0x00ba }
            if (r11 != r2) goto L_0x0079
            return r2
        L_0x0079:
            r3 = r9
        L_0x007a:
            io.monedata.MonedataLog r11 = io.monedata.MonedataLog.INSTANCE     // Catch:{ all -> 0x0056 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0056 }
            r8.<init>(r0)     // Catch:{ all -> 0x0056 }
            java.lang.String r0 = r3.getName()     // Catch:{ all -> 0x0056 }
            r8.append(r0)     // Catch:{ all -> 0x0056 }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x0056 }
            io.monedata.MonedataLog.d$default((io.monedata.MonedataLog) r11, (java.lang.String) r0, (java.lang.Throwable) r7, (int) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0056 }
            r1.a = r3     // Catch:{ all -> 0x0056 }
            r1.b = r10     // Catch:{ all -> 0x0056 }
            r1.e = r6     // Catch:{ all -> 0x0056 }
            java.lang.Object r11 = r3.onStart(r10, r1)     // Catch:{ all -> 0x0056 }
            if (r11 != r2) goto L_0x009c
            return r2
        L_0x009c:
            r0 = r3
        L_0x009d:
            r0.isStarted = r5     // Catch:{ all -> 0x0047 }
            io.monedata.MonedataLog r11 = io.monedata.MonedataLog.INSTANCE     // Catch:{ all -> 0x0047 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0047 }
            r3.<init>()     // Catch:{ all -> 0x0047 }
            java.lang.String r5 = r0.getName()     // Catch:{ all -> 0x0047 }
            r3.append(r5)     // Catch:{ all -> 0x0047 }
            java.lang.String r5 = " adapter has started"
            r3.append(r5)     // Catch:{ all -> 0x0047 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0047 }
            io.monedata.MonedataLog.d$default((io.monedata.MonedataLog) r11, (java.lang.String) r3, (java.lang.Throwable) r7, (int) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0047 }
            goto L_0x00e3
        L_0x00ba:
            r11 = move-exception
            r0 = r9
        L_0x00bc:
            io.monedata.MonedataLog r3 = io.monedata.MonedataLog.INSTANCE
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r0.getName()
            r5.append(r6)
            java.lang.String r6 = " adapter could not be started"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r3.d((java.lang.String) r5, (java.lang.Throwable) r11)
            r1.a = r7
            r1.b = r7
            r1.e = r4
            java.lang.Object r10 = io.monedata.partners.extensions.PartnerAdapterKt.a(r0, r10, r11, r1)
            if (r10 != r2) goto L_0x00e3
            return r2
        L_0x00e3:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00e6:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.partners.PartnerAdapter.internalStart$core_productionRelease(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object internalStop$core_productionRelease(android.content.Context r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            java.lang.String r0 = "Stopping adapter: "
            boolean r1 = r10 instanceof io.monedata.partners.PartnerAdapter.g
            if (r1 == 0) goto L_0x0015
            r1 = r10
            io.monedata.partners.PartnerAdapter$g r1 = (io.monedata.partners.PartnerAdapter.g) r1
            int r2 = r1.e
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.e = r2
            goto L_0x001a
        L_0x0015:
            io.monedata.partners.PartnerAdapter$g r1 = new io.monedata.partners.PartnerAdapter$g
            r1.<init>(r8, r10)
        L_0x001a:
            java.lang.Object r10 = r1.c
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.e
            r4 = 1
            r5 = 2
            r6 = 0
            if (r3 == 0) goto L_0x0046
            if (r3 == r4) goto L_0x0038
            if (r3 != r5) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00b3
        L_0x0030:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0038:
            java.lang.Object r9 = r1.b
            android.content.Context r9 = (android.content.Context) r9
            java.lang.Object r0 = r1.a
            io.monedata.partners.PartnerAdapter r0 = (io.monedata.partners.PartnerAdapter) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0044 }
            goto L_0x006c
        L_0x0044:
            r10 = move-exception
            goto L_0x008c
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r10)
            io.monedata.MonedataLog r10 = io.monedata.MonedataLog.INSTANCE     // Catch:{ all -> 0x008a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008a }
            r3.<init>(r0)     // Catch:{ all -> 0x008a }
            java.lang.String r0 = r8.getName()     // Catch:{ all -> 0x008a }
            r3.append(r0)     // Catch:{ all -> 0x008a }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x008a }
            io.monedata.MonedataLog.d$default((io.monedata.MonedataLog) r10, (java.lang.String) r0, (java.lang.Throwable) r6, (int) r5, (java.lang.Object) r6)     // Catch:{ all -> 0x008a }
            r1.a = r8     // Catch:{ all -> 0x008a }
            r1.b = r9     // Catch:{ all -> 0x008a }
            r1.e = r4     // Catch:{ all -> 0x008a }
            java.lang.Object r10 = r8.onStop(r9, r1)     // Catch:{ all -> 0x008a }
            if (r10 != r2) goto L_0x006b
            return r2
        L_0x006b:
            r0 = r8
        L_0x006c:
            r10 = 0
            r0.isStarted = r10     // Catch:{ all -> 0x0044 }
            io.monedata.MonedataLog r10 = io.monedata.MonedataLog.INSTANCE     // Catch:{ all -> 0x0044 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0044 }
            r3.<init>()     // Catch:{ all -> 0x0044 }
            java.lang.String r4 = r0.getName()     // Catch:{ all -> 0x0044 }
            r3.append(r4)     // Catch:{ all -> 0x0044 }
            java.lang.String r4 = " adapter has stopped"
            r3.append(r4)     // Catch:{ all -> 0x0044 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0044 }
            io.monedata.MonedataLog.d$default((io.monedata.MonedataLog) r10, (java.lang.String) r3, (java.lang.Throwable) r6, (int) r5, (java.lang.Object) r6)     // Catch:{ all -> 0x0044 }
            goto L_0x00b3
        L_0x008a:
            r10 = move-exception
            r0 = r8
        L_0x008c:
            io.monedata.MonedataLog r3 = io.monedata.MonedataLog.INSTANCE
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = r0.getName()
            r4.append(r7)
            java.lang.String r7 = " adapter could not be stopped"
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            r3.d((java.lang.String) r4, (java.lang.Throwable) r10)
            r1.a = r6
            r1.b = r6
            r1.e = r5
            java.lang.Object r9 = io.monedata.partners.extensions.PartnerAdapterKt.a(r0, r9, r10, r1)
            if (r9 != r2) goto L_0x00b3
            return r2
        L_0x00b3:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.partners.PartnerAdapter.internalStop$core_productionRelease(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean isDisabled() {
        return this.isDisabled;
    }

    public final boolean isInitialized() {
        return this.isInitialized;
    }

    public final boolean isReady() {
        return !this.isDisabled && this.isInitialized;
    }

    public final boolean isStarted() {
        return this.isStarted;
    }

    public final boolean isStopped() {
        return this.isStopped;
    }

    public final Job notifyConsentChange(Context context, ConsentData consentData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(consentData, "consent");
        return BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new h(context, this, consentData, (Continuation<? super h>) null), 3, (Object) null);
    }

    public Object onPostInitialize$core_productionRelease(Context context, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    public Object onPreStart$core_productionRelease(Context context, Continuation<? super Unit> continuation) {
        return onPreStart$suspendImpl(this, context, continuation);
    }

    public final Job start(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new j(this, context, (Continuation<? super j>) null), 3, (Object) null);
    }

    public final Job stop(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new k(this, context, (Continuation<? super k>) null), 3, (Object) null);
    }

    public final void warmUp(Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!this.isInitialized) {
            try {
                Result.Companion companion = Result.Companion;
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                onWarmUp(applicationContext);
                obj = Result.m2344constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
            }
            Throwable r0 = Result.m2347exceptionOrNullimpl(obj);
            if (r0 != null) {
                MonedataLog monedataLog = MonedataLog.INSTANCE;
                monedataLog.d(getName() + " adapter could not be warmed up", r0);
            }
            if (Result.m2351isSuccessimpl(obj)) {
                Unit unit = (Unit) obj;
                MonedataLog monedataLog2 = MonedataLog.INSTANCE;
                MonedataLog.d$default(monedataLog2, getName() + " adapter has warmed up", (Throwable) null, 2, (Object) null);
            }
        }
    }
}
