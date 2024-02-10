package com.m2catalyst.m2sdk.logger.monitor_stats;

import com.m2catalyst.m2sdk.y1;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;", "org/koin/core/component/KoinComponentKt$inject$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: KoinComponent.kt */
public final class MonitorStatsLogger$special$$inlined$inject$default$2 extends Lambda implements Function0<MonitorStatsManager> {
    final /* synthetic */ Function0 $parameters;
    final /* synthetic */ Qualifier $qualifier;
    final /* synthetic */ KoinComponent $this_inject;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MonitorStatsLogger$special$$inlined$inject$default$2(KoinComponent koinComponent, Qualifier qualifier, Function0 function0) {
        super(0);
        this.$this_inject = koinComponent;
        this.$qualifier = qualifier;
        this.$parameters = function0;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager, java.lang.Object] */
    public final MonitorStatsManager invoke() {
        KoinComponent koinComponent = this.$this_inject;
        Qualifier qualifier = this.$qualifier;
        Function0 function0 = this.$parameters;
        if (koinComponent instanceof KoinScopeComponent) {
            return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(MonitorStatsManager.class), qualifier, function0);
        }
        return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(MonitorStatsManager.class), qualifier, function0);
    }
}
