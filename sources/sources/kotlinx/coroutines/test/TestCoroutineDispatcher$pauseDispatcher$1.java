package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.test.TestCoroutineDispatcher", f = "TestCoroutineDispatcher.kt", i = {0, 0}, l = {68}, m = "pauseDispatcher", n = {"this", "previous"}, s = {"L$0", "Z$0"})
/* compiled from: TestCoroutineDispatcher.kt */
final class TestCoroutineDispatcher$pauseDispatcher$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TestCoroutineDispatcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TestCoroutineDispatcher$pauseDispatcher$1(TestCoroutineDispatcher testCoroutineDispatcher, Continuation<? super TestCoroutineDispatcher$pauseDispatcher$1> continuation) {
        super(continuation);
        this.this$0 = testCoroutineDispatcher;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.pauseDispatcher((Function1<? super Continuation<? super Unit>, ? extends Object>) null, this);
    }
}
