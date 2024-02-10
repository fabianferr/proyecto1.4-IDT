package com.wortise.ads;

import android.content.SharedPreferences;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\u001a3\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a-\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000b\u001a \u0010\u0007\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u001a \u0010\u0007\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000f\u001a(\u0010\u0007\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¨\u0006\u0011"}, d2 = {"", "T", "Landroid/content/SharedPreferences;", "", "key", "Lkotlin/reflect/KClass;", "clazz", "a", "(Landroid/content/SharedPreferences;Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "Ljava/lang/reflect/Type;", "type", "(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "Lkotlin/Function0;", "fallback", "Landroid/content/SharedPreferences$Editor;", "", "value", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: SharedPreferences.kt */
public final class g6 {
    public static final <T> T a(SharedPreferences sharedPreferences, String str, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        return a(sharedPreferences, str, (Type) JvmClassMappingKt.getJavaObjectType(kClass));
    }

    public static final <T> T a(SharedPreferences sharedPreferences, String str, Type type) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(type, "type");
        try {
            String string = sharedPreferences.getString(str, (String) null);
            if (string == null) {
                return null;
            }
            return q4.a.a(string, type);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final String a(SharedPreferences sharedPreferences, String str, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(function0, "fallback");
        String string = sharedPreferences.getString(str, (String) null);
        if (string != null) {
            return string;
        }
        String invoke = function0.invoke();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(str, invoke);
        edit.apply();
        return invoke;
    }

    public static final SharedPreferences.Editor a(SharedPreferences.Editor editor, String str, Enum<?> enumR) {
        Intrinsics.checkNotNullParameter(editor, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences.Editor putString = editor.putString(str, enumR == null ? null : enumR.name());
        Intrinsics.checkNotNullExpressionValue(putString, "putString(key, value?.name)");
        return putString;
    }

    public static /* synthetic */ SharedPreferences.Editor a(SharedPreferences.Editor editor, String str, Object obj, Type type, int i, Object obj2) {
        if ((i & 4) != 0) {
            type = null;
        }
        return a(editor, str, obj, type);
    }

    public static final SharedPreferences.Editor a(SharedPreferences.Editor editor, String str, Object obj, Type type) {
        Intrinsics.checkNotNullParameter(editor, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        String str2 = null;
        if (obj != null) {
            try {
                q4 q4Var = q4.a;
                if (type == null) {
                    type = obj.getClass();
                }
                str2 = q4Var.a(obj, type);
            } catch (Throwable unused) {
            }
        }
        SharedPreferences.Editor putString = editor.putString(str, str2);
        Intrinsics.checkNotNullExpressionValue(putString, "putString(key, json)");
        return putString;
    }
}
