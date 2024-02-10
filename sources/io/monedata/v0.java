package io.monedata;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lio/monedata/v0;", "", "Landroid/content/Context;", "context", "Lio/monedata/u0;", "a", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class v0 {
    public static final v0 a = new v0();

    private v0() {
    }

    public final u0 a(Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        u0 u0Var = null;
        try {
            Result.Companion companion = Result.Companion;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(this)");
            String string = defaultSharedPreferences.getString("appconsent_hello_reply", (String) null);
            if (string != null) {
                obj = Result.m2344constructorimpl((u0) t0.a().fromJson(string, u0.class));
                if (!Result.m2350isFailureimpl(obj)) {
                    u0Var = obj;
                }
                return u0Var;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
    }
}
