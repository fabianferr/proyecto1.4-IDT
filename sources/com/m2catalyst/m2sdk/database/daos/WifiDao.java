package com.m2catalyst.m2sdk.database.daos;

import androidx.sqlite.db.SupportSQLiteQuery;
import com.m2catalyst.m2sdk.database.entities.WifiEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\ba\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J)\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J!\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u0019H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u00032\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010!\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/m2catalyst/m2sdk/database/daos/WifiDao;", "", "addEntries", "", "entries", "", "Lcom/m2catalyst/m2sdk/database/entities/WifiEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addWifiEntry", "", "entry", "(Lcom/m2catalyst/m2sdk/database/entities/WifiEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWifiEntries", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastWifiInfo", "getWifiInfo", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWifiInfoEntries", "startDate", "", "endDate", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWifiInfoWhereClause", "query", "Landroidx/sqlite/db/SupportSQLiteQuery;", "(Landroidx/sqlite/db/SupportSQLiteQuery;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markWifiTransmittedEntries", "ids", "", "updateLastRecordsDataUsage", "dataRx", "dataTx", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: WifiDao.kt */
public interface WifiDao {
    Object addEntries(List<WifiEntity> list, Continuation<Unit> continuation);

    Object addWifiEntry(WifiEntity wifiEntity, Continuation<? super Long> continuation);

    Object deleteWifiEntries(Continuation<? super Unit> continuation);

    Object getLastWifiInfo(Continuation<? super WifiEntity> continuation);

    Object getWifiInfo(long j, Continuation<? super WifiEntity> continuation);

    Object getWifiInfo(Continuation<? super List<WifiEntity>> continuation);

    Object getWifiInfoEntries(String str, String str2, Continuation<? super List<WifiEntity>> continuation);

    Object getWifiInfoWhereClause(SupportSQLiteQuery supportSQLiteQuery, Continuation<? super List<WifiEntity>> continuation);

    Object markWifiTransmittedEntries(List<Integer> list, Continuation<? super Unit> continuation);

    Object updateLastRecordsDataUsage(long j, long j2, Continuation<? super Unit> continuation);
}
