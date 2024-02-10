package org.koin.core.instance;

import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "", "T", "invoke", "()[Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: InstanceBuilder.kt */
final class InstanceBuilderKt$newInstance$args$1 extends Lambda implements Function0<Object[]> {
    final /* synthetic */ Constructor<?> $constructor;
    final /* synthetic */ ParametersHolder $params;
    final /* synthetic */ Scope $this_newInstance;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstanceBuilderKt$newInstance$args$1(Constructor<?> constructor, Scope scope, ParametersHolder parametersHolder) {
        super(0);
        this.$constructor = constructor;
        this.$this_newInstance = scope;
        this.$params = parametersHolder;
    }

    public final Object[] invoke() {
        return InstanceBuilderKt.getArguments(this.$constructor, this.$this_newInstance, this.$params);
    }
}
