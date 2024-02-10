package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.MNSI;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/m2catalyst/m2sdk/business/models/MNSI;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIRecordsInBoundries$2", f = "MNSIRepository.kt", i = {}, l = {536, 537}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MNSIRepository.kt */
public final class MNSIRepository$getMNSIRecordsInBoundries$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends MNSI>>, Object> {
    final /* synthetic */ Long $endTime;
    final /* synthetic */ Integer $limit;
    final /* synthetic */ double $lowerRightLat;
    final /* synthetic */ double $lowerRightLong;
    final /* synthetic */ String $networkType;
    final /* synthetic */ Long $startTime;
    final /* synthetic */ double $upperLeftLat;
    final /* synthetic */ double $upperLeftLong;
    int label;
    final /* synthetic */ MNSIRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MNSIRepository$getMNSIRecordsInBoundries$2(double d, double d2, double d3, double d4, Long l, Long l2, String str, MNSIRepository mNSIRepository, Integer num, Continuation<? super MNSIRepository$getMNSIRecordsInBoundries$2> continuation) {
        super(2, continuation);
        this.$upperLeftLong = d;
        this.$lowerRightLong = d2;
        this.$upperLeftLat = d3;
        this.$lowerRightLat = d4;
        this.$startTime = l;
        this.$endTime = l2;
        this.$networkType = str;
        this.this$0 = mNSIRepository;
        this.$limit = num;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MNSIRepository$getMNSIRecordsInBoundries$2(this.$upperLeftLong, this.$lowerRightLong, this.$upperLeftLat, this.$lowerRightLat, this.$startTime, this.$endTime, this.$networkType, this.this$0, this.$limit, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends MNSI>> continuation) {
        return ((MNSIRepository$getMNSIRecordsInBoundries$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x014b A[LOOP:0: B:58:0x0145->B:60:0x014b, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            java.lang.String r1 = ""
            java.lang.String r2 = "longitude > "
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r0.label
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x002a
            if (r4 == r6) goto L_0x0023
            if (r4 != r5) goto L_0x001b
            kotlin.ResultKt.throwOnFailure(r17)
            r1 = r17
            goto L_0x012e
        L_0x001b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r17)
            r1 = r17
            goto L_0x011c
        L_0x002a:
            kotlin.ResultKt.throwOnFailure(r17)
            double r7 = r0.$upperLeftLong     // Catch:{ Exception -> 0x005a }
            double r9 = r0.$lowerRightLong     // Catch:{ Exception -> 0x005a }
            double r11 = r0.$upperLeftLat     // Catch:{ Exception -> 0x005a }
            double r13 = r0.$lowerRightLat     // Catch:{ Exception -> 0x005a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005a }
            r4.<init>(r2)     // Catch:{ Exception -> 0x005a }
            r4.append(r7)     // Catch:{ Exception -> 0x005a }
            java.lang.String r2 = " AND longitude < "
            r4.append(r2)     // Catch:{ Exception -> 0x005a }
            r4.append(r9)     // Catch:{ Exception -> 0x005a }
            java.lang.String r2 = " AND latitude < "
            r4.append(r2)     // Catch:{ Exception -> 0x005a }
            r4.append(r11)     // Catch:{ Exception -> 0x005a }
            java.lang.String r2 = " AND latitude > "
            r4.append(r2)     // Catch:{ Exception -> 0x005a }
            r4.append(r13)     // Catch:{ Exception -> 0x005a }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x005a }
            goto L_0x005c
        L_0x005a:
            r2 = r1
        L_0x005c:
            java.lang.Long r4 = r0.$startTime
            r7 = 0
            if (r4 == 0) goto L_0x0066
            java.lang.String r4 = r4.toString()
            goto L_0x0067
        L_0x0066:
            r4 = r7
        L_0x0067:
            java.lang.String r8 = "timeStamp >="
            java.lang.String r2 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r2, (java.lang.String) r8, (java.lang.String) r4)
            java.lang.Long r4 = r0.$endTime
            if (r4 == 0) goto L_0x007f
            long r7 = r4.longValue()
            int r4 = (int) r7
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.String r7 = r4.toString()
        L_0x007f:
            java.lang.String r4 = "timeStamp ="
            java.lang.String r2 = com.m2catalyst.m2sdk.c6.a((java.lang.String) r2, (java.lang.String) r4, (java.lang.String) r7)
            java.lang.String r4 = r0.$networkType
            r7 = 0
            if (r4 == 0) goto L_0x0094
            int r4 = r4.length()
            if (r4 != 0) goto L_0x0092
            goto L_0x0094
        L_0x0092:
            r4 = 0
            goto L_0x0095
        L_0x0094:
            r4 = 1
        L_0x0095:
            if (r4 != 0) goto L_0x009f
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r1 = r0.this$0
            java.lang.String r4 = r0.$networkType
            java.lang.String r1 = r1.getNetworkType(r4)
        L_0x009f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            java.lang.Integer r2 = r0.$limit
            if (r2 == 0) goto L_0x00ba
            int r2 = r2.intValue()
            if (r2 <= 0) goto L_0x00ba
            r2 = 1
            goto L_0x00bb
        L_0x00ba:
            r2 = 0
        L_0x00bb:
            int r4 = r1.length()
            if (r4 <= 0) goto L_0x00c3
            r4 = 1
            goto L_0x00c4
        L_0x00c3:
            r4 = 0
        L_0x00c4:
            if (r4 != 0) goto L_0x00c8
            if (r2 == 0) goto L_0x00d9
        L_0x00c8:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r1 = " ORDER BY id ASC"
            r4.append(r1)
            java.lang.String r1 = r4.toString()
        L_0x00d9:
            if (r2 == 0) goto L_0x00f1
            java.lang.Integer r2 = r0.$limit
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r1 = " LIMIT "
            r4.append(r1)
            r4.append(r2)
            java.lang.String r1 = r4.toString()
        L_0x00f1:
            int r2 = r1.length()
            if (r2 <= 0) goto L_0x00f8
            r7 = 1
        L_0x00f8:
            if (r7 == 0) goto L_0x011f
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r2 = r0.this$0
            com.m2catalyst.m2sdk.database.daos.MNSIDao r2 = r2.mnsiDao
            androidx.sqlite.db.SimpleSQLiteQuery r4 = new androidx.sqlite.db.SimpleSQLiteQuery
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "SELECT * FROM mnsi_tbl WHERE "
            r5.<init>(r7)
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            r4.<init>(r1)
            r0.label = r6
            java.lang.Object r1 = r2.getMNSIWithWhereClause(r4, r0)
            if (r1 != r3) goto L_0x011c
            return r3
        L_0x011c:
            java.util.List r1 = (java.util.List) r1
            goto L_0x0130
        L_0x011f:
            com.m2catalyst.m2sdk.business.repositories.MNSIRepository r1 = r0.this$0
            com.m2catalyst.m2sdk.database.daos.MNSIDao r1 = r1.mnsiDao
            r0.label = r5
            java.lang.Object r1 = r1.getMNSI(r0)
            if (r1 != r3) goto L_0x012e
            return r3
        L_0x012e:
            java.util.List r1 = (java.util.List) r1
        L_0x0130:
            if (r1 != 0) goto L_0x0136
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0136:
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r3)
            r2.<init>(r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x0145:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x015a
            java.lang.Object r3 = r1.next()
            com.m2catalyst.m2sdk.database.entities.MNSIEntity r3 = (com.m2catalyst.m2sdk.database.entities.MNSIEntity) r3
            com.m2catalyst.m2sdk.business.models.MNSI r4 = new com.m2catalyst.m2sdk.business.models.MNSI
            r4.<init>(r3)
            r2.add(r4)
            goto L_0x0145
        L_0x015a:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r5 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            double r3 = r0.$upperLeftLat
            double r6 = r0.$upperLeftLong
            double r8 = r0.$lowerRightLat
            double r10 = r0.$lowerRightLong
            java.lang.Long r1 = r0.$startTime
            java.lang.Long r12 = r0.$endTime
            java.lang.String r13 = r0.$networkType
            java.lang.Integer r14 = r0.$limit
            int r15 = r2.size()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r17 = r2
            java.lang.String r2 = "MNS Query for upperLeftLat="
            r0.<init>(r2)
            r0.append(r3)
            java.lang.String r2 = ", upperLeftLong="
            r0.append(r2)
            r0.append(r6)
            java.lang.String r2 = ", lowerRightLat="
            r0.append(r2)
            r0.append(r8)
            java.lang.String r2 = ", lowerRightLong="
            r0.append(r2)
            r0.append(r10)
            java.lang.String r2 = ", startTime="
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = ", endTime="
            r0.append(r1)
            r0.append(r12)
            java.lang.String r1 = ", networkType="
            r0.append(r1)
            r0.append(r13)
            java.lang.String r1 = ", limit="
            r0.append(r1)
            r0.append(r14)
            java.lang.String r1 = " returned "
            r0.append(r1)
            r0.append(r15)
            java.lang.String r1 = " entries"
            r0.append(r1)
            java.lang.String r7 = r0.toString()
            java.lang.String r6 = "NETWORK_LOGS"
            r8 = 0
            r9 = 0
            r10 = 12
            r11 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r5, r6, r7, r8, r9, r10, r11)
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIRecordsInBoundries$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
