package com.m2catalyst.m2sdk.database.daos;

import com.m2catalyst.m2sdk.database.daos.MNSIDao;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.database.daos.MNSIDao$DefaultImpls", f = "MNSIDao.kt", i = {0}, l = {57, 58}, m = "clearMNSITable", n = {"$this"}, s = {"L$0"})
/* compiled from: MNSIDao.kt */
public final class MNSIDao$clearMNSITable$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public MNSIDao$clearMNSITable$1(Continuation<? super MNSIDao$clearMNSITable$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MNSIDao.DefaultImpls.clearMNSITable((MNSIDao) null, this);
    }
}
