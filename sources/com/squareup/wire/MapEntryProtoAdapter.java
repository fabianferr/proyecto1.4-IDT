package com.squareup.wire;

import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B#\b\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0002\u0010\u0007J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00132\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\u001c\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J(\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/squareup/wire/MapEntryProtoAdapter;", "K", "V", "Lcom/squareup/wire/ProtoAdapter;", "", "keyAdapter", "valueAdapter", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ProtoAdapter;)V", "getKeyAdapter$wire_runtime", "()Lcom/squareup/wire/ProtoAdapter;", "getValueAdapter$wire_runtime", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "Lcom/squareup/wire/ReverseProtoWriter;", "encodedSize", "", "redact", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProtoAdapter.kt */
final class MapEntryProtoAdapter<K, V> extends ProtoAdapter<Map.Entry<? extends K, ? extends V>> {
    private final ProtoAdapter<K> keyAdapter;
    private final ProtoAdapter<V> valueAdapter;

    public final ProtoAdapter<K> getKeyAdapter$wire_runtime() {
        return this.keyAdapter;
    }

    public final ProtoAdapter<V> getValueAdapter$wire_runtime() {
        return this.valueAdapter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MapEntryProtoAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
        super(FieldEncoding.LENGTH_DELIMITED, (KClass<?>) Reflection.getOrCreateKotlinClass(Map.Entry.class), (String) null, protoAdapter2.getSyntax());
        Intrinsics.checkNotNullParameter(protoAdapter, "keyAdapter");
        Intrinsics.checkNotNullParameter(protoAdapter2, "valueAdapter");
        this.keyAdapter = protoAdapter;
        this.valueAdapter = protoAdapter2;
    }

    public int encodedSize(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "value");
        return this.keyAdapter.encodedSizeWithTag(1, entry.getKey()) + this.valueAdapter.encodedSizeWithTag(2, entry.getValue());
    }

    public void encode(ProtoWriter protoWriter, Map.Entry<? extends K, ? extends V> entry) throws IOException {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        Intrinsics.checkNotNullParameter(entry, "value");
        this.keyAdapter.encodeWithTag(protoWriter, 1, entry.getKey());
        this.valueAdapter.encodeWithTag(protoWriter, 2, entry.getValue());
    }

    public void encode(ReverseProtoWriter reverseProtoWriter, Map.Entry<? extends K, ? extends V> entry) throws IOException {
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        Intrinsics.checkNotNullParameter(entry, "value");
        this.valueAdapter.encodeWithTag(reverseProtoWriter, 2, entry.getValue());
        this.keyAdapter.encodeWithTag(reverseProtoWriter, 1, entry.getKey());
    }

    public Map.Entry<K, V> decode(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        throw new UnsupportedOperationException();
    }

    public Map.Entry<K, V> redact(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "value");
        throw new UnsupportedOperationException();
    }
}
