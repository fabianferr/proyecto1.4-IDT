package org.koin.android.ext.koin;

import android.app.Application;
import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.DefinitionBindingKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lorg/koin/core/module/Module;", "invoke"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: KoinExt.kt */
final class KoinExtKt$androidContext$1 extends Lambda implements Function1<Module, Unit> {
    final /* synthetic */ Context $androidContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KoinExtKt$androidContext$1(Context context) {
        super(1);
        this.$androidContext = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Module) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Module module) {
        Intrinsics.checkNotNullParameter(module, "$this$module");
        final Context context = this.$androidContext;
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Application.class), (Qualifier) null, new Function2<Scope, ParametersHolder, Application>() {
            public final Application invoke(Scope scope, ParametersHolder parametersHolder) {
                Intrinsics.checkNotNullParameter(scope, "$this$single");
                Intrinsics.checkNotNullParameter(parametersHolder, "it");
                return (Application) context;
            }
        }, kind, emptyList));
        module.indexPrimaryType(singleInstanceFactory);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        DefinitionBindingKt.binds(new Pair(module, singleInstanceFactory), new KClass[]{Reflection.getOrCreateKotlinClass(Context.class), Reflection.getOrCreateKotlinClass(Application.class)});
    }
}
