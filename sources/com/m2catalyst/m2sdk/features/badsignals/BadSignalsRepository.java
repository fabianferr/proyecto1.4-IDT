package com.m2catalyst.m2sdk.features.badsignals;

import com.m2catalyst.m2sdk.business.repositories.BaseRepository;
import com.m2catalyst.m2sdk.database.daos.BadSignalsDao;
import com.m2catalyst.m2sdk.database.entities.BadSignal;
import com.m2catalyst.m2sdk.external.DataAvailability;
import com.m2catalyst.m2sdk.external.M2SDK;
import com.m2catalyst.m2sdk.l2;
import com.m2catalyst.m2sdk.w2;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b&\u0010'J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\t\u001a\u00020\b*\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nH\u0017J)\u0010\u0015\u001a\u00020\u00142\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u001a\u001a\u00020\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001f\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010$\u001a\u0004\u0018\u00010#8\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/m2catalyst/m2sdk/features/badsignals/BadSignalsRepository;", "Lcom/m2catalyst/m2sdk/business/repositories/BaseRepository;", "Lcom/m2catalyst/m2sdk/external/DataAvailability$BadSignalAvailability;", "Ljava/util/Date;", "date", "", "getBadSignalsForDate", "(Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "convertDate", "Lcom/m2catalyst/m2sdk/features/badsignals/BadSignalTimeRange;", "timeRange", "getDateFromNow", "time", "getBadSignalCounts", "", "Lcom/m2catalyst/m2sdk/business/models/MNSI;", "signals", "", "noNetworkCount", "", "addBadSignalCount", "(Ljava/util/List;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/m2catalyst/m2sdk/database/entities/BadSignal;", "entries", "addEntries", "Lcom/m2catalyst/m2sdk/database/daos/BadSignalsDao;", "badSignalsDao", "Lcom/m2catalyst/m2sdk/database/daos/BadSignalsDao;", "Ljava/text/SimpleDateFormat;", "sdf", "Ljava/text/SimpleDateFormat;", "getSdf", "()Ljava/text/SimpleDateFormat;", "Lcom/m2catalyst/m2sdk/l2;", "accessComponent", "Lcom/m2catalyst/m2sdk/l2;", "<init>", "(Lcom/m2catalyst/m2sdk/database/daos/BadSignalsDao;)V", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: BadSignalsRepository.kt */
public final class BadSignalsRepository extends BaseRepository implements DataAvailability.BadSignalAvailability {
    private final l2 accessComponent;
    /* access modifiers changed from: private */
    public final BadSignalsDao badSignalsDao;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001e, code lost:
        r2 = r2.getDataAccess();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BadSignalsRepository(com.m2catalyst.m2sdk.database.daos.BadSignalsDao r2) {
        /*
            r1 = this;
            java.lang.String r0 = "badSignalsDao"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r1.<init>()
            r1.badSignalsDao = r2
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r0 = "yyyyMMdd"
            r2.<init>(r0)
            r1.sdf = r2
            com.m2catalyst.m2sdk.r2 r2 = com.m2catalyst.m2sdk.r2.a.a()
            com.m2catalyst.m2sdk.configuration.M2Configuration r2 = r2.c()
            if (r2 == 0) goto L_0x0029
            com.m2catalyst.m2sdk.n2 r2 = r2.getDataAccess()
            if (r2 == 0) goto L_0x0029
            com.m2catalyst.m2sdk.l2 r2 = r2.a()
            goto L_0x002a
        L_0x0029:
            r2 = 0
        L_0x002a:
            r1.accessComponent = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository.<init>(com.m2catalyst.m2sdk.database.daos.BadSignalsDao):void");
    }

    /* access modifiers changed from: private */
    public final String convertDate(Date date) {
        String format = this.sdf.format(date);
        Intrinsics.checkNotNullExpressionValue(format, "sdf.format(this)");
        return format;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0070 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getBadSignalsForDate(java.util.Date r5, kotlin.coroutines.Continuation<? super int[]> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository$getBadSignalsForDate$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository$getBadSignalsForDate$1 r0 = (com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository$getBadSignalsForDate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository$getBadSignalsForDate$1 r0 = new com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository$getBadSignalsForDate$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0043
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            com.m2catalyst.m2sdk.database.daos.BadSignalsDao r6 = r4.badSignalsDao
            java.lang.String r5 = r4.convertDate(r5)
            r0.label = r3
            java.lang.Object r6 = r6.getBadSignalsForDate(r5, r0)
            if (r6 != r1) goto L_0x0043
            return r1
        L_0x0043:
            com.m2catalyst.m2sdk.database.entities.BadSignal r6 = (com.m2catalyst.m2sdk.database.entities.BadSignal) r6
            if (r6 == 0) goto L_0x0070
            r5 = 5
            int[] r5 = new int[r5]
            r5 = {0, 0, 0, 0, 0} // fill-array
            int r0 = r6.getTwoCount()
            r1 = 0
            r5[r1] = r0
            int r0 = r6.getThreeCount()
            r5[r3] = r0
            int r0 = r6.getFourCount()
            r1 = 2
            r5[r1] = r0
            int r0 = r6.getFiveCount()
            r1 = 3
            r5[r1] = r0
            int r6 = r6.getNoNetworkCount()
            r0 = 4
            r5[r0] = r6
            goto L_0x0071
        L_0x0070:
            r5 = 0
        L_0x0071:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository.getBadSignalsForDate(java.util.Date, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final String getDateFromNow(BadSignalTimeRange badSignalTimeRange) {
        Integer days = badSignalTimeRange.getDays();
        if (days != null) {
            int intValue = days.intValue();
            Calendar instance = Calendar.getInstance();
            if (intValue != 0) {
                instance.add(5, intValue);
            }
            Date time = instance.getTime();
            Intrinsics.checkNotNullExpressionValue(time, "today.time");
            String convertDate = convertDate(time);
            return convertDate == null ? "" : convertDate;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0087 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object addBadSignalCount(java.util.List<com.m2catalyst.m2sdk.business.models.MNSI> r6, int r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository$addBadSignalCount$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository$addBadSignalCount$1 r0 = (com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository$addBadSignalCount$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository$addBadSignalCount$1 r0 = new com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository$addBadSignalCount$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0088
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.L$2
            java.util.Date r6 = (java.util.Date) r6
            java.lang.Object r7 = r0.L$1
            int[] r7 = (int[]) r7
            java.lang.Object r2 = r0.L$0
            com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository r2 = (com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0060
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r8)
            int[] r7 = com.m2catalyst.m2sdk.features.badsignals.BadSignalsUtilitiesKt.getBadSignalsByType(r6, r7)
            java.util.Date r6 = new java.util.Date
            r6.<init>()
            r0.L$0 = r5
            r0.L$1 = r7
            r0.L$2 = r6
            r0.label = r4
            java.lang.Object r8 = r5.getBadSignalsForDate(r6, r0)
            if (r8 != r1) goto L_0x005f
            return r1
        L_0x005f:
            r2 = r5
        L_0x0060:
            int[] r8 = (int[]) r8
            com.m2catalyst.m2sdk.database.entities.BadSignal r4 = new com.m2catalyst.m2sdk.database.entities.BadSignal
            r4.<init>()
            r4.updateValues(r7)
            java.lang.String r6 = r2.convertDate(r6)
            r4.setDate(r6)
            if (r8 == 0) goto L_0x0076
            r4.updateValues(r8)
        L_0x0076:
            com.m2catalyst.m2sdk.database.daos.BadSignalsDao r6 = r2.badSignalsDao
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r6 = r6.insertOrUpdateBadSignal(r4, r0)
            if (r6 != r1) goto L_0x0088
            return r1
        L_0x0088:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository.addBadSignalCount(java.util.List, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void addEntries(List<BadSignal> list) {
        Intrinsics.checkNotNullParameter(list, "entries");
        if (M2SDK.INSTANCE.isAccessible(new BadSignalsRepository$addEntries$1(this), this.accessComponent) || getTesting()) {
            Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new BadSignalsRepository$addEntries$2(this, list, (Continuation<? super BadSignalsRepository$addEntries$2>) null), 1, (Object) null);
        }
    }

    @w2
    public int[] getBadSignalCounts(BadSignalTimeRange badSignalTimeRange) {
        Intrinsics.checkNotNullParameter(badSignalTimeRange, "time");
        if (M2SDK.INSTANCE.isAccessible(new BadSignalsRepository$getBadSignalCounts$1(this), this.accessComponent) || getTesting()) {
            return (int[]) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new BadSignalsRepository$getBadSignalCounts$2(this, badSignalTimeRange, (Continuation<? super BadSignalsRepository$getBadSignalCounts$2>) null), 1, (Object) null);
        }
        return new int[]{0, 0, 0, 0, 0};
    }

    public final SimpleDateFormat getSdf() {
        return this.sdf;
    }
}
