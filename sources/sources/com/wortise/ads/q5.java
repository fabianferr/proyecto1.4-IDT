package com.wortise.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ8\u0010\u000b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00050\u00050\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004H\u0002J\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00050\u00050\t2\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/wortise/ads/q5;", "", "Landroid/content/Context;", "context", "Lkotlin/Function2;", "", "", "", "filter", "", "kotlin.jvm.PlatformType", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: PermissionUtils.kt */
public final class q5 {
    public static final q5 a = new q5();

    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n"}, d2 = {"", "<anonymous parameter 0>", "", "flags", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: PermissionUtils.kt */
    static final class a extends Lambda implements Function2<String, Integer, Boolean> {
        public static final a a = new a();

        a() {
            super(2);
        }

        public final Boolean a(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "$noName_0");
            return Boolean.valueOf((i & 2) != 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((String) obj, ((Number) obj2).intValue());
        }
    }

    private q5() {
    }

    private final List<String> a(Context context, Function2<? super String, ? super Integer, Boolean> function2) {
        ArrayList arrayList;
        try {
            PackageInfo a2 = b2.a(context, 4096);
            if (a2 != null) {
                int[] iArr = a2.requestedPermissionsFlags;
                String[] strArr = a2.requestedPermissions;
                Intrinsics.checkNotNullExpressionValue(strArr, "list");
                arrayList = new ArrayList();
                int length = strArr.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    String str = strArr[i];
                    int i3 = i2 + 1;
                    Intrinsics.checkNotNullExpressionValue(str, "p");
                    if (function2.invoke(str, Integer.valueOf(iArr[i2])).booleanValue()) {
                        arrayList.add(str);
                    }
                    i++;
                    i2 = i3;
                }
                return arrayList == null ? CollectionsKt.emptyList() : arrayList;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        } catch (Throwable unused) {
            arrayList = null;
        }
    }

    public final List<String> a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return a(context, a.a);
    }
}
