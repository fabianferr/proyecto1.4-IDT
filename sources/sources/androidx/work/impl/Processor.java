package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class Processor implements ExecutionListener, ForegroundProcessor {
    private static final String FOREGROUND_WAKELOCK_TAG = "ProcessorForegroundLck";
    private static final String TAG = Logger.tagWithPrefix("Processor");
    private Context mAppContext;
    private Set<String> mCancelledIds;
    private Configuration mConfiguration;
    private Map<String, WorkerWrapper> mEnqueuedWorkMap = new HashMap();
    private PowerManager.WakeLock mForegroundLock;
    private Map<String, WorkerWrapper> mForegroundWorkMap = new HashMap();
    private final Object mLock;
    private final List<ExecutionListener> mOuterListeners;
    private List<Scheduler> mSchedulers;
    private WorkDatabase mWorkDatabase;
    private Map<String, Set<StartStopToken>> mWorkRuns;
    private TaskExecutor mWorkTaskExecutor;

    public Processor(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, List<Scheduler> list) {
        this.mAppContext = context;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = taskExecutor;
        this.mWorkDatabase = workDatabase;
        this.mSchedulers = list;
        this.mCancelledIds = new HashSet();
        this.mOuterListeners = new ArrayList();
        this.mForegroundLock = null;
        this.mLock = new Object();
        this.mWorkRuns = new HashMap();
    }

    public boolean startWork(StartStopToken startStopToken) {
        return startWork(startStopToken, (WorkerParameters.RuntimeExtras) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0086, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean startWork(androidx.work.impl.StartStopToken r13, androidx.work.WorkerParameters.RuntimeExtras r14) {
        /*
            r12 = this;
            java.lang.String r0 = "Work "
            androidx.work.impl.model.WorkGenerationalId r1 = r13.getId()
            java.lang.String r2 = r1.getWorkSpecId()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            androidx.work.impl.WorkDatabase r3 = r12.mWorkDatabase
            androidx.work.impl.Processor$$ExternalSyntheticLambda0 r4 = new androidx.work.impl.Processor$$ExternalSyntheticLambda0
            r4.<init>(r12, r10, r2)
            java.lang.Object r3 = r3.runInTransaction(r4)
            r9 = r3
            androidx.work.impl.model.WorkSpec r9 = (androidx.work.impl.model.WorkSpec) r9
            r3 = 0
            if (r9 != 0) goto L_0x003b
            androidx.work.Logger r13 = androidx.work.Logger.get()
            java.lang.String r14 = TAG
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Didn't find WorkSpec for id "
            r0.<init>(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r13.warning(r14, r0)
            r12.runOnExecuted(r1, r3)
            return r3
        L_0x003b:
            java.lang.Object r11 = r12.mLock
            monitor-enter(r11)
            boolean r4 = r12.isEnqueued(r2)     // Catch:{ all -> 0x010c }
            if (r4 == 0) goto L_0x0087
            java.util.Map<java.lang.String, java.util.Set<androidx.work.impl.StartStopToken>> r14 = r12.mWorkRuns     // Catch:{ all -> 0x010c }
            java.lang.Object r14 = r14.get(r2)     // Catch:{ all -> 0x010c }
            java.util.Set r14 = (java.util.Set) r14     // Catch:{ all -> 0x010c }
            java.util.Iterator r2 = r14.iterator()     // Catch:{ all -> 0x010c }
            java.lang.Object r2 = r2.next()     // Catch:{ all -> 0x010c }
            androidx.work.impl.StartStopToken r2 = (androidx.work.impl.StartStopToken) r2     // Catch:{ all -> 0x010c }
            androidx.work.impl.model.WorkGenerationalId r2 = r2.getId()     // Catch:{ all -> 0x010c }
            int r2 = r2.getGeneration()     // Catch:{ all -> 0x010c }
            int r4 = r1.getGeneration()     // Catch:{ all -> 0x010c }
            if (r2 != r4) goto L_0x0082
            r14.add(r13)     // Catch:{ all -> 0x010c }
            androidx.work.Logger r13 = androidx.work.Logger.get()     // Catch:{ all -> 0x010c }
            java.lang.String r14 = TAG     // Catch:{ all -> 0x010c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x010c }
            r2.<init>(r0)     // Catch:{ all -> 0x010c }
            r2.append(r1)     // Catch:{ all -> 0x010c }
            java.lang.String r0 = " is already enqueued for processing"
            r2.append(r0)     // Catch:{ all -> 0x010c }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x010c }
            r13.debug(r14, r0)     // Catch:{ all -> 0x010c }
            goto L_0x0085
        L_0x0082:
            r12.runOnExecuted(r1, r3)     // Catch:{ all -> 0x010c }
        L_0x0085:
            monitor-exit(r11)     // Catch:{ all -> 0x010c }
            return r3
        L_0x0087:
            int r0 = r9.getGeneration()     // Catch:{ all -> 0x010c }
            int r4 = r1.getGeneration()     // Catch:{ all -> 0x010c }
            if (r0 == r4) goto L_0x0096
            r12.runOnExecuted(r1, r3)     // Catch:{ all -> 0x010c }
            monitor-exit(r11)     // Catch:{ all -> 0x010c }
            return r3
        L_0x0096:
            androidx.work.impl.WorkerWrapper$Builder r0 = new androidx.work.impl.WorkerWrapper$Builder     // Catch:{ all -> 0x010c }
            android.content.Context r4 = r12.mAppContext     // Catch:{ all -> 0x010c }
            androidx.work.Configuration r5 = r12.mConfiguration     // Catch:{ all -> 0x010c }
            androidx.work.impl.utils.taskexecutor.TaskExecutor r6 = r12.mWorkTaskExecutor     // Catch:{ all -> 0x010c }
            androidx.work.impl.WorkDatabase r8 = r12.mWorkDatabase     // Catch:{ all -> 0x010c }
            r3 = r0
            r7 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x010c }
            java.util.List<androidx.work.impl.Scheduler> r3 = r12.mSchedulers     // Catch:{ all -> 0x010c }
            androidx.work.impl.WorkerWrapper$Builder r0 = r0.withSchedulers(r3)     // Catch:{ all -> 0x010c }
            androidx.work.impl.WorkerWrapper$Builder r14 = r0.withRuntimeExtras(r14)     // Catch:{ all -> 0x010c }
            androidx.work.impl.WorkerWrapper r14 = r14.build()     // Catch:{ all -> 0x010c }
            com.google.common.util.concurrent.ListenableFuture r0 = r14.getFuture()     // Catch:{ all -> 0x010c }
            androidx.work.impl.Processor$FutureListener r3 = new androidx.work.impl.Processor$FutureListener     // Catch:{ all -> 0x010c }
            androidx.work.impl.model.WorkGenerationalId r4 = r13.getId()     // Catch:{ all -> 0x010c }
            r3.<init>(r12, r4, r0)     // Catch:{ all -> 0x010c }
            androidx.work.impl.utils.taskexecutor.TaskExecutor r4 = r12.mWorkTaskExecutor     // Catch:{ all -> 0x010c }
            java.util.concurrent.Executor r4 = r4.getMainThreadExecutor()     // Catch:{ all -> 0x010c }
            r0.addListener(r3, r4)     // Catch:{ all -> 0x010c }
            java.util.Map<java.lang.String, androidx.work.impl.WorkerWrapper> r0 = r12.mEnqueuedWorkMap     // Catch:{ all -> 0x010c }
            r0.put(r2, r14)     // Catch:{ all -> 0x010c }
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ all -> 0x010c }
            r0.<init>()     // Catch:{ all -> 0x010c }
            r0.add(r13)     // Catch:{ all -> 0x010c }
            java.util.Map<java.lang.String, java.util.Set<androidx.work.impl.StartStopToken>> r13 = r12.mWorkRuns     // Catch:{ all -> 0x010c }
            r13.put(r2, r0)     // Catch:{ all -> 0x010c }
            monitor-exit(r11)     // Catch:{ all -> 0x010c }
            androidx.work.impl.utils.taskexecutor.TaskExecutor r13 = r12.mWorkTaskExecutor
            androidx.work.impl.utils.taskexecutor.SerialExecutor r13 = r13.getSerialTaskExecutor()
            r13.execute(r14)
            androidx.work.Logger r13 = androidx.work.Logger.get()
            java.lang.String r14 = TAG
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Class r2 = r12.getClass()
            java.lang.String r2 = r2.getSimpleName()
            r0.append(r2)
            java.lang.String r2 = ": processing "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r13.debug(r14, r0)
            r13 = 1
            return r13
        L_0x010c:
            r13 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x010c }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.Processor.startWork(androidx.work.impl.StartStopToken, androidx.work.WorkerParameters$RuntimeExtras):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$startWork$0$androidx-work-impl-Processor  reason: not valid java name */
    public /* synthetic */ WorkSpec m1631lambda$startWork$0$androidxworkimplProcessor(ArrayList arrayList, String str) throws Exception {
        arrayList.addAll(this.mWorkDatabase.workTagDao().getTagsForWorkSpecId(str));
        return this.mWorkDatabase.workSpecDao().getWorkSpec(str);
    }

    public void startForeground(String str, ForegroundInfo foregroundInfo) {
        synchronized (this.mLock) {
            Logger logger = Logger.get();
            String str2 = TAG;
            logger.info(str2, "Moving WorkSpec (" + str + ") to the foreground");
            WorkerWrapper remove = this.mEnqueuedWorkMap.remove(str);
            if (remove != null) {
                if (this.mForegroundLock == null) {
                    PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(this.mAppContext, FOREGROUND_WAKELOCK_TAG);
                    this.mForegroundLock = newWakeLock;
                    newWakeLock.acquire();
                }
                this.mForegroundWorkMap.put(str, remove);
                ContextCompat.startForegroundService(this.mAppContext, SystemForegroundDispatcher.createStartForegroundIntent(this.mAppContext, remove.getWorkGenerationalId(), foregroundInfo));
            }
        }
    }

    public boolean stopForegroundWork(StartStopToken startStopToken) {
        WorkerWrapper remove;
        String workSpecId = startStopToken.getId().getWorkSpecId();
        synchronized (this.mLock) {
            Logger logger = Logger.get();
            String str = TAG;
            logger.debug(str, "Processor stopping foreground work " + workSpecId);
            remove = this.mForegroundWorkMap.remove(workSpecId);
            if (remove != null) {
                this.mWorkRuns.remove(workSpecId);
            }
        }
        return interrupt(workSpecId, remove);
    }

    public boolean stopWork(StartStopToken startStopToken) {
        String workSpecId = startStopToken.getId().getWorkSpecId();
        synchronized (this.mLock) {
            WorkerWrapper remove = this.mEnqueuedWorkMap.remove(workSpecId);
            if (remove == null) {
                Logger logger = Logger.get();
                String str = TAG;
                logger.debug(str, "WorkerWrapper could not be found for " + workSpecId);
                return false;
            }
            Set set = this.mWorkRuns.get(workSpecId);
            if (set != null) {
                if (set.contains(startStopToken)) {
                    Logger logger2 = Logger.get();
                    String str2 = TAG;
                    logger2.debug(str2, "Processor stopping background work " + workSpecId);
                    this.mWorkRuns.remove(workSpecId);
                    return interrupt(workSpecId, remove);
                }
            }
            return false;
        }
    }

    public boolean stopAndCancelWork(String str) {
        WorkerWrapper remove;
        boolean z;
        synchronized (this.mLock) {
            Logger logger = Logger.get();
            String str2 = TAG;
            logger.debug(str2, "Processor cancelling " + str);
            this.mCancelledIds.add(str);
            remove = this.mForegroundWorkMap.remove(str);
            z = remove != null;
            if (remove == null) {
                remove = this.mEnqueuedWorkMap.remove(str);
            }
            if (remove != null) {
                this.mWorkRuns.remove(str);
            }
        }
        boolean interrupt = interrupt(str, remove);
        if (z) {
            stopForegroundService();
        }
        return interrupt;
    }

    public void stopForeground(String str) {
        synchronized (this.mLock) {
            this.mForegroundWorkMap.remove(str);
            stopForegroundService();
        }
    }

    public boolean isCancelled(String str) {
        boolean contains;
        synchronized (this.mLock) {
            contains = this.mCancelledIds.contains(str);
        }
        return contains;
    }

    public boolean hasWork() {
        boolean z;
        synchronized (this.mLock) {
            if (this.mEnqueuedWorkMap.isEmpty()) {
                if (this.mForegroundWorkMap.isEmpty()) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public boolean isEnqueued(String str) {
        boolean z;
        synchronized (this.mLock) {
            if (!this.mEnqueuedWorkMap.containsKey(str)) {
                if (!this.mForegroundWorkMap.containsKey(str)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public boolean isEnqueuedInForeground(String str) {
        boolean containsKey;
        synchronized (this.mLock) {
            containsKey = this.mForegroundWorkMap.containsKey(str);
        }
        return containsKey;
    }

    public void addExecutionListener(ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.add(executionListener);
        }
    }

    public void removeExecutionListener(ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.remove(executionListener);
        }
    }

    /* renamed from: onExecuted */
    public void m1630lambda$runOnExecuted$1$androidxworkimplProcessor(WorkGenerationalId workGenerationalId, boolean z) {
        synchronized (this.mLock) {
            WorkerWrapper workerWrapper = this.mEnqueuedWorkMap.get(workGenerationalId.getWorkSpecId());
            if (workerWrapper != null && workGenerationalId.equals(workerWrapper.getWorkGenerationalId())) {
                this.mEnqueuedWorkMap.remove(workGenerationalId.getWorkSpecId());
            }
            Logger logger = Logger.get();
            String str = TAG;
            logger.debug(str, getClass().getSimpleName() + " " + workGenerationalId.getWorkSpecId() + " executed; reschedule = " + z);
            for (ExecutionListener onExecuted : this.mOuterListeners) {
                onExecuted.onExecuted(workGenerationalId, z);
            }
        }
    }

    public WorkSpec getRunningWorkSpec(String str) {
        synchronized (this.mLock) {
            WorkerWrapper workerWrapper = this.mForegroundWorkMap.get(str);
            if (workerWrapper == null) {
                workerWrapper = this.mEnqueuedWorkMap.get(str);
            }
            if (workerWrapper == null) {
                return null;
            }
            WorkSpec workSpec = workerWrapper.getWorkSpec();
            return workSpec;
        }
    }

    private void runOnExecuted(WorkGenerationalId workGenerationalId, boolean z) {
        this.mWorkTaskExecutor.getMainThreadExecutor().execute(new Processor$$ExternalSyntheticLambda1(this, workGenerationalId, z));
    }

    private void stopForegroundService() {
        synchronized (this.mLock) {
            if (!(!this.mForegroundWorkMap.isEmpty())) {
                try {
                    this.mAppContext.startService(SystemForegroundDispatcher.createStopForegroundIntent(this.mAppContext));
                } catch (Throwable th) {
                    Logger.get().error(TAG, "Unable to stop foreground service", th);
                }
                PowerManager.WakeLock wakeLock = this.mForegroundLock;
                if (wakeLock != null) {
                    wakeLock.release();
                    this.mForegroundLock = null;
                }
            }
        }
    }

    private static boolean interrupt(String str, WorkerWrapper workerWrapper) {
        if (workerWrapper != null) {
            workerWrapper.interrupt();
            Logger logger = Logger.get();
            String str2 = TAG;
            logger.debug(str2, "WorkerWrapper interrupted for " + str);
            return true;
        }
        Logger logger2 = Logger.get();
        String str3 = TAG;
        logger2.debug(str3, "WorkerWrapper could not be found for " + str);
        return false;
    }

    private static class FutureListener implements Runnable {
        private ExecutionListener mExecutionListener;
        private ListenableFuture<Boolean> mFuture;
        private final WorkGenerationalId mWorkGenerationalId;

        FutureListener(ExecutionListener executionListener, WorkGenerationalId workGenerationalId, ListenableFuture<Boolean> listenableFuture) {
            this.mExecutionListener = executionListener;
            this.mWorkGenerationalId = workGenerationalId;
            this.mFuture = listenableFuture;
        }

        public void run() {
            boolean z;
            try {
                z = ((Boolean) this.mFuture.get()).booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z = true;
            }
            this.mExecutionListener.onExecuted(this.mWorkGenerationalId, z);
        }
    }
}
