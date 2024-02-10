package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.database.daos.CrashDao;
import com.m2catalyst.m2sdk.database.entities.CrashEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/m2catalyst/m2sdk/business/repositories/CrashRepository;", "Lcom/m2catalyst/m2sdk/business/repositories/BaseRepository;", "crashDao", "Lcom/m2catalyst/m2sdk/database/daos/CrashDao;", "(Lcom/m2catalyst/m2sdk/database/daos/CrashDao;)V", "addCrashEntry", "", "entry", "Lcom/m2catalyst/m2sdk/database/entities/CrashEntity;", "(Lcom/m2catalyst/m2sdk/database/entities/CrashEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CrashRepository.kt */
public final class CrashRepository extends BaseRepository {
    private final CrashDao crashDao;

    public CrashRepository(CrashDao crashDao2) {
        Intrinsics.checkNotNullParameter(crashDao2, "crashDao");
        this.crashDao = crashDao2;
    }

    public final Object addCrashEntry(CrashEntity crashEntity, Continuation<? super Unit> continuation) {
        Object insertCrash = this.crashDao.insertCrash(crashEntity, continuation);
        return insertCrash == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? insertCrash : Unit.INSTANCE;
    }
}
