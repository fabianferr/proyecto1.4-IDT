package com.m2catalyst.m2sdk.logger;

import com.m2catalyst.m2sdk.external.LoggingLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.logger.M2SDKLogger$log$1", f = "M2SDKLogger.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: M2SDKLogger.kt */
public final class M2SDKLogger$log$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $combinedMessage;
    final /* synthetic */ LoggingLevel $level;
    final /* synthetic */ int $processID;
    final /* synthetic */ String $tag;
    final /* synthetic */ int $threadID;
    int label;
    final /* synthetic */ M2SDKLogger this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public M2SDKLogger$log$1(M2SDKLogger m2SDKLogger, LoggingLevel loggingLevel, String str, Ref.ObjectRef<String> objectRef, int i, int i2, Continuation<? super M2SDKLogger$log$1> continuation) {
        super(2, continuation);
        this.this$0 = m2SDKLogger;
        this.$level = loggingLevel;
        this.$tag = str;
        this.$combinedMessage = objectRef;
        this.$threadID = i;
        this.$processID = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new M2SDKLogger$log$1(this.this$0, this.$level, this.$tag, this.$combinedMessage, this.$threadID, this.$processID, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((M2SDKLogger$log$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.writeToFile(this.$level, this.$tag, (String) this.$combinedMessage.element, this.$threadID, this.$processID);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
