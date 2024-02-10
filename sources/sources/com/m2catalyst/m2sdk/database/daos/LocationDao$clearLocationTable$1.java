package com.m2catalyst.m2sdk.database.daos;

import com.m2catalyst.m2sdk.database.daos.LocationDao;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.database.daos.LocationDao$DefaultImpls", f = "LocationDao.kt", i = {0}, l = {40, 41}, m = "clearLocationTable", n = {"$this"}, s = {"L$0"})
/* compiled from: LocationDao.kt */
public final class LocationDao$clearLocationTable$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public LocationDao$clearLocationTable$1(Continuation<? super LocationDao$clearLocationTable$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return LocationDao.DefaultImpls.clearLocationTable((LocationDao) null, this);
    }
}
