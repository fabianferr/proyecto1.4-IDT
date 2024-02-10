package com.m2catalyst.m2sdk.database.daos;

import com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao$DefaultImpls", f = "NoSignalMNSIDao.kt", i = {0}, l = {34, 35}, m = "clearNoSignalTable", n = {"$this"}, s = {"L$0"})
/* compiled from: NoSignalMNSIDao.kt */
public final class NoSignalMNSIDao$clearNoSignalTable$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public NoSignalMNSIDao$clearNoSignalTable$1(Continuation<? super NoSignalMNSIDao$clearNoSignalTable$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return NoSignalMNSIDao.DefaultImpls.clearNoSignalTable((NoSignalMNSIDao) null, this);
    }
}
