package com.m2catalyst.m2sdk.logger.monitor_stats;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.SystemClock;
import com.facebook.internal.security.CertificateUtil;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.MonitoringStatsV10Message;
import com.m2catalyst.m2sdk.database.daos.CounterDao;
import com.m2catalyst.m2sdk.database.entities.CounterInt;
import com.m2catalyst.m2sdk.database.entities.CounterLong;
import com.m2catalyst.m2sdk.j3;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.n1;
import com.m2catalyst.m2sdk.n3;
import com.m2catalyst.m2sdk.p3;
import com.m2catalyst.m2sdk.r2;
import com.m2catalyst.m2sdk.u4;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 D2\u00020\u0001:\u0001DB\u0017\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\bB\u0010CJ.\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0002J0\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0002J\u001b\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u0018J#\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010 \u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u001f2\b\b\u0002\u0010\u0019\u001a\u00020\u0018J#\u0010!\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001eJ\u0013\u0010\"\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u001d\u0010$\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b$\u0010%J%\u0010'\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001b\u0010)\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b)\u0010%J\u001b\u0010*\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b*\u0010%R\u0014\u0010,\u001a\u00020+8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0017\u0010<\u001a\u00020;8\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010A\u0002\u0004\n\u0002\b\u0019¨\u0006E"}, d2 = {"Lcom/m2catalyst/m2sdk/logger/monitor_stats/MonitorStatsManager;", "", "", "reportDate", "", "Lcom/m2catalyst/m2sdk/database/entities/CounterInt;", "counterInts", "Lcom/m2catalyst/m2sdk/database/entities/CounterLong;", "counterLongs", "Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/ApiRequestMessage;", "createModel", "Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/MonitoringStatsV10Message$Builder;", "builder", "intValues", "longValues", "", "setupBuilders", "", "days", "rotationDelete", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/m2catalyst/m2sdk/logger/monitor_stats/LoggingEvents;", "counter", "value", "", "override", "incrementIntCounter", "Ljava/util/Date;", "date", "getIntCounterValue", "(Lcom/m2catalyst/m2sdk/logger/monitor_stats/LoggingEvents;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "incrementLongCounter", "getLongCounterValue", "createAndSavePackets", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createApiRequestMessage", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "apiRequestMessage", "buildPacketAndMarkTransmitted", "(Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/ApiRequestMessage;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPacketForDate", "clearCountersByDate", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/m2catalyst/m2sdk/database/daos/CounterDao;", "counterDao", "Lcom/m2catalyst/m2sdk/database/daos/CounterDao;", "Lcom/m2catalyst/m2sdk/n1;", "dateProvider", "Lcom/m2catalyst/m2sdk/n1;", "getDateProvider", "()Lcom/m2catalyst/m2sdk/n1;", "setDateProvider", "(Lcom/m2catalyst/m2sdk/n1;)V", "Lcom/m2catalyst/m2sdk/r2;", "m2InternalConfiguration", "Lcom/m2catalyst/m2sdk/r2;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "getMutex", "()Lkotlinx/coroutines/sync/Mutex;", "buildingReport", "Z", "<init>", "(Landroid/content/Context;Lcom/m2catalyst/m2sdk/database/daos/CounterDao;)V", "Companion", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: MonitorStatsManager.kt */
public final class MonitorStatsManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PREFS_NAME = "MonitoringStatsV2";
    public static final String TAG = "MonitoringStats";
    private boolean buildingReport;
    private final Context context;
    /* access modifiers changed from: private */
    public final CounterDao counterDao;
    private n1 dateProvider = new u4();
    private final r2 m2InternalConfiguration = r2.a.a();
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/m2catalyst/m2sdk/logger/monitor_stats/MonitorStatsManager$Companion;", "", "()V", "PREFS_NAME", "", "TAG", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: MonitorStatsManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MonitorStatsManager(Context context2, CounterDao counterDao2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(counterDao2, "counterDao");
        this.context = context2;
        this.counterDao = counterDao2;
    }

    private final ApiRequestMessage createModel(String str, List<CounterInt> list, List<CounterLong> list2) {
        if (this.buildingReport) {
            return null;
        }
        this.buildingReport = true;
        MonitoringStatsV10Message.Builder builder = new MonitoringStatsV10Message.Builder();
        builder.system_clock_up_time = Long.valueOf(SystemClock.uptimeMillis());
        p3.a(builder);
        builder.report_date = str;
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long elapsedRealtime = SystemClock.elapsedRealtime() - (instance.getTimeInMillis() - instance.getTimeInMillis());
        if (elapsedRealtime > 0) {
            builder.system_clock_elapsed_time = Long.valueOf(elapsedRealtime);
        }
        Context context2 = this.context;
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(context2, "context");
        try {
            List<ApplicationInfo> installedApplications = context2.getPackageManager().getInstalledApplications(128);
            Intrinsics.checkNotNullExpressionValue(installedApplications, "pm.getInstalledApplicati…ageManager.GET_META_DATA)");
            int i = 0;
            for (ApplicationInfo applicationInfo : installedApplications) {
                if (applicationInfo.uid >= 10000) {
                    i++;
                }
            }
            builder.count_installed_apps = Integer.valueOf(i);
        } catch (Exception unused) {
        }
        p3.a(builder, context2);
        p3.b(builder, context2);
        builder.is_storage_full = 0;
        setupBuilders(builder, list, list2);
        ApiRequestMessage.Builder a = n3.a(this.m2InternalConfiguration);
        a.monitoring_stats_v10 = builder.build();
        this.buildingReport = false;
        return a.build();
    }

    public static /* synthetic */ void incrementIntCounter$default(MonitorStatsManager monitorStatsManager, LoggingEvents loggingEvents, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        monitorStatsManager.incrementIntCounter(loggingEvents, i, z);
    }

    public static /* synthetic */ void incrementLongCounter$default(MonitorStatsManager monitorStatsManager, LoggingEvents loggingEvents, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 1;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        monitorStatsManager.incrementLongCounter(loggingEvents, j, z);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object rotationDelete(int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$rotationDelete$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$rotationDelete$1 r0 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$rotationDelete$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$rotationDelete$1 r0 = new com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$rotationDelete$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x007a
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r2 = r0.L$0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager r2 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x006a
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r7)
            java.util.Calendar r7 = java.util.Calendar.getInstance()
            int r6 = r6 * -1
            r2 = 5
            r7.add(r2, r6)
            java.util.Date r6 = r7.getTime()
            java.lang.String r7 = "date.time"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            java.lang.String r6 = com.m2catalyst.m2sdk.o1.a((java.util.Date) r6)
            com.m2catalyst.m2sdk.database.daos.CounterDao r7 = r5.counterDao
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r7.deleteCounterLongPriorToDate(r6, r0)
            if (r7 != r1) goto L_0x0069
            return r1
        L_0x0069:
            r2 = r5
        L_0x006a:
            com.m2catalyst.m2sdk.database.daos.CounterDao r7 = r2.counterDao
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r6 = r7.deleteCounterIntPriorToDate(r6, r0)
            if (r6 != r1) goto L_0x007a
            return r1
        L_0x007a:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager.rotationDelete(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void setupBuilders(MonitoringStatsV10Message.Builder builder, List<CounterInt> list, List<CounterLong> list2) {
        List<CounterLong> list3;
        List<CounterInt> list4;
        MonitoringStatsV10Message.Builder builder2 = builder;
        if (list != null) {
            for (CounterInt counterInt : list) {
                try {
                    Field declaredField = MonitoringStatsV10Message.Builder.class.getDeclaredField(StringsKt.replace$default(counterInt.getCounterId(), CertificateUtil.DELIMITER, "_", false, 4, (Object) null));
                    Intrinsics.checkNotNullExpressionValue(declaredField, "MonitoringStatsV10Messag…  )\n                    )");
                    declaredField.set(builder2, Integer.valueOf(counterInt.getCounterValue()));
                } catch (NoSuchFieldException unused) {
                    M2SDKLogger.Companion.logError$default(M2SDKLogger.Companion, "MonitorStatsManager", "Cannot find counter with name " + counterInt.getCounterId() + " while building monitor stats", (Exception) null, false, 12, (Object) null);
                } catch (IllegalAccessException unused2) {
                    M2SDKLogger.Companion.logError$default(M2SDKLogger.Companion, "MonitorStatsManager", "Exception thrown on counter with name " + counterInt.getCounterId() + " while building monitor stats", (Exception) null, false, 12, (Object) null);
                } catch (ClassCastException unused3) {
                    M2SDKLogger.Companion.logError$default(M2SDKLogger.Companion, "MonitorStatsManager", "Class cast exception thrown on counter with name " + counterInt.getCounterId() + " while building monitor stats", (Exception) null, false, 12, (Object) null);
                }
            }
        }
        if (list2 != null) {
            for (CounterLong counterLong : list2) {
                try {
                    Field declaredField2 = MonitoringStatsV10Message.Builder.class.getDeclaredField(StringsKt.replace$default(counterLong.getCounterId(), CertificateUtil.DELIMITER, "_", false, 4, (Object) null));
                    Intrinsics.checkNotNullExpressionValue(declaredField2, "MonitoringStatsV10Messag…  )\n                    )");
                    declaredField2.set(builder2, Long.valueOf(counterLong.getCounterValue()));
                } catch (NoSuchFieldException unused4) {
                    M2SDKLogger.Companion.logError$default(M2SDKLogger.Companion, "MonitorStatsManager", "Cannot find counter with name " + counterLong.getCounterId() + " while building monitor stats", (Exception) null, false, 12, (Object) null);
                } catch (IllegalAccessException unused5) {
                    M2SDKLogger.Companion.logError$default(M2SDKLogger.Companion, "MonitorStatsManager", "Exception thrown on counter with name " + counterLong.getCounterId() + " while building monitor stats", (Exception) null, false, 12, (Object) null);
                } catch (ClassCastException unused6) {
                    M2SDKLogger.Companion.logError$default(M2SDKLogger.Companion, "MonitorStatsManager", "Class cast exception thrown on counter with name " + counterLong.getCounterId() + " while building monitor stats", (Exception) null, false, 12, (Object) null);
                }
            }
        }
        LoggingEvents[] values = LoggingEvents.values();
        ArrayList<LoggingEvents> arrayList = new ArrayList<>(values.length);
        for (LoggingEvents add : values) {
            arrayList.add(add);
        }
        for (LoggingEvents loggingEvents : arrayList) {
            if (list2 == null) {
                list3 = CollectionsKt.emptyList();
            } else {
                list3 = list2;
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (CounterLong counterId : list3) {
                arrayList2.add(counterId.getCounterId());
            }
            if (!arrayList2.contains(loggingEvents.getEventName())) {
                if (list == null) {
                    list4 = CollectionsKt.emptyList();
                } else {
                    list4 = list;
                }
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                for (CounterInt counterId2 : list4) {
                    arrayList3.add(counterId2.getCounterId());
                }
                if (!arrayList3.contains(loggingEvents.getEventName())) {
                    try {
                        Field declaredField3 = MonitoringStatsV10Message.Builder.class.getDeclaredField(StringsKt.replace$default(loggingEvents.getEventName(), CertificateUtil.DELIMITER, "_", false, 4, (Object) null));
                        Intrinsics.checkNotNullExpressionValue(declaredField3, "MonitoringStatsV10Messag…                        )");
                        try {
                            declaredField3.set(builder2, 0);
                        } catch (Exception unused7) {
                            declaredField3.set(builder2, 0L);
                        }
                    } catch (NoSuchFieldException unused8) {
                        M2SDKLogger.Companion.logError$default(M2SDKLogger.Companion, "MonitorStatsManager", "Cannot find counter with name " + loggingEvents.getEventName() + " while building monitor stats", (Exception) null, false, 12, (Object) null);
                    } catch (IllegalAccessException unused9) {
                        M2SDKLogger.Companion.logError$default(M2SDKLogger.Companion, "MonitorStatsManager", "Exception thrown on counter with name " + loggingEvents.getEventName() + " while building monitor stats", (Exception) null, false, 12, (Object) null);
                    } catch (ClassCastException unused10) {
                        M2SDKLogger.Companion.logError$default(M2SDKLogger.Companion, "MonitorStatsManager", "Class cast exception thrown on counter with name " + loggingEvents.getEventName() + " while building monitor stats", (Exception) null, false, 12, (Object) null);
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0094 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object buildPacketAndMarkTransmitted(com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage r8, java.lang.String r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$buildPacketAndMarkTransmitted$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$buildPacketAndMarkTransmitted$1 r0 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$buildPacketAndMarkTransmitted$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$buildPacketAndMarkTransmitted$1 r0 = new com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$buildPacketAndMarkTransmitted$1
            r0.<init>(r7, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0095
        L_0x002c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0034:
            java.lang.Object r8 = r0.L$1
            r9 = r8
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r8 = r0.L$0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager r8 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0085
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r10)
            if (r8 == 0) goto L_0x0095
            com.squareup.wire.ProtoAdapter<com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage> r10 = com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage.ADAPTER
            byte[] r8 = r10.encode(r8)
            android.content.Context r10 = r7.context
            java.lang.String r10 = com.m2catalyst.m2sdk.a2.a(r8, r10, r9)
            if (r10 == 0) goto L_0x0075
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            int r8 = r8.length
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "The Monitor Stats packet was populated, converted into byte array size "
            r5.<init>(r6)
            r5.append(r8)
            java.lang.String r8 = " and saved into file named "
            r5.append(r8)
            r5.append(r10)
            java.lang.String r8 = r5.toString()
            r10 = 0
            java.lang.String[] r10 = new java.lang.String[r10]
            java.lang.String r5 = "NETWORK_LOGS"
            r2.v(r5, r8, r10)
        L_0x0075:
            com.m2catalyst.m2sdk.database.daos.CounterDao r8 = r7.counterDao
            r0.L$0 = r7
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r8 = r8.markCounterIntTransmitted(r9, r0)
            if (r8 != r1) goto L_0x0084
            return r1
        L_0x0084:
            r8 = r7
        L_0x0085:
            com.m2catalyst.m2sdk.database.daos.CounterDao r8 = r8.counterDao
            r10 = 0
            r0.L$0 = r10
            r0.L$1 = r10
            r0.label = r3
            java.lang.Object r8 = r8.markCounterLongTransmitted(r9, r0)
            if (r8 != r1) goto L_0x0095
            return r1
        L_0x0095:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager.buildPacketAndMarkTransmitted(com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0062 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object clearCountersByDate(java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$clearCountersByDate$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$clearCountersByDate$1 r0 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$clearCountersByDate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$clearCountersByDate$1 r0 = new com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$clearCountersByDate$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0063
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r2 = r0.L$0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager r2 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0053
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r7)
            com.m2catalyst.m2sdk.database.daos.CounterDao r7 = r5.counterDao
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r7.deleteCounterIntEntriesByDate(r6, r0)
            if (r7 != r1) goto L_0x0052
            return r1
        L_0x0052:
            r2 = r5
        L_0x0053:
            com.m2catalyst.m2sdk.database.daos.CounterDao r7 = r2.counterDao
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r6 = r7.deleteCounterLongEntriesByDate(r6, r0)
            if (r6 != r1) goto L_0x0063
            return r1
        L_0x0063:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager.clearCountersByDate(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0094 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ff A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createAndSavePackets(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$createAndSavePackets$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$createAndSavePackets$1 r0 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$createAndSavePackets$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$createAndSavePackets$1 r0 = new com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$createAndSavePackets$1
            r0.<init>(r11, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0060
            if (r2 == r6) goto L_0x0054
            if (r2 == r5) goto L_0x0048
            if (r2 == r4) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0100
        L_0x0033:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x003b:
            java.lang.Object r2 = r0.L$1
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r5 = r0.L$0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager r5 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager) r5
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00d7
        L_0x0048:
            java.lang.Object r2 = r0.L$1
            java.util.Set r2 = (java.util.Set) r2
            java.lang.Object r5 = r0.L$0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager r5 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager) r5
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0096
        L_0x0054:
            java.lang.Object r2 = r0.L$1
            java.util.Set r2 = (java.util.Set) r2
            java.lang.Object r7 = r0.L$0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager r7 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager) r7
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x007b
        L_0x0060:
            kotlin.ResultKt.throwOnFailure(r12)
            java.util.LinkedHashSet r12 = new java.util.LinkedHashSet
            r12.<init>()
            com.m2catalyst.m2sdk.database.daos.CounterDao r2 = r11.counterDao
            r0.L$0 = r11
            r0.L$1 = r12
            r0.label = r6
            java.lang.Object r2 = r2.getDistinctCounterIntUntransmittedDates(r0)
            if (r2 != r1) goto L_0x0077
            return r1
        L_0x0077:
            r7 = r11
            r10 = r2
            r2 = r12
            r12 = r10
        L_0x007b:
            java.util.List r12 = (java.util.List) r12
            if (r12 == 0) goto L_0x0086
            boolean r12 = r2.addAll(r12)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)
        L_0x0086:
            com.m2catalyst.m2sdk.database.daos.CounterDao r12 = r7.counterDao
            r0.L$0 = r7
            r0.L$1 = r2
            r0.label = r5
            java.lang.Object r12 = r12.getDistinctCounterLongUntransmittedDates(r0)
            if (r12 != r1) goto L_0x0095
            return r1
        L_0x0095:
            r5 = r7
        L_0x0096:
            java.util.List r12 = (java.util.List) r12
            if (r12 == 0) goto L_0x00a1
            boolean r12 = r2.addAll(r12)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)
        L_0x00a1:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x00aa:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x00d0
            java.lang.Object r7 = r2.next()
            r8 = r7
            java.lang.String r8 = (java.lang.String) r8
            com.m2catalyst.m2sdk.n1 r9 = r5.dateProvider
            java.util.Date r9 = r9.a()
            java.lang.String r9 = com.m2catalyst.m2sdk.o1.a((java.util.Date) r9)
            int r8 = r8.compareTo(r9)
            if (r8 >= 0) goto L_0x00c9
            r8 = 1
            goto L_0x00ca
        L_0x00c9:
            r8 = 0
        L_0x00ca:
            if (r8 == 0) goto L_0x00aa
            r12.add(r7)
            goto L_0x00aa
        L_0x00d0:
            r12.toString()
            java.util.Iterator r2 = r12.iterator()
        L_0x00d7:
            boolean r12 = r2.hasNext()
            if (r12 == 0) goto L_0x00f0
            java.lang.Object r12 = r2.next()
            java.lang.String r12 = (java.lang.String) r12
            r0.L$0 = r5
            r0.L$1 = r2
            r0.label = r4
            java.lang.Object r12 = r5.createPacketForDate(r12, r0)
            if (r12 != r1) goto L_0x00d7
            return r1
        L_0x00f0:
            r12 = 0
            r0.L$0 = r12
            r0.L$1 = r12
            r0.label = r3
            r12 = 15
            java.lang.Object r12 = r5.rotationDelete(r12, r0)
            if (r12 != r1) goto L_0x0100
            return r1
        L_0x0100:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager.createAndSavePackets(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0078 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createApiRequestMessage(java.lang.String r6, kotlin.coroutines.Continuation<? super com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$createApiRequestMessage$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$createApiRequestMessage$1 r0 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$createApiRequestMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$createApiRequestMessage$1 r0 = new com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$createApiRequestMessage$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004c
            if (r2 == r4) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            java.lang.Object r6 = r0.L$2
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r1 = r0.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.L$0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager r0 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x007d
        L_0x0038:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0040:
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r2 = r0.L$0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager r2 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005f
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r7)
            com.m2catalyst.m2sdk.database.daos.CounterDao r7 = r5.counterDao
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r7.getCounterIntNotTransmittedByDate(r6, r0)
            if (r7 != r1) goto L_0x005e
            return r1
        L_0x005e:
            r2 = r5
        L_0x005f:
            java.util.List r7 = (java.util.List) r7
            if (r7 != 0) goto L_0x0068
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x0068:
            com.m2catalyst.m2sdk.database.daos.CounterDao r4 = r2.counterDao
            r0.L$0 = r2
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r0 = r4.getCounterLongsNotTransmittedByDate(r6, r0)
            if (r0 != r1) goto L_0x0079
            return r1
        L_0x0079:
            r1 = r6
            r6 = r7
            r7 = r0
            r0 = r2
        L_0x007d:
            java.util.List r7 = (java.util.List) r7
            if (r7 != 0) goto L_0x0086
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x0086:
            java.util.Objects.toString(r6)
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage r6 = r0.createModel(r1, r6, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager.createApiRequestMessage(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055 A[Catch:{ Exception -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createPacketForDate(java.lang.String r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$createPacketForDate$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$createPacketForDate$1 r0 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$createPacketForDate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$createPacketForDate$1 r0 = new com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$createPacketForDate$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ Exception -> 0x0063 }
            goto L_0x0072
        L_0x002c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0034:
            java.lang.Object r8 = r0.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r2 = r0.L$0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager r2 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager) r2
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ Exception -> 0x0063 }
            goto L_0x0051
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r7     // Catch:{ Exception -> 0x0063 }
            r0.L$1 = r8     // Catch:{ Exception -> 0x0063 }
            r0.label = r4     // Catch:{ Exception -> 0x0063 }
            java.lang.Object r9 = r7.createApiRequestMessage(r8, r0)     // Catch:{ Exception -> 0x0063 }
            if (r9 != r1) goto L_0x0050
            return r1
        L_0x0050:
            r2 = r7
        L_0x0051:
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage r9 = (com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage) r9     // Catch:{ Exception -> 0x0063 }
            if (r9 == 0) goto L_0x0072
            r4 = 0
            r0.L$0 = r4     // Catch:{ Exception -> 0x0063 }
            r0.L$1 = r4     // Catch:{ Exception -> 0x0063 }
            r0.label = r3     // Catch:{ Exception -> 0x0063 }
            java.lang.Object r8 = r2.buildPacketAndMarkTransmitted(r9, r8, r0)     // Catch:{ Exception -> 0x0063 }
            if (r8 != r1) goto L_0x0072
            return r1
        L_0x0063:
            r8 = move-exception
            r3 = r8
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r0 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r1 = "NETWORK_LOGS"
            java.lang.String r2 = "Error writing packet to file"
            r4 = 0
            r5 = 8
            r6 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.logError$default(r0, r1, r2, r3, r4, r5, r6)
        L_0x0072:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager.createPacketForDate(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final n1 getDateProvider() {
        return this.dateProvider;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getIntCounterValue(com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r5, java.util.Date r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$getIntCounterValue$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$getIntCounterValue$1 r0 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$getIntCounterValue$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$getIntCounterValue$1 r0 = new com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$getIntCounterValue$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0047
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            com.m2catalyst.m2sdk.database.daos.CounterDao r7 = r4.counterDao
            java.lang.String r5 = r5.getEventName()
            java.lang.String r6 = com.m2catalyst.m2sdk.o1.a((java.util.Date) r6)
            r0.label = r3
            java.lang.Object r7 = r7.getIntCounterById(r5, r6, r0)
            if (r7 != r1) goto L_0x0047
            return r1
        L_0x0047:
            com.m2catalyst.m2sdk.database.entities.CounterInt r7 = (com.m2catalyst.m2sdk.database.entities.CounterInt) r7
            if (r7 == 0) goto L_0x0050
            int r5 = r7.getCounterValue()
            goto L_0x0051
        L_0x0050:
            r5 = 0
        L_0x0051:
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager.getIntCounterValue(com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents, java.util.Date, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getLongCounterValue(com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r5, java.util.Date r6, kotlin.coroutines.Continuation<? super java.lang.Long> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$getLongCounterValue$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$getLongCounterValue$1 r0 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$getLongCounterValue$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$getLongCounterValue$1 r0 = new com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$getLongCounterValue$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0047
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            com.m2catalyst.m2sdk.database.daos.CounterDao r7 = r4.counterDao
            java.lang.String r5 = r5.getEventName()
            java.lang.String r6 = com.m2catalyst.m2sdk.o1.a((java.util.Date) r6)
            r0.label = r3
            java.lang.Object r7 = r7.getLongCounterById(r5, r6, r0)
            if (r7 != r1) goto L_0x0047
            return r1
        L_0x0047:
            com.m2catalyst.m2sdk.database.entities.CounterLong r7 = (com.m2catalyst.m2sdk.database.entities.CounterLong) r7
            if (r7 == 0) goto L_0x0050
            long r5 = r7.getCounterValue()
            goto L_0x0052
        L_0x0050:
            r5 = 0
        L_0x0052:
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager.getLongCounterValue(com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents, java.util.Date, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Mutex getMutex() {
        return this.mutex;
    }

    public final void incrementIntCounter(LoggingEvents loggingEvents, int i, boolean z) {
        Intrinsics.checkNotNullParameter(loggingEvents, "counter");
        j3.b(new MonitorStatsManager$incrementIntCounter$1(loggingEvents, i, this, z, (Continuation<? super MonitorStatsManager$incrementIntCounter$1>) null));
    }

    public final void incrementLongCounter(LoggingEvents loggingEvents, long j, boolean z) {
        Intrinsics.checkNotNullParameter(loggingEvents, "counter");
        j3.b(new MonitorStatsManager$incrementLongCounter$1(this, loggingEvents, j, z, (Continuation<? super MonitorStatsManager$incrementLongCounter$1>) null));
    }

    public final void setDateProvider(n1 n1Var) {
        Intrinsics.checkNotNullParameter(n1Var, "<set-?>");
        this.dateProvider = n1Var;
    }
}
