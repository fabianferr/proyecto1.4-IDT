package io.monedata;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0007\u001a\u00028\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ9\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f2\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\u000eJ\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¨\u0006\u0012"}, d2 = {"Lio/monedata/r1;", "", "T", "", "json", "Lkotlin/reflect/KClass;", "clazz", "a", "(Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "Ljava/lang/reflect/Type;", "type", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "", "map", "(Ljava/util/Map;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "obj", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class r1 {
    public static final r1 a = new r1();

    private r1() {
    }

    public final <T> T a(String str, Type type) {
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.checkNotNullParameter(type, "type");
        return t0.a().fromJson(str, type);
    }

    public final <T> T a(String str, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        return a(str, (Type) JvmClassMappingKt.getJavaClass(kClass));
    }

    public final <T> T a(Map<?, ?> map, KClass<? extends T> kClass) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        String a2 = a((Object) map, (KClass<?>) Reflection.getOrCreateKotlinClass(Map.class));
        if (a2 != null) {
            return a.a(a2, kClass);
        }
        return null;
    }

    public final String a(Object obj, Type type) {
        if (obj == null) {
            return null;
        }
        Gson a2 = t0.a();
        if (type == null) {
            type = obj.getClass();
        }
        return a2.toJson(obj, type);
    }

    public final String a(Object obj, KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        return a(obj, (Type) JvmClassMappingKt.getJavaObjectType(kClass));
    }
}
