package com.ironsource.mediationsdk.bidding;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.environment.workerthread.WorkerManager;
import com.ironsource.environment.workerthread.WorkerResult;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class d {

    public interface a {
        void a(String str);

        void a(List<j> list, long j, List<String> list2);
    }

    static /* synthetic */ void a(d dVar, List list, List list2, long j) {
        StringBuilder sb;
        IronLog ironLog;
        String str;
        IronLog ironLog2 = IronLog.INTERNAL;
        ironLog2.verbose("tokens received=" + list.size() + ", reached timeout=" + list2.size() + ", total duration=" + j + " millis");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            if (jVar.c() != null) {
                ironLog = IronLog.INTERNAL;
                sb = new StringBuilder();
                sb.append(jVar.b());
                sb.append(" - success (");
                sb.append(jVar.d());
                str = " millis)";
            } else {
                ironLog = IronLog.INTERNAL;
                sb = new StringBuilder();
                sb.append(jVar.b());
                sb.append(" - failed (");
                sb.append(jVar.d());
                sb.append(" millis) error: ");
                str = jVar.e();
            }
            sb.append(str);
            ironLog.verbose(sb.toString());
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            IronLog ironLog3 = IronLog.INTERNAL;
            ironLog3.verbose(((String) it2.next()) + " reached timeout");
        }
    }

    public final void a(List<a> list, final a aVar, long j, TimeUnit timeUnit) {
        try {
            if (list.isEmpty()) {
                IronLog.INTERNAL.verbose("BiddingDataCallable list is empty");
                return;
            }
            WorkerManager workerManager = new WorkerManager(IronSourceThreadManager.INSTANCE.getThreadPoolExecutor());
            for (a addCallable : list) {
                workerManager.addCallable(addCallable);
            }
            IronLog.INTERNAL.verbose("instances=" + list.size() + ", timeout=" + j + " millis");
            workerManager.startWork(new WorkerManager.WorkEndedListener<j>() {
                public final void onWorkCompleted(List<WorkerResult<j>> list, long j) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (WorkerResult next : list) {
                        if (next instanceof WorkerResult.Completed) {
                            arrayList2.add((j) ((WorkerResult.Completed) next).data);
                        } else if (next instanceof WorkerResult.Canceled) {
                            arrayList.add(((a) ((WorkerResult.Canceled) next).callable).b);
                        } else if (next instanceof WorkerResult.Failed) {
                            WorkerResult.Failed failed = (WorkerResult.Failed) next;
                            a aVar = (a) failed.callable;
                            arrayList2.add(new j(aVar.a, aVar.b, (Map<String, Object>) null, 0, failed.exception.getMessage()));
                        }
                    }
                    d.a(d.this, (List) arrayList2, (List) arrayList, j);
                    aVar.a(arrayList2, j, arrayList);
                }

                public final void onWorkFailed(String str) {
                    String str2 = "failed to collect bidding data, error= " + str;
                    IronLog.INTERNAL.verbose(str2);
                    aVar.a(str2);
                }
            }, j, timeUnit);
        } catch (Throwable th) {
            String str = "Exception - failed to collect bidding data, error= " + th.getMessage();
            IronLog.INTERNAL.error(str);
            aVar.a(str);
        }
    }
}
