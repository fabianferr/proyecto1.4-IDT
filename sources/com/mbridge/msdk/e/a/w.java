package com.mbridge.msdk.e.a;

import com.mbridge.msdk.e.a.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* compiled from: WaitingRequestManager */
final class w implements m.a {
    private final Map<String, List<m<?>>> a = new HashMap();
    private final q b;
    private final n c = null;
    private final b d;
    private final BlockingQueue<m<?>> e;

    w(b bVar, BlockingQueue<m<?>> blockingQueue, q qVar) {
        this.b = qVar;
        this.d = bVar;
        this.e = blockingQueue;
    }

    public final void a(m<?> mVar, o<?> oVar) {
        List<m> remove;
        if (oVar.b == null || oVar.b.a(System.currentTimeMillis())) {
            a(mVar);
            return;
        }
        String i = mVar.i();
        synchronized (this) {
            remove = this.a.remove(i);
        }
        if (remove != null) {
            for (m a2 : remove) {
                this.b.a((m<?>) a2, oVar);
            }
        }
    }

    public final synchronized void a(m<?> mVar) {
        BlockingQueue<m<?>> blockingQueue;
        String i = mVar.i();
        List remove = this.a.remove(i);
        if (remove != null && !remove.isEmpty()) {
            m mVar2 = (m) remove.remove(0);
            this.a.put(i, remove);
            mVar2.a((m.a) this);
            n nVar = this.c;
            if (nVar != null) {
                nVar.c(mVar2);
            } else if (!(this.d == null || (blockingQueue = this.e) == null)) {
                try {
                    blockingQueue.put(mVar2);
                } catch (InterruptedException e2) {
                    v.c("Couldn't add request to queue. %s", e2.toString());
                    Thread.currentThread().interrupt();
                    this.d.a();
                }
            }
        }
        return;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean b(m<?> mVar) {
        String i = mVar.i();
        if (this.a.containsKey(i)) {
            List list = this.a.get(i);
            if (list == null) {
                list = new ArrayList();
            }
            list.add(mVar);
            this.a.put(i, list);
            return true;
        }
        this.a.put(i, (Object) null);
        mVar.a((m.a) this);
        return false;
    }
}
