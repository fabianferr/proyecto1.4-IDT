package com.m2catalyst.m2sdk.speed_test;

import android.net.Network;
import com.m2catalyst.m2sdk.business.models.M2Location;
import com.m2catalyst.m2sdk.business.models.MNSI;
import com.m2catalyst.m2sdk.m4;
import com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.speed_test.SpeedTestManager$runAutomaticTest$1", f = "SpeedTestManager.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SpeedTestManager.kt */
public final class SpeedTestManager$runAutomaticTest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MNSI $lastSavedMNSI;
    final /* synthetic */ M2Location $loc;
    final /* synthetic */ MNSI $mnsi;
    final /* synthetic */ NetworkDiagnosticTestConfig $networkDiagnosticTestConfig;
    int label;
    final /* synthetic */ SpeedTestManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpeedTestManager$runAutomaticTest$1(SpeedTestManager speedTestManager, NetworkDiagnosticTestConfig networkDiagnosticTestConfig, MNSI mnsi, M2Location m2Location, MNSI mnsi2, Continuation<? super SpeedTestManager$runAutomaticTest$1> continuation) {
        super(2, continuation);
        this.this$0 = speedTestManager;
        this.$networkDiagnosticTestConfig = networkDiagnosticTestConfig;
        this.$mnsi = mnsi;
        this.$loc = m2Location;
        this.$lastSavedMNSI = mnsi2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SpeedTestManager$runAutomaticTest$1(this.this$0, this.$networkDiagnosticTestConfig, this.$mnsi, this.$loc, this.$lastSavedMNSI, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SpeedTestManager$runAutomaticTest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ThroughputConfigUtil access$getThroughputConfigUtil$p = this.this$0.throughputConfigUtil;
            NetworkDiagnosticTestConfig networkDiagnosticTestConfig = this.$networkDiagnosticTestConfig;
            MNSI mnsi = this.$mnsi;
            M2Location m2Location = this.$loc;
            Network a = m4.a(this.this$0.context);
            MNSI mnsi2 = this.$lastSavedMNSI;
            this.label = 1;
            if (access$getThroughputConfigUtil$p.initiateTest(networkDiagnosticTestConfig, mnsi, m2Location, a, mnsi2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
