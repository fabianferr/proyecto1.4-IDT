package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/test/TestScopeImpl;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.test.TestBuildersKt__TestBuildersDeprecatedKt$runBlockingTestOnTestScope$1", f = "TestBuildersDeprecated.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TestBuildersDeprecated.kt */
final class TestBuildersKt__TestBuildersDeprecatedKt$runBlockingTestOnTestScope$1 extends SuspendLambda implements Function2<TestScopeImpl, Continuation<? super Unit>, Object> {
    final /* synthetic */ TestScopeImpl $scope;
    final /* synthetic */ Function2<TestScope, Continuation<? super Unit>, Object> $testBody;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TestBuildersKt__TestBuildersDeprecatedKt$runBlockingTestOnTestScope$1(Function2<? super TestScope, ? super Continuation<? super Unit>, ? extends Object> function2, TestScopeImpl testScopeImpl, Continuation<? super TestBuildersKt__TestBuildersDeprecatedKt$runBlockingTestOnTestScope$1> continuation) {
        super(2, continuation);
        this.$testBody = function2;
        this.$scope = testScopeImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestBuildersKt__TestBuildersDeprecatedKt$runBlockingTestOnTestScope$1(this.$testBody, this.$scope, continuation);
    }

    public final Object invoke(TestScopeImpl testScopeImpl, Continuation<? super Unit> continuation) {
        return ((TestBuildersKt__TestBuildersDeprecatedKt$runBlockingTestOnTestScope$1) create(testScopeImpl, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<TestScope, Continuation<? super Unit>, Object> function2 = this.$testBody;
            TestScopeImpl testScopeImpl = this.$scope;
            this.label = 1;
            if (function2.invoke(testScopeImpl, this) == coroutine_suspended) {
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
