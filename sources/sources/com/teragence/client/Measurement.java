package com.teragence.client;

import android.content.Context;
import com.teragence.client.service.b;
import com.teragence.client.service.f;
import com.teragence.client.service.h;
import com.teragence.client.service.i;
import com.teragence.client.service.n;
import com.teragence.library.c2;
import com.teragence.library.e2;
import com.teragence.library.f2;
import com.teragence.library.n2;
import com.teragence.library.o2;
import java.util.concurrent.atomic.AtomicBoolean;

public class Measurement {
    private static final AtomicBoolean isStarted = new AtomicBoolean(false);
    private final Context context;

    class a implements c2.a {
        final /* synthetic */ f a;

        a(Measurement measurement, f fVar) {
            this.a = fVar;
        }

        public void a() {
            this.a.b();
        }
    }

    public Measurement(Context context2) {
        this.context = context2;
    }

    public boolean isInProgress() {
        return isStarted.get();
    }

    public void make() {
        synchronized (Measurement.class) {
            AtomicBoolean atomicBoolean = isStarted;
            if (!atomicBoolean.get()) {
                h hVar = new h(new n(new i(this.context, new n2(new o2())), new b(new com.teragence.client.service.a(atomicBoolean), this.context)));
                hVar.a();
                hVar.a(new e2(new c2(new f2(this.context), new a(this, hVar))));
            }
        }
    }
}
