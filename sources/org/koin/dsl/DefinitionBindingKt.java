package org.koin.dsl;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.definition.Callbacks;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.module.Module;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001aY\u0010\u0000\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00040\u00030\u0001j\n\u0012\u0006\b\u0001\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006*\"\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00040\u00030\u0001j\n\u0012\u0006\b\u0001\u0012\u0002H\u0004`\u0005H\b\u001ae\u0010\u0000\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00040\u00030\u0001j\n\u0012\u0006\b\u0001\u0012\u0002H\u0004`\u0005\"\b\b\u0000\u0010\u0004*\u00020\u0006*\"\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00040\u00030\u0001j\n\u0012\u0006\b\u0001\u0012\u0002H\u0004`\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\bH\u0004\u001aT\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001j\u0006\u0012\u0002\b\u0003`\u0005*\u001a\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001j\u0006\u0012\u0002\b\u0003`\u00052\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u000bH\u0004¢\u0006\u0002\u0010\f\u001aa\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u00030\u0001\"\u0004\b\u0000\u0010\u000e*\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u000e`\u00052\u001e\u0010\r\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u0001H\u000e\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u0002H\u000e`\u0011H\u0004¨\u0006\u0012"}, d2 = {"bind", "Lkotlin/Pair;", "Lorg/koin/core/module/Module;", "Lorg/koin/core/instance/InstanceFactory;", "S", "Lorg/koin/core/module/KoinDefinition;", "", "clazz", "Lkotlin/reflect/KClass;", "binds", "classes", "", "(Lkotlin/Pair;[Lkotlin/reflect/KClass;)Lkotlin/Pair;", "onClose", "T", "Lkotlin/Function1;", "", "Lorg/koin/core/definition/OnCloseCallback;", "koin-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefinitionBinding.kt */
public final class DefinitionBindingKt {
    public static final <S> Pair<Module, InstanceFactory<? extends S>> bind(Pair<Module, ? extends InstanceFactory<? extends S>> pair, KClass<S> kClass) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        ((InstanceFactory) pair.getSecond()).getBeanDefinition().setSecondaryTypes(CollectionsKt.plus(((InstanceFactory) pair.getSecond()).getBeanDefinition().getSecondaryTypes(), kClass));
        pair.getFirst().saveMapping(BeanDefinitionKt.indexKey(kClass, ((InstanceFactory) pair.getSecond()).getBeanDefinition().getQualifier(), ((InstanceFactory) pair.getSecond()).getBeanDefinition().getScopeQualifier()), (InstanceFactory) pair.getSecond(), true);
        return pair;
    }

    public static final /* synthetic */ <S> Pair<Module, InstanceFactory<? extends S>> bind(Pair<Module, ? extends InstanceFactory<? extends S>> pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.LATITUDE_SOUTH);
        bind(pair, Reflection.getOrCreateKotlinClass(Object.class));
        return pair;
    }

    public static final Pair<Module, InstanceFactory<?>> binds(Pair<Module, ? extends InstanceFactory<?>> pair, KClass<?>[] kClassArr) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        Intrinsics.checkNotNullParameter(kClassArr, "classes");
        BeanDefinition beanDefinition = ((InstanceFactory) pair.getSecond()).getBeanDefinition();
        beanDefinition.setSecondaryTypes(CollectionsKt.plus(beanDefinition.getSecondaryTypes(), (T[]) kClassArr));
        for (KClass<?> indexKey : kClassArr) {
            pair.getFirst().saveMapping(BeanDefinitionKt.indexKey(indexKey, ((InstanceFactory) pair.getSecond()).getBeanDefinition().getQualifier(), ((InstanceFactory) pair.getSecond()).getBeanDefinition().getScopeQualifier()), (InstanceFactory) pair.getSecond(), true);
        }
        return pair;
    }

    public static final <T> Pair<Module, InstanceFactory<T>> onClose(Pair<Module, ? extends InstanceFactory<T>> pair, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onClose");
        ((InstanceFactory) pair.getSecond()).getBeanDefinition().setCallbacks(new Callbacks(function1));
        return pair;
    }
}
