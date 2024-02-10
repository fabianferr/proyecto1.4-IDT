package kotlinx.coroutines.test.internal;

import kotlin.Metadata;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"getTestMainDispatcher", "Lkotlinx/coroutines/test/internal/TestMainDispatcher;", "Lkotlinx/coroutines/Dispatchers;", "kotlinx-coroutines-test"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TestMainDispatcherJvm.kt */
public final class TestMainDispatcherJvmKt {
    public static final TestMainDispatcher getTestMainDispatcher(Dispatchers dispatchers) {
        MainCoroutineDispatcher main = Dispatchers.getMain();
        if (main instanceof TestMainDispatcher) {
            return (TestMainDispatcher) main;
        }
        throw new IllegalArgumentException(("TestMainDispatcher is not set as main dispatcher, have " + main + " instead.").toString());
    }
}
