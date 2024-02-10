package com.mbridge.msdk.foundation.same.e;

/* compiled from: CommonTask */
public abstract class a implements Runnable {
    public static long b;
    public b c = b.READY;
    public C0139a d;

    /* renamed from: com.mbridge.msdk.foundation.same.e.a$a  reason: collision with other inner class name */
    /* compiled from: CommonTask */
    public interface C0139a {
        void a(b bVar);
    }

    /* compiled from: CommonTask */
    public enum b {
        READY,
        RUNNING,
        PAUSE,
        CANCEL,
        FINISH
    }

    public abstract void a();

    public abstract void b();

    public final void run() {
        try {
            if (this.c == b.READY) {
                a(b.RUNNING);
                a();
                a(b.FINISH);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public a() {
        b++;
    }

    public final void d() {
        if (this.c != b.CANCEL) {
            a(b.CANCEL);
            b();
        }
    }

    private void a(b bVar) {
        this.c = bVar;
        C0139a aVar = this.d;
        if (aVar != null) {
            aVar.a(bVar);
        }
    }
}
