package kotlinx.coroutines.test;

import kotlinx.coroutines.DisposableHandle;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TestCoroutineScheduler$$ExternalSyntheticLambda0 implements DisposableHandle {
    public final /* synthetic */ TestCoroutineScheduler f$0;
    public final /* synthetic */ TestDispatchEvent f$1;

    public /* synthetic */ TestCoroutineScheduler$$ExternalSyntheticLambda0(TestCoroutineScheduler testCoroutineScheduler, TestDispatchEvent testDispatchEvent) {
        this.f$0 = testCoroutineScheduler;
        this.f$1 = testDispatchEvent;
    }

    public final void dispose() {
        TestCoroutineScheduler.m2947registerEvent$lambda4$lambda3(this.f$0, this.f$1);
    }
}
