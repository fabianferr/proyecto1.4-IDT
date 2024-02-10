package org.koin.core.instance;

import com.facebook.internal.NativeProtocol;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.annotation.KoinReflectAPI;
import org.koin.core.error.NoBeanDefFoundException;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.core.time.MeasureKt;
import org.koin.ext.KClassExtKt;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a+\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005H\u0002¢\u0006\u0002\u0010\u0006\u001a/\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\f\u001a1\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u0001*\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0012\u001a(\u0010\r\u001a\u0002H\u000e\"\n\b\u0000\u0010\u000e\u0018\u0001*\u00020\u0001*\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u000bH\b¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"createInstance", "", "args", "", "constructor", "Ljava/lang/reflect/Constructor;", "([Ljava/lang/Object;Ljava/lang/reflect/Constructor;)Ljava/lang/Object;", "getArguments", "scope", "Lorg/koin/core/scope/Scope;", "parameters", "Lorg/koin/core/parameter/ParametersHolder;", "(Ljava/lang/reflect/Constructor;Lorg/koin/core/scope/Scope;Lorg/koin/core/parameter/ParametersHolder;)[Ljava/lang/Object;", "newInstance", "T", "kClass", "Lkotlin/reflect/KClass;", "params", "(Lorg/koin/core/scope/Scope;Lkotlin/reflect/KClass;Lorg/koin/core/parameter/ParametersHolder;)Ljava/lang/Object;", "defParams", "(Lorg/koin/core/scope/Scope;Lorg/koin/core/parameter/ParametersHolder;)Ljava/lang/Object;", "koin-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: InstanceBuilder.kt */
public final class InstanceBuilderKt {
    public static /* synthetic */ Object newInstance$default(Scope scope, ParametersHolder parametersHolder, int i, Object obj) {
        if ((i & 1) != 0) {
            parametersHolder = ParametersHolderKt.emptyParametersHolder();
        }
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(parametersHolder, "defParams");
        Intrinsics.reifiedOperationMarker(4, "T");
        return newInstance(scope, Reflection.getOrCreateKotlinClass(Object.class), parametersHolder);
    }

    @KoinReflectAPI
    public static final /* synthetic */ <T> T newInstance(Scope scope, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(parametersHolder, "defParams");
        Intrinsics.reifiedOperationMarker(4, "T");
        return newInstance(scope, Reflection.getOrCreateKotlinClass(Object.class), parametersHolder);
    }

    @KoinReflectAPI
    public static final <T> T newInstance(Scope scope, KClass<T> kClass, ParametersHolder parametersHolder) {
        Object[] objArr;
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(parametersHolder, NativeProtocol.WEB_DIALOG_PARAMS);
        if (scope.getLogger().getLevel() == Level.DEBUG) {
            Logger logger = scope.getLogger();
            logger.debug("|- creating new instance - " + KClassExtKt.getFullName(kClass));
        }
        Constructor[] constructors = JvmClassMappingKt.getJavaClass(kClass).getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "kClass.java.constructors");
        Constructor constructor = (Constructor) ArraysKt.firstOrNull((T[]) (Object[]) constructors);
        if (constructor != null) {
            if (scope.getLogger().getLevel() == Level.DEBUG) {
                Pair measureDurationForResult = MeasureKt.measureDurationForResult(new InstanceBuilderKt$newInstance$args$1(constructor, scope, parametersHolder));
                objArr = (Object[]) measureDurationForResult.component1();
                double doubleValue = ((Number) measureDurationForResult.component2()).doubleValue();
                Logger logger2 = scope.getLogger();
                logger2.debug("|- got arguments in " + doubleValue + " ms");
            } else {
                objArr = getArguments(constructor, scope, parametersHolder);
            }
            if (scope.getLogger().getLevel() != Level.DEBUG) {
                return createInstance(objArr, constructor);
            }
            Pair measureDurationForResult2 = MeasureKt.measureDurationForResult(new InstanceBuilderKt$newInstance$1(objArr, constructor));
            T component1 = measureDurationForResult2.component1();
            double doubleValue2 = ((Number) measureDurationForResult2.component2()).doubleValue();
            Logger logger3 = scope.getLogger();
            logger3.debug("|- created instance in " + doubleValue2 + " ms");
            return component1;
        }
        throw new IllegalStateException(("No constructor found for class '" + KClassExtKt.getFullName(kClass) + '\'').toString());
    }

    /* access modifiers changed from: private */
    public static final Object createInstance(Object[] objArr, Constructor<? extends Object> constructor) {
        Object obj;
        if (objArr.length == 0) {
            obj = constructor.newInstance(new Object[0]);
        } else {
            obj = constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        }
        Intrinsics.checkNotNullExpressionValue(obj, "if (args.isEmpty()) {\n  ….newInstance(*args)\n    }");
        return obj;
    }

    /* access modifiers changed from: private */
    public static final Object[] getArguments(Constructor<?> constructor, Scope scope, ParametersHolder parametersHolder) {
        int length = constructor.getParameterTypes().length;
        if (length == 0) {
            return new Object[0];
        }
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            objArr[i] = Unit.INSTANCE;
        }
        for (int i2 = 0; i2 < length; i2++) {
            Class cls = constructor.getParameterTypes()[i2];
            Intrinsics.checkNotNullExpressionValue(cls, "p");
            KClass kotlinClass = JvmClassMappingKt.getKotlinClass(cls);
            Object orNull = scope.getOrNull(kotlinClass, (Qualifier) null, new InstanceBuilderKt$getArguments$1(parametersHolder));
            if (orNull == null && (orNull = parametersHolder.getOrNull(kotlinClass)) == null) {
                throw new NoBeanDefFoundException("No definition found for class '" + kotlinClass + '\'');
            }
            objArr[i2] = orNull;
        }
        return objArr;
    }
}
