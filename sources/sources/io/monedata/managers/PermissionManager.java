package io.monedata.managers;

import android.content.Context;
import android.content.pm.PackageInfo;
import io.monedata.extensions.ContextKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\t0\t0\u000b2\u0006\u0010\u0006\u001a\u00020\u0007J:\u0010\r\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\t0\t0\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fJ\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\t0\t0\u000b2\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lio/monedata/managers/PermissionManager;", "", "()V", "HAS_FLAGS", "", "contains", "context", "Landroid/content/Context;", "name", "", "denied", "", "kotlin.jvm.PlatformType", "get", "filter", "Lkotlin/Function2;", "", "granted", "core_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PermissionManager {
    private static final boolean HAS_FLAGS = true;
    public static final PermissionManager INSTANCE = new PermissionManager();

    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "<anonymous parameter 0>", "", "flags", "", "a", "(Ljava/lang/String;I)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1})
    static final class a extends Lambda implements Function2<String, Integer, Boolean> {
        public static final a a = new a();

        a() {
            super(2);
        }

        public final Boolean a(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
            return Boolean.valueOf((i & 2) == 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((String) obj, ((Number) obj2).intValue());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "<anonymous parameter 0>", "", "flags", "", "a", "(Ljava/lang/String;I)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1})
    static final class b extends Lambda implements Function2<String, Integer, Boolean> {
        public static final b a = new b();

        b() {
            super(2);
        }

        public final Boolean a(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
            return Boolean.valueOf((i & 2) != 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((String) obj, ((Number) obj2).intValue());
        }
    }

    private PermissionManager() {
    }

    public static /* synthetic */ List get$default(PermissionManager permissionManager, Context context, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        return permissionManager.get(context, function2);
    }

    public final boolean contains(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        return get$default(this, context, (Function2) null, 2, (Object) null).contains(str);
    }

    public final List<String> denied(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return get(context, a.a);
    }

    public final List<String> get(Context context, Function2<? super String, ? super Integer, Boolean> function2) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.Companion;
            PackageInfo packageInfo = ContextKt.getPackageInfo(context, 4096);
            if (packageInfo == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            } else if (!HAS_FLAGS || function2 == null) {
                String[] strArr = packageInfo.requestedPermissions;
                Intrinsics.checkNotNullExpressionValue(strArr, "info.requestedPermissions");
                return ArraysKt.toList((T[]) strArr);
            } else {
                int[] iArr = packageInfo.requestedPermissionsFlags;
                String[] strArr2 = packageInfo.requestedPermissions;
                Intrinsics.checkNotNullExpressionValue(strArr2, "info.requestedPermissions");
                ArrayList arrayList = new ArrayList();
                int length = strArr2.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    String str = strArr2[i];
                    int i3 = i2 + 1;
                    Intrinsics.checkNotNullExpressionValue(str, "p");
                    if (function2.invoke(str, Integer.valueOf(iArr[i2])).booleanValue()) {
                        arrayList.add(str);
                    }
                    i++;
                    i2 = i3;
                }
                obj = Result.m2344constructorimpl(arrayList);
                if (Result.m2350isFailureimpl(obj)) {
                    obj = null;
                }
                List<String> list = (List) obj;
                return list == null ? CollectionsKt.emptyList() : list;
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final List<String> granted(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return get(context, b.a);
    }
}
