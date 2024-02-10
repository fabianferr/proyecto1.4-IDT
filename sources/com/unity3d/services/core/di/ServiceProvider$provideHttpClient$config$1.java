package com.unity3d.services.core.di;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/unity3d/services/core/configuration/Configuration;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.di.ServiceProvider$provideHttpClient$config$1", f = "ServiceProvider.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ServiceProvider.kt */
final class ServiceProvider$provideHttpClient$config$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Configuration>, Object> {
    final /* synthetic */ ConfigFileFromLocalStorage $configFileFromLocalStorage;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceProvider$provideHttpClient$config$1(ConfigFileFromLocalStorage configFileFromLocalStorage, Continuation<? super ServiceProvider$provideHttpClient$config$1> continuation) {
        super(2, continuation);
        this.$configFileFromLocalStorage = configFileFromLocalStorage;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ServiceProvider$provideHttpClient$config$1 serviceProvider$provideHttpClient$config$1 = new ServiceProvider$provideHttpClient$config$1(this.$configFileFromLocalStorage, continuation);
        serviceProvider$provideHttpClient$config$1.L$0 = obj;
        return serviceProvider$provideHttpClient$config$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Configuration> continuation) {
        return ((ServiceProvider$provideHttpClient$config$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ConfigFileFromLocalStorage configFileFromLocalStorage = this.$configFileFromLocalStorage;
            Result.Companion companion = Result.Companion;
            this.label = 1;
            obj = configFileFromLocalStorage.invoke(new ConfigFileFromLocalStorage.Params(), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m2344constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m2344constructorimpl((Configuration) obj);
        if (Result.m2350isFailureimpl(obj2)) {
            return null;
        }
        return obj2;
    }
}
