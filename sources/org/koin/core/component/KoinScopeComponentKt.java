package org.koin.core.component;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.scope.Scope;
import org.koin.ext.KClassExtKt;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006\u001a\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002¢\u0006\u0002\u0010\t\u001a\u0019\u0010\n\u001a\u00020\u000b\"\b\b\u0000\u0010\u0002*\u00020\u0005*\u0002H\u0002¢\u0006\u0002\u0010\f\u001a\u0019\u0010\r\u001a\u00020\u000e\"\b\b\u0000\u0010\u0002*\u00020\u0005*\u0002H\u0002¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002¢\u0006\u0002\u0010\u0011\u001a\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\b\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002¢\u0006\u0002\u0010\t¨\u0006\u0013"}, d2 = {"createScope", "Lorg/koin/core/scope/Scope;", "T", "Lorg/koin/core/component/KoinScopeComponent;", "source", "", "(Lorg/koin/core/component/KoinScopeComponent;Ljava/lang/Object;)Lorg/koin/core/scope/Scope;", "getOrCreateScope", "Lkotlin/Lazy;", "(Lorg/koin/core/component/KoinScopeComponent;)Lkotlin/Lazy;", "getScopeId", "", "(Ljava/lang/Object;)Ljava/lang/String;", "getScopeName", "Lorg/koin/core/qualifier/TypeQualifier;", "(Ljava/lang/Object;)Lorg/koin/core/qualifier/TypeQualifier;", "getScopeOrNull", "(Lorg/koin/core/component/KoinScopeComponent;)Lorg/koin/core/scope/Scope;", "newScope", "koin-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: KoinScopeComponent.kt */
public final class KoinScopeComponentKt {
    public static final <T> String getScopeId(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        return KClassExtKt.getFullName(Reflection.getOrCreateKotlinClass(t.getClass())) + '@' + t.hashCode();
    }

    public static final <T> TypeQualifier getScopeName(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        return new TypeQualifier(Reflection.getOrCreateKotlinClass(t.getClass()));
    }

    public static /* synthetic */ Scope createScope$default(KoinScopeComponent koinScopeComponent, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return createScope(koinScopeComponent, obj);
    }

    public static final <T extends KoinScopeComponent> Scope createScope(T t, Object obj) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        return t.getKoin().createScope(getScopeId(t), getScopeName(t), obj);
    }

    public static final <T extends KoinScopeComponent> Scope getScopeOrNull(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        return t.getKoin().getScopeOrNull(getScopeId(t));
    }

    public static final <T extends KoinScopeComponent> Lazy<Scope> newScope(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        return LazyKt.lazy(new KoinScopeComponentKt$newScope$1(t));
    }

    public static final <T extends KoinScopeComponent> Lazy<Scope> getOrCreateScope(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        return LazyKt.lazy(new KoinScopeComponentKt$getOrCreateScope$1(t));
    }
}
