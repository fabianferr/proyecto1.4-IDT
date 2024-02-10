package com.m2catalyst.m2sdk.features.badsignals;

import com.m2catalyst.m2sdk.database.daos.BadSignalsDao;
import com.m2catalyst.m2sdk.database.entities.BadSignal;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository$addEntries$2", f = "BadSignalsRepository.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BadSignalsRepository.kt */
public final class BadSignalsRepository$addEntries$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<BadSignal> $entries;
    int label;
    final /* synthetic */ BadSignalsRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BadSignalsRepository$addEntries$2(BadSignalsRepository badSignalsRepository, List<BadSignal> list, Continuation<? super BadSignalsRepository$addEntries$2> continuation) {
        super(2, continuation);
        this.this$0 = badSignalsRepository;
        this.$entries = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BadSignalsRepository$addEntries$2(this.this$0, this.$entries, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BadSignalsRepository$addEntries$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BadSignalsDao access$getBadSignalsDao$p = this.this$0.badSignalsDao;
            List<BadSignal> list = this.$entries;
            this.label = 1;
            if (access$getBadSignalsDao$p.addEntries(list, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
