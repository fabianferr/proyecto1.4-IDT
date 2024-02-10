package io.monedata;

import android.app.AlertDialog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\u001a \u0010\u0002\u001a\u0004\u0018\u00010\u0000*\u00020\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0000¨\u0006\u0007"}, d2 = {"Landroid/app/AlertDialog;", "", "a", "Landroid/app/AlertDialog$Builder;", "Lkotlin/Function0;", "", "block", "core_productionRelease"}, k = 2, mv = {1, 7, 1})
public final class d {
    public static final AlertDialog a(AlertDialog.Builder builder, Function0<Unit> function0) {
        Object obj;
        Intrinsics.checkNotNullParameter(builder, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m2344constructorimpl(builder.show());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2350isFailureimpl(obj)) {
            obj = null;
        }
        AlertDialog alertDialog = (AlertDialog) obj;
        if (alertDialog == null) {
            return null;
        }
        if (function0 != null) {
            function0.invoke();
        }
        return alertDialog;
    }

    public static /* synthetic */ AlertDialog a(AlertDialog.Builder builder, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        return a(builder, function0);
    }

    public static final boolean a(AlertDialog alertDialog) {
        Object obj;
        Intrinsics.checkNotNullParameter(alertDialog, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            alertDialog.dismiss();
            obj = Result.m2344constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m2351isSuccessimpl(obj);
    }
}
