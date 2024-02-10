package com.squareup.wire;

import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u0016*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0016B\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006B\u001d\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0017\u0010\u0010\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0014¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/squareup/wire/RuntimeEnumAdapter;", "E", "Lcom/squareup/wire/WireEnum;", "Lcom/squareup/wire/EnumAdapter;", "javaType", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "syntax", "Lcom/squareup/wire/Syntax;", "(Ljava/lang/Class;Lcom/squareup/wire/Syntax;)V", "fromValueMethod", "Ljava/lang/reflect/Method;", "equals", "", "other", "", "fromValue", "value", "", "(I)Lcom/squareup/wire/WireEnum;", "getFromValueMethod", "hashCode", "Companion", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RuntimeEnumAdapter.kt */
public final class RuntimeEnumAdapter<E extends WireEnum> extends EnumAdapter<E> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Method fromValueMethod;
    private final Class<E> javaType;

    @JvmStatic
    public static final <E extends WireEnum> RuntimeEnumAdapter<E> create(Class<E> cls) {
        return Companion.create(cls);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RuntimeEnumAdapter(Class<E> cls, Syntax syntax) {
        super(JvmClassMappingKt.getKotlinClass(cls), syntax, Internal.getIdentityOrNull(cls));
        Intrinsics.checkNotNullParameter(cls, "javaType");
        Intrinsics.checkNotNullParameter(syntax, "syntax");
        this.javaType = cls;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RuntimeEnumAdapter(Class<E> cls) {
        this(cls, Syntax.PROTO_2);
        Intrinsics.checkNotNullParameter(cls, "javaType");
    }

    private final Method getFromValueMethod() {
        Method method = this.fromValueMethod;
        if (method != null) {
            return method;
        }
        Method method2 = this.javaType.getMethod("fromValue", new Class[]{Integer.TYPE});
        this.fromValueMethod = method2;
        Intrinsics.checkNotNullExpressionValue(method2, "javaType.getMethod(\"from…romValueMethod = it\n    }");
        return method2;
    }

    /* access modifiers changed from: protected */
    public E fromValue(int i) {
        E invoke = getFromValueMethod().invoke((Object) null, new Object[]{Integer.valueOf(i)});
        if (invoke != null) {
            return (WireEnum) invoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type E of com.squareup.wire.RuntimeEnumAdapter");
    }

    public boolean equals(Object obj) {
        return (obj instanceof RuntimeEnumAdapter) && Intrinsics.areEqual((Object) ((RuntimeEnumAdapter) obj).getType(), (Object) getType());
    }

    public int hashCode() {
        KClass<?> type = getType();
        if (type == null) {
            return 0;
        }
        return type.hashCode();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH\u0007¨\u0006\t"}, d2 = {"Lcom/squareup/wire/RuntimeEnumAdapter$Companion;", "", "()V", "create", "Lcom/squareup/wire/RuntimeEnumAdapter;", "E", "Lcom/squareup/wire/WireEnum;", "enumType", "Ljava/lang/Class;", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RuntimeEnumAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final <E extends WireEnum> RuntimeEnumAdapter<E> create(Class<E> cls) {
            Intrinsics.checkNotNullParameter(cls, "enumType");
            return new RuntimeEnumAdapter<>(cls, ProtoAdapter.Companion.get(cls).getSyntax());
        }
    }
}
