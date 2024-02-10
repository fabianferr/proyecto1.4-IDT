package com.startapp.sdk.adsbase.crashreport;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Printer;
import com.startapp.k9;
import com.startapp.sdk.components.j;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Sta */
public class b extends Thread implements Handler.Callback, Printer {
    public d a = new a(this);
    public e b = new C0166b(this);
    public g c = new c(this);
    public f d;
    public final Handler e = new Handler(Looper.getMainLooper(), this);
    public final AtomicLong f = new AtomicLong(0);
    public final long g;
    public final AtomicReference<String> h = new AtomicReference<>("");
    public final boolean i;

    /* compiled from: Sta */
    public class a implements d {
        public a(b bVar) {
        }

        public void a() {
        }

        public boolean a(long j, String str) {
            return false;
        }

        public void remove() {
        }
    }

    /* renamed from: com.startapp.sdk.adsbase.crashreport.b$b  reason: collision with other inner class name */
    /* compiled from: Sta */
    public class C0166b implements e {
        public C0166b(b bVar) {
        }

        public long a(long j) {
            return 0;
        }
    }

    /* compiled from: Sta */
    public class c implements g {
        public c(b bVar) {
        }
    }

    /* compiled from: Sta */
    public interface d {
        void a();

        boolean a(long j, String str);

        void remove();
    }

    /* compiled from: Sta */
    public interface e {
        long a(long j);
    }

    /* compiled from: Sta */
    public interface f {
    }

    /* compiled from: Sta */
    public interface g {
    }

    public b(long j, boolean z) {
        super("startapp-anr");
        this.g = j;
        this.i = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x004a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r12 = this;
            long r0 = r12.g
            r2 = 0
            r3 = 1
            r4 = 0
            r5 = 1
        L_0x0006:
            boolean r6 = r12.isInterrupted()
            if (r6 != 0) goto L_0x008d
            java.util.concurrent.atomic.AtomicLong r6 = r12.f
            long r6 = r6.getAndAdd(r0)
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x0036
            if (r4 == 0) goto L_0x002e
            java.util.concurrent.atomic.AtomicReference<java.lang.String> r5 = r12.h
            java.lang.Object r5 = r5.get()
            java.lang.String r5 = (java.lang.String) r5
            boolean r5 = r12.a(r5)
            if (r5 != 0) goto L_0x002e
            com.startapp.sdk.adsbase.crashreport.b$d r4 = r12.a
            r4.remove()
            r4 = 0
        L_0x002e:
            android.os.Handler r5 = r12.e
            r6 = 101(0x65, float:1.42E-43)
            r5.sendEmptyMessage(r6)
            r5 = 1
        L_0x0036:
            monitor-enter(r12)     // Catch:{ InterruptedException -> 0x0042, all -> 0x0040 }
            r12.wait(r0)     // Catch:{ all -> 0x003d }
            monitor-exit(r12)     // Catch:{ all -> 0x003d }
            r6 = 0
            goto L_0x0048
        L_0x003d:
            r6 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x003d }
            throw r6     // Catch:{ InterruptedException -> 0x0042, all -> 0x0040 }
        L_0x0040:
            goto L_0x0047
        L_0x0042:
            com.startapp.sdk.adsbase.crashreport.b$g r6 = r12.c
            r6.getClass()
        L_0x0047:
            r6 = 1
        L_0x0048:
            if (r6 == 0) goto L_0x004b
            return
        L_0x004b:
            java.util.concurrent.atomic.AtomicLong r6 = r12.f
            long r6 = r6.get()
            java.util.concurrent.atomic.AtomicReference<java.lang.String> r10 = r12.h
            java.lang.Object r10 = r10.get()
            java.lang.String r10 = (java.lang.String) r10
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 <= 0) goto L_0x0006
            if (r4 != 0) goto L_0x0006
            if (r5 != 0) goto L_0x0067
            boolean r11 = r12.a(r10)
            if (r11 == 0) goto L_0x0006
        L_0x0067:
            boolean r11 = android.os.Debug.isDebuggerConnected()
            if (r11 != 0) goto L_0x008a
            boolean r11 = android.os.Debug.waitingForDebugger()
            if (r11 == 0) goto L_0x0074
            goto L_0x008a
        L_0x0074:
            com.startapp.sdk.adsbase.crashreport.b$e r0 = r12.b
            long r0 = r0.a(r6)
            int r11 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r11 <= 0) goto L_0x0080
            r5 = 0
            goto L_0x0006
        L_0x0080:
            com.startapp.sdk.adsbase.crashreport.b$d r0 = r12.a
            boolean r4 = r0.a(r6, r10)
            long r0 = r12.g
            goto L_0x0006
        L_0x008a:
            r4 = 1
            goto L_0x0006
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.crashreport.b.a():void");
    }

    public boolean handleMessage(Message message) {
        this.f.set(0);
        return true;
    }

    public void println(String str) {
        if (str.startsWith(">>>>>")) {
            this.h.set(str);
        } else if (str.startsWith("<<<<<")) {
            this.h.set("");
            this.f.set(0);
        }
    }

    public void run() {
        try {
            a();
        } catch (Throwable unused) {
        }
    }

    public void start() {
        this.a.a();
        this.a.remove();
        if (this.i) {
            Looper.getMainLooper().setMessageLogging(this);
        }
        super.start();
    }

    public final boolean a(String str) {
        boolean z = !this.i || !TextUtils.isEmpty(str);
        f fVar = this.d;
        boolean z2 = fVar == null || (k9.e(((j) fVar).a.a) ^ true);
        if (!z || !z2) {
            return false;
        }
        return true;
    }
}
