package com.squareup.wire;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0005J\u001f\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u000bJ\u001f\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u0004\u0018\u00018\u00002\b\u0010\n\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"com/squareup/wire/ProtoAdapterKt$commonWrapper$1", "Lcom/squareup/wire/ProtoAdapter;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "(Lcom/squareup/wire/ProtoReader;)Ljava/lang/Object;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "(Lcom/squareup/wire/ProtoWriter;Ljava/lang/Object;)V", "Lcom/squareup/wire/ReverseProtoWriter;", "(Lcom/squareup/wire/ReverseProtoWriter;Ljava/lang/Object;)V", "encodedSize", "", "(Ljava/lang/Object;)I", "redact", "(Ljava/lang/Object;)Ljava/lang/Object;", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProtoAdapter.kt */
public final class ProtoAdapterKt$commonWrapper$1 extends ProtoAdapter<T> {
    final /* synthetic */ ProtoAdapter<T> $delegate;
    final /* synthetic */ String $typeUrl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProtoAdapterKt$commonWrapper$1(String str, ProtoAdapter<T> protoAdapter, FieldEncoding fieldEncoding, KClass<?> kClass, Syntax syntax, T t) {
        super(fieldEncoding, kClass, str, syntax, t);
        this.$typeUrl = str;
        this.$delegate = protoAdapter;
    }

    public int encodedSize(T t) {
        if (t == null || Intrinsics.areEqual((Object) t, (Object) this.$delegate.getIdentity())) {
            return 0;
        }
        return this.$delegate.encodedSizeWithTag(1, t);
    }

    public void encode(ProtoWriter protoWriter, T t) {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        if (t != null && !Intrinsics.areEqual((Object) t, (Object) this.$delegate.getIdentity())) {
            this.$delegate.encodeWithTag(protoWriter, 1, t);
        }
    }

    public void encode(ReverseProtoWriter reverseProtoWriter, T t) {
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        if (t != null && !Intrinsics.areEqual((Object) t, (Object) this.$delegate.getIdentity())) {
            this.$delegate.encodeWithTag(reverseProtoWriter, 1, t);
        }
    }

    public T decode(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        T identity = this.$delegate.getIdentity();
        ProtoAdapter<T> protoAdapter = this.$delegate;
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessageAndGetUnknownFields(beginMessage);
                return identity;
            } else if (nextTag == 1) {
                identity = protoAdapter.decode(protoReader);
            } else {
                protoReader.readUnknownField(nextTag);
            }
        }
    }

    public T redact(T t) {
        if (t == null) {
            return null;
        }
        return this.$delegate.redact(t);
    }
}
