package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.IConfigurationLoader;
import com.unity3d.services.core.configuration.IConfigurationLoaderListener;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.extensions.AbortRetryException;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.request.metrics.TSIMetric;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$configResult$1$1", f = "InitializeStateConfigWithLoader.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InitializeStateConfigWithLoader.kt */
final class InitializeStateConfigWithLoader$doWork$2$configResult$1$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Configuration> $config;
    final /* synthetic */ Ref.ObjectRef<IConfigurationLoader> $configurationLoader;
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ InitializeStateConfigWithLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateConfigWithLoader$doWork$2$configResult$1$1(InitializeStateConfigWithLoader initializeStateConfigWithLoader, Ref.ObjectRef<IConfigurationLoader> objectRef, Ref.ObjectRef<Configuration> objectRef2, Continuation<? super InitializeStateConfigWithLoader$doWork$2$configResult$1$1> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateConfigWithLoader;
        this.$configurationLoader = objectRef;
        this.$config = objectRef2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeStateConfigWithLoader$doWork$2$configResult$1$1 initializeStateConfigWithLoader$doWork$2$configResult$1$1 = new InitializeStateConfigWithLoader$doWork$2$configResult$1$1(this.this$0, this.$configurationLoader, this.$config, continuation);
        initializeStateConfigWithLoader$doWork$2$configResult$1$1.I$0 = ((Number) obj).intValue();
        return initializeStateConfigWithLoader$doWork$2$configResult$1$1;
    }

    public final Object invoke(int i, Continuation<? super Unit> continuation) {
        return ((InitializeStateConfigWithLoader$doWork$2$configResult$1$1) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (Continuation<? super Unit>) (Continuation) obj2);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.I$0 > 0) {
                InitializeEventsMetricSender.getInstance().onRetryConfig();
            }
            final Ref.ObjectRef<IConfigurationLoader> objectRef = this.$configurationLoader;
            final Ref.ObjectRef<Configuration> objectRef2 = this.$config;
            final InitializeStateConfigWithLoader initializeStateConfigWithLoader = this.this$0;
            this.label = 1;
            if (BuildersKt.withContext(this.this$0.dispatchers.getIo(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$configResult$1$1$1", f = "InitializeStateConfigWithLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$configResult$1$1$1  reason: invalid class name */
    /* compiled from: InitializeStateConfigWithLoader.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(objectRef, objectRef2, initializeStateConfigWithLoader, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                final Ref.ObjectRef<Configuration> objectRef = objectRef2;
                final InitializeStateConfigWithLoader initializeStateConfigWithLoader = initializeStateConfigWithLoader;
                ((IConfigurationLoader) objectRef.element).loadConfiguration(new IConfigurationLoaderListener() {
                    public void onSuccess(Configuration configuration) {
                        Intrinsics.checkNotNullParameter(configuration, "configuration");
                        objectRef.element = configuration;
                        ((Configuration) objectRef.element).saveToDisk();
                        initializeStateConfigWithLoader.tokenStorage.setInitToken(((Configuration) objectRef.element).getUnifiedAuctionToken());
                    }

                    public void onError(String str) {
                        Intrinsics.checkNotNullParameter(str, "errorMsg");
                        SDKMetricsSender access$getSdkMetricsSender$p = initializeStateConfigWithLoader.sdkMetricsSender;
                        Metric newEmergencySwitchOff = TSIMetric.newEmergencySwitchOff();
                        Intrinsics.checkNotNullExpressionValue(newEmergencySwitchOff, "newEmergencySwitchOff()");
                        access$getSdkMetricsSender$p.sendMetric(newEmergencySwitchOff);
                        throw new AbortRetryException(str);
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
