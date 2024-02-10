package com.m2catalyst.m2sdk;

import android.content.Context;
import com.m2catalyst.m2sdk.database.daos.CounterDao;
import com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: LoggingModule.kt */
public final class j2 extends Lambda implements Function2<Scope, ParametersHolder, MonitorStatsManager> {
    public static final j2 a = new j2();

    public j2() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return new MonitorStatsManager((Context) scope.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (CounterDao) scope.get(Reflection.getOrCreateKotlinClass(CounterDao.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
    }
}
