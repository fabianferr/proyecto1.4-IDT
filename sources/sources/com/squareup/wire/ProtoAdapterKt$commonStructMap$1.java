package com.squareup.wire;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010\u00020\u0001J\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016J\u001c\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016J,\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¨\u0006\u0011"}, d2 = {"com/squareup/wire/ProtoAdapterKt$commonStructMap$1", "Lcom/squareup/wire/ProtoAdapter;", "", "", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "Lcom/squareup/wire/ReverseProtoWriter;", "encodedSize", "", "redact", "", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProtoAdapter.kt */
public final class ProtoAdapterKt$commonStructMap$1 extends ProtoAdapter<Map<String, ?>> {
    ProtoAdapterKt$commonStructMap$1(FieldEncoding fieldEncoding, KClass<Map<?, ?>> kClass, Syntax syntax) {
        super(fieldEncoding, (KClass<?>) kClass, "type.googleapis.com/google.protobuf.Struct", syntax);
    }

    public int encodedSize(Map<String, ?> map) {
        int i = 0;
        if (map == null) {
            return 0;
        }
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            int encodedSizeWithTag = ProtoAdapter.STRING.encodedSizeWithTag(1, (String) next.getKey()) + ProtoAdapter.STRUCT_VALUE.encodedSizeWithTag(2, value);
            i += ProtoWriter.Companion.tagSize$wire_runtime(1) + ProtoWriter.Companion.varint32Size$wire_runtime(encodedSizeWithTag) + encodedSizeWithTag;
        }
        return i;
    }

    public void encode(ProtoWriter protoWriter, Map<String, ?> map) {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                Object value = next.getValue();
                int encodedSizeWithTag = ProtoAdapter.STRING.encodedSizeWithTag(1, str) + ProtoAdapter.STRUCT_VALUE.encodedSizeWithTag(2, value);
                protoWriter.writeTag(1, FieldEncoding.LENGTH_DELIMITED);
                protoWriter.writeVarint32(encodedSizeWithTag);
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, str);
                ProtoAdapter.STRUCT_VALUE.encodeWithTag(protoWriter, 2, value);
            }
        }
    }

    public void encode(ReverseProtoWriter reverseProtoWriter, Map<String, ?> map) {
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        if (map != null) {
            int i = 0;
            Object[] array = map.entrySet().toArray(new Map.Entry[0]);
            if (array != null) {
                Map.Entry[] entryArr = (Map.Entry[]) array;
                ArraysKt.reverse((T[]) entryArr);
                int length = entryArr.length;
                while (i < length) {
                    Map.Entry entry = entryArr[i];
                    i++;
                    Object value = entry.getValue();
                    int byteCount = reverseProtoWriter.getByteCount();
                    ProtoAdapter.STRUCT_VALUE.encodeWithTag(reverseProtoWriter, 2, value);
                    ProtoAdapter.STRING.encodeWithTag(reverseProtoWriter, 1, (String) entry.getKey());
                    reverseProtoWriter.writeVarint32(reverseProtoWriter.getByteCount() - byteCount);
                    reverseProtoWriter.writeTag(1, FieldEncoding.LENGTH_DELIMITED);
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    public Map<String, ?> decode(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        Map<String, ?> linkedHashMap = new LinkedHashMap<>();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessageAndGetUnknownFields(beginMessage);
                return linkedHashMap;
            } else if (nextTag != 1) {
                protoReader.skip();
            } else {
                long beginMessage2 = protoReader.beginMessage();
                String str = null;
                Object obj = null;
                while (true) {
                    int nextTag2 = protoReader.nextTag();
                    if (nextTag2 == -1) {
                        break;
                    } else if (nextTag2 == 1) {
                        str = ProtoAdapter.STRING.decode(protoReader);
                    } else if (nextTag2 != 2) {
                        protoReader.readUnknownField(nextTag2);
                    } else {
                        obj = ProtoAdapter.STRUCT_VALUE.decode(protoReader);
                    }
                }
                protoReader.endMessageAndGetUnknownFields(beginMessage2);
                if (str != null) {
                    linkedHashMap.put(str, obj);
                }
            }
        }
    }

    public Map<String, Object> redact(Map<String, ?> map) {
        if (map == null) {
            return null;
        }
        Map<String, Object> linkedHashMap = new LinkedHashMap<>(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), ProtoAdapter.STRUCT_VALUE.redact(entry));
        }
        return linkedHashMap;
    }
}
