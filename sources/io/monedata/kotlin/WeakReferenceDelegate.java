package io.monedata.kotlin;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J$\u0010\b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00020\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002¢\u0006\u0002\u0010\fJ*\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000fR\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lio/monedata/kotlin/WeakReferenceDelegate;", "T", "", "()V", "value", "(Ljava/lang/Object;)V", "reference", "Ljava/lang/ref/WeakReference;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WeakReferenceDelegate<T> {
    private WeakReference<T> reference;

    public WeakReferenceDelegate() {
    }

    public WeakReferenceDelegate(T t) {
        this.reference = new WeakReference<>(t);
    }

    public final T getValue(Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(obj, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        WeakReference<T> weakReference = this.reference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void setValue(Object obj, KProperty<?> kProperty, T t) {
        Intrinsics.checkNotNullParameter(obj, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        this.reference = new WeakReference<>(t);
    }
}
