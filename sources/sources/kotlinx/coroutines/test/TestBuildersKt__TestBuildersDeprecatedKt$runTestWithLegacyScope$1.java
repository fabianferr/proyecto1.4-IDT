package kotlinx.coroutines.test;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.test.TestBuildersKt__TestBuildersDeprecatedKt$runTestWithLegacyScope$1", f = "TestBuildersDeprecated.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TestBuildersDeprecated.kt */
final class TestBuildersKt__TestBuildersDeprecatedKt$runTestWithLegacyScope$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $dispatchTimeoutMs;
    final /* synthetic */ Function2<TestCoroutineScope, Continuation<? super Unit>, Object> $testBody;
    final /* synthetic */ TestBodyCoroutine $testScope;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TestBuildersKt__TestBuildersDeprecatedKt$runTestWithLegacyScope$1(TestBodyCoroutine testBodyCoroutine, long j, Function2<? super TestCoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super TestBuildersKt__TestBuildersDeprecatedKt$runTestWithLegacyScope$1> continuation) {
        super(2, continuation);
        this.$testScope = testBodyCoroutine;
        this.$dispatchTimeoutMs = j;
        this.$testBody = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TestBuildersKt__TestBuildersDeprecatedKt$runTestWithLegacyScope$1 testBuildersKt__TestBuildersDeprecatedKt$runTestWithLegacyScope$1 = new TestBuildersKt__TestBuildersDeprecatedKt$runTestWithLegacyScope$1(this.$testScope, this.$dispatchTimeoutMs, this.$testBody, continuation);
        testBuildersKt__TestBuildersDeprecatedKt$runTestWithLegacyScope$1.L$0 = obj;
        return testBuildersKt__TestBuildersDeprecatedKt$runTestWithLegacyScope$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TestBuildersKt__TestBuildersDeprecatedKt$runTestWithLegacyScope$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<TestCoroutineScope, Continuation<? super Unit>, Object> function2 = this.$testBody;
            final TestBodyCoroutine testBodyCoroutine = this.$testScope;
            this.label = 1;
            if (TestBuildersKt.runTestCoroutine((CoroutineScope) this.L$0, this.$testScope, this.$dispatchTimeoutMs, AnonymousClass1.INSTANCE, function2, new Function0<List<? extends Throwable>>() {
                public final List<Throwable> invoke() {
                    try {
                        testBodyCoroutine.cleanup();
                        return CollectionsKt.emptyList();
                    } catch (UncompletedCoroutinesError e) {
                        throw e;
                    } catch (Throwable th) {
                        return CollectionsKt.listOf(th);
                    }
                }
            }, this) == coroutine_suspended) {
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
