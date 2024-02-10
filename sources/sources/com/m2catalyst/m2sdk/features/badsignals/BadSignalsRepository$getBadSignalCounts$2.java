package com.m2catalyst.m2sdk.features.badsignals;

import androidx.sqlite.db.SimpleSQLiteQuery;
import com.m2catalyst.m2sdk.database.daos.BadSignalsDao;
import com.m2catalyst.m2sdk.database.entities.BadSignal;
import java.util.Date;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository$getBadSignalCounts$2", f = "BadSignalsRepository.kt", i = {0}, l = {52}, m = "invokeSuspend", n = {"results"}, s = {"L$0"})
/* compiled from: BadSignalsRepository.kt */
public final class BadSignalsRepository$getBadSignalCounts$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super int[]>, Object> {
    final /* synthetic */ BadSignalTimeRange $time;
    Object L$0;
    int label;
    final /* synthetic */ BadSignalsRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BadSignalsRepository$getBadSignalCounts$2(BadSignalsRepository badSignalsRepository, BadSignalTimeRange badSignalTimeRange, Continuation<? super BadSignalsRepository$getBadSignalCounts$2> continuation) {
        super(2, continuation);
        this.this$0 = badSignalsRepository;
        this.$time = badSignalTimeRange;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BadSignalsRepository$getBadSignalCounts$2(this.this$0, this.$time, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super int[]> continuation) {
        return ((BadSignalsRepository$getBadSignalCounts$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        int[] iArr;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            int[] iArr2 = {0, 0, 0, 0, 0};
            String access$convertDate = this.this$0.convertDate(new Date());
            String access$getDateFromNow = this.this$0.getDateFromNow(this.$time);
            if (this.$time == BadSignalTimeRange.ALL) {
                str = " date >= '" + access$getDateFromNow + "' and date <= '" + access$convertDate + "'";
            } else {
                str = " date <= '" + access$convertDate + "'";
            }
            String str2 = "SELECT * FROM bad_signals_tbl ";
            if (str.length() > 0) {
                str2 = str2 + str;
            }
            BadSignalsDao access$getBadSignalsDao$p = this.this$0.badSignalsDao;
            SimpleSQLiteQuery simpleSQLiteQuery = new SimpleSQLiteQuery(str2);
            this.L$0 = iArr2;
            this.label = 1;
            Object badSignals = access$getBadSignalsDao$p.getBadSignals(simpleSQLiteQuery, this);
            if (badSignals == coroutine_suspended) {
                return coroutine_suspended;
            }
            iArr = iArr2;
            obj = badSignals;
        } else if (i == 1) {
            iArr = (int[]) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        for (BadSignal badSignal : (List) obj) {
            iArr[0] = badSignal.getTwoCount();
            iArr[1] = badSignal.getThreeCount();
            iArr[2] = badSignal.getFourCount();
            iArr[3] = badSignal.getFiveCount();
            iArr[4] = badSignal.getNoNetworkCount();
        }
        return iArr;
    }
}
