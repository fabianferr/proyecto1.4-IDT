package com.squareup.wire.internal;

import com.squareup.wire.ProtoAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/squareup/wire/ProtoAdapter;", "", "M", "B", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FieldOrOneOfBinding.kt */
final class FieldOrOneOfBinding$adapter$2 extends Lambda implements Function0<ProtoAdapter<Object>> {
    final /* synthetic */ FieldOrOneOfBinding<M, B> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FieldOrOneOfBinding$adapter$2(FieldOrOneOfBinding<M, B> fieldOrOneOfBinding) {
        super(0);
        this.this$0 = fieldOrOneOfBinding;
    }

    public final ProtoAdapter<Object> invoke() {
        if (this.this$0.isMap()) {
            return ProtoAdapter.Companion.newMapAdapter(this.this$0.getKeyAdapter(), this.this$0.getSingleAdapter());
        }
        return this.this$0.getSingleAdapter().withLabel$wire_runtime(this.this$0.getLabel());
    }
}
