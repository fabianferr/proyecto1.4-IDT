package org.koin.core.module.dsl;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Callbacks;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.StringQualifier;
import org.koin.core.qualifier.TypeQualifier;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\b\u001a \u0010\u0004\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00032\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\u001a\u000e\u0010\b\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0003\u001a\u0019\u0010\t\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0003H\b\u001a\u0016\u0010\t\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\n\u001a\u00020\u000b\u001a6\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001e\u0010\f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0004\u0012\u00020\u00010\rj\b\u0012\u0004\u0012\u0002H\u0002`\u000e\u001aa\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\u00120\u0010j\b\u0012\u0004\u0012\u0002H\u0013`\u0014\"\u0006\b\u0000\u0010\u0013\u0018\u0001*\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00122\u001d\u0010\u0016\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\u0003\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u0017H\bø\u0001\u0000\u001aj\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00120\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0014\"\u0004\b\u0000\u0010\u0002*\u001e\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00120\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u00142\u001d\u0010\u0016\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u0017H\u0004\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0019"}, d2 = {"bind", "", "T", "Lorg/koin/core/definition/BeanDefinition;", "binds", "classes", "", "Lkotlin/reflect/KClass;", "createdAtStart", "named", "name", "", "onClose", "Lkotlin/Function1;", "Lorg/koin/core/definition/OnCloseCallback;", "setupInstance", "Lkotlin/Pair;", "Lorg/koin/core/module/Module;", "Lorg/koin/core/instance/InstanceFactory;", "R", "Lorg/koin/core/module/KoinDefinition;", "factory", "options", "Lkotlin/ExtensionFunctionType;", "withOptions", "koin-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: OptionDSL.kt */
public final class OptionDSLKt {
    public static final <T> Pair<Module, InstanceFactory<T>> withOptions(Pair<Module, ? extends InstanceFactory<T>> pair, Function1<? super BeanDefinition<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        Intrinsics.checkNotNullParameter(function1, "options");
        InstanceFactory instanceFactory = (InstanceFactory) pair.getSecond();
        Module first = pair.getFirst();
        BeanDefinition beanDefinition = ((InstanceFactory) pair.getSecond()).getBeanDefinition();
        Qualifier qualifier = beanDefinition.getQualifier();
        function1.invoke(beanDefinition);
        if (!Intrinsics.areEqual((Object) beanDefinition.getQualifier(), (Object) qualifier)) {
            first.indexPrimaryType(instanceFactory);
        }
        first.indexSecondaryTypes(instanceFactory);
        if (beanDefinition.get_createdAtStart() && (instanceFactory instanceof SingleInstanceFactory)) {
            first.prepareForCreationAtStart((SingleInstanceFactory) instanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R> Pair<Module, InstanceFactory<R>> setupInstance(Module module, InstanceFactory<R> instanceFactory, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(instanceFactory, "factory");
        Intrinsics.checkNotNullParameter(function1, "options");
        BeanDefinition<R> beanDefinition = instanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, instanceFactory);
        function1.invoke(beanDefinition);
        module.indexPrimaryType(instanceFactory);
        module.indexSecondaryTypes(instanceFactory);
        if (beanDefinition.get_createdAtStart() && (instanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) instanceFactory);
        }
        return pair;
    }

    public static final void named(BeanDefinition<?> beanDefinition, String str) {
        Intrinsics.checkNotNullParameter(beanDefinition, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        beanDefinition.setQualifier(new StringQualifier(str));
    }

    public static final /* synthetic */ <T> void named(BeanDefinition<?> beanDefinition) {
        Intrinsics.checkNotNullParameter(beanDefinition, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        beanDefinition.setQualifier(new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class)));
    }

    public static final /* synthetic */ <T> void bind(BeanDefinition<? extends T> beanDefinition) {
        Intrinsics.checkNotNullParameter(beanDefinition, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        beanDefinition.setSecondaryTypes(CollectionsKt.plus(beanDefinition.getSecondaryTypes(), Reflection.getOrCreateKotlinClass(Object.class)));
    }

    public static final void binds(BeanDefinition<?> beanDefinition, List<? extends KClass<?>> list) {
        Intrinsics.checkNotNullParameter(beanDefinition, "<this>");
        Intrinsics.checkNotNullParameter(list, "classes");
        beanDefinition.setSecondaryTypes(CollectionsKt.plus(beanDefinition.getSecondaryTypes(), list));
    }

    public static final void createdAtStart(BeanDefinition<?> beanDefinition) {
        Intrinsics.checkNotNullParameter(beanDefinition, "<this>");
        beanDefinition.set_createdAtStart(true);
    }

    public static final <T> void onClose(BeanDefinition<T> beanDefinition, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(beanDefinition, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onClose");
        beanDefinition.setCallbacks(new Callbacks(function1));
    }
}
