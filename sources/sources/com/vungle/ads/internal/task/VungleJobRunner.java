package com.vungle.ads.internal.task;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0003\u001b\u001c\u001dB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\r\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\b\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/vungle/ads/internal/task/VungleJobRunner;", "Lcom/vungle/ads/internal/task/JobRunner;", "creator", "Lcom/vungle/ads/internal/task/JobCreator;", "executor", "Ljava/util/concurrent/Executor;", "threadPriorityHelper", "Lcom/vungle/ads/internal/task/ThreadPriorityHelper;", "(Lcom/vungle/ads/internal/task/JobCreator;Ljava/util/concurrent/Executor;Lcom/vungle/ads/internal/task/ThreadPriorityHelper;)V", "nextCheck", "", "pendingJobs", "", "Lcom/vungle/ads/internal/task/VungleJobRunner$PendingJob;", "pendingRunnable", "Ljava/lang/Runnable;", "cancelPendingJob", "", "tag", "", "execute", "jobInfo", "Lcom/vungle/ads/internal/task/JobInfo;", "executePendingJobs", "getPendingJobSize", "", "getPendingJobSize$vungle_ads_release", "Companion", "PendingJob", "PendingRunnable", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VungleJobRunner.kt */
public final class VungleJobRunner implements JobRunner {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "VungleJobRunner";
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private final JobCreator creator;
    private final Executor executor;
    private long nextCheck = Long.MAX_VALUE;
    private final List<PendingJob> pendingJobs = new CopyOnWriteArrayList();
    private final Runnable pendingRunnable = new PendingRunnable(new WeakReference(this));
    private final ThreadPriorityHelper threadPriorityHelper;

    public VungleJobRunner(JobCreator jobCreator, Executor executor2, ThreadPriorityHelper threadPriorityHelper2) {
        Intrinsics.checkNotNullParameter(jobCreator, "creator");
        Intrinsics.checkNotNullParameter(executor2, "executor");
        this.creator = jobCreator;
        this.executor = executor2;
        this.threadPriorityHelper = threadPriorityHelper2;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/vungle/ads/internal/task/VungleJobRunner$PendingJob;", "", "uptimeMillis", "", "info", "Lcom/vungle/ads/internal/task/JobInfo;", "(JLcom/vungle/ads/internal/task/JobInfo;)V", "getInfo", "()Lcom/vungle/ads/internal/task/JobInfo;", "setInfo", "(Lcom/vungle/ads/internal/task/JobInfo;)V", "getUptimeMillis", "()J", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: VungleJobRunner.kt */
    private static final class PendingJob {
        private JobInfo info;
        private final long uptimeMillis;

        public PendingJob(long j, JobInfo jobInfo) {
            this.uptimeMillis = j;
            this.info = jobInfo;
        }

        public final JobInfo getInfo() {
            return this.info;
        }

        public final long getUptimeMillis() {
            return this.uptimeMillis;
        }

        public final void setInfo(JobInfo jobInfo) {
            this.info = jobInfo;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/vungle/ads/internal/task/VungleJobRunner$PendingRunnable;", "Ljava/lang/Runnable;", "runner", "Ljava/lang/ref/WeakReference;", "Lcom/vungle/ads/internal/task/VungleJobRunner;", "(Ljava/lang/ref/WeakReference;)V", "getRunner", "()Ljava/lang/ref/WeakReference;", "setRunner", "run", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: VungleJobRunner.kt */
    private static final class PendingRunnable implements Runnable {
        private WeakReference<VungleJobRunner> runner;

        public PendingRunnable(WeakReference<VungleJobRunner> weakReference) {
            Intrinsics.checkNotNullParameter(weakReference, "runner");
            this.runner = weakReference;
        }

        public final WeakReference<VungleJobRunner> getRunner() {
            return this.runner;
        }

        public final void setRunner(WeakReference<VungleJobRunner> weakReference) {
            Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
            this.runner = weakReference;
        }

        public void run() {
            VungleJobRunner vungleJobRunner = (VungleJobRunner) this.runner.get();
            if (vungleJobRunner != null) {
                vungleJobRunner.executePendingJobs();
            }
        }
    }

    public synchronized void execute(JobInfo jobInfo) {
        Intrinsics.checkNotNullParameter(jobInfo, "jobInfo");
        JobInfo copy = jobInfo.copy();
        if (copy != null) {
            String jobTag = copy.getJobTag();
            long delay = copy.getDelay();
            copy.setDelay(0);
            if (copy.getUpdateCurrent()) {
                for (PendingJob next : this.pendingJobs) {
                    JobInfo info = next.getInfo();
                    if (Intrinsics.areEqual((Object) info != null ? info.getJobTag() : null, (Object) jobTag)) {
                        String str = TAG;
                        Log.d(str, "replacing pending job with new " + jobTag);
                        this.pendingJobs.remove(next);
                    }
                }
            }
            this.pendingJobs.add(new PendingJob(SystemClock.uptimeMillis() + delay, copy));
            executePendingJobs();
        }
    }

    public final int getPendingJobSize$vungle_ads_release() {
        return this.pendingJobs.size();
    }

    public synchronized void cancelPendingJob(String str) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        List arrayList = new ArrayList();
        for (PendingJob next : this.pendingJobs) {
            JobInfo info = next.getInfo();
            if (Intrinsics.areEqual((Object) info != null ? info.getJobTag() : null, (Object) str)) {
                arrayList.add(next);
            }
        }
        this.pendingJobs.removeAll(arrayList);
    }

    /* access modifiers changed from: private */
    public final synchronized void executePendingJobs() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = Long.MAX_VALUE;
        for (PendingJob next : this.pendingJobs) {
            if (uptimeMillis >= next.getUptimeMillis()) {
                this.pendingJobs.remove(next);
                JobInfo info = next.getInfo();
                if (info != null) {
                    this.executor.execute(new JobRunnable(info, this.creator, this, this.threadPriorityHelper));
                }
            } else {
                j = Math.min(j, next.getUptimeMillis());
            }
        }
        if (!(j == Long.MAX_VALUE || j == this.nextCheck)) {
            Handler handler2 = handler;
            handler2.removeCallbacks(this.pendingRunnable);
            handler2.postAtTime(this.pendingRunnable, TAG, j);
        }
        this.nextCheck = j;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/vungle/ads/internal/task/VungleJobRunner$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "handler", "Landroid/os/Handler;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: VungleJobRunner.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
