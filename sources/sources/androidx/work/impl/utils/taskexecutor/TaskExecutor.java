package androidx.work.impl.utils.taskexecutor;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.concurrent.Executor;

public interface TaskExecutor {
    void executeOnTaskThread(Runnable runnable);

    Executor getMainThreadExecutor();

    SerialExecutor getSerialTaskExecutor();

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: androidx.work.impl.utils.taskexecutor.TaskExecutor$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$executeOnTaskThread(TaskExecutor _this, Runnable runnable) {
            _this.getSerialTaskExecutor().execute(runnable);
        }
    }
}
