package com.wortise.ads;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

@Metadata(bv = {}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0007B+\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030!\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0013\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\n\u001a\u00020\tR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/wortise/ads/v2;", "", "", "action", "Landroid/os/Bundle;", "extras", "", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "f", "Lcom/wortise/ads/d;", "adCache$delegate", "Lkotlin/Lazy;", "b", "()Lcom/wortise/ads/d;", "adCache", "Lcom/wortise/ads/w2;", "broadcastReceiver$delegate", "c", "()Lcom/wortise/ads/w2;", "broadcastReceiver", "", "identifier$delegate", "d", "()J", "identifier", "Landroid/content/Intent;", "e", "()Landroid/content/Intent;", "intent", "Landroid/content/Context;", "context", "Lkotlin/reflect/KClass;", "clazz", "Lcom/wortise/ads/AdResponse;", "adResponse", "Lcom/wortise/ads/v2$a;", "listener", "<init>", "(Landroid/content/Context;Lkotlin/reflect/KClass;Lcom/wortise/ads/AdResponse;Lcom/wortise/ads/v2$a;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: FullscreenAdController.kt */
public final class v2 {
    private final Context a;
    private final KClass<?> b;
    /* access modifiers changed from: private */
    public final AdResponse c;
    private final a d;
    private final Lazy e = LazyKt.lazy(new b(this));
    private final Lazy f = LazyKt.lazy(new c(this));
    private final Lazy g = LazyKt.lazy(new d(this));

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0002H&¨\u0006\n"}, d2 = {"Lcom/wortise/ads/v2$a;", "", "", "onAdClicked", "a", "onAdDismissed", "Lcom/wortise/ads/AdError;", "error", "onAdLoaded", "onAdShown", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: FullscreenAdController.kt */
    public interface a {
        void a();

        void a(AdError adError);

        void onAdClicked();

        void onAdDismissed();

        void onAdLoaded();

        void onAdShown();
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/wortise/ads/d;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: FullscreenAdController.kt */
    static final class b extends Lambda implements Function0<d> {
        final /* synthetic */ v2 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(v2 v2Var) {
            super(0);
            this.a = v2Var;
        }

        /* renamed from: a */
        public final d invoke() {
            return new d(this.a.c);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/wortise/ads/w2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: FullscreenAdController.kt */
    static final class c extends Lambda implements Function0<w2> {
        final /* synthetic */ v2 a;

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* compiled from: FullscreenAdController.kt */
        /* synthetic */ class a extends FunctionReferenceImpl implements Function2<String, Bundle, Unit> {
            a(Object obj) {
                super(2, obj, v2.class, "onEventReceived", "onEventReceived(Ljava/lang/String;Landroid/os/Bundle;)V", 0);
            }

            public final void a(String str, Bundle bundle) {
                Intrinsics.checkNotNullParameter(str, "p0");
                ((v2) this.receiver).a(str, bundle);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((String) obj, (Bundle) obj2);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(v2 v2Var) {
            super(0);
            this.a = v2Var;
        }

        /* renamed from: a */
        public final w2 invoke() {
            return new w2(this.a.d(), new a(this.a));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\t\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: FullscreenAdController.kt */
    static final class d extends Lambda implements Function0<Long> {
        final /* synthetic */ v2 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(v2 v2Var) {
            super(0);
            this.a = v2Var;
        }

        /* renamed from: a */
        public final Long invoke() {
            return Long.valueOf((long) this.a.hashCode());
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.fullscreen.FullscreenAdController", f = "FullscreenAdController.kt", i = {0}, l = {60}, m = "load", n = {"this"}, s = {"L$0"})
    /* compiled from: FullscreenAdController.kt */
    static final class e extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ v2 c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(v2 v2Var, Continuation<? super e> continuation) {
            super(continuation);
            this.c = v2Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.a((Continuation<? super Unit>) this);
        }
    }

    public v2(Context context, KClass<?> kClass, AdResponse adResponse, a aVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = context;
        this.b = kClass;
        this.c = adResponse;
        this.d = aVar;
    }

    private final w2 c() {
        return (w2) this.f.getValue();
    }

    /* access modifiers changed from: private */
    public final long d() {
        return ((Number) this.g.getValue()).longValue();
    }

    private final Intent e() {
        return u2.Companion.a(this.a, this.b, this.c, d());
    }

    public final boolean f() {
        boolean a2 = k4.a(e(), this.a);
        if (a2) {
            this.d.onAdShown();
        }
        return a2;
    }

    private final d b() {
        return (d) this.e.getValue();
    }

    public final void a() {
        c().b(this.a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.wortise.ads.v2.e
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.wortise.ads.v2$e r0 = (com.wortise.ads.v2.e) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.v2$e r0 = new com.wortise.ads.v2$e
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.a
            com.wortise.ads.v2 r0 = (com.wortise.ads.v2) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x004a
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            com.wortise.ads.d r5 = r4.b()
            android.content.Context r2 = r4.a
            r0.a = r4
            r0.d = r3
            java.lang.Object r5 = r5.a(r2, r0)
            if (r5 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r0 = r4
        L_0x004a:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x005c
            com.wortise.ads.v2$a r5 = r0.d
            com.wortise.ads.AdError r0 = com.wortise.ads.AdError.NO_FILL
            r5.a(r0)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x005c:
            com.wortise.ads.w2 r5 = r0.c()
            android.content.Context r1 = r0.a
            r5.a(r1)
            com.wortise.ads.v2$a r5 = r0.d
            r5.onAdLoaded()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.v2.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void a(String str, Bundle bundle) {
        AdError adError;
        int hashCode = str.hashCode();
        if (hashCode != -599445191) {
            if (hashCode != 94750088) {
                if (hashCode != 96784904) {
                    if (hashCode == 1671672458 && str.equals("dismiss")) {
                        this.d.onAdDismissed();
                    }
                } else if (str.equals("error")) {
                    if (bundle == null) {
                        adError = null;
                    } else {
                        adError = (AdError) bundle.getParcelable("error");
                    }
                    if (adError == null) {
                        adError = AdError.UNSPECIFIED;
                    }
                    this.d.a(adError);
                }
            } else if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_CLICK)) {
                this.d.onAdClicked();
            }
        } else if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE)) {
            this.d.a();
        }
    }
}
