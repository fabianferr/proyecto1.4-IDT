package com.wortise.ads.utils;

import com.wortise.ads.c2;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ/\u0010\r\u001a\u00028\u00002\u001c\u0010\u000e\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005J4\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u001c\u0010\u000e\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000fH\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u000b\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\tR\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u0004\u0018\u00018\u00002\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000@BX\u000e¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/wortise/ads/utils/AsyncManager;", "T", "", "()V", "deferred", "Lkotlinx/coroutines/Deferred;", "<set-?>", "value", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "clear", "", "fetch", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAsync", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Deferred;", "requireValue", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AsyncManager.kt */
public class AsyncManager<T> {
    private Deferred<? extends T> deferred;
    private T value;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.utils.AsyncManager", f = "AsyncManager.kt", i = {0}, l = {30}, m = "fetch", n = {"this"}, s = {"L$0"})
    /* compiled from: AsyncManager.kt */
    static final class a extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ AsyncManager<T> c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(AsyncManager<T> asyncManager, Continuation<? super a> continuation) {
            super(continuation);
            this.c = asyncManager;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.fetch((Function1) null, this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.utils.AsyncManager$fetchAsync$1", f = "AsyncManager.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: AsyncManager.kt */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        int a;
        final /* synthetic */ AsyncManager<T> b;
        final /* synthetic */ Function1<Continuation<? super T>, Object> c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AsyncManager<T> asyncManager, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = asyncManager;
            this.c = function1;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
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
                AsyncManager<T> asyncManager = this.b;
                Function1<Continuation<? super T>, Object> function1 = this.c;
                this.a = 1;
                obj = asyncManager.fetch(function1, this);
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

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetch(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<? super T> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.wortise.ads.utils.AsyncManager.a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.wortise.ads.utils.AsyncManager$a r0 = (com.wortise.ads.utils.AsyncManager.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.utils.AsyncManager$a r0 = new com.wortise.ads.utils.AsyncManager$a
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.a
            com.wortise.ads.utils.AsyncManager r5 = (com.wortise.ads.utils.AsyncManager) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0044
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.a = r4
            r0.d = r3
            java.lang.Object r6 = r5.invoke(r0)
            if (r6 != r1) goto L_0x0043
            return r1
        L_0x0043:
            r5 = r4
        L_0x0044:
            r5.value = r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.utils.AsyncManager.fetch(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void clear() {
        try {
            Deferred<? extends T> deferred2 = this.deferred;
            if (deferred2 != null) {
                Job.DefaultImpls.cancel$default((Job) deferred2, (CancellationException) null, 1, (Object) null);
            }
        } catch (Throwable unused) {
        }
        this.deferred = null;
        this.value = null;
    }

    public final Deferred<T> fetchAsync() {
        return this.deferred;
    }

    public final T getValue() {
        return this.value;
    }

    public final T requireValue() {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* access modifiers changed from: protected */
    public final Deferred<T> fetchAsync(Function1<? super Continuation<? super T>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        Deferred<? extends T> deferred2 = this.deferred;
        if (deferred2 != null) {
            return deferred2;
        }
        Deferred<? extends T> async$default = BuildersKt__Builders_commonKt.async$default(c2.c(), (CoroutineContext) null, (CoroutineStart) null, new b(this, function1, (Continuation<? super b>) null), 3, (Object) null);
        this.deferred = async$default;
        return async$default;
    }
}
