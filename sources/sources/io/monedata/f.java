package io.monedata;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lio/monedata/f;", "", "", "a", "()Z", "isAvailable", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class f {
    public static final f a = new f();

    private f() {
    }

    public final boolean a() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Class.forName("androidx.core.app.AppComponentFactory");
            obj = Result.m2344constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m2351isSuccessimpl(obj);
    }
}
