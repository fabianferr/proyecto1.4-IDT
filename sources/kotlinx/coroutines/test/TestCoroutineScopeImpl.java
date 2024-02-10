package kotlinx.coroutines.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/test/TestCoroutineScopeImpl;", "Lkotlinx/coroutines/test/TestCoroutineScope;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "cleanedUp", "", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "exceptions", "", "", "initialJobs", "", "Lkotlinx/coroutines/Job;", "lock", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "testScheduler", "Lkotlinx/coroutines/test/TestCoroutineScheduler;", "getTestScheduler", "()Lkotlinx/coroutines/test/TestCoroutineScheduler;", "cleanupTestCoroutines", "", "reportException", "throwable", "kotlinx-coroutines-test"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TestCoroutineScope.kt */
final class TestCoroutineScopeImpl implements TestCoroutineScope {
    private boolean cleanedUp;
    private final CoroutineContext coroutineContext;
    private List<Throwable> exceptions = new ArrayList();
    private final Set<Job> initialJobs = TestCoroutineScopeKt.activeJobs(getCoroutineContext());
    private final Object lock = new Object();

    public TestCoroutineScopeImpl(CoroutineContext coroutineContext2) {
        this.coroutineContext = coroutineContext2;
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final boolean reportException(Throwable th) {
        boolean z;
        synchronized (this.lock) {
            if (this.cleanedUp) {
                z = false;
            } else {
                this.exceptions.add(th);
                z = true;
            }
        }
        return z;
    }

    public TestCoroutineScheduler getTestScheduler() {
        CoroutineContext.Element element = getCoroutineContext().get(TestCoroutineScheduler.Key);
        Intrinsics.checkNotNull(element);
        return (TestCoroutineScheduler) element;
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [kotlin.coroutines.CoroutineContext$Element] */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    public void cleanupTestCoroutines() {
        /*
            r5 = this;
            kotlin.coroutines.CoroutineContext r0 = r5.getCoroutineContext()
            kotlin.coroutines.ContinuationInterceptor$Key r1 = kotlin.coroutines.ContinuationInterceptor.Key
            kotlin.coroutines.CoroutineContext$Key r1 = (kotlin.coroutines.CoroutineContext.Key) r1
            kotlin.coroutines.CoroutineContext$Element r0 = r0.get(r1)
            kotlin.coroutines.ContinuationInterceptor r0 = (kotlin.coroutines.ContinuationInterceptor) r0
            boolean r1 = r0 instanceof kotlinx.coroutines.test.DelayController
            r2 = 0
            if (r1 == 0) goto L_0x0016
            kotlinx.coroutines.test.DelayController r0 = (kotlinx.coroutines.test.DelayController) r0
            goto L_0x0017
        L_0x0016:
            r0 = r2
        L_0x0017:
            r1 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0021
            r0.cleanupTestCoroutines()     // Catch:{ UncompletedCoroutinesError -> 0x001f }
            goto L_0x0033
        L_0x001f:
            goto L_0x0032
        L_0x0021:
            kotlinx.coroutines.test.TestCoroutineScheduler r0 = r5.getTestScheduler()
            r0.runCurrent()
            kotlinx.coroutines.test.TestCoroutineScheduler r0 = r5.getTestScheduler()
            boolean r0 = r0.isIdle$kotlinx_coroutines_test(r1)
            if (r0 != 0) goto L_0x0033
        L_0x0032:
            r1 = 1
        L_0x0033:
            kotlin.coroutines.CoroutineContext r0 = r5.getCoroutineContext()
            kotlinx.coroutines.CoroutineExceptionHandler$Key r4 = kotlinx.coroutines.CoroutineExceptionHandler.Key
            kotlin.coroutines.CoroutineContext$Key r4 = (kotlin.coroutines.CoroutineContext.Key) r4
            kotlin.coroutines.CoroutineContext$Element r0 = r0.get(r4)
            boolean r4 = r0 instanceof kotlinx.coroutines.test.UncaughtExceptionCaptor
            if (r4 == 0) goto L_0x0046
            r2 = r0
            kotlinx.coroutines.test.UncaughtExceptionCaptor r2 = (kotlinx.coroutines.test.UncaughtExceptionCaptor) r2
        L_0x0046:
            if (r2 == 0) goto L_0x004b
            r2.cleanupTestCoroutines()
        L_0x004b:
            java.lang.Object r0 = r5.lock
            monitor-enter(r0)
            boolean r2 = r5.cleanedUp     // Catch:{ all -> 0x00c0 }
            if (r2 != 0) goto L_0x00b8
            r5.cleanedUp = r3     // Catch:{ all -> 0x00c0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00c0 }
            monitor-exit(r0)
            java.util.List<java.lang.Throwable> r0 = r5.exceptions
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            if (r0 == 0) goto L_0x0080
            java.util.List<java.lang.Throwable> r1 = r5.exceptions
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.List r1 = kotlin.collections.CollectionsKt.drop(r1, r3)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x006f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x007f
            java.lang.Object r2 = r1.next()
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            kotlin.ExceptionsKt.addSuppressed(r0, r2)
            goto L_0x006f
        L_0x007f:
            throw r0
        L_0x0080:
            if (r1 != 0) goto L_0x00b0
            kotlin.coroutines.CoroutineContext r0 = r5.getCoroutineContext()
            java.util.Set r0 = kotlinx.coroutines.test.TestCoroutineScopeKt.activeJobs(r0)
            java.util.Set<kotlinx.coroutines.Job> r1 = r5.initialJobs
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Set r1 = kotlin.collections.SetsKt.minus(r0, r1)
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r3
            if (r1 != 0) goto L_0x009c
            return
        L_0x009c:
            kotlinx.coroutines.test.UncompletedCoroutinesError r1 = new kotlinx.coroutines.test.UncompletedCoroutinesError
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Test finished with active jobs: "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x00b0:
            kotlinx.coroutines.test.UncompletedCoroutinesError r0 = new kotlinx.coroutines.test.UncompletedCoroutinesError
            java.lang.String r1 = "Unfinished coroutines during teardown. Ensure all coroutines are completed or cancelled by your test."
            r0.<init>(r1)
            throw r0
        L_0x00b8:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00c0 }
            java.lang.String r2 = "Attempting to clean up a test coroutine scope more than once."
            r1.<init>(r2)     // Catch:{ all -> 0x00c0 }
            throw r1     // Catch:{ all -> 0x00c0 }
        L_0x00c0:
            r1 = move-exception
            monitor-exit(r0)
            goto L_0x00c4
        L_0x00c3:
            throw r1
        L_0x00c4:
            goto L_0x00c3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.test.TestCoroutineScopeImpl.cleanupTestCoroutines():void");
    }
}
