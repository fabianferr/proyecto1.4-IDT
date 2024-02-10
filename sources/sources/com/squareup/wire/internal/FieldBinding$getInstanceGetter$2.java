package com.squareup.wire.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0014\b\u0000\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0014\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00050\u00062\u0006\u0010\u0007\u001a\u0002H\u0003H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "M", "Lcom/squareup/wire/Message;", "B", "Lcom/squareup/wire/Message$Builder;", "instance", "invoke", "(Lcom/squareup/wire/Message;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FieldBinding.kt */
final class FieldBinding$getInstanceGetter$2 extends Lambda implements Function1<M, Object> {
    final /* synthetic */ FieldBinding<M, B> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FieldBinding$getInstanceGetter$2(FieldBinding<M, B> fieldBinding) {
        super(1);
        this.this$0 = fieldBinding;
    }

    public final Object invoke(M m) {
        Intrinsics.checkNotNullParameter(m, "instance");
        return this.this$0.messageField.get(m);
    }
}
