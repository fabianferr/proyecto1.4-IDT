package com.squareup.wire.internal;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

@Metadata(d1 = {"com/squareup/wire/internal/Internal__InternalJvmKt", "com/squareup/wire/internal/Internal__InternalKt"}, k = 4, mv = {1, 6, 0}, xi = 48)
public final class Internal {
    /* renamed from: -redactElements  reason: not valid java name */
    public static final <T> List<T> m244redactElements(List<? extends T> list, ProtoAdapter<T> protoAdapter) {
        return Internal__InternalKt.m246redactElements(list, protoAdapter);
    }

    /* renamed from: -redactElements  reason: not valid java name */
    public static final <K, V> Map<K, V> m245redactElements(Map<K, ? extends V> map, ProtoAdapter<V> protoAdapter) {
        return Internal__InternalKt.m247redactElements(map, protoAdapter);
    }

    public static final String boxedOneOfClassName(String str) {
        return Internal__InternalKt.boxedOneOfClassName(str);
    }

    public static final String boxedOneOfKeyFieldName(String str, String str2) {
        return Internal__InternalKt.boxedOneOfKeyFieldName(str, str2);
    }

    public static final String boxedOneOfKeysFieldName(String str) {
        return Internal__InternalKt.boxedOneOfKeysFieldName(str);
    }

    public static final void checkElementsNotNull(List<?> list) {
        Internal__InternalKt.checkElementsNotNull(list);
    }

    public static final void checkElementsNotNull(Map<?, ?> map) {
        Internal__InternalKt.checkElementsNotNull(map);
    }

    @Deprecated(message = "Please regenerate code using wire-compiler version 3.0.0 or higher.", replaceWith = @ReplaceWith(expression = "com.squareup.internal.Internal.copyOf(list)", imports = {}))
    public static final <T> List<T> copyOf(String str, List<? extends T> list) {
        return Internal__InternalKt.copyOf(str, list);
    }

    public static final <T> List<T> copyOf(List<? extends T> list) {
        return Internal__InternalKt.copyOf(list);
    }

    @Deprecated(message = "Please regenerate code using wire-compiler version 3.0.0 or higher.", replaceWith = @ReplaceWith(expression = "com.squareup.internal.Internal.copyOf(map)", imports = {}))
    public static final <K, V> Map<K, V> copyOf(String str, Map<K, ? extends V> map) {
        return Internal__InternalKt.copyOf(str, map);
    }

    public static final <K, V> Map<K, V> copyOf(Map<K, ? extends V> map) {
        return Internal__InternalKt.copyOf(map);
    }

    public static final int countNonNull(Object obj, Object obj2) {
        return Internal__InternalKt.countNonNull(obj, obj2);
    }

    public static final int countNonNull(Object obj, Object obj2, Object obj3) {
        return Internal__InternalKt.countNonNull(obj, obj2, obj3);
    }

    public static final int countNonNull(Object obj, Object obj2, Object obj3, Object obj4, Object... objArr) {
        return Internal__InternalKt.countNonNull(obj, obj2, obj3, obj4, objArr);
    }

    public static final boolean equals(Object obj, Object obj2) {
        return Internal__InternalKt.equals(obj, obj2);
    }

    public static final <E extends WireEnum> E getIdentityOrNull(Class<E> cls) {
        return Internal__InternalJvmKt.getIdentityOrNull(cls);
    }

    public static final <T> List<T> immutableCopyOf(String str, List<? extends T> list) {
        return Internal__InternalKt.immutableCopyOf(str, list);
    }

    public static final <K, V> Map<K, V> immutableCopyOf(String str, Map<K, ? extends V> map) {
        return Internal__InternalKt.immutableCopyOf(str, map);
    }

    public static final <K, V> Map<K, V> immutableCopyOfMapWithStructValues(String str, Map<K, ? extends V> map) {
        return Internal__InternalKt.immutableCopyOfMapWithStructValues(str, map);
    }

    public static final <T> T immutableCopyOfStruct(String str, T t) {
        return Internal__InternalKt.immutableCopyOfStruct(str, t);
    }

    public static final IllegalStateException missingRequiredFields(Object... objArr) {
        return Internal__InternalKt.missingRequiredFields(objArr);
    }

    public static final <T> List<T> newMutableList() {
        return Internal__InternalKt.newMutableList();
    }

    public static final <K, V> Map<K, V> newMutableMap() {
        return Internal__InternalKt.newMutableMap();
    }

    public static final <T> void redactElements(List<T> list, ProtoAdapter<T> protoAdapter) {
        Internal__InternalJvmKt.redactElements(list, protoAdapter);
    }

    public static final <T> void redactElements(Map<?, T> map, ProtoAdapter<T> protoAdapter) {
        Internal__InternalJvmKt.redactElements(map, protoAdapter);
    }

    public static final String sanitize(String str) {
        return Internal__InternalKt.sanitize(str);
    }

    public static final String sanitize(List<String> list) {
        return Internal__InternalKt.sanitize(list);
    }
}
