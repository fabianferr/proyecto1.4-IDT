package io.monedata.utils;

import io.monedata.extensions.CoroutinesKt;
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

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\u0006\u001a\u00028\u00002\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J6\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003H\u0004ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bJ\u0012\u0010\u000b\u001a\u0004\b\u00028\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\u0004\u0018\u00018\u00002\b\u0010\u000f\u001a\u0004\u0018\u00018\u00008\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\f\u0002\b\n\u0002\b\u0019\n\u0002\b9¨\u0006\u0015"}, d2 = {"Lio/monedata/utils/a;", "T", "", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "block", "fetch", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/Deferred;", "fetchAsync", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Deferred;", "requireValue", "()Ljava/lang/Object;", "deferred", "Lkotlinx/coroutines/Deferred;", "<set-?>", "value", "Ljava/lang/Object;", "getValue", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public class a<T> {
    private Deferred<? extends T> deferred;
    private T value;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.utils.AsyncManager", f = "AsyncManager.kt", i = {0}, l = {23}, m = "fetch", n = {"this"}, s = {"L$0"})
    /* renamed from: io.monedata.utils.a$a  reason: collision with other inner class name */
    static final class C0210a extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ a<T> c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0210a(a<T> aVar, Continuation<? super C0210a> continuation) {
            super(continuation);
            this.c = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.fetch((Function1) null, this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.utils.AsyncManager$fetchAsync$1", f = "AsyncManager.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        int a;
        final /* synthetic */ a<T> b;
        final /* synthetic */ Function1<Continuation<? super T>, Object> c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a<T> aVar, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = aVar;
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
                a<T> aVar = this.b;
                Function1<Continuation<? super T>, Object> function1 = this.c;
                this.a = 1;
                obj = aVar.fetch(function1, this);
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
            boolean r0 = r6 instanceof io.monedata.utils.a.C0210a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.monedata.utils.a$a r0 = (io.monedata.utils.a.C0210a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.utils.a$a r0 = new io.monedata.utils.a$a
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.a
            io.monedata.utils.a r5 = (io.monedata.utils.a) r5
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
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.utils.a.fetch(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Deferred<T> fetchAsync() {
        return this.deferred;
    }

    /* access modifiers changed from: protected */
    public final Deferred<T> fetchAsync(Function1<? super Continuation<? super T>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        Deferred<? extends T> deferred2 = this.deferred;
        if (deferred2 != null) {
            return deferred2;
        }
        Deferred<? extends T> async$default = BuildersKt__Builders_commonKt.async$default(CoroutinesKt.getMainScope(), (CoroutineContext) null, (CoroutineStart) null, new b(this, function1, (Continuation<? super b>) null), 3, (Object) null);
        this.deferred = async$default;
        return async$default;
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
}
