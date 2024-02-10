package com.m2catalyst.m2sdk;

import android.content.SharedPreferences;
import com.m2catalyst.m2sdk.database.SDKDatabase;
import com.m2catalyst.m2sdk.database.daos.BadSignalsDao;
import com.m2catalyst.m2sdk.database.daos.CounterDao;
import com.m2catalyst.m2sdk.database.daos.CrashDao;
import com.m2catalyst.m2sdk.database.daos.LocationDao;
import com.m2catalyst.m2sdk.database.daos.MNSIDao;
import com.m2catalyst.m2sdk.database.daos.NDTDao;
import com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao;
import com.m2catalyst.m2sdk.database.daos.WifiDao;
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
import org.koin.core.qualifier.QualifierKt;
import org.koin.core.qualifier.StringQualifier;
import org.koin.core.registry.ScopeRegistry;
import org.koin.dsl.ModuleDSLKt;

/* compiled from: DataModules.kt */
public final class l1 {
    public static final Module a = ModuleDSLKt.module$default(false, a.a, 1, (Object) null);
    public static final Module b = ModuleDSLKt.module$default(false, b.a, 1, (Object) null);

    /* compiled from: DataModules.kt */
    public static final class a extends Lambda implements Function1<Module, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        public final Object invoke(Object obj) {
            Module module = (Module) obj;
            Intrinsics.checkNotNullParameter(module, "$this$module");
            b1 b1Var = new b1(new k1());
            SingleInstanceFactory a2 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SDKDatabase.class), (Qualifier) null, b1Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a2);
            }
            new Pair(module, a2);
            c1 c1Var = c1.a;
            SingleInstanceFactory a3 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CounterDao.class), (Qualifier) null, c1Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a3);
            }
            new Pair(module, a3);
            d1 d1Var = d1.a;
            SingleInstanceFactory a4 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LocationDao.class), (Qualifier) null, d1Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a4);
            }
            new Pair(module, a4);
            e1 e1Var = e1.a;
            SingleInstanceFactory a5 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(WifiDao.class), (Qualifier) null, e1Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a5);
            }
            new Pair(module, a5);
            f1 f1Var = f1.a;
            SingleInstanceFactory a6 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MNSIDao.class), (Qualifier) null, f1Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a6);
            }
            new Pair(module, a6);
            g1 g1Var = g1.a;
            SingleInstanceFactory a7 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(NDTDao.class), (Qualifier) null, g1Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a7);
            }
            new Pair(module, a7);
            h1 h1Var = h1.a;
            SingleInstanceFactory a8 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(NoSignalMNSIDao.class), (Qualifier) null, h1Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a8);
            }
            new Pair(module, a8);
            i1 i1Var = i1.a;
            SingleInstanceFactory a9 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(BadSignalsDao.class), (Qualifier) null, i1Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a9);
            }
            new Pair(module, a9);
            j1 j1Var = j1.a;
            SingleInstanceFactory a10 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CrashDao.class), (Qualifier) null, j1Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a10);
            }
            new Pair(module, a10);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: DataModules.kt */
    public static final class b extends Lambda implements Function1<Module, Unit> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        public final Object invoke(Object obj) {
            Module module = (Module) obj;
            Intrinsics.checkNotNullParameter(module, "$this$module");
            StringQualifier named = QualifierKt.named("sdk_preferences");
            m1 m1Var = m1.a;
            SingleInstanceFactory a2 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SharedPreferences.class), named, m1Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a2);
            }
            new Pair(module, a2);
            return Unit.INSTANCE;
        }
    }
}
