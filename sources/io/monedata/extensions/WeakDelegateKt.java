package io.monedata.extensions;

import io.monedata.kotlin.WeakReferenceDelegate;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\b\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\b¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"weak", "Lio/monedata/kotlin/WeakReferenceDelegate;", "T", "value", "(Ljava/lang/Object;)Lio/monedata/kotlin/WeakReferenceDelegate;", "core_productionRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class WeakDelegateKt {
    public static final /* synthetic */ <T> WeakReferenceDelegate<T> weak() {
        return new WeakReferenceDelegate<>();
    }

    public static final /* synthetic */ <T> WeakReferenceDelegate<T> weak(T t) {
        return new WeakReferenceDelegate<>(t);
    }
}
