package com.m2catalyst.m2sdk.database.daos;

import androidx.sqlite.db.SupportSQLiteQuery;
import com.m2catalyst.m2sdk.database.entities.BadSignal;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\ba\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/m2catalyst/m2sdk/database/daos/BadSignalsDao;", "", "addEntries", "", "entries", "", "Lcom/m2catalyst/m2sdk/database/entities/BadSignal;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBadSignals", "query", "Landroidx/sqlite/db/SupportSQLiteQuery;", "(Landroidx/sqlite/db/SupportSQLiteQuery;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBadSignalsForDate", "date", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertOrUpdateBadSignal", "entry", "(Lcom/m2catalyst/m2sdk/database/entities/BadSignal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BadSignalsDao.kt */
public interface BadSignalsDao {
    Object addEntries(List<BadSignal> list, Continuation<Unit> continuation);

    Object getBadSignals(SupportSQLiteQuery supportSQLiteQuery, Continuation<? super List<BadSignal>> continuation);

    Object getBadSignalsForDate(String str, Continuation<? super BadSignal> continuation);

    Object insertOrUpdateBadSignal(BadSignal badSignal, Continuation<? super Unit> continuation);
}
