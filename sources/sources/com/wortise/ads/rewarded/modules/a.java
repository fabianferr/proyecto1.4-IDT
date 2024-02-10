package com.wortise.ads.rewarded.modules;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.wortise.ads.AdFormat;
import com.wortise.ads.AdResponse;
import com.wortise.ads.g;
import com.wortise.ads.k3;
import com.wortise.ads.rewarded.models.Reward;
import com.wortise.ads.rewarded.modules.BaseRewardedModule;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u001b\u0018\u0000 *2\u00020\u0001:\u0001+B\u001f\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J%\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ#\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\rJ\b\u0010\u000e\u001a\u00020\u0002H\u0014J\u0013\u0010\u000f\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u0004\u0018\u00010\u001e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lcom/wortise/ads/rewarded/modules/a;", "Lcom/wortise/ads/rewarded/modules/BaseRewardedModule;", "", "invalidate", "", "adUnitId", "Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;", "adRequest", "Lcom/google/android/gms/ads/rewarded/RewardedAd;", "load", "(Ljava/lang/String;Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "adUnits", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDestroy", "onLoad", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "onShow", "Ljava/util/concurrent/atomic/AtomicBoolean;", "requested", "Ljava/util/concurrent/atomic/AtomicBoolean;", "rewardedAd", "Lcom/google/android/gms/ads/rewarded/RewardedAd;", "Lcom/google/android/gms/ads/OnUserEarnedRewardListener;", "earnedRewardListener", "Lcom/google/android/gms/ads/OnUserEarnedRewardListener;", "com/wortise/ads/rewarded/modules/a$b", "fullScreenContentCallback", "Lcom/wortise/ads/rewarded/modules/a$b;", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "activity", "Landroid/content/Context;", "context", "Lcom/wortise/ads/AdResponse;", "adResponse", "Lcom/wortise/ads/rewarded/modules/BaseRewardedModule$Listener;", "listener", "<init>", "(Landroid/content/Context;Lcom/wortise/ads/AdResponse;Lcom/wortise/ads/rewarded/modules/BaseRewardedModule$Listener;)V", "Companion", "a", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GoogleRewardedModule.kt */
public final class a extends BaseRewardedModule {
    public static final C0196a Companion = new C0196a((DefaultConstructorMarker) null);
    private static final long TIMEOUT = 10000;
    private final OnUserEarnedRewardListener earnedRewardListener = new a$$ExternalSyntheticLambda0(this);
    private final b fullScreenContentCallback = new b(this);
    private final AtomicBoolean requested = new AtomicBoolean(false);
    private RewardedAd rewardedAd;

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/wortise/ads/rewarded/modules/a$a;", "", "Lcom/wortise/ads/AdResponse;", "response", "", "a", "", "TIMEOUT", "J", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.wortise.ads.rewarded.modules.a$a  reason: collision with other inner class name */
    /* compiled from: GoogleRewardedModule.kt */
    public static final class C0196a {
        private C0196a() {
        }

