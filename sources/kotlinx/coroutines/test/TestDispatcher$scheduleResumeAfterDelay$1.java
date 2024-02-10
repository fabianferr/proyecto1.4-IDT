package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TestDispatcher.kt */
/* synthetic */ class TestDispatcher$scheduleResumeAfterDelay$1 extends FunctionReferenceImpl implements Function1<CancellableContinuationRunnable, Boolean> {
    public static final TestDispatcher$scheduleResumeAfterDelay$1 INSTANCE = new TestDispatcher$scheduleResumeAfterDelay$1();

    TestDispatcher$scheduleResumeAfterDelay$1() {
        super(1, TestDispatcherKt.class, "cancellableRunnableIsCancelled", "cancellableRunnableIsCancelled(Lkotlinx/coroutines/test/CancellableContinuationRunnable;)Z", 1);
    }

    public final Boolean invoke(CancellableContinuationRunnable cancellableContinuationRunnable) {
        return Boolean.valueOf(TestDispatcherKt.cancellableRunnableIsCancelled(cancellableContinuationRunnable));
    }
}
