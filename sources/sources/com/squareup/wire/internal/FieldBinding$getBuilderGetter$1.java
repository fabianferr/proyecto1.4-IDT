package com.squareup.wire.internal;

import com.squareup.wire.KotlinConstructorBuilder;
import com.squareup.wire.WireField;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0014\b\u0001\u0010\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u0002H\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "M", "Lcom/squareup/wire/Message;", "B", "Lcom/squareup/wire/Message$Builder;", "builder", "invoke", "(Lcom/squareup/wire/Message$Builder;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FieldBinding.kt */
final class FieldBinding$getBuilderGetter$1 extends Lambda implements Function1<B, Object> {
    final /* synthetic */ WireField $wireField;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FieldBinding$getBuilderGetter$1(WireField wireField) {
        super(1);
        this.$wireField = wireField;
    }

    public final Object invoke(B b) {
        Intrinsics.checkNotNullParameter(b, "builder");
        return ((KotlinConstructorBuilder) b).get(this.$wireField);
    }
}
