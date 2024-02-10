package com.wortise.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001c\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u001a\u0012\u0010\u0005\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u001a\u0010\u0005\u001a\u00020\b*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¨\u0006\r"}, d2 = {"Landroid/content/Intent;", "", "name", "", "value", "a", "Landroid/content/Context;", "context", "", "Landroid/app/Activity;", "activity", "", "requestCode", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: Intent.kt */
public final class k4 {
    public static final Intent a(Intent intent, String str, Object obj) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        Intent putExtra = intent.putExtra(str, obj == null ? null : p4.a(obj));
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(name, value?.toJson())");
        return putExtra;
    }

    public static final boolean a(Intent intent, Context context) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message == null) {
                message = "Caught an exception";
            }
            WortiseLog.e(message, th);
            return false;
        }
    }

    public static final boolean a(Intent intent, Activity activity, int i) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            activity.startActivityForResult(intent, i);
            return true;
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message == null) {
                message = "Caught an exception";
            }
            WortiseLog.e(message, th);
            return false;
        }
    }
}
