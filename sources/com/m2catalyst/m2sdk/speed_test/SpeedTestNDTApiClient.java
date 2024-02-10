package com.m2catalyst.m2sdk.speed_test;

import com.m2catalyst.m2sdk.a4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/m2catalyst/m2sdk/speed_test/SpeedTestNDTApiClient;", "", "Lcom/m2catalyst/m2sdk/business/models/MNSI;", "mnsi", "", "getNDTConfig", "(Lcom/m2catalyst/m2sdk/business/models/MNSI;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "getServers", "Lcom/m2catalyst/m2sdk/a4;", "networkFactory", "Lcom/m2catalyst/m2sdk/a4;", "Lcom/m2catalyst/m2sdk/speed_test/NDTApi;", "ndtApi", "Lcom/m2catalyst/m2sdk/speed_test/NDTApi;", "getNdtApi", "()Lcom/m2catalyst/m2sdk/speed_test/NDTApi;", "<init>", "(Lcom/m2catalyst/m2sdk/a4;)V", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: SpeedTestNDTApiClient.kt */
public final class SpeedTestNDTApiClient {
    private final NDTApi ndtApi;
    private final a4 networkFactory;

    public SpeedTestNDTApiClient(a4 a4Var) {
        Intrinsics.checkNotNullParameter(a4Var, "networkFactory");
        this.networkFactory = a4Var;
        this.ndtApi = a4Var.b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getNDTConfig(com.m2catalyst.m2sdk.business.models.MNSI r8, kotlin.coroutines.Continuation<? super java.lang.String> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.m2catalyst.m2sdk.speed_test.SpeedTestNDTApiClient$getNDTConfig$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.m2catalyst.m2sdk.speed_test.SpeedTestNDTApiClient$getNDTConfig$1 r0 = (com.m2catalyst.m2sdk.speed_test.SpeedTestNDTApiClient$getNDTConfig$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.speed_test.SpeedTestNDTApiClient$getNDTConfig$1 r0 = new com.m2catalyst.m2sdk.speed_test.SpeedTestNDTApiClient$getNDTConfig$1
            r0.<init>(r7, r9)
        L_0x0018:
            r6 = r0
            java.lang.Object r9 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ Exception -> 0x0054 }
            goto L_0x0051
        L_0x002a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r9)
            com.m2catalyst.m2sdk.speed_test.NDTApi r1 = r7.ndtApi     // Catch:{ Exception -> 0x0054 }
            java.lang.Double r9 = r8.getLatitude()     // Catch:{ Exception -> 0x0054 }
            java.lang.Double r3 = r8.getLongitude()     // Catch:{ Exception -> 0x0054 }
            java.lang.Integer r4 = r8.getNetworkMcc()     // Catch:{ Exception -> 0x0054 }
            java.lang.Integer r5 = r8.getNetworkMnc()     // Catch:{ Exception -> 0x0054 }
            r6.label = r2     // Catch:{ Exception -> 0x0054 }
            r2 = r9
            java.lang.Object r9 = r1.getNDTConfig(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0054 }
            if (r9 != r0) goto L_0x0051
            return r0
        L_0x0051:
            com.m2catalyst.m2sdk.speed_test.NDTConfig r9 = (com.m2catalyst.m2sdk.speed_test.NDTConfig) r9     // Catch:{ Exception -> 0x0054 }
            goto L_0x0059
        L_0x0054:
            r8 = move-exception
            r8.toString()
            r9 = 0
        L_0x0059:
            com.google.gson.Gson r8 = new com.google.gson.Gson
            r8.<init>()
            java.lang.String r8 = r8.toJson((java.lang.Object) r9)
            java.lang.String r8 = r8.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.speed_test.SpeedTestNDTApiClient.getNDTConfig(com.m2catalyst.m2sdk.business.models.MNSI, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final NDTApi getNdtApi() {
        return this.ndtApi;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getServers(com.m2catalyst.m2sdk.business.models.MNSI r14, kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.m2catalyst.m2sdk.speed_test.SpeedTestNDTApiClient$getServers$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.m2catalyst.m2sdk.speed_test.SpeedTestNDTApiClient$getServers$1 r0 = (com.m2catalyst.m2sdk.speed_test.SpeedTestNDTApiClient$getServers$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.speed_test.SpeedTestNDTApiClient$getServers$1 r0 = new com.m2catalyst.m2sdk.speed_test.SpeedTestNDTApiClient$getServers$1
            r0.<init>(r13, r15)
        L_0x0018:
            r12 = r0
            java.lang.Object r15 = r12.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0069
        L_0x002a:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r15)
            com.m2catalyst.m2sdk.speed_test.NDTApi r1 = r13.ndtApi
            java.lang.Double r15 = r14.getLatitude()
            java.lang.Double r3 = r14.getLongitude()
            java.lang.Integer r4 = r14.getNetworkMcc()
            java.lang.Integer r5 = r14.getNetworkMnc()
            java.lang.Integer r6 = r14.getLteCi()
            java.lang.Integer r7 = r14.getCid()
            java.lang.Integer r8 = r14.getLac()
            java.lang.Integer r9 = r14.getSystemId()
            java.lang.Integer r10 = r14.getNetworkId()
            java.lang.Integer r11 = r14.getBaseStationId()
            r12.label = r2
            r2 = r15
            java.lang.Object r15 = r1.getNDTServers(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            if (r15 != r0) goto L_0x0069
            return r0
        L_0x0069:
            com.m2catalyst.m2sdk.speed_test.NDTServers r15 = (com.m2catalyst.m2sdk.speed_test.NDTServers) r15
            java.util.List r14 = r15.getServers()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.speed_test.SpeedTestNDTApiClient.getServers(com.m2catalyst.m2sdk.business.models.MNSI, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
