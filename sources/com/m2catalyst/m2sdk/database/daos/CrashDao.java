package com.m2catalyst.m2sdk.database.daos;

import com.m2catalyst.m2sdk.database.entities.CrashEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lcom/m2catalyst/m2sdk/database/daos/CrashDao;", "", "insertCrash", "", "entry", "Lcom/m2catalyst/m2sdk/database/entities/CrashEntity;", "(Lcom/m2catalyst/m2sdk/database/entities/CrashEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CrashDao.kt */
public interface CrashDao {
    Object insertCrash(CrashEntity crashEntity, Continuation<? super Unit> continuation);
}
