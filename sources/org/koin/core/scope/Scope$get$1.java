package org.koin.core.scope;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "T", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Scope.kt */
final class Scope$get$1 extends Lambda implements Function0<T> {
    final /* synthetic */ KClass<?> $clazz;
    final /* synthetic */ Function0<ParametersHolder> $parameters;
    final /* synthetic */ Qualifier $qualifier;
    final /* synthetic */ Scope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Scope$get$1(Scope scope, Qualifier qualifier, KClass<?> kClass, Function0<? extends ParametersHolder> function0) {
        super(0);
        this.this$0 = scope;
        this.$qualifier = qualifier;
        this.$clazz = kClass;
        this.$parameters = function0;
    }

    public final T invoke() {
        return this.this$0.resolveInstance(this.$qualifier, this.$clazz, this.$parameters);
    }
}
