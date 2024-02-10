package io.monedata.extensions;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "R", "T", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class SafeMapKt$mapTry$3 extends Lambda implements Function1<T, R> {
    final /* synthetic */ Function1<T, R> $block;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SafeMapKt$mapTry$3(Function1<? super T, ? extends R> function1) {
        super(1);
        this.$block = function1;
    }

    public final R invoke(T t) {
        R r;
        Function1<T, R> function1 = this.$block;
        try {
            Result.Companion companion = Result.Companion;
            r = Result.m2344constructorimpl(function1.invoke(t));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            r = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2350isFailureimpl(r)) {
            return null;
        }
        return r;
    }
}
