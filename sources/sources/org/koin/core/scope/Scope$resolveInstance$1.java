package org.koin.core.scope;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.koin.core.parameter.ParametersHolder;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Scope.kt */
final class Scope$resolveInstance$1 extends Lambda implements Function0<String> {
    final /* synthetic */ ParametersHolder $parameters;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Scope$resolveInstance$1(ParametersHolder parametersHolder) {
        super(0);
        this.$parameters = parametersHolder;
    }

    public final String invoke() {
        return "| put parameters on stack " + this.$parameters + ' ';
    }
}
