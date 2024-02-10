package com.squareup.wire;

import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J(\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J(\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J\u0016\u0010\u0012\u001a\u00020\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J \u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/squareup/wire/RepeatedProtoAdapter;", "E", "Lcom/squareup/wire/ProtoAdapter;", "", "originalAdapter", "(Lcom/squareup/wire/ProtoAdapter;)V", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "Lcom/squareup/wire/ReverseProtoWriter;", "encodeWithTag", "tag", "", "encodedSize", "encodedSizeWithTag", "redact", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProtoAdapter.kt */
public final class RepeatedProtoAdapter<E> extends ProtoAdapter<List<? extends E>> {
    private final ProtoAdapter<E> originalAdapter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RepeatedProtoAdapter(ProtoAdapter<E> protoAdapter) {
        super(protoAdapter.getFieldEncoding$wire_runtime(), (KClass<?>) Reflection.getOrCreateKotlinClass(List.class), (String) null, protoAdapter.getSyntax(), CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(protoAdapter, "originalAdapter");
        this.originalAdapter = protoAdapter;
    }

    public int encodedSize(List<? extends E> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
    }

    public int encodedSizeWithTag(int i, List<? extends E> list) {
        if (list == null) {
            return 0;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += this.originalAdapter.encodedSizeWithTag(i, list.get(i3));
        }
        return i2;
    }

    public void encode(ProtoWriter protoWriter, List<? extends E> list) {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        Intrinsics.checkNotNullParameter(list, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    public void encode(ReverseProtoWriter reverseProtoWriter, List<? extends E> list) {
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        Intrinsics.checkNotNullParameter(list, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    public void encodeWithTag(ProtoWriter protoWriter, int i, List<? extends E> list) throws IOException {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.originalAdapter.encodeWithTag(protoWriter, i, list.get(i2));
            }
        }
    }

    public void encodeWithTag(ReverseProtoWriter reverseProtoWriter, int i, List<? extends E> list) throws IOException {
        int i2;
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        if (list != null && list.size() - 1 >= 0) {
            while (true) {
                int i3 = i2 - 1;
                this.originalAdapter.encodeWithTag(reverseProtoWriter, i, list.get(i2));
                if (i3 >= 0) {
                    i2 = i3;
                } else {
                    return;
                }
            }
        }
    }

    public List<E> decode(ProtoReader protoReader) throws IOException {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        return CollectionsKt.listOf(this.originalAdapter.decode(protoReader));
    }

    public List<E> redact(List<? extends E> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        return CollectionsKt.emptyList();
    }
}
