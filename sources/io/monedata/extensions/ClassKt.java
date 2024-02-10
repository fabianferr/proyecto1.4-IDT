package io.monedata.extensions;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001e\u0010\u0004\u001a\u0002H\u0005\"\u0006\b\u0000\u0010\u0005\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0006H\b¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"classExists", "", "className", "", "instantiate", "T", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "core_productionRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ClassKt {
    public static final boolean classExists(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "className");
        try {
            Result.Companion companion = Result.Companion;
            Class.forName(str);
            obj = Result.m2344constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m2351isSuccessimpl(obj);
    }

    public static final /* synthetic */ <T> T instantiate(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        T newInstance = cls.newInstance();
        Intrinsics.reifiedOperationMarker(1, "T");
        Object obj = (Object) newInstance;
        return newInstance;
    }
}
