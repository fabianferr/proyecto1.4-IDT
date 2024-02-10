package org.koin.core.scope;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import org.koin.core.qualifier.Qualifier;
import org.koin.ext.KClassExtKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Scope.kt */
final class Scope$resolveValue$2$1 extends Lambda implements Function0<String> {
    final /* synthetic */ KClass<?> $clazz;
    final /* synthetic */ Qualifier $qualifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Scope$resolveValue$2$1(KClass<?> kClass, Qualifier qualifier) {
        super(0);
        this.$clazz = kClass;
        this.$qualifier = qualifier;
    }

    public final String invoke() {
        return "- lookup? t:'" + KClassExtKt.getFullName(this.$clazz) + "' - q:'" + this.$qualifier + "' look at scope source";
    }
}
