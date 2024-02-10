package com.squareup.wire;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016J\u0016\u0010\f\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016J \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u00022\f\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¨\u0006\u0010"}, d2 = {"com/squareup/wire/ProtoAdapterKt$commonStructList$1", "Lcom/squareup/wire/ProtoAdapter;", "", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "Lcom/squareup/wire/ReverseProtoWriter;", "encodedSize", "", "redact", "", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProtoAdapter.kt */
public final class ProtoAdapterKt$commonStructList$1 extends ProtoAdapter<List<?>> {
    ProtoAdapterKt$commonStructList$1(FieldEncoding fieldEncoding, KClass<Map<?, ?>> kClass, Syntax syntax) {
        super(fieldEncoding, (KClass<?>) kClass, "type.googleapis.com/google.protobuf.ListValue", syntax);
    }

    public int encodedSize(List<?> list) {
        int i = 0;
        if (list == null) {
            return 0;
        }
        for (Object encodedSizeWithTag : list) {
            i += ProtoAdapter.STRUCT_VALUE.encodedSizeWithTag(1, encodedSizeWithTag);
        }
        return i;
    }

    public void encode(ProtoWriter protoWriter, List<?> list) {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        if (list != null) {
            for (Object encodeWithTag : list) {
                ProtoAdapter.STRUCT_VALUE.encodeWithTag(protoWriter, 1, encodeWithTag);
            }
        }
    }

    public void encode(ReverseProtoWriter reverseProtoWriter, List<?> list) {
        int size;
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        if (list != null && (size = list.size() - 1) >= 0) {
            while (true) {
                int i = size - 1;
                ProtoAdapter.STRUCT_VALUE.encodeWithTag(reverseProtoWriter, 1, list.get(size));
                if (i >= 0) {
                    size = i;
                } else {
                    return;
                }
            }
        }
    }

    public List<?> decode(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        List<?> arrayList = new ArrayList<>();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessageAndGetUnknownFields(beginMessage);
                return arrayList;
            } else if (nextTag != 1) {
                protoReader.skip();
            } else {
                arrayList.add(ProtoAdapter.STRUCT_VALUE.decode(protoReader));
            }
        }
    }

    public List<Object> redact(List<?> list) {
        if (list == null) {
            return null;
        }
        Iterable<Object> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Object redact : iterable) {
            arrayList.add(ProtoAdapter.STRUCT_VALUE.redact(redact));
        }
        return (List) arrayList;
    }
}
