package io.monedata;

import android.os.Build;
import android.os.Bundle;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"Landroid/os/Bundle;", "", "key", "a", "core_productionRelease"}, k = 2, mv = {1, 7, 1})
public final class n {
    public static final String a(Bundle bundle, String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        String str2 = null;
        try {
            Result.Companion companion = Result.Companion;
            Object serializable = Build.VERSION.SDK_INT >= 33 ? bundle.getSerializable(str, Serializable.class) : bundle.get(str);
            obj = Result.m2344constructorimpl(serializable instanceof String ? (String) serializable : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        if (!Result.m2350isFailureimpl(obj)) {
            str2 = obj;
        }
        return str2;
    }
}
