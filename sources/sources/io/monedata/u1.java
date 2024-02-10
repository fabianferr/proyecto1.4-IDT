package io.monedata;

import android.content.SharedPreferences;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a#\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004\u001a#\u0010\u0006\u001a\u0004\u0018\u00010\t*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u000b\u001a3\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\r*\u00020\f*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0006\u0010\u0010\u001a-\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\r*\u00020\f*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0006\u0010\u0013\u001a \u0010\u0006\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014\u001a#\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\u0017\u001a;\u0010\u0006\u001a\u00020\u0002\"\b\b\u0000\u0010\r*\u00020\f*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00018\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0006\u0010\u0018\u001a5\u0010\u0006\u001a\u00020\u0002\"\b\b\u0000\u0010\r*\u00020\f*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0006\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroid/content/SharedPreferences;", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "", "Lkotlin/ExtensionFunctionType;", "block", "a", "", "key", "", "defValue", "(Landroid/content/SharedPreferences;Ljava/lang/String;Z)Ljava/lang/Boolean;", "", "T", "Lkotlin/reflect/KClass;", "clazz", "(Landroid/content/SharedPreferences;Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "Ljava/lang/reflect/Type;", "type", "(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "Lkotlin/Function0;", "fallback", "value", "(Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Ljava/lang/Boolean;)Landroid/content/SharedPreferences$Editor;", "(Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Ljava/lang/Object;Lkotlin/reflect/KClass;)Landroid/content/SharedPreferences$Editor;", "(Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;)Landroid/content/SharedPreferences$Editor;", "core_productionRelease"}, k = 2, mv = {1, 7, 1})
public final class u1 {

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/content/SharedPreferences$Editor;", "", "a", "(Landroid/content/SharedPreferences$Editor;)V"}, k = 3, mv = {1, 7, 1})
    static final class a extends Lambda implements Function1<SharedPreferences.Editor, Unit> {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, String str2) {
            super(1);
            this.a = str;
            this.b = str2;
        }

        public final void a(SharedPreferences.Editor editor) {
            Intrinsics.checkNotNullParameter(editor, "$this$edit");
            editor.putString(this.a, this.b);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((SharedPreferences.Editor) obj);
            return Unit.INSTANCE;
        }
    }

    public static final SharedPreferences.Editor a(SharedPreferences.Editor editor, String str, Boolean bool) {
        Intrinsics.checkNotNullParameter(editor, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences.Editor putBoolean = bool != null ? editor.putBoolean(str, bool.booleanValue()) : null;
        if (putBoolean != null) {
            return putBoolean;
        }
        SharedPreferences.Editor remove = editor.remove(str);
        Intrinsics.checkNotNullExpressionValue(remove, "remove(key)");
        return remove;
    }

    public static final <T> SharedPreferences.Editor a(SharedPreferences.Editor editor, String str, T t, Type type) {
        String str2;
        Intrinsics.checkNotNullParameter(editor, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(type, "type");
        try {
            str2 = r1.a.a((Object) t, type);
        } catch (Throwable th) {
            MonedataLog.INSTANCE.e("Failed to put object in preferences", th);
            str2 = null;
        }
        SharedPreferences.Editor putString = editor.putString(str, str2);
        Intrinsics.checkNotNullExpressionValue(putString, "putString(key, json)");
        return putString;
    }

    public static final <T> SharedPreferences.Editor a(SharedPreferences.Editor editor, String str, T t, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(editor, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        return a(editor, str, t, (Type) JvmClassMappingKt.getJavaObjectType(kClass));
    }

    public static final Boolean a(SharedPreferences sharedPreferences, String str, boolean z) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        if (sharedPreferences.contains(str)) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, z));
        }
        return null;
    }

    public static final <T> T a(SharedPreferences sharedPreferences, String str, Type type) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(type, "type");
        try {
            Result.Companion companion = Result.Companion;
            String string = sharedPreferences.getString(str, (String) null);
            if (string != null) {
                return r1.a.a(string, type);
            }
            return null;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            T r2 = Result.m2344constructorimpl(ResultKt.createFailure(th));
            if (Result.m2350isFailureimpl(r2)) {
                return null;
            }
            return r2;
        }
    }

    public static final <T> T a(SharedPreferences sharedPreferences, String str, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        return a(sharedPreferences, str, (Type) JvmClassMappingKt.getJavaObjectType(kClass));
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
        a(sharedPreferences, new a(str, invoke));
        return invoke;
    }

    public static final void a(SharedPreferences sharedPreferences, Function1<? super SharedPreferences.Editor, Unit> function1) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "it");
        function1.invoke(edit);
        edit.apply();
    }
}
