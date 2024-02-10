package com.m2catalyst.m2sdk.database.daos;

import com.m2catalyst.m2sdk.database.daos.NDTDao;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.database.daos.NDTDao$DefaultImpls", f = "NDTDao.kt", i = {0}, l = {54, 55}, m = "clearNDTTable", n = {"$this"}, s = {"L$0"})
/* compiled from: NDTDao.kt */
public final class NDTDao$clearNDTTable$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public NDTDao$clearNDTTable$1(Continuation<? super NDTDao$clearNDTTable$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return NDTDao.DefaultImpls.clearNDTTable((NDTDao) null, this);
    }
}
