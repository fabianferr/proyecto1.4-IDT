package com.bykv.vk.openvk.preload.b;

import com.bykv.vk.openvk.preload.b.a.a;
import com.bykv.vk.openvk.preload.b.i;
import com.bykv.vk.openvk.preload.geckox.b;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* compiled from: ParallelInterceptor */
public class g<T> extends d<List<T>, T> {
    private Executor g;

    public final /* synthetic */ Object a(b bVar, Object obj) throws Throwable {
        List list = (List) obj;
        CountDownLatch countDownLatch = new CountDownLatch(list.size());
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        for (final Object next : list) {
            final b bVar2 = bVar;
            final CopyOnWriteArrayList copyOnWriteArrayList3 = copyOnWriteArrayList;
            final CopyOnWriteArrayList copyOnWriteArrayList4 = copyOnWriteArrayList2;
            final CountDownLatch countDownLatch2 = countDownLatch;
            this.g.execute(new Runnable() {
                public final void run() {
                    try {
                        copyOnWriteArrayList3.add(bVar2.a(next));
                    } catch (i.a e2) {
                        Throwable cause = e2.getCause();
                        copyOnWriteArrayList4.add(cause);
                        g.this.b(cause);
                    } catch (Throwable th) {
                        countDownLatch2.countDown();
                        throw th;
                    }
                    countDownLatch2.countDown();
                }
            });
        }
        countDownLatch.await();
        if (copyOnWriteArrayList2.isEmpty()) {
            return copyOnWriteArrayList;
        }
        throw new a(copyOnWriteArrayList2);
    }

    /* access modifiers changed from: protected */
    public final void a(Object... objArr) {
        super.a(objArr);
        if (objArr == null) {
            this.g = b.a();
        } else if (objArr.length == 1) {
            Executor executor = objArr[0];
            if (executor instanceof Executor) {
                this.g = executor;
                return;
            }
            throw new IllegalArgumentException("ParallelInterceptor args must be instance of Executor");
        } else {
            throw new IllegalArgumentException("ParallelInterceptor only need one param");
        }
    }
}
