package com.wortise.ads.renderers.modules;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.wortise.ads.AdError;
import com.wortise.ads.AdFormat;
import com.wortise.ads.AdResponse;
import com.wortise.ads.device.Dimensions;
import com.wortise.ads.g;
import com.wortise.ads.google.models.GoogleParams;
import com.wortise.ads.k3;
import com.wortise.ads.o3;
import com.wortise.ads.q;
import com.wortise.ads.renderers.modules.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u001c\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u001f\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J9\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\n\u0010\r\u001a\u00060\u000bj\u0002`\fH@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0015\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0014J\b\u0010\u0017\u001a\u00020\u0003H\u0014J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\u0019\u001a\u00020\u0003H\u0014R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/wortise/ads/renderers/modules/c;", "Lcom/wortise/ads/renderers/modules/a;", "Landroid/view/View;", "", "invalidate", "Landroid/content/Context;", "context", "", "adUnitId", "Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;", "adRequest", "Lcom/google/android/gms/ads/AdSize;", "Lcom/wortise/ads/google/extensions/GoogleAdSize;", "adSize", "Lcom/google/android/gms/ads/admanager/AdManagerAdView;", "load", "(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;Lcom/google/android/gms/ads/AdSize;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "adUnits", "render", "(Landroid/content/Context;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveAdSize", "onDestroy", "onPause", "onRender", "onResume", "googleAdView", "Lcom/google/android/gms/ads/admanager/AdManagerAdView;", "com/wortise/ads/renderers/modules/c$b", "adListener", "Lcom/wortise/ads/renderers/modules/c$b;", "adView", "Lcom/wortise/ads/AdResponse;", "adResponse", "Lcom/wortise/ads/renderers/modules/a$a;", "listener", "<init>", "(Landroid/view/View;Lcom/wortise/ads/AdResponse;Lcom/wortise/ads/renderers/modules/a$a;)V", "Companion", "a", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GoogleAdRenderer.kt */
public final class c extends a<View> {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final List<AdSize> SIZES = CollectionsKt.listOf(AdSize.WIDE_SKYSCRAPER, AdSize.MEDIUM_RECTANGLE, AdSize.LARGE_BANNER, AdSize.LEADERBOARD, AdSize.FULL_BANNER, AdSize.BANNER);
    private static final long TIMEOUT = 10000;
    private final b adListener = new b(this);
    private AdManagerAdView googleAdView;

    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/wortise/ads/renderers/modules/c$a;", "", "Lcom/wortise/ads/AdResponse;", "response", "", "a", "", "Lcom/google/android/gms/ads/AdSize;", "SIZES", "Ljava/util/List;", "", "TIMEOUT", "J", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: GoogleAdRenderer.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean a(AdResponse adResponse) {
            Intrinsics.checkNotNullParameter(adResponse, "response");
            return adResponse.a(AdFormat.GOOGLE);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/wortise/ads/renderers/modules/c$b", "Lcom/google/android/gms/ads/AdListener;", "", "onAdClicked", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: GoogleAdRenderer.kt */
    public static final class b extends AdListener {
        final /* synthetic */ c a;

        b(c cVar) {
            this.a = cVar;
        }

        public void onAdClicked() {
            a.deliverClick$default(this.a, false, (Bundle) null, 2, (Object) null);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/wortise/ads/g$a;", "Lcom/google/android/gms/ads/admanager/AdManagerAdView;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.renderers.modules.GoogleAdRenderer$load$2", f = "GoogleAdRenderer.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.wortise.ads.renderers.modules.c$c  reason: collision with other inner class name */
    /* compiled from: GoogleAdRenderer.kt */
    static final class C0194c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super g.a<AdManagerAdView>>, Object> {
        int a;
        final /* synthetic */ Context b;
        final /* synthetic */ String c;
        final /* synthetic */ AdManagerAdRequest d;
        final /* synthetic */ AdSize e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0194c(Context context, String str, AdManagerAdRequest adManagerAdRequest, AdSize adSize, Continuation<? super C0194c> continuation) {
            super(2, continuation);
            this.b = context;
            this.c = str;
            this.d = adManagerAdRequest;
            this.e = adSize;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super g.a<AdManagerAdView>> continuation) {
            return ((C0194c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C0194c(this.b, this.c, this.d, this.e, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                g gVar = g.a;
                Context context = this.b;
                String str = this.c;
                AdManagerAdRequest adManagerAdRequest = this.d;
                AdSize adSize = this.e;
                this.a = 1;
                obj = gVar.a(context, str, adManagerAdRequest, adSize, (Continuation<? super g.a<AdManagerAdView>>) this);
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

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.renderers.modules.GoogleAdRenderer$onRender$1", f = "GoogleAdRenderer.kt", i = {}, l = {48, 50}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: GoogleAdRenderer.kt */
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Context b;
        final /* synthetic */ c c;
        final /* synthetic */ List<String> d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Context context, c cVar, List<String> list, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = context;
            this.c = cVar;
            this.d = list;
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
                o3 o3Var = o3.a;
                Context context = this.b;
                this.a = 1;
                if (o3Var.b(context, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c cVar = this.c;
            Context context2 = this.b;
            List<String> list = this.d;
            this.a = 2;
            if (cVar.render(context2, list, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    /* compiled from: SafeCollector.common.kt */
    public static final class e implements Flow<AdManagerAdView> {
        final /* synthetic */ Flow a;
        final /* synthetic */ c b;
        final /* synthetic */ Context c;
        final /* synthetic */ AdManagerAdRequest d;
        final /* synthetic */ AdSize e;

        @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Collect.kt */
        public static final class a implements FlowCollector<String> {
            final /* synthetic */ FlowCollector a;
            final /* synthetic */ c b;
            final /* synthetic */ Context c;
            final /* synthetic */ AdManagerAdRequest d;
            final /* synthetic */ AdSize e;

            @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
            @DebugMetadata(c = "com.wortise.ads.renderers.modules.GoogleAdRenderer$render$$inlined$firstNotNull$1$2", f = "GoogleAdRenderer.kt", i = {0}, l = {138, 139}, m = "emit", n = {"$this$mapNotNull_u24lambda_u2d5"}, s = {"L$0"})
            /* renamed from: com.wortise.ads.renderers.modules.c$e$a$a  reason: collision with other inner class name */
            public static final class C0195a extends ContinuationImpl {
                /* synthetic */ Object a;
                int b;
                Object c;
                final /* synthetic */ a d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0195a(a aVar, Continuation continuation) {
                    super(continuation);
                    this.d = aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return this.d.emit((Object) null, this);
                }
            }

            public a(FlowCollector flowCollector, c cVar, Context context, AdManagerAdRequest adManagerAdRequest, AdSize adSize) {
                this.a = flowCollector;
                this.b = cVar;
                this.c = context;
                this.d = adManagerAdRequest;
                this.e = adSize;
            }

            /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x005f  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r11, kotlin.coroutines.Continuation r12) {
                /*
                    r10 = this;
                    boolean r0 = r12 instanceof com.wortise.ads.renderers.modules.c.e.a.C0195a
                    if (r0 == 0) goto L_0x0013
                    r0 = r12
                    com.wortise.ads.renderers.modules.c$e$a$a r0 = (com.wortise.ads.renderers.modules.c.e.a.C0195a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L_0x0018
                L_0x0013:
                    com.wortise.ads.renderers.modules.c$e$a$a r0 = new com.wortise.ads.renderers.modules.c$e$a$a
                    r0.<init>(r10, r12)
                L_0x0018:
                    java.lang.Object r12 = r0.a
                    java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r0.b
                    r8 = 2
                    r2 = 1
                    if (r1 == 0) goto L_0x003c
                    if (r1 == r2) goto L_0x0034
                    if (r1 != r8) goto L_0x002c
                    kotlin.ResultKt.throwOnFailure(r12)
                    goto L_0x006b
                L_0x002c:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r12)
                    throw r11
                L_0x0034:
                    java.lang.Object r11 = r0.c
                    kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
                    kotlin.ResultKt.throwOnFailure(r12)
                    goto L_0x005c
                L_0x003c:
                    kotlin.ResultKt.throwOnFailure(r12)
                    kotlinx.coroutines.flow.FlowCollector r12 = r10.a
                    r3 = r11
                    java.lang.String r3 = (java.lang.String) r3
                    com.wortise.ads.renderers.modules.c r1 = r10.b
                    android.content.Context r11 = r10.c
                    com.google.android.gms.ads.admanager.AdManagerAdRequest r4 = r10.d
                    com.google.android.gms.ads.AdSize r5 = r10.e
                    r0.c = r12
                    r0.b = r2
                    r2 = r11
                    r6 = r0
                    java.lang.Object r11 = r1.load(r2, r3, r4, r5, r6)
                    if (r11 != r7) goto L_0x0059
                    return r7
                L_0x0059:
                    r9 = r12
                    r12 = r11
                    r11 = r9
                L_0x005c:
                    if (r12 != 0) goto L_0x005f
                    goto L_0x006b
                L_0x005f:
                    r1 = 0
                    r0.c = r1
                    r0.b = r8
                    java.lang.Object r11 = r11.emit(r12, r0)
                    if (r11 != r7) goto L_0x006b
                    return r7
                L_0x006b:
                    kotlin.Unit r11 = kotlin.Unit.INSTANCE
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.renderers.modules.c.e.a.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public e(Flow flow, c cVar, Context context, AdManagerAdRequest adManagerAdRequest, AdSize adSize) {
            this.a = flow;
            this.b = cVar;
            this.c = context;
            this.d = adManagerAdRequest;
            this.e = adSize;
        }

        public Object collect(FlowCollector flowCollector, Continuation continuation) {
            Object collect = this.a.collect(new a(flowCollector, this.b, this.c, this.d, this.e), continuation);
            if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return collect;
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.renderers.modules.GoogleAdRenderer", f = "GoogleAdRenderer.kt", i = {0, 0, 0, 1, 1, 1}, l = {74, 142}, m = "render", n = {"this", "context", "adUnits", "this", "context", "adSize"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    /* compiled from: GoogleAdRenderer.kt */
    static final class f extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        final /* synthetic */ c e;
        int f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(c cVar, Continuation<? super f> continuation) {
            super(continuation);
            this.e = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return this.e.render((Context) null, (List<String>) null, this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(View view, AdResponse adResponse, a.C0192a aVar) {
        super(view, adResponse, aVar);
        Intrinsics.checkNotNullParameter(view, "adView");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    @JvmStatic
    public static final boolean canRender(AdResponse adResponse) {
        return Companion.a(adResponse);
    }

    private final void invalidate() {
        AdManagerAdView adManagerAdView = this.googleAdView;
        if (adManagerAdView != null) {
            adManagerAdView.destroy();
        }
        this.googleAdView = null;
    }

    /* access modifiers changed from: private */
    public final Object load(Context context, String str, AdManagerAdRequest adManagerAdRequest, AdSize adSize, Continuation<? super AdManagerAdView> continuation) {
        return new com.wortise.ads.f(k3.c, str).a(10000, new C0194c(context, str, adManagerAdRequest, adSize, (Continuation<? super C0194c>) null), continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v7, resolved type: java.util.List<java.lang.String>} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0092 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object render(android.content.Context r13, java.util.List<java.lang.String> r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof com.wortise.ads.renderers.modules.c.f
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.wortise.ads.renderers.modules.c$f r0 = (com.wortise.ads.renderers.modules.c.f) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.renderers.modules.c$f r0 = new com.wortise.ads.renderers.modules.c$f
            r0.<init>(r12, r15)
        L_0x0018:
            java.lang.Object r15 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L_0x0051
            if (r2 == r3) goto L_0x0040
            if (r2 != r4) goto L_0x0038
            java.lang.Object r13 = r0.c
            com.google.android.gms.ads.AdSize r13 = (com.google.android.gms.ads.AdSize) r13
            java.lang.Object r14 = r0.b
            android.content.Context r14 = (android.content.Context) r14
            java.lang.Object r0 = r0.a
            com.wortise.ads.renderers.modules.c r0 = (com.wortise.ads.renderers.modules.c) r0
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0098
        L_0x0038:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0040:
            java.lang.Object r13 = r0.c
            r14 = r13
            java.util.List r14 = (java.util.List) r14
            java.lang.Object r13 = r0.b
            android.content.Context r13 = (android.content.Context) r13
            java.lang.Object r2 = r0.a
            com.wortise.ads.renderers.modules.c r2 = (com.wortise.ads.renderers.modules.c) r2
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0066
        L_0x0051:
            kotlin.ResultKt.throwOnFailure(r15)
            com.wortise.ads.k r15 = com.wortise.ads.k.a
            r0.a = r12
            r0.b = r13
            r0.c = r14
            r0.f = r3
            java.lang.Object r15 = r15.a((android.content.Context) r13, (kotlin.coroutines.Continuation<? super com.google.android.gms.ads.admanager.AdManagerAdRequest>) r0)
            if (r15 != r1) goto L_0x0065
            return r1
        L_0x0065:
            r2 = r12
        L_0x0066:
            r9 = r15
            com.google.android.gms.ads.admanager.AdManagerAdRequest r9 = (com.google.android.gms.ads.admanager.AdManagerAdRequest) r9
            com.google.android.gms.ads.AdSize r15 = r2.resolveAdSize(r13)
            java.lang.String r3 = "Requesting Google ad with size "
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r15)
            r5 = 0
            com.wortise.ads.WortiseLog.d$default((java.lang.String) r3, (java.lang.Throwable) r5, (int) r4, (java.lang.Object) r5)
            kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.asFlow(r14)
            com.wortise.ads.renderers.modules.c$e r14 = new com.wortise.ads.renderers.modules.c$e
            r5 = r14
            r7 = r2
            r8 = r13
            r10 = r15
            r5.<init>(r6, r7, r8, r9, r10)
            r0.a = r2
            r0.b = r13
            r0.c = r15
            r0.f = r4
            java.lang.Object r14 = kotlinx.coroutines.flow.FlowKt.firstOrNull(r14, r0)
            if (r14 != r1) goto L_0x0093
            return r1
        L_0x0093:
            r0 = r2
            r11 = r14
            r14 = r13
            r13 = r15
            r15 = r11
        L_0x0098:
            com.google.android.gms.ads.admanager.AdManagerAdView r15 = (com.google.android.gms.ads.admanager.AdManagerAdView) r15
            if (r15 != 0) goto L_0x00a4
            com.wortise.ads.AdError r13 = com.wortise.ads.AdError.NO_FILL
            r0.deliverError(r13)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x00a4:
            com.wortise.ads.renderers.modules.c$b r1 = r0.adListener
            r15.setAdListener(r1)
            r0.googleAdView = r15
            int r1 = r13.getHeightInPixels(r14)
            int r13 = r13.getWidthInPixels(r14)
            com.wortise.ads.device.Dimensions r14 = new com.wortise.ads.device.Dimensions
            r14.<init>(r13, r1)
            r0.deliverView(r15, r14)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.renderers.modules.c.render(android.content.Context, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final AdSize resolveAdSize(Context context) {
        Dimensions size = getSize();
        int i = 0;
        int a2 = size == null ? 0 : size.a(context);
        Dimensions size2 = getSize();
        if (size2 != null) {
            i = size2.b(context);
        }
        if (a2 > 0 || i > 0) {
            com.wortise.ads.AdSize adSize = getAdSize();
            AdSize adSize2 = null;
            AdSize googleAdSize$sdk_productionRelease = adSize == null ? null : adSize.getGoogleAdSize$sdk_productionRelease();
            if (googleAdSize$sdk_productionRelease == null) {
                googleAdSize$sdk_productionRelease = q.a(SIZES, i, a2);
            }
            if (googleAdSize$sdk_productionRelease != null && !Intrinsics.areEqual((Object) googleAdSize$sdk_productionRelease, (Object) AdSize.INVALID)) {
                adSize2 = googleAdSize$sdk_productionRelease;
            }
            if (adSize2 != null) {
                return adSize2;
            }
            AdSize adSize3 = AdSize.BANNER;
            Intrinsics.checkNotNullExpressionValue(adSize3, AdPreferences.TYPE_BANNER);
            return adSize3;
        }
        AdSize adSize4 = AdSize.FLUID;
        Intrinsics.checkNotNullExpressionValue(adSize4, "FLUID");
        return adSize4;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        AdManagerAdView adManagerAdView = this.googleAdView;
        if (adManagerAdView != null) {
            adManagerAdView.pause();
        }
    }

    /* access modifiers changed from: protected */
    public void onRender(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        GoogleParams i = getAdResponse().i();
        List<String> a2 = i == null ? null : i.a();
        if (a2 == null || a2.isEmpty()) {
            deliverError(AdError.SERVER_ERROR);
            return;
        }
        invalidate();
        Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new d(context, this, a2, (Continuation<? super d>) null), 3, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        AdManagerAdView adManagerAdView = this.googleAdView;
        if (adManagerAdView != null) {
            adManagerAdView.resume();
        }
    }
}
