package com.m2catalyst.m2sdk;

import android.content.SharedPreferences;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SDKPreferences.kt */
public final class z5 {
    public final SharedPreferences a;

    public z5(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "preferences");
        this.a = sharedPreferences;
    }

    public final SharedPreferences a() {
        return this.a;
    }

    public final void a(a6 a6Var, Object obj) {
        Intrinsics.checkNotNullParameter(a6Var, "setting");
        Intrinsics.checkNotNullParameter(obj, "value");
        String str = a6Var.a;
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, "value");
        if (obj instanceof Boolean) {
            this.a.edit().putBoolean(str, ((Boolean) obj).booleanValue()).apply();
        } else if (obj instanceof Double) {
            this.a.edit().putFloat(str, (float) ((Number) obj).doubleValue()).apply();
        } else if (obj instanceof Integer) {
            this.a.edit().putInt(str, ((Number) obj).intValue()).apply();
        } else if (obj instanceof Float) {
            this.a.edit().putFloat(str, ((Number) obj).floatValue()).apply();
        } else if (obj instanceof Long) {
            this.a.edit().putLong(str, ((Number) obj).longValue()).apply();
        } else if (obj instanceof List) {
            this.a.edit().putString(str, CollectionsKt.joinToString$default((List) obj, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
        } else {
            this.a.edit().putString(str, obj.toString()).apply();
        }
    }
}
