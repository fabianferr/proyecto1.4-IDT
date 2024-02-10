package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.core.setup.M2SDKOpsReceiver;
import com.m2catalyst.m2sdk.core.setup.ZombieInitializationSDKReceiver;
import com.m2catalyst.m2sdk.data_collection.location.LocationSDKReceiver;
import com.m2catalyst.m2sdk.data_collection.wifi.WifiSDKReceiver;
import com.m2catalyst.m2sdk.data_transmission.TransmissionSDKReceiver;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.registry.ScopeRegistry;
import org.koin.dsl.ModuleDSLKt;

/* compiled from: ReceiverModule.kt */
public final class a5 {
    public static final Module a = ModuleDSLKt.module$default(false, a.a, 1, (Object) null);

    /* compiled from: ReceiverModule.kt */
    public static final class a extends Lambda implements Function1<Module, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        public final Object invoke(Object obj) {
            Module module = (Module) obj;
            Intrinsics.checkNotNullParameter(module, "$this$module");
            v4 v4Var = v4.a;
            SingleInstanceFactory a2 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ZombieInitializationSDKReceiver.class), (Qualifier) null, v4Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a2);
            }
            new Pair(module, a2);
            w4 w4Var = w4.a;
            SingleInstanceFactory a3 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TransmissionSDKReceiver.class), (Qualifier) null, w4Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a3);
            }
            new Pair(module, a3);
            x4 x4Var = x4.a;
            SingleInstanceFactory a4 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LocationSDKReceiver.class), (Qualifier) null, x4Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a4);
            }
            new Pair(module, a4);
            y4 y4Var = y4.a;
            SingleInstanceFactory a5 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(WifiSDKReceiver.class), (Qualifier) null, y4Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a5);
            }
            new Pair(module, a5);
            z4 z4Var = z4.a;
            SingleInstanceFactory a6 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(M2SDKOpsReceiver.class), (Qualifier) null, z4Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a6);
            }
            new Pair(module, a6);
            return Unit.INSTANCE;
        }
    }
}
