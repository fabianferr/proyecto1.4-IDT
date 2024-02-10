package com.m2catalyst.m2sdk.database.daos;

import com.m2catalyst.m2sdk.database.entities.CounterInt;
import com.m2catalyst.m2sdk.database.entities.CounterLong;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\ba\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J!\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J!\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J#\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J#\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J+\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u0019H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ+\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u001cH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u0019\u0010#\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lcom/m2catalyst/m2sdk/database/daos/CounterDao;", "", "deleteCounterIntEntriesByDate", "", "date", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCounterIntPriorToDate", "deleteCounterLongEntriesByDate", "deleteCounterLongPriorToDate", "getCounterIntNotTransmittedByDate", "", "Lcom/m2catalyst/m2sdk/database/entities/CounterInt;", "getCounterLongsNotTransmittedByDate", "Lcom/m2catalyst/m2sdk/database/entities/CounterLong;", "getDistinctCounterIntUntransmittedDates", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDistinctCounterLongUntransmittedDates", "getIntCounterById", "id", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLongCounterById", "incrementIntCounter", "counterId", "value", "", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementLongCounter", "", "(Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertIntCounter", "counter", "(Lcom/m2catalyst/m2sdk/database/entities/CounterInt;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertLongCounter", "(Lcom/m2catalyst/m2sdk/database/entities/CounterLong;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markCounterIntTransmitted", "markCounterLongTransmitted", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CounterDao.kt */
public interface CounterDao {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CounterDao.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object incrementIntCounter$default(CounterDao counterDao, String str, String str2, int i, Continuation continuation, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    i = 1;
                }
                return counterDao.incrementIntCounter(str, str2, i, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementIntCounter");
        }

        public static /* synthetic */ Object incrementLongCounter$default(CounterDao counterDao, String str, String str2, long j, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    j = 1;
                }
                return counterDao.incrementLongCounter(str, str2, j, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementLongCounter");
        }
    }

    Object deleteCounterIntEntriesByDate(String str, Continuation<? super Unit> continuation);

    Object deleteCounterIntPriorToDate(String str, Continuation<? super Unit> continuation);

    Object deleteCounterLongEntriesByDate(String str, Continuation<? super Unit> continuation);

    Object deleteCounterLongPriorToDate(String str, Continuation<? super Unit> continuation);

    Object getCounterIntNotTransmittedByDate(String str, Continuation<? super List<CounterInt>> continuation);

    Object getCounterLongsNotTransmittedByDate(String str, Continuation<? super List<CounterLong>> continuation);

    Object getDistinctCounterIntUntransmittedDates(Continuation<? super List<String>> continuation);

    Object getDistinctCounterLongUntransmittedDates(Continuation<? super List<String>> continuation);

    Object getIntCounterById(String str, String str2, Continuation<? super CounterInt> continuation);

    Object getLongCounterById(String str, String str2, Continuation<? super CounterLong> continuation);

    Object incrementIntCounter(String str, String str2, int i, Continuation<? super Unit> continuation);

    Object incrementLongCounter(String str, String str2, long j, Continuation<? super Unit> continuation);

    Object insertIntCounter(CounterInt counterInt, Continuation<? super Unit> continuation);

    Object insertLongCounter(CounterLong counterLong, Continuation<? super Unit> continuation);

    Object markCounterIntTransmitted(String str, Continuation<? super Unit> continuation);

    Object markCounterLongTransmitted(String str, Continuation<? super Unit> continuation);
}
