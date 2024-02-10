package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.YieldKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTestCoroutine$backgroundWorkRunner$1", f = "TestBuilders.kt", i = {0}, l = {249}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: TestBuilders.kt */
final class TestBuildersKt__TestBuildersKt$runTestCoroutine$backgroundWorkRunner$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TestCoroutineScheduler $scheduler;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TestBuildersKt__TestBuildersKt$runTestCoroutine$backgroundWorkRunner$1(TestCoroutineScheduler testCoroutineScheduler, Continuation<? super TestBuildersKt__TestBuildersKt$runTestCoroutine$backgroundWorkRunner$1> continuation) {
        super(2, continuation);
        this.$scheduler = testCoroutineScheduler;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TestBuildersKt__TestBuildersKt$runTestCoroutine$backgroundWorkRunner$1 testBuildersKt__TestBuildersKt$runTestCoroutine$backgroundWorkRunner$1 = new TestBuildersKt__TestBuildersKt$runTestCoroutine$backgroundWorkRunner$1(this.$scheduler, continuation);
        testBuildersKt__TestBuildersKt$runTestCoroutine$backgroundWorkRunner$1.L$0 = obj;
        return testBuildersKt__TestBuildersKt$runTestCoroutine$backgroundWorkRunner$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TestBuildersKt__TestBuildersKt$runTestCoroutine$backgroundWorkRunner$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        final CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
        } else if (i == 1) {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        do {
            this.$scheduler.tryRunNextTaskUnless$kotlinx_coroutines_test(new Function0<Boolean>() {
                public final Boolean invoke() {
                    return Boolean.valueOf(!CoroutineScopeKt.isActive(coroutineScope));
                }
            });
            this.L$0 = coroutineScope;
            this.label = 1;
        } while (YieldKt.yield(this) != coroutine_suspended);
        return coroutine_suspended;
    }
}
