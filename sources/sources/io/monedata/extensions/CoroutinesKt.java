package io.monedata.extensions;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0004\u001a\u00020\u00058@X\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u001b\u0010\n\u001a\u00020\u00058@X\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007¨\u0006\r"}, d2 = {"emptyErrorHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getEmptyErrorHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "getIoScope", "()Lkotlinx/coroutines/CoroutineScope;", "ioScope$delegate", "Lkotlin/Lazy;", "mainScope", "getMainScope", "mainScope$delegate", "core_productionRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CoroutinesKt {
    private static final CoroutineExceptionHandler emptyErrorHandler = new CoroutinesKt$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
    private static final Lazy ioScope$delegate = LazyKt.lazy(CoroutinesKt$ioScope$2.INSTANCE);
    private static final Lazy mainScope$delegate = LazyKt.lazy(CoroutinesKt$mainScope$2.INSTANCE);

    public static final CoroutineExceptionHandler getEmptyErrorHandler() {
        return emptyErrorHandler;
    }

    public static final CoroutineScope getIoScope() {
        return (CoroutineScope) ioScope$delegate.getValue();
    }

    public static final CoroutineScope getMainScope() {
        return (CoroutineScope) mainScope$delegate.getValue();
    }
}
