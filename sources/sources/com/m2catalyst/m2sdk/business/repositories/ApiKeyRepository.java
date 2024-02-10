package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.a6;
import com.m2catalyst.m2sdk.b2;
import com.m2catalyst.m2sdk.configuration.M2Configuration;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage;
import com.m2catalyst.m2sdk.n3;
import com.m2catalyst.m2sdk.o1;
import com.m2catalyst.m2sdk.p2;
import com.m2catalyst.m2sdk.r2;
import com.m2catalyst.m2sdk.s1;
import com.m2catalyst.m2sdk.z5;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001d\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/m2catalyst/m2sdk/business/repositories/ApiKeyRepository;", "Lcom/m2catalyst/m2sdk/business/repositories/BaseRepository;", "", "getApiCheckBody", "", "requiresVerification", "force", "verifyKey", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/m2catalyst/m2sdk/b2;", "apiClient", "Lcom/m2catalyst/m2sdk/b2;", "Lcom/m2catalyst/m2sdk/r2;", "configuration", "Lcom/m2catalyst/m2sdk/r2;", "<init>", "(Lcom/m2catalyst/m2sdk/b2;)V", "Companion", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: ApiKeyRepository.kt */
public final class ApiKeyRepository extends BaseRepository {
    private static final String API_KEY_REPOSITORY_LOGS = "API_KEY_REPOSITORY_LOGS";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final b2 apiClient;
    private final r2 configuration = r2.a.a();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/m2catalyst/m2sdk/business/repositories/ApiKeyRepository$Companion;", "", "()V", "API_KEY_REPOSITORY_LOGS", "", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ApiKeyRepository.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ApiKeyRepository(b2 b2Var) {
        Intrinsics.checkNotNullParameter(b2Var, "apiClient");
        this.apiClient = b2Var;
    }

    private final byte[] getApiCheckBody() {
        return ApiRequestMessage.ADAPTER.encode(n3.a(this.configuration).build());
    }

    private final boolean requiresVerification() {
        long j;
        p2 generalConfig;
        Integer num;
        if (this.configuration.h.c == 1) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        z5 a = this.configuration.a();
        Object obj = a6.LAST_TIME_VERIFY_API_CLIENT.b;
        if (a.a.getAll().containsKey("lastTimeVerifyApiClient")) {
            obj = a.a.getAll().get("lastTimeVerifyApiClient");
        }
        Long l = (Long) obj;
        Set<String> set = s1.a;
        long longValue = currentTimeMillis - (l != null ? l.longValue() : 0);
        M2Configuration m2Configuration = this.configuration.g;
        if (m2Configuration == null || (generalConfig = m2Configuration.getGeneralConfig()) == null || (num = generalConfig.a) == null) {
            j = o1.a(168);
        } else {
            j = o1.a(num.intValue() * 24);
        }
        if (longValue > j) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ Object verifyKey$default(ApiKeyRepository apiKeyRepository, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return apiKeyRepository.verifyKey(z, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0076 A[Catch:{ all -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0087 A[Catch:{ all -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a1 A[Catch:{ all -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object verifyKey(boolean r18, kotlin.coroutines.Continuation<? super java.lang.Boolean> r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            java.lang.String r2 = "Verifying API_KEY was SUCCESSFUL with details "
            boolean r3 = r0 instanceof com.m2catalyst.m2sdk.business.repositories.ApiKeyRepository$verifyKey$1
            if (r3 == 0) goto L_0x0019
            r3 = r0
            com.m2catalyst.m2sdk.business.repositories.ApiKeyRepository$verifyKey$1 r3 = (com.m2catalyst.m2sdk.business.repositories.ApiKeyRepository$verifyKey$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.label = r4
            goto L_0x001e
        L_0x0019:
            com.m2catalyst.m2sdk.business.repositories.ApiKeyRepository$verifyKey$1 r3 = new com.m2catalyst.m2sdk.business.repositories.ApiKeyRepository$verifyKey$1
            r3.<init>(r1, r0)
        L_0x001e:
            java.lang.Object r0 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L_0x0040
            if (r5 != r7) goto L_0x0038
            java.lang.Object r4 = r3.L$1
            kotlin.jvm.internal.Ref$BooleanRef r4 = (kotlin.jvm.internal.Ref.BooleanRef) r4
            java.lang.Object r3 = r3.L$0
            com.m2catalyst.m2sdk.business.repositories.ApiKeyRepository r3 = (com.m2catalyst.m2sdk.business.repositories.ApiKeyRepository) r3
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x010a }
            goto L_0x006c
        L_0x0038:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$BooleanRef r0 = new kotlin.jvm.internal.Ref$BooleanRef
            r0.<init>()
            r0.element = r7
            boolean r5 = r17.requiresVerification()     // Catch:{ all -> 0x010a }
            if (r5 != 0) goto L_0x0052
            if (r18 == 0) goto L_0x0107
        L_0x0052:
            r0.element = r6     // Catch:{ all -> 0x010a }
            byte[] r5 = r17.getApiCheckBody()     // Catch:{ all -> 0x010a }
            if (r5 == 0) goto L_0x0107
            com.m2catalyst.m2sdk.b2 r8 = r1.apiClient     // Catch:{ all -> 0x010a }
            r3.L$0 = r1     // Catch:{ all -> 0x010a }
            r3.L$1 = r0     // Catch:{ all -> 0x010a }
            r3.label = r7     // Catch:{ all -> 0x010a }
            java.lang.Object r3 = r8.a(r5, r3)     // Catch:{ all -> 0x010a }
            if (r3 != r4) goto L_0x0069
            return r4
        L_0x0069:
            r4 = r0
            r0 = r3
            r3 = r1
        L_0x006c:
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiResponseMessage r0 = (com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiResponseMessage) r0     // Catch:{ all -> 0x010a }
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.VerifyApiKeyResponseMessage r5 = r0.verify_api_key_response     // Catch:{ all -> 0x010a }
            if (r5 == 0) goto L_0x0087
            java.lang.Integer r5 = r5.company_id     // Catch:{ all -> 0x010a }
            if (r5 == 0) goto L_0x0087
            com.m2catalyst.m2sdk.a6 r8 = com.m2catalyst.m2sdk.a6.COMPANY_ID     // Catch:{ all -> 0x010a }
            java.lang.Object r8 = r8.a()     // Catch:{ all -> 0x010a }
            java.lang.Number r8 = (java.lang.Number) r8     // Catch:{ all -> 0x010a }
            int r8 = r8.intValue()     // Catch:{ all -> 0x010a }
            int r5 = com.m2catalyst.m2sdk.s1.a(r5, r8)     // Catch:{ all -> 0x010a }
            goto L_0x0093
        L_0x0087:
            com.m2catalyst.m2sdk.a6 r5 = com.m2catalyst.m2sdk.a6.COMPANY_ID     // Catch:{ all -> 0x010a }
            java.lang.Object r5 = r5.a()     // Catch:{ all -> 0x010a }
            java.lang.Number r5 = (java.lang.Number) r5     // Catch:{ all -> 0x010a }
            int r5 = r5.intValue()     // Catch:{ all -> 0x010a }
        L_0x0093:
            java.lang.Boolean r8 = r0.success     // Catch:{ all -> 0x010a }
            java.lang.String r9 = "this.success"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)     // Catch:{ all -> 0x010a }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x010a }
            if (r8 == 0) goto L_0x00f6
            com.m2catalyst.m2sdk.a6 r8 = com.m2catalyst.m2sdk.a6.COMPANY_ID     // Catch:{ all -> 0x010a }
            java.lang.Object r9 = r8.a()     // Catch:{ all -> 0x010a }
            java.lang.Number r9 = (java.lang.Number) r9     // Catch:{ all -> 0x010a }
            int r9 = r9.intValue()     // Catch:{ all -> 0x010a }
            if (r5 == r9) goto L_0x00f6
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r10 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion     // Catch:{ all -> 0x010a }
            java.lang.String r11 = "API_KEY_REPOSITORY_LOGS"
            java.lang.String r0 = r0.details     // Catch:{ all -> 0x010a }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x010a }
            r9.<init>(r2)     // Catch:{ all -> 0x010a }
            r9.append(r0)     // Catch:{ all -> 0x010a }
            java.lang.String r12 = r9.toString()     // Catch:{ all -> 0x010a }
            r13 = 0
            r14 = 0
            r15 = 12
            r16 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x010a }
            com.m2catalyst.m2sdk.r2 r0 = r3.configuration     // Catch:{ all -> 0x010a }
            com.m2catalyst.m2sdk.z5 r0 = r0.a()     // Catch:{ all -> 0x010a }
            com.m2catalyst.m2sdk.a6 r2 = com.m2catalyst.m2sdk.a6.LAST_TIME_VERIFY_API_CLIENT     // Catch:{ all -> 0x010a }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x010a }
            java.lang.Long r9 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r9)     // Catch:{ all -> 0x010a }
            r0.a(r2, r9)     // Catch:{ all -> 0x010a }
            com.m2catalyst.m2sdk.r2 r0 = r3.configuration     // Catch:{ all -> 0x010a }
            com.m2catalyst.m2sdk.d6 r0 = r0.b()     // Catch:{ all -> 0x010a }
            r0.a(r5)     // Catch:{ all -> 0x010a }
            com.m2catalyst.m2sdk.r2 r0 = r3.configuration     // Catch:{ all -> 0x010a }
            com.m2catalyst.m2sdk.z5 r0 = r0.a()     // Catch:{ all -> 0x010a }
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)     // Catch:{ all -> 0x010a }
            r0.a(r8, r2)     // Catch:{ all -> 0x010a }
            r4.element = r7     // Catch:{ all -> 0x010a }
            goto L_0x0106
        L_0x00f6:
            r4.element = r6     // Catch:{ all -> 0x010a }
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r9 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion     // Catch:{ all -> 0x010a }
            java.lang.String r10 = "API_KEY_REPOSITORY_LOGS"
            java.lang.String r11 = "Verifying API_KEY FAILED"
            r12 = 0
            r13 = 0
            r14 = 12
            r15 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x010a }
        L_0x0106:
            r0 = r4
        L_0x0107:
            boolean r6 = r0.element     // Catch:{ all -> 0x010a }
            goto L_0x0126
        L_0x010a:
            r0 = move-exception
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Verifying API_KEY FAILED exception: "
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String[] r3 = new java.lang.String[r6]
            java.lang.String r4 = "API_KEY_REPOSITORY_LOGS"
            r2.e((java.lang.String) r4, (java.lang.String) r0, (java.lang.String[]) r3)
        L_0x0126:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.ApiKeyRepository.verifyKey(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
