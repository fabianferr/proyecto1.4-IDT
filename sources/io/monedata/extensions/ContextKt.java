package io.monedata.extensions;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import androidx.preference.PreferenceManager;
import io.monedata.BuildConfig;
import io.monedata.n1;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u0014\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f\u001a$\u0010\u0010\u001a\u0004\u0018\u0001H\u0011\"\u0006\b\u0000\u0010\u0011\u0018\u0001*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\b¢\u0006\u0002\u0010\u0014\u001a#\u0010\u0015\u001a\u00020\u0006*\u00020\u00022\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0017\"\u00020\u0013¢\u0006\u0002\u0010\u0018\u001a\u0012\u0010\u0019\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013\"\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00028À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0018\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0019\u0010\f\u001a\u00020\u0001*\u00020\u00028À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0004¨\u0006\u001a"}, d2 = {"defaultPreferences", "Landroid/content/SharedPreferences;", "Landroid/content/Context;", "getDefaultPreferences", "(Landroid/content/Context;)Landroid/content/SharedPreferences;", "isMainProcess", "", "(Landroid/content/Context;)Z", "packageInfo", "Landroid/content/pm/PackageInfo;", "getPackageInfo", "(Landroid/content/Context;)Landroid/content/pm/PackageInfo;", "preferences", "getPreferences", "flags", "", "getService", "T", "name", "", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;", "hasAnyPermission", "list", "", "(Landroid/content/Context;[Ljava/lang/String;)Z", "hasPermission", "core_productionRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ContextKt {
    public static final SharedPreferences getDefaultPreferences(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(this)");
        return defaultSharedPreferences;
    }

    public static final PackageInfo getPackageInfo(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return getPackageInfo(context, 0);
    }

    public static final PackageInfo getPackageInfo(Context context, int i) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            PackageManager packageManager = context.getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "packageManager");
            String packageName = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
            obj = Result.m2344constructorimpl(PackageManagerKt.getCompatPackageInfo(packageManager, packageName, Integer.valueOf(i)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2350isFailureimpl(obj)) {
            obj = null;
        }
        return (PackageInfo) obj;
    }

    public static final SharedPreferences getPreferences(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        SharedPreferences sharedPreferences = context.getSharedPreferences(BuildConfig.LIBRARY_PACKAGE_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(\"io.monedata\", MODE_PRIVATE)");
        return sharedPreferences;
    }

    public static final /* synthetic */ <T> T getService(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        T systemService = context.getSystemService(str);
        Intrinsics.reifiedOperationMarker(2, "T");
        Object obj = (Object) systemService;
        return systemService;
    }

    public static final boolean hasAnyPermission(Context context, String... strArr) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(strArr, "list");
        for (String hasPermission : strArr) {
            if (hasPermission(context, hasPermission)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean hasPermission(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public static final boolean isMainProcess(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return n1.a.b(context);
    }
}
