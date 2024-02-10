package com.wortise.ads;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0003BK\u0012\u001d\u0010\u0010\u001a\u0019\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e0\r¢\u0006\u0002\b\u000f\u0012#\u0010\u0015\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00140\r0\r¢\u0006\u0002\b\u000f¢\u0006\u0004\b\u0017\u0010\u0018J&\u0010\u0007\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u00002\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00028\u00002\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\b\u0010\t\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\fR.\u0010\u0010\u001a\u0019\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e0\r¢\u0006\u0002\b\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R4\u0010\u0015\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00140\r0\r¢\u0006\u0002\b\u000f8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/wortise/ads/b6;", "T", "U", "Lkotlin/properties/ReadWriteProperty;", "thisRef", "Lkotlin/reflect/KProperty;", "property", "getValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "value", "", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "Lkotlin/Function1;", "Lkotlin/Function0;", "Lkotlin/ExtensionFunctionType;", "getter", "Lkotlin/jvm/functions/Function1;", "a", "()Lkotlin/jvm/functions/Function1;", "", "setter", "b", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: SafeDelegate.kt */
public final class b6<T, U> implements ReadWriteProperty<T, U> {
    private final Function1<T, Function0<U>> a;
    private final Function1<T, Function1<U, Object>> b;

    public b6(Function1<? super T, ? extends Function0<? extends U>> function1, Function1<? super T, ? extends Function1<? super U, ? extends Object>> function12) {
        Intrinsics.checkNotNullParameter(function1, "getter");
        Intrinsics.checkNotNullParameter(function12, "setter");
        this.a = function1;
        this.b = function12;
    }

    public final Function1<T, Function0<U>> a() {
        return this.a;
    }

    public final Function1<T, Function1<U, Object>> b() {
        return this.b;
    }

    public U getValue(T t, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        try {
            return ((Function0) a().invoke(t)).invoke();
        } catch (Throwable unused) {
            return null;
        }
    }

    public void setValue(T t, KProperty<?> kProperty, U u) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        if (u != null) {
            try {
                ((Function1) b().invoke(t)).invoke(u);
            } catch (Throwable unused) {
            }
        }
    }
}
