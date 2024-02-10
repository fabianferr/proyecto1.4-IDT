package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.business.repositories.ApiKeyRepository;
import com.m2catalyst.m2sdk.business.repositories.DeviceRepository;
import com.m2catalyst.m2sdk.r2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

/* compiled from: IngestionManager.kt */
public final class x1 implements KoinComponent {
    public final Lazy a = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new b(this));
    public final Lazy b = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new c(this));
    public final r2 c = r2.a.a();

    @DebugMetadata(c = "com.m2catalyst.m2sdk.business.IngestionManager", f = "IngestionManager.kt", i = {0, 1, 1, 1}, l = {20, 27}, m = "initializeIngestion", n = {"this", "this", "alreadySynced", "apiKeyVerified"}, s = {"L$0", "L$0", "L$1", "Z$0"})
    /* compiled from: IngestionManager.kt */
    public static final class a extends ContinuationImpl {
        public x1 a;
        public Ref.BooleanRef b;
        public boolean c;
        public /* synthetic */ Object d;
        public final /* synthetic */ x1 e;
        public int f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(x1 x1Var, Continuation<? super a> continuation) {
            super(continuation);
            this.e = x1Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return this.e.a(this);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class b extends Lambda implements Function0<ApiKeyRepository> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object, com.m2catalyst.m2sdk.business.repositories.ApiKeyRepository] */
        /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Object, com.m2catalyst.m2sdk.business.repositories.ApiKeyRepository] */
        public final ApiKeyRepository invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(ApiKeyRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(ApiKeyRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class c extends Lambda implements Function0<DeviceRepository> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.business.repositories.DeviceRepository, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.business.repositories.DeviceRepository, java.lang.Object] */
        public final DeviceRepository invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(DeviceRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(DeviceRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b6 A[Catch:{ all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f2 A[Catch:{ all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super java.lang.Boolean> r29) {
        /*
            r28 = this;
            r1 = r28
            r0 = r29
            java.lang.String r2 = "Device synced correctly with deviceId "
            boolean r3 = r0 instanceof com.m2catalyst.m2sdk.x1.a
            if (r3 == 0) goto L_0x0019
            r3 = r0
            com.m2catalyst.m2sdk.x1$a r3 = (com.m2catalyst.m2sdk.x1.a) r3
            int r4 = r3.f
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f = r4
            goto L_0x001e
        L_0x0019:
            com.m2catalyst.m2sdk.x1$a r3 = new com.m2catalyst.m2sdk.x1$a
            r3.<init>(r1, r0)
        L_0x001e:
            java.lang.Object r0 = r3.d
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.f
            r6 = 0
            r7 = 1
            r8 = 2
            r9 = 0
            if (r5 == 0) goto L_0x004c
            if (r5 == r7) goto L_0x0046
            if (r5 != r8) goto L_0x003e
            boolean r4 = r3.c
            kotlin.jvm.internal.Ref$BooleanRef r5 = r3.b
            com.m2catalyst.m2sdk.x1 r3 = r3.a
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x003b }
            goto L_0x00a9
        L_0x003b:
            r0 = move-exception
            goto L_0x010f
        L_0x003e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0046:
            com.m2catalyst.m2sdk.x1 r5 = r3.a
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0063
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.Lazy r0 = r1.a
            java.lang.Object r0 = r0.getValue()
            com.m2catalyst.m2sdk.business.repositories.ApiKeyRepository r0 = (com.m2catalyst.m2sdk.business.repositories.ApiKeyRepository) r0
            r3.a = r1
            r3.f = r7
            java.lang.Object r0 = com.m2catalyst.m2sdk.business.repositories.ApiKeyRepository.verifyKey$default(r0, r6, r3, r7, r9)
            if (r0 != r4) goto L_0x0062
            return r4
        L_0x0062:
            r5 = r1
        L_0x0063:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r10 = r0.booleanValue()
            kotlin.jvm.internal.Ref$BooleanRef r11 = new kotlin.jvm.internal.Ref$BooleanRef
            r11.<init>()
            kotlin.Lazy r0 = r5.b
            java.lang.Object r0 = r0.getValue()
            com.m2catalyst.m2sdk.business.repositories.DeviceRepository r0 = (com.m2catalyst.m2sdk.business.repositories.DeviceRepository) r0
            boolean r0 = r0.syncNeeded()
            r0 = r0 ^ r7
            r11.element = r0
            if (r10 == 0) goto L_0x0167
            if (r0 != 0) goto L_0x014e
            kotlin.Lazy r0 = r5.b
            java.lang.Object r0 = r0.getValue()
            com.m2catalyst.m2sdk.business.repositories.DeviceRepository r0 = (com.m2catalyst.m2sdk.business.repositories.DeviceRepository) r0
            byte[] r0 = r0.getSyncBody()
            if (r0 == 0) goto L_0x017f
            kotlin.Lazy r12 = r5.b     // Catch:{ all -> 0x010b }
            java.lang.Object r12 = r12.getValue()     // Catch:{ all -> 0x010b }
            com.m2catalyst.m2sdk.business.repositories.DeviceRepository r12 = (com.m2catalyst.m2sdk.business.repositories.DeviceRepository) r12     // Catch:{ all -> 0x010b }
            r3.a = r5     // Catch:{ all -> 0x010b }
            r3.b = r11     // Catch:{ all -> 0x010b }
            r3.c = r10     // Catch:{ all -> 0x010b }
            r3.f = r8     // Catch:{ all -> 0x010b }
            java.lang.Object r0 = r12.syncDevice(r0, r3)     // Catch:{ all -> 0x010b }
            if (r0 != r4) goto L_0x00a6
            return r4
        L_0x00a6:
            r3 = r5
            r4 = r10
            r5 = r11
        L_0x00a9:
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiResponseMessage r0 = (com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiResponseMessage) r0     // Catch:{ all -> 0x003b }
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.SyncDeviceResponseMessage r0 = r0.sync_device_response     // Catch:{ all -> 0x003b }
            java.lang.Integer r0 = r0.device_id     // Catch:{ all -> 0x003b }
            int r0 = r0.intValue()     // Catch:{ all -> 0x003b }
            r0 = r0 | r6
            if (r0 == 0) goto L_0x00f2
            com.m2catalyst.m2sdk.r2 r10 = r3.c     // Catch:{ all -> 0x003b }
            com.m2catalyst.m2sdk.d6 r10 = r10.b()     // Catch:{ all -> 0x003b }
            r10.b(r0)     // Catch:{ all -> 0x003b }
            com.m2catalyst.m2sdk.r2 r10 = r3.c     // Catch:{ all -> 0x003b }
            com.m2catalyst.m2sdk.z5 r10 = r10.a()     // Catch:{ all -> 0x003b }
            com.m2catalyst.m2sdk.a6 r11 = com.m2catalyst.m2sdk.a6.DEVICE_ID     // Catch:{ all -> 0x003b }
            java.lang.Integer r12 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)     // Catch:{ all -> 0x003b }
            r10.a(r11, r12)     // Catch:{ all -> 0x003b }
            r5.element = r7     // Catch:{ all -> 0x003b }
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r13 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion     // Catch:{ all -> 0x003b }
            com.m2catalyst.m2sdk.logger.Event$Builder r10 = new com.m2catalyst.m2sdk.logger.Event$Builder     // Catch:{ all -> 0x003b }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x003b }
            r11.<init>(r2)     // Catch:{ all -> 0x003b }
            r11.append(r0)     // Catch:{ all -> 0x003b }
            java.lang.String r0 = r11.toString()     // Catch:{ all -> 0x003b }
            r10.<init>(r0, r9, r8, r9)     // Catch:{ all -> 0x003b }
            com.m2catalyst.m2sdk.logger.Event r14 = r10.build()     // Catch:{ all -> 0x003b }
            r15 = 0
            r16 = 1
            r17 = 2
            r18 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x003b }
            goto L_0x014a
        L_0x00f2:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r19 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion     // Catch:{ all -> 0x003b }
            com.m2catalyst.m2sdk.logger.Event$Builder r0 = new com.m2catalyst.m2sdk.logger.Event$Builder     // Catch:{ all -> 0x003b }
            java.lang.String r2 = "Device sync failed"
            r0.<init>(r2, r9, r8, r9)     // Catch:{ all -> 0x003b }
            com.m2catalyst.m2sdk.logger.Event r20 = r0.build()     // Catch:{ all -> 0x003b }
            r21 = 0
            r22 = 1
            r23 = 2
            r24 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x003b }
            goto L_0x014a
        L_0x010b:
            r0 = move-exception
            r3 = r5
            r4 = r10
            r5 = r11
        L_0x010f:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r10 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r2 = r0.getMessage()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "Device sync failed exception: "
            r11.<init>(r12)
            r11.append(r2)
            java.lang.String r2 = r11.toString()
            java.lang.String[] r11 = new java.lang.String[r6]
            java.lang.String r13 = "IngestionManager"
            r10.e((java.lang.String) r13, (java.lang.String) r2, (java.lang.String[]) r11)
            com.m2catalyst.m2sdk.logger.Event$Builder r2 = new com.m2catalyst.m2sdk.logger.Event$Builder
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r12)
            r11.append(r0)
            java.lang.String r0 = r11.toString()
            r2.<init>(r0, r9, r8, r9)
            com.m2catalyst.m2sdk.logger.Event r11 = r2.build()
            r12 = 0
            r13 = 1
            r14 = 2
            r15 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r10, r11, r12, r13, r14, r15)
        L_0x014a:
            r10 = r4
            r11 = r5
            r5 = r3
            goto L_0x017f
        L_0x014e:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r16 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.Event$Builder r0 = new com.m2catalyst.m2sdk.logger.Event$Builder
            java.lang.String r2 = "Device already synced"
            r0.<init>(r2, r9, r8, r9)
            com.m2catalyst.m2sdk.logger.Event r17 = r0.build()
            r18 = 0
            r19 = 1
            r20 = 2
            r21 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r16, r17, r18, r19, r20, r21)
            goto L_0x017f
        L_0x0167:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r22 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.Event$Builder r0 = new com.m2catalyst.m2sdk.logger.Event$Builder
            java.lang.String r2 = "Not able to verify api key"
            r0.<init>(r2, r9, r8, r9)
            com.m2catalyst.m2sdk.logger.Event r23 = r0.build()
            r24 = 0
            r25 = 1
            r26 = 2
            r27 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r22, r23, r24, r25, r26, r27)
        L_0x017f:
            if (r10 == 0) goto L_0x0188
            boolean r0 = r11.element
            if (r0 != 0) goto L_0x0186
            goto L_0x0188
        L_0x0186:
            r6 = 1
            goto L_0x018b
        L_0x0188:
            r5.getClass()
        L_0x018b:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.x1.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.m2catalyst.m2sdk.y6.a r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.m2catalyst.m2sdk.w1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.m2catalyst.m2sdk.w1 r0 = (com.m2catalyst.m2sdk.w1) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.w1 r0 = new com.m2catalyst.m2sdk.w1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005c
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            kotlin.jvm.functions.Function1 r6 = r0.a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0048
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.a = r6
            r0.d = r4
            java.lang.Object r7 = r5.a(r0)
            if (r7 != r1) goto L_0x0048
            return r1
        L_0x0048:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x005f
            r7 = 0
            r0.a = r7
            r0.d = r3
            java.lang.Object r6 = r6.invoke(r0)
            if (r6 != r1) goto L_0x005c
            return r1
        L_0x005c:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x005f:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.x1.a(com.m2catalyst.m2sdk.y6$a, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
