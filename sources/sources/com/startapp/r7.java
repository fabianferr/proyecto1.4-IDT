package com.startapp;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

/* compiled from: Sta */
public class r7 implements Executor {
    public final Queue<Runnable> a = new ArrayDeque();
    public final Executor b;
    public Runnable c;

    /* compiled from: Sta */
    public class a implements Runnable {
        public final /* synthetic */ Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        public void run() {
            try {
                this.a.run();
            } finally {
                r7.this.a();
            }
        }
    }

    public r7(Executor executor) {
        this.b = executor;
    }

    public synchronized void a() {
        Runnable poll = this.a.poll();
        this.c = poll;
        if (poll != null) {
            this.b.execute(poll);
        }
    }

    public synchronized void execute(Runnable runnable) {
        this.a.offer(new a(runnable));
        if (this.c == null) {
            a();
        }
    }
}
