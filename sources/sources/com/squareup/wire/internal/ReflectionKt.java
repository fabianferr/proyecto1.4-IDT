package com.squareup.wire.internal;

import com.squareup.wire.KotlinConstructorBuilder;
import com.squareup.wire.Message;
import com.squareup.wire.OneOf;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aT\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\"\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001ah\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\"\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\b\u001a\u00020\t\u001aH\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\"\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0002\u001aF\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u0010\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\"\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¨\u0006\u0014"}, d2 = {"createRuntimeMessageAdapter", "Lcom/squareup/wire/internal/RuntimeMessageAdapter;", "M", "B", "Lcom/squareup/wire/Message;", "Lcom/squareup/wire/Message$Builder;", "messageType", "Ljava/lang/Class;", "writeIdentityValues", "", "typeUrl", "", "syntax", "Lcom/squareup/wire/Syntax;", "getBuilderType", "getKeys", "", "Lcom/squareup/wire/OneOf$Key;", "messageField", "Ljava/lang/reflect/Field;", "wire-runtime"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: reflection.kt */
public final class ReflectionKt {
    public static /* synthetic */ RuntimeMessageAdapter createRuntimeMessageAdapter$default(Class cls, String str, Syntax syntax, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return createRuntimeMessageAdapter(cls, str, syntax, z);
    }

    public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> createRuntimeMessageAdapter(Class<M> cls, String str, Syntax syntax, boolean z) {
        Class<M> cls2 = cls;
        Intrinsics.checkNotNullParameter(cls2, "messageType");
        Intrinsics.checkNotNullParameter(syntax, "syntax");
        Class<B> builderType = getBuilderType(cls);
        Function0 reflectionKt$createRuntimeMessageAdapter$newBuilderInstance$1 = new ReflectionKt$createRuntimeMessageAdapter$newBuilderInstance$1(builderType, cls2);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "messageType.declaredFields");
        int length = declaredFields.length;
        int i = 0;
        while (i < length) {
            Field field = declaredFields[i];
            int i2 = i + 1;
            WireField wireField = (WireField) field.getAnnotation(WireField.class);
            if (wireField != null) {
                Integer valueOf = Integer.valueOf(wireField.tag());
                Intrinsics.checkNotNullExpressionValue(field, "messageField");
                FieldBinding fieldBinding = r0;
                FieldBinding fieldBinding2 = new FieldBinding(wireField, cls, field, builderType, z);
                linkedHashMap.put(valueOf, fieldBinding);
            } else if (Intrinsics.areEqual((Object) field.getType(), (Object) OneOf.class)) {
                Intrinsics.checkNotNullExpressionValue(field, "messageField");
                for (OneOf.Key next : getKeys(field)) {
                    linkedHashMap.put(Integer.valueOf(next.getTag()), new OneOfBinding(field, builderType, next, z));
                }
            }
            boolean z2 = z;
            Class<M> cls3 = cls;
            i = i2;
        }
        KClass<M> kotlinClass = JvmClassMappingKt.getKotlinClass(cls);
        Map unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "unmodifiableMap(fields)");
        return new RuntimeMessageAdapter<>(new RuntimeMessageBinding(kotlinClass, builderType, reflectionKt$createRuntimeMessageAdapter$newBuilderInstance$1, unmodifiableMap, str, syntax));
    }

    private static final <M extends Message<M, B>, B extends Message.Builder<M, B>> Set<OneOf.Key<?>> getKeys(Field field) {
        Class<?> declaringClass = field.getDeclaringClass();
        String name = field.getName();
        Intrinsics.checkNotNullExpressionValue(name, "messageField.name");
        Field declaredField = declaringClass.getDeclaredField(Internal.boxedOneOfKeysFieldName(name));
        declaredField.setAccessible(true);
        Object obj = declaredField.get((Object) null);
        if (obj != null) {
            return (Set) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Set<com.squareup.wire.OneOf.Key<*>>");
    }

    public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> createRuntimeMessageAdapter(Class<M> cls, boolean z) {
        Intrinsics.checkNotNullParameter(cls, "messageType");
        ProtoAdapter<M> protoAdapter = ProtoAdapter.Companion.get(cls);
        return createRuntimeMessageAdapter(cls, protoAdapter.getTypeUrl(), protoAdapter.getSyntax(), z);
    }

    private static final <M extends Message<M, B>, B extends Message.Builder<M, B>> Class<B> getBuilderType(Class<M> cls) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Class<?> cls2 = Class.forName(Intrinsics.stringPlus(cls.getName(), "$Builder"));
            if (cls2 != null) {
                obj = Result.m2344constructorimpl(cls2);
                if (Result.m2350isFailureimpl(obj)) {
                    obj = null;
                }
                Class<B> cls3 = (Class) obj;
                return cls3 == null ? KotlinConstructorBuilder.class : cls3;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<B of com.squareup.wire.internal.ReflectionKt.getBuilderType$lambda-0>");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
    }
}
