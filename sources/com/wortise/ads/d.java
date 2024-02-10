package com.wortise.ads;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0006R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/wortise/ads/d;", "", "Landroid/content/Context;", "context", "", "b", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Lcom/wortise/ads/AdResponse;", "Lcom/wortise/ads/AdResponse;", "adResponse", "<init>", "(Lcom/wortise/ads/AdResponse;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: AdCache.kt */
public final class d {
    /* access modifiers changed from: private */
    public final AdResponse a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AdCache.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AdFormat.values().length];
            iArr[AdFormat.IMAGE.ordinal()] = 1;
            a = iArr;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.AdCache$cacheImage$2", f = "AdCache.kt", i = {}, l = {20, 22}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: AdCache.kt */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int a;
        final /* synthetic */ d b;
        final /* synthetic */ Context c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d dVar, Context context, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = dVar;
            this.c = context;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            boolean z;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String f = this.b.a.f();
                z = false;
                if (!(f == null || StringsKt.isBlank(f))) {
                    if (a2.a.b(f)) {
                        z3 z3Var = z3.a;
                        Context context = this.c;
                        this.a = 1;
                        obj = z3Var.a(context, f, (Continuation<? super Boolean>) this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        j4 j4Var = j4.a;
                        Context context2 = this.c;
                        this.a = 2;
                        obj = j4Var.a(context2, f, (Continuation<? super Boolean>) this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        z = ((Boolean) obj).booleanValue();
                    }
                }
                return Boxing.boxBoolean(z);
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                z = ((Boolean) obj).booleanValue();
                return Boxing.boxBoolean(z);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = ((Boolean) obj).booleanValue();
            return Boxing.boxBoolean(z);
        }
    }

    public d(AdResponse adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.a = adResponse;
    }

    private final Object b(Context context, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new b(this, context, (Continuation<? super b>) null), continuation);
    }

    public final Object a(Context context, Continuation<? super Boolean> continuation) {
        AdFormat g = this.a.g();
        if ((g == null ? -1 : a.a[g.ordinal()]) == 1) {
            return b(context, continuation);
        }
        return Boxing.boxBoolean(true);
    }
}
