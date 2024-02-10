package com.applovin.impl.adview;

import android.os.Handler;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class j {
    /* access modifiers changed from: private */
    public final u a;
    private final Handler b;
    private final Set<b> c = new HashSet();
    /* access modifiers changed from: private */
    public final AtomicInteger d = new AtomicInteger();

    public interface a {
        void a();

        boolean b();
    }

    private static class b {
        private final String a;
        private final a b;
        private final long c;

        private b(String str, long j, a aVar) {
            this.a = str;
            this.c = j;
            this.b = aVar;
        }

        /* access modifiers changed from: private */
        public String a() {
            return this.a;
        }

        /* access modifiers changed from: private */
        public long b() {
            return this.c;
        }

        /* access modifiers changed from: private */
        public a c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            String str = this.a;
            String str2 = ((b) obj).a;
            return str != null ? str.equalsIgnoreCase(str2) : str2 == null;
        }

        public int hashCode() {
            String str = this.a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "CountdownProxy{identifier='" + this.a + "', countdownStepMillis=" + this.c + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public j(Handler handler, m mVar) {
        if (handler == null) {
            throw new IllegalArgumentException("No handler specified.");
        } else if (mVar != null) {
            this.b = handler;
            this.a = mVar.A();
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* access modifiers changed from: private */
    public void a(final b bVar, final int i) {
        this.b.postDelayed(new Runnable() {
            public void run() {
                a b2 = bVar.c();
                if (b2.b()) {
                    if (j.this.d.get() == i) {
                        try {
                            b2.a();
                            j.this.a(bVar, i);
                        } catch (Throwable th) {
                            if (u.a()) {
                                u b3 = j.this.a;
                                b3.b("CountdownManager", "Encountered error on countdown step for: " + bVar.a(), th);
                            }
                            j.this.b();
                        }
                    } else if (u.a()) {
                        u b4 = j.this.a;
                        b4.d("CountdownManager", "Killing duplicate countdown from previous generation: " + bVar.a());
                    }
                } else if (u.a()) {
                    u b5 = j.this.a;
                    b5.b("CountdownManager", "Ending countdown for " + bVar.a());
                }
            }
        }, bVar.b());
    }

    public void a() {
        HashSet<b> hashSet = new HashSet<>(this.c);
        if (u.a()) {
            u uVar = this.a;
            uVar.b("CountdownManager", "Starting " + hashSet.size() + " countdowns...");
        }
        int incrementAndGet = this.d.incrementAndGet();
        for (b bVar : hashSet) {
            if (u.a()) {
                u uVar2 = this.a;
                uVar2.b("CountdownManager", "Starting countdown: " + bVar.a() + " for generation " + incrementAndGet + "...");
            }
            a(bVar, incrementAndGet);
        }
    }

    public void a(String str, long j, a aVar) {
        if (j <= 0) {
            throw new IllegalArgumentException("Invalid step specified.");
        } else if (this.b != null) {
            if (u.a()) {
                u uVar = this.a;
                uVar.b("CountdownManager", "Adding countdown: " + str);
            }
            this.c.add(new b(str, j, aVar));
        } else {
            throw new IllegalArgumentException("No handler specified.");
        }
    }

    public void b() {
        if (u.a()) {
            this.a.b("CountdownManager", "Removing all countdowns...");
        }
        c();
        this.c.clear();
    }

    public void c() {
        if (u.a()) {
            this.a.b("CountdownManager", "Stopping countdowns...");
        }
        this.d.incrementAndGet();
        this.b.removeCallbacksAndMessages((Object) null);
    }
}
