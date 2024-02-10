package com.m2catalyst.m2sdk.logger;

import com.m2catalyst.m2sdk.business.repositories.CrashRepository;
import com.m2catalyst.m2sdk.database.entities.CrashEntity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/m2catalyst/m2sdk/logger/CrashCollector;", "Lorg/koin/core/component/KoinComponent;", "()V", "crashRepository", "Lcom/m2catalyst/m2sdk/business/repositories/CrashRepository;", "getCrashRepository", "()Lcom/m2catalyst/m2sdk/business/repositories/CrashRepository;", "crashRepository$delegate", "Lkotlin/Lazy;", "saveCrashRecord", "", "time", "", "stackTrace", "", "(Ljava/lang/Long;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CrashCollector.kt */
public final class CrashCollector implements KoinComponent {
    private final Lazy crashRepository$delegate = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new CrashCollector$special$$inlined$inject$default$1(this, (Qualifier) null, (Function0) null));

    private final CrashRepository getCrashRepository() {
        return (CrashRepository) this.crashRepository$delegate.getValue();
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final Object saveCrashRecord(Long l, String str, Continuation<? super Unit> continuation) {
        CrashRepository crashRepository = getCrashRepository();
        CrashEntity crashEntity = new CrashEntity();
        crashEntity.setTime_stamp(l);
        crashEntity.setStack_trace(str);
        Object addCrashEntry = crashRepository.addCrashEntry(crashEntity, continuation);
        return addCrashEntry == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? addCrashEntry : Unit.INSTANCE;
    }
}
