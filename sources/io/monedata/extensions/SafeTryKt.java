package io.monedata.extensions;

import com.facebook.internal.NativeProtocol;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\bø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a.\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007\"\u0004\b\u0000\u0010\u00012\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00070\u0004H\bø\u0001\u0000\u001a)\u0010\b\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0004H\bø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u001a\u0010\n\u001a\u00020\u000b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\f0\u0004H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\r"}, d2 = {"tryOrDefault", "T", "defaultValue", "action", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "tryOrEmpty", "", "tryOrNull", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "tryQuietly", "", "", "core_productionRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SafeTryKt {
    public static final <T> T tryOrDefault(T t, Function0<? extends T> function0) {
        T t2;
        Intrinsics.checkNotNullParameter(function0, NativeProtocol.WEB_DIALOG_ACTION);
        try {
            Result.Companion companion = Result.Companion;
            t2 = Result.m2344constructorimpl(function0.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            t2 = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m2350isFailureimpl(t2) ? t : t2;
    }

    public static final <T> List<T> tryOrEmpty(Function0<? extends List<? extends T>> function0) {
        Object obj;
        Intrinsics.checkNotNullParameter(function0, NativeProtocol.WEB_DIALOG_ACTION);
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m2344constructorimpl(function0.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2350isFailureimpl(obj)) {
            obj = null;
        }
        List<T> list = (List) obj;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public static final <T> T tryOrNull(Function0<? extends T> function0) {
        T t;
        Intrinsics.checkNotNullParameter(function0, NativeProtocol.WEB_DIALOG_ACTION);
        try {
            Result.Companion companion = Result.Companion;
            t = Result.m2344constructorimpl(function0.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            t = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2350isFailureimpl(t)) {
            return null;
        }
        return t;
    }

    public static final boolean tryQuietly(Function0<Unit> function0) {
        Object obj;
        Intrinsics.checkNotNullParameter(function0, NativeProtocol.WEB_DIALOG_ACTION);
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m2344constructorimpl(function0.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m2351isSuccessimpl(obj);
    }
}
