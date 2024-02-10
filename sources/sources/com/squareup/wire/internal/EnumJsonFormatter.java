package com.squareup.wire.internal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireEnumConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\rJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fR\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/squareup/wire/internal/EnumJsonFormatter;", "E", "Lcom/squareup/wire/WireEnum;", "Lcom/squareup/wire/internal/JsonFormatter;", "adapter", "Lcom/squareup/wire/EnumAdapter;", "(Lcom/squareup/wire/EnumAdapter;)V", "stringToValue", "", "", "valueToString", "fromString", "value", "(Ljava/lang/String;)Lcom/squareup/wire/WireEnum;", "toStringOrNumber", "(Lcom/squareup/wire/WireEnum;)Ljava/lang/String;", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EnumJsonFormatter.kt */
public final class EnumJsonFormatter<E extends WireEnum> implements JsonFormatter<E> {
    private final Map<String, E> stringToValue;
    private final Map<E, String> valueToString;

    public EnumJsonFormatter(EnumAdapter<E> enumAdapter) {
        Intrinsics.checkNotNullParameter(enumAdapter, "adapter");
        Map<String, E> linkedHashMap = new LinkedHashMap<>();
        Map<E, String> linkedHashMap2 = new LinkedHashMap<>();
        KClass<?> type = enumAdapter.getType();
        Intrinsics.checkNotNull(type);
        Class<?> javaClass = JvmClassMappingKt.getJavaClass(type);
        Object[] enumConstants = javaClass.getEnumConstants();
        Intrinsics.checkNotNullExpressionValue(enumConstants, "enumType.enumConstants");
        WireEnum[] wireEnumArr = (WireEnum[]) enumConstants;
        int length = wireEnumArr.length;
        int i = 0;
        while (i < length) {
            WireEnum wireEnum = wireEnumArr[i];
            i++;
            if (wireEnum != null) {
                String name = ((Enum) wireEnum).name();
                linkedHashMap.put(name, wireEnum);
                linkedHashMap.put(String.valueOf(wireEnum.getValue()), wireEnum);
                linkedHashMap2.put(wireEnum, name);
                WireEnumConstant wireEnumConstant = (WireEnumConstant) javaClass.getDeclaredField(name).getAnnotation(WireEnumConstant.class);
                if (wireEnumConstant != null) {
                    if (wireEnumConstant.declaredName().length() > 0) {
                        linkedHashMap.put(wireEnumConstant.declaredName(), wireEnum);
                        linkedHashMap2.put(wireEnum, wireEnumConstant.declaredName());
                    }
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Enum<*>");
            }
        }
        this.stringToValue = linkedHashMap;
        this.valueToString = linkedHashMap2;
    }

    public E fromString(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return (WireEnum) this.stringToValue.get(str);
    }

    public String toStringOrNumber(E e) {
        Intrinsics.checkNotNullParameter(e, "value");
        String str = this.valueToString.get(e);
        Intrinsics.checkNotNull(str);
        return str;
    }
}
