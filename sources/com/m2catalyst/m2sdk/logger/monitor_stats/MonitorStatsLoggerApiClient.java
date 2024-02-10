package com.m2catalyst.m2sdk.logger.monitor_stats;

import android.content.Context;
import com.m2catalyst.m2sdk.a2;
import com.m2catalyst.m2sdk.a4;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0013\u0010\u0004\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/m2catalyst/m2sdk/logger/monitor_stats/MonitorStatsLoggerApiClient;", "", "", "deleteMonitoringStatsFilesAfterTwoWeeks", "submitMonitorStats", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/m2catalyst/m2sdk/a4;", "networkFactory", "Lcom/m2catalyst/m2sdk/a4;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/m2catalyst/m2sdk/logger/monitor_stats/MonitorStatsLoggingApis;", "api", "Lcom/m2catalyst/m2sdk/logger/monitor_stats/MonitorStatsLoggingApis;", "<init>", "(Lcom/m2catalyst/m2sdk/a4;Landroid/content/Context;)V", "Companion", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: MonitorStatsLoggerApiClient.kt */
public final class MonitorStatsLoggerApiClient {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String SUBMIT_PROCESS_RESULT = "submit_process_result";
    private final MonitorStatsLoggingApis api;
    private final Context context;
    private final a4 networkFactory;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/m2catalyst/m2sdk/logger/monitor_stats/MonitorStatsLoggerApiClient$Companion;", "", "()V", "SUBMIT_PROCESS_RESULT", "", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: MonitorStatsLoggerApiClient.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MonitorStatsLoggerApiClient(a4 a4Var, Context context2) {
        Intrinsics.checkNotNullParameter(a4Var, "networkFactory");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.networkFactory = a4Var;
        this.context = context2;
        this.api = a4Var.a();
    }

    private final void deleteMonitoringStatsFilesAfterTwoWeeks() {
        a2.a(this.context, MonitorStatsManager.TAG);
    }

    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v3 */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:21|(2:22|23)|26|27|28|(1:30)(14:31|32|33|34|(0)(0)|(0)(0)|44|(0)(0)|48|(0)(0)|(0)|54|56|(1:57)(0))|30) */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0105, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0106, code lost:
        r17 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion;
        r5 = r0.getMessage();
        com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.logError$default(r17, com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.MONITOR_STATS_TAG, "Error Submitting MONITOR STATS: " + r5, (java.lang.Exception) null, false, 12, (java.lang.Object) null);
        r0.printStackTrace();
        r6 = r3;
        r3 = r8;
        r5 = r11;
        r11 = r14;
        r0 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object submitMonitorStats(kotlin.coroutines.Continuation<? super kotlin.Unit> r26) {
        /*
            r25 = this;
            r1 = r25
            r0 = r26
            boolean r2 = r0 instanceof com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLoggerApiClient$submitMonitorStats$1
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLoggerApiClient$submitMonitorStats$1 r2 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLoggerApiClient$submitMonitorStats$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001c
        L_0x0017:
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLoggerApiClient$submitMonitorStats$1 r2 = new com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLoggerApiClient$submitMonitorStats$1
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L_0x0052
            if (r4 != r6) goto L_0x004a
            int r4 = r2.I$3
            int r8 = r2.I$2
            int r9 = r2.I$1
            int r10 = r2.I$0
            java.lang.Object r11 = r2.L$3
            java.io.File r11 = (java.io.File) r11
            java.lang.Object r12 = r2.L$2
            java.io.File[] r12 = (java.io.File[]) r12
            java.lang.Object r13 = r2.L$1
            java.io.File[] r13 = (java.io.File[]) r13
            java.lang.Object r14 = r2.L$0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLoggerApiClient r14 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLoggerApiClient) r14
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0047 }
            goto L_0x00ec
        L_0x0047:
            r0 = move-exception
            goto L_0x00f7
        L_0x004a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r0)
            r25.deleteMonitoringStatsFilesAfterTwoWeeks()
            android.content.Context r0 = r1.context
            java.io.File r0 = r0.getFilesDir()
            java.io.File[] r0 = r0.listFiles()
            if (r0 == 0) goto L_0x019b
            int r4 = r0.length
            r13 = r1
            r8 = r3
            r9 = r4
            r10 = 0
            r11 = 0
            r12 = 0
            r3 = r0
            r4 = r2
            r2 = r3
        L_0x006e:
            if (r10 >= r9) goto L_0x0198
            r14 = r3[r10]
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r0 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r15 = r14.getName()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r5 = "submitMonitorStats - file: "
            r6.<init>(r5)
            r6.append(r15)
            java.lang.String r5 = r6.toString()
            java.lang.String[] r6 = new java.lang.String[r7]
            java.lang.String r15 = "monitor_stats_v2"
            r0.v(r15, r5, r6)
            java.lang.String r0 = r14.getName()
            java.lang.String r5 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            java.lang.String r5 = "MonitoringStats"
            r6 = 2
            r15 = 0
            boolean r0 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r0, (java.lang.CharSequence) r5, (boolean) r7, (int) r6, (java.lang.Object) r15)
            if (r0 == 0) goto L_0x0192
            long r5 = r14.length()
            int r0 = (int) r5
            byte[] r5 = new byte[r0]
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00b9 }
            java.io.FileInputStream r15 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00b9 }
            r15.<init>(r14)     // Catch:{ Exception -> 0x00b9 }
            r6.<init>(r15)     // Catch:{ Exception -> 0x00b9 }
            r6.read(r5, r7, r0)     // Catch:{ Exception -> 0x00b9 }
            r6.close()     // Catch:{ Exception -> 0x00b9 }
            goto L_0x00bd
        L_0x00b9:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00bd:
            int r11 = r11 + 1
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLoggingApis r0 = r13.api     // Catch:{ all -> 0x0105 }
            okhttp3.RequestBody r5 = com.m2catalyst.m2sdk.a2.a((byte[]) r5)     // Catch:{ all -> 0x0105 }
            r4.L$0 = r13     // Catch:{ all -> 0x0105 }
            r4.L$1 = r2     // Catch:{ all -> 0x0105 }
            r4.L$2 = r3     // Catch:{ all -> 0x0105 }
            r4.L$3 = r14     // Catch:{ all -> 0x0105 }
            r4.I$0 = r11     // Catch:{ all -> 0x0105 }
            r4.I$1 = r12     // Catch:{ all -> 0x0105 }
            r4.I$2 = r10     // Catch:{ all -> 0x0105 }
            r4.I$3 = r9     // Catch:{ all -> 0x0105 }
            r6 = 1
            r4.label = r6     // Catch:{ all -> 0x0105 }
            java.lang.Object r0 = r0.submitMonitorStats(r5, r4)     // Catch:{ all -> 0x0105 }
            if (r0 != r8) goto L_0x00df
            return r8
        L_0x00df:
            r24 = r13
            r13 = r2
            r2 = r4
            r4 = r9
            r9 = r12
            r12 = r3
            r3 = r8
            r8 = r10
            r10 = r11
            r11 = r14
            r14 = r24
        L_0x00ec:
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiResponseMessage r0 = (com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiResponseMessage) r0     // Catch:{ all -> 0x0047 }
            r5 = r10
            r6 = r12
            r10 = r8
            r12 = r9
            r9 = r4
            r4 = r2
            r2 = r13
            r13 = r14
            goto L_0x012f
        L_0x00f7:
            r24 = r4
            r4 = r2
            r2 = r13
            r13 = r14
            r14 = r11
            r11 = r10
            r10 = r8
            r8 = r3
            r3 = r12
            r12 = r9
            r9 = r24
            goto L_0x0106
        L_0x0105:
            r0 = move-exception
        L_0x0106:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r17 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r5 = r0.getMessage()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r15 = "Error Submitting MONITOR STATS: "
            r6.<init>(r15)
            r6.append(r5)
            java.lang.String r19 = r6.toString()
            java.lang.String r18 = "monitor_stats_v2"
            r20 = 0
            r21 = 0
            r22 = 12
            r23 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.logError$default(r17, r18, r19, r20, r21, r22, r23)
            r0.printStackTrace()
            r6 = r3
            r3 = r8
            r5 = r11
            r11 = r14
            r0 = 0
        L_0x012f:
            if (r0 == 0) goto L_0x013d
            java.lang.Boolean r8 = r0.success
            r14 = 1
            java.lang.Boolean r15 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r14)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r15)
            goto L_0x013e
        L_0x013d:
            r8 = 0
        L_0x013e:
            if (r8 == 0) goto L_0x0143
            java.lang.String r8 = "SUCCESSFUL"
            goto L_0x014e
        L_0x0143:
            int r8 = r12 + 1
            java.lang.Integer r12 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r12)
            r24 = r12
            r12 = r8
            r8 = r24
        L_0x014e:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r17 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r18 = "monitor_stats_v2"
            if (r0 == 0) goto L_0x0157
            java.lang.String r14 = r0.details
            goto L_0x0158
        L_0x0157:
            r14 = 0
        L_0x0158:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r7 = "Submitting MONITOR STATS was "
            r15.<init>(r7)
            r15.append(r8)
            java.lang.String r7 = " with details: "
            r15.append(r7)
            r15.append(r14)
            java.lang.String r19 = r15.toString()
            r20 = 0
            r21 = 0
            r22 = 12
            r23 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r17, r18, r19, r20, r21, r22, r23)
            if (r0 == 0) goto L_0x0187
            java.lang.Boolean r0 = r0.success
            r7 = 1
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r8)
            goto L_0x0189
        L_0x0187:
            r7 = 1
            r0 = 0
        L_0x0189:
            if (r0 == 0) goto L_0x018e
            r11.delete()
        L_0x018e:
            r8 = r3
            r11 = r5
            r3 = r6
            goto L_0x0193
        L_0x0192:
            r7 = 1
        L_0x0193:
            int r10 = r10 + r7
            r6 = 1
            r7 = 0
            goto L_0x006e
        L_0x0198:
            r0 = r2
            r7 = r11
            goto L_0x019d
        L_0x019b:
            r7 = 0
            r12 = 0
        L_0x019d:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r13 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            int r0 = r0.length
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "submit_process_result with SUCCESS:"
            r2.<init>(r3)
            r2.append(r7)
            java.lang.String r3 = ", ERROR:"
            r2.append(r3)
            r2.append(r12)
            java.lang.String r3 = " from a TOTAL:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r15 = r2.toString()
            java.lang.String r14 = "monitor_stats_v2"
            r16 = 0
            r17 = 0
            r18 = 12
            r19 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r13, r14, r15, r16, r17, r18, r19)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLoggerApiClient.submitMonitorStats(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
