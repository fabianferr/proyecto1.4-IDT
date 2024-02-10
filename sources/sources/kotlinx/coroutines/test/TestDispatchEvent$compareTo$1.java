package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TestCoroutineScheduler.kt */
/* synthetic */ class TestDispatchEvent$compareTo$1 extends PropertyReference1Impl {
    public static final TestDispatchEvent$compareTo$1 INSTANCE = new TestDispatchEvent$compareTo$1();

    TestDispatchEvent$compareTo$1() {
        super(TestDispatchEvent.class, "time", "getTime()J", 0);
    }

    public Object get(Object obj) {
        return Long.valueOf(((TestDispatchEvent) obj).time);
    }
}
