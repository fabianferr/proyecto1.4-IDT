package com.wortise.ads;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\"\u0014\u0010\u0003\u001a\u00020\u00008@X\u0004¢\u0006\u0006\u001a\u0004\b\u0001\u0010\u0002\"\u001b\u0010\t\u001a\u00020\u00048@X\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u001b\u0010\f\u001a\u00020\u00048@X\u0002¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler;", "a", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "emptyErrorHandler", "Lkotlinx/coroutines/CoroutineScope;", "ioScope$delegate", "Lkotlin/Lazy;", "b", "()Lkotlinx/coroutines/CoroutineScope;", "ioScope", "mainScope$delegate", "c", "mainScope", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: Coroutines.kt */
public final class c2 {
    private static final Lazy a = LazyKt.lazy(a.a);
    private static final Lazy b = LazyKt.lazy(b.a);

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: Coroutines.kt */
    static final class a extends Lambda implements Function0<CoroutineScope> {
        public static final a a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final CoroutineScope invoke() {
            return CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: Coroutines.kt */
    static final class b extends Lambda implements Function0<CoroutineScope> {
        public static final b a = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final CoroutineScope invoke() {
            return CoroutineScopeKt.MainScope();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    /* compiled from: CoroutineExceptionHandler.kt */
    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public c(CoroutineExceptionHandler.Key key) {
            super(key);
        }

        public void handleException(CoroutineContext coroutineContext, Throwable th) {
        }
    }

    public static final CoroutineExceptionHandler a() {
        return new c(CoroutineExceptionHandler.Key);
    }

    public static final CoroutineScope b() {
        return (CoroutineScope) a.getValue();
    }

    public static final CoroutineScope c() {
        return (CoroutineScope) b.getValue();
    }
}
