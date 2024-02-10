package org.koin.androidx.workmanager.koin;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.DelegatingWorkerFactory;
import androidx.work.WorkManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.androidx.workmanager.factory.KoinWorkerFactory;
import org.koin.core.KoinApplication;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0004"}, d2 = {"createWorkManagerFactory", "", "Lorg/koin/core/KoinApplication;", "workManagerFactory", "koin-androidx-workmanager_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: KoinApplicationExt.kt */
public final class KoinApplicationExtKt {
    public static final void workManagerFactory(KoinApplication koinApplication) {
        Intrinsics.checkNotNullParameter(koinApplication, "<this>");
        createWorkManagerFactory(koinApplication);
    }

    private static final void createWorkManagerFactory(KoinApplication koinApplication) {
        DelegatingWorkerFactory delegatingWorkerFactory = new DelegatingWorkerFactory();
        delegatingWorkerFactory.addFactory(new KoinWorkerFactory());
        Configuration build = new Configuration.Builder().setWorkerFactory(delegatingWorkerFactory).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n        .setWo…factory)\n        .build()");
        WorkManager.initialize((Context) koinApplication.getKoin().getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), build);
    }
}
