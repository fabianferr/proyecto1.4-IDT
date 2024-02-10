package com.squareup.wire.internal;

import com.squareup.wire.Message;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0014\b\u0001\u0010\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "", "M", "Lcom/squareup/wire/Message;", "B", "Lcom/squareup/wire/Message$Builder;", "builder", "value", "", "invoke", "(Lcom/squareup/wire/Message$Builder;Ljava/lang/Object;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FieldBinding.kt */
final class FieldBinding$getBuilderSetter$2 extends Lambda implements Function2<B, Object, Unit> {
    final /* synthetic */ Method $method;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FieldBinding$getBuilderSetter$2(Method method) {
        super(2);
        this.$method = method;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Message.Builder) obj, obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(B b, Object obj) {
        Intrinsics.checkNotNullParameter(b, "builder");
        this.$method.invoke(b, new Object[]{obj});
    }
}
