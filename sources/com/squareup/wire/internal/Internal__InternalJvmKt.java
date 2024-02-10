package com.squareup.wire.internal;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f\u001a,\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\b0\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f\"'\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"identityOrNull", "E", "Lcom/squareup/wire/WireEnum;", "Ljava/lang/Class;", "getIdentityOrNull", "(Ljava/lang/Class;)Lcom/squareup/wire/WireEnum;", "redactElements", "", "T", "list", "Ljava/util/List;", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "map", "Ljava/util/Map;", "wire-runtime"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "com/squareup/wire/internal/Internal")
/* compiled from: InternalJvm.kt */
final /* synthetic */ class Internal__InternalJvmKt {
    public static final <T> void redactElements(List<T> list, ProtoAdapter<T> protoAdapter) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(protoAdapter, "adapter");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.set(i, protoAdapter.redact(list.get(i)));
        }
    }

    public static final <T> void redactElements(Map<?, T> map, ProtoAdapter<T> protoAdapter) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(protoAdapter, "adapter");
        for (Map.Entry next : map.entrySet()) {
            next.setValue(protoAdapter.redact(next.getValue()));
        }
    }

    public static final <E extends WireEnum> E getIdentityOrNull(Class<E> cls) {
        E e;
        boolean z;
        Intrinsics.checkNotNullParameter(cls, "<this>");
        E[] enumConstants = cls.getEnumConstants();
        Intrinsics.checkNotNullExpressionValue(enumConstants, "enumConstants");
        int length = enumConstants.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                e = null;
                break;
            }
            e = enumConstants[i];
            i++;
            WireEnum wireEnum = (WireEnum) e;
            if (wireEnum != null) {
                if (wireEnum.getValue() == 0) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.squareup.wire.WireEnum");
            }
        }
        return (WireEnum) e;
    }
}
