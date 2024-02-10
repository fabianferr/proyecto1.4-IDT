package com.squareup.wire;

import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B#\b\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0002\u0010\u0007J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00122\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J.\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016J.\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016J\u001c\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J&\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00152\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016J(\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/squareup/wire/MapProtoAdapter;", "K", "V", "Lcom/squareup/wire/ProtoAdapter;", "", "keyAdapter", "valueAdapter", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ProtoAdapter;)V", "entryAdapter", "Lcom/squareup/wire/MapEntryProtoAdapter;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "Lcom/squareup/wire/ReverseProtoWriter;", "encodeWithTag", "tag", "", "encodedSize", "encodedSizeWithTag", "redact", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProtoAdapter.kt */
public final class MapProtoAdapter<K, V> extends ProtoAdapter<Map<K, ? extends V>> {
    private final MapEntryProtoAdapter<K, V> entryAdapter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MapProtoAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
        super(FieldEncoding.LENGTH_DELIMITED, (KClass<?>) Reflection.getOrCreateKotlinClass(Map.class), (String) null, protoAdapter2.getSyntax(), MapsKt.emptyMap());
        Intrinsics.checkNotNullParameter(protoAdapter, "keyAdapter");
        Intrinsics.checkNotNullParameter(protoAdapter2, "valueAdapter");
        this.entryAdapter = new MapEntryProtoAdapter<>(protoAdapter, protoAdapter2);
    }

    public int encodedSize(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "value");
        throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
    }

    public int encodedSizeWithTag(int i, Map<K, ? extends V> map) {
        int i2 = 0;
        if (map == null) {
            return 0;
        }
        for (Map.Entry<K, ? extends V> encodedSizeWithTag : map.entrySet()) {
            i2 += this.entryAdapter.encodedSizeWithTag(i, encodedSizeWithTag);
        }
        return i2;
    }

    public void encode(ProtoWriter protoWriter, Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        Intrinsics.checkNotNullParameter(map, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    public void encode(ReverseProtoWriter reverseProtoWriter, Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        Intrinsics.checkNotNullParameter(map, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    public void encodeWithTag(ProtoWriter protoWriter, int i, Map<K, ? extends V> map) throws IOException {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        if (map != null) {
            for (Map.Entry<K, ? extends V> encodeWithTag : map.entrySet()) {
                this.entryAdapter.encodeWithTag(protoWriter, i, encodeWithTag);
            }
        }
    }

    public void encodeWithTag(ReverseProtoWriter reverseProtoWriter, int i, Map<K, ? extends V> map) throws IOException {
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        if (map != null) {
            int i2 = 0;
            Object[] array = map.entrySet().toArray(new Map.Entry[0]);
            if (array != null) {
                Map.Entry[] entryArr = (Map.Entry[]) array;
                ArraysKt.reverse((T[]) entryArr);
                int length = entryArr.length;
                while (i2 < length) {
                    Map.Entry entry = entryArr[i2];
                    i2++;
                    this.entryAdapter.encodeWithTag(reverseProtoWriter, i, entry);
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    public Map<K, V> decode(ProtoReader protoReader) throws IOException {
        boolean z;
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        K identity = this.entryAdapter.getKeyAdapter$wire_runtime().getIdentity();
        V identity2 = this.entryAdapter.getValueAdapter$wire_runtime().getIdentity();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            z = true;
            if (nextTag == -1) {
                break;
            } else if (nextTag == 1) {
                identity = this.entryAdapter.getKeyAdapter$wire_runtime().decode(protoReader);
            } else if (nextTag == 2) {
                identity2 = this.entryAdapter.getValueAdapter$wire_runtime().decode(protoReader);
            }
        }
        protoReader.endMessageAndGetUnknownFields(beginMessage);
        if (identity != null) {
            if (identity2 == null) {
                z = false;
            }
            if (z) {
                return MapsKt.mapOf(TuplesKt.to(identity, identity2));
            }
            throw new IllegalStateException("Map entry with null value".toString());
        }
        throw new IllegalStateException("Map entry with null key".toString());
    }

    public Map<K, V> redact(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "value");
        return MapsKt.emptyMap();
    }
}
