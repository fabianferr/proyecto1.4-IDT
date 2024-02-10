package com.m2catalyst.m2sdk.business.repositories;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.ApiKeyRepository", f = "ApiKeyRepository.kt", i = {0, 0}, l = {34}, m = "verifyKey", n = {"this", "success"}, s = {"L$0", "L$1"})
/* compiled from: ApiKeyRepository.kt */
public final class ApiKeyRepository$verifyKey$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ApiKeyRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApiKeyRepository$verifyKey$1(ApiKeyRepository apiKeyRepository, Continuation<? super ApiKeyRepository$verifyKey$1> continuation) {
        super(continuation);
        this.this$0 = apiKeyRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.verifyKey(false, this);
    }
}
