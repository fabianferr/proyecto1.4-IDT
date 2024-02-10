package com.squareup.wire.internal;

import com.squareup.wire.KotlinConstructorBuilder;
import com.squareup.wire.Message;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0003\"\u0014\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "B", "M", "Lcom/squareup/wire/Message;", "Lcom/squareup/wire/Message$Builder;", "invoke", "()Lcom/squareup/wire/Message$Builder;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: reflection.kt */
final class ReflectionKt$createRuntimeMessageAdapter$newBuilderInstance$1 extends Lambda implements Function0<B> {
    final /* synthetic */ Class<B> $builderType;
    final /* synthetic */ Class<M> $messageType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReflectionKt$createRuntimeMessageAdapter$newBuilderInstance$1(Class<B> cls, Class<M> cls2) {
        super(0);
        this.$builderType = cls;
        this.$messageType = cls2;
    }

    public final B invoke() {
        if (this.$builderType.isAssignableFrom(KotlinConstructorBuilder.class)) {
            return (Message.Builder) new KotlinConstructorBuilder(this.$messageType);
        }
        B newInstance = this.$builderType.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "{\n      builderType.newInstance()\n    }");
        return (Message.Builder) newInstance;
    }
}
