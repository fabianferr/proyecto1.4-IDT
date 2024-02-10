package io.monedata.extensions;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0005H\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a+\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H\bø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0007\n\u0005\b20\u0001¨\u0006\r"}, d2 = {"onlyIf", "T", "condition", "", "block", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "requireNotFalse", "", "value", "lazyMessage", "", "(Ljava/lang/Boolean;Lkotlin/jvm/functions/Function0;)V", "core_productionRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ConditionalsKt {
    public static final <T> T onlyIf(boolean z, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        if (z) {
            return function0.invoke();
        }
        return null;
    }

    public static final void requireNotFalse(Boolean bool, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        if (!(!Intrinsics.areEqual((Object) bool, (Object) Boolean.FALSE))) {
            throw new IllegalArgumentException(function0.invoke().toString());
        }
    }

    public static /* synthetic */ void requireNotFalse$default(Boolean bool, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = ConditionalsKt$requireNotFalse$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        if (!(!Intrinsics.areEqual((Object) bool, (Object) false))) {
            throw new IllegalArgumentException(function0.invoke().toString());
        }
    }
}