        public /* synthetic */ C0196a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean a(AdResponse adResponse) {
            Intrinsics.checkNotNullParameter(adResponse, "response");
            return adResponse.a(AdFormat.GOOGLE);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/wortise/ads/rewarded/modules/a$b", "Lcom/google/android/gms/ads/FullScreenContentCallback;", "", "onAdDismissedFullScreenContent", "Lcom/google/android/gms/ads/AdError;", "error", "onAdFailedToShowFullScreenContent", "onAdShowedFullScreenContent", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: GoogleRewardedModule.kt */
    public static final class b extends FullScreenContentCallback {
        final /* synthetic */ a a;

        b(a aVar) {
            this.a = aVar;
        }

        public void onAdDismissedFullScreenContent() {
            this.a.deliverDismiss();
        }

        public void onAdFailedToShowFullScreenContent(AdError adError) {
            Intrinsics.checkNotNullParameter(adError, "error");
            this.a.deliverError(com.wortise.ads.AdError.UNSPECIFIED);
        }

        public void onAdShowedFullScreenContent() {
            this.a.deliverShow();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    /* compiled from: SafeCollector.common.kt */
    public static final class c implements Flow<RewardedAd> {
        final /* synthetic */ Flow a;
        final /* synthetic */ a b;
        final /* synthetic */ AdManagerAdRequest c;

        @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
        /* renamed from: com.wortise.ads.rewarded.modules.a$c$a  reason: collision with other inner class name */
        /* compiled from: Collect.kt */
        public static final class C0197a implements FlowCollector<String> {
            final /* synthetic */ FlowCollector a;
            final /* synthetic */ a b;
            final /* synthetic */ AdManagerAdRequest c;

            @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
            @DebugMetadata(c = "com.wortise.ads.rewarded.modules.GoogleRewardedModule$load$$inlined$firstNotNull$1$2", f = "GoogleRewardedModule.kt", i = {0}, l = {138, 139}, m = "emit", n = {"$this$mapNotNull_u24lambda_u2d5"}, s = {"L$0"})
            /* renamed from: com.wortise.ads.rewarded.modules.a$c$a$a  reason: collision with other inner class name */
            public static final class C0198a extends ContinuationImpl {
                /* synthetic */ Object a;
                int b;
                Object c;
                final /* synthetic */ C0197a d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0198a(C0197a aVar, Continuation continuation) {
                    super(continuation);
                    this.d = aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return this.d.emit((Object) null, this);
                }
            }

            public C0197a(FlowCollector flowCollector, a aVar, AdManagerAdRequest adManagerAdRequest) {
                this.a = flowCollector;
                this.b = aVar;
                this.c = adManagerAdRequest;
            }

            /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof com.wortise.ads.rewarded.modules.a.c.C0197a.C0198a
                    if (r0 == 0) goto L_0x0013
                    r0 = r9
                    com.wortise.ads.rewarded.modules.a$c$a$a r0 = (com.wortise.ads.rewarded.modules.a.c.C0197a.C0198a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L_0x0018
                L_0x0013:
                    com.wortise.ads.rewarded.modules.a$c$a$a r0 = new com.wortise.ads.rewarded.modules.a$c$a$a
                    r0.<init>(r7, r9)
                L_0x0018:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.b
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L_0x003c
                    if (r2 == r4) goto L_0x0034
                    if (r2 != r3) goto L_0x002c
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L_0x0064
                L_0x002c:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L_0x0034:
                    java.lang.Object r8 = r0.c
                    kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L_0x0055
                L_0x003c:
                    kotlin.ResultKt.throwOnFailure(r9)
                    kotlinx.coroutines.flow.FlowCollector r9 = r7.a
                    java.lang.String r8 = (java.lang.String) r8
                    com.wortise.ads.rewarded.modules.a r2 = r7.b
                    com.google.android.gms.ads.admanager.AdManagerAdRequest r5 = r7.c
                    r0.c = r9
                    r0.b = r4
                    java.lang.Object r8 = r2.load(r8, r5, r0)
                    if (r8 != r1) goto L_0x0052
                    return r1
                L_0x0052:
                    r6 = r9
                    r9 = r8
                    r8 = r6
                L_0x0055:
                    if (r9 != 0) goto L_0x0058
                    goto L_0x0064
                L_0x0058:
                    r2 = 0
                    r0.c = r2
                    r0.b = r3
                    java.lang.Object r8 = r8.emit(r9, r0)
                    if (r8 != r1) goto L_0x0064
                    return r1
                L_0x0064:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.rewarded.modules.a.c.C0197a.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public c(Flow flow, a aVar, AdManagerAdRequest adManagerAdRequest) {
            this.a = flow;
            this.b = aVar;
            this.c = adManagerAdRequest;
        }

        public Object collect(FlowCollector flowCollector, Continuation continuation) {
            Object collect = this.a.collect(new C0197a(flowCollector, this.b, this.c), continuation);
            if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return collect;
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/wortise/ads/g$a;", "Lcom/google/android/gms/ads/rewarded/RewardedAd;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.rewarded.modules.GoogleRewardedModule$load$2", f = "GoogleRewardedModule.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: GoogleRewardedModule.kt */
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super g.a<RewardedAd>>, Object> {
        int a;
        final /* synthetic */ a b;
        final /* synthetic */ String c;
        final /* synthetic */ AdManagerAdRequest d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar, String str, AdManagerAdRequest adManagerAdRequest, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = aVar;
            this.c = str;
            this.d = adManagerAdRequest;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super g.a<RewardedAd>> continuation) {
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
                g gVar = g.a;
                Context access$getContext = this.b.getContext();
                String str = this.c;
                AdManagerAdRequest adManagerAdRequest = this.d;
                this.a = 1;
                obj = gVar.b(access$getContext, str, adManagerAdRequest, this);
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

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.rewarded.modules.GoogleRewardedModule", f = "GoogleRewardedModule.kt", i = {0, 0, 1}, l = {79, 133}, m = "load", n = {"this", "adUnits", "this"}, s = {"L$0", "L$1", "L$0"})
    /* compiled from: GoogleRewardedModule.kt */
    static final class e extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        final /* synthetic */ a d;
        int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(a aVar, Continuation<? super e> continuation) {
            super(continuation);
            this.d = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.load((List<String>) null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.rewarded.modules.GoogleRewardedModule", f = "GoogleRewardedModule.kt", i = {0, 0, 1}, l = {50, 52}, m = "onLoad", n = {"this", "adUnits", "this"}, s = {"L$0", "L$1", "L$0"})
    /* compiled from: GoogleRewardedModule.kt */
    static final class f extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        final /* synthetic */ a d;
        int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(a aVar, Continuation<? super f> continuation) {
            super(continuation);
            this.d = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.onLoad(this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, AdResponse adResponse, BaseRewardedModule.Listener listener) {
        super(context, adResponse, listener);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    @JvmStatic
    public static final boolean canParse(AdResponse adResponse) {
        return Companion.a(adResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: earnedRewardListener$lambda-1  reason: not valid java name */
    public static final void m2337earnedRewardListener$lambda1(a aVar, RewardItem rewardItem) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        Intrinsics.checkNotNullParameter(rewardItem, "it");
        aVar.deliverComplete(new Reward(rewardItem.getAmount(), rewardItem.getType(), true));
    }

    private final Activity getActivity() {
        Context context = getContext();
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    private final void invalidate() {
        this.rewardedAd = null;
    }

    /* access modifiers changed from: private */
    public final Object load(String str, AdManagerAdRequest adManagerAdRequest, Continuation<? super RewardedAd> continuation) {
        return new com.wortise.ads.f(k3.REWARDED, str).a(10000, new d(this, str, adManagerAdRequest, (Continuation<? super d>) null), continuation);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        invalidate();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ad A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object onLoad(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.wortise.ads.rewarded.modules.a.f
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.wortise.ads.rewarded.modules.a$f r0 = (com.wortise.ads.rewarded.modules.a.f) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.rewarded.modules.a$f r0 = new com.wortise.ads.rewarded.modules.a$f
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0049
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r1 = r0.b
            com.wortise.ads.rewarded.modules.a r1 = (com.wortise.ads.rewarded.modules.a) r1
            java.lang.Object r0 = r0.a
            com.wortise.ads.rewarded.modules.a r0 = (com.wortise.ads.rewarded.modules.a) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x00b0
        L_0x0035:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x003d:
            java.lang.Object r2 = r0.b
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r4 = r0.a
            com.wortise.ads.rewarded.modules.a r4 = (com.wortise.ads.rewarded.modules.a) r4
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x00a1
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r7)
            android.app.Activity r7 = r6.getActivity()
            if (r7 != 0) goto L_0x005a
            com.wortise.ads.AdError r7 = com.wortise.ads.AdError.INVALID_PARAMS
            r6.deliverError(r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x005a:
            com.wortise.ads.AdResponse r7 = r6.getAdResponse()
            com.wortise.ads.google.models.GoogleParams r7 = r7.i()
            if (r7 != 0) goto L_0x0066
            r7 = 0
            goto L_0x006a
        L_0x0066:
            java.util.List r7 = r7.a()
        L_0x006a:
            r2 = r7
            r7 = 0
            if (r2 == 0) goto L_0x0077
            boolean r5 = r2.isEmpty()
            if (r5 == 0) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            r5 = 0
            goto L_0x0078
        L_0x0077:
            r5 = 1
        L_0x0078:
            if (r5 == 0) goto L_0x0082
            com.wortise.ads.AdError r7 = com.wortise.ads.AdError.NO_FILL
            r6.deliverError(r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0082:
            java.util.concurrent.atomic.AtomicBoolean r5 = r6.requested
            boolean r7 = r5.compareAndSet(r7, r4)
            if (r7 != 0) goto L_0x008d
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x008d:
            com.wortise.ads.o3 r7 = com.wortise.ads.o3.a
            android.content.Context r5 = r6.getContext()
            r0.a = r6
            r0.b = r2
            r0.e = r4
            java.lang.Object r7 = r7.b(r5, r0)
            if (r7 != r1) goto L_0x00a0
            return r1
        L_0x00a0:
            r4 = r6
        L_0x00a1:
            r0.a = r4
            r0.b = r4
            r0.e = r3
            java.lang.Object r7 = r4.load(r2, r0)
            if (r7 != r1) goto L_0x00ae
            return r1
        L_0x00ae:
            r0 = r4
            r1 = r0
        L_0x00b0:
            com.google.android.gms.ads.rewarded.RewardedAd r7 = (com.google.android.gms.ads.rewarded.RewardedAd) r7
            if (r7 != 0) goto L_0x00bc
            com.wortise.ads.AdError r7 = com.wortise.ads.AdError.NO_FILL
            r0.deliverError(r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x00bc:
            r1.rewardedAd = r7
            r0.deliverLoad()
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.rewarded.modules.a.onLoad(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public Object onShow(Continuation<? super Boolean> continuation) {
        Activity activity = getActivity();
        if (activity == null) {
            return Boxing.boxBoolean(false);
        }
        RewardedAd rewardedAd2 = this.rewardedAd;
        if (rewardedAd2 == null) {
            return Boxing.boxBoolean(false);
        }
        rewardedAd2.show(activity, this.earnedRewardListener);
        return Boxing.boxBoolean(true);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0073 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object load(java.util.List<java.lang.String> r6, kotlin.coroutines.Continuation<? super com.google.android.gms.ads.rewarded.RewardedAd> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.wortise.ads.rewarded.modules.a.e
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.wortise.ads.rewarded.modules.a$e r0 = (com.wortise.ads.rewarded.modules.a.e) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.rewarded.modules.a$e r0 = new com.wortise.ads.rewarded.modules.a$e
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r6 = r0.a
            com.wortise.ads.rewarded.modules.a r6 = (com.wortise.ads.rewarded.modules.a) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0075
        L_0x0030:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0038:
            java.lang.Object r6 = r0.b
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r2 = r0.a
            com.wortise.ads.rewarded.modules.a r2 = (com.wortise.ads.rewarded.modules.a) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005b
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r7)
            com.wortise.ads.k r7 = com.wortise.ads.k.a
            android.content.Context r2 = r5.getContext()
            r0.a = r5
            r0.b = r6
            r0.e = r4
            java.lang.Object r7 = r7.a((android.content.Context) r2, (kotlin.coroutines.Continuation<? super com.google.android.gms.ads.admanager.AdManagerAdRequest>) r0)
            if (r7 != r1) goto L_0x005a
            return r1
        L_0x005a:
            r2 = r5
        L_0x005b:
            com.google.android.gms.ads.admanager.AdManagerAdRequest r7 = (com.google.android.gms.ads.admanager.AdManagerAdRequest) r7
            kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.asFlow(r6)
            com.wortise.ads.rewarded.modules.a$c r4 = new com.wortise.ads.rewarded.modules.a$c
            r4.<init>(r6, r2, r7)
            r0.a = r2
            r6 = 0
            r0.b = r6
            r0.e = r3
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.firstOrNull(r4, r0)
            if (r7 != r1) goto L_0x0074
            return r1
        L_0x0074:
            r6 = r2
        L_0x0075:
            com.google.android.gms.ads.rewarded.RewardedAd r7 = (com.google.android.gms.ads.rewarded.RewardedAd) r7
            if (r7 != 0) goto L_0x007a
            goto L_0x007f
        L_0x007a:
            com.wortise.ads.rewarded.modules.a$b r6 = r6.fullScreenContentCallback
            r7.setFullScreenContentCallback(r6)
        L_0x007f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.rewarded.modules.a.load(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
