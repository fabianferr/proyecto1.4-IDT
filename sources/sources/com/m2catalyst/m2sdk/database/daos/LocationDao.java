package com.m2catalyst.m2sdk.database.daos;

import androidx.sqlite.db.SupportSQLiteQuery;
import com.m2catalyst.m2sdk.database.entities.LocationEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\ba\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0011\u0010\u000e\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0011H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J!\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u0015H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\rJ)\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ!\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0011\u0010 \u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lcom/m2catalyst/m2sdk/database/daos/LocationDao;", "", "addLocationEntry", "", "entry", "Lcom/m2catalyst/m2sdk/database/entities/LocationEntity;", "(Lcom/m2catalyst/m2sdk/database/entities/LocationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addLocations", "", "entries", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearLocationTable", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLocationEntries", "getLocationById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocationWithWHereClause", "query", "Landroidx/sqlite/db/SupportSQLiteQuery;", "(Landroidx/sqlite/db/SupportSQLiteQuery;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocations", "getLocationsBetweenDates", "startDate", "endDate", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markLocationAsTransmitted", "startId", "endId", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetLocationTable", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LocationDao.kt */
public interface LocationDao {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: LocationDao.kt */
    public static final class DefaultImpls {
        /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0055 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.Object clearLocationTable(com.m2catalyst.m2sdk.database.daos.LocationDao r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
            /*
                boolean r0 = r6 instanceof com.m2catalyst.m2sdk.database.daos.LocationDao$clearLocationTable$1
                if (r0 == 0) goto L_0x0013
                r0 = r6
                com.m2catalyst.m2sdk.database.daos.LocationDao$clearLocationTable$1 r0 = (com.m2catalyst.m2sdk.database.daos.LocationDao$clearLocationTable$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                com.m2catalyst.m2sdk.database.daos.LocationDao$clearLocationTable$1 r0 = new com.m2catalyst.m2sdk.database.daos.LocationDao$clearLocationTable$1
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
                com.m2catalyst.m2sdk.database.daos.LocationDao r5 = (com.m2catalyst.m2sdk.database.daos.LocationDao) r5
                kotlin.ResultKt.throwOnFailure(r6)
                goto L_0x004a
            L_0x003c:
                kotlin.ResultKt.throwOnFailure(r6)
                r0.L$0 = r5
                r0.label = r4
                java.lang.Object r6 = r5.deleteLocationEntries(r0)
                if (r6 != r1) goto L_0x004a
                return r1
            L_0x004a:
                r6 = 0
                r0.L$0 = r6
                r0.label = r3
                java.lang.Object r5 = r5.resetLocationTable(r0)
                if (r5 != r1) goto L_0x0056
                return r1
            L_0x0056:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.database.daos.LocationDao.DefaultImpls.clearLocationTable(com.m2catalyst.m2sdk.database.daos.LocationDao, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    Object addLocationEntry(LocationEntity locationEntity, Continuation<? super Long> continuation);

    Object addLocations(List<LocationEntity> list, Continuation<Unit> continuation);

    Object clearLocationTable(Continuation<? super Unit> continuation);

    Object deleteLocationEntries(Continuation<? super Unit> continuation);

    Object getLocationById(int i, Continuation<? super LocationEntity> continuation);

    Object getLocationWithWHereClause(SupportSQLiteQuery supportSQLiteQuery, Continuation<? super List<LocationEntity>> continuation);

    Object getLocations(Continuation<? super List<LocationEntity>> continuation);

    Object getLocationsBetweenDates(long j, long j2, Continuation<? super List<LocationEntity>> continuation);

    Object markLocationAsTransmitted(int i, int i2, Continuation<? super Unit> continuation);

    Object resetLocationTable(Continuation<? super Unit> continuation);
}
