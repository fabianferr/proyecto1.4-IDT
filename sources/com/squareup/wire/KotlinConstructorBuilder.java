package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0001\u001cB\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\r\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\fJ\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a*\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002R(\u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\n\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b0\tX\u0004¢\u0006\u0002\n\u0000R.\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t0\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000b0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/squareup/wire/KotlinConstructorBuilder;", "M", "Lcom/squareup/wire/Message;", "B", "Lcom/squareup/wire/Message$Builder;", "messageType", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "fieldValueMap", "", "", "Lkotlin/Pair;", "Lcom/squareup/wire/WireField;", "", "mapFieldKeyValueMap", "repeatedFieldValueMap", "", "build", "()Lcom/squareup/wire/Message;", "clobberOtherIsOneOfs", "", "field", "get", "set", "value", "declaredProtoFields", "", "Lcom/squareup/wire/KotlinConstructorBuilder$ProtoField;", "ProtoField", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: KotlinConstructorBuilder.kt */
public final class KotlinConstructorBuilder<M extends Message<M, B>, B extends Message.Builder<M, B>> extends Message.Builder<M, B> {
    private final Map<Integer, Pair<WireField, Object>> fieldValueMap;
    private final Map<Integer, Pair<WireField, Map<?, ?>>> mapFieldKeyValueMap;
    private final Class<M> messageType;
    private final Map<Integer, Pair<WireField, List<?>>> repeatedFieldValueMap;

    public KotlinConstructorBuilder(Class<M> cls) {
        Intrinsics.checkNotNullParameter(cls, "messageType");
        this.messageType = cls;
        int length = cls.getDeclaredFields().length;
        this.fieldValueMap = new LinkedHashMap(length);
        this.repeatedFieldValueMap = new LinkedHashMap(length);
        this.mapFieldKeyValueMap = new LinkedHashMap(length);
    }

    public final void set(WireField wireField, Object obj) {
        Intrinsics.checkNotNullParameter(wireField, "field");
        if (KotlinConstructorBuilderKt.isMap(wireField)) {
            Map<Integer, Pair<WireField, Map<?, ?>>> map = this.mapFieldKeyValueMap;
            Integer valueOf = Integer.valueOf(wireField.tag());
            if (obj != null) {
                map.put(valueOf, TuplesKt.to(wireField, TypeIntrinsics.asMutableMap(obj)));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<*, *>");
        } else if (wireField.label().isRepeated()) {
            Map<Integer, Pair<WireField, List<?>>> map2 = this.repeatedFieldValueMap;
            Integer valueOf2 = Integer.valueOf(wireField.tag());
            if (obj != null) {
                map2.put(valueOf2, TuplesKt.to(wireField, TypeIntrinsics.asMutableList(obj)));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<*>");
        } else {
            this.fieldValueMap.put(Integer.valueOf(wireField.tag()), TuplesKt.to(wireField, obj));
            if (obj != null && wireField.label().isOneOf()) {
                clobberOtherIsOneOfs(wireField);
            }
        }
    }

    private final void clobberOtherIsOneOfs(WireField wireField) {
        Iterable<Pair> values = this.fieldValueMap.values();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(values, 10));
        for (Pair first : values) {
            arrayList.add((WireField) first.getFirst());
        }
        Collection arrayList2 = new ArrayList();
        for (Object next : (List) arrayList) {
            WireField wireField2 = (WireField) next;
            if (Intrinsics.areEqual((Object) wireField2.oneofName(), (Object) wireField.oneofName()) && wireField2.tag() != wireField.tag()) {
                arrayList2.add(next);
            }
        }
        for (WireField tag : (List) arrayList2) {
            this.fieldValueMap.remove(Integer.valueOf(tag.tag()));
        }
    }

    public final Object get(WireField wireField) {
        Intrinsics.checkNotNullParameter(wireField, "field");
        Object obj = null;
        if (KotlinConstructorBuilderKt.isMap(wireField)) {
            Pair pair = this.mapFieldKeyValueMap.get(Integer.valueOf(wireField.tag()));
            if (pair != null) {
                obj = (Map) pair.getSecond();
            }
            if (obj == null) {
                return MapsKt.emptyMap();
            }
            return obj;
        } else if (wireField.label().isRepeated()) {
            Pair pair2 = this.repeatedFieldValueMap.get(Integer.valueOf(wireField.tag()));
            if (pair2 != null) {
                obj = (List) pair2.getSecond();
            }
            if (obj == null) {
                return CollectionsKt.emptyList();
            }
            return obj;
        } else {
            Pair pair3 = this.fieldValueMap.get(Integer.valueOf(wireField.tag()));
            if (pair3 == null) {
                return null;
            }
            return pair3.getSecond();
        }
    }

    public M build() {
        Object obj;
        List<ProtoField> declaredProtoFields = declaredProtoFields(this.messageType);
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        for (ProtoField next : declaredProtoFields) {
            if (next.getWireField().label().isRepeated() || KotlinConstructorBuilderKt.isMap(next.getWireField())) {
                arrayDeque.add(next);
            } else {
                arrayDeque2.add(next);
            }
        }
        Constructor[] constructors = this.messageType.getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "messageType.constructors");
        Object[] objArr = (Object[]) constructors;
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object obj2 = objArr[i];
            i++;
            Constructor constructor = (Constructor) obj2;
            boolean z = true;
            if (constructor.getParameterCount() != declaredProtoFields.size() + 1) {
                z = false;
                continue;
            }
            if (z) {
                Parameter[] parameters = constructor.getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters, "constructor.parameters");
                Object[] objArr2 = (Object[]) parameters;
                Collection arrayList = new ArrayList(objArr2.length);
                int length2 = objArr2.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length2) {
                    Object obj3 = objArr2[i2];
                    i2++;
                    int i4 = i3 + 1;
                    Parameter parameter = (Parameter) obj3;
                    if (Intrinsics.areEqual((Object) parameter.getType(), (Object) List.class) || Intrinsics.areEqual((Object) parameter.getType(), (Object) Map.class)) {
                        obj = get(((ProtoField) arrayDeque.removeFirst()).getWireField());
                    } else if (i3 == declaredProtoFields.size()) {
                        obj = buildUnknownFields();
                    } else {
                        obj = get(((ProtoField) arrayDeque2.removeFirst()).getWireField());
                    }
                    arrayList.add(obj);
                    i3 = i4;
                }
                Object[] array = ((List) arrayList).toArray(new Object[0]);
                if (array != null) {
                    M newInstance = constructor.newInstance(Arrays.copyOf(array, array.length));
                    if (newInstance != null) {
                        return (Message) newInstance;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type M of com.squareup.wire.KotlinConstructorBuilder");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    private final List<ProtoField> declaredProtoFields(Class<M> cls) {
        ProtoField protoField;
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "declaredFields");
        Object[] objArr = (Object[]) declaredFields;
        Collection arrayList = new ArrayList();
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            Field field = (Field) obj;
            Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
            Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "field.declaredAnnotations");
            WireField wireField = (WireField) CollectionsKt.firstOrNull(ArraysKt.filterIsInstance((Object[]) declaredAnnotations, WireField.class));
            if (wireField == null) {
                protoField = null;
            } else {
                Class<?> type = field.getType();
                Intrinsics.checkNotNullExpressionValue(type, "field.type");
                protoField = new ProtoField(type, wireField);
            }
            if (protoField != null) {
                arrayList.add(protoField);
            }
        }
        return (List) arrayList;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/squareup/wire/KotlinConstructorBuilder$ProtoField;", "", "type", "Ljava/lang/Class;", "wireField", "Lcom/squareup/wire/WireField;", "(Ljava/lang/Class;Lcom/squareup/wire/WireField;)V", "getType", "()Ljava/lang/Class;", "getWireField", "()Lcom/squareup/wire/WireField;", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: KotlinConstructorBuilder.kt */
    private static final class ProtoField {
        private final Class<?> type;
        private final WireField wireField;

        public ProtoField(Class<?> cls, WireField wireField2) {
            Intrinsics.checkNotNullParameter(cls, "type");
            Intrinsics.checkNotNullParameter(wireField2, "wireField");
            this.type = cls;
            this.wireField = wireField2;
        }

        public final Class<?> getType() {
            return this.type;
        }

        public final WireField getWireField() {
            return this.wireField;
        }
    }
}
