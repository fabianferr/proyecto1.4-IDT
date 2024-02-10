package org.koin.core.instance;

import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: InstanceBuilder.kt */
final class InstanceBuilderKt$newInstance$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ Object[] $args;
    final /* synthetic */ Constructor<?> $constructor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstanceBuilderKt$newInstance$1(Object[] objArr, Constructor<?> constructor) {
        super(0);
        this.$args = objArr;
        this.$constructor = constructor;
    }

    public final Object invoke() {
        return InstanceBuilderKt.createInstance(this.$args, this.$constructor);
    }
}
