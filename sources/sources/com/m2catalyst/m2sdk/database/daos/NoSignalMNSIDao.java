package com.m2catalyst.m2sdk.database.daos;

import androidx.sqlite.db.SupportSQLiteQuery;
import com.m2catalyst.m2sdk.database.entities.NoSignalMNSIEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0011\u0010\b\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0011\u0010\n\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ!\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0016\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/m2catalyst/m2sdk/database/daos/NoSignalMNSIDao;", "", "addEntries", "", "entries", "", "Lcom/m2catalyst/m2sdk/database/entities/NoSignalMNSIEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearNoSignalTable", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllEntries", "getEntries", "getEntriesWithWhereClause", "query", "Landroidx/sqlite/db/SupportSQLiteQuery;", "(Landroidx/sqlite/db/SupportSQLiteQuery;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertNoSignalEntry", "", "entry", "(Lcom/m2catalyst/m2sdk/database/entities/NoSignalMNSIEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markNoSignalEntriesAsTransmitted", "", "resetNDTTable", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NoSignalMNSIDao.kt */
public interface NoSignalMNSIDao {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NoSignalMNSIDao.kt */
    public static final class DefaultImpls {
        /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0055 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.Object clearNoSignalTable(com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
            /*
                boolean r0 = r6 instanceof com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao$clearNoSignalTable$1
                if (r0 == 0) goto L_0x0013
                r0 = r6
                com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao$clearNoSignalTable$1 r0 = (com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao$clearNoSignalTable$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao$clearNoSignalTable$1 r0 = new com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao$clearNoSignalTable$1
                r0.<init>(r6)
            L_0x0018:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x003c
                if (r2 == r4) goto L_0x0034
                if (r2 != r3) goto L_0x002c
                kotlin.ResultKt.throwOnFailure(r6)
                goto L_0x0056
            L_0x002c:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x0034:
                java.lang.Object r5 = r0.L$0
                com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao r5 = (com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao) r5
                kotlin.ResultKt.throwOnFailure(r6)
                goto L_0x004a
            L_0x003c:
                kotlin.ResultKt.throwOnFailure(r6)
                r0.L$0 = r5
                r0.label = r4
                java.lang.Object r6 = r5.deleteAllEntries(r0)
                if (r6 != r1) goto L_0x004a
                return r1
            L_0x004a:
                r6 = 0
                r0.L$0 = r6
                r0.label = r3
                java.lang.Object r5 = r5.resetNDTTable(r0)
                if (r5 != r1) goto L_0x0056
                return r1
            L_0x0056:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao.DefaultImpls.clearNoSignalTable(com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    Object addEntries(List<NoSignalMNSIEntity> list, Continuation<Unit> continuation);

    Object clearNoSignalTable(Continuation<? super Unit> continuation);

    Object deleteAllEntries(Continuation<? super Unit> continuation);

    Object getEntries(Continuation<? super List<NoSignalMNSIEntity>> continuation);

    Object getEntriesWithWhereClause(SupportSQLiteQuery supportSQLiteQuery, Continuation<? super List<NoSignalMNSIEntity>> continuation);

    Object insertNoSignalEntry(NoSignalMNSIEntity noSignalMNSIEntity, Continuation<? super Long> continuation);

    Object markNoSignalEntriesAsTransmitted(List<Integer> list, Continuation<? super Unit> continuation);

    Object resetNDTTable(Continuation<? super Unit> continuation);
}
