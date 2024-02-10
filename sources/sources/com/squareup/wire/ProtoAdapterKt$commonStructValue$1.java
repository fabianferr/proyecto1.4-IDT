package com.squareup.wire;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0012"}, d2 = {"com/squareup/wire/ProtoAdapterKt$commonStructValue$1", "Lcom/squareup/wire/ProtoAdapter;", "", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "Lcom/squareup/wire/ReverseProtoWriter;", "encodeWithTag", "tag", "", "encodedSize", "encodedSizeWithTag", "redact", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProtoAdapter.kt */
public final class ProtoAdapterKt$commonStructValue$1 extends ProtoAdapter<Object> {
    ProtoAdapterKt$commonStructValue$1(FieldEncoding fieldEncoding, KClass<Object> kClass, Syntax syntax) {
        super(fieldEncoding, (KClass<?>) kClass, "type.googleapis.com/google.protobuf.Value", syntax);
    }

    public int encodedSize(Object obj) {
        if (obj == null) {
            return ProtoAdapter.STRUCT_NULL.encodedSizeWithTag(1, obj);
        }
        if (obj instanceof Number) {
            return ProtoAdapter.DOUBLE.encodedSizeWithTag(2, Double.valueOf(((Number) obj).doubleValue()));
        }
        if (obj instanceof String) {
            return ProtoAdapter.STRING.encodedSizeWithTag(3, obj);
        }
        if (obj instanceof Boolean) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(4, obj);
        }
        if (obj instanceof Map) {
            ProtoAdapter<Map<String, ?>> protoAdapter = ProtoAdapter.STRUCT_MAP;
            if (obj != null) {
                return protoAdapter.encodedSizeWithTag(5, (Map) obj);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
        } else if (obj instanceof List) {
            return ProtoAdapter.STRUCT_LIST.encodedSizeWithTag(6, obj);
        } else {
            throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected struct value: ", obj));
        }
    }

    public int encodedSizeWithTag(int i, Object obj) {
        if (obj != null) {
            return super.encodedSizeWithTag(i, obj);
        }
        int encodedSize = encodedSize(obj);
        return ProtoWriter.Companion.tagSize$wire_runtime(i) + ProtoWriter.Companion.varint32Size$wire_runtime(encodedSize) + encodedSize;
    }

    public void encode(ProtoWriter protoWriter, Object obj) {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        if (obj == null) {
            ProtoAdapter.STRUCT_NULL.encodeWithTag(protoWriter, 1, obj);
        } else if (obj instanceof Number) {
            ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 2, Double.valueOf(((Number) obj).doubleValue()));
        } else if (obj instanceof String) {
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, obj);
        } else if (obj instanceof Boolean) {
            ProtoAdapter.BOOL.encodeWithTag(protoWriter, 4, obj);
        } else if (obj instanceof Map) {
            ProtoAdapter<Map<String, ?>> protoAdapter = ProtoAdapter.STRUCT_MAP;
            if (obj != null) {
                protoAdapter.encodeWithTag(protoWriter, 5, (Map) obj);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
        } else if (obj instanceof List) {
            ProtoAdapter.STRUCT_LIST.encodeWithTag(protoWriter, 6, obj);
        } else {
            throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected struct value: ", obj));
        }
    }

    public void encode(ReverseProtoWriter reverseProtoWriter, Object obj) {
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        if (obj == null) {
            ProtoAdapter.STRUCT_NULL.encodeWithTag(reverseProtoWriter, 1, obj);
        } else if (obj instanceof Number) {
            ProtoAdapter.DOUBLE.encodeWithTag(reverseProtoWriter, 2, Double.valueOf(((Number) obj).doubleValue()));
        } else if (obj instanceof String) {
            ProtoAdapter.STRING.encodeWithTag(reverseProtoWriter, 3, obj);
        } else if (obj instanceof Boolean) {
            ProtoAdapter.BOOL.encodeWithTag(reverseProtoWriter, 4, obj);
        } else if (obj instanceof Map) {
            ProtoAdapter<Map<String, ?>> protoAdapter = ProtoAdapter.STRUCT_MAP;
            if (obj != null) {
                protoAdapter.encodeWithTag(reverseProtoWriter, 5, (Map) obj);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
        } else if (obj instanceof List) {
            ProtoAdapter.STRUCT_LIST.encodeWithTag(reverseProtoWriter, 6, obj);
        } else {
            throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected struct value: ", obj));
        }
    }

    public void encodeWithTag(ProtoWriter protoWriter, int i, Object obj) {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        if (obj == null) {
            protoWriter.writeTag(i, getFieldEncoding$wire_runtime());
            protoWriter.writeVarint32(encodedSize(obj));
            encode(protoWriter, obj);
            return;
        }
        super.encodeWithTag(protoWriter, i, obj);
    }

    public void encodeWithTag(ReverseProtoWriter reverseProtoWriter, int i, Object obj) {
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        if (obj == null) {
            int byteCount = reverseProtoWriter.getByteCount();
            encode(reverseProtoWriter, obj);
            reverseProtoWriter.writeVarint32(reverseProtoWriter.getByteCount() - byteCount);
            reverseProtoWriter.writeTag(i, getFieldEncoding$wire_runtime());
            return;
        }
        super.encodeWithTag(reverseProtoWriter, i, obj);
    }

    public Object redact(Object obj) {
        if (obj == null) {
            return ProtoAdapter.STRUCT_NULL.redact(obj);
        }
        if (obj instanceof Number) {
            return obj;
        }
        if (obj instanceof String) {
            return null;
        }
        if (obj instanceof Boolean) {
            return obj;
        }
        if (obj instanceof Map) {
            ProtoAdapter<Map<String, ?>> protoAdapter = ProtoAdapter.STRUCT_MAP;
            if (obj != null) {
                return protoAdapter.redact((Map) obj);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
        } else if (obj instanceof List) {
            return ProtoAdapter.STRUCT_LIST.redact(obj);
        } else {
            throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected struct value: ", obj));
        }
    }

    public Object decode(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        long beginMessage = protoReader.beginMessage();
        Object obj = null;
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        obj = ProtoAdapter.STRUCT_NULL.decode(protoReader);
                        break;
                    case 2:
                        obj = ProtoAdapter.DOUBLE.decode(protoReader);
                        break;
                    case 3:
                        obj = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 4:
                        obj = ProtoAdapter.BOOL.decode(protoReader);
                        break;
                    case 5:
                        obj = ProtoAdapter.STRUCT_MAP.decode(protoReader);
                        break;
                    case 6:
                        obj = ProtoAdapter.STRUCT_LIST.decode(protoReader);
                        break;
                    default:
                        protoReader.skip();
                        break;
                }
            } else {
                protoReader.endMessageAndGetUnknownFields(beginMessage);
                return obj;
            }
        }
    }
}
