package io.monedata;

import android.content.SharedPreferences;
import io.monedata.consent.ConsentManager;
import io.monedata.extensions.StringKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\f"}, d2 = {"Lio/monedata/x1;", "Lio/monedata/m1;", "Landroid/content/SharedPreferences;", "sp", "", "a", "", "key", "", "onSharedPreferenceChanged", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class x1 extends m1 {
    public static final x1 c = new x1();

    private x1() {
    }

    private final boolean a(SharedPreferences sharedPreferences) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            String string = sharedPreferences.getString("IABTCF_TCString", (String) null);
            StringKt.requireNotEmpty(string);
            MonedataLog monedataLog = MonedataLog.INSTANCE;
            MonedataLog.d$default(monedataLog, "Detected IAB TC string: " + string, (Throwable) null, 2, (Object) null);
            ConsentManager.INSTANCE.setIabString(c.a(), string);
            obj = Result.m2344constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m2351isSuccessimpl(obj);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sp");
        if (Intrinsics.areEqual((Object) str, (Object) "IABTCF_TCString")) {
            a(sharedPreferences);
        }
    }
}
