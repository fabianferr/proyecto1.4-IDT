package io.monedata.extensions;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/CoroutineScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class CoroutinesKt$ioScope$2 extends Lambda implements Function0<CoroutineScope> {
    public static final CoroutinesKt$ioScope$2 INSTANCE = new CoroutinesKt$ioScope$2();

    CoroutinesKt$ioScope$2() {
        super(0);
    }

    public final CoroutineScope invoke() {
        return CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }
}
